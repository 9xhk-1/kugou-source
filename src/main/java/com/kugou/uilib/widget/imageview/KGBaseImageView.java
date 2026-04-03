package com.kugou.uilib.widget.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kugou.uilib.R;
import com.kugou.uilib.widget.baseDelegate.IAttrParse;
import com.kugou.uilib.widget.baseDelegate.IViewDelegate;
import com.kugou.uilib.widget.baseDelegate.KGUIDelegateManager;
import com.kugou.uilib.widget.baseDelegate.commImpl.CommonDelegateAttrHelper;
import com.kugou.uilib.widget.baseDelegate.commImpl.CommonDelegateHelper;
import com.kugou.uilib.widget.imageview.delegate.base.AbsImageViewDelegate;
import com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class KGBaseImageView extends ImageView implements IAttrParse {
    private List<IImageViewDelegate> functions;
    public KGUIDelegateManager<ImageView> mDelegateManager;

    public KGBaseImageView(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        KGUIDelegateManager<ImageView> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.preDraw(canvas);
        }
        super.draw(canvas);
        KGUIDelegateManager<ImageView> kGUIDelegateManager2 = this.mDelegateManager;
        if (kGUIDelegateManager2 != null) {
            kGUIDelegateManager2.afterDraw(canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        KGUIDelegateManager<ImageView> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.drawableStateChanged();
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public <E extends IViewDelegate> E getCommonDelegate(Class<E> cls) {
        IImageViewDelegate iImageViewDelegate = (E) CommonDelegateAttrHelper.getCommonDelegate(this, this.mDelegateManager, cls);
        if ((iImageViewDelegate instanceof AbsImageViewDelegate) && !this.functions.contains(iImageViewDelegate)) {
            this.functions.add(iImageViewDelegate);
        }
        return iImageViewDelegate;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public abstract List<IImageViewDelegate> getDelegates(TypedArray typedArray);

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.mDelegateManager != null ? super.hasOverlappingRendering() && this.mDelegateManager.hasOverlappingRendering() : super.hasOverlappingRendering();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        KGUIDelegateManager<ImageView> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.onDraw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mDelegateManager.onFinishInflate();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        KGUIDelegateManager<ImageView> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.onLayout(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        int[] iArrMeasure;
        KGUIDelegateManager<ImageView> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager == null || (iArrMeasure = kGUIDelegateManager.measure(i2, i3)) == null) {
            super.onMeasure(i2, i3);
        } else {
            super.onMeasure(iArrMeasure[0], iArrMeasure[1]);
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public final void parseAttributeSet(Context context, AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KGBaseImageView, i2, 0);
        List<IImageViewDelegate> delegates = getDelegates(typedArrayObtainStyledAttributes);
        this.functions = delegates;
        Iterator<IImageViewDelegate> it = delegates.iterator();
        while (it.hasNext()) {
            it.next().init(this, typedArrayObtainStyledAttributes);
        }
        this.mDelegateManager.addList(this.functions);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        KGUIDelegateManager<ImageView> kGUIDelegateManager = this.mDelegateManager;
        Drawable warpBackgroundFromColor = kGUIDelegateManager != null ? kGUIDelegateManager.getWarpBackgroundFromColor(i2) : null;
        if (warpBackgroundFromColor == null) {
            super.setBackgroundColor(i2);
        } else {
            super.setBackground(warpBackgroundFromColor);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        KGUIDelegateManager<ImageView> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            drawable = kGUIDelegateManager.getWarpBackground(drawable);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        KGUIDelegateManager<ImageView> kGUIDelegateManager = this.mDelegateManager;
        Drawable warpBackground = kGUIDelegateManager != null ? kGUIDelegateManager.getWarpBackground(i2) : null;
        if (warpBackground == null) {
            super.setBackgroundResource(i2);
        } else {
            super.setBackground(warpBackground);
        }
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        List<IImageViewDelegate> list = this.functions;
        if (list != null) {
            Iterator<IImageViewDelegate> it = list.iterator();
            while (it.hasNext()) {
                ColorFilter colorFilter2 = it.next().getColorFilter(colorFilter);
                if (colorFilter2 != null) {
                    colorFilter = colorFilter2;
                }
            }
        }
        super.setColorFilter(colorFilter);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        List<IImageViewDelegate> list = this.functions;
        Drawable drawable = null;
        if (list != null) {
            for (IImageViewDelegate iImageViewDelegate : list) {
                Drawable warpDrawable = drawable == null ? iImageViewDelegate.getWarpDrawable(bitmap) : iImageViewDelegate.getWarpDrawable(drawable);
                if (warpDrawable != null) {
                    drawable = warpDrawable;
                }
            }
        }
        if (drawable == null) {
            super.setImageBitmap(bitmap);
        } else {
            super.setImageDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        List<IImageViewDelegate> list = this.functions;
        if (list != null) {
            Iterator<IImageViewDelegate> it = list.iterator();
            while (it.hasNext()) {
                Drawable warpDrawable = it.next().getWarpDrawable(drawable);
                if (warpDrawable != null) {
                    drawable = warpDrawable;
                }
            }
        }
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        List<IImageViewDelegate> list = this.functions;
        Drawable drawable = null;
        if (list != null) {
            for (IImageViewDelegate iImageViewDelegate : list) {
                Drawable warpDrawable = drawable == null ? iImageViewDelegate.getWarpDrawable(i2) : iImageViewDelegate.getWarpDrawable(drawable);
                if (warpDrawable != null) {
                    drawable = warpDrawable;
                }
            }
        }
        if (drawable == null) {
            super.setImageResource(i2);
        } else {
            super.setImageDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(@Nullable Uri uri) {
        List<IImageViewDelegate> list = this.functions;
        Drawable drawable = null;
        if (list != null) {
            for (IImageViewDelegate iImageViewDelegate : list) {
                Drawable warpDrawable = drawable == null ? iImageViewDelegate.getWarpDrawable(uri) : iImageViewDelegate.getWarpDrawable(drawable);
                if (warpDrawable != null) {
                    drawable = warpDrawable;
                }
            }
        }
        if (drawable == null) {
            super.setImageURI(uri);
        } else {
            super.setImageDrawable(drawable);
        }
    }

    public KGBaseImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KGBaseImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.functions = new ArrayList();
        TypedArray commonTypeArray = CommonDelegateHelper.getCommonTypeArray(context, attributeSet, i2);
        KGUIDelegateManager<ImageView> kGUIDelegateManagerInitCommonDelegate = CommonDelegateHelper.initCommonDelegate(commonTypeArray);
        this.mDelegateManager = kGUIDelegateManagerInitCommonDelegate;
        kGUIDelegateManagerInitCommonDelegate.init(this, commonTypeArray);
        commonTypeArray.recycle();
        parseAttributeSet(context, attributeSet, i2);
    }
}
