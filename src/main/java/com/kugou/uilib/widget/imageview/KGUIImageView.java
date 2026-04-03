package com.kugou.uilib.widget.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.kugou.uilib.compile.build.KGUIDelegateHelper;
import com.kugou.uilib.widget.baseDelegate.commImpl.CornerDelegate;
import com.kugou.uilib.widget.baseDelegate.commImpl.PressAlphaDelegate;
import com.kugou.uilib.widget.baseDelegate.commImpl.RatioWHDelegate;
import com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate;
import com.kugou.uilib.widget.imageview.delegate.impl.MaskDelegate;
import com.kugou.uilib.widget.imageview.delegate.impl.PaletteDelegate;
import com.kugou.uilib.widget.imageview.delegate.impl.SrcAlphaDelegate;
import com.kugou.uilib.widget.imageview.round.roundedimageview.Corner;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIImageView extends KGBaseImageView {
    public KGUIImageView(Context context) {
        super(context);
    }

    @Override // com.kugou.uilib.widget.imageview.KGBaseImageView, com.kugou.uilib.widget.baseDelegate.IAttrParse
    public final List<IImageViewDelegate> getDelegates(TypedArray typedArray) {
        return KGUIDelegateHelper.getIImageViewDelegatePlugin(typedArray);
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

    public void setCurrentCornerRadius(int i2) {
        ((CornerDelegate) getCommonDelegate(CornerDelegate.class)).setCurrentCornerRadius(i2);
    }

    public void setDisableAlpha(float f2) {
        ((PressAlphaDelegate) getCommonDelegate(PressAlphaDelegate.class)).setDisableAlpha(f2);
    }

    public void setEnableTrans(boolean z) {
        ((PressAlphaDelegate) getCommonDelegate(PressAlphaDelegate.class)).setEnableTrans(z);
    }

    public void setMaskColor(int i2) {
        ((MaskDelegate) getCommonDelegate(MaskDelegate.class)).setMaskColor(i2);
    }

    public void setNormalAlpha(float f2) {
        ((PressAlphaDelegate) getCommonDelegate(PressAlphaDelegate.class)).setNormalAlpha(f2);
    }

    public void setPaletteListener(PaletteDelegate.PaletteListener paletteListener) {
        ((PaletteDelegate) getCommonDelegate(PaletteDelegate.class)).setPaletteListener(paletteListener);
    }

    public void setPressAlpha(float f2) {
        ((PressAlphaDelegate) getCommonDelegate(PressAlphaDelegate.class)).setPressedAlpha(f2);
    }

    public void setPressColor(int i2) {
        ((MaskDelegate) getCommonDelegate(MaskDelegate.class)).setPressColor(i2);
    }

    public void setPressedAlpha(float f2) {
        ((PressAlphaDelegate) getCommonDelegate(PressAlphaDelegate.class)).setPressedAlpha(f2);
    }

    public void setSrcAlpha(float f2) {
        ((SrcAlphaDelegate) getCommonDelegate(SrcAlphaDelegate.class)).setAlpha(f2);
    }

    public void setWHRatio(float f2) {
        setWHRatio(false, f2);
    }

    public KGUIImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setWHRatio(boolean z, float f2) {
        RatioWHDelegate ratioWHDelegate = (RatioWHDelegate) getCommonDelegate(RatioWHDelegate.class);
        ratioWHDelegate.setBaseWidth(z);
        ratioWHDelegate.setRatio(f2);
    }

    public KGUIImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
