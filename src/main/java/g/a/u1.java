package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class u1 {
    public static final g.a.n2.q a = new g.a.n2.q("SEALED");
    public static final v0 b = new v0(false);
    public static final v0 c = new v0(true);

    public static final Object d(Object obj) {
        return obj instanceof h1 ? new i1((h1) obj) : obj;
    }

    public static final Object e(Object obj) {
        h1 h1Var;
        i1 i1Var = (i1) (!(obj instanceof i1) ? null : obj);
        return (i1Var == null || (h1Var = i1Var.a) == null) ? obj : h1Var;
    }
}
