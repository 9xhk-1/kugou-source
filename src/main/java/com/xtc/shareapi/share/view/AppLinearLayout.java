package com.xtc.shareapi.share.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.constraintlayout.motion.widget.Key;
import com.xtc.shareapi.share.constant.OpenApiConstant;

/* JADX INFO: loaded from: classes2.dex */
public class AppLinearLayout extends LinearLayout {
    private Animator.AnimatorListener animatorListener;
    private AnimatorSet resetSet;
    private AnimatorSet zoomSet;

    public AppLinearLayout(Context context) {
        this(context, null);
    }

    private void initAnimation() {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setTarget(this);
        objectAnimator.setPropertyName(Key.TRANSLATION_X);
        objectAnimator.setDuration(350L);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.addListener(this.animatorListener);
        ObjectAnimator objectAnimator2 = new ObjectAnimator();
        objectAnimator2.setTarget(this);
        objectAnimator2.setPropertyName(Key.TRANSLATION_Y);
        objectAnimator2.setDuration(400L);
        objectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator2.addListener(this.animatorListener);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, Key.ALPHA, 1.0f, 0.6f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, Key.SCALE_X, 1.0f, 0.95f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this, Key.SCALE_Y, 1.0f, 0.95f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.zoomSet = animatorSet;
        animatorSet.setDuration(100L);
        this.zoomSet.setInterpolator(new AccelerateDecelerateInterpolator());
        this.zoomSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this, Key.ALPHA, 0.6f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this, Key.SCALE_X, 0.95f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this, Key.SCALE_Y, 0.95f, 1.0f);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.resetSet = animatorSet2;
        animatorSet2.setDuration(100L);
        this.resetSet.setInterpolator(new AccelerateDecelerateInterpolator());
        this.resetSet.playTogether(objectAnimatorOfFloat4, objectAnimatorOfFloat5, objectAnimatorOfFloat6);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.resetSet.isRunning()) {
                this.resetSet.cancel();
            }
            if (!this.zoomSet.isRunning()) {
                this.zoomSet.start();
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.zoomSet.isRunning()) {
                this.zoomSet.cancel();
            }
            if (!this.resetSet.isRunning()) {
                this.resetSet.start();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public AppLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.animatorListener = new Animator.AnimatorListener() { // from class: com.xtc.shareapi.share.view.AppLinearLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Log.d(OpenApiConstant.TAG, "AnimatorListener onAnimationEnd");
                AppLinearLayout.this.setTranslationX(0.0f);
                AppLinearLayout.this.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        };
        initAnimation();
    }
}
