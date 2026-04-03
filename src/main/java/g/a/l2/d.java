package g.a.l2;

import g.a.k0;
import g.a.l2.c;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class d<E> extends a<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReentrantLock f1595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object[] f1596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1598g;
    public volatile int size;

    public d(int i2) {
        this.f1598g = i2;
        if (i2 >= 1) {
            this.f1595d = new ReentrantLock();
            this.f1596e = new Object[Math.min(i2, 8)];
        } else {
            throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i2 + " was specified").toString());
        }
    }

    @Override // g.a.l2.a
    public void H() {
        ReentrantLock reentrantLock = this.f1595d;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.f1596e[this.f1597f] = 0;
                this.f1597f = (this.f1597f + 1) % this.f1596e.length;
            }
            this.size = 0;
            f.s sVar = f.s.a;
            reentrantLock.unlock();
            super.H();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // g.a.l2.a
    public final boolean M() {
        return false;
    }

    @Override // g.a.l2.a
    public final boolean N() {
        return this.size == 0;
    }

    @Override // g.a.l2.a
    public Object Q() {
        q qVar;
        Object objV;
        ReentrantLock reentrantLock = this.f1595d;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            if (i2 == 0) {
                Object objL = l();
                if (objL == null) {
                    objL = b.c;
                }
                return objL;
            }
            Object[] objArr = this.f1596e;
            int i3 = this.f1597f;
            Object obj = objArr[i3];
            objArr[i3] = null;
            this.size = i2 - 1;
            Object objT = b.c;
            if (i2 == this.f1598g) {
                qVar = null;
                objV = null;
                while (true) {
                    q qVarA = A();
                    if (qVarA == null) {
                        break;
                    }
                    if (qVarA == null) {
                        f.z.d.j.n();
                        throw null;
                    }
                    objV = qVarA.v(null);
                    if (objV == null) {
                        qVar = qVarA;
                    } else {
                        if (qVarA == null) {
                            f.z.d.j.n();
                            throw null;
                        }
                        objT = qVarA.t();
                        qVar = qVarA;
                    }
                }
            } else {
                qVar = null;
                objV = null;
            }
            if (objT != b.c && !(objT instanceof h)) {
                this.size = i2;
                Object[] objArr2 = this.f1596e;
                objArr2[(this.f1597f + i2) % objArr2.length] = objT;
            }
            this.f1597f = (this.f1597f + 1) % this.f1596e.length;
            f.s sVar = f.s.a;
            if (objV != null) {
                if (qVar == null) {
                    f.z.d.j.n();
                    throw null;
                }
                qVar.s(objV);
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a5  */
    @Override // g.a.l2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object R(g.a.q2.d<?> r11) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.l2.d.R(g.a.q2.d):java.lang.Object");
    }

    public final void Z(int i2) {
        Object[] objArr = this.f1596e;
        if (i2 >= objArr.length) {
            Object[] objArr2 = new Object[Math.min(objArr.length * 2, this.f1598g)];
            for (int i3 = 0; i3 < i2; i3++) {
                Object[] objArr3 = this.f1596e;
                objArr2[i3] = objArr3[(this.f1597f + i3) % objArr3.length];
            }
            this.f1596e = objArr2;
            this.f1597f = 0;
        }
    }

    @Override // g.a.l2.c
    public String j() {
        return "(buffer:capacity=" + this.f1598g + ",size=" + this.size + ')';
    }

    @Override // g.a.l2.c
    public final boolean r() {
        return false;
    }

    @Override // g.a.l2.c
    public final boolean s() {
        return this.size == this.f1598g;
    }

    @Override // g.a.l2.c
    public Object t(E e2) {
        o<E> oVarZ;
        Object objTryResumeReceive;
        ReentrantLock reentrantLock = this.f1595d;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            h<?> hVarL = l();
            if (hVarL != null) {
                return hVarL;
            }
            if (i2 >= this.f1598g) {
                return b.b;
            }
            this.size = i2 + 1;
            if (i2 == 0) {
                do {
                    oVarZ = z();
                    if (oVarZ != null) {
                        if (oVarZ instanceof h) {
                            this.size = i2;
                            if (oVarZ != null) {
                                return oVarZ;
                            }
                            f.z.d.j.n();
                            throw null;
                        }
                        if (oVarZ == null) {
                            f.z.d.j.n();
                            throw null;
                        }
                        objTryResumeReceive = oVarZ.tryResumeReceive(e2, null);
                    }
                } while (objTryResumeReceive == null);
                this.size = i2;
                f.s sVar = f.s.a;
                if (oVarZ == null) {
                    f.z.d.j.n();
                    throw null;
                }
                oVarZ.completeResumeReceive(objTryResumeReceive);
                if (oVarZ != null) {
                    return oVarZ.getOfferResult();
                }
                f.z.d.j.n();
                throw null;
            }
            Z(i2);
            Object[] objArr = this.f1596e;
            objArr[(this.f1597f + i2) % objArr.length] = e2;
            return b.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // g.a.l2.c
    public Object u(E e2, g.a.q2.d<?> dVar) {
        f.z.d.j.f(dVar, "select");
        ReentrantLock reentrantLock = this.f1595d;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            h<?> hVarL = l();
            if (hVarL != null) {
                return hVarL;
            }
            if (i2 >= this.f1598g) {
                return b.b;
            }
            this.size = i2 + 1;
            if (i2 == 0) {
                c.e<E> eVarH = h(e2);
                Object objPerformAtomicTrySelect = dVar.performAtomicTrySelect(eVarH);
                if (objPerformAtomicTrySelect == null) {
                    this.size = i2;
                    o<? super E> oVarB = eVarH.b();
                    Object obj = eVarH.a;
                    if (k0.a()) {
                        if (!(obj != null)) {
                            throw new AssertionError();
                        }
                    }
                    f.s sVar = f.s.a;
                    if (oVarB == null) {
                        f.z.d.j.n();
                        throw null;
                    }
                    if (obj == null) {
                        f.z.d.j.n();
                        throw null;
                    }
                    oVarB.completeResumeReceive(obj);
                    if (oVarB != null) {
                        return oVarB.getOfferResult();
                    }
                    f.z.d.j.n();
                    throw null;
                }
                if (objPerformAtomicTrySelect != b.b) {
                    if (objPerformAtomicTrySelect != g.a.q2.e.a() && !(objPerformAtomicTrySelect instanceof h)) {
                        throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + objPerformAtomicTrySelect).toString());
                    }
                    this.size = i2;
                    return objPerformAtomicTrySelect;
                }
            }
            if (!dVar.trySelect(null)) {
                this.size = i2;
                return g.a.q2.e.a();
            }
            Z(i2);
            Object[] objArr = this.f1596e;
            objArr[(this.f1597f + i2) % objArr.length] = e2;
            return b.a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
