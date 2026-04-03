package com.kugou.uilib.widget.baseDelegate.commImpl;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;
import com.kugou.uilib.widget.baseDelegate.AbsViewDelegate;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.baseDelegate.IViewDelegate")
public class DrawableAlphaDelegate<T extends View> extends AbsViewDelegate<T> {
    private float backgroundAlpha;
    public Runnable refreshTask = new Runnable() { // from class: com.kugou.uilib.widget.baseDelegate.commImpl.DrawableAlphaDelegate.1
        @Override // java.lang.Runnable
        public void run() {
            if (DrawableAlphaDelegate.this.mView.getBackground() == null || !DrawableAlphaDelegate.this.isFinishInflate) {
                return;
            }
            DrawableAlphaDelegate.this.mView.getBackground().mutate().setAlpha((int) (DrawableAlphaDelegate.this.backgroundAlpha * 255.0f));
            DrawableAlphaDelegate.this.mView.invalidate();
        }
    };

    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.hasValue(R.styleable.KGUIView_kgui_background_alpha);
    }

    private void notifyBackgroundChanged() {
        this.mView.post(this.refreshTask);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public Drawable getWarpBackground(int i2) {
        notifyBackgroundChanged();
        return null;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public Drawable getWarpBackgroundFromColor(int i2) {
        notifyBackgroundChanged();
        return null;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(T t, TypedArray typedArray) {
        super.init(t, typedArray);
        this.backgroundAlpha = typedArray.getFloat(R.styleable.KGUIView_kgui_background_alpha, 1.0f);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onFinishInflate() {
        if (this.isFinishInflate) {
            return;
        }
        this.isFinishInflate = true;
        this.mView.getBackground().mutate().setAlpha((int) (this.backgroundAlpha * 255.0f));
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public Drawable getWarpBackground(Drawable drawable) {
        notifyBackgroundChanged();
        return null;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(T t) {
        super.init(t);
    }
}
