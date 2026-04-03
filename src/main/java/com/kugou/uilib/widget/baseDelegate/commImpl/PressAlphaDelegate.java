package com.kugou.uilib.widget.baseDelegate.commImpl;

import android.content.res.TypedArray;
import android.view.View;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;
import com.kugou.uilib.anno.ExposeMethod;
import com.kugou.uilib.widget.baseDelegate.AbsViewDelegate;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.baseDelegate.IViewDelegate")
public class PressAlphaDelegate<T extends View> extends AbsViewDelegate<T> {
    private float mNormalAlpha = 1.0f;
    private float mPressedAlpha = 0.6f;
    private float mDisableAlpha = 0.6f;
    private boolean mEnableTrans = true;

    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.hasValue(R.styleable.KGUIView_kgui_press_alpha) || typedArray.hasValue(R.styleable.KGUIView_kgui_disable_alpha) || typedArray.hasValue(R.styleable.KGUIView_kgui_all_state_alpha);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void drawableStateChanged() {
        if (!this.mEnableTrans) {
            this.mView.setAlpha(this.mNormalAlpha);
            return;
        }
        float f2 = this.mNormalAlpha;
        if (this.mView.isPressed() || this.mView.isFocused() || this.mView.isSelected()) {
            f2 = this.mPressedAlpha;
        } else if (!this.mView.isEnabled()) {
            f2 = this.mDisableAlpha;
        }
        this.mView.setAlpha(f2);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(T t, TypedArray typedArray) {
        super.init(t, typedArray);
        if (typedArray != null) {
            this.mNormalAlpha = typedArray.getFloat(R.styleable.KGUIView_kgui_normal_alpha, this.mNormalAlpha);
            float f2 = typedArray.getFloat(R.styleable.KGUIView_kgui_all_state_alpha, 0.6f);
            t.setAlpha(this.mNormalAlpha);
            float f3 = typedArray.getFloat(R.styleable.KGUIView_kgui_press_alpha, -1.0f);
            if (f3 <= 0.0f) {
                f3 = f2;
            }
            this.mPressedAlpha = f3;
            float f4 = typedArray.getFloat(R.styleable.KGUIView_kgui_disable_alpha, -1.0f);
            if (f4 > 0.0f) {
                f2 = f4;
            }
            this.mDisableAlpha = f2;
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onFinishInflate() {
    }

    @ExposeMethod
    public void setDisableAlpha(float f2) {
        this.mDisableAlpha = f2;
        drawableStateChanged();
    }

    @ExposeMethod
    public void setEnableTrans(boolean z) {
        this.mEnableTrans = z;
        drawableStateChanged();
    }

    @ExposeMethod
    public void setNormalAlpha(float f2) {
        this.mNormalAlpha = f2;
        drawableStateChanged();
    }

    @ExposeMethod
    public void setPressedAlpha(float f2) {
        this.mPressedAlpha = f2;
        drawableStateChanged();
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(T t) {
        super.init(t);
    }
}
