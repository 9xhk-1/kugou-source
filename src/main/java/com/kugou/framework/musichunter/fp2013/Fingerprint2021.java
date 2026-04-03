package com.kugou.framework.musichunter.fp2013;

/* JADX INFO: loaded from: classes2.dex */
public class Fingerprint2021 {
    private static boolean sLoadOK = false;

    public static boolean loadLibs() {
        try {
            System.loadLibrary("kugouplayer_covercqt");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean loadOK() {
        if (!sLoadOK) {
            sLoadOK = loadLibs();
        }
        return sLoadOK;
    }

    public native int[] fingerprintFlush(long j, byte[] bArr);

    public native void fingerprintFree(long j);

    public native int[] fingerprintGet(long j, byte[] bArr, byte[] bArr2);

    public native long fingerprintInit(int i2);
}
