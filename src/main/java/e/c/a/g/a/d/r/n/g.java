package e.c.a.g.a.d.r.n;

import com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface g {
    List<a<?>> doCalaulatePrice(int i2);

    void finish();

    AbsFrameworkActivity getActivity();

    void hideLoadingView();

    int pay(boolean z);

    void runOnUIThread(Runnable runnable);

    void showAlbumDialog();

    void showDownChangSongDialog();

    void showListenDialog(int i2, e.c.a.g.a.d.r.p.a.c cVar);

    void showListenForrbiddonDialog(KGMusic kGMusic);

    void showListenLocalEncrypt(int i2, long j, int i3);

    void showListenPartStrengthenDialog(int i2, e.c.a.g.a.d.r.p.a.c cVar, KGMusicWrapper kGMusicWrapper);

    void showLoadingView();

    void showLoginDialog();

    void showNoSupportSingleBuy(String str);

    void showQualityFeeDialog(int i2, int i3, int i4, String str);
}
