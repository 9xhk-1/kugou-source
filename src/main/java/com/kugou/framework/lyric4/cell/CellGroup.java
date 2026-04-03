package com.kugou.framework.lyric4.cell;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.cell.lyric.CantoneseCell;
import com.kugou.framework.lyric4.cell.lyric.EmptyCell;
import com.kugou.framework.lyric4.cell.lyric.LyricMakerCell;
import com.kugou.framework.lyric4.cell.lyric.SingleLineCell;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CellGroup extends Cell {
    public List<Cell> cellList;
    public int currentIndex;
    public int preIndex;
    public int selectLine;
    public boolean showAnimation;

    public CellGroup(Context context) {
        super(context);
        this.cellList = new ArrayList();
        this.showAnimation = false;
    }

    private String getAllCellLyricLine() {
        List<Cell> list = this.cellList;
        if (list == null || list.size() == 0) {
            return "歌词";
        }
        StringBuilder sb = new StringBuilder();
        int size = this.cellList.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(this.cellList.get(i2).getLyricLine());
        }
        return sb.toString();
    }

    private String getCellLyricLine(int i2) {
        Cell childCell = getChildCell(i2);
        return childCell == null ? "歌词" : childCell.getLyricLine();
    }

    public static void updateCellPressedStatus(Cell cell, boolean z, View view) {
        if (cell != null) {
            cell.setPressed(z);
            view.invalidate();
        }
    }

    public void addChildCell(Cell cell) {
        this.cellList.add(cell);
    }

    public void clearSelectCell() {
        this.selectLine = -1;
        int size = this.cellList.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.cellList.get(i2).setShowSelectLine(false);
        }
    }

    public CantoneseCell getCantoneseCell() {
        int size = this.cellList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Cell cell = this.cellList.get(i2);
            if (cell instanceof CantoneseCell) {
                return (CantoneseCell) cell;
            }
        }
        return null;
    }

    public int getCellSize() {
        List<Cell> list = this.cellList;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.cellList.size();
    }

    public Cell getChildCell(int i2) {
        List<Cell> list = this.cellList;
        if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.cellList.size()) {
            return null;
        }
        return this.cellList.get(i2);
    }

    public Cell getChildCellById(int i2) {
        List<Cell> list = this.cellList;
        if (list != null && !list.isEmpty()) {
            for (Cell cell : this.cellList) {
                if (cell.getCellId() == i2) {
                    return cell;
                }
            }
        }
        return null;
    }

    public SingleLineCell getCurrentSingleLineCell() {
        SingleLineCell singleLineCell;
        AttachInfo attachInfo;
        List<Cell> list = this.cellList;
        if (list != null && list.size() != 0) {
            int size = this.cellList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Cell cell = this.cellList.get(i2);
                if ((cell instanceof SingleLineCell) && (attachInfo = (singleLineCell = (SingleLineCell) cell).getAttachInfo()) != null) {
                    if (attachInfo.getCurrentHighLightLine() == singleLineCell.mLine) {
                        return singleLineCell;
                    }
                }
            }
        }
        return null;
    }

    public LyricMakerCell getLyricMakerCell() {
        int size = this.cellList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Cell cell = this.cellList.get(i2);
            if (cell instanceof LyricMakerCell) {
                return (LyricMakerCell) cell;
            }
        }
        return null;
    }

    public String getRightCellLyricLine(int i2) {
        Cell childCell = getChildCell(i2);
        return childCell instanceof CellGroup ? ((CellGroup) childCell).getAllCellLyricLine() : getCellLyricLine(i2);
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public int getSingleLineHeight() {
        List<Cell> list = this.cellList;
        if (list == null || list.isEmpty()) {
            return super.getSingleLineHeight();
        }
        int size = this.cellList.size();
        int singleLineHeight = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Cell cell = this.cellList.get(i2);
            singleLineHeight += cell.getSingleLineHeight() + cell.getMarginTop() + cell.getMarginBottom();
        }
        return singleLineHeight + getPaddingTop() + getPaddingBottom();
    }

    public boolean isEmpty() {
        List<Cell> list = this.cellList;
        return list == null || list.isEmpty();
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public boolean isInBlankArea(float f2, float f3) {
        List<Cell> list = this.cellList;
        if (list != null && !list.isEmpty()) {
            int size = this.cellList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Cell cell = this.cellList.get(i2);
                if (!this.mShowSelectLine && cell.isInBlankArea(f2, f3)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public boolean isInClick(float f2, float f3) {
        return this.mShowSelectLine && isInClickArea(f2, f3);
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public boolean isInClickArea(float f2, float f3) {
        if (!this.mShowSelectLine) {
            return super.isInClickArea(f2, f3);
        }
        RectF rectF = this.mPressRect;
        return rectF.top <= f3 && rectF.bottom >= f3;
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
        int size = this.cellList.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.cellList.get(i2).draw(canvas);
        }
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onDrawAnimation(Canvas canvas, float f2) {
        int size = this.cellList.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.cellList.get(i2).drawAnimation(canvas, f2);
        }
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onLayout(int i2, int i3, int i4, int i5) {
        int size = this.cellList.size();
        int height = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Cell cell = this.cellList.get(i6);
            int marginLeft = cell.getMarginLeft() + i2;
            int marginTop = i3 + height + cell.getMarginTop();
            cell.layout(marginLeft, marginTop, cell.getWidth() + marginLeft, cell.getHeight() + marginTop);
            height = height + cell.getHeight() + cell.getMarginTop() + cell.getMarginBottom();
        }
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onMeasure(int i2, int i3) {
        int size = this.cellList.size();
        int height = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Cell cell = this.cellList.get(i4);
            cell.measure((i2 - getPaddingLeft()) - getPaddingRight(), i3);
            height += cell.getHeight() + cell.getMarginTop() + cell.getMarginBottom();
        }
        setMeasureResult(i2, height + getPaddingTop() + getPaddingBottom());
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onMeasureCell(int i2, int i3, float f2) {
        int size = this.cellList.size();
        int height = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Cell cell = this.cellList.get(i4);
            cell.measureCell((i2 - getPaddingLeft()) - getPaddingRight(), i3, f2);
            height += cell.getHeight() + cell.getMarginTop() + cell.getMarginBottom();
        }
        setMeasureResult(i2, height + getPaddingTop() + getPaddingBottom());
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onMeasureCellWithAnimation(int i2, int i3, float f2) {
        int size = this.cellList.size();
        int height = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Cell cell = this.cellList.get(i4);
            cell.setState(getState());
            cell.measureCellWithAnimation((i2 - getPaddingLeft()) - getPaddingRight(), i3, f2);
            height += cell.getHeight() + cell.getMarginTop() + cell.getMarginBottom();
        }
        setMeasureResult(i2, height + getPaddingTop() + getPaddingBottom());
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void setAlphaValue(int i2) {
        super.setAlphaValue(i2);
        int size = this.cellList.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.cellList.get(i3).setAlphaValue(i2);
        }
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void setAttachInfo(AttachInfo attachInfo) {
        super.setAttachInfo(attachInfo);
        int size = this.cellList.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.cellList.get(i2).setAttachInfo(attachInfo);
        }
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void setParentBottom(int i2) {
        super.setParentBottom(i2);
        List<Cell> list = this.cellList;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.cellList.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.cellList.get(i3).setParentBottom(i2);
        }
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void setParentTop(int i2) {
        super.setParentTop(i2);
        List<Cell> list = this.cellList;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.cellList.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.cellList.get(i3).setParentTop(i2);
        }
    }

    public void setSelectLine(int i2) {
        this.selectLine = i2;
        int size = this.cellList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Cell cell = this.cellList.get(i3);
            if (!(cell instanceof EmptyCell) && cell.getLine() == i2) {
                cell.setShowSelectLine(true);
                return;
            }
        }
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void setShowSelectLine(boolean z) {
        super.setShowSelectLine(z);
        int size = this.cellList.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.cellList.get(i2).setShowSelectLine(z);
        }
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void showHighLight(boolean z) {
        int size = this.cellList.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.cellList.get(i2).showHighLight(z);
        }
        super.showHighLight(z);
    }
}
