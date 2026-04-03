package com.kugou.uilib.widget.popupwindow;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class TriangleDrawable extends Drawable {
    public static final int BOTTOM = 13;
    public static final int LEFT = 14;
    public static final int RIGHT = 15;
    public static final int TOP = 12;
    private int arrowDirection;
    private int bgColor;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ARROWDIRECTION {
    }

    public TriangleDrawable(int i2, @ColorInt int i3) {
        this.bgColor = -1;
        this.arrowDirection = i2;
        this.bgColor = i3;
    }

    private Path createPath() {
        Rect bounds = getBounds();
        Path path = new Path();
        int i2 = this.arrowDirection;
        if (i2 == 12) {
            path.moveTo(bounds.right / 2, 0.0f);
            path.lineTo(0.0f, bounds.bottom);
            path.lineTo(bounds.right, bounds.bottom);
            path.close();
        } else if (i2 == 13) {
            path.moveTo(bounds.right / 2, bounds.bottom);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(bounds.right, 0.0f);
            path.close();
        } else if (i2 == 14) {
            path.moveTo(0.0f, bounds.bottom / 2);
            path.lineTo(bounds.right, 0.0f);
            path.lineTo(bounds.right, bounds.bottom);
            path.close();
        } else {
            path.moveTo(bounds.right, bounds.bottom / 2);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(0.0f, bounds.bottom);
            path.close();
        }
        return path;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.bgColor);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(createPath(), paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
