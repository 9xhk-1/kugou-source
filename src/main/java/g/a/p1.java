package g.a;

/* JADX INFO: loaded from: classes2.dex */
public class p1 extends t1 implements s {
    public final boolean b;

    public p1(m1 m1Var) {
        super(true);
        x(m1Var);
        this.b = a0();
    }

    public final boolean a0() {
        t1 t1Var;
        o oVar = this.parentHandle;
        if (!(oVar instanceof p)) {
            oVar = null;
        }
        p pVar = (p) oVar;
        if (pVar != null && (t1Var = (t1) pVar.f1650f) != null) {
            while (!t1Var.r()) {
                o oVar2 = t1Var.parentHandle;
                if (!(oVar2 instanceof p)) {
                    oVar2 = null;
                }
                p pVar2 = (p) oVar2;
                if (pVar2 == null || (t1Var = (t1) pVar2.f1650f) == null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // g.a.s
    public boolean complete() {
        return C(f.s.a);
    }

    @Override // g.a.s
    public boolean completeExceptionally(Throwable th) {
        f.z.d.j.f(th, "exception");
        return C(new t(th, false, 2, null));
    }

    @Override // g.a.t1
    public boolean r() {
        return this.b;
    }

    @Override // g.a.t1
    public boolean s() {
        return true;
    }
}
