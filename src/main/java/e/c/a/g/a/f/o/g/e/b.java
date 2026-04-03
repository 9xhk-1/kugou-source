package e.c.a.g.a.f.o.g.e;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public final Object a = new Object();
    public boolean b;
    public boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<a> f733e;

    public boolean a(a aVar, long j) {
        a aVar2;
        if (aVar.f729e == null) {
            throw new IllegalArgumentException("Instruction must have a target.");
        }
        if (aVar.a()) {
            throw new IllegalStateException(aVar + " This instruction is already in use.");
        }
        synchronized (this) {
            aVar.b();
            aVar.f728d = j;
            a aVar3 = this.f732d;
            boolean z = false;
            if (aVar3 == null || j == 0 || j < aVar3.f728d) {
                aVar.f731g = aVar3;
                this.f732d = aVar;
                z = this.b;
            } else {
                while (true) {
                    aVar2 = aVar3.f731g;
                    if (aVar2 == null || j < aVar2.f728d) {
                        break;
                    }
                    aVar3 = aVar2;
                }
                aVar.f731g = aVar2;
                aVar3.f731g = aVar;
            }
            if (z) {
                h();
            }
        }
        return true;
    }

    public final void b(a aVar) {
        aVar.f729e.c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        r7.f732d = r3.f731g;
        r3.f731g = null;
        r3.b();
        r7.b = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        if (f(r3) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        if (r7.f733e != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        r7.f733e = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
    
        r7.f733e.add(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public e.c.a.g.a.f.o.g.e.a c() {
        /*
            r7 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            r7.g(r1)
            monitor-enter(r7)
            java.util.List<e.c.a.g.a.f.o.g.e.a> r1 = r7.f733e     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto L2f
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L76
            if (r1 <= 0) goto L2f
            java.util.List<e.c.a.g.a.f.o.g.e.a> r1 = r7.f733e     // Catch: java.lang.Throwable -> L76
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L76
        L16:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L76
            if (r2 == 0) goto L2f
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L76
            e.c.a.g.a.f.o.g.e.a r2 = (e.c.a.g.a.f.o.g.e.a) r2     // Catch: java.lang.Throwable -> L76
            boolean r3 = r7.f(r2)     // Catch: java.lang.Throwable -> L76
            if (r3 == 0) goto L16
            r1.remove()     // Catch: java.lang.Throwable -> L76
            r7.b = r0     // Catch: java.lang.Throwable -> L76
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            return r2
        L2f:
            long r1 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L76
            e.c.a.g.a.f.o.g.e.a r3 = r7.f732d     // Catch: java.lang.Throwable -> L76
            if (r3 == 0) goto L70
            long r4 = r3.f728d     // Catch: java.lang.Throwable -> L76
            long r4 = r4 - r1
            r1 = 0
            int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r6 <= 0) goto L4a
            r1 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r1 = java.lang.Math.min(r4, r1)     // Catch: java.lang.Throwable -> L76
            int r2 = (int) r1     // Catch: java.lang.Throwable -> L76
            r1 = r2
            goto L71
        L4a:
            e.c.a.g.a.f.o.g.e.a r1 = r3.f731g     // Catch: java.lang.Throwable -> L76
            r7.f732d = r1     // Catch: java.lang.Throwable -> L76
            r1 = 0
            r3.f731g = r1     // Catch: java.lang.Throwable -> L76
            r3.b()     // Catch: java.lang.Throwable -> L76
            r7.b = r0     // Catch: java.lang.Throwable -> L76
            boolean r1 = r7.f(r3)     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto L5e
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            return r3
        L5e:
            java.util.List<e.c.a.g.a.f.o.g.e.a> r1 = r7.f733e     // Catch: java.lang.Throwable -> L76
            if (r1 != 0) goto L69
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L76
            r1.<init>()     // Catch: java.lang.Throwable -> L76
            r7.f733e = r1     // Catch: java.lang.Throwable -> L76
        L69:
            java.util.List<e.c.a.g.a.f.o.g.e.a> r1 = r7.f733e     // Catch: java.lang.Throwable -> L76
            r1.add(r3)     // Catch: java.lang.Throwable -> L76
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            goto L1
        L70:
            r1 = -1
        L71:
            r2 = 1
            r7.b = r2     // Catch: java.lang.Throwable -> L76
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            goto L2
        L76:
            r0 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            goto L7a
        L79:
            throw r0
        L7a:
            goto L79
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.f.o.g.e.b.c():e.c.a.g.a.f.o.g.e.a");
    }

    public void d(a aVar) {
        List<a> list;
        synchronized (this) {
            b(aVar);
            aVar.e();
            if (this.b && (list = this.f733e) != null && list.size() > 0) {
                h();
            }
        }
    }

    public void e(d dVar, int i2, Object obj) {
        if (dVar == null) {
            return;
        }
        synchronized (this) {
            a aVar = this.f732d;
            while (aVar != null && aVar.f729e == dVar && aVar.a == i2 && (obj == null || aVar.b == obj)) {
                a aVar2 = aVar.f731g;
                this.f732d = aVar2;
                aVar.e();
                aVar = aVar2;
            }
            while (aVar != null) {
                a aVar3 = aVar.f731g;
                if (aVar3 != null && aVar3.f729e == dVar && aVar3.a == i2 && (obj == null || aVar3.b == obj)) {
                    a aVar4 = aVar3.f731g;
                    aVar3.e();
                    aVar.f731g = aVar4;
                } else {
                    aVar = aVar3;
                }
            }
            List<a> list = this.f733e;
            if (list != null && list.size() > 0) {
                Iterator<a> it = this.f733e.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.f729e == dVar && next.a == i2 && (obj == null || next.b == obj)) {
                        next.e();
                        it.remove();
                    }
                }
            }
        }
    }

    public final boolean f(a aVar) {
        return aVar.f729e.k();
    }

    public final void g(int i2) {
        if (i2 == 0) {
            return;
        }
        synchronized (this.a) {
            try {
                if (!this.c) {
                    if (i2 < 0) {
                        this.a.wait();
                    } else {
                        this.a.wait(i2);
                    }
                }
                this.c = false;
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void h() {
        synchronized (this.a) {
            this.c = true;
            this.a.notify();
        }
    }
}
