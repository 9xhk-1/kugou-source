package e.c.a.g.a.d.x;

import com.kugou.android.watch.lite.base.player.entity.CommNetSongUrlInfo;
import com.kugou.android.watch.lite.base.player.entity.UrlRequesterInfo;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;

/* JADX INFO: loaded from: classes.dex */
public class m {
    public static CommNetSongUrlInfo a(KGMusicWrapper kGMusicWrapper) {
        return b(kGMusicWrapper, "play");
    }

    public static CommNetSongUrlInfo b(KGMusicWrapper kGMusicWrapper, String str) {
        if (kGMusicWrapper == null) {
            return null;
        }
        UrlRequesterInfo urlRequesterInfo = new UrlRequesterInfo();
        urlRequesterInfo.setHash(kGMusicWrapper.getHashValue());
        urlRequesterInfo.mixId = kGMusicWrapper.getMixId();
        urlRequesterInfo.albumId = kGMusicWrapper.getAlbumID();
        urlRequesterInfo.quality = kGMusicWrapper.getSongQuality();
        urlRequesterInfo.isListenPart = kGMusicWrapper.isNeedListenPart();
        urlRequesterInfo.feeOption = e.c.a.g.a.d.x.q.a.a(str, true, String.valueOf(kGMusicWrapper.getFeeAlbumID()), kGMusicWrapper.getMixId(), kGMusicWrapper.getAudioId());
        return new n(urlRequesterInfo).g();
    }
}
