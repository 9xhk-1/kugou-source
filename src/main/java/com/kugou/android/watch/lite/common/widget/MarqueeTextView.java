package com.kugou.android.watch.lite.common.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class MarqueeTextView extends TextView {
    public boolean a;
    public boolean b;

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = c.c().getConfigAsBoolean(b.y2, true);
        this.b = true;
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.b;
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.b;
    }

    public void setFocus(boolean z) {
        this.b = z;
        g0.f();
        if (this.a) {
            if (!z) {
                setEllipsize(TextUtils.TruncateAt.END);
                setFocusable(false);
                setFocusableInTouchMode(false);
            } else {
                setEllipsize(TextUtils.TruncateAt.MARQUEE);
                setMarqueeRepeatLimit(-1);
                setSingleLine(true);
                setFocusable(true);
                setFocusableInTouchMode(true);
            }
        }
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = c.c().getConfigAsBoolean(b.y2, true);
        this.b = true;
    }
}
