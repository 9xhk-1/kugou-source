package e.c.a.g.a.g.j.c;

import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    void changeBaseAndHostType(DelegateFragment delegateFragment, int i2);

    @Nullable
    KGMusicWrapper getCur();

    DelegateFragment getFragment();

    boolean isPlaying();

    boolean isQueueEmpty();

    boolean isResume();

    boolean isShowingVipBar();

    void onCoverChanged(@Nullable String str);

    void onMetaDataChanged(KGMusicWrapper kGMusicWrapper);

    void onPlayStateChanged(boolean z);

    void setResume(boolean z);

    void setShowingVipBar(boolean z);
}
