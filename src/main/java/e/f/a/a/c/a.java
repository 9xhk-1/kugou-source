package e.f.a.a.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tmachine.trace.cpu.monitor.CpuInfoMonitor;
import com.tencent.tmachine.trace.looper.monitor.LooperMsgDispatchMonitor;
import com.tencent.tmachine.trace.provider.stacktrace.StackTraceConfig;
import com.tme.fireeye.crash.crashmodule.JavaCrashHandler;
import com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler;
import e.f.a.a.c.c.c;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: e.f.a.a.c.a$a, reason: collision with other inner class name */
    public static class C0249a {
        public boolean a = true;
        public boolean b = false;
        public StackTraceConfig c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1410d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public LooperMsgDispatchMonitor.Config f1411e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1412f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public CpuInfoMonitor.Config f1413g = null;

        public C0249a a(boolean z) {
            this.a = z;
            return this;
        }

        public C0249a b(boolean z) {
            this.f1412f = z;
            return this;
        }

        public C0249a c(boolean z) {
            this.b = z;
            return this;
        }

        public String toString() {
            return "AnrConfig{enableCatchSystemAnrTrace=" + this.a + ", enableMethodTrace=" + this.b + ", methodTraceCfg=" + this.c + ", enableLooperTrace=" + this.f1410d + ", looperTraceCfg=" + this.f1411e + ", enableCpuMonitor=" + this.f1412f + ", cpuMonitorCfg=" + this.f1413g + '}';
        }
    }

    public static class b {
        public boolean a = false;
        public boolean b = true;
        public boolean c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1414d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1415e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1416f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public C0249a f1417g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f1418h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public e.f.a.a.c.c.a f1419i = null;
        public e.f.a.a.c.d.a j = null;
        public c k = null;

        public b a(e.f.a.a.c.c.a aVar) {
            this.f1419i = aVar;
            return this;
        }

        public b b(c cVar) {
            this.k = cVar;
            return this;
        }

        public b c(String str) {
            this.f1418h = str;
            return this;
        }

        public b d(boolean z, C0249a c0249a) {
            this.f1416f = z;
            this.f1417g = c0249a;
            return this;
        }

        public b e(boolean z) {
            this.c = z;
            return this;
        }

        public b f(boolean z) {
            this.f1414d = z;
            return this;
        }

        public b g(boolean z) {
            this.a = z;
            return this;
        }

        public b h(boolean z) {
            this.b = z;
            return this;
        }

        public String toString() {
            return "InitParameters{isDebug=" + this.a + ", isUploadProcess=" + this.b + ", enableJavaCrashHandler=" + this.c + ", enableNativeCrashHandler=" + this.f1414d + ", enableAnrHandler=" + this.f1416f + ", anrConfig=" + this.f1417g + ", dumpFilePath='" + this.f1418h + "', crashHandleListener=" + this.f1419i + ", uploadHandleListener=" + this.j + ", crashStrategyBean=" + this.k + '}';
        }
    }

    public static void a(Context context, boolean z) {
        e.f.a.a.c.c.b.g(context, z);
    }

    public static c b(c cVar, C0249a c0249a) {
        if (cVar != null) {
            cVar.F(c0249a.a);
            cVar.I(c0249a.b);
            cVar.W(c0249a.c);
            cVar.H(c0249a.f1410d);
            cVar.K(c0249a.f1411e);
            cVar.G(c0249a.f1412f);
            cVar.D(c0249a.f1413g);
            return cVar;
        }
        c cVar2 = new c();
        cVar2.P(true);
        cVar2.V(true);
        cVar2.M(10);
        cVar2.N(1);
        cVar2.O(10);
        cVar2.L(500);
        cVar2.R(true);
        cVar2.S(true);
        cVar2.J(5000L);
        cVar2.F(c0249a.a);
        cVar2.I(c0249a.b);
        cVar2.W(c0249a.c);
        cVar2.H(c0249a.f1410d);
        cVar2.K(c0249a.f1411e);
        cVar2.G(c0249a.f1412f);
        cVar2.D(c0249a.f1413g);
        return cVar2;
    }

    public static void c(Context context, String str, b bVar) {
        if (bVar == null) {
            Log.i("FireEyeEup", "[FireEyeCrashAnrPlugin.init] param 'initParameters' is null, use default params");
            bVar = new b();
        }
        if (!bVar.c && !bVar.f1414d && !bVar.f1416f) {
            Log.i("FireEyeEup", "[FireEyeCrashAnrPlugin.init] all crash is disable, return");
            return;
        }
        boolean z = bVar.a;
        e.f.a.a.c.c.b.t(z, z);
        e.f.a.a.a.k.c.f("[FireEyeCrashAnrPlugin.init] appId=%s, initParameters=%s", str, bVar.toString());
        boolean z2 = bVar.c;
        JavaCrashHandler.canEnableJavaCrashHandler = z2;
        if (z2) {
            e.f.a.a.a.k.c.f("[FireEyeCrashAnrPlugin.init] init java crash report", new Object[0]);
        }
        c cVar = bVar.k;
        C0249a c0249a = bVar.f1417g;
        if (c0249a == null) {
            c0249a = new C0249a();
        }
        e.f.a.a.c.c.b.i(context, str, bVar.f1419i, bVar.j, bVar.b, b(cVar, c0249a));
        boolean z3 = bVar.f1414d;
        NativeCrashHandler.canEnableNativeCrashHandler = z3;
        if (z3) {
            e.f.a.a.a.k.c.f("[FireEyeCrashAnrPlugin.init] init native crash report", new Object[0]);
        }
        boolean z4 = bVar.f1415e;
        NativeCrashHandler.isProtectionModeEnabled = z4;
        if (z4) {
            e.f.a.a.a.k.c.f("[FireEyeCrashAnrPlugin.init] isProtectionModeEnabled", new Object[0]);
        }
        String absolutePath = bVar.f1418h;
        if (TextUtils.isEmpty(absolutePath)) {
            absolutePath = context.getDir("fireeye_dump", 0).getAbsolutePath();
        } else {
            File file = new File(absolutePath);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        e.f.a.a.c.c.b.k(context, absolutePath, bVar.a);
        if (bVar.f1416f) {
            e.f.a.a.a.k.c.f("[FireEyeCrashAnrPlugin.init] init anr report", new Object[0]);
            e.f.a.a.c.b.a.a(context);
        }
    }

    public static void d(Context context, String str, String str2) {
        e.f.a.a.c.c.b.p(context, str, str2);
    }

    public static void e(Context context, String str) {
        e.f.a.a.c.c.b.r(context, str);
    }

    public static void f(Context context, String str) {
        e.f.a.a.c.c.b.s(context, str);
    }

    public static void g(Context context, String str) {
        e.f.a.a.c.c.b.u(context, str);
    }

    public static void h(Context context, String str) {
        e.f.a.a.c.c.b.v(context, str);
    }

    public static void i(Context context, String str) {
        e.f.a.a.c.c.b.x(context, str);
    }

    public static void j() {
        e.f.a.a.c.c.b.y();
    }

    public static void k() {
        e.f.a.a.c.c.b.z();
    }

    public static void l() {
        e.f.a.a.c.c.b.A();
    }
}
