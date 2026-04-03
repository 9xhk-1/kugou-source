package com.kugou.framework.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class Workspace2 extends ViewGroup {
    private static final int INVALID_POINTER = -1;
    private static final int INVALID_SCREEN = -1;
    private static final int MAX_Y_DISTANCE = 10;
    private static final int MIN_LENGTH_FOR_FLING = 100;
    private static final int SNAP_VELOCITY = 500;
    private static final String TAG = "Workspace";
    private static final int TOUCH_STATE_REST = 0;
    private static final int TOUCH_STATE_SCROLLING = 1;
    private static final int TOUCH_STATE_SCROLLING_LYR = 2;
    private int mActivePointerId;
    private boolean mAllowLongPress;
    private int mCurrentScreen;
    private int mDefaultScreen;
    private boolean mDeferredNotify;
    private int mDeferredScreenChange;
    private boolean mDeferredScreenChangeFast;
    private float mDownMotionX;
    private float mDownMotionY;
    private int mDownScrollX;
    private boolean mFirstLayout;
    private boolean mHasLaidOut;
    private boolean mIgnoreChildFocusRequests;
    private FlowIndicator2 mIndicator;
    private boolean mIsVerbose;
    private boolean mLocked;
    private View.OnLongClickListener mLongClickListener;
    private int mMaximumVelocity;
    private int mNextScreen;
    private OnScreenChangeListener mOnScreenChangeListener;
    private OnScrollListener mOnScrollListener;
    private int mPagingTouchSlop;
    private Scroller mScroller;
    private Drawable mSeparatorDrawable;
    private int mTouchSlop;
    private int mTouchState;
    private VelocityTracker mVelocityTracker;

    public interface OnScreenChangeListener {
        void onScreenChanged(View view, int i2);

        void onScreenChanging(View view, int i2);
    }

    public interface OnScrollListener {
        void onScroll(float f2);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.kugou.framework.widget.Workspace2.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        public int currentScreen;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.currentScreen);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.currentScreen = -1;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentScreen = -1;
            this.currentScreen = parcel.readInt();
        }
    }

    public Workspace2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFirstLayout = true;
        this.mHasLaidOut = false;
        this.mNextScreen = -1;
        this.mTouchState = 0;
        this.mAllowLongPress = true;
        this.mActivePointerId = -1;
        this.mDeferredScreenChange = -1;
        this.mDeferredScreenChangeFast = false;
        this.mDeferredNotify = false;
        this.mIsVerbose = false;
        this.mDefaultScreen = 0;
        this.mLocked = false;
        setHapticFeedbackEnabled(false);
        initWorkspace();
        this.mIsVerbose = Log.isLoggable(TAG, 2);
    }

    private void initWorkspace() {
        this.mScroller = new Scroller(getContext());
        this.mCurrentScreen = this.mDefaultScreen;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mPagingTouchSlop = ((Integer) ReflectionUtils2.callWithDefault(viewConfiguration, "getScaledPagingTouchSlop", Integer.valueOf(this.mTouchSlop * 2))).intValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        int i4 = this.mCurrentScreen;
        View screenAt = (i4 < 0 || i4 >= getScreenCount()) ? null : getScreenAt(this.mCurrentScreen);
        if (i2 == 17) {
            int i5 = this.mCurrentScreen;
            if (i5 > 0) {
                screenAt = getScreenAt(i5 - 1);
            }
        } else if (i2 == 66 && this.mCurrentScreen < getScreenCount() - 1) {
            screenAt = getScreenAt(this.mCurrentScreen + 1);
        }
        if (screenAt != null) {
            screenAt.addFocusables(arrayList, i2, i3);
        }
    }

    public void addViewToBack(View view) {
        addView(view);
    }

    public void addViewToFront(View view) {
        this.mCurrentScreen++;
        addView(view, 0);
    }

    public boolean allowLongPress() {
        return this.mAllowLongPress;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.mScroller.computeScrollOffset()) {
            int i2 = this.mNextScreen;
            if (i2 != -1) {
                handleScreenChangeCompletion(Math.max(0, Math.min(i2, getScreenCount() - 1)));
                this.mNextScreen = -1;
                return;
            }
            return;
        }
        scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
        FlowIndicator2 flowIndicator2 = this.mIndicator;
        if (flowIndicator2 != null) {
            flowIndicator2.onScrolled(this.mScroller.getCurrX(), 0, 0, 0);
        }
        OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(getCurrentScreenFraction());
        }
        postInvalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.mTouchState != 1 && this.mNextScreen == -1) {
            if (getScreenAt(this.mCurrentScreen) != null) {
                drawChild(canvas, getScreenAt(this.mCurrentScreen), getDrawingTime());
                return;
            }
            return;
        }
        long drawingTime = getDrawingTime();
        int i2 = this.mNextScreen;
        if (i2 >= 0 && i2 < getScreenCount() && Math.abs(this.mCurrentScreen - this.mNextScreen) == 1) {
            drawChild(canvas, getScreenAt(this.mCurrentScreen), drawingTime);
            drawChild(canvas, getScreenAt(this.mNextScreen), drawingTime);
        } else {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                drawChild(canvas, getChildAt(i3), drawingTime);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i2) {
        if (i2 == 17) {
            if (getCurrentScreen() > 0) {
                snapToScreen(getCurrentScreen() - 1);
                return true;
            }
        } else if (i2 == 66 && getCurrentScreen() < getScreenCount() - 1) {
            snapToScreen(getCurrentScreen() + 1);
            return true;
        }
        return super.dispatchUnhandledMove(view, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void focusableViewAvailable(View view) {
        View screenAt = getScreenAt(this.mCurrentScreen);
        for (View view2 = view; view2 != screenAt; view2 = (View) view2.getParent()) {
            if (view2 == this || !(view2.getParent() instanceof View)) {
                return;
            }
        }
        super.focusableViewAvailable(view);
    }

    public int getCurrentScreen() {
        return this.mCurrentScreen;
    }

    public float getCurrentScreenFraction() {
        if (!this.mHasLaidOut) {
            return this.mCurrentScreen;
        }
        return getScrollX() / getWidth();
    }

    public View getScreenAt(int i2) {
        return this.mSeparatorDrawable == null ? getChildAt(i2) : getChildAt(i2 * 2);
    }

    public int getScreenCount() {
        int childCount = getChildCount();
        return this.mSeparatorDrawable != null ? (childCount + 1) / 2 : childCount;
    }

    public int getScrollWidth() {
        int width = getWidth();
        Drawable drawable = this.mSeparatorDrawable;
        return drawable != null ? width + drawable.getIntrinsicWidth() : width;
    }

    public void handleScreenChangeCompletion(int i2) {
        this.mCurrentScreen = i2;
        try {
            ReflectionUtils2.tryInvoke(getScreenAt(i2), "dispatchDisplayHint", new Class[]{Integer.TYPE}, 0);
            invalidate();
        } catch (NullPointerException e2) {
            Log.e(TAG, "Caught NullPointerException", e2);
        }
        notifyScreenChangeListener(this.mCurrentScreen, true);
    }

    public void lockCurrentScreen() {
        this.mLocked = true;
    }

    public void markViewSelected(View view) {
        this.mCurrentScreen = indexOfChild(view);
    }

    public void notifyScreenChangeListener(int i2, boolean z) {
        OnScreenChangeListener onScreenChangeListener = this.mOnScreenChangeListener;
        if (onScreenChangeListener != null) {
            if (z) {
                onScreenChangeListener.onScreenChanged(getScreenAt(i2), i2);
            } else {
                onScreenChangeListener.onScreenChanging(getScreenAt(i2), i2);
            }
        }
        OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(getCurrentScreenFraction());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00b5  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.widget.Workspace2.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth() + i6;
                childAt.layout(i6, 0, measuredWidth, childAt.getMeasuredHeight());
                i6 = measuredWidth;
            }
        }
        this.mHasLaidOut = true;
        int i8 = this.mDeferredScreenChange;
        if (i8 >= 0) {
            snapToScreen(i8, this.mDeferredScreenChangeFast, this.mDeferredNotify);
            this.mDeferredScreenChange = -1;
            this.mDeferredScreenChangeFast = false;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            if (this.mSeparatorDrawable == null || (i4 & 1) != 1) {
                getChildAt(i4).measure(i2, i3);
            } else {
                getChildAt(i4).measure(this.mSeparatorDrawable.getIntrinsicWidth(), i3);
            }
        }
        if (this.mFirstLayout) {
            setHorizontalScrollBarEnabled(false);
            int size = View.MeasureSpec.getSize(i2);
            Drawable drawable = this.mSeparatorDrawable;
            if (drawable != null) {
                size += drawable.getIntrinsicWidth();
            }
            scrollTo(this.mCurrentScreen * size, 0);
            setHorizontalScrollBarEnabled(true);
            this.mFirstLayout = false;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3 = this.mNextScreen;
        if (i3 == -1) {
            i3 = this.mCurrentScreen;
        }
        View screenAt = getScreenAt(i3);
        if (screenAt != null) {
            return screenAt.requestFocus(i2, rect);
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i2 = savedState.currentScreen;
        if (i2 != -1) {
            snapToScreen(i2, true, true);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentScreen = this.mCurrentScreen;
        return savedState;
    }

    public void onSecondaryPointerUp(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (MotionEventUtils2.getPointerId(motionEvent, action) == this.mActivePointerId) {
            int i2 = action == 0 ? 1 : 0;
            this.mDownMotionX = MotionEventUtils2.getX(motionEvent, i2);
            this.mDownMotionX = MotionEventUtils2.getY(motionEvent, i2);
            this.mDownScrollX = getScrollX();
            this.mActivePointerId = MotionEventUtils2.getPointerId(motionEvent, i2);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        if (this.mIsVerbose) {
            Log.v(TAG, "onTouchEvent: " + (motionEvent.getAction() & 255));
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1) {
                if (this.mTouchState == 1) {
                    float x = MotionEventUtils2.getX(motionEvent, MotionEventUtils2.findPointerIndex(motionEvent, this.mActivePointerId));
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    boolean z = Math.abs(this.mDownMotionX - x) > 100.0f;
                    float currentScreenFraction = getCurrentScreenFraction();
                    int iRound = Math.round(currentScreenFraction);
                    if (z && this.mIsVerbose) {
                        Log.v(TAG, "isFling, whichScreen=" + iRound + " scrolledPos=" + currentScreenFraction + " mCurrentScreen=" + this.mCurrentScreen + " velocityX=" + xVelocity);
                    }
                    if (z && xVelocity > 500 && (i2 = this.mCurrentScreen) > 0) {
                        if (currentScreenFraction <= iRound) {
                            i2--;
                        }
                        snapToScreen(Math.min(iRound, i2));
                    } else if (!z || xVelocity >= -500 || this.mCurrentScreen >= getChildCount() - 1) {
                        snapToDestination();
                    } else {
                        snapToScreen(Math.max(iRound, currentScreenFraction >= ((float) iRound) ? this.mCurrentScreen + 1 : this.mCurrentScreen));
                    }
                } else {
                    performClick();
                }
                this.mTouchState = 0;
                this.mActivePointerId = -1;
            } else if (action == 2) {
                if (this.mIsVerbose) {
                    Log.v(TAG, "mTouchState=" + this.mTouchState);
                }
                int i3 = this.mTouchState;
                if (i3 == 1) {
                    scrollTo(Math.max(0, Math.min(getChildAt(getChildCount() - 1).getRight() - getWidth(), (int) ((this.mDownScrollX + this.mDownMotionX) - MotionEventUtils2.getX(motionEvent, MotionEventUtils2.findPointerIndex(motionEvent, this.mActivePointerId))))), 0);
                    OnScrollListener onScrollListener = this.mOnScrollListener;
                    if (onScrollListener != null) {
                        onScrollListener.onScroll(getCurrentScreenFraction());
                    }
                } else if (i3 == 0 && !this.mLocked) {
                    int iFindPointerIndex = MotionEventUtils2.findPointerIndex(motionEvent, this.mActivePointerId);
                    float x2 = MotionEventUtils2.getX(motionEvent, iFindPointerIndex);
                    float y = MotionEventUtils2.getY(motionEvent, iFindPointerIndex);
                    int iAbs = (int) Math.abs(x2 - this.mDownMotionX);
                    int iAbs2 = (int) Math.abs(y - this.mDownMotionY);
                    boolean z2 = iAbs > this.mPagingTouchSlop;
                    int i4 = this.mTouchSlop;
                    boolean z3 = iAbs > i4;
                    boolean z4 = iAbs2 > i4;
                    if (z3 || z4) {
                        if (z2) {
                            this.mTouchState = 1;
                        }
                        if (this.mAllowLongPress) {
                            this.mAllowLongPress = false;
                            View screenAt = getScreenAt(this.mCurrentScreen);
                            if (screenAt != null) {
                                screenAt.cancelLongPress();
                            }
                        }
                    }
                }
            } else if (action != 3) {
                if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                }
            }
            this.mTouchState = 0;
            this.mActivePointerId = -1;
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
        } else {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            this.mDownMotionX = motionEvent.getX();
            this.mDownMotionY = motionEvent.getY();
            this.mDownScrollX = getScrollX();
            this.mActivePointerId = MotionEventUtils2.getPointerId(motionEvent, 0);
        }
        return true;
    }

    public void removeViewFromBack() {
        removeViewAt(getChildCount() - 1);
    }

    public void removeViewFromFront() {
        this.mCurrentScreen--;
        removeViewAt(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        int iIndexOfChild = indexOfChild(view);
        if (this.mSeparatorDrawable != null) {
            iIndexOfChild /= 2;
        }
        if (iIndexOfChild < 0 || isInTouchMode()) {
            return;
        }
        snapToScreen(iIndexOfChild);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        int iIndexOfChild = indexOfChild(view);
        if (!this.mIgnoreChildFocusRequests || this.mScroller.isFinished()) {
            if (iIndexOfChild == this.mCurrentScreen && this.mScroller.isFinished()) {
                return false;
            }
            snapToScreen(iIndexOfChild);
            return true;
        }
        Log.w(TAG, "Ignoring child focus request: request " + this.mCurrentScreen + " -> " + iIndexOfChild);
        return false;
    }

    public void scrollLeft() {
        if (this.mLocked) {
            return;
        }
        if (this.mScroller.isFinished()) {
            int i2 = this.mCurrentScreen;
            if (i2 > 0) {
                snapToScreen(i2 - 1);
                return;
            }
            return;
        }
        int i3 = this.mNextScreen;
        if (i3 > 0) {
            snapToScreen(i3 - 1);
        }
    }

    public void scrollRight() {
        if (this.mLocked) {
            return;
        }
        if (this.mScroller.isFinished()) {
            if (this.mCurrentScreen < getChildCount() - 1) {
                snapToScreen(this.mCurrentScreen + 1);
            }
        } else if (this.mNextScreen < getChildCount() - 1) {
            snapToScreen(this.mNextScreen + 1);
        }
    }

    public void setCurrentScreen(int i2) {
        snapToScreen(Math.max(0, Math.min(getScreenCount() - 1, i2)));
    }

    public void setCurrentScreenNow(int i2) {
        setCurrentScreenNow(i2, true);
    }

    public void setIgnoreChildFocusRequests(boolean z) {
        this.mIgnoreChildFocusRequests = z;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        int screenCount = getScreenCount();
        for (int i2 = 0; i2 < screenCount; i2++) {
            getScreenAt(i2).setOnLongClickListener(onLongClickListener);
        }
    }

    public void setOnScreenChangeListener(OnScreenChangeListener onScreenChangeListener) {
        setOnScreenChangeListener(onScreenChangeListener, true);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener, boolean z) {
        this.mOnScrollListener = onScrollListener;
        if (onScrollListener == null || !z) {
            return;
        }
        onScrollListener.onScroll(getCurrentScreenFraction());
    }

    public void setSeparator(int i2) {
        Drawable drawable = this.mSeparatorDrawable;
        if (drawable != null && i2 == 0) {
            this.mSeparatorDrawable = null;
            for (int childCount = getChildCount() - 2; childCount > 0; childCount -= 2) {
                removeViewAt(childCount);
            }
            requestLayout();
            return;
        }
        if (i2 != 0) {
            if (drawable != null) {
                this.mSeparatorDrawable = getResources().getDrawable(i2);
                for (int childCount2 = getChildCount() - 2; childCount2 > 0; childCount2 -= 2) {
                    getChildAt(childCount2).setBackgroundDrawable(this.mSeparatorDrawable);
                }
                requestLayout();
                return;
            }
            int childCount3 = getChildCount();
            this.mSeparatorDrawable = getResources().getDrawable(i2);
            int i3 = 1;
            for (int i4 = 1; i4 < childCount3; i4++) {
                View view = new View(getContext());
                view.setBackgroundDrawable(this.mSeparatorDrawable);
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
                addView(view, i3);
                i3 += 2;
            }
            requestLayout();
        }
    }

    public void setmIndicator(FlowIndicator2 flowIndicator2) {
        this.mIndicator = flowIndicator2;
        flowIndicator2.setWorkspace(this);
    }

    public void snapToDestination() {
        int scrollWidth = getScrollWidth();
        snapToScreen((getScrollX() + (scrollWidth / 2)) / scrollWidth);
    }

    public void snapToScreen(int i2) {
        snapToScreen(i2, false, true);
    }

    public void unlockCurrentScreen() {
        this.mLocked = false;
    }

    public void setCurrentScreenNow(int i2, boolean z) {
        snapToScreen(Math.max(0, Math.min(getScreenCount() - 1, i2)), true, z);
    }

    public void setOnScreenChangeListener(OnScreenChangeListener onScreenChangeListener, boolean z) {
        this.mOnScreenChangeListener = onScreenChangeListener;
        if (onScreenChangeListener == null || !z) {
            return;
        }
        onScreenChangeListener.onScreenChanged(getScreenAt(this.mCurrentScreen), this.mCurrentScreen);
    }

    public void snapToScreen(int i2, boolean z, boolean z2) {
        if (!this.mHasLaidOut) {
            this.mDeferredScreenChange = i2;
            this.mDeferredScreenChangeFast = z;
            this.mDeferredNotify = z2;
            return;
        }
        if (this.mIsVerbose) {
            Log.v(TAG, "Snapping to screen: " + i2);
        }
        int iMax = Math.max(0, Math.min(i2, getScreenCount() - 1));
        int iAbs = Math.abs(iMax - this.mCurrentScreen);
        int i3 = this.mNextScreen;
        boolean z3 = ((i3 == -1 || i3 == iMax) && this.mCurrentScreen == iMax) ? false : true;
        this.mNextScreen = iMax;
        if (getFocusedChild() != null && iAbs != 0) {
            getScreenAt(this.mCurrentScreen);
        }
        int scrollWidth = iMax * getScrollWidth();
        int scrollX = getScrollX();
        int i4 = scrollWidth - scrollX;
        int iAbs2 = iAbs * 300;
        awakenScrollBars(iAbs2);
        if (iAbs2 == 0) {
            iAbs2 = Math.abs(i4);
        }
        int i5 = z ? 0 : iAbs2;
        int i6 = this.mNextScreen;
        int i7 = this.mCurrentScreen;
        if (i6 != i7) {
            View screenAt = getScreenAt(i7);
            if (screenAt == null) {
                Log.e(TAG, "Screen at index was null. mCurrentScreen = " + this.mCurrentScreen);
                return;
            }
            ReflectionUtils2.tryInvoke(screenAt, "dispatchDisplayHint", new Class[]{Integer.TYPE}, 4);
        }
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        this.mScroller.startScroll(scrollX, 0, i4, 0, i5);
        if (z3 && z2) {
            notifyScreenChangeListener(this.mNextScreen, false);
        }
        invalidate();
    }
}
