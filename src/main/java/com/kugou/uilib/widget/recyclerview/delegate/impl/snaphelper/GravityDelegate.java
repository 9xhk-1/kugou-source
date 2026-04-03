package com.kugou.uilib.widget.recyclerview.delegate.impl.snaphelper;

import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.kugou.uilib.widget.recyclerview.delegate.impl.snaphelper.GravitySnapHelper;

/* JADX INFO: loaded from: classes2.dex */
public class GravityDelegate {
    private int currentSnappedPosition;
    private int gravity;
    private OrientationHelper horizontalHelper;
    private boolean isClipToPadding;
    private GravitySnapHelper.SnapListener listener;
    private RecyclerView recyclerView;
    private boolean snapLastItem;
    private OrientationHelper verticalHelper;
    private boolean isScrolling = false;
    private boolean ignoreDecorate = true;
    private RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() { // from class: com.kugou.uilib.widget.recyclerview.delegate.impl.snaphelper.GravityDelegate.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0 && GravityDelegate.this.listener != null && GravityDelegate.this.currentSnappedPosition != -1 && GravityDelegate.this.isScrolling) {
                GravityDelegate.this.listener.onSnap(GravityDelegate.this.currentSnappedPosition);
            }
            GravityDelegate.this.isScrolling = i2 != 0;
        }
    };

    public GravityDelegate(int i2, boolean z, @Nullable GravitySnapHelper.SnapListener snapListener) {
        if (i2 != 8388611 && i2 != 8388613 && i2 != 80 && i2 != 48) {
            throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP constants");
        }
        this.snapLastItem = z;
        this.gravity = i2;
        this.listener = snapListener;
    }

    private int distanceToEnd(View view, LinearLayoutManager linearLayoutManager, @NonNull OrientationHelper orientationHelper) {
        int childEnd;
        int childLayoutPosition = this.recyclerView.getChildLayoutPosition(view);
        if ((childLayoutPosition == 0 || childLayoutPosition == linearLayoutManager.getItemCount() - 1) && !this.recyclerView.getClipToPadding() && (childEnd = getChildEnd(view, orientationHelper)) < orientationHelper.getEnd() - ((orientationHelper.getEnd() - orientationHelper.getEndAfterPadding()) / 2)) {
            return childEnd - orientationHelper.getEndAfterPadding();
        }
        int childEnd2 = getChildEnd(view, orientationHelper);
        int end = orientationHelper.getEnd();
        return childEnd2 - end;
    }

    private int distanceToStart(View view, LinearLayoutManager linearLayoutManager, @NonNull OrientationHelper orientationHelper) {
        int childStart;
        int childLayoutPosition = this.recyclerView.getChildLayoutPosition(view);
        boolean clipToPadding = this.recyclerView.getClipToPadding();
        if ((childLayoutPosition == 0 || childLayoutPosition == linearLayoutManager.getItemCount() - 1) && !clipToPadding) {
            childStart = getChildStart(view, orientationHelper);
            if (childStart >= orientationHelper.getStartAfterPadding() / 2) {
                childStart -= orientationHelper.getStartAfterPadding();
            }
        } else {
            childStart = getChildStart(view, orientationHelper);
        }
        return !clipToPadding ? childStart - this.recyclerView.getPaddingLeft() : childStart;
    }

    @Nullable
    private View findEdgeView(LinearLayoutManager linearLayoutManager, OrientationHelper orientationHelper, boolean z) {
        View view = null;
        if (linearLayoutManager.getChildCount() == 0) {
            return null;
        }
        if (isAtEndOfList(linearLayoutManager) && !this.snapLastItem) {
            return null;
        }
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int i3 = 0; i3 < linearLayoutManager.getChildCount(); i3++) {
            View childAt = linearLayoutManager.getChildAt(i3);
            int iAbs = z ? Math.abs(getChildStart(childAt, orientationHelper)) : Math.abs(getChildEnd(childAt, orientationHelper) - orientationHelper.getEnd());
            if (iAbs < i2) {
                view = childAt;
                i2 = iAbs;
            }
        }
        return view;
    }

    private int getChildEnd(View view, OrientationHelper orientationHelper) {
        return this.ignoreDecorate ? view.getRight() : orientationHelper.getDecoratedEnd(view);
    }

    private int getChildStart(View view, OrientationHelper orientationHelper) {
        return this.ignoreDecorate ? view.getLeft() : orientationHelper.getDecoratedStart(view);
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.horizontalHelper == null) {
            this.horizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.horizontalHelper;
    }

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.verticalHelper == null) {
            this.verticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.verticalHelper;
    }

    private boolean isAtEndOfList(LinearLayoutManager linearLayoutManager) {
        int i2 = this.gravity;
        return (i2 == 8388611 || i2 == 8388613 || i2 == 48 || i2 == 80) ? linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1 : linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0;
    }

    private boolean isClipToPadding() {
        return Build.VERSION.SDK_INT >= 21 ? this.recyclerView.getClipToPadding() : this.isClipToPadding;
    }

    private void scrollTo(int i2, boolean z) {
        if (this.recyclerView.getLayoutManager() != null) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.recyclerView.findViewHolderForAdapterPosition(i2);
            if (viewHolderFindViewHolderForAdapterPosition == null) {
                if (z) {
                    this.recyclerView.smoothScrollToPosition(i2);
                    return;
                } else {
                    this.recyclerView.scrollToPosition(i2);
                    return;
                }
            }
            int[] iArrCalculateDistanceToFinalSnap = calculateDistanceToFinalSnap(this.recyclerView.getLayoutManager(), viewHolderFindViewHolderForAdapterPosition.itemView);
            if (z) {
                this.recyclerView.smoothScrollBy(iArrCalculateDistanceToFinalSnap[0], iArrCalculateDistanceToFinalSnap[1]);
            } else {
                this.recyclerView.scrollBy(iArrCalculateDistanceToFinalSnap[0], iArrCalculateDistanceToFinalSnap[1]);
            }
        }
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        if (recyclerView != null) {
            recyclerView.setOnFlingListener(null);
            if (this.listener != null) {
                recyclerView.addOnScrollListener(this.scrollListener);
            }
            this.recyclerView = recyclerView;
        }
    }

    @NonNull
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return iArr;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (!linearLayoutManager.canScrollHorizontally()) {
            iArr[0] = 0;
        } else if (this.gravity == 8388611) {
            iArr[0] = distanceToStart(view, linearLayoutManager, getHorizontalHelper(linearLayoutManager));
        } else {
            iArr[0] = distanceToEnd(view, linearLayoutManager, getHorizontalHelper(linearLayoutManager));
        }
        if (!linearLayoutManager.canScrollVertically()) {
            iArr[1] = 0;
        } else if (this.gravity == 48) {
            iArr[1] = distanceToStart(view, linearLayoutManager, getVerticalHelper(linearLayoutManager));
        } else {
            iArr[1] = distanceToEnd(view, linearLayoutManager, getVerticalHelper(linearLayoutManager));
        }
        return iArr;
    }

    public void enableLastItemSnap(boolean z) {
        this.snapLastItem = z;
    }

    @Nullable
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        View viewFindEdgeView = null;
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int i2 = this.gravity;
        if (i2 == 48) {
            viewFindEdgeView = findEdgeView(linearLayoutManager, getVerticalHelper(linearLayoutManager), true);
        } else if (i2 == 80) {
            viewFindEdgeView = findEdgeView(linearLayoutManager, getVerticalHelper(linearLayoutManager), false);
        } else if (i2 == 8388611) {
            viewFindEdgeView = findEdgeView(linearLayoutManager, getHorizontalHelper(linearLayoutManager), true);
        } else if (i2 == 8388613) {
            viewFindEdgeView = findEdgeView(linearLayoutManager, getHorizontalHelper(linearLayoutManager), false);
        }
        if (viewFindEdgeView != null) {
            this.currentSnappedPosition = this.recyclerView.getChildAdapterPosition(viewFindEdgeView);
        } else {
            this.currentSnappedPosition = -1;
        }
        return viewFindEdgeView;
    }

    public int getCurrentSnappedPosition() {
        return this.currentSnappedPosition;
    }

    public void scrollToPosition(int i2) {
        scrollTo(i2, false);
    }

    public void setClipToPadding(boolean z) {
        this.isClipToPadding = z;
    }

    public void setIgnoreDecorate(boolean z) {
        this.ignoreDecorate = z;
    }

    public void smoothScrollToPosition(int i2) {
        scrollTo(i2, true);
    }
}
