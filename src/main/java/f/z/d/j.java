package f.z.d;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str + " must not be null");
        j(illegalStateException);
        throw illegalStateException;
    }

    public static void c(Object obj) {
        if (obj != null) {
            return;
        }
        m();
        throw null;
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str + " must not be null");
        j(nullPointerException);
        throw nullPointerException;
    }

    public static void e(Object obj, String str) {
        if (obj != null) {
            return;
        }
        p(str);
        throw null;
    }

    public static void f(Object obj, String str) {
        if (obj != null) {
            return;
        }
        o(str);
        throw null;
    }

    public static int g(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    public static String h(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void i(int i2, String str) {
        q();
        throw null;
    }

    public static <T extends Throwable> T j(T t) {
        k(t, j.class.getName());
        return t;
    }

    public static <T extends Throwable> T k(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return t;
    }

    public static String l(String str, Object obj) {
        return str + obj;
    }

    public static void m() {
        NullPointerException nullPointerException = new NullPointerException();
        j(nullPointerException);
        throw nullPointerException;
    }

    public static void n() {
        f.c cVar = new f.c();
        j(cVar);
        throw cVar;
    }

    public static void o(String str) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(h(str));
        j(illegalArgumentException);
        throw illegalArgumentException;
    }

    public static void p(String str) {
        NullPointerException nullPointerException = new NullPointerException(h(str));
        j(nullPointerException);
        throw nullPointerException;
    }

    public static void q() {
        r("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
        throw null;
    }

    public static void r(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void s(String str) {
        f.r rVar = new f.r(str);
        j(rVar);
        throw rVar;
    }

    public static void t(String str) {
        s("lateinit property " + str + " has not been initialized");
        throw null;
    }
}
