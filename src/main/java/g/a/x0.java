package g.a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x0 extends y0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1660f = AtomicReferenceFieldUpdater.newUpdater(x0.class, Object.class, "_queue");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1661h = AtomicReferenceFieldUpdater.newUpdater(x0.class, Object.class, "_delayed");
    public volatile boolean isCompleted;
    private volatile Object _queue = null;
    private volatile Object _delayed = null;

    public static abstract class a implements Runnable, Comparable<a>, t0, g.a.n2.y {
        public Object a;
        public int b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f1662d;

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            f.z.d.j.f(aVar, "other");
            long j = this.f1662d - aVar.f1662d;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        public final synchronized int b(long j, b bVar, x0 x0Var) {
            f.z.d.j.f(bVar, "delayed");
            f.z.d.j.f(x0Var, "eventLoop");
            if (this.a == a1.a) {
                return 2;
            }
            synchronized (bVar) {
                a aVarB = bVar.b();
                if (x0Var.isCompleted) {
                    return 1;
                }
                if (aVarB == null) {
                    bVar.b = j;
                } else {
                    long j2 = aVarB.f1662d;
                    if (j2 - j < 0) {
                        j = j2;
                    }
                    if (j - bVar.b > 0) {
                        bVar.b = j;
                    }
                }
                long j3 = this.f1662d;
                long j4 = bVar.b;
                if (j3 - j4 < 0) {
                    this.f1662d = j4;
                }
                bVar.a(this);
                return 0;
            }
        }

        public final boolean c(long j) {
            return j - this.f1662d >= 0;
        }

        @Override // g.a.t0
        public final synchronized void dispose() {
            Object obj = this.a;
            if (obj == a1.a) {
                return;
            }
            if (!(obj instanceof b)) {
                obj = null;
            }
            b bVar = (b) obj;
            if (bVar != null) {
                bVar.g(this);
            }
            this.a = a1.a;
        }

        @Override // g.a.n2.y
        public g.a.n2.x<?> getHeap() {
            Object obj = this.a;
            if (!(obj instanceof g.a.n2.x)) {
                obj = null;
            }
            return (g.a.n2.x) obj;
        }

        @Override // g.a.n2.y
        public int getIndex() {
            return this.b;
        }

        @Override // g.a.n2.y
        public void setHeap(g.a.n2.x<?> xVar) {
            if (!(this.a != a1.a)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.a = xVar;
        }

        @Override // g.a.n2.y
        public void setIndex(int i2) {
            this.b = i2;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f1662d + ']';
        }
    }

    public static final class b extends g.a.n2.x<a> {
        public long b;

        public b(long j) {
            this.b = j;
        }
    }

    public final int A(long j, a aVar) {
        if (this.isCompleted) {
            return 1;
        }
        b bVar = (b) this._delayed;
        if (bVar == null) {
            f1661h.compareAndSet(this, null, new b(j));
            Object obj = this._delayed;
            if (obj == null) {
                f.z.d.j.n();
                throw null;
            }
            bVar = (b) obj;
        }
        return aVar.b(j, bVar, this);
    }

    public final boolean B(a aVar) {
        b bVar = (b) this._delayed;
        return (bVar != null ? bVar.e() : null) == aVar;
    }

    @Override // g.a.b0
    public final void a(f.w.g gVar, Runnable runnable) {
        f.z.d.j.f(gVar, "context");
        f.z.d.j.f(runnable, "block");
        u(runnable);
    }

    @Override // g.a.w0
    public long g() {
        a aVarE;
        if (super.g() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof g.a.n2.k)) {
                return obj == a1.b ? Long.MAX_VALUE : 0L;
            }
            if (!((g.a.n2.k) obj).j()) {
                return 0L;
            }
        }
        b bVar = (b) this._delayed;
        if (bVar == null || (aVarE = bVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j = aVarE.f1662d;
        g2 g2VarA = h2.a();
        return f.b0.f.c(j - (g2VarA != null ? g2VarA.nanoTime() : System.nanoTime()), 0L);
    }

    @Override // g.a.w0
    public long l() {
        a aVarH;
        if (m()) {
            return g();
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            g2 g2VarA = h2.a();
            long jNanoTime = g2VarA != null ? g2VarA.nanoTime() : System.nanoTime();
            do {
                synchronized (bVar) {
                    a aVarB = bVar.b();
                    if (aVarB != null) {
                        a aVar = aVarB;
                        aVarH = aVar.c(jNanoTime) ? v(aVar) : false ? bVar.h(0) : null;
                    }
                }
            } while (aVarH != null);
        }
        Runnable runnableT = t();
        if (runnableT != null) {
            runnableT.run();
        }
        return g();
    }

    public final void s() {
        if (k0.a() && !this.isCompleted) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (f1660f.compareAndSet(this, null, a1.b)) {
                    return;
                }
            } else {
                if (obj instanceof g.a.n2.k) {
                    ((g.a.n2.k) obj).g();
                    return;
                }
                if (obj == a1.b) {
                    return;
                }
                g.a.n2.k kVar = new g.a.n2.k(8, true);
                if (obj == null) {
                    throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
                kVar.d((Runnable) obj);
                if (f1660f.compareAndSet(this, obj, kVar)) {
                    return;
                }
            }
        }
    }

    @Override // g.a.w0
    public void shutdown() {
        f2.b.c();
        this.isCompleted = true;
        s();
        while (l() <= 0) {
        }
        x();
    }

    public final Runnable t() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof g.a.n2.k) {
                if (obj == null) {
                    throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
                g.a.n2.k kVar = (g.a.n2.k) obj;
                Object objM = kVar.m();
                if (objM != g.a.n2.k.f1614g) {
                    return (Runnable) objM;
                }
                f1660f.compareAndSet(this, obj, kVar.l());
            } else {
                if (obj == a1.b) {
                    return null;
                }
                if (f1660f.compareAndSet(this, obj, null)) {
                    if (obj != null) {
                        return (Runnable) obj;
                    }
                    throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }

    public final void u(Runnable runnable) {
        f.z.d.j.f(runnable, "task");
        if (v(runnable)) {
            q();
        } else {
            m0.j.u(runnable);
        }
    }

    public final boolean v(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (this.isCompleted) {
                return false;
            }
            if (obj == null) {
                if (f1660f.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof g.a.n2.k) {
                if (obj == null) {
                    throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
                g.a.n2.k kVar = (g.a.n2.k) obj;
                int iD = kVar.d(runnable);
                if (iD == 0) {
                    return true;
                }
                if (iD == 1) {
                    f1660f.compareAndSet(this, obj, kVar.l());
                } else if (iD == 2) {
                    return false;
                }
            } else {
                if (obj == a1.b) {
                    return false;
                }
                g.a.n2.k kVar2 = new g.a.n2.k(8, true);
                if (obj == null) {
                    throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
                kVar2.d((Runnable) obj);
                kVar2.d(runnable);
                if (f1660f.compareAndSet(this, obj, kVar2)) {
                    return true;
                }
            }
        }
    }

    public boolean w() {
        if (!k()) {
            return false;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof g.a.n2.k) {
                return ((g.a.n2.k) obj).j();
            }
            if (obj != a1.b) {
                return false;
            }
        }
        return true;
    }

    public final void x() {
        a aVarI;
        g2 g2VarA = h2.a();
        long jNanoTime = g2VarA != null ? g2VarA.nanoTime() : System.nanoTime();
        while (true) {
            b bVar = (b) this._delayed;
            if (bVar == null || (aVarI = bVar.i()) == null) {
                return;
            } else {
                p(jNanoTime, aVarI);
            }
        }
    }

    public final void y() {
        this._queue = null;
        this._delayed = null;
    }

    public final void z(long j, a aVar) {
        f.z.d.j.f(aVar, "delayedTask");
        int iA = A(j, aVar);
        if (iA == 0) {
            if (B(aVar)) {
                q();
            }
        } else if (iA == 1) {
            p(j, aVar);
        } else if (iA != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }
}
