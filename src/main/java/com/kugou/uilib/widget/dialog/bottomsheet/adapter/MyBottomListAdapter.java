package com.kugou.uilib.widget.dialog.bottomsheet.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kugou.uilib.R;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MyBottomListAdapter extends CommonBottomListAdapter<String, MyVH> {

    public static class MyVH extends RecyclerView.ViewHolder {
        private TextView mItemTv;

        public MyVH(@NonNull View view) {
            super(view);
            this.mItemTv = (TextView) view.findViewById(R.id.tv_item);
        }
    }

    public MyBottomListAdapter(List<String> list) {
        super(list);
    }

    @Override // com.kugou.uilib.widget.dialog.bottomsheet.adapter.CommonBottomListAdapter
    public int getItemLayoutId() {
        return R.layout.kgui_bottom_sheet_item_layout;
    }

    @Override // com.kugou.uilib.widget.dialog.bottomsheet.adapter.CommonBottomListAdapter
    public void convertView(@NonNull MyVH myVH, int i2) {
        myVH.mItemTv.setText((CharSequence) this.datas.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public MyVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new MyVH(getItemLayout(viewGroup));
    }
}
