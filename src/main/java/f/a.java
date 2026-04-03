package f;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final void a(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        f.z.d.j.e(th, "$this$addSuppressed");
        f.z.d.j.e(th2, "exception");
        if (th != th2) {
            f.x.b.a.a(th, th2);
        }
    }
}
