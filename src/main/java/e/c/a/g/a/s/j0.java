package e.c.a.g.a.s;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.appcompat.widget.ActivityChooserView;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class j0 {
    public static volatile j0 c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Handler f1211d;
    public volatile HandlerThread a;
    public ThreadPoolExecutor b;

    public j0() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        Math.min(iAvailableProcessors * 50, 200);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iAvailableProcessors, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60L, TimeUnit.SECONDS, new SynchronousQueue());
        this.b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static j0 b() {
        if (c == null) {
            f();
        }
        return c;
    }

    public static Handler c() {
        if (f1211d == null) {
            f1211d = new Handler(Looper.getMainLooper());
        }
        return f1211d;
    }

    public static synchronized void f() {
        c = new j0();
    }

    public static void g(Runnable runnable) {
        if (runnable != null) {
            c().post(runnable);
        }
    }

    public static void h(Runnable runnable, long j) {
        if (runnable != null) {
            c().postDelayed(runnable, j);
        }
    }

    public static void i(Runnable runnable) {
        if (runnable != null) {
            c().removeCallbacks(runnable);
        }
    }

    public void a(Runnable runnable) {
        if (runnable == null || this.b.isShutdown()) {
            return;
        }
        this.b.execute(runnable);
    }

    public Looper d() {
        if (this.a == null) {
            synchronized (j0.class) {
                if (this.a == null) {
                    this.a = new HandlerThread("mainPage", 10);
                    this.a.start();
                }
            }
        }
        return this.a.getLooper();
    }

    public ThreadPoolExecutor e() {
        return this.b;
    }
}
