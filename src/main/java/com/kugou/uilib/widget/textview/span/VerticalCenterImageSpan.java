package com.kugou.uilib.widget.textview.span;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import com.kugou.uilib.utils.KGUILog;

/* JADX INFO: loaded from: classes2.dex */
public class VerticalCenterImageSpan extends ImageSpan {
    private static final String TAG = "VerticalCenterImageSpan";
    private int mSizeOffset;

    public VerticalCenterImageSpan(Drawable drawable) {
        super(drawable);
        this.mSizeOffset = 0;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Drawable drawable = getDrawable();
        canvas.save();
        int i7 = (i5 + ((int) paint.getFontMetrics().descent)) - drawable.getBounds().bottom;
        if (((ImageSpan) this).mVerticalAlignment == 1) {
            i7 -= paint.getFontMetricsInt().descent;
        }
        canvas.translate(f2, i7);
        try {
            drawable.draw(canvas);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        Drawable drawable = getDrawable();
        Rect bounds = drawable.getBounds();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int i4 = (int) (fontMetrics.descent - fontMetrics.ascent);
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicHeight <= 0) {
            if (KGUILog.DEBUG) {
                KGUILog.d(TAG, "VerticalCenterImageSpan bitmapHeight <= 0");
            }
            return bounds.right;
        }
        int i5 = (intrinsicWidth * i4) / intrinsicHeight;
        int i6 = this.mSizeOffset;
        bounds.set(0, 0, i5 + i6, i4 + i6);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = (int) fontMetrics.ascent;
            fontMetricsInt.descent = (int) fontMetrics.descent;
            fontMetricsInt.top = (int) fontMetrics.top;
            fontMetricsInt.bottom = (int) fontMetrics.bottom;
        }
        return bounds.width();
    }

    public VerticalCenterImageSpan(@NonNull Drawable drawable, int i2) {
        super(drawable);
        this.mSizeOffset = 0;
        this.mSizeOffset = i2;
    }

    public VerticalCenterImageSpan(Context context, Bitmap bitmap) {
        super(context, bitmap);
        this.mSizeOffset = 0;
    }

    public VerticalCenterImageSpan(Context context, int i2) {
        super(context, i2);
        this.mSizeOffset = 0;
    }
}
