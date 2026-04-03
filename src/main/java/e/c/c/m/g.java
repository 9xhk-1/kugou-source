package e.c.c.m;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.player.kugouplayer.JniGlobalEventListen;
import com.kugou.datacollect.crash.JonSnow;
import com.kugou.datacollect.crash.bean.CrashBean;
import com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Thread.UncaughtExceptionHandler, JniGlobalEventListen {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile g f1272e;
    public AbsHttpClient a = null;
    public e.c.c.d b = null;
    public Thread.UncaughtExceptionHandler c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f1273d;

    public static class a {
        public final JonSnow a;
        public Thread.UncaughtExceptionHandler b;
        public final AtomicBoolean c = new AtomicBoolean(false);

        /* JADX INFO: renamed from: e.c.c.m.g$a$a, reason: collision with other inner class name */
        public class C0208a implements JonSnow.c {
            public C0208a() {
            }

            @Override // com.kugou.datacollect.crash.JonSnow.c
            public void onDecideHandle(Thread thread, Throwable th) {
                a.this.b(false, thread, th, -1L);
            }

            @Override // com.kugou.datacollect.crash.JonSnow.c
            public void onRisingGiveUp() {
                g.e("snow give up");
                SystemClock.sleep(5000L);
                Process.killProcess(Process.myPid());
            }
        }

        public a(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.b = uncaughtExceptionHandler;
            this.a = new JonSnow(context);
        }

        public final void b(boolean z, Thread thread, Throwable th, long j) {
            if (this.c.getAndSet(true)) {
                g.e("this process has processed crash once, ignore the more");
                return;
            }
            g.e("onHandleCrash");
            try {
                e.c.c.f.b(new CrashBean(0, th));
            } catch (Throwable th2) {
                e.c.c.f.b(new CrashBean(PointerIconCompat.TYPE_VERTICAL_TEXT, th2));
            }
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }

        /* JADX WARN: Finally extract failed */
        public void c(Thread thread, Throwable th) {
            if (this.a.f(thread, th, new C0208a())) {
                g.e("snow handle this uncaught exception, just return");
                return;
            }
            try {
                b(true, thread, th, NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_EXPIRED_TIME);
                if (g.f1272e.c != null) {
                    e.c.c.o.g.a("siganid-bisdk", "buglyUncaughtExceptionHandler run");
                    g.f1272e.c.uncaughtException(thread, th);
                }
                if (this.b != null) {
                    e.c.c.o.g.a("siganid-bisdk", "defaultHandler run");
                    this.b.uncaughtException(thread, th);
                }
                Process.killProcess(Process.myPid());
            } catch (Throwable th2) {
                if (g.f1272e.c != null) {
                    e.c.c.o.g.a("siganid-bisdk", "buglyUncaughtExceptionHandler run");
                    g.f1272e.c.uncaughtException(thread, th);
                }
                if (this.b != null) {
                    e.c.c.o.g.a("siganid-bisdk", "defaultHandler run");
                    this.b.uncaughtException(thread, th);
                }
                Process.killProcess(Process.myPid());
                throw th2;
            }
        }
    }

    public g(Context context) {
        context.getApplicationContext();
        Thread.getDefaultUncaughtExceptionHandler();
        this.f1273d = new a(context, Thread.getDefaultUncaughtExceptionHandler());
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static g d(Context context) {
        if (f1272e == null) {
            synchronized (g.class) {
                if (f1272e == null) {
                    f1272e = new g(context);
                }
            }
        }
        return f1272e;
    }

    public static void e(String str) {
        Log.i("CrashHandler", str);
    }

    public AbsHttpClient b() {
        return this.a;
    }

    public e.c.c.d c() {
        return this.b;
    }

    @Override // com.kugou.common.player.kugouplayer.JniGlobalEventListen
    public void onNativeCrashed(String[] strArr) {
        e.c.c.o.g.a("bisdk", strArr[0].toString());
        e.c.c.o.g.a("bisdk", strArr[1].toString());
        CrashBean crashBean = new CrashBean(1006, strArr[1]);
        e.c.c.o.g.a("bisdk", "begin add to report");
        e.c.c.f.b(crashBean);
        try {
            Thread.sleep(NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_EXPIRED_TIME);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this.f1273d.c(thread, th);
    }
}
