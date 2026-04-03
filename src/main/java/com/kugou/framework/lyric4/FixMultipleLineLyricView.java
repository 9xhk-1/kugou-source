package com.kugou.framework.lyric4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.loader.language.Language;
import com.kugou.framework.lyric4.BaseLyricView;
import com.kugou.framework.lyric4.adapter.CellAdapter;
import com.kugou.framework.lyric4.adapter.LyricLineCellAdapter;
import com.kugou.framework.lyric4.cell.Cell;
import com.kugou.framework.lyric4.cell.CellGroup;
import com.kugou.framework.lyric4.cell.RestrictedDrawCellGroup;
import com.kugou.framework.lyric4.cell.TransparentGradientCellGroup;
import com.kugou.framework.lyric4.cell.lyric.EmptyCell;
import com.kugou.framework.lyric4.cell.lyric.FooterCell;
import com.kugou.framework.lyric4.cell.lyric.HeaderCell;
import com.kugou.framework.lyric4.cell.lyric.TxtHeaderCell;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class FixMultipleLineLyricView extends BaseLyricView {
    public static final int ANIMATED_SCROLL_GAP = 520;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_Y_OVERSCROLL_DISTANCE = 100;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private float alphaCellValue;
    private int mActivePointerId;
    private CellAdapter mCellAdapter;
    private CellGroup mCellGroup;
    private int mClickCellPosition;
    private int mCurrentPosition;
    private float mDownY;
    private String mFooterText;
    private String mHeaderText;
    private boolean mHeaderVisible;
    private boolean mIsAutoScrollBackToCurrentPosition;
    private boolean mIsBeingDragged;
    private boolean mIsFadeMode;
    private boolean mIsFling;
    private boolean mIsResponseToLongClick;
    private boolean mIsStartSliding;
    private boolean mIsStartedSlide;
    private boolean mIsUserStopFling;
    private float mLastMotionX;
    private float mLastMotionY;
    private long mLastScroll;
    private int mMaxRows;
    private int mMaxYOverscrollDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private OnHeaderItemClickListener mOnHeaderItemClickListener;
    private OnLyricSlideListener mOnLyricSlideListener;
    private int mOverflingDistance;
    private int mOverscrollDistance;
    private CheckForLongPress mPendingCheckForLongPress;
    private CheckForTap mPendingCheckForTap;
    private CheckScrollBack mPendingCheckScrollBack;
    private OnScrollListener mScrollListener;
    private int mScrollState;
    private OverScroller mScroller;
    private int mTotalHeight;
    private Runnable mTouchModeReset;
    private int mTouchSlop;
    private boolean mTxtLyricNotAutoScroll;
    private VelocityTracker mVelocityTracker;

    public class CheckForLongPress implements Runnable {
        public float x;
        public float y;

        @Override // java.lang.Runnable
        public void run() {
            Cell childCell;
            FixMultipleLineLyricView.this.mIsResponseToLongClick = true;
            if (FixMultipleLineLyricView.this.mClickCellPosition != -1 && FixMultipleLineLyricView.this.mCellGroup != null && (childCell = FixMultipleLineLyricView.this.mCellGroup.getChildCell(FixMultipleLineLyricView.this.mClickCellPosition)) != null && !FixMultipleLineLyricView.this.shouldInterceptClickEvent()) {
                FixMultipleLineLyricView fixMultipleLineLyricView = FixMultipleLineLyricView.this;
                if (fixMultipleLineLyricView.mCellLongClickEnable) {
                    CellGroup unused = fixMultipleLineLyricView.mCellGroup;
                    CellGroup.updateCellPressedStatus(childCell, false, FixMultipleLineLyricView.this);
                    if (FixMultipleLineLyricView.this.mClickCellPosition != 0) {
                        FixMultipleLineLyricView fixMultipleLineLyricView2 = FixMultipleLineLyricView.this;
                        BaseLyricView.OnCellLongClickListener onCellLongClickListener = fixMultipleLineLyricView2.mOnItemLongClickListener;
                        if (onCellLongClickListener != null) {
                            onCellLongClickListener.onItemLongClick(childCell, fixMultipleLineLyricView2.mClickCellPosition - 1, this.y);
                        }
                    } else if (FixMultipleLineLyricView.this.mOnHeaderItemClickListener != null) {
                        FixMultipleLineLyricView.this.mOnHeaderItemClickListener.onHeaderItemLongClick();
                    }
                }
            }
            FixMultipleLineLyricView.this.mClickCellPosition = -1;
        }

        private CheckForLongPress() {
        }
    }

    public final class CheckForTap implements Runnable {
        public float x;
        public float y;

        @Override // java.lang.Runnable
        public void run() {
            Cell childCell;
            FixMultipleLineLyricView fixMultipleLineLyricView = FixMultipleLineLyricView.this;
            fixMultipleLineLyricView.mClickCellPosition = fixMultipleLineLyricView.getTouchCellPosition(this.x, this.y);
            if (FixMultipleLineLyricView.this.mClickCellPosition == -1 || FixMultipleLineLyricView.this.mCellGroup == null || (childCell = FixMultipleLineLyricView.this.mCellGroup.getChildCell(FixMultipleLineLyricView.this.mClickCellPosition)) == null || !childCell.isInClickArea(this.x + FixMultipleLineLyricView.this.getScrollX(), this.y + FixMultipleLineLyricView.this.getScrollY()) || FixMultipleLineLyricView.this.shouldInterceptClickEvent()) {
                return;
            }
            FixMultipleLineLyricView fixMultipleLineLyricView2 = FixMultipleLineLyricView.this;
            if (fixMultipleLineLyricView2.mCellLongClickEnable) {
                CellGroup unused = fixMultipleLineLyricView2.mCellGroup;
                CellGroup.updateCellPressedStatus(childCell, true, FixMultipleLineLyricView.this);
            }
            if (FixMultipleLineLyricView.this.mPendingCheckForLongPress == null) {
                FixMultipleLineLyricView fixMultipleLineLyricView3 = FixMultipleLineLyricView.this;
                Objects.requireNonNull(fixMultipleLineLyricView3);
                fixMultipleLineLyricView3.mPendingCheckForLongPress = new CheckForLongPress();
            }
            FixMultipleLineLyricView.this.mPendingCheckForLongPress.x = this.x;
            FixMultipleLineLyricView.this.mPendingCheckForLongPress.y = this.y;
            FixMultipleLineLyricView fixMultipleLineLyricView4 = FixMultipleLineLyricView.this;
            fixMultipleLineLyricView4.postDelayed(fixMultipleLineLyricView4.mPendingCheckForLongPress, 300L);
        }

        private CheckForTap() {
        }
    }

    public class CheckScrollBack implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            FixMultipleLineLyricView.this.mPendingCheckScrollBack = null;
            if (FixMultipleLineLyricView.this.mOnLyricSlideListener != null && FixMultipleLineLyricView.this.mIsStartSliding) {
                FixMultipleLineLyricView.this.mIsStartSliding = false;
                if (!FixMultipleLineLyricView.this.isTxtLyric()) {
                    FixMultipleLineLyricView.this.mOnLyricSlideListener.onSlideTimeOut();
                }
            }
            if (FixMultipleLineLyricView.this.mIsAutoScrollBackToCurrentPosition) {
                FixMultipleLineLyricView fixMultipleLineLyricView = FixMultipleLineLyricView.this;
                fixMultipleLineLyricView.scrollToPosition(fixMultipleLineLyricView.mCurrentPosition);
            }
        }

        private CheckScrollBack() {
        }
    }

    public interface OnHeaderItemClickListener {
        void onHeaderItemClick();

        void onHeaderItemLongClick();
    }

    public interface OnLyricSlideListener {
        void onSlideTimeOut();

        void onSlidingMove(long j);

        void onSlidingStart();
    }

    public interface OnScrollListener {
        void onScrollStateChanged(FixMultipleLineLyricView fixMultipleLineLyricView, int i2);

        void onScrolled(FixMultipleLineLyricView fixMultipleLineLyricView, int i2, int i3);
    }

    public FixMultipleLineLyricView(Context context) {
        this(context, null);
    }

    private void autoScrollBackToCurrent() {
        if (getTargetCellScrollDistance(this.mCurrentPosition + 1) != getScrollY()) {
            if (this.mPendingCheckScrollBack == null) {
                this.mPendingCheckScrollBack = new CheckScrollBack();
            }
            removeCallbacks(this.mPendingCheckScrollBack);
            postDelayed(this.mPendingCheckScrollBack, 3000L);
        }
    }

    private void autoScrollToCenter() {
        post(new Runnable() { // from class: com.kugou.framework.lyric4.FixMultipleLineLyricView.4
            @Override // java.lang.Runnable
            public void run() {
                if (FixMultipleLineLyricView.this.mCellGroup == null || FixMultipleLineLyricView.this.mIsBeingDragged || FixMultipleLineLyricView.this.isTxtNoNeedAutoScroll()) {
                    return;
                }
                FixMultipleLineLyricView fixMultipleLineLyricView = FixMultipleLineLyricView.this;
                int targetCellScrollDistance = fixMultipleLineLyricView.getTargetCellScrollDistance(fixMultipleLineLyricView.mCurrentPosition + 1);
                if (!FixMultipleLineLyricView.this.mScroller.isFinished()) {
                    FixMultipleLineLyricView.this.mScroller.abortAnimation();
                }
                FixMultipleLineLyricView fixMultipleLineLyricView2 = FixMultipleLineLyricView.this;
                fixMultipleLineLyricView2.scrollTo(fixMultipleLineLyricView2.getScrollX(), targetCellScrollDistance);
            }
        });
    }

    private void checkBeginDraw(int i2) {
        if (Math.abs(i2) > this.mTouchSlop) {
            this.mIsBeingDragged = true;
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
    }

    private long getCenterCellPlayTime() {
        int scrollY = getScrollY() + (getMeasuredHeight() / 2);
        if (this.mCellGroup == null) {
            return -1L;
        }
        int iAbs = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = -1;
        for (int i3 = 0; i3 < this.mCellGroup.getCellSize(); i3++) {
            Cell childCell = this.mCellGroup.getChildCell(i3);
            if (Math.abs(childCell.getCellRect().centerY() - scrollY) < iAbs) {
                iAbs = Math.abs(childCell.getCellRect().centerY() - scrollY);
                i2 = i3;
            }
        }
        if (getLyricData() == null) {
            return -1L;
        }
        if (i2 == 0 && getLyricData().getRowBeginTime().length > 0) {
            return getLyricData().getRowBeginTime()[0];
        }
        int i4 = i2 - 1;
        if (i4 < 0 || i4 >= getLyricData().getRowBeginTime().length) {
            return -1L;
        }
        return getLyricData().getRowBeginTime()[i4];
    }

    private int getDefaultHeightMeasureSpec(int i2) {
        Paint paint = new Paint(1);
        paint.setTextSize(getAttachInfo().getTextSize());
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return View.MeasureSpec.makeMeasureSpec((int) ((this.mMaxRows * (fontMetrics.bottom - fontMetrics.top)) + (getAttachInfo().getCellRowMargin() * (this.mMaxRows - 1)) + getPaddingTop() + getPaddingBottom()), BasicMeasure.EXACTLY);
    }

    private int getScrollRange() {
        return Math.max(0, this.mTotalHeight - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTargetCellScrollDistance(int i2) {
        Cell childCell;
        CellGroup cellGroup = this.mCellGroup;
        if (cellGroup == null || (childCell = cellGroup.getChildCell(i2)) == null) {
            return 0;
        }
        return childCell.getCellRect().centerY() - (getMeasuredHeight() / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTouchCellPosition(float f2, float f3) {
        if (this.mCellGroup == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.mCellGroup.getCellSize(); i2++) {
            Cell childCell = this.mCellGroup.getChildCell(i2);
            if (childCell.getCellRect().top <= getScrollY() + f3 && childCell.getCellRect().bottom >= getScrollY() + f3) {
                return i2;
            }
        }
        return -1;
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext(), new DecelerateInterpolator());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = 0;
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mOverscrollDistance = viewConfiguration.getScaledOverscrollDistance();
        this.mOverflingDistance = viewConfiguration.getScaledOverflingDistance();
        this.mMaxYOverscrollDistance = 0;
        setOverScrollMode(0);
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean isMaxRowsSetted() {
        return this.mMaxRows != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTxtLyric() {
        return getLyricData() != null && getLyricData().getLyricType() == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTxtNoNeedAutoScroll() {
        return getLyricData() != null && getLyricData().getLyricType() == 3 && this.mTxtLyricNotAutoScroll;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            int i2 = action == 0 ? 1 : 0;
            this.mLastMotionY = motionEvent.getY(i2);
            this.mLastMotionX = motionEvent.getX(i2);
            this.mActivePointerId = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void onTouchCancel() {
        CellGroup cellGroup;
        int i2 = this.mClickCellPosition;
        if (i2 != -1 && (cellGroup = this.mCellGroup) != null) {
            CellGroup.updateCellPressedStatus(cellGroup.getChildCell(i2), false, this);
            this.mClickCellPosition = -1;
        }
        removeCallbacks(this.mPendingCheckForTap);
        removeCallbacks(this.mPendingCheckForLongPress);
        if (this.mIsBeingDragged) {
            if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                invalidate();
            } else {
                setScrollState(0);
            }
            this.mActivePointerId = -1;
            endDrag();
        }
    }

    private void onTouchDown(MotionEvent motionEvent) {
        if (!this.mScroller.isFinished()) {
            if (this.mIsFling) {
                this.mIsUserStopFling = true;
            }
            this.mScroller.abortAnimation();
        }
        if (this.mScrollState == 2) {
            setScrollState(1);
        }
        this.mLastMotionY = motionEvent.getY();
        this.mLastMotionX = motionEvent.getX();
        this.mDownY = motionEvent.getY();
        this.mActivePointerId = motionEvent.getPointerId(0);
        if (this.mCellClickEnable || this.mCellLongClickEnable) {
            this.mIsResponseToLongClick = false;
            if (this.mPendingCheckForTap == null) {
                this.mPendingCheckForTap = new CheckForTap();
            }
            this.mPendingCheckForTap.x = motionEvent.getX();
            this.mPendingCheckForTap.y = motionEvent.getY();
            postDelayed(this.mPendingCheckForTap, 500L);
        }
    }

    private void onTouchMove(MotionEvent motionEvent) {
        CellGroup cellGroup;
        CellGroup cellGroup2;
        int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
        float y = motionEvent.getY(iFindPointerIndex);
        float x = motionEvent.getX(iFindPointerIndex);
        int i2 = (int) (this.mLastMotionY - y);
        int i3 = (int) (this.mLastMotionX - x);
        this.mLastMotionY = y;
        this.mLastMotionX = x;
        float f2 = this.mDownY - y;
        checkBeginDraw(i3);
        if (Math.abs(i3) > this.mTouchSlop || this.mIsBeingDragged) {
            int i4 = this.mClickCellPosition;
            if (i4 != -1 && (cellGroup = this.mCellGroup) != null) {
                CellGroup.updateCellPressedStatus(cellGroup.getChildCell(i4), false, this);
                this.mClickCellPosition = -1;
            }
            removeCallbacks(this.mPendingCheckForTap);
            removeCallbacks(this.mPendingCheckForLongPress);
        }
        if ((Math.abs(f2) <= this.mTouchSlop && !this.mIsBeingDragged) || !this.mCanSlide) {
            this.mIsBeingDragged = false;
            return;
        }
        int i5 = this.mClickCellPosition;
        if (i5 != -1 && (cellGroup2 = this.mCellGroup) != null) {
            CellGroup.updateCellPressedStatus(cellGroup2.getChildCell(i5), false, this);
            this.mClickCellPosition = -1;
        }
        removeCallbacks(this.mPendingCheckForTap);
        removeCallbacks(this.mPendingCheckForLongPress);
        if (!this.mIsBeingDragged) {
            this.mIsStartedSlide = true;
            this.mIsStartSliding = true;
        }
        this.mIsBeingDragged = true;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        if (overScrollBy(0, i2, 0, getScrollY(), 0, getScrollRange(), 0, this.mMaxYOverscrollDistance, true)) {
            this.mVelocityTracker.clear();
        }
        setScrollState(1);
        onScrollChanged(getScrollX(), getScrollY(), scrollX, scrollY);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, getScrollX() - scrollX, getScrollY() - scrollY);
        }
        autoScrollBackToCurrent();
        if (this.mIsStartedSlide && this.mOnLyricSlideListener != null && this.mIsStartSliding) {
            if (!isTxtLyric()) {
                this.mOnLyricSlideListener.onSlidingStart();
            }
            this.mIsStartedSlide = false;
        }
        if (!this.mIsStartSliding || this.mOnLyricSlideListener == null || isTxtLyric()) {
            return;
        }
        this.mOnLyricSlideListener.onSlidingMove(getCenterCellPlayTime());
    }

    private void onTouchUp(final MotionEvent motionEvent) {
        CellGroup cellGroup;
        CellGroup cellGroup2;
        CellGroup cellGroup3;
        int i2 = this.mClickCellPosition;
        if (i2 != -1 && (cellGroup3 = this.mCellGroup) != null) {
            CellGroup.updateCellPressedStatus(cellGroup3.getChildCell(i2), false, this);
            this.mClickCellPosition = -1;
        }
        removeCallbacks(this.mPendingCheckForTap);
        removeCallbacks(this.mPendingCheckForLongPress);
        if (this.mIsBeingDragged) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int yVelocity = ((int) velocityTracker.getYVelocity(this.mActivePointerId)) * 2;
            if (Math.abs(yVelocity) > this.mMinimumVelocity) {
                this.mIsFling = true;
                fling(-yVelocity);
            } else if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                invalidate();
            } else {
                setScrollState(0);
            }
            this.mActivePointerId = -1;
            endDrag();
            return;
        }
        if (this.mIsUserStopFling) {
            this.mIsUserStopFling = false;
            return;
        }
        if (this.mIsResponseToLongClick) {
            return;
        }
        if (this.mCellClickEnable) {
            int touchCellPosition = getTouchCellPosition(motionEvent.getX(), motionEvent.getY());
            this.mClickCellPosition = touchCellPosition;
            if (touchCellPosition == -1 || (cellGroup2 = this.mCellGroup) == null) {
                return;
            }
            final Cell childCell = cellGroup2.getChildCell(touchCellPosition);
            if (childCell == null || !childCell.isInClickArea(motionEvent.getX() + getScrollX(), motionEvent.getY() + getScrollY()) || shouldInterceptClickEvent()) {
                handleClickEvent(motionEvent);
                return;
            }
            CellGroup.updateCellPressedStatus(childCell, true, this);
            Runnable runnable = this.mTouchModeReset;
            if (runnable != null) {
                removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: com.kugou.framework.lyric4.FixMultipleLineLyricView.1
                @Override // java.lang.Runnable
                public void run() {
                    FixMultipleLineLyricView.this.mTouchModeReset = null;
                    if (FixMultipleLineLyricView.this.mCellGroup != null) {
                        CellGroup unused = FixMultipleLineLyricView.this.mCellGroup;
                        CellGroup.updateCellPressedStatus(childCell, false, FixMultipleLineLyricView.this);
                    }
                    if (FixMultipleLineLyricView.this.mClickCellPosition == 0) {
                        FixMultipleLineLyricView fixMultipleLineLyricView = FixMultipleLineLyricView.this;
                        if (fixMultipleLineLyricView.mOnLyricViewBlankAreaClickListener != null && fixMultipleLineLyricView.isTouchInBlankArea(motionEvent.getX(), motionEvent.getY())) {
                            FixMultipleLineLyricView.this.mOnLyricViewBlankAreaClickListener.onLyricViewBlankAreaClick();
                            return;
                        } else if (FixMultipleLineLyricView.this.mOnHeaderItemClickListener != null) {
                            FixMultipleLineLyricView.this.mOnHeaderItemClickListener.onHeaderItemClick();
                        }
                    } else {
                        BaseLyricView.OnCellClickListener onCellClickListener = FixMultipleLineLyricView.this.mOnItemClickListener;
                        if (onCellClickListener != null) {
                            onCellClickListener.onItemClick(childCell, r0.mClickCellPosition - 1);
                        }
                    }
                    FixMultipleLineLyricView.this.mClickCellPosition = -1;
                }
            };
            this.mTouchModeReset = runnable2;
            postDelayed(runnable2, ViewConfiguration.getPressedStateDuration());
            return;
        }
        int touchCellPosition2 = getTouchCellPosition(motionEvent.getX(), motionEvent.getY());
        this.mClickCellPosition = touchCellPosition2;
        if (touchCellPosition2 != 0 || this.mOnHeaderItemClickListener == null || (cellGroup = this.mCellGroup) == null) {
            handleClickEvent(motionEvent);
            return;
        }
        final Cell childCell2 = cellGroup.getChildCell(touchCellPosition2);
        if (childCell2 == null || !childCell2.isInClickArea(motionEvent.getX() + getScrollX(), motionEvent.getY() + getScrollY()) || shouldInterceptClickEvent()) {
            handleClickEvent(motionEvent);
            return;
        }
        CellGroup.updateCellPressedStatus(childCell2, true, this);
        Runnable runnable3 = this.mTouchModeReset;
        if (runnable3 != null) {
            removeCallbacks(runnable3);
        }
        Runnable runnable4 = new Runnable() { // from class: com.kugou.framework.lyric4.FixMultipleLineLyricView.2
            @Override // java.lang.Runnable
            public void run() {
                FixMultipleLineLyricView.this.mTouchModeReset = null;
                if (FixMultipleLineLyricView.this.mCellGroup != null) {
                    CellGroup unused = FixMultipleLineLyricView.this.mCellGroup;
                    CellGroup.updateCellPressedStatus(childCell2, false, FixMultipleLineLyricView.this);
                }
                if (FixMultipleLineLyricView.this.mClickCellPosition == 0) {
                    FixMultipleLineLyricView fixMultipleLineLyricView = FixMultipleLineLyricView.this;
                    if (fixMultipleLineLyricView.mOnLyricViewBlankAreaClickListener != null && fixMultipleLineLyricView.isTouchInBlankArea(motionEvent.getX(), motionEvent.getY())) {
                        FixMultipleLineLyricView.this.mOnLyricViewBlankAreaClickListener.onLyricViewBlankAreaClick();
                        return;
                    } else if (FixMultipleLineLyricView.this.mOnHeaderItemClickListener != null) {
                        FixMultipleLineLyricView.this.mOnHeaderItemClickListener.onHeaderItemClick();
                    }
                }
                FixMultipleLineLyricView.this.mClickCellPosition = -1;
            }
        };
        this.mTouchModeReset = runnable4;
        postDelayed(runnable4, ViewConfiguration.getPressedStateDuration());
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setScrollState(int i2) {
        if (i2 != this.mScrollState) {
            this.mScrollState = i2;
            if (i2 != 2) {
                this.mScroller.abortAnimation();
            }
            OnScrollListener onScrollListener = this.mScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(this, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldInterceptClickEvent() {
        BaseLyricView.OnClickInterceptListener onClickInterceptListener = this.mOnClickInterceptListener;
        if (onClickInterceptListener != null) {
            return onClickInterceptListener.shouldInterceptEvent();
        }
        return false;
    }

    private void updateCellGroup() {
        if (getMeasuredWidth() <= 0 || getMeasuredHeight() <= 0) {
            return;
        }
        if (this.mIsFadeMode) {
            this.mCellGroup = new TransparentGradientCellGroup(getContext(), this, getAlphaCellValue());
        } else {
            this.mCellGroup = new RestrictedDrawCellGroup(getContext(), this);
        }
        if (this.mCellAdapter == null && getLyricData() != null) {
            setAdapter(new LyricLineCellAdapter(getContext(), getLyricData(), getAttachInfo()));
        }
        CellAdapter cellAdapter = this.mCellAdapter;
        if (cellAdapter == null || cellAdapter.getCount() == 0) {
            return;
        }
        Cell cell = this.mCellAdapter.getCell(0);
        cell.measure(getMeasuredWidth(), getMeasuredHeight());
        CellAdapter cellAdapter2 = this.mCellAdapter;
        Cell cell2 = cellAdapter2.getCell(cellAdapter2.getCount() - 1);
        cell2.measure(getMeasuredWidth(), getMeasuredHeight());
        if (getLyricData() != null && getLyricData().getLyricType() == 3) {
            this.mCellGroup.addChildCell(new TxtHeaderCell(getContext(), (cell.getHeight() / 2) + cell.getMarginTop(), getAttachInfo()));
        } else if (this.mHeaderText != null) {
            this.mCellGroup.addChildCell(new HeaderCell(getContext(), (cell.getHeight() / 2) + cell.getMarginTop(), this.mHeaderText, getAttachInfo()));
        } else {
            this.mCellGroup.addChildCell(new EmptyCell(getContext(), (cell.getHeight() / 2) + cell.getMarginTop()));
        }
        for (int i2 = 0; i2 < this.mCellAdapter.getCount(); i2++) {
            this.mCellGroup.addChildCell(this.mCellAdapter.getCell(i2));
        }
        if (this.mFooterText != null) {
            this.mCellGroup.addChildCell(new FooterCell(getContext(), (cell2.getHeight() / 2) + cell2.getMarginBottom(), this.mFooterText, getAttachInfo()));
        } else {
            this.mCellGroup.addChildCell(new EmptyCell(getContext(), (cell2.getHeight() / 2) + cell2.getMarginBottom()));
        }
        this.mCellGroup.measure(getMeasuredWidth(), getMeasuredHeight());
        CellGroup cellGroup = this.mCellGroup;
        cellGroup.layout(0, 0, cellGroup.getWidth(), this.mCellGroup.getHeight());
        this.mTotalHeight = this.mCellGroup.getHeight();
        this.mIsCellLayoutValid = true;
        if (isMaxRowsSetted()) {
            requestLayout();
        }
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public boolean checkChangeLineInside(int i2, int i3) {
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.mScroller.computeScrollOffset()) {
            this.mIsFling = false;
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            int i2 = currX - scrollX;
            int i3 = currY - scrollY;
            overScrollBy(i2, i3, scrollX, scrollY, 0, getScrollRange(), 0, this.mOverflingDistance, false);
            onScrollChanged(getScrollX(), getScrollY(), scrollX, scrollY);
            OnScrollListener onScrollListener = this.mScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScrolled(this, i2, i3);
            }
            if (this.mOnLyricSlideListener != null && this.mIsFling && !isTxtLyric()) {
                this.mOnLyricSlideListener.onSlidingMove(getCenterCellPlayTime());
            }
        }
        if (!this.mScroller.isFinished()) {
            postInvalidateOnAnimation();
        } else {
            this.mIsFling = false;
            setScrollState(0);
        }
    }

    public void fling(int i2) {
        setScrollState(2);
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        this.mScroller.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, 0, Math.max(0, this.mTotalHeight - height), 0, height / 2);
        invalidate();
    }

    public float getAlphaCellValue() {
        return this.alphaCellValue;
    }

    public boolean isHideHalfLine() {
        return getAttachInfo().isHideHalfLine();
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public boolean isTouchInBlankArea(float f2, float f3) {
        CellGroup cellGroup;
        Cell childCell;
        int touchCellPosition = getTouchCellPosition(f2, f3);
        if (touchCellPosition == -1 || (cellGroup = this.mCellGroup) == null || (childCell = cellGroup.getChildCell(touchCellPosition)) == null) {
            return false;
        }
        return childCell.isInBlankArea(f2, f3 + getScrollY());
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mIsCellLayoutValid) {
            updateCellGroup();
        }
        CellGroup cellGroup = this.mCellGroup;
        if (cellGroup == null || cellGroup.isEmpty()) {
            drawDefaultMessage(canvas);
        } else {
            this.mCellGroup.draw(canvas);
        }
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void onLyricDataSet(LyricData lyricData) {
        setAdapter(new LyricLineCellAdapter(getContext(), lyricData, getAttachInfo()));
        if (lyricData.getLyricType() == 3) {
            setIsAutoScrollBackToCurrentPosition(false);
        } else {
            setIsAutoScrollBackToCurrentPosition(true);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (!isMaxRowsSetted()) {
            super.onMeasure(i2, i3);
            return;
        }
        CellGroup cellGroup = this.mCellGroup;
        if (cellGroup == null || cellGroup.getCellSize() < 2) {
            super.onMeasure(i2, getDefaultHeightMeasureSpec(i3));
            return;
        }
        if (this.mCellGroup.getCellSize() < this.mMaxRows) {
            super.onMeasure(i2, getDefaultHeightMeasureSpec(i3));
            return;
        }
        int size = View.MeasureSpec.getSize(i3);
        int singleLineHeight = (this.mMaxRows * this.mCellGroup.getChildCell(1).getSingleLineHeight()) + getPaddingTop() + getPaddingBottom();
        if (singleLineHeight >= size) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(i2, View.MeasureSpec.makeMeasureSpec(singleLineHeight, BasicMeasure.EXACTLY));
        }
    }

    @Override // android.view.View
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        if (this.mScroller.isFinished()) {
            super.scrollTo(i2, i3);
        } else {
            setScrollX(i2);
            setScrollY(i3);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        autoScrollToCenter();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        CellGroup cellGroup;
        try {
            if (this.mDisableTouchEvent) {
                return super.onTouchEvent(motionEvent);
            }
            if ((!this.mCanSlide && !this.mCellClickEnable && !this.mCellLongClickEnable) || (cellGroup = this.mCellGroup) == null || cellGroup.isEmpty()) {
                if ((motionEvent.getAction() & 255) != 0 && (motionEvent.getAction() & 255) == 1) {
                    handleClickEvent(motionEvent);
                }
                return true;
            }
            initVelocityTrackerIfNotExists();
            this.mVelocityTracker.addMovement(motionEvent);
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                onTouchDown(motionEvent);
            } else if (action == 1) {
                onTouchUp(motionEvent);
            } else if (action == 2) {
                onTouchMove(motionEvent);
            } else if (action == 3) {
                onTouchCancel();
            } else if (action == 5) {
                int actionIndex = motionEvent.getActionIndex();
                float x = motionEvent.getX(actionIndex);
                this.mLastMotionY = motionEvent.getY(actionIndex);
                this.mLastMotionX = x;
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            } else if (action == 6) {
                onSecondaryPointerUp(motionEvent);
                this.mLastMotionY = motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
                this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
            }
            return true;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return super.onTouchEvent(motionEvent);
        }
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void reScrollToCenter() {
        if (this.mCellGroup == null || this.mIsBeingDragged || isTxtNoNeedAutoScroll()) {
            return;
        }
        smoothScrollTo(getScrollX(), getTargetCellScrollDistance(this.mCurrentPosition + 1));
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView, com.kugou.framework.lyric.ILyricView
    public void release() {
        super.release();
        this.mWeakHandler.post(new Runnable() { // from class: com.kugou.framework.lyric4.FixMultipleLineLyricView.3
            @Override // java.lang.Runnable
            public void run() {
                FixMultipleLineLyricView.this.mCellGroup = null;
                FixMultipleLineLyricView.this.mCellAdapter = null;
                FixMultipleLineLyricView fixMultipleLineLyricView = FixMultipleLineLyricView.this;
                fixMultipleLineLyricView.mIsCellLayoutValid = false;
                fixMultipleLineLyricView.mClickCellPosition = -1;
                FixMultipleLineLyricView.this.getAttachInfo().setLanguage(Language.Origin);
                if (FixMultipleLineLyricView.this.mScroller != null) {
                    FixMultipleLineLyricView.this.mScroller.abortAnimation();
                }
                FixMultipleLineLyricView.this.scrollTo(0, 0);
                FixMultipleLineLyricView.this.invalidate();
            }
        });
    }

    public void scrollToPosition(int i2) {
        if (this.mCellGroup == null || this.mIsBeingDragged || isTxtNoNeedAutoScroll()) {
            return;
        }
        smoothScrollTo(getScrollX(), getTargetCellScrollDistance(i2 + 1));
    }

    public void setAdapter(CellAdapter cellAdapter) {
        this.mCellAdapter = cellAdapter;
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setCurrentPosition(int i2) {
        if (this.mCurrentPosition != i2) {
            this.mCurrentPosition = i2;
            if (this.mPendingCheckScrollBack == null) {
                scrollToPosition(i2);
            }
        }
    }

    public void setFadeMode(boolean z) {
        this.mIsFadeMode = z;
    }

    public void setFooterStyle(int i2, int i3) {
        getAttachInfo().setFooterTextColor(i2);
        getAttachInfo().setFooterTextSize(i3);
    }

    public void setFooterText(String str) {
        this.mFooterText = str;
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setHeaderStyle(int i2, int i3) {
        getAttachInfo().setHeaderTextColor(i2);
        getAttachInfo().setHeaderTextSize(i3);
    }

    public void setHeaderText(String str) {
        this.mHeaderText = str;
    }

    public void setHeaderVisible(boolean z) {
        Cell childCell;
        this.mHeaderVisible = z;
        CellGroup cellGroup = this.mCellGroup;
        if (cellGroup == null || (childCell = cellGroup.getChildCell(0)) == null || !(childCell instanceof HeaderCell)) {
            return;
        }
        ((HeaderCell) childCell).setMessageVisible(z);
        invalidate();
    }

    public void setHideHalfLine(boolean z) {
        getAttachInfo().setHideHalfLine(z);
        postInvalidate();
    }

    public void setIsAutoScrollBackToCurrentPosition(boolean z) {
        this.mIsAutoScrollBackToCurrentPosition = z;
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void setLanguage(Language language) {
        super.setLanguage(language);
        autoScrollToCenter();
    }

    public void setMaxRows(int i2) {
        this.mMaxRows = i2;
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setOnHeaderItemClickListener(OnHeaderItemClickListener onHeaderItemClickListener) {
        this.mOnHeaderItemClickListener = onHeaderItemClickListener;
    }

    public void setOnLyricSlideListener(OnLyricSlideListener onLyricSlideListener) {
        this.mOnLyricSlideListener = onLyricSlideListener;
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void setScaleHighLightWord(boolean z) {
        super.setScaleHighLightWord(z);
        autoScrollToCenter();
    }

    public void setScrollListener(OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void setTextSize(int i2) {
        super.setTextSize(i2);
        autoScrollToCenter();
    }

    public void setTxtLyricNotAutoScroll(boolean z) {
        this.mTxtLyricNotAutoScroll = z;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        int visibility = getVisibility();
        super.setVisibility(i2);
        if (i2 == visibility || i2 != 0) {
            return;
        }
        autoScrollToCenter();
    }

    public final void smoothScrollBy(int i2, int i3) {
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 520) {
            int iMax = Math.max(0, this.mTotalHeight - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
            int scrollY = getScrollY();
            int iMax2 = Math.max(0, Math.min(i3 + scrollY, iMax)) - scrollY;
            setScrollState(2);
            this.mScroller.startScroll(getScrollX(), scrollY, 0, iMax2, 500);
            postInvalidateOnAnimation();
        } else {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            scrollBy(i2, i3);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    public void smoothScrollTo(int i2, int i3) {
        smoothScrollBy(i2 - getScrollX(), i3 - getScrollY());
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void startChangeLineAnimation(int i2, int i3) {
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void updateView() {
        setCurrentPosition(getAttachInfo().getCurrentHighLightLine());
        invalidate();
    }

    public FixMultipleLineLyricView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FixMultipleLineLyricView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        this.mScrollState = 0;
        this.mIsAutoScrollBackToCurrentPosition = true;
        this.mClickCellPosition = -1;
        this.mIsFling = false;
        this.mIsStartSliding = false;
        this.mIsStartedSlide = false;
        this.mHeaderVisible = true;
        this.mIsFadeMode = true;
        this.mMaxRows = -1;
        this.mIsUserStopFling = false;
        this.mTxtLyricNotAutoScroll = false;
        this.alphaCellValue = 1.3f;
        initScrollView();
    }
}
