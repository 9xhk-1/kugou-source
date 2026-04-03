package com.kugou.uilib.widget.dialog.bottomsheet;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIBottomSheetBehavior<V extends ViewGroup> extends BottomSheetBehavior<V> {
    private DownDragDecisionMaker mDownDragDecisionMaker;
    private boolean mAllowDrag = true;
    private boolean mMotionEventCanDrag = true;

    public interface DownDragDecisionMaker {
        boolean canDrag(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent);
    }

    public void setAllowDrag(boolean z) {
        this.mAllowDrag = z;
    }

    public void setDownDragDecisionMaker(DownDragDecisionMaker downDragDecisionMaker) {
        this.mDownDragDecisionMaker = downDragDecisionMaker;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        if (!this.mAllowDrag) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            DownDragDecisionMaker downDragDecisionMaker = this.mDownDragDecisionMaker;
            this.mMotionEventCanDrag = downDragDecisionMaker == null || downDragDecisionMaker.canDrag(coordinatorLayout, v, motionEvent);
        }
        if (this.mMotionEventCanDrag) {
            return super.onInterceptTouchEvent(coordinatorLayout, v, motionEvent);
        }
        return false;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i3) {
        if (this.mAllowDrag) {
            return super.onStartNestedScroll(coordinatorLayout, v, view, view2, i2, i3);
        }
        return false;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        if (!this.mAllowDrag) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            DownDragDecisionMaker downDragDecisionMaker = this.mDownDragDecisionMaker;
            this.mMotionEventCanDrag = downDragDecisionMaker == null || downDragDecisionMaker.canDrag(coordinatorLayout, v, motionEvent);
        }
        if (this.mMotionEventCanDrag) {
            return super.onTouchEvent(coordinatorLayout, v, motionEvent);
        }
        return false;
    }
}
