package com.kugou.common.network.protocol.response;

/* JADX INFO: loaded from: classes2.dex */
public class CheckNotEmpty implements IResponseTypeChecker {
    @Override // com.kugou.common.network.protocol.response.IResponseTypeChecker
    public boolean checkResponseType(byte[] bArr) {
        return bArr != null && bArr.length > 0;
    }

    @Override // com.kugou.common.network.protocol.response.IResponseTypeChecker
    public int getCheckType() {
        return 0;
    }
}
