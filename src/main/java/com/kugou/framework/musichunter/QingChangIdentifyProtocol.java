package com.kugou.framework.musichunter;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class QingChangIdentifyProtocol {
    private final long uniqueID;

    public QingChangIdentifyProtocol(long j) {
        this.uniqueID = j;
    }

    @NonNull
    public RecognizeResult requestInTime(byte[] bArr, boolean z, int i2) {
        return new MusicQingChangHttpProtocol(this.uniqueID).requestIntime(RequestParam.createQc(bArr, z, i2));
    }
}
