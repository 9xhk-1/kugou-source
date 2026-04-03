package com.kugou.common.network;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.kugou.common.network.cache.DiskLruCache;
import com.kugou.common.network.cache.FileSystem;
import com.kugou.common.network.networkutils.HttpHeaderParser;
import com.kugou.common.network.networkutils.KGNetworkUtil;
import com.kugou.common.network.protocol.AbstractMultiUrlRequestPackage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;

/* JADX INFO: loaded from: classes2.dex */
public final class KGHttpCache {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201710;
    public final DiskLruCache cache;
    private Entry cacheEntry;

    public KGHttpCache(File file, long j) {
        this.cache = DiskLruCache.create(FileSystem.SYSTEM, file, VERSION, 2, j);
    }

    private void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    private String genKey(String str) {
        return ByteString.encodeUtf8(str).md5().hex();
    }

    private String getKeyString(RequestParams requestParams) {
        StringBuilder sb = new StringBuilder();
        if (requestParams.isMultiUrlReqPkg()) {
            sb.append(((AbstractMultiUrlRequestPackage) requestParams.getRequestPkg()).getConfigKeyString());
        } else {
            sb.append(requestParams.getUrl());
        }
        sb.append(requestParams.getGetRequestParams());
        "POST".equalsIgnoreCase(requestParams.getRequestType());
        return genKey(sb.toString());
    }

    public static boolean isCacheable(HttpResponse httpResponse) {
        return HttpHeaderParser.parseCacheHeaders(httpResponse.getAllHeaders()) != null && httpResponse.getStatusLine().getStatusCode() == 200;
    }

    public static int readInt(BufferedSource bufferedSource) throws IOException {
        try {
            long decimalLong = bufferedSource.readDecimalLong();
            String utf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (decimalLong >= 0 && decimalLong <= 2147483647L && utf8LineStrict.isEmpty()) {
                return (int) decimalLong;
            }
            throw new IOException("expected an int but was \"" + decimalLong + utf8LineStrict + "\"");
        } catch (NumberFormatException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public void delete() throws IOException {
        this.cache.delete();
    }

    @Nullable
    public Entry get(RequestParams requestParams) {
        try {
            final DiskLruCache.Snapshot snapshot = this.cache.get(getKeyString(requestParams));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                if (TextUtils.equals(entry.requestMethod, requestParams.getRequestType()) && TextUtils.equals(entry.url, requestParams.getUrl())) {
                    entry.response(Okio.buffer(new ForwardingSource(snapshot.getSource(1)) { // from class: com.kugou.common.network.KGHttpCache.1
                        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                        public void close() throws IOException {
                            snapshot.close();
                            super.close();
                        }
                    }));
                    this.cacheEntry = entry;
                    return entry;
                }
                return null;
            } catch (IOException unused) {
                KGNetworkUtil.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    public Entry getCacheEntry() {
        return this.cacheEntry;
    }

    public void put(RequestParams requestParams, byte[] bArr, HttpResponse httpResponse) {
        String url = requestParams.getUrl();
        String requestType = requestParams.getRequestType();
        if (!requestType.equalsIgnoreCase("GET") && !requestType.equalsIgnoreCase("POST")) {
            try {
                remove(requestParams);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        Entry entry = new Entry(url, requestType, httpResponse);
        DiskLruCache.Editor editorEdit = null;
        try {
            editorEdit = this.cache.edit(getKeyString(requestParams));
            if (editorEdit == null) {
                return;
            }
            entry.writeTo(editorEdit);
            entry.writeBody(editorEdit, bArr);
            editorEdit.commit();
        } catch (IOException unused2) {
            abortQuietly(editorEdit);
        }
    }

    public void remove(RequestParams requestParams) throws IOException {
        this.cache.remove(getKeyString(requestParams));
    }

    public void update(RequestParams requestParams, HttpResponse httpResponse) {
        Entry entry = new Entry(requestParams.getUrl(), requestParams.getRequestType(), httpResponse);
        DiskLruCache.Editor editorEdit = null;
        try {
            editorEdit = this.cache.edit(getKeyString(requestParams));
            if (editorEdit != null) {
                entry.writeTo(editorEdit);
                editorEdit.commit();
            }
        } catch (IOException unused) {
            abortQuietly(editorEdit);
        }
    }

    public static final class Entry {
        public final int code;
        public byte[] data;
        public final String message;
        public final long receivedResponseMillis;
        public final String requestMethod;
        public final Header[] responseHeaders;
        public final String url;

        public Entry(Source source) throws IOException {
            try {
                BufferedSource bufferedSourceBuffer = Okio.buffer(source);
                this.url = bufferedSourceBuffer.readUtf8LineStrict();
                this.requestMethod = bufferedSourceBuffer.readUtf8LineStrict();
                this.code = Integer.parseInt(bufferedSourceBuffer.readUtf8LineStrict());
                this.receivedResponseMillis = Long.parseLong(bufferedSourceBuffer.readUtf8LineStrict());
                this.message = bufferedSourceBuffer.readUtf8LineStrict();
                int i2 = KGHttpCache.readInt(bufferedSourceBuffer);
                ArrayList arrayList = new ArrayList(i2);
                for (int i3 = 0; i3 < i2; i3++) {
                    String utf8LineStrict = bufferedSourceBuffer.readUtf8LineStrict();
                    int iIndexOf = utf8LineStrict.indexOf(":", 1);
                    arrayList.add(iIndexOf != -1 ? new BasicHeader(utf8LineStrict.substring(0, iIndexOf), utf8LineStrict.substring(iIndexOf + 1)) : utf8LineStrict.startsWith(":") ? new BasicHeader("", utf8LineStrict.substring(1)) : new BasicHeader("", utf8LineStrict));
                }
                this.responseHeaders = (Header[]) arrayList.toArray(new Header[i2]);
            } finally {
                source.close();
            }
        }

        public byte[] getData() {
            return this.data;
        }

        public long getReceivedResponseMillis() {
            return this.receivedResponseMillis;
        }

        public Header[] getResponseHeaders() {
            return this.responseHeaders;
        }

        public void response(BufferedSource bufferedSource) throws IOException {
            this.data = bufferedSource.readByteArray();
        }

        public void writeBody(DiskLruCache.Editor editor, byte[] bArr) throws IOException {
            BufferedSink bufferedSinkBuffer = Okio.buffer(editor.newSink(1));
            bufferedSinkBuffer.write(bArr);
            bufferedSinkBuffer.close();
        }

        public void writeTo(DiskLruCache.Editor editor) throws IOException {
            BufferedSink bufferedSinkBuffer = Okio.buffer(editor.newSink(0));
            bufferedSinkBuffer.writeUtf8(this.url).writeByte(10);
            bufferedSinkBuffer.writeUtf8(this.requestMethod).writeByte(10);
            bufferedSinkBuffer.writeUtf8(String.valueOf(this.code)).writeByte(10);
            bufferedSinkBuffer.writeUtf8(String.valueOf(this.receivedResponseMillis)).writeByte(10);
            bufferedSinkBuffer.writeUtf8(this.message).writeByte(10);
            bufferedSinkBuffer.writeDecimalLong(this.responseHeaders.length).writeByte(10);
            for (Header header : this.responseHeaders) {
                bufferedSinkBuffer.writeUtf8(header.getName()).writeUtf8(": ").writeUtf8(header.getValue()).writeByte(10);
            }
            bufferedSinkBuffer.close();
        }

        public Entry(String str, String str2, HttpResponse httpResponse) {
            this.url = str;
            this.requestMethod = str2;
            this.code = httpResponse.getStatusLine().getStatusCode();
            this.receivedResponseMillis = System.currentTimeMillis();
            this.message = httpResponse.getStatusLine().getReasonPhrase();
            this.responseHeaders = httpResponse.getAllHeaders();
        }
    }
}
