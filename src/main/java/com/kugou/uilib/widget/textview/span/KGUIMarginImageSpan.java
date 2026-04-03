package com.kugou.uilib.widget.textview.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIMarginImageSpan extends KGUIAlignMiddleImageSpan {
    private int mOffsetY;
    private int mSpanMarginLeft;
    private int mSpanMarginRight;

    public KGUIMarginImageSpan(Drawable drawable, int i2, int i3, int i4) {
        this(drawable, i2, i3, i4, 0);
    }

    @Override // com.kugou.uilib.widget.textview.span.KGUIAlignMiddleImageSpan, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.mOffsetY);
        super.draw(canvas, charSequence, i2, i3, f2 + this.mSpanMarginLeft, i4, i5, i6, paint);
        canvas.restore();
    }

    @Override // com.kugou.uilib.widget.textview.span.KGUIAlignMiddleImageSpan, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        if (this.mSpanMarginLeft == 0 && this.mSpanMarginRight == 0) {
            return super.getSize(paint, charSequence, i2, i3, fontMetricsInt);
        }
        super.getSize(paint, charSequence, i2, i3, fontMetricsInt);
        return getDrawable().getIntrinsicWidth() + this.mSpanMarginLeft + this.mSpanMarginRight;
    }

    public KGUIMarginImageSpan(Drawable drawable, int i2, int i3, int i4, int i5) {
        super(drawable, i2);
        this.mSpanMarginLeft = 0;
        this.mSpanMarginRight = 0;
        this.mOffsetY = 0;
        this.mSpanMarginLeft = i3;
        this.mSpanMarginRight = i4;
        this.mOffsetY = i5;
    }
}
