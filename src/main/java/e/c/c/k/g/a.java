package e.c.c.k.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import e.c.c.k.c;
import e.c.c.k.f.e;
import e.c.c.o.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f1256e = new a();
    public b c;
    public boolean a = false;
    public List<e.c.c.k.f.b> b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HandlerThread f1257d = new HandlerThread("bi_sdk_cache");

    /* JADX INFO: renamed from: e.c.c.k.g.a$a, reason: collision with other inner class name */
    public class RunnableC0201a implements Runnable {
        public final /* synthetic */ e.c.c.k.f.b a;

        /* JADX INFO: renamed from: e.c.c.k.g.a$a$a, reason: collision with other inner class name */
        public class RunnableC0202a implements Runnable {
            public RunnableC0202a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.a("siganid", "开始添加到数据库");
                Iterator<e.c.c.k.f.b> it = a.this.b.iterator();
                while (it.hasNext()) {
                    a.this.d(it.next());
                }
                a.this.b.clear();
            }
        }

        public RunnableC0201a(e.c.c.k.f.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.e()) {
                a.this.d(this.a);
                return;
            }
            a.this.b.add(this.a);
            if (a.this.b.size() % 2 == 1) {
                a.this.h(new RunnableC0202a(), 2000L);
            }
        }
    }

    public class b extends Handler {
        public b(a aVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    public static a e() {
        return f1256e;
    }

    public void a(String str, String str2, Map<String, String> map) {
        f(c.c().b(str).a().toCacheData(str2, map));
    }

    public void b(e.c.c.k.f.b bVar) {
        g.a("bisdk", "saveCacheEvent:" + bVar);
        e.q().a(bVar);
    }

    public void c(String str, String str2, Map<String, String> map) {
        e.c.c.k.f.b cacheData = c.c().b(str).a().toCacheData(str2, map);
        cacheData.g(true);
        f(cacheData);
    }

    public void d(e.c.c.k.f.b bVar) {
        e.c.c.k.b bVarB = c.c().b(bVar.d());
        if (bVarB.f()) {
            j(bVar);
        } else if (bVarB.e()) {
            b(bVar);
        }
        if (bVarB.d()) {
            k();
        }
    }

    public void f(e.c.c.k.f.b bVar) {
        g(new RunnableC0201a(bVar));
    }

    public void g(Runnable runnable) {
        h(runnable, 0L);
    }

    public void h(Runnable runnable, long j) {
        this.c.postDelayed(runnable, j);
    }

    public void i() {
        if (this.a) {
            return;
        }
        g.a("CacheModel", "prepare");
        this.f1257d.start();
        this.c = new b(this, this.f1257d.getLooper());
        this.a = true;
    }

    public void j(e.c.c.k.f.b bVar) {
        e.q().a(bVar);
        g.a("bisdk", "saveCacheEvent end:");
    }

    public void k() {
        g.a("bisdk", "saveCacheEvent:");
        e.q().d();
    }
}
