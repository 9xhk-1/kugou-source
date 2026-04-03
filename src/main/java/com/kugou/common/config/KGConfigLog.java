package com.kugou.common.config;

/* JADX INFO: loaded from: classes2.dex */
public class KGConfigLog {
    private static IKGConfigLog sLog;

    public static void d(String str, String str2) {
        IKGConfigLog iKGConfigLog = sLog;
        if (iKGConfigLog != null) {
            iKGConfigLog.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        IKGConfigLog iKGConfigLog = sLog;
        if (iKGConfigLog != null) {
            iKGConfigLog.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        IKGConfigLog iKGConfigLog = sLog;
        if (iKGConfigLog != null) {
            iKGConfigLog.d(str, str2);
        }
    }

    public static void setImpl(IKGConfigLog iKGConfigLog) {
        sLog = iKGConfigLog;
    }
}
