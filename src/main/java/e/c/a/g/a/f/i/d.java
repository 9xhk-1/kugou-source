package e.c.a.g.a.f.i;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.kugou.android.watch.lite.R;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public View a;
    public boolean b;
    public boolean c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Rect f668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f670h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Matrix f671i;
    public float k;
    public Drawable m;
    public Drawable n;
    public Drawable o;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f666d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f667e = 1;
    public boolean j = false;
    public boolean l = false;
    public final Paint p = new Paint();
    public final Paint q = new Paint();
    public final Paint r = new Paint();

    public d(View view) {
        this.a = view;
    }

    public final Rect a() {
        RectF rectF = this.f670h;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float f4 = rectF.bottom;
        RectF rectF2 = new RectF(f2, ((f4 - f3) / 3.0f) + f3, rectF.right, f4 - ((f4 - f3) / 3.0f));
        this.f671i.mapRect(rectF2);
        return new Rect(Math.round(rectF2.left), Math.round(rectF2.top), Math.round(rectF2.right), Math.round(rectF2.bottom));
    }

    public final Rect b() {
        RectF rectF = this.f670h;
        RectF rectF2 = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
        this.f671i.mapRect(rectF2);
        return new Rect(Math.round(rectF2.left), Math.round(rectF2.top), Math.round(rectF2.right), Math.round(rectF2.bottom));
    }

    public final Rect c(RectF rectF) {
        RectF rectF2 = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
        this.f671i.mapRect(rectF2);
        return new Rect(Math.round(rectF2.left), Math.round(rectF2.top), Math.round(rectF2.right), Math.round(rectF2.bottom));
    }

    public void d(Canvas canvas) {
        if (this.c) {
            return;
        }
        canvas.save();
        Path path = new Path();
        if (!j()) {
            this.r.setColor(this.f666d ? -855638017 : -16777216);
            canvas.drawRect(this.f668f, this.r);
            return;
        }
        Rect rect = new Rect();
        this.a.getDrawingRect(rect);
        if (this.l) {
            float fWidth = this.f668f.width();
            float fHeight = this.f668f.height();
            Rect rect2 = this.f668f;
            float f2 = fWidth / 2.0f;
            path.addCircle(rect2.left + f2, rect2.top + (fHeight / 2.0f), f2, Path.Direction.CW);
            this.r.setColor(this.f666d ? -855638017 : -1112874);
        } else {
            path.addRect(new RectF(this.f668f), Path.Direction.CW);
            this.r.setColor(this.f666d ? -855638017 : -1);
        }
        if (m(canvas)) {
            try {
                if (this.f666d) {
                    Path path2 = new Path();
                    path2.addRect(new RectF(a()), Path.Direction.CW);
                    Paint paint = new Paint();
                    paint.reset();
                    paint.setStrokeWidth(3.0f);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setAntiAlias(true);
                    paint.setColor(-855638017);
                    paint.setPathEffect(new DashPathEffect(new float[]{20.0f, 10.0f}, 0.0f));
                    Path path3 = new Path();
                    path3.moveTo(r6.left, r6.top);
                    path3.lineTo(r6.right, r6.top);
                    canvas.drawPath(path3, paint);
                    Path path4 = new Path();
                    path4.moveTo(r6.left, r6.bottom);
                    path4.lineTo(r6.right, r6.bottom);
                    canvas.drawPath(path4, paint);
                    canvas.clipPath(path2, Region.Op.DIFFERENCE);
                } else {
                    canvas.clipPath(path, Region.Op.DIFFERENCE);
                }
            } catch (UnsupportedOperationException unused) {
            }
            canvas.drawRect(rect, j() ? this.p : this.q);
        } else {
            e(canvas);
        }
        canvas.restore();
        canvas.drawPath(path, this.r);
        if (this.f667e == 3) {
            if (this.l) {
                int intrinsicWidth = this.o.getIntrinsicWidth();
                int intrinsicHeight = this.o.getIntrinsicHeight();
                double dCos = Math.cos(0.7853981633974483d);
                double dWidth = this.f668f.width();
                Double.isNaN(dWidth);
                int iRound = (int) Math.round(dCos * (dWidth / 2.0d));
                Rect rect3 = this.f668f;
                int iWidth = ((rect3.left + (rect3.width() / 2)) + iRound) - (intrinsicWidth / 2);
                Rect rect4 = this.f668f;
                int iHeight = ((rect4.top + (rect4.height() / 2)) - iRound) - (intrinsicHeight / 2);
                Drawable drawable = this.o;
                drawable.setBounds(iWidth, iHeight, drawable.getIntrinsicWidth() + iWidth, this.o.getIntrinsicHeight() + iHeight);
                this.o.draw(canvas);
                return;
            }
            Rect rect5 = this.f668f;
            int i2 = rect5.left + 1;
            int i3 = rect5.right + 1;
            int i4 = rect5.top + 4;
            int i5 = rect5.bottom + 3;
            int intrinsicWidth2 = this.m.getIntrinsicWidth() / 2;
            int intrinsicHeight2 = this.m.getIntrinsicHeight() / 2;
            int intrinsicHeight3 = this.n.getIntrinsicHeight() / 2;
            int intrinsicWidth3 = this.n.getIntrinsicWidth() / 2;
            Rect rect6 = this.f668f;
            int i6 = rect6.left;
            int i7 = i6 + ((rect6.right - i6) / 2);
            int i8 = rect6.top;
            int i9 = i8 + ((rect6.bottom - i8) / 2);
            int i10 = i9 - intrinsicHeight2;
            int i11 = i9 + intrinsicHeight2;
            this.m.setBounds(i2 - intrinsicWidth2, i10, i2 + intrinsicWidth2, i11);
            this.m.draw(canvas);
            this.m.setBounds(i3 - intrinsicWidth2, i10, i3 + intrinsicWidth2, i11);
            this.m.draw(canvas);
            int i12 = i7 - intrinsicWidth3;
            int i13 = i7 + intrinsicWidth3;
            this.n.setBounds(i12, i4 - intrinsicHeight3, i13, i4 + intrinsicHeight3);
            this.n.draw(canvas);
            this.n.setBounds(i12, i5 - intrinsicHeight3, i13, i5 + intrinsicHeight3);
            this.n.draw(canvas);
        }
    }

    public final void e(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), this.f668f.top, this.q);
        canvas.drawRect(0.0f, this.f668f.bottom, canvas.getWidth(), canvas.getHeight(), this.q);
        Rect rect = this.f668f;
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom, this.q);
        Rect rect2 = this.f668f;
        canvas.drawRect(rect2.right, rect2.top, canvas.getWidth(), this.f668f.bottom, this.q);
    }

    public Rect f() {
        RectF rectF = this.f670h;
        return new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public int g(float f2, float f3) {
        Rect rectB = b();
        if (this.l) {
            float fCenterX = f2 - rectB.centerX();
            float fCenterY = f3 - rectB.centerY();
            int iSqrt = (int) Math.sqrt((fCenterX * fCenterX) + (fCenterY * fCenterY));
            int iWidth = this.f668f.width() / 2;
            return ((float) Math.abs(iSqrt - iWidth)) <= 20.0f ? Math.abs(fCenterY) > Math.abs(fCenterX) ? fCenterY < 0.0f ? 8 : 16 : fCenterX < 0.0f ? 2 : 4 : iSqrt < iWidth ? 32 : 1;
        }
        boolean z = false;
        boolean z2 = f3 >= ((float) rectB.top) - 20.0f && f3 < ((float) rectB.bottom) + 20.0f;
        int i2 = rectB.left;
        if (f2 >= i2 - 20.0f && f2 < rectB.right + 20.0f) {
            z = true;
        }
        int i3 = (Math.abs(((float) i2) - f2) >= 20.0f || !z2) ? 1 : 3;
        if (Math.abs(rectB.right - f2) < 20.0f && z2) {
            i3 |= 4;
        }
        if (Math.abs(rectB.top - f3) < 20.0f && z) {
            i3 |= 8;
        }
        if (Math.abs(rectB.bottom - f3) < 20.0f && z) {
            i3 |= 16;
        }
        if (i3 == 1 && rectB.contains((int) f2, (int) f3)) {
            return 32;
        }
        return i3;
    }

    public void h(float f2, float f3) {
        if (this.j) {
            if (f2 != 0.0f) {
                f3 = f2 / this.k;
            } else if (f3 != 0.0f) {
                f2 = this.k * f3;
            }
        }
        RectF rectF = new RectF(this.f670h);
        if (f2 > 0.0f && rectF.width() + (f2 * 2.0f) > this.f669g.width()) {
            f2 = (this.f669g.width() - rectF.width()) / 2.0f;
            if (this.j) {
                f3 = f2 / this.k;
            }
        }
        if (f3 > 0.0f && rectF.height() + (f3 * 2.0f) > this.f669g.height()) {
            f3 = (this.f669g.height() - rectF.height()) / 2.0f;
            if (this.j) {
                f2 = this.k * f3;
            }
        }
        rectF.inset(-f2, -f3);
        if (rectF.width() < 25.0f) {
            rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
        }
        float f4 = this.j ? 25.0f / this.k : 25.0f;
        if (rectF.height() < f4) {
            rectF.inset(0.0f, (-(f4 - rectF.height())) / 2.0f);
        }
        float f5 = rectF.left;
        RectF rectF2 = this.f669g;
        float f6 = rectF2.left;
        if (f5 < f6) {
            rectF.offset(f6 - f5, 0.0f);
        } else {
            float f7 = rectF.right;
            float f8 = rectF2.right;
            if (f7 > f8) {
                rectF.offset(-(f7 - f8), 0.0f);
            }
        }
        float f9 = rectF.top;
        RectF rectF3 = this.f669g;
        float f10 = rectF3.top;
        if (f9 < f10) {
            rectF.offset(0.0f, f10 - f9);
        } else {
            float f11 = rectF.bottom;
            float f12 = rectF3.bottom;
            if (f11 > f12) {
                rectF.offset(0.0f, -(f11 - f12));
            }
        }
        int width = this.a.getWidth() - 10;
        int height = this.a.getHeight() - 10;
        Rect rectC = c(rectF);
        if (rectC.width() > width || rectC.height() > height) {
            if (g0.a) {
                g0.c("vz-growBy", "截图款超过屏幕");
            }
        } else {
            this.f670h.set(rectF);
            this.f668f = rectC;
            this.a.invalidate();
        }
    }

    public void i(int i2, float f2, float f3) {
        Rect rectB = b();
        if (i2 == 1) {
            return;
        }
        if (i2 == 32) {
            n(f2 * (this.f670h.width() / rectB.width()), f3 * (this.f670h.height() / rectB.height()));
            return;
        }
        if ((i2 & 6) == 0) {
            f2 = 0.0f;
        }
        if ((i2 & 24) == 0) {
            f3 = 0.0f;
        }
        h(((i2 & 2) != 0 ? -1 : 1) * f2 * (this.f670h.width() / rectB.width()), ((i2 & 8) != 0 ? -1 : 1) * f3 * (this.f670h.height() / rectB.height()));
    }

    public boolean j() {
        return this.b;
    }

    public final void k() {
        Resources resources = this.a.getResources();
        this.m = resources.getDrawable(R.drawable.camera_crop_width);
        this.n = resources.getDrawable(R.drawable.camera_crop_height);
        this.o = resources.getDrawable(R.drawable.indicator_autocrop);
    }

    public void l() {
        this.f668f = b();
    }

    @SuppressLint({"NewApi"})
    public final boolean m(Canvas canvas) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 17) {
            return false;
        }
        if (i2 < 14 || i2 > 15) {
            return true;
        }
        return !canvas.isHardwareAccelerated();
    }

    public void n(float f2, float f3) {
        Rect rect = new Rect(this.f668f);
        this.f670h.offset(f2, f3);
        RectF rectF = this.f670h;
        rectF.offset(Math.max(0.0f, this.f669g.left - rectF.left), Math.max(0.0f, this.f669g.top - this.f670h.top));
        RectF rectF2 = this.f670h;
        rectF2.offset(Math.min(0.0f, this.f669g.right - rectF2.right), Math.min(0.0f, this.f669g.bottom - this.f670h.bottom));
        Rect rectB = b();
        this.f668f = rectB;
        rect.union(rectB);
        rect.inset(-10, -10);
        this.a.invalidate(rect);
    }

    public void o(boolean z) {
        this.b = z;
    }

    public void p(boolean z) {
        this.f666d = z;
    }

    public void q(boolean z) {
        this.c = z;
    }

    public void r(int i2) {
        if (i2 != this.f667e) {
            this.f667e = i2;
            this.a.invalidate();
        }
    }

    public void s(Matrix matrix, Rect rect, RectF rectF, boolean z, boolean z2) {
        if (z) {
            z2 = true;
        }
        this.f671i = new Matrix(matrix);
        RectF rectF2 = new RectF(rectF);
        if (this.f671i.mapRect(rectF2)) {
            int width = this.a.getWidth() - 10;
            int iWidth = (int) rectF2.width();
            int i2 = width - iWidth;
            if (i2 < 0 && iWidth != 0) {
                if (g0.a) {
                    g0.c("vz-setup 2", "dw " + i2);
                }
                rectF2.inset((-i2) / 2, (-((((int) rectF2.height()) / iWidth) * i2)) / 2);
                Matrix matrix2 = new Matrix();
                if (this.f671i.invert(matrix2)) {
                    matrix2.mapRect(rectF2);
                    rectF = rectF2;
                } else if (g0.a) {
                    g0.c("vz-setup 3", "invert failed");
                }
            }
        } else if (g0.a) {
            g0.c("vz-setup 1", "mapRect failed");
        }
        this.f670h = rectF;
        this.f669g = new RectF(rect);
        this.j = z2;
        this.l = z;
        this.k = this.f670h.width() / this.f670h.height();
        this.f668f = b();
        this.p.setARGB(125, 50, 50, 50);
        this.q.setARGB(125, 50, 50, 50);
        this.r.setStrokeWidth(3.0f);
        this.r.setStyle(Paint.Style.STROKE);
        this.r.setAntiAlias(true);
        this.f667e = 1;
        k();
    }
}
