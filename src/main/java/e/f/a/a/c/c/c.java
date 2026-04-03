package e.f.a.a.c.c;

import com.tencent.tmachine.trace.cpu.monitor.CpuInfoMonitor;
import com.tencent.tmachine.trace.looper.monitor.LooperMsgDispatchMonitor;
import com.tencent.tmachine.trace.provider.stacktrace.StackTraceConfig;
import com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer;
import e.f.a.a.b.f.c;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Cloneable {
    public boolean v;
    public int a = 10;
    public int b = 10;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1426d = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1427f = 10;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1428h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1429i = false;
    public boolean j = true;
    public int k = 100;
    public int l = e.f.a.a.b.c.l;
    public String m = null;
    public boolean n = false;
    public String o = null;
    public int p = e.f.a.a.b.c.r;
    public int q = e.f.a.a.b.c.m;
    public boolean r = false;
    public int s = 60;
    public int t = 50;
    public boolean u = true;
    public boolean w = false;
    public StackTraceConfig x = null;
    public boolean y = false;
    public CpuInfoMonitor.Config z = null;
    public boolean A = false;
    public LooperMsgDispatchMonitor.Config B = null;
    public boolean C = false;
    public long D = 2000;
    public long E = 2000;
    public c.i F = null;
    public boolean G = true;
    public int H = 31;
    public boolean I = true;
    public boolean J = false;
    public long K = SignalAnrTracer.CHECK_ANR_INTERVAL.longValue();

    public c() {
        this.v = false;
        this.v = b.o();
    }

    public synchronized void A(boolean z) {
        this.r = z;
    }

    public synchronized void B(int i2) {
        if (i2 < 50) {
            try {
                e.f.a.a.a.k.c.f("rqdp{The trigger count of the assert store is smaller than the default count.} [%s]", Integer.valueOf(i2));
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i2 <= 0) {
            i2 = 50;
        }
        this.t = i2;
    }

    public synchronized void C(int i2) {
        if (i2 < 60) {
            try {
                e.f.a.a.a.k.c.f("rqdp{The interval of assert check task is smaller than the default time.} [%s s]", Integer.valueOf(i2));
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i2 <= 0) {
            i2 = 60;
        }
        this.s = i2;
    }

    public void D(CpuInfoMonitor.Config config) {
        this.z = config;
    }

    public synchronized void E(boolean z) {
        this.f1429i = z;
    }

    public synchronized void F(boolean z) {
        this.v = z;
    }

    public void G(boolean z) {
        this.y = z;
    }

    public void H(boolean z) {
        this.A = z;
    }

    public void I(boolean z) {
        this.w = z;
    }

    public void J(long j) {
        if (j < 0) {
            j = 0;
        }
        this.D = j;
    }

    public void K(LooperMsgDispatchMonitor.Config config) {
        this.B = config;
    }

    public synchronized void L(int i2) {
        if (i2 > 0) {
            this.k = i2;
        }
    }

    public synchronized void M(int i2) {
        if (i2 > 0 && i2 <= 20) {
            this.a = i2;
        }
    }

    public synchronized void N(int i2) {
        if (i2 > 0) {
            this.f1426d = i2;
        }
    }

    public synchronized void O(int i2) {
        if (i2 > 0) {
            this.b = i2;
        }
    }

    public synchronized void P(boolean z) {
        this.f1428h = z;
    }

    public synchronized void Q(String str) {
        this.m = str;
    }

    public synchronized void R(boolean z) {
        this.u = z;
    }

    public void S(boolean z) {
        this.C = z;
    }

    public synchronized void T(int i2) {
        if (i2 > 0) {
            this.f1427f = i2;
        }
    }

    public synchronized void U(boolean z) {
        this.j = z;
    }

    public synchronized void V(boolean z) {
        this.n = z;
    }

    public void W(StackTraceConfig stackTraceConfig) {
        this.x = stackTraceConfig;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized c clone() throws CloneNotSupportedException {
        c cVar;
        cVar = new c();
        cVar.E(this.f1429i);
        cVar.M(this.a);
        cVar.N(this.f1426d);
        cVar.O(this.b);
        cVar.P(this.f1428h);
        cVar.T(this.f1427f);
        cVar.U(this.j);
        cVar.L(this.k);
        cVar.Q(this.m);
        cVar.A(this.r);
        cVar.C(this.s);
        cVar.B(this.t);
        return cVar;
    }

    public c.i b() {
        return this.F;
    }

    public synchronized int c() {
        return this.H;
    }

    public long d() {
        return this.K;
    }

    public synchronized boolean e() {
        return this.I;
    }

    public CpuInfoMonitor.Config f() {
        return this.z;
    }

    public synchronized int g() {
        return this.p;
    }

    public long h() {
        return this.D;
    }

    public long i() {
        return this.E;
    }

    public boolean j() {
        return this.J;
    }

    public LooperMsgDispatchMonitor.Config k() {
        return this.B;
    }

    public int l() {
        return this.l;
    }

    public synchronized int m() {
        return this.q;
    }

    public synchronized String n() {
        return this.m;
    }

    public synchronized int o() {
        return this.f1427f;
    }

    public synchronized String p() {
        return this.o;
    }

    public StackTraceConfig q() {
        return this.x;
    }

    public synchronized boolean r() {
        return this.v;
    }

    public boolean s() {
        return this.y;
    }

    public boolean t() {
        return this.A;
    }

    public synchronized String toString() {
        try {
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.k(th)) {
                return "error";
            }
            th.printStackTrace();
            return "error";
        }
        return String.format(Locale.US, "[MSNum:%d ,Wifi:%d,GPRS:%d,ODay:%d,isMerged:%b,AfQ:%b,Silent:%b,mLog:%d,tag:%s,assert:%s, interval:%s, limit:%s]", Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.f1426d), Integer.valueOf(this.f1427f), Boolean.valueOf(this.f1428h), Boolean.valueOf(this.f1429i), Boolean.valueOf(this.j), Integer.valueOf(this.k), this.m, Boolean.valueOf(this.r), Integer.valueOf(this.t), Integer.valueOf(this.s));
    }

    public boolean u() {
        return this.w;
    }

    public synchronized boolean v() {
        return this.f1428h;
    }

    public synchronized boolean w() {
        return this.u;
    }

    public boolean x() {
        return this.C;
    }

    public synchronized boolean y() {
        return this.n;
    }

    public synchronized boolean z() {
        return this.G;
    }
}
