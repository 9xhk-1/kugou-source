package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.cell.breakline.BreakLineStrategy;
import com.kugou.framework.lyric4.cell.breakline.LyricLineInfo;
import com.kugou.framework.lyric4.cell.breakline.SingleLineStrategy;

/* JADX INFO: loaded from: classes2.dex */
public class SingleLineCell extends BaseLyricCell {
    public BreakLineStrategy mBreakLineStrategy;
    public int mLine;
    public LyricLineInfo mLyricLineInfo;
    public boolean mNeedSyncProgress;

    public SingleLineCell(Context context, String[] strArr, AttachInfo attachInfo, int i2) {
        super(context, strArr, attachInfo);
        this.mBreakLineStrategy = new SingleLineStrategy();
        this.mLine = i2;
    }

    public void drawLyricLine(Canvas canvas, String str, float f2, float f3, float f4, Paint paint) {
        if (this.mLyricLineInfo.getLineWidth() > getVisibleRect().right - getVisibleRect().left && getOriginalLineHighLightPercentage() > 0.1d) {
            canvas.translate((int) (((getVisibleRect().right - getVisibleRect().left) - this.mLyricLineInfo.getLineWidth()) * getOriginalLineHighLightPercentage()), 0.0f);
        }
        if (this.mAttachInfo.isStroke()) {
            canvas.drawText(str, f2 - this.mAttachInfo.getStrokeSize(), this.mAttachInfo.getStrokeSize() + f4, getStrokePaint());
        }
        canvas.drawText(str, f2, f4, getSelectLinePaint(getDefaultPaint()));
    }

    public float getLineWidth() {
        LyricLineInfo lyricLineInfo = this.mLyricLineInfo;
        if (lyricLineInfo != null) {
            return lyricLineInfo.getLineWidth();
        }
        return 0.0f;
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public String getLyricLine() {
        if (!TextUtils.isEmpty(this.mLyricLine)) {
            return this.mLyricLine;
        }
        LyricLineInfo lyricLineInfo = this.mLyricLineInfo;
        return (lyricLineInfo == null || TextUtils.isEmpty(lyricLineInfo.getLyricLine())) ? "歌词" : this.mLyricLineInfo.getLyricLine();
    }

    public float getOriginalLineHighLightPercentage() {
        if (!this.mNeedSyncProgress) {
            return 0.0f;
        }
        float currentHighLightWord = (getAttachInfo().getCurrentHighLightWord() + ((getAttachInfo().getCurrentHighLightPercentage() * 1.0f) / 100.0f)) / getAttachInfo().getLineTotalWords();
        float f2 = currentHighLightWord >= 0.0f ? currentHighLightWord : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public boolean isInBlankArea(float f2, float f3) {
        float lineWidth;
        int i2;
        int alignMode = getAlignMode();
        if (alignMode != 0) {
            if (alignMode == 1 || alignMode != 2 || this.mLyricLineInfo.getLineWidth() > getVisibleRect().right - getVisibleRect().left) {
                i2 = getVisibleRect().left;
                lineWidth = i2;
            } else {
                lineWidth = getVisibleRect().right - this.mLyricLineInfo.getLineWidth();
            }
        } else if (this.mLyricLineInfo.getLineWidth() > getVisibleRect().right - getVisibleRect().left) {
            i2 = getVisibleRect().left;
            lineWidth = i2;
        } else {
            lineWidth = getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - this.mLyricLineInfo.getLineWidth()) / 2.0f);
        }
        return f2 < lineWidth || f2 > lineWidth + this.mLyricLineInfo.getLineWidth();
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
        float lineWidth;
        int i2;
        float fCenterY = this.mVisibleRect.centerY() + this.mLyricLineInfo.getBaseLineOffset();
        int i3 = getVisibleRect().right - getVisibleRect().left;
        int alignMode = getAlignMode();
        if (alignMode == 0) {
            float f2 = i3;
            if (this.mLyricLineInfo.getLineWidth() > f2) {
                i2 = getVisibleRect().left;
                lineWidth = i2;
            } else {
                lineWidth = getVisibleRect().left + ((f2 - this.mLyricLineInfo.getLineWidth()) / 2.0f);
            }
        } else if (alignMode == 1 || alignMode != 2 || this.mLyricLineInfo.getLineWidth() > i3) {
            i2 = getVisibleRect().left;
            lineWidth = i2;
        } else {
            lineWidth = getVisibleRect().right - this.mLyricLineInfo.getLineWidth();
        }
        float f3 = lineWidth;
        if (this.mLyricLineInfo.getLineWidth() <= i3) {
            drawLyricLine(canvas, this.mLyricLineInfo.getLyricLine(), f3, 0.0f, fCenterY, getDefaultPaint());
            return;
        }
        canvas.save();
        canvas.clipRect(getCellRect());
        drawLyricLine(canvas, this.mLyricLineInfo.getLyricLine(), f3, 0.0f, fCenterY, getDefaultPaint());
        canvas.restore();
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
        LyricLineInfo lyricLineInfo = this.mBreakLineStrategy.getBreakLineResult(this.mAttachInfo.getSpanMap(this.mLine), this.mLyricWords, (i2 - getPaddingLeft()) - getPaddingRight(), getDefaultPaint(), 1.0f)[0];
        this.mLyricLineInfo = lyricLineInfo;
        setMeasureResult(i2, ((int) lyricLineInfo.getLineHeight()) + getPaddingTop() + getPaddingBottom());
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onMeasureCell(int i2, int i3, float f2) {
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onMeasureCellWithAnimation(int i2, int i3, float f2) {
    }

    public SingleLineCell(Context context, String[] strArr, AttachInfo attachInfo, int i2, boolean z) {
        super(context, strArr, attachInfo);
        this.mBreakLineStrategy = new SingleLineStrategy();
        this.mNeedSyncProgress = z;
        this.mLine = i2;
    }
}
