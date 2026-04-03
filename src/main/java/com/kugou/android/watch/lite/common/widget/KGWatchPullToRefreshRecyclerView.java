package com.kugou.android.watch.lite.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kugou.uilib.widget.recyclerview.KGUIRecyclerView;
import com.kugou.uilib.widget.recyclerview.pulltorefresh.AnimationStyle;
import com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout;
import com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshRecyclerView;
import com.kugou.uilib.widget.recyclerview.pulltorefresh.Mode;
import com.kugou.uilib.widget.recyclerview.pulltorefresh.Orientation;
import com.kugou.uilib.widget.recyclerview.pulltorefresh.PtrLoadingLayoutFactory;

/* JADX INFO: loaded from: classes.dex */
public class KGWatchPullToRefreshRecyclerView extends KGUIPullToRefreshRecyclerView {

    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
            if (i2 == 0 && KGWatchPullToRefreshRecyclerView.this.isReadyForPullEnd()) {
                if ((KGWatchPullToRefreshRecyclerView.this.getMode() == Mode.BOTH || KGWatchPullToRefreshRecyclerView.this.getMode() == Mode.PULL_FROM_END) && KGWatchPullToRefreshRecyclerView.this.mOnRefreshListener2 != null) {
                    KGWatchPullToRefreshRecyclerView.this.mOnRefreshListener2.onPullUpToRefresh(KGWatchPullToRefreshRecyclerView.this);
                }
            }
        }
    }

    public class b extends PtrLoadingLayoutFactory {
        public b(KGWatchPullToRefreshRecyclerView kGWatchPullToRefreshRecyclerView) {
        }

        @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.PtrLoadingLayoutFactory
        public ILoadingLayout createLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray, AnimationStyle animationStyle) {
            return new e.c.a.g.a.f.o.a(context, mode, orientation, typedArray);
        }
    }

    public KGWatchPullToRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public PtrLoadingLayoutFactory getPtrLoadingLayoutFactory() {
        return new b(this);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshRecyclerView, com.kugou.uilib.widget.recyclerview.pulltorefresh.KGUIPullToRefreshBase
    public KGUIRecyclerView createRefreshableView(Context context, AttributeSet attributeSet) {
        KGUIRecyclerView kGUIRecyclerViewCreateRefreshableView = super.createRefreshableView(context, attributeSet);
        kGUIRecyclerViewCreateRefreshableView.addOnScrollListener(new a());
        return kGUIRecyclerViewCreateRefreshableView;
    }
}
