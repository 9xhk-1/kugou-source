package com.kugou.common.network.ackutils;

import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.networkutils.NetLog;
import com.kugou.common.network.protocol.ResponsePackage;
import org.apache.http.Header;

/* JADX INFO: loaded from: classes2.dex */
public abstract class StringResponsePackage<E> implements ResponsePackage<E> {
    public String mJsonString;

    public String getJsonString() {
        return this.mJsonString;
    }

    @Override // com.kugou.common.network.protocol.ResponsePackage
    public void getResponseData(E e2) {
    }

    @Override // com.kugou.common.network.protocol.ResponsePackage
    public ResponseTypeChecker.ResponseType getResponseType() {
        return ResponseTypeChecker.ResponseType.JSON;
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpException
    public void onContentException(int i2, String str, int i3, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            this.mJsonString = new String(bArr, "UTF-8");
        } catch (Exception unused) {
        }
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpException
    public void onHeaderException(int i2, String str, int i3, Header[] headerArr) {
    }

    @Override // com.kugou.common.network.protocol.ResponsePackage
    public void setContext(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            this.mJsonString = new String(bArr, "UTF-8");
        } catch (Exception e2) {
            NetLog.uploadException(e2);
        }
    }
}
