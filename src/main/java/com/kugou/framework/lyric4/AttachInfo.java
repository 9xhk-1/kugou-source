package com.kugou.framework.lyric4;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import androidx.core.internal.view.SupportMenu;
import com.kugou.framework.lyric.loader.language.Language;
import com.kugou.framework.lyric4.span.ExtraDrawSpan;
import com.kugou.framework.lyric4.span.Span;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AttachInfo {
    public static final int DEFAULT_STROKE_SIZE = 1;
    public static final String TAG = "AttachInfo";
    private ExtraDrawSpan extraDrawSpan;
    public Bitmap mClimaxBitmap;
    private int mCurWordsBeginTimePercentage;
    private int mCurrentHighLightLine;
    private int mCurrentHighLightPercentage;
    private int mCurrentHighLightWord;
    private int mLineTotalWords;
    private Map<Integer, Span>[] mSpanMaps;
    private Typeface mTypeface;
    private int mClimaxLine = -1;
    private int mTextColor = -1;
    private int mTextHighLightColor = SupportMenu.CATEGORY_MASK;
    private int mTextLineColor = -1;
    private int mSelectedLineColor = -1;
    private int mTextSize = 50;
    private int mBlurStrength = 0;
    private float mHighLightTextZoomRate = 1.0f;
    private float mHighLightScaleRate = 0.3f;
    private int mCellRowMargin = 10;
    private int mLineSpacing = 0;
    private int mPressColor = -16777216;
    private float mBreakFactor = 1.0f;
    private Language language = Language.Origin;
    private int cellAlignMode = 0;
    private int mHeaderTextSize = 50;
    private int mHeaderTextColor = -16777216;
    private int mFooterTextSize = 50;
    private int mFooterTextColor = -16777216;
    private boolean mIsStroke = false;
    private int mStrokeColor = -16777216;
    private float mStrokeSize = 0.0f;
    private float mStrokePenSize = 1.0f;
    private int mTranslationTextSize = -1;
    private int mTransliterationTextSize = -1;
    private int mChineseTextSize = -1;
    private int mSubLyricMarginTop = 10;
    private boolean mIsScaleHighLightWord = false;
    private boolean mIsBoldHighLightWord = false;
    private boolean mIsBoldText = false;
    private float mAlpha = 1.0f;
    private String mTxtNoSupportText = "";
    private boolean isShowTopHalfLine = false;
    private boolean isHideHalfLine = false;
    private boolean showHighLightLine = true;
    private boolean showPlayingLineLight = false;
    private int lyrType = 0;
    private long climaxStartTime = 0;
    private long climaxEndTime = 0;
    private boolean mIsSliding = false;

    private void log(String str) {
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public int getBlur() {
        return this.mBlurStrength;
    }

    public float getBreakFactor() {
        return this.mBreakFactor;
    }

    public int getCellAlignMode() {
        return this.cellAlignMode;
    }

    public int getCellRowMargin() {
        return this.mCellRowMargin;
    }

    public int getChineseTextSize() {
        return this.mChineseTextSize;
    }

    public Bitmap getClimaxBitmap() {
        return this.mClimaxBitmap;
    }

    public long getClimaxEndTime() {
        return this.climaxEndTime;
    }

    public int getClimaxLine() {
        return this.mClimaxLine;
    }

    public long getClimaxStartTime() {
        return this.climaxStartTime;
    }

    public int getCurWordsBeginTimePercentage() {
        return this.mCurWordsBeginTimePercentage;
    }

    public int getCurrentHighLightLine() {
        return this.mCurrentHighLightLine;
    }

    public int getCurrentHighLightPercentage() {
        return this.mCurrentHighLightPercentage;
    }

    public int getCurrentHighLightWord() {
        return this.mCurrentHighLightWord;
    }

    public ExtraDrawSpan getExtraDrawSpan() {
        return this.extraDrawSpan;
    }

    public int getFooterTextColor() {
        return this.mFooterTextColor;
    }

    public int getFooterTextSize() {
        return this.mFooterTextSize;
    }

    public int getHeaderTextColor() {
        return this.mHeaderTextColor;
    }

    public int getHeaderTextSize() {
        return this.mHeaderTextSize;
    }

    public float getHighLightScaleRate() {
        return this.mHighLightScaleRate;
    }

    public float getHighLightTextZoomRate() {
        return this.mHighLightTextZoomRate;
    }

    public boolean getIsSliding() {
        return this.mIsSliding;
    }

    public Language getLanguage() {
        return this.language;
    }

    public int getLineSpacing() {
        return this.mLineSpacing;
    }

    public int getLineTotalWords() {
        return this.mLineTotalWords;
    }

    public int getLyrType() {
        return this.lyrType;
    }

    public int getPressColor() {
        return this.mPressColor;
    }

    public int getSelectedLineColor() {
        return this.mSelectedLineColor;
    }

    public boolean getShowHighLightLine() {
        return this.showHighLightLine;
    }

    public Map<Integer, Span> getSpanMap(int i2) {
        Map<Integer, Span>[] mapArr = this.mSpanMaps;
        if (mapArr == null || i2 >= mapArr.length) {
            return null;
        }
        return mapArr[i2];
    }

    public Map<Integer, Span>[] getSpanMaps() {
        return this.mSpanMaps;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public float getStrokePenSize() {
        return this.mStrokePenSize;
    }

    public float getStrokeSize() {
        return this.mStrokeSize;
    }

    public int getSubLyricMarginTop() {
        return this.mSubLyricMarginTop;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public int getTextHighLightColor() {
        return this.mTextHighLightColor;
    }

    public int getTextLineColor() {
        return this.showPlayingLineLight ? this.mTextLineColor : this.mTextColor;
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    public int getTranslationTextSize() {
        return this.mTranslationTextSize;
    }

    public int getTransliterationTextSize() {
        return this.mTransliterationTextSize;
    }

    public String getTxtNoSupportText() {
        return this.mTxtNoSupportText;
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public boolean isBoldHighLightWord() {
        return this.mIsBoldHighLightWord;
    }

    public boolean isBoldText() {
        return this.mIsBoldText;
    }

    public boolean isHideHalfLine() {
        return this.isHideHalfLine;
    }

    public boolean isScaleHighLightWord() {
        return this.mIsScaleHighLightWord;
    }

    public boolean isShowClimax(long j) {
        long j2 = this.climaxStartTime;
        if (j2 <= 0) {
            return false;
        }
        long j3 = this.climaxEndTime;
        return j3 > 0 && j >= j2 && j <= j3 && j2 < j3;
    }

    public boolean isShowPlayingLineLight() {
        return this.showPlayingLineLight;
    }

    public boolean isShowSelectBgMode() {
        return this.extraDrawSpan != null;
    }

    public boolean isShowTopHalfLine() {
        return this.isShowTopHalfLine;
    }

    public boolean isStroke() {
        return this.mIsStroke;
    }

    public void setAlpha(float f2) {
        if (this.mAlpha > 1.0f) {
            this.mAlpha = 1.0f;
        }
        if (this.mAlpha < 0.0f) {
            this.mAlpha = 0.0f;
        }
        this.mAlpha = f2;
    }

    public void setBlur(int i2) {
        this.mBlurStrength = i2;
    }

    public void setBoldHighLightWord(boolean z) {
        this.mIsBoldHighLightWord = z;
    }

    public void setBoldText(boolean z) {
        this.mIsBoldText = z;
    }

    public void setBreakFactor(float f2) {
        this.mBreakFactor = f2;
    }

    public void setCellAlignMode(int i2) {
        this.cellAlignMode = i2;
    }

    public void setCellRowMargin(int i2) {
        this.mCellRowMargin = i2;
    }

    public void setChineseTextSize(int i2) {
        this.mChineseTextSize = i2;
    }

    public void setClimaxBitmap(Bitmap bitmap) {
        this.mClimaxBitmap = bitmap;
    }

    public void setClimaxEndTime(long j) {
        this.climaxEndTime = j;
    }

    public void setClimaxLine(int i2) {
        this.mClimaxLine = i2;
    }

    public void setClimaxStartTime(long j) {
        this.climaxStartTime = j;
    }

    public void setCurWordsBeginTimePercentage(int i2) {
        this.mCurWordsBeginTimePercentage = i2;
    }

    public void setCurrentHighLightLine(int i2) {
        this.mCurrentHighLightLine = i2;
    }

    public void setCurrentHighLightPercentage(int i2) {
        this.mCurrentHighLightPercentage = i2;
    }

    public void setCurrentHighLightWord(int i2) {
        this.mCurrentHighLightWord = i2;
    }

    public void setExtraDrawSpan(ExtraDrawSpan extraDrawSpan) {
        this.extraDrawSpan = extraDrawSpan;
        if (extraDrawSpan != null) {
            extraDrawSpan.setAttachInfo(this);
        }
    }

    public void setFooterTextColor(int i2) {
        this.mFooterTextColor = i2;
    }

    public void setFooterTextSize(int i2) {
        this.mFooterTextSize = i2;
    }

    public void setHeaderTextColor(int i2) {
        this.mHeaderTextColor = i2;
    }

    public void setHeaderTextSize(int i2) {
        this.mHeaderTextSize = i2;
    }

    public void setHideHalfLine(boolean z) {
        this.isHideHalfLine = z;
    }

    public void setHighLightScaleRate(float f2) {
        this.mHighLightScaleRate = f2;
    }

    public void setHighLightTextZoomRate(float f2) {
        this.mHighLightTextZoomRate = f2;
    }

    public void setIsSliding(boolean z) {
        log("setIsSliding:" + z);
        this.mIsSliding = z;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setLineSpacing(int i2) {
        this.mLineSpacing = i2;
    }

    public void setLineTotalWords(int i2) {
        this.mLineTotalWords = i2;
    }

    public void setLyrType(int i2) {
        this.lyrType = i2;
    }

    public void setPressColor(int i2) {
        this.mPressColor = i2;
    }

    public void setScaleHighLightWord(boolean z) {
        this.mIsScaleHighLightWord = z;
    }

    public void setSelectedLineColor(int i2) {
        this.mSelectedLineColor = i2;
    }

    public void setShowHighLight(boolean z) {
        this.showHighLightLine = z;
    }

    public void setShowPlayingLineLight(boolean z) {
        this.showPlayingLineLight = z;
    }

    public void setShowTopHalfLine(boolean z) {
        this.isShowTopHalfLine = z;
    }

    public void setSpanMaps(Map<Integer, Span>[] mapArr) {
        this.mSpanMaps = mapArr;
    }

    public void setStroke(boolean z) {
        this.mIsStroke = z;
    }

    public void setStrokeColor(int i2) {
        this.mStrokeColor = i2;
    }

    public void setStrokePenSize(float f2) {
        this.mStrokePenSize = f2;
    }

    public void setStrokeSize(int i2) {
        this.mStrokeSize = i2;
    }

    public void setSubLyricMarginTop(int i2) {
        this.mSubLyricMarginTop = i2;
    }

    public void setTextColor(int i2) {
        this.mTextColor = i2;
    }

    public void setTextHighLightColor(int i2) {
        this.mTextHighLightColor = i2;
    }

    public void setTextLineColor(int i2) {
        this.mTextLineColor = i2;
    }

    public void setTextSize(int i2) {
        this.mTextSize = i2;
    }

    public void setTranslationTextSize(int i2) {
        this.mTranslationTextSize = i2;
    }

    public void setTransliterationTextSize(int i2) {
        this.mTransliterationTextSize = i2;
    }

    public void setTxtNoSupportText(String str) {
        this.mTxtNoSupportText = str;
    }

    public void setTypeface(Typeface typeface) {
        this.mTypeface = typeface;
    }
}
