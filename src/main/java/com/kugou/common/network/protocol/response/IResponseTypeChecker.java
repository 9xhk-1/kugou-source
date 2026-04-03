package com.kugou.common.network.protocol.response;

/* JADX INFO: loaded from: classes2.dex */
public interface IResponseTypeChecker {
    boolean checkResponseType(byte[] bArr);

    int getCheckType();
}
