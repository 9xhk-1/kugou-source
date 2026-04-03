package com.kugou.uilib.widget.button.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.widget.CompoundButtonCompat;
import com.kugou.uilib.R;
import com.kugou.uilib.widget.baseDelegate.IAttrParse;
import com.kugou.uilib.widget.baseDelegate.IViewDelegate;
import com.kugou.uilib.widget.baseDelegate.KGUIDelegateManager;
import com.kugou.uilib.widget.baseDelegate.commImpl.CommonDelegateAttrHelper;
import com.kugou.uilib.widget.baseDelegate.commImpl.CommonDelegateHelper;
import com.kugou.uilib.widget.baseDelegate.commImpl.SkinDelegate;
import com.kugou.uilib.widget.button.delegate.base.IButtonDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KGUICheckBox extends CheckBox implements IAttrParse {
    private List<IButtonDelegate> functions;
    private int mCheckColor;
    private int mCheckPressColor;
    private KGUIDelegateManager<Button> mDelegateManager;
    private boolean mIsCircleStyle;
    private int mUncheckColor;

    public KGUICheckBox(Context context) {
        this(context, null);
    }

    @RequiresApi(api = 21)
    private void initCheckBox() {
        setButtonDrawable(this.mIsCircleStyle ? (AnimatedStateListDrawable) getContext().getResources().getDrawable(R.drawable.kgui_checkbox_circle_svg_anim) : (AnimatedStateListDrawable) getContext().getResources().getDrawable(R.drawable.kgui_checkbox_svg_anim));
        setBackgroundColor(0);
        if (this.mIsCircleStyle) {
            int i2 = this.mCheckColor;
            CompoundButtonCompat.setButtonTintList(this, getColorStateList(i2, this.mCheckPressColor, i2, this.mUncheckColor));
        } else {
            int i3 = this.mCheckColor;
            CompoundButtonCompat.setButtonTintList(this, getColorStateList(i3, this.mCheckPressColor, i3, this.mUncheckColor));
        }
    }

    private void initColor(TypedArray typedArray) {
        if (this.mIsCircleStyle) {
            this.mCheckColor = typedArray.getColor(R.styleable.KGUICheckBox_kgui_cb_check_color, Color.parseColor("#0090FF"));
            this.mCheckPressColor = typedArray.getColor(R.styleable.KGUICheckBox_kgui_cb_check_press_color, Color.parseColor("#990090FF"));
            this.mUncheckColor = typedArray.getColor(R.styleable.KGUICheckBox_kgui_cb_uncheck_color, Color.parseColor("#96A1AC"));
        } else {
            this.mCheckColor = typedArray.getColor(R.styleable.KGUICheckBox_kgui_cb_check_color, Color.parseColor("#00A9FF"));
            this.mCheckPressColor = typedArray.getColor(R.styleable.KGUICheckBox_kgui_cb_check_press_color, Color.parseColor("#9900A9FF"));
            this.mUncheckColor = typedArray.getColor(R.styleable.KGUICheckBox_kgui_cb_uncheck_color, Color.parseColor("#99556677"));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        KGUIDelegateManager<Button> kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.drawableStateChanged();
        }
    }

    public ColorStateList getColorStateList(@ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorInt int i5) {
        if (Build.VERSION.SDK_INT > 21) {
            return new ColorStateList(new int[][]{new int[]{16842919, 16842912}, new int[]{16842919, SkinDelegate.STATE_CHECKED}, new int[]{16842912}, new int[0]}, new int[]{i3, i4, i2, i5});
        }
        return new ColorStateList(new int[][]{new int[]{16842912}, new int[0]}, new int[]{i2, i5});
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public <E extends IViewDelegate> E getCommonDelegate(Class<E> cls) {
        return (E) CommonDelegateAttrHelper.getCommonDelegate(this, this.mDelegateManager, cls);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public final List<IButtonDelegate> getDelegates(TypedArray typedArray) {
        return new ArrayList();
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

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
    }

    public void setCircleStyle(boolean z) {
        this.mIsCircleStyle = z;
        initCheckBox();
    }

    public void setStateColor(@ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorInt int i5) {
        CompoundButtonCompat.setButtonTintList(this, getColorStateList(i2, i3, i4, i5));
    }

    public KGUICheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.checkboxStyle);
    }

    public KGUICheckBox(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.functions = new ArrayList();
        TypedArray commonTypeArray = CommonDelegateHelper.getCommonTypeArray(context, attributeSet, i2);
        KGUIDelegateManager<Button> kGUIDelegateManagerInitCommonDelegate = CommonDelegateHelper.initCommonDelegate(commonTypeArray);
        this.mDelegateManager = kGUIDelegateManagerInitCommonDelegate;
        kGUIDelegateManagerInitCommonDelegate.init(this, commonTypeArray);
        commonTypeArray.recycle();
        parseAttributeSet(context, attributeSet, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KGUICheckBox, i2, 0);
        this.mIsCircleStyle = typedArrayObtainStyledAttributes.getBoolean(R.styleable.KGUICheckBox_kgui_cb_circle_style, false);
        initColor(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            initCheckBox();
        }
    }
}
