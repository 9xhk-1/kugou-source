package com.kugou.uilib.widget.recyclerview.sticky;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public abstract class StickyRecyclerViewAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements StickyJudgeable {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        StickyRecyclerViewHelper.onAttachedToRecyclerView(recyclerView, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(VH vh) {
        StickyRecyclerViewHelper.onViewAttachedToWindow(vh, this);
    }
}
