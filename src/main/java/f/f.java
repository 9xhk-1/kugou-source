package f;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static final <T> d<T> a(g gVar, f.z.c.a<? extends T> aVar) {
        f.z.d.j.e(gVar, "mode");
        f.z.d.j.e(aVar, "initializer");
        int i2 = e.a[gVar.ordinal()];
        if (i2 == 1) {
            return new m(aVar, null, 2, null);
        }
        if (i2 == 2) {
            return new l(aVar);
        }
        if (i2 == 3) {
            return new t(aVar);
        }
        throw new h();
    }

    public static final <T> d<T> b(f.z.c.a<? extends T> aVar) {
        f.z.d.j.e(aVar, "initializer");
        return new m(aVar, null, 2, null);
    }
}
