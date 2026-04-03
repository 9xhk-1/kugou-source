package com.kugou.framework.lyric4.utils;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric4.MultipleLineLyricView;
import com.kugou.framework.lyric4.cell.breakline.LyricLineInfo;
import com.kugou.framework.lyric4.cell.breakline.LyricWord;
import com.kugou.framework.lyric4.cell.breakline.WrapLineStrategy;
import com.kugou.framework.lyric4.span.Span;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class Utils {
    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() <= 0;
    }

    public static LyricData transformLyricDataToSingleLine(int i2, Paint paint, Map<Integer, Span> map, float f2, LyricData lyricData) {
        ArrayList arrayList;
        try {
            int i3 = 1;
            if (lyricData.getLyricType() == 1) {
                WrapLineStrategy wrapLineStrategy = new WrapLineStrategy();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                ArrayList arrayList7 = new ArrayList();
                ArrayList arrayList8 = new ArrayList();
                int i4 = 0;
                while (i4 < lyricData.getWords().length) {
                    String[] strArr = lyricData.getWords()[i4];
                    long j = lyricData.getRowBeginTime()[i4];
                    long j2 = lyricData.getRowDelayTime()[i4];
                    long[] jArr = lyricData.getWordBeginTime()[i4];
                    long[] jArr2 = lyricData.getWordDelayTime()[i4];
                    int i5 = i4;
                    LyricLineInfo[] breakLineResult = wrapLineStrategy.getBreakLineResult(map, strArr, i2, paint, f2);
                    if (breakLineResult != null) {
                        if (breakLineResult.length == i3) {
                            arrayList2.add(strArr);
                            arrayList3.add(Long.valueOf(j));
                            arrayList4.add(Long.valueOf(j2));
                            arrayList5.add(jArr);
                            arrayList6.add(jArr2);
                        } else {
                            String[] strArr2 = strArr;
                            long j3 = -1;
                            long j4 = -1;
                            int i6 = 0;
                            while (i6 < breakLineResult.length) {
                                LyricLineInfo lyricLineInfo = breakLineResult[i6];
                                WrapLineStrategy wrapLineStrategy2 = wrapLineStrategy;
                                String[] strArr3 = new String[lyricLineInfo.getLyricWords().length];
                                j3 = i6 == 0 ? j : j3 + j4;
                                j4 = 0;
                                LyricLineInfo[] lyricLineInfoArr = breakLineResult;
                                int i7 = i6;
                                ArrayList arrayList9 = arrayList6;
                                long j5 = 0;
                                int i8 = 0;
                                int index = -1;
                                while (i8 < lyricLineInfo.getLyricWords().length) {
                                    LyricWord lyricWord = lyricLineInfo.getLyricWords()[i8];
                                    strArr3[i8] = lyricWord.getLyricWord();
                                    String str = strArr2[lyricWord.getIndex()];
                                    long j6 = jArr[lyricWord.getIndex()];
                                    long j7 = jArr2[lyricWord.getIndex()];
                                    LyricLineInfo lyricLineInfo2 = lyricLineInfo;
                                    arrayList7.add(Long.valueOf(j5));
                                    String[] strArr4 = strArr2;
                                    if (lyricWord.getLyricWord().length() == str.length()) {
                                        j5 += j7;
                                        arrayList = arrayList5;
                                        index = -1;
                                    } else {
                                        if (index != lyricWord.getIndex()) {
                                            index = lyricWord.getIndex();
                                        }
                                        arrayList = arrayList5;
                                        float length = jArr2[index] * (lyricWord.getLyricWord().length() / str.length());
                                        long j8 = jArr[index];
                                        long j9 = (long) length;
                                        j5 += j9;
                                        j7 = j9;
                                    }
                                    arrayList8.add(Long.valueOf(j7));
                                    j4 += j7;
                                    i8++;
                                    arrayList5 = arrayList;
                                    lyricLineInfo = lyricLineInfo2;
                                    strArr2 = strArr4;
                                }
                                String[] strArr5 = strArr2;
                                ArrayList arrayList10 = arrayList5;
                                arrayList2.add(strArr3);
                                arrayList3.add(Long.valueOf(j3));
                                arrayList4.add(Long.valueOf(j4));
                                long[] jArr3 = new long[arrayList7.size()];
                                for (int i9 = 0; i9 < arrayList7.size(); i9++) {
                                    jArr3[i9] = ((Long) arrayList7.get(i9)).longValue();
                                }
                                long[] jArr4 = new long[arrayList8.size()];
                                for (int i10 = 0; i10 < arrayList8.size(); i10++) {
                                    jArr4[i10] = ((Long) arrayList8.get(i10)).longValue();
                                }
                                arrayList10.add(jArr3);
                                arrayList9.add(jArr4);
                                arrayList7.clear();
                                arrayList8.clear();
                                i6 = i7 + 1;
                                arrayList6 = arrayList9;
                                arrayList5 = arrayList10;
                                wrapLineStrategy = wrapLineStrategy2;
                                breakLineResult = lyricLineInfoArr;
                                strArr2 = strArr5;
                            }
                        }
                    }
                    i4 = i5 + 1;
                    arrayList6 = arrayList6;
                    arrayList5 = arrayList5;
                    wrapLineStrategy = wrapLineStrategy;
                    i3 = 1;
                }
                ArrayList arrayList11 = arrayList5;
                ArrayList arrayList12 = arrayList6;
                LyricData lyricData2 = new LyricData();
                lyricData2.setHeaders(lyricData.getHeaders());
                lyricData2.setLyricType(lyricData.getLyricType());
                String[][] strArr6 = new String[arrayList2.size()][];
                for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                    strArr6[i11] = (String[]) arrayList2.get(i11);
                }
                lyricData2.setWords(strArr6);
                long[] jArr5 = new long[arrayList3.size()];
                for (int i12 = 0; i12 < arrayList3.size(); i12++) {
                    jArr5[i12] = ((Long) arrayList3.get(i12)).longValue();
                }
                lyricData2.setRowBeginTime(jArr5);
                long[] jArr6 = new long[arrayList4.size()];
                for (int i13 = 0; i13 < arrayList4.size(); i13++) {
                    jArr6[i13] = ((Long) arrayList4.get(i13)).longValue();
                }
                lyricData2.setRowDelayTime(jArr6);
                long[][] jArr7 = new long[arrayList11.size()][];
                for (int i14 = 0; i14 < arrayList11.size(); i14++) {
                    jArr7[i14] = (long[]) arrayList11.get(i14);
                }
                lyricData2.setWordBeginTime(jArr7);
                long[][] jArr8 = new long[arrayList12.size()][];
                for (int i15 = 0; i15 < arrayList12.size(); i15++) {
                    jArr8[i15] = (long[]) arrayList12.get(i15);
                }
                lyricData2.setWordDelayTime(jArr8);
                return lyricData2;
            }
        } catch (Exception e2) {
            Log.e(MultipleLineLyricView.TAG, "transformLyricDataToSingleLine: " + e2.getMessage());
        }
        return lyricData;
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.size() == 0;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }
}
