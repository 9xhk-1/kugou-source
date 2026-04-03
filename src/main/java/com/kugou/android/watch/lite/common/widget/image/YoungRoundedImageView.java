package com.kugou.android.watch.lite.common.widget.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import com.kugou.android.watch.lite.R;
import e.c.a.g.a.b;
import e.c.a.g.a.f.o.f.a;

/* JADX INFO: loaded from: classes.dex */
public class YoungRoundedImageView extends RoundedImageView {
    public float v;
    public float w;
    public boolean x;
    public a y;

    public YoungRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.kugou.android.watch.lite.common.widget.image.RoundedImageView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.x) {
            setAlpha((isPressed() || isFocused() || isSelected()) ? this.w : this.v);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        a aVar = this.y;
        if (aVar != null) {
            aVar.b(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a aVar = this.y;
        if (aVar != null) {
            aVar.c(i2, i3, c(0), c(2));
        }
    }

    public void setBgColor(int i2) {
        this.y.d(i2);
    }

    public void setHidePlaceHolder(boolean z) {
        this.y.f(z);
    }

    public void setIconColor(int i2) {
        this.y.g(i2);
    }

    @Override // com.kugou.android.watch.lite.common.widget.image.RoundedImageView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        a aVar = this.y;
        if (aVar != null) {
            aVar.e(bitmap == null);
        }
    }

    @Override // com.kugou.android.watch.lite.common.widget.image.RoundedImageView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        a aVar = this.y;
        if (aVar != null) {
            aVar.e(drawable == null);
        }
    }

    @Override // com.kugou.android.watch.lite.common.widget.image.RoundedImageView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        a aVar = this.y;
        if (aVar != null) {
            aVar.e(i2 == 0);
        }
    }

    @Override // com.kugou.android.watch.lite.common.widget.image.RoundedImageView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        a aVar = this.y;
        if (aVar != null) {
            aVar.e(uri == null);
        }
    }

    public void setIsSquare(boolean z) {
        a aVar = this.y;
        if (aVar != null) {
            aVar.h(z);
        }
    }

    public YoungRoundedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.v = 1.0f;
        this.w = 0.6f;
        this.x = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.YoungRoundedImageView, i2, 0);
        int color = typedArrayObtainStyledAttributes.getColor(1, 562069632);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.x = typedArrayObtainStyledAttributes.getBoolean(2, false);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(3, R.drawable.kg_young_placeholder_icon);
        typedArrayObtainStyledAttributes.recycle();
        a aVar = new a();
        this.y = aVar;
        aVar.a(context, color, z, resourceId);
    }
}
