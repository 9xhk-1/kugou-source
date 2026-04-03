package com.kugou.uilib.widget.recyclerview.sticky;

import android.graphics.Canvas;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: classes2.dex */
public class StickyItemDecoration extends RecyclerView.ItemDecoration {
    public RecyclerView.Adapter mAdapter;
    private boolean mEnableStickyHead = true;
    private int mFirstVisiblePosition;
    private int[] mInto;
    private OnStickyChangeListener mOnStickyChangeListener;
    private StickyHeadContainer mStickyHeadContainer;
    private int mStickyHeadPosition;
    public StickyJudgeable stickyJudgeable;

    public StickyItemDecoration(StickyHeadContainer stickyHeadContainer, StickyJudgeable stickyJudgeable) {
        this.mStickyHeadContainer = stickyHeadContainer;
        this.stickyJudgeable = stickyJudgeable;
    }

    private void calculateStickyHeadPosition(RecyclerView recyclerView) {
        int iFindFirstVisiblePosition = findFirstVisiblePosition(recyclerView.getLayoutManager());
        this.mFirstVisiblePosition = iFindFirstVisiblePosition;
        int iFindStickyHeadPosition = findStickyHeadPosition(iFindFirstVisiblePosition);
        if (iFindStickyHeadPosition >= 0 && this.mStickyHeadPosition != iFindStickyHeadPosition) {
            this.mStickyHeadPosition = iFindStickyHeadPosition;
        } else if (iFindStickyHeadPosition < 0) {
            this.mStickyHeadPosition = -1;
        }
    }

    private void checkCache(RecyclerView recyclerView) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (this.mAdapter != adapter) {
            this.mAdapter = adapter;
            this.mStickyHeadPosition = -1;
            adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: com.kugou.uilib.widget.recyclerview.sticky.StickyItemDecoration.1
                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onChanged() {
                    StickyItemDecoration.this.reset();
                }

                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onItemRangeChanged(int i2, int i3) {
                    StickyItemDecoration.this.reset();
                }

                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onItemRangeInserted(int i2, int i3) {
                    StickyItemDecoration.this.reset();
                }

                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onItemRangeMoved(int i2, int i3, int i4) {
                    StickyItemDecoration.this.reset();
                }

                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onItemRangeRemoved(int i2, int i3) {
                    StickyItemDecoration.this.reset();
                }

                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onItemRangeChanged(int i2, int i3, Object obj) {
                    StickyItemDecoration.this.reset();
                }
            });
        }
    }

    private int findFirstCompletelyVisiblePosition(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return 0;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
        this.mInto = iArr;
        staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(iArr);
        int iMin = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int i2 : this.mInto) {
            iMin = Math.min(i2, iMin);
        }
        return iMin;
    }

    private int getCurrentVisibleFirstStickyPosition(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        return findStickyHeadPositionInVisibles(findFirstVisiblePosition(layoutManager), findLastVisiblePosition(layoutManager));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.mStickyHeadContainer.reset();
    }

    public void enableStickyHead(boolean z) {
        this.mEnableStickyHead = z;
        this.mStickyHeadContainer.setVisibility(z ? 0 : 4);
    }

    public int findFirstVisiblePosition(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return 0;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
        this.mInto = iArr;
        staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
        int iMin = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int i2 : this.mInto) {
            iMin = Math.min(i2, iMin);
        }
        return iMin;
    }

    public int findLastVisiblePosition(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return 0;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
        this.mInto = iArr;
        staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
        int iMin = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int i2 : this.mInto) {
            iMin = Math.min(i2, iMin);
        }
        return iMin;
    }

    public int findStickyHeadPosition(int i2) {
        if (this.stickyJudgeable == null) {
            return -1;
        }
        while (i2 >= 0) {
            if (this.stickyJudgeable.isSticky(i2)) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public int findStickyHeadPositionInVisibles(int i2, int i3) {
        while (i2 <= i3) {
            if (this.stickyJudgeable.isSticky(i2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public boolean isEnableStickyHead() {
        return this.mEnableStickyHead;
    }

    public boolean isStickyHead(RecyclerView recyclerView, View view) {
        StickyJudgeable stickyJudgeable;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        return (childAdapterPosition == -1 || (stickyJudgeable = this.stickyJudgeable) == null || !stickyJudgeable.isSticky(childAdapterPosition)) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        checkCache(recyclerView);
        if (this.mAdapter == null) {
            return;
        }
        calculateStickyHeadPosition(recyclerView);
        if (this.mEnableStickyHead) {
            int i2 = this.mFirstVisiblePosition;
            int i3 = this.mStickyHeadPosition;
            if (i2 >= i3 && i3 != -1) {
                View viewFindChildViewUnder = recyclerView.findChildViewUnder(canvas.getWidth() / 2, this.mStickyHeadContainer.getChildHeight() + 0.01f);
                this.mStickyHeadContainer.onDataChange(this.mStickyHeadPosition);
                int top = (!isStickyHead(recyclerView, viewFindChildViewUnder) || viewFindChildViewUnder.getTop() <= 0) ? 0 : viewFindChildViewUnder.getTop() - this.mStickyHeadContainer.getChildHeight();
                OnStickyChangeListener onStickyChangeListener = this.mOnStickyChangeListener;
                if (onStickyChangeListener != null) {
                    onStickyChangeListener.onScrollable(top);
                    return;
                }
                return;
            }
        }
        OnStickyChangeListener onStickyChangeListener2 = this.mOnStickyChangeListener;
        if (onStickyChangeListener2 != null) {
            onStickyChangeListener2.onInVisible();
        }
    }

    public void setOnStickyChangeListener(OnStickyChangeListener onStickyChangeListener) {
        this.mOnStickyChangeListener = onStickyChangeListener;
    }
}
