package com.kugou.uilib.compile.build;

import com.kugou.uilib.widget.baseDelegate.IAttrParse;
import com.kugou.uilib.widget.baseDelegate.commImpl.CommonDelegateAttrHelper;
import com.kugou.uilib.widget.baseDelegate.commImpl.CornerDelegate;
import com.kugou.uilib.widget.baseDelegate.commImpl.PressAlphaDelegate;
import com.kugou.uilib.widget.baseDelegate.commImpl.PressScaleDelegate;
import com.kugou.uilib.widget.baseDelegate.commImpl.RatioWHDelegate;
import com.kugou.uilib.widget.imageview.delegate.impl.MaskDelegate;
import com.kugou.uilib.widget.imageview.delegate.impl.PaletteDelegate;
import com.kugou.uilib.widget.imageview.delegate.impl.SrcAlphaDelegate;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIViewCompact {
    public static void setAlpha(IAttrParse iAttrParse, float f2) {
        SrcAlphaDelegate srcAlphaDelegate = (SrcAlphaDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, SrcAlphaDelegate.class);
        if (srcAlphaDelegate != null) {
            srcAlphaDelegate.setAlpha(f2);
        }
    }

    public static void setBaseWidth(IAttrParse iAttrParse, boolean z) {
        RatioWHDelegate ratioWHDelegate = (RatioWHDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, RatioWHDelegate.class);
        if (ratioWHDelegate != null) {
            ratioWHDelegate.setBaseWidth(z);
        }
    }

    public static void setBorderColor(IAttrParse iAttrParse, int i2) {
        CornerDelegate cornerDelegate = (CornerDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, CornerDelegate.class);
        if (cornerDelegate != null) {
            cornerDelegate.setBorderColor(i2);
        }
    }

    public static void setBorderStrokeWidth(IAttrParse iAttrParse, int i2) {
        CornerDelegate cornerDelegate = (CornerDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, CornerDelegate.class);
        if (cornerDelegate != null) {
            cornerDelegate.setBorderStrokeWidth(i2);
        }
    }

    public static void setCornerRadius(IAttrParse iAttrParse, float f2) {
        CornerDelegate cornerDelegate = (CornerDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, CornerDelegate.class);
        if (cornerDelegate != null) {
            cornerDelegate.setCornerRadius(f2);
        }
    }

    public static void setCurrentCornerRadius(IAttrParse iAttrParse, float f2) {
        CornerDelegate cornerDelegate = (CornerDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, CornerDelegate.class);
        if (cornerDelegate != null) {
            cornerDelegate.setCurrentCornerRadius(f2);
        }
    }

    public static void setDisableAlpha(IAttrParse iAttrParse, float f2) {
        PressAlphaDelegate pressAlphaDelegate = (PressAlphaDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, PressAlphaDelegate.class);
        if (pressAlphaDelegate != null) {
            pressAlphaDelegate.setDisableAlpha(f2);
        }
    }

    public static void setEnableTrans(IAttrParse iAttrParse, boolean z) {
        PressAlphaDelegate pressAlphaDelegate = (PressAlphaDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, PressAlphaDelegate.class);
        if (pressAlphaDelegate != null) {
            pressAlphaDelegate.setEnableTrans(z);
        }
    }

    public static void setMaskColor(IAttrParse iAttrParse, int i2) {
        MaskDelegate maskDelegate = (MaskDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, MaskDelegate.class);
        if (maskDelegate != null) {
            maskDelegate.setMaskColor(i2);
        }
    }

    public static void setNormalAlpha(IAttrParse iAttrParse, float f2) {
        PressAlphaDelegate pressAlphaDelegate = (PressAlphaDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, PressAlphaDelegate.class);
        if (pressAlphaDelegate != null) {
            pressAlphaDelegate.setNormalAlpha(f2);
        }
    }

    public static void setPaletteListener(IAttrParse iAttrParse, PaletteDelegate.PaletteListener paletteListener) {
        PaletteDelegate paletteDelegate = (PaletteDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, PaletteDelegate.class);
        if (paletteDelegate != null) {
            paletteDelegate.setPaletteListener(paletteListener);
        }
    }

    public static void setPressAnimDuration(IAttrParse iAttrParse, long j) {
        PressScaleDelegate pressScaleDelegate = (PressScaleDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, PressScaleDelegate.class);
        if (pressScaleDelegate != null) {
            pressScaleDelegate.setPressAnimDuration(j);
        }
    }

    public static void setPressColor(IAttrParse iAttrParse, int i2) {
        MaskDelegate maskDelegate = (MaskDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, MaskDelegate.class);
        if (maskDelegate != null) {
            maskDelegate.setPressColor(i2);
        }
    }

    public static void setPressScale(IAttrParse iAttrParse, float f2) {
        PressScaleDelegate pressScaleDelegate = (PressScaleDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, PressScaleDelegate.class);
        if (pressScaleDelegate != null) {
            pressScaleDelegate.setPressScale(f2);
        }
    }

    public static void setPressedAlpha(IAttrParse iAttrParse, float f2) {
        PressAlphaDelegate pressAlphaDelegate = (PressAlphaDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, PressAlphaDelegate.class);
        if (pressAlphaDelegate != null) {
            pressAlphaDelegate.setPressedAlpha(f2);
        }
    }

    public static void setRatio(IAttrParse iAttrParse, float f2) {
        RatioWHDelegate ratioWHDelegate = (RatioWHDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, RatioWHDelegate.class);
        if (ratioWHDelegate != null) {
            ratioWHDelegate.setRatio(f2);
        }
    }

    public static void setCornerRadius(IAttrParse iAttrParse, float f2, int... iArr) {
        CornerDelegate cornerDelegate = (CornerDelegate) CommonDelegateAttrHelper.getDelegate(iAttrParse, CornerDelegate.class);
        if (cornerDelegate != null) {
            cornerDelegate.setCornerRadius(f2, iArr);
        }
    }
}
