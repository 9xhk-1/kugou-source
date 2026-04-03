package com.kugou.uilib.widget.layout.coor;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.kugou.uilib.R;

/* JADX INFO: loaded from: classes2.dex */
public class KGUICombineScrollLayout extends CoordinatorLayout {
    private AppBarStateChangeListener headerStateListener;
    private final AppBarLayout mAppBarLayout;
    public AppBarLayout.OnOffsetChangedListener mDefaultListener;
    private final View mHeader;
    private final View mScrollAbleLayout;

    public static abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {
        private State mCurrentState = State.EXPANDED;

        public enum State {
            EXPANDED,
            JUST_BEGIN,
            ALMOST,
            COLLAPSED
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int iAbs = Math.abs(i2);
            if (iAbs == 0) {
                State state = this.mCurrentState;
                State state2 = State.EXPANDED;
                if (state != state2) {
                    onStateChanged(appBarLayout, state2);
                }
                this.mCurrentState = state2;
                return;
            }
            if (iAbs > 0 && iAbs < totalScrollRange / 2) {
                State state3 = this.mCurrentState;
                State state4 = State.JUST_BEGIN;
                if (state3 != state4) {
                    onStateChanged(appBarLayout, state4);
                }
                this.mCurrentState = state4;
                return;
            }
            if (iAbs >= totalScrollRange / 2 && iAbs < totalScrollRange) {
                State state5 = this.mCurrentState;
                State state6 = State.ALMOST;
                if (state5 != state6) {
                    onStateChanged(appBarLayout, state6);
                }
                this.mCurrentState = state6;
                return;
            }
            if (iAbs >= totalScrollRange) {
                State state7 = this.mCurrentState;
                State state8 = State.COLLAPSED;
                if (state7 != state8) {
                    onStateChanged(appBarLayout, state8);
                }
                this.mCurrentState = state8;
            }
        }

        public abstract void onStateChanged(AppBarLayout appBarLayout, State state);
    }

    public KGUICombineScrollLayout(@NonNull Context context) {
        this(context, null, 0);
    }

    public View getHeader() {
        return this.mHeader;
    }

    public View getScrollAbleLayout() {
        return this.mScrollAbleLayout;
    }

    public void setHeaderOffsetChangedListener(AppBarLayout.OnOffsetChangedListener onOffsetChangedListener, boolean z) {
        if (z) {
            this.mAppBarLayout.removeOnOffsetChangedListener(this.mDefaultListener);
        }
        this.mAppBarLayout.addOnOffsetChangedListener(onOffsetChangedListener);
    }

    public void setHeaderStateListener(AppBarStateChangeListener appBarStateChangeListener) {
        this.headerStateListener = appBarStateChangeListener;
    }

    public KGUICombineScrollLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KGUICombineScrollLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mDefaultListener = new AppBarLayout.OnOffsetChangedListener() { // from class: com.kugou.uilib.widget.layout.coor.KGUICombineScrollLayout.1
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i3) {
                KGUICombineScrollLayout.this.mHeader.setAlpha(1.0f - (Math.abs(i3 * 1.0f) / appBarLayout.getTotalScrollRange()));
                if (KGUICombineScrollLayout.this.headerStateListener != null) {
                    KGUICombineScrollLayout.this.headerStateListener.onOffsetChanged(appBarLayout, i3);
                }
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KGUICombineScrollLayout, i2, 0);
        int i3 = R.styleable.KGUICombineScrollLayout_kgui_header_layout;
        int i4 = R.layout.kgui_layout_blank;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(i3, i4);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.KGUICombineScrollLayout_kgui_head_collapsed_color, -16777216);
        float dimension = typedArrayObtainStyledAttributes.getDimension(R.styleable.KGUICombineScrollLayout_kgui_top_space, 0.0f);
        AppBarLayout appBarLayout = new AppBarLayout(getContext());
        this.mAppBarLayout = appBarLayout;
        View viewInflate = LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null, false);
        this.mHeader = viewInflate;
        appBarLayout.addView(viewInflate);
        ((AppBarLayout.LayoutParams) viewInflate.getLayoutParams()).setScrollFlags(3);
        viewInflate.setMinimumHeight((int) dimension);
        appBarLayout.setLayoutParams(new CoordinatorLayout.LayoutParams(-1, -2));
        addView(appBarLayout);
        appBarLayout.setBackgroundColor(color);
        appBarLayout.addOnOffsetChangedListener(this.mDefaultListener);
        View viewInflate2 = LayoutInflater.from(context).inflate(typedArrayObtainStyledAttributes.getResourceId(R.styleable.KGUICombineScrollLayout_kgui_scrollable_layout, i4), (ViewGroup) null, false);
        this.mScrollAbleLayout = viewInflate2;
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        layoutParams.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        viewInflate2.setLayoutParams(layoutParams);
        addView(viewInflate2);
        typedArrayObtainStyledAttributes.recycle();
    }
}
