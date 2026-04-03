package com.kugou.framework.libcommon.netcore;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public class HttpEntity {
    private String contentType;
    private byte[] mBytes;

    public HttpEntity(byte[] bArr, String str) {
        this.mBytes = bArr;
        this.contentType = str;
    }

    public byte[] getBody() {
        return this.mBytes;
    }

    public String getContentType() {
        return this.contentType;
    }

    public HttpEntity(String str, String str2) {
        this.mBytes = str.getBytes(Charset.forName("UTF-8"));
        this.contentType = str2;
    }
}
