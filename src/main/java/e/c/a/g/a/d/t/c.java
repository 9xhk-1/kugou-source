package e.c.a.g.a.d.t;

import android.content.Context;
import android.view.View;
import com.kugou.android.watch.lite.base.activity.AbsBaseActivity;

/* JADX INFO: loaded from: classes.dex */
public interface c {
    void attachActivity(AbsBaseActivity absBaseActivity);

    void destory();

    View getView();

    void hideNavigationBar(boolean z);

    void hideSecondaryButton(boolean z);

    void init(Context context);

    void onAvatarChanged(String str);

    void onMetaChanged();

    void onPlayStateChanged();

    void onViewAdded();

    void showNavigationBar(boolean z);

    void showSecondaryButton(boolean z);
}
