package g.a.n2;

import g.a.k0;
import g.a.n2.y;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public class x<T extends y & Comparable<? super T>> {
    private volatile int _size = 0;
    public T[] a;

    static {
        AtomicIntegerFieldUpdater.newUpdater(x.class, "_size");
    }

    public final void a(T t) {
        f.z.d.j.f(t, "node");
        if (k0.a()) {
            if (!(t.getHeap() == null)) {
                throw new AssertionError();
            }
        }
        t.setHeap(this);
        y[] yVarArrF = f();
        int iC = c();
        j(iC + 1);
        yVarArrF[iC] = t;
        t.setIndex(iC);
        l(iC);
    }

    public final T b() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        return c() == 0;
    }

    public final T e() {
        T t;
        synchronized (this) {
            t = (T) b();
        }
        return t;
    }

    public final T[] f() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new y[4];
            this.a = tArr2;
            return tArr2;
        }
        if (c() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, c() * 2);
        f.z.d.j.b(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((y[]) objArrCopyOf);
        this.a = tArr3;
        return tArr3;
    }

    public final boolean g(T t) {
        boolean z;
        f.z.d.j.f(t, "node");
        synchronized (this) {
            z = true;
            if (t.getHeap() == null) {
                z = false;
            } else {
                int index = t.getIndex();
                if (k0.a()) {
                    if (!(index >= 0)) {
                        throw new AssertionError();
                    }
                }
                h(index);
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T h(int r9) {
        /*
            r8 = this;
            boolean r0 = g.a.k0.a()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1a
            int r0 = r8.c()
            if (r0 <= 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L14
            goto L1a
        L14:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L1a:
            T extends g.a.n2.y & java.lang.Comparable<? super T>[] r0 = r8.a
            r3 = 0
            if (r0 == 0) goto L8c
            int r4 = r8.c()
            r5 = -1
            int r4 = r4 + r5
            r8.j(r4)
            int r4 = r8.c()
            if (r9 >= r4) goto L5d
            int r4 = r8.c()
            r8.m(r9, r4)
            int r4 = r9 + (-1)
            int r4 = r4 / 2
            if (r9 <= 0) goto L5a
            r6 = r0[r9]
            if (r6 == 0) goto L56
            java.lang.Comparable r6 = (java.lang.Comparable) r6
            r7 = r0[r4]
            if (r7 == 0) goto L52
            int r6 = r6.compareTo(r7)
            if (r6 >= 0) goto L5a
            r8.m(r9, r4)
            r8.l(r4)
            goto L5d
        L52:
            f.z.d.j.n()
            throw r3
        L56:
            f.z.d.j.n()
            throw r3
        L5a:
            r8.k(r9)
        L5d:
            int r9 = r8.c()
            r9 = r0[r9]
            if (r9 == 0) goto L88
            boolean r4 = g.a.k0.a()
            if (r4 == 0) goto L7b
            g.a.n2.x r4 = r9.getHeap()
            if (r4 != r8) goto L72
            r1 = 1
        L72:
            if (r1 == 0) goto L75
            goto L7b
        L75:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L7b:
            r9.setHeap(r3)
            r9.setIndex(r5)
            int r1 = r8.c()
            r0[r1] = r3
            return r9
        L88:
            f.z.d.j.n()
            throw r3
        L8c:
            f.z.d.j.n()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.n2.x.h(int):g.a.n2.y");
    }

    public final T i() {
        T t;
        synchronized (this) {
            t = c() > 0 ? (T) h(0) : null;
        }
        return t;
    }

    public final void j(int i2) {
        this._size = i2;
    }

    public final void k(int i2) {
        while (true) {
            int i3 = (i2 * 2) + 1;
            if (i3 >= c()) {
                return;
            }
            T[] tArr = this.a;
            if (tArr == null) {
                f.z.d.j.n();
                throw null;
            }
            int i4 = i3 + 1;
            if (i4 < c()) {
                T t = tArr[i4];
                if (t == null) {
                    f.z.d.j.n();
                    throw null;
                }
                Comparable comparable = (Comparable) t;
                T t2 = tArr[i3];
                if (t2 == null) {
                    f.z.d.j.n();
                    throw null;
                }
                if (comparable.compareTo(t2) < 0) {
                    i3 = i4;
                }
            }
            T t3 = tArr[i2];
            if (t3 == null) {
                f.z.d.j.n();
                throw null;
            }
            Comparable comparable2 = (Comparable) t3;
            T t4 = tArr[i3];
            if (t4 == null) {
                f.z.d.j.n();
                throw null;
            }
            if (comparable2.compareTo(t4) <= 0) {
                return;
            }
            m(i2, i3);
            i2 = i3;
        }
    }

    public final void l(int i2) {
        while (i2 > 0) {
            T[] tArr = this.a;
            if (tArr == null) {
                f.z.d.j.n();
                throw null;
            }
            int i3 = (i2 - 1) / 2;
            T t = tArr[i3];
            if (t == null) {
                f.z.d.j.n();
                throw null;
            }
            Comparable comparable = (Comparable) t;
            T t2 = tArr[i2];
            if (t2 == null) {
                f.z.d.j.n();
                throw null;
            }
            if (comparable.compareTo(t2) <= 0) {
                return;
            }
            m(i2, i3);
            i2 = i3;
        }
    }

    public final void m(int i2, int i3) {
        T[] tArr = this.a;
        if (tArr == null) {
            f.z.d.j.n();
            throw null;
        }
        T t = tArr[i3];
        if (t == null) {
            f.z.d.j.n();
            throw null;
        }
        T t2 = tArr[i2];
        if (t2 == null) {
            f.z.d.j.n();
            throw null;
        }
        tArr[i2] = t;
        tArr[i3] = t2;
        t.setIndex(i2);
        t2.setIndex(i3);
    }
}
