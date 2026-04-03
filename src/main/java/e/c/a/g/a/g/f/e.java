package e.c.a.g.a.g.f;

import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.AbsBaseFragment;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.s.p1;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static long a = -1;

    public static void a(AbsBaseFragment absBaseFragment) {
        KGMusicWrapper kGMusicWrapperE;
        if (absBaseFragment == null || a <= 0 || (kGMusicWrapperE = e.c.a.g.a.d.x.f.e()) == null || kGMusicWrapperE.getMixId() != a || kGMusicWrapperE.getKgmusic() == null) {
            return;
        }
        a = -1L;
        if (e.c.a.g.a.f.j.c.b.g() && e.c.a.g.a.f.j.c.b.k(kGMusicWrapperE.getTrackName())) {
            p1.h(KGApplication.getContext(), "收藏失败！该歌曲在当前设备端暂不支持收藏操作");
        } else {
            g.k().h(1, absBaseFragment.m(), kGMusicWrapperE.getKgmusic(), "", absBaseFragment.l());
        }
    }

    public static void b(long j) {
        a = j;
    }
}
