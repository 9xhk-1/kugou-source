package e.c.c.o;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static boolean a = true;

    public static void a(String str, String str2) {
        if (a) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (a) {
            Log.e(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (a) {
            Log.e(str, str2);
        }
    }

    public static boolean d() {
        return a;
    }
}
