package e.c.a.g.a.d.m;

import android.os.SystemClock;
import android.view.Choreographer;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.g0;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile b f456h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f457d;
    public final boolean a = c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.c4, false);
    public final int b = c.c().getConfigAsInt(e.c.a.g.a.f.e.b.S3, 20);
    public boolean c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f458e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f459f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Choreographer.FrameCallback f460g = new a();

    public class a implements Choreographer.FrameCallback {
        public a() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            if (b.this.f458e == 0) {
                b.this.f457d = SystemClock.elapsedRealtime();
            }
            b.c(b.this);
            if (b.this.f458e % 8000 == 0) {
                long jElapsedRealtime = (SystemClock.elapsedRealtime() - b.this.f457d) / ((long) b.this.f458e);
                if (jElapsedRealtime >= b.this.b) {
                    if (g0.a) {
                        g0.b("FpsMonitor", "doFrame: detachMonitor");
                    }
                    b.this.c = true;
                    EventBus.getDefault().post(new e.c.a.g.a.d.m.a());
                }
                if (g0.a) {
                    g0.b("FpsMonitor", "doFrame: avgFps:" + jElapsedRealtime);
                }
                b.this.f458e = 0;
            }
            if (b.this.c) {
                return;
            }
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public static /* synthetic */ int c(b bVar) {
        int i2 = bVar.f458e;
        bVar.f458e = i2 + 1;
        return i2;
    }

    public static b i() {
        if (f456h == null) {
            synchronized (b.class) {
                if (f456h == null) {
                    f456h = new b();
                }
            }
        }
        return f456h;
    }

    public void j() {
        if (g0.a) {
            g0.b("FpsMonitor", "onStart:");
        }
        if (this.f459f || !this.a || this.c) {
            return;
        }
        this.f459f = true;
        Choreographer.getInstance().postFrameCallback(this.f460g);
    }

    public void k() {
        if (g0.a) {
            g0.b("FpsMonitor", "onStop:");
        }
        if (this.f459f && this.a && !this.c) {
            this.f459f = false;
            this.f458e = 0;
            Choreographer.getInstance().removeFrameCallback(this.f460g);
        }
    }
}
