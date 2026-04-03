package com.kugou.framework.lyric2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.internal.view.SupportMenu;
import com.kugou.framework.lyric.ILyricView;
import com.kugou.framework.lyric.LyricConstent;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.debug.LyricDebug;
import com.kugou.framework.lyric.loader.language.Language;
import com.kugou.framework.lyric2.render.CellRender;
import com.kugou.framework.lyric2.render.cell.Cell;
import com.kugou.framework.lyric2.render.cell.CellUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NewLyricView extends EventLyricView implements ILyricView {
    private final Object cellDataMapLock;
    private SparseArray<Cell> cellDataSparseArray;
    private int centerOffset;
    private int cutEndTime;
    private int cutStartTime;
    private int dftMsgColor;
    private RectF footerAreaRect;
    private FooterMessage footerMessage;
    private boolean fullScreen;
    private int headImgToTextPadding;
    private RectF headerAreaRect;
    private HeaderMessage headerMessage;
    private int hoverColor;
    private boolean isDismissPlayedLyric;
    private boolean isDrawingAllRows;
    private boolean isFadeMode;
    private boolean isFooterMessageVisible;
    private boolean isHeaderMessageVisible;
    private boolean isNeedKrcRender;
    private boolean isNeedLargeCurLyric;
    private boolean isNormalFadeMode;
    private boolean isOpenHover;
    private boolean isPlayLyricBgHighlight;
    private boolean isPlayingCellFontBig;
    private boolean isSettingLanguage;
    private boolean isShowDynamicLyricFirstRow;
    private boolean isShowDynamicLyricSecondRow;
    public boolean isShowPartLyric;
    private boolean isTextBorder;
    private boolean isTouchFadeMode;
    private Language language;
    public LyricData lyricData;
    private OnLyricDataLoadListener lyricDataLoadListener;
    private final Object lyricLock;
    private int lyricType;
    private int mLocationHeight;
    public int mShadowColor;
    private int maxRows;
    private boolean playedLyricShowPlayedColor;
    private int playedOffset;
    private int rowCount;
    private boolean rowEndTimeUseBeginAddDelay;
    private int scrollTimeNoticeDelay;
    private int textBorderColor;

    public interface OnLyricDataLoadListener {
        void onLyricDataLoaded(LyricData lyricData);
    }

    public NewLyricView(Context context) {
        this(context, null);
    }

    private void resetState(LyricData lyricData) {
        synchronized (this.allHeightLock) {
            clearCellData();
            int length = 0;
            this.isDrawingAllRows = false;
            this.allRowHeight = 0;
            this.lineHeightPlusCellMargin = 0;
            if (lyricData != null) {
                long[] rowBeginTime = lyricData.getRowBeginTime();
                if (rowBeginTime != null) {
                    length = rowBeginTime.length - 1;
                }
                this.rowCount = length;
            }
            this.isSettingLanguage = true;
        }
    }

    @Override // com.kugou.framework.lyric2.BaseLyricView
    public boolean calcuLyric() {
        if (this.lyricData == null) {
            return false;
        }
        synchronized (this.allHeightLock) {
            this.playedOffset = 0;
            this.centerOffset = 0;
            this.allRowHeight = 0;
            int i2 = 0;
            boolean z = false;
            boolean z2 = false;
            while (i2 < this.rowCount) {
                Cell cellByIndex = getCellByIndex(i2);
                int i3 = i2 + 1;
                Cell cellByIndex2 = getCellByIndex(i3);
                if (cellByIndex == null) {
                    break;
                }
                long cellBeginTime = cellByIndex2 == null ? Long.MAX_VALUE : CellUtils.getCellBeginTime(cellByIndex2);
                if (!z || !z2) {
                    if ((i2 == 0 && this.mPlayingTime < CellUtils.getCellBeginTime(cellByIndex)) || (this.mPlayingTime >= CellUtils.getCellBeginTime(cellByIndex) && this.mPlayingTime < cellBeginTime)) {
                        z = true;
                    }
                    if (i2 >= CellRender.getInstance().getCenterIndex()) {
                        z2 = true;
                    }
                    if (!z2) {
                        this.centerOffset = (int) (this.centerOffset - (cellByIndex.getCellHeight() + getCellMargin()));
                    }
                    if (!z) {
                        this.playedOffset = (int) (this.playedOffset - (cellByIndex.getCellHeight() + getCellMargin()));
                    }
                }
                if (i2 == this.rowCount - 1) {
                    this.allRowHeight = (int) (this.allRowHeight + (cellByIndex.getCellHeight() - cellByIndex.getLineHeight()));
                } else {
                    this.allRowHeight = (int) (this.allRowHeight + cellByIndex.getCellHeight() + getCellMargin());
                }
                i2 = i3;
            }
            if (!z) {
                return false;
            }
            if (this.isSettingLanguage) {
                scrollToWithDuration(this.playedOffset, 20);
                this.isSettingLanguage = false;
            }
            return true;
        }
    }

    public boolean canDrawHoverColor() {
        return this.isOpenHover && this.canShowHover && hadScrollMsg();
    }

    @Override // com.kugou.framework.lyric2.EventLyricView
    public boolean canSlide() {
        LyricDebug.d("canSlide: " + this.rowCount);
        return this.rowCount > 1 && this.lyricData != null;
    }

    public void clearCellData() {
        synchronized (this.cellDataMapLock) {
            this.cellDataSparseArray.clear();
        }
    }

    public void clearCutTime() {
        this.cutEndTime = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.cutStartTime = 0;
        this.isShowPartLyric = false;
    }

    public void cutPartLyric(long j, long j2) {
        int i2;
        int i3;
        LyricData lyricData = this.lyricData;
        if (lyricData == null || lyricData.getRowBeginTime() == null || this.lyricData.getRowBeginTime().length == 0) {
            return;
        }
        if (j == 0 && j2 == 2147483647L) {
            return;
        }
        long[] rowBeginTime = this.lyricData.getRowBeginTime();
        long[] rowDelayTime = this.lyricData.getRowDelayTime();
        int length = rowBeginTime.length;
        int i4 = 0;
        boolean z = false;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length) {
            long j3 = rowBeginTime[i4];
            long j4 = rowDelayTime[i4];
            long j5 = i4 < length + (-1) ? rowBeginTime[i4 + 1] : 0L;
            if (!z) {
                if (j == 0) {
                    z = true;
                    i5 = 0;
                }
                if (j == j3 && j < j3 + j4) {
                    i5 = i4;
                    z = true;
                }
            }
            if (!z2) {
                if (j2 == 2147483647L) {
                    i6 = length - 2;
                    z2 = true;
                }
                if (j2 > j3 && (j2 <= j3 + j4 || j2 <= j5)) {
                    i6 = i4;
                    z2 = true;
                }
            }
            if (z && z2) {
                break;
            } else {
                i4++;
            }
        }
        if (z && z2 && i5 <= i6) {
            boolean z3 = this.lyricData.getTranslateWords() != null;
            boolean z4 = this.lyricData.getTransliterationWords() != null;
            boolean z5 = this.lyricData.getChineseWords() != null;
            int i7 = (i6 - i5) + 1;
            int i8 = i7 + 1;
            long[] jArr = new long[i8];
            long[] jArr2 = new long[i7];
            String[][] strArr = new String[i7][];
            long[][] jArr3 = new long[i7][];
            long[][] jArr4 = new long[i7][];
            System.arraycopy(this.lyricData.getRowBeginTime(), i5, jArr, 0, i7);
            System.arraycopy(this.lyricData.getRowDelayTime(), i5, jArr2, 0, i7);
            System.arraycopy(this.lyricData.getWords(), i5, strArr, 0, i7);
            System.arraycopy(this.lyricData.getWordBeginTime(), i5, jArr3, 0, i7);
            System.arraycopy(this.lyricData.getWordDelayTime(), i5, jArr4, 0, i7);
            if (this.lyricData.getRowBeginTime() != null && i8 > i7 && this.lyricData.getRowBeginTime().length > (i3 = i6 + 1)) {
                jArr[i7] = this.lyricData.getRowBeginTime()[i3];
            }
            this.lyricData.setRowBeginTime(jArr);
            this.lyricData.setRowDelayTime(jArr2);
            this.lyricData.setWords(strArr);
            this.lyricData.setWordBeginTime(jArr3);
            this.lyricData.setWordDelayTime(jArr4);
            if (z3) {
                String[][] strArr2 = new String[i7][];
                i2 = 0;
                System.arraycopy(this.lyricData.getTranslateWords(), i5, strArr2, 0, i7);
                this.lyricData.setTranslateWords(strArr2);
            } else {
                i2 = 0;
            }
            if (z4) {
                String[][] strArr3 = new String[i7][];
                System.arraycopy(this.lyricData.getTransliterationWords(), i5, strArr3, i2, i7);
                this.lyricData.setTransliterationWords(strArr3);
            }
            if (z5) {
                String[][] strArr4 = new String[i7][];
                System.arraycopy(this.lyricData.getChineseWords(), i5, strArr4, i2, i7);
                this.lyricData.setChineseWords(strArr4);
            }
        }
        resetState(this.lyricData);
    }

    @Override // com.kugou.framework.lyric2.BaseLyricView
    public void drawLyric(Canvas canvas) {
        LyricData lyricData;
        HeaderMessage headerMessage;
        FooterMessage footerMessage;
        if (getSurWidth() == 0 || (lyricData = this.lyricData) == null) {
            showDefaultMsg(canvas);
            LyricDebug.e("lyricData is null");
            return;
        }
        if (!this.isDrawingAllRows) {
            this.isDrawingAllRows = true;
            LyricDebug.assertNotNull(lyricData);
        }
        CellRender cellRender = CellRender.getInstance();
        cellRender.drawAllCell(this, canvas, false);
        if (this.isFooterMessageVisible && (footerMessage = this.footerMessage) != null) {
            cellRender.drawFooterMessage(canvas, footerMessage, this.footerAreaRect);
        }
        if (this.isHeaderMessageVisible && (headerMessage = this.headerMessage) != null) {
            cellRender.drawHeaderMessage(canvas, headerMessage, this.headerAreaRect);
        }
        computeLyricScroll();
    }

    public List<Language> getCanUseType() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(Language.Origin);
        LyricData lyricData = this.lyricData;
        if (lyricData != null) {
            if (lyricData.getTranslateWords() != null) {
                arrayList.add(Language.Translation);
            }
            if (this.lyricData.getTransliterationWords() != null) {
                arrayList.add(Language.Transliteration);
            }
            if (this.lyricData.getChineseWords() != null) {
                arrayList.add(Language.Chinese);
            }
        }
        return arrayList;
    }

    @Nullable
    public Cell getCellByIndex(int i2) {
        return CellUtils.getCellByIndex(this, i2, this.language);
    }

    public Cell getCellData(int i2) {
        Cell cell;
        synchronized (this.cellDataMapLock) {
            cell = this.cellDataSparseArray.get(i2);
        }
        return cell;
    }

    public float getCellRowMargin() {
        return this.cellRowMargin;
    }

    @Override // com.kugou.framework.lyric2.EventLyricView
    public long getCenterCellPlayTime() {
        return CellRender.getInstance().getCenterCellPlayTime();
    }

    @Override // com.kugou.framework.lyric2.EventLyricView
    public int getCenterOffset() {
        return isEnableFling() ? this.centerOffset : CellRender.getInstance().getCenterRowOffset();
    }

    public long getCenterTime() {
        return CellRender.getInstance().getCenterCellPlayTime();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getContentWidth() {
        return 0.0f;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public String getCurrentLyrics() {
        return null;
    }

    public int getCutEndTime() {
        return this.cutEndTime;
    }

    public int getCutStartTime() {
        return this.cutStartTime;
    }

    public int getHeadImgToTextPadding() {
        return this.headImgToTextPadding;
    }

    public int getHoverColor() {
        return this.hoverColor;
    }

    public Language getLanguage() {
        return this.language;
    }

    public int getLocationHeight() {
        int i2 = this.mLocationHeight;
        if (i2 != -1) {
            return i2;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i3 = iArr[1];
        this.mLocationHeight = i3;
        return i3;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public LyricData getLyricData() {
        return this.lyricData;
    }

    public int getLyricType() {
        return this.lyricType;
    }

    public int getMaxRows() {
        return this.maxRows;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public Paint getPen() {
        return getmPaint();
    }

    @Override // com.kugou.framework.lyric2.EventLyricView
    public int getPlayedOffset() {
        return this.playedOffset;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getRowHeight() {
        return 0.0f;
    }

    @Override // com.kugou.framework.lyric2.BaseLyricView
    public int getScrollTimeNoticeDelay() {
        return this.scrollTimeNoticeDelay;
    }

    public int getTextBorderColor() {
        return this.textBorderColor;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getTextSize() {
        return getmPaint().getTextSize();
    }

    public boolean isCurLyricLarge() {
        return this.isNeedLargeCurLyric;
    }

    public boolean isDismissPlayedLyric() {
        return this.isDismissPlayedLyric;
    }

    public boolean isFadeMode() {
        return this.isFadeMode;
    }

    @Override // com.kugou.framework.lyric2.EventLyricView
    public boolean isHitFooterArea(MotionEvent motionEvent) {
        return this.isFooterMessageVisible && this.footerAreaRect.contains(motionEvent.getX(), motionEvent.getY());
    }

    @Override // com.kugou.framework.lyric2.EventLyricView
    public boolean isHitHeaderArea(MotionEvent motionEvent) {
        return this.isHeaderMessageVisible && this.headerAreaRect.contains(motionEvent.getX(), motionEvent.getY());
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public boolean isLyrViewShown() {
        return isShown();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public boolean isLyricLoaded() {
        return this.lyricData != null;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public boolean isLyricSplited() {
        return true;
    }

    public boolean isNeedKrcRender() {
        return this.isNeedKrcRender;
    }

    @Override // com.kugou.framework.lyric2.BaseLyricView
    public boolean isNeedSameRowMargin() {
        return this.language == Language.Origin;
    }

    public boolean isNormalFadeMode() {
        return this.isNormalFadeMode;
    }

    public boolean isOpenHover() {
        return this.isOpenHover;
    }

    public boolean isPlayLyricBgHighlight() {
        return this.isPlayLyricBgHighlight;
    }

    public boolean isPlayedLyricShowPlayedColor() {
        return this.playedLyricShowPlayedColor;
    }

    public boolean isPlayingCellFontBig() {
        return this.isPlayingCellFontBig;
    }

    public boolean isRowEndTimeUseBeginAddDelay() {
        return this.rowEndTimeUseBeginAddDelay;
    }

    public boolean isShowDynamicLyricFirstRow() {
        return this.isShowDynamicLyricFirstRow;
    }

    public boolean isShowDynamicLyricSecondRow() {
        return this.isShowDynamicLyricSecondRow;
    }

    public boolean isTextBorder() {
        return this.isTextBorder;
    }

    public boolean isTouchFadeMode() {
        return this.isTouchFadeMode;
    }

    public void onCellDraw(Canvas canvas, long j, long j2, float f2, float f3, float f4, int i2) {
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        this.surWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (View.MeasureSpec.getMode(i3) != 1073741824 && !this.fullScreen) {
            size2 = Math.min(size2, (int) Math.ceil(this.maxRows * CellUtils.getWordHeight(getmPaint())));
        }
        setMeasuredDimension(size, size2);
    }

    public void onRowDraw(Canvas canvas, long j, long j2, int i2, float f2, float f3, boolean z) {
    }

    public void putCellData(int i2, Cell cell) {
        synchronized (this.cellDataMapLock) {
            this.cellDataSparseArray.put(i2, cell);
        }
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void refresh() {
        postInvalidate();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void release() {
        synchronized (this.cellDataMapLock) {
            this.lyricData = null;
            this.mPlayingTime = 0L;
            this.footerMessage = null;
            this.cellDataSparseArray.clear();
            postInvalidate();
        }
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void resetRowIndex() {
    }

    @Override // com.kugou.framework.lyric2.BaseLyricView
    public void scrollToPlayingRow() {
        if (this.scrollRowOffset == this.playedOffset || !this.mScroller.isFinished()) {
            return;
        }
        LyricDebug.d("2 scroll to: scrollToPlayingRow");
        scrollToPlayingRow(this.playedOffset);
    }

    @Override // com.kugou.framework.lyric2.BaseLyricView
    public void setCellMargin(int i2) {
        super.setCellMargin(i2);
        resetState(this.lyricData);
    }

    public void setCellRowMargin(float f2) {
        if (this.cellRowMargin != f2) {
            this.cellRowMargin = f2;
            resetState(this.lyricData);
        }
    }

    public void setCurLyricLarge(boolean z) {
        this.isNeedLargeCurLyric = z;
    }

    public void setCutTime(int i2, int i3) {
        this.cutStartTime = i2;
        this.cutEndTime = i3;
        if (i2 > 0 || i3 < Integer.MAX_VALUE) {
            this.isShowPartLyric = true;
        } else {
            this.isShowPartLyric = false;
        }
        if (i2 >= i3) {
            throw new IndexOutOfBoundsException("startTime must smaller than endTime");
        }
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void setDefaultMsg(String str) {
        LyricConstent.defaultMsg = str;
    }

    public void setDefaultMsgColor(int i2) {
        this.dftMsgColor = i2;
    }

    public void setFooterMessage(FooterMessage footerMessage) {
        this.footerMessage = footerMessage;
        if (footerMessage == null) {
            this.footerAreaRect.setEmpty();
        }
    }

    public void setFooterMessageVisible(boolean z) {
        this.isFooterMessageVisible = z;
    }

    public void setFrontColor(int i2) {
        setPlayedColor(i2);
    }

    public void setFullScreen(boolean z) {
        this.fullScreen = z;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (z) {
            layoutParams.height = -1;
        } else {
            layoutParams.height = -2;
        }
        setLayoutParams(layoutParams);
        requestLayout();
    }

    public void setHeadImgToTextPadding(int i2) {
        this.headImgToTextPadding = i2;
    }

    public void setHeaderMessage(HeaderMessage headerMessage) {
        this.headerMessage = headerMessage;
        if (headerMessage == null) {
            this.headerAreaRect.setEmpty();
        }
    }

    public void setHeaderMessageVisible(boolean z) {
        this.isHeaderMessageVisible = z;
    }

    public void setHoverColor(int i2) {
        this.hoverColor = i2;
    }

    public void setIsDismissPlayedLyric(boolean z) {
        this.isDismissPlayedLyric = z;
    }

    public void setIsFadeMode(boolean z) {
        this.isFadeMode = z;
    }

    public void setIsOpenHover(boolean z) {
        this.isOpenHover = z;
    }

    public void setIsPlayingCellFontBig(boolean z) {
        this.isPlayingCellFontBig = z;
    }

    public void setIsShowDynamicLyricFirstRow(boolean z) {
        this.isShowDynamicLyricFirstRow = z;
    }

    public void setIsShowDynamicLyricSecondRow(boolean z) {
        this.isShowDynamicLyricSecondRow = z;
    }

    public void setIsTouchFadeMode(boolean z) {
        this.isTouchFadeMode = z;
    }

    public void setLanguage(Language language) {
        if (this.language != language) {
            this.language = language;
            resetState(this.lyricData);
            invalidate();
        }
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void setLyricData(LyricData lyricData) {
        if (lyricData == null) {
            return;
        }
        synchronized (this.lyricLock) {
            this.lyricData = lyricData;
            this.lyricType = lyricData.getLyricType();
            OnLyricDataLoadListener onLyricDataLoadListener = this.lyricDataLoadListener;
            if (onLyricDataLoadListener != null) {
                onLyricDataLoadListener.onLyricDataLoaded(lyricData);
            }
            this.scrollRowOffset = 0;
        }
        resetState(lyricData);
    }

    public void setLyricType(int i2) {
        this.lyricType = i2;
    }

    public void setMaxRows(int i2) {
        this.maxRows = i2;
    }

    public void setNeedKrcRender(boolean z) {
        this.isNeedKrcRender = z;
    }

    public void setNormalFadeMode(boolean z) {
        this.isNormalFadeMode = z;
    }

    public void setOnLyricDataLoadListener(OnLyricDataLoadListener onLyricDataLoadListener) {
        this.lyricDataLoadListener = onLyricDataLoadListener;
    }

    public void setPlayLyricBgHighlight(boolean z) {
        this.isPlayLyricBgHighlight = z;
    }

    public void setPlayedLyricShowPlayedColor(boolean z) {
        this.playedLyricShowPlayedColor = z;
    }

    public void setRowCount(int i2) {
        this.rowCount = i2;
    }

    public void setRowEndTimeUseBeginAddDelay(boolean z) {
        this.rowEndTimeUseBeginAddDelay = z;
    }

    public void setScrollTimeNoticeDelay(int i2) {
        this.scrollTimeNoticeDelay = i2;
    }

    public void setShadowColor(int i2) {
        this.mShadowColor = i2;
    }

    public void setSlideLyricRowMargin(int i2) {
        super.setCellMargin(i2);
    }

    @Override // com.kugou.framework.lyric2.BaseLyricView
    public void setSurLyricBg(int i2) {
        super.setSurLyricBg(i2);
    }

    public void setTextBorder(boolean z) {
        this.isTextBorder = z;
    }

    public void setTextBorderColor(int i2) {
        this.textBorderColor = i2;
    }

    public void setTextSize(int i2) {
        super.setTextSize(i2);
        resetState(this.lyricData);
    }

    @Override // com.kugou.framework.lyric2.BaseLyricView
    public void setViewSize(int i2, int i3) {
        super.setViewSize(i2, i3);
        resetState(this.lyricData);
    }

    public void showDefaultMsg(Canvas canvas) {
        getmPaint().setShader(null);
        int width = getWidth();
        int height = getHeight();
        float fMeasureText = (width - getmPaint().measureText(LyricConstent.defaultMsg)) / 2.0f;
        float wordHeight = ((height + CellUtils.getWordHeight(getmPaint())) / 2.0f) - CellUtils.getLeading(getmPaint());
        getmPaint().setAlpha(256);
        getmPaint().setColor(this.dftMsgColor);
        canvas.drawText(LyricConstent.defaultMsg, fMeasureText, wordHeight, getmPaint());
    }

    public NewLyricView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewLyricView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.rowCount = 0;
        this.isSettingLanguage = false;
        this.fullScreen = true;
        this.maxRows = -1;
        this.lyricType = 1;
        this.dftMsgColor = -1;
        this.hoverColor = SupportMenu.CATEGORY_MASK;
        this.isOpenHover = false;
        this.isFadeMode = true;
        this.isTouchFadeMode = false;
        this.isNormalFadeMode = false;
        this.isShowPartLyric = false;
        this.isNeedLargeCurLyric = false;
        this.rowEndTimeUseBeginAddDelay = false;
        this.isShowDynamicLyricSecondRow = false;
        this.isShowDynamicLyricFirstRow = false;
        this.isDismissPlayedLyric = false;
        this.playedLyricShowPlayedColor = false;
        this.isNeedKrcRender = true;
        this.isPlayLyricBgHighlight = false;
        this.headImgToTextPadding = 10;
        this.isPlayingCellFontBig = false;
        this.mLocationHeight = -1;
        this.cutStartTime = 0;
        this.cutEndTime = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.scrollTimeNoticeDelay = 3000;
        this.language = Language.Transliteration;
        this.lyricLock = new Object();
        this.isDrawingAllRows = false;
        this.cellDataSparseArray = new SparseArray<>();
        this.footerAreaRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.isFooterMessageVisible = true;
        this.headerAreaRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.isHeaderMessageVisible = false;
        this.isTextBorder = false;
        this.textBorderColor = Color.parseColor("#BD212121");
        this.playedOffset = 0;
        this.centerOffset = 0;
        this.cellDataMapLock = new Object();
        this.mShadowColor = SupportMenu.CATEGORY_MASK;
    }
}
