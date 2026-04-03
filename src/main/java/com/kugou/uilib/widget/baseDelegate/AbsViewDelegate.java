package com.kugou.uilib.widget.baseDelegate;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class AbsViewDelegate<T extends View> implements IViewDelegate<T> {
    public boolean isFinishInflate;
    public T mView;

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void afterDraw(Canvas canvas) {
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void drawableStateChanged() {
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public Drawable getWarpBackground(int i2) {
        return null;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public Drawable getWarpBackground(Drawable drawable) {
        return null;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public Drawable getWarpBackgroundFromColor(int i2) {
        return null;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public boolean hasOverlappingRendering() {
        return true;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(T t, TypedArray typedArray) {
        this.mView = t;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public boolean isFocused() {
        return false;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public int[] measure(int i2, int i3) {
        return null;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onDraw(Canvas canvas) {
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onFinishInflate() {
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void preDraw(Canvas canvas) {
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(T t) {
        this.mView = t;
    }
}
