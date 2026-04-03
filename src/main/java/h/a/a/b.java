package h.a.a;

import android.util.Log;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static void a(String str, String str2) {
        b(str, str2, new Object[0]);
    }

    public static void b(String str, String str2, Object... objArr) {
        String strE = e(str2, objArr);
        Throwable thG = g(objArr);
        if (thG != null) {
            Log.d(i(str), strE, thG);
        } else {
            Log.d(i(str), strE);
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        String strD = d(str2, objArr);
        Throwable thG = g(objArr);
        if (thG != null) {
            Log.e(i(str), strD, thG);
        } else {
            Log.e(i(str), strD);
        }
    }

    public static String d(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(Locale.US, str, objArr);
    }

    public static String e(String str, Object... objArr) {
        return "[" + f() + "] " + d(str, objArr);
    }

    public static String f() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = b.class.getName();
        int i2 = 0;
        while (true) {
            if (i2 >= stackTrace.length) {
                break;
            }
            if (stackTrace[i2].getClassName().equals(name)) {
                i2 += 4;
                break;
            }
            i2++;
        }
        return stackTrace[i2].getFileName() + ":" + stackTrace[i2].getLineNumber();
    }

    public static Throwable g(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }

    public static void h(String str, String str2, Object... objArr) {
        String strD = d(str2, objArr);
        Throwable thG = g(objArr);
        if (thG != null) {
            Log.i(i(str), strD, thG);
        } else {
            Log.i(i(str), strD);
        }
    }

    public static String i(String str) {
        if (str.startsWith("cr_")) {
            return str;
        }
        return "cr_" + str.substring(str.startsWith("cr.") ? 3 : 0, str.length());
    }

    public static void j(String str, String str2, Object... objArr) {
        String strD = d(str2, objArr);
        Throwable thG = g(objArr);
        if (thG != null) {
            Log.w(i(str), strD, thG);
        } else {
            Log.w(i(str), strD);
        }
    }
}
