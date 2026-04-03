package com.kugou.uilib.widget.dialog.bottomsheet;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class MyDividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = {R.attr.listDivider};
    public static final int HORIZONTAL = 0;
    private static final String TAG = "DividerItem";
    public static final int VERTICAL = 1;
    private final Rect mBounds = new Rect();
    private Drawable mDivider;
    private boolean mIsShowBottomDivider;
    private int mOrientation;

    public MyDividerItemDecoration(Context context, int i2, boolean z) {
        this.mIsShowBottomDivider = z;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(ATTRS);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        this.mDivider = drawable;
        if (drawable == null) {
            Log.w(TAG, "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        typedArrayObtainStyledAttributes.recycle();
        setOrientation(i2);
    }

    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int height;
        int paddingTop;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int childCount = recyclerView.getChildCount();
        int itemCount = state.getItemCount() - 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            if (this.mIsShowBottomDivider || childAdapterPosition < itemCount) {
                recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.mBounds);
                int iRound = this.mBounds.right + Math.round(childAt.getTranslationX());
                this.mDivider.setBounds(iRound - this.mDivider.getIntrinsicWidth(), paddingTop, iRound, height);
                this.mDivider.draw(canvas);
            }
        }
        canvas.restore();
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int width;
        int paddingLeft;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            paddingLeft = 0;
        }
        int childCount = recyclerView.getChildCount();
        int itemCount = state.getItemCount() - 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            if (this.mIsShowBottomDivider || childAdapterPosition < itemCount) {
                recyclerView.getDecoratedBoundsWithMargins(childAt, this.mBounds);
                int iRound = this.mBounds.bottom + Math.round(childAt.getTranslationY());
                this.mDivider.setBounds(paddingLeft, iRound - this.mDivider.getIntrinsicHeight(), width, iRound);
                this.mDivider.draw(canvas);
            }
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.mDivider == null) {
            rect.set(0, 0, 0, 0);
            return;
        }
        if (this.mOrientation == 1) {
            int itemCount = state.getItemCount() - 1;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (this.mIsShowBottomDivider || childAdapterPosition < itemCount) {
                rect.set(0, 0, 0, this.mDivider.getIntrinsicHeight());
                return;
            } else {
                rect.set(0, 0, 0, 0);
                return;
            }
        }
        int itemCount2 = state.getItemCount() - 1;
        int childAdapterPosition2 = recyclerView.getChildAdapterPosition(view);
        if (this.mIsShowBottomDivider || childAdapterPosition2 < itemCount2) {
            rect.set(0, 0, this.mDivider.getIntrinsicWidth(), 0);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getLayoutManager() == null || this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawVertical(canvas, recyclerView, state);
        } else {
            drawHorizontal(canvas, recyclerView, state);
        }
    }

    public void setDrawable(@NonNull Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.mDivider = drawable;
    }

    public void setOrientation(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        this.mOrientation = i2;
    }
}
