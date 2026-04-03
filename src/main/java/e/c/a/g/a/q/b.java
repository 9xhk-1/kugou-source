package e.c.a.g.a.q;

import android.app.Activity;
import androidx.appcompat.widget.ActivityChooserModel;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.apm.task.ShareSongAPM;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Activity activity) {
        super(activity);
        j.e(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // e.c.a.g.a.q.d
    public boolean isShareEnable() {
        return false;
    }

    @Override // e.c.a.g.a.q.d
    public void share(KGMusicWrapper kGMusicWrapper, ShareSongAPM shareSongAPM) {
        j.e(kGMusicWrapper, "current");
        j.e(shareSongAPM, "shareSongAPM");
    }
}
