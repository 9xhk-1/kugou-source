package com.kugou.uilib.widget.recyclerview;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class RecyclerHelper {
    public static boolean isFirstItemVisible(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        return (layoutManager instanceof LinearLayoutManager) && ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0;
    }

    public static boolean isLastItemVisible(RecyclerView recyclerView) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null || adapter.getItemCount() == 0) {
            return true;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        return (layoutManager instanceof LinearLayoutManager) && ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() - 1;
    }
}
