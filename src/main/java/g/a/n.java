package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends o1<m1> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k<?> f1607h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(m1 m1Var, k<?> kVar) {
        super(m1Var);
        f.z.d.j.f(m1Var, "parent");
        f.z.d.j.f(kVar, "child");
        this.f1607h = kVar;
    }

    @Override // f.z.c.l
    public /* bridge */ /* synthetic */ f.s invoke(Throwable th) {
        s(th);
        return f.s.a;
    }

    @Override // g.a.x
    public void s(Throwable th) {
        k<?> kVar = this.f1607h;
        kVar.cancel(kVar.k(this.f1650f));
    }

    @Override // g.a.n2.i
    public String toString() {
        return "ChildContinuation[" + this.f1607h + ']';
    }
}
