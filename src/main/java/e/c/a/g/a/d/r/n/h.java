package e.c.a.g.a.d.r.n;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.util.Log;
import e.c.a.g.a.s.g0;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile h f506e;
    public final ArrayBlockingQueue<d<?>> a = new ArrayBlockingQueue<>(12);
    public e b;
    public c c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f507d;

    public h() {
        g();
    }

    @SuppressLint({"Assert"})
    public static h c() {
        if (f506e == null) {
            synchronized (h.class) {
                if (f506e == null) {
                    f506e = new h();
                }
            }
        }
        return f506e;
    }

    public static void f() {
        synchronized (h.class) {
            if (f506e != null) {
                f506e.h();
            }
        }
    }

    public final void a() {
        if (SystemClock.elapsedRealtime() - this.f507d > 3000) {
            try {
                d<?> dVarB = b();
                if (dVarB != null) {
                    boolean z = false;
                    g gVar = dVarB.f501i;
                    if (gVar != null) {
                        gVar.finish();
                        z = true;
                    } else {
                        dVarB.e();
                    }
                    this.a.clear();
                    Log.d("MusicFeesController", "checkQueueBlocking: str=" + (z + "," + dVarB.getClass() + "," + dVarB.l() + "," + dVarB.k()));
                }
            } catch (Exception unused) {
            }
            this.f507d = SystemClock.elapsedRealtime();
        }
    }

    public d<?> b() {
        d<?> dVarC;
        e eVar = this.b;
        if (eVar == null || (dVarC = eVar.c()) == null) {
            return null;
        }
        return dVarC;
    }

    public void d(d<?> dVar) {
        a();
        if (!dVar.d()) {
            dVar.Q();
            return;
        }
        if (!dVar.o()) {
            dVar.I();
            return;
        }
        try {
            if (!this.b.isAlive()) {
                g();
                if (g0.a) {
                    g0.b("MusicFeesController", "restart: " + this.a.size() + " thread is alive: " + this.b.isAlive());
                }
            }
            this.b.a(dVar);
            if (g0.a) {
                g0.b("MusicFeesController", "add size: " + this.a.size() + " thread is alive: " + this.b.isAlive());
            }
        } catch (IllegalStateException e2) {
            g0.k(e2);
        }
    }

    public void e(b bVar) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(bVar);
        }
    }

    public final void g() {
        h();
        e eVar = new e(this.a);
        this.b = eVar;
        eVar.start();
        c cVar = new c();
        this.c = cVar;
        cVar.c();
    }

    public final void h() {
        e eVar = this.b;
        if (eVar != null) {
            eVar.d();
        }
        c cVar = this.c;
        if (cVar != null) {
            cVar.b();
        }
    }
}
