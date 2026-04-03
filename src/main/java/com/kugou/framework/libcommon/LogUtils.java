package com.kugou.framework.libcommon;

import android.util.Log;
import com.kugou.framework.musichunter.Global;

/* JADX INFO: loaded from: classes2.dex */
public class LogUtils {
    public static boolean isLogEnable = false;

    public static void d(String str, String str2) {
        if (Global.isDebugModel()) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (Global.isDebugModel()) {
            Log.e(str, str2);
        }
    }

    public static void log(String str) {
        if (Global.isDebugModel()) {
            Log.d("MusicHunter", str);
        }
    }

    public static void logBi(String str, String str2, String str3) {
        if (Global.isDebugModel() && "d".equals(str)) {
            Log.d("BILog", str2 + ":" + str3);
        }
    }

    public static void logNet(String str) {
        if (Global.isDebugModel()) {
            Log.d("MusicHunter", str);
        }
    }
}
