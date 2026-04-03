package com.kugou.uilib.compile.build;

import android.content.res.TypedArray;
import android.view.View;
import com.kugou.uilib.widget.baseDelegate.IViewDelegate;
import com.kugou.uilib.widget.baseDelegate.commImpl.CompoundDrawableDelegate;
import com.kugou.uilib.widget.baseDelegate.commImpl.CornerDelegate;
import com.kugou.uilib.widget.baseDelegate.commImpl.DrawableAlphaDelegate;
import com.kugou.uilib.widget.baseDelegate.commImpl.PressAlphaDelegate;
import com.kugou.uilib.widget.baseDelegate.commImpl.PressScaleDelegate;
import com.kugou.uilib.widget.baseDelegate.commImpl.RatioWHDelegate;
import com.kugou.uilib.widget.baseDelegate.commImpl.RippleDelegate;
import com.kugou.uilib.widget.imageview.delegate.base.IImageViewDelegate;
import com.kugou.uilib.widget.imageview.delegate.impl.MaskDelegate;
import com.kugou.uilib.widget.imageview.delegate.impl.SrcAlphaDelegate;
import com.kugou.uilib.widget.layout.delegate.ChainPressEffectDelegate;
import com.kugou.uilib.widget.layout.delegate.DefaultLayoutDelegate;
import com.kugou.uilib.widget.layout.delegate.base.IViewGroupDelegate;
import com.kugou.uilib.widget.recyclerview.delegate.base.IRecyclerViewDelegate;
import com.kugou.uilib.widget.recyclerview.delegate.impl.GestureDelegate;
import com.kugou.uilib.widget.recyclerview.delegate.impl.HNestedScrollDelegate;
import com.kugou.uilib.widget.recyclerview.delegate.impl.SnapHelperDelegate;
import com.kugou.uilib.widget.textview.delegate.CenterLeftDrawableDelegate;
import com.kugou.uilib.widget.textview.delegate.CustomFontDelegate;
import com.kugou.uilib.widget.textview.delegate.DrawableSizeDelegate;
import com.kugou.uilib.widget.textview.delegate.LineSpaceDelegate;
import com.kugou.uilib.widget.textview.delegate.MarqueeFocusedDelegate;
import com.kugou.uilib.widget.textview.delegate.NoBottomEmptyDelegate;
import com.kugou.uilib.widget.textview.delegate.TextColorAlphaDelegate;
import com.kugou.uilib.widget.textview.delegate.TextViewDelegate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIDelegateHelper {
    public static <T extends View> List<IViewDelegate<T>> getCommonPlugin(TypedArray typedArray) {
        ArrayList arrayList = new ArrayList();
        if (CompoundDrawableDelegate.isNeed(typedArray)) {
            arrayList.add(new CompoundDrawableDelegate());
        }
        if (CornerDelegate.isNeed(typedArray)) {
            arrayList.add(new CornerDelegate());
        }
        if (DrawableAlphaDelegate.isNeed(typedArray)) {
            arrayList.add(new DrawableAlphaDelegate());
        }
        if (PressAlphaDelegate.isNeed(typedArray)) {
            arrayList.add(new PressAlphaDelegate());
        }
        if (PressScaleDelegate.isNeed(typedArray)) {
            arrayList.add(new PressScaleDelegate());
        }
        if (RatioWHDelegate.isNeed(typedArray)) {
            arrayList.add(new RatioWHDelegate());
        }
        if (RippleDelegate.isNeed(typedArray)) {
            arrayList.add(new RippleDelegate());
        }
        return arrayList;
    }

    public static List<IImageViewDelegate> getIImageViewDelegatePlugin(TypedArray typedArray) {
        ArrayList arrayList = new ArrayList();
        if (MaskDelegate.isNeed(typedArray)) {
            arrayList.add(new MaskDelegate());
        }
        if (SrcAlphaDelegate.isNeed(typedArray)) {
            arrayList.add(new SrcAlphaDelegate());
        }
        return arrayList;
    }

    public static List<IRecyclerViewDelegate> getIRecyclerViewDelegatePlugin(TypedArray typedArray) {
        ArrayList arrayList = new ArrayList();
        if (GestureDelegate.isNeed(typedArray)) {
            arrayList.add(new GestureDelegate());
        }
        if (HNestedScrollDelegate.isNeed(typedArray)) {
            arrayList.add(new HNestedScrollDelegate());
        }
        if (SnapHelperDelegate.isNeed(typedArray)) {
            arrayList.add(new SnapHelperDelegate());
        }
        return arrayList;
    }

    public static List<IViewGroupDelegate> getIViewGroupDelegatePlugin(TypedArray typedArray) {
        ArrayList arrayList = new ArrayList();
        if (ChainPressEffectDelegate.isNeed(typedArray)) {
            arrayList.add(new ChainPressEffectDelegate());
        }
        if (DefaultLayoutDelegate.isNeed(typedArray)) {
            arrayList.add(new DefaultLayoutDelegate());
        }
        return arrayList;
    }

    public static List<TextViewDelegate> getTextViewDelegatePlugin(TypedArray typedArray) {
        ArrayList arrayList = new ArrayList();
        if (CenterLeftDrawableDelegate.isNeed(typedArray)) {
            arrayList.add(new CenterLeftDrawableDelegate());
        }
        if (CustomFontDelegate.isNeed(typedArray)) {
            arrayList.add(new CustomFontDelegate());
        }
        if (DrawableSizeDelegate.isNeed(typedArray)) {
            arrayList.add(new DrawableSizeDelegate());
        }
        if (LineSpaceDelegate.isNeed(typedArray)) {
            arrayList.add(new LineSpaceDelegate());
        }
        if (MarqueeFocusedDelegate.isNeed(typedArray)) {
            arrayList.add(new MarqueeFocusedDelegate());
        }
        if (NoBottomEmptyDelegate.isNeed(typedArray)) {
            arrayList.add(new NoBottomEmptyDelegate());
        }
        if (TextColorAlphaDelegate.isNeed(typedArray)) {
            arrayList.add(new TextColorAlphaDelegate());
        }
        return arrayList;
    }
}
