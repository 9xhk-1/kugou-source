package com.kugou.uilib.widget.layout.relativelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kugou.uilib.compile.build.KGUIDelegateHelper;
import com.kugou.uilib.widget.baseDelegate.commImpl.CornerDelegate;
import com.kugou.uilib.widget.baseDelegate.commImpl.RatioWHDelegate;
import com.kugou.uilib.widget.imageview.round.roundedimageview.Corner;
import com.kugou.uilib.widget.layout.delegate.base.IViewGroupDelegate;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIRelativeLayout extends KGUIBaseRelativeLayout {
    public KGUIRelativeLayout(@NonNull Context context) {
        this(context, null, 0);
    }

    @Override // com.kugou.uilib.widget.layout.relativelayout.KGUIBaseRelativeLayout, com.kugou.uilib.widget.baseDelegate.IAttrParse
    public List<IViewGroupDelegate> getDelegates(TypedArray typedArray) {
        return KGUIDelegateHelper.getIViewGroupDelegatePlugin(typedArray);
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

    public void setWHRatio(float f2) {
        setWHRatio(false, f2);
    }

    public KGUIRelativeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setWHRatio(boolean z, float f2) {
        RatioWHDelegate ratioWHDelegate = (RatioWHDelegate) getCommonDelegate(RatioWHDelegate.class);
        ratioWHDelegate.setBaseWidth(z);
        ratioWHDelegate.setRatio(f2);
    }

    public KGUIRelativeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
