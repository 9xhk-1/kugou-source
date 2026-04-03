package com.kugou.android.watch.lite.base.exit;

import android.os.Handler;
import android.os.Process;
import android.util.Log;
import com.kugou.android.watch.lite.base.application.KGApplication;
import e.c.a.g.a.d.j.b;
import e.c.a.g.a.s.g0;
import e.c.c.o.f;

/* JADX INFO: loaded from: classes.dex */
public class ExitGlobalImpl implements b.c {

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            new Handler(e.c.a.g.a.d.v.d.a()).postDelayed(new d(), 50L);
        }
    }

    public static class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            KGApplication.destroyServer();
        }
    }

    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (g0.a) {
                g0.c("Exit001", "exitForeground() start");
            }
            e.c.a.g.a.f.n.b.a.b(true);
            e.c.a.g.a.d.j.a.e().b();
            e.c.a.g.a.d.j.b.e(f.a(), Process.myPid());
            if (e.c.a.g.a.d.x.f.o()) {
                e.c.a.g.a.d.x.f.w();
                e.c.a.g.a.d.x.f.b();
            }
            if (g0.a) {
                g0.c("Exit001", "exitForeground() end");
            }
        }
    }

    public static class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Log.e("Exit001", "杀掉pid = " + Process.myPid() + ", 前台");
            Process.killProcess(Process.myPid());
        }
    }

    @Override // e.c.a.g.a.d.j.b.c
    public void handleExit() {
        e.c.a.g.a.d.o.f.c.c(new c());
        e.c.a.g.a.d.o.f.c.c(new b());
        e.c.a.g.a.d.o.f.c.d(KGApplication.isForeProcess() ? new d() : new a());
        new d().run();
    }
}
