package e.c.c.j.d;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static ExecutorService a = Executors.newSingleThreadExecutor();

    public static void a(Runnable runnable) {
        a.execute(runnable);
    }
}
