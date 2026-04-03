package e.c.e.a.a.d;

import androidx.appcompat.widget.ActivityChooserView;
import e.c.e.a.a.c;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class b implements c {
    public final ThreadPoolExecutor a;

    public b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60L, TimeUnit.SECONDS, new SynchronousQueue());
        this.a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    @Override // e.c.e.a.a.c
    public void execute(Runnable runnable) {
        this.a.execute(runnable);
    }
}
