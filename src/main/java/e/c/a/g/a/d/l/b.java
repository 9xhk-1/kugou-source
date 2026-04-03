package e.c.a.g.a.d.l;

import android.os.SystemClock;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.f.m.c;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.c.o.f;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static volatile b b = null;
    public static String c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f455d = false;
    public volatile long a = 0;

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                    f455d = l1.n(KGApplication.getContext()).endsWith("1");
                    c = String.format("bt_%s", Long.valueOf(SystemClock.elapsedRealtime()));
                    f455d = true;
                    if (g0.f()) {
                        g0.b("UseTimeManager", String.format("getInstance: pick:%s, mid:%s, bootTime:%s", Boolean.valueOf(f455d), l1.n(f.a()), c));
                    }
                }
            }
        }
        return b;
    }

    public synchronized void b() {
        if (c.a.e("key_agree_privacy", false)) {
            if (this.a > 0) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.a;
                this.a = 0L;
                e.c.a.g.a.r.b.W(0L);
                if (g0.f()) {
                    g0.b("UseTimeManager", "上报前台亮屏使用时长" + jElapsedRealtime);
                }
                if (f455d) {
                    try {
                        e.c.a.g.a.e.b.a(new YoungBITask(20013, "statistics").setSvar1(c).setDuration(Long.toString(jElapsedRealtime)));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public synchronized void c() {
        if (this.a <= 0 && f455d) {
            if (g0.f()) {
                g0.b("UseTimeManager", "开始记录前台亮屏使用时长");
            }
            this.a = SystemClock.elapsedRealtime();
            e.c.a.g.a.r.b.W(SystemClock.elapsedRealtime());
        }
    }
}
