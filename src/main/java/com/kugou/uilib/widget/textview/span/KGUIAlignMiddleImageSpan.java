package com.kugou.uilib.widget.textview.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIAlignMiddleImageSpan extends ImageSpan {
    public static final int ALIGN_MIDDLE = -100;
    private boolean mAvoidSuperChangeFontMetrics;
    private Drawable mDrawable;
    private int mDrawableTintColorAttr;
    private float mFontWidthMultiple;
    private int mWidth;

    public KGUIAlignMiddleImageSpan(Drawable drawable, int i2) {
        this(drawable, i2, 0.0f);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        if (((ImageSpan) this).mVerticalAlignment != -100) {
            super.draw(canvas, charSequence, i2, i3, f2, i4, i5, i6, paint);
            return;
        }
        Drawable drawable = this.mDrawable;
        canvas.save();
        int i7 = paint.getFontMetricsInt().top;
        canvas.translate(f2, i5 + i7 + (((r5.bottom - i7) - (drawable.getBounds().bottom - drawable.getBounds().top)) / 2));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        if (this.mAvoidSuperChangeFontMetrics) {
            this.mWidth = getDrawable().getBounds().right;
        } else {
            this.mWidth = super.getSize(paint, charSequence, i2, i3, fontMetricsInt);
        }
        if (this.mFontWidthMultiple > 0.0f) {
            this.mWidth = (int) (paint.measureText("子") * this.mFontWidthMultiple);
        }
        return this.mWidth;
    }

    public void setAvoidSuperChangeFontMetrics(boolean z) {
        this.mAvoidSuperChangeFontMetrics = z;
    }

    public KGUIAlignMiddleImageSpan(@NonNull Drawable drawable, int i2, float f2) {
        super(drawable.mutate(), i2);
        this.mFontWidthMultiple = -1.0f;
        this.mAvoidSuperChangeFontMetrics = false;
        this.mDrawable = getDrawable();
        if (f2 >= 0.0f) {
            this.mFontWidthMultiple = f2;
        }
    }
}
