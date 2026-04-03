package g.a;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 {
    public static final List<CoroutineExceptionHandler> a;

    static {
        Iterator it = ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator();
        f.z.d.j.b(it, "ServiceLoader.load(\n    ….classLoader\n).iterator()");
        a = f.d0.i.h(f.d0.g.c(it));
    }

    public static final void a(f.w.g gVar, Throwable th) {
        f.z.d.j.f(gVar, "context");
        f.z.d.j.f(th, "exception");
        Iterator<CoroutineExceptionHandler> it = a.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(gVar, th);
            } catch (Throwable th2) {
                Thread threadCurrentThread = Thread.currentThread();
                f.z.d.j.b(threadCurrentThread, "currentThread");
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, d0.b(th, th2));
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        f.z.d.j.b(threadCurrentThread2, "currentThread");
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }
}
