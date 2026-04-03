package e.f.a.a.a.k;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final AtomicInteger b = new AtomicInteger(1);
    public static a c;
    public ScheduledExecutorService a;

    /* JADX INFO: renamed from: e.f.a.a.a.k.a$a, reason: collision with other inner class name */
    public class ThreadFactoryC0246a implements ThreadFactory {
        public ThreadFactoryC0246a(a aVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("FireEyeThread-" + a.b.getAndIncrement());
            return thread;
        }
    }

    public a() {
        this.a = null;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactoryC0246a(this));
        this.a = scheduledExecutorServiceNewScheduledThreadPool;
        if (scheduledExecutorServiceNewScheduledThreadPool == null || scheduledExecutorServiceNewScheduledThreadPool.isShutdown()) {
            c.j("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized a b() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean c() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.concurrent.ScheduledExecutorService r0 = r1.a     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Ld
            boolean r0 = r0.isShutdown()     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto Ld
            r0 = 1
            goto Le
        Ld:
            r0 = 0
        Le:
            monitor-exit(r1)
            return r0
        L10:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.a.a.a.k.a.c():boolean");
    }

    public synchronized boolean d(Runnable runnable) {
        if (!c()) {
            c.j("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            c.j("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        c.b("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
        try {
            this.a.execute(runnable);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public synchronized boolean e(Runnable runnable, long j) {
        if (!c()) {
            c.j("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            c.j("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        if (j <= 0) {
            j = 0;
        }
        c.b("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j), runnable.getClass().getName());
        try {
            this.a.schedule(runnable, j, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
