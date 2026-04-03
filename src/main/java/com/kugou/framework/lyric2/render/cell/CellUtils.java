package com.kugou.framework.lyric2.render.cell;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.debug.LyricDebug;
import com.kugou.framework.lyric.loader.language.Language;
import com.kugou.framework.lyric2.NewLyricView;

/* JADX INFO: loaded from: classes2.dex */
public class CellUtils {
    public static float getBottom(@NonNull Paint paint) {
        return paint.getFontMetrics().bottom;
    }

    public static long getCellBeginTime(Cell cell) {
        if (cell != null) {
            LyricDebug.assertTrue(cell.getCellList().size() > 0);
            CellTime cellTime = cell.getCellList().get(0).cellTime;
            if (cellTime != null && cellTime.getRowBeginTime() != null && cellTime.getRowBeginTime().length > 0) {
                return cell.getCellList().get(0).cellTime.getRowBeginTime()[0];
            }
        }
        LyricDebug.fail();
        return 0L;
    }

    @Nullable
    public static Cell getCellByIndex(@NonNull NewLyricView newLyricView, int i2, Language language) {
        LyricData lyricData = newLyricView.getLyricData();
        if (lyricData == null) {
            return null;
        }
        LyricDebug.assertTrue(i2 >= 0);
        LyricDebug.assertNotNull(lyricData);
        LyricDebug.assertNotNull(lyricData.getWords());
        Cell cellData = newLyricView.getCellData(i2);
        if (cellData != null || i2 >= lyricData.getWords().length) {
            return cellData;
        }
        String[] strArr = lyricData.getWords()[i2];
        long j = lyricData.getRowDelayTime()[i2];
        long j2 = lyricData.getRowBeginTime()[i2];
        Cell cell = new Cell(newLyricView, strArr, lyricData.getTranslateWords() != null ? lyricData.getTranslateWords()[i2] : null, lyricData.getTransliterationWords() != null ? lyricData.getTransliterationWords()[i2] : null, lyricData.getChineseWords() != null ? lyricData.getChineseWords()[i2] : null, j, lyricData.getWordBeginTime()[i2], lyricData.getWordDelayTime()[i2], language, j2);
        newLyricView.putCellData(i2, cell);
        return cell;
    }

    public static long getCellRowDelayTime(Cell cell) {
        if (cell != null) {
            return cell.getRowDelayTime();
        }
        return 0L;
    }

    public static float getDescent(@NonNull Paint paint) {
        return paint.getFontMetrics().descent;
    }

    public static float getLeading(@NonNull Paint paint) {
        return paint.getFontMetrics().leading;
    }

    public static String getRowString(String[][] strArr, int i2) {
        LyricDebug.assertNotNull(strArr);
        if (i2 >= 0 || i2 < strArr.length) {
            LyricDebug.assertNotNull(strArr[i2]);
            return getRowString(strArr, i2, strArr[i2].length);
        }
        LyricDebug.fail();
        return "";
    }

    public static float getStringWidth(String str, @NonNull Paint paint) {
        return paint.measureText(str);
    }

    public static float getTop(@NonNull Paint paint) {
        return paint.getFontMetrics().top;
    }

    public static float getWordHeight(@NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.bottom - fontMetrics.top;
    }

    public static float getWordsLength(CellData cellData, int i2, int i3) {
        LyricDebug.assertNotNull(cellData);
        float f2 = 0.0f;
        if (i2 < 0 && i2 >= cellData.getWords().length) {
            LyricDebug.fail();
            return 0.0f;
        }
        float[] fArr = cellData.cellTime.getWordsLength()[i2];
        for (int i4 = 0; i4 < i3; i4++) {
            f2 += fArr[i4];
        }
        return f2;
    }

    public static boolean isPlayingCellRow(@NonNull long[] jArr, long j, long j2, int i2, long j3, boolean z) {
        int length = jArr.length;
        return z ? j > jArr[i2] && (i2 == length - 1 || j < jArr[i2 + 1] || j < j3) : j > jArr[i2] && (i2 == length - 1 || j < jArr[i2 + 1] || j < j2);
    }

    public static boolean isPlayingRow(@NonNull long[] jArr, long j, long j2) {
        LyricDebug.assertNotNull(jArr);
        if (jArr == null) {
            return false;
        }
        int length = jArr.length;
        int i2 = 0;
        while (i2 < length) {
            long j3 = i2 == length + (-1) ? jArr[i2] + j2 : jArr[i2 + 1];
            LyricDebug.d("playingTime : " + j + " rowBegin[i]: " + jArr[i2] + "  endTime: " + j3);
            if (j >= jArr[i2] && j < j3) {
                return true;
            }
            i2++;
        }
        return false;
    }

    public static String[][] removeEndLength(String[][] strArr, int i2) {
        LyricDebug.assertNotNull(strArr);
        int length = strArr.length - i2;
        String[][] strArr2 = new String[length][];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        return strArr2;
    }

    public static long[][] removeEndLength(long[][] jArr, int i2) {
        LyricDebug.assertNotNull(jArr);
        int length = jArr.length - i2;
        long[][] jArr2 = new long[length][];
        System.arraycopy(jArr, 0, jArr2, 0, length);
        return jArr2;
    }

    public static String getRowString(String[][] strArr, int i2, int i3) {
        LyricDebug.assertNotNull(strArr);
        if (i2 < 0 && i2 >= strArr.length) {
            LyricDebug.fail();
            return "";
        }
        String[] strArr2 = strArr[i2];
        LyricDebug.assertNotNull(strArr2);
        if (i3 < 0 && i3 >= strArr2.length) {
            LyricDebug.fail();
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < i3; i4++) {
            sb.append(strArr2[i4]);
        }
        return sb.toString();
    }

    public static long[] removeEndLength(long[] jArr, int i2) {
        LyricDebug.assertNotNull(jArr);
        int length = jArr.length - i2;
        long[] jArr2 = new long[length];
        System.arraycopy(jArr, 0, jArr2, 0, length);
        return jArr2;
    }
}
