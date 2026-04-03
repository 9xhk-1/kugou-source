package e.f.a.b.a.m.e;

import android.os.Handler;
import android.os.Looper;
import f.d;
import f.f;
import f.s;
import f.z.d.j;
import f.z.d.k;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static ExecutorService c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f1487d = new b();
    public static final d a = f.b(C0257b.a);
    public static final d b = f.b(a.a);

    public static final class a extends k implements f.z.c.a<ExecutorService> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ExecutorService invoke() {
            return Executors.newCachedThreadPool();
        }
    }

    /* JADX INFO: renamed from: e.f.a.b.a.m.e.b$b, reason: collision with other inner class name */
    public static final class C0257b extends k implements f.z.c.a<Handler> {
        public static final C0257b a = new C0257b();

        public C0257b() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    public final ExecutorService a() {
        return (ExecutorService) b.getValue();
    }

    public final void b(f.z.c.a<s> aVar) {
        j.f(aVar, "runnable");
        ExecutorService executorServiceA = c;
        if (executorServiceA == null) {
            executorServiceA = a();
        }
        executorServiceA.execute(new c(aVar));
    }
}
