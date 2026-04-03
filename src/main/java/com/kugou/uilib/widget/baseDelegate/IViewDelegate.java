package com.kugou.uilib.widget.baseDelegate;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.DrawableRes;

/* JADX INFO: loaded from: classes2.dex */
public interface IViewDelegate<T extends View> {
    void afterDraw(Canvas canvas);

    void drawableStateChanged();

    Drawable getWarpBackground(@DrawableRes int i2);

    Drawable getWarpBackground(Drawable drawable);

    Drawable getWarpBackgroundFromColor(int i2);

    boolean hasOverlappingRendering();

    void init(T t);

    void init(T t, TypedArray typedArray);

    boolean isFocused();

    int[] measure(int i2, int i3);

    void onDraw(Canvas canvas);

    void onFinishInflate();

    void onLayout(boolean z, int i2, int i3, int i4, int i5);

    void onSizeChanged(int i2, int i3, int i4, int i5);

    void preDraw(Canvas canvas);
}
