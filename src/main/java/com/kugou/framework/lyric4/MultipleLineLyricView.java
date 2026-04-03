package com.kugou.framework.lyric4;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.OverScroller;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.debug.LyricDebug;
import com.kugou.framework.lyric.loader.language.Language;
import com.kugou.framework.lyric4.BaseLyricView;
import com.kugou.framework.lyric4.Entity.BulletinEntity;
import com.kugou.framework.lyric4.adapter.CellAdapter;
import com.kugou.framework.lyric4.adapter.LyricLineCellAdapter;
import com.kugou.framework.lyric4.cell.Cell;
import com.kugou.framework.lyric4.cell.CellGroup;
import com.kugou.framework.lyric4.cell.OnlyPlayingLineCellGroup;
import com.kugou.framework.lyric4.cell.RestrictedDrawCellGroup;
import com.kugou.framework.lyric4.cell.TransparentGradientCellGroup;
import com.kugou.framework.lyric4.cell.breakline.LyricLineInfo;
import com.kugou.framework.lyric4.cell.lyric.BulletinButtonCell;
import com.kugou.framework.lyric4.cell.lyric.BulletinTextCell;
import com.kugou.framework.lyric4.cell.lyric.CantoneseCell;
import com.kugou.framework.lyric4.cell.lyric.CopyRightCell;
import com.kugou.framework.lyric4.cell.lyric.EmptyCell;
import com.kugou.framework.lyric4.cell.lyric.FooterCell;
import com.kugou.framework.lyric4.cell.lyric.HeaderCell;
import com.kugou.framework.lyric4.cell.lyric.LyricMakerCell;
import com.kugou.framework.lyric4.cell.lyric.TxtHeaderCell;
import com.kugou.framework.lyric4.cell.lyric.WrapLineHighLightCell;
import com.kugou.framework.lyric4.span.Span;
import com.kugou.framework.lyric4.utils.SpanUtil;
import com.kugou.framework.lyric4.utils.Utils;
import com.kugou.framework.lyricanim.LyricDataUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MultipleLineLyricView extends BaseLyricView {
    public static final int ANIMATED_SCROLL_GAP = 520;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_Y_OVERSCROLL_DISTANCE = 100;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final String TAG = "MultipleLineLyricView";
    private boolean GLRenderEnable;
    private boolean GlRenderNotifyFlag;
    private float alphaCellValue;
    private CalPreludeTimeListener calPreludeTimeListener;
    private boolean canShowSelected;
    private boolean disableAutoScroll;
    private boolean disableScrollBack;
    private boolean isForbiddenSmallScroll;
    private boolean isOnlyShowPlayingLine;
    public boolean isPinTopMode;
    public boolean isPressed;
    private int mActivePointerId;
    private BulletinEntity mBulletinEntity;
    private OnCantoneseClickListener mCantoneseClickListener;
    private Bitmap mCantoneseCover;
    private int mCantoneseIconRes;
    private String mCantoneseText;
    public CellAdapter mCellAdapter;
    public CellGroup mCellGroup;
    private Cell mClickCell;
    private int mClickCellPosition;
    private Span mClickSpan;
    private String mCopyrightText;
    public int mCurrentPosition;
    public float mDownX;
    public float mDownY;
    private String mFooterText;
    private String mHeaderText;
    private boolean mHeaderVisible;
    private boolean mIsAutoScrollBackToCurrentPosition;
    public boolean mIsBeingDragged;
    private boolean mIsFadeMode;
    private boolean mIsFling;
    private boolean mIsResponseToLongClick;
    private boolean mIsStartSliding;
    private boolean mIsStartedSlide;
    private boolean mIsUserStopFling;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mLastRightCellLyricPosition;
    private long mLastScroll;
    private CellGroupListener mListener;
    private int mLyricContributorArrowIconRes;
    private float mLyricMakerLineSpacing;
    private String mLyricProducerName;
    private String mLyricTranslatorName;
    private String mLyricTransliterName;
    private OnLyricMakerClickListener mMakerClickListener;
    private int mMaxRows;
    private int mMaxYOverscrollDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private BaseLyricView.OnCellExposeListener mOnCellExposeListener;
    private OnHeaderItemClickListener mOnHeaderItemClickListener;
    private OnLyricSellExposeListener mOnLyricSellExposeListener;
    private OnLyricSlideListener mOnLyricSlideListener;
    private BaseLyricView.OnTouchInterceptListener mOnTouchInterceptListener;
    private int mOverflingDistance;
    private int mOverscrollDistance;
    private CheckForLongPress mPendingCheckForLongPress;
    private CheckForTap mPendingCheckForTap;
    private CheckScrollBack mPendingCheckScrollBack;
    public long mPreludeTime;
    private OnScrollListener mScrollListener;
    private int mScrollState;
    private OverScroller mScroller;
    private int mSelectPos;
    public boolean mSingleLineScrollMode;
    private int mTotalHeight;
    private Runnable mTouchModeReset;
    private int mTouchSlop;
    private boolean mTxtLyricNotAutoScroll;
    private float mUpX;
    private float mUpY;
    private VelocityTracker mVelocityTracker;
    private int maxSmoothY;
    public int miniCell;
    private int pinTopDistance;
    private boolean refreshCellGroupDelay;
    private float rowHeight;
    private Runnable scrollCenterAction;
    private int scrollDelayTime;
    private float scrollOffsetScale;
    private int scrollRangeOffset;
    private float zoomRate;

    public interface CalPreludeTimeListener {
        long calPreludeTime(LyricData lyricData);
    }

    public interface CellGroupListener {
        void onCellGroupPrelude();

        void onCellGroupUpdated(float f2, boolean z);
    }

    public class CheckForLongPress implements Runnable {
        public float x;
        public float y;

        private CheckForLongPress() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultipleLineLyricView multipleLineLyricView;
            CellGroup cellGroup;
            Cell childCell;
            MultipleLineLyricView.this.mIsResponseToLongClick = true;
            if (MultipleLineLyricView.this.mClickCellPosition != -1 && (cellGroup = (multipleLineLyricView = MultipleLineLyricView.this).mCellGroup) != null && (childCell = cellGroup.getChildCell(multipleLineLyricView.mClickCellPosition)) != null && !MultipleLineLyricView.this.shouldInterceptClickEvent()) {
                MultipleLineLyricView multipleLineLyricView2 = MultipleLineLyricView.this;
                if (multipleLineLyricView2.mCellLongClickEnable) {
                    CellGroup cellGroup2 = multipleLineLyricView2.mCellGroup;
                    CellGroup.updateCellPressedStatus(childCell, false, multipleLineLyricView2);
                    if (MultipleLineLyricView.this.mClickCellPosition != 0) {
                        MultipleLineLyricView multipleLineLyricView3 = MultipleLineLyricView.this;
                        BaseLyricView.OnCellLongClickListener onCellLongClickListener = multipleLineLyricView3.mOnItemLongClickListener;
                        if (onCellLongClickListener != null) {
                            onCellLongClickListener.onItemLongClick(childCell, multipleLineLyricView3.mClickCellPosition - 1, this.y);
                        }
                    } else if (MultipleLineLyricView.this.mOnHeaderItemClickListener != null) {
                        MultipleLineLyricView.this.mOnHeaderItemClickListener.onHeaderItemLongClick();
                    }
                }
            }
            MultipleLineLyricView.this.mClickCellPosition = -1;
        }
    }

    public final class CheckForTap implements Runnable {
        public float x;
        public float y;

        private CheckForTap() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultipleLineLyricView multipleLineLyricView;
            CellGroup cellGroup;
            Cell childCell;
            MultipleLineLyricView multipleLineLyricView2 = MultipleLineLyricView.this;
            multipleLineLyricView2.mClickCellPosition = multipleLineLyricView2.getTouchCellPosition(this.x, this.y);
            if (MultipleLineLyricView.this.mClickCellPosition == -1 || (cellGroup = (multipleLineLyricView = MultipleLineLyricView.this).mCellGroup) == null || (childCell = cellGroup.getChildCell(multipleLineLyricView.mClickCellPosition)) == null || !childCell.isInClickArea(this.x + MultipleLineLyricView.this.getScrollX(), this.y + MultipleLineLyricView.this.getScrollY()) || MultipleLineLyricView.this.shouldInterceptClickEvent()) {
                return;
            }
            MultipleLineLyricView multipleLineLyricView3 = MultipleLineLyricView.this;
            if (multipleLineLyricView3.mCellLongClickEnable) {
                CellGroup cellGroup2 = multipleLineLyricView3.mCellGroup;
                CellGroup.updateCellPressedStatus(childCell, true, multipleLineLyricView3);
            }
            if (MultipleLineLyricView.this.mPendingCheckForLongPress == null) {
                MultipleLineLyricView multipleLineLyricView4 = MultipleLineLyricView.this;
                multipleLineLyricView4.mPendingCheckForLongPress = new CheckForLongPress();
            }
            MultipleLineLyricView.this.log("CheckForTap mPendingCheckForLongPress");
            MultipleLineLyricView.this.mPendingCheckForLongPress.x = this.x;
            MultipleLineLyricView.this.mPendingCheckForLongPress.y = this.y;
            MultipleLineLyricView multipleLineLyricView5 = MultipleLineLyricView.this;
            multipleLineLyricView5.postDelayed(multipleLineLyricView5.mPendingCheckForLongPress, 300L);
        }
    }

    public class CheckScrollBack implements Runnable {
        private CheckScrollBack() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultipleLineLyricView.this.recoverSlideStatus();
            if (MultipleLineLyricView.this.mIsAutoScrollBackToCurrentPosition && !MultipleLineLyricView.this.disableAutoScroll) {
                MultipleLineLyricView multipleLineLyricView = MultipleLineLyricView.this;
                multipleLineLyricView.scrollToPosition(multipleLineLyricView.mCurrentPosition);
            }
            MultipleLineLyricView.this.mPendingCheckScrollBack = null;
        }
    }

    public interface OnCantoneseClickListener {
        void OnCantoneseClickListener();
    }

    public interface OnHeaderItemClickListener {
        void onHeaderItemClick();

        void onHeaderItemLongClick();
    }

    public interface OnLyricMakerClickListener {
        void onLyricMakerInfoClick(int i2);
    }

    public interface OnLyricSellExposeListener {
        void OnLyricSellExpose(Cell cell);
    }

    public interface OnLyricSlideEndListener extends OnLyricSlideListener {
        void onSlidingEnd();
    }

    public interface OnLyricSlideListener {
        void onSlideTimeOut();

        void onSlidingMove(long j);

        void onSlidingStart();
    }

    public interface OnScrollListener {
        void onScrollFinished();

        void onScrollFinished(long j);

        void onScrollStateChanged(MultipleLineLyricView multipleLineLyricView, int i2);

        void onScrolled(MultipleLineLyricView multipleLineLyricView, int i2, int i3);
    }

    public MultipleLineLyricView(Context context) {
        this(context, null);
    }

    private void checkFlingFinish() {
        if (this.mIsFling) {
            if (getAttachInfo().isShowSelectBgMode()) {
                getAttachInfo().getExtraDrawSpan().setFling(false);
            }
            OnScrollListener onScrollListener = this.mScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScrollFinished();
            }
            if (this.mPendingCheckScrollBack != null) {
                autoScrollBackToCurrent();
            }
        }
        this.mIsFling = false;
    }

    private boolean checkInsideLineChanged(int i2, LyricLineInfo[] lyricLineInfoArr) {
        int length = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < lyricLineInfoArr.length && i2 > (lyricLineInfoArr[i4].getLyricWords().length + length) - 1; i4++) {
            i3++;
            length += lyricLineInfoArr[i4].getLyricWords().length;
        }
        if (this.lastInsideLineIndex == i3) {
            return false;
        }
        this.lastInsideLineIndex = i3;
        return true;
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.disableScrollBack = false;
        recycleVelocityTracker();
        OnLyricSlideListener onLyricSlideListener = this.mOnLyricSlideListener;
        if (onLyricSlideListener instanceof OnLyricSlideEndListener) {
            ((OnLyricSlideEndListener) onLyricSlideListener).onSlidingEnd();
        }
    }

    private Pair<Long, Cell> getCenterCellPlayTime(boolean z) {
        if (this.scrollOffsetScale <= 1.0f) {
            this.scrollOffsetScale = 2.0f;
        }
        int scrollY = getScrollY() + ((int) (getMeasuredHeight() / this.scrollOffsetScale));
        long j = -1;
        Cell childCell = null;
        if (this.mCellGroup != null) {
            int iAbs = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i2 = -1;
            for (int i3 = 0; i3 < this.mCellGroup.getCellSize(); i3++) {
                Cell childCell2 = this.mCellGroup.getChildCell(i3);
                if (!(childCell2 instanceof EmptyCell)) {
                    if (z) {
                        childCell2.setShowSelectLine(false);
                    }
                    if (Math.abs(childCell2.getCellRect().centerY() - scrollY) < iAbs) {
                        iAbs = Math.abs(childCell2.getCellRect().centerY() - scrollY);
                        i2 = i3;
                        childCell = childCell2;
                    }
                }
            }
            if (i2 == -1) {
                childCell = this.mCellGroup.getChildCell(0);
                i2 = 0;
            }
            if (getLyricData() != null) {
                if (i2 == 0 && getLyricData().getRowBeginTime().length > 0) {
                    j = getLyricData().getRowBeginTime()[0];
                }
                int i4 = i2 - 1;
                if (i4 >= 0 && i4 < getLyricData().getRowBeginTime().length) {
                    j = getLyricData().getRowBeginTime()[i4];
                }
                if (i4 >= 0 && i2 > getLyricData().getRowBeginTime().length) {
                    j = getLyricData().getRowBeginTime()[getLyricData().getRowBeginTime().length - 1];
                }
            }
        }
        return new Pair<>(Long.valueOf(j), childCell);
    }

    private int getDefaultHeightMeasureSpec(int i2) {
        return View.MeasureSpec.makeMeasureSpec((int) ((this.mMaxRows * getRowHeight()) + (getAttachInfo().getCellRowMargin() * (this.mMaxRows - 1)) + getPaddingTop() + getPaddingBottom()), BasicMeasure.EXACTLY);
    }

    private int getScrollRange() {
        return Math.max(0, (this.mTotalHeight - ((getHeight() - getPaddingBottom()) - getPaddingTop())) + this.scrollRangeOffset);
    }

    private int getTargetCellScrollDistance(int i2) {
        Cell childCell;
        CellGroup cellGroup = this.mCellGroup;
        if (cellGroup == null || (childCell = cellGroup.getChildCell(i2)) == null) {
            return 0;
        }
        int iCenterY = (int) (childCell.getCellRect().centerY() - (getMeasuredHeight() / this.scrollOffsetScale));
        if (this.isPinTopMode) {
            int iAbs = Math.abs(iCenterY);
            int i3 = this.pinTopDistance;
            if (iAbs < i3) {
                return i3;
            }
        }
        return iCenterY;
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
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.scrollOffsetScale = 2.0f;
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity() / 3;
        this.mOverscrollDistance = viewConfiguration.getScaledOverscrollDistance();
        this.mOverflingDistance = viewConfiguration.getScaledOverflingDistance();
        this.mMaxYOverscrollDistance = Utils.dip2px(getContext(), 100.0f);
        setOverScrollMode(1);
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean isMaxRowsSetted() {
        return this.mMaxRows != -1;
    }

    private boolean isTxtNoNeedAutoScroll() {
        return getLyricData() != null && getLyricData().getLyricType() == 3 && this.mTxtLyricNotAutoScroll;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        Log.i(TAG, "zchen-" + str);
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
        this.isPressed = false;
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
        this.isPressed = true;
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
        this.mClickSpan = null;
        this.mDownX = motionEvent.getX();
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
        this.disableScrollBack = false;
        float f2 = this.mDownY - y;
        if (Math.abs(i3) > this.mTouchSlop || this.mIsBeingDragged) {
            this.isPressed = false;
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
        this.isPressed = false;
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
            this.canShowSelected = true;
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
        if (this.mIsStartSliding) {
            log("onTouchMove mIsStartSliding");
            AttachInfo attachInfo = this.mAttachInfo;
            if (attachInfo != null) {
                attachInfo.setIsSliding(true);
            }
        }
        if (!this.mIsStartSliding || this.mOnLyricSlideListener == null || isTxtLyric() || isPureMusic()) {
            return;
        }
        Pair<Long, Cell> centerCellPlayTime = getCenterCellPlayTime(true);
        if (this.canShowSelected) {
            ((Cell) centerCellPlayTime.second).setShowSelectLine(true);
            this.mSelectPos = ((Cell) centerCellPlayTime.second).getLine();
        }
        this.mOnLyricSlideListener.onSlidingMove(((Long) centerCellPlayTime.first).longValue());
        OnLyricSellExposeListener onLyricSellExposeListener = this.mOnLyricSellExposeListener;
        if (onLyricSellExposeListener != null) {
            onLyricSellExposeListener.OnLyricSellExpose((Cell) centerCellPlayTime.second);
        }
    }

    private void onTouchUp(final MotionEvent motionEvent) {
        CellGroup cellGroup;
        OnCantoneseClickListener onCantoneseClickListener;
        CellGroup cellGroup2;
        CellGroup cellGroup3;
        this.isPressed = false;
        this.mUpX = motionEvent.getX();
        this.mUpY = motionEvent.getY();
        Span clickSpan = getClickSpan();
        this.mClickSpan = clickSpan;
        if (clickSpan != null) {
            this.mIsUserStopFling = !this.mScroller.isFinished();
        } else if (this.mOnNewCellClickListener != null) {
            int touchCellPosition = getTouchCellPosition(motionEvent.getX(), motionEvent.getY());
            LyricDebug.e("yijunwu_ly", "clickCellPosition:" + touchCellPosition);
            if (touchCellPosition != -1 && this.mCellGroup != null) {
                LyricDebug.e("yijunwu_ly", "mClickCell:" + this.mCellGroup);
                Cell childCell = this.mCellGroup.getChildCell(touchCellPosition);
                if (childCell.isInClick(motionEvent.getX() + getScrollX(), motionEvent.getY() + getScrollY())) {
                    this.mClickCell = childCell;
                }
            }
            if (this.mClickCell != null) {
                this.mIsUserStopFling = !this.mScroller.isFinished();
            }
        }
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
            int yVelocity = (int) velocityTracker.getYVelocity(this.mActivePointerId);
            if (Math.abs(yVelocity) > this.mMinimumVelocity) {
                this.mIsFling = true;
                fling(-yVelocity);
            } else if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                invalidate();
            } else {
                setScrollState(0);
                if (this.mScrollListener != null && !isTxtLyric()) {
                    this.mScrollListener.onScrollFinished(((Long) getCenterCellPlayTime(false).first).longValue());
                }
            }
            this.mActivePointerId = -1;
            endDrag();
            return;
        }
        if (this.mIsUserStopFling) {
            LyricDebug.e("yijunwu_ly", "update mIsUserStopFling=" + this.mIsUserStopFling);
            this.mIsUserStopFling = false;
            return;
        }
        if (this.mIsResponseToLongClick) {
            return;
        }
        if (this.mCellClickEnable) {
            int touchCellPosition2 = getTouchCellPosition(motionEvent.getX(), motionEvent.getY());
            this.mClickCellPosition = touchCellPosition2;
            if (touchCellPosition2 == -1 || (cellGroup2 = this.mCellGroup) == null) {
                return;
            }
            final Cell childCell2 = cellGroup2.getChildCell(touchCellPosition2);
            if (childCell2 == null || !childCell2.isInClickArea(motionEvent.getX() + getScrollX(), motionEvent.getY() + getScrollY()) || shouldInterceptClickEvent()) {
                handleClickEvent(motionEvent, this.mCellGroup.getChildCell(this.mClickCellPosition) == null || !this.mCellGroup.getChildCell(this.mClickCellPosition).getShowSelectLine());
                return;
            }
            CellGroup.updateCellPressedStatus(childCell2, true, this);
            Runnable runnable = this.mTouchModeReset;
            if (runnable != null) {
                removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: com.kugou.framework.lyric4.MultipleLineLyricView.1
                @Override // java.lang.Runnable
                public void run() {
                    MultipleLineLyricView.this.mTouchModeReset = null;
                    MultipleLineLyricView multipleLineLyricView = MultipleLineLyricView.this;
                    if (multipleLineLyricView.mCellGroup != null) {
                        CellGroup.updateCellPressedStatus(childCell2, false, multipleLineLyricView);
                    }
                    if (MultipleLineLyricView.this.mClickCellPosition == 0) {
                        MultipleLineLyricView multipleLineLyricView2 = MultipleLineLyricView.this;
                        if (multipleLineLyricView2.mOnLyricViewBlankAreaClickListener != null && multipleLineLyricView2.isTouchInBlankArea(motionEvent.getX(), motionEvent.getY())) {
                            MultipleLineLyricView.this.mOnLyricViewBlankAreaClickListener.onLyricViewBlankAreaClick();
                            return;
                        } else if (MultipleLineLyricView.this.mOnHeaderItemClickListener != null) {
                            MultipleLineLyricView.this.mOnHeaderItemClickListener.onHeaderItemClick();
                        }
                    } else if (MultipleLineLyricView.this.mMakerClickListener != null) {
                        MultipleLineLyricView multipleLineLyricView3 = MultipleLineLyricView.this;
                        if (multipleLineLyricView3.mCellGroup.getChildCell(multipleLineLyricView3.mClickCellPosition) instanceof LyricMakerCell) {
                            MultipleLineLyricView multipleLineLyricView4 = MultipleLineLyricView.this;
                            MultipleLineLyricView.this.mMakerClickListener.onLyricMakerInfoClick(((LyricMakerCell) multipleLineLyricView4.mCellGroup.getChildCell(multipleLineLyricView4.mClickCellPosition)).calculateIndex(motionEvent.getX() + MultipleLineLyricView.this.getScrollX(), motionEvent.getY() + MultipleLineLyricView.this.getScrollY()));
                            return;
                        }
                    } else if (MultipleLineLyricView.this.mCantoneseClickListener != null) {
                        MultipleLineLyricView multipleLineLyricView5 = MultipleLineLyricView.this;
                        if (multipleLineLyricView5.mCellGroup.getChildCell(multipleLineLyricView5.mClickCellPosition) instanceof CantoneseCell) {
                            MultipleLineLyricView.this.mCantoneseClickListener.OnCantoneseClickListener();
                            return;
                        }
                    } else {
                        BaseLyricView.OnCellClickListener onCellClickListener = MultipleLineLyricView.this.mOnItemClickListener;
                        if (onCellClickListener != null) {
                            onCellClickListener.onItemClick(childCell2, r0.mClickCellPosition - 1);
                        }
                    }
                    MultipleLineLyricView.this.mClickCellPosition = -1;
                }
            };
            this.mTouchModeReset = runnable2;
            postDelayed(runnable2, ViewConfiguration.getPressedStateDuration());
            return;
        }
        int touchCellPosition3 = getTouchCellPosition(motionEvent.getX(), motionEvent.getY());
        this.mClickCellPosition = touchCellPosition3;
        CellGroup cellGroup4 = this.mCellGroup;
        if (cellGroup4 != null && (cellGroup4.getChildCell(touchCellPosition3) instanceof LyricMakerCell) && this.mMakerClickListener != null) {
            this.mMakerClickListener.onLyricMakerInfoClick(((LyricMakerCell) this.mCellGroup.getChildCell(this.mClickCellPosition)).calculateIndex(motionEvent.getX() + getScrollX(), motionEvent.getY() + getScrollY()));
            return;
        }
        CellGroup cellGroup5 = this.mCellGroup;
        if (cellGroup5 != null && (cellGroup5.getChildCell(this.mClickCellPosition) instanceof CantoneseCell) && (onCantoneseClickListener = this.mCantoneseClickListener) != null) {
            onCantoneseClickListener.OnCantoneseClickListener();
            return;
        }
        int i3 = this.mClickCellPosition;
        if (i3 != 0 || this.mOnHeaderItemClickListener == null || (cellGroup = this.mCellGroup) == null) {
            CellGroup cellGroup6 = this.mCellGroup;
            handleClickEvent(motionEvent, cellGroup6 == null || cellGroup6.getChildCell(i3) == null || !this.mCellGroup.getChildCell(this.mClickCellPosition).getShowSelectLine());
            return;
        }
        final Cell childCell3 = cellGroup.getChildCell(i3);
        if (childCell3 == null || !childCell3.isInClickArea(motionEvent.getX() + getScrollX(), motionEvent.getY() + getScrollY()) || shouldInterceptClickEvent()) {
            handleClickEvent(motionEvent, this.mCellGroup.getChildCell(this.mClickCellPosition) == null || !this.mCellGroup.getChildCell(this.mClickCellPosition).getShowSelectLine());
            return;
        }
        CellGroup.updateCellPressedStatus(childCell3, true, this);
        Runnable runnable3 = this.mTouchModeReset;
        if (runnable3 != null) {
            removeCallbacks(runnable3);
        }
        Runnable runnable4 = new Runnable() { // from class: com.kugou.framework.lyric4.MultipleLineLyricView.2
            @Override // java.lang.Runnable
            public void run() {
                MultipleLineLyricView.this.mTouchModeReset = null;
                MultipleLineLyricView multipleLineLyricView = MultipleLineLyricView.this;
                if (multipleLineLyricView.mCellGroup != null) {
                    CellGroup.updateCellPressedStatus(childCell3, false, multipleLineLyricView);
                }
                if (MultipleLineLyricView.this.mClickCellPosition == 0) {
                    MultipleLineLyricView multipleLineLyricView2 = MultipleLineLyricView.this;
                    if (multipleLineLyricView2.mOnLyricViewBlankAreaClickListener != null && multipleLineLyricView2.isTouchInBlankArea(motionEvent.getX(), motionEvent.getY())) {
                        MultipleLineLyricView.this.mOnLyricViewBlankAreaClickListener.onLyricViewBlankAreaClick();
                        return;
                    } else if (MultipleLineLyricView.this.mOnHeaderItemClickListener != null) {
                        MultipleLineLyricView.this.mOnHeaderItemClickListener.onHeaderItemClick();
                    }
                }
                MultipleLineLyricView.this.mClickCellPosition = -1;
            }
        };
        this.mTouchModeReset = runnable4;
        postDelayed(runnable4, ViewConfiguration.getPressedStateDuration());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recoverSlideStatus() {
        log("recoverSlideStatus");
        CheckScrollBack checkScrollBack = this.mPendingCheckScrollBack;
        if (checkScrollBack == null || this.mOnLyricSlideListener == null || !this.mIsStartSliding || this.mIsBeingDragged) {
            return;
        }
        removeCallbacks(checkScrollBack);
        this.mPendingCheckScrollBack = null;
        this.mIsStartSliding = false;
        if (isTxtLyric()) {
            return;
        }
        log("recoverSlideStatus mOnLyricSlideListener.onSlideTimeOut");
        this.mOnLyricSlideListener.onSlideTimeOut();
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private boolean returnOnTouch(boolean z) {
        BaseLyricView.OnTouchInterceptListener onTouchInterceptListener = this.mOnTouchInterceptListener;
        return onTouchInterceptListener == null || onTouchInterceptListener.OnTouchIntercept() || z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToCurPos() {
        Cell childCell;
        if (this.refreshCellGroupDelay) {
            updateCellGroup();
        }
        if (this.mCellGroup == null || this.mIsBeingDragged || isTxtNoNeedAutoScroll()) {
            return;
        }
        int targetCellScrollDistance = getTargetCellScrollDistance(this.mCurrentPosition + 1);
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        recoverSlideStatus();
        CellGroup cellGroup = this.mCellGroup;
        boolean zIsCellWholeVisible = (cellGroup == null || (childCell = cellGroup.getChildCell(this.mCurrentPosition + 1)) == null) ? false : childCell.isCellWholeVisible();
        if (targetCellScrollDistance == 0 || Math.abs(targetCellScrollDistance - getScrollY()) >= this.rowHeight || !(zIsCellWholeVisible || this.isForbiddenSmallScroll)) {
            scrollTo(getScrollX(), targetCellScrollDistance);
            this.disableScrollBack = false;
        }
    }

    private void setScrollState(int i2) {
        if (i2 == this.mScrollState) {
            return;
        }
        this.mScrollState = i2;
        if (i2 != 2) {
            this.mScroller.abortAnimation();
        }
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i2);
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

    private void smoothScrollBy(int i2, int i3) {
        if (!this.disableScrollBack || i3 >= 0) {
            this.disableScrollBack = false;
            if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll <= 520 || (this.maxSmoothY > 0 && Math.abs(i3) >= this.maxSmoothY)) {
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                scrollBy(i2, i3);
            } else {
                int iMax = Math.max(0, this.mTotalHeight - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                int iMax2 = Math.max(0, Math.min(i3 + scrollY, iMax)) - scrollY;
                setScrollState(2);
                this.mScroller.startScroll(getScrollX(), scrollY, 0, iMax2, 500);
                postInvalidateOnAnimation();
            }
            this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    @TargetApi(21)
    private void toSetContentDescription() {
        if (this.mCellGroup == null || !isAccessibilityFocused()) {
            return;
        }
        int i2 = this.mLastRightCellLyricPosition;
        int i3 = this.mCurrentPosition;
        if (i2 == i3) {
            return;
        }
        this.mLastRightCellLyricPosition = i3;
        String rightCellLyricLine = this.mCellGroup.getRightCellLyricLine(i3 + 1);
        if (this.mCurrentPosition % 2 != 0) {
            setContentDescription(rightCellLyricLine);
            return;
        }
        setContentDescription(rightCellLyricLine + " ");
    }

    public void autoScrollBackToCurrent() {
        if (this.scrollDelayTime <= 0) {
            this.scrollDelayTime = 3000;
        }
        autoScrollBackToCurrent(this.scrollDelayTime);
    }

    public void autoScrollToCenter() {
        if (this.disableAutoScroll) {
            return;
        }
        removeCallbacks(this.scrollCenterAction);
        Runnable runnable = new Runnable() { // from class: com.kugou.framework.lyric4.MultipleLineLyricView.6
            @Override // java.lang.Runnable
            public void run() {
                if (MultipleLineLyricView.this.disableAutoScroll) {
                    return;
                }
                MultipleLineLyricView.this.scrollToCurPos();
            }
        };
        this.scrollCenterAction = runnable;
        postDelayed(runnable, 100L);
    }

    public void calculatePreludeTime() {
        if (this.mPreludeTime != -1) {
            return;
        }
        CalPreludeTimeListener calPreludeTimeListener = this.calPreludeTimeListener;
        if (calPreludeTimeListener != null) {
            this.mPreludeTime = calPreludeTimeListener.calPreludeTime(getLyricData());
        } else {
            this.mPreludeTime = LyricDataUtils.calculatePreludeTime(getLyricData());
        }
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void changeGLRenderFlag() {
        super.changeGLRenderFlag();
        if (this.GLRenderEnable) {
            this.GlRenderNotifyFlag = true;
            calculatePreludeTime();
            CellGroupListener cellGroupListener = this.mListener;
            if (cellGroupListener == null || this.mPreludeTime == -1) {
                return;
            }
            cellGroupListener.onCellGroupUpdated(this.zoomRate, checkHasPassPrePlay(getAttachInfo().getCurrentHighLightLine()));
        }
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public boolean checkChangeLineInside(int i2, int i3) {
        CellGroup cellGroup;
        if (this.GLRenderEnable && (cellGroup = this.mCellGroup) != null && cellGroup.getCellSize() > 0) {
            Cell childCell = this.mCellGroup.getChildCell(i2 + 1);
            if (childCell instanceof WrapLineHighLightCell) {
                return checkInsideLineChanged(i3, ((WrapLineHighLightCell) childCell).getLyricLineInfos());
            }
            if (childCell instanceof CellGroup) {
                Cell childCell2 = ((CellGroup) childCell).getChildCell(0);
                if (childCell2 instanceof WrapLineHighLightCell) {
                    return checkInsideLineChanged(i3, ((WrapLineHighLightCell) childCell2).getLyricLineInfos());
                }
            }
        }
        return true;
    }

    public boolean checkHasPassPrePlay(int i2) {
        if (!this.GLRenderEnable || getLyricData() == null) {
            return false;
        }
        if ((getLyricData().getLyricType() == 3 && getLyricData().getLyricType() == 2) || this.mPreludeTime == -1) {
            return false;
        }
        return (getAttachInfo() == null || getAttachInfo().getSpanMaps() == null || getAttachInfo().getSpanMaps().length <= i2 || getAttachInfo().getSpanMaps()[i2] == null || getAttachInfo().getSpanMaps()[i2].size() == 0) && getLyricData().getRowBeginTime()[Math.min(i2, getLyricData().getRowBeginTime().length)] + getLyricData().getRowDelayTime()[Math.min(i2, getLyricData().getRowDelayTime().length)] > this.mPreludeTime;
    }

    public void clearCellSelectState() {
        this.canShowSelected = false;
        this.mSelectPos = -1;
        CellGroup cellGroup = this.mCellGroup;
        if (cellGroup != null) {
            cellGroup.clearSelectCell();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.mScroller.computeScrollOffset()) {
            checkFlingFinish();
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
            if (this.mIsFling && this.mPendingCheckScrollBack != null) {
                autoScrollBackToCurrent();
            }
            if (this.mOnLyricSlideListener != null && this.mIsFling && !isTxtLyric() && !isPureMusic()) {
                Pair<Long, Cell> centerCellPlayTime = getCenterCellPlayTime(true);
                if (this.canShowSelected) {
                    this.mSelectPos = ((Cell) centerCellPlayTime.second).getLine();
                    ((Cell) centerCellPlayTime.second).setShowSelectLine(true);
                }
                if (Math.abs(i3) < 3 && getAttachInfo().isShowSelectBgMode()) {
                    getAttachInfo().getExtraDrawSpan().setFling(false);
                }
                this.mOnLyricSlideListener.onSlidingMove(((Long) centerCellPlayTime.first).longValue());
                OnLyricSellExposeListener onLyricSellExposeListener = this.mOnLyricSellExposeListener;
                if (onLyricSellExposeListener != null) {
                    onLyricSellExposeListener.OnLyricSellExpose((Cell) centerCellPlayTime.second);
                }
            }
        }
        if (!this.mScroller.isFinished()) {
            postInvalidateOnAnimation();
            return;
        }
        log("mScroller.isFinished()");
        checkFlingFinish();
        setScrollState(0);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void fastScroll(int i2, int i3) {
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        scrollBy(i2 - getScrollX(), i3 - getScrollY());
    }

    public void fling(int i2) {
        setScrollState(2);
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int i3 = this.mTotalHeight;
        if (getAttachInfo().isShowSelectBgMode() && Math.abs(i2) > this.mMinimumVelocity * 30) {
            getAttachInfo().getExtraDrawSpan().setFling(true);
        }
        this.mScroller.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, 0, Math.max(0, i3 - height), 0, (int) (height / this.scrollOffsetScale));
        invalidate();
    }

    public float getAlphaCellValue() {
        return this.alphaCellValue;
    }

    public Span getClickSpan() {
        float f2 = this.mUpX;
        float f3 = this.mUpY;
        LyricDebug.e("yijunwu_ly", "x=" + f2 + ",y=" + f3 + ",ScrollY=" + getScrollY() + ",mDownX=" + this.mDownX + ",mDownY=" + this.mDownY);
        float f4 = this.mDownX;
        float f5 = this.mDownY;
        if (!SpanUtil.hit(f4 - 10.0f, f5 - 10.0f, f4 + 10.0f, f5 + 10.0f, f2, f3)) {
            return null;
        }
        for (Span span : SpanUtil.mapChangeList(getAttachInfo().getSpanMaps())) {
            LyricDebug.e("yijunwu_ly", span.toString());
            if (span != null && span.isNeedClick() && SpanUtil.hit(span, getScrollX() + f2, getScrollY() + f3)) {
                LyricDebug.e("yijunwu_ly", "span. hit");
                return span;
            }
        }
        return null;
    }

    public boolean getGlRenderNotifyFlag() {
        return this.GlRenderNotifyFlag;
    }

    public BaseLyricView.OnTouchInterceptListener getOnTouchInterceptListener() {
        return this.mOnTouchInterceptListener;
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView, com.kugou.framework.lyric.ILyricView
    public float getRowHeight() {
        Paint paint = new Paint(1);
        paint.setTextSize(getAttachInfo().getTextSize());
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = fontMetrics.bottom - fontMetrics.top;
        this.rowHeight = f2;
        return f2;
    }

    public int getSelectPos() {
        return this.mSelectPos;
    }

    public boolean hasClick() {
        int touchCellPosition = getTouchCellPosition(this.mDownX, this.mDownY);
        CellGroup cellGroup = this.mCellGroup;
        if ((cellGroup == null || !(cellGroup.getChildCell(touchCellPosition) instanceof LyricMakerCell)) && this.mClickSpan == null) {
            return (this.mOnNewCellClickListener == null || this.mClickCell == null) ? false : true;
        }
        return true;
    }

    public void hideHighLightLine() {
        getAttachInfo().setShowHighLight(false);
        updateView();
    }

    public boolean isAutoScrollBackToCurrentPosition() {
        return this.mIsAutoScrollBackToCurrentPosition;
    }

    public boolean isGLRenderEnable() {
        return this.GLRenderEnable;
    }

    public boolean isHideHalfLine() {
        return getAttachInfo().isHideHalfLine();
    }

    public boolean isPureMusic() {
        return getLyricData() == null || getLyricData().getWords() == null || getLyricData().getWords().length <= 1;
    }

    public boolean isShowLineZoomAnimation() {
        CellGroup cellGroup = this.mCellGroup;
        if (cellGroup == null || cellGroup.isEmpty()) {
            return false;
        }
        return this.mCellGroup.showAnimation;
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public boolean isTouchInBlankArea(float f2, float f3) {
        int touchCellPosition;
        CellGroup cellGroup;
        Cell childCell;
        if (this.mClickSpan != null || (touchCellPosition = getTouchCellPosition(f2, f3)) == -1 || (cellGroup = this.mCellGroup) == null || (childCell = cellGroup.getChildCell(touchCellPosition)) == null) {
            return false;
        }
        return childCell.isInBlankArea(f2, f3 + getScrollY());
    }

    public boolean isTxtLyric() {
        return getLyricData() != null && getLyricData().getLyricType() == 3;
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public boolean onClick() {
        Cell cell;
        Span span = this.mClickSpan;
        this.mClickSpan = null;
        if (span != null) {
            span.onClick(span);
            return true;
        }
        BaseLyricView.OnNewCellClickListener onNewCellClickListener = this.mOnNewCellClickListener;
        if (onNewCellClickListener == null || (cell = this.mClickCell) == null) {
            return false;
        }
        this.mClickCell = null;
        onNewCellClickListener.onClick(cell);
        return true;
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mIsCellLayoutValid) {
            this.disableAutoScroll = false;
            this.disableScrollBack = false;
            updateCellGroup();
            if (this.isPinTopMode && this.mCurrentPosition <= 0 && !isTxtLyric() && !isPureMusic()) {
                fastScroll(getScrollX(), this.pinTopDistance);
            }
        }
        CellGroup cellGroup = this.mCellGroup;
        if (cellGroup == null || cellGroup.isEmpty()) {
            drawDefaultMessage(canvas);
            return;
        }
        this.mCellGroup.showHighLight(getAttachInfo().getShowHighLightLine());
        CellGroup cellGroup2 = this.mCellGroup;
        if (cellGroup2.showAnimation) {
            cellGroup2.measureCellWithAnimation(getMeasuredWidth(), getMeasuredHeight(), this.zoomRate);
            CellGroup cellGroup3 = this.mCellGroup;
            cellGroup3.layout(0, 0, cellGroup3.getWidth(), this.mCellGroup.getHeight());
            this.mTotalHeight = this.mCellGroup.getHeight();
            this.mCellGroup.drawAnimation(canvas, this.zoomRate);
            if (this.mListener == null || !this.GlRenderNotifyFlag) {
                return;
            }
            if (this.mPreludeTime == -1 || !checkHasPassPrePlay(getAttachInfo().getCurrentHighLightLine())) {
                this.mListener.onCellGroupPrelude();
                return;
            } else {
                this.mListener.onCellGroupUpdated(this.zoomRate, checkHasPassPrePlay(getAttachInfo().getCurrentHighLightLine()));
                return;
            }
        }
        cellGroup2.measureCell(getMeasuredWidth(), getMeasuredHeight(), getTextHighLightZoom());
        CellGroup cellGroup4 = this.mCellGroup;
        cellGroup4.layout(0, 0, cellGroup4.getWidth(), this.mCellGroup.getHeight());
        this.mTotalHeight = this.mCellGroup.getHeight();
        this.mCellGroup.draw(canvas);
        if (this.mListener == null || !this.GlRenderNotifyFlag) {
            return;
        }
        if (this.mPreludeTime == -1 || !checkHasPassPrePlay(getAttachInfo().getCurrentHighLightLine())) {
            this.mListener.onCellGroupPrelude();
        } else {
            this.mListener.onCellGroupUpdated(getAttachInfo().getHighLightTextZoomRate(), checkHasPassPrePlay(getAttachInfo().getCurrentHighLightLine()));
        }
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void onLyricDataSet(LyricData lyricData) {
        this.mPreludeTime = -1L;
        calculatePreludeTime();
        if (this.GLRenderEnable) {
            this.mWeakHandler.removeMessages(3);
            this.mWeakHandler.sendEmptyMessageDelayed(3, 600L);
        }
        setDisableScrollBack(false);
        setDisableAutoScroll(false);
        setAdapter(new LyricLineCellAdapter(getContext(), lyricData, getAttachInfo()));
        if (lyricData.getLyricType() == 3 || !this.supportScroll) {
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
            BaseLyricView.OnTouchInterceptListener onTouchInterceptListener = this.mOnTouchInterceptListener;
            if (onTouchInterceptListener != null && onTouchInterceptListener.shouldInterceptEvent(motionEvent)) {
                return false;
            }
            if ((this.mCanSlide || this.mCellClickEnable || this.mCellLongClickEnable) && (cellGroup = this.mCellGroup) != null && !cellGroup.isEmpty()) {
                initVelocityTrackerIfNotExists();
                this.mVelocityTracker.addMovement(motionEvent);
                int action = motionEvent.getAction();
                boolean z = this.isPressed;
                int i2 = action & 255;
                if (i2 == 0) {
                    onTouchDown(motionEvent);
                } else if (i2 == 1) {
                    onTouchUp(motionEvent);
                } else if (i2 == 2) {
                    onTouchMove(motionEvent);
                } else if (i2 == 3) {
                    onTouchCancel();
                } else if (i2 == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    float x = motionEvent.getX(actionIndex);
                    this.mLastMotionY = motionEvent.getY(actionIndex);
                    this.mLastMotionX = x;
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                } else if (i2 == 6) {
                    onSecondaryPointerUp(motionEvent);
                    this.mLastMotionY = motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
                    this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                }
                return returnOnTouch(z);
            }
            if ((motionEvent.getAction() & 255) == 0) {
                return returnOnTouch(false);
            }
            if ((motionEvent.getAction() & 255) == 1) {
                handleClickEvent(motionEvent);
            }
            return returnOnTouch(false);
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
        this.mWeakHandler.post(new Runnable() { // from class: com.kugou.framework.lyric4.MultipleLineLyricView.5
            @Override // java.lang.Runnable
            public void run() {
                MultipleLineLyricView multipleLineLyricView = MultipleLineLyricView.this;
                multipleLineLyricView.mCellGroup = null;
                multipleLineLyricView.mCellAdapter = null;
                multipleLineLyricView.mIsCellLayoutValid = false;
                multipleLineLyricView.mClickCellPosition = -1;
                MultipleLineLyricView multipleLineLyricView2 = MultipleLineLyricView.this;
                multipleLineLyricView2.mPreludeTime = -1L;
                ValueAnimator valueAnimator = multipleLineLyricView2.animator;
                if (valueAnimator != null) {
                    valueAnimator.removeAllUpdateListeners();
                    MultipleLineLyricView.this.animator.removeAllListeners();
                    MultipleLineLyricView.this.animator.cancel();
                    MultipleLineLyricView.this.animator = null;
                }
                MultipleLineLyricView.this.getAttachInfo().setLanguage(Language.Origin);
                if (MultipleLineLyricView.this.mScroller != null) {
                    MultipleLineLyricView.this.mScroller.abortAnimation();
                }
                MultipleLineLyricView.this.scrollTo(0, 0);
                MultipleLineLyricView.this.invalidate();
            }
        });
    }

    public void resetTouch() {
        this.mDownY = 0.0f;
        this.mDownX = 0.0f;
        this.mIsBeingDragged = false;
        this.isPressed = false;
        removeCallbacks(this.mPendingCheckForTap);
        removeCallbacks(this.mPendingCheckForLongPress);
    }

    public void scrollToPosManual(long j, boolean z) {
        this.mIsStartSliding = true;
        int iUpdateCurrentLine = updateCurrentLine(j, getLyricData().getRowBeginTime(), getLyricData().getRowDelayTime(), getLyricData().getWordBeginTime());
        if (this.mCellGroup != null && z) {
            int i2 = 0;
            while (i2 < this.mCellGroup.getCellSize()) {
                Cell childCell = this.mCellGroup.getChildCell(i2);
                if (childCell != null) {
                    childCell.setShowSelectLine(i2 == iUpdateCurrentLine + 1);
                }
                i2++;
            }
        }
        int targetCellScrollDistance = getTargetCellScrollDistance(iUpdateCurrentLine + 1);
        if (targetCellScrollDistance > 0) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            scrollBy(0, targetCellScrollDistance - getScrollY());
        }
        autoScrollBackToCurrent();
    }

    public void scrollToPosition(int i2) {
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo != null) {
            attachInfo.setIsSliding(false);
        }
        log("scrollToPosition");
        if (!this.disableScrollBack && this.refreshCellGroupDelay) {
            updateCellGroup();
        }
        if (this.mCellGroup == null || this.mIsBeingDragged || isTxtNoNeedAutoScroll()) {
            return;
        }
        int targetCellScrollDistance = getTargetCellScrollDistance(i2 + 1);
        recoverSlideStatus();
        smoothScrollTo(getScrollX(), targetCellScrollDistance);
    }

    public void setAdapter(CellAdapter cellAdapter) {
        this.mCellAdapter = cellAdapter;
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setAnimationType(int i2) {
        if (i2 == 1) {
            this.mScaleHighLightLine = false;
            getAttachInfo().setScaleHighLightWord(false);
        } else if (i2 == 2) {
            this.mScaleHighLightLine = false;
            getAttachInfo().setScaleHighLightWord(true);
        } else if (i2 == 3) {
            this.mScaleHighLightLine = true;
            getAttachInfo().setScaleHighLightWord(false);
        }
        calculatePreludeTime();
        this.mIsCellLayoutValid = false;
        invalidate();
        autoScrollToCenter();
    }

    public void setBulletinEntity(BulletinEntity bulletinEntity) {
        this.mBulletinEntity = bulletinEntity;
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setCalPreludeTimeListener(CalPreludeTimeListener calPreludeTimeListener) {
        this.calPreludeTimeListener = calPreludeTimeListener;
    }

    public void setCantoneseInfo(Bitmap bitmap, String str, int i2) {
        this.mCantoneseCover = bitmap;
        this.mCantoneseText = str;
        this.mCantoneseIconRes = i2;
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setCantoneseTextColor(int i2) {
        CantoneseCell cantoneseCell;
        CellGroup cellGroup = this.mCellGroup;
        if (cellGroup == null || (cantoneseCell = cellGroup.getCantoneseCell()) == null) {
            return;
        }
        cantoneseCell.setCantoneseTextColor(i2);
    }

    public void setCellGroupListener(CellGroupListener cellGroupListener) {
        this.mListener = cellGroupListener;
    }

    public void setClimaxTime(long j, long j2) {
        AttachInfo attachInfo = getAttachInfo();
        if (attachInfo != null) {
            attachInfo.setClimaxStartTime(j);
            attachInfo.setClimaxEndTime(j2);
            LyricData lyricData = getLyricData();
            calculatePreludeTime();
            if (lyricData != null && lyricData.getRowBeginTime() != null && lyricData.getRowBeginTime().length > 1) {
                for (int i2 = 0; i2 < lyricData.getRowBeginTime().length; i2++) {
                    if (attachInfo.isShowClimax(lyricData.getRowBeginTime()[i2]) && lyricData.getRowBeginTime()[i2] >= this.mPreludeTime) {
                        attachInfo.setClimaxLine(i2);
                        return;
                    }
                }
            }
            attachInfo.setClimaxLine(-1);
        }
    }

    public void setCopyRightText(String str) {
        this.mCopyrightText = str;
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setCurrentPosition(int i2) {
        if (this.mCurrentPosition == i2) {
            return;
        }
        this.mCurrentPosition = i2;
        if (this.mPendingCheckScrollBack == null) {
            scrollToPosition(i2);
        }
    }

    public void setDisableAutoScroll(boolean z) {
        this.disableAutoScroll = z;
    }

    public void setDisableScrollBack(boolean z) {
        this.disableScrollBack = z;
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

    public void setForbiddenSmallScroll(boolean z) {
        this.isForbiddenSmallScroll = z;
    }

    public void setGLRenderEnable(boolean z) {
        this.GLRenderEnable = z;
        this.GlRenderNotifyFlag = z;
        if (z) {
            calculatePreludeTime();
        }
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setGlRenderNotifyFlag(boolean z) {
        this.GlRenderNotifyFlag = z;
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

    public void setIsBeingDragged(boolean z) {
        this.mIsBeingDragged = z;
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void setLanguage(Language language) {
        super.setLanguage(language);
        autoScrollToCenter();
    }

    public void setLyricMakerInfo(String str, String str2, String str3, int i2) {
        this.mLyricProducerName = str;
        this.mLyricTranslatorName = str2;
        this.mLyricTransliterName = str3;
        this.mLyricContributorArrowIconRes = i2;
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setLyricMakerLineSpacing(float f2) {
        this.mLyricMakerLineSpacing = f2;
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setLyricMakerTextColor(int i2) {
        LyricMakerCell lyricMakerCell;
        CellGroup cellGroup = this.mCellGroup;
        if (cellGroup == null || (lyricMakerCell = cellGroup.getLyricMakerCell()) == null) {
            return;
        }
        lyricMakerCell.setLyricMakerTextColor(i2);
    }

    public void setMaxRows(int i2) {
        this.mMaxRows = i2;
        this.mIsCellLayoutValid = false;
        postInvalidate();
    }

    public void setMaxSmoothY(int i2) {
        this.maxSmoothY = i2;
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void setMultiTextSize(int i2, int i3, int i4, int i5) {
        super.setMultiTextSize(i2, i3, i4, i5);
        getRowHeight();
        autoScrollToCenter();
    }

    public void setOnCantoneseClickListener(OnCantoneseClickListener onCantoneseClickListener) {
        this.mCantoneseClickListener = onCantoneseClickListener;
    }

    public void setOnCellExposeListener(BaseLyricView.OnCellExposeListener onCellExposeListener) {
        CantoneseCell cantoneseCell;
        CellGroup cellGroup = this.mCellGroup;
        if (cellGroup != null && (cantoneseCell = cellGroup.getCantoneseCell()) != null) {
            cantoneseCell.setOnCellExposeListener(onCellExposeListener);
        }
        this.mOnCellExposeListener = onCellExposeListener;
    }

    public void setOnHeaderItemClickListener(OnHeaderItemClickListener onHeaderItemClickListener) {
        this.mOnHeaderItemClickListener = onHeaderItemClickListener;
    }

    public void setOnLyricMakerClickListener(OnLyricMakerClickListener onLyricMakerClickListener) {
        this.mMakerClickListener = onLyricMakerClickListener;
    }

    public void setOnLyricSellExposeListener(OnLyricSellExposeListener onLyricSellExposeListener) {
        this.mOnLyricSellExposeListener = onLyricSellExposeListener;
    }

    public void setOnLyricSlideListener(OnLyricSlideListener onLyricSlideListener) {
        this.mOnLyricSlideListener = onLyricSlideListener;
    }

    public void setOnlyShowPlayingLine(boolean z) {
        this.isOnlyShowPlayingLine = z;
        this.mIsCellLayoutValid = false;
        postInvalidate();
    }

    public void setPinTopMode(boolean z) {
        this.isPinTopMode = z;
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void setScaleHighLightWord(boolean z) {
        super.setScaleHighLightWord(z);
        autoScrollToCenter();
    }

    public void setScrollDelayTime(int i2) {
        this.scrollDelayTime = i2;
    }

    public void setScrollListener(OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setScrollOffsetScale(float f2, boolean z) {
        if (f2 <= 1.0f) {
            f2 = 2.0f;
        }
        this.scrollOffsetScale = f2;
        this.refreshCellGroupDelay = z;
        if (z) {
            return;
        }
        updateCellGroup();
        scrollToCurPos();
    }

    public void setScrollRangeOffset(int i2) {
        this.scrollRangeOffset = i2;
    }

    public void setShowTopHalfLine(boolean z) {
        getAttachInfo().setShowTopHalfLine(z);
        postInvalidate();
    }

    public void setSingleLineScrollMode(boolean z) {
        if (this.mSingleLineScrollMode != z) {
            this.mSingleLineScrollMode = z;
            this.mIsCellLayoutValid = false;
        }
    }

    public void setSpanMaps(Map<Integer, Span>[] mapArr) {
        getAttachInfo().setSpanMaps(mapArr);
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void setTextHighLightZoom(float f2) {
        super.setTextHighLightZoom(f2);
        autoScrollToCenter();
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void setTextSize(int i2) {
        super.setTextSize(i2);
        getRowHeight();
        autoScrollToCenter();
    }

    public void setTouchInterceptListener(BaseLyricView.OnTouchInterceptListener onTouchInterceptListener) {
        this.mOnTouchInterceptListener = onTouchInterceptListener;
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

    public void showHighLightLine() {
        getAttachInfo().setShowHighLight(true);
        updateView();
    }

    public void smoothScrollTo(int i2, int i3) {
        if (i3 == 0 || Math.abs(i3 - getScrollY()) >= this.rowHeight) {
            smoothScrollBy(i2 - getScrollX(), i3 - getScrollY());
        }
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void startChangeLineAnimation(int i2, int i3) {
        CellGroup cellGroup = this.mCellGroup;
        if (cellGroup != null) {
            cellGroup.preIndex = i2;
            cellGroup.currentIndex = i3;
            cellGroup.showAnimation = true;
            if (this.animator == null) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, getAttachInfo().getHighLightTextZoomRate());
                this.animator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                this.animator.setDuration(150L);
                this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kugou.framework.lyric4.MultipleLineLyricView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        MultipleLineLyricView multipleLineLyricView = MultipleLineLyricView.this;
                        multipleLineLyricView.zoomRate = ((Float) multipleLineLyricView.animator.getAnimatedValue()).floatValue();
                        MultipleLineLyricView.this.invalidate();
                    }
                });
                this.animator.addListener(new Animator.AnimatorListener() { // from class: com.kugou.framework.lyric4.MultipleLineLyricView.4
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        MultipleLineLyricView.this.mCellGroup.showAnimation = false;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        MultipleLineLyricView.this.mCellGroup.showAnimation = false;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
            if (this.animator.isRunning()) {
                this.animator.cancel();
            }
            this.animator.setFloatValues(1.0f, getAttachInfo().getHighLightTextZoomRate());
            this.animator.start();
        }
    }

    public void updateCellGroup() {
        this.refreshCellGroupDelay = false;
        this.pinTopDistance = 0;
        if (getMeasuredWidth() <= 0 || getMeasuredHeight() <= 0) {
            return;
        }
        if (this.isOnlyShowPlayingLine) {
            this.mCellGroup = new OnlyPlayingLineCellGroup(getContext(), this);
        } else if (this.mIsFadeMode) {
            this.mCellGroup = new TransparentGradientCellGroup(getContext(), this, getAlphaCellValue());
        } else {
            this.mCellGroup = new RestrictedDrawCellGroup(getContext(), this);
        }
        if (this.mSingleLineScrollMode) {
            setLyricDataInternal(Utils.transformLyricDataToSingleLine(getMeasuredWidth(), getDefaultMessagePaint(), null, this.mAttachInfo.getBreakFactor(), this.mOriginalLyricData));
        }
        AttachInfo attachInfo = getAttachInfo();
        if (getLyricData() != null) {
            this.mCellAdapter = new LyricLineCellAdapter(getContext(), getLyricData(), attachInfo);
        }
        CellAdapter cellAdapter = this.mCellAdapter;
        if (cellAdapter == null || cellAdapter.getCount() == 0) {
            return;
        }
        this.mCellAdapter.getCell(0).measure(getMeasuredWidth(), getMeasuredHeight());
        CellAdapter cellAdapter2 = this.mCellAdapter;
        Cell cell = cellAdapter2.getCell(cellAdapter2.getCount() - 1);
        cell.measure(getMeasuredWidth(), getMeasuredHeight());
        if (this.scrollOffsetScale <= 1.0f) {
            this.scrollOffsetScale = 2.0f;
        }
        if (getLyricData() != null && getLyricData().getLyricType() == 3) {
            this.mCellGroup.addChildCell(new TxtHeaderCell(getContext(), 0, attachInfo));
        } else if (this.mHeaderText != null) {
            this.mCellGroup.addChildCell(new HeaderCell(getContext(), (int) ((r2.getHeight() / this.scrollOffsetScale) + r2.getMarginTop()), this.mHeaderText, attachInfo, this.scrollOffsetScale));
        } else {
            this.mCellGroup.addChildCell(new EmptyCell(getContext(), (int) ((r2.getHeight() / this.scrollOffsetScale) + r2.getMarginTop()), this.scrollOffsetScale));
        }
        for (int i2 = 0; i2 < this.mCellAdapter.getCount(); i2++) {
            this.mCellGroup.addChildCell(this.mCellAdapter.getCell(i2));
        }
        if (!TextUtils.isEmpty(this.mCopyrightText)) {
            this.mCellGroup.addChildCell(new CopyRightCell(getContext(), this.mCopyrightText, attachInfo));
        }
        if (!TextUtils.isEmpty(this.mLyricTranslatorName) || !TextUtils.isEmpty(this.mLyricProducerName) || !TextUtils.isEmpty(this.mLyricTransliterName)) {
            LyricMakerCell lyricMakerCell = new LyricMakerCell(getContext(), cell.getHeight(), this.mLyricProducerName, this.mLyricTranslatorName, this.mLyricTransliterName, attachInfo, this.mLyricContributorArrowIconRes);
            float f2 = this.mLyricMakerLineSpacing;
            if (f2 != -1.0f) {
                lyricMakerCell.setLineSpacing(f2);
            }
            this.mCellGroup.addChildCell(lyricMakerCell);
        }
        Bitmap bitmap = this.mCantoneseCover;
        if (bitmap != null && !bitmap.isRecycled() && !TextUtils.isEmpty(this.mCantoneseText)) {
            CantoneseCell cantoneseCell = new CantoneseCell(getContext(), cell.getHeight(), this.mCantoneseCover, this.mCantoneseText, attachInfo, this.mCantoneseIconRes);
            cantoneseCell.setOnCellExposeListener(this.mOnCellExposeListener);
            this.mCellGroup.addChildCell(cantoneseCell);
        }
        BulletinEntity bulletinEntity = this.mBulletinEntity;
        if (bulletinEntity != null) {
            if (!Utils.isEmpty(bulletinEntity.getBulletin())) {
                this.mCellGroup.addChildCell(new BulletinTextCell(getContext(), cell.getHeight() + cell.getMarginBottom(), this.mBulletinEntity.getBulletin(), attachInfo));
            }
            if (!Utils.isEmpty(this.mBulletinEntity.getBtnText())) {
                this.mCellGroup.addChildCell(new BulletinButtonCell(getContext(), cell.getMarginBottom() + cell.getHeight(), this.mBulletinEntity.getBtnRId(), this.mBulletinEntity.getBtnText(), attachInfo));
            }
        }
        if (this.mFooterText != null) {
            CellGroup cellGroup = this.mCellGroup;
            Context context = getContext();
            int marginBottom = cell.getMarginBottom() + (cell.getHeight() / 2);
            String str = this.mFooterText;
            float f3 = this.scrollOffsetScale;
            cellGroup.addChildCell(new FooterCell(context, marginBottom, str, attachInfo, f3 / (f3 - 1.0f)));
        } else {
            CellGroup cellGroup2 = this.mCellGroup;
            Context context2 = getContext();
            int height = (cell.getHeight() / 2) + cell.getMarginBottom();
            float f4 = this.scrollOffsetScale;
            cellGroup2.addChildCell(new EmptyCell(context2, height, f4 / (f4 - 1.0f)));
        }
        if (attachInfo != null && attachInfo.getClimaxStartTime() > 0 && attachInfo.getClimaxEndTime() > 0) {
            setClimaxTime(attachInfo.getClimaxStartTime(), attachInfo.getClimaxEndTime());
        }
        this.mCellGroup.measure(getMeasuredWidth(), getMeasuredHeight());
        this.mCellGroup.measureCell(getMeasuredWidth(), getMeasuredHeight(), getTextHighLightZoom());
        CellGroup cellGroup3 = this.mCellGroup;
        cellGroup3.layout(0, 0, cellGroup3.getWidth(), this.mCellGroup.getHeight());
        this.mTotalHeight = this.mCellGroup.getHeight();
        this.mIsCellLayoutValid = true;
        if (this.isPinTopMode && this.mCellGroup.getCellSize() > this.miniCell && (this.mCellGroup.getChildCell(0) instanceof EmptyCell)) {
            EmptyCell emptyCell = (EmptyCell) this.mCellGroup.getChildCell(0);
            if (!isTxtLyric() && emptyCell != null && !isPureMusic()) {
                this.pinTopDistance = emptyCell.getHeight() - (this.mScaleHighLightLine ? Utils.dip2px(getContext(), 30.0f) : 0);
            }
        }
        int i3 = this.mSelectPos;
        if (i3 >= 0 && this.canShowSelected) {
            this.mCellGroup.setSelectLine(i3);
        }
        this.mCellGroup.setAttachInfo(attachInfo);
        if (isMaxRowsSetted()) {
            requestLayout();
        }
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void updateView() {
        setCurrentPosition(getAttachInfo().getCurrentHighLightLine());
        if (Build.VERSION.SDK_INT >= 21) {
            toSetContentDescription();
        }
        invalidate();
    }

    public MultipleLineLyricView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultipleLineLyricView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        this.mScrollState = 0;
        this.mIsAutoScrollBackToCurrentPosition = true;
        this.mClickCellPosition = -1;
        this.mIsFling = false;
        this.mLyricMakerLineSpacing = -1.0f;
        this.mIsStartSliding = false;
        this.mIsStartedSlide = false;
        this.mHeaderVisible = true;
        this.mIsFadeMode = true;
        this.mMaxRows = -1;
        this.mIsUserStopFling = false;
        this.mTxtLyricNotAutoScroll = false;
        this.alphaCellValue = 1.3f;
        this.zoomRate = 1.0f;
        this.GLRenderEnable = false;
        this.GlRenderNotifyFlag = false;
        this.mPreludeTime = -1L;
        this.mSelectPos = -1;
        this.scrollOffsetScale = 2.0f;
        this.maxSmoothY = 0;
        this.isForbiddenSmallScroll = true;
        this.isPinTopMode = false;
        this.pinTopDistance = 0;
        this.miniCell = 5;
        this.scrollDelayTime = 3000;
        this.mSingleLineScrollMode = false;
        this.mLastRightCellLyricPosition = -1;
        initScrollView();
    }

    private void autoScrollBackToCurrent(long j) {
        if (this.mPendingCheckScrollBack == null) {
            this.mPendingCheckScrollBack = new CheckScrollBack();
        }
        removeCallbacks(this.scrollCenterAction);
        removeCallbacks(this.mPendingCheckScrollBack);
        postDelayed(this.mPendingCheckScrollBack, j);
    }
}
