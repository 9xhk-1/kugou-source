package g.a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class o0<T> extends g.a.n2.n<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f1621h = AtomicIntegerFieldUpdater.newUpdater(o0.class, "_decision");
    private volatile int _decision;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(f.w.g gVar, f.w.d<? super T> dVar) {
        super(gVar, dVar);
        f.z.d.j.f(gVar, "context");
        f.z.d.j.f(dVar, "uCont");
        this._decision = 0;
    }

    @Override // g.a.n2.n, g.a.a
    public int a0() {
        return 1;
    }

    @Override // g.a.n2.n, g.a.t1
    public void d(Object obj, int i2) {
        if (i0()) {
            return;
        }
        super.d(obj, i2);
    }

    public final Object h0() throws Throwable {
        if (j0()) {
            return f.w.i.c.d();
        }
        Object objE = u1.e(u());
        if (objE instanceof t) {
            throw ((t) objE).a;
        }
        return objE;
    }

    public final boolean i0() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f1621h.compareAndSet(this, 0, 2));
        return true;
    }

    public final boolean j0() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f1621h.compareAndSet(this, 0, 1));
        return true;
    }
}
