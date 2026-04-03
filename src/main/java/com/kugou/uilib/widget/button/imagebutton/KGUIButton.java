package com.kugou.uilib.widget.button.imagebutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.kugou.uilib.widget.baseDelegate.commImpl.CornerDelegate;
import com.kugou.uilib.widget.baseDelegate.commImpl.RatioWHDelegate;
import com.kugou.uilib.widget.button.delegate.base.IButtonDelegate;
import com.kugou.uilib.widget.imageview.round.roundedimageview.Corner;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIButton extends KGUIBaseButton {
    public KGUIButton(Context context) {
        this(context, null, 0);
    }

    @Override // com.kugou.uilib.widget.button.imagebutton.KGUIBaseButton, com.kugou.uilib.widget.baseDelegate.IAttrParse
    public final List<IButtonDelegate> getDelegates(TypedArray typedArray) {
        return new ArrayList();
    }

    public void setBorderColor(int i2) {
        ((CornerDelegate) getCommonDelegate(CornerDelegate.class)).setBorderColor(i2);
    }

    public void setBorderWidth(int i2) {
        ((CornerDelegate) getCommonDelegate(CornerDelegate.class)).setBorderStrokeWidth(i2);
    }

    public void setCorner(float f2) {
        ((CornerDelegate) getCommonDelegate(CornerDelegate.class)).setCornerRadius(f2);
    }

    public void setCornerRadius(float f2, @Corner int... iArr) {
        ((CornerDelegate) getCommonDelegate(CornerDelegate.class)).setCornerRadius(f2, iArr);
    }

    public void setCurrentCornerRadius(float f2) {
        ((CornerDelegate) getCommonDelegate(CornerDelegate.class)).setCurrentCornerRadius(f2);
    }

    public void setWHRatio(float f2) {
        setWHRatio(false, f2);
    }

    public KGUIButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setWHRatio(boolean z, float f2) {
        RatioWHDelegate ratioWHDelegate = (RatioWHDelegate) getCommonDelegate(RatioWHDelegate.class);
        ratioWHDelegate.setBaseWidth(z);
        ratioWHDelegate.setRatio(f2);
    }

    public KGUIButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
