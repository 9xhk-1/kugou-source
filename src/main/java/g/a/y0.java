package g.a;

import g.a.x0;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y0 extends w0 {
    public abstract Thread o();

    public final void p(long j, x0.a aVar) {
        f.z.d.j.f(aVar, "delayedTask");
        if (k0.a()) {
            if (!(this != m0.j)) {
                throw new AssertionError();
            }
        }
        m0.j.z(j, aVar);
    }

    public final void q() {
        Thread threadO = o();
        if (Thread.currentThread() != threadO) {
            g2 g2VarA = h2.a();
            if (g2VarA != null) {
                g2VarA.unpark(threadO);
            } else {
                LockSupport.unpark(threadO);
            }
        }
    }
}
