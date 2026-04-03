package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import f.s;
import f.z.c.l;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap bitmap, l<? super Canvas, s> lVar) {
        j.f(bitmap, "$this$applyCanvas");
        j.f(lVar, "block");
        lVar.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(Bitmap bitmap, Point point) {
        int i2;
        j.f(bitmap, "$this$contains");
        j.f(point, "p");
        int i3 = point.x;
        return i3 >= 0 && i3 < bitmap.getWidth() && (i2 = point.y) >= 0 && i2 < bitmap.getHeight();
    }

    public static final Bitmap createBitmap(int i2, int i3, Bitmap.Config config) {
        j.f(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config);
        j.b(bitmapCreateBitmap, "Bitmap.createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i2, int i3, Bitmap.Config config, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        j.f(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config);
        j.b(bitmapCreateBitmap, "Bitmap.createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static final int get(Bitmap bitmap, int i2, int i3) {
        j.f(bitmap, "$this$get");
        return bitmap.getPixel(i2, i3);
    }

    public static final Bitmap scale(Bitmap bitmap, int i2, int i3, boolean z) {
        j.f(bitmap, "$this$scale");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, z);
        j.b(bitmapCreateScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z = true;
        }
        j.f(bitmap, "$this$scale");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, z);
        j.b(bitmapCreateScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static final void set(Bitmap bitmap, int i2, int i3, @ColorInt int i4) {
        j.f(bitmap, "$this$set");
        bitmap.setPixel(i2, i3, i4);
    }

    public static final boolean contains(Bitmap bitmap, PointF pointF) {
        j.f(bitmap, "$this$contains");
        j.f(pointF, "p");
        float f2 = pointF.x;
        float f3 = 0;
        if (f2 < f3 || f2 >= bitmap.getWidth()) {
            return false;
        }
        float f4 = pointF.y;
        return f4 >= f3 && f4 < ((float) bitmap.getHeight());
    }

    @RequiresApi(26)
    public static final Bitmap createBitmap(int i2, int i3, Bitmap.Config config, boolean z, ColorSpace colorSpace) {
        j.f(config, "config");
        j.f(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config, z, colorSpace);
        j.b(bitmapCreateBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i2, int i3, Bitmap.Config config, boolean z, ColorSpace colorSpace, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i4 & 8) != 0) {
            z = true;
        }
        if ((i4 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            j.b(colorSpace, "ColorSpace.get(ColorSpace.Named.SRGB)");
        }
        j.f(config, "config");
        j.f(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config, z, colorSpace);
        j.b(bitmapCreateBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }
}
