package com.kugou.uilib.widget.popupwindow.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class ArrowView extends View {
    private int color;
    private Paint mArrowPaint;
    private Path mArrowPath;
    private int ori;

    public ArrowView(Context context) {
        this(context, null, 0);
    }

    private void init() {
        Paint paint = new Paint();
        this.mArrowPaint = paint;
        paint.setAntiAlias(true);
        this.mArrowPath = new Path();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.mArrowPaint.setStyle(Paint.Style.FILL);
        this.mArrowPaint.setColor(this.color);
        this.mArrowPath.reset();
        int i2 = this.ori;
        if (i2 == 0) {
            this.mArrowPath.setLastPoint(0.0f, getHeight() / 2.0f);
            this.mArrowPath.lineTo(getWidth(), 0.0f);
            this.mArrowPath.lineTo(getWidth(), getHeight());
        } else if (i2 == 1) {
            this.mArrowPath.setLastPoint(0.0f, 0.0f);
            this.mArrowPath.lineTo(0.0f, getHeight());
            this.mArrowPath.lineTo(getWidth(), getHeight() / 2.0f);
        } else if (i2 == 2) {
            this.mArrowPath.setLastPoint(0.0f, getHeight());
            this.mArrowPath.lineTo(getWidth() / 2.0f, 0.0f);
            this.mArrowPath.lineTo(getWidth(), getHeight());
        } else if (i2 == 3) {
            this.mArrowPath.setLastPoint(0.0f, 0.0f);
            this.mArrowPath.lineTo(getWidth() / 2.0f, getHeight());
            this.mArrowPath.lineTo(getWidth(), 0.0f);
        }
        this.mArrowPath.close();
        canvas.drawPath(this.mArrowPath, this.mArrowPaint);
    }

    public void setArrowColor(int i2) {
        this.color = i2;
    }

    public void setOri(int i2) {
        this.ori = i2;
    }

    public ArrowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.ori = 4;
        this.color = -16777216;
        init();
    }
}
