package com.kugou.uilib.widget.recyclerview.pulltorefresh;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.kugou.uilib.R;
import com.kugou.uilib.utils.KGUISystemUtil;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LoadingLayout implements ILoadingLayout {
    public static final Interpolator ANIMATION_INTERPOLATOR = new LinearInterpolator();
    public ImageView mHeaderImage;
    public TextView mHeaderText;
    public Mode mMode;
    private CharSequence mPullLabel;
    private CharSequence mRefreshingLabel;
    private CharSequence mReleaseLabel;
    public Orientation mScrollDirection;
    private TextView mSubHeaderText;
    private boolean mUseIntrinsicAnimation;
    private int scrollOffset;
    private View view;

    /* JADX INFO: renamed from: com.kugou.uilib.widget.recyclerview.pulltorefresh.LoadingLayout$1, reason: invalid class name */
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

    public LoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.kgui_common_pull_to_refresh_header_vertical, (ViewGroup) null, false);
        this.view = viewInflate;
        this.mMode = mode;
        this.mScrollDirection = orientation;
        this.mHeaderText = (TextView) viewInflate.findViewById(R.id.pull_to_refresh_text);
        this.mSubHeaderText = (TextView) this.view.findViewById(R.id.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.view.findViewById(R.id.pull_to_refresh_image);
        if (AnonymousClass1.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[mode.ordinal()] != 1) {
            this.mPullLabel = context.getString(R.string.pull_to_refresh_pull);
            this.mRefreshingLabel = context.getString(R.string.pull_to_refresh_refreshing);
            this.mReleaseLabel = context.getString(R.string.pull_to_refresh_release);
        } else {
            this.mPullLabel = context.getString(R.string.pull_to_refresh_push);
            this.mRefreshingLabel = context.getString(R.string.pull_to_refresh_refreshing);
            this.mReleaseLabel = context.getString(R.string.pull_to_refresh_release);
        }
        if (typedArray != null) {
            int i2 = R.styleable.KGUIPullToRefreshBase_kgui_ptrHeaderBackground;
            if (typedArray.hasValue(i2) && (drawable = typedArray.getDrawable(i2)) != null) {
                ViewCompat.setBackground(this.view, drawable);
            }
            int i3 = R.styleable.KGUIPullToRefreshBase_kgui_ptrHeaderTextAppearance;
            if (typedArray.hasValue(i3)) {
                TypedValue typedValue = new TypedValue();
                typedArray.getValue(i3, typedValue);
                setTextAppearance(typedValue.data);
            }
            int i4 = R.styleable.KGUIPullToRefreshBase_kgui_ptrSubHeaderTextAppearance;
            if (typedArray.hasValue(i4)) {
                TypedValue typedValue2 = new TypedValue();
                typedArray.getValue(i4, typedValue2);
                setSubTextAppearance(typedValue2.data);
            }
            int i5 = R.styleable.KGUIPullToRefreshBase_kgui_ptrHeaderTextColor;
            if (typedArray.hasValue(i5) && (colorStateList2 = typedArray.getColorStateList(i5)) != null) {
                setTextColor(colorStateList2);
            }
            int i6 = R.styleable.KGUIPullToRefreshBase_kgui_ptrHeaderSubTextColor;
            if (typedArray.hasValue(i6)) {
                try {
                    colorStateList = typedArray.getColorStateList(i6);
                } catch (Exception unused) {
                    colorStateList = null;
                }
                if (colorStateList != null) {
                    setSubTextColor(colorStateList);
                }
            }
            int i7 = R.styleable.KGUIPullToRefreshBase_kgui_ptrDrawable;
            drawable = typedArray.hasValue(i7) ? typedArray.getDrawable(i7) : null;
            if (AnonymousClass1.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Mode[mode.ordinal()] != 1) {
                int i8 = R.styleable.KGUIPullToRefreshBase_kgui_ptrDrawableStart;
                if (typedArray.hasValue(i8)) {
                    drawable = typedArray.getDrawable(i8);
                } else {
                    int i9 = R.styleable.KGUIPullToRefreshBase_kgui_ptrDrawableTop;
                    if (typedArray.hasValue(i9)) {
                        drawable = typedArray.getDrawable(i9);
                    }
                }
            } else {
                int i10 = R.styleable.KGUIPullToRefreshBase_kgui_ptrDrawableEnd;
                if (typedArray.hasValue(i10)) {
                    drawable = typedArray.getDrawable(i10);
                } else {
                    int i11 = R.styleable.KGUIPullToRefreshBase_kgui_ptrDrawableBottom;
                    if (typedArray.hasValue(i11)) {
                        drawable = typedArray.getDrawable(i11);
                    }
                }
            }
        }
        setLoadingDrawable(drawable == null ? context.getResources().getDrawable(getDefaultDrawableResId()) : drawable);
        reset();
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.mSubHeaderText != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.mSubHeaderText.setVisibility(8);
                return;
            }
            this.mSubHeaderText.setText(charSequence);
            if (8 == this.mSubHeaderText.getVisibility()) {
                this.mSubHeaderText.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i2) {
        TextView textView = this.mSubHeaderText;
        if (textView != null) {
            textView.setTextAppearance(this.view.getContext(), i2);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        TextView textView = this.mSubHeaderText;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i2) {
        TextView textView = this.mHeaderText;
        if (textView != null) {
            textView.setTextAppearance(this.view.getContext(), i2);
        }
        TextView textView2 = this.mSubHeaderText;
        if (textView2 != null) {
            textView2.setTextAppearance(this.view.getContext(), i2);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        TextView textView = this.mHeaderText;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
        TextView textView2 = this.mSubHeaderText;
        if (textView2 != null) {
            textView2.setTextColor(colorStateList);
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public final int getContentSize() {
        return KGUISystemUtil.dp2px(80.0f);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public View getContentView() {
        return this.view;
    }

    public int getCustomContentSize() {
        return 0;
    }

    public abstract int getDefaultDrawableResId();

    public int getScrollOffset() {
        return this.scrollOffset;
    }

    public final void hideAllViews() {
        if (this.mHeaderText.getVisibility() == 0) {
            this.mHeaderText.setVisibility(4);
        }
        if (this.mHeaderImage.getVisibility() == 0) {
            this.mHeaderImage.setVisibility(4);
        }
        if (this.mSubHeaderText.getVisibility() == 0) {
            this.mSubHeaderText.setVisibility(4);
        }
    }

    public abstract void onLoadingDrawableSet(Drawable drawable);

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public final void onPull(float f2) {
        if (this.mUseIntrinsicAnimation) {
            return;
        }
        onPullImpl(f2);
    }

    public abstract void onPullImpl(float f2);

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void onScrollOffset(int i2) {
        this.scrollOffset = i2;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public final void pullToRefresh() {
        TextView textView = this.mHeaderText;
        if (textView != null) {
            textView.setText(this.mPullLabel);
        }
        pullToRefreshImpl();
    }

    public abstract void pullToRefreshImpl();

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public final void refreshing() {
        TextView textView = this.mHeaderText;
        if (textView != null) {
            textView.setText(this.mRefreshingLabel);
        }
        if (this.mUseIntrinsicAnimation) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        TextView textView2 = this.mSubHeaderText;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    public abstract void refreshingImpl();

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public final void releaseToRefresh() {
        TextView textView = this.mHeaderText;
        if (textView != null) {
            textView.setText(this.mReleaseLabel);
        }
        releaseToRefreshImpl();
    }

    public abstract void releaseToRefreshImpl();

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public final void reset() {
        this.mHeaderImage.setVisibility(0);
        if (this.mUseIntrinsicAnimation) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).selectDrawable(0);
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        TextView textView = this.mSubHeaderText;
        if (textView != null) {
            if (TextUtils.isEmpty(textView.getText())) {
                this.mSubHeaderText.setVisibility(8);
            } else {
                this.mSubHeaderText.setVisibility(0);
            }
        }
    }

    public abstract void resetImpl();

    public final void resetToRefresh(String str) {
        TextView textView = this.mHeaderText;
        if (textView != null) {
            textView.setText(str);
        }
        reset();
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public final void setLoadingDrawable(Drawable drawable) {
        this.mHeaderImage.setImageDrawable(drawable);
        this.mUseIntrinsicAnimation = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void setPaddingTop(int i2) {
        this.view.setPadding(0, i2, 0, 0);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void setPullLabel(CharSequence charSequence) {
        this.mPullLabel = charSequence;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        this.mRefreshingLabel = charSequence;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void setReleaseLabel(CharSequence charSequence) {
        this.mReleaseLabel = charSequence;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void setTextTypeface(Typeface typeface) {
        this.mHeaderText.setTypeface(typeface);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void setVisibility(int i2) {
        if (i2 == 0) {
            showInvisibleViews();
        } else {
            hideAllViews();
        }
    }

    public final void showInvisibleViews() {
        if (4 == this.mHeaderText.getVisibility()) {
            this.mHeaderText.setVisibility(0);
        }
        if (4 == this.mHeaderImage.getVisibility()) {
            this.mHeaderImage.setVisibility(0);
        }
        if (4 == this.mSubHeaderText.getVisibility()) {
            this.mSubHeaderText.setVisibility(0);
        }
    }
}
