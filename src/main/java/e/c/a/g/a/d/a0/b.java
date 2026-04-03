package e.c.a.g.a.d.a0;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.kugou.android.watch.lite.base.swipeback.SwipeBackLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class b implements SwipeBackLayout.b {
    public final WeakReference<Activity> a;

    public b(@NonNull Activity activity) {
        this.a = new WeakReference<>(activity);
    }

    @Override // com.kugou.android.watch.lite.base.swipeback.SwipeBackLayout.b
    public void onEdgeTouch(int i2) {
        Activity activity = this.a.get();
        if (activity != null) {
            c.a(activity);
        }
    }

    @Override // com.kugou.android.watch.lite.base.swipeback.SwipeBackLayout.b
    public void onScroll(float f2) {
    }

    @Override // com.kugou.android.watch.lite.base.swipeback.SwipeBackLayout.b
    public void onScrollOverThreshold() {
    }

    @Override // com.kugou.android.watch.lite.base.swipeback.SwipeBackLayout.b
    public void onScrollStateChange(int i2, float f2) {
    }
}
