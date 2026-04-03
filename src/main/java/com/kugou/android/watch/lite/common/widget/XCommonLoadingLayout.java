package com.kugou.android.watch.lite.common.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import e.c.a.g.a.f.o.c;
import e.c.a.g.a.s.l1;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public class XCommonLoadingLayout extends LinearLayout {
    public int a;
    public int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f123d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public XCommonLoadingView f124f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout.LayoutParams f125h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout.LayoutParams f126i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public Drawable o;
    public Drawable p;
    public String q;
    public String r;
    public String s;
    public String t;
    public int u;
    public int v;
    public final int w;

    public static final class a implements c {
        public a() {
        }

        @Override // e.c.a.g.a.f.o.c
        public void onChangeColor() {
            TextView tipView = XCommonLoadingLayout.this.getTipView();
            j.c(tipView);
            tipView.setText(XCommonLoadingLayout.this.getMLoadingSecondStr());
        }
    }

    public XCommonLoadingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ XCommonLoadingLayout(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? -1 : i2);
    }

    public final void a() {
        if (this.f124f != null) {
            TextView textView = this.f123d;
            if (textView != null) {
                j.c(textView);
                textView.setText(this.q);
            }
            XCommonLoadingView xCommonLoadingView = this.f124f;
            if (xCommonLoadingView == null) {
                return;
            }
            xCommonLoadingView.o(false);
        }
    }

    public final void b() {
        XCommonLoadingView xCommonLoadingView;
        this.f123d = new TextView(getContext());
        this.v = l1.c(12.0f);
        TextView textView = this.f123d;
        j.c(textView);
        textView.setTextSize(0, this.v);
        TextView textView2 = this.f123d;
        j.c(textView2);
        textView2.setIncludeFontPadding(false);
        TextView textView3 = this.f123d;
        j.c(textView3);
        textView3.setTextColor(-1);
        this.f125h = new LinearLayout.LayoutParams(-2, -2);
        TextView textView4 = this.f123d;
        j.c(textView4);
        textView4.setLayoutParams(this.f125h);
        XCommonLoadingView xCommonLoadingView2 = new XCommonLoadingView(getContext());
        this.f124f = xCommonLoadingView2;
        if (xCommonLoadingView2 != null) {
            xCommonLoadingView2.setColorMode(this.w);
        }
        XCommonLoadingView xCommonLoadingView3 = this.f124f;
        if (xCommonLoadingView3 != null) {
            xCommonLoadingView3.setCircleStype(this.n);
        }
        XCommonLoadingView xCommonLoadingView4 = this.f124f;
        if (xCommonLoadingView4 != null) {
            xCommonLoadingView4.setViewSize(this.m);
        }
        XCommonLoadingView xCommonLoadingView5 = this.f124f;
        if (xCommonLoadingView5 != null) {
            xCommonLoadingView5.setOnLoadingListener(new a());
        }
        int iC = l1.c(44.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iC, iC);
        this.f126i = layoutParams;
        XCommonLoadingView xCommonLoadingView6 = this.f124f;
        if (xCommonLoadingView6 != null) {
            xCommonLoadingView6.setLayoutParams(layoutParams);
        }
        Drawable drawable = this.p;
        if (drawable != null && (xCommonLoadingView = this.f124f) != null) {
            xCommonLoadingView.setImageDrawable(drawable);
        }
        if (this.u != 0) {
            TextView textView5 = this.f123d;
            j.c(textView5);
            textView5.setTextColor(getResources().getColor(this.u));
        }
    }

    public final void c() {
        TextView textView = this.f123d;
        if (textView != null) {
            j.c(textView);
            textView.setText(this.r);
        }
    }

    public final void d() {
        XCommonLoadingView xCommonLoadingView = this.f124f;
        if (xCommonLoadingView != null) {
            xCommonLoadingView.o(false);
        }
        TextView textView = this.f123d;
        if (textView != null) {
            j.c(textView);
            textView.setText(this.q);
        }
    }

    public final void e() {
    }

    public final void f() {
        setGravity(17);
        removeAllViews();
        int i2 = this.a;
        if (i2 == 0) {
            setOrientation(0);
            addView(this.f124f);
            return;
        }
        if (i2 == 1) {
            setOrientation(0);
            LinearLayout.LayoutParams layoutParams = this.f125h;
            j.c(layoutParams);
            layoutParams.rightMargin = l1.c(8.0f);
            addView(this.f123d);
            addView(this.f124f);
            return;
        }
        if (i2 == 2) {
            setOrientation(0);
            LinearLayout.LayoutParams layoutParams2 = this.f125h;
            j.c(layoutParams2);
            layoutParams2.leftMargin = l1.c(8.0f);
            addView(this.f124f);
            addView(this.f123d);
            return;
        }
        if (i2 == 3) {
            setOrientation(1);
            LinearLayout.LayoutParams layoutParams3 = this.f125h;
            j.c(layoutParams3);
            layoutParams3.topMargin = l1.c(8.0f);
            addView(this.f124f);
            addView(this.f123d);
            return;
        }
        if (i2 != 4) {
            return;
        }
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams4 = this.f125h;
        j.c(layoutParams4);
        layoutParams4.bottomMargin = l1.c(8.0f);
        addView(this.f123d);
        addView(this.f124f);
    }

    public final void g() {
        if (this.f124f != null) {
            TextView textView = this.f123d;
            if (textView != null) {
                j.c(textView);
                textView.setText(this.s);
            }
            XCommonLoadingView xCommonLoadingView = this.f124f;
            if (xCommonLoadingView == null) {
                return;
            }
            xCommonLoadingView.r();
        }
    }

    public final int getArcNormalColor() {
        return this.k;
    }

    public final Drawable getBgDrawable() {
        return this.o;
    }

    public final int getChangeColor() {
        return this.l;
    }

    public final int getIconNormalColor() {
        return this.j;
    }

    public final Drawable getMDefaultDrawable() {
        return this.p;
    }

    public final String getMDragStr() {
        return this.q;
    }

    public final String getMLoadingSecondStr() {
        return this.t;
    }

    public final String getMLoadingStr() {
        return this.s;
    }

    public final XCommonLoadingView getMLoadingView() {
        return this.f124f;
    }

    public final String getMReleaseStr() {
        return this.r;
    }

    public final int getMTextColor() {
        return this.u;
    }

    public final int getTextMode() {
        return this.a;
    }

    public final TextView getTipView() {
        return this.f123d;
    }

    public final int getViewSizes() {
        return this.m;
    }

    public final void setArcNormalColor(int i2) {
        this.k = i2;
    }

    public final void setBgDrawable(Drawable drawable) {
        this.o = drawable;
    }

    public final void setChangeColor(int i2) {
        this.l = i2;
    }

    public final void setChangeTime(int i2) {
        XCommonLoadingView xCommonLoadingView = this.f124f;
        if (xCommonLoadingView == null || xCommonLoadingView == null) {
            return;
        }
        xCommonLoadingView.setChangeTime(i2);
    }

    public final void setCircleStype(boolean z) {
        XCommonLoadingView xCommonLoadingView = this.f124f;
        if (xCommonLoadingView == null) {
            return;
        }
        xCommonLoadingView.setCircleStype(z);
    }

    public final void setCircleType(boolean z) {
        this.n = z;
    }

    public final void setColorFilter(int i2) {
        XCommonLoadingView xCommonLoadingView = this.f124f;
        if (xCommonLoadingView == null) {
            return;
        }
        xCommonLoadingView.setColorFilter(i2);
    }

    public final void setDragStr(String str) {
        this.q = str;
    }

    public final void setIconImg(int i2) {
        XCommonLoadingView xCommonLoadingView = this.f124f;
        if (xCommonLoadingView == null) {
            return;
        }
        xCommonLoadingView.setImageResource(i2);
    }

    public final void setIconNormalColor(int i2) {
        this.j = i2;
    }

    public final void setImageSrc(Drawable drawable) {
        XCommonLoadingView xCommonLoadingView = this.f124f;
        if (xCommonLoadingView == null) {
            return;
        }
        xCommonLoadingView.setImageDrawable(drawable);
    }

    public final void setLoadingSecondStr(String str) {
        this.t = str;
    }

    public final void setLoadingStr(String str) {
        this.s = str;
    }

    public final void setLoadingType(int i2) {
        XCommonLoadingView xCommonLoadingView = this.f124f;
        if (xCommonLoadingView == null || xCommonLoadingView == null) {
            return;
        }
        xCommonLoadingView.setLoadingType(i2);
    }

    public final void setLoadingViewVisible(boolean z) {
        XCommonLoadingView xCommonLoadingView = this.f124f;
        if (xCommonLoadingView == null || xCommonLoadingView == null) {
            return;
        }
        xCommonLoadingView.setVisibility(z ? 0 : 8);
    }

    public final void setMDefaultDrawable(Drawable drawable) {
        this.p = drawable;
    }

    public final void setMDragStr(String str) {
        this.q = str;
    }

    public final void setMLoadingSecondStr(String str) {
        this.t = str;
    }

    public final void setMLoadingStr(String str) {
        this.s = str;
    }

    public final void setMLoadingView(XCommonLoadingView xCommonLoadingView) {
        this.f124f = xCommonLoadingView;
    }

    public final void setMReleaseStr(String str) {
        this.r = str;
    }

    public final void setMTextColor(int i2) {
        this.u = i2;
    }

    public final void setPullScale(float f2) {
        XCommonLoadingView xCommonLoadingView = this.f124f;
        if (xCommonLoadingView == null) {
            return;
        }
        xCommonLoadingView.setPullScale(f2);
    }

    public final void setRefreshState(int i2) {
        this.b = i2;
        TextView textView = this.f123d;
        if (textView == null) {
            return;
        }
        if (i2 == 1) {
            j.c(textView);
            textView.setText(this.q);
        } else if (i2 == 2) {
            j.c(textView);
            textView.setText(this.r);
        } else if (i2 != 3) {
            j.c(textView);
            textView.setText(this.q);
        } else {
            j.c(textView);
            textView.setText(this.s);
        }
    }

    public final void setSkinEnable(boolean z) {
    }

    public final void setTextColor(int i2) {
        TextView textView = this.f123d;
        j.c(textView);
        textView.setTextColor(i2);
    }

    public final void setTextMode(int i2) {
        this.a = i2;
    }

    public final void setTextSize(int i2) {
        this.v = i2;
        TextView textView = this.f123d;
        j.c(textView);
        textView.setTextSize(0, this.v);
    }

    public final void setTipText(String str) {
        TextView textView = this.f123d;
        if (textView != null) {
            j.c(textView);
            textView.setText(str);
        }
    }

    public final void setUseLoadingApm(boolean z) {
        XCommonLoadingView xCommonLoadingView = this.f124f;
        if (xCommonLoadingView == null) {
            return;
        }
        xCommonLoadingView.setUseLoadingApm(z);
    }

    public final void setViewSize(int i2) {
        XCommonLoadingView xCommonLoadingView = this.f124f;
        if (xCommonLoadingView == null) {
            return;
        }
        xCommonLoadingView.setViewSize(i2);
    }

    public final void setViewSizes(int i2) {
        this.m = i2;
    }

    public final void setViewType(int i2) {
        this.a = i2;
        f();
    }

    public XCommonLoadingLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 2;
        this.b = 1;
        e();
        b();
        f();
    }
}
