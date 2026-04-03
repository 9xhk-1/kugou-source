package com.kugou.common.network.quic;

import h.a.b.k;
import h.a.b.l;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpRetryException;
import java.nio.ByteBuffer;
import okhttp3.MediaType;
import org.apache.http.HttpEntity;

/* JADX INFO: loaded from: classes2.dex */
public class HttpEntityUploadProvider extends k {
    private static final MediaType DEFAULT_MEDIA_TYPE = MediaType.parse("application/octet-stream");
    private byte[] bytes;
    private final HttpEntity entity;
    private final MediaType mediaType;
    private int pos = 0;

    public HttpEntityUploadProvider(HttpEntity httpEntity, String str) throws IOException {
        this.entity = httpEntity;
        if (str != null) {
            this.mediaType = MediaType.parse(str);
        } else if (httpEntity.getContentType() != null) {
            this.mediaType = MediaType.parse(httpEntity.getContentType().getValue());
        } else {
            this.mediaType = DEFAULT_MEDIA_TYPE;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) getLength());
        httpEntity.writeTo(byteArrayOutputStream);
        this.bytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
    }

    @Override // h.a.b.k
    public long getLength() throws IOException {
        return this.entity.getContentLength();
    }

    public MediaType getMediaType() {
        return this.mediaType;
    }

    @Override // h.a.b.k
    public void read(l lVar, ByteBuffer byteBuffer) throws IOException {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
        }
        int length = ((long) byteBuffer.remaining()) >= getLength() - ((long) this.pos) ? (int) (getLength() - ((long) this.pos)) : byteBuffer.remaining();
        byteBuffer.put(this.bytes, this.pos, length);
        this.pos += length;
        lVar.a(false);
    }

    @Override // h.a.b.k
    public void rewind(l lVar) throws IOException {
        lVar.b(new HttpRetryException("Cannot retry streamed Http body", -1));
    }
}
