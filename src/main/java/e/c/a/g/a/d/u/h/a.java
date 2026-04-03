package e.c.a.g.a.d.u.h;

import android.app.Service;
import android.content.Context;
import android.text.TextUtils;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.u.c;
import e.c.a.g.a.d.x.f;
import qihoo.sdk.QWatch;
import qihoo.sdk.widget.WidgetPlayer;

/* JADX INFO: loaded from: classes.dex */
public class a implements c {
    public WidgetPlayer a;
    public boolean b;

    @Override // e.c.a.g.a.d.u.c
    public void cancel(Context context) {
        WidgetPlayer widgetPlayer = this.a;
        if (widgetPlayer != null) {
            widgetPlayer.releaseFocus();
        }
    }

    @Override // e.c.a.g.a.d.u.c
    public void init() {
        QWatch.init(KGApplication.getContext());
    }

    @Override // e.c.a.g.a.d.u.c
    public void showNotification(Context context) {
        if (this.a != null) {
            if (!f.q()) {
                this.a.updatePlayState(false);
                return;
            }
            KGMusicWrapper currentSong = e.c.a.g.a.d.x.b.b().getCurrentSong();
            if (currentSong != null) {
                String displayName = currentSong.getDisplayName();
                if (TextUtils.isEmpty(displayName)) {
                    displayName = context.getString(R.string.noti_title);
                }
                this.a.updateCurrentPosition(e.c.a.g.a.d.x.b.b().getCurrentPosition());
                this.a.updateTitle(displayName);
                this.a.updateTotalTime((int) currentSong.getDuration());
            }
            this.a.updatePlayState(true);
        }
    }

    @Override // e.c.a.g.a.d.u.c
    public void startNotification(Service service) {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a = QWatch.requestPlayerFocus(new b());
        showNotification(service);
    }
}
