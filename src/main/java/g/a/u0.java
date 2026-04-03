package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 extends h {
    public final t0 a;

    public u0(t0 t0Var) {
        f.z.d.j.f(t0Var, "handle");
        this.a = t0Var;
    }

    @Override // g.a.i
    public void a(Throwable th) {
        this.a.dispose();
    }

    @Override // f.z.c.l
    public /* bridge */ /* synthetic */ f.s invoke(Throwable th) {
        a(th);
        return f.s.a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.a + ']';
    }
}
