package com.kugou.uilib.widget.recyclerview.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.kugou.uilib.R;
import com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PullToRefreshAdapterViewBase<T extends AbsListView> extends KGUIPullToRefreshBase<T> implements AbsListView.OnScrollListener {
    private View mEmptyView;
    private boolean mFirstItemVisible;
    private IndicatorLayout mIndicatorIvBottom;
    private IndicatorLayout mIndicatorIvTop;
    private boolean mLastItemVisible;
    private KGUIPullToRefreshBase.OnFirstItemVisibleListener mOnFirstItemVisibleListener;
    private KGUIPullToRefreshBase.OnLastItemVisibleListener mOnLastItemVisibleListener;
    public AbsListView.OnScrollListener mOnScrollListener;
    private boolean mScrollEmptyView;
    private boolean mShowIndicator;

    /* JADX INFO: renamed from: com.kugou.uilib.widget.recyclerview.pulltorefresh.PullToRefreshAdapterViewBase$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode = iArr;
            try {
                iArr[Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PullToRefreshAdapterViewBase(Context context) {
        super(context);
        this.mShowIndicator = false;
        this.mScrollEmptyView = true;
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    private void addIndicatorViews() {
        IndicatorLayout indicatorLayout;
        IndicatorLayout indicatorLayout2;
        Mode mode = getMode();
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (mode.showHeaderLoadingLayout() && this.mIndicatorIvTop == null) {
            this.mIndicatorIvTop = new IndicatorLayout(getContext(), Mode.PULL_FROM_START);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.kg_pulltorefresh_indicator_right_padding);
            layoutParams.gravity = 53;
            refreshableViewWrapper.addView(this.mIndicatorIvTop, layoutParams);
        } else if (!mode.showHeaderLoadingLayout() && (indicatorLayout = this.mIndicatorIvTop) != null) {
            refreshableViewWrapper.removeView(indicatorLayout);
            this.mIndicatorIvTop = null;
        }
        if (mode.showFooterLoadingLayout() && this.mIndicatorIvBottom == null) {
            this.mIndicatorIvBottom = new IndicatorLayout(getContext(), Mode.PULL_FROM_END);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.rightMargin = getResources().getDimensionPixelSize(R.dimen.kg_pulltorefresh_indicator_right_padding);
            layoutParams2.gravity = 85;
            refreshableViewWrapper.addView(this.mIndicatorIvBottom, layoutParams2);
            return;
        }
        if (mode.showFooterLoadingLayout() || (indicatorLayout2 = this.mIndicatorIvBottom) == null) {
            return;
        }
        refreshableViewWrapper.removeView(indicatorLayout2);
        this.mIndicatorIvBottom = null;
    }

    private static FrameLayout.LayoutParams convertEmptyViewLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            layoutParams2.gravity = ((LinearLayout.LayoutParams) layoutParams).gravity;
            return layoutParams2;
        }
        layoutParams2.gravity = 17;
        return layoutParams2;
    }

    private boolean getShowIndicatorInternal() {
        return this.mShowIndicator && isPullToRefreshEnabled();
    }

    private boolean isFirstItemVisible() {
        View childAt;
        if (((AbsListView) this.mRefreshableView).getFirstVisiblePosition() > 1 || (childAt = ((AbsListView) this.mRefreshableView).getChildAt(0)) == null) {
            return false;
        }
        return !(((AbsListView) this.mRefreshableView).getFirstVisiblePosition() == 1 && childAt.getTop() == ((AbsListView) this.mRefreshableView).getTop()) && childAt.getTop() >= ((AbsListView) this.mRefreshableView).getTop();
    }

    private boolean isLastItemVisible() {
        Adapter adapter = ((AbsListView) this.mRefreshableView).getAdapter();
        if (adapter == null || adapter.getCount() == 0) {
            Log.d(KGUIPullToRefreshBase.LOG_TAG, "isLastItemVisible. Empty View.");
            return true;
        }
        int count = ((AbsListView) this.mRefreshableView).getCount() - 1;
        int lastVisiblePosition = ((AbsListView) this.mRefreshableView).getLastVisiblePosition();
        Log.d(KGUIPullToRefreshBase.LOG_TAG, "isLastItemVisible. Last Item Position: " + count + " Last Visible Pos: " + lastVisiblePosition);
        if (lastVisiblePosition >= count - 1) {
            View childAt = ((AbsListView) this.mRefreshableView).getChildAt(lastVisiblePosition - ((AbsListView) this.mRefreshableView).getFirstVisiblePosition());
            return childAt != null && childAt.getBottom() <= ((AbsListView) this.mRefreshableView).getBottom();
        }
        return false;
    }

    private void removeIndicatorViews() {
        if (this.mIndicatorIvTop != null) {
            getRefreshableViewWrapper().removeView(this.mIndicatorIvTop);
            this.mIndicatorIvTop = null;
        }
        if (this.mIndicatorIvBottom != null) {
            getRefreshableViewWrapper().removeView(this.mIndicatorIvBottom);
            this.mIndicatorIvBottom = null;
        }
    }

    private void updateIndicatorViewsVisibility() {
        if (this.mIndicatorIvTop != null) {
            if (isRefreshing() || !isReadyForPullStart()) {
                if (this.mIndicatorIvTop.isVisible()) {
                    this.mIndicatorIvTop.hide();
                }
            } else if (!this.mIndicatorIvTop.isVisible()) {
                this.mIndicatorIvTop.show();
            }
        }
        if (this.mIndicatorIvBottom != null) {
            if (isRefreshing() || !isReadyForPullEnd()) {
                if (this.mIndicatorIvBottom.isVisible()) {
                    this.mIndicatorIvBottom.hide();
                }
            } else {
                if (this.mIndicatorIvBottom.isVisible()) {
                    return;
                }
                this.mIndicatorIvBottom.show();
            }
        }
    }

    public boolean getShowIndicator() {
        return this.mShowIndicator;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public void handleStyledAttributes(TypedArray typedArray) {
        this.mShowIndicator = typedArray.getBoolean(R.styleable.KGUIPullToRefreshBase_kgui_ptrShowIndicator, false);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public boolean isReadyForPullEnd() {
        return isLastItemVisible();
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public boolean isReadyForPullStart() {
        return isFirstItemVisible();
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public void onPullToRefresh() {
        super.onPullToRefresh();
        if (getShowIndicatorInternal()) {
            int i2 = AnonymousClass1.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[getCurrentMode().ordinal()];
            if (i2 == 1) {
                this.mIndicatorIvBottom.pullToRefresh();
            } else {
                if (i2 != 2) {
                    return;
                }
                this.mIndicatorIvTop.pullToRefresh();
            }
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public void onRefreshing(boolean z) {
        super.onRefreshing(z);
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public void onReleaseToRefresh() {
        super.onReleaseToRefresh();
        if (getShowIndicatorInternal()) {
            int i2 = AnonymousClass1.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[getCurrentMode().ordinal()];
            if (i2 == 1) {
                this.mIndicatorIvBottom.releaseToRefresh();
            } else {
                if (i2 != 2) {
                    return;
                }
                this.mIndicatorIvTop.releaseToRefresh();
            }
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public void onReset() {
        super.onReset();
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Log.d(KGUIPullToRefreshBase.LOG_TAG, "First Visible: " + i2 + ". Visible Count: " + i3 + ". Total Items:" + i4);
        if (this.mOnLastItemVisibleListener != null) {
            this.mLastItemVisible = i4 > 0 && i2 + i3 >= i4 + (-1);
        }
        if (this.mOnFirstItemVisibleListener != null) {
            this.mFirstItemVisible = i2 == 0;
        }
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        View view = this.mEmptyView;
        if (view == null || this.mScrollEmptyView) {
            return;
        }
        view.scrollTo(-i2, -i3);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        KGUIPullToRefreshBase.OnFirstItemVisibleListener onFirstItemVisibleListener;
        KGUIPullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener;
        if (i2 == 0 && (onLastItemVisibleListener = this.mOnLastItemVisibleListener) != null && this.mLastItemVisible) {
            onLastItemVisibleListener.onLastItemVisible();
        }
        if (i2 == 0 && (onFirstItemVisibleListener = this.mOnFirstItemVisibleListener) != null && this.mFirstItemVisible) {
            onFirstItemVisibleListener.onFirstItemVisible();
        }
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i2);
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        ((AdapterView) this.mRefreshableView).setAdapter(listAdapter);
    }

    public final void setEmptyView(View view) {
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (view != null) {
            view.setClickable(true);
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(view);
            }
            FrameLayout.LayoutParams layoutParamsConvertEmptyViewLayoutParams = convertEmptyViewLayoutParams(view.getLayoutParams());
            if (layoutParamsConvertEmptyViewLayoutParams != null) {
                refreshableViewWrapper.addView(view, layoutParamsConvertEmptyViewLayoutParams);
            } else {
                refreshableViewWrapper.addView(view);
            }
        }
        T t = this.mRefreshableView;
        if (t instanceof EmptyViewMethodAccessor) {
            ((EmptyViewMethodAccessor) t).setEmptyViewInternal(view);
        } else {
            ((AbsListView) t).setEmptyView(view);
        }
        this.mEmptyView = view;
    }

    public final void setOnFirstItemVisibleListener(KGUIPullToRefreshBase.OnFirstItemVisibleListener onFirstItemVisibleListener) {
        this.mOnFirstItemVisibleListener = onFirstItemVisibleListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        ((AbsListView) this.mRefreshableView).setOnItemClickListener(onItemClickListener);
    }

    public final void setOnLastItemVisibleListener(KGUIPullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener) {
        this.mOnLastItemVisibleListener = onLastItemVisibleListener;
    }

    public final void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    public final void setScrollEmptyView(boolean z) {
        this.mScrollEmptyView = z;
    }

    public void setSelection(int i2) {
        ((AbsListView) this.mRefreshableView).setSelection(i2);
    }

    public void setShowIndicator(boolean z) {
        this.mShowIndicator = z;
        if (getShowIndicatorInternal()) {
            addIndicatorViews();
        } else {
            removeIndicatorViews();
        }
    }

    public void smoothScrollToPositionFromTop(int i2, int i3, int i4) {
        ((AbsListView) this.mRefreshableView).smoothScrollToPositionFromTop(i2, i3, i4);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public void updateUIForMode() {
        super.updateUIForMode();
        if (getShowIndicatorInternal()) {
            addIndicatorViews();
        } else {
            removeIndicatorViews();
        }
    }

    public PullToRefreshAdapterViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mShowIndicator = false;
        this.mScrollEmptyView = true;
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, Mode mode) {
        super(context, mode);
        this.mShowIndicator = false;
        this.mScrollEmptyView = true;
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
        this.mShowIndicator = false;
        this.mScrollEmptyView = true;
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }
}
