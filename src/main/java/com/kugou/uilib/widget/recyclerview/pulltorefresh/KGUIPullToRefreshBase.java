package com.kugou.uilib.widget.recyclerview.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingParent2;
import com.kugou.uilib.R;
import com.kugou.uilib.widget.recyclerview.scroll.IScrollableChild;

/* JADX INFO: loaded from: classes2.dex */
public abstract class KGUIPullToRefreshBase<T extends View> extends LinearLayout implements IPullToRefresh<T>, NestedScrollingParent2 {
    public static final boolean DEBUG = true;
    public static final int DEMO_SCROLL_INTERVAL = 225;
    public static final float FRICTION_DEFAULT = 3.0f;
    public static final String LOG_TAG = "PullToRefresh";
    public static final int SMOOTH_SCROLL_DURATION_MS = 200;
    public static final int SMOOTH_SCROLL_LONG_DURATION_MS = 325;
    public static final String STATE_CURRENT_MODE = "ptr_current_mode";
    public static final String STATE_MODE = "ptr_mode";
    public static final String STATE_SCROLLING_REFRESHING_ENABLED = "ptr_disable_scrolling";
    public static final String STATE_SHOW_REFRESHING_VIEW = "ptr_show_refreshing_view";
    public static final String STATE_STATE = "ptr_state";
    public static final String STATE_SUPER = "ptr_super";
    public static final boolean USE_HW_LAYERS = false;
    private boolean isLastActionDragging;
    public boolean isTouch;
    public Mode mCurrentMode;
    private KGUIPullToRefreshBase<T>.SmoothScrollRunnable mCurrentSmoothScrollRunnable;
    public boolean mFilterTouchEvents;
    public ILoadingLayout mFooterLayout;
    public float mFriction;
    public ILoadingLayout mHeaderLayout;
    public float mInitialMotionX;
    public float mInitialMotionY;
    public boolean mIsBeingDragged;
    public float mLastMotionX;
    public float mLastMotionY;
    public boolean mLayoutVisibilityChangesEnabled;
    private AnimationStyle mLoadingAnimationStyle;
    public Mode mMode;
    private OnDraggingListener mOnDraggingListener;
    private OnPullEventListener<T> mOnPullEventListener;
    private OnPullScrollListener mOnPullScrollListener;
    public OnRefreshListener<T> mOnRefreshListener;
    public OnRefreshListener2<T> mOnRefreshListener2;
    private boolean mOverScrollEnabled;
    public T mRefreshableView;
    private FrameLayout mRefreshableViewWrapper;
    private Interpolator mScrollAnimationInterpolator;
    public boolean mScrollingWhileRefreshingEnabled;
    public boolean mShowViewWhileRefreshing;
    public State mState;
    public int mTouchSlop;

    /* JADX INFO: renamed from: com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode;
        public static final /* synthetic */ int[] $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation;
        public static final /* synthetic */ int[] $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$State;

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
            try {
                $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[Mode.MANUAL_REFRESH_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[State.values().length];
            $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$State = iArr2;
            try {
                iArr2[State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$State[State.PULL_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$State[State.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$State[State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$State[State.MANUAL_REFRESHING.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$State[State.OVERSCROLLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr3 = new int[Orientation.values().length];
            $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation = iArr3;
            try {
                iArr3[Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation[Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public interface OnDraggingListener {
        void endDragging();

        void startDragging();
    }

    public interface OnFirstItemVisibleListener {
        void onFirstItemVisible();
    }

    public interface OnLastItemVisibleListener {
        void onLastItemVisible();
    }

    public interface OnPullEventListener<V extends View> {
        void onPullEvent(KGUIPullToRefreshBase<V> kGUIPullToRefreshBase, State state, Mode mode);
    }

    public interface OnPullScrollListener {
        void onHeadScroll(int i2, boolean z);
    }

    public interface OnRefreshListener<V extends View> {
        void onRefresh(KGUIPullToRefreshBase<V> kGUIPullToRefreshBase);
    }

    public interface OnRefreshListener2<V extends View> {
        boolean onPullDownToRefresh(KGUIPullToRefreshBase<V> kGUIPullToRefreshBase);

        boolean onPullUpToRefresh(KGUIPullToRefreshBase<V> kGUIPullToRefreshBase);
    }

    public interface OnSmoothScrollFinishedListener {
        void onSmoothScrollFinished();
    }

    public final class SmoothScrollRunnable implements Runnable {
        private final long mDuration;
        private final Interpolator mInterpolator;
        private OnSmoothScrollFinishedListener mListener;
        private final int mScrollFromY;
        private final int mScrollToY;
        private boolean mContinueRunning = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;

        public SmoothScrollRunnable(int i2, int i3, long j, OnSmoothScrollFinishedListener onSmoothScrollFinishedListener) {
            this.mScrollFromY = i2;
            this.mScrollToY = i3;
            this.mInterpolator = KGUIPullToRefreshBase.this.mScrollAnimationInterpolator;
            this.mDuration = j;
            this.mListener = onSmoothScrollFinishedListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                int iRound = this.mScrollFromY - Math.round((this.mScrollFromY - this.mScrollToY) * this.mInterpolator.getInterpolation(Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L) / 1000.0f));
                this.mCurrentY = iRound;
                KGUIPullToRefreshBase.this.setHeaderScroll(iRound);
            }
            if (this.mContinueRunning && this.mScrollToY != this.mCurrentY) {
                ViewCompat.postOnAnimation(KGUIPullToRefreshBase.this, this);
                return;
            }
            OnSmoothScrollFinishedListener onSmoothScrollFinishedListener = this.mListener;
            if (onSmoothScrollFinishedListener != null) {
                onSmoothScrollFinishedListener.onSmoothScrollFinished();
            }
        }

        public void stop() {
            this.mContinueRunning = false;
            KGUIPullToRefreshBase.this.removeCallbacks(this);
        }
    }

    public KGUIPullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.mFriction = 3.0f;
        this.mState = State.RESET;
        this.mMode = Mode.getDefault();
        this.mShowViewWhileRefreshing = true;
        this.mScrollingWhileRefreshingEnabled = false;
        this.mFilterTouchEvents = true;
        this.mOverScrollEnabled = true;
        this.mLayoutVisibilityChangesEnabled = true;
        this.mLoadingAnimationStyle = AnimationStyle.getDefault();
        this.isLastActionDragging = false;
        init(context, null);
    }

    private void addRefreshableView(Context context, T t) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.mRefreshableViewWrapper = frameLayout;
        frameLayout.addView(t, -1, -1);
        addViewInternal(this.mRefreshableViewWrapper, new LinearLayout.LayoutParams(-1, -1));
    }

    private LinearLayout.LayoutParams getLoadingLayoutLayoutParams(ILoadingLayout iLoadingLayout) {
        return AnonymousClass4.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation[getPullToRefreshScrollDirection().ordinal()] != 1 ? new LinearLayout.LayoutParams(-1, iLoadingLayout.getContentSize()) : new LinearLayout.LayoutParams(iLoadingLayout.getContentSize(), -1);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Drawable drawable;
        if (AnonymousClass4.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation[getPullToRefreshScrollDirection().ordinal()] != 1) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
        setGravity(17);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KGUIPullToRefreshBase);
        int i2 = R.styleable.KGUIPullToRefreshBase_kgui_ptrMode;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            this.mMode = Mode.mapIntToValue(typedArrayObtainStyledAttributes.getInteger(i2, 0));
        }
        int i3 = R.styleable.KGUIPullToRefreshBase_kgui_ptrAnimationStyle;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            this.mLoadingAnimationStyle = AnimationStyle.mapIntToValue(typedArrayObtainStyledAttributes.getInteger(i3, 0));
        }
        T t = (T) createRefreshableView(context, attributeSet);
        this.mRefreshableView = t;
        addRefreshableView(context, t);
        PtrLoadingLayoutFactory ptrLoadingLayoutFactory = null;
        int i4 = R.styleable.KGUIPullToRefreshBase_kgui_ptr_loadingLayout_factory;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            try {
                ptrLoadingLayoutFactory = (PtrLoadingLayoutFactory) Class.forName(typedArrayObtainStyledAttributes.getString(i4)).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception unused) {
                Log.e("z", "找不到所设置的PtrLoadingLayoutFactory子类，将使用默认的DefaultLoadingLayoutFactory");
            }
        }
        if (ptrLoadingLayoutFactory == null) {
            ptrLoadingLayoutFactory = getPtrLoadingLayoutFactory();
        }
        if (ptrLoadingLayoutFactory == null) {
            ptrLoadingLayoutFactory = PtrLoadingLayoutFactory.getDefault();
        }
        ILoadingLayout iLoadingLayoutCreateLoadingLayout = ptrLoadingLayoutFactory.createLoadingLayout(context, Mode.PULL_FROM_START, getPullToRefreshScrollDirection(), typedArrayObtainStyledAttributes, this.mLoadingAnimationStyle);
        this.mHeaderLayout = iLoadingLayoutCreateLoadingLayout;
        iLoadingLayoutCreateLoadingLayout.setVisibility(0);
        this.mFooterLayout = ptrLoadingLayoutFactory.createLoadingLayout(context, Mode.PULL_FROM_END, getPullToRefreshScrollDirection(), typedArrayObtainStyledAttributes, this.mLoadingAnimationStyle);
        this.mHeaderLayout.setVisibility(0);
        int i5 = R.styleable.KGUIPullToRefreshBase_kgui_ptrRefreshableViewBackground;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(i5);
            if (drawable2 != null) {
                this.mRefreshableView.setBackgroundDrawable(drawable2);
            }
        } else {
            int i6 = R.styleable.KGUIPullToRefreshBase_kgui_ptrAdapterViewBackground;
            if (typedArrayObtainStyledAttributes.hasValue(i6) && (drawable = typedArrayObtainStyledAttributes.getDrawable(i6)) != null) {
                this.mRefreshableView.setBackgroundDrawable(drawable);
            }
        }
        int i7 = R.styleable.KGUIPullToRefreshBase_kgui_ptrOverScroll;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            this.mOverScrollEnabled = typedArrayObtainStyledAttributes.getBoolean(i7, true);
        }
        int i8 = R.styleable.KGUIPullToRefreshBase_kgui_ptrScrollingWhileRefreshingEnabled;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            this.mScrollingWhileRefreshingEnabled = typedArrayObtainStyledAttributes.getBoolean(i8, false);
        }
        handleStyledAttributes(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        updateUIForMode();
    }

    private final void smoothScrollToAndBack(int i2) {
        smoothScrollTo(i2, 200L, 0L, new OnSmoothScrollFinishedListener() { // from class: com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase.3
            @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase.OnSmoothScrollFinishedListener
            public void onSmoothScrollFinished() {
                KGUIPullToRefreshBase.this.smoothScrollTo(0, 200L, 225L, null);
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Log.d(LOG_TAG, "addView: " + view.getClass().getSimpleName());
        View refreshableView = getRefreshableView();
        if (!(refreshableView instanceof ViewGroup)) {
            throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
        }
        ((ViewGroup) refreshableView).addView(view, i2, layoutParams);
    }

    public final void addViewInternal(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
    }

    public void baseDispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
            if (motionEvent.getAction() == 0) {
                this.isTouch = true;
                return;
            }
            return;
        }
        if (this.mState == State.RELEASE_TO_REFRESH && (this.mOnRefreshListener != null || this.mOnRefreshListener2 != null)) {
            setState(State.REFRESHING, Boolean.TRUE);
        } else if (isRefreshing()) {
            smoothScrollTo(0);
        } else {
            setState(State.RESET);
        }
        this.isTouch = false;
    }

    public void callRefreshListener() {
        OnRefreshListener<T> onRefreshListener = this.mOnRefreshListener;
        if (onRefreshListener != null) {
            onRefreshListener.onRefresh(this);
            return;
        }
        OnRefreshListener2<T> onRefreshListener2 = this.mOnRefreshListener2;
        if (onRefreshListener2 != null) {
            Mode mode = this.mCurrentMode;
            if (mode == Mode.PULL_FROM_START) {
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

    public void cleanAllOnRefreshListener() {
        this.mOnRefreshListener2 = null;
        this.mOnRefreshListener = null;
    }

    public LoadingLayoutProxy createLoadingLayoutProxy(boolean z, boolean z2) {
        LoadingLayoutProxy loadingLayoutProxy = new LoadingLayoutProxy();
        if (z && this.mMode.showHeaderLoadingLayout()) {
            loadingLayoutProxy.addLayout(this.mHeaderLayout);
        }
        if (z2 && this.mMode.showFooterLoadingLayout()) {
            loadingLayoutProxy.addLayout(this.mFooterLayout);
        }
        return loadingLayoutProxy;
    }

    public abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final boolean demo() {
        if (this.mMode.showHeaderLoadingLayout() && isReadyForPullStart()) {
            smoothScrollToAndBack((-getHeaderSize()) * 2);
            return true;
        }
        if (!this.mMode.showFooterLoadingLayout() || !isReadyForPullEnd()) {
            return false;
        }
        smoothScrollToAndBack(getFooterSize() * 2);
        return true;
    }

    public final void disableLoadingLayoutVisibilityChanges() {
        this.mLayoutVisibilityChangesEnabled = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollingWhileRefreshingEnabled && isRefreshing()) {
            return false;
        }
        baseDispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final Mode getCurrentMode() {
        return this.mCurrentMode;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final boolean getFilterTouchEvents() {
        return this.mFilterTouchEvents;
    }

    public final ILoadingLayout getFooterLayout() {
        return this.mFooterLayout;
    }

    public final int getFooterSize() {
        return this.mFooterLayout.getContentSize();
    }

    public final ILoadingLayout getHeaderLayout() {
        return this.mHeaderLayout;
    }

    public final int getHeaderSize() {
        return this.mHeaderLayout.getContentSize();
    }

    public int getHeaderVerticalTopPadding() {
        return -this.mHeaderLayout.getContentSize();
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final ILoadingLayout getLoadingLayoutProxy() {
        return getLoadingLayoutProxy(true, true);
    }

    public int getMaximumPullScroll() {
        return AnonymousClass4.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation[getPullToRefreshScrollDirection().ordinal()] != 1 ? Math.round(getHeight() / this.mFriction) : Math.round(getWidth() / this.mFriction);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final Mode getMode() {
        return this.mMode;
    }

    public PtrLoadingLayoutFactory getPtrLoadingLayoutFactory() {
        return null;
    }

    public long getPullToRefreshScrollDelay() {
        return 0L;
    }

    public abstract Orientation getPullToRefreshScrollDirection();

    public int getPullToRefreshScrollDuration() {
        return 200;
    }

    public int getPullToRefreshScrollDurationLonger() {
        return SMOOTH_SCROLL_LONG_DURATION_MS;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final T getRefreshableView() {
        return this.mRefreshableView;
    }

    public FrameLayout getRefreshableViewWrapper() {
        return this.mRefreshableViewWrapper;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final boolean getShowViewWhileRefreshing() {
        return this.mShowViewWhileRefreshing;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final State getState() {
        return this.mState;
    }

    public void handleStyledAttributes(TypedArray typedArray) {
    }

    public final boolean isDisableScrollingWhileRefreshing() {
        return !isScrollingWhileRefreshingEnabled();
    }

    public boolean isPullFromStart() {
        return this.mCurrentMode == Mode.PULL_FROM_START;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final boolean isPullToRefreshEnabled() {
        return this.mMode.permitsPullToRefresh();
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final boolean isPullToRefreshOverScrollEnabled() {
        return Build.VERSION.SDK_INT >= 9 && this.mOverScrollEnabled && OverscrollHelper.isAndroidOverScrollEnabled(this.mRefreshableView);
    }

    public boolean isReadyForPull() {
        int i2 = AnonymousClass4.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[this.mMode.ordinal()];
        if (i2 == 1) {
            return isReadyForPullEnd();
        }
        if (i2 == 2) {
            return isReadyForPullStart();
        }
        if (i2 != 4) {
            return false;
        }
        return isReadyForPullEnd() || isReadyForPullStart();
    }

    public abstract boolean isReadyForPullEnd();

    public abstract boolean isReadyForPullStart();

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final boolean isRefreshing() {
        State state = this.mState;
        return state == State.REFRESHING || state == State.MANUAL_REFRESHING;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final boolean isScrollingWhileRefreshingEnabled() {
        return this.mScrollingWhileRefreshingEnabled;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
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
                if (AnonymousClass4.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation[getPullToRefreshScrollDirection().ordinal()] != 1) {
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

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5, int i6) {
        float f2;
        float scrollX;
        float f3;
        if (view instanceof IScrollableChild) {
            boolean zIsScrollAble = ((IScrollableChild) view).isScrollAble(i4, i5);
            if (!this.isTouch || zIsScrollAble) {
                return;
            }
            if (AnonymousClass4.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation[getPullToRefreshScrollDirection().ordinal()] != 1) {
                f2 = i5;
                scrollX = getScrollY();
                f3 = this.mFriction;
            } else {
                f2 = i4;
                scrollX = getScrollX();
                f3 = this.mFriction;
            }
            float f4 = (scrollX * f3) + f2;
            if (this.mMode.showHeaderLoadingLayout() && f2 <= -1.0f && isReadyForPullStart()) {
                this.mIsBeingDragged = true;
                Mode mode = this.mMode;
                if (mode == Mode.BOTH || mode == Mode.PULL_FROM_START) {
                    this.mCurrentMode = Mode.PULL_FROM_START;
                }
            } else if (this.mMode.showFooterLoadingLayout() && f2 >= 1.0f && isReadyForPullEnd()) {
                this.mIsBeingDragged = true;
                Mode mode2 = this.mMode;
                if (mode2 == Mode.BOTH || mode2 == Mode.PULL_FROM_END) {
                    this.mCurrentMode = Mode.PULL_FROM_END;
                }
            }
            pullEvent(f4);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2, int i3) {
    }

    public void onPtrRestoreInstanceState(Bundle bundle) {
    }

    public void onPtrSaveInstanceState(Bundle bundle) {
    }

    public void onPullToRefresh() {
        int i2 = AnonymousClass4.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[this.mCurrentMode.ordinal()];
        if (i2 == 1) {
            this.mFooterLayout.pullToRefresh();
        } else {
            if (i2 != 2) {
                return;
            }
            this.mHeaderLayout.pullToRefresh();
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final void onRefreshComplete() {
        if (isRefreshing()) {
            setState(State.RESET);
        }
    }

    public void onRefreshing() {
        if (isRefreshing()) {
            return;
        }
        setState(State.MANUAL_REFRESHING, Boolean.TRUE);
    }

    public void onReleaseToRefresh() {
        int i2 = AnonymousClass4.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[this.mCurrentMode.ordinal()];
        if (i2 == 1) {
            this.mFooterLayout.releaseToRefresh();
        } else {
            if (i2 != 2) {
                return;
            }
            this.mHeaderLayout.releaseToRefresh();
        }
    }

    public void onReset() {
        this.mIsBeingDragged = false;
        this.mLayoutVisibilityChangesEnabled = true;
        this.mHeaderLayout.reset();
        this.mFooterLayout.reset();
        smoothScrollTo(0, getPullToRefreshScrollDuration(), getPullToRefreshScrollDelay(), null);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        setMode(Mode.mapIntToValue(bundle.getInt(STATE_MODE, 0)));
        this.mCurrentMode = Mode.mapIntToValue(bundle.getInt(STATE_CURRENT_MODE, 0));
        this.mScrollingWhileRefreshingEnabled = bundle.getBoolean(STATE_SCROLLING_REFRESHING_ENABLED, false);
        this.mShowViewWhileRefreshing = bundle.getBoolean(STATE_SHOW_REFRESHING_VIEW, true);
        super.onRestoreInstanceState(bundle.getParcelable(STATE_SUPER));
        State stateMapIntToValue = State.mapIntToValue(bundle.getInt(STATE_STATE, 0));
        if (stateMapIntToValue == State.REFRESHING || stateMapIntToValue == State.MANUAL_REFRESHING) {
            setState(stateMapIntToValue, Boolean.TRUE);
        }
        onPtrRestoreInstanceState(bundle);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        onPtrSaveInstanceState(bundle);
        bundle.putInt(STATE_STATE, this.mState.getIntValue());
        bundle.putInt(STATE_MODE, this.mMode.getIntValue());
        bundle.putInt(STATE_CURRENT_MODE, this.mCurrentMode.getIntValue());
        bundle.putBoolean(STATE_SCROLLING_REFRESHING_ENABLED, this.mScrollingWhileRefreshingEnabled);
        bundle.putBoolean(STATE_SHOW_REFRESHING_VIEW, this.mShowViewWhileRefreshing);
        bundle.putParcelable(STATE_SUPER, super.onSaveInstanceState());
        return bundle;
    }

    public void onSetStateDefault(State state, Boolean bool) {
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        refreshLoadingViewsSize();
        refreshRefreshableViewSize(i2, i3);
        post(new Runnable() { // from class: com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                KGUIPullToRefreshBase.this.requestLayout();
            }
        });
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2, int i3) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase$OnDraggingListener r0 = r5.mOnDraggingListener
            r1 = 3
            r2 = 2
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L31
            int r0 = r6.getAction()
            if (r0 != r2) goto L1e
            boolean r0 = r5.mIsBeingDragged
            if (r0 == 0) goto L31
            boolean r0 = r5.isLastActionDragging
            if (r0 != 0) goto L31
            com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase$OnDraggingListener r0 = r5.mOnDraggingListener
            r0.startDragging()
            r5.isLastActionDragging = r4
            goto L31
        L1e:
            int r0 = r6.getAction()
            if (r0 == r4) goto L2a
            int r0 = r6.getAction()
            if (r0 != r1) goto L31
        L2a:
            com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase$OnDraggingListener r0 = r5.mOnDraggingListener
            r0.endDragging()
            r5.isLastActionDragging = r3
        L31:
            boolean r0 = r5.isPullToRefreshEnabled()
            if (r0 != 0) goto L38
            return r3
        L38:
            boolean r0 = r5.mScrollingWhileRefreshingEnabled
            if (r0 != 0) goto L43
            boolean r0 = r5.isRefreshing()
            if (r0 == 0) goto L43
            return r4
        L43:
            int r0 = r6.getAction()
            if (r0 != 0) goto L50
            int r0 = r6.getEdgeFlags()
            if (r0 == 0) goto L50
            return r3
        L50:
            int r0 = r6.getAction()
            if (r0 == 0) goto L94
            if (r0 == r4) goto L8d
            if (r0 == r2) goto L5d
            if (r0 == r1) goto L8d
            goto Lab
        L5d:
            boolean r0 = r5.mIsBeingDragged
            if (r0 == 0) goto Lab
            float r0 = r6.getY()
            r5.mLastMotionY = r0
            float r6 = r6.getX()
            r5.mLastMotionX = r6
            int[] r6 = com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase.AnonymousClass4.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation
            com.kugou.uilib.widget.recyclerview.pulltorefresh.Orientation r0 = r5.getPullToRefreshScrollDirection()
            int r0 = r0.ordinal()
            r6 = r6[r0]
            if (r6 == r4) goto L84
            float r6 = r5.mInitialMotionY
            float r0 = r5.mLastMotionY
            float r6 = r6 - r0
            r5.pullEvent(r6)
            goto L8c
        L84:
            float r6 = r5.mInitialMotionX
            float r0 = r5.mLastMotionX
            float r6 = r6 - r0
            r5.pullEvent(r6)
        L8c:
            return r4
        L8d:
            boolean r6 = r5.mIsBeingDragged
            if (r6 == 0) goto Lab
            r5.mIsBeingDragged = r3
            return r4
        L94:
            boolean r0 = r5.isReadyForPull()
            if (r0 == 0) goto Lab
            float r0 = r6.getY()
            r5.mInitialMotionY = r0
            r5.mLastMotionY = r0
            float r6 = r6.getX()
            r5.mInitialMotionX = r6
            r5.mLastMotionX = r6
            return r4
        Lab:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void pullEvent(float f2) {
        int iRound;
        int footerSize;
        Log.e("z", "pullEvent:" + f2);
        int[] iArr = AnonymousClass4.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode;
        if (iArr[this.mCurrentMode.ordinal()] != 1) {
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
        if (iArr[this.mCurrentMode.ordinal()] != 1) {
            this.mHeaderLayout.onPull(fAbs);
        } else {
            this.mFooterLayout.onPull(fAbs);
        }
        State state = this.mState;
        State state2 = State.PULL_TO_REFRESH;
        if (state != state2 && footerSize >= Math.abs(iRound)) {
            setState(state2);
        } else {
            if (this.mState != state2 || footerSize >= Math.abs(iRound)) {
                return;
            }
            setState(State.RELEASE_TO_REFRESH);
        }
    }

    public final void refreshLoadingViewsSize() {
        getMaximumPullScroll();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int i2 = AnonymousClass4.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation[getPullToRefreshScrollDirection().ordinal()];
        if (i2 == 1) {
            paddingLeft = this.mMode.showHeaderLoadingLayout() ? -this.mHeaderLayout.getContentSize() : 0;
            paddingRight = this.mMode.showFooterLoadingLayout() ? -this.mFooterLayout.getContentSize() : 0;
        } else if (i2 == 2) {
            paddingTop = this.mMode.showHeaderLoadingLayout() ? getHeaderVerticalTopPadding() : 0;
            paddingBottom = this.mMode.showFooterLoadingLayout() ? -this.mFooterLayout.getContentSize() : 0;
        }
        Log.d(LOG_TAG, String.format("Setting Padding. L: %d, T: %d, R: %d, B: %d", Integer.valueOf(paddingLeft), Integer.valueOf(paddingTop), Integer.valueOf(paddingRight), Integer.valueOf(paddingBottom)));
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public final void refreshRefreshableViewSize(int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRefreshableViewWrapper.getLayoutParams();
        int i4 = AnonymousClass4.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation[getPullToRefreshScrollDirection().ordinal()];
        if (i4 == 1) {
            if (layoutParams.width != i2) {
                layoutParams.width = i2;
                this.mRefreshableViewWrapper.requestLayout();
                return;
            }
            return;
        }
        if (i4 == 2 && layoutParams.height != i3) {
            layoutParams.height = i3;
            this.mRefreshableViewWrapper.requestLayout();
        }
    }

    public void setCurrentMode(Mode mode) {
        this.mCurrentMode = mode;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final void setFilterTouchEvents(boolean z) {
        this.mFilterTouchEvents = z;
    }

    public void setFriction(float f2) {
        this.mFriction = f2;
    }

    public void setHeaderScroll(int i2) {
        Log.d(LOG_TAG, "setHeaderScroll: " + i2);
        OnPullScrollListener onPullScrollListener = this.mOnPullScrollListener;
        if (onPullScrollListener != null) {
            onPullScrollListener.onHeadScroll(i2, this.mIsBeingDragged);
        }
        int maximumPullScroll = getMaximumPullScroll();
        int iMin = Math.min(maximumPullScroll, Math.max(-maximumPullScroll, i2));
        if (this.mLayoutVisibilityChangesEnabled) {
            if (iMin < 0) {
                this.mHeaderLayout.setVisibility(0);
            } else if (iMin > 0) {
                this.mFooterLayout.setVisibility(0);
            } else {
                this.mHeaderLayout.setVisibility(4);
                this.mFooterLayout.setVisibility(4);
            }
        }
        int i3 = AnonymousClass4.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation[getPullToRefreshScrollDirection().ordinal()];
        if (i3 == 1) {
            scrollTo(iMin, 0);
            this.mHeaderLayout.onScrollOffset(iMin);
        } else {
            if (i3 != 2) {
                return;
            }
            scrollTo(0, iMin);
            this.mHeaderLayout.onScrollOffset(iMin);
        }
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    public void setLoadingLayoutMode(AnimationStyle animationStyle) {
        this.mLoadingAnimationStyle = animationStyle;
        updateUIForMode();
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final void setMode(Mode mode) {
        if (mode != this.mMode) {
            Log.d(LOG_TAG, "Setting mode to: " + mode);
            this.mMode = mode;
            updateUIForMode();
        }
    }

    public void setOnDraggingListener(OnDraggingListener onDraggingListener) {
        this.mOnDraggingListener = onDraggingListener;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public void setOnPullEventListener(OnPullEventListener<T> onPullEventListener) {
        this.mOnPullEventListener = onPullEventListener;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final void setOnRefreshListener(OnRefreshListener<T> onRefreshListener) {
        this.mOnRefreshListener = onRefreshListener;
        this.mOnRefreshListener2 = null;
    }

    public void setPaddingTop(int i2) {
        this.mHeaderLayout.setPaddingTop(i2);
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public void setPullScrollListener(OnPullScrollListener onPullScrollListener) {
        this.mOnPullScrollListener = onPullScrollListener;
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.mOverScrollEnabled = z;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final void setRefreshing() {
        setRefreshing(true);
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        setReleaseLabel(charSequence, Mode.BOTH);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.mScrollAnimationInterpolator = interpolator;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final void setScrollingWhileRefreshingEnabled(boolean z) {
        this.mScrollingWhileRefreshingEnabled = z;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final void setShowViewWhileRefreshing(boolean z) {
        this.mShowViewWhileRefreshing = z;
    }

    public final void setState(State state) {
        setState(state, null);
    }

    public final void smoothScrollTo(int i2) {
        smoothScrollTo(i2, getPullToRefreshScrollDuration());
    }

    public final void smoothScrollToLonger(int i2) {
        smoothScrollTo(i2, getPullToRefreshScrollDurationLonger());
    }

    public void updateUIForMode() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams(this.mHeaderLayout);
        View contentView = this.mHeaderLayout.getContentView();
        if (this == contentView.getParent()) {
            removeView(contentView);
        }
        if (this.mMode.showHeaderLoadingLayout()) {
            addViewInternal(contentView, 0, loadingLayoutLayoutParams);
        }
        LinearLayout.LayoutParams loadingLayoutLayoutParams2 = getLoadingLayoutLayoutParams(this.mFooterLayout);
        View contentView2 = this.mFooterLayout.getContentView();
        if (this == contentView2.getParent()) {
            removeView(contentView2);
        }
        if (this.mMode.showFooterLoadingLayout()) {
            addViewInternal(contentView2, loadingLayoutLayoutParams2);
        }
        refreshLoadingViewsSize();
        Mode mode = this.mMode;
        if (mode == Mode.BOTH) {
            mode = Mode.PULL_FROM_START;
        }
        this.mCurrentMode = mode;
    }

    public final void addViewInternal(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final ILoadingLayout getLoadingLayoutProxy(boolean z, boolean z2) {
        return createLoadingLayoutProxy(z, z2);
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
    }

    public void setPullLabel(CharSequence charSequence, Mode mode) {
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charSequence);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final void setRefreshing(boolean z) {
        if (isRefreshing()) {
            return;
        }
        setState(State.MANUAL_REFRESHING, Boolean.valueOf(z));
    }

    public void setRefreshingLabel(CharSequence charSequence, Mode mode) {
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public final void setState(State state, Boolean bool) {
        this.mState = state;
        Log.d(LOG_TAG, "State: " + this.mState.name());
        switch (AnonymousClass4.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$State[this.mState.ordinal()]) {
            case 1:
                onReset();
                break;
            case 2:
                onPullToRefresh();
                break;
            case 3:
                onReleaseToRefresh();
                break;
            case 4:
            case 5:
                if (bool != null) {
                    onRefreshing(bool.booleanValue());
                }
                break;
            case 6:
                break;
            default:
                onSetStateDefault(state, bool);
                break;
        }
        OnPullEventListener<T> onPullEventListener = this.mOnPullEventListener;
        if (onPullEventListener != null) {
            onPullEventListener.onPullEvent(this, this.mState, this.mCurrentMode);
        }
    }

    public final void smoothScrollTo(int i2, OnSmoothScrollFinishedListener onSmoothScrollFinishedListener) {
        smoothScrollTo(i2, getPullToRefreshScrollDuration(), 0L, onSmoothScrollFinishedListener);
    }

    private final void smoothScrollTo(int i2, long j) {
        smoothScrollTo(i2, j, 0L, null);
    }

    public void onRefreshing(boolean z) {
        if (this.mMode.showHeaderLoadingLayout()) {
            this.mHeaderLayout.refreshing();
        }
        if (this.mMode.showFooterLoadingLayout()) {
            this.mFooterLayout.refreshing();
        }
        if (z) {
            if (this.mShowViewWhileRefreshing) {
                OnSmoothScrollFinishedListener onSmoothScrollFinishedListener = new OnSmoothScrollFinishedListener() { // from class: com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase.1
                    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase.OnSmoothScrollFinishedListener
                    public void onSmoothScrollFinished() {
                        KGUIPullToRefreshBase.this.callRefreshListener();
                    }
                };
                int i2 = AnonymousClass4.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[this.mCurrentMode.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        smoothScrollTo(-getHeaderSize(), onSmoothScrollFinishedListener);
                        return;
                    } else if (i2 != 3) {
                        onRefreshComplete();
                        return;
                    }
                }
                smoothScrollTo(getFooterSize(), onSmoothScrollFinishedListener);
                return;
            }
            smoothScrollTo(0);
            return;
        }
        callRefreshListener();
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.IPullToRefresh
    public final void setOnRefreshListener(OnRefreshListener2<T> onRefreshListener2) {
        this.mOnRefreshListener2 = onRefreshListener2;
        this.mOnRefreshListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void smoothScrollTo(int i2, long j, long j2, OnSmoothScrollFinishedListener onSmoothScrollFinishedListener) {
        int scrollX;
        KGUIPullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable = this.mCurrentSmoothScrollRunnable;
        if (smoothScrollRunnable != null) {
            smoothScrollRunnable.stop();
        }
        if (AnonymousClass4.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation[getPullToRefreshScrollDirection().ordinal()] != 1) {
            scrollX = getScrollY();
        } else {
            scrollX = getScrollX();
        }
        int i3 = scrollX;
        if (i3 != i2) {
            if (this.mScrollAnimationInterpolator == null) {
                this.mScrollAnimationInterpolator = new DecelerateInterpolator();
            }
            KGUIPullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable2 = new SmoothScrollRunnable(i3, i2, j, onSmoothScrollFinishedListener);
            this.mCurrentSmoothScrollRunnable = smoothScrollRunnable2;
            if (j2 > 0) {
                postDelayed(smoothScrollRunnable2, j2);
            } else {
                post(smoothScrollRunnable2);
            }
        }
    }

    public KGUIPullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.mFriction = 3.0f;
        this.mState = State.RESET;
        this.mMode = Mode.getDefault();
        this.mShowViewWhileRefreshing = true;
        this.mScrollingWhileRefreshingEnabled = false;
        this.mFilterTouchEvents = true;
        this.mOverScrollEnabled = true;
        this.mLayoutVisibilityChangesEnabled = true;
        this.mLoadingAnimationStyle = AnimationStyle.getDefault();
        this.isLastActionDragging = false;
        init(context, attributeSet);
    }

    public KGUIPullToRefreshBase(Context context, Mode mode) {
        super(context);
        this.mIsBeingDragged = false;
        this.mFriction = 3.0f;
        this.mState = State.RESET;
        this.mMode = Mode.getDefault();
        this.mShowViewWhileRefreshing = true;
        this.mScrollingWhileRefreshingEnabled = false;
        this.mFilterTouchEvents = true;
        this.mOverScrollEnabled = true;
        this.mLayoutVisibilityChangesEnabled = true;
        this.mLoadingAnimationStyle = AnimationStyle.getDefault();
        this.isLastActionDragging = false;
        this.mMode = mode;
        init(context, null);
    }

    public KGUIPullToRefreshBase(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context);
        this.mIsBeingDragged = false;
        this.mFriction = 3.0f;
        this.mState = State.RESET;
        this.mMode = Mode.getDefault();
        this.mShowViewWhileRefreshing = true;
        this.mScrollingWhileRefreshingEnabled = false;
        this.mFilterTouchEvents = true;
        this.mOverScrollEnabled = true;
        this.mLayoutVisibilityChangesEnabled = true;
        this.mLoadingAnimationStyle = AnimationStyle.getDefault();
        this.isLastActionDragging = false;
        this.mMode = mode;
        this.mLoadingAnimationStyle = animationStyle;
        init(context, null);
    }
}
