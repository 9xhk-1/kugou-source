package g.a.p2;

import g.a.b1;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends b1 implements j, Executor {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f1639h = AtomicIntegerFieldUpdater.newUpdater(f.class, "inFlightTasks");
    public final ConcurrentLinkedQueue<Runnable> a;
    public final d b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1640d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f1641f;
    private volatile int inFlightTasks;

    public f(d dVar, int i2, l lVar) {
        f.z.d.j.f(dVar, "dispatcher");
        f.z.d.j.f(lVar, "taskMode");
        this.b = dVar;
        this.f1640d = i2;
        this.f1641f = lVar;
        this.a = new ConcurrentLinkedQueue<>();
        this.inFlightTasks = 0;
    }

    @Override // g.a.b0
    public void a(f.w.g gVar, Runnable runnable) {
        f.z.d.j.f(gVar, "context");
        f.z.d.j.f(runnable, "block");
        d(runnable, false);
    }

    @Override // g.a.p2.j
    public void afterTask() {
        Runnable runnablePoll = this.a.poll();
        if (runnablePoll != null) {
            this.b.f(runnablePoll, this, true);
            return;
        }
        f1639h.decrementAndGet(this);
        Runnable runnablePoll2 = this.a.poll();
        if (runnablePoll2 != null) {
            d(runnablePoll2, true);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    public final void d(Runnable runnable, boolean z) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f1639h;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.f1640d) {
                this.b.f(runnable, this, z);
                return;
            }
            this.a.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.f1640d) {
                return;
            } else {
                runnable = this.a.poll();
            }
        } while (runnable != null);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        f.z.d.j.f(runnable, "command");
        d(runnable, false);
    }

    @Override // g.a.p2.j
    public l getTaskMode() {
        return this.f1641f;
    }

    @Override // g.a.b0
    public String toString() {
        return super.toString() + "[dispatcher = " + this.b + ']';
    }
}
