package e.c.a.g.a.d.r;

import android.app.Activity;
import com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity;

/* JADX INFO: loaded from: classes.dex */
public interface e {
    e attachActivity(AbsFrameworkActivity absFrameworkActivity);

    void finish();

    void finishInMainThread();

    Activity getActivity();

    void onCreate();

    void onDestroy();
}
