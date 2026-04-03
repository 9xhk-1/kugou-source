package com.kugou.uilib.widget.recyclerview.sticky;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.kugou.uilib.R;
import com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase;
import com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshRecyclerView2;
import com.kugou.uilib.widget.recyclerview.pulltorefresh.Mode;
import com.kugou.uilib.widget.recyclerview.sticky.StickyHeadContainer;

/* JADX INFO: loaded from: classes2.dex */
public class StickyRecyclerView extends FrameLayout {
    private StickyRecyclerViewAdapter currentAdapter;
    private FrameLayout flHead;
    private KGUIPullToRefreshRecyclerView2 pullToRefreshRecyclerView;
    private RecyclerView recyclerView;
    private StickyHeadContainer stickyHeadContainer;
    private RecyclerView.ViewHolder viewHolderSticky;

    public StickyRecyclerView(@NonNull Context context) {
        super(context);
        this.pullToRefreshRecyclerView = null;
        this.recyclerView = null;
        this.flHead = null;
        this.stickyHeadContainer = null;
        this.currentAdapter = null;
        this.viewHolderSticky = null;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_sticky_recycler_view, (ViewGroup) this, true);
    }

    public KGUIPullToRefreshRecyclerView2 getPullToRefreshRecyclerView() {
        return this.pullToRefreshRecyclerView;
    }

    public RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        KGUIPullToRefreshRecyclerView2 kGUIPullToRefreshRecyclerView2 = (KGUIPullToRefreshRecyclerView2) findViewById(R.id.rv_pull_to_refresh);
        this.pullToRefreshRecyclerView = kGUIPullToRefreshRecyclerView2;
        kGUIPullToRefreshRecyclerView2.setMode(Mode.DISABLED);
        this.recyclerView = (RecyclerView) this.pullToRefreshRecyclerView.getRefreshableView();
        this.stickyHeadContainer = (StickyHeadContainer) findViewById(R.id.v_head_container);
        this.flHead = (FrameLayout) findViewById(R.id.v_head_frame);
    }

    public void setAdapter(StickyRecyclerViewAdapter stickyRecyclerViewAdapter) {
        if (this.recyclerView.getLayoutManager() == null) {
            throw new RuntimeException("Please set LayoutManager before calling setAdapter()");
        }
        this.recyclerView.setAdapter(stickyRecyclerViewAdapter);
        this.currentAdapter = stickyRecyclerViewAdapter;
        this.stickyHeadContainer.setDataCallback(new StickyHeadContainer.DataCallback() { // from class: com.kugou.uilib.widget.recyclerview.sticky.StickyRecyclerView.1
            /* JADX WARN: Type inference failed for: r1v3, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder] */
            @Override // com.kugou.uilib.widget.recyclerview.sticky.StickyHeadContainer.DataCallback
            public void onDataChange(int i2) {
                if (StickyRecyclerView.this.viewHolderSticky == null) {
                    StickyRecyclerView stickyRecyclerView = StickyRecyclerView.this;
                    stickyRecyclerView.viewHolderSticky = stickyRecyclerView.currentAdapter.onCreateViewHolder(StickyRecyclerView.this.recyclerView, StickyRecyclerView.this.currentAdapter.getItemViewType(i2));
                    if (StickyRecyclerView.this.viewHolderSticky != null) {
                        StickyRecyclerView.this.flHead.removeAllViews();
                        StickyRecyclerView.this.flHead.addView(StickyRecyclerView.this.viewHolderSticky.itemView);
                    }
                }
                StickyRecyclerView.this.currentAdapter.onBindViewHolder(StickyRecyclerView.this.viewHolderSticky, i2);
            }
        });
        StickyHeadContainer.bind(this.recyclerView, stickyRecyclerViewAdapter, this.stickyHeadContainer);
        this.pullToRefreshRecyclerView.setOnDraggingListener(new KGUIPullToRefreshBase.OnDraggingListener() { // from class: com.kugou.uilib.widget.recyclerview.sticky.StickyRecyclerView.2
            @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase.OnDraggingListener
            public void endDragging() {
            }

            @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase.OnDraggingListener
            public void startDragging() {
                if (StickyRecyclerView.this.pullToRefreshRecyclerView.isPullFromStart()) {
                    StickyRecyclerView.this.stickyHeadContainer.setVisibility(8);
                }
            }
        });
        this.pullToRefreshRecyclerView.setPullScrollListener(new KGUIPullToRefreshBase.OnPullScrollListener() { // from class: com.kugou.uilib.widget.recyclerview.sticky.StickyRecyclerView.3
            @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase.OnPullScrollListener
            public void onHeadScroll(int i2, boolean z) {
                if (i2 > 0 || !StickyRecyclerView.this.pullToRefreshRecyclerView.isPullFromStart()) {
                    return;
                }
                StickyRecyclerView.this.stickyHeadContainer.setVisibility(8);
            }
        });
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.recyclerView.setLayoutManager(layoutManager);
    }

    public StickyRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pullToRefreshRecyclerView = null;
        this.recyclerView = null;
        this.flHead = null;
        this.stickyHeadContainer = null;
        this.currentAdapter = null;
        this.viewHolderSticky = null;
        init();
    }

    public StickyRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.pullToRefreshRecyclerView = null;
        this.recyclerView = null;
        this.flHead = null;
        this.stickyHeadContainer = null;
        this.currentAdapter = null;
        this.viewHolderSticky = null;
        init();
    }
}
