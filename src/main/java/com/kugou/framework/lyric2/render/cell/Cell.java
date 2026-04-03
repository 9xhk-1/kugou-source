package com.kugou.framework.lyric2.render.cell;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import com.kugou.framework.lyric.check.CellChecker;
import com.kugou.framework.lyric.debug.LyricDebug;
import com.kugou.framework.lyric.loader.language.Language;
import com.kugou.framework.lyric2.NewLyricView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Cell {
    private float baseLineToLineCenter;
    private List<CellData> cellDataList;
    private int cellHeight = 0;
    private Language language;
    private float lineHeight;
    private NewLyricView lyricView;
    private long rowDelayTime;

    public Cell(@NonNull NewLyricView newLyricView, @NonNull String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, @NonNull long j, @NonNull long[] jArr, @NonNull long[] jArr2, Language language, long j2) {
        ArrayList arrayList = new ArrayList(3);
        this.cellDataList = arrayList;
        this.lyricView = newLyricView;
        this.language = language;
        arrayList.clear();
        this.cellDataList.add(new CellData(Language.Origin, strArr, new CellTime(j2, jArr, jArr2)));
        StringBuilder sb = new StringBuilder();
        sb.append("translateWords: ");
        sb.append(strArr2 != null);
        LyricDebug.e(sb.toString());
        if (strArr2 != null) {
            this.cellDataList.add(new CellData(Language.Translation, strArr2, new CellTime(j2, jArr, jArr2)));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("transliterationWords: ");
        sb2.append(strArr2 != null);
        LyricDebug.e(sb2.toString());
        if (strArr3 != null) {
            this.cellDataList.add(new CellData(Language.Transliteration, strArr3, new CellTime(j2, jArr, jArr2)));
        }
        if (strArr3 != null) {
            this.cellDataList.add(new CellData(Language.Chinese, strArr4, new CellTime(j2, jArr, jArr2)));
        }
        this.rowDelayTime = j;
        measure();
    }

    private long[] delayAllWords(long[] jArr, long j, int i2) {
        LyricDebug.assertNotNull(jArr);
        int length = jArr.length;
        for (int i3 = i2; i2 < length && i3 < length; i3++) {
            jArr[i3] = jArr[i3] - j;
        }
        return jArr;
    }

    private long getArrayPrewData(@NonNull long[] jArr) {
        LyricDebug.assertNotNull(jArr);
        return jArr[jArr.length - 1];
    }

    private void measure() {
        Paint paint = this.lyricView.getmPaint();
        float cellRowMargin = this.lyricView.getCellRowMargin();
        float wordHeight = CellUtils.getWordHeight(paint);
        this.lineHeight = CellUtils.getLeading(paint) + wordHeight + cellRowMargin;
        this.baseLineToLineCenter = (wordHeight / 2.0f) - CellUtils.getDescent(paint);
        for (int i2 = 0; i2 < this.cellDataList.size(); i2++) {
            CellData cellData = this.cellDataList.get(i2);
            measureCellData(cellData, paint);
            setEachWordWidth(cellData);
        }
        LyricDebug.d("measure finish");
    }

    private void measureCellData(@NonNull CellData cellData, @NonNull Paint paint) {
        float f2;
        String str;
        long j;
        float f3;
        long[] jArr;
        long[] jArr2;
        Cell cell;
        String[] strArr;
        long[] jArr3;
        int i2;
        long[] jArr4;
        long arrayPrewData;
        int i3;
        int i4;
        long j2;
        long[] jArr5;
        Cell cell2 = this;
        Paint paint2 = paint;
        int surWidth = (cell2.lyricView.getSurWidth() - cell2.lyricView.getPaddingLeft()) - cell2.lyricView.getPaddingRight();
        LyricDebug.d("width: " + surWidth + "  paddingLeft: " + cell2.lyricView.getPaddingLeft() + " paddingRight: " + cell2.lyricView.getPaddingRight());
        int length = cellData.getWords()[0].length;
        String[] strArr2 = new String[length];
        System.arraycopy(cellData.getWords()[0], 0, strArr2, 0, length);
        long j3 = cellData.cellTime.getRowBeginTime()[0];
        CellChecker cellChecker = new CellChecker(strArr2, cellData.cellTime.getRowWordBegin()[0], cellData.cellTime.getRowWordDelay()[0]);
        cellChecker.checkAndResize();
        String[] rowWords = cellChecker.getRowWords();
        long[] rowWordDelay = cellChecker.getRowWordDelay();
        long[] rowWordBegin = cellChecker.getRowWordBegin();
        LyricDebug.d("wordsLength: " + rowWords.length + "  delayLength: " + rowWordDelay.length + "  beginLength: " + rowWordBegin.length);
        int length2 = rowWords.length;
        float[] fArr = new float[length2];
        float f4 = 0.0f;
        for (int i5 = 0; i5 < length2; i5++) {
            fArr[i5] = paint2.measureText(rowWords[i5]);
            f4 += fArr[i5];
        }
        float f5 = surWidth;
        if (f4 <= f5) {
            cellData.getWords()[0] = rowWords;
            cellData.cellTime.getRowWordBegin()[0] = rowWordBegin;
            cellData.cellTime.getRowWordDelay()[0] = rowWordDelay;
            return;
        }
        int iCeil = (int) Math.ceil(f4 / (cell2.lyricView.cutFactor * f5));
        float f6 = f4 / iCeil;
        String[][] strArr3 = new String[iCeil][];
        long[] jArr6 = new long[iCeil];
        long[][] jArr7 = new long[iCeil][];
        long[][] jArr8 = new long[iCeil][];
        StringBuilder sb = new StringBuilder();
        long j4 = j3;
        sb.append("need split to ");
        sb.append(iCeil);
        sb.append(" line. better line surWidth: ");
        sb.append(f6);
        LyricDebug.d(sb.toString());
        int length3 = rowWords.length;
        int i6 = iCeil;
        long j5 = j4;
        int i7 = 0;
        int i8 = 0;
        float fMeasureText = 0.0f;
        int i9 = 0;
        while (i7 < length3) {
            int i10 = length3;
            fMeasureText += paint2.measureText(rowWords[i7]);
            if (fMeasureText > f6) {
                if (fMeasureText > f5) {
                    String str2 = rowWords[i7];
                    f2 = f5;
                    LyricDebug.e("expWord: " + str2);
                    char[] charArray = str2.toCharArray();
                    float fMeasureText2 = fMeasureText - paint2.measureText(rowWords[i7]);
                    int length4 = charArray.length;
                    int i11 = 0;
                    int i12 = 0;
                    float fMeasureText3 = 0.0f;
                    while (true) {
                        if (i11 >= length4) {
                            jArr5 = rowWordDelay;
                            jArr2 = rowWordBegin;
                            jArr4 = jArr6;
                            f3 = f6;
                            cell = this;
                            break;
                        }
                        long j6 = j5;
                        if (charArray[i11] == ' ') {
                            i12 = i11;
                        }
                        fMeasureText3 += paint2.measureText(charArray, i11, 1);
                        if (fMeasureText2 + fMeasureText3 < f6 || i11 == length4 - 1) {
                            i11++;
                            paint2 = paint;
                            rowWordBegin = rowWordBegin;
                            j5 = j6;
                            f6 = f6;
                            jArr6 = jArr6;
                            rowWordDelay = rowWordDelay;
                        } else {
                            if (i12 != 0) {
                                i11 = i12;
                            }
                            long j7 = rowWordDelay[i7];
                            f3 = f6;
                            jArr4 = jArr6;
                            long j8 = (long) ((j7 / length4) * (i11 + 1));
                            long j9 = j7 - j8;
                            long[] jArr9 = rowWordBegin;
                            String str3 = new String(charArray, 0, i11);
                            String str4 = new String(charArray, i11, length4 - i11);
                            LyricDebug.d("tmpWord: " + str3 + "  tmpDelay: " + j8 + "  freeWord: " + str4 + "  freeDelayTime: " + j9);
                            int i13 = i7 - i8;
                            int i14 = i13 + 1;
                            strArr3[i9] = new String[i14];
                            jArr7[i9] = new long[i14];
                            jArr8[i9] = new long[i14];
                            if (i13 > 0) {
                                System.arraycopy(rowWords, i8, strArr3[i9], 0, i13);
                                System.arraycopy(rowWordDelay, i8, jArr8[i9], 0, i13);
                                jArr5 = rowWordDelay;
                                jArr2 = jArr9;
                                System.arraycopy(jArr2, i8, jArr7[i9], 0, i13);
                            } else {
                                jArr5 = rowWordDelay;
                                jArr2 = jArr9;
                            }
                            strArr3[i9][i13] = str3;
                            if (i13 == 0) {
                                jArr7[i9][i13] = 0;
                            } else {
                                int i15 = i13 - 1;
                                jArr7[i9][i13] = jArr7[i9][i15] + jArr8[i9][i15];
                            }
                            jArr4[i9] = j6;
                            jArr8[i9][i13] = j8;
                            cell = this;
                            long arrayPrewData2 = j6 + cell.getArrayPrewData(jArr7[i9]) + cell.getArrayPrewData(jArr8[i9]);
                            rowWords[i7] = str4;
                            jArr2[i7] = 0;
                            jArr5[i7] = j9;
                            cell.delayAllWords(jArr2, arrayPrewData2 - j4, i7 + 1);
                            i8 = i7;
                            j5 = arrayPrewData2;
                            j4 = j5;
                        }
                    }
                    i7--;
                    strArr = rowWords;
                    arrayPrewData = j5;
                    str = "copy length: ";
                    jArr = jArr5;
                } else {
                    f2 = f5;
                    long[] jArr10 = rowWordDelay;
                    long j10 = j5;
                    jArr2 = rowWordBegin;
                    jArr4 = jArr6;
                    f3 = f6;
                    cell = cell2;
                    int i16 = (i7 - i8) + 1;
                    StringBuilder sb2 = new StringBuilder();
                    str = "copy length: ";
                    sb2.append(str);
                    sb2.append(i16);
                    LyricDebug.d(sb2.toString());
                    strArr3[i9] = new String[i16];
                    jArr7[i9] = new long[i16];
                    jArr8[i9] = new long[i16];
                    System.arraycopy(rowWords, i8, strArr3[i9], 0, i16);
                    System.arraycopy(jArr2, i8, jArr7[i9], 0, i16);
                    jArr = jArr10;
                    System.arraycopy(jArr, i8, jArr8[i9], 0, i16);
                    jArr4[i9] = j10;
                    arrayPrewData = j10 + cell.getArrayPrewData(jArr7[i9]) + cell.getArrayPrewData(jArr8[i9]);
                    strArr = rowWords;
                    int i17 = i7 + 1;
                    cell.delayAllWords(jArr2, arrayPrewData - j4, i17);
                    i8 = i17;
                    j4 = arrayPrewData;
                }
                int i18 = i9 + 1;
                int i19 = i6;
                if (i18 == i19) {
                    int i20 = i19 + 1;
                    String[][] strArr4 = new String[i20][];
                    jArr3 = new long[i20];
                    i3 = i7;
                    long[][] jArr11 = new long[i20][];
                    i4 = i18;
                    long[][] jArr12 = new long[i20][];
                    j2 = arrayPrewData;
                    System.arraycopy(strArr3, 0, strArr4, 0, strArr3.length);
                    long[] jArr13 = jArr4;
                    System.arraycopy(jArr13, 0, jArr3, 0, jArr13.length);
                    System.arraycopy(jArr7, 0, jArr11, 0, jArr7.length);
                    System.arraycopy(jArr8, 0, jArr12, 0, jArr8.length);
                    jArr7 = jArr11;
                    jArr8 = jArr12;
                    strArr3 = strArr4;
                    i19 = i20;
                } else {
                    i3 = i7;
                    i4 = i18;
                    j2 = arrayPrewData;
                    jArr3 = jArr4;
                }
                i7 = i3;
                i9 = i4;
                j = j2;
                fMeasureText = 0.0f;
                i6 = i19;
            } else {
                f2 = f5;
                str = "copy length: ";
                j = j5;
                f3 = f6;
                jArr = rowWordDelay;
                jArr2 = rowWordBegin;
                long[] jArr14 = jArr6;
                cell = cell2;
                strArr = rowWords;
                jArr3 = jArr14;
            }
            if (i7 == i10 - 1 && (i2 = i10 - i8) > 0 && i2 > 0) {
                LyricDebug.d(str + i2 + " words length: " + strArr.length);
                jArr3[i9] = j;
                strArr3[i9] = new String[i2];
                jArr7[i9] = new long[i2];
                jArr8[i9] = new long[i2];
                System.arraycopy(strArr, i8, strArr3[i9], 0, i2);
                cell.printArrayState(strArr, i8, i2);
                System.arraycopy(jArr2, i8, jArr7[i9], 0, i2);
                System.arraycopy(jArr, i8, jArr8[i9], 0, i2);
            }
            i7++;
            paint2 = paint;
            rowWords = strArr;
            rowWordBegin = jArr2;
            rowWordDelay = jArr;
            cell2 = cell;
            jArr6 = jArr3;
            length3 = i10;
            f5 = f2;
            j5 = j;
            f6 = f3;
        }
        long[] jArr15 = jArr6;
        int i21 = 0;
        int length5 = strArr3.length;
        int i22 = 0;
        while (i22 < length5) {
            int i23 = i22 + 1;
            if (strArr3[i22] == null) {
                break;
            }
            i21++;
            i22 = i23;
        }
        int length6 = strArr3.length - i21;
        String[][] strArrRemoveEndLength = CellUtils.removeEndLength(strArr3, length6);
        long[] jArrRemoveEndLength = CellUtils.removeEndLength(jArr15, length6);
        long[][] jArrRemoveEndLength2 = CellUtils.removeEndLength(jArr7, length6);
        long[][] jArrRemoveEndLength3 = CellUtils.removeEndLength(jArr8, length6);
        cellData.setWords(strArrRemoveEndLength);
        cellData.cellTime.setRowBeginTime(jArrRemoveEndLength);
        cellData.cellTime.setRowWordBegin(jArrRemoveEndLength2);
        cellData.cellTime.setRowWordDelay(jArrRemoveEndLength3);
    }

    private void printArrayState(String[] strArr, int i2, int i3) {
    }

    private void setEachWordWidth(CellData cellData) {
        String[][] words = cellData.getWords();
        int length = words.length;
        float[] fArr = new float[length];
        float[][] fArr2 = new float[length][];
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = 0.0f;
            int length2 = words[i2].length;
            float[] fArr3 = new float[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                float fMeasureText = this.lyricView.getmPaint().measureText(words[i2][i3]);
                f2 += fMeasureText;
                fArr3[i3] = fMeasureText;
            }
            fArr[i2] = f2;
            fArr2[i2] = fArr3;
        }
        cellData.cellTime.setRowsLength(fArr);
        cellData.cellTime.setWordsLength(fArr2);
    }

    public float getBaseLineOffsetToCenter() {
        return this.baseLineToLineCenter;
    }

    public int getCellHeight() {
        if (this.cellHeight == 0) {
            Iterator<CellData> it = this.cellDataList.iterator();
            int length = 0;
            int length2 = 0;
            while (it.hasNext()) {
                Language language = it.next().language;
                if (language == Language.Origin) {
                    length = (int) (r4.getWords().length * getLineHeight());
                } else if (language == this.language) {
                    length2 = (int) (r4.getWords().length * getLineHeight());
                }
            }
            LyricDebug.assertFalse(length == 0);
            LyricDebug.d("Origin: " + length + "  tranHeight: " + length2);
            this.cellHeight = length2 + length;
        }
        return this.cellHeight;
    }

    public List<CellData> getCellList() {
        return this.cellDataList;
    }

    public float getLineHeight() {
        return this.lineHeight;
    }

    public long getRowDelayTime() {
        return this.rowDelayTime;
    }
}
