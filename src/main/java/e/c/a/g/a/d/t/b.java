package e.c.a.g.a.d.t;

import com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    void attach(ViewPagerFrameworkDelegate viewPagerFrameworkDelegate, c cVar, a aVar);

    void destory();

    void executeNavChanged();

    c getNavigationBar();

    void recordChangeAfter();

    void recordChangeBefore();
}
