package g.a.n2;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static final Object a = new q("CONDITION_FALSE");

    static {
        new q("ALREADY_REMOVED");
        new q("LIST_EMPTY");
        new q("REMOVE_PREPARED");
    }

    public static final Object a() {
        return a;
    }

    public static final i b(Object obj) {
        i iVar;
        f.z.d.j.f(obj, "$this$unwrap");
        m mVar = (m) (!(obj instanceof m) ? null : obj);
        return (mVar == null || (iVar = mVar.a) == null) ? (i) obj : iVar;
    }
}
