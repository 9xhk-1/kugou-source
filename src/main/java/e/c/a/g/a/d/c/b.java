package e.c.a.g.a.d.c;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.ipc.core.RemoteConnector;
import com.kugou.android.watch.lite.common.network.KGHttpVariables;
import com.kugou.common.datacollect.UpdateDeviceFingerHelper;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import com.kugou.common.utils.GrayUtil;
import com.kugou.framework.hack.SystemHackerManager;
import com.kugou.uilib.KGUI;
import e.c.a.g.a.f.m.d;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import e.c.c.e;
import e.c.c.g;
import e.c.c.o.f;
import me.jessyan.autosize.AutoSizeBridge;
import org.greenrobot.eventbus.EventBus;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static KGApplication b = null;
    public static volatile boolean c = false;
    public e.c.a.g.a.d.o.g.c a;

    public class a implements Runnable {
        public a(b bVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.setDefaultUncaughtExceptionHandler(new e.c.a.g.a.d.e.c(b.b));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.c.b$b, reason: collision with other inner class name */
    public class RunnableC0044b implements Runnable {
        public RunnableC0044b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.o();
            e.c.a.g.a.f.e.c.c();
            b.this.m();
            b.this.o();
            b.this.n();
            b.this.p();
            KGUI.getInstance().init().setKGUILog(g0.a).setAppContext(b.b);
            UpdateDeviceFingerHelper.getInstance().tryUpdate();
            b.this.h();
            b.q();
        }
    }

    public class c extends e.a.a.a.b {
        public c(b bVar) {
        }
    }

    public static void q() {
        try {
            e.c.a.g.a.d.d0.c.a.q(f.a(), "");
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("initXLog 1 e = ");
                sb.append(th.getMessage());
                sb.append(", getCanWriteLog = ");
                e.c.a.g.a.d.d0.c cVar = e.c.a.g.a.d.d0.c.a;
                sb.append(cVar.e());
                Log.e("mhs_watch_xlogcrash", sb.toString());
                cVar.t(false);
                Log.e("mhs_watch_xlogcrash", "initXLog 2 e getCanWriteLog = " + cVar.e());
                RingBiReportHelper.INSTANCE.reportHeadFeedBack("发生了错误堆栈" + th.getMessage());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void f() {
        if (g0.a) {
            g0.b("KGAppImpl", "afterPermissionGranted");
        }
        e.c.a.g.a.f.m.c.a.j("key_agree_privacy", true);
        if (e.c.a.g.a.r.b.e()) {
            e.c.a.g.a.r.b.Y(false);
        }
        m.a();
        s();
    }

    public void g(KGApplication kGApplication) {
        if (g0.a) {
            g0.b("KGAppImpl", "attachBaseContext");
        }
        b = kGApplication;
        Retrofit.initHttpVarsClassName(KGHttpVariables.class.getName());
    }

    public void h() {
        try {
            if (d.g(true)) {
                new Handler(Looper.getMainLooper()).postDelayed(new a(this), 2000L);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void i() {
        if (g0.a) {
            g0.b("KGAppImpl", "destroyServer");
        }
        e.c.a.g.a.d.o.g.c cVar = this.a;
        if (cVar != null) {
            cVar.destroy();
        }
        RemoteConnector.h().e();
    }

    public void j() {
        e.c.a.g.a.d.l.b.a().b();
        if (g0.a) {
            g0.c("Exit001", "调用KGCommonApplication.exit(), is fore");
        }
        e.c.a.g.a.d.j.b.c();
    }

    public Application k() {
        return b;
    }

    public Context l() {
        return b;
    }

    public final void m() {
        e.c.c.l.e.a.b = String.valueOf(3337);
        e.c.c.l.e.a.c = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f642d);
        try {
            g.b = l1.T();
            e.a(b, String.valueOf(3337), Integer.parseInt(l1.j()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        e.d(10080);
        e.b(String.valueOf(3337));
        e.c("9FUAroQHHdX8ngYHdTg5v1m9LiX0rX8d");
        e.e(g0.f());
        e.f("8bc5fbeb");
    }

    public final void n() {
        e.c.a.g.a.d.f.b.a.c(b);
    }

    public final void o() {
        try {
            if (g0.a) {
                g0.e("KGAppImpl", "initFireEyeSdk start process:" + e.c.a.g.a.s.d.c(k()));
            }
            e.c.b.a.b.c().d();
            if (g0.a) {
                g0.e("KGAppImpl", "initFireEyeSdk end process:" + e.c.a.g.a.s.d.c(k()));
            }
        } catch (Throwable th) {
            if (g0.a) {
                g0.e("KGAppImpl", "initFireEyeSdk exception:" + th.getMessage());
            }
            if (g0.a || GrayUtil.isGrayPackage) {
                g0.k(th);
            }
        }
    }

    public final void p() {
        e.c.a.g.a.f.k.i.a.f();
    }

    public void r() {
        if (g0.a) {
            g0.b("KGAppImpl", "onCreate");
        }
        f.c(b);
        e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
        cVar.f(b);
        e.c.a.g.a.d.z.a.b().c();
        e.c.a.g.a.d.l.a.d(b, KGApplication.isForeProcess());
        EventBus.builder().executorService(j0.b().e()).addIndex(new e.c.a.g.a.a()).installDefaultEventBus();
        KGApplication.sOrientation = b.getResources().getConfiguration().orientation;
        KGApplication.sScreenSize = l1.y(b);
        if (KGApplication.isForeProcess()) {
            AutoSizeBridge.applyCompat(b);
        }
        e.c.a.g.a.d.u.d.b().init();
        boolean zE = cVar.e("sp_key_show_privacy", true);
        Log.e("mhs_watch_login", "firstInstall = " + zE);
        if (!zE) {
            f();
        }
        t(zE);
        SystemHackerManager.startHack(b);
        try {
            if (d.h(true)) {
                e.c.a.g.a.d.e.b.c();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        e.a.a.a.a.b(b, new c(this)).c();
    }

    public final void s() {
        if (g0.a) {
            g0.b("KGAppImpl", "onCreateFore");
        }
        this.a = e.c.a.g.a.d.o.g.b.f(b);
        RemoteConnector.h().d(true);
        j0.b().a(new RunnableC0044b());
    }

    public final void t(boolean z) {
        int iG = l1.G();
        if (z) {
            KGApplication.isFirstStartAfterInstall = Boolean.TRUE;
            KGApplication.isCoverInstall = Boolean.FALSE;
            e.c.a.g.a.f.m.a.b().h(iG);
        } else {
            KGApplication.isFirstStartAfterInstall = Boolean.FALSE;
            int iA = e.c.a.g.a.f.m.a.b().a(-1);
            Boolean boolValueOf = Boolean.valueOf(iA != iG);
            KGApplication.isCoverInstall = boolValueOf;
            if (boolValueOf.booleanValue()) {
                e.c.a.g.a.f.m.a.b().h(iA);
            }
        }
        Log.e("mhs_watch_login", "isFirstStartAfterInstall = " + KGApplication.isFirstStartAfterInstall);
        e.c.a.g.a.f.m.a.b().g(iG);
        if (g0.a) {
            g0.b("KGAppImpl", String.format("onCreate: 首次安装:%s, 覆盖安装：%s, oldVer:%s, newVer:%s", KGApplication.isFirstStartAfterInstall, KGApplication.isCoverInstall, Integer.valueOf(e.c.a.g.a.f.m.a.b().d(-1)), Integer.valueOf(e.c.a.g.a.f.m.a.b().a(-1))));
        }
    }
}
