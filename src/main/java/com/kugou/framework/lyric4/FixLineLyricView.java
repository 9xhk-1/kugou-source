package com.kugou.framework.lyric4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.loader.language.Language;
import com.kugou.framework.lyric4.BaseLyricView;
import com.kugou.framework.lyric4.adapter.CellAdapter;
import com.kugou.framework.lyric4.adapter.FixLyricLineCellAdapter;
import com.kugou.framework.lyric4.cell.Cell;
import com.kugou.framework.lyric4.cell.CellGroup;
import com.kugou.framework.lyric4.cell.lyric.EmptySingleLineCell;
import com.kugou.framework.lyric4.cell.lyric.SingleLineCell;

/* JADX INFO: loaded from: classes2.dex */
public class FixLineLyricView extends BaseLyricView {
    private static final int SHOW_LINES = 2;
    private CellAdapter mCellAdapter;
    private CellGroup mCellGroup;
    private int mClickCellPosition;
    private boolean mHasShowLanguage;
    private boolean mIsResponseToLongClick;
    private boolean mIsSingleLine;
    private float mLastMotionX;
    private float mLastMotionY;
    private CheckForLongPress mPendingCheckForLongPress;
    private CheckForTap mPendingCheckForTap;
    private int mStartLine;
    private Runnable mTouchModeReset;
    private int mTouchSlop;

    public class CheckForLongPress implements Runnable {
        public float x;
        public float y;

        private CheckForLongPress() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Cell childCell;
            FixLineLyricView.this.mIsResponseToLongClick = true;
            if (FixLineLyricView.this.mClickCellPosition != -1 && FixLineLyricView.this.mCellGroup != null && (childCell = FixLineLyricView.this.mCellGroup.getChildCell(FixLineLyricView.this.mClickCellPosition)) != null && !FixLineLyricView.this.shouldInterceptClickEvent()) {
                FixLineLyricView fixLineLyricView = FixLineLyricView.this;
                if (fixLineLyricView.mCellLongClickEnable) {
                    CellGroup unused = fixLineLyricView.mCellGroup;
                    CellGroup.updateCellPressedStatus(childCell, false, FixLineLyricView.this);
                    FixLineLyricView fixLineLyricView2 = FixLineLyricView.this;
                    BaseLyricView.OnCellLongClickListener onCellLongClickListener = fixLineLyricView2.mOnItemLongClickListener;
                    if (onCellLongClickListener != null) {
                        onCellLongClickListener.onItemLongClick(childCell, fixLineLyricView2.mStartLine + FixLineLyricView.this.mClickCellPosition, this.y);
                    }
                }
            }
            FixLineLyricView.this.mClickCellPosition = -1;
        }
    }

    public final class CheckForTap implements Runnable {
        public float x;
        public float y;

        private CheckForTap() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Cell childCell;
            FixLineLyricView fixLineLyricView = FixLineLyricView.this;
            fixLineLyricView.mClickCellPosition = fixLineLyricView.getTouchCellPosition(this.x, this.y);
            if (FixLineLyricView.this.mClickCellPosition == -1 || FixLineLyricView.this.mCellGroup == null || (childCell = FixLineLyricView.this.mCellGroup.getChildCell(FixLineLyricView.this.mClickCellPosition)) == null || !childCell.isInClickArea(this.x, this.y) || FixLineLyricView.this.shouldInterceptClickEvent()) {
                return;
            }
            FixLineLyricView fixLineLyricView2 = FixLineLyricView.this;
            if (fixLineLyricView2.mCellLongClickEnable) {
                CellGroup unused = fixLineLyricView2.mCellGroup;
                CellGroup.updateCellPressedStatus(childCell, true, FixLineLyricView.this);
            }
            if (FixLineLyricView.this.mPendingCheckForLongPress == null) {
                FixLineLyricView fixLineLyricView3 = FixLineLyricView.this;
                fixLineLyricView3.mPendingCheckForLongPress = new CheckForLongPress();
            }
            FixLineLyricView.this.mPendingCheckForLongPress.x = this.x;
            FixLineLyricView.this.mPendingCheckForLongPress.y = this.y;
            FixLineLyricView fixLineLyricView4 = FixLineLyricView.this;
            fixLineLyricView4.postDelayed(fixLineLyricView4.mPendingCheckForLongPress, 300L);
        }
    }

    public FixLineLyricView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTouchCellPosition(float f2, float f3) {
        if (this.mCellGroup == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.mCellGroup.getCellSize(); i2++) {
            Cell childCell = this.mCellGroup.getChildCell(i2);
            if (childCell.getCellRect().top <= f3 && childCell.getCellRect().bottom >= f3 && !(childCell instanceof EmptySingleLineCell)) {
                return i2;
            }
        }
        return -1;
    }

    private void init() {
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void onTouchCancel() {
        removeCallbacks(this.mPendingCheckForTap);
        removeCallbacks(this.mPendingCheckForLongPress);
        if (this.mCellGroup != null) {
            for (int i2 = 0; i2 < this.mCellGroup.getCellSize(); i2++) {
                this.mCellGroup.getChildCell(i2).setPressed(false);
            }
        }
        invalidate();
    }

    private void onTouchDown(MotionEvent motionEvent) {
        this.mLastMotionY = motionEvent.getY();
        this.mLastMotionX = motionEvent.getX();
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
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i2 = (int) (this.mLastMotionY - y);
        int i3 = (int) (this.mLastMotionX - x);
        this.mLastMotionY = y;
        this.mLastMotionX = x;
        if (Math.abs(i2) > this.mTouchSlop || Math.abs(i3) > this.mTouchSlop) {
            int i4 = this.mClickCellPosition;
            if (i4 != -1 && (cellGroup = this.mCellGroup) != null) {
                CellGroup.updateCellPressedStatus(cellGroup.getChildCell(i4), false, this);
            }
            removeCallbacks(this.mPendingCheckForTap);
            removeCallbacks(this.mPendingCheckForLongPress);
        }
    }

    private void onTouchUp(MotionEvent motionEvent) {
        CellGroup cellGroup;
        removeCallbacks(this.mPendingCheckForTap);
        removeCallbacks(this.mPendingCheckForLongPress);
        if (this.mIsResponseToLongClick) {
            return;
        }
        if (!this.mCellClickEnable) {
            handleClickEvent(motionEvent);
            return;
        }
        int touchCellPosition = getTouchCellPosition(motionEvent.getX(), motionEvent.getY());
        this.mClickCellPosition = touchCellPosition;
        if (touchCellPosition == -1 || (cellGroup = this.mCellGroup) == null) {
            return;
        }
        final Cell childCell = cellGroup.getChildCell(touchCellPosition);
        if (childCell == null || !childCell.isInClickArea(motionEvent.getX(), motionEvent.getY()) || shouldInterceptClickEvent()) {
            handleClickEvent(motionEvent);
            return;
        }
        CellGroup.updateCellPressedStatus(childCell, true, this);
        Runnable runnable = this.mTouchModeReset;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.kugou.framework.lyric4.FixLineLyricView.1
            @Override // java.lang.Runnable
            public void run() {
                FixLineLyricView.this.mTouchModeReset = null;
                if (FixLineLyricView.this.mCellGroup != null) {
                    CellGroup unused = FixLineLyricView.this.mCellGroup;
                    CellGroup.updateCellPressedStatus(childCell, false, FixLineLyricView.this);
                }
                FixLineLyricView fixLineLyricView = FixLineLyricView.this;
                BaseLyricView.OnCellClickListener onCellClickListener = fixLineLyricView.mOnItemClickListener;
                if (onCellClickListener != null) {
                    onCellClickListener.onItemClick(childCell, fixLineLyricView.mStartLine + FixLineLyricView.this.mClickCellPosition);
                }
                FixLineLyricView.this.mClickCellPosition = -1;
            }
        };
        this.mTouchModeReset = runnable2;
        postDelayed(runnable2, ViewConfiguration.getPressedStateDuration());
    }

    private void onTranslateXListener() {
        CellGroup cellGroup = this.mCellGroup;
        if (cellGroup == null || this.onLyricTranslateXListener == null) {
            return;
        }
        int width = cellGroup.getWidth();
        if (width == 0) {
            this.onLyricTranslateXListener.onEndTranslateX();
            return;
        }
        SingleLineCell currentSingleLineCell = this.mCellGroup.getCurrentSingleLineCell();
        if (currentSingleLineCell == null || currentSingleLineCell.getLineWidth() == 0.0f) {
            this.onLyricTranslateXListener.onEndTranslateX();
        } else if (currentSingleLineCell.getLineWidth() > width) {
            this.onLyricTranslateXListener.onStartTranslateX();
        } else {
            this.onLyricTranslateXListener.onEndTranslateX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldInterceptClickEvent() {
        if (getLyricData() != null && getLyricData().getLyricType() == 3) {
            return true;
        }
        BaseLyricView.OnClickInterceptListener onClickInterceptListener = this.mOnClickInterceptListener;
        if (onClickInterceptListener != null) {
            return onClickInterceptListener.shouldInterceptEvent();
        }
        return false;
    }

    private boolean shouldShowSingleLine() {
        return this.mHasShowLanguage || this.mIsSingleLine;
    }

    private void updateCellGroup() {
        Cell emptySingleLineCell;
        CellGroup cellGroup;
        this.mCellGroup = new CellGroup(getContext());
        if (this.mCellAdapter == null && getLyricData() != null) {
            setAdapter(new FixLyricLineCellAdapter(getContext(), getLyricData(), getAttachInfo()));
        }
        int i2 = 0;
        if (getLyricData() == null || this.mCellGroup == null || getLyricData().getLyricType() != 3) {
            CellAdapter cellAdapter = this.mCellAdapter;
            if (cellAdapter != null && this.mCellGroup != null && cellAdapter.getCount() != 0 && this.mStartLine != -1) {
                if (shouldShowSingleLine() || this.mCellAdapter.getCount() == 1) {
                    if (this.mStartLine > this.mCellAdapter.getCount() - 1) {
                        this.mStartLine = this.mCellAdapter.getCount() - 1;
                    }
                    this.mCellGroup.addChildCell(this.mCellAdapter.getCell(this.mStartLine));
                    this.mCellGroup.measure(getMeasuredWidth(), getMeasuredHeight());
                    CellGroup cellGroup2 = this.mCellGroup;
                    cellGroup2.layout(0, 0, cellGroup2.getWidth(), this.mCellGroup.getHeight());
                } else {
                    if (this.mStartLine > this.mCellAdapter.getCount() - 1) {
                        this.mStartLine = this.mCellAdapter.getCount() - 1;
                    }
                    Cell cell = this.mCellAdapter.getCell(this.mStartLine);
                    if (this.mStartLine + 1 < this.mCellAdapter.getCount()) {
                        emptySingleLineCell = this.mCellAdapter.getCell(this.mStartLine + 1);
                    } else {
                        emptySingleLineCell = new EmptySingleLineCell(getContext(), getAttachInfo());
                        emptySingleLineCell.setPaddingTop(getAttachInfo().getCellRowMargin() / 2);
                        emptySingleLineCell.setPaddingBottom(getAttachInfo().getCellRowMargin() / 2);
                    }
                    if (this.mStartLine % 2 == 0) {
                        this.mCellGroup.addChildCell(cell);
                        this.mCellGroup.addChildCell(emptySingleLineCell);
                    } else {
                        this.mCellGroup.addChildCell(emptySingleLineCell);
                        this.mCellGroup.addChildCell(cell);
                    }
                    this.mCellGroup.measure(getMeasuredWidth(), getMeasuredHeight());
                    CellGroup cellGroup3 = this.mCellGroup;
                    cellGroup3.layout(0, 0, cellGroup3.getWidth(), this.mCellGroup.getHeight());
                }
                this.mIsCellLayoutValid = true;
                if (getHeight() != this.mCellGroup.getHeight()) {
                    requestLayout();
                }
            }
        } else {
            CellAdapter cellAdapter2 = this.mCellAdapter;
            if (cellAdapter2 != null && cellAdapter2.getCount() != 0) {
                this.mCellGroup.addChildCell(this.mCellAdapter.getCell(0));
                this.mCellGroup.measure(getMeasuredWidth(), getMeasuredHeight());
                CellGroup cellGroup4 = this.mCellGroup;
                cellGroup4.layout(0, 0, cellGroup4.getWidth(), this.mCellGroup.getHeight());
                this.mIsCellLayoutValid = true;
                if (getHeight() != this.mCellGroup.getHeight()) {
                    requestLayout();
                }
            }
        }
        try {
            if (Build.VERSION.SDK_INT < 21 || (cellGroup = this.mCellGroup) == null) {
                return;
            }
            if (this.mStartLine % 2 != 0) {
                i2 = 1;
            }
            setContentDescription(cellGroup.getRightCellLyricLine(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public boolean checkChangeLineInside(int i2, int i3) {
        return true;
    }

    public String getNewDefaultMsg() {
        return this.mNewDefaultMsg;
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public boolean isCanSlide() {
        return false;
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public boolean isTouchInBlankArea(float f2, float f3) {
        CellGroup cellGroup;
        Cell childCell;
        int touchCellPosition = getTouchCellPosition(f2, f3);
        if (touchCellPosition == -1 || (cellGroup = this.mCellGroup) == null || (childCell = cellGroup.getChildCell(touchCellPosition)) == null) {
            return false;
        }
        return childCell.isInBlankArea(f2, f3);
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
            onTranslateXListener();
        }
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void onLyricDataSet(LyricData lyricData) {
        setAdapter(new FixLyricLineCellAdapter(getContext(), lyricData, getAttachInfo()));
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        float paddingTop;
        int paddingBottom;
        CellGroup cellGroup = this.mCellGroup;
        if (cellGroup != null && !cellGroup.isEmpty()) {
            setMeasuredDimension(i2, View.MeasureSpec.makeMeasureSpec(this.mCellGroup.getHeight(), BasicMeasure.EXACTLY));
            return;
        }
        Paint.FontMetrics fontMetrics = this.mDefaultMessagePaint.getFontMetrics();
        float cellRowMargin = (fontMetrics.bottom - fontMetrics.top) + getAttachInfo().getCellRowMargin();
        if (this.mIsSingleLine) {
            paddingTop = cellRowMargin + getPaddingTop();
            paddingBottom = getPaddingBottom();
        } else {
            paddingTop = (cellRowMargin * 2.0f) + getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        setMeasuredDimension(i2, View.MeasureSpec.makeMeasureSpec((int) (paddingTop + paddingBottom), BasicMeasure.EXACTLY));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        CellGroup cellGroup;
        if (this.mDisableTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        if ((!this.mCellClickEnable && !this.mCellLongClickEnable) || (cellGroup = this.mCellGroup) == null || cellGroup.isEmpty()) {
            if ((motionEvent.getAction() & 255) != 0 && (motionEvent.getAction() & 255) == 1) {
                handleClickEvent(motionEvent);
            }
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            onTouchDown(motionEvent);
        } else if (action == 1) {
            onTouchUp(motionEvent);
        } else if (action == 2) {
            onTouchMove(motionEvent);
        } else if (action == 3) {
            onTouchCancel();
        }
        return true;
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView, com.kugou.framework.lyric.ILyricView
    public void release() {
        super.release();
        this.mWeakHandler.post(new Runnable() { // from class: com.kugou.framework.lyric4.FixLineLyricView.2
            @Override // java.lang.Runnable
            public void run() {
                FixLineLyricView.this.mCellGroup = null;
                FixLineLyricView.this.mCellAdapter = null;
                FixLineLyricView fixLineLyricView = FixLineLyricView.this;
                fixLineLyricView.mIsCellLayoutValid = false;
                fixLineLyricView.mStartLine = -1;
                FixLineLyricView.this.mClickCellPosition = -1;
                FixLineLyricView.this.getAttachInfo().setLanguage(Language.Origin);
                FixLineLyricView.this.invalidate();
            }
        });
    }

    public void setAdapter(CellAdapter cellAdapter) {
        this.mCellAdapter = cellAdapter;
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void setLanguage(Language language) {
        if (language == Language.Translation || language == Language.Transliteration || language == Language.Chinese) {
            this.mHasShowLanguage = true;
        } else {
            this.mHasShowLanguage = false;
        }
        super.setLanguage(language);
    }

    public void setSingleLine(boolean z) {
        this.mIsSingleLine = z;
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void startChangeLineAnimation(int i2, int i3) {
    }

    @Override // com.kugou.framework.lyric4.BaseLyricView
    public void updateView() {
        int currentHighLightLine = getAttachInfo().getCurrentHighLightLine();
        if (this.mStartLine != currentHighLightLine) {
            this.mStartLine = currentHighLightLine;
            CellAdapter cellAdapter = this.mCellAdapter;
            if (cellAdapter != null && cellAdapter.getCount() > 1) {
                if (shouldShowSingleLine()) {
                    if (this.mStartLine > this.mCellAdapter.getCount() - 1) {
                        this.mStartLine = this.mCellAdapter.getCount() - 1;
                    }
                } else if (this.mStartLine > this.mCellAdapter.getCount() - 1) {
                    this.mStartLine = this.mCellAdapter.getCount() - 1;
                }
            }
            this.mIsCellLayoutValid = false;
        }
        invalidate();
    }

    public FixLineLyricView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FixLineLyricView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mStartLine = -1;
        this.mClickCellPosition = -1;
        this.mIsSingleLine = false;
        this.mHasShowLanguage = false;
        init();
    }
}
