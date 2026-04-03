package com.kugou.uilib.widget.layout.relativelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kugou.uilib.R;
import com.kugou.uilib.widget.baseDelegate.IAttrParse;
import com.kugou.uilib.widget.baseDelegate.IViewDelegate;
import com.kugou.uilib.widget.baseDelegate.KGUIDelegateManager;
import com.kugou.uilib.widget.baseDelegate.commImpl.CommonDelegateAttrHelper;
import com.kugou.uilib.widget.baseDelegate.commImpl.CommonDelegateHelper;
import com.kugou.uilib.widget.layout.delegate.base.IViewGroupDelegate;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class KGUIBaseRelativeLayout extends RelativeLayout implements IAttrParse {
    private List<IViewGroupDelegate> functions;
    private final KGUIDelegateManager<ViewGroup> mDelegateManager;

    public KGUIBaseRelativeLayout(@NonNull Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        KGUIDelegateManager<ViewGroup> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.preDraw(canvas);
        }
        super.draw(canvas);
        KGUIDelegateManager<ViewGroup> kGUIDelegateManager2 = this.mDelegateManager;
        if (kGUIDelegateManager2 != null) {
            kGUIDelegateManager2.afterDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.mDelegateManager.drawableStateChanged();
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public <E extends IViewDelegate> E getCommonDelegate(Class<E> cls) {
        return (E) CommonDelegateAttrHelper.getCommonDelegate(this, this.mDelegateManager, cls);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public abstract List<IViewGroupDelegate> getDelegates(TypedArray typedArray);

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.mDelegateManager != null ? super.hasOverlappingRendering() && this.mDelegateManager.hasOverlappingRendering() : super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        KGUIDelegateManager<ViewGroup> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.onFinishInflate();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        KGUIDelegateManager<ViewGroup> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.onLayout(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int[] iArrMeasure;
        KGUIDelegateManager<ViewGroup> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager == null || (iArrMeasure = kGUIDelegateManager.measure(i2, i3)) == null) {
            super.onMeasure(i2, i3);
        } else {
            super.onMeasure(iArrMeasure[0], iArrMeasure[1]);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        KGUIDelegateManager<ViewGroup> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.onSizeChanged(i2, i3, i4, i5);
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public final void parseAttributeSet(Context context, AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KGUIViewGroup, i2, 0);
        List<IViewGroupDelegate> delegates = getDelegates(typedArrayObtainStyledAttributes);
        this.functions = delegates;
        Iterator<IViewGroupDelegate> it = delegates.iterator();
        while (it.hasNext()) {
            it.next().init(this, typedArrayObtainStyledAttributes);
        }
        this.mDelegateManager.addList(this.functions);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        KGUIDelegateManager<ViewGroup> kGUIDelegateManager = this.mDelegateManager;
        Drawable warpBackgroundFromColor = kGUIDelegateManager != null ? kGUIDelegateManager.getWarpBackgroundFromColor(i2) : null;
        if (warpBackgroundFromColor == null) {
            super.setBackgroundColor(i2);
        } else {
            super.setBackground(warpBackgroundFromColor);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        KGUIDelegateManager<ViewGroup> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            drawable = kGUIDelegateManager.getWarpBackground(drawable);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        KGUIDelegateManager<ViewGroup> kGUIDelegateManager = this.mDelegateManager;
        Drawable warpBackground = kGUIDelegateManager != null ? kGUIDelegateManager.getWarpBackground(i2) : null;
        if (warpBackground == null) {
            super.setBackgroundResource(i2);
        } else {
            super.setBackground(warpBackground);
        }
    }

    public KGUIBaseRelativeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KGUIBaseRelativeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray commonTypeArray = CommonDelegateHelper.getCommonTypeArray(context, attributeSet, i2);
        KGUIDelegateManager<ViewGroup> kGUIDelegateManagerInitCommonDelegate = CommonDelegateHelper.initCommonDelegate(commonTypeArray);
        this.mDelegateManager = kGUIDelegateManagerInitCommonDelegate;
        kGUIDelegateManagerInitCommonDelegate.init(this, commonTypeArray);
        commonTypeArray.recycle();
        parseAttributeSet(context, attributeSet, i2);
    }
}
