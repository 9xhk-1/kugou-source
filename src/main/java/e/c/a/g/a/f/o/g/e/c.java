package e.c.a.g.a.f.o.g.e;

import android.os.Process;
import e.c.a.g.a.s.j0;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final e.c.a.g.a.f.o.g.e.b a;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(c.this);
            throw null;
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static b f734f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static int f735h;
        public e.c.a.g.a.f.o.g.e.b a;
        public e.c.a.g.a.f.o.g.e.a b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b f736d;

        public static b b(e.c.a.g.a.f.o.g.e.b bVar, e.c.a.g.a.f.o.g.e.a aVar) {
            b bVar2;
            synchronized (b.class) {
                bVar2 = f734f;
                if (bVar2 != null) {
                    f734f = bVar2.f736d;
                    bVar2.f736d = null;
                    f735h--;
                } else {
                    bVar2 = new b();
                }
                bVar2.a = bVar;
                bVar2.b = aVar;
            }
            return bVar2;
        }

        public final void a(int i2) {
            try {
                Process.setThreadPriority(i2);
            } catch (Exception unused) {
            }
        }

        public void c() {
            this.a = null;
            this.b = null;
            synchronized (b.class) {
                int i2 = f735h;
                if (i2 < 30) {
                    this.f736d = f734f;
                    f734f = this;
                    f735h = i2 + 1;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this.b.f729e.f737d);
            e.c.a.g.a.f.o.g.e.a aVar = this.b;
            aVar.f729e.a(aVar);
            this.a.d(this.b);
            c();
            a(0);
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.f.o.g.e.c$c, reason: collision with other inner class name */
    public static class C0108c {
        public static final c a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static /* synthetic */ void a(c cVar) {
        cVar.d();
        throw null;
    }

    public static c c() {
        return C0108c.a;
    }

    public final void b(Runnable runnable) {
        j0.b().a(runnable);
    }

    public final void d() {
        try {
            Process.setThreadPriority(-8);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        e.c.a.g.a.f.o.g.e.b bVar = this.a;
        while (true) {
            e.c.a.g.a.f.o.g.e.a aVarC = bVar.c();
            if (aVarC == null) {
                throw new RuntimeException("Should not happened !!!");
            }
            b(b.b(bVar, aVarC));
        }
    }

    public c() {
        this.a = new e.c.a.g.a.f.o.g.e.b();
        new Thread(new a(), "ScheduleManager").start();
    }
}
