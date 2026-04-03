package com.kugou.android.watch.lite.common.widget.image;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import com.kugou.uilib.widget.imageview.round.roundedimageview.Corner;
import com.kugou.uilib.widget.imageview.round.roundedimageview.RoundedDrawable;
import e.c.a.g.a.f.o.f.b;

/* JADX INFO: loaded from: classes.dex */
public class RoundedImageView extends AppCompatImageView {
    public static final Shader.TileMode t = Shader.TileMode.CLAMP;
    public static final ImageView.ScaleType[] u = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public final float[] a;
    public Drawable b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorStateList f131d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f132f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorFilter f133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f134i;
    public Drawable j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public ImageView.ScaleType p;
    public Shader.TileMode q;
    public Shader.TileMode r;
    public boolean s;

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
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static Shader.TileMode d(int i2) {
        if (i2 == 0) {
            return Shader.TileMode.CLAMP;
        }
        if (i2 == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i2 != 2) {
            return null;
        }
        return Shader.TileMode.MIRROR;
    }

    public final void a() {
        Drawable drawable = this.j;
        if (drawable == null || !this.f134i) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.j = drawableMutate;
        if (this.k) {
            drawableMutate.setColorFilter(this.f133h);
        }
    }

    public final void b() {
        Drawable drawable = this.j;
        if (drawable == null || !(drawable instanceof b)) {
            return;
        }
        ((b) drawable).h(null);
    }

    public float c(@Corner int i2) {
        return this.a[i2];
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
        if (this.s) {
            setAlpha((isPressed() || isFocused() || isSelected()) ? 0.3f : 1.0f);
        }
    }

    public final Drawable e() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.o;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception e2) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.o, e2);
                this.o = 0;
            }
        }
        return RoundedDrawable.fromDrawable(drawable);
    }

    public final Drawable f() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.n;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception e2) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.n, e2);
                this.n = 0;
            }
        }
        return b.e(drawable);
    }

    public void g(float f2, float f3, float f4, float f5) {
        float[] fArr = this.a;
        if (fArr[0] == f2 && fArr[1] == f3 && fArr[2] == f5 && fArr[3] == f4) {
            return;
        }
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[3] = f4;
        fArr[2] = f5;
        j();
        i(false);
        invalidate();
    }

    @ColorInt
    public int getBorderColor() {
        return this.f131d.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.f131d;
    }

    public float getBorderWidth() {
        return this.f132f;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f2 : this.a) {
            fMax = Math.max(f2, fMax);
        }
        return fMax;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.p;
    }

    public Shader.TileMode getTileModeX() {
        return this.q;
    }

    public Shader.TileMode getTileModeY() {
        return this.r;
    }

    public final void h(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof RoundedDrawable) {
            RoundedDrawable roundedDrawable = (RoundedDrawable) drawable;
            roundedDrawable.setScaleType(scaleType).setBorderWidth(this.f132f).setBorderColor(this.f131d).setOval(this.l).setTileModeX(this.q).setTileModeY(this.r);
            float[] fArr = this.a;
            if (fArr != null) {
                roundedDrawable.setCornerRadius(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            a();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                h(layerDrawable.getDrawable(i2), scaleType);
            }
        }
    }

    public final void i(boolean z) {
        if (this.m) {
            if (z) {
                this.b = RoundedDrawable.fromDrawable(this.b);
            }
            h(this.b, ImageView.ScaleType.FIT_XY);
        }
    }

    public final void j() {
        h(this.j, this.p);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        ColorDrawable colorDrawable = new ColorDrawable(i2);
        this.b = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.b = drawable;
        i(true);
        super.setBackgroundDrawable(this.b);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        if (this.o != i2) {
            this.o = i2;
            Drawable drawableE = e();
            this.b = drawableE;
            setBackgroundDrawable(drawableE);
        }
    }

    public void setBorderColor(@ColorInt int i2) {
        setBorderColor(ColorStateList.valueOf(i2));
    }

    public void setBorderWidth(@DimenRes int i2) {
        setBorderWidth(getResources().getDimension(i2));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f133h != colorFilter) {
            this.f133h = colorFilter;
            this.k = true;
            this.f134i = true;
            a();
            invalidate();
        }
    }

    public void setCornerRadius(float f2) {
        g(f2, f2, f2, f2);
    }

    public void setCornerRadiusDimen(@DimenRes int i2) {
        float dimension = getResources().getDimension(i2);
        g(dimension, dimension, dimension, dimension);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        b();
        this.n = 0;
        this.j = b.d(bitmap);
        j();
        super.setImageDrawable(this.j);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        b();
        this.n = 0;
        this.j = b.e(drawable);
        j();
        super.setImageDrawable(this.j);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int i2) {
        if (this.n != i2) {
            b();
            this.n = i2;
            this.j = f();
            j();
            super.setImageDrawable(this.j);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z) {
        this.l = z;
        j();
        i(false);
        invalidate();
    }

    public void setRadius(int[] iArr) {
        if (iArr.length < 4) {
            return;
        }
        float[] fArr = this.a;
        fArr[0] = iArr[0];
        fArr[1] = iArr[1];
        fArr[3] = iArr[2];
        fArr[2] = iArr[3];
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.p != scaleType) {
            this.p = scaleType;
            switch (a.a[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            j();
            i(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.q == tileMode) {
            return;
        }
        this.q = tileMode;
        j();
        i(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.r == tileMode) {
            return;
        }
        this.r = tileMode;
        j();
        i(false);
        invalidate();
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.a = fArr;
        this.f131d = ColorStateList.valueOf(-16777216);
        this.f132f = 0.0f;
        this.f133h = null;
        this.f134i = false;
        this.k = false;
        this.l = false;
        this.m = false;
        Shader.TileMode tileMode = t;
        this.q = tileMode;
        this.r = tileMode;
        this.s = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.c.a.g.a.b.RoundedImageView, i2, 0);
        int i3 = typedArrayObtainStyledAttributes.getInt(0, -1);
        if (i3 >= 0) {
            setScaleType(u[i3]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, -1);
        fArr[0] = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, -1);
        fArr[1] = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
        fArr[2] = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, -1);
        fArr[3] = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, -1);
        int length = fArr.length;
        boolean z = false;
        for (int i4 = 0; i4 < length; i4++) {
            float[] fArr2 = this.a;
            if (fArr2[i4] < 0.0f) {
                fArr2[i4] = 0.0f;
            } else {
                z = true;
            }
        }
        if (!z) {
            dimensionPixelSize = dimensionPixelSize < 0.0f ? 0.0f : dimensionPixelSize;
            int length2 = this.a.length;
            for (int i5 = 0; i5 < length2; i5++) {
                this.a[i5] = dimensionPixelSize;
            }
        }
        float dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1);
        this.f132f = dimensionPixelSize2;
        if (dimensionPixelSize2 < 0.0f) {
            this.f132f = 0.0f;
        }
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(1);
        this.f131d = colorStateList;
        if (colorStateList == null) {
            this.f131d = ColorStateList.valueOf(-16777216);
        }
        this.m = typedArrayObtainStyledAttributes.getBoolean(8, false);
        this.l = typedArrayObtainStyledAttributes.getBoolean(9, false);
        this.s = typedArrayObtainStyledAttributes.getBoolean(10, false);
        int i6 = typedArrayObtainStyledAttributes.getInt(11, -2);
        if (i6 != -2) {
            setTileModeX(d(i6));
            setTileModeY(d(i6));
        }
        int i7 = typedArrayObtainStyledAttributes.getInt(12, -2);
        if (i7 != -2) {
            setTileModeX(d(i7));
        }
        int i8 = typedArrayObtainStyledAttributes.getInt(13, -2);
        if (i8 != -2) {
            setTileModeY(d(i8));
        }
        j();
        i(true);
        if (this.m) {
            super.setBackgroundDrawable(this.b);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.f131d.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.f131d = colorStateList;
        j();
        i(false);
        if (this.f132f > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f2) {
        if (this.f132f == f2) {
            return;
        }
        this.f132f = f2;
        j();
        i(false);
        invalidate();
    }
}
