package g.a.n2;

import g.a.n2.k;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public class j<E> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_cur$internal");
    public volatile /* synthetic */ Object _cur$internal;

    public j(boolean z) {
        this._cur$internal = new k(8, z);
    }

    public final boolean a(E e2) {
        f.z.d.j.f(e2, "element");
        while (true) {
            k kVar = (k) this._cur$internal;
            int iD = kVar.d(e2);
            if (iD == 0) {
                return true;
            }
            if (iD == 1) {
                a.compareAndSet(this, kVar, kVar.l());
            } else if (iD == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            k kVar = (k) this._cur$internal;
            if (kVar.g()) {
                return;
            } else {
                a.compareAndSet(this, kVar, kVar.l());
            }
        }
    }

    public final int c() {
        return ((k) this._cur$internal).i();
    }

    public final E d() {
        E e2;
        Object obj;
        while (true) {
            k kVar = (k) this._cur$internal;
            while (true) {
                long j = kVar._state$internal;
                e2 = null;
                if ((1152921504606846976L & j) == 0) {
                    k.a aVar = k.f1615h;
                    int i2 = (int) ((1073741823 & j) >> 0);
                    if ((((int) ((1152921503533105152L & j) >> 30)) & kVar.a) == (kVar.a & i2)) {
                        break;
                    }
                    obj = kVar.b.get(kVar.a & i2);
                    if (obj == null) {
                        if (kVar.f1616d) {
                            break;
                        }
                    } else {
                        if (obj instanceof k.b) {
                            break;
                        }
                        int i3 = (i2 + 1) & 1073741823;
                        if (k.f1613f.compareAndSet(kVar, j, aVar.b(j, i3))) {
                            kVar.b.set(kVar.a & i2, null);
                            break;
                        }
                        if (kVar.f1616d) {
                            k kVarN = kVar;
                            do {
                                kVarN = kVarN.n(i2, i3);
                            } while (kVarN != null);
                        }
                    }
                } else {
                    e2 = (E) k.f1614g;
                    break;
                }
            }
            e2 = (E) obj;
            if (e2 != k.f1614g) {
                return e2;
            }
            a.compareAndSet(this, kVar, kVar.l());
        }
    }
}
