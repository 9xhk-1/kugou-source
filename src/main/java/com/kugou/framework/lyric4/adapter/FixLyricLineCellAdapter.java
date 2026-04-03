package com.kugou.framework.lyric4.adapter;

import android.content.Context;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.loader.language.Language;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.cell.Cell;
import com.kugou.framework.lyric4.cell.CellGroup;
import com.kugou.framework.lyric4.cell.lyric.BaseLyricCell;
import com.kugou.framework.lyric4.cell.lyric.ScaleWordSingleLineCell;
import com.kugou.framework.lyric4.cell.lyric.SingleLineCell;
import com.kugou.framework.lyric4.cell.lyric.SingleLineHighLightCell;
import com.kugou.framework.lyric4.cell.lyric.SingleLineLrcCell;
import com.kugou.framework.lyric4.cell.lyric.TxtNoSupportCell;

/* JADX INFO: loaded from: classes2.dex */
public class FixLyricLineCellAdapter implements CellAdapter<String[]> {
    private AttachInfo mAttachInfo;
    private Context mContext;
    private LyricData mLyricData;

    public FixLyricLineCellAdapter(Context context, LyricData lyricData, AttachInfo attachInfo) {
        this.mContext = context;
        this.mAttachInfo = attachInfo;
        this.mLyricData = lyricData;
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
        Cell cell;
        if (this.mLyricData.getLyricType() == 1) {
            Language language = this.mAttachInfo.getLanguage();
            Language language2 = Language.Origin;
            if (language == language2) {
                BaseLyricCell scaleWordSingleLineCell = this.mAttachInfo.isScaleHighLightWord() ? new ScaleWordSingleLineCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2) : new SingleLineHighLightCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                scaleWordSingleLineCell.setPressColor(this.mAttachInfo.getPressColor());
                scaleWordSingleLineCell.setShowingLanguage(language2);
                setCellAlignMode(this.mAttachInfo, scaleWordSingleLineCell, i2);
                cell = scaleWordSingleLineCell;
            } else {
                Language language3 = this.mAttachInfo.getLanguage();
                Language language4 = Language.Translation;
                if (language3 == language4 && isTranslationExist(this.mLyricData)) {
                    CellGroup cellGroup = new CellGroup(this.mContext);
                    cellGroup.setPressColor(this.mAttachInfo.getPressColor());
                    BaseLyricCell scaleWordSingleLineCell2 = this.mAttachInfo.isScaleHighLightWord() ? new ScaleWordSingleLineCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2) : new SingleLineHighLightCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                    setCellAlignMode(this.mAttachInfo, scaleWordSingleLineCell2, i2);
                    scaleWordSingleLineCell2.setShowingLanguage(language2);
                    SingleLineCell singleLineCell = new SingleLineCell(this.mContext, this.mLyricData.getTranslateWords()[i2], this.mAttachInfo, i2, true);
                    setCellAlignMode(this.mAttachInfo, singleLineCell, i2);
                    singleLineCell.setShowingLanguage(language4);
                    singleLineCell.setMarginTop(this.mAttachInfo.getSubLyricMarginTop());
                    cellGroup.addChildCell(scaleWordSingleLineCell2);
                    cellGroup.addChildCell(singleLineCell);
                    cell = cellGroup;
                } else {
                    Language language5 = this.mAttachInfo.getLanguage();
                    Language language6 = Language.Transliteration;
                    if (language5 == language6 && isTransliterationExist(this.mLyricData)) {
                        CellGroup cellGroup2 = new CellGroup(this.mContext);
                        cellGroup2.setPressColor(this.mAttachInfo.getPressColor());
                        BaseLyricCell scaleWordSingleLineCell3 = this.mAttachInfo.isScaleHighLightWord() ? new ScaleWordSingleLineCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2) : new SingleLineHighLightCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                        setCellAlignMode(this.mAttachInfo, scaleWordSingleLineCell3, i2);
                        scaleWordSingleLineCell3.setShowingLanguage(language2);
                        SingleLineHighLightCell singleLineHighLightCell = new SingleLineHighLightCell(this.mContext, this.mLyricData.getTransliterationWords()[i2], this.mAttachInfo, i2);
                        setCellAlignMode(this.mAttachInfo, singleLineHighLightCell, i2);
                        singleLineHighLightCell.setShowingLanguage(language6);
                        singleLineHighLightCell.setMarginTop(this.mAttachInfo.getSubLyricMarginTop());
                        cellGroup2.addChildCell(scaleWordSingleLineCell3);
                        cellGroup2.addChildCell(singleLineHighLightCell);
                        cell = cellGroup2;
                    } else {
                        Language language7 = this.mAttachInfo.getLanguage();
                        Language language8 = Language.Chinese;
                        if (language7 == language8 && isChineseExist(this.mLyricData)) {
                            CellGroup cellGroup3 = new CellGroup(this.mContext);
                            cellGroup3.setPressColor(this.mAttachInfo.getPressColor());
                            BaseLyricCell scaleWordSingleLineCell4 = this.mAttachInfo.isScaleHighLightWord() ? new ScaleWordSingleLineCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2) : new SingleLineHighLightCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                            setCellAlignMode(this.mAttachInfo, scaleWordSingleLineCell4, i2);
                            scaleWordSingleLineCell4.setShowingLanguage(language2);
                            SingleLineHighLightCell singleLineHighLightCell2 = new SingleLineHighLightCell(this.mContext, this.mLyricData.getChineseWords()[i2], this.mAttachInfo, i2);
                            setCellAlignMode(this.mAttachInfo, singleLineHighLightCell2, i2);
                            singleLineHighLightCell2.setShowingLanguage(language8);
                            singleLineHighLightCell2.setMarginTop(this.mAttachInfo.getSubLyricMarginTop());
                            cellGroup3.addChildCell(scaleWordSingleLineCell4);
                            cellGroup3.addChildCell(singleLineHighLightCell2);
                            cell = cellGroup3;
                        } else {
                            BaseLyricCell scaleWordSingleLineCell5 = this.mAttachInfo.isScaleHighLightWord() ? new ScaleWordSingleLineCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2) : new SingleLineHighLightCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                            scaleWordSingleLineCell5.setPressColor(this.mAttachInfo.getPressColor());
                            scaleWordSingleLineCell5.setShowingLanguage(language2);
                            setCellAlignMode(this.mAttachInfo, scaleWordSingleLineCell5, i2);
                            cell = scaleWordSingleLineCell5;
                        }
                    }
                }
            }
        } else if (this.mLyricData.getLyricType() == 2) {
            Language language9 = this.mAttachInfo.getLanguage();
            Language language10 = Language.Translation;
            if (language9 == language10 && isTranslationExist(this.mLyricData)) {
                CellGroup cellGroup4 = new CellGroup(this.mContext);
                cellGroup4.setPressColor(this.mAttachInfo.getPressColor());
                SingleLineLrcCell singleLineLrcCell = new SingleLineLrcCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                setCellAlignMode(this.mAttachInfo, singleLineLrcCell, i2);
                singleLineLrcCell.setShowingLanguage(Language.Origin);
                SingleLineCell singleLineCell2 = new SingleLineCell(this.mContext, this.mLyricData.getTranslateWords()[i2], this.mAttachInfo, i2);
                setCellAlignMode(this.mAttachInfo, singleLineCell2, i2);
                singleLineCell2.setShowingLanguage(language10);
                singleLineCell2.setMarginTop(this.mAttachInfo.getSubLyricMarginTop());
                cellGroup4.addChildCell(singleLineLrcCell);
                cellGroup4.addChildCell(singleLineCell2);
                cell = cellGroup4;
            } else {
                Language language11 = this.mAttachInfo.getLanguage();
                Language language12 = Language.Transliteration;
                if (language11 == language12 && isTransliterationExist(this.mLyricData)) {
                    CellGroup cellGroup5 = new CellGroup(this.mContext);
                    cellGroup5.setPressColor(this.mAttachInfo.getPressColor());
                    SingleLineLrcCell singleLineLrcCell2 = new SingleLineLrcCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                    setCellAlignMode(this.mAttachInfo, singleLineLrcCell2, i2);
                    singleLineLrcCell2.setShowingLanguage(Language.Origin);
                    SingleLineCell singleLineCell3 = new SingleLineCell(this.mContext, this.mLyricData.getTransliterationWords()[i2], this.mAttachInfo, i2);
                    setCellAlignMode(this.mAttachInfo, singleLineCell3, i2);
                    singleLineCell3.setShowingLanguage(language12);
                    singleLineCell3.setMarginTop(this.mAttachInfo.getSubLyricMarginTop());
                    cellGroup5.addChildCell(singleLineLrcCell2);
                    cellGroup5.addChildCell(singleLineCell3);
                    cell = cellGroup5;
                } else {
                    Language language13 = this.mAttachInfo.getLanguage();
                    Language language14 = Language.Chinese;
                    if (language13 == language14 && isChineseExist(this.mLyricData)) {
                        CellGroup cellGroup6 = new CellGroup(this.mContext);
                        cellGroup6.setPressColor(this.mAttachInfo.getPressColor());
                        SingleLineLrcCell singleLineLrcCell3 = new SingleLineLrcCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                        setCellAlignMode(this.mAttachInfo, singleLineLrcCell3, i2);
                        singleLineLrcCell3.setShowingLanguage(Language.Origin);
                        SingleLineCell singleLineCell4 = new SingleLineCell(this.mContext, this.mLyricData.getChineseWords()[i2], this.mAttachInfo, i2);
                        setCellAlignMode(this.mAttachInfo, singleLineCell4, i2);
                        singleLineCell4.setShowingLanguage(language14);
                        singleLineCell4.setMarginTop(this.mAttachInfo.getSubLyricMarginTop());
                        cellGroup6.addChildCell(singleLineLrcCell3);
                        cellGroup6.addChildCell(singleLineCell4);
                        cell = cellGroup6;
                    } else {
                        SingleLineLrcCell singleLineLrcCell4 = new SingleLineLrcCell(this.mContext, this.mLyricData.getWords()[i2], this.mAttachInfo, i2);
                        singleLineLrcCell4.setPressColor(this.mAttachInfo.getPressColor());
                        singleLineLrcCell4.setShowingLanguage(Language.Origin);
                        setCellAlignMode(this.mAttachInfo, singleLineLrcCell4, i2);
                        cell = singleLineLrcCell4;
                    }
                }
            }
        } else if (this.mLyricData.getLyricType() == 3) {
            TxtNoSupportCell txtNoSupportCell = new TxtNoSupportCell(this.mContext, this.mAttachInfo);
            txtNoSupportCell.setPressColor(this.mAttachInfo.getPressColor());
            txtNoSupportCell.setShowingLanguage(Language.Origin);
            setCellAlignMode(this.mAttachInfo, txtNoSupportCell, i2);
            cell = txtNoSupportCell;
        } else {
            cell = null;
        }
        if (cell != null) {
            cell.setPaddingTop(this.mAttachInfo.getCellRowMargin() / 2);
            cell.setPaddingBottom(this.mAttachInfo.getCellRowMargin() / 2);
        }
        return cell;
    }

    @Override // com.kugou.framework.lyric4.adapter.CellAdapter
    public int getCount() {
        if (this.mLyricData.getLyricType() == 3) {
            return 1;
        }
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
