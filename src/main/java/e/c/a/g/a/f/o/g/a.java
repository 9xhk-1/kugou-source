package e.c.a.g.a.f.o.g;

import com.kugou.android.watch.lite.common.widget.loading.CommonLoadingView;
import e.c.a.g.a.f.o.g.c;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    void attachView(CommonLoadingView commonLoadingView);

    void cancelTimer();

    boolean checkLocation();

    void setTimeSpec(int i2);

    void setTimerCallback(c.e eVar);

    void startAnim();

    void startAnimWithTimer();

    void startTimer();

    void stopAnim();
}
