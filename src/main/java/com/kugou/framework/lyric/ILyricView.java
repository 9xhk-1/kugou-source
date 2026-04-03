package com.kugou.framework.lyric;

import android.graphics.Paint;

/* JADX INFO: loaded from: classes2.dex */
public interface ILyricView {
    float getContentWidth();

    String getCurrentLyrics();

    LyricData getLyricData();

    Paint getPen();

    float getRowHeight();

    float getTextSize();

    boolean isLyrViewShown();

    boolean isLyricLoaded();

    boolean isLyricSplited();

    void refresh();

    void release();

    void resetRowIndex();

    void setDefaultMsg(String str);

    void setLyricData(LyricData lyricData);
}
