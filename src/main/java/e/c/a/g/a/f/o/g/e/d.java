package e.c.a.g.a.f.o.g.e;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public final e.c.a.g.a.f.o.g.e.b a;
    public final a b;
    public final b c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f737d;

    public interface a {
        boolean handleInstruction(e.c.a.g.a.f.o.g.e.a aVar);
    }

    public static final class b {
        public boolean a;

        public final void a() {
            this.a = false;
        }

        public final boolean b() {
            if (this.a) {
                return false;
            }
            this.a = true;
            return true;
        }
    }

    public d(String str, a aVar) {
        this(str, aVar, null);
    }

    public final void a(e.c.a.g.a.f.o.g.e.a aVar) {
        Runnable runnable = aVar.f730f;
        if (runnable != null) {
            runnable.run();
            return;
        }
        a aVar2 = this.b;
        if (aVar2 == null || !aVar2.handleInstruction(aVar)) {
            d(aVar);
        }
    }

    public final boolean b(e.c.a.g.a.f.o.g.e.b bVar, e.c.a.g.a.f.o.g.e.a aVar, long j) {
        aVar.f729e = this;
        return bVar.a(aVar, j);
    }

    public final void c() {
        this.c.a();
    }

    public void d(e.c.a.g.a.f.o.g.e.a aVar) {
    }

    public final e.c.a.g.a.f.o.g.e.a e(int i2, Object obj) {
        return e.c.a.g.a.f.o.g.e.a.d(this, i2, obj);
    }

    public final void f(int i2) {
        this.a.e(this, i2, null);
    }

    public final void g(int i2, Object obj) {
        this.a.e(this, i2, obj);
    }

    public final boolean h(e.c.a.g.a.f.o.g.e.a aVar) {
        return j(aVar, 0L);
    }

    public boolean i(e.c.a.g.a.f.o.g.e.a aVar, long j) {
        e.c.a.g.a.f.o.g.e.b bVar = this.a;
        if (bVar == null) {
            return false;
        }
        return b(bVar, aVar, j);
    }

    public final boolean j(e.c.a.g.a.f.o.g.e.a aVar, long j) {
        if (j < 0) {
            j = 0;
        }
        return i(aVar, SystemClock.uptimeMillis() + j);
    }

    public final boolean k() {
        return this.c.b();
    }

    public d(String str, a aVar, b bVar) {
        this.a = c.c().a;
        this.b = aVar;
        this.c = bVar == null ? new b() : bVar;
        this.f737d = 0;
    }
}
