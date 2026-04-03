package com.kugou.framework.musichunter;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class MusicPcmIdentifyProtocol {
    private final long uniqueID;

    public MusicPcmIdentifyProtocol(long j) {
        this.uniqueID = j;
    }

    @NonNull
    public RecognizeResult requestInTime(byte[] bArr) {
        RequestParam requestParam = new RequestParam();
        requestParam.fingerprintSlice = bArr;
        return new MusicPcmHttpProtocol(this.uniqueID).requestIntime(requestParam);
    }
}
