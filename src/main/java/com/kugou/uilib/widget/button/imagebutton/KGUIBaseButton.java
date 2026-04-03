package com.kugou.uilib.widget.button.imagebutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kugou.uilib.R;
import com.kugou.uilib.widget.baseDelegate.IAttrParse;
import com.kugou.uilib.widget.baseDelegate.IViewDelegate;
import com.kugou.uilib.widget.baseDelegate.KGUIDelegateManager;
import com.kugou.uilib.widget.baseDelegate.commImpl.CommonDelegateAttrHelper;
import com.kugou.uilib.widget.baseDelegate.commImpl.CommonDelegateHelper;
import com.kugou.uilib.widget.button.delegate.base.IButtonDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class KGUIBaseButton extends Button implements IAttrParse {
    private List<IButtonDelegate> functions;
    private final KGUIDelegateManager<Button> mDelegateManager;

    public KGUIBaseButton(Context context) {
        this(context, null, 0);
    }

    private Drawable getWarpDrawable(Drawable drawable) {
        List<IButtonDelegate> list = this.functions;
        if (list != null) {
            Iterator<IButtonDelegate> it = list.iterator();
            while (it.hasNext()) {
                Drawable warpDrawable = it.next().getWarpDrawable(drawable);
                if (warpDrawable != null) {
                    drawable = warpDrawable;
                }
            }
        }
        return drawable;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        KGUIDelegateManager<Button> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.preDraw(canvas);
        }
        super.draw(canvas);
        KGUIDelegateManager<Button> kGUIDelegateManager2 = this.mDelegateManager;
        if (kGUIDelegateManager2 != null) {
            kGUIDelegateManager2.afterDraw(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.mDelegateManager.drawableStateChanged();
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public <E extends IViewDelegate> E getCommonDelegate(Class<E> cls) {
        return (E) CommonDelegateAttrHelper.getCommonDelegate(this, this.mDelegateManager, cls);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    @NonNull
    public abstract List<IButtonDelegate> getDelegates(TypedArray typedArray);

    @Override // android.view.View
    public boolean isFocused() {
        return super.isFocused();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        KGUIDelegateManager<Button> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.onFinishInflate();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        KGUIDelegateManager<Button> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.onLayout(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        int[] iArrMeasure;
        KGUIDelegateManager<Button> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager == null || (iArrMeasure = kGUIDelegateManager.measure(i2, i3)) == null) {
            super.onMeasure(i2, i3);
        } else {
            super.onMeasure(iArrMeasure[0], iArrMeasure[1]);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        KGUIDelegateManager<Button> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.onSizeChanged(i2, i3, i4, i5);
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    @SuppressLint({"CustomViewStyleable"})
    public final void parseAttributeSet(Context context, AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KGUIButton, i2, 0);
        List<IButtonDelegate> delegates = getDelegates(typedArrayObtainStyledAttributes);
        this.functions = delegates;
        Iterator<IButtonDelegate> it = delegates.iterator();
        while (it.hasNext()) {
            it.next().init(this, typedArrayObtainStyledAttributes);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.mDelegateManager.addList(this.functions);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(getWarpDrawable(drawable), getWarpDrawable(drawable2), getWarpDrawable(drawable3), getWarpDrawable(drawable4));
    }

    public KGUIBaseButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KGUIBaseButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.functions = new ArrayList();
        TypedArray commonTypeArray = CommonDelegateHelper.getCommonTypeArray(context, attributeSet, i2);
        KGUIDelegateManager<Button> kGUIDelegateManagerInitCommonDelegate = CommonDelegateHelper.initCommonDelegate(commonTypeArray);
        this.mDelegateManager = kGUIDelegateManagerInitCommonDelegate;
        kGUIDelegateManagerInitCommonDelegate.init(this, commonTypeArray);
        commonTypeArray.recycle();
        parseAttributeSet(context, attributeSet, i2);
    }
}
