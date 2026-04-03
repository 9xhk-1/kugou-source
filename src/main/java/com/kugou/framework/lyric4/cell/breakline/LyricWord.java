package com.kugou.framework.lyric4.cell.breakline;

/* JADX INFO: loaded from: classes2.dex */
public class LyricWord {
    private int mIndex;
    private String mLyricWord;
    private int mLyricWordLength;
    private float mLyricWordWidth;

    public LyricWord(String str, int i2, float f2, int i3) {
        this.mLyricWord = str;
        this.mIndex = i2;
        this.mLyricWordWidth = f2;
        this.mLyricWordLength = i3;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public String getLyricWord() {
        return this.mLyricWord;
    }

    public int getLyricWordLength() {
        return this.mLyricWordLength;
    }

    public float getLyricWordWidth() {
        return this.mLyricWordWidth;
    }
}
