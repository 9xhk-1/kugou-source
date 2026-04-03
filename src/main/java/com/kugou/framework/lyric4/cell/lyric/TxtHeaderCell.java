package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class TxtHeaderCell extends EmptyCell {
    private AttachInfo mAttachInfo;
    private Paint.FontMetrics mFontMetrics;
    private String[] mHeadeText;
    private Paint mHeaderPaint;
    private int mMarginBottom;
    private int mMarginTop;
    private float[] mTextWidth;

    public TxtHeaderCell(Context context, int i2, AttachInfo attachInfo) {
        super(context, i2);
        this.mHeadeText = new String[]{"抱歉，该歌词暂不支持自动滚动", "------------------------"};
        this.mHeaderPaint = new Paint(1);
        this.mTextWidth = new float[this.mHeadeText.length];
        this.mMarginTop = 10;
        this.mMarginBottom = 30;
        this.mAttachInfo = attachInfo;
        this.mMarginTop = Utils.dip2px(context, 10.0f);
        this.mMarginBottom = Utils.dip2px(context, 30.0f);
        this.mHeaderPaint.setTextSize(Utils.dip2px(this.mContext, 16.0f));
        this.mHeaderPaint.setColor(this.mAttachInfo.getTextColor());
        this.mHeaderPaint.setTypeface(this.mAttachInfo.getTypeface());
        this.mFontMetrics = this.mHeaderPaint.getFontMetrics();
        int i3 = 0;
        while (true) {
            String[] strArr = this.mHeadeText;
            if (i3 >= strArr.length) {
                return;
            }
            this.mTextWidth[i3] = this.mHeaderPaint.measureText(strArr[i3]);
            i3++;
        }
    }

    private int getStartY() {
        return getVisibleRect().bottom - this.mMarginBottom;
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public boolean isInBlankArea(float f2, float f3) {
        return true;
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float startY = getStartY();
        for (int i2 = 0; i2 < this.mHeadeText.length; i2++) {
            Paint.FontMetrics fontMetrics = this.mFontMetrics;
            float f2 = fontMetrics.bottom;
            float f3 = (((f2 - fontMetrics.top) / 2.0f) + startY) - f2;
            float f4 = getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - this.mTextWidth[i2]) / 2.0f);
            int cellAlignMode = this.mAttachInfo.getCellAlignMode();
            if (cellAlignMode == 0) {
                f4 = getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - this.mTextWidth[i2]) / 2.0f);
            } else if (cellAlignMode == 1) {
                f4 = getVisibleRect().left;
            } else if (cellAlignMode == 2) {
                f4 = getVisibleRect().right - this.mTextWidth[i2];
            }
            canvas.drawText(this.mHeadeText[i2], f4, f3, this.mHeaderPaint);
            Paint.FontMetrics fontMetrics2 = this.mFontMetrics;
            float f5 = fontMetrics2.bottom;
            startY += (((f5 - fontMetrics2.top) / 2.0f) - f5) + this.mMarginTop;
        }
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public void onMeasure(int i2, int i3) {
        int i4 = (i3 / 2) - this.mExtraHeight;
        Paint.FontMetrics fontMetrics = this.mFontMetrics;
        float fDip2px = ((((fontMetrics.bottom - fontMetrics.top) + this.mMarginTop) + this.mMarginBottom) + Utils.dip2px(this.mContext, 2.0f)) - this.mExtraHeight;
        if (i4 > fDip2px) {
            setMeasureResult(i2, i4);
        } else {
            setMeasureResult(i2, (int) fDip2px);
        }
    }
}
