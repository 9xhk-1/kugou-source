package com.kugou.framework.lyric4.cell;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class TransparentGradientCellGroup extends RestrictedDrawCellGroup {
    private float alphaCellValue;

    public TransparentGradientCellGroup(Context context, View view, float f2) {
        super(context, view);
        this.alphaCellValue = 1.3f;
        this.alphaCellValue = f2;
    }

    private int getAlphaValue(Cell cell) {
        float fAbs = (Math.abs((cell.getCellRect().centerY() - this.mParentView.getScrollY()) - (this.mParentView.getHeight() / 2)) * 1.0f) / (this.mParentView.getHeight() * this.alphaCellValue);
        if (fAbs > 0.9f) {
            fAbs = 0.9f;
        }
        if (fAbs < 0.0f) {
            fAbs = 0.0f;
        }
        int i2 = (int) (255.0f - (fAbs * 255.0f));
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }

    @Override // com.kugou.framework.lyric4.cell.RestrictedDrawCellGroup, com.kugou.framework.lyric4.cell.CellGroup, com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.cellList.size(); i2++) {
            Cell cell = this.cellList.get(i2);
            cell.setParentLeft(this.mParentView.getLeft());
            cell.setParentRight(this.mParentView.getRight());
            cell.setParentTop(getParentScrollYDis());
            cell.setParentBottom(getParentScrollYDis() + this.mParentView.getHeight());
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
