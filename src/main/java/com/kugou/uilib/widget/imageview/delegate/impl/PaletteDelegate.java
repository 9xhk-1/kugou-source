package com.kugou.uilib.widget.imageview.delegate.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.kugou.uilib.anno.ExposeMethod;
import com.kugou.uilib.widget.imageview.delegate.base.AbsImageViewDelegate;

/* JADX INFO: loaded from: classes2.dex */
public class PaletteDelegate extends AbsImageViewDelegate {
    private PaletteListener l;
    public Runnable task = new Runnable() { // from class: com.kugou.uilib.widget.imageview.delegate.impl.PaletteDelegate.1
        @Override // java.lang.Runnable
        public void run() {
            PaletteDelegate.this.l.onDrawableChange();
        }
    };

    public interface PaletteListener {
        void onDrawableChange();
    }

    private void notifyDrawableChange() {
        ((ImageView) this.mView).removeCallbacks(this.task);
        ((ImageView) this.mView).post(this.task);
    }

    @Override // com.kugou.uilib.widget.imageview.delegate.base.AbsImageViewDelegate, com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate
    public Drawable getWarpDrawable(Drawable drawable) {
        notifyDrawableChange();
        return null;
    }

    @ExposeMethod
    public void setPaletteListener(PaletteListener paletteListener) {
        this.l = paletteListener;
    }

    @Override // com.kugou.uilib.widget.imageview.delegate.base.AbsImageViewDelegate, com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate
    public Drawable getWarpDrawable(Uri uri) {
        notifyDrawableChange();
        return null;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(ImageView imageView) {
        super.init(imageView);
    }

    @Override // com.kugou.uilib.widget.imageview.delegate.base.AbsImageViewDelegate, com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate
    public Drawable getWarpDrawable(Bitmap bitmap) {
        notifyDrawableChange();
        return null;
    }

    @Override // com.kugou.uilib.widget.imageview.delegate.base.AbsImageViewDelegate, com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate
    public Drawable getWarpDrawable(int i2) {
        notifyDrawableChange();
        return null;
    }
}
