package g.a;

import java.lang.reflect.InvocationTargetException;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 {
    public static final void a(f.w.g gVar, Throwable th) {
        f.z.d.j.f(gVar, "context");
        f.z.d.j.f(th, "exception");
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) gVar.get(CoroutineExceptionHandler.f1692e);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(gVar, th);
            } else {
                c0.a(gVar, th);
            }
        } catch (Throwable th2) {
            c0.a(gVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        f.z.d.j.f(th, "originalException");
        f.z.d.j.f(th2, "thrownException");
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        f.a.a(runtimeException, th);
        return runtimeException;
    }
}
