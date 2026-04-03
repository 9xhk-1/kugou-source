package com.kugou.framework.lyric4;

import com.kugou.framework.lyric.LyricData;

/* JADX INFO: loaded from: classes2.dex */
public class LyricCutDelegate {
    private LyricData rawData;

    public LyricData cutLyricData(long j, long j2) {
        LyricData lyricData = this.rawData;
        return (lyricData == null || j < 0 || j2 < 0) ? lyricData : LyricData.cutLyricData(lyricData, j, j2);
    }

    public LyricData getRawData() {
        return this.rawData;
    }

    public LyricData recoverLyricData() {
        return this.rawData;
    }

    public void setRawData(LyricData lyricData) {
        this.rawData = lyricData;
    }
}
