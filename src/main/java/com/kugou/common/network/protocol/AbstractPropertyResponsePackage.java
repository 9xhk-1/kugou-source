package com.kugou.common.network.protocol;

import com.kugou.common.network.AbsHttpClient;
import org.apache.http.Header;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractPropertyResponsePackage<T> implements ResponsePackage<T>, AbsHttpClient.IHttpProperty {
    @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
    public boolean onContentType(String str) {
        return true;
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
    public boolean onHeaders(Header[] headerArr) {
        return true;
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
    public boolean onResponseCode(int i2) {
        return true;
    }
}
