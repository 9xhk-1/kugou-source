package com.kugou.common.network.protocol;

import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.ResponseTypeChecker;

/* JADX INFO: loaded from: classes2.dex */
public interface ResponsePackage<T> extends AbsHttpClient.IHttpException {
    void getResponseData(T t);

    ResponseTypeChecker.ResponseType getResponseType();

    void setContext(byte[] bArr);
}
