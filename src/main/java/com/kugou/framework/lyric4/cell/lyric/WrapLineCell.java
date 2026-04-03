package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.cell.breakline.BreakLineStrategy;
import com.kugou.framework.lyric4.cell.breakline.LyricLineInfo;
import com.kugou.framework.lyric4.cell.breakline.LyricWord;
import com.kugou.framework.lyric4.cell.breakline.WrapLineStrategy;
import com.kugou.framework.lyric4.span.Span;
import com.kugou.framework.lyric4.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class WrapLineCell extends BaseLyricCell {
    public boolean isTransCell;
    public BreakLineStrategy mBreakLineStrategy;
    public int mLineSpacing;
    public LyricLineInfo[] mLyricLineInfo;
    public RectF mTempRect;

    public WrapLineCell(Context context, String[] strArr, AttachInfo attachInfo, int i2) {
        super(context, strArr, attachInfo);
        this.mTempRect = new RectF();
        this.isTransCell = false;
        this.mLine = i2;
        this.mBreakLineStrategy = new WrapLineStrategy();
    }

    private void onMeasureHandle(int i2) {
        StringBuilder sb = new StringBuilder();
        int lineHeight = 0;
        for (LyricLineInfo lyricLineInfo : this.mLyricLineInfo) {
            if (lyricLineInfo != null) {
                lineHeight = (int) (lineHeight + lyricLineInfo.getLineHeight());
                sb.append(lyricLineInfo.getLyricLine());
            }
        }
        this.mLyricLine = sb.toString();
        setMeasureResult(i2, lineHeight + (this.mLineSpacing * (this.mLyricLineInfo.length - 1)) + getPaddingTop() + getPaddingBottom());
    }

    public void drawLyricLine(Canvas canvas, LyricLineInfo lyricLineInfo, String str, float f2, float f3, float f4, Paint paint, int i2, int i3, RectF rectF) {
        if (this.mAttachInfo.isStroke()) {
            drawText(canvas, lyricLineInfo, str, f2 - this.mAttachInfo.getStrokeSize(), f3, f4 + this.mAttachInfo.getStrokeSize(), getStrokePaint());
        }
        if (this.mIsHighLighting) {
            drawText(canvas, lyricLineInfo, str, f2, f3, f4, getPlayLinePaint(getDefaultPaint()));
        } else {
            drawText(canvas, lyricLineInfo, str, f2, f3, f4, getSelectLinePaint(getDefaultPaint()));
        }
    }

    public void drawText(Canvas canvas, LyricLineInfo lyricLineInfo, String str, float f2, float f3, float f4, Paint paint) {
        if (!isDrawSpan() || Utils.isEmpty(lyricLineInfo.getSpanMap())) {
            canvas.drawText(str, f2, f4, paint);
            return;
        }
        float lyricWordWidth = f2;
        for (int i2 = 0; i2 < lyricLineInfo.getLyricWords().length; i2++) {
            LyricWord lyricWord = lyricLineInfo.getLyricWords()[i2];
            Span span = lyricLineInfo.getSpanMap().get(Integer.valueOf(i2));
            if (span != null) {
                span.setCell(this);
                if (!span.draw(canvas, lyricWord.getLyricWord(), lyricWordWidth, f3, lyricWordWidth + lyricWord.getLyricWordWidth(), f3 + lyricLineInfo.getLineHeight(), f4, paint)) {
                    canvas.drawText(lyricWord.getLyricWord(), lyricWordWidth, f4, paint);
                }
            } else {
                canvas.drawText(lyricWord.getLyricWord(), lyricWordWidth, f4, paint);
            }
            lyricWordWidth += lyricWord.getLyricWordWidth();
        }
    }

    public void drawTextWord(Canvas canvas, LyricLineInfo lyricLineInfo, int i2, String str, float f2, float f3, float f4, Paint paint) {
        if (!isDrawSpan() || Utils.isEmpty(lyricLineInfo.getSpanMap()) || lyricLineInfo.getSpanMap().get(Integer.valueOf(i2)) == null) {
            canvas.drawText(str, f2, f4, paint);
            return;
        }
        Span span = lyricLineInfo.getSpanMap().get(Integer.valueOf(i2));
        LyricWord lyricWord = lyricLineInfo.getLyricWords()[i2];
        span.setCell(this);
        if (span.draw(canvas, str, f2, f3, f2 + lyricWord.getLyricWordWidth(), f3 + lyricLineInfo.getLineHeight(), f4, paint)) {
            return;
        }
        canvas.drawText(str, f2, f4, paint);
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public int getLine() {
        return this.mLine;
    }

    public int getLineSpacing() {
        return this.mLineSpacing;
    }

    public LyricLineInfo[] getLyricLineInfos() {
        return this.mLyricLineInfo;
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public int getSingleLineHeight() {
        LyricLineInfo[] lyricLineInfoArr = this.mLyricLineInfo;
        return lyricLineInfoArr.length > 0 ? ((int) lyricLineInfoArr[0].getLineHeight()) + getPaddingTop() + getPaddingBottom() : super.getSingleLineHeight();
    }

    public boolean isDrawSpan() {
        return !this.isTransCell;
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public boolean isInBlankArea(float f2, float f3) {
        float lineWidth;
        float lineHeight = 0.0f;
        for (int i2 = 0; i2 < this.mLyricLineInfo.length; i2++) {
            int alignMode = getAlignMode();
            if (alignMode == 0) {
                lineWidth = getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - this.mLyricLineInfo[i2].getLineWidth()) / 2.0f);
            } else if (alignMode == 1 || alignMode != 2) {
                int i3 = getVisibleRect().left;
                lineWidth = i3;
            } else {
                lineWidth = getVisibleRect().right - this.mLyricLineInfo[i2].getLineWidth();
            }
            float f4 = getCellRect().top + lineHeight;
            float lineWidth2 = this.mLyricLineInfo[i2].getLineWidth() + lineWidth;
            float lineHeight2 = this.mLyricLineInfo[i2].getLineHeight() + f4 + this.mLineSpacing;
            if (i2 == this.mLyricLineInfo.length - 1) {
                lineHeight2 = getCellRect().bottom;
            }
            lineHeight = lineHeight + this.mLyricLineInfo[i2].getLineHeight() + this.mLineSpacing;
            if (f3 > f4 && f3 < lineHeight2 && (f2 < lineWidth || f2 > lineWidth2)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
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
            float f4 = this.mVisibleRect.top + f3;
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
            float f5 = lineWidth;
            RectF rectF = this.mTempRect;
            rectF.left = f5;
            rectF.top = getVisibleRect().top + f3;
            this.mTempRect.right = this.mLyricLineInfo[i2].getLineWidth() + f5;
            RectF rectF2 = this.mTempRect;
            rectF2.bottom = rectF2.top + this.mLyricLineInfo[i2].getLineHeight();
            float lineHeight3 = f3 + this.mLyricLineInfo[i2].getLineHeight() + this.mLineSpacing;
            if (isRectInVisibleRange(this.mTempRect)) {
                LyricLineInfo[] lyricLineInfoArr2 = this.mLyricLineInfo;
                drawLyricLine(canvas, lyricLineInfoArr2[i2], lyricLineInfoArr2[i2].getLyricLine(), f5, f4, baseLineOffset, getDefaultPaint(), length, length + this.mLyricLineInfo[i2].getLyricWords().length, this.mTempRect);
            }
            length += this.mLyricLineInfo[i2].getLyricWords().length;
            i2++;
            f2 = lineHeight2;
            f3 = lineHeight3;
        }
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
        this.mLyricLineInfo = this.mBreakLineStrategy.getBreakLineResult(this.mAttachInfo.getSpanMap(this.mLine), this.mLyricWords, (i2 - getPaddingLeft()) - getPaddingRight(), getDefaultPaint(), this.mAttachInfo.getBreakFactor());
        onMeasureHandle(i2);
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onMeasureCell(int i2, int i3, float f2) {
        onMeasureHandle(i2);
        this.mIsHighLighting = getAttachInfo().getCurrentHighLightLine() == this.mLine;
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onMeasureCellWithAnimation(int i2, int i3, float f2) {
        onMeasureCell(i2, i3, 1.0f);
    }

    public void setLineSpacing(int i2) {
        this.mLineSpacing = i2;
    }

    public void setTransCell(boolean z) {
        this.isTransCell = z;
    }
}
