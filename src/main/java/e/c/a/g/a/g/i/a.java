package e.c.a.g.a.g.i;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Runnable {
    public boolean a = true;
    public boolean b = false;

    /* JADX INFO: renamed from: e.c.a.g.a.g.i.a$a, reason: collision with other inner class name */
    public class C0137a extends TimerTask {
        public C0137a(a aVar) {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            y.e().j();
        }
    }

    public abstract void a();

    public void b(boolean z) {
        this.a = z;
    }

    public void c() {
        if (this.a) {
            x.v(null, false, true);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Thread.interrupted()) {
            return;
        }
        a();
        if (this.b) {
            return;
        }
        new Timer().schedule(new C0137a(this), 10L);
    }
}
