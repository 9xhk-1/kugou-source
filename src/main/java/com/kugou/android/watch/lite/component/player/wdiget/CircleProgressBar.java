package com.kugou.android.watch.lite.component.player.wdiget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.R;
import e.c.a.g.a.s.l1;

/* JADX INFO: loaded from: classes2.dex */
public class CircleProgressBar extends View {
    public final int a;
    public Paint b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f166d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f167f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f168h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Rect f169i;

    public CircleProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawArc(this.f168h, (this.f167f / 100.0f) * 360.0f, 360.0f, false, this.f166d);
        canvas.drawArc(this.f168h, 0.0f, (this.f167f / 100.0f) * 360.0f, false, this.b);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        RectF rectF = this.f168h;
        int i6 = this.a;
        rectF.set(i6, i6, getWidth() - this.a, getHeight() - this.a);
        Rect rect = this.f169i;
        int i7 = this.a;
        rect.set(i7, i7, getWidth() - this.a, getHeight() - this.a);
    }

    public void setProgress(int i2) {
        float f2 = i2;
        if (this.f167f != f2) {
            this.f167f = f2;
            invalidate(this.f169i);
        }
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f167f = 0.0f;
        this.f168h = new RectF();
        this.f169i = new Rect();
        Paint paint = new Paint();
        this.b = paint;
        paint.setColor(getResources().getColor(R.color.auto_ht));
        int iC = l1.c(1.0f);
        this.a = iC;
        this.b.setStrokeWidth(iC);
        this.b.setAntiAlias(true);
        this.b.setDither(true);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        this.b.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f166d = paint2;
        paint2.setColor(getResources().getColor(R.color.auto_nt_30));
        this.f166d.setStrokeWidth(iC);
        this.f166d.setAntiAlias(true);
        this.f166d.setDither(true);
        this.f166d.setStrokeCap(Paint.Cap.ROUND);
        this.f166d.setStyle(Paint.Style.STROKE);
        setRotation(-90.0f);
    }
}
