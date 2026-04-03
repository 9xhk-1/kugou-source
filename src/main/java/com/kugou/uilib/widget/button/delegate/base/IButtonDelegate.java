package com.kugou.uilib.widget.button.delegate.base;

import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.ImageView;
import com.kugou.uilib.widget.baseDelegate.IViewDelegate;

/* JADX INFO: loaded from: classes2.dex */
public interface IButtonDelegate extends IViewDelegate<Button> {
    ImageView.ScaleType getScaleType(ImageView.ScaleType scaleType);

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    Drawable getWarpBackground(Drawable drawable);

    Drawable getWarpDrawable(Drawable drawable);
}
