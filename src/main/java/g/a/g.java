package g.a;

import f.w.e;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g {
    public static final <T> Object a(f.w.g gVar, f.z.c.p<? super g0, ? super f.w.d<? super T>, ? extends Object> pVar, f.w.d<? super T> dVar) throws Throwable {
        Object objH0;
        f.w.g context = dVar.getContext();
        f.w.g gVarPlus = context.plus(gVar);
        k2.a(gVarPlus);
        if (gVarPlus == context) {
            g.a.n2.n nVar = new g.a.n2.n(gVarPlus, dVar);
            objH0 = g.a.o2.b.d(nVar, nVar, pVar);
        } else {
            e.b bVar = f.w.e.c;
            if (f.z.d.j.a((f.w.e) gVarPlus.get(bVar), (f.w.e) context.get(bVar))) {
                j2 j2Var = new j2(gVarPlus, dVar);
                Object objC = g.a.n2.u.c(gVarPlus, null);
                try {
                    Object objD = g.a.o2.b.d(j2Var, j2Var, pVar);
                    g.a.n2.u.a(gVarPlus, objC);
                    objH0 = objD;
                } catch (Throwable th) {
                    g.a.n2.u.a(gVarPlus, objC);
                    throw th;
                }
            } else {
                o0 o0Var = new o0(gVarPlus, dVar);
                o0Var.b0();
                g.a.o2.a.b(pVar, o0Var, o0Var);
                objH0 = o0Var.h0();
            }
        }
        if (objH0 == f.w.i.c.d()) {
            f.w.j.a.h.c(dVar);
        }
        return objH0;
    }
}
