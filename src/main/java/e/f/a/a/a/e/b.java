package e.f.a.a.a.e;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tme.fireeye.crash.comm.biz.UserInfoBean;
import com.tme.fireeye.crash.comm.strategy.StrategyBean;
import e.f.a.a.a.k.c;
import e.f.a.a.a.k.f;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static boolean a = false;
    public static int b = 10;
    public static long c = 300000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f1328d = 30000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f1329e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f1330f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f1331g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f1332h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static e.f.a.a.a.e.a f1333i = null;
    public static long j = 0;
    public static Application.ActivityLifecycleCallbacks k = null;
    public static Class<?> l = null;
    public static boolean m = true;

    public class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ e.f.a.a.a.b b;

        public a(Context context, e.f.a.a.a.b bVar) {
            this.a = context;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.t(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: e.f.a.a.a.e.b$b, reason: collision with other inner class name */
    public class C0244b implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            String name = activity != null ? activity.getClass().getName() : "unknown";
            if (b.l == null || b.l.getName().equals(name)) {
                c.b(">>> %s onCreated <<<", name);
                e.f.a.a.a.h.b bVarM = e.f.a.a.a.h.b.m();
                if (bVarM != null) {
                    bVarM.f0.add(b.q(name, "onCreated"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String name = activity != null ? activity.getClass().getName() : "unknown";
            if (b.l == null || b.l.getName().equals(name)) {
                c.b(">>> %s onDestroyed <<<", name);
                e.f.a.a.a.h.b bVarM = e.f.a.a.a.h.b.m();
                if (bVarM != null) {
                    bVarM.f0.add(b.q(name, "onDestroyed"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            String name = activity != null ? activity.getClass().getName() : "unknown";
            if (b.l == null || b.l.getName().equals(name)) {
                c.b(">>> %s onPaused <<<", name);
                e.f.a.a.a.h.b bVarM = e.f.a.a.a.h.b.m();
                if (bVarM == null) {
                    return;
                }
                bVarM.f0.add(b.q(name, "onPaused"));
                bVarM.I(false);
                long jCurrentTimeMillis = System.currentTimeMillis();
                bVarM.T = jCurrentTimeMillis;
                bVarM.U = jCurrentTimeMillis - bVarM.S;
                long unused = b.f1331g = jCurrentTimeMillis;
                if (bVarM.U < 0) {
                    bVarM.U = 0L;
                }
                if (activity != null) {
                    bVarM.R = "background";
                } else {
                    bVarM.R = "unknown";
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            String name = activity != null ? activity.getClass().getName() : "unknown";
            if (b.l == null || b.l.getName().equals(name)) {
                c.b(">>> %s onResumed <<<", name);
                e.f.a.a.a.h.b bVarM = e.f.a.a.a.h.b.m();
                if (bVarM == null) {
                    return;
                }
                bVarM.f0.add(b.q(name, "onResumed"));
                bVarM.I(true);
                bVarM.R = name;
                long jCurrentTimeMillis = System.currentTimeMillis();
                bVarM.S = jCurrentTimeMillis;
                bVarM.V = jCurrentTimeMillis - b.f1332h;
                long j = bVarM.S - b.f1331g;
                if (j > (b.f1329e > 0 ? b.f1329e : b.f1328d)) {
                    bVarM.H();
                    b.m();
                    c.f("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j / 1000), Long.valueOf(b.f1328d / 1000));
                    if (b.f1330f % b.b == 0) {
                        b.f1333i.i(4, b.m, 0L);
                        return;
                    }
                    b.f1333i.i(4, false, 0L);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (jCurrentTimeMillis2 - b.j > b.c) {
                        long unused = b.j = jCurrentTimeMillis2;
                        c.f("add a timer to upload hot start user info", new Object[0]);
                        if (b.m) {
                            b.f1333i.d(b.c);
                        }
                    }
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public static /* synthetic */ int m() {
        int i2 = f1330f;
        f1330f = i2 + 1;
        return i2;
    }

    public static boolean p(Context context) {
        e.f.a.a.a.h.b bVarE = e.f.a.a.a.h.b.e(context);
        List<UserInfoBean> listK = f1333i.k(bVarE.f1346f);
        if (listK == null) {
            return true;
        }
        for (int i2 = 0; i2 < listK.size(); i2++) {
            UserInfoBean userInfoBean = listK.get(i2);
            if (userInfoBean.q.equals(bVarE.d()) && userInfoBean.b == 1) {
                long jO = f.o();
                if (jO <= 0) {
                    return true;
                }
                if (userInfoBean.f266h >= jO) {
                    if (userInfoBean.f267i <= 0) {
                        f1333i.n();
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static String q(String str, String str2) {
        return f.m() + "  " + str + "  " + str2 + "\n";
    }

    public static void r(Context context, e.f.a.a.a.b bVar) {
        long jC;
        if (a) {
            return;
        }
        boolean z = e.f.a.a.a.h.b.e(context).f1348h;
        m = z;
        f1333i = new e.f.a.a.a.e.a(context, z);
        a = true;
        if (bVar != null) {
            l = bVar.f();
            jC = bVar.c();
        } else {
            jC = 0;
        }
        if (jC <= 0) {
            t(context, bVar);
        } else {
            e.f.a.a.a.k.a.b().e(new a(context, bVar), jC);
        }
    }

    public static void s() {
        e.f.a.a.a.h.b bVarM = e.f.a.a.a.h.b.m();
        if (bVarM == null) {
            return;
        }
        String className = null;
        boolean z = false;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getMethodName().equals("onCreate")) {
                className = stackTraceElement.getClassName();
            }
            if (stackTraceElement.getClassName().equals("android.app.Activity")) {
                z = true;
            }
        }
        if (className == null) {
            className = "unknown";
        } else if (z) {
            bVarM.I(true);
        } else {
            className = "background";
        }
        bVarM.R = className;
    }

    public static void t(Context context, e.f.a.a.a.b bVar) {
        boolean zG;
        boolean zK;
        boolean z = false;
        if (bVar != null) {
            zK = bVar.k();
            zG = bVar.g();
        } else {
            zG = true;
            zK = false;
        }
        if (!zK) {
            z = zG;
        } else if (!p(context)) {
            return;
        }
        s();
        if (z) {
            x(context);
        }
        if (m) {
            u();
            f1333i.e();
            f1333i.f(21600000L);
        }
    }

    public static void u() {
        f1332h = System.currentTimeMillis();
        f1333i.i(1, false, 0L);
        c.f("[session] launch app, new start", new Object[0]);
    }

    public static void v() {
        e.f.a.a.a.e.a aVar = f1333i;
        if (aVar != null) {
            aVar.i(2, false, 0L);
        }
    }

    public static void w(StrategyBean strategyBean, boolean z) {
        e.f.a.a.a.e.a aVar = f1333i;
        if (aVar != null && !z) {
            aVar.n();
        }
        if (strategyBean == null) {
            return;
        }
        long j2 = strategyBean.p;
        if (j2 > 0) {
            f1328d = j2;
        }
        int i2 = strategyBean.u;
        if (i2 > 0) {
            b = i2;
        }
        long j3 = strategyBean.v;
        if (j3 > 0) {
            c = j3;
        }
    }

    @TargetApi(14)
    public static void x(Context context) {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application == null) {
            return;
        }
        try {
            if (k == null) {
                k = new C0244b();
            }
            application.registerActivityLifecycleCallbacks(k);
        } catch (Exception e2) {
            if (c.k(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }
}
