package g.a;

import g.a.m1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public class k<T> extends q0<T> implements j<T>, f.w.j.a.e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f1569i = AtomicIntegerFieldUpdater.newUpdater(k.class, "_decision");
    public static final AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_state");
    private volatile int _decision;
    private volatile Object _state;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f.w.g f1570f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f.w.d<T> f1571h;
    public volatile t0 parentHandle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public k(f.w.d<? super T> dVar, int i2) {
        super(i2);
        f.z.d.j.f(dVar, "delegate");
        this.f1571h = dVar;
        this.f1570f = dVar.getContext();
        this._decision = 0;
        this._state = b.a;
    }

    @Override // g.a.q0
    public void b(Object obj, Throwable th) {
        f.z.d.j.f(th, "cause");
        if (obj instanceof w) {
            try {
                ((w) obj).b.invoke(th);
            } catch (Throwable th2) {
                d0.a(getContext(), new y("Exception in cancellation handler for " + this, th2));
            }
        }
    }

    @Override // g.a.q0
    public final f.w.d<T> c() {
        return this.f1571h;
    }

    @Override // g.a.j
    public boolean cancel(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof x1)) {
                return false;
            }
            z = obj instanceof h;
        } while (!j.compareAndSet(this, obj, new m(this, th, z)));
        if (z) {
            try {
                ((h) obj).a(th);
            } catch (Throwable th2) {
                d0.a(getContext(), new y("Exception in cancellation handler for " + this, th2));
            }
        }
        j();
        i(0);
        return true;
    }

    @Override // g.a.j
    public void completeResume(Object obj) {
        f.z.d.j.f(obj, "token");
        i(this.f1648d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g.a.q0
    public <T> T e(Object obj) {
        return obj instanceof v ? (T) ((v) obj).b : obj instanceof w ? (T) ((w) obj).a : obj;
    }

    @Override // g.a.q0
    public Object g() {
        return m();
    }

    @Override // f.w.j.a.e
    public f.w.j.a.e getCallerFrame() {
        f.w.d<T> dVar = this.f1571h;
        if (!(dVar instanceof f.w.j.a.e)) {
            dVar = null;
        }
        return (f.w.j.a.e) dVar;
    }

    @Override // g.a.j, f.w.d
    public f.w.g getContext() {
        return this.f1570f;
    }

    @Override // f.w.j.a.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final void h(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    public final void i(int i2) {
        if (s()) {
            return;
        }
        p0.b(this, i2);
    }

    @Override // g.a.j
    public /* synthetic */ void initCancellability() {
    }

    @Override // g.a.j
    public void invokeOnCancellation(f.z.c.l<? super Throwable, f.s> lVar) {
        Object obj;
        f.z.d.j.f(lVar, "handler");
        h hVarO = null;
        do {
            obj = this._state;
            if (!(obj instanceof b)) {
                if (obj instanceof h) {
                    p(lVar, obj);
                    throw null;
                }
                if (obj instanceof m) {
                    if (!((m) obj).b()) {
                        p(lVar, obj);
                        throw null;
                    }
                    try {
                        if (!(obj instanceof t)) {
                            obj = null;
                        }
                        t tVar = (t) obj;
                        lVar.invoke(tVar != null ? tVar.a : null);
                        return;
                    } catch (Throwable th) {
                        d0.a(getContext(), new y("Exception in cancellation handler for " + this, th));
                        return;
                    }
                }
                return;
            }
            if (hVarO == null) {
                hVarO = o(lVar);
            }
        } while (!j.compareAndSet(this, obj, hVarO));
    }

    @Override // g.a.j
    public boolean isActive() {
        return m() instanceof x1;
    }

    @Override // g.a.j
    public boolean isCancelled() {
        return m() instanceof m;
    }

    @Override // g.a.j
    public boolean isCompleted() {
        return !(m() instanceof x1);
    }

    public final void j() {
        t0 t0Var = this.parentHandle;
        if (t0Var != null) {
            t0Var.dispose();
            this.parentHandle = w1.a;
        }
    }

    public Throwable k(m1 m1Var) {
        f.z.d.j.f(m1Var, "parent");
        return m1Var.getCancellationException();
    }

    public final Object l() {
        m1 m1Var;
        n();
        if (t()) {
            return f.w.i.c.d();
        }
        Object objM = m();
        if (objM instanceof t) {
            throw g.a.n2.p.k(((t) objM).a, this);
        }
        if (this.f1648d != 1 || (m1Var = (m1) getContext().get(m1.f1605g)) == null || m1Var.isActive()) {
            return e(objM);
        }
        CancellationException cancellationException = m1Var.getCancellationException();
        b(objM, cancellationException);
        throw g.a.n2.p.k(cancellationException, this);
    }

    public final Object m() {
        return this._state;
    }

    public final void n() {
        m1 m1Var;
        if (isCompleted() || (m1Var = (m1) this.f1571h.getContext().get(m1.f1605g)) == null) {
            return;
        }
        m1Var.start();
        t0 t0VarE = m1.a.e(m1Var, true, false, new n(m1Var, this), 2, null);
        this.parentHandle = t0VarE;
        if (isCompleted()) {
            t0VarE.dispose();
            this.parentHandle = w1.a;
        }
    }

    public final h o(f.z.c.l<? super Throwable, f.s> lVar) {
        return lVar instanceof h ? (h) lVar : new j1(lVar);
    }

    public final void p(f.z.c.l<? super Throwable, f.s> lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    public String q() {
        return "CancellableContinuation";
    }

    public final m r(Object obj, int i2) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof x1)) {
                if (obj2 instanceof m) {
                    m mVar = (m) obj2;
                    if (mVar.c()) {
                        return mVar;
                    }
                }
                h(obj);
                throw null;
            }
        } while (!j.compareAndSet(this, obj2, obj));
        j();
        i(i2);
        return null;
    }

    @Override // g.a.j
    public void resume(T t, f.z.c.l<? super Throwable, f.s> lVar) {
        f.z.d.j.f(lVar, "onCancellation");
        m mVarR = r(new w(t, lVar), this.f1648d);
        if (mVarR != null) {
            try {
                lVar.invoke(mVarR.a);
            } catch (Throwable th) {
                d0.a(getContext(), new y("Exception in cancellation handler for " + this, th));
            }
        }
    }

    @Override // g.a.j
    public void resumeUndispatched(b0 b0Var, T t) {
        f.z.d.j.f(b0Var, "$this$resumeUndispatched");
        f.w.d<T> dVar = this.f1571h;
        if (!(dVar instanceof n0)) {
            dVar = null;
        }
        n0 n0Var = (n0) dVar;
        r(t, (n0Var != null ? n0Var.j : null) == b0Var ? 3 : this.f1648d);
    }

    @Override // g.a.j
    public void resumeUndispatchedWithException(b0 b0Var, Throwable th) {
        f.z.d.j.f(b0Var, "$this$resumeUndispatchedWithException");
        f.z.d.j.f(th, "exception");
        f.w.d<T> dVar = this.f1571h;
        if (!(dVar instanceof n0)) {
            dVar = null;
        }
        n0 n0Var = (n0) dVar;
        r(new t(th, false, 2, null), (n0Var != null ? n0Var.j : null) == b0Var ? 3 : this.f1648d);
    }

    @Override // g.a.j, f.w.d
    public void resumeWith(Object obj) {
        r(u.a(obj), this.f1648d);
    }

    public final boolean s() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f1569i.compareAndSet(this, 0, 2));
        return true;
    }

    public final boolean t() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f1569i.compareAndSet(this, 0, 1));
        return true;
    }

    public String toString() {
        return q() + '(' + l0.c(this.f1571h) + "){" + m() + "}@" + l0.b(this);
    }

    @Override // g.a.j
    public Object tryResume(T t, Object obj) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof x1)) {
                if (!(obj2 instanceof v)) {
                    return null;
                }
                v vVar = (v) obj2;
                if (vVar.a != obj) {
                    return null;
                }
                if (k0.a()) {
                    if (!(vVar.b == t)) {
                        throw new AssertionError();
                    }
                }
                return vVar.c;
            }
        } while (!j.compareAndSet(this, obj2, obj == null ? t : new v(obj, t, (x1) obj2)));
        j();
        return obj2;
    }

    @Override // g.a.j
    public Object tryResumeWithException(Throwable th) {
        Object obj;
        f.z.d.j.f(th, "exception");
        do {
            obj = this._state;
            if (!(obj instanceof x1)) {
                return null;
            }
        } while (!j.compareAndSet(this, obj, new t(th, false, 2, null)));
        j();
        return obj;
    }
}
