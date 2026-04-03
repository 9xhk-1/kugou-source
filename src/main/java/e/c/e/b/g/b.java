package e.c.e.b.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import e.c.e.b.e.d;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Handler f1310e;

    @NonNull
    public d a;
    public volatile a b;
    public volatile int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile float f1311d;

    public class a implements Runnable {
        public int a;

        @NonNull
        public InterfaceC0236b b;

        public a(int i2, @NonNull InterfaceC0236b interfaceC0236b) {
            this.a = i2;
            this.b = interfaceC0236b;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.b == this) {
                b.this.b = null;
            }
            b.this.e().removeCallbacks(this);
            this.b.call();
        }
    }

    /* JADX INFO: renamed from: e.c.e.b.g.b$b, reason: collision with other inner class name */
    public interface InterfaceC0236b {
        void call();
    }

    public b(@NonNull d dVar) {
        this.a = dVar;
    }

    public final void d(a aVar) {
        e().removeCallbacks(aVar);
    }

    public final Handler e() {
        if (f1310e == null) {
            synchronized (b.class) {
                if (f1310e == null) {
                    HandlerThread handlerThread = new HandlerThread("PlayPositionReminder");
                    handlerThread.start();
                    f1310e = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f1310e;
    }

    public void f() {
        d(this.b);
    }

    public void g() {
        this.c = this.a.audio().getCurrentPosition();
        k(this.b);
    }

    public void h() {
        f();
    }

    public void i() {
        g();
    }

    public void j(int i2, InterfaceC0236b interfaceC0236b) {
        l();
        if (i2 <= 0) {
            return;
        }
        n();
        a aVar = new a(i2, interfaceC0236b);
        m(aVar);
        this.b = aVar;
    }

    public final void k(a aVar) {
        d(aVar);
        m(aVar);
    }

    public void l() {
        this.b = null;
        e().removeCallbacksAndMessages(null);
    }

    public final void m(a aVar) {
        if (aVar == null) {
            return;
        }
        e().postDelayed(aVar, (long) ((aVar.a - this.c) * this.f1311d));
    }

    public final void n() {
        this.c = this.a.audio().getCurrentPosition();
        int[] localPlaySpeedCache = this.a.extra().getLocalPlaySpeedCache();
        if (localPlaySpeedCache == null || localPlaySpeedCache.length < 2 || localPlaySpeedCache[0] <= 0 || localPlaySpeedCache[1] <= 0) {
            localPlaySpeedCache = new int[]{1, 1};
        }
        this.f1311d = (localPlaySpeedCache[0] * 1.0f) / localPlaySpeedCache[1];
    }
}
