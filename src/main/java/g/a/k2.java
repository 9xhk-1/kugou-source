package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class k2 {
    public static final void a(f.w.g gVar) {
        f.z.d.j.f(gVar, "$this$checkCompletion");
        m1 m1Var = (m1) gVar.get(m1.f1605g);
        if (m1Var != null && !m1Var.isActive()) {
            throw m1Var.getCancellationException();
        }
    }
}
