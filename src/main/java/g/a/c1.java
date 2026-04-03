package g.a;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c1 extends b1 {
    @Override // g.a.b0
    public void a(f.w.g gVar, Runnable runnable) {
        Runnable runnableWrapTask;
        f.z.d.j.f(gVar, "context");
        f.z.d.j.f(runnable, "block");
        try {
            Executor executorC = c();
            g2 g2VarA = h2.a();
            if (g2VarA == null || (runnableWrapTask = g2VarA.wrapTask(runnable)) == null) {
                runnableWrapTask = runnable;
            }
            executorC.execute(runnableWrapTask);
        } catch (RejectedExecutionException unused) {
            g2 g2VarA2 = h2.a();
            if (g2VarA2 != null) {
                g2VarA2.unTrackTask();
            }
            m0.j.u(runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorC = c();
        if (!(executorC instanceof ExecutorService)) {
            executorC = null;
        }
        ExecutorService executorService = (ExecutorService) executorC;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final void d() {
        g.a.n2.e.b(c());
    }

    public boolean equals(Object obj) {
        return (obj instanceof c1) && ((c1) obj).c() == c();
    }

    public int hashCode() {
        return System.identityHashCode(c());
    }

    @Override // g.a.b0
    public String toString() {
        return c().toString();
    }
}
