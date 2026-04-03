package e.c.a.g.a.g.j.g;

import android.os.SystemClock;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.s.f0;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public KGMusic a;
    public long b;
    public long c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f956d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f957e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f958f = 0;

    public static class a {
        public static final b a = new b();
    }

    public static b d() {
        return a.a;
    }

    public final void a(int i2) {
        if (g0.a) {
            g0.e("ContentViewTime", String.format("计时增量 time:%s", Integer.valueOf(i2)));
        }
        this.f957e += (long) i2;
    }

    public final void b(boolean z, int i2) {
        if (z) {
            this.f958f |= i2;
        } else {
            this.f958f &= i2 ^ (-1);
        }
    }

    public void c() {
        if (this.a != null && e(2) && this.c > 1000) {
            b(true, 8);
            if (g0.a) {
                f0.c();
            }
            if (g0.a) {
                g0.e("ContentViewTime", String.format("结束计时 time:%s", Long.valueOf(SystemClock.elapsedRealtime())));
            }
            if (e(4)) {
                b(false, 4);
                a((int) Math.max(0L, SystemClock.elapsedRealtime() - this.f956d));
            }
            j();
        }
    }

    public final boolean e(int i2) {
        return (this.f958f & i2) == i2;
    }

    public void f(KGMusicWrapper kGMusicWrapper) {
        if (kGMusicWrapper == null) {
            b(false, 2);
            return;
        }
        this.a = kGMusicWrapper.getKgmusic();
        this.f956d = 0L;
        this.f957e = 0L;
        this.b = 0L;
        this.c = 0L;
        b(false, 4);
        b(false, 8);
        b(true, 2);
    }

    public void g(int i2, int i3) {
        if (g0.a) {
            g0.e("ContentViewTime", String.format("歌曲时间变化 position%s duration:%s", Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        this.b = i2;
        this.c = i3;
    }

    public void h() {
        if (this.a != null && e(2) && !e(8) && e(4)) {
            if (g0.a) {
                f0.c();
            }
            if (g0.a) {
                g0.e("ContentViewTime", String.format("暂停计时 time:%s", Long.valueOf(SystemClock.elapsedRealtime())));
            }
            b(false, 4);
            a((int) Math.max(0L, SystemClock.elapsedRealtime() - this.f956d));
        }
    }

    public void i() {
        if (this.a == null || !f.q() || !e(2) || e(8) || e(4)) {
            return;
        }
        if (g0.a) {
            f0.c();
        }
        if (g0.a) {
            g0.e("ContentViewTime", String.format("开始计时 time:%s", Long.valueOf(SystemClock.elapsedRealtime())));
        }
        this.f956d = SystemClock.elapsedRealtime();
        b(true, 4);
    }

    public final void j() {
        long j = this.f957e;
        if (j <= 1000) {
            if (g0.a) {
                g0.e("ContentViewTime", String.format("统计计时:观看时长过短->丢弃 time:%s", Long.valueOf(j)));
            }
        } else {
            long j2 = this.b;
            long j3 = this.c;
            long j4 = j3 - ((long) ((int) (j3 * 0.03f)));
            e.c.a.g.a.e.b.b(new YoungBITask(20011, "statistics").setSpt(Long.toString(j3)).setDuration(Long.toString(j)).setMixsongid(Long.toString(this.a.getMixId())).setSvar1(Integer.toString((j < j4 || j2 < j4) ? 2 : 1)));
        }
    }
}
