package com.kugou.framework.lyric4.cell.breakline;

import android.graphics.Paint;
import com.kugou.framework.lyric.debug.LyricDebug;
import com.kugou.framework.lyric4.span.Span;
import com.kugou.framework.lyric4.utils.SpanUtil;
import com.kugou.framework.lyric4.utils.SplitLyricStringUtils;
import com.kugou.framework.lyric4.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class WrapLineStrategy implements BreakLineStrategy {
    private int mExtraWidth;

    private LyricWord[] transformStringToLyricWord(Map<Integer, Span> map, String[] strArr, int i2, Paint paint) {
        WrapLineStrategy wrapLineStrategy = this;
        String[] strArr2 = strArr;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < strArr2.length) {
            if (strArr2[i3] == null) {
                strArr2[i3] = "";
            }
            float fMeasureText = SpanUtil.measureText(paint, map, i3, strArr2[i3]) + (wrapLineStrategy.mExtraWidth * 2);
            float f2 = i2;
            if (fMeasureText <= f2) {
                arrayList.add(new LyricWord(strArr2[i3], i3, fMeasureText, strArr2[i3].length()));
            } else {
                String[] strArrSplitLyricString = SplitLyricStringUtils.splitLyricString(strArr2[i3]);
                int i4 = 0;
                while (i4 < strArrSplitLyricString.length) {
                    float fMeasureText2 = SpanUtil.measureText(paint, map, i3, strArrSplitLyricString[i4]) + (wrapLineStrategy.mExtraWidth * 2);
                    if (fMeasureText2 <= f2) {
                        arrayList.add(new LyricWord(strArrSplitLyricString[i4], i3, fMeasureText2, strArrSplitLyricString[i4].length()));
                    } else {
                        double d2 = fMeasureText2 / f2;
                        int iCeil = ((int) Math.ceil(d2)) > 0 ? (int) Math.ceil(d2) : 1;
                        int length = strArrSplitLyricString[i4].length() / iCeil;
                        int i5 = 0;
                        int i6 = 0;
                        while (i5 < iCeil) {
                            int i7 = i6 + length;
                            String strSubstring = strArrSplitLyricString[i4].substring(i6, i7 < strArrSplitLyricString[i4].length() ? i7 : strArrSplitLyricString[i4].length());
                            arrayList.add(new LyricWord(strSubstring, i3, SpanUtil.measureText(paint, map, i3, strSubstring) + (wrapLineStrategy.mExtraWidth * 2), strSubstring.length()));
                            i5++;
                            wrapLineStrategy = this;
                            i6 = i7;
                        }
                    }
                    i4++;
                    wrapLineStrategy = this;
                }
            }
            i3++;
            wrapLineStrategy = this;
            strArr2 = strArr;
        }
        return (LyricWord[]) arrayList.toArray(new LyricWord[arrayList.size()]);
    }

    @Override // com.kugou.framework.lyric4.cell.breakline.BreakLineStrategy
    public LyricLineInfo[] getBreakLineResult(Map<Integer, Span> map, String[] strArr, int i2, Paint paint, float f2) {
        Span span;
        int i3 = (int) (i2 * f2);
        String[] strArr2 = strArr == null ? new String[]{""} : strArr;
        LyricWord[] lyricWordArrTransformStringToLyricWord = transformStringToLyricWord(map, strArr2, i3, paint);
        float lyricWordWidth = 0.0f;
        for (LyricWord lyricWord : lyricWordArrTransformStringToLyricWord) {
            lyricWordWidth += lyricWord.getLyricWordWidth();
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f3 = fontMetrics.bottom - fontMetrics.top;
        float f4 = i3;
        if (lyricWordWidth <= f4) {
            StringBuilder sb = new StringBuilder();
            for (LyricWord lyricWord2 : lyricWordArrTransformStringToLyricWord) {
                sb.append(lyricWord2.getLyricWord());
            }
            String string = sb.toString();
            LyricLineInfo lyricLineInfo = new LyricLineInfo();
            lyricLineInfo.setSpanMap(map);
            lyricLineInfo.setLyricWords(lyricWordArrTransformStringToLyricWord);
            lyricLineInfo.setLyricLine(string);
            lyricLineInfo.setLineHeight(SpanUtil.getHeight(f3, map));
            lyricLineInfo.setLineWidth(lyricWordWidth);
            lyricLineInfo.setExtraWidth(this.mExtraWidth);
            lyricLineInfo.setBaseLineOffset((-(fontMetrics.bottom + fontMetrics.top)) / 2.0f);
            return new LyricLineInfo[]{lyricLineInfo};
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        float lyricWordWidth2 = f4;
        for (int i4 = 0; i4 < lyricWordArrTransformStringToLyricWord.length; i4++) {
            if (lyricWordArrTransformStringToLyricWord[i4].getLyricWordWidth() > lyricWordWidth2) {
                arrayList2.add(Integer.valueOf(i4));
                lyricWordWidth2 = f4 - lyricWordArrTransformStringToLyricWord[i4].getLyricWordWidth();
            } else {
                lyricWordWidth2 -= lyricWordArrTransformStringToLyricWord[i4].getLyricWordWidth();
            }
        }
        if (!arrayList2.isEmpty() && ((Integer) arrayList2.get(arrayList2.size() - 1)).intValue() != lyricWordArrTransformStringToLyricWord.length) {
            arrayList2.add(Integer.valueOf(lyricWordArrTransformStringToLyricWord.length));
        }
        SpanUtil.getLsatIndex(map);
        int iIntValue = 0;
        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
            StringBuilder sb2 = new StringBuilder();
            HashMap map2 = new HashMap();
            float lyricWordWidth3 = 0.0f;
            for (int i6 = iIntValue; i6 < ((Integer) arrayList2.get(i5)).intValue(); i6++) {
                sb2.append(lyricWordArrTransformStringToLyricWord[i6].getLyricWord());
                lyricWordWidth3 += lyricWordArrTransformStringToLyricWord[i6].getLyricWordWidth();
                if (!Utils.isEmpty(map) && lyricWordArrTransformStringToLyricWord.length == strArr2.length && (span = map.get(Integer.valueOf(i6))) != null) {
                    map2.put(Integer.valueOf(i6 - iIntValue), span);
                }
            }
            if (!Utils.isEmpty(map)) {
                LyricDebug.e("yijunwu_ly", map2.toString());
            }
            LyricLineInfo lyricLineInfo2 = new LyricLineInfo();
            lyricLineInfo2.setSpanMap(map2);
            lyricLineInfo2.setLyricWords((LyricWord[]) Arrays.copyOfRange(lyricWordArrTransformStringToLyricWord, iIntValue, ((Integer) arrayList2.get(i5)).intValue()));
            lyricLineInfo2.setLyricLine(sb2.toString());
            lyricLineInfo2.setLineHeight(SpanUtil.getHeight(f3, map2));
            lyricLineInfo2.setLineWidth(lyricWordWidth3);
            lyricLineInfo2.setExtraWidth(this.mExtraWidth);
            lyricLineInfo2.setBaseLineOffset((-(fontMetrics.bottom + fontMetrics.top)) / 2.0f);
            arrayList.add(lyricLineInfo2);
            iIntValue = ((Integer) arrayList2.get(i5)).intValue();
        }
        return (LyricLineInfo[]) arrayList.toArray(new LyricLineInfo[arrayList.size()]);
    }

    public void setExtraWidth(int i2) {
        this.mExtraWidth = i2;
    }
}
