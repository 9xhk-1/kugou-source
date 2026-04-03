package com.kugou.uilib.widget.textview.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class KGUITextSizeSpan extends ReplacementSpan {
    private Paint mPaint;
    private int mTextSize;
    private Typeface mTypeface;
    private int mVerticalOffset;

    public KGUITextSizeSpan(int i2, int i3) {
        this(i2, i3, null);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
        canvas.drawText(charSequence, i2, i3, f2, i5 + this.mVerticalOffset, this.mPaint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        Paint paint2 = new Paint(paint);
        this.mPaint = paint2;
        paint2.setTextSize(this.mTextSize);
        this.mPaint.setTypeface(this.mTypeface);
        if (this.mTextSize > paint.getTextSize() && fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = this.mPaint.getFontMetricsInt();
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return (int) this.mPaint.measureText(charSequence, i2, i3);
    }

    public KGUITextSizeSpan(int i2, int i3, Typeface typeface) {
        this.mTextSize = i2;
        this.mVerticalOffset = i3;
        this.mTypeface = typeface;
    }
}
