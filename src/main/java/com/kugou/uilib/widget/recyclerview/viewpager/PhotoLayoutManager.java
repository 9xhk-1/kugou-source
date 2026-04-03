package com.kugou.uilib.widget.recyclerview.viewpager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoLayoutManager extends RecyclerView.LayoutManager {
    public int TRANS_Y_GAP = 40;
    public int MAX_SHOW_COUNT = 5;
    public float SCALE_GAP = 0.03f;
    private final ArrayList<View> temp = new ArrayList<>();

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        if (getItemCount() - 1 < 0) {
            return;
        }
        int i2 = this.MAX_SHOW_COUNT;
        while (i2 >= 0) {
            try {
                View viewForPosition = recycler.getViewForPosition(i2);
                this.temp.add(viewForPosition);
                measureChildWithMargins(viewForPosition, 0, 0);
                int width = (getWidth() - getDecoratedMeasuredWidth(viewForPosition)) / 2;
                int height = (getHeight() - getDecoratedMeasuredHeight(viewForPosition)) / 2;
                layoutDecoratedWithMargins(viewForPosition, width, height, width + getDecoratedMeasuredWidth(viewForPosition), height + getDecoratedMeasuredHeight(viewForPosition));
                int i3 = this.MAX_SHOW_COUNT;
                int i4 = i2 == i3 ? i3 - 1 : i2;
                viewForPosition.setTranslationY(this.TRANS_Y_GAP * i4);
                float f2 = i4;
                viewForPosition.setScaleX(1.0f - (this.SCALE_GAP * f2));
                viewForPosition.setScaleY(1.0f - (this.SCALE_GAP * f2));
            } catch (Exception unused) {
            }
            i2--;
        }
        Iterator<View> it = this.temp.iterator();
        while (it.hasNext()) {
            addView(it.next());
        }
        this.temp.clear();
    }
}
