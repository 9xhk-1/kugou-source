package e.c.c.o;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static volatile h b;
    public ThreadPoolExecutor a;

    public h() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        Math.min(iAvailableProcessors * 50, 200);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iAvailableProcessors, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60L, TimeUnit.SECONDS, new SynchronousQueue());
        this.a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static h b() {
        if (b == null) {
            c();
        }
        return b;
    }

    public static synchronized void c() {
        b = new h();
    }

    public static void d(Runnable runnable) {
        b().a(runnable);
    }

    public void a(Runnable runnable) {
        if (runnable == null || this.a.isShutdown()) {
            return;
        }
        this.a.execute(runnable);
    }
}
