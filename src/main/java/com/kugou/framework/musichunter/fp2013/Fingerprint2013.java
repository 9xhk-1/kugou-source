package com.kugou.framework.musichunter.fp2013;

/* JADX INFO: loaded from: classes2.dex */
public class Fingerprint2013 {
    private static boolean sLoadOK = false;

    public static boolean loadLibs() {
        try {
            System.loadLibrary("fp");
            System.loadLibrary("fph");
            return true;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean loadOK() {
        if (!sLoadOK) {
            sLoadOK = loadLibs();
        }
        return sLoadOK;
    }

    public native boolean init();

    public native void queryFingerprintSetVersion(long j, int i2);

    public native int[] queryFingerprintXiaokong(long j, byte[] bArr, byte[] bArr2, boolean z);

    public native void queryFingerprintXiaokongFree(long j);

    public native long queryFingerprintXiaokongInit();

    public native long queryFingerprintXiaokongInitIntime();

    public native int resample(int i2, int i3, byte[] bArr, int i4, byte[] bArr2);
}
