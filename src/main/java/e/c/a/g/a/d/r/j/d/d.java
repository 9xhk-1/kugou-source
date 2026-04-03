package e.c.a.g.a.d.r.j.d;

import com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.r.n.g;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface d extends g {
    @Override // e.c.a.g.a.d.r.n.g
    /* synthetic */ List<e.c.a.g.a.d.r.n.a<?>> doCalaulatePrice(int i2);

    @Override // e.c.a.g.a.d.r.n.g
    void finish();

    @Override // e.c.a.g.a.d.r.n.g
    /* synthetic */ AbsFrameworkActivity getActivity();

    List<e.c.a.g.a.d.r.n.a<?>> getFeeResourceDatas();

    @Override // e.c.a.g.a.d.r.n.g
    /* synthetic */ void hideLoadingView();

    @Override // e.c.a.g.a.d.r.n.g
    /* synthetic */ int pay(boolean z);

    @Override // e.c.a.g.a.d.r.n.g
    /* synthetic */ void runOnUIThread(Runnable runnable);

    @Override // e.c.a.g.a.d.r.n.g
    /* synthetic */ void showAlbumDialog();

    @Override // e.c.a.g.a.d.r.n.g
    /* synthetic */ void showDownChangSongDialog();

    @Override // e.c.a.g.a.d.r.n.g
    /* synthetic */ void showListenDialog(int i2, e.c.a.g.a.d.r.p.a.c cVar);

    @Override // e.c.a.g.a.d.r.n.g
    /* synthetic */ void showListenForrbiddonDialog(KGMusic kGMusic);

    @Override // e.c.a.g.a.d.r.n.g
    /* synthetic */ void showListenLocalEncrypt(int i2, long j, int i3);

    @Override // e.c.a.g.a.d.r.n.g
    /* synthetic */ void showListenPartStrengthenDialog(int i2, e.c.a.g.a.d.r.p.a.c cVar, KGMusicWrapper kGMusicWrapper);

    @Override // e.c.a.g.a.d.r.n.g
    /* synthetic */ void showLoadingView();

    @Override // e.c.a.g.a.d.r.n.g, e.c.a.g.a.d.r.j.d.b
    /* synthetic */ void showLoginDialog();

    @Override // e.c.a.g.a.d.r.n.g
    /* synthetic */ void showNoSupportSingleBuy(String str);

    @Override // e.c.a.g.a.d.r.n.g
    /* synthetic */ void showQualityFeeDialog(int i2, int i3, int i4, String str);
}
