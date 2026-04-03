package g.a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class k1 extends o1<m1> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f1573i = AtomicIntegerFieldUpdater.newUpdater(k1.class, "_invoked");
    private volatile int _invoked;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f.z.c.l<Throwable, f.s> f1574h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public k1(m1 m1Var, f.z.c.l<? super Throwable, f.s> lVar) {
        super(m1Var);
        f.z.d.j.f(m1Var, "job");
        f.z.d.j.f(lVar, "handler");
        this.f1574h = lVar;
        this._invoked = 0;
    }

    @Override // f.z.c.l
    public /* bridge */ /* synthetic */ f.s invoke(Throwable th) {
        s(th);
        return f.s.a;
    }

    @Override // g.a.x
    public void s(Throwable th) {
        if (f1573i.compareAndSet(this, 0, 1)) {
            this.f1574h.invoke(th);
        }
    }

    @Override // g.a.n2.i
    public String toString() {
        return "InvokeOnCancelling[" + l0.a(this) + '@' + l0.b(this) + ']';
    }
}
