package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.cell.breakline.SingleLineStrategy;

/* JADX INFO: loaded from: classes2.dex */
public class ScaleWordSingleLineCell extends SingleLineCell {
    private static final float SCALE_SIZE = 0.3f;
    private float mHighLightPercentage;

    public ScaleWordSingleLineCell(Context context, String[] strArr, AttachInfo attachInfo, int i2) {
        super(context, strArr, attachInfo, i2);
        ((SingleLineCell) this).mLine = i2;
        SingleLineStrategy singleLineStrategy = new SingleLineStrategy();
        singleLineStrategy.setExtraWidth(0);
        this.mBreakLineStrategy = singleLineStrategy;
    }

    private float getScalePercentage(float f2) {
        double d2 = f2;
        if (d2 <= 0.5d) {
            return f2 * 2.0f;
        }
        if (d2 > 0.5d) {
            return (1.0f - f2) * 2.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 < 0.0f) {
            return 0.0f;
        }
        return f2;
    }

    private float getScaleSize(float f2) {
        return (getScalePercentage(f2) * this.mAttachInfo.getHighLightScaleRate()) + 1.0f;
    }

    private void updateHighLightWordAndPercentage(int i2, int i3) {
        this.mHighLightWordIndex = i2;
        this.mHighLightWordPercentage = i3;
        float lyricWordWidth = 0.0f;
        int i4 = 0;
        while (i4 <= i2) {
            if (i4 < this.mLyricLineInfo.getLyricWords().length) {
                lyricWordWidth += i4 != i2 ? this.mLyricLineInfo.getLyricWords()[i4].getLyricWordWidth() : (this.mLyricLineInfo.getLyricWords()[i4].getLyricWordWidth() * i3) / 100.0f;
            }
            i4++;
        }
        this.mHighLightPercentage = lyricWordWidth / this.mLyricLineInfo.getLineWidth();
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.SingleLineCell
    public void drawLyricLine(Canvas canvas, String str, float f2, float f3, float f4, Paint paint) {
        float lyricWordWidth = 0.0f;
        if (this.mLyricLineInfo.getLineWidth() > getVisibleRect().right - getVisibleRect().left && getOriginalLineHighLightPercentage() > 0.1d) {
            canvas.translate((int) (((getVisibleRect().right - getVisibleRect().left) - this.mLyricLineInfo.getLineWidth()) * getOriginalLineHighLightPercentage()), 0.0f);
        }
        int i2 = 0;
        boolean z = getAttachInfo().getCurrentHighLightLine() == ((SingleLineCell) this).mLine;
        this.mIsHighLighting = z;
        if (!z) {
            paint.setColor(getAttachInfo().getTextColor());
            paint.setTextSize(getAttachInfo().getTextSize());
            Paint selectLinePaint = getSelectLinePaint(paint);
            while (i2 < this.mLyricLineInfo.getLyricWords().length) {
                if (this.mAttachInfo.isStroke()) {
                    canvas.drawText(this.mLyricLineInfo.getLyricWords()[i2].getLyricWord(), ((f2 + lyricWordWidth) + this.mLyricLineInfo.getExtraWidth()) - this.mAttachInfo.getStrokeSize(), this.mAttachInfo.getStrokeSize() + f4, getStrokePaint());
                }
                canvas.drawText(this.mLyricLineInfo.getLyricWords()[i2].getLyricWord(), f2 + lyricWordWidth + this.mLyricLineInfo.getExtraWidth(), f4, selectLinePaint);
                lyricWordWidth += this.mLyricLineInfo.getLyricWords()[i2].getLyricWordWidth();
                i2++;
            }
            return;
        }
        if (this.mAttachInfo.isBoldHighLightWord()) {
            paint.setFakeBoldText(true);
        }
        updateHighLightWordAndPercentage(getAttachInfo().getCurrentHighLightWord(), getAttachInfo().getCurrentHighLightPercentage());
        if (this.mLyricLineInfo.getLineWidth() > getVisibleRect().right - getVisibleRect().left && this.mHighLightPercentage > 0.1d) {
            canvas.translate((int) (((getVisibleRect().right - getVisibleRect().left) - this.mLyricLineInfo.getLineWidth()) * this.mHighLightPercentage), 0.0f);
        }
        float f5 = (this.mHighLightWordPercentage * 1.0f) / 100.0f;
        while (i2 < this.mLyricLineInfo.getLyricWords().length) {
            int i3 = this.mHighLightWordIndex;
            if (i2 < i3) {
                if (this.mAttachInfo.isStroke()) {
                    canvas.drawText(this.mLyricLineInfo.getLyricWords()[i2].getLyricWord(), ((f2 + lyricWordWidth) + this.mLyricLineInfo.getExtraWidth()) - this.mAttachInfo.getStrokeSize(), this.mAttachInfo.getStrokeSize() + f4, getStrokePaint());
                }
                paint.setColor(getAttachInfo().getTextHighLightColor());
                paint.setTextSize(getAttachInfo().getTextSize());
                canvas.drawText(this.mLyricLineInfo.getLyricWords()[i2].getLyricWord(), f2 + lyricWordWidth + this.mLyricLineInfo.getExtraWidth(), f4, paint);
            } else if (i2 == i3) {
                paint.setTextSize(getAttachInfo().getTextSize() * getScaleSize(f5));
                float fMeasureText = paint.measureText(this.mLyricLineInfo.getLyricWords()[i2].getLyricWord());
                float lyricWordWidth2 = (fMeasureText - this.mLyricLineInfo.getLyricWords()[i2].getLyricWordWidth()) / 2.0f;
                RectF rectF = new RectF();
                float f6 = (f2 + lyricWordWidth) - lyricWordWidth2;
                rectF.left = f6;
                rectF.right = f6 + fMeasureText;
                rectF.top = getVisibleRect().top - lyricWordWidth2;
                rectF.bottom = getVisibleRect().bottom + lyricWordWidth2;
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                float f7 = rectF.left;
                float f8 = rectF.top;
                float f9 = f8 + ((rectF.bottom - f8) / 2.0f);
                float f10 = fontMetrics.bottom;
                float f11 = (f9 + ((f10 - fontMetrics.top) / 2.0f)) - f10;
                if (this.mAttachInfo.isStroke()) {
                    Paint strokePaint = getStrokePaint();
                    strokePaint.setTextSize(getAttachInfo().getTextSize() * getScaleSize(f5));
                    canvas.drawText(this.mLyricLineInfo.getLyricWords()[i2].getLyricWord(), f7 - this.mAttachInfo.getStrokeSize(), this.mAttachInfo.getStrokeSize() + f11, strokePaint);
                }
                paint.setColor(getAttachInfo().getTextColor());
                canvas.drawText(this.mLyricLineInfo.getLyricWords()[i2].getLyricWord(), f7, f11, paint);
                canvas.save();
                rectF.right = rectF.left + (fMeasureText * f5);
                canvas.clipRect(rectF);
                paint.setColor(getAttachInfo().getTextHighLightColor());
                canvas.drawText(this.mLyricLineInfo.getLyricWords()[i2].getLyricWord(), f7, f11, paint);
                canvas.restore();
            } else if (i2 > i3) {
                if (this.mAttachInfo.isStroke()) {
                    canvas.drawText(this.mLyricLineInfo.getLyricWords()[i2].getLyricWord(), ((f2 + lyricWordWidth) + this.mLyricLineInfo.getExtraWidth()) - this.mAttachInfo.getStrokeSize(), this.mAttachInfo.getStrokeSize() + f4, getStrokePaint());
                }
                paint.setColor(getAttachInfo().getTextColor());
                paint.setTextSize(getAttachInfo().getTextSize());
                canvas.drawText(this.mLyricLineInfo.getLyricWords()[i2].getLyricWord(), f2 + lyricWordWidth + this.mLyricLineInfo.getExtraWidth(), f4, paint);
            }
            lyricWordWidth += this.mLyricLineInfo.getLyricWords()[i2].getLyricWordWidth();
            i2++;
        }
    }
}
