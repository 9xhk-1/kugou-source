package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends o1<t1> implements o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q f1622h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(t1 t1Var, q qVar) {
        super(t1Var);
        f.z.d.j.f(t1Var, "parent");
        f.z.d.j.f(qVar, "childJob");
        this.f1622h = qVar;
    }

    @Override // g.a.o
    public boolean childCancelled(Throwable th) {
        f.z.d.j.f(th, "cause");
        return ((t1) this.f1650f).j(th);
    }

    @Override // f.z.c.l
    public /* bridge */ /* synthetic */ f.s invoke(Throwable th) {
        s(th);
        return f.s.a;
    }

    @Override // g.a.x
    public void s(Throwable th) {
        this.f1622h.parentCancelled((y1) this.f1650f);
    }

    @Override // g.a.n2.i
    public String toString() {
        return "ChildHandle[" + this.f1622h + ']';
    }
}
