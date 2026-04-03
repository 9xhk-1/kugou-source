package com.kugou.uilib.widget.recyclerview.pulltorefresh;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kugou.uilib.widget.recyclerview.KGUIRecyclerBaseView;
import com.kugou.uilib.widget.recyclerview.KGUIRecyclerView;
import com.kugou.uilib.widget.recyclerview.RecyclerHelper;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIPullToRefreshRecyclerView2 extends KGUIPullToRefreshBase2<KGUIRecyclerBaseView> {
    public KGUIPullToRefreshRecyclerView2(Context context) {
        super(context);
    }

    private int getScollYDistance() {
        RecyclerView.LayoutManager layoutManager = ((KGUIRecyclerBaseView) this.mRefreshableView).getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return 0;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        View viewFindViewByPosition = linearLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
        return (iFindFirstVisibleItemPosition * viewFindViewByPosition.getHeight()) - viewFindViewByPosition.getTop();
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public boolean isReadyForPullEnd() {
        return RecyclerHelper.isLastItemVisible((RecyclerView) this.mRefreshableView);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public boolean isReadyForPullStart() {
        return RecyclerHelper.isFirstItemVisible((RecyclerView) this.mRefreshableView);
    }

    public KGUIPullToRefreshRecyclerView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public KGUIRecyclerView createRefreshableView(Context context, AttributeSet attributeSet) {
        KGUIRecyclerView kGUIRecyclerView = new KGUIRecyclerView(context, attributeSet);
        kGUIRecyclerView.setId(R.id.list);
        kGUIRecyclerView.setOverScrollMode(2);
        return kGUIRecyclerView;
    }

    public KGUIPullToRefreshRecyclerView2(Context context, Mode mode) {
        super(context, mode);
    }

    public KGUIPullToRefreshRecyclerView2(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }
}
