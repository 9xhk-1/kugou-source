package com.kugou.framework.lyric2;

import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;
import com.kugou.framework.lyric.LyricView;
import com.kugou.framework.lyric.debug.LyricDebug;
import com.kugou.framework.lyric2.BaseLyricView;
import com.kugou.framework.lyric2.render.CellRender;

/* JADX INFO: loaded from: classes2.dex */
public abstract class EventLyricView extends BaseLyricView {
    private static final int CLICK_FOOTER_AREA = 11;
    private static final int CLICK_HEADER_AREA = 12;
    private static final int INVALID_POINTER = -1;
    public static final String TAG = "EventLyricView";
    private static final int TAP = 10;
    public boolean canShowHover;
    private boolean isCanSlide;
    public boolean isClickable;
    private boolean isEnableFling;
    private boolean isInTouch;
    public boolean isLongClickable;
    public boolean isLongClicked;
    private boolean isPostLongClickCb;
    private boolean isStartSliding;
    private boolean isStartedSlide;
    private boolean isUserFling;
    private boolean isUserFlingWhenDown;
    private Runnable longClickRunnable;
    private OnLyricFooterMessageClickListener lyricFooterMessageClickListener;
    private OnLyricHeaderMessageClickListener lyricHeaderMessageClickListener;
    private OnLyricTapListener lyricViewClickListener;
    private int mActivePointerId;
    private MotionEvent mCurrentDownEvent;
    public int mDownY;
    private LyricView.InterceptLongClickCallback mInterceptLongClickCallback;
    private boolean mIsBeingDragged;
    private LyricView.LongClickCallBack mLongClickCallBack;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mMoveDistance;
    private MotionEvent mPreviousUpEvent;
    public OverScroller mScroller;
    private int mTouchSlop;
    private long mTouchTimeSlop;
    private VelocityTracker mVelocityTracker;

    public interface OnLyricFooterMessageClickListener {
        void onLyricFooterMessageClick();
    }

    public interface OnLyricHeaderMessageClickListener {
        void onLyricHeaderMessageClick();
    }

    public interface OnLyricTapListener {
        void onDoubleTap();

        void onSingleTapConfirmed(View view);
    }

    public EventLyricView(Context context) {
        this(context, null);
    }

    private void checkRollback() {
        synchronized (this.allHeightLock) {
            int i2 = this.scrollRowOffset;
            if (i2 > 0) {
                scrollTo(0);
                doCalcu();
            } else {
                int i3 = this.allRowHeight;
                if (i2 < (-i3)) {
                    scrollTo(-i3);
                    doCalcu();
                }
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
    }

    private void fling(int i2) {
        LyricDebug.d("startFling: " + i2 + " scrollRowOffset:" + this.scrollRowOffset + " allRowHeight:" + this.allRowHeight);
        if (isInTouch()) {
            LyricDebug.e("Error startFling");
        }
        synchronized (this.allHeightLock) {
            if (i2 != 0) {
                int i3 = this.allRowHeight;
                if (i3 != 0) {
                    this.mScroller.fling(0, this.scrollRowOffset, 0, i2, 0, 0, -i3, 0, 0, 200);
                    doCalcu();
                }
            }
        }
    }

    private void handleClickEvent(MotionEvent motionEvent) {
        if (this.isStartSliding || !this.isClickable || this.lyricViewClickListener == null || motionEvent.getEventTime() - motionEvent.getDownTime() >= ViewConfiguration.getLongPressTimeout()) {
            return;
        }
        boolean zHasMessages = getLyricHandler().hasMessages(10);
        if (zHasMessages) {
            getLyricHandler().removeMessages(10);
        }
        if (zHasMessages) {
            this.lyricViewClickListener.onDoubleTap();
            return;
        }
        if (isHitFooterArea(motionEvent)) {
            getLyricHandler().sendEmptyMessage(11);
        } else if (isHitHeaderArea(motionEvent)) {
            getLyricHandler().sendEmptyMessage(12);
        } else {
            getLyricHandler().sendEmptyMessageDelayed(10, ViewConfiguration.getDoubleTapTimeout());
        }
    }

    private void handleLongClick() {
        if (this.isPostLongClickCb) {
            removeCallbacks(this.longClickRunnable);
            this.isPostLongClickCb = false;
        } else {
            postDelayed(this.longClickRunnable, ViewConfiguration.getLongPressTimeout());
            this.isPostLongClickCb = true;
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void initViewConfig() {
        if (Build.VERSION.SDK_INT >= 11) {
            this.mScroller.setFriction(0.02f);
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    private void log(String str) {
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldInterceptTouchEvent() {
        LyricView.InterceptLongClickCallback interceptLongClickCallback = this.mInterceptLongClickCallback;
        if (interceptLongClickCallback == null) {
            return false;
        }
        return interceptLongClickCallback.shouldInterceptLongClickEvent();
    }

    private void slidingStop() {
        if (this.onNewLyricSlidingListener == null || !this.mScroller.isFinished()) {
            return;
        }
        this.onNewLyricSlidingListener.onSlidingStop(getCenterCellPlayTime());
        this.isStartSliding = false;
        LyricDebug.d("onSlidingStop");
    }

    public abstract boolean canSlide();

    @Override // com.kugou.framework.lyric2.BaseLyricView
    public void computeLyricScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.isNeedDrawStatic = true;
            setIsScrolling(true);
            int i2 = this.scrollRowOffset;
            int currY = this.mScroller.getCurrY();
            if (i2 != currY) {
                this.scrollRowOffset = currY;
            }
            BaseLyricView.OnNewLyricSlidingListener onNewLyricSlidingListener = this.onNewLyricSlidingListener;
            if (onNewLyricSlidingListener != null) {
                onNewLyricSlidingListener.onSlidingMove(getCenterCellPlayTime());
            }
            doCalcu();
            return;
        }
        setIsScrolling(false);
        if (this.isStartSliding && !this.isInTouch) {
            slidingStop();
        }
        if (this.mScroller.isFinished() && this.isUserFling && !this.isInTouch) {
            this.isUserFling = false;
            this.rePosCenterPos.set(true);
        }
        this.isNeedDrawStatic = this.isInTouch;
    }

    public abstract long getCenterCellPlayTime();

    public abstract int getCenterOffset();

    public LyricView.LongClickCallBack getLongClickCallBack() {
        return this.mLongClickCallBack;
    }

    public boolean getLongClickable() {
        return this.isLongClickable;
    }

    public abstract int getPlayedOffset();

    @Override // com.kugou.framework.lyric2.BaseLyricView
    public long getScrollingRowTime() {
        this.mScroller.abortAnimation();
        return getCenterCellPlayTime();
    }

    @Override // com.kugou.framework.lyric2.BaseLyricView
    public void handleSubMessage(Message message) {
        switch (message.what) {
            case 10:
                post(new Runnable() { // from class: com.kugou.framework.lyric2.EventLyricView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (EventLyricView.this.lyricViewClickListener != null) {
                            EventLyricView.this.lyricViewClickListener.onSingleTapConfirmed(EventLyricView.this);
                        }
                    }
                });
                break;
            case 11:
                post(new Runnable() { // from class: com.kugou.framework.lyric2.EventLyricView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (EventLyricView.this.lyricFooterMessageClickListener != null) {
                            EventLyricView.this.lyricFooterMessageClickListener.onLyricFooterMessageClick();
                        }
                    }
                });
                break;
            case 12:
                post(new Runnable() { // from class: com.kugou.framework.lyric2.EventLyricView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (EventLyricView.this.lyricHeaderMessageClickListener != null) {
                            EventLyricView.this.lyricHeaderMessageClickListener.onLyricHeaderMessageClick();
                        }
                    }
                });
                break;
        }
    }

    public boolean isEnableFling() {
        return this.isEnableFling;
    }

    public abstract boolean isHitFooterArea(MotionEvent motionEvent);

    public abstract boolean isHitHeaderArea(MotionEvent motionEvent);

    public boolean isInTouch() {
        return this.isInTouch;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        BaseLyricView.OnNewLyricSlidingListener onNewLyricSlidingListener;
        BaseLyricView.OnNewLyricSlidingListener onNewLyricSlidingListener2;
        int action = motionEvent.getAction();
        if (!this.isCanSlide || !canSlide()) {
            if (action == 0) {
                this.isInTouch = true;
                this.isLongClicked = false;
                this.isUserFlingWhenDown = this.isUserFling;
                this.mDownY = (int) motionEvent.getY();
                handleLongClick();
            } else if (action == 1 || action == 3) {
                this.isInTouch = false;
                this.isLongClicked = false;
                if (!this.isUserFlingWhenDown) {
                    handleClickEvent(motionEvent);
                }
            }
            return true;
        }
        initVelocityTrackerIfNotExists();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (action == 0) {
            this.isLongClicked = false;
            this.isStartSliding = false;
            this.isUserFlingWhenDown = this.isUserFling;
            this.isUserFling = false;
            this.isStartedSlide = false;
            this.isInTouch = true;
            this.isNeedDrawStatic = true;
            this.mMoveDistance = this.scrollRowOffset;
            if (!this.mScroller.isFinished()) {
                this.mScroller.forceFinished(true);
                slidingStop();
            }
            this.mDownY = (int) motionEvent.getY();
            this.mActivePointerId = motionEvent.getPointerId(0);
            handleLongClick();
        } else if (action == 1) {
            this.isInTouch = false;
            this.isLongClicked = false;
            if (this.isStartSliding) {
                slidingStop();
            }
            if (this.mIsBeingDragged) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int yVelocity = (int) velocityTracker.getYVelocity(this.mActivePointerId);
                if (Math.abs(yVelocity) <= this.mMinimumVelocity || !this.isEnableFling) {
                    synchronized (this.allHeightLock) {
                        int i2 = this.scrollRowOffset;
                        if (i2 > 0) {
                            scrollTo(0);
                        } else {
                            int i3 = this.allRowHeight;
                            if (i2 < (-i3)) {
                                scrollTo(-i3);
                            } else {
                                LyricDebug.d("1---------");
                                this.rePosCenterPos.set(true);
                            }
                        }
                    }
                } else {
                    this.isUserFling = true;
                    fling(yVelocity);
                }
                this.mActivePointerId = -1;
                endDrag();
            } else {
                if (!this.isUserFlingWhenDown) {
                    handleClickEvent(motionEvent);
                }
                checkRollback();
                endDrag();
            }
            MotionEvent motionEvent2 = this.mPreviousUpEvent;
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            this.mPreviousUpEvent = MotionEvent.obtain(motionEvent);
        } else if (action == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
            if (iFindPointerIndex != -1) {
                int y = this.mDownY - ((int) motionEvent.getY(iFindPointerIndex));
                if (!this.mIsBeingDragged && Math.abs(y) > this.mTouchSlop) {
                    this.mIsBeingDragged = true;
                    this.isStartSliding = true;
                    this.isStartedSlide = true;
                    this.canShowHover = true;
                }
                if (this.mIsBeingDragged) {
                    if (this.isPostLongClickCb) {
                        removeCallbacks(this.longClickRunnable);
                        this.isPostLongClickCb = false;
                    }
                    this.scrollRowOffset = this.mMoveDistance - y;
                    doCalcu();
                    scrollLyricView(true);
                    if (this.isStartedSlide && (onNewLyricSlidingListener2 = this.onNewLyricSlidingListener) != null && this.isStartSliding) {
                        onNewLyricSlidingListener2.onSlidingStart();
                        this.isStartedSlide = false;
                    }
                    if (this.isStartSliding && (onNewLyricSlidingListener = this.onNewLyricSlidingListener) != null) {
                        onNewLyricSlidingListener.onSlidingMove(getCenterCellPlayTime());
                    }
                }
            }
        } else if (action == 3) {
            this.isInTouch = false;
            this.isLongClicked = false;
            if (this.isStartSliding) {
                slidingStop();
            }
            this.mActivePointerId = -1;
            checkRollback();
            endDrag();
        }
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    @Override // com.kugou.framework.lyric2.BaseLyricView
    public void rePosCenterPos() {
        if (this.mScroller.isFinished()) {
            scrollBy(CellRender.getInstance().getCenterCellOffset());
        }
    }

    public void scrollBy(int i2) {
        if (isInTouch()) {
            LyricDebug.e("Error scrollBy diff");
            return;
        }
        this.isNeedDrawStatic = true;
        OverScroller overScroller = this.mScroller;
        if (overScroller != null) {
            overScroller.forceFinished(true);
            this.mScroller.startScroll(0, this.scrollRowOffset, 0, i2, 300);
        }
    }

    public void scrollTo(int i2) {
        if (isInTouch()) {
            LyricDebug.e("Error scrollTo");
        }
        this.isNeedDrawStatic = true;
        OverScroller overScroller = this.mScroller;
        if (overScroller != null) {
            overScroller.startScroll(0, overScroller.getCurrY(), 0, i2 - this.mScroller.getCurrY(), 500);
        }
    }

    public void scrollToPlayingRow(int i2) {
        if (isInTouch()) {
            LyricDebug.e("Error scrollToPlayingRow");
            return;
        }
        this.isNeedDrawStatic = true;
        if (this.mScroller != null) {
            BaseLyricView.OnNewLyricSlidingListener onNewLyricSlidingListener = this.onNewLyricSlidingListener;
            if (onNewLyricSlidingListener != null) {
                onNewLyricSlidingListener.onAutoRollBack();
            }
            this.mScroller.startScroll(0, getCenterOffset(), 0, i2 - getCenterOffset(), 500);
        }
    }

    public void scrollToWithDuration(int i2, int i3) {
        if (isInTouch()) {
            LyricDebug.e("Error scrollToWithDuration");
        }
        this.isNeedDrawStatic = true;
        OverScroller overScroller = this.mScroller;
        if (overScroller != null) {
            overScroller.startScroll(0, overScroller.getCurrY(), 0, i2 - this.mScroller.getCurrY(), i3);
        }
    }

    public void setCanSlide(boolean z) {
        this.isCanSlide = z;
    }

    public void setEnableFling(boolean z) {
        this.isEnableFling = z;
    }

    public void setInterceptLongClickCallback(LyricView.InterceptLongClickCallback interceptLongClickCallback) {
        this.mInterceptLongClickCallback = interceptLongClickCallback;
    }

    public void setLongClickCallBack(LyricView.LongClickCallBack longClickCallBack) {
        this.mLongClickCallBack = longClickCallBack;
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        this.isLongClickable = z;
    }

    public void setLyricFooterMessageClickListener(OnLyricFooterMessageClickListener onLyricFooterMessageClickListener) {
        this.lyricFooterMessageClickListener = onLyricFooterMessageClickListener;
    }

    public void setLyricHeaderMessageClickListener(OnLyricHeaderMessageClickListener onLyricHeaderMessageClickListener) {
        this.lyricHeaderMessageClickListener = onLyricHeaderMessageClickListener;
    }

    public void setLyricViewClickListener(OnLyricTapListener onLyricTapListener) {
        this.lyricViewClickListener = onLyricTapListener;
    }

    public EventLyricView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EventLyricView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mActivePointerId = -1;
        this.isLongClicked = false;
        this.isInTouch = false;
        this.mIsBeingDragged = false;
        this.canShowHover = false;
        this.isLongClickable = true;
        this.isClickable = true;
        this.isStartSliding = false;
        this.isUserFling = false;
        this.isStartedSlide = false;
        this.isPostLongClickCb = false;
        this.isCanSlide = true;
        this.isEnableFling = true;
        this.isUserFlingWhenDown = false;
        this.longClickRunnable = new Runnable() { // from class: com.kugou.framework.lyric2.EventLyricView.4
            @Override // java.lang.Runnable
            public void run() {
                EventLyricView.this.isPostLongClickCb = false;
                if (EventLyricView.this.mIsBeingDragged) {
                    return;
                }
                EventLyricView eventLyricView = EventLyricView.this;
                if (eventLyricView.isLongClickable && eventLyricView.isInTouch && !EventLyricView.this.shouldInterceptTouchEvent()) {
                    EventLyricView eventLyricView2 = EventLyricView.this;
                    eventLyricView2.isLongClicked = true;
                    eventLyricView2.invalidate();
                }
            }
        };
        this.mScroller = new OverScroller(getContext(), new DecelerateInterpolator());
        initViewConfig();
    }
}
