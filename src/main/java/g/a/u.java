package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class u {
    public static final <T> Object a(Object obj) {
        if (f.j.d(obj)) {
            f.k.b(obj);
            return obj;
        }
        Throwable thB = f.j.b(obj);
        if (thB != null) {
            return new t(thB, false, 2, null);
        }
        f.z.d.j.n();
        throw null;
    }
}
