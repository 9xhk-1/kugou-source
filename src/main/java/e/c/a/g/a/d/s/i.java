package e.c.a.g.a.d.s;

import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.uilib.utils.KGUIStringParseUtils;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public static boolean a(KGMusicWrapper kGMusicWrapper) {
        return e(kGMusicWrapper) || b(kGMusicWrapper);
    }

    public static boolean b(KGMusicWrapper kGMusicWrapper) {
        if (kGMusicWrapper == null || !e.c.a.g.a.r.b.F()) {
            return false;
        }
        long jO = e.c.a.g.a.r.b.o();
        long j = KGUIStringParseUtils.parseInt(kGMusicWrapper.getFeeAlbumID());
        return j > 0 ? h.i().e(jO, j) : h.i().e(jO, kGMusicWrapper.getAlbumID());
    }

    public static boolean c(long j, String str) {
        if (e.c.a.g.a.r.b.F()) {
            return h.i().f(e.c.a.g.a.r.b.o(), j, str);
        }
        return false;
    }

    public static boolean d(KGMusic kGMusic) {
        if (kGMusic == null) {
            return false;
        }
        return c(kGMusic.getMixId(), kGMusic.getHashValue());
    }

    public static boolean e(KGMusicWrapper kGMusicWrapper) {
        if (kGMusicWrapper == null || !e.c.a.g.a.r.b.F()) {
            return false;
        }
        return h.i().f(e.c.a.g.a.r.b.o(), kGMusicWrapper.getMixId(), kGMusicWrapper.getHashValueV2());
    }
}
