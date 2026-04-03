package com.kugou.uilib.widget.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kugou.uilib.compile.build.KGUIDelegateHelper;
import com.kugou.uilib.widget.recyclerview.delegate.base.IRecyclerViewDelegate;
import com.kugou.uilib.widget.recyclerview.delegate.impl.HNestedScrollDelegate;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIRecyclerView extends KGUIRecyclerBaseView {
    public KGUIRecyclerView(@NonNull Context context) {
        this(context, null, 0);
    }

    @Override // com.kugou.uilib.widget.recyclerview.KGUIRecyclerBaseView, com.kugou.uilib.widget.baseDelegate.IAttrParse
    @NonNull
    public List<IRecyclerViewDelegate> getDelegates(TypedArray typedArray) {
        return KGUIDelegateHelper.getIRecyclerViewDelegatePlugin(typedArray);
    }

    public void setDisallowIntercept(boolean z) {
        HNestedScrollDelegate hNestedScrollDelegate = (HNestedScrollDelegate) getDelegate(HNestedScrollDelegate.class);
        if (hNestedScrollDelegate != null) {
            hNestedScrollDelegate.setDisallowIntercept(z);
        }
    }

    public void setEdgeScrollEnable(boolean z) {
        HNestedScrollDelegate hNestedScrollDelegate = (HNestedScrollDelegate) getDelegate(HNestedScrollDelegate.class);
        if (hNestedScrollDelegate != null) {
            hNestedScrollDelegate.setEdgeScrollEnable(z);
        }
    }

    public KGUIRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KGUIRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
