package com.kugou.android.watch.lite.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.kugou.android.watch.lite.R;
import com.kugou.uilib.widget.imageview.KGUIImageView;
import com.xtc.shareapi.share.shareobject.ShareCloudFileResource;
import e.c.a.g.a.f.o.c;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import f.z.d.g;
import f.z.d.j;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class XCommonLoadingView extends KGUIImageView {
    public Drawable A;
    public int B;
    public int C;
    public int D;
    public int E;
    public c F;
    public final String a;
    public Paint b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f127d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f128f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f130i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public ValueAnimator s;
    public Timer t;
    public long u;
    public int v;
    public int w;
    public int x;
    public Drawable y;
    public boolean z;

    public final class a extends TimerTask {
        public final /* synthetic */ XCommonLoadingView a;

        /* JADX INFO: renamed from: com.kugou.android.watch.lite.common.widget.XCommonLoadingView$a$a, reason: collision with other inner class name */
        public static final class RunnableC0010a implements Runnable {
            public final /* synthetic */ XCommonLoadingView a;

            public RunnableC0010a(XCommonLoadingView xCommonLoadingView) {
                this.a = xCommonLoadingView;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (g0.a) {
                    g0.b(this.a.a, j.l("mLoadingApmHelper.onChangeColor() loading 超时 ", Long.valueOf(SystemClock.elapsedRealtime() - this.a.u)));
                }
                this.a.z = true;
                if (this.a.getDrawable() != null) {
                    Drawable drawable = this.a.getDrawable();
                    if (drawable instanceof LayerDrawable) {
                        ((LayerDrawable) drawable).getDrawable(0).mutate().setColorFilter(this.a.x, PorterDuff.Mode.SRC_IN);
                    } else {
                        drawable.mutate().setColorFilter(this.a.z ? this.a.x : this.a.v, PorterDuff.Mode.SRC_IN);
                    }
                }
                c cVar = this.a.F;
                if (cVar != null) {
                    cVar.onChangeColor();
                }
                this.a.invalidate();
            }
        }

        public a(XCommonLoadingView xCommonLoadingView) {
            j.e(xCommonLoadingView, "this$0");
            this.a = xCommonLoadingView;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            XCommonLoadingView xCommonLoadingView = this.a;
            xCommonLoadingView.post(new RunnableC0010a(xCommonLoadingView));
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            XCommonLoadingView xCommonLoadingView = XCommonLoadingView.this;
            xCommonLoadingView.n = (xCommonLoadingView.n + XCommonLoadingView.this.k) % XCommonLoadingView.this.j;
            XCommonLoadingView xCommonLoadingView2 = XCommonLoadingView.this;
            xCommonLoadingView2.o = (xCommonLoadingView2.o + XCommonLoadingView.this.k) % XCommonLoadingView.this.j;
            XCommonLoadingView xCommonLoadingView3 = XCommonLoadingView.this;
            Object animatedValue = valueAnimator.getAnimatedValue();
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            xCommonLoadingView3.p = ((Integer) animatedValue).intValue();
            XCommonLoadingView.this.invalidate();
        }
    }

    public XCommonLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ XCommonLoadingView(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, attributeSet, (i3 & 4) != 0 ? -1 : i2);
    }

    @Override // com.kugou.uilib.widget.imageview.KGBaseImageView, android.view.View
    public void draw(Canvas canvas) {
        j.e(canvas, "canvas");
        super.draw(canvas);
    }

    public final ValueAnimator getAngeleAnimator() {
        return this.s;
    }

    public final Drawable getBgDrawable() {
        return this.y;
    }

    public final c getOnLoadingListener() {
        return this.F;
    }

    public final int getViewSize() {
        return this.B;
    }

    public final void o(boolean z) {
        this.q = false;
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator != null) {
            j.c(valueAnimator);
            valueAnimator.cancel();
            this.s = null;
        }
        q();
        Timer timer = this.t;
        if (timer != null) {
            j.c(timer);
            timer.cancel();
            Timer timer2 = this.t;
            j.c(timer2);
            timer2.purge();
            this.t = null;
        }
        if (z) {
            s();
        }
        if (getDrawable() != null) {
            Drawable drawable = getDrawable();
            if (drawable instanceof LayerDrawable) {
                ((LayerDrawable) drawable).getDrawable(0).mutate().setColorFilter(this.z ? this.x : this.v, PorterDuff.Mode.SRC_IN);
            } else {
                drawable.mutate().setColorFilter(this.z ? this.x : this.v, PorterDuff.Mode.SRC_IN);
            }
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.r) {
            this.r = false;
            r();
        }
    }

    @Override // com.kugou.uilib.widget.imageview.KGBaseImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (g0.a) {
            g0.c("XCommonLoadingView", j.l("onDetachedFromWindow :", Integer.valueOf(hashCode())));
        }
        o(true);
    }

    @Override // com.kugou.uilib.widget.imageview.KGBaseImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        j.e(canvas, "canvas");
        super.onDraw(canvas);
        this.f127d.set(l1.c(3.0f), l1.c(3.0f), getWidth() - l1.c(3.0f), getHeight() - l1.c(3.0f));
        Paint paint = this.b;
        j.c(paint);
        paint.setColor(this.z ? this.x : this.w);
        RectF rectF = this.f127d;
        float f2 = this.n;
        float f3 = this.p;
        Paint paint2 = this.b;
        j.c(paint2);
        canvas.drawArc(rectF, f2, f3, false, paint2);
        RectF rectF2 = this.f127d;
        float f4 = this.o;
        float f5 = this.p;
        Paint paint3 = this.b;
        j.c(paint3);
        canvas.drawArc(rectF2, f4, f5, false, paint3);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i2) {
        j.e(view, "changedView");
        boolean zIsShown = i2 == 0 && getVisibility() == 0;
        if (zIsShown) {
            zIsShown = isShown();
        }
        super.onVisibilityChanged(view, i2);
        if (zIsShown) {
            return;
        }
        s();
    }

    public final void p() {
        if (this.B == 0) {
            Paint paint = this.b;
            j.c(paint);
            paint.setStrokeWidth(l1.c(2.0f));
            Drawable drawableMutate = getResources().getDrawable(R.drawable.x_refresh_loading_pic31).mutate();
            this.A = drawableMutate;
            j.c(drawableMutate);
            drawableMutate.setColorFilter(e.c.a.g.a.s.g.a(-16777216, 0.1f), PorterDuff.Mode.SRC_IN);
        } else {
            Paint paint2 = this.b;
            j.c(paint2);
            paint2.setStrokeWidth(l1.c(1.0f));
            Drawable drawableMutate2 = getResources().getDrawable(R.drawable.x_refresh_loading_pic_small_31).mutate();
            this.A = drawableMutate2;
            j.c(drawableMutate2);
            drawableMutate2.setColorFilter(e.c.a.g.a.s.g.a(-16777216, 0.1f), PorterDuff.Mode.SRC_IN);
        }
        Drawable drawable = this.y;
        if (drawable != null && (drawable instanceof GradientDrawable)) {
            Objects.requireNonNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            int i2 = this.B;
            gradientDrawable.setSize(i2 == 0 ? this.C : this.D, i2 == 0 ? this.C : this.D);
            setBackgroundDrawable(this.y);
        }
        setImageDrawable(this.A);
    }

    public final void q() {
        this.n = this.f128f;
        this.o = this.f129h;
        this.p = this.f130i;
        this.z = false;
        Drawable drawable = this.A;
        j.c(drawable);
        drawable.setColorFilter(e.c.a.g.a.s.g.a(-16777216, 0.1f), PorterDuff.Mode.SRC_IN);
    }

    public final void r() {
        if (this.q) {
            return;
        }
        Timer timer = this.t;
        if (timer != null) {
            j.c(timer);
            timer.cancel();
            Timer timer2 = this.t;
            j.c(timer2);
            timer2.purge();
        }
        p();
        q();
        if (getDrawable() != null) {
            Drawable drawable = getDrawable();
            if (drawable instanceof LayerDrawable) {
                ((LayerDrawable) drawable).getDrawable(0).mutate().setColorFilter(this.z ? this.x : this.v, PorterDuff.Mode.SRC_IN);
            } else {
                drawable.mutate().setColorFilter(this.z ? this.x : this.v, PorterDuff.Mode.SRC_IN);
            }
        }
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator != null) {
            j.c(valueAnimator);
            if (valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.s;
                j.c(valueAnimator2);
                valueAnimator2.cancel();
                this.s = null;
            }
        }
        int[] iArr = new int[3];
        int i2 = this.f130i;
        iArr[0] = i2;
        iArr[1] = this.B == 0 ? this.l : this.m;
        iArr[2] = i2;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(iArr);
        this.s = valueAnimatorOfInt;
        if (valueAnimatorOfInt != null) {
            valueAnimatorOfInt.addUpdateListener(new b());
        }
        ValueAnimator valueAnimator3 = this.s;
        if (valueAnimator3 != null) {
            valueAnimator3.setDuration(2000L);
        }
        ValueAnimator valueAnimator4 = this.s;
        if (valueAnimator4 != null) {
            valueAnimator4.setRepeatCount(-1);
        }
        this.q = true;
        ValueAnimator valueAnimator5 = this.s;
        if (valueAnimator5 != null) {
            valueAnimator5.start();
        }
        Timer timer3 = new Timer();
        this.t = timer3;
        j.c(timer3);
        timer3.schedule(new a(this), TimeUnit.SECONDS.toMillis(this.E));
        this.u = SystemClock.elapsedRealtime();
    }

    public final void s() {
        this.u = 0L;
    }

    public final void setAngeleAnimator(ValueAnimator valueAnimator) {
        this.s = valueAnimator;
    }

    public final void setBgDrawable(Drawable drawable) {
        this.y = drawable;
    }

    public final void setChangeTime(int i2) {
        this.E = i2;
    }

    public final void setCircleStype(boolean z) {
        invalidate();
    }

    public final void setColorMode(int i2) {
    }

    public final void setLoadingType(int i2) {
    }

    public final void setOnLoadingListener(c cVar) {
        this.F = cVar;
    }

    public final void setPullScale(float f2) {
        Drawable drawable = this.y;
        if (drawable != null && (drawable instanceof GradientDrawable)) {
            Objects.requireNonNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            int i2 = this.B;
            gradientDrawable.setSize(i2 == 0 ? this.C : this.D, i2 == 0 ? this.C : this.D);
        }
        Drawable drawable2 = this.A;
        j.c(drawable2);
        drawable2.setColorFilter(this.z ? this.x : this.v, PorterDuff.Mode.SRC_IN);
        setImageDrawable(this.A);
        setScaleX(f2);
        setScaleY(f2);
    }

    public final void setUseLoadingApm(boolean z) {
    }

    public final void setViewSize(int i2) {
        this.B = i2;
        p();
    }

    public XCommonLoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = "wwh-XCommonLoadingView";
        RectF rectF = new RectF();
        this.f127d = rectF;
        this.f128f = 359;
        this.f129h = 179;
        this.f130i = 1;
        this.j = ShareCloudFileResource.HEIGHT;
        this.k = 5;
        this.l = 100;
        this.m = 50;
        this.n = 359;
        this.o = 179;
        this.p = 1;
        this.E = 3000;
        this.C = l1.c(44.0f);
        this.D = l1.c(34.0f);
        Drawable drawableMutate = getResources().getDrawable(R.drawable.x_refresh_loading_pic31).mutate();
        this.A = drawableMutate;
        j.c(drawableMutate);
        drawableMutate.setColorFilter(e.c.a.g.a.s.g.a(-16777216, 0.1f), PorterDuff.Mode.SRC_IN);
        Paint paint = new Paint();
        this.b = paint;
        if (paint != null) {
            paint.setAntiAlias(true);
        }
        Paint paint2 = this.b;
        if (paint2 != null) {
            paint2.setStrokeCap(Paint.Cap.ROUND);
        }
        Paint paint3 = this.b;
        if (paint3 != null) {
            paint3.setStyle(Paint.Style.STROKE);
        }
        Paint paint4 = this.b;
        if (paint4 != null) {
            paint4.setStrokeWidth(l1.c(2.0f));
        }
        rectF.set(0.0f, 0.0f, getWidth(), getBottom());
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public XCommonLoadingView(Context context) {
        this(context, null, 0, 4, null);
        setWHRatio(true, 1.0f);
    }
}
