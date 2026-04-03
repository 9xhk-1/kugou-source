package f.z.d;

import f.z.c.w;

/* JADX INFO: loaded from: classes2.dex */
public class v {
    public static Object a(Object obj, int i2) {
        if (obj == null || c(obj, i2)) {
            return obj;
        }
        f(obj, "kotlin.jvm.functions.Function" + i2);
        throw null;
    }

    public static int b(Object obj) {
        if (obj instanceof h) {
            return ((h) obj).getArity();
        }
        if (obj instanceof f.z.c.a) {
            return 0;
        }
        if (obj instanceof f.z.c.l) {
            return 1;
        }
        if (obj instanceof f.z.c.p) {
            return 2;
        }
        if (obj instanceof f.z.c.q) {
            return 3;
        }
        if (obj instanceof f.z.c.r) {
            return 4;
        }
        if (obj instanceof f.z.c.s) {
            return 5;
        }
        if (obj instanceof f.z.c.t) {
            return 6;
        }
        if (obj instanceof f.z.c.u) {
            return 7;
        }
        if (obj instanceof f.z.c.v) {
            return 8;
        }
        if (obj instanceof w) {
            return 9;
        }
        if (obj instanceof f.z.c.b) {
            return 10;
        }
        if (obj instanceof f.z.c.c) {
            return 11;
        }
        if (obj instanceof f.z.c.d) {
            return 12;
        }
        if (obj instanceof f.z.c.e) {
            return 13;
        }
        if (obj instanceof f.z.c.f) {
            return 14;
        }
        if (obj instanceof f.z.c.g) {
            return 15;
        }
        if (obj instanceof f.z.c.h) {
            return 16;
        }
        if (obj instanceof f.z.c.i) {
            return 17;
        }
        if (obj instanceof f.z.c.j) {
            return 18;
        }
        if (obj instanceof f.z.c.k) {
            return 19;
        }
        if (obj instanceof f.z.c.m) {
            return 20;
        }
        if (obj instanceof f.z.c.n) {
            return 21;
        }
        return obj instanceof f.z.c.o ? 22 : -1;
    }

    public static boolean c(Object obj, int i2) {
        return (obj instanceof f.b) && b(obj) == i2;
    }

    public static <T extends Throwable> T d(T t) {
        j.k(t, v.class.getName());
        return t;
    }

    public static ClassCastException e(ClassCastException classCastException) {
        d(classCastException);
        throw classCastException;
    }

    public static void f(Object obj, String str) {
        g((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
        throw null;
    }

    public static void g(String str) {
        e(new ClassCastException(str));
        throw null;
    }
}
