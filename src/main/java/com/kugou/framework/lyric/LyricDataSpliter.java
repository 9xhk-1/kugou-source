package com.kugou.framework.lyric;

import android.graphics.Paint;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class LyricDataSpliter {
    private static String[][] checkBounds(int i2, String[][] strArr) {
        return i2 >= strArr.length + (-2) ? incrementStrArrys(strArr) : strArr;
    }

    private static long[] incrementLongArrys(long[] jArr) {
        int length = jArr.length;
        long[] jArr2 = new long[length + 100];
        System.arraycopy(jArr, 0, jArr2, 0, length);
        return jArr2;
    }

    private static long[][] incrementLongsArrys(long[][] jArr) {
        int length = jArr.length;
        long[][] jArr2 = new long[length + 100][];
        System.arraycopy(jArr, 0, jArr2, 0, length);
        return jArr2;
    }

    private static String[][] incrementStrArrys(String[][] strArr) {
        int length = strArr.length;
        String[][] strArr2 = new String[length + 100][];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        return strArr2;
    }

    public static LyricData splitData(LyricData lyricData, float f2, Paint paint) {
        long[][] jArr;
        String[][] strArr;
        int i2;
        HashMap<String, String> map;
        long[] jArr2;
        int i3;
        long[][] jArr3;
        HashMap<String, String> map2;
        long[] jArr4;
        long j;
        int i4;
        int i5;
        int i6;
        long j2;
        int i7;
        long j3;
        int i8;
        int i9;
        long j4;
        long j5;
        long j6;
        int i10;
        String str;
        int i11;
        Paint paint2 = paint;
        HashMap<String, String> headers = lyricData.getHeaders();
        long[] rowBeginTime = lyricData.getRowBeginTime();
        long[][] wordBeginTime = lyricData.getWordBeginTime();
        long[][] wordDelayTime = lyricData.getWordDelayTime();
        String[][] words = lyricData.getWords();
        long[] jArrCheckBounds = new long[200];
        long[][] jArrCheckBounds2 = new long[200][];
        long[][] jArrCheckBounds3 = new long[200][];
        String[][] strArrCheckBounds = new String[200][];
        int length = words.length;
        int i12 = 0;
        int i13 = 0;
        while (i12 < length) {
            int length2 = words[i12].length;
            if (length2 == 0) {
                jArrCheckBounds[i13] = rowBeginTime[i12];
                strArrCheckBounds[i13] = words[i12];
                jArrCheckBounds2[i13] = wordBeginTime[i12];
                jArrCheckBounds3[i13] = wordDelayTime[i12];
                strArrCheckBounds = checkBounds(i13, strArrCheckBounds);
                jArrCheckBounds = checkBounds(i13, jArrCheckBounds);
                jArrCheckBounds2 = checkBounds(i13, jArrCheckBounds2);
                jArrCheckBounds3 = checkBounds(i13, jArrCheckBounds3);
            } else {
                String[] strArr2 = words[i12];
                long[] jArr5 = wordBeginTime[i12];
                long[] jArr6 = wordDelayTime[i12];
                float fMeasureText = 0.0f;
                for (int i14 = 0; i14 < length2; i14++) {
                    fMeasureText += paint2.measureText(strArr2[i14]);
                }
                if (fMeasureText < f2) {
                    jArrCheckBounds[i13] = rowBeginTime[i12];
                    strArrCheckBounds[i13] = words[i12];
                    jArrCheckBounds2[i13] = wordBeginTime[i12];
                    jArrCheckBounds3[i13] = wordDelayTime[i12];
                    strArrCheckBounds = checkBounds(i13, strArrCheckBounds);
                    jArrCheckBounds = checkBounds(i13, jArrCheckBounds);
                    jArrCheckBounds2 = checkBounds(i13, jArrCheckBounds2);
                    jArrCheckBounds3 = checkBounds(i13, jArrCheckBounds3);
                } else {
                    long[][] jArr7 = wordBeginTime;
                    jArr = wordDelayTime;
                    Double.isNaN(fMeasureText / f2);
                    float fCeil = fMeasureText / ((int) Math.ceil(r3 + 0.2d));
                    long j7 = rowBeginTime[i12];
                    String str2 = "";
                    strArr = words;
                    i2 = length;
                    String str3 = "";
                    long j8 = 0;
                    long j9 = 0;
                    long j10 = 0;
                    long j11 = 0;
                    int i15 = 0;
                    int i16 = 0;
                    int i17 = 0;
                    while (i16 < length2) {
                        String str4 = str2;
                        String str5 = strArr2[i16];
                        float fMeasureText2 = paint2.measureText(str5);
                        i15 = (int) (i15 + fMeasureText2);
                        long[][] jArr8 = jArr7;
                        float f3 = i15;
                        if (f3 > fCeil) {
                            if (f3 > f2) {
                                float f4 = f3 - fMeasureText2;
                                char[] charArray = str5.toCharArray();
                                HashMap<String, String> map3 = headers;
                                jArr4 = rowBeginTime;
                                long j12 = jArr6[i16];
                                float f5 = f4;
                                int length3 = charArray.length;
                                map2 = map3;
                                i4 = i12;
                                i5 = length2;
                                long j13 = 0;
                                long j14 = j11;
                                int i18 = 0;
                                int i19 = 0;
                                float f6 = 0.0f;
                                String str6 = str3;
                                long j15 = j10;
                                long j16 = j9;
                                int i20 = i17;
                                int i21 = 0;
                                while (i18 < length3) {
                                    int i22 = length3;
                                    int i23 = charArray[i18] == ' ' ? i18 : i21;
                                    int i24 = (i18 - i19) + 1;
                                    float fMeasureText3 = paint2.measureText(charArray, i19, i24);
                                    if (f5 + fMeasureText3 < f2) {
                                        j4 = j12;
                                        j5 = j7;
                                    } else {
                                        j4 = j12;
                                        float length4 = j12 / charArray.length;
                                        int i25 = i18 + 1;
                                        long j17 = (long) (length4 * i25);
                                        jArrCheckBounds[i13] = (j7 + j16) - j15;
                                        int i26 = !TextUtils.isEmpty(str6) ? 1 : 0;
                                        int i27 = i25;
                                        int i28 = (i16 - i20) + 1 + i26;
                                        j5 = j7;
                                        strArrCheckBounds[i13] = new String[i28];
                                        int i29 = i28 + 1;
                                        jArrCheckBounds2[i13] = new long[i29];
                                        jArrCheckBounds3[i13] = new long[i29];
                                        if (i26 != 0) {
                                            strArrCheckBounds[i13][0] = str6;
                                            jArrCheckBounds2[i13][1] = j14;
                                            jArrCheckBounds3[i13][0] = j15;
                                            j14 = 0;
                                            j6 = j15;
                                            str6 = str4;
                                            i10 = 1;
                                            j15 = 0;
                                        } else {
                                            j6 = 0;
                                            i10 = 0;
                                        }
                                        if (i23 == i19) {
                                            i11 = i10;
                                            str = new String(charArray, i19, i24);
                                            i23 = i27;
                                        } else {
                                            i11 = i10;
                                            str = new String(charArray, i19, i23 - i19);
                                            i27 = i23;
                                        }
                                        long j18 = jArr5[i20];
                                        int i30 = i20;
                                        int i31 = i11;
                                        long j19 = 0;
                                        while (i30 < i16) {
                                            strArrCheckBounds[i13][i31] = strArr2[i30];
                                            int i32 = i31 + 1;
                                            int i33 = i30 + 1;
                                            jArrCheckBounds2[i13][i32] = (jArr5[i33] - j18) + j6;
                                            jArrCheckBounds3[i13][i31] = jArr6[i30];
                                            i31 = i32;
                                            i30 = i33;
                                            j19 = jArrCheckBounds2[i13][i32];
                                        }
                                        strArrCheckBounds[i13][i31] = str;
                                        jArrCheckBounds2[i13][i31 + 1] = j19 + j17;
                                        jArrCheckBounds3[i13][i31] = j17;
                                        String[][] strArrCheckBounds2 = checkBounds(i13, strArrCheckBounds);
                                        long[] jArrCheckBounds4 = checkBounds(i13, jArrCheckBounds);
                                        long[][] jArrCheckBounds5 = checkBounds(i13, jArrCheckBounds2);
                                        long[][] jArrCheckBounds6 = checkBounds(i13, jArrCheckBounds3);
                                        i13++;
                                        j13 = j17;
                                        j16 = j8 + j17;
                                        jArrCheckBounds3 = jArrCheckBounds6;
                                        i20 = i16;
                                        i19 = i23;
                                        i23 = i27;
                                        f5 = 0.0f;
                                        jArrCheckBounds2 = jArrCheckBounds5;
                                        jArrCheckBounds = jArrCheckBounds4;
                                        strArrCheckBounds = strArrCheckBounds2;
                                    }
                                    i18++;
                                    paint2 = paint;
                                    f6 = fMeasureText3;
                                    j12 = j4;
                                    j7 = j5;
                                    i21 = i23;
                                    length3 = i22;
                                }
                                j = j7;
                                String str7 = new String(charArray, i19, charArray.length - i19);
                                i9 = (int) f6;
                                j8 += jArr6[i16];
                                str3 = str7;
                                j11 = j12 - j13;
                                j9 = j16;
                                j10 = j11;
                            } else {
                                map2 = headers;
                                jArr4 = rowBeginTime;
                                j = j7;
                                i4 = i12;
                                i5 = length2;
                                j8 += jArr6[i16];
                                jArrCheckBounds[i13] = (j + j9) - j10;
                                int i34 = !TextUtils.isEmpty(str3) ? 1 : 0;
                                int i35 = (i16 - i17) + 1 + i34;
                                strArrCheckBounds[i13] = new String[i35];
                                int i36 = i35 + 1;
                                jArrCheckBounds2[i13] = new long[i36];
                                jArrCheckBounds3[i13] = new long[i36];
                                if (i34 != 0) {
                                    strArrCheckBounds[i13][0] = str3;
                                    jArrCheckBounds2[i13][1] = j11;
                                    jArrCheckBounds3[i13][0] = j10;
                                    j3 = 0;
                                    j11 = 0;
                                    str3 = str4;
                                    i8 = 1;
                                } else {
                                    j3 = j10;
                                    i8 = 0;
                                    j10 = 0;
                                }
                                long j20 = jArr5[i17];
                                while (true) {
                                    int i37 = i17;
                                    if (i37 >= i16 + 1) {
                                        break;
                                    }
                                    strArrCheckBounds[i13][i8] = strArr2[i37];
                                    int i38 = i8 + 1;
                                    i17 = i37 + 1;
                                    jArrCheckBounds2[i13][i38] = (jArr5[i17] - j20) + j10;
                                    jArrCheckBounds3[i13][i8] = jArr6[i37];
                                    i8 = i38;
                                }
                                String[][] strArrCheckBounds3 = checkBounds(i13, strArrCheckBounds);
                                long[] jArrCheckBounds7 = checkBounds(i13, jArrCheckBounds);
                                long[][] jArrCheckBounds8 = checkBounds(i13, jArrCheckBounds2);
                                long[][] jArrCheckBounds9 = checkBounds(i13, jArrCheckBounds3);
                                i13++;
                                strArrCheckBounds = strArrCheckBounds3;
                                j10 = j3;
                                jArrCheckBounds = jArrCheckBounds7;
                                jArrCheckBounds2 = jArrCheckBounds8;
                                jArrCheckBounds3 = jArrCheckBounds9;
                                j9 = j8;
                                i9 = 0;
                            }
                            i17 = i16 + 1;
                            i15 = i9;
                        } else {
                            map2 = headers;
                            jArr4 = rowBeginTime;
                            j = j7;
                            i4 = i12;
                            i5 = length2;
                            j8 += jArr6[i16];
                        }
                        if (i16 == i5 - 1) {
                            jArrCheckBounds[i13] = (j + j9) - j10;
                            int i39 = !TextUtils.isEmpty(str3) ? 1 : 0;
                            int i40 = (i5 - i17) + i39;
                            strArrCheckBounds[i13] = new String[i40];
                            int i41 = i40 + 1;
                            jArrCheckBounds2[i13] = new long[i41];
                            jArrCheckBounds3[i13] = new long[i41];
                            if (i39 != 0) {
                                strArrCheckBounds[i13][0] = str3;
                                jArrCheckBounds2[i13][1] = j11;
                                jArrCheckBounds3[i13][0] = j10;
                                j11 = 0;
                                j2 = j10;
                                str3 = str4;
                                i7 = 1;
                                j10 = 0;
                            } else {
                                j2 = 0;
                                i7 = 0;
                            }
                            long j21 = jArr5[i17];
                            int i42 = i17;
                            i6 = i5;
                            while (i42 < i6) {
                                strArrCheckBounds[i13][i7] = strArr2[i42];
                                int i43 = i7 + 1;
                                int i44 = i42 + 1;
                                jArrCheckBounds2[i13][i43] = (jArr5[i44] - j21) + j2;
                                jArrCheckBounds3[i13][i7] = jArr6[i42];
                                i7 = i43;
                                i42 = i44;
                            }
                            String[][] strArrCheckBounds4 = checkBounds(i13, strArrCheckBounds);
                            long[] jArrCheckBounds10 = checkBounds(i13, jArrCheckBounds);
                            long[][] jArrCheckBounds11 = checkBounds(i13, jArrCheckBounds2);
                            long[][] jArrCheckBounds12 = checkBounds(i13, jArrCheckBounds3);
                            i13++;
                            strArrCheckBounds = strArrCheckBounds4;
                            jArrCheckBounds = jArrCheckBounds10;
                            jArrCheckBounds2 = jArrCheckBounds11;
                            jArrCheckBounds3 = jArrCheckBounds12;
                        } else {
                            i6 = i5;
                        }
                        i16++;
                        paint2 = paint;
                        length2 = i6;
                        str2 = str4;
                        rowBeginTime = jArr4;
                        jArr7 = jArr8;
                        headers = map2;
                        i12 = i4;
                        j7 = j;
                    }
                    map = headers;
                    jArr2 = rowBeginTime;
                    i3 = i12;
                    jArr3 = jArr7;
                    i12 = i3 + 1;
                    paint2 = paint;
                    wordDelayTime = jArr;
                    words = strArr;
                    length = i2;
                    rowBeginTime = jArr2;
                    wordBeginTime = jArr3;
                    headers = map;
                }
            }
            i13++;
            map = headers;
            jArr2 = rowBeginTime;
            jArr3 = wordBeginTime;
            jArr = wordDelayTime;
            strArr = words;
            i2 = length;
            i3 = i12;
            i12 = i3 + 1;
            paint2 = paint;
            wordDelayTime = jArr;
            words = strArr;
            length = i2;
            rowBeginTime = jArr2;
            wordBeginTime = jArr3;
            headers = map;
        }
        HashMap<String, String> map4 = headers;
        long[] jArr9 = rowBeginTime;
        jArrCheckBounds[i13] = jArr9[jArr9.length - 1];
        int i45 = i13 + 1;
        long[] jArr10 = new long[i45];
        long[][] jArr11 = new long[i13][];
        long[][] jArr12 = new long[i13][];
        String[][] strArr3 = new String[i13][];
        System.arraycopy(jArrCheckBounds, 0, jArr10, 0, i45);
        System.arraycopy(jArrCheckBounds2, 0, jArr11, 0, i13);
        System.arraycopy(jArrCheckBounds3, 0, jArr12, 0, i13);
        System.arraycopy(strArrCheckBounds, 0, strArr3, 0, i13);
        LyricData lyricData2 = new LyricData();
        lyricData2.setLyricType(lyricData.getLyricType());
        lyricData2.setHeaders(map4);
        lyricData2.setRowBeginTime(jArr10);
        lyricData2.setWordBeginTime(jArr11);
        lyricData2.setWordDelayTime(jArr12);
        lyricData2.setWords(strArr3);
        return lyricData2;
    }

    private static long[] checkBounds(int i2, long[] jArr) {
        return i2 >= jArr.length + (-2) ? incrementLongArrys(jArr) : jArr;
    }

    private static long[][] checkBounds(int i2, long[][] jArr) {
        return i2 >= jArr.length + (-2) ? incrementLongsArrys(jArr) : jArr;
    }
}
