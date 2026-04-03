package f;

import f.j;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static final Object a(Throwable th) {
        f.z.d.j.e(th, "exception");
        return new j.b(th);
    }

    public static final void b(Object obj) throws Throwable {
        if (obj instanceof j.b) {
            throw ((j.b) obj).a;
        }
    }
}
