package com.kugou.android.watch.lite.base.swipeback;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class CircleFrameLayout extends FrameLayout {
    public PaintFlagsDrawFilter a;
    public float b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f81d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f82f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f83h;

    public CircleFrameLayout(Context context) {
        this(context, null);
    }

    public final void a(int i2, int i3) {
        float f2 = i2;
        this.f82f.set(0.0f, 0.0f, f2, i3);
        this.b = f2 / 2.0f;
        this.f81d.reset();
        Path path = this.f81d;
        RectF rectF = this.f82f;
        float f3 = this.b;
        path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f83h && this.b > 0.0f) {
            if (this.a == null) {
                this.a = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.a);
            canvas.clipPath(this.f81d);
        }
        super.draw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a(i2, i3);
    }

    public void setShowCircle(boolean z) {
        this.f83h = z;
        postInvalidate();
    }

    public CircleFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f83h = false;
        setWillNotDraw(false);
        this.f81d = new Path();
        this.f82f = new RectF();
    }
}
