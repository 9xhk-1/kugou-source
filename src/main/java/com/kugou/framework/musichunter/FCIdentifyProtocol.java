package com.kugou.framework.musichunter;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class FCIdentifyProtocol {
    private final long uniqueID;

    public FCIdentifyProtocol(long j) {
        this.uniqueID = j;
    }

    @NonNull
    public RecognizeResult requestInTime(byte[] bArr, int i2) {
        return new MusicFCHttpProtocol(this.uniqueID, RecordType.TYPE_HUMMING).requestIntime(RequestParam.createFc(bArr, i2));
    }
}
