package e.c.a.g.a.g.j;

import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.x.f;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements e.c.a.g.a.g.j.c.b {
    public DelegateFragment a;
    public KGMusicWrapper b = f.e();
    public boolean c = f.q();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f928e;

    public b(DelegateFragment delegateFragment, int i2) {
        this.a = delegateFragment;
    }

    @Override // e.c.a.g.a.g.j.c.b
    public void changeBaseAndHostType(DelegateFragment delegateFragment, int i2) {
        this.a = delegateFragment;
    }

    @Override // e.c.a.g.a.g.j.c.b
    public KGMusicWrapper getCur() {
        return this.b;
    }

    @Override // e.c.a.g.a.g.j.c.b
    public DelegateFragment getFragment() {
        return this.a;
    }

    @Override // e.c.a.g.a.g.j.c.b
    public boolean isPlaying() {
        return this.c;
    }

    @Override // e.c.a.g.a.g.j.c.b
    public boolean isQueueEmpty() {
        return this.b == null && f.r();
    }

    @Override // e.c.a.g.a.g.j.c.b
    public boolean isResume() {
        return this.f927d;
    }

    @Override // e.c.a.g.a.g.j.c.b
    public boolean isShowingVipBar() {
        return this.f928e;
    }

    @Override // e.c.a.g.a.g.j.c.b
    public void onCoverChanged(String str) {
        KGMusicWrapper kGMusicWrapper = this.b;
        KGMusic kgmusic = kGMusicWrapper == null ? null : kGMusicWrapper.getKgmusic();
        if (kgmusic == null) {
            return;
        }
        kgmusic.imgUrl = str;
    }

    @Override // e.c.a.g.a.g.j.c.b
    public void onMetaDataChanged(KGMusicWrapper kGMusicWrapper) {
        this.b = kGMusicWrapper;
    }

    @Override // e.c.a.g.a.g.j.c.b
    public void onPlayStateChanged(boolean z) {
        this.c = z;
    }

    @Override // e.c.a.g.a.g.j.c.b
    public void setResume(boolean z) {
        this.f927d = z;
    }

    @Override // e.c.a.g.a.g.j.c.b
    public void setShowingVipBar(boolean z) {
        this.f928e = z;
    }
}
