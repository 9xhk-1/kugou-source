package e.c.a.g.a.g.i;

import com.kugou.android.watch.lite.component.fav.FavListFragment;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.u0;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile y f922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f923e = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(100));
    public a b;
    public volatile Queue<a> a = new ConcurrentLinkedQueue();
    public volatile w c = null;

    public class a {
        public int a;
        public int b;
        public Runnable c;

        public a(y yVar, int i2, int i3, Runnable runnable) {
            e.c.a.g.a.r.b.o();
            this.a = i2;
            this.b = i3;
            this.c = runnable;
        }
    }

    public static void c() {
        try {
            boolean z = e.c.a.g.a.d.v.c.b() instanceof FavListFragment;
            if (!e.c.a.g.a.f.m.b.m().F() || z) {
                return;
            }
            e.c.a.g.a.g.f.c.a.w(w.l.c());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static y e() {
        if (f922d == null || h()) {
            synchronized (y.class) {
                if (f922d == null || h()) {
                    f922d = null;
                    f923e = null;
                    f922d = new y();
                    f923e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(100));
                }
            }
        }
        return f922d;
    }

    public static boolean h() {
        ThreadPoolExecutor threadPoolExecutor = f923e;
        return threadPoolExecutor != null && threadPoolExecutor.isShutdown();
    }

    public void a(int i2, int i3, Runnable runnable) {
        a aVar;
        if (!u0.n(e.c.c.o.f.a(), false) || e.c.a.g.a.r.b.o() <= 0 || runnable == null || this.a == null) {
            return;
        }
        a aVar2 = new a(this, i2, i3, runnable);
        if (1 == i2) {
            for (a aVar3 : this.a) {
                if (1 == aVar3.a) {
                    this.a.remove(aVar3);
                }
                if (9 == aVar3.a && (aVar = this.b) != null && aVar.a != 1) {
                    this.a.remove(aVar3);
                }
            }
        } else if (4 != i2 && 8 == i2) {
            Iterator<a> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next.a == 4 && next.b == i3) {
                    this.a.remove(next);
                    break;
                }
            }
        }
        this.a.offer(aVar2);
        if (g0.f()) {
            i("addExecuteTask\ttaskQueue.size=" + this.a.size() + "\ttype=" + i2);
        }
        j();
    }

    public void b(int i2, Runnable runnable) {
        if (g0.f()) {
            i("addExecuteTask--typeId=" + i2);
        }
        a(i2, 0, runnable);
    }

    public w d() {
        if (this.c == null) {
            synchronized (y.class) {
                if (this.c == null) {
                    this.c = new w();
                }
            }
        }
        return this.c;
    }

    public boolean f() {
        if (g0.f()) {
            i("threadPool.getActiveTaskCount()=" + f923e.getActiveCount());
        }
        return f923e != null && f923e.getActiveCount() > 0;
    }

    public boolean g() {
        if (g0.f()) {
            StringBuilder sb = new StringBuilder();
            sb.append("hasMoreTask=");
            sb.append(!this.a.isEmpty());
            i(sb.toString());
        }
        return (this.a == null || this.a.isEmpty()) ? false : true;
    }

    public void i(String str) {
        if (g0.a) {
            g0.c("yabinCloudSync", "CloudSyncNetThreadPool-->log," + str);
        }
    }

    public synchronized void j() {
        if (!h() && e.c.a.g.a.r.b.o() != 0) {
            boolean zF = f();
            if (zF || !g()) {
                if (!zF) {
                    this.b = null;
                }
            } else {
                if (this.a.peek() == null) {
                    this.a.remove(this.a.poll());
                    j();
                    return;
                }
                if (g0.f()) {
                    i("CloudSyncNetThreadPool-->loop,queueSize=" + this.a.size());
                    if (this.a.peek() != null) {
                        i("taskQueueItemType=" + this.a.peek().a);
                    }
                }
                this.b = this.a.poll();
                try {
                    f923e.execute(this.b.c);
                } catch (Exception e2) {
                    g0.k(e2);
                }
            }
            return;
        }
        if (g0.f()) {
            i("threadPool.isShutdown() = true ");
        }
    }
}
