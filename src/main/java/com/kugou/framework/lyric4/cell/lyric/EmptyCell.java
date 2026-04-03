package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Canvas;
import com.kugou.framework.lyric4.cell.Cell;

/* JADX INFO: loaded from: classes2.dex */
public class EmptyCell extends Cell {
    public int mAlignMode;
    public int mExtraHeight;
    public float scrollOffsetScale;

    public EmptyCell(Context context, int i2) {
        super(context);
        this.mAlignMode = 0;
        this.mExtraHeight = i2;
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void drawPressStatus(Canvas canvas) {
    }

    public int getAlignMode() {
        return this.mAlignMode;
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public boolean isInClickArea(float f2, float f3) {
        return false;
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onDrawAnimation(Canvas canvas, float f2) {
        onDraw(canvas);
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onLayout(int i2, int i3, int i4, int i5) {
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onMeasure(int i2, int i3) {
        if (this.scrollOffsetScale <= 0.0f) {
            this.scrollOffsetScale = 2.0f;
        }
        setMeasureResult(i2, (int) ((i3 / this.scrollOffsetScale) - this.mExtraHeight));
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onMeasureCell(int i2, int i3, float f2) {
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public void onMeasureCellWithAnimation(int i2, int i3, float f2) {
    }

    public void setAlignMode(int i2) {
        this.mAlignMode = i2;
    }

    public EmptyCell(Context context, int i2, float f2) {
        this(context, i2);
        this.scrollOffsetScale = f2;
    }
}
