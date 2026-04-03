package com.kugou.framework.lyricanim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.kugou.framework.lyric.ILyricView;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.debug.LyricDebug;
import com.kugou.framework.lyric.loader.language.Language;
import com.kugou.framework.lyric2.ISurLyricSync;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.BaseLyricView;
import com.kugou.framework.lyric4.Entity.BulletinEntity;
import com.kugou.framework.lyric4.MultipleLineLyricView;
import com.kugou.framework.lyric4.cell.Cell;
import com.kugou.framework.lyric4.cell.CellGroup;
import com.kugou.framework.lyric4.cell.breakline.LyricLineInfo;
import com.kugou.framework.lyric4.cell.breakline.LyricWord;
import com.kugou.framework.lyric4.cell.lyric.WrapLineHighLightCell;
import com.kugou.framework.lyric4.span.ExtraDrawSpan;
import com.kugou.framework.lyric4.span.Span;
import com.kugou.framework.lyric4.utils.Utils;
import com.kugou.framework.lyricanim.SingleLyricCell;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MultiLineLyricView extends FrameLayout implements ILyricView, ISurLyricSync, MultipleLineLyricView.CellGroupListener {
    private static final String TAG = "MultiLineLyricView";
    private int lastCellIndex;
    private int lastLineIndexInCell;
    private SingleLyricCell mAnimationCell;
    private float mAnimationCellHeight;
    private boolean mGLTextureReleaseWhenDetached;
    private int mHighLightWordIndex;
    private int mHighLightWordPercentage;
    private boolean mIsBounceAnimMode;
    private boolean mIsCellLayoutValid;
    private SingleLyricCell.TextRenderListener mListener;
    private FadingLyricView mLyricView;
    private VisibilityListener mVisibilityListener;

    public interface VisibilityListener {
        void onVisibility(int i2);
    }

    public MultiLineLyricView(@NonNull Context context) {
        this(context, null);
    }

    private boolean checkCellWordsIllegal(WrapLineHighLightCell wrapLineHighLightCell) {
        int length = 0;
        for (LyricLineInfo lyricLineInfo : wrapLineHighLightCell.getLyricLineInfos()) {
            length += lyricLineInfo.getLyricWords().length;
        }
        return wrapLineHighLightCell.getLyricWords().length != length;
    }

    private boolean checkStringContentChanged(int i2, int i3) {
        return (this.lastCellIndex == i2 && this.lastLineIndexInCell == i3) ? false : true;
    }

    private String[] getCurWords(LyricWord[] lyricWordArr) {
        String[] strArr = new String[lyricWordArr.length];
        for (int i2 = 0; i2 < lyricWordArr.length; i2++) {
            strArr[i2] = lyricWordArr[i2].getLyricWord();
        }
        return strArr;
    }

    private void hideAnimCell() {
        if (this.mAnimationCell.isSurfaceCreated() && this.mAnimationCell.getVisibility() == 0) {
            this.mAnimationCell.setVisibility(4);
            this.mLyricView.showHighLightLine();
        }
    }

    public void clearLyricSelected() {
        this.mLyricView.clearCellSelectState();
    }

    public SingleLyricCell getAnimationCell() {
        return this.mAnimationCell;
    }

    public AttachInfo getAttachInfo() {
        return this.mLyricView.getAttachInfo();
    }

    public List<Language> getCanUseType() {
        return this.mLyricView.getCanUseType();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getContentWidth() {
        return this.mLyricView.getContentWidth();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public String getCurrentLyrics() {
        return this.mLyricView.getCurrentLyrics();
    }

    public FadingLyricView getFadingLyricView() {
        return this.mLyricView;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public LyricData getLyricData() {
        return this.mLyricView.getLyricData();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public Paint getPen() {
        return this.mLyricView.getPen();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getRowHeight() {
        return this.mLyricView.getRowHeight();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getTextSize() {
        return this.mLyricView.getTextSize();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public boolean isLyrViewShown() {
        return getVisibility() == 0;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public boolean isLyricLoaded() {
        return this.mLyricView.isLyricLoaded();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public boolean isLyricSplited() {
        return this.mLyricView.isLyricSplited();
    }

    @Override // com.kugou.framework.lyric4.MultipleLineLyricView.CellGroupListener
    public void onCellGroupPrelude() {
        hideAnimCell();
    }

    @Override // com.kugou.framework.lyric4.MultipleLineLyricView.CellGroupListener
    public void onCellGroupUpdated(float f2, boolean z) {
        CellGroup cellGroup = this.mLyricView.mCellGroup;
        if (cellGroup == null || cellGroup.getCellSize() <= 0) {
            hideAnimCell();
            return;
        }
        int currentHighLightLine = getAttachInfo().getCurrentHighLightLine();
        this.mHighLightWordIndex = getAttachInfo().getCurrentHighLightWord();
        this.mHighLightWordPercentage = getAttachInfo().getCurWordsBeginTimePercentage();
        String[] curWords = null;
        if (!this.mLyricView.getGlRenderNotifyFlag() || this.mLyricView.getLyricData() == null || this.mLyricView.getLyricData().getLyricType() == 2 || this.mLyricView.getLyricData().getLyricType() == 3) {
            return;
        }
        if (!z) {
            hideAnimCell();
        }
        Cell childCell = this.mLyricView.mCellGroup.getChildCell(currentHighLightLine + 1);
        if (childCell instanceof WrapLineHighLightCell) {
            WrapLineHighLightCell wrapLineHighLightCell = (WrapLineHighLightCell) childCell;
            if (checkCellWordsIllegal(wrapLineHighLightCell)) {
                hideAnimCell();
                return;
            }
            LyricDebug.d("onCellGroupUpdated: index->" + this.mHighLightWordIndex + " percentage-> " + this.mHighLightWordPercentage);
            LyricLineInfo[] defaultLyricLineInfos = wrapLineHighLightCell.getDefaultLyricLineInfos();
            int i2 = 0;
            int length = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i2 >= defaultLyricLineInfos.length) {
                    i2 = i3;
                    break;
                }
                LyricLineInfo lyricLineInfo = defaultLyricLineInfos[i2];
                if (this.mHighLightWordIndex <= (lyricLineInfo.getLyricWords().length + length) - 1) {
                    i4 = this.mHighLightWordIndex - length;
                    curWords = getCurWords(lyricLineInfo.getLyricWords());
                    break;
                }
                i4 = this.mHighLightWordIndex - length;
                String[] curWords2 = getCurWords(lyricLineInfo.getLyricWords());
                length += lyricLineInfo.getLyricWords().length;
                i3 = i2;
                i2++;
                curWords = curWords2;
            }
            int i5 = i4;
            if (checkStringContentChanged(currentHighLightLine, i2)) {
                this.lastCellIndex = currentHighLightLine;
                this.lastLineIndexInCell = i2;
                if (this.mAnimationCell.isSurfaceCreated()) {
                    this.mAnimationCell.setVisibility(4);
                }
                if (this.mAnimationCellHeight == -1.0f) {
                    float lineHeight = wrapLineHighLightCell.getDefaultLyricLineInfos()[0].getLineHeight();
                    this.mAnimationCellHeight = lineHeight;
                    this.mAnimationCell.updateCellHeight(((int) lineHeight) * 4);
                }
                this.mAnimationCell.updateStringContent(curWords, wrapLineHighLightCell.getPlayLinePaint(), i5, this.mHighLightWordPercentage);
            } else if (!this.mIsCellLayoutValid) {
                this.mIsCellLayoutValid = true;
                this.lastCellIndex = currentHighLightLine;
                this.lastLineIndexInCell = i2;
                float lineHeight2 = wrapLineHighLightCell.getDefaultLyricLineInfos()[0].getLineHeight();
                this.mAnimationCellHeight = lineHeight2;
                this.mAnimationCell.updateCellHeight(((int) lineHeight2) * 4);
                this.mAnimationCell.updateStringContent(curWords, wrapLineHighLightCell.getPlayLinePaint(), i5, this.mHighLightWordPercentage);
            }
            this.mAnimationCell.setTextSize((int) wrapLineHighLightCell.getDefaultLyricLineInfos()[0].getLineHeight());
            int i6 = this.mHighLightWordPercentage;
            if (i6 >= 0) {
                this.mAnimationCell.updateAnimationParams(curWords, i5, i6, f2);
            } else {
                this.mAnimationCell.updateInitParams(curWords, f2);
            }
            this.mAnimationCell.setTranslationY((((childCell.getVisibleRect().top + ((this.mAnimationCellHeight + wrapLineHighLightCell.getLineSpacing()) * i2)) + ((this.mAnimationCellHeight * (this.mLyricView.getAttachInfo().getHighLightTextZoomRate() - 1.0f)) * (i2 + 1))) - (this.mAnimationCellHeight * 2.0f)) - this.mLyricView.getScrollY());
            return;
        }
        if (childCell instanceof CellGroup) {
            Cell childCell2 = ((CellGroup) childCell).getChildCell(0);
            if (childCell2 instanceof WrapLineHighLightCell) {
                WrapLineHighLightCell wrapLineHighLightCell2 = (WrapLineHighLightCell) childCell2;
                if (checkCellWordsIllegal(wrapLineHighLightCell2)) {
                    hideAnimCell();
                    return;
                }
                LyricLineInfo[] lyricLineInfos = wrapLineHighLightCell2.getLyricLineInfos();
                int i7 = 0;
                int length2 = 0;
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    if (i7 >= lyricLineInfos.length) {
                        i7 = i8;
                        break;
                    }
                    LyricLineInfo lyricLineInfo2 = lyricLineInfos[i7];
                    if (this.mHighLightWordIndex <= (lyricLineInfo2.getLyricWords().length + length2) - 1) {
                        i9 = this.mHighLightWordIndex - length2;
                        curWords = getCurWords(lyricLineInfo2.getLyricWords());
                        break;
                    }
                    i9 = this.mHighLightWordIndex - length2;
                    String[] curWords3 = getCurWords(lyricLineInfo2.getLyricWords());
                    length2 += lyricLineInfo2.getLyricWords().length;
                    i8 = i7;
                    i7++;
                    curWords = curWords3;
                }
                if (checkStringContentChanged(currentHighLightLine, i7)) {
                    this.lastCellIndex = currentHighLightLine;
                    this.lastLineIndexInCell = i7;
                    if (this.mAnimationCell.isSurfaceCreated()) {
                        this.mAnimationCell.setVisibility(4);
                    }
                    if (this.mAnimationCellHeight == -1.0f) {
                        float lineHeight3 = wrapLineHighLightCell2.getDefaultLyricLineInfos()[0].getLineHeight();
                        this.mAnimationCellHeight = lineHeight3;
                        this.mAnimationCell.updateCellHeight(((int) lineHeight3) * 4);
                    }
                    this.mAnimationCell.updateStringContent(curWords, wrapLineHighLightCell2.getPlayLinePaint(), i9, this.mHighLightWordPercentage);
                } else if (!this.mIsCellLayoutValid) {
                    this.mIsCellLayoutValid = true;
                    this.lastCellIndex = currentHighLightLine;
                    this.lastLineIndexInCell = i7;
                    if (this.mAnimationCell.isSurfaceCreated()) {
                        this.mAnimationCell.setVisibility(4);
                    }
                    float lineHeight4 = wrapLineHighLightCell2.getDefaultLyricLineInfos()[0].getLineHeight();
                    this.mAnimationCellHeight = lineHeight4;
                    this.mAnimationCell.updateCellHeight(((int) lineHeight4) * 4);
                    this.mAnimationCell.updateStringContent(curWords, wrapLineHighLightCell2.getPlayLinePaint(), i9, this.mHighLightWordPercentage);
                }
                this.mAnimationCell.setTextSize((int) wrapLineHighLightCell2.getDefaultLyricLineInfos()[0].getLineHeight());
                int i10 = this.mHighLightWordPercentage;
                if (i10 >= 0) {
                    this.mAnimationCell.updateAnimationParams(curWords, i9, i10, f2);
                } else {
                    this.mAnimationCell.updateInitParams(curWords, f2);
                }
                this.mAnimationCell.setTranslationY((((childCell2.getVisibleRect().top + ((this.mAnimationCellHeight + wrapLineHighLightCell2.getLineSpacing()) * i7)) + ((this.mAnimationCellHeight * (this.mLyricView.getAttachInfo().getHighLightTextZoomRate() - 1.0f)) * (i7 + 1))) - (this.mAnimationCellHeight * 2.0f)) - this.mLyricView.getScrollY());
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        FadingLyricView fadingLyricView;
        FadingLyricView fadingLyricView2 = this.mLyricView;
        if (fadingLyricView2 == null || ((fadingLyricView2.getOnTouchInterceptListener() != null && ((fadingLyricView = this.mLyricView) == null || !fadingLyricView.getOnTouchInterceptListener().OnTouchIntercept())) || getAttachInfo() == null || !getAttachInfo().isShowSelectBgMode())) {
            return super.onTouchEvent(motionEvent);
        }
        motionEvent.offsetLocation(-this.mLyricView.getLeft(), -this.mLyricView.getTop());
        return this.mLyricView.onTouchEvent(motionEvent);
    }

    public void reScrollToCenter() {
        this.mIsCellLayoutValid = true;
        this.mLyricView.setDisableScrollBack(false);
        this.mLyricView.setDisableAutoScroll(false);
        this.mLyricView.reScrollToCenter();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void refresh() {
        this.mLyricView.refresh();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void release() {
        this.mIsCellLayoutValid = false;
        this.lastCellIndex = -1;
        this.lastLineIndexInCell = -1;
        this.mHighLightWordIndex = 0;
        this.mHighLightWordPercentage = 0;
        this.mLyricView.setGlRenderNotifyFlag(false);
        this.mAnimationCell.release();
        this.mLyricView.release();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void resetRowIndex() {
        this.mLyricView.resetRowIndex();
    }

    public void setAnimationImageArray(int[] iArr) {
        this.mAnimationCell.setAnimationImageArray(iArr);
        if (this.mLyricView.isGLRenderEnable()) {
            float highLightTextZoomRate = this.mLyricView.getAttachInfo().getHighLightTextZoomRate();
            FadingLyricView fadingLyricView = this.mLyricView;
            onCellGroupUpdated(highLightTextZoomRate, fadingLyricView.checkHasPassPrePlay(fadingLyricView.getAttachInfo().getCurrentHighLightLine()));
        }
    }

    public void setAnimationType(int i2) {
        if (i2 == 2) {
            return;
        }
        this.mLyricView.setAnimationType(i2);
    }

    public void setBlur(int i2) {
        this.mLyricView.setBlur(i2);
    }

    public void setBoldHighLightWord(boolean z) {
        this.mIsCellLayoutValid = false;
        this.mLyricView.setBoldHighLightWord(z);
    }

    public void setBreakFactor(float f2) {
        this.mLyricView.setBreakFactor(f2);
    }

    public void setBulletinEntity(BulletinEntity bulletinEntity) {
        this.mLyricView.setBulletinEntity(bulletinEntity);
    }

    public void setCanSlide(boolean z) {
        this.mLyricView.setCanSlide(z);
    }

    public void setCantoneseInfo(Bitmap bitmap, String str, int i2) {
        this.mLyricView.setCantoneseInfo(bitmap, str, i2);
    }

    public void setCantoneseTextColor(int i2) {
        this.mLyricView.setCantoneseTextColor(i2);
    }

    public void setCellClickEnable(boolean z) {
        this.mLyricView.setCellClickEnable(z);
    }

    public void setCellLineSpacing(int i2) {
        this.mLyricView.setCellLineSpacing(i2);
    }

    public void setCellLongClickEnable(boolean z) {
        this.mLyricView.setCellLongClickEnable(z);
    }

    public void setCellRowMargin(int i2) {
        this.mLyricView.setCellRowMargin(i2);
    }

    public void setChineseTextSize(int i2) {
        this.mIsCellLayoutValid = false;
        this.mLyricView.setChineseTextSize(i2);
    }

    public void setClimaxBg(Bitmap bitmap) {
        getAttachInfo().setClimaxBitmap(bitmap);
    }

    public void setClimaxTime(long j, long j2) {
        this.mLyricView.setClimaxTime(j, j2);
    }

    public void setCopyRightText(String str) {
        this.mLyricView.setCopyRightText(str);
    }

    public void setDefaultMessageStyle(int i2) {
        this.mLyricView.setDefaultMessageStyle(i2);
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void setDefaultMsg(String str) {
        this.mLyricView.setDefaultMsg(str);
    }

    public void setDisableAutoScroll(boolean z) {
        this.mLyricView.setDisableAutoScroll(z);
    }

    public void setDisableTouchEvent(boolean z) {
        this.mLyricView.setDisableTouchEvent(z);
    }

    public void setEnableFadingEdge(boolean z) {
        if (!z) {
            this.mLyricView.setVerticalFadingEdgeEnabled(false);
            this.mLyricView.setEnableFadingEdge(false);
        } else {
            this.mLyricView.setEnableFadingEdge(true);
            this.mLyricView.setVerticalFadingEdgeEnabled(true);
            this.mLyricView.setFadingEdgeLength(Utils.dip2px(getContext(), 80.0f));
        }
    }

    public void setFooterStyle(int i2, int i3) {
        this.mLyricView.setFooterStyle(i2, i3);
    }

    public void setFooterText(String str) {
        this.mLyricView.setFooterText(str);
    }

    public void setHeaderStyle(int i2, int i3) {
        this.mLyricView.setHeaderStyle(i2, i3);
    }

    public void setHeaderText(String str) {
        this.mLyricView.setHeaderText(str);
    }

    public void setHeaderVisible(boolean z) {
        this.mLyricView.setHeaderVisible(z);
    }

    public void setIsAutoScrollBackToCurrentPosition(boolean z) {
        this.mLyricView.setIsAutoScrollBackToCurrentPosition(z);
    }

    public void setIsBoldText(boolean z) {
        this.mIsCellLayoutValid = false;
        this.mLyricView.setIsBoldText(z);
    }

    public void setLanguage(Language language) {
        this.mIsCellLayoutValid = false;
        this.mLyricView.setLanguage(language);
    }

    public void setLineZoomWithBounceAnim(float f2) {
        this.mIsCellLayoutValid = false;
        this.mLyricView.getAttachInfo().setShowHighLight(false);
        this.mLyricView.setTextHighLightZoom(f2);
        this.mLyricView.setAnimationType(3);
        this.mAnimationCell.setVisibility(0);
        this.mAnimationCell.setTextAnimType(0);
        this.mIsBounceAnimMode = true;
        this.mLyricView.setGLRenderEnable(true);
    }

    public void setLineZoomWithoutBounceAnim(float f2) {
        this.mIsCellLayoutValid = false;
        this.mLyricView.getAttachInfo().setShowHighLight(true);
        this.mLyricView.setGLRenderEnable(false);
        if (this.mAnimationCell.isSurfaceCreated()) {
            this.mAnimationCell.setVisibility(4);
        }
        this.mLyricView.setTextHighLightZoom(f2);
        this.mLyricView.setAnimationType(3);
        this.mAnimationCell.setTextAnimType(1);
        this.mIsBounceAnimMode = false;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void setLyricData(LyricData lyricData) {
        this.mLyricView.setGlRenderNotifyFlag(false);
        this.mLyricView.setLyricData(lyricData);
    }

    public void setLyricMakerInfo(String str, String str2, String str3, int i2) {
        this.mLyricView.setLyricMakerInfo(str, str2, str3, i2);
    }

    public void setLyricMakerLineSpacing(float f2) {
        this.mLyricView.setLyricMakerLineSpacing(f2);
    }

    public void setLyricMakerTextColor(int i2) {
        this.mLyricView.setLyricMakerTextColor(i2);
    }

    public void setMaxRows(int i2) {
        this.mIsCellLayoutValid = false;
        this.mLyricView.setMaxRows(i2);
    }

    public void setMultiTextSize(int i2, int i3, int i4, int i5) {
        this.mLyricView.setMultiTextSize(i2, i3, i4, i5);
        this.mIsCellLayoutValid = false;
    }

    public void setNormalWithBounceAnim() {
        this.mIsCellLayoutValid = false;
        this.mLyricView.setTextHighLightZoom(1.0f);
        this.mAnimationCell.setVisibility(0);
        this.mLyricView.setGLRenderEnable(true);
        this.mLyricView.setAnimationType(1);
        this.mAnimationCell.setTextAnimType(0);
        this.mIsBounceAnimMode = true;
    }

    public void setNormalWithoutAnyAnim() {
        this.mIsCellLayoutValid = false;
        this.mLyricView.getAttachInfo().setShowHighLight(true);
        this.mLyricView.setTextHighLightZoom(1.0f);
        if (this.mAnimationCell.isSurfaceCreated()) {
            this.mAnimationCell.setVisibility(4);
        }
        this.mLyricView.setGLRenderEnable(false);
        this.mLyricView.setAnimationType(1);
        this.mAnimationCell.setTextAnimType(0);
        this.mIsBounceAnimMode = false;
    }

    public void setOnCantoneseClickListener(MultipleLineLyricView.OnCantoneseClickListener onCantoneseClickListener) {
        this.mLyricView.setOnCantoneseClickListener(onCantoneseClickListener);
    }

    public void setOnCellClickListener(BaseLyricView.OnCellClickListener onCellClickListener) {
        this.mLyricView.setOnCellClickListener(onCellClickListener);
    }

    public void setOnCellExposeListener(BaseLyricView.OnCellExposeListener onCellExposeListener) {
        this.mLyricView.setOnCellExposeListener(onCellExposeListener);
    }

    public void setOnCellLongClickListener(BaseLyricView.OnCellLongClickListener onCellLongClickListener) {
        this.mLyricView.setOnCellLongClickListener(onCellLongClickListener);
    }

    public void setOnClickInterceptListener(BaseLyricView.OnClickInterceptListener onClickInterceptListener) {
        this.mLyricView.setOnClickInterceptListener(onClickInterceptListener);
    }

    public void setOnHeaderItemClickListener(MultipleLineLyricView.OnHeaderItemClickListener onHeaderItemClickListener) {
        this.mLyricView.setOnHeaderItemClickListener(onHeaderItemClickListener);
    }

    public void setOnLyricDataLoadListener(BaseLyricView.OnLyricDataLoadListener onLyricDataLoadListener) {
        this.mLyricView.setOnLyricDataLoadListener(onLyricDataLoadListener);
    }

    public void setOnLyricMakerClickListener(MultipleLineLyricView.OnLyricMakerClickListener onLyricMakerClickListener) {
        this.mLyricView.setOnLyricMakerClickListener(onLyricMakerClickListener);
    }

    public void setOnLyricSellExposeListener(MultipleLineLyricView.OnLyricSellExposeListener onLyricSellExposeListener) {
        FadingLyricView fadingLyricView = this.mLyricView;
        if (fadingLyricView != null) {
            fadingLyricView.setOnLyricSellExposeListener(onLyricSellExposeListener);
        }
    }

    public void setOnLyricSlideListener(MultipleLineLyricView.OnLyricSlideListener onLyricSlideListener) {
        this.mLyricView.setOnLyricSlideListener(onLyricSlideListener);
    }

    public void setOnLyricViewBlankAreaClickListener(BaseLyricView.OnLyricViewBlankAreaClickListener onLyricViewBlankAreaClickListener) {
        this.mLyricView.setOnLyricViewBlankAreaClickListener(onLyricViewBlankAreaClickListener);
    }

    public void setOnLyricViewClickListener(BaseLyricView.OnLyricViewClickListener onLyricViewClickListener) {
        this.mLyricView.setOnLyricViewClickListener(onLyricViewClickListener);
    }

    public void setOnNewCellClickListener(BaseLyricView.OnNewCellClickListener onNewCellClickListener) {
        FadingLyricView fadingLyricView = this.mLyricView;
        if (fadingLyricView != null) {
            fadingLyricView.setOnNewCellClickListener(onNewCellClickListener);
        }
    }

    public void setParticleBitmaps(int[] iArr) {
        this.mAnimationCell.setParticleBitmaps(iArr);
        if (this.mLyricView.isGLRenderEnable()) {
            float highLightTextZoomRate = this.mLyricView.getAttachInfo().getHighLightTextZoomRate();
            FadingLyricView fadingLyricView = this.mLyricView;
            onCellGroupUpdated(highLightTextZoomRate, fadingLyricView.checkHasPassPrePlay(fadingLyricView.getAttachInfo().getCurrentHighLightLine()));
        }
    }

    public void setPlayBitmap(Bitmap bitmap) {
        if (getAttachInfo().isShowSelectBgMode()) {
            getAttachInfo().getExtraDrawSpan().setBitmap(bitmap);
        }
    }

    public void setPressColor(int i2) {
        this.mLyricView.setPressColor(i2);
    }

    public void setScaleHighLightWord(boolean z) {
        this.mLyricView.setScaleHighLightWord(z);
    }

    public void setScaleWordAnim(float f2) {
        this.mIsCellLayoutValid = false;
        this.mLyricView.getAttachInfo().setHighLightScaleRate(f2);
        this.mLyricView.getAttachInfo().setShowHighLight(true);
        this.mLyricView.setGLRenderEnable(false);
        this.mAnimationCell.setVisibility(4);
        this.mAnimationCell.setTextAnimType(0);
        this.mIsBounceAnimMode = false;
        this.mLyricView.setTextHighLightZoom(1.0f);
        this.mLyricView.setAnimationType(2);
    }

    public void setScrollOffsetScale(float f2) {
        this.mLyricView.setScrollOffsetScale(f2, false);
    }

    public void setScrollRangeOffset(int i2) {
        this.mLyricView.setScrollRangeOffset(i2);
    }

    public void setSelectedLineColor(int i2) {
        this.mIsCellLayoutValid = false;
        this.mLyricView.setSelectedLineColor(i2);
    }

    public void setSingleLineScrollMode(boolean z) {
        this.mLyricView.setSingleLineScrollMode(z);
    }

    public void setSlideCurTimeStr(String str, long j) {
        if (getAttachInfo().isShowSelectBgMode()) {
            getAttachInfo().getExtraDrawSpan().setCurTimeStr(str, j);
        }
    }

    public void setSpanMaps(Map<Integer, Span>[] mapArr) {
        this.mLyricView.setSpanMaps(mapArr);
    }

    public void setStroke(boolean z) {
        this.mLyricView.setStroke(z);
    }

    public void setStrokePenSize(float f2) {
        this.mLyricView.setStrokePenSize(f2);
    }

    public void setSubLyricMarginTop(int i2) {
        this.mLyricView.setSubLyricMarginTop(i2);
    }

    public void setTextAlign(int i2) {
        this.mIsCellLayoutValid = false;
        this.mLyricView.setCellAlignMode(i2);
        this.mAnimationCell.setTextAlign(i2);
    }

    public void setTextColor(int i2) {
        this.mIsCellLayoutValid = false;
        this.mLyricView.setTextColor(i2);
    }

    public void setTextHighLightColor(int i2) {
        this.mIsCellLayoutValid = false;
        this.mAnimationCell.setHighLightTextColor(i2);
        this.mLyricView.setTextHighLightColor(i2);
    }

    public void setTextHighLightZoom(float f2) {
        this.mLyricView.setTextHighLightZoom(f2);
    }

    public void setTextPlayLineColor(int i2, boolean z) {
        this.mIsCellLayoutValid = false;
        this.mLyricView.setTextPlayLineColor(i2, z);
        this.mAnimationCell.setUnPlayColor(this.mLyricView.getAttachInfo().getTextLineColor());
    }

    public void setTextSize(int i2) {
        this.mIsCellLayoutValid = false;
        this.mLyricView.setTextSize(i2);
    }

    public void setTranslationTextSize(int i2) {
        this.mIsCellLayoutValid = false;
        this.mLyricView.setTranslationTextSize(i2);
    }

    public void setTransliterationTextSize(int i2) {
        this.mIsCellLayoutValid = false;
        this.mLyricView.setTransliterationTextSize(i2);
    }

    public void setTxtLyricNotAutoScroll(boolean z) {
        this.mLyricView.setTxtLyricNotAutoScroll(z);
    }

    public void setTypeface(Typeface typeface) {
        setTypeface(typeface, false);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        this.mIsCellLayoutValid = false;
        this.mLyricView.setVisibility(i2);
        VisibilityListener visibilityListener = this.mVisibilityListener;
        if (visibilityListener != null) {
            visibilityListener.onVisibility(i2);
        }
    }

    public void setVisibilityListener(VisibilityListener visibilityListener) {
        this.mVisibilityListener = visibilityListener;
    }

    public void showSelectBgMode(ExtraDrawSpan extraDrawSpan) {
        getAttachInfo().setExtraDrawSpan(extraDrawSpan);
    }

    @Override // com.kugou.framework.lyric2.ISurLyricSync
    public void syncLyric2(long j) {
        this.mLyricView.syncLyric2(j);
    }

    public MultiLineLyricView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScrollOffsetScale(float f2, boolean z) {
        this.mLyricView.setScrollOffsetScale(f2, z);
    }

    public void setTypeface(Typeface typeface, boolean z) {
        this.mIsCellLayoutValid = false;
        this.mAnimationCell.setAdjustSpecialTypeface(z);
        this.mLyricView.setTypeface(typeface);
    }

    public MultiLineLyricView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.lastCellIndex = -1;
        this.lastLineIndexInCell = -1;
        this.mIsCellLayoutValid = false;
        this.mAnimationCellHeight = -1.0f;
        this.mHighLightWordIndex = 0;
        this.mHighLightWordPercentage = 0;
        this.mGLTextureReleaseWhenDetached = false;
        this.mListener = new SingleLyricCell.TextRenderListener() { // from class: com.kugou.framework.lyricanim.MultiLineLyricView.1
            @Override // com.kugou.framework.lyricanim.SingleLyricCell.TextRenderListener
            public void onGLCreated() {
                MultiLineLyricView.this.post(new Runnable() { // from class: com.kugou.framework.lyricanim.MultiLineLyricView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MultiLineLyricView.this.lastCellIndex = -1;
                        MultiLineLyricView.this.lastLineIndexInCell = -1;
                        if (MultiLineLyricView.this.mLyricView.isGLRenderEnable()) {
                            MultiLineLyricView multiLineLyricView = MultiLineLyricView.this;
                            multiLineLyricView.onCellGroupUpdated(multiLineLyricView.mLyricView.getAttachInfo().getHighLightTextZoomRate(), MultiLineLyricView.this.mLyricView.checkHasPassPrePlay(MultiLineLyricView.this.mLyricView.getAttachInfo().getCurrentHighLightLine()));
                        }
                    }
                });
            }

            @Override // com.kugou.framework.lyricanim.SingleLyricCell.TextRenderListener
            public void onSurfaceTextureDestroy() {
                if (MultiLineLyricView.this.mIsBounceAnimMode) {
                    MultiLineLyricView.this.mAnimationCell.setVisibility(0);
                }
            }

            @Override // com.kugou.framework.lyricanim.SingleLyricCell.TextRenderListener
            public void onTextRenderChanged() {
                if (MultiLineLyricView.this.mIsBounceAnimMode && MultiLineLyricView.this.mLyricView.getGlRenderNotifyFlag()) {
                    MultiLineLyricView.this.mAnimationCell.setVisibility(0);
                    MultiLineLyricView.this.mLyricView.hideHighLightLine();
                }
            }
        };
        FadingLyricView fadingLyricView = new FadingLyricView(context);
        this.mLyricView = fadingLyricView;
        addView(fadingLyricView, new FrameLayout.LayoutParams(-1, -1));
        SingleLyricCell singleLyricCell = new SingleLyricCell(context);
        this.mAnimationCell = singleLyricCell;
        singleLyricCell.setTextRenderListener(this.mListener);
        addView(this.mAnimationCell, new FrameLayout.LayoutParams(-1, -2));
        this.mAnimationCell.setEnabled(false);
        this.mLyricView.setCellGroupListener(this);
    }
}
