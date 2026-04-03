package com.kugou.uilib.widget.textview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.kugou.uilib.widget.baseDelegate.IAttrParse;
import com.kugou.uilib.widget.baseDelegate.commImpl.CornerDelegate;
import com.kugou.uilib.widget.baseDelegate.commImpl.PressAlphaDelegate;
import com.kugou.uilib.widget.baseDelegate.commImpl.RatioWHDelegate;
import com.kugou.uilib.widget.imageview.round.roundedimageview.Corner;
import com.kugou.uilib.widget.textview.delegate.CustomFontDelegate;
import com.kugou.uilib.widget.textview.delegate.DrawableSizeDelegate;
import com.kugou.uilib.widget.textview.delegate.MarqueeFocusedDelegate;
import com.kugou.uilib.widget.textview.delegate.NoBottomEmptyDelegate;
import com.kugou.uilib.widget.textview.delegate.TextColorAlphaDelegate;

/* JADX INFO: loaded from: classes2.dex */
public class KGUITextView extends KGUIBaseTextView implements IAttrParse {
    private static final String TAG = "KGUITextView";

    public KGUITextView(Context context) {
        this(context, null, 0);
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

    public void setDisableAlpha(float f2) {
        ((PressAlphaDelegate) getCommonDelegate(PressAlphaDelegate.class)).setDisableAlpha(f2);
    }

    public void setDrawableSize(int i2, int i3, int i4) {
        ((DrawableSizeDelegate) getCommonDelegate(DrawableSizeDelegate.class)).setDrawableSize(i2, i3, i4);
    }

    public void setEnableTrans(boolean z) {
        ((PressAlphaDelegate) getCommonDelegate(PressAlphaDelegate.class)).setEnableTrans(z);
    }

    public void setMarqueeFocused(boolean z) {
        ((MarqueeFocusedDelegate) getCommonDelegate(MarqueeFocusedDelegate.class)).setEnable(z);
    }

    public void setNoBottomEmpty(boolean z) {
        ((NoBottomEmptyDelegate) getCommonDelegate(NoBottomEmptyDelegate.class)).setEnable(z);
    }

    public void setNormalAlpha(float f2) {
        ((PressAlphaDelegate) getCommonDelegate(PressAlphaDelegate.class)).setNormalAlpha(f2);
    }

    public void setPressedAlpha(float f2) {
        ((PressAlphaDelegate) getCommonDelegate(PressAlphaDelegate.class)).setPressedAlpha(f2);
    }

    public void setTextAlpha(float f2) {
        ((TextColorAlphaDelegate) getCommonDelegate(TextColorAlphaDelegate.class)).setTextAlpha(f2);
    }

    @Override // com.kugou.uilib.widget.textview.KGUIBaseTextView, android.widget.TextView
    public void setTextColor(int i2) {
        super.setTextColor(i2);
    }

    public void setTypeface(int i2) {
        ((CustomFontDelegate) getCommonDelegate(CustomFontDelegate.class)).setTypeFace(i2);
    }

    public void setWHRatio(float f2) {
        setWHRatio(false, f2);
    }

    public KGUITextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setWHRatio(boolean z, float f2) {
        RatioWHDelegate ratioWHDelegate = (RatioWHDelegate) getCommonDelegate(RatioWHDelegate.class);
        ratioWHDelegate.setBaseWidth(z);
        ratioWHDelegate.setRatio(f2);
    }

    public KGUITextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
