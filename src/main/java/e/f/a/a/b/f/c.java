package e.f.a.a.b.f;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.tencent.tmachine.trace.cpu.monitor.CpuInfoMonitor;
import com.tencent.tmachine.trace.looper.data.KeyPendingMsg;
import com.tencent.tmachine.trace.looper.data.SyncBarrierMsg;
import com.tencent.tmachine.trace.looper.monitor.LooperMsgDispatchMonitor;
import com.tencent.tmachine.trace.provider.stacktrace.StackTraceConfig;
import com.tencent.tmachine.trace.provider.stacktrace.StackTraceMonitor;
import com.tme.fireeye.crash.comm.strategy.StrategyBean;
import com.tme.fireeye.crash.crashmodule.CrashDetailBean;
import com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer;
import com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler;
import e.f.a.a.a.b;
import e.f.a.a.b.f.e;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class c implements e.f.a.a.b.h.c, SignalAnrTracer.b {
    public static c H;
    public final Context c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e.f.a.a.a.h.b f1394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e.f.a.a.a.k.a f1395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e.f.a.a.b.b f1397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FileObserver f1398h;
    public e.f.a.a.b.h.b j;
    public int k;
    public SignalAnrTracer y;
    public i z;
    public AtomicInteger a = new AtomicInteger(0);
    public long b = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1399i = true;
    public boolean m = true;
    public boolean n = false;
    public boolean o = false;
    public StackTraceConfig p = null;
    public boolean q = false;
    public boolean r = false;
    public CpuInfoMonitor.Config s = null;
    public boolean t = false;
    public boolean u = false;
    public LooperMsgDispatchMonitor.Config v = null;
    public boolean w = false;
    public boolean x = true;
    public boolean A = true;
    public long B = SignalAnrTracer.CHECK_ANR_INTERVAL.longValue();
    public Handler C = new Handler(Looper.getMainLooper());
    public final Runnable D = new d();
    public final Runnable E = new e();
    public boolean F = false;
    public boolean G = false;
    public ActivityManager.ProcessErrorStateInfo l = new ActivityManager.ProcessErrorStateInfo();

    public class a extends FileObserver {

        /* JADX INFO: renamed from: e.f.a.a.b.f.c$a$a, reason: collision with other inner class name */
        public class RunnableC0247a implements Runnable {
            public final /* synthetic */ String a;

            public RunnableC0247a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.K(this.a);
            }
        }

        public a(String str, int i2) {
            super(str, i2);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i2, String str) {
            if (str == null) {
                return;
            }
            String str2 = "/data/anr/" + str;
            e.f.a.a.a.k.c.j("watching file %s", str2);
            if (str2.contains("trace")) {
                c.this.f1395e.d(new RunnableC0247a(str2));
            } else {
                e.f.a.a.a.k.c.j("not anr file %s", str2);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.R();
        }
    }

    /* JADX INFO: renamed from: e.f.a.a.b.f.c$c, reason: collision with other inner class name */
    public class RunnableC0248c implements Runnable {
        public RunnableC0248c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.N();
            c.this.L();
            c.this.M();
        }
    }

    public class d implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.N();
                c.this.L();
                c.this.M();
                c.this.R();
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.y = new SignalAnrTracer(c.this.c);
            c.this.y.setSignalAnrDetectedListener(c.this);
            c.this.y.setForwardSignalImmediately(c.this.A);
            c.this.y.setCheckAnrInterval(c.this.B);
            c.this.y.startAnrDetective(c.this.w, c.this.m ? new File(c.this.f1396f).getAbsolutePath() : "");
            c.this.f1395e.d(new a());
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.y.stopAnrDetective();
            c.this.y = null;
            c.this.r();
            c.this.p();
            c.this.q();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.R();
        }
    }

    public class g extends FileObserver {
        public g(String str, int i2) {
            super(str, i2);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i2, String str) {
            if (str == null) {
                return;
            }
            e.f.a.a.a.k.c.j("startWatchingPrivateAnrDir %s", str);
            if (!c.this.p0(str)) {
                e.f.a.a.a.k.c.b("trace file not caused by sigquit , ignore ", new Object[0]);
            } else if (c.this.j != null) {
                c.this.j.h(true);
            }
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.R();
        }
    }

    public interface i {
        void onAnr(long j, long j2, String str, e.f.a.a.b.f.b bVar);
    }

    public c(Context context, e.f.a.a.a.i.a aVar, e.f.a.a.a.h.b bVar, e.f.a.a.a.k.a aVar2, e.f.a.a.a.g.b bVar2, e.f.a.a.b.b bVar3, b.a aVar3) {
        this.c = e.f.a.a.a.k.f.d(context);
        this.f1396f = context.getDir("fireeye", 0).getAbsolutePath();
        this.f1394d = bVar;
        this.f1395e = aVar2;
        this.f1397g = bVar3;
    }

    public static synchronized c v() {
        return H;
    }

    public static c w(Context context, e.f.a.a.a.i.a aVar, e.f.a.a.a.h.b bVar, e.f.a.a.a.k.a aVar2, e.f.a.a.a.g.b bVar2, e.f.a.a.b.b bVar3, b.a aVar3) {
        if (H == null) {
            H = new c(context, aVar, bVar, aVar2, bVar2, bVar3, aVar3);
        }
        return H;
    }

    public boolean A() {
        return this.u;
    }

    public synchronized boolean B() {
        return this.f1398h != null;
    }

    public final boolean C() {
        return this.y != null;
    }

    public boolean D() {
        return this.a.get() != 0;
    }

    public boolean E() {
        return this.o;
    }

    public synchronized boolean F() {
        return this.f1399i;
    }

    public String G(long j) {
        return new File(this.f1396f, "fireeye_looper_trace_" + j + ".txt").getAbsolutePath();
    }

    public String H(long j) {
        return new File(this.f1396f, "fireeye_method_trace_" + j + ".txt").getAbsolutePath();
    }

    public final void I(long j, String str, String str2, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, e.f.a.a.b.f.b bVar, boolean z) {
        String strH;
        Map<String, String> map = new HashMap<>();
        try {
            strH = TextUtils.isEmpty(str) ? e.f.a.a.a.k.f.h(Looper.getMainLooper().getThread()) : str;
        } catch (Throwable th) {
            th = th;
            strH = str;
        }
        try {
            map = e.f.a.a.a.k.f.i(200000, false);
        } catch (Throwable th2) {
            th = th2;
            e.f.a.a.a.k.c.d(th);
            map.put("main", th.getMessage());
        }
        Q(this.c, null, str2, bVar, processErrorStateInfo, j, strH, map, z);
    }

    public synchronized void J(StrategyBean strategyBean) {
        e.f.a.a.a.k.c.j("customer decides whether to open or close.", new Object[0]);
    }

    public final void K(String str) {
        long j;
        synchronized (this) {
            if (this.a.get() != 0) {
                e.f.a.a.a.k.c.b("trace started return ", new Object[0]);
                return;
            }
            this.a.set(1);
            try {
                e.f.a.a.a.k.c.b("read trace first dump for create time!", new Object[0]);
                e.c cVarA = e.f.a.a.b.f.e.a(str, false);
                long jCurrentTimeMillis = cVarA != null ? cVarA.c : -1L;
                if (jCurrentTimeMillis == -1) {
                    e.f.a.a.a.k.c.j("trace dump fail could not get time!", new Object[0]);
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
                j = jCurrentTimeMillis;
            } finally {
                try {
                } finally {
                }
            }
            if (Math.abs(j - this.b) < NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_EXPIRED_TIME) {
                e.f.a.a.a.k.c.j("should not process ANR too Fre in %d", 10000);
            } else {
                this.b = j;
                this.a.set(1);
                try {
                    String strH = e.f.a.a.a.k.f.h(Looper.getMainLooper().getThread());
                    Map<String, String> mapI = e.f.a.a.a.k.f.i(e.f.a.a.b.c.m, false);
                    if (mapI == null || mapI.size() <= 0) {
                        e.f.a.a.a.k.c.j("can't get all thread skip this anr", new Object[0]);
                    } else {
                        ActivityManager.ProcessErrorStateInfo processErrorStateInfoQ0 = q0(this.c, 20000L);
                        this.l = processErrorStateInfoQ0;
                        if (processErrorStateInfoQ0 == null) {
                            e.f.a.a.a.k.c.b("proc state is unvisiable!", new Object[0]);
                        } else {
                            if (processErrorStateInfoQ0.pid == Process.myPid()) {
                                e.f.a.a.a.k.c.f("found visiable anr , start to process!", new Object[0]);
                                Q(this.c, str, null, null, this.l, j, strH, mapI, false);
                                return;
                            }
                            e.f.a.a.a.k.c.b("not mind proc!", this.l.processName);
                        }
                    }
                } catch (Throwable th) {
                    e.f.a.a.a.k.c.k(th);
                    e.f.a.a.a.k.c.c("get mainStack or all thread stack fail!", new Object[0]);
                }
            }
        }
    }

    public synchronized void L() {
        if (this.q && !this.r) {
            e.f.a.a.a.k.c.f("open cpu monitor", new Object[0]);
            CpuInfoMonitor.INSTANCE.startMonitor(this.s);
            this.r = true;
        }
    }

    public synchronized void M() {
        if (this.t && !this.u) {
            e.f.a.a.a.k.c.f("open looper msg trace", new Object[0]);
            LooperMsgDispatchMonitor.INSTANCE.startMonitor(this.v);
            this.u = true;
        }
    }

    public final synchronized void N() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            StackTraceMonitor.INSTANCE.prepare(this.c);
        }
        boolean z = i2 == 34 && Build.MANUFACTURER.equalsIgnoreCase("samsung");
        e.f.a.a.a.k.c.f("[openTMachineTrace] isAndroid14Samsung: " + z, new Object[0]);
        if (i2 >= 23 && this.n && !this.o && !z) {
            StackTraceMonitor stackTraceMonitor = StackTraceMonitor.INSTANCE;
            this.o = stackTraceMonitor.init(this.p);
            this.o = stackTraceMonitor.startStackTracing(Looper.getMainLooper().getThread());
            e.f.a.a.a.k.c.f("open TMachine result: " + this.o, new Object[0]);
        }
    }

    public e.f.a.a.b.f.a O(Context context, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j, String str, Map<String, String> map) {
        e.f.a.a.b.f.a aVar = new e.f.a.a.b.f.a();
        aVar.c = j;
        aVar.a = processErrorStateInfo != null ? processErrorStateInfo.processName : e.f.a.a.a.h.a.e(context, Process.myPid());
        aVar.f1388f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : "";
        aVar.f1387e = processErrorStateInfo != null ? processErrorStateInfo.longMsg : "";
        aVar.b = map;
        aVar.f1389g = str;
        if (TextUtils.isEmpty(str)) {
            aVar.f1389g = "main stack is null , some error may be encountered.";
        }
        Object[] objArr = new Object[7];
        objArr[0] = Long.valueOf(aVar.c);
        objArr[1] = aVar.f1386d;
        objArr[2] = aVar.a;
        objArr[3] = aVar.f1389g;
        objArr[4] = aVar.f1388f;
        objArr[5] = aVar.f1387e;
        Map<String, String> map2 = aVar.b;
        objArr[6] = Integer.valueOf(map2 != null ? map2.size() : 0);
        e.f.a.a.a.k.c.b("anr tm:%d\ntr:%s\nproc:%s\nmain stack:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
        return aVar;
    }

    public CrashDetailBean P(e.f.a.a.b.f.a aVar, boolean z) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.J = e.f.a.a.a.h.c.k();
            crashDetailBean.K = e.f.a.a.a.h.c.m();
            crashDetailBean.L = e.f.a.a.a.h.c.i();
            crashDetailBean.M = this.f1394d.u();
            crashDetailBean.N = this.f1394d.v();
            crashDetailBean.O = this.f1394d.w();
            if (!e.f.a.a.a.h.c.x(this.c)) {
                crashDetailBean.D = e.f.a.a.a.k.f.x(this.c, e.f.a.a.b.c.l, e.f.a.a.b.c.o);
            }
            if (z) {
                crashDetailBean.b = 9;
            } else {
                crashDetailBean.b = 3;
            }
            crashDetailBean.f275h = this.f1394d.l();
            crashDetailBean.f276i = this.f1394d.d();
            crashDetailBean.j = this.f1394d.i();
            crashDetailBean.q = this.f1394d.x();
            crashDetailBean.r = "ANR_EXCEPTION";
            crashDetailBean.s = aVar.f1388f;
            crashDetailBean.u = aVar.f1389g;
            HashMap map = new HashMap();
            crashDetailBean.X = map;
            map.put("FIREEYE_CR_01", aVar.f1387e);
            String str = crashDetailBean.u;
            int iIndexOf = str != null ? str.indexOf("\n") : -1;
            crashDetailBean.t = iIndexOf > 0 ? crashDetailBean.u.substring(0, iIndexOf) : "GET_FAIL";
            crashDetailBean.v = aVar.c;
            String str2 = crashDetailBean.u;
            if (str2 != null) {
                crashDetailBean.y = e.f.a.a.a.k.f.p(str2.getBytes());
            }
            crashDetailBean.G = aVar.b;
            crashDetailBean.H = aVar.a;
            crashDetailBean.I = "main(1)";
            crashDetailBean.P = this.f1394d.r();
            crashDetailBean.k = this.f1394d.p();
            crashDetailBean.l = this.f1394d.o();
            crashDetailBean.z = aVar.f1386d;
            e.f.a.a.a.h.b bVar = this.f1394d;
            crashDetailBean.T = bVar.H;
            crashDetailBean.U = bVar.c;
            crashDetailBean.V = bVar.B();
            if (!e.f.a.a.a.h.c.x(this.c)) {
                this.f1397g.l(crashDetailBean);
            }
            crashDetailBean.Y = this.f1394d.z();
            crashDetailBean.Z = this.f1394d.s();
            Map<String, String> mapH = this.f1394d.h();
            crashDetailBean.a0 = mapH;
            if (z) {
                if (mapH == null) {
                    crashDetailBean.a0 = new HashMap(1);
                }
                crashDetailBean.a0.put("FireEye_SignalAnrNativeBacktrace", "1");
            }
            crashDetailBean.b0 = this.f1394d.g();
            crashDetailBean.F = e.f.a.a.a.k.e.b();
        } catch (Throwable th) {
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    public boolean Q(Context context, String str, String str2, e.f.a.a.b.f.b bVar, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j, String str3, Map<String, String> map, boolean z) {
        e.f.a.a.b.f.a aVarO = O(context, processErrorStateInfo, j, str3, map);
        e.f.a.a.a.k.c.f("found visiable anr , start to upload!", new Object[0]);
        CrashDetailBean crashDetailBeanP = P(aVarO, z);
        if (crashDetailBeanP == null) {
            e.f.a.a.a.k.c.c("pack anr fail!", new Object[0]);
            return false;
        }
        e.f.a.a.a.k.c.b("anrExtraInfo = " + bVar, new Object[0]);
        if (bVar != null) {
            u(crashDetailBeanP, bVar);
            if (!TextUtils.isEmpty(bVar.f1391e)) {
                e.f.a.a.a.k.c.f("method trace file: " + bVar.f1391e, new Object[0]);
                crashDetailBeanP.A = bVar.f1391e;
            }
            if (!TextUtils.isEmpty(bVar.f1392f)) {
                e.f.a.a.a.k.c.f("cpu trace file: " + bVar.f1392f, new Object[0]);
                crashDetailBeanP.B = bVar.f1392f;
            }
            if (!TextUtils.isEmpty(bVar.f1393g)) {
                e.f.a.a.a.k.c.f("looper msg trace file: " + bVar.f1393g, new Object[0]);
                crashDetailBeanP.C = bVar.f1393g;
            }
        }
        e.f.a.a.b.c.c().h(crashDetailBeanP);
        if (crashDetailBeanP.a >= 0) {
            e.f.a.a.a.k.c.f("backup anr record success!", new Object[0]);
        } else {
            e.f.a.a.a.k.c.j("backup anr record fail!", new Object[0]);
        }
        if (str != null && new File(str).exists()) {
            aVarO.f1386d = new File(this.f1396f, "fireeye_trace_" + j + ".txt").getAbsolutePath();
            this.a.set(3);
            if (t(str, aVarO.f1386d, aVarO.a)) {
                e.f.a.a.a.k.c.f("backup trace success", new Object[0]);
            }
        } else if (TextUtils.isEmpty(str2)) {
            File fileO0 = o0();
            e.f.a.a.a.k.c.f("traceFile is %s", fileO0);
            if (fileO0 != null) {
                crashDetailBeanP.z = fileO0.getAbsolutePath();
            }
        } else {
            e.f.a.a.a.k.c.f("hookTraceFile is %s", str2);
            crashDetailBeanP.z = str2;
        }
        e.f.a.a.b.b.t("ANR", e.f.a.a.a.k.f.m(), aVarO.a, "main", aVarO.f1389g, crashDetailBeanP);
        if (!x(crashDetailBeanP)) {
            this.f1397g.A(crashDetailBeanP, 3000L, true);
        }
        this.f1397g.r(crashDetailBeanP);
        return true;
    }

    public void R() {
        int iIndexOf;
        long jO = e.f.a.a.a.k.f.o() - e.f.a.a.b.c.n;
        File file = new File(this.f1396f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    int length = fileArrListFiles.length;
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (i2 < length) {
                        File file2 = fileArrListFiles[i2];
                        String name = file2.getName();
                        boolean z = true;
                        if (name.startsWith("jni_mannual_fireeye_trace_")) {
                            i4 = 26;
                        } else if (name.startsWith("fireeye_trace_")) {
                            i4 = 14;
                        } else if (name.startsWith("fireeye_method_trace_")) {
                            i4 = 21;
                        } else if (name.startsWith("fireeye_cpu_trace_")) {
                            i4 = 18;
                        } else if (name.startsWith("fireeye_looper_trace_")) {
                            i4 = 21;
                        } else {
                            z = false;
                        }
                        StringBuilder sb = new StringBuilder();
                        File[] fileArr = fileArrListFiles;
                        sb.append("Number Trace file : ");
                        sb.append(name);
                        e.f.a.a.a.k.c.b(sb.toString(), new Object[0]);
                        if (z) {
                            try {
                                iIndexOf = name.indexOf(".txt");
                            } catch (Throwable unused) {
                                e.f.a.a.a.k.c.b("Trace file that has invalid format: " + name, new Object[0]);
                            }
                            if (iIndexOf <= 0 || Long.parseLong(name.substring(i4, iIndexOf)) < jO) {
                                if (file2.delete()) {
                                    i3++;
                                }
                            }
                        }
                        i2++;
                        fileArrListFiles = fileArr;
                    }
                    e.f.a.a.a.k.c.b("Number of overdue trace files that has deleted: " + i3, new Object[0]);
                }
            } catch (Throwable th) {
                e.f.a.a.a.k.c.k(th);
            }
        }
    }

    public void S(i iVar) {
        this.z = iVar;
    }

    public void T(long j) {
        this.B = j;
    }

    public synchronized void U(CpuInfoMonitor.Config config) {
        this.s = config;
    }

    public synchronized void V(String str) {
        this.f1396f = str;
    }

    public synchronized void W(boolean z) {
        this.m = z;
    }

    public synchronized void X(boolean z) {
        this.q = z;
    }

    public synchronized void Y(boolean z) {
        this.t = z;
    }

    public synchronized void Z(boolean z) {
        this.n = z;
    }

    public synchronized void a0(boolean z) {
        this.w = z;
    }

    public void b0(boolean z) {
        this.x = z;
    }

    public synchronized void c0(LooperMsgDispatchMonitor.Config config) {
        this.v = config;
    }

    public synchronized void d0(boolean z) {
        if (Build.VERSION.SDK_INT <= 19) {
            if (z) {
                j0();
            } else {
                m0();
            }
        } else if (z) {
            i0();
            this.f1395e.d(new RunnableC0248c());
        } else {
            l0();
            r();
            p();
            q();
        }
    }

    public final void e0(boolean z) {
        if (z) {
            if (e.f.a.a.a.k.f.r()) {
                this.D.run();
                return;
            } else {
                this.C.post(this.D);
                return;
            }
        }
        if (e.f.a.a.a.k.f.r()) {
            this.E.run();
        } else {
            this.C.post(this.E);
        }
    }

    public synchronized void f0(StackTraceConfig stackTraceConfig) {
        this.p = stackTraceConfig;
    }

    public void g0(boolean z) {
        o(z);
        boolean zF = F();
        e.f.a.a.a.k.c.f("[setUserOpend] isOpened=" + zF, new Object[0]);
        e.f.a.a.a.i.a aVarG = e.f.a.a.a.i.a.g();
        if (aVarG != null) {
            zF = zF && aVarG.h().f269d;
        }
        this.A = y();
        e.f.a.a.a.k.c.f("[setUserOpend] useNewAnrCatchLogic=" + this.x, new Object[0]);
        if (this.x) {
            if (zF != C()) {
                e.f.a.a.a.k.c.f("new anr changed to %b", Boolean.valueOf(zF));
                e0(zF);
                return;
            }
            return;
        }
        if (zF != B()) {
            e.f.a.a.a.k.c.f("anr changed to %b", Boolean.valueOf(zF));
            d0(zF);
        }
    }

    public final boolean h0() {
        e.f.a.a.b.h.b bVar = this.j;
        if (bVar != null && bVar.isAlive()) {
            return false;
        }
        e.f.a.a.b.h.b bVar2 = new e.f.a.a.b.h.b();
        this.j = bVar2;
        StringBuilder sb = new StringBuilder();
        sb.append("FireEye-ThreadMonitor");
        int i2 = this.k;
        this.k = i2 + 1;
        sb.append(i2);
        bVar2.setName(sb.toString());
        this.j.a();
        this.j.d(this);
        boolean zI = this.j.i();
        this.f1395e.d(new f());
        return zI;
    }

    public final synchronized void i0() {
        if (B()) {
            e.f.a.a.a.k.c.j("start when started!", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(this.f1396f)) {
            return;
        }
        h0();
        g gVar = new g(this.f1396f, 256);
        this.f1398h = gVar;
        try {
            gVar.startWatching();
            e.f.a.a.a.k.c.f("startWatchingPrivateAnrDir! dumFilePath is %s", this.f1396f);
            this.f1395e.d(new h());
        } catch (Throwable th) {
            this.f1398h = null;
            e.f.a.a.a.k.c.j("startWatchingPrivateAnrDir failed!", new Object[0]);
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void j0() {
        if (B()) {
            e.f.a.a.a.k.c.j("start when started!", new Object[0]);
            return;
        }
        a aVar = new a("/data/anr/", 8);
        this.f1398h = aVar;
        try {
            aVar.startWatching();
            e.f.a.a.a.k.c.f("start anr monitor!", new Object[0]);
            this.f1395e.d(new b());
        } catch (Throwable th) {
            this.f1398h = null;
            e.f.a.a.a.k.c.j("start anr monitor failed!", new Object[0]);
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
        }
    }

    public final boolean k0() {
        e.f.a.a.b.h.b bVar = this.j;
        if (bVar == null) {
            return false;
        }
        boolean zJ = bVar.j();
        this.j.f();
        this.j.g(this);
        this.j = null;
        return zJ;
    }

    public final synchronized void l0() {
        if (!B()) {
            e.f.a.a.a.k.c.j("close when closed!", new Object[0]);
            return;
        }
        k0();
        e.f.a.a.a.k.c.f("stopWatchingPrivateAnrDir", new Object[0]);
        try {
            this.f1398h.stopWatching();
            this.f1398h = null;
            e.f.a.a.a.k.c.j("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            e.f.a.a.a.k.c.j("stop anr monitor failed!", new Object[0]);
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void m0() {
        if (!B()) {
            e.f.a.a.a.k.c.j("close when closed!", new Object[0]);
            return;
        }
        try {
            this.f1398h.stopWatching();
            this.f1398h = null;
            e.f.a.a.a.k.c.j("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            e.f.a.a.a.k.c.j("stop anr monitor failed!", new Object[0]);
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
        }
    }

    public final void n(CrashDetailBean crashDetailBean) {
        if (this.F) {
            this.F = false;
            SignalAnrTracer signalAnrTracer = this.y;
            if (signalAnrTracer != null && !crashDetailBean.n) {
                e.f.a.a.a.k.c.f("[afterHandleCrashBean] call dumpSysAnrTrace", new Object[0]);
                String strDumpSysAnrTrace = signalAnrTracer.dumpSysAnrTrace();
                e.f.a.a.a.k.c.f("[afterHandleCrashBean] sysTracePath is %s", strDumpSysAnrTrace);
                if (!TextUtils.isEmpty(strDumpSysAnrTrace)) {
                    crashDetailBean.z = strDumpSysAnrTrace;
                    e.f.a.a.b.c.c().h(crashDetailBean);
                }
            }
        }
        if (this.G) {
            this.G = false;
            if (this.y != null) {
                SignalAnrTracer.nativeSendSigQuitToSignalCatcher();
            }
        }
    }

    public void n0() {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= 30) {
                return;
            }
            try {
                e.f.a.a.a.k.c.f("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i3));
                e.f.a.a.a.k.f.C(5000L);
                i2 = i3;
            } catch (Throwable th) {
                if (e.f.a.a.a.k.c.k(th)) {
                    return;
                }
                th.printStackTrace();
                return;
            }
        }
    }

    public final synchronized void o(boolean z) {
        if (this.f1399i != z) {
            e.f.a.a.a.k.c.f("user change anr %b", Boolean.valueOf(z));
            this.f1399i = z;
        }
    }

    public final File o0() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file = new File(this.f1396f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    int i2 = 26;
                    int length = fileArrListFiles.length;
                    int i3 = 0;
                    while (i3 < length) {
                        File file2 = fileArrListFiles[i3];
                        String name = file2.getName();
                        if (name.startsWith("jni_mannual_fireeye_trace_")) {
                            try {
                                int iIndexOf = name.indexOf(".txt");
                                if (iIndexOf > 0) {
                                    long j = Long.parseLong(name.substring(i2, iIndexOf));
                                    long j2 = (jCurrentTimeMillis - j) / 1000;
                                    e.f.a.a.a.k.c.b("current time %d trace time is %d s", Long.valueOf(jCurrentTimeMillis), Long.valueOf(j));
                                    e.f.a.a.a.k.c.b("current time minus trace time is %d s", Long.valueOf(j2));
                                    if (j2 < 30) {
                                        return file2;
                                    }
                                } else {
                                    continue;
                                }
                            } catch (Throwable unused) {
                                e.f.a.a.a.k.c.b("Trace file that has invalid format: " + name, new Object[0]);
                            }
                        }
                        i3++;
                        i2 = 26;
                    }
                }
                return null;
            } catch (Throwable th) {
                e.f.a.a.a.k.c.k(th);
                return null;
            }
        }
        return null;
    }

    @Override // com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.b
    public void onAnrDetected(long j, String str, String str2, String str3, long j2, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, boolean z, boolean z2, e.f.a.a.b.f.b bVar) {
        i iVar = this.z;
        if (iVar != null) {
            iVar.onAnr(j, j2, str, bVar);
        }
        this.F = z;
        this.G = z2;
        I(j, str, str2, processErrorStateInfo, bVar, false);
    }

    @Override // com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.b
    public void onNativeBacktraceDetected(long j, String str, String str2, long j2, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, e.f.a.a.b.f.b bVar) {
        i iVar = this.z;
        if (iVar != null) {
            iVar.onAnr(j, j2, str, bVar);
        }
        I(j, str, "", processErrorStateInfo, bVar, true);
    }

    @Override // e.f.a.a.b.h.c
    public boolean onThreadBlock(e.f.a.a.b.h.a aVar) {
        Map<String, String> mapI;
        HashMap map = new HashMap();
        if (aVar.b().equals(Looper.getMainLooper())) {
            String strH = null;
            try {
                strH = e.f.a.a.a.k.f.h(Looper.getMainLooper().getThread());
                mapI = e.f.a.a.a.k.f.i(200000, false);
            } catch (Throwable th) {
                e.f.a.a.a.k.c.d(th);
                map.put("main", th.getMessage());
                mapI = map;
            }
            String str = strH;
            e.f.a.a.a.k.c.b("onThreadBlock found visiable anr , start to process!", new Object[0]);
            String strN = e.f.a.a.a.h.c.n(this.c);
            if (!TextUtils.isEmpty(strN) && (strN.contains("XiaoMi") || strN.contains("samsung"))) {
                this.l = q0(this.c, 20000L);
            }
            Q(this.c, null, null, null, this.l, System.currentTimeMillis(), str, mapI, false);
        } else {
            e.f.a.a.a.k.c.b("anr handler onThreadBlock only care main thread ,current thread is: %s", aVar.c());
        }
        return true;
    }

    public synchronized void p() {
        if (this.q && this.r) {
            e.f.a.a.a.k.c.f("close cpu monitor", new Object[0]);
            CpuInfoMonitor.INSTANCE.stopMonitor();
            this.r = false;
        }
    }

    public final boolean p0(String str) {
        return str.startsWith("fireeye_trace_");
    }

    public synchronized void q() {
        if (this.t && this.u) {
            e.f.a.a.a.k.c.f("close looper msg trace", new Object[0]);
            LooperMsgDispatchMonitor.INSTANCE.stopMonitor();
            this.u = false;
        }
    }

    public ActivityManager.ProcessErrorStateInfo q0(Context context, long j) {
        if (j < 0) {
            j = 0;
        }
        try {
            e.f.a.a.a.k.c.b("to find!", new Object[0]);
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            long j2 = j / 500;
            int i2 = 0;
            while (true) {
                e.f.a.a.a.k.c.b("waiting!", new Object[0]);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2) {
                            e.f.a.a.a.k.c.b("found!", new Object[0]);
                            return processErrorStateInfo;
                        }
                    }
                }
                e.f.a.a.a.k.f.C(500L);
                int i3 = i2 + 1;
                if (i2 >= j2) {
                    e.f.a.a.a.k.c.b("end!", new Object[0]);
                    return null;
                }
                i2 = i3;
            }
        } catch (Exception e2) {
            e.f.a.a.a.k.c.d(e2);
            return null;
        } catch (OutOfMemoryError e3) {
            this.l.pid = Process.myPid();
            this.l.shortMsg = "fireeye sdk waitForAnrProcessStateChanged encount error:" + e3.getMessage();
            return this.l;
        }
    }

    public final synchronized void r() {
        if (Build.VERSION.SDK_INT >= 23 && this.n && this.o) {
            StackTraceMonitor stackTraceMonitor = StackTraceMonitor.INSTANCE;
            stackTraceMonitor.stopStackTracing(Looper.getMainLooper().getThread());
            this.o = stackTraceMonitor.destroy();
            e.f.a.a.a.k.c.f("close TMachine result: " + this.o, new Object[0]);
        }
    }

    public String s(long j) {
        return new File(this.f1396f, "fireeye_cpu_trace_" + j + ".txt").getAbsolutePath();
    }

    public boolean t(String str, String str2, String str3) throws Throwable {
        Map<String, String[]> map;
        Throwable th;
        e.c cVarC = e.f.a.a.b.f.e.c(str3, str, true);
        if (cVarC == null || (map = cVarC.f1402d) == null || map.size() <= 0) {
            e.f.a.a.a.k.c.c("not found trace dump for %s", str3);
            return false;
        }
        File file = new File(str2);
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            if (!file.exists() || !file.canWrite()) {
                e.f.a.a.a.k.c.c("backup file create fail %s", str2);
                return false;
            }
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, false));
                    try {
                        String[] strArr = cVarC.f1402d.get("main");
                        int i2 = 3;
                        if (strArr != null && strArr.length >= 3) {
                            String str4 = strArr[0];
                            String str5 = strArr[1];
                            bufferedWriter2.write("\"main\" tid=" + strArr[2] + " :\n" + str4 + "\n" + str5 + "\n\n");
                            bufferedWriter2.flush();
                        }
                        for (Map.Entry<String, String[]> entry : cVarC.f1402d.entrySet()) {
                            if (!entry.getKey().equals("main")) {
                                if (entry.getValue() != null && entry.getValue().length >= i2) {
                                    String str6 = entry.getValue()[0];
                                    String str7 = entry.getValue()[1];
                                    bufferedWriter2.write("\"" + entry.getKey() + "\" tid=" + entry.getValue()[2] + " :\n" + str6 + "\n" + str7 + "\n\n");
                                    bufferedWriter2.flush();
                                }
                                i2 = 3;
                            }
                        }
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e2) {
                            if (!e.f.a.a.a.k.c.k(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        return true;
                    } catch (IOException e3) {
                        e = e3;
                        bufferedWriter = bufferedWriter2;
                        if (!e.f.a.a.a.k.c.k(e)) {
                            e.printStackTrace();
                        }
                        e.f.a.a.a.k.c.c("dump trace fail %s", e.getClass().getName() + ":" + e.getMessage());
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e4) {
                                if (!e.f.a.a.a.k.c.k(e4)) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter == null) {
                            throw th;
                        }
                        try {
                            bufferedWriter.close();
                            throw th;
                        } catch (IOException e5) {
                            if (e.f.a.a.a.k.c.k(e5)) {
                                throw th;
                            }
                            e5.printStackTrace();
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e6) {
                e = e6;
            }
        } catch (Exception e7) {
            if (!e.f.a.a.a.k.c.k(e7)) {
                e7.printStackTrace();
            }
            e.f.a.a.a.k.c.c("backup file create error! %s  %s", e7.getClass().getName() + ":" + e7.getMessage(), str2);
            return false;
        }
    }

    public final void u(CrashDetailBean crashDetailBean, e.f.a.a.b.f.b bVar) {
        if (crashDetailBean == null || bVar == null || bVar.a == null) {
            return;
        }
        if (crashDetailBean.a0 == null) {
            crashDetailBean.a0 = new HashMap();
        }
        crashDetailBean.a0.put("F_ANR_BLOCK_TIME", String.valueOf(bVar.a));
        Integer num = bVar.b;
        if (num != null) {
            crashDetailBean.a0.put("F_ANR_PENDING_MSG_CNT", String.valueOf(num));
        }
        List<SyncBarrierMsg> list = bVar.c;
        if (list != null) {
            crashDetailBean.a0.put("F_ANR_SYNC_BARRIER_MSG", list.size() > 0 ? "1" : "0");
        }
        List<KeyPendingMsg> list2 = bVar.f1390d;
        if (list2 != null) {
            crashDetailBean.a0.put("F_ANR_KEY_PENDING_MSG", list2.size() > 0 ? "1" : "0");
        }
        if (!TextUtils.isEmpty(bVar.f1391e)) {
            crashDetailBean.a0.put("F_ANR_METHOD_TRACE", "1");
        }
        if (!TextUtils.isEmpty(bVar.f1393g)) {
            crashDetailBean.a0.put("F_ANR_LOOPER_TRACE", "1");
        }
        if (TextUtils.isEmpty(bVar.f1392f)) {
            return;
        }
        crashDetailBean.a0.put("F_ANR_CPU_TRACE", "1");
    }

    public final boolean x(CrashDetailBean crashDetailBean) {
        e.f.a.a.b.b bVar = this.f1397g;
        boolean zJ = bVar != null ? bVar.j(crashDetailBean) : true;
        n(crashDetailBean);
        return zJ;
    }

    public final boolean y() {
        return (e.f.a.a.a.k.b.c() || e.f.a.a.a.k.b.b()) ? false : true;
    }

    public boolean z() {
        return this.r;
    }
}
