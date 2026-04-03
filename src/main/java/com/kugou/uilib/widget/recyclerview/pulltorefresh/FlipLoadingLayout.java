package com.kugou.uilib.widget.recyclerview.pulltorefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.kugou.uilib.R;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public class FlipLoadingLayout extends LoadingLayout {
    public static final int FLIP_ANIMATION_DURATION = 150;
    private Animation mResetRotateAnimation;
    private Animation mRotateAnimation;

    /* JADX INFO: renamed from: com.kugou.uilib.widget.recyclerview.pulltorefresh.FlipLoadingLayout$1, reason: invalid class name */
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

    public FlipLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        float f2 = mode == Mode.PULL_FROM_START ? -180 : 180;
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, f2, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation = rotateAnimation;
        Interpolator interpolator = LoadingLayout.ANIMATION_INTERPOLATOR;
        rotateAnimation.setInterpolator(interpolator);
        this.mRotateAnimation.setDuration(150L);
        this.mRotateAnimation.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(f2, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mResetRotateAnimation = rotateAnimation2;
        rotateAnimation2.setInterpolator(interpolator);
        this.mResetRotateAnimation.setDuration(150L);
        this.mResetRotateAnimation.setFillAfter(true);
    }

    private float getDrawableRotationAngle() {
        int i2 = AnonymousClass1.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[this.mMode.ordinal()];
        return i2 != 1 ? (i2 == 2 && this.mScrollDirection == Orientation.HORIZONTAL) ? 270.0f : 0.0f : this.mScrollDirection == Orientation.HORIZONTAL ? 90.0f : 180.0f;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.LoadingLayout
    public int getDefaultDrawableResId() {
        return R.drawable.common_xlistview_arrow;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            ViewGroup.LayoutParams layoutParams = this.mHeaderImage.getLayoutParams();
            int iMax = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = iMax;
            layoutParams.width = iMax;
            this.mHeaderImage.requestLayout();
            this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate((layoutParams.width - intrinsicWidth) / 2.0f, (layoutParams.height - intrinsicHeight) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), layoutParams.width / 2.0f, layoutParams.height / 2.0f);
            this.mHeaderImage.setImageMatrix(matrix);
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.LoadingLayout
    public void onPullImpl(float f2) {
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.LoadingLayout
    public void pullToRefreshImpl() {
        if (this.mRotateAnimation == this.mHeaderImage.getAnimation()) {
            this.mHeaderImage.startAnimation(this.mResetRotateAnimation);
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.LoadingLayout
    public void refreshingImpl() {
        this.mHeaderImage.clearAnimation();
        this.mHeaderImage.setVisibility(4);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.LoadingLayout
    public void releaseToRefreshImpl() {
        this.mHeaderImage.startAnimation(this.mRotateAnimation);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.LoadingLayout
    public void resetImpl() {
        this.mHeaderImage.clearAnimation();
        this.mHeaderImage.setVisibility(0);
    }
}
