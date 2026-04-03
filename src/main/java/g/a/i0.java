package g.a;

/* JADX INFO: loaded from: classes2.dex */
public enum i0 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public final <R, T> void a(f.z.c.p<? super R, ? super f.w.d<? super T>, ? extends Object> pVar, R r, f.w.d<? super T> dVar) {
        f.z.d.j.f(pVar, "block");
        f.z.d.j.f(dVar, "completion");
        int i2 = h0.b[ordinal()];
        if (i2 == 1) {
            g.a.o2.a.b(pVar, r, dVar);
            return;
        }
        if (i2 == 2) {
            f.w.f.a(pVar, r, dVar);
        } else if (i2 == 3) {
            g.a.o2.b.a(pVar, r, dVar);
        } else if (i2 != 4) {
            throw new f.h();
        }
    }
}
