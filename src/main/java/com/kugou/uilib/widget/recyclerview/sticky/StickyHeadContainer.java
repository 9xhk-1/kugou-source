package com.kugou.uilib.widget.recyclerview.sticky;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class StickyHeadContainer extends ViewGroup {
    private int mBottom;
    private DataCallback mDataCallback;
    private int mLastOffset;
    private int mLastStickyHeadPosition;
    private int mLeft;
    private int mOffset;
    private int mRight;
    private int mTop;

    public interface DataCallback {
        void onDataChange(int i2);
    }

    public StickyHeadContainer(Context context) {
        this(context, null);
    }

    public static StickyItemDecoration bind(RecyclerView recyclerView, StickyJudgeable stickyJudgeable, StickyHeadContainer stickyHeadContainer) {
        StickyItemDecoration stickyItemDecoration = new StickyItemDecoration(stickyHeadContainer, stickyJudgeable);
        stickyItemDecoration.setOnStickyChangeListener(new OnStickyChangeListener() { // from class: com.kugou.uilib.widget.recyclerview.sticky.StickyHeadContainer.2
            @Override // com.kugou.uilib.widget.recyclerview.sticky.OnStickyChangeListener
            public void onInVisible() {
                StickyHeadContainer.this.reset();
                StickyHeadContainer.this.setVisibility(4);
            }

            @Override // com.kugou.uilib.widget.recyclerview.sticky.OnStickyChangeListener
            public void onScrollable(int i2) {
                StickyHeadContainer.this.scrollChild(i2);
                StickyHeadContainer.this.setVisibility(0);
            }
        });
        recyclerView.addItemDecoration(stickyItemDecoration);
        return stickyItemDecoration;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public int getChildHeight() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return childAt.getHeight();
    }

    public void onDataChange(int i2) {
        DataCallback dataCallback = this.mDataCallback;
        if (dataCallback != null && this.mLastStickyHeadPosition != i2) {
            dataCallback.onDataChange(i2);
        }
        this.mLastStickyHeadPosition = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.mLeft = paddingLeft + marginLayoutParams.leftMargin;
        this.mRight = childAt.getMeasuredWidth() + this.mLeft;
        this.mTop = paddingTop + marginLayoutParams.topMargin + this.mOffset;
        int measuredHeight = childAt.getMeasuredHeight();
        int i6 = this.mTop;
        int i7 = measuredHeight + i6;
        this.mBottom = i7;
        childAt.layout(this.mLeft, i6, this.mRight, i7);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (getChildCount() != 1) {
            throw new IllegalArgumentException("只允许容器添加1个子View！");
        }
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        measureChildWithMargins(childAt, i2, 0, i3, 0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
        int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(ViewGroup.resolveSize(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2), ViewGroup.resolveSize(Math.max(paddingTop, getSuggestedMinimumHeight()), i3));
    }

    public void reset() {
        this.mLastStickyHeadPosition = Integer.MIN_VALUE;
    }

    public void scrollChild(int i2) {
        int i3 = this.mLastOffset;
        if (i3 != i2 && i3 != Integer.MIN_VALUE) {
            this.mOffset = i2;
            View childAt = getChildAt(0);
            if (childAt != null) {
                ViewCompat.offsetTopAndBottom(childAt, this.mOffset - this.mLastOffset);
            }
        }
        this.mLastOffset = this.mOffset;
    }

    public void setDataCallback(DataCallback dataCallback) {
        this.mDataCallback = dataCallback;
    }

    public StickyHeadContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public StickyHeadContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mLastOffset = Integer.MIN_VALUE;
        this.mLastStickyHeadPosition = Integer.MIN_VALUE;
        setOnClickListener(new View.OnClickListener() { // from class: com.kugou.uilib.widget.recyclerview.sticky.StickyHeadContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }
}
