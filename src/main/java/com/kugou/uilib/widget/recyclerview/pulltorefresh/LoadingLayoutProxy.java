package com.kugou.uilib.widget.recyclerview.pulltorefresh;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class LoadingLayoutProxy implements ILoadingLayout {
    private final HashSet<ILoadingLayout> mLoadingLayouts = new HashSet<>();

    public void addLayout(ILoadingLayout iLoadingLayout) {
        if (iLoadingLayout != null) {
            this.mLoadingLayouts.add(iLoadingLayout);
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public int getContentSize() {
        return 0;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public View getContentView() {
        return null;
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void onPull(float f2) {
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void onScrollOffset(int i2) {
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void pullToRefresh() {
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void refreshing() {
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void releaseToRefresh() {
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void reset() {
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Iterator<ILoadingLayout> it = this.mLoadingLayouts.iterator();
        while (it.hasNext()) {
            it.next().setLastUpdatedLabel(charSequence);
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void setLoadingDrawable(Drawable drawable) {
        Iterator<ILoadingLayout> it = this.mLoadingLayouts.iterator();
        while (it.hasNext()) {
            it.next().setLoadingDrawable(drawable);
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void setPaddingTop(int i2) {
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void setPullLabel(CharSequence charSequence) {
        Iterator<ILoadingLayout> it = this.mLoadingLayouts.iterator();
        while (it.hasNext()) {
            it.next().setPullLabel(charSequence);
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        Iterator<ILoadingLayout> it = this.mLoadingLayouts.iterator();
        while (it.hasNext()) {
            it.next().setRefreshingLabel(charSequence);
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void setReleaseLabel(CharSequence charSequence) {
        Iterator<ILoadingLayout> it = this.mLoadingLayouts.iterator();
        while (it.hasNext()) {
            it.next().setReleaseLabel(charSequence);
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void setTextTypeface(Typeface typeface) {
        Iterator<ILoadingLayout> it = this.mLoadingLayouts.iterator();
        while (it.hasNext()) {
            it.next().setTextTypeface(typeface);
        }
    }

    public void setViewType(Typeface typeface) {
        Iterator<ILoadingLayout> it = this.mLoadingLayouts.iterator();
        while (it.hasNext()) {
            it.next().setTextTypeface(typeface);
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.ILoadingLayout
    public void setVisibility(int i2) {
    }
}
