package com.kugou.framework.lyric4.cell.breakline;

import android.graphics.Paint;
import com.kugou.framework.lyric4.span.Span;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SingleLineStrategy implements BreakLineStrategy {
    private int mExtraWidth;

    private LyricWord[] transformStringToLyricWord(String[] strArr, Paint paint) {
        LyricWord[] lyricWordArr = new LyricWord[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            if (str == null) {
                str = "";
            }
            lyricWordArr[i2] = new LyricWord(str, i2, paint.measureText(str) + (this.mExtraWidth * 2), str.length());
        }
        return lyricWordArr;
    }

    @Override // com.kugou.framework.lyric4.cell.breakline.BreakLineStrategy
    public LyricLineInfo[] getBreakLineResult(Map<Integer, Span> map, String[] strArr, int i2, Paint paint, float f2) {
        if (strArr == null) {
            strArr = new String[]{""};
        }
        LyricWord[] lyricWordArrTransformStringToLyricWord = transformStringToLyricWord(strArr, paint);
        float lyricWordWidth = 0.0f;
        for (LyricWord lyricWord : lyricWordArrTransformStringToLyricWord) {
            lyricWordWidth += lyricWord.getLyricWordWidth();
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        String string = sb.toString();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f3 = fontMetrics.bottom - fontMetrics.top;
        LyricLineInfo lyricLineInfo = new LyricLineInfo();
        lyricLineInfo.setSpanMap(map);
        lyricLineInfo.setLyricWords(lyricWordArrTransformStringToLyricWord);
        lyricLineInfo.setLyricLine(string);
        lyricLineInfo.setLineHeight(f3);
        lyricLineInfo.setLineWidth(lyricWordWidth);
        lyricLineInfo.setExtraWidth(this.mExtraWidth);
        lyricLineInfo.setBaseLineOffset((-(fontMetrics.bottom + fontMetrics.top)) / 2.0f);
        return new LyricLineInfo[]{lyricLineInfo};
    }

    public void setExtraWidth(int i2) {
        this.mExtraWidth = i2;
    }
}
