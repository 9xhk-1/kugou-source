package com.kugou.android.watch.lite.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import e.c.a.g.a.s.g0;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class AutoLoadingView extends XCommonLoadingLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AutoLoadingView(Context context) {
        this(context, null, 0, 6, null);
        j.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AutoLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        j.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoLoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        j.e(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (g0.a) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAttachedToWindow :");
            sb.append(getVisibility() == 0);
            sb.append(" ** name :");
            sb.append((Object) AutoLoadingView.class.getName());
            g0.c("wwh", sb.toString());
        }
        if (getVisibility() == 0) {
            g();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (g0.a) {
            StringBuilder sb = new StringBuilder();
            sb.append("onDetachedFromWindow :");
            sb.append(getVisibility() == 0);
            sb.append(" ** name :");
            sb.append((Object) AutoLoadingView.class.getName());
            g0.c("wwh", sb.toString());
        }
        a();
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 0) {
            g();
        } else {
            a();
        }
    }

    public /* synthetic */ AutoLoadingView(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}
