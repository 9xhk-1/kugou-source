package com.kugou.uilib.widget.recyclerview.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase;

/* JADX INFO: loaded from: classes2.dex */
public abstract class KGUIPullToRefreshBase2<T extends View> extends KGUIPullToRefreshBase<T> {
    private boolean justScrollable;
    private View mPinnedHeader;
    private OnStateChangeListener onStateChangeListener;
    private ViewCreator viewCreator;

    /* JADX INFO: renamed from: com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase2$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode;
        public static final /* synthetic */ int[] $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation;
        public static final /* synthetic */ int[] $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$State;

        static {
            int[] iArr = new int[Orientation.values().length];
            $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation = iArr;
            try {
                iArr[Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation[Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Mode.values().length];
            $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode = iArr2;
            try {
                iArr2[Mode.MANUAL_REFRESH_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[Mode.PULL_FROM_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[Mode.PULL_FROM_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[State.values().length];
            $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$State = iArr3;
            try {
                iArr3[State.SHOW_PINNED_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$State[State.RELEASE_TO_SHOW_PINNED_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public interface OnStateChangeListener {
        void onPinnedHeaderClose();

        void onPinnedHeaderOpen();

        void onPinnedHeaderTrigger();
    }

    public interface ViewCreator {
        View createView(KGUIPullToRefreshBase2 kGUIPullToRefreshBase2);
    }

    public KGUIPullToRefreshBase2(Context context) {
        super(context);
        this.onStateChangeListener = null;
        this.viewCreator = null;
        this.mPinnedHeader = null;
        this.justScrollable = false;
    }

    private boolean isPinnedHeaderAvailable() {
        return this.mPinnedHeader != null;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public void baseDispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
            if (motionEvent.getAction() == 0) {
                this.isTouch = true;
                return;
            }
            return;
        }
        State state = this.mState;
        if (state == State.RELEASE_TO_REFRESH && (this.mOnRefreshListener != null || this.mOnRefreshListener2 != null)) {
            setState(State.REFRESHING, Boolean.TRUE);
        } else if (state == State.RELEASE_TO_SHOW_PINNED_HEADER && (isPinnedHeaderAvailable() || this.justScrollable)) {
            setState(State.SHOW_PINNED_HEADER, Boolean.TRUE);
        } else if (isRefreshing()) {
            smoothScrollTo(0);
        } else if (this.mState != State.SHOW_PINNED_HEADER || (!isPinnedHeaderAvailable() && !this.justScrollable)) {
            setState(State.RESET);
        }
        this.isTouch = false;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public void callRefreshListener() {
        KGUIPullToRefreshBase.OnRefreshListener<T> onRefreshListener = this.mOnRefreshListener;
        if (onRefreshListener != null) {
            onRefreshListener.onRefresh(this);
            return;
        }
        KGUIPullToRefreshBase.OnRefreshListener2<T> onRefreshListener2 = this.mOnRefreshListener2;
        if (onRefreshListener2 != null) {
            Mode mode = this.mCurrentMode;
            if (mode == Mode.PULL_FROM_START && this.mState != State.SHOW_PINNED_HEADER) {
                if (onRefreshListener2.onPullDownToRefresh(this)) {
                    return;
                }
                onRefreshComplete();
            } else if (mode != Mode.PULL_FROM_END) {
                onRefreshComplete();
            } else {
                if (onRefreshListener2.onPullUpToRefresh(this)) {
                    return;
                }
                onRefreshComplete();
            }
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public int getHeaderVerticalTopPadding() {
        initPinnedHeaderHeight();
        return super.getHeaderVerticalTopPadding() - getPinnedHeaderHeight();
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public int getMaximumPullScroll() {
        return this.mRefreshableView.getMeasuredHeight();
    }

    public int getPinnedHeaderHeight() {
        if (this.viewCreator == null) {
            return 0;
        }
        return getHeight();
    }

    public void hidePinnedHeader() {
        setState(State.RESET);
        OnStateChangeListener onStateChangeListener = this.onStateChangeListener;
        if (onStateChangeListener != null) {
            onStateChangeListener.onPinnedHeaderClose();
        }
    }

    public void initPinnedHeaderHeight() {
        ViewCreator viewCreator;
        if (isPinnedHeaderAvailable() || (viewCreator = this.viewCreator) == null) {
            return;
        }
        this.mPinnedHeader = viewCreator.createView(this);
        addViewInternal(this.mPinnedHeader, 0, new LinearLayout.LayoutParams(-1, getPinnedHeaderHeight()));
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (!isPullToRefreshEnabled()) {
            return false;
        }
        if (!this.mScrollingWhileRefreshingEnabled && isRefreshing()) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mIsBeingDragged = false;
            return false;
        }
        if (action != 0 && this.mIsBeingDragged) {
            return true;
        }
        if (action != 0) {
            if (action == 2 && isReadyForPull()) {
                float y = motionEvent.getY();
                float x = motionEvent.getX();
                if (AnonymousClass2.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation[getPullToRefreshScrollDirection().ordinal()] != 1) {
                    f2 = y - this.mLastMotionY;
                    f3 = x - this.mLastMotionX;
                } else {
                    f2 = x - this.mLastMotionX;
                    f3 = y - this.mLastMotionY;
                }
                float fAbs = Math.abs(f2);
                if (fAbs > this.mTouchSlop && (!this.mFilterTouchEvents || fAbs > Math.abs(f3))) {
                    if (this.mMode.showHeaderLoadingLayout() && f2 >= 1.0f && isReadyForPullStart()) {
                        this.mLastMotionY = y;
                        this.mLastMotionX = x;
                        this.mIsBeingDragged = true;
                        if (this.mMode == Mode.BOTH) {
                            this.mCurrentMode = Mode.PULL_FROM_START;
                        }
                    } else if (this.mMode.showFooterLoadingLayout() && f2 <= -1.0f && isReadyForPullEnd()) {
                        this.mLastMotionY = y;
                        this.mLastMotionX = x;
                        this.mIsBeingDragged = true;
                        if (this.mMode == Mode.BOTH) {
                            this.mCurrentMode = Mode.PULL_FROM_END;
                        }
                    } else if (this.mState == State.SHOW_PINNED_HEADER && f2 <= -1.0f) {
                        this.mLastMotionY = y;
                        this.mLastMotionX = x;
                        this.mIsBeingDragged = true;
                    }
                }
            }
        } else if (isReadyForPull()) {
            float y2 = motionEvent.getY();
            this.mInitialMotionY = y2;
            this.mLastMotionY = y2;
            float x2 = motionEvent.getX();
            this.mInitialMotionX = x2;
            this.mLastMotionX = x2;
            this.mIsBeingDragged = false;
        }
        return this.mIsBeingDragged;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public void onRefreshing(boolean z) {
        if (this.mMode.showHeaderLoadingLayout()) {
            this.mHeaderLayout.refreshing();
        }
        if (this.mMode.showFooterLoadingLayout()) {
            this.mFooterLayout.refreshing();
        }
        if (!z) {
            callRefreshListener();
            return;
        }
        if (!this.mShowViewWhileRefreshing) {
            smoothScrollTo(0);
            return;
        }
        KGUIPullToRefreshBase.OnSmoothScrollFinishedListener onSmoothScrollFinishedListener = new KGUIPullToRefreshBase.OnSmoothScrollFinishedListener() { // from class: com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase2.1
            @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase.OnSmoothScrollFinishedListener
            public void onSmoothScrollFinished() {
                KGUIPullToRefreshBase2.this.callRefreshListener();
            }
        };
        int i2 = AnonymousClass2.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[this.mCurrentMode.ordinal()];
        if (i2 == 1 || i2 == 2) {
            smoothScrollTo(getFooterSize(), onSmoothScrollFinishedListener);
            return;
        }
        if (i2 != 3) {
            onRefreshComplete();
            return;
        }
        State state = this.mState;
        if (state == State.REFRESHING || state == State.MANUAL_REFRESHING) {
            smoothScrollTo(-getHeaderSize(), onSmoothScrollFinishedListener);
        } else {
            smoothScrollTo(-this.mRefreshableView.getMeasuredHeight(), onSmoothScrollFinishedListener);
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public void onSetStateDefault(State state, Boolean bool) {
        OnStateChangeListener onStateChangeListener;
        if (isPinnedHeaderAvailable() || this.justScrollable) {
            int i2 = AnonymousClass2.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$State[state.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 && (onStateChangeListener = this.onStateChangeListener) != null) {
                    onStateChangeListener.onPinnedHeaderTrigger();
                    return;
                }
                return;
            }
            onShowPinnedHeader();
            OnStateChangeListener onStateChangeListener2 = this.onStateChangeListener;
            if (onStateChangeListener2 != null) {
                onStateChangeListener2.onPinnedHeaderOpen();
            }
        }
    }

    public void onShowPinnedHeader() {
        onRefreshing(true);
        ILoadingLayout iLoadingLayout = this.mFooterLayout;
        if (iLoadingLayout != null) {
            iLoadingLayout.reset();
        }
        ILoadingLayout iLoadingLayout2 = this.mHeaderLayout;
        if (iLoadingLayout2 != null) {
            iLoadingLayout2.reset();
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public void pullEvent(float f2) {
        int iRound;
        int footerSize;
        if (this.mState == State.SHOW_PINNED_HEADER) {
            if (f2 > 0.0f) {
                setState(State.RESET);
                OnStateChangeListener onStateChangeListener = this.onStateChangeListener;
                if (onStateChangeListener != null) {
                    onStateChangeListener.onPinnedHeaderClose();
                    return;
                }
                return;
            }
            return;
        }
        int[] iArr = AnonymousClass2.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode;
        if (iArr[this.mCurrentMode.ordinal()] != 2) {
            iRound = Math.round(Math.min(f2, 0.0f) / this.mFriction);
            footerSize = getHeaderSize();
        } else {
            iRound = Math.round(Math.max(f2, 0.0f) / this.mFriction);
            footerSize = getFooterSize();
        }
        setHeaderScroll(iRound);
        if (iRound == 0 || isRefreshing() || footerSize == 0) {
            return;
        }
        float fAbs = Math.abs(iRound) / footerSize;
        if (iArr[this.mCurrentMode.ordinal()] != 2) {
            this.mHeaderLayout.onPull(fAbs);
        } else {
            this.mFooterLayout.onPull(fAbs);
        }
        State state = this.mState;
        State state2 = State.PULL_TO_REFRESH;
        if (state != state2 && footerSize >= Math.abs(iRound)) {
            setState(state2);
            return;
        }
        if (this.mState == state2 && footerSize < Math.abs(iRound)) {
            setState(State.RELEASE_TO_REFRESH);
            return;
        }
        if (this.mState != State.RELEASE_TO_REFRESH || footerSize * 2 >= Math.abs(iRound)) {
            return;
        }
        if (isPinnedHeaderAvailable() || this.justScrollable) {
            setState(State.RELEASE_TO_SHOW_PINNED_HEADER);
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public void setHeaderScroll(int i2) {
        super.setHeaderScroll(i2);
        if (this.mLayoutVisibilityChangesEnabled) {
            if (isPinnedHeaderAvailable() || this.justScrollable) {
                if (this.mState == State.SHOW_PINNED_HEADER) {
                    this.mHeaderLayout.getContentView().setVisibility(8);
                    this.mFooterLayout.getContentView().setVisibility(8);
                } else {
                    this.mHeaderLayout.getContentView().setVisibility(0);
                    this.mFooterLayout.getContentView().setVisibility(0);
                }
            }
        }
    }

    public void setJustScrollable(boolean z) {
        this.justScrollable = z;
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.onStateChangeListener = onStateChangeListener;
    }

    public void setViewCreator(ViewCreator viewCreator) {
        this.viewCreator = viewCreator;
    }

    public KGUIPullToRefreshBase2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onStateChangeListener = null;
        this.viewCreator = null;
        this.mPinnedHeader = null;
        this.justScrollable = false;
    }

    public KGUIPullToRefreshBase2(Context context, Mode mode) {
        super(context, mode);
        this.onStateChangeListener = null;
        this.viewCreator = null;
        this.mPinnedHeader = null;
        this.justScrollable = false;
    }

    public KGUIPullToRefreshBase2(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
        this.onStateChangeListener = null;
        this.viewCreator = null;
        this.mPinnedHeader = null;
        this.justScrollable = false;
    }
}
