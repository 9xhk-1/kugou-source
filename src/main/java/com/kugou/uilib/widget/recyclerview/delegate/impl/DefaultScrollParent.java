package com.kugou.uilib.widget.recyclerview.delegate.impl;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingParentHelper;
import com.kugou.uilib.widget.recyclerview.scroll.IScrollParent;
import com.kugou.uilib.widget.recyclerview.scroll.IScrollableChild;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultScrollParent implements IScrollParent {
    private final NestedScrollingParentHelper helper;
    private final ViewGroup viewGroup;

    public DefaultScrollParent(ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
        this.helper = new NestedScrollingParentHelper(viewGroup);
    }

    @Override // com.kugou.uilib.widget.recyclerview.scroll.IScrollParent
    public void onNestedPreScroll(@NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kugou.uilib.widget.recyclerview.scroll.IScrollParent
    public void onNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5, int i6) {
        if (!(view instanceof IScrollableChild) || ((IScrollableChild) view).isScrollAble(i4, i5)) {
            return;
        }
        this.viewGroup.scrollBy(i4, i5);
    }

    @Override // com.kugou.uilib.widget.recyclerview.scroll.IScrollParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2, int i3) {
        this.helper.onNestedScrollAccepted(view, view2, i2, i3);
    }

    @Override // com.kugou.uilib.widget.recyclerview.scroll.IScrollParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2, int i3) {
        return true;
    }

    @Override // com.kugou.uilib.widget.recyclerview.scroll.IScrollParent
    public void onStopNestedScroll(@NonNull View view, int i2) {
        this.helper.onStopNestedScroll(view, i2);
    }
}
