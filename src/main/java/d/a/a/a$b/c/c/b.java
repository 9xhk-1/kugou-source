package d.a.a.a$b.c.c;

import f.d;
import f.f;
import f.s;
import f.z.d.j;
import f.z.d.k;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b a = new b();
    public static final d b = f.b(a.a);

    public static final class a extends k implements f.z.c.a<ConcurrentHashMap<String, ExecutorService>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        public ConcurrentHashMap<String, ExecutorService> invoke() {
            return new ConcurrentHashMap<>();
        }
    }

    /* JADX INFO: renamed from: d.a.a.a$b.c.c.b$b, reason: collision with other inner class name */
    public static final class C0035b extends k implements f.z.c.a<s> {
        public final /* synthetic */ f.z.c.a<s> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0035b(f.z.c.a<s> aVar) {
            super(0);
            this.a = aVar;
        }

        @Override // f.z.c.a
        public s invoke() {
            this.a.invoke();
            return s.a;
        }
    }

    public static final void e(f.z.c.a aVar) {
        j.e(aVar, "$run");
        e.g.a.b.b.a.g.b.a.a("ExecutorTask", new C0035b(aVar));
    }

    public final Map<String, ExecutorService> a() {
        return (Map) b.getValue();
    }

    public final void b(String str) {
        j.e(str, "widgetCode");
        e.g.b.b.a.a("ExecutorTask", j.l("unregisterDataTask widgetCode: ", str));
        a().remove(str);
    }

    public final void c(String str, ExecutorService executorService) {
        j.e(str, "widgetCode");
        j.e(executorService, "executorService");
        e.g.b.b.a.a("ExecutorTask", "registerDataTask widgetCode: " + str + ", task: " + executorService);
        a().put(str, executorService);
    }

    public final void d(String str, final f.z.c.a<s> aVar) {
        j.e(str, "widgetCode");
        j.e(aVar, "run");
        ExecutorService executorService = a().get(str);
        if (executorService == null) {
            executorService = null;
        } else {
            Future<?> futureSubmit = executorService.submit(new Runnable() { // from class: d.a.a.a$b.c.c.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.e(aVar);
                }
            });
            e.g.b.b.a.a("ExecutorTask", "runOnDataThread widgetCode(" + str + ") submit result is " + futureSubmit);
        }
        if (executorService == null) {
            e.g.b.b.a.b("ExecutorTask", "runOnDataThread widgetCode(" + str + ") is illegal");
        }
    }
}
