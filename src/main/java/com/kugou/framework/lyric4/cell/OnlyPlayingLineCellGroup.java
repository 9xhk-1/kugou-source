package com.kugou.framework.lyric4.cell;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class OnlyPlayingLineCellGroup extends RestrictedDrawCellGroup {
    public OnlyPlayingLineCellGroup(Context context, View view) {
        super(context, view);
    }

    private int getAlphaValue(Cell cell) {
        return ((double) ((((float) Math.abs((cell.getCellRect().centerY() - this.mParentView.getScrollY()) - (this.mParentView.getHeight() / 2))) * 1.0f) / ((float) this.mParentView.getHeight()))) > 0.25d ? 0 : 255;
    }

    @Override // com.kugou.framework.lyric4.cell.RestrictedDrawCellGroup, com.kugou.framework.lyric4.cell.CellGroup, com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.cellList.size(); i2++) {
            Cell cell = this.cellList.get(i2);
            cell.setParentLeft(this.mParentView.getLeft());
            cell.setParentRight(this.mParentView.getRight());
            cell.setParentTop(this.mParentView.getScrollY());
            cell.setParentBottom(this.mParentView.getScrollY() + this.mParentView.getHeight());
            int alphaValue = cell.getAlphaValue();
            cell.setAlphaValue(getAlphaValue(cell));
            cell.draw(canvas);
            cell.setAlphaValue(alphaValue);
        }
    }

    @Override // com.kugou.framework.lyric4.cell.CellGroup, com.kugou.framework.lyric4.cell.Cell
    public void onDrawAnimation(Canvas canvas, float f2) {
        for (Cell cell : this.cellList) {
            cell.setParentTop(this.mParentView.getScrollY());
            cell.setParentBottom(this.mParentView.getScrollY() + this.mParentView.getHeight());
            int alphaValue = cell.getAlphaValue();
            cell.setAlphaValue(getAlphaValue(cell));
            if (cell.getLine() == this.preIndex) {
                cell.drawAnimation(canvas, 1.0f / f2);
            } else if (cell.getLine() == this.currentIndex) {
                cell.drawAnimation(canvas, f2);
            } else {
                cell.drawAnimation(canvas, 1.0f);
            }
            cell.setAlphaValue(alphaValue);
        }
    }

    @Override // com.kugou.framework.lyric4.cell.CellGroup, com.kugou.framework.lyric4.cell.Cell
    public void onMeasureCellWithAnimation(int i2, int i3, float f2) {
        int height = 0;
        for (Cell cell : this.cellList) {
            if (cell.getLine() == this.preIndex) {
                cell.setState(State.ZOOM_OUT);
            } else if (cell.getLine() == this.currentIndex) {
                cell.setState(State.ZOOM_IN);
            } else {
                cell.setState(State.STANDARD);
            }
            cell.measureCellWithAnimation((i2 - getPaddingLeft()) - getPaddingRight(), i3, f2);
            height += cell.getHeight() + cell.getMarginTop() + cell.getMarginBottom();
        }
        setMeasureResult(i2, height + getPaddingTop() + getPaddingBottom());
    }
}
