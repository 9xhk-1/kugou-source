package com.kugou.android.watch.lite.common.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class KgDataRecylerView extends RecyclerView {

    public class a extends RecyclerView.OnScrollListener {
        public a(KgDataRecylerView kgDataRecylerView) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            layoutManager.getChildCount();
            layoutManager.getItemCount();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            }
            super.onScrolled(recyclerView, i2, i3);
        }
    }

    public KgDataRecylerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void a() {
        addOnScrollListener(new a(this));
    }

    public KgDataRecylerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
