package e.c.a.g.a.s;

import android.content.Context;
import android.text.TextUtils;
import com.kugou.android.watch.lite.common.music.entity.KGFile;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.SongQuality;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i0 {
    public static List<KGFile> a(List<KGFile> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (KGFile kGFile : list) {
            if (!q.E(kGFile.getFilepath())) {
                arrayList.add(kGFile);
            }
        }
        return arrayList;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.replace("\\", "").replace("/", "").replace("*", "").replace("?", "").replace(":", "").replace("\"", "").replace("<", "").replace(">", "").replace(RetryStaticsLOG.MARK_SEPERATE, "");
    }

    public static KGFile c(String str, long j, String str2, boolean z, SongQuality songQuality, boolean z2) {
        return e(str, j, str2, z, songQuality, z2, false);
    }

    public static KGFile d(List<KGFile> list, String str, SongQuality songQuality) {
        KGFile next;
        if (list != null) {
            Iterator<KGFile> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next != null && next.getQualitytype() == songQuality.getType()) {
                    break;
                }
            }
            if (next != null && str.equals(next.getMusicname())) {
                return next;
            }
        }
        return null;
    }

    public static KGFile e(String str, long j, String str2, boolean z, SongQuality songQuality, boolean z2, boolean z3) {
        KGFile kGFileD;
        KGFile kGFileD2;
        boolean zA = e.c.a.g.a.f.j.c.c.a();
        try {
            TextUtils.isEmpty(str);
        } catch (Exception e2) {
            g0.k(e2);
        }
        if (zA) {
            if (!TextUtils.isEmpty(str2) && (kGFileD = d(null, str2, songQuality)) != null) {
                return kGFileD;
            }
        } else if (!TextUtils.isEmpty(str2) && (kGFileD2 = d(a(null), str2, songQuality)) != null) {
            return kGFileD2;
        }
        return null;
    }

    public static KGFile f(KGMusic kGMusic, boolean z, SongQuality... songQualityArr) {
        SongQuality nearestSongQuality;
        KGFile kGFileC;
        if (kGMusic == null) {
            return null;
        }
        if (songQualityArr == null || songQualityArr.length == 0 || songQualityArr[0] == null) {
            nearestSongQuality = kGMusic.getNearestSongQuality(h(e.c.c.o.f.a()));
            if (g0.a) {
                g0.b("zlx_quality", "musicQuality: " + nearestSongQuality);
            }
            kGFileC = c(kGMusic.getHashValue(), kGMusic.getMixId(), kGMusic.getDisplayName(), true, nearestSongQuality, true);
        } else {
            nearestSongQuality = songQualityArr[0];
            if (g0.a) {
                g0.b("zlx_quality", "forceMusicQuality musicQuality: " + nearestSongQuality);
            }
            kGFileC = c(kGMusic.getHashValue(), kGMusic.getMixId(), kGMusic.getDisplayName(), true, nearestSongQuality, false);
        }
        if (kGFileC != null) {
            kGFileC.setAudioId(kGMusic.getAudioId());
            kGFileC.setAlbumID("" + kGMusic.getAlbumID());
            kGFileC.setCharge(kGMusic.getCharge() > 0);
            kGFileC.setMusicLinkSource(kGMusic.musicLinkSource);
            kGFileC.setMusicLinkExtInfo(kGMusic.getMusicLinkExtInfo());
            kGFileC.setAudioType(kGMusic.getAudioType());
            if (!TextUtils.isEmpty(kGMusic.getExtname())) {
                kGFileC.setExtname(kGMusic.getExtname());
            }
        }
        if (kGFileC == null) {
            return kGMusic.toKGFile(nearestSongQuality);
        }
        if (g0.a) {
            g0.b("zlx_quality", "getKGFileToPlay: " + kGFileC.getQualitytype());
        }
        return kGFileC;
    }

    public static KGFile g(KGMusic kGMusic, SongQuality... songQualityArr) {
        return f(kGMusic, true, songQualityArr);
    }

    public static SongQuality h(Context context) {
        return SongQuality.QUALITY_LOW;
    }
}
