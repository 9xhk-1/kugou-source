package com.kugou.framework.lyric;

import android.graphics.Paint;
import android.graphics.Typeface;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetLyricView implements ILyricView {
    public int backgroundColor;
    public float contentWidth;
    public int frontColor;
    public float leading;
    public LyricData lyricData;
    public float rowHeight;
    public float textSize;
    public float wordHeight;
    public String defaultMsg = LyricConstent.defaultMsg;
    public Paint pen = new Paint();

    public WidgetLyricView() {
        initPen();
    }

    private float getLeading(Paint paint) {
        return paint.getFontMetrics().leading;
    }

    private float getWordHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getContentWidth() {
        return this.contentWidth;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public String getCurrentLyrics() {
        LyricData lyricData = this.lyricData;
        return lyricData != null ? lyricData.getCurrentLyrics() : this.defaultMsg;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public LyricData getLyricData() {
        return this.lyricData;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public Paint getPen() {
        return this.pen;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getRowHeight() {
        return this.rowHeight;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getTextSize() {
        return this.textSize;
    }

    public void initPen() {
        this.pen.setAntiAlias(true);
        this.pen.setStrokeWidth(0.0f);
        this.pen.setStrokeCap(Paint.Cap.ROUND);
        this.pen.setTextSize(this.textSize);
        this.pen.setTypeface(Typeface.defaultFromStyle(0));
        this.wordHeight = getWordHeight(this.pen);
        float leading = getLeading(this.pen);
        this.leading = leading;
        this.rowHeight = this.wordHeight + leading;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public boolean isLyrViewShown() {
        return isLyrViewShown();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public boolean isLyricLoaded() {
        return this.lyricData != null;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public boolean isLyricSplited() {
        return true;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void refresh() {
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void release() {
        this.lyricData = null;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void resetRowIndex() {
        LyricData lyricData = this.lyricData;
        if (lyricData != null) {
            lyricData.setRowIndex(0);
        }
    }

    public void setContentWidth(float f2) {
        this.contentWidth = f2;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void setDefaultMsg(String str) {
        this.defaultMsg = str;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void setLyricData(LyricData lyricData) {
        synchronized (LyricManager.lyrDataLock) {
            this.lyricData = lyricData;
        }
    }

    public void setTextSize(float f2) {
        this.textSize = f2;
        initPen();
    }
}
