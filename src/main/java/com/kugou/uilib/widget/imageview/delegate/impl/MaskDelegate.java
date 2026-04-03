package com.kugou.uilib.widget.imageview.delegate.impl;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;
import com.kugou.uilib.anno.ExposeMethod;
import com.kugou.uilib.widget.imageview.delegate.base.AbsImageViewDelegate;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate")
public class MaskDelegate extends AbsImageViewDelegate {
    private boolean isInit;
    private PorterDuffColorFilter mColorFilter;
    private Drawable mLastDrawable;
    private PorterDuffColorFilter mPressColorFilter;

    private int checkAlpha(int i2) {
        return i2;
    }

    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.hasValue(R.styleable.KGBaseImageView_kgui_mask_color) || typedArray.hasValue(R.styleable.KGBaseImageView_kgui_press_color);
    }

    private boolean isPressState() {
        return ((ImageView) this.mView).isPressed() || ((ImageView) this.mView).isFocused() || ((ImageView) this.mView).isSelected();
    }

    @Override // com.kugou.uilib.widget.imageview.delegate.base.AbsImageViewDelegate, com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void drawableStateChanged() {
        Drawable drawable;
        if (this.mPressColorFilter == null || (drawable = ((ImageView) this.mView).getDrawable()) == null) {
            return;
        }
        drawable.mutate().setColorFilter(isPressState() ? this.mPressColorFilter : this.mColorFilter);
    }

    @Override // com.kugou.uilib.widget.imageview.delegate.base.AbsImageViewDelegate, com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate
    public ColorFilter getColorFilter(ColorFilter colorFilter) {
        PorterDuffColorFilter porterDuffColorFilter;
        return (!isPressState() || (porterDuffColorFilter = this.mPressColorFilter) == null) ? this.mColorFilter : porterDuffColorFilter;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void preDraw(Canvas canvas) {
        PorterDuffColorFilter porterDuffColorFilter;
        Drawable drawable = ((ImageView) this.mView).getDrawable();
        if (drawable != this.mLastDrawable) {
            this.isInit = false;
        }
        if (drawable != null && !this.isInit) {
            this.isInit = true;
            Drawable drawableMutate = drawable.mutate();
            if (!isPressState() || (porterDuffColorFilter = this.mPressColorFilter) == null) {
                porterDuffColorFilter = this.mColorFilter;
            }
            drawableMutate.setColorFilter(porterDuffColorFilter);
        }
        this.mLastDrawable = drawable;
    }

    @ExposeMethod
    public void setMaskColor(int i2) {
        this.mColorFilter = new PorterDuffColorFilter(checkAlpha(i2), PorterDuff.Mode.SRC_ATOP);
        drawableStateChanged();
    }

    @ExposeMethod
    public void setPressColor(int i2) {
        this.mPressColorFilter = new PorterDuffColorFilter(checkAlpha(i2), PorterDuff.Mode.SRC_ATOP);
        drawableStateChanged();
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(ImageView imageView, TypedArray typedArray) {
        super.init(imageView, typedArray);
        int color = typedArray.getColor(R.styleable.KGBaseImageView_kgui_mask_color, 0);
        int i2 = R.styleable.KGBaseImageView_kgui_press_color;
        if (typedArray.hasValue(i2)) {
            this.mPressColorFilter = new PorterDuffColorFilter(checkAlpha(typedArray.getColor(i2, color)), PorterDuff.Mode.SRC_ATOP);
        }
        this.mColorFilter = new PorterDuffColorFilter(checkAlpha(color), PorterDuff.Mode.SRC_ATOP);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(ImageView imageView) {
        super.init(imageView);
    }
}
