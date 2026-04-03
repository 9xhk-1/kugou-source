package e.c.a.g.a.q;

import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.apm.task.ShareSongAPM;

/* JADX INFO: loaded from: classes2.dex */
public interface d {
    boolean isShareEnable();

    void onDestroy();

    void share(KGMusicWrapper kGMusicWrapper, ShareSongAPM shareSongAPM);
}
