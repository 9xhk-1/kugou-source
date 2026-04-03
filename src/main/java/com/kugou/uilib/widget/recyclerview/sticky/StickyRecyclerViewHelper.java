package com.kugou.uilib.widget.recyclerview.sticky;

import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: classes2.dex */
public class StickyRecyclerViewHelper {
    public static void onAttachedToRecyclerView(RecyclerView recyclerView, final StickyJudgeable stickyJudgeable) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.kugou.uilib.widget.recyclerview.sticky.StickyRecyclerViewHelper.1
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i2) {
                    if (stickyJudgeable.isItemFullLine(i2)) {
                        return gridLayoutManager.getSpanCount();
                    }
                    GridLayoutManager.SpanSizeLookup spanSizeLookup2 = spanSizeLookup;
                    if (spanSizeLookup2 != null) {
                        return spanSizeLookup2.getSpanSize(i2);
                    }
                    return 1;
                }
            });
        }
    }

    public static void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder, StickyJudgeable stickyJudgeable) {
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(stickyJudgeable.isItemFullLine(viewHolder.getLayoutPosition()));
        }
    }
}
