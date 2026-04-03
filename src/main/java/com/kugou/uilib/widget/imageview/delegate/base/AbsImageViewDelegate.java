package com.kugou.uilib.widget.imageview.delegate.base;

import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.kugou.uilib.widget.baseDelegate.AbsViewDelegate;

/* JADX INFO: loaded from: classes2.dex */
public class AbsImageViewDelegate extends AbsViewDelegate<ImageView> implements IImageViewDelegate {
    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void drawableStateChanged() {
    }

    @Override // com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate
    public ColorFilter getColorFilter(ColorFilter colorFilter) {
        return null;
    }

    @Override // com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate
    public ImageView.ScaleType getScaleType(ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public Drawable getWarpBackground(int i2) {
        return null;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public Drawable getWarpBackground(Drawable drawable) {
        return null;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public Drawable getWarpBackgroundFromColor(int i2) {
        return null;
    }

    @Override // com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate
    public Drawable getWarpDrawable(int i2) {
        return null;
    }

    @Override // com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate
    public Drawable getWarpDrawable(Bitmap bitmap) {
        return null;
    }

    @Override // com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate
    public Drawable getWarpDrawable(Drawable drawable) {
        return null;
    }

    @Override // com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate
    public Drawable getWarpDrawable(Uri uri) {
        return null;
    }
}
