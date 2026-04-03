package g.a.l2;

/* JADX INFO: loaded from: classes2.dex */
public class l<E> extends a<E> {
    @Override // g.a.l2.a
    public final boolean M() {
        return true;
    }

    @Override // g.a.l2.a
    public final boolean N() {
        return true;
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
        o<?> oVarX;
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
            oVarX = x(e2);
            if (oVarX == null) {
                return obj;
            }
        } while (!(oVarX instanceof h));
        return oVarX;
    }

    @Override // g.a.l2.c
    public Object u(E e2, g.a.q2.d<?> dVar) {
        Object objPerformAtomicTrySelect;
        f.z.d.j.f(dVar, "select");
        do {
            if (L()) {
                objPerformAtomicTrySelect = super.u(e2, dVar);
            } else {
                objPerformAtomicTrySelect = dVar.performAtomicTrySelect(f(e2));
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
}
