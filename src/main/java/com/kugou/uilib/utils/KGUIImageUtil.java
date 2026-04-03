package com.kugou.uilib.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIImageUtil {
    private static Bitmap createBitmap(Bitmap bitmap, int i2, int i3, int i4, int i5, Matrix matrix) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        try {
            return Bitmap.createBitmap(bitmap, i2, i3, i4, i5, matrix, true);
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        } catch (OutOfMemoryError unused2) {
            System.gc();
            return Bitmap.createBitmap(bitmap, i2, i3, i4, i5, matrix, true);
        }
    }

    public static Bitmap zoomBitmap(Bitmap bitmap, int i2, int i3) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i2 / width, i3 / height);
        return createBitmap(bitmap, 0, 0, width, height, matrix);
    }
}
