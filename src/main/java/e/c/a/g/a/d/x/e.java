package e.c.a.g.a.d.x;

import android.media.AudioManager;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.s.h1;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static volatile long a;
    public static volatile long b;

    public static void a() {
        if (a > 0) {
            long j = b - a;
            long jCurrentTimeMillis = System.currentTimeMillis() - b;
            e.c.a.g.a.e.b.b(new YoungBITask(22020017, "statistics").setSvar1(String.valueOf(j)).setSvar2(String.valueOf(jCurrentTimeMillis)).setDuration(String.valueOf(j + jCurrentTimeMillis)));
            a = 0L;
            b = 0L;
        }
    }

    public static void b() {
        b = System.currentTimeMillis();
    }

    public static void c() {
        a = System.currentTimeMillis();
    }

    public static void d(int i2) {
        e.c.a.g.a.e.b.b(new YoungBITask(12820993, "statistics").setSvar1(h1.h(String.valueOf(((AudioManager) KGApplication.getContext().getSystemService("audio")) != null ? (r0.getStreamVolume(3) * 1.0f) / r0.getStreamMaxVolume(3) : 1.0f), 4)).setSvar2(String.valueOf(i2)).setSvar3(e.c.a.g.a.d.l.a.e() ? "1" : "0"));
        e.c.a.g.a.d.d0.a.a("PlayTrace", "tracePlayPause: " + i2);
    }
}
