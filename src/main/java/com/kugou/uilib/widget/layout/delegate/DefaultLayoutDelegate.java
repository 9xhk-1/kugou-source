package com.kugou.uilib.widget.layout.delegate;

import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;
import com.kugou.uilib.widget.layout.delegate.base.IViewGroupDelegate;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.layout.delegate.base.IViewGroupDelegate")
public class DefaultLayoutDelegate extends IViewGroupDelegate {
    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.hasValue(R.styleable.KGUIViewGroup_kgui_default_layout_id);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(ViewGroup viewGroup, TypedArray typedArray) {
        LayoutInflater.from(viewGroup.getContext()).inflate(typedArray.getResourceId(R.styleable.KGUIViewGroup_kgui_default_layout_id, 0), viewGroup, true);
    }
}
