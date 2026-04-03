package com.kugou.uilib.widget.recyclerview.delegate.impl;

import android.content.res.TypedArray;
import android.view.ViewConfiguration;
import androidx.core.view.ViewConfigurationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;
import com.kugou.uilib.widget.recyclerview.delegate.base.AbsRecyclerViewDelegate;
import com.kugou.uilib.widget.recyclerview.scroll.ScrollCharacter;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.recyclerview.delegate.base.IRecyclerViewDelegate")
public class GestureDelegate extends AbsRecyclerViewDelegate {
    private float mDownX;
    private float mDownY;
    private boolean mEnableCompact;
    private int mTouchSlop;
    private RecyclerView view;

    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.getInteger(R.styleable.KGUIRecyclerBaseView_kgui_scroll_character, 0) == ScrollCharacter.CHILD.ordinal();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0079  */
    @Override // com.kugou.uilib.widget.recyclerview.delegate.base.AbsRecyclerViewDelegate, com.kugou.uilib.widget.recyclerview.delegate.base.IRecyclerViewDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r5.view
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            float r0 = r6.getY()
            float r2 = r6.getX()
            int r3 = r6.getAction()
            r4 = 1
            if (r3 == 0) goto L83
            if (r3 == r4) goto L79
            r6 = 2
            if (r3 == r6) goto L23
            r6 = 3
            if (r3 == r6) goto L79
            goto L98
        L23:
            boolean r6 = r5.mEnableCompact
            if (r6 == 0) goto L98
            float r6 = r5.mDownX
            float r2 = r2 - r6
            int r6 = (int) r2
            float r2 = r5.mDownY
            float r0 = r0 - r2
            int r0 = (int) r0
            androidx.recyclerview.widget.RecyclerView r2 = r5.view
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r2.getLayoutManager()
            boolean r2 = r2.canScrollHorizontally()
            int r3 = java.lang.Math.abs(r6)
            int r4 = r5.mTouchSlop
            if (r3 > r4) goto L49
            int r3 = java.lang.Math.abs(r0)
            int r4 = r5.mTouchSlop
            if (r3 <= r4) goto L98
        L49:
            if (r2 == 0) goto L61
            int r3 = java.lang.Math.abs(r6)
            int r4 = java.lang.Math.abs(r0)
            int r4 = r4 + 30
            if (r3 >= r4) goto L61
            androidx.recyclerview.widget.RecyclerView r6 = r5.view
            android.view.ViewParent r6 = r6.getParent()
            r6.requestDisallowInterceptTouchEvent(r1)
            goto L98
        L61:
            if (r2 != 0) goto L98
            int r0 = java.lang.Math.abs(r0)
            int r6 = java.lang.Math.abs(r6)
            int r6 = r6 + 30
            if (r0 >= r6) goto L98
            androidx.recyclerview.widget.RecyclerView r6 = r5.view
            android.view.ViewParent r6 = r6.getParent()
            r6.requestDisallowInterceptTouchEvent(r1)
            goto L98
        L79:
            androidx.recyclerview.widget.RecyclerView r6 = r5.view
            android.view.ViewParent r6 = r6.getParent()
            r6.requestDisallowInterceptTouchEvent(r1)
            goto L98
        L83:
            float r0 = r6.getX()
            r5.mDownX = r0
            float r6 = r6.getY()
            r5.mDownY = r6
            androidx.recyclerview.widget.RecyclerView r6 = r5.view
            android.view.ViewParent r6 = r6.getParent()
            r6.requestDisallowInterceptTouchEvent(r4)
        L98:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.uilib.widget.recyclerview.delegate.impl.GestureDelegate.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setEnableCompact(boolean z) {
        this.mEnableCompact = z;
    }

    @Override // com.kugou.uilib.widget.recyclerview.delegate.base.AbsRecyclerViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(RecyclerView recyclerView, TypedArray typedArray) {
        this.view = recyclerView;
        this.mEnableCompact = typedArray.getBoolean(R.styleable.KGUIRecyclerBaseView_kgui_direction_compact_enable, false);
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(recyclerView.getContext()));
    }

    @Override // com.kugou.uilib.widget.recyclerview.delegate.base.AbsRecyclerViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(RecyclerView recyclerView) {
        this.view = recyclerView;
    }
}
