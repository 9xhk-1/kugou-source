package com.kugou.framework.libcommon.netcore;

import android.text.TextUtils;
import android.util.Log;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseConnection {
    public static final int CONNECT_TIMEOUT = 5000;
    public static final int DEFAULT_READ_TIMEOUT = 10000;
    public static final String HTTP_REQ_COOKIE = "Cookie";
    public static final String HTTP_REQ_ENTITY_JOIN = "&";
    public static final String HTTP_REQ_ENTITY_LINE_END = "\r\n";
    public static final String HTTP_REQ_ENTITY_MERGE = "=";
    public static final String HTTP_REQ_ENTITY_PREFIX = "--";
    public static final String HTTP_REQ_METHOD_GET = "GET";
    public static final String HTTP_REQ_METHOD_POST = "POST";
    public static final String HTTP_REQ_PROPERTY_CHARSET = "Charset";
    public static final String HTTP_REQ_PROPERTY_CONTENT_DISPOSITION = "Content-Disposition";
    public static final String HTTP_REQ_PROPERTY_CONTENT_LENGTH = "Content-Length";
    public static final String HTTP_REQ_PROPERTY_CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding";
    public static final String HTTP_REQ_PROPERTY_CONTENT_TYPE = "Content-Type";
    public static final String HTTP_REQ_VALUE_CHARSET_ISO_8599_1 = "ISO-8859-1";
    public static final String HTTP_REQ_VALUE_CHARSET_UTF8 = "UTF-8";
    public static final String HTTP_REQ_VALUE_CONTENT_TYPE_FORM = "multipart/form-data";
    public static final String HTTP_REQ_VALUE_CONTENT_TYPE_OCTET_STREAM = "application/octet-stream";
    public static final String HTTP_REQ_VALUE_CONTENT_TYPE_TEXT = "text/plain";
    public static final String HTTP_REQ_VALUE_CONTENT_TYPE_URL_ENCODD = "application/x-www-form-urlencoded";
    private static final String LOG_TAG = "T_NET";
    public int mConnectTimeout = CONNECT_TIMEOUT;
    public int mReadTimeout = 10000;

    private boolean isGzipStream(HttpURLConnection httpURLConnection) throws IllegalStateException {
        String contentEncoding;
        return (httpURLConnection == null || (contentEncoding = httpURLConnection.getContentEncoding()) == null || !contentEncoding.toLowerCase().contains("gzip")) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] doGetRequest() {
        /*
            r6 = this;
            r0 = 0
            java.net.HttpURLConnection r1 = r6.getURLConnection()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39 javax.net.ssl.SSLHandshakeException -> L44
            if (r1 != 0) goto L8
            return r0
        L8:
            java.lang.String r2 = "GET"
            r1.setRequestMethod(r2)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39 javax.net.ssl.SSLHandshakeException -> L44
            java.io.InputStream r1 = r1.getInputStream()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39 javax.net.ssl.SSLHandshakeException -> L44
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Exception -> L33 javax.net.ssl.SSLHandshakeException -> L35 java.lang.Throwable -> L56
            r2.<init>()     // Catch: java.lang.Exception -> L33 javax.net.ssl.SSLHandshakeException -> L35 java.lang.Throwable -> L56
            r3 = 8192(0x2000, float:1.148E-41)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Exception -> L33 javax.net.ssl.SSLHandshakeException -> L35 java.lang.Throwable -> L56
        L1a:
            int r4 = r1.read(r3)     // Catch: java.lang.Exception -> L33 javax.net.ssl.SSLHandshakeException -> L35 java.lang.Throwable -> L56
            r5 = -1
            if (r4 == r5) goto L26
            r5 = 0
            r2.write(r3, r5, r4)     // Catch: java.lang.Exception -> L33 javax.net.ssl.SSLHandshakeException -> L35 java.lang.Throwable -> L56
            goto L1a
        L26:
            r1.close()     // Catch: java.lang.Exception -> L33 javax.net.ssl.SSLHandshakeException -> L35 java.lang.Throwable -> L56
            byte[] r0 = r2.toByteArray()     // Catch: java.lang.Exception -> L33 javax.net.ssl.SSLHandshakeException -> L35 java.lang.Throwable -> L56
            if (r1 == 0) goto L32
            r1.close()     // Catch: java.io.IOException -> L32
        L32:
            return r0
        L33:
            r2 = move-exception
            goto L3b
        L35:
            r2 = move-exception
            goto L46
        L37:
            r1 = r0
            goto L56
        L39:
            r2 = move-exception
            r1 = r0
        L3b:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto L43
            r1.close()     // Catch: java.io.IOException -> L43
        L43:
            return r0
        L44:
            r2 = move-exception
            r1 = r0
        L46:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L56
            java.lang.String r2 = "T_NET"
            java.lang.String r3 = "javax.net.ssl.SSLPeerUnverifiedException"
            android.util.Log.e(r2, r3)     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto L55
            r1.close()     // Catch: java.io.IOException -> L55
        L55:
            return r0
        L56:
            if (r1 == 0) goto L5b
            r1.close()     // Catch: java.io.IOException -> L5b
        L5b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.libcommon.netcore.BaseConnection.doGetRequest():byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] doPostRequest(byte[] r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.libcommon.netcore.BaseConnection.doPostRequest(byte[]):byte[]");
    }

    public byte[] doRequest(HttpBasicRequest httpBasicRequest) {
        if (getURLConnection() == null) {
            Log.e(LOG_TAG, "URLConnection is null");
            return null;
        }
        setURLConnectionCommonPara();
        HashMap<String, String> map = new HashMap<>();
        if (httpBasicRequest.getRequestProperties() != null) {
            map.putAll(httpBasicRequest.getRequestProperties());
        }
        String contentType = httpBasicRequest.getContentType();
        if (contentType != null) {
            map.put("Content-Type", contentType);
        }
        setURLConnectionRequestProperty(map);
        HashMap<String, String> map2 = httpBasicRequest.cookieInfo;
        if (map2 != null && map2.size() > 0) {
            setURLConnectionCookie(httpBasicRequest.cookieInfo);
        }
        if (!HttpBasicRequest.POST.equals(httpBasicRequest.method)) {
            return doGetRequest();
        }
        byte[] data = httpBasicRequest.getData();
        if (data == null) {
            data = new byte[0];
        }
        return doPostRequest(data);
    }

    public Map<String, List<String>> getResponseAllHeaders() {
        HttpURLConnection uRLConnection = getURLConnection();
        if (uRLConnection == null) {
            return null;
        }
        try {
            return uRLConnection.getHeaderFields();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public int getResponseCode() {
        HttpURLConnection uRLConnection = getURLConnection();
        if (uRLConnection == null) {
            return -1;
        }
        try {
            return uRLConnection.getResponseCode();
        } catch (IOException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public String getResponseHeader(String str) {
        HttpURLConnection uRLConnection = getURLConnection();
        if (uRLConnection == null) {
            return null;
        }
        try {
            return uRLConnection.getHeaderField(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getResponseMessage() {
        HttpURLConnection uRLConnection = getURLConnection();
        if (uRLConnection == null) {
            return "";
        }
        try {
            return uRLConnection.getResponseMessage();
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public abstract HttpURLConnection getURLConnection();

    public void setTimeOut(int i2, int i3) {
        this.mConnectTimeout = i2;
        this.mReadTimeout = i3;
    }

    public void setURLConnectionCommonPara() {
        HttpURLConnection uRLConnection = getURLConnection();
        if (uRLConnection == null) {
            return;
        }
        uRLConnection.setConnectTimeout(this.mConnectTimeout);
        uRLConnection.setReadTimeout(this.mReadTimeout);
        uRLConnection.setUseCaches(false);
    }

    public void setURLConnectionCookie(HashMap<String, String> map) {
        HttpURLConnection uRLConnection = getURLConnection();
        if (uRLConnection == null) {
            return;
        }
        String requestProperty = uRLConnection.getRequestProperty("Cookie");
        String str = TextUtils.isEmpty(requestProperty) ? "" : requestProperty + RetryStaticsLOG.MARK_END;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (TextUtils.isEmpty(entry.getKey()) || TextUtils.isEmpty(entry.getValue())) {
                Log.d(LOG_TAG, "cookie inf is bad");
            } else {
                str = str + entry.getKey() + HTTP_REQ_ENTITY_MERGE + entry.getValue() + RetryStaticsLOG.MARK_END;
            }
        }
        uRLConnection.setRequestProperty("Cookie", str);
    }

    public void setURLConnectionRequestProperty(HashMap<String, String> map) {
        HttpURLConnection uRLConnection = getURLConnection();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (TextUtils.isEmpty(entry.getKey()) || TextUtils.isEmpty(entry.getValue())) {
                Log.d(LOG_TAG, "requestProperty is bad");
            } else {
                uRLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }
}
