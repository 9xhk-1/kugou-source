package com.kugou.uilib.widget.dialog.bottomsheet.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CommonBottomListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    public List<T> datas;
    private OnItemClickListener<T> onItemClickListener;

    public interface OnItemClickListener<T> {
        void onItemClick(T t, int i2);
    }

    public CommonBottomListAdapter(List<T> list) {
        this.datas = list;
    }

    public abstract void convertView(@NonNull VH vh, int i2);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<T> list = this.datas;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public View getItemLayout(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(getItemLayoutId(), viewGroup, false);
    }

    public abstract int getItemLayoutId();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull VH vh, @SuppressLint({RecyclerView.TAG}) final int i2) {
        convertView(vh, i2);
        vh.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.kugou.uilib.widget.dialog.bottomsheet.adapter.CommonBottomListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonBottomListAdapter.this.onItemClickListener != null) {
                    CommonBottomListAdapter.this.onItemClickListener.onItemClick(CommonBottomListAdapter.this.datas.get(i2), i2);
                }
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
