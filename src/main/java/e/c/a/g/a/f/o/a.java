package e.c.a.g.a.f.o;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.common.widget.XCommonLoadingLayout;
import com.kugou.uilib.widget.recyclerview.pulltorefresh.AbsLoadingLayout;
import com.kugou.uilib.widget.recyclerview.pulltorefresh.Mode;
import com.kugou.uilib.widget.recyclerview.pulltorefresh.Orientation;
import e.c.a.g.a.s.l1;

/* JADX INFO: loaded from: classes.dex */
public class a extends AbsLoadingLayout {
    public XCommonLoadingLayout a;

    public a(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
        XCommonLoadingLayout xCommonLoadingLayout = (XCommonLoadingLayout) LayoutInflater.from(context).inflate(R.layout.x_loading_white, (ViewGroup) null, false);
        this.a = xCommonLoadingLayout;
        xCommonLoadingLayout.setViewType(2);
        this.a.setViewSize(1);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.AbsLoadingLayout, com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public int getContentSize() {
        return l1.d(this.a.getContext(), 44.0f);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.AbsLoadingLayout, com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public View getContentView() {
        return this.a;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.AbsLoadingLayout, com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void onPull(float f2) {
        this.a.setPullScale(Math.max((Math.min(f2, 1.0f) + 0.6f) - 1.0f, 0.0f) / 0.6f);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.AbsLoadingLayout, com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void pullToRefresh() {
        this.a.setVisibility(0);
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.AbsLoadingLayout, com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void refreshing() {
        this.a.setVisibility(0);
        this.a.g();
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.AbsLoadingLayout, com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void releaseToRefresh() {
        this.a.c();
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.AbsLoadingLayout, com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void reset() {
        this.a.d();
    }
}
