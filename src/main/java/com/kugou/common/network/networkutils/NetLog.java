package com.kugou.common.network.networkutils;

/* JADX INFO: loaded from: classes2.dex */
public class NetLog {
    private static ILog mLog;

    /* JADX INFO: loaded from: classes.dex */
    public interface ILog {
        void d(String str);

        void d(String str, String str2);

        void e(String str);

        void e(String str, String str2);

        void e(String str, String str2, Throwable th);

        void i(String str);

        void i(String str, String str2);

        boolean isDebug();

        void uploadException(Throwable th);
    }

    public static void d(String str) {
        ILog iLog = mLog;
        if (iLog != null) {
            iLog.d(str);
        }
    }

    public static void e(String str) {
        ILog iLog = mLog;
        if (iLog != null) {
            iLog.e(str);
        }
    }

    public static void i(String str) {
        ILog iLog = mLog;
        if (iLog != null) {
            iLog.i(str);
        }
    }

    public static void init(ILog iLog) {
        mLog = iLog;
    }

    public static boolean isDebug() {
        ILog iLog = mLog;
        if (iLog != null) {
            return iLog.isDebug();
        }
        return false;
    }

    public static void uploadException(Throwable th) {
        ILog iLog = mLog;
        if (iLog != null) {
            iLog.uploadException(th);
        }
    }

    public static void d(String str, String str2) {
        ILog iLog = mLog;
        if (iLog != null) {
            iLog.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        ILog iLog = mLog;
        if (iLog != null) {
            iLog.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        ILog iLog = mLog;
        if (iLog != null) {
            iLog.i(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        ILog iLog = mLog;
        if (iLog != null) {
            iLog.e(str, str2, th);
        }
    }
}
