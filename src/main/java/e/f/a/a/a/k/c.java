package e.f.a.a.a.k;

import android.util.Log;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static String a = "UserFireEyeEup";
    public static String b = "FireEyeEup";
    public static boolean c = false;

    public static boolean a(Class cls, String str, Object... objArr) {
        return g(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean b(String str, Object... objArr) {
        return g(1, str, objArr);
    }

    public static boolean c(String str, Object... objArr) {
        return g(3, str, objArr);
    }

    public static boolean d(Throwable th) {
        return h(3, th);
    }

    public static String e(String str, Object... objArr) {
        return str == null ? "null" : (objArr == null || objArr.length == 0) ? str : String.format(Locale.US, str, objArr);
    }

    public static boolean f(String str, Object... objArr) {
        return g(0, str, objArr);
    }

    public static boolean g(int i2, String str, Object... objArr) {
        if (!c) {
            return false;
        }
        String strE = e(str, objArr);
        if (i2 == 0) {
            Log.i(b, strE);
            return true;
        }
        if (i2 == 1) {
            Log.d(b, strE);
            return true;
        }
        if (i2 == 2) {
            Log.w(b, strE);
            return true;
        }
        if (i2 == 3) {
            Log.e(b, strE);
            return true;
        }
        if (i2 != 5) {
            return false;
        }
        Log.i(a, strE);
        return true;
    }

    public static boolean h(int i2, Throwable th) {
        if (c) {
            return g(i2, f.v(th), new Object[0]);
        }
        return false;
    }

    public static boolean i(String str, Object... objArr) {
        return g(5, str, objArr);
    }

    public static boolean j(String str, Object... objArr) {
        return g(2, str, objArr);
    }

    public static boolean k(Throwable th) {
        return h(2, th);
    }
}
