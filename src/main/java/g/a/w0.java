package g.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w0 extends b0 {
    public long a;
    public boolean b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g.a.n2.a<q0<?>> f1659d;

    public static /* synthetic */ void d(w0 w0Var, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i2 & 1) != 0) {
            z = false;
        }
        w0Var.c(z);
    }

    public static /* synthetic */ void i(w0 w0Var, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i2 & 1) != 0) {
            z = false;
        }
        w0Var.h(z);
    }

    public final void c(boolean z) {
        long jE = this.a - e(z);
        this.a = jE;
        if (jE > 0) {
            return;
        }
        if (k0.a()) {
            if (!(this.a == 0)) {
                throw new AssertionError();
            }
        }
        if (this.b) {
            shutdown();
        }
    }

    public final long e(boolean z) {
        return z ? 4294967296L : 1L;
    }

    public final void f(q0<?> q0Var) {
        f.z.d.j.f(q0Var, "task");
        g.a.n2.a<q0<?>> aVar = this.f1659d;
        if (aVar == null) {
            aVar = new g.a.n2.a<>();
            this.f1659d = aVar;
        }
        aVar.a(q0Var);
    }

    public long g() {
        g.a.n2.a<q0<?>> aVar = this.f1659d;
        return (aVar == null || aVar.c()) ? Long.MAX_VALUE : 0L;
    }

    public final void h(boolean z) {
        this.a += e(z);
        if (z) {
            return;
        }
        this.b = true;
    }

    public final boolean j() {
        return this.a >= e(true);
    }

    public final boolean k() {
        g.a.n2.a<q0<?>> aVar = this.f1659d;
        if (aVar != null) {
            return aVar.c();
        }
        return true;
    }

    public long l() {
        if (m()) {
            return g();
        }
        return Long.MAX_VALUE;
    }

    public final boolean m() {
        q0<?> q0VarD;
        g.a.n2.a<q0<?>> aVar = this.f1659d;
        if (aVar == null || (q0VarD = aVar.d()) == null) {
            return false;
        }
        q0VarD.run();
        return true;
    }

    public boolean n() {
        return false;
    }

    public void shutdown() {
    }
}
