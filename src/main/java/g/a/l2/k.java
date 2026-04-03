package g.a.l2;

import g.a.l2.c;

/* JADX INFO: loaded from: classes2.dex */
public class k<E> extends a<E> {
    @Override // g.a.l2.a
    public final boolean M() {
        return true;
    }

    @Override // g.a.l2.a
    public final boolean N() {
        return true;
    }

    public final void Z(c.a<? extends E> aVar) {
        for (g.a.n2.i iVarK = aVar.k(); iVarK instanceof c.a; iVarK = iVarK.k()) {
            if (!iVarK.p()) {
                iVarK.m();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final o<?> a0(E e2) {
        g.a.n2.i iVar;
        c.a<? extends E> aVar = new c.a<>(e2);
        g.a.n2.g gVarN = n();
        do {
            Object objJ = gVarN.j();
            if (objJ == null) {
                throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            iVar = (g.a.n2.i) objJ;
            if (iVar instanceof o) {
                return (o) iVar;
            }
        } while (!iVar.b(aVar, gVarN));
        Z(aVar);
        return null;
    }

    @Override // g.a.l2.c
    public final boolean r() {
        return false;
    }

    @Override // g.a.l2.c
    public final boolean s() {
        return false;
    }

    @Override // g.a.l2.c
    public Object t(E e2) {
        o<?> oVarA0;
        do {
            Object objT = super.t(e2);
            Object obj = b.a;
            if (objT == obj) {
                return obj;
            }
            if (objT != b.b) {
                if (objT instanceof h) {
                    return objT;
                }
                throw new IllegalStateException(("Invalid offerInternal result " + objT).toString());
            }
            oVarA0 = a0(e2);
            if (oVarA0 == null) {
                return obj;
            }
        } while (!(oVarA0 instanceof h));
        return oVarA0;
    }

    @Override // g.a.l2.c
    public Object u(E e2, g.a.q2.d<?> dVar) {
        Object objPerformAtomicTrySelect;
        f.z.d.j.f(dVar, "select");
        do {
            if (L()) {
                objPerformAtomicTrySelect = super.u(e2, dVar);
            } else {
                objPerformAtomicTrySelect = dVar.performAtomicTrySelect(g(e2));
                if (objPerformAtomicTrySelect == null) {
                    objPerformAtomicTrySelect = b.a;
                }
            }
            if (objPerformAtomicTrySelect == g.a.q2.e.a()) {
                return g.a.q2.e.a();
            }
            Object obj = b.a;
            if (objPerformAtomicTrySelect == obj) {
                return obj;
            }
        } while (objPerformAtomicTrySelect == b.b);
        if (objPerformAtomicTrySelect instanceof h) {
            return objPerformAtomicTrySelect;
        }
        throw new IllegalStateException(("Invalid result " + objPerformAtomicTrySelect).toString());
    }

    @Override // g.a.l2.c
    public void v(g.a.n2.i iVar) {
        f.z.d.j.f(iVar, "closed");
        g.a.n2.i iVarK = iVar.k();
        if (!(iVarK instanceof c.a)) {
            iVarK = null;
        }
        c.a<? extends E> aVar = (c.a) iVarK;
        if (aVar != null) {
            Z(aVar);
        }
    }
}
