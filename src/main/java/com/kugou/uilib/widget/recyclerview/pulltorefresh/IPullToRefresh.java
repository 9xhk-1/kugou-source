package com.kugou.uilib.widget.recyclerview.pulltorefresh;

import android.view.View;
import android.view.animation.Interpolator;
import com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IPullToRefresh<T extends View> {
    boolean demo();

    Mode getCurrentMode();

    boolean getFilterTouchEvents();

    ILoadingLayout getLoadingLayoutProxy();

    ILoadingLayout getLoadingLayoutProxy(boolean z, boolean z2);

    Mode getMode();

    T getRefreshableView();

    boolean getShowViewWhileRefreshing();

    State getState();

    boolean isPullToRefreshEnabled();

    boolean isPullToRefreshOverScrollEnabled();

    boolean isRefreshing();

    boolean isScrollingWhileRefreshingEnabled();

    void onRefreshComplete();

    void setFilterTouchEvents(boolean z);

    void setMode(Mode mode);

    void setOnPullEventListener(KGUIPullToRefreshBase.OnPullEventListener<T> onPullEventListener);

    void setOnRefreshListener(KGUIPullToRefreshBase.OnRefreshListener2<T> onRefreshListener2);

    void setOnRefreshListener(KGUIPullToRefreshBase.OnRefreshListener<T> onRefreshListener);

    void setPullToRefreshOverScrollEnabled(boolean z);

    void setRefreshing();

    void setRefreshing(boolean z);

    void setScrollAnimationInterpolator(Interpolator interpolator);

    void setScrollingWhileRefreshingEnabled(boolean z);

    void setShowViewWhileRefreshing(boolean z);
}
