package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.cell.breakline.LyricLineInfo;
import com.kugou.framework.lyric4.cell.breakline.LyricWord;
import com.kugou.framework.lyric4.cell.breakline.WrapLineStrategy;
import com.kugou.framework.lyric4.utils.SpanUtil;

/* JADX INFO: loaded from: classes2.dex */
public class ScaleWordWrapLineCell extends WrapLineCell {
    private static final float SCALE_SIZE = 0.3f;

    public ScaleWordWrapLineCell(Context context, String[] strArr, AttachInfo attachInfo, int i2) {
        super(context, strArr, attachInfo, i2);
        WrapLineStrategy wrapLineStrategy = new WrapLineStrategy();
        wrapLineStrategy.setExtraWidth(0);
        this.mBreakLineStrategy = wrapLineStrategy;
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

    private void updateHighLightWordAndPercentage() {
        LyricLineInfo[] lyricLineInfoArr = this.mLyricLineInfo;
        if (lyricLineInfoArr.length == 1) {
            this.mHighLightWordIndex = getAttachInfo().getCurrentHighLightWord();
            this.mHighLightWordPercentage = getAttachInfo().getCurrentHighLightPercentage();
            return;
        }
        int i2 = 0;
        int i3 = 0;
        for (LyricLineInfo lyricLineInfo : lyricLineInfoArr) {
            for (LyricWord lyricWord : lyricLineInfo.getLyricWords()) {
                if (lyricWord.getIndex() >= getAttachInfo().getCurrentHighLightWord()) {
                    if (lyricWord.getIndex() != getAttachInfo().getCurrentHighLightWord()) {
                        if (lyricWord.getIndex() > getAttachInfo().getCurrentHighLightWord()) {
                            break;
                        }
                    } else {
                        i2++;
                    }
                } else {
                    i3++;
                }
            }
        }
        if (i2 == 1) {
            this.mHighLightWordIndex = i3;
            this.mHighLightWordPercentage = getAttachInfo().getCurrentHighLightPercentage();
        } else {
            this.mHighLightWordIndex = getAttachInfo().getCurrentHighLightWord() + ((i2 * getAttachInfo().getCurrentHighLightPercentage()) / 100);
            this.mHighLightWordPercentage = 100;
        }
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.WrapLineCell
    public void drawLyricLine(Canvas canvas, LyricLineInfo lyricLineInfo, String str, float f2, float f3, float f4, Paint paint, int i2, int i3, RectF rectF) {
        int i4;
        float f5;
        RectF rectF2;
        int i5;
        RectF rectF3 = rectF;
        boolean z = getAttachInfo().getCurrentHighLightLine() == this.mLine;
        this.mIsHighLighting = z;
        if (!z) {
            paint.setColor(getAttachInfo().getTextColor());
            paint.setAlpha(getActualAlphaValue(getAttachInfo().getTextColor()));
            paint.setTextSize(getAttachInfo().getTextSize());
            Paint selectLinePaint = getSelectLinePaint(paint);
            float lyricWordWidth = 0.0f;
            for (int i6 = 0; i6 < lyricLineInfo.getLyricWords().length; i6++) {
                if (this.mAttachInfo.isStroke()) {
                    drawTextWord(canvas, lyricLineInfo, i6, lyricLineInfo.getLyricWords()[i6].getLyricWord(), ((f2 + lyricWordWidth) + lyricLineInfo.getExtraWidth()) - this.mAttachInfo.getStrokeSize(), f3, f4 + this.mAttachInfo.getStrokeSize(), getStrokePaint());
                }
                drawTextWord(canvas, lyricLineInfo, i6, lyricLineInfo.getLyricWords()[i6].getLyricWord(), f2 + lyricWordWidth + lyricLineInfo.getExtraWidth(), f3, f4, selectLinePaint);
                lyricWordWidth += lyricLineInfo.getLyricWords()[i6].getLyricWordWidth();
            }
            return;
        }
        if (this.mAttachInfo.isBoldHighLightWord()) {
            paint.setFakeBoldText(true);
        }
        updateHighLightWordAndPercentage();
        int i7 = this.mHighLightWordIndex;
        if (i7 < i2) {
            paint.setColor(getAttachInfo().getTextColor());
            paint.setAlpha(getAlphaValue());
            paint.setTextSize(getAttachInfo().getTextSize());
            getPlayLinePaint(paint);
            float lyricWordWidth2 = 0.0f;
            for (int i8 = 0; i8 < lyricLineInfo.getLyricWords().length; i8++) {
                if (this.mAttachInfo.isStroke()) {
                    drawTextWord(canvas, lyricLineInfo, i8, lyricLineInfo.getLyricWords()[i8].getLyricWord(), ((f2 + lyricWordWidth2) + lyricLineInfo.getExtraWidth()) - this.mAttachInfo.getStrokeSize(), f3, f4 + this.mAttachInfo.getStrokeSize(), getStrokePaint());
                }
                drawTextWord(canvas, lyricLineInfo, i8, lyricLineInfo.getLyricWords()[i8].getLyricWord(), f2 + lyricWordWidth2 + lyricLineInfo.getExtraWidth(), f3, f4, paint);
                lyricWordWidth2 += lyricLineInfo.getLyricWords()[i8].getLyricWordWidth();
            }
            return;
        }
        if (i7 >= i3) {
            paint.setColor(getAttachInfo().getTextHighLightColor());
            paint.setAlpha(getAlphaValue());
            paint.setTextSize(getAttachInfo().getTextSize());
            float lyricWordWidth3 = 0.0f;
            for (int i9 = 0; i9 < lyricLineInfo.getLyricWords().length; i9++) {
                if (this.mAttachInfo.isStroke()) {
                    drawTextWord(canvas, lyricLineInfo, i9, lyricLineInfo.getLyricWords()[i9].getLyricWord(), ((f2 + lyricWordWidth3) + lyricLineInfo.getExtraWidth()) - this.mAttachInfo.getStrokeSize(), f3, f4 + this.mAttachInfo.getStrokeSize(), getStrokePaint());
                }
                drawTextWord(canvas, lyricLineInfo, i9, lyricLineInfo.getLyricWords()[i9].getLyricWord(), f2 + lyricWordWidth3 + lyricLineInfo.getExtraWidth(), f3, f4, paint);
                lyricWordWidth3 += lyricLineInfo.getLyricWords()[i9].getLyricWordWidth();
            }
            paint.setColor(getAttachInfo().getTextColor());
            paint.setAlpha(getAlphaValue());
            return;
        }
        int i10 = i7 - i2;
        float f6 = (this.mHighLightWordPercentage * 1.0f) / 100.0f;
        int i11 = 0;
        float lyricWordWidth4 = 0.0f;
        while (i11 < lyricLineInfo.getLyricWords().length) {
            if (i11 < i10) {
                if (this.mAttachInfo.isStroke()) {
                    i5 = i11;
                    drawTextWord(canvas, lyricLineInfo, i11, lyricLineInfo.getLyricWords()[i11].getLyricWord(), ((f2 + lyricWordWidth4) + lyricLineInfo.getExtraWidth()) - this.mAttachInfo.getStrokeSize(), f3, f4 + this.mAttachInfo.getStrokeSize(), getStrokePaint());
                } else {
                    i5 = i11;
                }
                paint.setColor(getAttachInfo().getTextHighLightColor());
                paint.setAlpha(getAlphaValue());
                paint.setTextSize(getAttachInfo().getTextSize());
                drawTextWord(canvas, lyricLineInfo, i5, lyricLineInfo.getLyricWords()[i5].getLyricWord(), f2 + lyricWordWidth4 + lyricLineInfo.getExtraWidth(), f3, f4, paint);
                i4 = i5;
            } else {
                int i12 = i11;
                if (i12 == i10) {
                    paint.setTextSize(getAttachInfo().getTextSize() * getScaleSize(f6));
                    float fMeasureText = SpanUtil.measureText(paint, lyricLineInfo.getSpanMap(), i12, lyricLineInfo.getLyricWords()[i12].getLyricWord());
                    float lyricWordWidth5 = (fMeasureText - lyricLineInfo.getLyricWords()[i12].getLyricWordWidth()) / 2.0f;
                    RectF rectF4 = new RectF();
                    float f7 = (f2 + lyricWordWidth4) - lyricWordWidth5;
                    rectF4.left = f7;
                    rectF4.right = f7 + fMeasureText;
                    rectF4.top = rectF3.top - lyricWordWidth5;
                    rectF4.bottom = rectF3.bottom + lyricWordWidth5;
                    Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                    float f8 = rectF4.left;
                    float f9 = rectF4.top;
                    float f10 = f9 + ((rectF4.bottom - f9) / 2.0f);
                    float f11 = fontMetrics.bottom;
                    float f12 = (f10 + ((f11 - fontMetrics.top) / 2.0f)) - f11;
                    if (this.mAttachInfo.isStroke()) {
                        Paint strokePaint = getStrokePaint();
                        strokePaint.setTextSize(getAttachInfo().getTextSize() * getScaleSize(f6));
                        f5 = f8;
                        rectF2 = rectF4;
                        drawTextWord(canvas, lyricLineInfo, i12, lyricLineInfo.getLyricWords()[i12].getLyricWord(), f8 - this.mAttachInfo.getStrokeSize(), f3, f12 + this.mAttachInfo.getStrokeSize(), strokePaint);
                    } else {
                        f5 = f8;
                        rectF2 = rectF4;
                    }
                    paint.setColor(getAttachInfo().getTextColor());
                    paint.setAlpha(getAlphaValue());
                    getPlayLinePaint(paint);
                    float f13 = f5;
                    drawTextWord(canvas, lyricLineInfo, i12, lyricLineInfo.getLyricWords()[i12].getLyricWord(), f13, f3, f12, paint);
                    canvas.save();
                    rectF2.right = rectF2.left + (fMeasureText * f6);
                    canvas.clipRect(rectF2);
                    paint.setColor(getAttachInfo().getTextHighLightColor());
                    paint.setAlpha(getAlphaValue());
                    i4 = i12;
                    drawTextWord(canvas, lyricLineInfo, i12, lyricLineInfo.getLyricWords()[i12].getLyricWord(), f13, f3, f12, paint);
                    canvas.restore();
                } else {
                    i4 = i12;
                    if (i4 > i10) {
                        if (this.mAttachInfo.isStroke()) {
                            float f14 = f2 + lyricWordWidth4;
                            canvas.drawText(lyricLineInfo.getLyricWords()[i4].getLyricWord(), (lyricLineInfo.getExtraWidth() + f14) - this.mAttachInfo.getStrokeSize(), f4 + this.mAttachInfo.getStrokeSize(), getStrokePaint());
                            drawTextWord(canvas, lyricLineInfo, i4, lyricLineInfo.getLyricWords()[i4].getLyricWord(), (f14 + lyricLineInfo.getExtraWidth()) - this.mAttachInfo.getStrokeSize(), f3, f4 + this.mAttachInfo.getStrokeSize(), getStrokePaint());
                        }
                        paint.setColor(getAttachInfo().getTextColor());
                        paint.setAlpha(getAlphaValue());
                        paint.setTextSize(getAttachInfo().getTextSize());
                        getPlayLinePaint(paint);
                        drawTextWord(canvas, lyricLineInfo, i4, lyricLineInfo.getLyricWords()[i4].getLyricWord(), f2 + lyricWordWidth4 + lyricLineInfo.getExtraWidth(), f3, f4, paint);
                    }
                }
            }
            lyricWordWidth4 += lyricLineInfo.getLyricWords()[i4].getLyricWordWidth();
            i11 = i4 + 1;
            rectF3 = rectF;
        }
    }
}
