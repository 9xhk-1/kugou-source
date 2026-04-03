package com.kugou.android.watch.lite.common.widget.loading;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.kugou.android.watch.lite.R;
import e.c.a.g.a.b;
import e.c.a.g.a.f.o.g.a;
import e.c.a.g.a.f.o.g.c;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;

/* JADX INFO: loaded from: classes.dex */
public class CommonLoadingView extends AppCompatTextView {
    public int a;
    public a b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LayerDrawable f135d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AnimationDrawable f136f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f138i;
    public int j;
    public int k;
    public String l;
    public String m;
    public String n;
    public int o;
    public boolean p;

    static {
        g0.f();
    }

    public CommonLoadingView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 3;
        this.k = 20;
        this.n = "加载中";
        this.o = 1;
        this.p = false;
        a(context.obtainStyledAttributes(attributeSet, b.LoadingView));
    }

    private void setDrawable(int i2) {
        if (i2 == 1) {
            setCompoundDrawables(this.f135d, null, null, null);
            return;
        }
        if (i2 == 2) {
            setCompoundDrawables(this.f135d, null, null, null);
            return;
        }
        if (i2 == 3) {
            setCompoundDrawables(null, this.f135d, null, null);
        } else if (i2 != 4) {
            setCompoundDrawables(this.f135d, null, null, null);
        } else {
            setCompoundDrawables(null, this.f135d, null, null);
        }
    }

    public final void a(TypedArray typedArray) {
        String str;
        String string;
        setGravity(17);
        c cVar = new c();
        this.b = cVar;
        cVar.attachView(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.loadingView_textSize_default);
        String string2 = null;
        if (typedArray != null) {
            try {
                try {
                    String string3 = typedArray.getString(9);
                    try {
                        dimensionPixelSize = typedArray.getDimensionPixelSize(11, dimensionPixelSize);
                        this.a = typedArray.getInt(10, 3);
                        this.k = typedArray.getDimensionPixelSize(0, 20);
                        string = typedArray.getString(4);
                        try {
                            string2 = typedArray.getString(5);
                            this.l = typedArray.getString(7);
                            this.m = typedArray.getString(8);
                            this.o = typedArray.getInt(6, 1);
                            typedArray.recycle();
                            str = string2;
                            string2 = string3;
                        } catch (Exception unused) {
                            str = string2;
                            string2 = string3;
                        }
                    } catch (Exception unused2) {
                        string = null;
                        string2 = string3;
                        str = null;
                    }
                } finally {
                    typedArray.recycle();
                }
            } catch (Exception unused3) {
                str = null;
                string = null;
            }
        } else {
            str = null;
            string = null;
        }
        if (TextUtils.isEmpty(string2)) {
            setTextColor(getResources().getColor(R.color.secondary_txt));
        } else {
            setTextColor(Color.parseColor(string2));
        }
        if (TextUtils.isEmpty(this.l)) {
            this.l = getResources().getString(R.string.loading_tips_primary);
        }
        if (TextUtils.isEmpty(this.m)) {
            this.m = getResources().getString(R.string.loading_tips_secondary);
        }
        setTextSize(0, dimensionPixelSize);
        this.f138i = Color.parseColor(TextUtils.isEmpty(string) ? "#0090FF" : string);
        if (TextUtils.isEmpty(string)) {
            str = "#FF6C00";
        }
        this.j = Color.parseColor(str);
        this.n = this.l;
        int iD = l1.d(getContext(), 40.0f);
        LayerDrawable layerDrawable = (LayerDrawable) getResources().getDrawable(R.drawable.common_loading);
        this.f135d = layerDrawable;
        layerDrawable.setBounds(0, 0, iD, iD);
        this.f136f = (AnimationDrawable) this.f135d.findDrawableByLayerId(R.id.common_loading_anim_id);
        setCompoundDrawablePadding(this.k);
        setText(this.n);
        setDrawable(this.a);
    }

    public void b() {
        if (getLoadingPresenter() == null) {
            return;
        }
        getLoadingPresenter().startAnim();
    }

    public void c() {
        if (getLoadingPresenter() == null) {
            return;
        }
        getLoadingPresenter().stopAnim();
    }

    public void d(boolean z) {
        if (z) {
            b();
        } else {
            c();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.b.checkLocation()) {
            return;
        }
        super.draw(canvas);
    }

    @Nullable
    public AnimationDrawable getAnim() {
        return this.f136f;
    }

    public int getIconColor() {
        return this.f137h;
    }

    public a getLoadingPresenter() {
        return this.b;
    }

    public int getPageId() {
        return e.c.a.g.a.d.w.a.f(this);
    }

    public int getPrimaryColor() {
        return this.f138i;
    }

    public String getPrimaryText() {
        return this.l;
    }

    public int getSecondaryColor() {
        return this.j;
    }

    public String getSecondaryText() {
        return this.m;
    }

    public long getTimestamp() {
        return e.c.a.g.a.d.w.a.k(this);
    }

    public int getType() {
        return this.o;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.p) {
            return;
        }
        c();
    }

    @Override // android.widget.TextView, android.view.View
    public void onVisibilityChanged(View view, int i2) {
        boolean zIsShown = i2 == 0 && getVisibility() == 0;
        if (zIsShown) {
            zIsShown = isShown();
        }
        super.onVisibilityChanged(view, i2);
        if (!this.p) {
            d(zIsShown);
        } else if (view == this) {
            d(zIsShown);
        }
    }

    public void setIconColor(@ColorInt int i2) {
        this.f137h = i2;
    }

    public void setNeedControlAnim(boolean z) {
        this.p = z;
    }

    public void setPrimaryColor(int i2) {
        this.f138i = i2;
    }

    public void setPrimaryText(String str) {
        this.l = str;
    }

    public void setSecondaryColor(int i2) {
        this.j = i2;
    }

    public void setSecondaryText(String str) {
        this.m = str;
    }

    public void setText(String str) {
        int i2 = this.a;
        if (1 == i2 || 4 == i2) {
            return;
        }
        super.setText((CharSequence) str);
    }

    public void setType(int i2) {
        this.o = i2;
    }

    public CommonLoadingView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 3;
        this.k = 20;
        this.n = "加载中";
        this.o = 1;
        this.p = false;
        a(context.obtainStyledAttributes(attributeSet, b.LoadingView));
    }
}
