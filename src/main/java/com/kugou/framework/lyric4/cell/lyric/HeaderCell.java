package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class HeaderCell extends EmptyCell {
    private AttachInfo mAttachInfo;
    private Paint.FontMetrics mFontMetrics;
    private Paint mHeaderPaint;
    private String mHeaderText;
    private boolean mMessageVisible;
    private float mTextHeight;
    private float mTextWidth;

    public HeaderCell(Context context, int i2, String str, AttachInfo attachInfo) {
        super(context, i2);
        Paint paint = new Paint(1);
        this.mHeaderPaint = paint;
        this.mMessageVisible = true;
        this.mHeaderText = str;
        this.mLyricLine = str;
        this.mAttachInfo = attachInfo;
        paint.setTextSize(attachInfo.getHeaderTextSize());
        this.mHeaderPaint.setColor(this.mAttachInfo.getHeaderTextColor());
        this.mHeaderPaint.setTypeface(this.mAttachInfo.getTypeface());
        this.mFontMetrics = this.mHeaderPaint.getFontMetrics();
        this.mTextWidth = this.mHeaderPaint.measureText(str);
        Paint.FontMetrics fontMetrics = this.mFontMetrics;
        this.mTextHeight = fontMetrics.bottom - fontMetrics.top;
    }

    private int getStartY() {
        return getVisibleRect().bottom - Utils.dip2px(getContext(), 40.0f);
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public boolean isInBlankArea(float f2, float f3) {
        if (!this.mMessageVisible) {
            return true;
        }
        float f4 = this.mTextWidth > ((float) (getVisibleRect().right - getVisibleRect().left)) ? getVisibleRect().left : getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - this.mTextWidth) / 2.0f);
        float startY = getStartY() - (this.mTextHeight / 2.0f);
        float startY2 = getStartY() + (this.mTextHeight / 2.0f);
        if (f2 >= f4) {
            return (f2 > f4 + this.mTextWidth && f3 < startY) || f3 > startY2;
        }
        return true;
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public boolean isInClickArea(float f2, float f3) {
        if (this.mMessageVisible) {
            return f3 > ((float) getStartY()) - (this.mTextHeight / 2.0f) && f3 < ((float) getStartY()) + (this.mTextHeight / 2.0f);
        }
        return false;
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mMessageVisible) {
            float startY = getStartY();
            Paint.FontMetrics fontMetrics = this.mFontMetrics;
            float f2 = fontMetrics.bottom;
            canvas.drawText(this.mHeaderText, this.mTextWidth > ((float) (getVisibleRect().right - getVisibleRect().left)) ? getVisibleRect().left : getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - this.mTextWidth) / 2.0f), (startY + ((f2 - fontMetrics.top) / 2.0f)) - f2, this.mHeaderPaint);
        }
    }

    public void setMessageVisible(boolean z) {
        this.mMessageVisible = z;
    }

    public HeaderCell(Context context, int i2, String str, AttachInfo attachInfo, float f2) {
        this(context, i2, str, attachInfo);
        this.scrollOffsetScale = f2;
    }
}
