package g.a;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends b1 {
    public static final int a;
    public static boolean b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f1649d = new r();
    public static volatile Executor pool;

    public static final class a implements ThreadFactory {
        public final /* synthetic */ AtomicInteger a;

        public a(AtomicInteger atomicInteger) {
            this.a = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "CommonPool-worker-" + this.a.incrementAndGet());
            thread.setDaemon(true);
            return thread;
        }
    }

    public static final class b implements Runnable {
        public static final b a = new b();

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    static {
        String property;
        int iIntValue;
        try {
            property = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            property = null;
        }
        if (property != null) {
            Integer numF = f.e0.m.f(property);
            if (numF == null || numF.intValue() < 1) {
                throw new IllegalStateException(("Expected positive number in kotlinx.coroutines.default.parallelism, but has " + property).toString());
            }
            iIntValue = numF.intValue();
        } else {
            iIntValue = -1;
        }
        a = iIntValue;
    }

    @Override // g.a.b0
    public void a(f.w.g gVar, Runnable runnable) {
        Runnable runnableWrapTask;
        f.z.d.j.f(gVar, "context");
        f.z.d.j.f(runnable, "block");
        try {
            Executor executorF = pool;
            if (executorF == null) {
                executorF = f();
            }
            g2 g2VarA = h2.a();
            if (g2VarA == null || (runnableWrapTask = g2VarA.wrapTask(runnable)) == null) {
                runnableWrapTask = runnable;
            }
            executorF.execute(runnableWrapTask);
        } catch (RejectedExecutionException unused) {
            g2 g2VarA2 = h2.a();
            if (g2VarA2 != null) {
                g2VarA2.unTrackTask();
            }
            m0.j.u(runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    public final ExecutorService d() {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(g(), new a(new AtomicInteger()));
        f.z.d.j.b(executorServiceNewFixedThreadPool, "Executors.newFixedThread…Daemon = true }\n        }");
        return executorServiceNewFixedThreadPool;
    }

    public final ExecutorService e() {
        Class<?> cls;
        ExecutorService executorService;
        if (System.getSecurityManager() != null) {
            return d();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return d();
        }
        if (!b && a < 0) {
            try {
                Method method = cls.getMethod("commonPool", new Class[0]);
                Object objInvoke = method != null ? method.invoke(null, new Object[0]) : null;
                if (!(objInvoke instanceof ExecutorService)) {
                    objInvoke = null;
                }
                executorService = (ExecutorService) objInvoke;
            } catch (Throwable unused2) {
                executorService = null;
            }
            if (executorService != null) {
                if (!f1649d.h(cls, executorService)) {
                    executorService = null;
                }
                if (executorService != null) {
                    return executorService;
                }
            }
        }
        try {
            Object objNewInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(f1649d.g()));
            if (!(objNewInstance instanceof ExecutorService)) {
                objNewInstance = null;
            }
            executorService2 = (ExecutorService) objNewInstance;
        } catch (Throwable unused3) {
        }
        return executorService2 != null ? executorService2 : d();
    }

    public final synchronized Executor f() {
        Executor executorE;
        executorE = pool;
        if (executorE == null) {
            executorE = e();
            pool = executorE;
        }
        return executorE;
    }

    public final int g() {
        Integer numValueOf = Integer.valueOf(a);
        if (!(numValueOf.intValue() > 0)) {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : f.b0.f.b(Runtime.getRuntime().availableProcessors() - 1, 1);
    }

    public final boolean h(Class<?> cls, ExecutorService executorService) {
        f.z.d.j.f(cls, "fjpClass");
        f.z.d.j.f(executorService, "executor");
        executorService.submit(b.a);
        Integer num = null;
        try {
            Object objInvoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (!(objInvoke instanceof Integer)) {
                objInvoke = null;
            }
            num = (Integer) objInvoke;
        } catch (Throwable unused) {
        }
        return num != null && num.intValue() >= 1;
    }

    @Override // g.a.b0
    public String toString() {
        return "CommonPool";
    }
}
