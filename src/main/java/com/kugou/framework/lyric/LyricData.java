package com.kugou.framework.lyric;

import android.os.Parcel;
import android.os.Parcelable;
import com.kugou.framework.lyric.loader.language.Language;
import com.kugou.framework.lyric4.span.Span;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class LyricData implements Parcelable {
    public static final Parcelable.Creator<LyricData> CREATOR = new Parcelable.Creator<LyricData>() { // from class: com.kugou.framework.lyric.LyricData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LyricData createFromParcel(Parcel parcel) {
            LyricData lyricData = new LyricData();
            lyricData.lyricType = parcel.readInt();
            lyricData.headers = parcel.readHashMap(HashMap.class.getClassLoader());
            lyricData.rowBeginTime = new long[parcel.readInt()];
            parcel.readLongArray(lyricData.rowBeginTime);
            lyricData.rowDelayTime = new long[parcel.readInt()];
            parcel.readLongArray(lyricData.rowDelayTime);
            int i2 = parcel.readInt();
            lyricData.words = new String[i2][];
            for (int i3 = 0; i3 < i2; i3++) {
                lyricData.words[i3] = new String[parcel.readInt()];
                parcel.readStringArray(lyricData.words[i3]);
            }
            int i4 = parcel.readInt();
            if (-1 != i4) {
                lyricData.srcWords = new String[i4][];
                for (int i5 = 0; i5 < i4; i5++) {
                    lyricData.srcWords[i5] = parcel.createStringArray();
                }
            }
            int i6 = parcel.readInt();
            if (-1 != i6) {
                lyricData.complexWords = new String[i6][];
                for (int i7 = 0; i7 < i6; i7++) {
                    lyricData.complexWords[i7] = parcel.createStringArray();
                }
            }
            int i8 = parcel.readInt();
            if (-1 != i8) {
                lyricData.translateWords = new String[i8][];
                for (int i9 = 0; i9 < i8; i9++) {
                    lyricData.translateWords[i9] = parcel.createStringArray();
                }
            }
            int i10 = parcel.readInt();
            if (-1 != i10) {
                lyricData.transliterationWords = new String[i10][];
                for (int i11 = 0; i11 < i10; i11++) {
                    lyricData.transliterationWords[i11] = parcel.createStringArray();
                }
            }
            int i12 = parcel.readInt();
            if (-1 != i12) {
                lyricData.chineseWords = new String[i12][];
                for (int i13 = 0; i13 < i12; i13++) {
                    lyricData.chineseWords[i13] = parcel.createStringArray();
                }
            }
            int i14 = parcel.readInt();
            lyricData.wordBeginTime = new long[i14][];
            for (int i15 = 0; i15 < i14; i15++) {
                lyricData.wordBeginTime[i15] = new long[parcel.readInt()];
                parcel.readLongArray(lyricData.wordBeginTime[i15]);
            }
            int i16 = parcel.readInt();
            lyricData.wordDelayTime = new long[i16][];
            for (int i17 = 0; i17 < i16; i17++) {
                lyricData.wordDelayTime[i17] = new long[parcel.readInt()];
                parcel.readLongArray(lyricData.wordDelayTime[i17]);
            }
            lyricData.moving = parcel.readInt() == 1;
            lyricData.rowIndex = parcel.readInt();
            lyricData.moveX = parcel.readFloat();
            lyricData.moveY = parcel.readFloat();
            lyricData.rowChanging = parcel.readInt() == 1;
            lyricData.rowTimeDelay = parcel.readLong();
            lyricData.firstInRowTime = parcel.readLong();
            lyricData.wordTimeDelay = parcel.readLong();
            lyricData.currentTime = parcel.readLong();
            lyricData.currentTextSize = parcel.readFloat();
            lyricData.rowChanged = parcel.readInt() == 1;
            return lyricData;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LyricData[] newArray(int i2) {
            return new LyricData[i2];
        }
    };
    private static final int MIN_DURATION_LENGTH = 1000;
    private String[][] chineseWords;
    private String[][] complexWords;
    private float currentTextSize;
    private long currentTime;
    private long firstInRowTime;
    private HashMap<String, String> headers;
    private int lyricType;
    private Map<Integer, Span>[] mSpanMaps;
    private float moveX;
    private float moveY;
    private boolean moving;
    private long[] rowBeginTime;
    private boolean rowChanged;
    private boolean rowChanging;
    private long[] rowDelayTime;
    private int rowIndex;
    private long rowTimeDelay;
    private String[][] srcWords;
    private String[][] translateWords;
    private String[][] transliterationWords;
    private long[][] wordBeginTime;
    private long[][] wordDelayTime;
    private int wordIndex = -1;
    private long wordTimeDelay;
    private String[][] words;

    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void cut(com.kugou.framework.lyric.LyricData r11, long r12, long r14) {
        /*
            long[] r0 = r11.rowBeginTime
            r1 = 0
            r2 = -1
            r3 = 0
            r4 = -1
            r5 = -1
        L7:
            int r6 = r0.length
            if (r3 >= r6) goto L38
            r6 = r0[r3]
            r8 = 1000(0x3e8, double:4.94E-321)
            int r10 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r10 <= 0) goto L1f
            if (r4 != r2) goto L1f
            r6 = r0[r3]
            long r6 = r6 - r12
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 >= 0) goto L1d
            long r12 = (long) r3
            goto L1f
        L1d:
            int r4 = r3 + (-1)
        L1f:
            r6 = r0[r3]
            int r10 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r10 <= 0) goto L35
            if (r5 != r2) goto L35
            if (r3 <= 0) goto L34
            int r5 = r3 + (-1)
            r6 = r0[r5]
            long r6 = r14 - r6
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 >= 0) goto L34
            goto L35
        L34:
            r5 = r3
        L35:
            int r3 = r3 + 1
            goto L7
        L38:
            if (r4 != r2) goto L3b
            goto L3c
        L3b:
            r1 = r4
        L3c:
            if (r5 != r2) goto L41
            int r12 = r0.length
            int r5 = r12 + (-1)
        L41:
            long[] r12 = r11.rowBeginTime
            long[] r12 = safeGetRange(r12, r1, r5)
            r11.rowBeginTime = r12
            long[] r12 = r11.rowDelayTime
            long[] r12 = safeGetRange(r12, r1, r5)
            r11.rowDelayTime = r12
            java.lang.String[][] r12 = r11.words
            java.lang.Object[] r12 = safeGetRange(r12, r1, r5)
            java.lang.String[][] r12 = (java.lang.String[][]) r12
            r11.words = r12
            java.lang.String[][] r12 = r11.srcWords
            java.lang.Object[] r12 = safeGetRange(r12, r1, r5)
            java.lang.String[][] r12 = (java.lang.String[][]) r12
            r11.srcWords = r12
            java.lang.String[][] r12 = r11.complexWords
            java.lang.Object[] r12 = safeGetRange(r12, r1, r5)
            java.lang.String[][] r12 = (java.lang.String[][]) r12
            r11.complexWords = r12
            long[][] r12 = r11.wordBeginTime
            java.lang.Object[] r12 = safeGetRange(r12, r1, r5)
            long[][] r12 = (long[][]) r12
            r11.wordBeginTime = r12
            long[][] r12 = r11.wordDelayTime
            java.lang.Object[] r12 = safeGetRange(r12, r1, r5)
            long[][] r12 = (long[][]) r12
            r11.wordDelayTime = r12
            java.lang.String[][] r12 = r11.translateWords
            java.lang.Object[] r12 = safeGetRange(r12, r1, r5)
            java.lang.String[][] r12 = (java.lang.String[][]) r12
            r11.translateWords = r12
            java.lang.String[][] r12 = r11.transliterationWords
            java.lang.Object[] r12 = safeGetRange(r12, r1, r5)
            java.lang.String[][] r12 = (java.lang.String[][]) r12
            r11.transliterationWords = r12
            java.lang.String[][] r12 = r11.chineseWords
            java.lang.Object[] r12 = safeGetRange(r12, r1, r5)
            java.lang.String[][] r12 = (java.lang.String[][]) r12
            r11.chineseWords = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.lyric.LyricData.cut(com.kugou.framework.lyric.LyricData, long, long):void");
    }

    public static LyricData cutLyricData(LyricData lyricData, long j, long j2) {
        LyricData lyricDataFrom = from(lyricData);
        cut(lyricDataFrom, j, j2);
        return lyricDataFrom;
    }

    public static LyricData from(LyricData lyricData) {
        LyricData lyricData2 = new LyricData();
        lyricData2.currentTextSize = lyricData.getCurrentTextSize();
        lyricData2.currentTime = lyricData.getCurrentTime();
        lyricData2.firstInRowTime = lyricData.getFirstInRowTime();
        lyricData2.headers = lyricData.getHeaders();
        lyricData2.lyricType = lyricData.getLyricType();
        lyricData2.moveX = lyricData.getMoveX();
        lyricData2.moveY = lyricData.getMoveY();
        lyricData2.moving = lyricData.isMoving();
        lyricData2.rowBeginTime = lyricData.getRowBeginTime();
        lyricData2.rowDelayTime = lyricData.getRowDelayTime();
        lyricData2.rowChanged = lyricData.isRowChanged();
        lyricData2.rowChanging = lyricData.isRowChanging();
        lyricData2.rowIndex = lyricData.getRowIndex();
        lyricData2.rowTimeDelay = lyricData.getRowTimeDelay();
        lyricData2.wordBeginTime = lyricData.getWordBeginTime();
        lyricData2.wordDelayTime = lyricData.getWordDelayTime();
        lyricData2.translateWords = lyricData.getTranslateWords();
        lyricData2.transliterationWords = lyricData.getTransliterationWords();
        lyricData2.chineseWords = lyricData.getChineseWords();
        lyricData2.wordIndex = lyricData.getWordIndex();
        lyricData2.words = lyricData.getWords();
        lyricData2.srcWords = lyricData.getSrcWords();
        lyricData2.complexWords = lyricData.getComplexWords();
        lyricData2.wordTimeDelay = lyricData.getWordTimeDelay();
        return lyricData2;
    }

    private static <T> T[] safeGetRange(T[] tArr, int i2, int i3) {
        if (tArr == null) {
            return tArr;
        }
        if (i2 < 0 || i2 >= tArr.length) {
            i2 = 0;
        }
        if (i3 < 0 || i3 > tArr.length) {
            i3 = tArr.length;
        }
        if (i2 > i3) {
            i2 = i3;
        }
        return (T[]) Arrays.copyOfRange(tArr, i2, i3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String[][] getChineseWords() {
        return this.chineseWords;
    }

    public String[][] getComplexWords() {
        return this.complexWords;
    }

    public String getCurrentLyrics() {
        int i2 = this.rowIndex;
        if (i2 < 0 || i2 >= this.words.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (true) {
            String[][] strArr = this.words;
            int i4 = this.rowIndex;
            if (i3 >= strArr[i4].length) {
                return sb.toString();
            }
            sb.append(strArr[i4][i3]);
            i3++;
        }
    }

    public float getCurrentTextSize() {
        return this.currentTextSize;
    }

    public long getCurrentTime() {
        return this.currentTime;
    }

    public long getFirstInRowTime() {
        return this.firstInRowTime;
    }

    public HashMap<String, String> getHeaders() {
        return this.headers;
    }

    public List<Language> getLanguageList() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(Language.Origin);
        if (this.translateWords != null) {
            arrayList.add(Language.Translation);
        }
        if (this.transliterationWords != null) {
            arrayList.add(Language.Transliteration);
        }
        if (this.chineseWords != null) {
            arrayList.add(Language.Chinese);
        }
        return arrayList;
    }

    public int getLyricType() {
        return this.lyricType;
    }

    public float getMoveX() {
        return this.moveX;
    }

    public float getMoveY() {
        return this.moveY;
    }

    public long[] getRowBeginTime() {
        return this.rowBeginTime;
    }

    public long[] getRowDelayTime() {
        return this.rowDelayTime;
    }

    public int getRowIndex() {
        return this.rowIndex;
    }

    public long getRowTimeDelay() {
        return this.rowTimeDelay;
    }

    public Map<Integer, Span>[] getSpanMaps() {
        return this.mSpanMaps;
    }

    public String[][] getSrcWords() {
        return this.srcWords;
    }

    public String[][] getTranslateWords() {
        return this.translateWords;
    }

    public String[][] getTransliterationWords() {
        return this.transliterationWords;
    }

    public long[][] getWordBeginTime() {
        return this.wordBeginTime;
    }

    public long[][] getWordDelayTime() {
        return this.wordDelayTime;
    }

    public int getWordIndex() {
        return this.wordIndex;
    }

    public long getWordTimeDelay() {
        return this.wordTimeDelay;
    }

    public String[][] getWords() {
        return this.words;
    }

    public boolean isMoving() {
        return this.moving;
    }

    public boolean isRowChanged() {
        return this.rowChanged;
    }

    public boolean isRowChanging() {
        return this.rowChanging;
    }

    public void setChineseWords(String[][] strArr) {
        this.chineseWords = strArr;
    }

    public void setComplexWords(String[][] strArr) {
        this.complexWords = strArr;
    }

    public void setCurrentTextSize(float f2) {
        this.currentTextSize = f2;
    }

    public void setCurrentTime(long j) {
        this.currentTime = j;
    }

    public void setFirstInRowTime(long j) {
        this.firstInRowTime = j;
    }

    public void setHeaders(HashMap<String, String> map) {
        this.headers = map;
    }

    public void setLyricType(int i2) {
        this.lyricType = i2;
    }

    public void setMoveX(float f2) {
        this.moveX = f2;
    }

    public void setMoveY(float f2) {
        this.moveY = f2;
    }

    public void setMoving(boolean z) {
        this.moving = z;
    }

    public void setRowBeginTime(long[] jArr) {
        this.rowBeginTime = jArr;
    }

    public void setRowChanged(boolean z) {
        this.rowChanged = z;
    }

    public void setRowChanging(boolean z) {
        this.rowChanging = z;
    }

    public void setRowDelayTime(long[] jArr) {
        this.rowDelayTime = jArr;
    }

    public void setRowIndex(int i2) {
        this.rowIndex = i2;
    }

    public void setRowTimeDelay(long j) {
        this.rowTimeDelay = j;
    }

    public void setSpanMaps(Map<Integer, Span>[] mapArr) {
        this.mSpanMaps = mapArr;
    }

    public void setSrcWords(String[][] strArr) {
        this.srcWords = strArr;
    }

    public void setTranslateWords(String[][] strArr) {
        this.translateWords = strArr;
    }

    public void setTransliterationWords(String[][] strArr) {
        this.transliterationWords = strArr;
    }

    public void setWordBeginTime(long[][] jArr) {
        this.wordBeginTime = jArr;
    }

    public void setWordDelayTime(long[][] jArr) {
        this.wordDelayTime = jArr;
    }

    public void setWordIndex(int i2) {
        this.wordIndex = i2;
    }

    public void setWordTimeDelay(long j) {
        this.wordTimeDelay = j;
    }

    public void setWords(String[][] strArr) {
        this.words = strArr;
    }

    public String toString() {
        return super.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.lyricType);
        parcel.writeMap(this.headers);
        parcel.writeInt(this.rowBeginTime.length);
        parcel.writeLongArray(this.rowBeginTime);
        parcel.writeInt(this.rowDelayTime.length);
        parcel.writeLongArray(this.rowDelayTime);
        int length = this.words.length;
        parcel.writeInt(length);
        for (int i3 = 0; i3 < length; i3++) {
            parcel.writeInt(this.words[i3].length);
            parcel.writeStringArray(this.words[i3]);
        }
        String[][] strArr = this.srcWords;
        if (strArr != null) {
            int length2 = strArr.length;
            parcel.writeInt(length2);
            for (int i4 = 0; i4 < length2; i4++) {
                parcel.writeStringArray(this.srcWords[i4]);
            }
        } else {
            parcel.writeInt(-1);
        }
        String[][] strArr2 = this.complexWords;
        if (strArr2 != null) {
            int length3 = strArr2.length;
            parcel.writeInt(length3);
            for (int i5 = 0; i5 < length3; i5++) {
                parcel.writeStringArray(this.complexWords[i5]);
            }
        } else {
            parcel.writeInt(-1);
        }
        String[][] strArr3 = this.translateWords;
        if (strArr3 != null) {
            int length4 = strArr3.length;
            parcel.writeInt(length4);
            for (int i6 = 0; i6 < length4; i6++) {
                parcel.writeStringArray(this.translateWords[i6]);
            }
        } else {
            parcel.writeInt(-1);
        }
        String[][] strArr4 = this.transliterationWords;
        if (strArr4 != null) {
            int length5 = strArr4.length;
            parcel.writeInt(length5);
            for (int i7 = 0; i7 < length5; i7++) {
                parcel.writeStringArray(this.transliterationWords[i7]);
            }
        } else {
            parcel.writeInt(-1);
        }
        String[][] strArr5 = this.chineseWords;
        if (strArr5 != null) {
            int length6 = strArr5.length;
            parcel.writeInt(length6);
            for (int i8 = 0; i8 < length6; i8++) {
                parcel.writeStringArray(this.chineseWords[i8]);
            }
        } else {
            parcel.writeInt(-1);
        }
        int length7 = this.wordBeginTime.length;
        parcel.writeInt(length7);
        for (int i9 = 0; i9 < length7; i9++) {
            parcel.writeInt(this.wordBeginTime[i9].length);
            parcel.writeLongArray(this.wordBeginTime[i9]);
        }
        int length8 = this.wordDelayTime.length;
        parcel.writeInt(length8);
        for (int i10 = 0; i10 < length8; i10++) {
            parcel.writeInt(this.wordDelayTime[i10].length);
            parcel.writeLongArray(this.wordDelayTime[i10]);
        }
        parcel.writeInt(this.moving ? 1 : 0);
        parcel.writeInt(this.rowIndex);
        parcel.writeFloat(this.moveX);
        parcel.writeFloat(this.moveY);
        parcel.writeInt(this.rowChanging ? 1 : 0);
        parcel.writeLong(this.rowTimeDelay);
        parcel.writeLong(this.firstInRowTime);
        parcel.writeLong(this.wordTimeDelay);
        parcel.writeLong(this.currentTime);
        parcel.writeFloat(this.currentTextSize);
        parcel.writeInt(this.rowChanged ? 1 : 0);
    }

    private static long[] safeGetRange(long[] jArr, int i2, int i3) {
        if (jArr == null) {
            return jArr;
        }
        if (i2 < 0 || i2 >= jArr.length) {
            i2 = 0;
        }
        if (i3 < 0 || i3 > jArr.length) {
            i3 = jArr.length;
        }
        if (i2 > i3) {
            i2 = i3;
        }
        return Arrays.copyOfRange(jArr, i2, i3);
    }
}
