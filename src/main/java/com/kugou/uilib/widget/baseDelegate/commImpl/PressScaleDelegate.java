package com.kugou.uilib.widget.baseDelegate.commImpl;

import android.animation.Animator;
import android.content.res.TypedArray;
import android.view.View;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;
import com.kugou.uilib.anno.ExposeMethod;
import com.kugou.uilib.widget.baseDelegate.AbsViewDelegate;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.baseDelegate.IViewDelegate")
public class PressScaleDelegate<T extends View> extends AbsViewDelegate<T> {
    private long ANIM_DURATION = 100;
    private boolean isAniming;
    private float mPressScale;

    /* JADX INFO: Access modifiers changed from: private */
    public void animToNormalState() {
        this.mView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(this.ANIM_DURATION).setListener(new Animator.AnimatorListener() { // from class: com.kugou.uilib.widget.baseDelegate.commImpl.PressScaleDelegate.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                PressScaleDelegate.this.isAniming = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PressScaleDelegate.this.isAniming = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PressScaleDelegate.this.isAniming = true;
            }
        }).start();
    }

    private void animToPressState() {
        this.mView.animate().scaleX(this.mPressScale).scaleY(this.mPressScale).setDuration(this.ANIM_DURATION).setListener(new Animator.AnimatorListener() { // from class: com.kugou.uilib.widget.baseDelegate.commImpl.PressScaleDelegate.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                PressScaleDelegate.this.isAniming = false;
                if (PressScaleDelegate.this.mView.isPressed()) {
                    return;
                }
                PressScaleDelegate.this.animToNormalState();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PressScaleDelegate.this.isAniming = false;
                if (PressScaleDelegate.this.mView.isPressed()) {
                    return;
                }
                PressScaleDelegate.this.animToNormalState();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PressScaleDelegate.this.isAniming = true;
            }
        }).start();
    }

    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.hasValue(R.styleable.KGUIView_kgui_press_scale_anim_ratio);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mView.isPressed()) {
            animToPressState();
        } else {
            if (this.isAniming) {
                return;
            }
            animToNormalState();
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(T t, TypedArray typedArray) {
        super.init(t, typedArray);
        this.mPressScale = typedArray.getFloat(R.styleable.KGUIView_kgui_press_scale_anim_ratio, 1.0f);
    }

    @ExposeMethod
    public void setPressAnimDuration(long j) {
        this.ANIM_DURATION = j;
    }

    @ExposeMethod
    public void setPressScale(float f2) {
        this.mPressScale = f2;
    }
}
