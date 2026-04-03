package com.kugou.uilib.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kugou.uilib.R;
import com.kugou.uilib.compile.build.KGUIDelegateHelper;
import com.kugou.uilib.widget.baseDelegate.IAttrParse;
import com.kugou.uilib.widget.baseDelegate.IViewDelegate;
import com.kugou.uilib.widget.baseDelegate.KGUIDelegateManager;
import com.kugou.uilib.widget.baseDelegate.commImpl.CommonDelegateAttrHelper;
import com.kugou.uilib.widget.baseDelegate.commImpl.CommonDelegateHelper;
import com.kugou.uilib.widget.textview.delegate.TextViewDelegate;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIBaseTextView extends TextView implements IAttrParse {
    private static final String TAG = "KGUITextView";
    private List<TextViewDelegate> customDelegates;
    private KGUIDelegateManager<TextView> mDelegateManager;

    public KGUIBaseTextView(Context context) {
        this(context, null, 0);
    }

    private void parseCommonAttrs(Context context, AttributeSet attributeSet, int i2) {
        TypedArray commonTypeArray = CommonDelegateHelper.getCommonTypeArray(context, attributeSet, i2);
        KGUIDelegateManager<TextView> kGUIDelegateManagerInitCommonDelegate = CommonDelegateHelper.initCommonDelegate(commonTypeArray);
        this.mDelegateManager = kGUIDelegateManagerInitCommonDelegate;
        kGUIDelegateManagerInitCommonDelegate.init(this, commonTypeArray);
        commonTypeArray.recycle();
    }

    private void parseCustomAttrs(AttributeSet attributeSet, TypedArray typedArray) {
        if (attributeSet != null) {
            List<TextViewDelegate> delegates = getDelegates(typedArray);
            this.customDelegates = delegates;
            if (delegates != null) {
                Iterator<TextViewDelegate> it = delegates.iterator();
                while (it.hasNext()) {
                    it.next().init(this, typedArray);
                }
                this.mDelegateManager.addList(this.customDelegates);
            }
        }
        typedArray.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        KGUIDelegateManager<TextView> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.preDraw(canvas);
        }
        super.draw(canvas);
        KGUIDelegateManager<TextView> kGUIDelegateManager2 = this.mDelegateManager;
        if (kGUIDelegateManager2 != null) {
            kGUIDelegateManager2.afterDraw(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        KGUIDelegateManager<TextView> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.drawableStateChanged();
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public <E extends IViewDelegate> E getCommonDelegate(Class<E> cls) {
        return (E) CommonDelegateAttrHelper.getCommonDelegate(this, this.mDelegateManager, cls);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public List<TextViewDelegate> getDelegates(TypedArray typedArray) {
        return KGUIDelegateHelper.getTextViewDelegatePlugin(typedArray);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.mDelegateManager != null ? super.hasOverlappingRendering() && this.mDelegateManager.hasOverlappingRendering() : super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public boolean isFocused() {
        KGUIDelegateManager<TextView> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager == null || !kGUIDelegateManager.isFocused()) {
            return super.isFocused();
        }
        return true;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        KGUIDelegateManager<TextView> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.onDraw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        KGUIDelegateManager<TextView> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.onFinishInflate();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        KGUIDelegateManager<TextView> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.onLayout(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        int[] iArrMeasure;
        KGUIDelegateManager<TextView> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager == null || (iArrMeasure = kGUIDelegateManager.measure(i2, i3)) == null) {
            super.onMeasure(i2, i3);
        } else {
            super.onMeasure(iArrMeasure[0], iArrMeasure[1]);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        KGUIDelegateManager<TextView> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.onSizeChanged(i2, i3, i4, i5);
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public void parseAttributeSet(Context context, AttributeSet attributeSet, int i2) {
        parseCommonAttrs(context, attributeSet, i2);
        parseCustomAttrs(attributeSet, context.obtainStyledAttributes(attributeSet, R.styleable.KGUITextView, i2, 0));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        KGUIDelegateManager<TextView> kGUIDelegateManager = this.mDelegateManager;
        Drawable warpBackgroundFromColor = kGUIDelegateManager != null ? kGUIDelegateManager.getWarpBackgroundFromColor(i2) : null;
        if (warpBackgroundFromColor == null) {
            super.setBackgroundColor(i2);
        } else {
            super.setBackground(warpBackgroundFromColor);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        KGUIDelegateManager<TextView> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            drawable = kGUIDelegateManager.getWarpBackground(drawable);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        KGUIDelegateManager<TextView> kGUIDelegateManager = this.mDelegateManager;
        Drawable warpBackground = kGUIDelegateManager != null ? kGUIDelegateManager.getWarpBackground(i2) : null;
        if (warpBackground == null) {
            super.setBackgroundResource(i2);
        } else {
            super.setBackground(warpBackground);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        List<TextViewDelegate> list = this.customDelegates;
        if (list != null) {
            Iterator<TextViewDelegate> it = list.iterator();
            while (it.hasNext()) {
                it.next().afterSetText();
            }
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        List<TextViewDelegate> list = this.customDelegates;
        if (list != null) {
            Iterator<TextViewDelegate> it = list.iterator();
            while (it.hasNext()) {
                i2 = it.next().getTextColor(i2);
            }
        }
        super.setTextColor(i2);
    }

    public KGUIBaseTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KGUIBaseTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mDelegateManager = new KGUIDelegateManager<>();
        parseAttributeSet(context, attributeSet, i2);
    }
}
