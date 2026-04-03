package e.f.a.a.b.h;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Thread {
    public boolean a = false;
    public boolean b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<a> f1407d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<c> f1408f = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<a> f1409h = new ArrayList<>();

    public void a() {
        b(new Handler(Looper.getMainLooper()));
    }

    public void b(Handler handler) {
        c(handler, 5000L);
    }

    public void c(Handler handler, long j) {
        if (handler == null) {
            e.f.a.a.a.k.c.c("addThread handler should not be null", new Object[0]);
            return;
        }
        String name = handler.getLooper().getThread().getName();
        for (int i2 = 0; i2 < this.f1407d.size(); i2++) {
            try {
                if (this.f1407d.get(i2).c().equals(handler.getLooper().getThread().getName())) {
                    e.f.a.a.a.k.c.c("addThread fail ,this thread has been added in monitor queue", new Object[0]);
                    return;
                }
            } catch (Exception e2) {
                e.f.a.a.a.k.c.d(e2);
            }
            this.f1407d.add(new a(handler, name, j));
        }
        this.f1407d.add(new a(handler, name, j));
    }

    public void d(c cVar) {
        if (this.f1408f.contains(cVar)) {
            e.f.a.a.a.k.c.b("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
        } else {
            this.f1408f.add(cVar);
        }
    }

    public final int e() {
        int iMax = 0;
        for (int i2 = 0; i2 < this.f1407d.size(); i2++) {
            try {
                iMax = Math.max(iMax, this.f1407d.get(i2).a());
            } catch (Exception e2) {
                e.f.a.a.a.k.c.d(e2);
            }
        }
        return iMax;
    }

    public void f() {
        for (int i2 = 0; i2 < this.f1407d.size(); i2++) {
            try {
                if (this.f1407d.get(i2).c().equals(Looper.getMainLooper().getThread().getName())) {
                    e.f.a.a.a.k.c.b("remove handler::%s", this.f1407d.get(i2));
                    this.f1407d.remove(i2);
                }
            } catch (Exception e2) {
                e.f.a.a.a.k.c.d(e2);
                return;
            }
        }
    }

    public void g(c cVar) {
        this.f1408f.remove(cVar);
    }

    public void h(boolean z) {
        this.b = z;
    }

    public boolean i() {
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e2) {
            e.f.a.a.a.k.c.d(e2);
            return false;
        }
    }

    public boolean j() {
        this.a = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e2) {
            e.f.a.a.a.k.c.d(e2);
        }
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.a) {
            for (int i2 = 0; i2 < this.f1407d.size(); i2++) {
                try {
                    this.f1407d.get(i2).f();
                } catch (Exception e2) {
                    e.f.a.a.a.k.c.d(e2);
                } catch (OutOfMemoryError e3) {
                    e.f.a.a.a.k.c.d(e3);
                }
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            for (long jUptimeMillis2 = 2000; jUptimeMillis2 > 0 && !isInterrupted(); jUptimeMillis2 = 2000 - (SystemClock.uptimeMillis() - jUptimeMillis)) {
                Thread.sleep(jUptimeMillis2);
            }
            int iE = e();
            if (iE != 0 && iE != 1) {
                this.f1409h.clear();
                for (int i3 = 0; i3 < this.f1407d.size(); i3++) {
                    a aVar = this.f1407d.get(i3);
                    if (aVar.d()) {
                        this.f1409h.add(aVar);
                        aVar.g(Long.MAX_VALUE);
                    }
                }
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                if (nativeCrashHandler == null || !nativeCrashHandler.isEnableCatchAnrTrace()) {
                    e.f.a.a.a.k.c.b("do not enable jni mannual dump anr trace", new Object[0]);
                } else {
                    nativeCrashHandler.dumpAnrNativeStack();
                    e.f.a.a.a.k.c.b("jni mannual dump anr trace", new Object[0]);
                }
                int i4 = 0;
                while (true) {
                    if (this.b) {
                        break;
                    }
                    e.f.a.a.a.k.c.b("do not enable anr continue check", new Object[0]);
                    Thread.sleep(2000L);
                    i4++;
                    if (i4 == 15) {
                        this.f1409h.clear();
                        break;
                    }
                }
                for (int i5 = 0; i5 < this.f1409h.size(); i5++) {
                    a aVar2 = this.f1409h.get(i5);
                    for (int i6 = 0; i6 < this.f1408f.size(); i6++) {
                        e.f.a.a.a.k.c.c("main thread blocked,now begin to upload anr stack", new Object[0]);
                        this.f1408f.get(i6).onThreadBlock(aVar2);
                        this.b = false;
                    }
                }
            }
        }
    }
}
