package com.kugou.uilib.widget.recyclerview.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kugou.uilib.R;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIDefaultTab extends TabItemViewHolder {
    public KGUIDefaultTab(Context context, String str) {
        super(context, str);
    }

    @Override // com.kugou.uilib.widget.recyclerview.viewpager.TabItemViewHolder
    public TextView getTitleView() {
        return (TextView) getItemView().findViewById(R.id.tab_title);
    }

    @Override // com.kugou.uilib.widget.recyclerview.viewpager.TabItemViewHolder
    public View inflate(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.common_swipe_tabview_item, (ViewGroup) null, false);
    }

    @Override // com.kugou.uilib.widget.recyclerview.viewpager.TabItemViewHolder
    public void onSelectedChange(boolean z) {
        String string;
        TextView titleView = getTitleView();
        titleView.setSelected(z);
        if (z) {
            string = titleView.getText().toString() + "已选中";
        } else {
            string = titleView.getText().toString();
        }
        titleView.setContentDescription(string);
    }
}
