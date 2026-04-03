package g.a.o2;

import f.j;
import f.k;
import f.w.d;
import f.w.g;
import f.w.i.c;
import f.w.j.a.h;
import f.z.c.l;
import f.z.c.p;
import f.z.d.j;
import f.z.d.v;
import g.a.n2.o;
import g.a.n2.u;
import g.a.t;
import g.a.u1;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> void a(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r, d<? super T> dVar) {
        j.f(pVar, "$this$startCoroutineUndispatched");
        j.f(dVar, "completion");
        h.a(dVar);
        try {
            g context = dVar.getContext();
            Object objC = u.c(context, null);
            try {
                v.a(pVar, 2);
                Object objInvoke = pVar.invoke(r, dVar);
                if (objInvoke != c.d()) {
                    j.a aVar = f.j.a;
                    f.j.a(objInvoke);
                    dVar.resumeWith(objInvoke);
                }
            } finally {
                u.a(context, objC);
            }
        } catch (Throwable th) {
            j.a aVar2 = f.j.a;
            Object objA = k.a(th);
            f.j.a(objA);
            dVar.resumeWith(objA);
        }
    }

    public static final <T> void b(l<? super d<? super T>, ? extends Object> lVar, d<? super T> dVar) {
        f.z.d.j.f(lVar, "$this$startCoroutineUnintercepted");
        f.z.d.j.f(dVar, "completion");
        h.a(dVar);
        try {
            v.a(lVar, 1);
            Object objInvoke = lVar.invoke(dVar);
            if (objInvoke != c.d()) {
                j.a aVar = f.j.a;
                f.j.a(objInvoke);
                dVar.resumeWith(objInvoke);
            }
        } catch (Throwable th) {
            j.a aVar2 = f.j.a;
            Object objA = k.a(th);
            f.j.a(objA);
            dVar.resumeWith(objA);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> void c(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r, d<? super T> dVar) {
        f.z.d.j.f(pVar, "$this$startCoroutineUnintercepted");
        f.z.d.j.f(dVar, "completion");
        h.a(dVar);
        try {
            v.a(pVar, 2);
            Object objInvoke = pVar.invoke(r, dVar);
            if (objInvoke != c.d()) {
                j.a aVar = f.j.a;
                f.j.a(objInvoke);
                dVar.resumeWith(objInvoke);
            }
        } catch (Throwable th) {
            j.a aVar2 = f.j.a;
            Object objA = k.a(th);
            f.j.a(objA);
            dVar.resumeWith(objA);
        }
    }

    public static final <T, R> Object d(g.a.a<? super T> aVar, R r, p<? super R, ? super d<? super T>, ? extends Object> pVar) throws Throwable {
        Object tVar;
        f.z.d.j.f(aVar, "$this$startUndispatchedOrReturn");
        f.z.d.j.f(pVar, "block");
        aVar.b0();
        try {
            v.a(pVar, 2);
            tVar = pVar.invoke(r, aVar);
        } catch (Throwable th) {
            tVar = new t(th, false, 2, null);
        }
        if (tVar == c.d()) {
            return c.d();
        }
        if (!aVar.D(tVar, 4)) {
            return c.d();
        }
        Object objU = aVar.u();
        if (objU instanceof t) {
            throw o.a(aVar, ((t) objU).a);
        }
        return u1.e(objU);
    }
}
