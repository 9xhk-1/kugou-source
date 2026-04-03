package e.c.a.g.a.f.o.f;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kugou.uilib.widget.imageview.round.roundedimageview.RoundedDrawable;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class b extends Drawable {
    public final RectF a;
    public final RectF b;
    public final RectF c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bitmap f711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f716i;
    public final Matrix j;
    public final RectF k;
    public Shader.TileMode l;
    public Shader.TileMode m;
    public boolean n;
    public InterfaceC0105b o;
    public float p;
    public final boolean[] q;
    public boolean r;
    public float s;
    public ColorStateList t;
    public ImageView.ScaleType u;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.f.o.f.b$b, reason: collision with other inner class name */
    public interface InterfaceC0105b {
        void draw(Canvas canvas, RectF rectF, float f2);
    }

    public static boolean a(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap c(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Exception e2) {
            g0.k(e2);
            Log.w(RoundedDrawable.TAG, "Failed to create bitmap from drawable!");
            return null;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            Log.w(RoundedDrawable.TAG, "Failed to create bitmap from drawable ---- OutOfMemoryError!");
            return null;
        }
    }

    public static RoundedDrawable d(Bitmap bitmap) {
        if (bitmap != null) {
            return new RoundedDrawable(bitmap);
        }
        return null;
    }

    public static Drawable e(Drawable drawable) {
        if (drawable == null || (drawable instanceof RoundedDrawable)) {
            return drawable;
        }
        if (!(drawable instanceof LayerDrawable)) {
            Bitmap bitmapC = c(drawable);
            return bitmapC != null ? new RoundedDrawable(bitmapC) : drawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), e(layerDrawable.getDrawable(i2)));
        }
        return layerDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.n) {
            BitmapShader bitmapShader = new BitmapShader(this.f711d, this.l, this.m);
            Shader.TileMode tileMode = this.l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.m == tileMode2) {
                bitmapShader.setLocalMatrix(this.j);
            }
            this.f712e.setShader(bitmapShader);
            this.n = false;
        }
        if (this.r) {
            if (this.s > 0.0f) {
                canvas.drawOval(this.b, this.f712e);
                canvas.drawOval(this.f715h, this.f716i);
            } else {
                canvas.drawOval(this.b, this.f712e);
            }
        } else if (b(this.q)) {
            float f2 = this.p;
            if (this.s > 0.0f) {
                canvas.drawRoundRect(this.b, f2, f2, this.f712e);
                canvas.drawRoundRect(this.f715h, f2, f2, this.f716i);
                f(canvas);
                g(canvas);
            } else {
                canvas.drawRoundRect(this.b, f2, f2, this.f712e);
                f(canvas);
            }
        } else {
            canvas.drawRect(this.b, this.f712e);
            if (this.s > 0.0f) {
                canvas.drawRect(this.f715h, this.f716i);
            }
        }
        InterfaceC0105b interfaceC0105b = this.o;
        if (interfaceC0105b != null) {
            interfaceC0105b.draw(canvas, this.b, this.p);
        }
    }

    public final void f(Canvas canvas) {
        if (a(this.q) || this.p == 0.0f) {
            return;
        }
        RectF rectF = this.b;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float fWidth = rectF.width() + f2;
        float fHeight = this.b.height() + f3;
        float f4 = this.p;
        if (!this.q[0]) {
            this.k.set(f2, f3, f2 + f4, f3 + f4);
            canvas.drawRect(this.k, this.f712e);
        }
        if (!this.q[1]) {
            this.k.set(fWidth - f4, f3, fWidth, f4);
            canvas.drawRect(this.k, this.f712e);
        }
        if (!this.q[2]) {
            this.k.set(fWidth - f4, fHeight - f4, fWidth, fHeight);
            canvas.drawRect(this.k, this.f712e);
        }
        if (this.q[3]) {
            return;
        }
        this.k.set(f2, fHeight - f4, f4 + f2, fHeight);
        canvas.drawRect(this.k, this.f712e);
    }

    public final void g(Canvas canvas) {
        float f2;
        if (a(this.q) || this.p == 0.0f) {
            return;
        }
        RectF rectF = this.b;
        float f3 = rectF.left;
        float f4 = rectF.top;
        float fWidth = rectF.width() + f3;
        float fHeight = f4 + this.b.height();
        float f5 = this.p;
        float f6 = this.s / 2.0f;
        if (!this.q[0]) {
            canvas.drawLine(f3 - f6, f4, f3 + f5, f4, this.f716i);
            canvas.drawLine(f3, f4 - f6, f3, f4 + f5, this.f716i);
        }
        if (!this.q[1]) {
            canvas.drawLine((fWidth - f5) - f6, f4, fWidth, f4, this.f716i);
            canvas.drawLine(fWidth, f4 - f6, fWidth, f4 + f5, this.f716i);
        }
        if (this.q[2]) {
            f2 = f5;
        } else {
            f2 = f5;
            canvas.drawLine((fWidth - f5) - f6, fHeight, fWidth + f6, fHeight, this.f716i);
            canvas.drawLine(fWidth, fHeight - f2, fWidth, fHeight, this.f716i);
        }
        if (this.q[3]) {
            return;
        }
        canvas.drawLine(f3 - f6, fHeight, f3 + f2, fHeight, this.f716i);
        canvas.drawLine(f3, fHeight - f2, f3, fHeight, this.f716i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f712e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f712e.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f714g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f713f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(InterfaceC0105b interfaceC0105b) {
        this.o = interfaceC0105b;
    }

    public final void i() {
        float fWidth;
        float fHeight;
        switch (a.a[this.u.ordinal()]) {
            case 1:
                this.f715h.set(this.a);
                RectF rectF = this.f715h;
                float f2 = this.s;
                rectF.inset(f2 / 2.0f, f2 / 2.0f);
                this.j.reset();
                this.j.setTranslate((int) (((this.f715h.width() - this.f713f) * 0.5f) + 0.5f), (int) (((this.f715h.height() - this.f714g) * 0.5f) + 0.5f));
                break;
            case 2:
                this.f715h.set(this.a);
                RectF rectF2 = this.f715h;
                float f3 = this.s;
                rectF2.inset(f3 / 2.0f, f3 / 2.0f);
                this.j.reset();
                float fWidth2 = 0.0f;
                if (this.f713f * this.f715h.height() > this.f715h.width() * this.f714g) {
                    fWidth = this.f715h.height() / this.f714g;
                    fWidth2 = (this.f715h.width() - (this.f713f * fWidth)) * 0.5f;
                    fHeight = 0.0f;
                } else {
                    fWidth = this.f715h.width() / this.f713f;
                    fHeight = (this.f715h.height() - (this.f714g * fWidth)) * 0.5f;
                }
                this.j.setScale(fWidth, fWidth);
                Matrix matrix = this.j;
                float f4 = this.s;
                matrix.postTranslate(((int) (fWidth2 + 0.5f)) + (f4 / 2.0f), ((int) (fHeight + 0.5f)) + (f4 / 2.0f));
                break;
            case 3:
                this.j.reset();
                float fMin = (((float) this.f713f) > this.a.width() || ((float) this.f714g) > this.a.height()) ? Math.min(this.a.width() / this.f713f, this.a.height() / this.f714g) : 1.0f;
                float fWidth3 = (int) (((this.a.width() - (this.f713f * fMin)) * 0.5f) + 0.5f);
                float fHeight2 = (int) (((this.a.height() - (this.f714g * fMin)) * 0.5f) + 0.5f);
                this.j.setScale(fMin, fMin);
                this.j.postTranslate(fWidth3, fHeight2);
                this.f715h.set(this.c);
                this.j.mapRect(this.f715h);
                RectF rectF3 = this.f715h;
                float f5 = this.s;
                rectF3.inset(f5 / 2.0f, f5 / 2.0f);
                this.j.setRectToRect(this.c, this.f715h, Matrix.ScaleToFit.FILL);
                break;
            case 4:
                this.f715h.set(this.c);
                this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.END);
                this.j.mapRect(this.f715h);
                RectF rectF4 = this.f715h;
                float f6 = this.s;
                rectF4.inset(f6 / 2.0f, f6 / 2.0f);
                this.j.setRectToRect(this.c, this.f715h, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.f715h.set(this.c);
                this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.START);
                this.j.mapRect(this.f715h);
                RectF rectF5 = this.f715h;
                float f7 = this.s;
                rectF5.inset(f7 / 2.0f, f7 / 2.0f);
                this.j.setRectToRect(this.c, this.f715h, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.f715h.set(this.a);
                RectF rectF6 = this.f715h;
                float f8 = this.s;
                rectF6.inset(f8 / 2.0f, f8 / 2.0f);
                this.j.reset();
                this.j.setRectToRect(this.c, this.f715h, Matrix.ScaleToFit.FILL);
                break;
            default:
                this.f715h.set(this.c);
                this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.CENTER);
                this.j.mapRect(this.f715h);
                RectF rectF7 = this.f715h;
                float f9 = this.s;
                rectF7.inset(f9 / 2.0f, f9 / 2.0f);
                this.j.setRectToRect(this.c, this.f715h, Matrix.ScaleToFit.FILL);
                break;
        }
        this.b.set(this.f715h);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.t.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.a.set(rect);
        i();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.t.getColorForState(iArr, 0);
        if (this.f716i.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.f716i.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f712e.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f712e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f712e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f712e.setFilterBitmap(z);
        invalidateSelf();
    }
}
