package g.a.p2;

import g.a.n2.k;

/* JADX INFO: loaded from: classes2.dex */
public class e extends g.a.n2.j<i> {
    public e() {
        super(false);
    }

    public final i e(l lVar) {
        Object obj;
        Object obj2;
        f.z.d.j.f(lVar, "mode");
        while (true) {
            g.a.n2.k kVar = (g.a.n2.k) this._cur$internal;
            while (true) {
                long j = kVar._state$internal;
                obj = null;
                if ((1152921504606846976L & j) == 0) {
                    k.a aVar = g.a.n2.k.f1615h;
                    int i2 = (int) ((1073741823 & j) >> 0);
                    if ((kVar.a & ((int) ((1152921503533105152L & j) >> 30))) == (kVar.a & i2)) {
                        break;
                    }
                    obj2 = kVar.b.get(kVar.a & i2);
                    if (obj2 != null) {
                        if (obj2 instanceof k.b) {
                            break;
                        }
                        if (!(((i) obj2).a() == lVar)) {
                            break;
                        }
                        int i3 = (i2 + 1) & 1073741823;
                        if (g.a.n2.k.f1613f.compareAndSet(kVar, j, aVar.b(j, i3))) {
                            kVar.b.set(kVar.a & i2, null);
                            break;
                        }
                        if (kVar.f1616d) {
                            g.a.n2.k kVarN = kVar;
                            do {
                                kVarN = kVarN.n(i2, i3);
                            } while (kVarN != null);
                        }
                    } else if (kVar.f1616d) {
                        break;
                    }
                } else {
                    obj = g.a.n2.k.f1614g;
                    break;
                }
            }
            obj = obj2;
            if (obj != g.a.n2.k.f1614g) {
                return (i) obj;
            }
            g.a.n2.j.a.compareAndSet(this, kVar, kVar.l());
        }
    }
}
