package com.kugou.uilib.widget.recyclerview.delegate.base;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class AbsRecyclerViewDelegate implements IRecyclerViewDelegate {
    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void afterDraw(Canvas canvas) {
    }

    @Override // com.kugou.uilib.widget.recyclerview.delegate.base.IRecyclerViewDelegate
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
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
    public void init(RecyclerView recyclerView) {
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(RecyclerView recyclerView, TypedArray typedArray) {
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

    @Override // com.kugou.uilib.widget.recyclerview.delegate.base.IRecyclerViewDelegate
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
    }

    @Override // com.kugou.uilib.widget.recyclerview.delegate.base.IRecyclerViewDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void preDraw(Canvas canvas) {
    }
}
