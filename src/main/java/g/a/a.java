package g.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> extends t1 implements m1, f.w.d<T>, g0 {
    public final f.w.g b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f.w.g f1559d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f.w.g gVar, boolean z) {
        super(z);
        f.z.d.j.f(gVar, "parentContext");
        this.f1559d = gVar;
        this.b = gVar.plus(this);
    }

    @Override // g.a.t1
    public String F() {
        String strB = a0.b(this.b);
        if (strB == null) {
            return super.F();
        }
        return '\"' + strB + "\":" + super.F();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g.a.t1
    public final void K(Object obj) {
        if (!(obj instanceof t)) {
            d0(obj);
        } else {
            t tVar = (t) obj;
            c0(tVar.a, tVar.a());
        }
    }

    @Override // g.a.t1
    public final void L() {
        e0();
    }

    public int a0() {
        return 0;
    }

    public final void b0() {
        x((m1) this.f1559d.get(m1.f1605g));
    }

    public void c0(Throwable th, boolean z) {
        f.z.d.j.f(th, "cause");
    }

    public void d0(T t) {
    }

    public void e0() {
    }

    public final <R> void f0(i0 i0Var, R r, f.z.c.p<? super R, ? super f.w.d<? super T>, ? extends Object> pVar) {
        f.z.d.j.f(i0Var, "start");
        f.z.d.j.f(pVar, "block");
        b0();
        i0Var.a(pVar, r, this);
    }

    @Override // f.w.d
    public final f.w.g getContext() {
        return this.b;
    }

    @Override // g.a.g0
    public f.w.g getCoroutineContext() {
        return this.b;
    }

    @Override // g.a.t1, g.a.m1, g.a.q, g.a.y1
    public boolean isActive() {
        return super.isActive();
    }

    @Override // f.w.d
    public final void resumeWith(Object obj) {
        D(u.a(obj), a0());
    }

    @Override // g.a.t1
    public final void w(Throwable th) {
        f.z.d.j.f(th, "exception");
        d0.a(this.b, th);
    }
}
