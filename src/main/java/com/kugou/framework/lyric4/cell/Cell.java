package com.kugou.framework.lyric4.cell;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.BaseLyricView;
import com.kugou.framework.lyric4.span.ExtraDrawSpan;
import com.kugou.framework.lyric4.utils.Utils;
import com.kugou.framework.lyricanim.TextBitmapUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Cell {
    private Paint.FontMetrics climaxFontMetrics;
    private Paint climaxPaint;
    private final float dp10;
    private final float dp8;
    public AttachInfo mAttachInfo;
    public int mBottom;
    private int mClimaxColor;
    public RectF mClimaxDst;
    public Rect mClimaxSrc;
    public Context mContext;
    private Paint mDebugPaint;
    public int mHeight;
    public int mLeft;
    public int mMarginBottom;
    public int mMarginLeft;
    public int mMarginRight;
    public int mMarginTop;
    public BaseLyricView.OnCellExposeListener mOnCellExposeListener;
    public int mPaddingBottom;
    public int mPaddingLeft;
    public int mPaddingRight;
    public int mPaddingTop;
    public int mRight;
    public int mTop;
    public int mWidth;
    private int mCellId = 0;
    public String mLyricLine = "";
    public Rect mCellRect = new Rect();
    public Rect mVisibleRect = new Rect();
    public RectF mPressRect = new RectF();
    public boolean mIsPressed = false;
    public Paint mPressedPaint = new Paint(1);
    public int mPressColor = -16777216;
    public int mAlphaValue = 255;
    public boolean mIsHighLighting = false;
    public int mLine = -1;
    public boolean mShowHighLightLine = true;
    public boolean mShowSelectLine = false;
    public boolean mShowClimax = false;
    private State mState = State.STANDARD;
    public int mParentTop = -1;
    public int mParentBottom = -1;
    public int mParentLeft = 0;
    public int mParentRight = 0;

    public Cell(Context context) {
        this.mContext = context;
        this.dp10 = Utils.dip2px(context, 10.0f);
        this.dp8 = Utils.dip2px(context, 8.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void checkStatus() {
        /*
            r5 = this;
            com.kugou.framework.lyric4.AttachInfo r0 = r5.mAttachInfo
            r1 = 1
            r2 = -1
            r3 = 0
            if (r0 == 0) goto L14
            int r0 = r0.getClimaxLine()
            int r4 = r5.mLine
            if (r0 != r4) goto L14
            if (r4 == r2) goto L14
            r5.mShowClimax = r1
            goto L16
        L14:
            r5.mShowClimax = r3
        L16:
            com.kugou.framework.lyric4.AttachInfo r0 = r5.mAttachInfo
            if (r0 == 0) goto L27
            int r0 = r0.getCurrentHighLightLine()
            int r4 = r5.mLine
            if (r0 != r4) goto L27
            if (r4 == r2) goto L27
            r5.mIsHighLighting = r1
            goto L29
        L27:
            r5.mIsHighLighting = r3
        L29:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.lyric4.cell.Cell.checkStatus():void");
    }

    private void drawClimaxTag(Canvas canvas) {
        AttachInfo attachInfo;
        Bitmap climaxBitmap;
        float f2;
        if (canvas == null || (attachInfo = this.mAttachInfo) == null || !this.mShowClimax || this.mShowSelectLine || this.mIsHighLighting || (climaxBitmap = attachInfo.getClimaxBitmap()) == null || this.mPressRect == null || !(this instanceof CellGroup)) {
            return;
        }
        if (this.climaxPaint == null) {
            Paint paint = new Paint(1);
            this.climaxPaint = paint;
            paint.setTextSize(this.dp8);
        }
        setClimaxColor();
        if (this.climaxFontMetrics == null) {
            this.climaxFontMetrics = this.climaxPaint.getFontMetrics();
        }
        if (this.mClimaxDst == null) {
            this.mClimaxSrc = new Rect();
            this.mClimaxDst = new RectF();
        }
        Rect rect = this.mClimaxSrc;
        if (rect != null) {
            rect.set(0, 0, climaxBitmap.getWidth(), climaxBitmap.getHeight());
        }
        RectF rectF = this.mPressRect;
        float height = ((rectF.top + rectF.bottom) - climaxBitmap.getHeight()) / 2.0f;
        float width = this.mAttachInfo.getCellAlignMode() == 1 ? (this.mPressRect.right - this.dp10) - climaxBitmap.getWidth() : this.mPressRect.left + this.dp10;
        if (isRectInVisibleRange(this.mPressRect)) {
            this.mClimaxDst.set(width, height, climaxBitmap.getWidth() + width, climaxBitmap.getHeight() + height);
            this.climaxPaint.setAlpha(255);
            if (this.mAttachInfo.getCellAlignMode() == 1) {
                canvas.save();
                canvas.rotate(180.0f, (climaxBitmap.getWidth() / 2.0f) + width, (climaxBitmap.getHeight() / 2.0f) + height);
                canvas.drawBitmap(climaxBitmap, this.mClimaxSrc, this.mClimaxDst, this.climaxPaint);
                canvas.restore();
                f2 = width + this.dp8 + 1.0f;
            } else {
                f2 = width + (this.dp8 / 2.0f);
                canvas.drawBitmap(climaxBitmap, this.mClimaxSrc, this.mClimaxDst, this.climaxPaint);
            }
            this.climaxPaint.setAlpha(178);
            double d2 = height + 1.0f;
            float height2 = climaxBitmap.getHeight();
            Paint.FontMetrics fontMetrics = this.climaxFontMetrics;
            double d3 = (height2 - fontMetrics.descent) - fontMetrics.ascent;
            Double.isNaN(d3);
            Double.isNaN(d2);
            canvas.drawText("高潮", f2, (float) (d2 + (d3 / 2.0d)), this.climaxPaint);
        }
    }

    private void setClimaxColor() {
        Paint paint;
        AttachInfo attachInfo = this.mAttachInfo;
        int textLineColor = attachInfo == null ? -1 : attachInfo.getTextLineColor();
        if (this.mClimaxColor == textLineColor || (paint = this.climaxPaint) == null) {
            return;
        }
        this.mClimaxColor = textLineColor;
        paint.setColor(textLineColor);
        this.climaxPaint.setColorFilter(TextBitmapUtils.color2ColorFilter(this.mClimaxColor));
    }

    public void draw(Canvas canvas) {
        if (this.mIsPressed) {
            drawPressStatus(canvas);
        }
        drawSelectBg(canvas);
        drawClimaxTag(canvas);
        onDraw(canvas);
    }

    public void drawAnimation(Canvas canvas, float f2) {
        if (this.mIsPressed) {
            drawPressStatus(canvas);
        }
        drawSelectBg(canvas);
        drawClimaxTag(canvas);
        onDrawAnimation(canvas, f2);
    }

    public void drawPressStatus(Canvas canvas) {
        this.mPressedPaint.setColor(this.mPressColor);
        this.mPressedPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(this.mPressRect, this.mPressedPaint);
    }

    public void drawSelectBg(Canvas canvas) {
        AttachInfo attachInfo;
        if (this.mShowSelectLine && (attachInfo = this.mAttachInfo) != null && attachInfo.isShowSelectBgMode() && (this instanceof CellGroup)) {
            if (this.mPressRect != null) {
                ExtraDrawSpan extraDrawSpan = this.mAttachInfo.getExtraDrawSpan();
                RectF rectF = this.mPressRect;
                extraDrawSpan.onLayout(rectF.left, rectF.right, rectF.top, rectF.bottom);
            }
            this.mAttachInfo.getExtraDrawSpan().draw(canvas, this.mAttachInfo.getCellAlignMode());
        }
    }

    public int getAlphaValue() {
        return this.mAlphaValue;
    }

    public AttachInfo getAttachInfo() {
        return this.mAttachInfo;
    }

    public int getBottom() {
        return this.mBottom;
    }

    public int getCellId() {
        return this.mCellId;
    }

    public Rect getCellRect() {
        return this.mCellRect;
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getLine() {
        return this.mLine;
    }

    public String getLyricLine() {
        return TextUtils.isEmpty(this.mLyricLine) ? "歌词" : this.mLyricLine;
    }

    public int getMarginBottom() {
        return this.mMarginBottom;
    }

    public int getMarginLeft() {
        return this.mMarginLeft;
    }

    public int getMarginRight() {
        return this.mMarginRight;
    }

    public int getMarginTop() {
        return this.mMarginTop;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public int getParentBottom() {
        return this.mParentBottom;
    }

    public int getParentLeft() {
        return this.mParentLeft;
    }

    public int getParentRight() {
        return this.mParentRight;
    }

    public int getParentTop() {
        return this.mParentTop;
    }

    public int getRight() {
        return this.mRight;
    }

    public boolean getShowSelectLine() {
        return this.mShowSelectLine;
    }

    public int getSingleLineHeight() {
        return getHeight();
    }

    public State getState() {
        return this.mState;
    }

    public int getTop() {
        return this.mTop;
    }

    public Rect getVisibleRect() {
        return this.mVisibleRect;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isCellWholeVisible() {
        RectF rectF;
        if (getParentTop() == -1 || getPaddingBottom() == -1 || (rectF = this.mPressRect) == null) {
            return true;
        }
        return rectF.bottom <= ((float) getParentBottom()) && this.mPressRect.top >= ((float) getParentTop());
    }

    public boolean isHighLighting() {
        return this.mIsHighLighting;
    }

    public boolean isInBlankArea(float f2, float f3) {
        return false;
    }

    public boolean isInClick(float f2, float f3) {
        return false;
    }

    public boolean isInClickArea(float f2, float f3) {
        Rect rect = this.mCellRect;
        return ((float) rect.top) <= f3 && ((float) rect.bottom) >= f3;
    }

    public boolean isPressed() {
        return this.mIsPressed;
    }

    public boolean isRectInVisibleRange(RectF rectF) {
        if (getParentTop() == -1 || getPaddingBottom() == -1) {
            return true;
        }
        return this.mAttachInfo.isHideHalfLine() ? rectF.bottom <= ((float) getParentBottom()) && rectF.top >= ((float) getParentTop()) : this.mAttachInfo.isShowTopHalfLine() ? ((float) getParentTop()) <= rectF.bottom && rectF.top <= ((float) getParentBottom()) : ((float) getParentTop()) <= rectF.bottom && rectF.top <= ((float) getParentBottom()) && rectF.top >= ((float) getParentTop());
    }

    public void layout(int i2, int i3, int i4, int i5) {
        checkStatus();
        this.mLeft = i2;
        this.mTop = i3;
        this.mRight = i4;
        this.mBottom = i5;
        Rect rect = this.mCellRect;
        rect.left = i2;
        rect.top = i3;
        rect.right = i4;
        rect.bottom = i5;
        this.mVisibleRect.left = getPaddingLeft() + i2;
        this.mVisibleRect.top = getPaddingTop() + i3;
        this.mVisibleRect.right = i4 - getPaddingRight();
        this.mVisibleRect.bottom = i5 - getPaddingBottom();
        RectF rectF = this.mPressRect;
        rectF.left = i2 - this.mParentLeft;
        rectF.right = Math.max(this.mParentRight, i4);
        RectF rectF2 = this.mPressRect;
        rectF2.top = i3;
        rectF2.bottom = i5;
        Rect rect2 = this.mVisibleRect;
        onLayout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    public void measure(int i2, int i3) {
        onMeasure((i2 - getMarginLeft()) - getMarginRight(), (i3 - getMarginTop()) - getMarginBottom());
        setMeasureResult(getWidth(), getHeight());
    }

    public void measureCell(int i2, int i3, float f2) {
        onMeasureCell(i2, i3, f2);
        setMeasureResult(getWidth(), getHeight());
    }

    public void measureCellWithAnimation(int i2, int i3, float f2) {
        onMeasureCellWithAnimation(i2, i3, f2);
        setMeasureResult(getWidth(), getHeight());
    }

    public abstract void onDraw(Canvas canvas);

    public abstract void onDrawAnimation(Canvas canvas, float f2);

    public abstract void onLayout(int i2, int i3, int i4, int i5);

    public abstract void onMeasure(int i2, int i3);

    public abstract void onMeasureCell(int i2, int i3, float f2);

    public abstract void onMeasureCellWithAnimation(int i2, int i3, float f2);

    public void setAlphaValue(int i2) {
        this.mAlphaValue = i2;
    }

    public void setAttachInfo(AttachInfo attachInfo) {
        this.mAttachInfo = attachInfo;
    }

    public void setBottom(int i2) {
        this.mBottom = i2;
    }

    public void setCellId(int i2) {
        this.mCellId = i2;
    }

    public void setLeft(int i2) {
        this.mLeft = i2;
    }

    public void setLine(int i2) {
        this.mLine = i2;
    }

    public void setMarginBottom(int i2) {
        this.mMarginBottom = i2;
    }

    public void setMarginLeft(int i2) {
        this.mMarginLeft = i2;
    }

    public void setMarginRight(int i2) {
        this.mMarginRight = i2;
    }

    public void setMarginTop(int i2) {
        this.mMarginTop = i2;
    }

    public void setMeasureResult(int i2, int i3) {
        this.mWidth = i2;
        this.mHeight = i3;
    }

    public void setOnCellExposeListener(BaseLyricView.OnCellExposeListener onCellExposeListener) {
        this.mOnCellExposeListener = onCellExposeListener;
    }

    public void setPaddingBottom(int i2) {
        this.mPaddingBottom = i2;
    }

    public void setPaddingLeft(int i2) {
        this.mPaddingLeft = i2;
    }

    public void setPaddingRight(int i2) {
        this.mPaddingRight = i2;
    }

    public void setPaddingTop(int i2) {
        this.mPaddingTop = i2;
    }

    public void setParentBottom(int i2) {
        this.mParentBottom = i2;
    }

    public void setParentLeft(int i2) {
        this.mParentLeft = i2;
    }

    public void setParentRight(int i2) {
        this.mParentRight = i2;
    }

    public void setParentTop(int i2) {
        this.mParentTop = i2;
    }

    public void setPressColor(int i2) {
        this.mPressColor = i2;
    }

    public void setPressed(boolean z) {
        this.mIsPressed = z;
    }

    public void setRight(int i2) {
        this.mRight = i2;
    }

    public void setShowSelectLine(boolean z) {
        this.mShowSelectLine = z;
    }

    public void setState(State state) {
        this.mState = state;
    }

    public void setTop(int i2) {
        this.mTop = i2;
    }

    public void showHighLight(boolean z) {
        this.mShowHighLightLine = z;
    }
}
