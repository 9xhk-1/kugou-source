package com.kugou.uilib.widget.recyclerview.delegate.impl.snaphelper;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class GravitySnapHelper extends LinearSnapHelper {

    @NonNull
    private final GravityDelegate delegate;

    public interface SnapListener {
        void onSnap(int i2);
    }

    public GravitySnapHelper(int i2) {
        this(i2, false, null);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        this.delegate.attachToRecyclerView(recyclerView);
        super.attachToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        return this.delegate.calculateDistanceToFinalSnap(layoutManager, view);
    }

    public void enableLastItemSnap(boolean z) {
        this.delegate.enableLastItemSnap(z);
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        return this.delegate.findSnapView(layoutManager);
    }

    public int getCurrentSnappedPosition() {
        return this.delegate.getCurrentSnappedPosition();
    }

    public void scrollToPosition(int i2) {
        this.delegate.scrollToPosition(i2);
    }

    public void setClipToPadding(boolean z) {
        this.delegate.setClipToPadding(z);
    }

    public void setIgnoreDecorate(boolean z) {
        this.delegate.setIgnoreDecorate(z);
    }

    public void smoothScrollToPosition(int i2) {
        this.delegate.smoothScrollToPosition(i2);
    }

    public GravitySnapHelper(int i2, boolean z) {
        this(i2, z, null);
    }

    public GravitySnapHelper(int i2, boolean z, @Nullable SnapListener snapListener) {
        this.delegate = new GravityDelegate(i2, z, snapListener);
    }
}
