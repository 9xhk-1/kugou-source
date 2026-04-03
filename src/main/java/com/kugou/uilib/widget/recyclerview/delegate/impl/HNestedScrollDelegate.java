package com.kugou.uilib.widget.recyclerview.delegate.impl;

import android.content.res.TypedArray;
import android.view.MotionEvent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;
import com.kugou.uilib.utils.KGUILog;
import com.kugou.uilib.widget.recyclerview.delegate.base.AbsRecyclerViewDelegate;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.recyclerview.delegate.base.IRecyclerViewDelegate")
public class HNestedScrollDelegate extends AbsRecyclerViewDelegate {
    private static final String TAG = "HNestedScrollDelegate";
    private boolean disallowIntercept = true;
    private boolean edgeScrollEnable = true;
    private boolean intercept;
    private RecyclerView mRecyclerView;
    private int mStartX;
    private int mStartY;

    private boolean isLeftEdge() {
        int iFindLastCompletelyVisibleItemPosition;
        int iFindFirstCompletelyVisibleItemPosition;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            iFindLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        } else if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            iFindFirstCompletelyVisibleItemPosition = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
            iFindLastCompletelyVisibleItemPosition = gridLayoutManager.findLastCompletelyVisibleItemPosition();
        } else {
            iFindLastCompletelyVisibleItemPosition = 0;
            iFindFirstCompletelyVisibleItemPosition = 0;
        }
        int childCount = layoutManager.getChildCount();
        if (KGUILog.DEBUG) {
            StringBuilder sb = new StringBuilder();
            sb.append("isLeftEdge: visibleItemCount=");
            sb.append(childCount);
            sb.append(" firstVisibleItemPos=");
            sb.append(iFindFirstCompletelyVisibleItemPosition);
            sb.append(" lastVisibleItemPos=");
            sb.append(iFindLastCompletelyVisibleItemPosition);
            sb.append(" result=");
            sb.append(childCount > 0 && iFindFirstCompletelyVisibleItemPosition == 0);
            KGUILog.d(TAG, sb.toString());
        }
        return childCount > 0 && iFindFirstCompletelyVisibleItemPosition == 0;
    }

    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.getBoolean(R.styleable.KGUIRecyclerBaseView_kgui_hor_nest_scroll_enable, false);
    }

    private boolean isRightEdge() {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int iFindLastCompletelyVisibleItemPosition = layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() : layoutManager instanceof GridLayoutManager ? ((GridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() : 0;
        int childCount = layoutManager.getChildCount();
        int itemCount = layoutManager.getItemCount();
        if (KGUILog.DEBUG) {
            StringBuilder sb = new StringBuilder();
            sb.append("isRightEdge: visibleItemCount=");
            sb.append(childCount);
            sb.append(" lastVisibleItemPos=");
            sb.append(iFindLastCompletelyVisibleItemPosition);
            sb.append(" totalItemCount=");
            sb.append(itemCount);
            sb.append(" reuslt=");
            sb.append(iFindLastCompletelyVisibleItemPosition == itemCount + (-1));
            KGUILog.d(TAG, sb.toString());
        }
        return childCount > 0 && iFindLastCompletelyVisibleItemPosition == itemCount - 1;
    }

    @Override // com.kugou.uilib.widget.recyclerview.delegate.base.AbsRecyclerViewDelegate, com.kugou.uilib.widget.recyclerview.delegate.base.IRecyclerViewDelegate
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (KGUILog.DEBUG) {
            KGUILog.d(TAG, "dispatchTouchEvent: result=" + zDispatchTouchEvent + " action=" + motionEvent.getAction());
        }
        return zDispatchTouchEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
    @Override // com.kugou.uilib.widget.recyclerview.delegate.base.AbsRecyclerViewDelegate, com.kugou.uilib.widget.recyclerview.delegate.base.IRecyclerViewDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.uilib.widget.recyclerview.delegate.impl.HNestedScrollDelegate.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.kugou.uilib.widget.recyclerview.delegate.base.AbsRecyclerViewDelegate, com.kugou.uilib.widget.recyclerview.delegate.base.IRecyclerViewDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (KGUILog.DEBUG) {
            KGUILog.d(TAG, "onTouchEvent: result=" + zOnTouchEvent + " action=" + motionEvent.getAction());
        }
        return zOnTouchEvent;
    }

    public void setDisallowIntercept(boolean z) {
        this.disallowIntercept = z;
    }

    public void setEdgeScrollEnable(boolean z) {
        this.edgeScrollEnable = z;
    }

    @Override // com.kugou.uilib.widget.recyclerview.delegate.base.AbsRecyclerViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(RecyclerView recyclerView, TypedArray typedArray) {
        super.init(recyclerView, typedArray);
        this.mRecyclerView = recyclerView;
    }
}
