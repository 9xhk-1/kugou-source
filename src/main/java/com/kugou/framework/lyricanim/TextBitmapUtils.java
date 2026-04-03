package com.kugou.framework.lyricanim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes2.dex */
public class TextBitmapUtils {
    private static float calculateExtraHeight(float f2) {
        return f2 * 0.04761905f;
    }

    private static float calculateExtraWidth(float f2, float f3, float f4) {
        return ((((f3 + f2) * f4) / f2) - f4) / 2.0f;
    }

    public static ColorFilter color2ColorFilter(int i2) {
        return new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, (16711680 & i2) / 65535, 0.0f, 0.0f, 0.0f, 0.0f, (65280 & i2) / 255, 0.0f, 0.0f, 0.0f, 0.0f, i2 & 255, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public static Bitmap convertString2Bitmap(String str, Paint paint) {
        Paint paint2 = new Paint(paint);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(-1);
        paint2.setAlpha(255);
        float fMeasureText = paint2.measureText(str);
        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        float f2 = fontMetrics.bottom - fontMetrics.top;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(fMeasureText > 0.0f ? (int) fMeasureText : 1, f2 > 0.0f ? (int) f2 : 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f3 = fontMetrics.bottom;
        canvas.drawText(str, 0.0f, (f2 / 2.0f) + (((f3 - fontMetrics.top) / 2.0f) - f3), paint2);
        return bitmapCreateBitmap;
    }

    public static Bitmap convertString2Bitmap(String str, Paint paint, boolean z) {
        float fCalculateExtraHeight;
        float fCalculateExtraWidth;
        if (!z) {
            return convertString2Bitmap(str, paint);
        }
        Paint paint2 = new Paint(paint);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setAntiAlias(true);
        paint2.setAlpha(255);
        paint2.setColor(-1);
        float fMeasureText = paint2.measureText(str);
        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        float f2 = fontMetrics.bottom - fontMetrics.top;
        if (paint2.getTypeface() != null) {
            fCalculateExtraHeight = calculateExtraHeight(paint2.getTextSize());
            fCalculateExtraWidth = calculateExtraWidth(f2, fCalculateExtraHeight, fMeasureText);
        } else {
            fCalculateExtraHeight = 0.0f;
            fCalculateExtraWidth = 0.0f;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(fMeasureText > 0.0f ? (int) (fMeasureText + (fCalculateExtraWidth * 2.0f)) : 1, f2 > 0.0f ? ((int) f2) + ((int) fCalculateExtraHeight) : 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f3 = fontMetrics.bottom;
        canvas.drawText(str, fCalculateExtraWidth, (f2 / 2.0f) + (((f3 - fontMetrics.top) / 2.0f) - f3), paint2);
        return bitmapCreateBitmap;
    }
}
