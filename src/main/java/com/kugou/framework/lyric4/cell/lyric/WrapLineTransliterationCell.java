package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.cell.breakline.LyricLineInfo;
import com.kugou.framework.lyric4.cell.breakline.LyricWord;

/* JADX INFO: loaded from: classes2.dex */
public class WrapLineTransliterationCell extends WrapLineCell {
    public WrapLineTransliterationCell(Context context, String[] strArr, AttachInfo attachInfo, int i2) {
        super(context, strArr, attachInfo, i2);
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
        int i4 = 0;
        this.mIsHighLighting = getAttachInfo().getCurrentHighLightLine() == this.mLine;
        if (this.mAttachInfo.isStroke()) {
            canvas.drawText(str, f2 - this.mAttachInfo.getStrokeSize(), this.mAttachInfo.getStrokeSize() + f4, getStrokePaint());
        }
        if (!this.mIsHighLighting) {
            canvas.drawText(str, f2, f4, getSelectLinePaint(getDefaultPaint(0.36f), 0.36f));
            return;
        }
        updateHighLightWordAndPercentage();
        int i5 = this.mHighLightWordIndex;
        if (i5 < i2) {
            canvas.drawText(str, f2, f4, getPlayLinePaint(getDefaultPaint(0.36f), 0.36f));
            return;
        }
        if (i5 >= i3) {
            canvas.drawText(str, f2, f4, getHighLightPaint(0.36f));
            return;
        }
        int i6 = i5 - i2;
        float lyricWordWidth = 0.0f;
        while (i4 <= i6) {
            lyricWordWidth += i4 != i6 ? lyricLineInfo.getLyricWords()[i4].getLyricWordWidth() : (lyricLineInfo.getLyricWords()[i4].getLyricWordWidth() * this.mHighLightWordPercentage) / 100.0f;
            i4++;
        }
        float lineWidth = lyricWordWidth / lyricLineInfo.getLineWidth();
        if (lineWidth <= 0.0f) {
            canvas.drawText(str, f2, f4, getPlayLinePaint(getDefaultPaint(0.36f), 0.36f));
            return;
        }
        canvas.drawText(str, f2, f4, getPlayLinePaint(getDefaultPaint(0.36f), 0.36f));
        canvas.save();
        RectF rectF2 = this.mTempRect;
        rectF2.right = rectF2.left + (lyricLineInfo.getLineWidth() * lineWidth);
        canvas.clipRect(this.mTempRect);
        canvas.drawText(str, f2, f4, getHighLightPaint(0.36f));
        canvas.restore();
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.WrapLineCell
    public boolean isDrawSpan() {
        return false;
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.WrapLineCell, com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
        float lineWidth;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        int length = 0;
        while (true) {
            LyricLineInfo[] lyricLineInfoArr = this.mLyricLineInfo;
            if (i2 >= lyricLineInfoArr.length) {
                return;
            }
            float lineHeight = f2 + (lyricLineInfoArr[i2].getLineHeight() / 2.0f);
            float baseLineOffset = this.mVisibleRect.top + lineHeight + this.mLyricLineInfo[i2].getBaseLineOffset();
            float lineHeight2 = lineHeight + (this.mLyricLineInfo[i2].getLineHeight() / 2.0f) + this.mLineSpacing;
            int alignMode = getAlignMode();
            if (alignMode == 0) {
                lineWidth = getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - this.mLyricLineInfo[i2].getLineWidth()) / 2.0f);
            } else if (alignMode == 1 || alignMode != 2) {
                int i3 = getVisibleRect().left;
                lineWidth = i3;
            } else {
                lineWidth = getVisibleRect().right - this.mLyricLineInfo[i2].getLineWidth();
            }
            float f4 = lineWidth;
            RectF rectF = this.mTempRect;
            rectF.left = f4;
            rectF.top = getVisibleRect().top + f3;
            this.mTempRect.right = this.mLyricLineInfo[i2].getLineWidth() + f4;
            RectF rectF2 = this.mTempRect;
            rectF2.bottom = rectF2.top + this.mLyricLineInfo[i2].getLineHeight();
            float lineHeight3 = f3 + this.mLyricLineInfo[i2].getLineHeight() + this.mLineSpacing;
            if (isRectInVisibleRange(this.mTempRect)) {
                LyricLineInfo[] lyricLineInfoArr2 = this.mLyricLineInfo;
                drawLyricLine(canvas, lyricLineInfoArr2[i2], lyricLineInfoArr2[i2].getLyricLine(), f4, 0.0f, baseLineOffset, getDefaultPaint(), length, length + this.mLyricLineInfo[i2].getLyricWords().length, this.mTempRect);
            }
            length += this.mLyricLineInfo[i2].getLyricWords().length;
            i2++;
            f2 = lineHeight2;
            f3 = lineHeight3;
        }
    }
}
