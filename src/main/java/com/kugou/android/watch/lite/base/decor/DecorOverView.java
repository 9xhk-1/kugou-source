package com.kugou.android.watch.lite.base.decor;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import e.c.a.g.a.d.g.b;

/* JADX INFO: loaded from: classes.dex */
public class DecorOverView extends View {
    public DecorOverView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        b.b().a(canvas);
    }

    public DecorOverView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
