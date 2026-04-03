package com.kugou.common.network.protocol.response;

/* JADX INFO: loaded from: classes2.dex */
public class CheckIgnore implements IResponseTypeChecker {
    @Override // com.kugou.common.network.protocol.response.IResponseTypeChecker
    public boolean checkResponseType(byte[] bArr) {
        return true;
    }

    @Override // com.kugou.common.network.protocol.response.IResponseTypeChecker
    public int getCheckType() {
        return 4;
    }
}
