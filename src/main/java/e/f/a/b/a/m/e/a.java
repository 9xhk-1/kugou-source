package e.f.a.b.a.m.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import f.s;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static volatile Looper a;
    public static volatile HandlerThread b;
    public static final C0256a c = new C0256a(null);

    /* JADX INFO: renamed from: e.f.a.b.a.m.e.a$a, reason: collision with other inner class name */
    public static final class C0256a {
        public C0256a() {
        }

        public final Looper a() {
            if (a.a == null) {
                synchronized (a.class) {
                    if (a.a == null) {
                        a.b = new HandlerThread("RMonitor_Default_thread");
                        HandlerThread handlerThread = a.b;
                        if (handlerThread == null) {
                            j.n();
                            throw null;
                        }
                        handlerThread.start();
                        HandlerThread handlerThread2 = a.b;
                        if (handlerThread2 == null) {
                            j.n();
                            throw null;
                        }
                        a.a = handlerThread2.getLooper();
                        Looper looper = a.a;
                        if (looper == null) {
                            j.n();
                            throw null;
                        }
                        a.c(new Handler(looper));
                    }
                    s sVar = s.a;
                }
            }
            Looper looper2 = a.a;
            if (looper2 != null) {
                return looper2;
            }
            j.n();
            throw null;
        }

        public /* synthetic */ C0256a(g gVar) {
            this();
        }
    }

    public static final /* synthetic */ void c(Handler handler) {
    }

    public static final Looper f() {
        return c.a();
    }
}
