package com.kugou.uilib.widget.imageview.delegate.impl;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;
import com.kugou.uilib.anno.ExposeMethod;
import com.kugou.uilib.widget.imageview.delegate.base.AbsImageViewDelegate;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate")
public class SrcAlphaDelegate extends AbsImageViewDelegate {
    private float alpha;
    public Runnable refreshTask = new Runnable() { // from class: com.kugou.uilib.widget.imageview.delegate.impl.SrcAlphaDelegate.1
        @Override // java.lang.Runnable
        public void run() {
            if (((ImageView) SrcAlphaDelegate.this.mView).getDrawable() == null || !SrcAlphaDelegate.this.isFinishInflate) {
                return;
            }
            ((ImageView) SrcAlphaDelegate.this.mView).getDrawable().mutate().setAlpha((int) (SrcAlphaDelegate.this.alpha * 255.0f));
            ((ImageView) SrcAlphaDelegate.this.mView).invalidate();
        }
    };

    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.hasValue(R.styleable.KGBaseImageView_kgui_src_alpha);
    }

    private void notifyChanged() {
        ((ImageView) this.mView).post(this.refreshTask);
    }

    @Override // com.kugou.uilib.widget.imageview.delegate.base.AbsImageViewDelegate, com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate
    public Drawable getWarpDrawable(int i2) {
        notifyChanged();
        return super.getWarpDrawable(i2);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onFinishInflate() {
        if (this.isFinishInflate) {
            return;
        }
        this.isFinishInflate = true;
        ((ImageView) this.mView).getDrawable().mutate().setAlpha((int) (this.alpha * 255.0f));
    }

    @ExposeMethod
    public void setAlpha(float f2) {
        this.alpha = f2;
        this.refreshTask.run();
    }

    @Override // com.kugou.uilib.widget.imageview.delegate.base.AbsImageViewDelegate, com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate
    public Drawable getWarpDrawable(Bitmap bitmap) {
        notifyChanged();
        return super.getWarpDrawable(bitmap);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(ImageView imageView, TypedArray typedArray) {
        super.init(imageView, typedArray);
        this.alpha = typedArray.getFloat(R.styleable.KGBaseImageView_kgui_src_alpha, 1.0f);
    }

    @Override // com.kugou.uilib.widget.imageview.delegate.base.AbsImageViewDelegate, com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate
    public Drawable getWarpDrawable(Uri uri) {
        notifyChanged();
        return super.getWarpDrawable(uri);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(ImageView imageView) {
        super.init(imageView);
    }

    @Override // com.kugou.uilib.widget.imageview.delegate.base.AbsImageViewDelegate, com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate
    public Drawable getWarpDrawable(Drawable drawable) {
        notifyChanged();
        return super.getWarpDrawable(drawable);
    }
}
