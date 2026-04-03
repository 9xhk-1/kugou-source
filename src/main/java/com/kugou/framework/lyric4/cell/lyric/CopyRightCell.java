package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.cell.Cell;
import com.kugou.framework.lyric4.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class CopyRightCell extends Cell {
    public int mAlignMode;
    private AttachInfo mAttachInfo;
    private int mCellHeight;
    private int mCellMargin;
    private Paint.FontMetrics mFontMetrics;
    private Paint mPaint;
    private String mText;
    private float mTextHeight;
    private float mTextWidth;

    public CopyRightCell(Context context, String str, AttachInfo attachInfo) {
        super(context);
        this.mAlignMode = 0;
        this.mText = str;
        this.mLyricLine = str;
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setTextSize(attachInfo.getFooterTextSize());
        this.mPaint.setColor(attachInfo.getFooterTextColor());
        this.mPaint.setTypeface(attachInfo.getTypeface());
        this.mPaint.setFlags(1);
        this.mFontMetrics = this.mPaint.getFontMetrics();
        this.mAttachInfo = attachInfo;
        this.mCellMargin = Utils.dip2px(context, 20.0f);
        this.mAlignMode = this.mAttachInfo.getCellAlignMode();
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
        canvas.drawText(this.mText, this.mAlignMode != 1 ? getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - this.mTextWidth) / 2.0f) : getVisibleRect().left, getCellRect().top + this.mCellMargin + (this.mTextHeight / 2.0f), this.mPaint);
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onDrawAnimation(Canvas canvas, float f2) {
        onDraw(canvas);
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onLayout(int i2, int i3, int i4, int i5) {
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onMeasure(int i2, int i3) {
        this.mTextWidth = this.mPaint.measureText(this.mText);
        Paint.FontMetrics fontMetrics = this.mFontMetrics;
        float f2 = fontMetrics.bottom - fontMetrics.top;
        this.mTextHeight = f2;
        int i4 = ((int) f2) + this.mCellMargin;
        this.mCellHeight = i4;
        setMeasureResult(i2, i4);
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onMeasureCell(int i2, int i3, float f2) {
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onMeasureCellWithAnimation(int i2, int i3, float f2) {
    }
}
