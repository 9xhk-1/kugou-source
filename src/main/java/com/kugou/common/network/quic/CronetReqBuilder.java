package com.kugou.common.network.quic;

import java.util.Objects;
import org.apache.http.Header;

/* JADX INFO: loaded from: classes2.dex */
public class CronetReqBuilder {
    private static final int MAX_REQUREST_TIMEOUT = 180000;
    private static final int MIN_REQUREST_TIMEOUT = 10000;
    public Header[] headers;
    public HttpEntityUploadProvider provider;
    public String url;
    public int timeOut = MAX_REQUREST_TIMEOUT;
    public String method = "GET";

    public CronetReqBuilder addHeader(Header header) {
        Header[] headerArr = this.headers;
        if (headerArr == null) {
            this.headers = new Header[]{header};
        } else {
            int length = headerArr.length;
            Header[] headerArr2 = new Header[length + 1];
            System.arraycopy(headerArr, 0, headerArr2, 0, length);
            headerArr2[length] = header;
            this.headers = headerArr2;
        }
        return this;
    }

    public CronetReqBuilder body(HttpEntityUploadProvider httpEntityUploadProvider) {
        this.provider = httpEntityUploadProvider;
        return this;
    }

    public CronetReqBuilder build() {
        return this;
    }

    public CronetReqBuilder headers(Header[] headerArr) {
        this.headers = headerArr;
        return this;
    }

    public CronetReqBuilder method(String str) {
        this.method = str;
        return this;
    }

    public CronetReqBuilder setTimeOut(int i2, boolean z) {
        if (z) {
            if (i2 <= 0) {
                i2 = 10000;
            }
            this.timeOut = i2;
        } else {
            if (i2 < 10000) {
                i2 = 10000;
            }
            this.timeOut = i2;
        }
        return this;
    }

    public CronetReqBuilder url(String str) {
        Objects.requireNonNull(str, "url == null");
        this.url = str;
        return this;
    }
}
