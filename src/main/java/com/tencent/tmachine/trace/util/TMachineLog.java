package com.tencent.tmachine.trace.util;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class TMachineLog {
    private static TMachineLogImp TMachineLogImp;
    private static final TMachineLogImp debugLog;
    private static boolean isLogEnabled;

    public interface TMachineLogImp {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static {
        TMachineLogImp tMachineLogImp = new TMachineLogImp() { // from class: com.tencent.tmachine.trace.util.TMachineLog.1
            @Override // com.tencent.tmachine.trace.util.TMachineLog.TMachineLogImp
            public void d(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                Log.d(str, str2);
            }

            @Override // com.tencent.tmachine.trace.util.TMachineLog.TMachineLogImp
            public void e(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                Log.e(str, str2);
            }

            @Override // com.tencent.tmachine.trace.util.TMachineLog.TMachineLogImp
            public void i(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                Log.i(str, str2);
            }

            @Override // com.tencent.tmachine.trace.util.TMachineLog.TMachineLogImp
            public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                if (str2 == null) {
                    str2 = "";
                }
                Log.e(str, str2 + "  " + Log.getStackTraceString(th));
            }

            @Override // com.tencent.tmachine.trace.util.TMachineLog.TMachineLogImp
            public void v(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                Log.v(str, str2);
            }

            @Override // com.tencent.tmachine.trace.util.TMachineLog.TMachineLogImp
            public void w(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                Log.w(str, str2);
            }
        };
        debugLog = tMachineLogImp;
        TMachineLogImp = tMachineLogImp;
        isLogEnabled = false;
    }

    private TMachineLog() {
    }

    public static void d(String str, String str2, Object... objArr) {
        TMachineLogImp tMachineLogImp = TMachineLogImp;
        if (tMachineLogImp == null || !isLogEnabled) {
            return;
        }
        tMachineLogImp.d(str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        TMachineLogImp tMachineLogImp = TMachineLogImp;
        if (tMachineLogImp == null || !isLogEnabled) {
            return;
        }
        tMachineLogImp.e(str, str2, objArr);
    }

    public static TMachineLogImp getImpl() {
        return TMachineLogImp;
    }

    public static void i(String str, String str2, Object... objArr) {
        TMachineLogImp tMachineLogImp = TMachineLogImp;
        if (tMachineLogImp == null || !isLogEnabled) {
            return;
        }
        tMachineLogImp.i(str, str2, objArr);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        TMachineLogImp tMachineLogImp = TMachineLogImp;
        if (tMachineLogImp == null || !isLogEnabled) {
            return;
        }
        tMachineLogImp.printErrStackTrace(str, th, str2, objArr);
    }

    public static void setLogEnable(boolean z) {
        isLogEnabled = z;
    }

    public static void setTMachineLogImp(TMachineLogImp tMachineLogImp) {
        TMachineLogImp = tMachineLogImp;
    }

    public static void v(String str, String str2, Object... objArr) {
        TMachineLogImp tMachineLogImp = TMachineLogImp;
        if (tMachineLogImp == null || !isLogEnabled) {
            return;
        }
        tMachineLogImp.v(str, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        TMachineLogImp tMachineLogImp = TMachineLogImp;
        if (tMachineLogImp == null || !isLogEnabled) {
            return;
        }
        tMachineLogImp.w(str, str2, objArr);
    }
}
