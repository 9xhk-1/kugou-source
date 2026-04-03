package com.kugou.framework.bilib;

import com.kugou.framework.bilib.common.LibConfig;

/* JADX INFO: loaded from: classes2.dex */
public class LibLog {
    public static boolean DEBUG = true;

    public static void d(String str, String str2) {
        LibConfig.getInstance().log("d", str, str2);
    }

    public static void e(String str, String str2) {
        LibConfig.getInstance().log("e", str, str2);
    }

    public static void i(String str, String str2) {
        LibConfig.getInstance().log("i", str, str2);
    }

    public static void w(String str, String str2) {
        LibConfig.getInstance().log("w", str, str2);
    }
}
