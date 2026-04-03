package g.a;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public final class c<T> extends a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Thread f1561f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w0 f1562h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(f.w.g gVar, Thread thread, w0 w0Var) {
        super(gVar, true);
        f.z.d.j.f(gVar, "parentContext");
        f.z.d.j.f(thread, "blockedThread");
        this.f1561f = thread;
        this.f1562h = w0Var;
    }

    @Override // g.a.t1
    public void d(Object obj, int i2) {
        if (!f.z.d.j.a(Thread.currentThread(), this.f1561f)) {
            LockSupport.unpark(this.f1561f);
        }
    }

    public final T g0() throws Throwable {
        g2 g2VarA = h2.a();
        if (g2VarA != null) {
            g2VarA.registerTimeLoopThread();
        }
        try {
            w0 w0Var = this.f1562h;
            if (w0Var != null) {
                w0.i(w0Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    w0 w0Var2 = this.f1562h;
                    long jL = w0Var2 != null ? w0Var2.l() : Long.MAX_VALUE;
                    if (isCompleted()) {
                        T t = (T) u1.e(u());
                        t tVar = (t) (t instanceof t ? t : null);
                        if (tVar == null) {
                            return t;
                        }
                        throw tVar.a;
                    }
                    g2 g2VarA2 = h2.a();
                    if (g2VarA2 != null) {
                        g2VarA2.parkNanos(this, jL);
                    } else {
                        LockSupport.parkNanos(this, jL);
                    }
                } finally {
                    w0 w0Var3 = this.f1562h;
                    if (w0Var3 != null) {
                        w0.d(w0Var3, false, 1, null);
                    }
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            e(interruptedException);
            throw interruptedException;
        } finally {
            g2 g2VarA3 = h2.a();
            if (g2VarA3 != null) {
                g2VarA3.unregisterTimeLoopThread();
            }
        }
    }

    @Override // g.a.t1
    public boolean y() {
        return true;
    }
}
