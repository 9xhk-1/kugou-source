package g.a.o2;

import f.j;
import f.k;
import f.s;
import f.w.d;
import f.z.c.l;
import f.z.c.p;
import f.z.d.j;
import g.a.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final <T> void a(l<? super d<? super T>, ? extends Object> lVar, d<? super T> dVar) {
        j.f(lVar, "$this$startCoroutineCancellable");
        j.f(dVar, "completion");
        try {
            p0.d(f.w.i.b.c(f.w.i.b.a(lVar, dVar)), s.a);
        } catch (Throwable th) {
            j.a aVar = f.j.a;
            Object objA = k.a(th);
            f.j.a(objA);
            dVar.resumeWith(objA);
        }
    }

    public static final <R, T> void b(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r, d<? super T> dVar) {
        f.z.d.j.f(pVar, "$this$startCoroutineCancellable");
        f.z.d.j.f(dVar, "completion");
        try {
            p0.d(f.w.i.b.c(f.w.i.b.b(pVar, r, dVar)), s.a);
        } catch (Throwable th) {
            j.a aVar = f.j.a;
            Object objA = k.a(th);
            f.j.a(objA);
            dVar.resumeWith(objA);
        }
    }
}
