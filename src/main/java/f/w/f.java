package f.w;

import f.j;
import f.s;
import f.z.c.p;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final <R, T> void a(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r, d<? super T> dVar) {
        j.e(pVar, "$this$startCoroutine");
        j.e(dVar, "completion");
        d dVarC = f.w.i.b.c(f.w.i.b.b(pVar, r, dVar));
        s sVar = s.a;
        j.a aVar = f.j.a;
        f.j.a(sVar);
        dVarC.resumeWith(sVar);
    }
}
