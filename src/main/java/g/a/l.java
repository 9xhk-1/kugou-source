package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    public static final void a(j<?> jVar, t0 t0Var) {
        f.z.d.j.f(jVar, "$this$disposeOnCancellation");
        f.z.d.j.f(t0Var, "handle");
        jVar.invokeOnCancellation(new u0(t0Var));
    }

    public static final void b(j<?> jVar, g.a.n2.i iVar) {
        f.z.d.j.f(jVar, "$this$removeOnCancellation");
        f.z.d.j.f(iVar, "node");
        jVar.invokeOnCancellation(new z1(iVar));
    }
}
