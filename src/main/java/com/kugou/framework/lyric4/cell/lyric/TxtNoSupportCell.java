package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class TxtNoSupportCell extends BaseLyricCell {
    private String mDefaultText;
    private Paint.FontMetrics mFontMetrics;
    private Paint mPaint;
    private float mTextWidth;

    public TxtNoSupportCell(Context context, AttachInfo attachInfo) {
        super(context, null, attachInfo);
        this.mDefaultText = "抱歉，该歌词不支持双行模式";
        this.mTextWidth = 0.0f;
        this.mPaint = new Paint(1);
        if (!TextUtils.isEmpty(attachInfo.getTxtNoSupportText())) {
            this.mDefaultText = attachInfo.getTxtNoSupportText();
        }
        this.mPaint.setTextSize(Utils.dip2px(this.mContext, 16.0f));
        this.mPaint.setColor(this.mAttachInfo.getTextColor());
        this.mPaint.setTypeface(this.mAttachInfo.getTypeface());
        this.mFontMetrics = this.mPaint.getFontMetrics();
        this.mTextWidth = this.mPaint.measureText(this.mDefaultText);
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
        float fCenterY = this.mVisibleRect.centerY();
        Paint.FontMetrics fontMetrics = this.mFontMetrics;
        float f2 = fontMetrics.bottom;
        float f3 = (fCenterY + ((f2 - fontMetrics.top) / 2.0f)) - f2;
        float f4 = getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - this.mTextWidth) / 2.0f);
        if (this.mAttachInfo.isStroke()) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(1.0f);
            this.mPaint.setFakeBoldText(true);
            this.mPaint.setColor(this.mAttachInfo.getStrokeColor());
            canvas.drawText(this.mDefaultText, f4 - this.mAttachInfo.getStrokeSize(), this.mAttachInfo.getStrokeSize() + f3, this.mPaint);
        }
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPaint.setFakeBoldText(false);
        this.mPaint.setColor(this.mAttachInfo.getTextColor());
        canvas.drawText(this.mDefaultText, f4, f3, this.mPaint);
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
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        setMeasureResult(i2, (int) ((((fontMetrics.bottom - fontMetrics.top) + getAttachInfo().getCellRowMargin()) * 2.0f) + getPaddingTop() + getPaddingBottom()));
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onMeasureCell(int i2, int i3, float f2) {
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onMeasureCellWithAnimation(int i2, int i3, float f2) {
    }
}
