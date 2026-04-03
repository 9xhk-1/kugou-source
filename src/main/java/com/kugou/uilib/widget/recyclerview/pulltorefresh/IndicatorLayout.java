package com.kugou.uilib.widget.recyclerview.pulltorefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kugou.uilib.R;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public class IndicatorLayout extends FrameLayout implements Animation.AnimationListener {
    public static final int DEFAULT_ROTATION_ANIMATION_DURATION = 150;
    private ImageView mArrowImageView;
    private Animation mInAnim;
    private Animation mOutAnim;
    private final Animation mResetRotateAnimation;
    private final Animation mRotateAnimation;

    /* JADX INFO: renamed from: com.kugou.uilib.widget.recyclerview.pulltorefresh.IndicatorLayout$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode = iArr;
            try {
                iArr[Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public IndicatorLayout(Context context, Mode mode) {
        int i2;
        int i3;
        super(context);
        this.mArrowImageView = new ImageView(context);
        this.mArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.common_xlistview_arrow));
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.kg_pulltorefresh_indicator_internal_padding);
        this.mArrowImageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        addView(this.mArrowImageView);
        if (AnonymousClass1.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[mode.ordinal()] != 1) {
            i2 = R.anim.common_pulltorefresh_slide_in_from_top;
            i3 = R.anim.common_pulltorefresh_slide_out_to_top;
            setBackgroundResource(R.drawable.common_pulltorefresh_indicator_bg_top);
        } else {
            i2 = R.anim.common_pulltorefresh_slide_in_from_bottom;
            int i4 = R.anim.common_pulltorefresh_slide_out_to_bottom;
            setBackgroundResource(R.drawable.common_pulltorefresh_indicator_bg_bottom);
            this.mArrowImageView.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.setRotate(180.0f, r0.getIntrinsicWidth() / 2.0f, r0.getIntrinsicHeight() / 2.0f);
            this.mArrowImageView.setImageMatrix(matrix);
            i3 = i4;
        }
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, i2);
        this.mInAnim = animationLoadAnimation;
        animationLoadAnimation.setAnimationListener(this);
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, i3);
        this.mOutAnim = animationLoadAnimation2;
        animationLoadAnimation2.setAnimationListener(this);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation = rotateAnimation;
        rotateAnimation.setInterpolator(linearInterpolator);
        rotateAnimation.setDuration(150L);
        rotateAnimation.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mResetRotateAnimation = rotateAnimation2;
        rotateAnimation2.setInterpolator(linearInterpolator);
        rotateAnimation2.setDuration(150L);
        rotateAnimation2.setFillAfter(true);
    }

    public void hide() {
        startAnimation(this.mOutAnim);
    }

    public final boolean isVisible() {
        Animation animation = getAnimation();
        return animation != null ? this.mInAnim == animation : getVisibility() == 0;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (animation == this.mOutAnim) {
            this.mArrowImageView.clearAnimation();
            setVisibility(8);
        } else if (animation == this.mInAnim) {
            setVisibility(0);
        }
        clearAnimation();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        setVisibility(0);
    }

    public void pullToRefresh() {
        this.mArrowImageView.startAnimation(this.mResetRotateAnimation);
    }

    public void releaseToRefresh() {
        this.mArrowImageView.startAnimation(this.mRotateAnimation);
    }

    public void show() {
        this.mArrowImageView.clearAnimation();
        startAnimation(this.mInAnim);
    }
}
