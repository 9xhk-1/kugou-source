package e.g.a.b.b.a;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import d.a.a.a$b.b.a;
import f.z.d.j;
import f.z.d.k;
import f.z.d.s;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final c a = new c();
    public static final f.d b = f.f.b(C0259c.a);
    public static final f.d c = f.f.b(a.a);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f.d f1488d = f.f.b(b.a);

    public static final class a extends k implements f.z.c.a<AtomicBoolean> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AtomicBoolean invoke() {
            return new AtomicBoolean(false);
        }
    }

    public static final class b extends k implements f.z.c.a<ArrayList<e.g.a.b.b.a.d>> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ArrayList<e.g.a.b.b.a.d> invoke() {
            return new ArrayList<>();
        }
    }

    /* JADX INFO: renamed from: e.g.a.b.b.a.c$c, reason: collision with other inner class name */
    public static final class C0259c extends k implements f.z.c.a<HandlerThread> {
        public static final C0259c a = new C0259c();

        public C0259c() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HandlerThread invoke() {
            return new HandlerThread("DataChannel.ClientChannel");
        }
    }

    public static final class d extends k implements f.z.c.a<Context> {
        public final /* synthetic */ Context a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context) {
            super(0);
            this.a = context;
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Context invoke() {
            return this.a;
        }
    }

    public static final class e extends k implements f.z.c.a<e.g.a.b.b.a.g.c> {
        public static final e a = new e();

        public e() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.g.a.b.b.a.g.c invoke() {
            Looper looper = c.a.d().getLooper();
            j.d(looper, "handlerThread.looper");
            return new e.g.a.b.b.a.g.c(looper);
        }
    }

    public static final class f extends k implements f.z.c.a<ExecutorService> {
        public final /* synthetic */ ExecutorService a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ExecutorService executorService) {
            super(0);
            this.a = executorService;
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ExecutorService invoke() {
            return this.a;
        }
    }

    public final AtomicBoolean b() {
        return (AtomicBoolean) c.getValue();
    }

    public final ArrayList<e.g.a.b.b.a.d> c() {
        return (ArrayList) f1488d.getValue();
    }

    public final HandlerThread d() {
        return (HandlerThread) b.getValue();
    }

    public final void e(String str, String str2, e.g.a.b.b.a.e eVar) {
        j.e(str, "serverAuthority");
        j.e(str2, "clientName");
        j.e(eVar, "iClient");
        synchronized (c()) {
            e.g.b.b.a.a("DataChannel.ClientChannel", "initClientImpl serverAuthority = [" + str + "], clientName = [" + str2 + "], client = [" + eVar + ']');
            a.c().add(new e.g.a.b.b.a.d(str, str2, eVar));
        }
    }

    public final void f(Context context) {
        j.e(context, "context");
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(1);
        j.d(executorServiceNewFixedThreadPool, "newFixedThreadPool(1)");
        g(context, executorServiceNewFixedThreadPool);
    }

    public final void g(Context context, ExecutorService executorService) {
        boolean z;
        boolean z2;
        j.e(context, "context");
        j.e(executorService, "executorService");
        boolean z3 = false;
        if (b().compareAndSet(false, true)) {
            d().start();
            f.c0.b<?> bVarA = s.a(Context.class);
            a.C0032a c0032a = new a.C0032a(new d(context));
            j.e(bVarA, "kClass");
            j.e(c0032a, "lazyInstance");
            e.g.a.b.b.a.g.a aVar = e.g.a.b.b.a.g.a.a;
            ConcurrentHashMap<f.c0.b<?>, f.d<?>> concurrentHashMapA = aVar.a();
            if (concurrentHashMapA.containsKey(bVarA)) {
                aVar.c("Object of the same class [ " + ((Object) bVarA.getSimpleName()) + " ] type are injected");
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                concurrentHashMapA.put(bVarA, c0032a);
            }
            f.c0.b<?> bVarA2 = s.a(e.g.a.b.b.a.g.c.class);
            a.C0032a c0032a2 = new a.C0032a(e.a);
            j.e(bVarA2, "kClass");
            j.e(c0032a2, "lazyInstance");
            ConcurrentHashMap<f.c0.b<?>, f.d<?>> concurrentHashMapA2 = aVar.a();
            if (concurrentHashMapA2.containsKey(bVarA2)) {
                aVar.c("Object of the same class [ " + ((Object) bVarA2.getSimpleName()) + " ] type are injected");
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                concurrentHashMapA2.put(bVarA2, c0032a2);
            }
            f.c0.b<?> bVarA3 = s.a(ExecutorService.class);
            a.C0032a c0032a3 = new a.C0032a(new f(executorService));
            j.e(bVarA3, "kClass");
            j.e(c0032a3, "lazyInstance");
            ConcurrentHashMap<f.c0.b<?>, f.d<?>> concurrentHashMapA3 = aVar.a();
            if (concurrentHashMapA3.containsKey(bVarA3)) {
                aVar.c("Object of the same class [ " + ((Object) bVarA3.getSimpleName()) + " ] type are injected");
                z3 = true;
            }
            if (z3) {
                return;
            }
            concurrentHashMapA3.put(bVarA3, c0032a3);
        }
    }
}
