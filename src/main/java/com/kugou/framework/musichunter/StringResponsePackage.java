package com.kugou.framework.musichunter;

import com.kugou.framework.libcommon.ResponsePackage;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public class StringResponsePackage<E> implements ResponsePackage<E> {
    public String mJsonString;

    public String getJsonString() {
        return this.mJsonString;
    }

    @Override // com.kugou.framework.libcommon.ResponsePackage
    public void getResponseData(E e2) {
    }

    @Override // com.kugou.framework.libcommon.ResponsePackage
    public void setContext(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            this.mJsonString = new String(bArr, Charset.forName("UTF-8"));
        } catch (Exception unused) {
        }
    }
}
