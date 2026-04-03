package com.kugou.uilib.widget.recyclerview.viewpager;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoItemTouchListener implements RecyclerView.OnItemTouchListener {
    private View cache;
    private int curp;
    private int initCenterViewX;
    private int initCenterViewY;
    private ViewDragHelper mDragHelper;
    private boolean mOverThres;
    private PhotoLooperView mRecyclerView;
    private OnSwipListener onSwipListener;
    public Runnable showBottomTask = new Runnable() { // from class: com.kugou.uilib.widget.recyclerview.viewpager.PhotoItemTouchListener.2
        @Override // java.lang.Runnable
        public void run() {
            PhotoItemTouchListener photoItemTouchListener = PhotoItemTouchListener.this;
            photoItemTouchListener.processLinkageView(photoItemTouchListener.initCenterViewX, PhotoItemTouchListener.this.initCenterViewY);
        }
    };

    public class DragHelperCallback extends ViewDragHelper.Callback {
        private DragHelperCallback() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            return i2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i2, int i3) {
            return i2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return 256;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i2) {
            super.onViewDragStateChanged(i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
            PhotoItemTouchListener photoItemTouchListener = PhotoItemTouchListener.this;
            photoItemTouchListener.processLinkageView(photoItemTouchListener.initCenterViewX - i2, PhotoItemTouchListener.this.initCenterViewY - i3);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            int childCount = PhotoItemTouchListener.this.mRecyclerView.getChildCount();
            if (!PhotoItemTouchListener.this.mOverThres || childCount <= 1) {
                PhotoItemTouchListener.this.mDragHelper.smoothSlideViewTo(view, PhotoItemTouchListener.this.initCenterViewX, PhotoItemTouchListener.this.initCenterViewY);
                ViewCompat.postInvalidateOnAnimation(PhotoItemTouchListener.this.mRecyclerView);
                return;
            }
            PhotoItemTouchListener.this.mOverThres = false;
            RecyclerView.Adapter adapter = PhotoItemTouchListener.this.mRecyclerView.getAdapter();
            int itemCount = adapter.getItemCount();
            if (PhotoItemTouchListener.this.cache != null) {
                int showCount = PhotoItemTouchListener.this.mRecyclerView.getShowCount() + PhotoItemTouchListener.this.curp;
                if (showCount >= itemCount) {
                    showCount -= itemCount;
                }
                adapter.onBindViewHolder(PhotoItemTouchListener.this.mRecyclerView.getChildViewHolder(PhotoItemTouchListener.this.cache), showCount);
                PhotoItemTouchListener.this.mRecyclerView.removeCallbacks(PhotoItemTouchListener.this.showBottomTask);
                PhotoItemTouchListener.this.mRecyclerView.postDelayed(PhotoItemTouchListener.this.showBottomTask, 500L);
            }
            PhotoItemTouchListener.this.cache = view;
            if (PhotoItemTouchListener.this.onSwipListener != null) {
                PhotoItemTouchListener.this.onSwipListener.onSwip(view);
            }
            adapter.notifyItemMoved(0, Math.min(PhotoItemTouchListener.this.mRecyclerView.getShowCount(), adapter.getItemCount() - 1));
            PhotoItemTouchListener.access$108(PhotoItemTouchListener.this);
            if (PhotoItemTouchListener.this.curp == itemCount) {
                PhotoItemTouchListener.this.curp = 0;
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            return PhotoItemTouchListener.this.mRecyclerView.getChildAdapterPosition(view) != -1;
        }
    }

    public interface OnSwipListener {
        void onSwip(View view);
    }

    public static /* synthetic */ int access$108(PhotoItemTouchListener photoItemTouchListener) {
        int i2 = photoItemTouchListener.curp;
        photoItemTouchListener.curp = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processLinkageView(int i2, int i3) {
        double dSqrt = Math.sqrt((i2 * i2) + (i3 * i3));
        double threshold = getThreshold();
        Double.isNaN(threshold);
        double d2 = dSqrt / threshold;
        if (d2 > 1.0d) {
            this.mOverThres = true;
            d2 = 1.0d;
        } else {
            this.mOverThres = false;
        }
        int childCount = this.mRecyclerView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = this.mRecyclerView.getChildAt(i4);
            int i5 = (childCount - i4) - 1;
            if (i5 > 0 && i5 < this.mRecyclerView.getShowCount()) {
                float f2 = i5;
                double scaleGap = 1.0f - (this.mRecyclerView.getScaleGap() * f2);
                double scaleGap2 = this.mRecyclerView.getScaleGap();
                Double.isNaN(scaleGap2);
                Double.isNaN(scaleGap);
                childAt.setScaleX((float) (scaleGap + (scaleGap2 * d2)));
                double scaleGap3 = 1.0f - (this.mRecyclerView.getScaleGap() * f2);
                double scaleGap4 = this.mRecyclerView.getScaleGap();
                Double.isNaN(scaleGap4);
                Double.isNaN(scaleGap3);
                childAt.setScaleY((float) (scaleGap3 + (scaleGap4 * d2)));
                double transYGAP = this.mRecyclerView.getTransYGAP() * i5;
                double transYGAP2 = this.mRecyclerView.getTransYGAP();
                Double.isNaN(transYGAP2);
                Double.isNaN(transYGAP);
                childAt.setTranslationY((float) (transYGAP - (transYGAP2 * d2)));
            } else if (i5 == this.mRecyclerView.getShowCount()) {
                childAt.setScaleX(1.0f - (this.mRecyclerView.getScaleGap() * (this.mRecyclerView.getShowCount() - 1)));
                childAt.setScaleY(1.0f - (this.mRecyclerView.getScaleGap() * (this.mRecyclerView.getShowCount() - 1)));
                childAt.setTranslationY(this.mRecyclerView.getTransYGAP() * (this.mRecyclerView.getShowCount() - 1));
            }
        }
    }

    public void attachToRecyclerView(PhotoLooperView photoLooperView) {
        this.mRecyclerView = photoLooperView;
        this.mDragHelper = ViewDragHelper.create(photoLooperView, 10.0f, new DragHelperCallback());
        this.initCenterViewX = photoLooperView.getLeft();
        this.initCenterViewY = photoLooperView.getTop();
        photoLooperView.addOnItemTouchListener(this);
        photoLooperView.setDragHelper(this.mDragHelper);
    }

    public int getCurrentPosition() {
        return this.curp;
    }

    public float getThreshold() {
        return this.mRecyclerView.getThreshold();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        return this.mDragHelper.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.mDragHelper.processTouchEvent(motionEvent);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: com.kugou.uilib.widget.recyclerview.viewpager.PhotoItemTouchListener.1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                PhotoItemTouchListener.this.curp = 0;
            }
        });
    }

    public void setOnSwipListener(OnSwipListener onSwipListener) {
        this.onSwipListener = onSwipListener;
    }
}
