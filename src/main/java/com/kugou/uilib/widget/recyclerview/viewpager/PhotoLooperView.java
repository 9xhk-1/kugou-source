package com.kugou.uilib.widget.recyclerview.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.kugou.uilib.widget.recyclerview.viewpager.PhotoItemTouchListener;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoLooperView extends RecyclerView {
    private ViewDragHelper helper;
    private PhotoItemTouchListener mPhotoItemTouchListener;
    private PhotoLayoutManager mPhotoLayoutManager;
    private float threshold;

    public PhotoLooperView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.threshold = 0.6f;
        init();
    }

    private void init() {
        PhotoLayoutManager photoLayoutManager = new PhotoLayoutManager();
        this.mPhotoLayoutManager = photoLayoutManager;
        setLayoutManager(photoLayoutManager);
        PhotoItemTouchListener photoItemTouchListener = new PhotoItemTouchListener();
        this.mPhotoItemTouchListener = photoItemTouchListener;
        photoItemTouchListener.attachToRecyclerView(this);
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.helper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public int getCurrentPosition() {
        return this.mPhotoItemTouchListener.getCurrentPosition();
    }

    public float getScaleGap() {
        return this.mPhotoLayoutManager.SCALE_GAP;
    }

    public int getShowCount() {
        return Math.min(this.mPhotoLayoutManager.MAX_SHOW_COUNT, getAdapter().getItemCount());
    }

    public float getThreshold() {
        return getWidth() * this.threshold;
    }

    public int getTransYGAP() {
        return this.mPhotoLayoutManager.TRANS_Y_GAP;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        this.mPhotoItemTouchListener.setAdapter(adapter);
    }

    public void setDragHelper(ViewDragHelper viewDragHelper) {
        this.helper = viewDragHelper;
    }

    public void setOnSwipListener(PhotoItemTouchListener.OnSwipListener onSwipListener) {
        this.mPhotoItemTouchListener.setOnSwipListener(onSwipListener);
    }

    public void setScaleGap(float f2) {
        this.mPhotoLayoutManager.SCALE_GAP = f2;
    }

    public void setShowCount(int i2) {
        this.mPhotoLayoutManager.MAX_SHOW_COUNT = i2;
    }

    public void setThreshold(float f2) {
        this.threshold = f2;
    }

    public void setTransYGAP(int i2) {
        this.mPhotoLayoutManager.TRANS_Y_GAP = i2;
    }

    public PhotoLooperView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.threshold = 0.6f;
        init();
    }

    public PhotoLooperView(Context context) {
        super(context);
        this.threshold = 0.6f;
        init();
    }
}
