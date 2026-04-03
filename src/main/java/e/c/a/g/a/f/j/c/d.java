package e.c.a.g.a.f.j.c;

import android.text.TextUtils;
import com.kugou.android.watch.lite.common.music.entity.CExtraInfo;
import com.kugou.android.watch.lite.common.music.entity.ExtraInfo;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.music.entity.SongQuality;
import e.c.a.g.a.d.r.g;
import e.c.a.g.a.s.r0;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static int a(int i2, String str) {
        if (i2 > 10000) {
            i2 /= 1000;
        }
        return (TextUtils.isEmpty(str) || !("ape".equals(str.toLowerCase()) || "kgma".equals(str.toLowerCase()) || "flac".equals(str.toLowerCase()))) ? i2 < 64 ? SongQuality.QUALITY_LOW.getType() : i2 > 300 ? SongQuality.QUALITY_HIGHEST.getType() : SongQuality.QUALITY_HIGH.getType() : SongQuality.QUALITY_SUPER.getType();
    }

    public static String b(KGMusicWrapper kGMusicWrapper) {
        KGMusic kgmusic = kGMusicWrapper != null ? kGMusicWrapper.getKgmusic() : null;
        ExtraInfo extraInfo = kgmusic != null ? kgmusic.getExtraInfo() : null;
        CExtraInfo cExtraInfo = extraInfo != null ? extraInfo.cExtraInfo : null;
        if (cExtraInfo != null) {
            return cExtraInfo.getSource();
        }
        if (kGMusicWrapper != null) {
            return kGMusicWrapper.getSource();
        }
        return null;
    }

    public static boolean c(KGMusicWrapper kGMusicWrapper) {
        if (kGMusicWrapper == null) {
            return false;
        }
        return r0.h(kGMusicWrapper.getMusicTransParamEnenty()) || g.y(kGMusicWrapper.getCharge()) || g.x(kGMusicWrapper.getKgmusic());
    }

    public static boolean d(KGSong kGSong) {
        if (kGSong == null) {
            return false;
        }
        return r0.h(kGSong.getMusicTransParamEnenty()) || g.y(kGSong.q1()) || g.w(kGSong.q1());
    }

    public static String e(String str) {
        if (str == null || !str.trim().toLowerCase().equals("null")) {
            return str;
        }
        return null;
    }
}
