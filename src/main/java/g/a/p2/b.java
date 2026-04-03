package g.a.p2;

import androidx.appcompat.widget.ActivityChooserView;
import com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler;
import f.s;
import g.a.g2;
import g.a.h2;
import g.a.k0;
import g.a.l0;
import g.a.n2.q;
import g.a.n2.t;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Executor, Closeable {
    public static final AtomicLongFieldUpdater l;
    public static final AtomicLongFieldUpdater m;
    public static final AtomicIntegerFieldUpdater n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final q s;
    private volatile int _isTerminated;
    public final e a;
    public final Semaphore b;
    public volatile long controlState;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a[] f1623d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Random f1624f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1625h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f1626i;
    public final long j;
    public final String k;
    private volatile long parkedWorkersStack;

    /* JADX INFO: renamed from: g.a.p2.b$b, reason: collision with other inner class name */
    public enum EnumC0276b {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        RETIRING,
        TERMINATED
    }

    static {
        int iD = t.d("kotlinx.coroutines.scheduler.spins", 1000, 1, 0, 8, null);
        o = iD;
        p = iD + t.d("kotlinx.coroutines.scheduler.yields", 0, 0, 0, 8, null);
        int nanos = (int) TimeUnit.SECONDS.toNanos(1L);
        q = nanos;
        r = (int) f.b0.f.f(f.b0.f.c(m.a / ((long) 4), 10L), nanos);
        s = new q("NOT_IN_STACK");
        l = AtomicLongFieldUpdater.newUpdater(b.class, "parkedWorkersStack");
        m = AtomicLongFieldUpdater.newUpdater(b.class, "controlState");
        n = AtomicIntegerFieldUpdater.newUpdater(b.class, "_isTerminated");
    }

    public b(int i2, int i3, long j, String str) {
        f.z.d.j.f(str, "schedulerName");
        this.f1625h = i2;
        this.f1626i = i3;
        this.j = j;
        this.k = str;
        if (!(i2 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (!(i3 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.a = new e();
        this.b = new Semaphore(i2, false);
        this.parkedWorkersStack = 0L;
        this.f1623d = new a[i3 + 1];
        this.controlState = 0L;
        this.f1624f = new Random();
        this._isTerminated = 0;
    }

    public static /* synthetic */ void w(b bVar, Runnable runnable, j jVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            jVar = h.b;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        bVar.v(runnable, jVar, z);
    }

    public final void A(a aVar) {
        long j;
        long j2;
        int i2;
        if (aVar.k() != s) {
            return;
        }
        do {
            j = this.parkedWorkersStack;
            int i3 = (int) (2097151 & j);
            j2 = (2097152 + j) & (-2097152);
            i2 = aVar.i();
            if (k0.a()) {
                if (!(i2 != 0)) {
                    throw new AssertionError();
                }
            }
            aVar.t(this.f1623d[i3]);
        } while (!l.compareAndSet(this, j, ((long) i2) | j2));
    }

    public final void B(a aVar, int i2, int i3) {
        while (true) {
            long j = this.parkedWorkersStack;
            int iY = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (iY == i2) {
                iY = i3 == 0 ? y(aVar) : i3;
            }
            if (iY >= 0 && l.compareAndSet(this, j, j2 | ((long) iY))) {
                return;
            }
        }
    }

    public final void C() {
        if (this.b.availablePermits() == 0) {
            G();
            return;
        }
        if (G()) {
            return;
        }
        long j = this.controlState;
        if (((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)) < this.f1625h) {
            int iS = s();
            if (iS == 1 && this.f1625h > 1) {
                s();
            }
            if (iS > 0) {
                return;
            }
        }
        G();
    }

    public final void D(i iVar) {
        try {
            iVar.run();
        } catch (Throwable th) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                f.z.d.j.b(threadCurrentThread, "thread");
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                g2 g2VarA = h2.a();
                if (g2VarA == null) {
                }
            } finally {
                g2 g2VarA2 = h2.a();
                if (g2VarA2 != null) {
                    g2VarA2.unTrackTask();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void E(long r9) throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = g.a.p2.b.n
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            g.a.p2.b$a r0 = r8.u()
            g.a.p2.b$a[] r3 = r8.f1623d
            monitor-enter(r3)
            long r4 = r8.controlState     // Catch: java.lang.Throwable -> La3
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r5 = (int) r4
            monitor-exit(r3)
            if (r2 > r5) goto L5f
            r3 = 1
        L1d:
            g.a.p2.b$a[] r4 = r8.f1623d
            r4 = r4[r3]
            if (r4 == 0) goto L5a
            if (r4 == r0) goto L55
        L25:
            boolean r6 = r4.isAlive()
            if (r6 == 0) goto L32
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r9)
            goto L25
        L32:
            g.a.p2.b$b r6 = r4.m()
            boolean r7 = g.a.k0.a()
            if (r7 == 0) goto L4c
            g.a.p2.b$b r7 = g.a.p2.b.EnumC0276b.TERMINATED
            if (r6 != r7) goto L42
            r6 = 1
            goto L43
        L42:
            r6 = 0
        L43:
            if (r6 == 0) goto L46
            goto L4c
        L46:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L4c:
            g.a.p2.o r4 = r4.j()
            g.a.p2.e r6 = r8.a
            r4.f(r6)
        L55:
            if (r3 == r5) goto L5f
            int r3 = r3 + 1
            goto L1d
        L5a:
            f.z.d.j.n()
            r9 = 0
            throw r9
        L5f:
            g.a.p2.e r9 = r8.a
            r9.b()
        L64:
            if (r0 == 0) goto L6d
            g.a.p2.i r9 = r0.g()
            if (r9 == 0) goto L6d
            goto L75
        L6d:
            g.a.p2.e r9 = r8.a
            java.lang.Object r9 = r9.d()
            g.a.p2.i r9 = (g.a.p2.i) r9
        L75:
            if (r9 == 0) goto L7b
            r8.D(r9)
            goto L64
        L7b:
            if (r0 == 0) goto L82
            g.a.p2.b$b r9 = g.a.p2.b.EnumC0276b.TERMINATED
            r0.w(r9)
        L82:
            boolean r9 = g.a.k0.a()
            if (r9 == 0) goto L9c
            java.util.concurrent.Semaphore r9 = r8.b
            int r9 = r9.availablePermits()
            int r10 = r8.f1625h
            if (r9 != r10) goto L93
            r1 = 1
        L93:
            if (r1 == 0) goto L96
            goto L9c
        L96:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L9c:
            r9 = 0
            r8.parkedWorkersStack = r9
            r8.controlState = r9
            return
        La3:
            r9 = move-exception
            monitor-exit(r3)
            goto La7
        La6:
            throw r9
        La7:
            goto La6
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.p2.b.E(long):void");
    }

    public final int F(i iVar, boolean z) {
        a aVarU = u();
        if (aVarU == null || aVarU.m() == EnumC0276b.TERMINATED) {
            return 1;
        }
        int i2 = -1;
        if (iVar.a() == l.NON_BLOCKING) {
            if (aVarU.p()) {
                i2 = 0;
            } else if (!aVarU.u()) {
                return 1;
            }
        }
        if (!(z ? aVarU.j().c(iVar, this.a) : aVarU.j().b(iVar, this.a)) || aVarU.j().e() > m.b) {
            return 0;
        }
        return i2;
    }

    public final boolean G() {
        while (true) {
            a aVarZ = z();
            if (aVarZ == null) {
                return false;
            }
            aVarZ.o();
            boolean zQ = aVarZ.q();
            LockSupport.unpark(aVarZ);
            if (zQ && aVarZ.v()) {
                return true;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        E(NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_EXPIRED_TIME);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        f.z.d.j.f(runnable, "command");
        w(this, runnable, null, false, 6, null);
    }

    public final boolean isTerminated() {
        return this._isTerminated != 0;
    }

    public final int s() {
        synchronized (this.f1623d) {
            if (isTerminated()) {
                return -1;
            }
            long j = this.controlState;
            int i2 = (int) (j & 2097151);
            int i3 = i2 - ((int) ((j & 4398044413952L) >> 21));
            if (i3 >= this.f1625h) {
                return 0;
            }
            if (i2 < this.f1626i && this.b.availablePermits() != 0) {
                int i4 = ((int) (this.controlState & 2097151)) + 1;
                if (!(i4 > 0 && this.f1623d[i4] == null)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                a aVar = new a(this, i4);
                aVar.start();
                if (!(i4 == ((int) (2097151 & m.incrementAndGet(this))))) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                this.f1623d[i4] = aVar;
                return i3 + 1;
            }
            return 0;
        }
    }

    public final i t(Runnable runnable, j jVar) {
        f.z.d.j.f(runnable, "block");
        f.z.d.j.f(jVar, "taskContext");
        long jA = m.f1646f.a();
        if (!(runnable instanceof i)) {
            return new k(runnable, jA, jVar);
        }
        i iVar = (i) runnable;
        iVar.a = jA;
        iVar.b = jVar;
        return iVar;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (a aVar : this.f1623d) {
            if (aVar != null) {
                int i7 = aVar.j().i();
                int i8 = g.a.p2.a.a[aVar.m().ordinal()];
                if (i8 == 1) {
                    i4++;
                } else if (i8 == 2) {
                    i3++;
                    arrayList.add(String.valueOf(i7) + "b");
                } else if (i8 == 3) {
                    i2++;
                    arrayList.add(String.valueOf(i7) + "c");
                } else if (i8 == 4) {
                    i5++;
                    if (i7 > 0) {
                        arrayList.add(String.valueOf(i7) + "r");
                    }
                } else if (i8 == 5) {
                    i6++;
                }
            }
        }
        long j = this.controlState;
        return this.k + '@' + l0.b(this) + "[Pool Size {core = " + this.f1625h + ", max = " + this.f1626i + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", retired = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global queue size = " + this.a.c() + ", Control State Workers {created = " + ((int) (2097151 & j)) + ", blocking = " + ((int) ((j & 4398044413952L) >> 21)) + "}]";
    }

    public final a u() {
        Thread threadCurrentThread = Thread.currentThread();
        if (!(threadCurrentThread instanceof a)) {
            threadCurrentThread = null;
        }
        a aVar = (a) threadCurrentThread;
        if (aVar == null || !f.z.d.j.a(aVar.l(), this)) {
            return null;
        }
        return aVar;
    }

    public final void v(Runnable runnable, j jVar, boolean z) {
        f.z.d.j.f(runnable, "block");
        f.z.d.j.f(jVar, "taskContext");
        g2 g2VarA = h2.a();
        if (g2VarA != null) {
            g2VarA.trackTask();
        }
        i iVarT = t(runnable, jVar);
        int iF = F(iVarT, z);
        if (iF != -1) {
            if (iF != 1) {
                C();
            } else {
                if (this.a.a(iVarT)) {
                    C();
                    return;
                }
                throw new RejectedExecutionException(this.k + " was terminated");
            }
        }
    }

    public final int x() {
        return (int) (this.controlState & 2097151);
    }

    public final int y(a aVar) {
        Object objK = aVar.k();
        while (objK != s) {
            if (objK == null) {
                return 0;
            }
            a aVar2 = (a) objK;
            int i2 = aVar2.i();
            if (i2 != 0) {
                return i2;
            }
            objK = aVar2.k();
        }
        return -1;
    }

    public final a z() {
        while (true) {
            long j = this.parkedWorkersStack;
            a aVar = this.f1623d[(int) (2097151 & j)];
            if (aVar == null) {
                return null;
            }
            long j2 = (2097152 + j) & (-2097152);
            int iY = y(aVar);
            if (iY >= 0 && l.compareAndSet(this, j, ((long) iY) | j2)) {
                aVar.t(s);
                return aVar;
            }
        }
    }

    public final class a extends Thread {
        public static final AtomicIntegerFieldUpdater k = AtomicIntegerFieldUpdater.newUpdater(a.class, "terminationState");
        public final o a;
        public long b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f1627d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1628f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1629h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1630i;
        public volatile int indexInArray;
        public volatile Object nextParkedWorker;
        public volatile int spins;
        public volatile EnumC0276b state;
        private volatile int terminationState;

        public a() {
            setDaemon(true);
            this.a = new o();
            this.state = EnumC0276b.RETIRING;
            this.terminationState = 0;
            this.nextParkedWorker = b.s;
            this.f1628f = b.r;
            this.f1629h = b.this.f1624f.nextInt();
        }

        public final void a(l lVar) {
            if (lVar != l.NON_BLOCKING) {
                b.m.addAndGet(b.this, -2097152L);
                EnumC0276b enumC0276b = this.state;
                if (enumC0276b != EnumC0276b.TERMINATED) {
                    if (k0.a()) {
                        if (!(enumC0276b == EnumC0276b.BLOCKING)) {
                            throw new AssertionError();
                        }
                    }
                    this.state = EnumC0276b.RETIRING;
                }
            }
        }

        public final void b(l lVar, long j) {
            if (lVar != l.NON_BLOCKING) {
                b.m.addAndGet(b.this, 2097152L);
                if (w(EnumC0276b.BLOCKING)) {
                    b.this.C();
                    return;
                }
                return;
            }
            if (b.this.b.availablePermits() == 0) {
                return;
            }
            long jA = m.f1646f.a();
            long j2 = jA - j;
            long j3 = m.a;
            if (j2 < j3 || jA - this.f1627d < j3 * ((long) 5)) {
                return;
            }
            this.f1627d = jA;
            b.this.C();
        }

        public final boolean c() {
            i iVarE = b.this.a.e(l.PROBABLY_BLOCKING);
            if (iVarE == null) {
                return true;
            }
            this.a.b(iVarE, b.this.a);
            return false;
        }

        public final void d() {
            w(EnumC0276b.PARKING);
            if (c()) {
                this.terminationState = 0;
                if (this.b == 0) {
                    this.b = System.nanoTime() + b.this.j;
                }
                if (f(b.this.j) && System.nanoTime() - this.b >= 0) {
                    this.b = 0L;
                    y();
                }
            }
        }

        public final void e() {
            int i2 = this.spins;
            if (i2 <= b.p) {
                this.spins = i2 + 1;
                if (i2 >= b.o) {
                    Thread.yield();
                    return;
                }
                return;
            }
            if (this.f1628f < b.q) {
                this.f1628f = f.b0.f.e((this.f1628f * 3) >>> 1, b.q);
            }
            w(EnumC0276b.PARKING);
            f(this.f1628f);
        }

        public final boolean f(long j) {
            b.this.A(this);
            if (!c()) {
                return false;
            }
            LockSupport.parkNanos(j);
            return true;
        }

        public final i g() {
            if (u()) {
                return h();
            }
            i iVarH = this.a.h();
            return iVarH != null ? iVarH : b.this.a.e(l.PROBABLY_BLOCKING);
        }

        public final i h() {
            i iVarD;
            i iVarE;
            boolean z = r(b.this.f1625h * 2) == 0;
            if (z && (iVarE = b.this.a.e(l.NON_BLOCKING)) != null) {
                return iVarE;
            }
            i iVarH = this.a.h();
            return iVarH != null ? iVarH : (z || (iVarD = b.this.a.d()) == null) ? x() : iVarD;
        }

        public final int i() {
            return this.indexInArray;
        }

        public final o j() {
            return this.a;
        }

        public final Object k() {
            return this.nextParkedWorker;
        }

        public final b l() {
            return b.this;
        }

        public final EnumC0276b m() {
            return this.state;
        }

        public final void n(l lVar) {
            this.b = 0L;
            this.f1630i = 0;
            if (this.state == EnumC0276b.PARKING) {
                if (k0.a()) {
                    if (!(lVar == l.PROBABLY_BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.state = EnumC0276b.BLOCKING;
                this.f1628f = b.r;
            }
            this.spins = 0;
        }

        public final void o() {
            this.f1628f = b.r;
            this.spins = 0;
        }

        public final boolean p() {
            return this.state == EnumC0276b.BLOCKING;
        }

        public final boolean q() {
            return this.state == EnumC0276b.PARKING;
        }

        public final int r(int i2) {
            int i3 = this.f1629h;
            int i4 = i3 ^ (i3 << 13);
            this.f1629h = i4;
            int i5 = i4 ^ (i4 >> 17);
            this.f1629h = i5;
            int i6 = i5 ^ (i5 << 5);
            this.f1629h = i6;
            int i7 = i2 - 1;
            return (i7 & i2) == 0 ? i6 & i7 : (i6 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) % i2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean z = false;
            while (!b.this.isTerminated() && this.state != EnumC0276b.TERMINATED) {
                i iVarG = g();
                if (iVarG == null) {
                    if (this.state == EnumC0276b.CPU_ACQUIRED) {
                        e();
                    } else {
                        d();
                    }
                    z = true;
                } else {
                    l lVarA = iVarG.a();
                    if (z) {
                        n(lVarA);
                        z = false;
                    }
                    b(lVarA, iVarG.a);
                    b.this.D(iVarG);
                    a(lVarA);
                }
            }
            w(EnumC0276b.TERMINATED);
        }

        public final void s(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(b.this.k);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void t(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean u() {
            EnumC0276b enumC0276b = this.state;
            EnumC0276b enumC0276b2 = EnumC0276b.CPU_ACQUIRED;
            if (enumC0276b == enumC0276b2) {
                return true;
            }
            if (!b.this.b.tryAcquire()) {
                return false;
            }
            this.state = enumC0276b2;
            return true;
        }

        public final boolean v() {
            int i2 = this.terminationState;
            if (i2 == 1 || i2 == -1) {
                return false;
            }
            if (i2 == 0) {
                return k.compareAndSet(this, 0, -1);
            }
            throw new IllegalStateException(("Invalid terminationState = " + i2).toString());
        }

        public final boolean w(EnumC0276b enumC0276b) {
            f.z.d.j.f(enumC0276b, "newState");
            EnumC0276b enumC0276b2 = this.state;
            boolean z = enumC0276b2 == EnumC0276b.CPU_ACQUIRED;
            if (z) {
                b.this.b.release();
            }
            if (enumC0276b2 != enumC0276b) {
                this.state = enumC0276b;
            }
            return z;
        }

        public final i x() {
            int iX = b.this.x();
            if (iX < 2) {
                return null;
            }
            int iR = this.f1630i;
            if (iR == 0) {
                iR = r(iX);
            }
            int i2 = iR + 1;
            int i3 = i2 <= iX ? i2 : 1;
            this.f1630i = i3;
            a aVar = b.this.f1623d[i3];
            if (aVar == null || aVar == this || !this.a.k(aVar.a, b.this.a)) {
                return null;
            }
            return this.a.h();
        }

        public final void y() {
            synchronized (b.this.f1623d) {
                if (b.this.isTerminated()) {
                    return;
                }
                if (b.this.x() <= b.this.f1625h) {
                    return;
                }
                if (c()) {
                    if (k.compareAndSet(this, 0, 1)) {
                        int i2 = this.indexInArray;
                        s(0);
                        b.this.B(this, i2, 0);
                        int andDecrement = (int) (b.m.getAndDecrement(b.this) & 2097151);
                        if (andDecrement != i2) {
                            a aVar = b.this.f1623d[andDecrement];
                            if (aVar == null) {
                                f.z.d.j.n();
                                throw null;
                            }
                            b.this.f1623d[i2] = aVar;
                            aVar.s(i2);
                            b.this.B(aVar, andDecrement, i2);
                        }
                        b.this.f1623d[andDecrement] = null;
                        s sVar = s.a;
                        this.state = EnumC0276b.TERMINATED;
                    }
                }
            }
        }

        public a(b bVar, int i2) {
            this();
            s(i2);
        }
    }
}
