package g.a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 extends x0 implements Runnable {
    public static volatile Thread _thread;
    public static volatile int debugStatus;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f1604i;
    public static final m0 j;

    static {
        Long l;
        m0 m0Var = new m0();
        j = m0Var;
        w0.i(m0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        f.z.d.j.b(l, "try {\n            java.l…AULT_KEEP_ALIVE\n        }");
        f1604i = timeUnit.toNanos(l.longValue());
    }

    public final synchronized void C() {
        if (E()) {
            debugStatus = 3;
            y();
            notifyAll();
        }
    }

    public final synchronized Thread D() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean E() {
        int i2 = debugStatus;
        return i2 == 2 || i2 == 3;
    }

    public final synchronized boolean F() {
        if (E()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    @Override // g.a.y0
    public Thread o() {
        Thread thread = _thread;
        return thread != null ? thread : D();
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zW;
        f2.b.d(this);
        g2 g2VarA = h2.a();
        if (g2VarA != null) {
            g2VarA.registerTimeLoopThread();
        }
        try {
            if (!F()) {
                if (zW) {
                    return;
                } else {
                    return;
                }
            }
            long j2 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jL = l();
                if (jL == Long.MAX_VALUE) {
                    if (j2 == Long.MAX_VALUE) {
                        g2 g2VarA2 = h2.a();
                        long jNanoTime = g2VarA2 != null ? g2VarA2.nanoTime() : System.nanoTime();
                        if (j2 == Long.MAX_VALUE) {
                            j2 = f1604i + jNanoTime;
                        }
                        long j3 = j2 - jNanoTime;
                        if (j3 <= 0) {
                            _thread = null;
                            C();
                            g2 g2VarA3 = h2.a();
                            if (g2VarA3 != null) {
                                g2VarA3.unregisterTimeLoopThread();
                            }
                            if (w()) {
                                return;
                            }
                            o();
                            return;
                        }
                        jL = f.b0.f.f(jL, j3);
                    } else {
                        jL = f.b0.f.f(jL, f1604i);
                    }
                }
                if (jL > 0) {
                    if (E()) {
                        _thread = null;
                        C();
                        g2 g2VarA4 = h2.a();
                        if (g2VarA4 != null) {
                            g2VarA4.unregisterTimeLoopThread();
                        }
                        if (w()) {
                            return;
                        }
                        o();
                        return;
                    }
                    g2 g2VarA5 = h2.a();
                    if (g2VarA5 != null) {
                        g2VarA5.parkNanos(this, jL);
                    } else {
                        LockSupport.parkNanos(this, jL);
                    }
                }
            }
        } finally {
            _thread = null;
            C();
            g2 g2VarA6 = h2.a();
            if (g2VarA6 != null) {
                g2VarA6.unregisterTimeLoopThread();
            }
            if (!w()) {
                o();
            }
        }
    }
}
