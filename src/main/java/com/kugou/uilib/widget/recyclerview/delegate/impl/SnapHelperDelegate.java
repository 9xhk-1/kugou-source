package com.kugou.uilib.widget.recyclerview.delegate.impl;

import android.content.res.TypedArray;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;
import com.kugou.uilib.widget.recyclerview.delegate.base.AbsRecyclerViewDelegate;
import com.kugou.uilib.widget.recyclerview.delegate.impl.snaphelper.GravitySnapHelper;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.recyclerview.delegate.base.IRecyclerViewDelegate")
public class SnapHelperDelegate extends AbsRecyclerViewDelegate {
    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.getBoolean(R.styleable.KGUIRecyclerBaseView_kgui_snap_helper_enable, false);
    }

    @Override // com.kugou.uilib.widget.recyclerview.delegate.base.AbsRecyclerViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(RecyclerView recyclerView, TypedArray typedArray) {
        super.init(recyclerView, typedArray);
        GravitySnapHelper gravitySnapHelper = new GravitySnapHelper(GravityCompat.START);
        gravitySnapHelper.setIgnoreDecorate(true);
        gravitySnapHelper.setClipToPadding(false);
        gravitySnapHelper.attachToRecyclerView(recyclerView);
    }
}
