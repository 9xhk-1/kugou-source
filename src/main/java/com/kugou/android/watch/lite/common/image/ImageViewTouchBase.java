package com.kugou.android.watch.lite.common.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;
import e.c.a.g.a.f.i.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class ImageViewTouchBase extends ImageView {
    public Matrix a;
    public Matrix b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f103d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f104f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f106i;
    public int j;
    public float k;
    public c l;
    public Handler m;
    public Runnable n;

    public class a implements Runnable {
        public final /* synthetic */ j a;
        public final /* synthetic */ boolean b;

        public a(j jVar, boolean z) {
            this.a = jVar;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageViewTouchBase.this.l(this.a, this.b);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ float a;
        public final /* synthetic */ long b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f108d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ float f109f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ float f110h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ float f111i;

        public b(float f2, long j, float f3, float f4, float f5, float f6) {
            this.a = f2;
            this.b = j;
            this.f108d = f3;
            this.f109f = f4;
            this.f110h = f5;
            this.f111i = f6;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMin = Math.min(this.a, System.currentTimeMillis() - this.b);
            ImageViewTouchBase.this.n(this.f108d + (this.f109f * fMin), this.f110h, this.f111i);
            if (fMin < this.a) {
                ImageViewTouchBase.this.m.post(this);
            }
        }
    }

    public interface c {
        void recycle(Bitmap bitmap);
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Matrix();
        this.b = new Matrix();
        this.f103d = new Matrix();
        this.f104f = new float[9];
        this.f105h = new j(null);
        this.f106i = -1;
        this.j = -1;
        this.m = new Handler();
        this.n = null;
        f();
    }

    public void a(boolean z, boolean z2) {
        float f2;
        float f3;
        float height;
        float f4;
        if (this.f105h.a() == null) {
            return;
        }
        Matrix imageViewMatrix = getImageViewMatrix();
        float f5 = 0.0f;
        RectF rectF = new RectF(0.0f, 0.0f, this.f105h.a().getWidth(), this.f105h.a().getHeight());
        imageViewMatrix.mapRect(rectF);
        float fHeight = rectF.height();
        float fWidth = rectF.width();
        if (z2) {
            float height2 = getHeight();
            if (fHeight < height2) {
                height = (height2 - fHeight) / 2.0f;
                f4 = rectF.top;
            } else {
                float f6 = rectF.top;
                if (f6 > 0.0f) {
                    f2 = -f6;
                } else {
                    if (rectF.bottom < height2) {
                        height = getHeight();
                        f4 = rectF.bottom;
                    }
                    f2 = 0.0f;
                }
            }
            f2 = height - f4;
        } else {
            f2 = 0.0f;
        }
        if (z) {
            float width = getWidth();
            if (fWidth < width) {
                width = (width - fWidth) / 2.0f;
                f3 = rectF.left;
            } else {
                float f7 = rectF.left;
                if (f7 > 0.0f) {
                    f5 = -f7;
                } else {
                    f3 = rectF.right;
                    if (f3 < width) {
                    }
                }
            }
            f5 = width - f3;
        }
        i(f5, f2);
        setImageMatrix(getImageViewMatrix());
    }

    public void b() {
        k(null, true);
    }

    public final void c(j jVar, Matrix matrix) {
        float width = getWidth();
        float height = getHeight();
        float fE = jVar.e();
        float fB = jVar.b();
        matrix.reset();
        float fMax = Math.max(Math.min(width / fE, 3.0f), Math.min(height / fB, 3.0f));
        matrix.postConcat(jVar.c());
        matrix.postScale(fMax, fMax);
        matrix.postTranslate((width - (fE * fMax)) / 2.0f, (height - (fB * fMax)) / 2.0f);
    }

    public float d(Matrix matrix) {
        return e(matrix, 0);
    }

    public float e(Matrix matrix, int i2) {
        matrix.getValues(this.f104f);
        return this.f104f[i2];
    }

    public final void f() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public float g() {
        if (this.f105h.a() == null) {
            return 1.0f;
        }
        return Math.max(this.f105h.e() / this.f106i, this.f105h.b() / this.j) * 4.0f;
    }

    public Matrix getBaseMatrix() {
        return this.a;
    }

    public Matrix getImageViewMatrix() {
        this.f103d.set(this.a);
        this.f103d.postConcat(this.b);
        return this.f103d;
    }

    public float getScale() {
        return d(this.b);
    }

    public Matrix getSuppMatrix() {
        return this.b;
    }

    public Matrix getUnrotatedMatrix() {
        Matrix matrix = new Matrix();
        c(this.f105h, matrix);
        matrix.postConcat(this.b);
        return matrix;
    }

    public void h(float f2, float f3) {
        i(f2, f3);
        setImageMatrix(getImageViewMatrix());
    }

    public void i(float f2, float f3) {
        this.b.postTranslate(f2, f3);
    }

    public final void j(Bitmap bitmap, int i2) {
        c cVar;
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap bitmapA = this.f105h.a();
        this.f105h.g(bitmap);
        this.f105h.h(i2);
        if (bitmapA == null || bitmapA == bitmap || (cVar = this.l) == null) {
            return;
        }
        cVar.recycle(bitmapA);
    }

    public void k(Bitmap bitmap, boolean z) {
        l(new j(bitmap), z);
    }

    public void l(j jVar, boolean z) {
        if (getWidth() <= 0) {
            this.n = new a(jVar, z);
            return;
        }
        if (jVar.a() != null) {
            c(jVar, this.a);
            j(jVar.a(), jVar.d());
        } else {
            this.a.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.b.reset();
        }
        setImageMatrix(getImageViewMatrix());
        this.k = g();
    }

    public void m(float f2) {
        n(f2, getWidth() / 2.0f, getHeight() / 2.0f);
    }

    public void n(float f2, float f3, float f4) {
        float f5 = this.k;
        if (f2 > f5) {
            f2 = f5;
        }
        float scale = f2 / getScale();
        this.b.postScale(scale, scale, f3, f4);
        setImageMatrix(getImageViewMatrix());
        a(true, true);
    }

    public void o(float f2, float f3, float f4, float f5) {
        float scale = (f2 - getScale()) / f5;
        float scale2 = getScale();
        this.m.post(new b(f5, System.currentTimeMillis(), scale2, scale, f3, f4));
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i2, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !keyEvent.isTracking() || keyEvent.isCanceled() || getScale() <= 1.0f) {
            return super.onKeyUp(i2, keyEvent);
        }
        m(1.0f);
        return true;
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f106i = i4 - i2;
        this.j = i5 - i3;
        Runnable runnable = this.n;
        if (runnable != null) {
            this.n = null;
            runnable.run();
        }
        if (this.f105h.a() != null) {
            c(this.f105h, this.a);
            setImageMatrix(getImageViewMatrix());
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        j(bitmap, 0);
    }

    public void setRecycler(c cVar) {
        this.l = cVar;
    }
}
