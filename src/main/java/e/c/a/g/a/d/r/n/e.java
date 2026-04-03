package e.c.a.g.a.d.r.n;

import e.c.a.g.a.s.g0;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class e extends Thread {
    public final BlockingQueue<d<?>> b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d<?> f502d;
    public volatile boolean a = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f503f = new AtomicBoolean(false);

    public e(BlockingQueue<d<?>> blockingQueue) {
        this.b = blockingQueue;
    }

    public void a(d<?> dVar) {
        if (this.f503f.get()) {
            return;
        }
        this.b.add(dVar);
    }

    public final synchronized void b() {
        this.f502d = null;
    }

    public synchronized d<?> c() {
        return this.f502d;
    }

    public void d() {
        this.a = true;
        interrupt();
    }

    public final synchronized void e(d<?> dVar) {
        this.f502d = dVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            try {
                b();
                d<?> dVarTake = this.b.take();
                this.f503f.set(true);
                e(dVarTake);
                if (dVarTake.h() != null) {
                    i.a().b(dVarTake.h());
                    dVarTake.S();
                }
                this.f503f.set(false);
            } catch (InterruptedException e2) {
                g0.k(e2);
                if (this.a) {
                    b();
                    return;
                }
            }
        }
    }
}
