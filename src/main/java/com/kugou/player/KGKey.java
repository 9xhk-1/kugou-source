package com.kugou.player;

/* JADX INFO: loaded from: classes2.dex */
public class KGKey {
    static {
        System.loadLibrary("kgkey");
    }

    private static native String decryptAvatar(String str);

    private static native String getA(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    private static native String getB(String str, String str2, String str3, String str4, String str5, String str6);

    private static native String native_encryptString(String str);
}
