package e.c.a.g.a.d.l;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.ipc.core.RemoteConnector;
import com.kugou.android.watch.lite.component.SplashActivity;
import com.kugou.android.watch.lite.component.privacy.PrivacyAgreementActivity;
import com.kugou.common.permission.PermissionActivity;
import e.c.a.g.a.d.d0.c;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.g.i.y;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m1;
import e.c.a.g.a.s.q;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f451e = "Foreground";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile a f452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f453g;
    public boolean a;
    public int b;
    public Handler c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f454d;

    /* JADX INFO: renamed from: e.c.a.g.a.d.l.a$a, reason: collision with other inner class name */
    public class RunnableC0059a implements Runnable {
        public RunnableC0059a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.a && l1.X() && !a.e()) {
                Log.e(a.f451e, "onExitMainPage: 九学王 Foreground 延时关闭进程：");
                KGApplication.exit();
            }
        }
    }

    public class b implements Action1<String> {
        public b(a aVar) {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(String str) {
            try {
                c cVar = c.a;
                if (!cVar.r()) {
                    g0.c("mhs_watch_xlog", "xlog is not enable");
                    q.j(cVar.d(), "");
                    q.j(cVar.l(), "");
                } else {
                    e.c.a.g.a.d.d0.b bVar = e.c.a.g.a.d.d0.b.a;
                    bVar.d(cVar.c(), 10);
                    bVar.d(cVar.i(), 1);
                    bVar.b(cVar.c(), 2L);
                    bVar.b(cVar.i(), 2L);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public a(boolean z) {
        this.a = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.G3, 1) == 1;
        this.b = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.H3, 5) * 1000;
        this.c = new Handler(Looper.getMainLooper());
        this.f454d = new RunnableC0059a();
    }

    public static int c() {
        return f453g;
    }

    public static void d(Application application, boolean z) {
        if (f452f != null) {
            application.registerActivityLifecycleCallbacks(f452f);
            if (g0.a) {
                g0.b("hch-desklyric", "instance != null  registerActivityLifecycleCallbacks");
                return;
            }
            return;
        }
        f452f = new a(z);
        application.registerActivityLifecycleCallbacks(f452f);
        if (g0.a) {
            g0.b("hch-desklyric", "instance == null  registerActivityLifecycleCallbacks");
        }
    }

    public static boolean e() {
        return f453g > 0;
    }

    public final boolean f(@NonNull Activity activity) {
        return (activity instanceof SplashActivity) || (activity instanceof PermissionActivity) || (activity instanceof PrivacyAgreementActivity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        if (g0.a) {
            g0.b("hch-desklyric", "onActivityCreated-------");
        }
        if (f(activity)) {
            return;
        }
        e.c.a.g.a.d.l.b.a().c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        if (g0.a) {
            g0.b("hch-desklyric", "onActivityDestroyed-------");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        l1.s0(null);
        l1.r0(false, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        if (g0.a) {
            g0.b("hch-desklyric", "onActivityResumed------- activity = " + activity);
        }
        if (!f(activity)) {
            e.c.a.g.a.d.l.b.a().c();
            f.I(true);
            e.c.a.g.a.d.d0.a.a(f451e, "app on foreground");
        }
        l1.s0(activity.getClass());
        l1.r0(true, activity.getClass());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        f453g++;
        e.c.a.g.a.d.m.b.i().j();
        if (this.a && l1.X()) {
            this.c.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        if (g0.a) {
            g0.b("hch-desklyric", "onActivityStopped-------");
        }
        f453g--;
        if (c() <= 0) {
            e.c.a.g.a.d.l.b.a().b();
            f.I(false);
            e.c.a.g.a.d.m.b.i().k();
            if (this.a && l1.X()) {
                Log.e(f451e, "forceStopAppTime = " + this.b);
                this.c.postDelayed(this.f454d, (long) this.b);
            }
            y.c();
            RemoteConnector.l();
            e.c.a.g.a.d.d0.a.a(f451e, "app not on foreground");
            m1.f(new b(this));
        }
        l1.s0(null);
        l1.r0(false, null);
    }
}
