package com.kugou.framework.musichunter;

/* JADX INFO: loaded from: classes2.dex */
public class RequestParam {
    public int fcIndex;
    public byte[] fingerprintSlice;
    public int index;
    public boolean isLast;

    public static RequestParam createFc(byte[] bArr, int i2) {
        RequestParam requestParam = new RequestParam();
        requestParam.fingerprintSlice = bArr;
        requestParam.fcIndex = i2;
        return requestParam;
    }

    public static RequestParam createNormal(byte[] bArr, boolean z) {
        RequestParam requestParam = new RequestParam();
        requestParam.fingerprintSlice = bArr;
        requestParam.isLast = z;
        return requestParam;
    }

    public static RequestParam createQc(byte[] bArr, boolean z, int i2) {
        RequestParam requestParam = new RequestParam();
        requestParam.fingerprintSlice = bArr;
        requestParam.isLast = z;
        requestParam.index = i2;
        return requestParam;
    }

    public static RequestParam createSecondLever(byte[] bArr) {
        RequestParam requestParam = new RequestParam();
        requestParam.fingerprintSlice = bArr;
        return requestParam;
    }
}
