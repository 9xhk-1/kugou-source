package com.kugou.common.filemanager.downloadengine.http;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class KGHttpResponse {
    private long contentLength;
    private String contentType;
    private InputStream inputStream;
    private int responseCode;

    public KGHttpResponse(int i2, InputStream inputStream) {
        this.responseCode = i2;
        this.inputStream = inputStream;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getContentType() {
        return this.contentType;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setContentLength(long j) {
        this.contentLength = j;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setResponseCode(int i2) {
        this.responseCode = i2;
    }
}
