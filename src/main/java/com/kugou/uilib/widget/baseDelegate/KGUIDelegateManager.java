package com.kugou.uilib.widget.baseDelegate;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.kugou.uilib.utils.KGUIListUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIDelegateManager<T extends View> implements IViewDelegate<T> {
    private List<IViewDelegate<T>> mAllFunctions = new ArrayList();

    private boolean isFunctionsEmpty() {
        return KGUIListUtil.isEmpty(getDelegates());
    }

    public void add(IViewDelegate<T> iViewDelegate) {
        if (getDelegates() != null) {
            getDelegates().add(iViewDelegate);
        }
    }

    public <P extends IViewDelegate<T>> void addList(List<P> list) {
        if (getDelegates() != null) {
            getDelegates().addAll(list);
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void afterDraw(Canvas canvas) {
        if (isFunctionsEmpty()) {
            return;
        }
        Iterator<IViewDelegate<T>> it = getDelegates().iterator();
        while (it.hasNext()) {
            it.next().afterDraw(canvas);
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void drawableStateChanged() {
        if (isFunctionsEmpty()) {
            return;
        }
        Iterator<IViewDelegate<T>> it = getDelegates().iterator();
        while (it.hasNext()) {
            it.next().drawableStateChanged();
        }
    }

    @Nullable
    public IViewDelegate<T> getDelegate(Class<IViewDelegate<T>> cls) {
        for (IViewDelegate<T> iViewDelegate : getDelegates()) {
            if (iViewDelegate.getClass() == cls) {
                return iViewDelegate;
            }
        }
        return null;
    }

    public List<IViewDelegate<T>> getDelegates() {
        return this.mAllFunctions;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public Drawable getWarpBackground(int i2) {
        Drawable drawable = null;
        for (IViewDelegate<T> iViewDelegate : getDelegates()) {
            Drawable warpBackground = drawable == null ? iViewDelegate.getWarpBackground(i2) : iViewDelegate.getWarpBackground(drawable);
            if (warpBackground != null) {
                drawable = warpBackground;
            }
        }
        return drawable;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public Drawable getWarpBackgroundFromColor(int i2) {
        Drawable drawable = null;
        for (IViewDelegate<T> iViewDelegate : getDelegates()) {
            Drawable warpBackgroundFromColor = drawable == null ? iViewDelegate.getWarpBackgroundFromColor(i2) : iViewDelegate.getWarpBackground(drawable);
            if (warpBackgroundFromColor != null) {
                drawable = warpBackgroundFromColor;
            }
        }
        return drawable;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public boolean hasOverlappingRendering() {
        Iterator<IViewDelegate<T>> it = getDelegates().iterator();
        boolean zHasOverlappingRendering = true;
        while (it.hasNext()) {
            zHasOverlappingRendering &= it.next().hasOverlappingRendering();
        }
        return zHasOverlappingRendering;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(T t) {
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(T t, TypedArray typedArray) {
        if (getDelegates() != null) {
            Iterator<IViewDelegate<T>> it = getDelegates().iterator();
            while (it.hasNext()) {
                it.next().init(t, typedArray);
            }
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public boolean isFocused() {
        boolean zIsFocused = false;
        if (isFunctionsEmpty()) {
            return false;
        }
        Iterator<IViewDelegate<T>> it = getDelegates().iterator();
        while (it.hasNext()) {
            zIsFocused |= it.next().isFocused();
        }
        return zIsFocused;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public int[] measure(int i2, int i3) {
        int[] iArr = null;
        if (isFunctionsEmpty()) {
            return null;
        }
        for (IViewDelegate<T> iViewDelegate : getDelegates()) {
            int[] iArrMeasure = iArr == null ? iViewDelegate.measure(i2, i3) : iViewDelegate.measure(iArr[0], iArr[1]);
            if (iArrMeasure != null) {
                iArr = iArrMeasure;
            }
        }
        return iArr;
    }

    public void onDetachedFromWindow() {
        this.mAllFunctions.clear();
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onDraw(Canvas canvas) {
        if (isFunctionsEmpty()) {
            return;
        }
        Iterator<IViewDelegate<T>> it = getDelegates().iterator();
        while (it.hasNext()) {
            it.next().onDraw(canvas);
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onFinishInflate() {
        Iterator<IViewDelegate<T>> it = getDelegates().iterator();
        while (it.hasNext()) {
            it.next().onFinishInflate();
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (isFunctionsEmpty()) {
            return;
        }
        Iterator<IViewDelegate<T>> it = getDelegates().iterator();
        while (it.hasNext()) {
            it.next().onLayout(z, i2, i3, i4, i5);
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (getDelegates() != null) {
            Iterator<IViewDelegate<T>> it = getDelegates().iterator();
            while (it.hasNext()) {
                it.next().onSizeChanged(i2, i3, i4, i5);
            }
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void preDraw(Canvas canvas) {
        if (isFunctionsEmpty()) {
            return;
        }
        Iterator<IViewDelegate<T>> it = getDelegates().iterator();
        while (it.hasNext()) {
            it.next().preDraw(canvas);
        }
    }

    public boolean remove(IViewDelegate<T> iViewDelegate) {
        if (getDelegates() != null) {
            return getDelegates().remove(iViewDelegate);
        }
        return false;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public Drawable getWarpBackground(Drawable drawable) {
        Iterator<IViewDelegate<T>> it = getDelegates().iterator();
        while (it.hasNext()) {
            Drawable warpBackground = it.next().getWarpBackground(drawable);
            if (warpBackground != null) {
                drawable = warpBackground;
            }
        }
        return drawable;
    }
}
