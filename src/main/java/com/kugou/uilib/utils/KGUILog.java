package com.kugou.uilib.utils;

import android.util.Log;
import com.kugou.uilib.IKGUIBuild;
import com.kugou.uilib.KGUI;

/* JADX INFO: loaded from: classes2.dex */
public class KGUILog {
    private static String TAG = "KGUILog-";
    public static volatile long endTime;
    public static final boolean DEBUG = KGUI.getInstance().isDebugOpen();
    public static boolean isInitialTime = false;

    public static void d(String str, String str2) {
        if (DEBUG) {
            Log.d(TAG + str, str2 + "" + getCurLineForJump(4));
            writeAllLog(str2);
        }
    }

    public static void e(String str, String str2) {
        String str3;
        if (DEBUG) {
            String str4 = TAG + str;
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = str2 + getCurLineForJump(4);
            }
            Log.e(str4, str3);
            writeAllLog(str2);
        }
    }

    private static String getCurLineForJump(int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || i2 < 0 || i2 >= stackTrace.length) {
            return "";
        }
        return "\n==> at " + stackTrace[i2];
    }

    public static String getStack() {
        return Log.getStackTraceString(new RuntimeException("KGLog_StackTrace"));
    }

    public static void i(String str, String str2) {
        String str3;
        if (DEBUG) {
            String str4 = TAG + str;
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = str2 + getCurLineForJump(4);
            }
            Log.i(str4, str3);
        }
    }

    public static void iLFCurrentStack(String str) {
        iLFCurrentStack(str, null);
    }

    public static void s(String str, String str2) {
        if (DEBUG) {
            e(str, str2);
            iLFCurrentStack(str);
        }
    }

    public static void splitLogI(String str, String str2) {
        if (str2 == null) {
            return;
        }
        int length = str2.length();
        if (length <= 4000) {
            Log.i(TAG + str, str2);
            return;
        }
        int i2 = 0;
        int i3 = (length / 4000) + (length % 4000 == 0 ? 0 : 1);
        while (i2 < i3) {
            Log.i(TAG + str, "[-" + i2 + "-]" + (i2 != i3 + (-1) ? str2.substring(i2 * 4000, (i2 + 1) * 4000) : str2.substring(i2 * 4000, Math.min((i2 + 1) * 4000, length))));
            i2++;
        }
    }

    public static void uploadException(Throwable th) {
        IKGUIBuild.IUploadExceptionListener uploadExceptionListener = KGUI.getInstance().getUploadExceptionListener();
        if (uploadExceptionListener != null) {
            uploadExceptionListener.processUploadException(th);
        } else {
            e(th.getMessage());
        }
    }

    public static void v(String str, String str2) {
        if (DEBUG) {
            Log.v(TAG + str, str2 + "" + getCurLineForJump(4));
            writeAllLog(str2);
        }
    }

    public static void w(String str, String str2) {
        String str3;
        if (DEBUG) {
            String str4 = TAG + str;
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = str2 + getCurLineForJump(4);
            }
            Log.w(str4, str3);
            writeAllLog(str2);
        }
    }

    public static void writeAllLog(String str) {
    }

    private static void iLFCurrentStack(String str, String str2) {
        if (DEBUG) {
            if (str2 == null) {
                str2 = getStack();
            }
            splitLogI(str, str2);
        }
    }

    public static void i(String str) {
        i(TAG, str);
    }

    public static void d(String str) {
        d(TAG, str);
    }

    public static void e(String str) {
        e(TAG, str);
    }
}
