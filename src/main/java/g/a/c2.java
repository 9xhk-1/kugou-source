package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class c2<R> extends s1<t1> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g.a.q2.d<R> f1563h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f.z.c.l<f.w.d<? super R>, Object> f1564i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c2(t1 t1Var, g.a.q2.d<? super R> dVar, f.z.c.l<? super f.w.d<? super R>, ? extends Object> lVar) {
        super(t1Var);
        f.z.d.j.f(t1Var, "job");
        f.z.d.j.f(dVar, "select");
        f.z.d.j.f(lVar, "block");
        this.f1563h = dVar;
        this.f1564i = lVar;
    }

    @Override // f.z.c.l
    public /* bridge */ /* synthetic */ f.s invoke(Throwable th) {
        s(th);
        return f.s.a;
    }

    @Override // g.a.x
    public void s(Throwable th) {
        if (this.f1563h.trySelect(null)) {
            g.a.o2.a.a(this.f1564i, this.f1563h.getCompletion());
        }
    }

    @Override // g.a.n2.i
    public String toString() {
        return "SelectJoinOnCompletion[" + this.f1563h + ']';
    }
}
