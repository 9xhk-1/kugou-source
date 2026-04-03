package com.kugou.framework.lyric4.cell;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import com.kugou.framework.lyric4.cell.lyric.EmptyCell;

/* JADX INFO: loaded from: classes2.dex */
public class RestrictedDrawCellGroup extends CellGroup {
    public View mParentView;
    public int pinTopExtra;

    public RestrictedDrawCellGroup(Context context, View view) {
        super(context);
        this.mParentView = view;
    }

    public int getParentScrollYDis() {
        return this.mParentView.getScrollY() - this.pinTopExtra;
    }

    public int getPinTopExtra() {
        return this.pinTopExtra;
    }

    public boolean isAlwaysNeedDraw(Cell cell) {
        return cell instanceof EmptyCell;
    }

    public boolean isInViewRange(Rect rect) {
        return this.mParentView.getScrollY() <= rect.bottom && rect.top <= this.mParentView.getScrollY() + this.mParentView.getHeight() && rect.top >= this.mParentView.getScrollY();
    }

    @Override // com.kugou.framework.lyric4.cell.CellGroup, com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
        for (Cell cell : this.cellList) {
            cell.setParentLeft(this.mParentView.getLeft());
            cell.setParentRight(this.mParentView.getRight());
            cell.setParentTop(getParentScrollYDis());
            cell.setParentBottom(getParentScrollYDis() + this.mParentView.getHeight());
            cell.draw(canvas);
        }
    }

    public void setPinTopExtra(int i2) {
        this.pinTopExtra = i2;
    }
}
