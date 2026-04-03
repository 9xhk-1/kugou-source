package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class l1 extends s1<m1> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f.z.c.l<Throwable, f.s> f1575h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public l1(m1 m1Var, f.z.c.l<? super Throwable, f.s> lVar) {
        super(m1Var);
        f.z.d.j.f(m1Var, "job");
        f.z.d.j.f(lVar, "handler");
        this.f1575h = lVar;
    }

    @Override // f.z.c.l
    public /* bridge */ /* synthetic */ f.s invoke(Throwable th) {
        s(th);
        return f.s.a;
    }

    @Override // g.a.x
    public void s(Throwable th) {
        this.f1575h.invoke(th);
    }

    @Override // g.a.n2.i
    public String toString() {
        return "InvokeOnCompletion[" + l0.a(this) + '@' + l0.b(this) + ']';
    }
}
