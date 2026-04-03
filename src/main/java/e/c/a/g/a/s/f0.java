package e.c.a.g.a.s;

import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class f0 {
    public static void a(String str, boolean z) {
        f(str, !z);
    }

    public static void b(boolean z) {
        a(null, z);
    }

    public static void c() {
        if (g0.a) {
            g(Looper.getMainLooper() == Looper.myLooper());
        }
    }

    public static void d(Object obj) {
        e(null, obj);
    }

    public static void e(String str, Object obj) {
        f(str, obj != null);
    }

    public static void f(String str, boolean z) {
        if (z) {
            return;
        }
        h(str);
    }

    public static void g(boolean z) {
        f(null, z);
    }

    public static void h(String str) {
        if (g0.a) {
            throw new Error(str);
        }
    }
}
