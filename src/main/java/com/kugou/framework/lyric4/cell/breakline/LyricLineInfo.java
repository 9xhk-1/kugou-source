package com.kugou.framework.lyric4.cell.breakline;

import com.kugou.framework.lyric4.span.Span;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class LyricLineInfo {
    private float mBaseLineOffset;
    private float mExtraWidth;
    private float mLineHeight;
    private float mLineWidth;
    private String mLyricLine;
    private LyricWord[] mLyricWords;
    private Map<Integer, Span> mSpanMap;

    public float getBaseLineOffset() {
        return this.mBaseLineOffset;
    }

    public float getExtraWidth() {
        return this.mExtraWidth;
    }

    public float getLineHeight() {
        return this.mLineHeight;
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public String getLyricLine() {
        return this.mLyricLine;
    }

    public LyricWord[] getLyricWords() {
        return this.mLyricWords;
    }

    public Map<Integer, Span> getSpanMap() {
        return this.mSpanMap;
    }

    public void setBaseLineOffset(float f2) {
        this.mBaseLineOffset = f2;
    }

    public void setExtraWidth(float f2) {
        this.mExtraWidth = f2;
    }

    public void setLineHeight(float f2) {
        this.mLineHeight = f2;
    }

    public void setLineWidth(float f2) {
        this.mLineWidth = f2;
    }

    public void setLyricLine(String str) {
        this.mLyricLine = str;
    }

    public void setLyricWords(LyricWord[] lyricWordArr) {
        this.mLyricWords = lyricWordArr;
    }

    public void setSpanMap(Map<Integer, Span> map) {
        this.mSpanMap = map;
    }
}
