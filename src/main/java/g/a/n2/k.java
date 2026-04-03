package g.a.n2;

import g.a.k0;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class k<E> {
    private volatile Object _next = null;
    public volatile /* synthetic */ long _state$internal = 0;
    public final int a;
    public /* synthetic */ AtomicReferenceArray b;
    public final int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1616d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f1615h = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q f1614g = new q("REMOVE_FROZEN");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1612e = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f1613f = AtomicLongFieldUpdater.newUpdater(k.class, "_state$internal");

    public static final class a {
        public a() {
        }

        public final int a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j, int i2) {
            return d(j, 1073741823L) | (((long) i2) << 0);
        }

        public final long c(long j, int i2) {
            return d(j, 1152921503533105152L) | (((long) i2) << 30);
        }

        public final long d(long j, long j2) {
            return j & (j2 ^ (-1));
        }

        public /* synthetic */ a(f.z.d.g gVar) {
            this();
        }
    }

    public static final class b {
        public final int a;

        public b(int i2) {
            this.a = i2;
        }
    }

    public k(int i2, boolean z) {
        this.c = i2;
        this.f1616d = z;
        int i3 = i2 - 1;
        this.a = i3;
        this.b = new AtomicReferenceArray(i2);
        if (!(i3 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i2 & i3) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int d(E r14) {
        /*
            r13 = this;
            java.lang.String r0 = "element"
            f.z.d.j.f(r14, r0)
        L5:
            long r3 = r13._state$internal
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r3
            r7 = 0
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 == 0) goto L17
            g.a.n2.k$a r14 = g.a.n2.k.f1615h
            int r14 = r14.a(r3)
            return r14
        L17:
            g.a.n2.k$a r0 = g.a.n2.k.f1615h
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            r9 = 0
            long r1 = r1 >> r9
            int r2 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r1 = 30
            long r5 = r5 >> r1
            int r10 = (int) r5
            int r11 = r13.a
            int r1 = r10 + 2
            r1 = r1 & r11
            r5 = r2 & r11
            r6 = 1
            if (r1 != r5) goto L35
            return r6
        L35:
            boolean r1 = r13.f1616d
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 != 0) goto L54
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r13.b
            r12 = r10 & r11
            java.lang.Object r1 = r1.get(r12)
            if (r1 == 0) goto L54
            int r0 = r13.c
            r1 = 1024(0x400, float:1.435E-42)
            if (r0 < r1) goto L53
            int r10 = r10 - r2
            r1 = r10 & r5
            int r0 = r0 >> 1
            if (r1 <= r0) goto L5
        L53:
            return r6
        L54:
            int r1 = r10 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = g.a.n2.k.f1613f
            long r5 = r0.c(r3, r1)
            r1 = r2
            r2 = r13
            boolean r0 = r1.compareAndSet(r2, r3, r5)
            if (r0 == 0) goto L5
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.b
            r1 = r10 & r11
            r0.set(r1, r14)
            r0 = r13
        L6d:
            long r1 = r0._state$internal
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 != 0) goto L77
            goto L82
        L77:
            g.a.n2.k r0 = r0.l()
            g.a.n2.k r0 = r0.h(r10, r14)
            if (r0 == 0) goto L82
            goto L6d
        L82:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.n2.k.d(java.lang.Object):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final k<E> e(long j) {
        k<E> kVar = new k<>(this.c * 2, this.f1616d);
        int i2 = (int) ((1073741823 & j) >> 0);
        int i3 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i4 = this.a;
            if ((i2 & i4) == (i3 & i4)) {
                kVar._state$internal = f1615h.d(j, 1152921504606846976L);
                return kVar;
            }
            Object bVar = this.b.get(i4 & i2);
            if (bVar == null) {
                bVar = new b(i2);
            }
            kVar.b.set(kVar.a & i2, bVar);
            i2++;
        }
    }

    public final k<E> f(long j) {
        while (true) {
            k<E> kVar = (k) this._next;
            if (kVar != null) {
                return kVar;
            }
            f1612e.compareAndSet(this, null, e(j));
        }
    }

    public final boolean g() {
        long j;
        do {
            j = this._state$internal;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f1613f.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final k<E> h(int i2, E e2) {
        Object obj = this.b.get(this.a & i2);
        if (!(obj instanceof b) || ((b) obj).a != i2) {
            return null;
        }
        this.b.set(i2 & this.a, e2);
        return this;
    }

    public final int i() {
        long j = this._state$internal;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0)));
    }

    public final boolean j() {
        long j = this._state$internal;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    public final long k() {
        long j;
        long j2;
        do {
            j = this._state$internal;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!f1613f.compareAndSet(this, j, j2));
        return j2;
    }

    public final k<E> l() {
        return f(k());
    }

    public final Object m() {
        Object obj;
        while (true) {
            long j = this._state$internal;
            if ((1152921504606846976L & j) != 0) {
                return f1614g;
            }
            a aVar = f1615h;
            int i2 = (int) ((1073741823 & j) >> 0);
            if ((((int) ((1152921503533105152L & j) >> 30)) & this.a) == (this.a & i2)) {
                return null;
            }
            obj = this.b.get(this.a & i2);
            if (obj == null) {
                if (this.f1616d) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i3 = (i2 + 1) & 1073741823;
                if (f1613f.compareAndSet(this, j, aVar.b(j, i3))) {
                    this.b.set(this.a & i2, null);
                    break;
                }
                if (this.f1616d) {
                    k<E> kVarN = this;
                    do {
                        kVarN = kVarN.n(i2, i3);
                    } while (kVarN != null);
                }
            }
        }
        return obj;
    }

    public final k<E> n(int i2, int i3) {
        long j;
        a aVar;
        int i4;
        do {
            j = this._state$internal;
            aVar = f1615h;
            i4 = (int) ((1073741823 & j) >> 0);
            if (k0.a()) {
                if (!(i4 == i2)) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j) != 0) {
                return l();
            }
        } while (!f1613f.compareAndSet(this, j, aVar.b(j, i3)));
        this.b.set(this.a & i4, null);
        return null;
    }
}
