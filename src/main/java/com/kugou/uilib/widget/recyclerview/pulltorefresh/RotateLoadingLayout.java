package com.kugou.uilib.widget.recyclerview.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.kugou.uilib.R;

/* JADX INFO: loaded from: classes2.dex */
public class RotateLoadingLayout extends LoadingLayout {
    public static final int ROTATION_ANIMATION_DURATION = 1200;
    private Matrix mHeaderImageMatrix;
    private Animation mRotateAnimation;
    private boolean mRotateDrawableWhilePulling;
    private float mRotationPivotX;
    private float mRotationPivotY;

    public RotateLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.mRotateDrawableWhilePulling = typedArray.getBoolean(R.styleable.KGUIPullToRefreshBase_kgui_ptrRotateDrawableWhilePulling, true);
        this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        this.mHeaderImageMatrix = matrix;
        this.mHeaderImage.setImageMatrix(matrix);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation = rotateAnimation;
        rotateAnimation.setInterpolator(LoadingLayout.ANIMATION_INTERPOLATOR);
        this.mRotateAnimation.setDuration(1200L);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setRepeatMode(1);
    }

    private void resetImageRotation() {
        Matrix matrix = this.mHeaderImageMatrix;
        if (matrix != null) {
            matrix.reset();
            this.mHeaderImage.setImageMatrix(this.mHeaderImageMatrix);
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.LoadingLayout
    public int getDefaultDrawableResId() {
        return R.drawable.common_pulltorefresh_default_ptr_rotate;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        if (drawable != null) {
            this.mRotationPivotX = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.mRotationPivotY = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.LoadingLayout
    public void onPullImpl(float f2) {
        this.mHeaderImageMatrix.setRotate(this.mRotateDrawableWhilePulling ? f2 * 90.0f : Math.max(0.0f, Math.min(180.0f, (f2 * 360.0f) - 180.0f)), this.mRotationPivotX, this.mRotationPivotY);
        this.mHeaderImage.setImageMatrix(this.mHeaderImageMatrix);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.LoadingLayout
    public void pullToRefreshImpl() {
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.LoadingLayout
    public void refreshingImpl() {
        this.mHeaderImage.startAnimation(this.mRotateAnimation);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.LoadingLayout
    public void releaseToRefreshImpl() {
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.LoadingLayout
    public void resetImpl() {
        this.mHeaderImage.clearAnimation();
        resetImageRotation();
    }
}
