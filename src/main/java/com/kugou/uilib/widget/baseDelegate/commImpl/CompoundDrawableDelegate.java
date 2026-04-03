package com.kugou.uilib.widget.baseDelegate.commImpl;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;
import com.kugou.uilib.widget.baseDelegate.AbsViewDelegate;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.baseDelegate.IViewDelegate")
public class CompoundDrawableDelegate<T extends View> extends AbsViewDelegate<T> {
    private Drawable mDrawable;
    private float mPivotX;
    private float mPivotY;
    private float mSelfPivotX;
    private float mSelfPivotY;
    private T view;

    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.hasValue(R.styleable.KGUIView_kgui_compound_drawable);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void afterDraw(Canvas canvas) {
        int width = (int) (this.view.getWidth() * this.mPivotX);
        int height = (int) (this.view.getHeight() * this.mPivotY);
        int intrinsicWidth = (int) (this.mDrawable.getIntrinsicWidth() * this.mSelfPivotX);
        int intrinsicHeight = (int) (this.mDrawable.getIntrinsicHeight() * this.mPivotY);
        Drawable drawable = this.mDrawable;
        drawable.setBounds(width - intrinsicWidth, height - intrinsicHeight, (drawable.getIntrinsicWidth() + width) - intrinsicWidth, (this.mDrawable.getIntrinsicHeight() + height) - intrinsicHeight);
        this.mDrawable.draw(canvas);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(T t, TypedArray typedArray) {
        this.view = t;
        if (typedArray == null) {
            return;
        }
        this.mDrawable = typedArray.getDrawable(R.styleable.KGUIView_kgui_compound_drawable);
        this.mPivotX = typedArray.getFloat(R.styleable.KGUIView_kgui_compound_drawable_pivotX, 0.5f);
        this.mPivotY = typedArray.getFloat(R.styleable.KGUIView_kgui_compound_drawable_pivotY, 0.5f);
        this.mSelfPivotX = typedArray.getFloat(R.styleable.KGUIView_kgui_compound_drawable_pivotX_self, 0.5f);
        this.mSelfPivotY = typedArray.getFloat(R.styleable.KGUIView_kgui_compound_drawable_pivotY_self, 0.5f);
    }
}
