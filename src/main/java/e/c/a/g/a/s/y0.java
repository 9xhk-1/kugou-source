package e.c.a.g.a.s;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler;

/* JADX INFO: loaded from: classes2.dex */
public class y0 {
    public static Runnable a;

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (d.f(KGApplication.getContext())) {
                return;
            }
            e.c.a.g.a.d.x.f.t();
        }
    }

    public static void a(KGMusic kGMusic, KGMusic kGMusic2) {
        if (kGMusic == null || kGMusic2 == null) {
            return;
        }
        if (kGMusic.getSpecialId() <= 0 && kGMusic2.getSpecialId() > 0) {
            kGMusic.setSpecialId(kGMusic2.getSpecialId());
        }
        if (kGMusic.getAlbumID() <= 0 && kGMusic2.getAlbumID() > 0) {
            kGMusic.setAlbumID(kGMusic2.getAlbumID());
        }
        if (TextUtils.isEmpty(kGMusic.getmSpecialOrAlbumName()) && !TextUtils.isEmpty(kGMusic2.getmSpecialOrAlbumName())) {
            kGMusic.setmSpecialOrAlbumName(kGMusic2.getmSpecialOrAlbumName());
        }
        kGMusic.musicLinkSource = kGMusic2.musicLinkSource;
        kGMusic.setSource(kGMusic2.getSource());
    }

    public static long b(KGMusicWrapper kGMusicWrapper, long j) {
        return kGMusicWrapper.isNeedListenPart() ? kGMusicWrapper.getHashOffset().end_ms : j;
    }

    public static long c(@Nullable KGMusicWrapper kGMusicWrapper, int i2) {
        if (kGMusicWrapper != null) {
            long jB = b(kGMusicWrapper, -1L) - d(kGMusicWrapper, -1L);
            if (jB > NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_EXPIRED_TIME) {
                return jB / 1000;
            }
        }
        return i2;
    }

    public static long d(KGMusicWrapper kGMusicWrapper, long j) {
        return kGMusicWrapper.isNeedListenPart() ? kGMusicWrapper.getHashOffset().start_ms : kGMusicWrapper.hasStartMs() ? kGMusicWrapper.getDisposableStartMs() : j;
    }

    public static void e() {
        if (e.c.a.g.a.d.x.f.o() && e.c.a.g.a.d.x.f.q()) {
            Runnable runnable = a;
            if (runnable != null) {
                j0.i(runnable);
            }
            if (a == null) {
                a = new a();
            }
            j0.h(a, 1000L);
        }
    }
}
