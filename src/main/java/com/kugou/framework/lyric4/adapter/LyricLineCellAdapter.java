package com.kugou.framework.lyric4.adapter;

import android.content.Context;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.loader.language.Language;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.cell.Cell;
import com.kugou.framework.lyric4.cell.CellGroup;
import com.kugou.framework.lyric4.cell.lyric.BaseLyricCell;
import com.kugou.framework.lyric4.cell.lyric.ScaleWordWrapLineCell;
import com.kugou.framework.lyric4.cell.lyric.WrapLineCell;
import com.kugou.framework.lyric4.cell.lyric.WrapLineHighLightCell;
import com.kugou.framework.lyric4.cell.lyric.WrapLineLrcCell;
import com.kugou.framework.lyric4.cell.lyric.WrapLineTransliterationCell;
import com.kugou.framework.lyric4.utils.SplitLyricStringUtils;

/* JADX INFO: loaded from: classes2.dex */
public class LyricLineCellAdapter implements CellAdapter<String[]> {
    private AttachInfo mAttachInfo;
    private Context mContext;
    private LyricData mLyricData;

    public LyricLineCellAdapter(Context context, LyricData lyricData, AttachInfo attachInfo) {
        this.mContext = context;
        this.mLyricData = lyricData;
        this.mAttachInfo = attachInfo;
    }

    private boolean isChineseExist(LyricData lyricData) {
        return lyricData.getChineseWords() != null && lyricData.getChineseWords().length > 0;
    }

    private boolean isTranslationExist(LyricData lyricData) {
        return lyricData.getTranslateWords() != null && lyricData.getTranslateWords().length > 0;
    }

    private boolean isTransliterationExist(LyricData lyricData) {
        return lyricData.getTransliterationWords() != null && lyricData.getTransliterationWords().length > 0;
    }

    private void setCellAlignMode(AttachInfo attachInfo, BaseLyricCell baseLyricCell, int i2) {
        if (attachInfo.getCellAlignMode() == 0) {
            baseLyricCell.setAlignMode(0);
            return;
        }
        if (attachInfo.getCellAlignMode() == 1) {
            baseLyricCell.setAlignMode(1);
            return;
        }
        if (attachInfo.getCellAlignMode() == 2) {
            baseLyricCell.setAlignMode(2);
        } else if (attachInfo.getCellAlignMode() == 3) {
            if (i2 % 2 == 0) {
                baseLyricCell.setAlignMode(1);
            } else {
                baseLyricCell.setAlignMode(2);
            }
        }
    }

    @Override // com.kugou.framework.lyric4.adapter.CellAdapter
    public Cell getCell(int i2) {
        CellGroup cellGroup = new CellGroup(this.mContext);
        cellGroup.setPressColor(this.mAttachInfo.getPressColor());
        if (this.mLyricData.getLyricType() == 1) {
            Language language = this.mAttachInfo.getLanguage();
            Language language2 = Language.Origin;
            if (language == language2) {
                WrapLineCell scaleWordWrapLineCell = this.mAttachInfo.isScaleHighLightWord() ? new ScaleWordWrapLineCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2) : new WrapLineHighLightCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                scaleWordWrapLineCell.setLineSpacing(this.mAttachInfo.getLineSpacing());
                scaleWordWrapLineCell.setPressColor(this.mAttachInfo.getPressColor());
                scaleWordWrapLineCell.setShowingLanguage(language2);
                setCellAlignMode(this.mAttachInfo, scaleWordWrapLineCell, i2);
                cellGroup.addChildCell(scaleWordWrapLineCell);
                cellGroup.setLine(i2);
            } else {
                Language language3 = this.mAttachInfo.getLanguage();
                Language language4 = Language.Translation;
                if (language3 == language4 && isTranslationExist(this.mLyricData)) {
                    WrapLineCell scaleWordWrapLineCell2 = this.mAttachInfo.isScaleHighLightWord() ? new ScaleWordWrapLineCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2) : new WrapLineHighLightCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                    scaleWordWrapLineCell2.setLineSpacing(this.mAttachInfo.getLineSpacing());
                    setCellAlignMode(this.mAttachInfo, scaleWordWrapLineCell2, i2);
                    scaleWordWrapLineCell2.setShowingLanguage(language2);
                    if (this.mLyricData.getTranslateWords()[i2] == null) {
                        this.mLyricData.getTranslateWords()[i2] = new String[]{""};
                    }
                    WrapLineCell wrapLineCell = this.mLyricData.getTranslateWords()[i2].length == 1 ? new WrapLineCell(this.mContext, SplitLyricStringUtils.splitLyricString(this.mLyricData.getTranslateWords()[i2][0]), this.mAttachInfo, i2) : new WrapLineCell(this.mContext, this.mLyricData.getTranslateWords()[i2], this.mAttachInfo, i2);
                    wrapLineCell.setTransCell(true);
                    wrapLineCell.setLineSpacing(this.mAttachInfo.getLineSpacing());
                    wrapLineCell.setMarginTop(this.mAttachInfo.getSubLyricMarginTop());
                    wrapLineCell.setShowingLanguage(language4);
                    setCellAlignMode(this.mAttachInfo, wrapLineCell, i2);
                    cellGroup.addChildCell(scaleWordWrapLineCell2);
                    cellGroup.addChildCell(wrapLineCell);
                    cellGroup.setLine(i2);
                } else {
                    Language language5 = this.mAttachInfo.getLanguage();
                    Language language6 = Language.Transliteration;
                    if (language5 == language6 && isTransliterationExist(this.mLyricData)) {
                        WrapLineCell scaleWordWrapLineCell3 = this.mAttachInfo.isScaleHighLightWord() ? new ScaleWordWrapLineCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2) : new WrapLineHighLightCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                        scaleWordWrapLineCell3.setLineSpacing(this.mAttachInfo.getLineSpacing());
                        scaleWordWrapLineCell3.setShowingLanguage(language2);
                        setCellAlignMode(this.mAttachInfo, scaleWordWrapLineCell3, i2);
                        WrapLineTransliterationCell wrapLineTransliterationCell = new WrapLineTransliterationCell(this.mContext, this.mLyricData.getTransliterationWords()[i2], this.mAttachInfo, i2);
                        wrapLineTransliterationCell.setLineSpacing(this.mAttachInfo.getLineSpacing());
                        setCellAlignMode(this.mAttachInfo, wrapLineTransliterationCell, i2);
                        wrapLineTransliterationCell.setShowingLanguage(language6);
                        wrapLineTransliterationCell.setMarginTop(this.mAttachInfo.getSubLyricMarginTop());
                        cellGroup.addChildCell(scaleWordWrapLineCell3);
                        cellGroup.addChildCell(wrapLineTransliterationCell);
                        cellGroup.setLine(i2);
                    } else {
                        Language language7 = this.mAttachInfo.getLanguage();
                        Language language8 = Language.Chinese;
                        if (language7 == language8 && isChineseExist(this.mLyricData)) {
                            WrapLineCell scaleWordWrapLineCell4 = this.mAttachInfo.isScaleHighLightWord() ? new ScaleWordWrapLineCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2) : new WrapLineHighLightCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                            scaleWordWrapLineCell4.setLineSpacing(this.mAttachInfo.getLineSpacing());
                            scaleWordWrapLineCell4.setShowingLanguage(language2);
                            setCellAlignMode(this.mAttachInfo, scaleWordWrapLineCell4, i2);
                            WrapLineTransliterationCell wrapLineTransliterationCell2 = new WrapLineTransliterationCell(this.mContext, this.mLyricData.getChineseWords()[i2], this.mAttachInfo, i2);
                            wrapLineTransliterationCell2.setLineSpacing(this.mAttachInfo.getLineSpacing());
                            setCellAlignMode(this.mAttachInfo, wrapLineTransliterationCell2, i2);
                            wrapLineTransliterationCell2.setShowingLanguage(language8);
                            wrapLineTransliterationCell2.setMarginTop(this.mAttachInfo.getSubLyricMarginTop());
                            cellGroup.addChildCell(scaleWordWrapLineCell4);
                            cellGroup.addChildCell(wrapLineTransliterationCell2);
                            cellGroup.setLine(i2);
                        } else {
                            WrapLineCell scaleWordWrapLineCell5 = this.mAttachInfo.isScaleHighLightWord() ? new ScaleWordWrapLineCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2) : new WrapLineHighLightCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                            scaleWordWrapLineCell5.setPressColor(this.mAttachInfo.getPressColor());
                            scaleWordWrapLineCell5.setLineSpacing(this.mAttachInfo.getLineSpacing());
                            scaleWordWrapLineCell5.setShowingLanguage(language2);
                            setCellAlignMode(this.mAttachInfo, scaleWordWrapLineCell5, i2);
                            cellGroup.addChildCell(scaleWordWrapLineCell5);
                            cellGroup.setLine(i2);
                        }
                    }
                }
            }
        } else if (this.mLyricData.getLyricType() == 2) {
            Language language9 = this.mAttachInfo.getLanguage();
            Language language10 = Language.Translation;
            if (language9 == language10 && isTranslationExist(this.mLyricData)) {
                WrapLineLrcCell wrapLineLrcCell = new WrapLineLrcCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                wrapLineLrcCell.setLineSpacing(this.mAttachInfo.getLineSpacing());
                setCellAlignMode(this.mAttachInfo, wrapLineLrcCell, i2);
                wrapLineLrcCell.setShowingLanguage(Language.Origin);
                if (this.mLyricData.getTranslateWords()[i2] == null) {
                    this.mLyricData.getTranslateWords()[i2] = new String[]{""};
                }
                WrapLineCell wrapLineCell2 = this.mLyricData.getTranslateWords()[i2].length == 1 ? new WrapLineCell(this.mContext, SplitLyricStringUtils.splitLyricString(this.mLyricData.getTranslateWords()[i2][0]), this.mAttachInfo, i2) : new WrapLineCell(this.mContext, this.mLyricData.getTranslateWords()[i2], this.mAttachInfo, i2);
                wrapLineCell2.setTransCell(true);
                wrapLineCell2.setLineSpacing(this.mAttachInfo.getLineSpacing());
                wrapLineCell2.setMarginTop(this.mAttachInfo.getSubLyricMarginTop());
                wrapLineCell2.setShowingLanguage(language10);
                setCellAlignMode(this.mAttachInfo, wrapLineCell2, i2);
                cellGroup.addChildCell(wrapLineLrcCell);
                cellGroup.addChildCell(wrapLineCell2);
                cellGroup.setLine(i2);
            } else {
                Language language11 = this.mAttachInfo.getLanguage();
                Language language12 = Language.Transliteration;
                if (language11 == language12 && isTransliterationExist(this.mLyricData)) {
                    WrapLineLrcCell wrapLineLrcCell2 = new WrapLineLrcCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                    wrapLineLrcCell2.setLineSpacing(this.mAttachInfo.getLineSpacing());
                    wrapLineLrcCell2.setShowingLanguage(Language.Origin);
                    setCellAlignMode(this.mAttachInfo, wrapLineLrcCell2, i2);
                    WrapLineCell wrapLineCell3 = new WrapLineCell(this.mContext, this.mLyricData.getTransliterationWords()[i2], this.mAttachInfo, i2);
                    wrapLineCell3.setTransCell(true);
                    wrapLineCell3.setLineSpacing(this.mAttachInfo.getLineSpacing());
                    setCellAlignMode(this.mAttachInfo, wrapLineCell3, i2);
                    wrapLineCell3.setShowingLanguage(language12);
                    wrapLineCell3.setMarginTop(this.mAttachInfo.getSubLyricMarginTop());
                    cellGroup.addChildCell(wrapLineLrcCell2);
                    cellGroup.addChildCell(wrapLineCell3);
                    cellGroup.setLine(i2);
                } else {
                    Language language13 = this.mAttachInfo.getLanguage();
                    Language language14 = Language.Chinese;
                    if (language13 == language14 && isChineseExist(this.mLyricData)) {
                        WrapLineLrcCell wrapLineLrcCell3 = new WrapLineLrcCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                        wrapLineLrcCell3.setLineSpacing(this.mAttachInfo.getLineSpacing());
                        wrapLineLrcCell3.setShowingLanguage(Language.Origin);
                        setCellAlignMode(this.mAttachInfo, wrapLineLrcCell3, i2);
                        WrapLineCell wrapLineCell4 = new WrapLineCell(this.mContext, this.mLyricData.getChineseWords()[i2], this.mAttachInfo, i2);
                        wrapLineCell4.setTransCell(true);
                        wrapLineCell4.setLineSpacing(this.mAttachInfo.getLineSpacing());
                        setCellAlignMode(this.mAttachInfo, wrapLineCell4, i2);
                        wrapLineCell4.setShowingLanguage(language14);
                        wrapLineCell4.setMarginTop(this.mAttachInfo.getSubLyricMarginTop());
                        cellGroup.addChildCell(wrapLineLrcCell3);
                        cellGroup.addChildCell(wrapLineCell4);
                        cellGroup.setLine(i2);
                    } else {
                        WrapLineLrcCell wrapLineLrcCell4 = new WrapLineLrcCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                        wrapLineLrcCell4.setPressColor(this.mAttachInfo.getPressColor());
                        wrapLineLrcCell4.setLineSpacing(this.mAttachInfo.getLineSpacing());
                        wrapLineLrcCell4.setShowingLanguage(Language.Origin);
                        setCellAlignMode(this.mAttachInfo, wrapLineLrcCell4, i2);
                        cellGroup.addChildCell(wrapLineLrcCell4);
                        cellGroup.setLine(i2);
                    }
                }
            }
        } else if (this.mLyricData.getLyricType() == 3) {
            WrapLineCell wrapLineCell5 = new WrapLineCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
            wrapLineCell5.setPressColor(this.mAttachInfo.getPressColor());
            wrapLineCell5.setLineSpacing(this.mAttachInfo.getLineSpacing());
            wrapLineCell5.setShowingLanguage(Language.Origin);
            setCellAlignMode(this.mAttachInfo, wrapLineCell5, i2);
            cellGroup.addChildCell(wrapLineCell5);
            cellGroup.setLine(i2);
        }
        cellGroup.setPaddingTop(this.mAttachInfo.getCellRowMargin() / 2);
        cellGroup.setPaddingBottom(this.mAttachInfo.getCellRowMargin() / 2);
        return cellGroup;
    }

    @Override // com.kugou.framework.lyric4.adapter.CellAdapter
    public int getCount() {
        if (this.mLyricData.getWords() == null) {
            return 0;
        }
        return this.mLyricData.getWords().length;
    }

    @Override // com.kugou.framework.lyric4.adapter.CellAdapter
    public String[] getItem(int i2) {
        return this.mLyricData.getWords()[i2];
    }
}
