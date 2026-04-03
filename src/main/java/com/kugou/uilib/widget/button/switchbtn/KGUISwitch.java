package com.kugou.uilib.widget.button.switchbtn;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.Switch;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
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
public class KGUISwitch extends Switch implements IAttrParse {
    private List<IButtonDelegate> functions;
    private KGUIDelegateManager<Button> mDelegateManager;
    private int mThumbCheckColor;
    private int mThumbUncheckColor;
    private int mTrackCheckColor;
    private int mTrackUncheckColor;

    public KGUISwitch(Context context) {
        this(context, null);
    }

    private void initStyle(TypedArray typedArray) {
        this.mTrackCheckColor = typedArray.getColor(R.styleable.KGUISwitch_kgui_sw_track_check_color, Color.parseColor("#0090FF"));
        this.mTrackUncheckColor = typedArray.getColor(R.styleable.KGUISwitch_kgui_sw_track_uncheck_color, Color.parseColor("#ffe6eaf6"));
        this.mThumbCheckColor = typedArray.getColor(R.styleable.KGUISwitch_kgui_sw_thumb_check_color, -1);
        this.mThumbUncheckColor = typedArray.getColor(R.styleable.KGUISwitch_kgui_sw_thumb_uncheck_color, -1);
    }

    private void initSwitch() {
        setBackgroundColor(0);
        setStateColor(this.mTrackCheckColor, this.mTrackUncheckColor, this.mThumbCheckColor, this.mThumbUncheckColor);
    }

    @Override // android.widget.Switch, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        KGUIDelegateManager<Button> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.drawableStateChanged();
        }
    }

    public ColorStateList getColorStateList(@ColorInt int i2, @ColorInt int i3) {
        return new ColorStateList(new int[][]{new int[]{16842912}, new int[0]}, new int[]{i2, i3});
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public <E extends IViewDelegate> E getCommonDelegate(Class<E> cls) {
        return (E) CommonDelegateAttrHelper.getCommonDelegate(this, this.mDelegateManager, cls);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public final List<IButtonDelegate> getDelegates(TypedArray typedArray) {
        return new ArrayList();
    }

    @Override // android.widget.Switch, android.widget.TextView, android.view.View
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
    public void parseAttributeSet(@NonNull Context context, AttributeSet attributeSet, int i2) {
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

    @Override // android.widget.Switch, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
    }

    public void setStateColor(int i2, int i3, int i4, int i5) {
        Drawable drawable = getContext().getDrawable(R.drawable.kgui_switch_track);
        if (drawable != null) {
            drawable.setTintList(getColorStateList(i2, i3));
        }
        setTrackDrawable(drawable);
        Drawable drawable2 = getContext().getDrawable(R.drawable.kgui_switch_thumb);
        setThumbDrawable(drawable2);
        if (drawable2 != null) {
            drawable2.setTintList(getColorStateList(i4, i5));
        }
    }

    public KGUISwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.switchStyle);
    }

    public KGUISwitch(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.functions = new ArrayList();
        TypedArray commonTypeArray = CommonDelegateHelper.getCommonTypeArray(context, attributeSet, i2);
        KGUIDelegateManager<Button> kGUIDelegateManagerInitCommonDelegate = CommonDelegateHelper.initCommonDelegate(commonTypeArray);
        this.mDelegateManager = kGUIDelegateManagerInitCommonDelegate;
        kGUIDelegateManagerInitCommonDelegate.init(this, commonTypeArray);
        commonTypeArray.recycle();
        parseAttributeSet(context, attributeSet, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KGUISwitch, i2, 0);
        initStyle(typedArrayObtainStyledAttributes);
        initSwitch();
        typedArrayObtainStyledAttributes.recycle();
    }
}
