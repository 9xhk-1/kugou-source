package e.c.a.g.a.i;

import android.util.Log;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import e.c.a.g.a.s.m1;
import f.z.d.j;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public final KGMusicWrapper a;
    public int b;
    public long c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1089d;

    /* JADX INFO: renamed from: e.c.a.g.a.i.a$a, reason: collision with other inner class name */
    public static final class C0163a<T> implements Action1 {
        public C0163a() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) {
            b.a.a(a.this.a);
        }
    }

    public a(KGMusicWrapper kGMusicWrapper) {
        j.e(kGMusicWrapper, "music");
        this.a = kGMusicWrapper;
        e.c.a.g.a.f.h.a.a aVar = e.c.a.g.a.f.h.a.a.a;
        this.b = aVar.d() * 1000;
        this.f1089d = aVar.k();
    }

    public final void b() {
        KGMusicWrapper kGMusicWrapper;
        if (this.f1089d && (kGMusicWrapper = this.a) != null) {
            if (kGMusicWrapper.getMixId() <= 0) {
                RingBiReportHelper.reportHead4$default(RingBiReportHelper.INSTANCE, j.l("startTracking mixid 为 0, song = ", this.a), null, 2, null);
                return;
            }
            this.c = System.currentTimeMillis();
            Log.e("mhs_watch_history", "startTracking: " + this.c + ", music = " + ((Object) this.a.getDisplayName()));
        }
    }

    public final void c(KGMusicWrapper kGMusicWrapper, int i2) {
        KGMusicWrapper kGMusicWrapper2;
        j.e(kGMusicWrapper, "currentMusic");
        if (this.f1089d && (kGMusicWrapper2 = this.a) != null && kGMusicWrapper2.getMixId() > 0) {
            boolean z = false;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.c;
            if (e.c.a.g.a.r.b.F() && e.c.a.g.a.r.b.o() > 0 && jCurrentTimeMillis >= this.b - 3000) {
                m1.f(new C0163a());
                z = true;
            }
            Log.d("mhs_watch_history", "stopTracking: " + jCurrentTimeMillis + ", music = " + ((Object) this.a.getDisplayName()) + ", mix = " + this.a.getMixId() + ", 是否插入 = " + z);
        }
    }
}
