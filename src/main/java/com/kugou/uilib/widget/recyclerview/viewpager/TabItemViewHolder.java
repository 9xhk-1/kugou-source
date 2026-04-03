package com.kugou.uilib.widget.recyclerview.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TabItemViewHolder {
    private final View itemView;
    private String title;

    public TabItemViewHolder(Context context, String str) {
        this.title = str;
        this.itemView = inflate(context);
        getTitleView().setText(str);
    }

    public View getItemView() {
        return this.itemView;
    }

    public abstract TextView getTitleView();

    public abstract View inflate(Context context);

    public abstract void onSelectedChange(boolean z);
}
