package com.kugou.uilib.widget.imageview.delegate.base;

import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.kugou.uilib.widget.baseDelegate.IViewDelegate;

/* JADX INFO: loaded from: classes2.dex */
public interface IImageViewDelegate extends IViewDelegate<ImageView> {
    ColorFilter getColorFilter(ColorFilter colorFilter);

    ImageView.ScaleType getScaleType(ImageView.ScaleType scaleType);

    Drawable getWarpDrawable(@DrawableRes int i2);

    Drawable getWarpDrawable(Bitmap bitmap);

    Drawable getWarpDrawable(Drawable drawable);

    Drawable getWarpDrawable(Uri uri);
}
