package g.a.n2;

/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static final Throwable a(g.a.a<?> aVar, Throwable th) {
        f.w.d<T> dVar;
        f.z.d.j.f(aVar, "$this$tryRecover");
        f.z.d.j.f(th, "exception");
        if (!(aVar instanceof n)) {
            aVar = null;
        }
        n nVar = (n) aVar;
        return (nVar == null || (dVar = nVar.f1617f) == 0) ? th : p.k(th, dVar);
    }
}
