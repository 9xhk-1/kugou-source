package com.kugou.framework.lyric2.render;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.NonNull;
import android.util.Log;
import com.kugou.framework.lyric.debug.LyricDebug;
import com.kugou.framework.lyric.loader.language.Language;
import com.kugou.framework.lyric2.FooterMessage;
import com.kugou.framework.lyric2.HeaderMessage;
import com.kugou.framework.lyric2.NewLyricView;
import com.kugou.framework.lyric2.render.cell.Cell;
import com.kugou.framework.lyric2.render.cell.CellData;
import com.kugou.framework.lyric2.render.cell.CellUtils;

/* JADX INFO: loaded from: classes2.dex */
public class CellRender {
    private static CellRender instance;
    private Language language;
    private float lineHeight;
    private NewLyricView lyricView;
    private Paint mPaint;
    private long mPlayingTime;
    private Paint mTextBoaderPaint;
    private boolean playingCenterCellHadDraw = false;
    private boolean hadDrawCell = false;
    private boolean isCenterCell = false;
    private long prePlayingTime = 0;
    private long centerCellPlayTime = 0;
    private float centerCellOffset = 0.0f;
    private int centerRowOffset = 0;
    private int centerIndex = 0;
    private int halfSurHeight = 0;
    private float centerBaseOffset = 0.0f;
    private float mLastY = -1.0f;
    private float mstartY = -1.0f;
    private Matrix matrix = new Matrix();

    private CellRender() {
    }

    public static void destroy() {
        if (instance != null) {
            instance = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x0323  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void drawCell(@android.support.annotation.NonNull com.kugou.framework.lyric2.render.cell.Cell r33, @android.support.annotation.NonNull android.graphics.Canvas r34, int r35, float r36, long r37, int r39) {
        /*
            Method dump skipped, instruction units count: 1167
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.lyric2.render.CellRender.drawCell(com.kugou.framework.lyric2.render.cell.Cell, android.graphics.Canvas, int, float, long, int):void");
    }

    private void drawDynamicCell(@NonNull Canvas canvas, @NonNull CellData cellData, int i2, float f2, long j, long j2, long j3, long j4) {
        float f3;
        float[] fArr;
        float f4;
        String str;
        float f5;
        long j5;
        int i3;
        float f6;
        float f7;
        String str2;
        long j6 = j4;
        int surWidth = this.lyricView.getSurWidth();
        float textSize = this.mPaint.getTextSize();
        if (!this.lyricView.isCurLyricLarge() || this.lyricView.isInTouch()) {
            f3 = cellData.cellTime.getRowsLength()[i2];
            fArr = cellData.cellTime.getWordsLength()[i2];
        } else {
            this.mPaint.setTextSize(1.1f * textSize);
            String[] strArr = cellData.getWords()[i2];
            int length = strArr.length;
            fArr = new float[length];
            int i4 = 0;
            f3 = 0.0f;
            while (i4 < length) {
                fArr[i4] = this.mPaint.measureText(strArr[i4]);
                f3 += fArr[i4];
                i4++;
                length = length;
            }
        }
        float[] fArr2 = fArr;
        String str3 = cellData.getRowString()[i2];
        float f8 = surWidth;
        LyricDebug.assertTrue(f8 >= f3);
        LyricDebug.assertTrue(cellData.getRowString().length > i2);
        long j7 = j2 - cellData.cellTime.getRowBeginTime()[i2];
        long[] jArr = cellData.cellTime.getRowWordBegin()[i2];
        long[] jArr2 = cellData.cellTime.getRowWordDelay()[i2];
        int length2 = jArr.length;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= length2) {
                f4 = f8;
                str = str3;
                f5 = textSize;
                j5 = j6;
                i3 = i6;
                f6 = 0.0f;
                break;
            }
            long j8 = jArr[i5];
            int i7 = i5;
            int i8 = length2;
            long[] jArr3 = jArr;
            f4 = f8;
            str = str3;
            f5 = textSize;
            j5 = j6;
            long nextWordBeginTime = getNextWordBeginTime(i2, cellData, i8, i7, j);
            if (j7 < j8 || j7 >= nextWordBeginTime) {
                if (i7 == i8 - 1) {
                    i6 = i8;
                }
                i5 = i7 + 1;
                j6 = j5;
                length2 = i8;
                jArr = jArr3;
                f8 = f4;
                str3 = str;
                textSize = f5;
            } else {
                i3 = i7;
                float f9 = fArr2[i3];
                float f10 = j7 - j8;
                if (f10 > jArr2[i3]) {
                    f10 = jArr2[i3];
                }
                f6 = f9 * (f10 / jArr2[i3]);
            }
        }
        if (i2 < 0 && i2 >= cellData.getWords().length) {
            LyricDebug.fail();
        }
        float f11 = 0.0f;
        for (int i9 = 0; i9 < i3; i9++) {
            f11 += fArr2[i9];
        }
        float f12 = (f4 - f3) / 2.0f;
        float f13 = (f11 + f6) / f3;
        if (f13 >= 1.0f) {
            f13 = 1.0f;
        }
        this.mPaint.setShader(new LinearGradient(f12, f2, f12 + f3, f2, new int[]{this.lyricView.getPlayedColor(j3, j5), this.lyricView.getNotPlayColor(j3, j5)}, new float[]{f13, f13}, Shader.TileMode.MIRROR));
        if (this.lyricView.isFadeMode()) {
            f7 = f2;
            setPaintColor(this.mPaint, f7);
        } else {
            f7 = f2;
            this.mPaint.setAlpha(255);
        }
        if (this.lyricView.isTouchFadeMode() && this.lyricView.isInTouch() && !this.isCenterCell) {
            this.mPaint.setAlpha(80);
        }
        float f14 = f7;
        float f15 = f5;
        this.lyricView.onRowDraw(canvas, j3, j4, i2, f12, f2, true);
        if (this.lyricView.isTextBorder()) {
            str2 = str;
            canvas.drawText(str2, f12 - 1.0f, 1.0f + f14, getTextBorderPaint());
        } else {
            str2 = str;
        }
        canvas.drawText(str2, f12, f14, this.mPaint);
        this.mPaint.setShader(null);
        if (this.lyricView.isCurLyricLarge()) {
            this.mPaint.setTextSize(f15);
        }
    }

    private void drawLongClickArea(@NonNull Cell cell, @NonNull Canvas canvas, int i2, float f2) {
        NewLyricView newLyricView = this.lyricView;
        if (newLyricView.isLongClicked && isYPosInCell(newLyricView.mDownY, cell, f2, newLyricView.getCellMargin())) {
            Paint paint = new Paint();
            paint.setColor(this.lyricView.mShadowColor);
            paint.setStyle(Paint.Style.FILL);
            float lineHeight = (f2 - cell.getLineHeight()) + 10.0f;
            canvas.drawRect(0.0f, lineHeight, this.lyricView.getSurWidth(), cell.getCellHeight() + lineHeight + 10.0f, paint);
            if (this.lyricView.getLongClickCallBack() != null) {
                this.lyricView.getLongClickCallBack().longClickCallBack(i2);
            }
        }
    }

    private void drawStaticCell(Canvas canvas, CellData cellData, int i2, float f2, boolean z, long j, long j2) {
        int hoverColor;
        if (z && this.lyricView.isDismissPlayedLyric() && !this.lyricView.isInTouch()) {
            return;
        }
        LyricDebug.assertNotNull(cellData.cellTime.getRowsLength());
        int surWidth = this.lyricView.getSurWidth();
        String str = cellData.getRowString()[i2];
        float f3 = cellData.cellTime.getRowsLength()[i2];
        float f4 = surWidth;
        LyricDebug.assertTrue(f4 >= f3);
        int playedColor = this.lyricView.getPlayedColor(j, j2);
        int notPlayColor = this.lyricView.getNotPlayColor(j, j2);
        int playedStaticColor = this.lyricView.getPlayedStaticColor();
        if (cellData.language == Language.Translation) {
            playedColor = notPlayColor;
        }
        if (this.lyricView.canDrawHoverColor() && !z && this.isCenterCell) {
            hoverColor = this.lyricView.getHoverColor();
        } else {
            if (z) {
                notPlayColor = playedColor;
            }
            if (playedStaticColor != -1) {
                if (!z) {
                    playedStaticColor = notPlayColor;
                }
                hoverColor = playedStaticColor;
            } else {
                hoverColor = notPlayColor;
            }
        }
        this.mPaint.setColor(hoverColor);
        if (this.lyricView.isFadeMode()) {
            setPaintColor(this.mPaint, f2);
        } else {
            this.mPaint.setAlpha(255);
        }
        if (this.lyricView.isNormalFadeMode() && !this.isCenterCell) {
            this.mPaint.setAlpha(255);
            this.mPaint.setColor(this.lyricView.getNormalFadeModeColor());
        }
        if (this.lyricView.isTouchFadeMode() && this.lyricView.isInTouch() && !this.isCenterCell) {
            this.mPaint.setAlpha(80);
        }
        float f5 = (f4 - f3) / 2.0f;
        this.lyricView.onRowDraw(canvas, j, j2, i2, f5, f2, false);
        if (this.lyricView.isTextBorder()) {
            canvas.drawText(str, f5 - 1.0f, 1.0f + f2, getTextBorderPaint());
        }
        canvas.drawText(str, f5, f2, this.mPaint);
    }

    public static CellRender getInstance() {
        if (instance == null) {
            instance = new CellRender();
        }
        return instance;
    }

    private long getNextWordBeginTime(int i2, CellData cellData, int i3, int i4, long j) {
        return i4 == i3 + (-1) ? i2 == cellData.cellTime.getRowBeginTime().length + (-1) ? j : cellData.cellTime.getRowWordBegin()[i2][i4] + cellData.cellTime.getRowWordDelay()[i2][i4] : cellData.cellTime.getRowWordBegin()[i2][i4 + 1];
    }

    private boolean isYPosInCell(float f2, @NonNull Cell cell, float f3, float f4) {
        float f5 = f4 / 2.0f;
        float lineHeight = (cell.getLineHeight() / 4.0f) * 3.0f;
        float f6 = (f3 - lineHeight) - f5;
        if (f2 < f6) {
            return false;
        }
        float cellHeight = ((f3 + cell.getCellHeight()) + f5) - lineHeight;
        this.centerBaseOffset = f2 - f6;
        return f2 <= cellHeight;
    }

    private boolean needKrcRender(@NonNull CellData cellData) {
        if (cellData == null) {
            return false;
        }
        Language language = cellData.language;
        return language == Language.Origin || language == Language.Transliteration || language == Language.Chinese;
    }

    private void setPaintColor(@NonNull Paint paint, float f2) {
        float f3 = this.halfSurHeight;
        float fAbs = (Math.abs(f3 - f2) / this.lyricView.getSurHeight()) - f3;
        if (fAbs > 1.0f) {
            fAbs = 1.0f;
        }
        paint.setAlpha((int) (256.0f - (fAbs * 256.0f)));
    }

    private boolean syncCenterPlayingTime(@NonNull Cell cell, float f2, int i2) {
        if (!isYPosInCell(this.halfSurHeight, cell, f2, this.lyricView.getCellMargin())) {
            return false;
        }
        this.centerIndex = i2;
        this.centerCellPlayTime = CellUtils.getCellBeginTime(cell);
        return true;
    }

    public void drawAllCell(@NonNull NewLyricView newLyricView, @NonNull Canvas canvas, boolean z) {
        Cell cell;
        int i2;
        int i3;
        boolean z2;
        int i4;
        if (this.prePlayingTime != newLyricView.getmPlayingTime()) {
            this.prePlayingTime = newLyricView.getmPlayingTime();
        }
        this.mPlayingTime = newLyricView.getmPlayingTime();
        this.language = newLyricView.getLanguage();
        this.lyricView = newLyricView;
        int surHeight = newLyricView.getSurHeight();
        this.mPaint = newLyricView.getmPaint();
        float cellMargin = newLyricView.getCellMargin();
        int rowCount = newLyricView.getRowCount();
        int scrollRowOffset = newLyricView.getScrollRowOffset();
        this.hadDrawCell = false;
        this.halfSurHeight = surHeight / 2;
        if (newLyricView.isShowDynamicLyricSecondRow()) {
            this.halfSurHeight = newLyricView.getLineHeightPlusCellMargin();
        }
        if (newLyricView.isShowDynamicLyricFirstRow()) {
            this.halfSurHeight = (int) (newLyricView.getLineHeight() + ((newLyricView.getLineHeight() + newLyricView.getCellMargin()) / 2.0f));
        }
        int i5 = this.halfSurHeight;
        this.playingCenterCellHadDraw = false;
        this.centerRowOffset = 0;
        this.mstartY = scrollRowOffset;
        int cellHeight = i5;
        int i6 = 0;
        boolean z3 = false;
        while (i6 < rowCount) {
            Cell cellByIndex = newLyricView.getCellByIndex(i6);
            int i7 = i6 + 1;
            Cell cellByIndex2 = newLyricView.getCellByIndex(i7);
            if (cellByIndex == null) {
                return;
            }
            long cellBeginTime = cellByIndex2 == null ? Long.MAX_VALUE : CellUtils.getCellBeginTime(cellByIndex2);
            int i8 = -cellByIndex.getCellHeight();
            int i9 = cellHeight + scrollRowOffset;
            if (!z3) {
                this.centerRowOffset = (int) (this.centerRowOffset - (cellByIndex.getCellHeight() + cellMargin));
            }
            if (!(i9 < i8 || i9 >= surHeight)) {
                float lineHeight = i9 + (cellByIndex.getLineHeight() / 4.0f);
                this.isCenterCell = syncCenterPlayingTime(cellByIndex, lineHeight, i6);
                long cellBeginTime2 = CellUtils.getCellBeginTime(cellByIndex);
                if (!newLyricView.isShowPartLyric) {
                    cell = cellByIndex;
                    i2 = i6;
                    i3 = cellHeight;
                    z2 = true;
                    i4 = i7;
                    drawCell(cell, canvas, i9, lineHeight, cellBeginTime, i6);
                } else if (cellBeginTime2 >= newLyricView.getCutStartTime()) {
                    i3 = cellHeight;
                    if (cellBeginTime2 + CellUtils.getCellRowDelayTime(cellByIndex) <= newLyricView.getCutEndTime()) {
                        z2 = true;
                        cell = cellByIndex;
                        i4 = i7;
                        i2 = i6;
                        drawCell(cellByIndex, canvas, i9, lineHeight, cellBeginTime, i6);
                    } else {
                        cell = cellByIndex;
                        i4 = i7;
                        i2 = i6;
                        z2 = true;
                    }
                } else {
                    cell = cellByIndex;
                    i2 = i6;
                    i3 = cellHeight;
                    z2 = true;
                    i4 = i7;
                }
                this.hadDrawCell = z2;
                if (this.isCenterCell) {
                    this.centerRowOffset = (int) (this.centerRowOffset + cell.getCellHeight() + cellMargin);
                    z3 = true;
                }
                if (newLyricView.isRowEndTimeUseBeginAddDelay()) {
                    long j = this.mPlayingTime;
                    if (cellBeginTime2 <= j && j < cellBeginTime2 + CellUtils.getCellRowDelayTime(cell)) {
                        this.playingCenterCellHadDraw = z2;
                    }
                }
            } else {
                if (this.hadDrawCell) {
                    return;
                }
                cell = cellByIndex;
                i2 = i6;
                i3 = cellHeight;
                i4 = i7;
            }
            i6 = i4;
            cellHeight = i2 == rowCount + (-1) ? i3 + cell.getCellHeight() : (int) (i3 + cell.getCellHeight() + cellMargin);
        }
    }

    public void drawCellLoc(Canvas canvas, float f2, @NonNull Cell cell, float f3, float f4) {
        float f5 = f4 / 2.0f;
        float lineHeight = (cell.getLineHeight() / 4.0f) * 3.0f;
        canvas.drawRect(0.0f, (f3 - lineHeight) - f5, this.lyricView.getSurWidth(), ((f3 + cell.getCellHeight()) + f5) - lineHeight, this.lyricView.getmPaint());
    }

    public void drawFooterMessage(Canvas canvas, FooterMessage footerMessage, RectF rectF) {
        if (this.mLastY == -1.0f || footerMessage == null) {
            return;
        }
        Log.d("zwkk", "mLastY:" + this.mLastY);
        float surWidth = (((float) this.lyricView.getSurWidth()) - footerMessage.getMessageTotalWidth()) / 2.0f;
        float marginTop = this.mLastY + ((float) footerMessage.getMarginTop()) + (footerMessage.getTextHeight() / 2.0f);
        Paint.FontMetrics fontMetrics = footerMessage.getPaint().getFontMetrics();
        float f2 = fontMetrics.bottom;
        float f3 = (((f2 - fontMetrics.top) / 2.0f) + marginTop) - f2;
        canvas.drawText(footerMessage.getText(), surWidth, f3, footerMessage.getPaint());
        if (footerMessage.getDetailBitmap() != null) {
            canvas.drawBitmap(footerMessage.getDetailBitmap(), footerMessage.getTextWidth() + surWidth + footerMessage.getDetailMarginLeft(), marginTop - (footerMessage.getDetailBitmap().getHeight() / 2), footerMessage.getPaint());
        }
        if (rectF != null) {
            rectF.left = surWidth;
            rectF.top = (this.mLastY + footerMessage.getMarginTop()) - footerMessage.getExtraClickTopAndBottomSize();
            rectF.right = surWidth + footerMessage.getMessageTotalWidth();
            rectF.bottom = f3 + footerMessage.getExtraClickTopAndBottomSize();
        }
    }

    public void drawHeaderMessage(Canvas canvas, HeaderMessage headerMessage, RectF rectF) {
        float f2 = this.mstartY;
        if (f2 == -1.0f || headerMessage == null || f2 <= headerMessage.getMarginBottom()) {
            return;
        }
        float surWidth = (this.lyricView.getSurWidth() - headerMessage.getMessageTotalWidth()) / 2.0f;
        float marginBottom = (this.mstartY - headerMessage.getMarginBottom()) + (headerMessage.getHeight() / 2.0f);
        Log.d("zwk_ceshi", "center:" + marginBottom + " mstartY:" + this.mstartY);
        Paint.FontMetrics fontMetrics = headerMessage.getPaint().getFontMetrics();
        float f3 = fontMetrics.bottom;
        float f4 = (((f3 - fontMetrics.top) / 2.0f) + marginBottom) - f3;
        canvas.drawText(HeaderMessage.LYRIC_AUTHOR_STR, surWidth, f4, headerMessage.getPaint());
        if (headerMessage.isMoreAuthor()) {
            canvas.drawText(headerMessage.getText(), headerMessage.getDefaultStrWidth() + surWidth, f4, headerMessage.getPaint());
        } else {
            float defaultStrWidth = headerMessage.getDefaultStrWidth() + surWidth + headerMessage.getMarginPoint() + (headerMessage.getDotsWidth() / 2);
            canvas.drawCircle(defaultStrWidth, marginBottom + (headerMessage.getDotsWidth() / 2), headerMessage.getDotsWidth(), headerMessage.getPaint());
            canvas.drawText(headerMessage.getText(), headerMessage.getMarginPoint() + defaultStrWidth + (headerMessage.getDotsWidth() / 2) + headerMessage.getDotsWidth(), f4, headerMessage.getPaint());
        }
        if (rectF != null) {
            rectF.left = surWidth;
            rectF.top = (this.mstartY - headerMessage.getMarginBottom()) - headerMessage.getExtraClickTopAndBottomSize();
            rectF.right = surWidth + headerMessage.getMessageTotalWidth();
            rectF.bottom = f4 + headerMessage.getExtraClickTopAndBottomSize();
        }
    }

    public float getCenterBaseOffset() {
        return this.centerBaseOffset;
    }

    public int getCenterCellOffset() {
        return (int) this.centerCellOffset;
    }

    public long getCenterCellPlayTime() {
        return this.centerCellPlayTime;
    }

    public int getCenterIndex() {
        return this.centerIndex;
    }

    public int getCenterRowOffset() {
        return this.centerRowOffset;
    }

    public int getHalfSurHeight() {
        return this.halfSurHeight;
    }

    public Paint getTextBorderPaint() {
        if (this.mTextBoaderPaint == null) {
            Paint paint = new Paint(1);
            this.mTextBoaderPaint = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.mTextBoaderPaint.setStrokeWidth(1.0f);
            this.mTextBoaderPaint.setFakeBoldText(true);
        }
        this.mTextBoaderPaint.setAlpha(this.mPaint.getAlpha());
        this.mTextBoaderPaint.setColor(this.lyricView.getTextBorderColor());
        this.mTextBoaderPaint.setTextSize(this.mPaint.getTextSize());
        return this.mTextBoaderPaint;
    }
}
