package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class z1 extends h {
    public final g.a.n2.i a;

    public z1(g.a.n2.i iVar) {
        f.z.d.j.f(iVar, "node");
        this.a = iVar;
    }

    @Override // g.a.i
    public void a(Throwable th) {
        this.a.p();
    }

    @Override // f.z.c.l
    public /* bridge */ /* synthetic */ f.s invoke(Throwable th) {
        a(th);
        return f.s.a;
    }

    public String toString() {
        return "RemoveOnCancel[" + this.a + ']';
    }
}
