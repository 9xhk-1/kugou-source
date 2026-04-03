package com.kugou.uilib.widget.recyclerview.delegate.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.kugou.uilib.widget.recyclerview.delegate.OnItemClickListener;
import com.kugou.uilib.widget.recyclerview.delegate.OnItemLongClickListener;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseHeaderAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int ITEM_TYPE_FOOTERAREA = -101;
    public static final int ITEM_TYPE_HEADERAREA = -100;
    public OnItemClickListener mOnItemClickListener;
    public OnItemLongClickListener mOnItemLongClickListener;
    public LinearLayout mHeaderArea = null;
    public LinearLayout mFooterArea = null;
    public HashSet<View> headerCache = null;
    public HashSet<View> footerCache = null;

    public class ExtraAreaHolder extends ViewHolder {
        public ExtraAreaHolder(View view) {
            super(view);
            view.setClickable(false);
            view.setLongClickable(false);
        }
    }

    public abstract class ViewHolder<D> extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.kugou.uilib.widget.recyclerview.delegate.adapter.BaseHeaderAdapter.ViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ViewHolder viewHolder = ViewHolder.this;
                    if (BaseHeaderAdapter.this.mOnItemClickListener != null) {
                        int adapterPosition = viewHolder.getAdapterPosition() - BaseHeaderAdapter.this.headerAreaCount();
                        ViewHolder viewHolder2 = ViewHolder.this;
                        BaseHeaderAdapter.this.mOnItemClickListener.onItemClick(view2, adapterPosition, viewHolder2.getItemId());
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.kugou.uilib.widget.recyclerview.delegate.adapter.BaseHeaderAdapter.ViewHolder.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    ViewHolder viewHolder = ViewHolder.this;
                    if (BaseHeaderAdapter.this.mOnItemLongClickListener == null) {
                        return false;
                    }
                    int adapterPosition = viewHolder.getAdapterPosition() - BaseHeaderAdapter.this.headerAreaCount();
                    ViewHolder viewHolder2 = ViewHolder.this;
                    return BaseHeaderAdapter.this.mOnItemLongClickListener.onItemLongClick(view2, adapterPosition, viewHolder2.getItemId());
                }
            });
        }

        public void refresh(D d2) {
        }
    }

    private void checkArgumentNotNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Argument can not be null!");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.widget.LinearLayout getExtraArea(android.view.ViewGroup r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.recyclerview.widget.RecyclerView
            r1 = -1
            r2 = 1
            r3 = -2
            if (r0 == 0) goto L1e
            r0 = r6
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            boolean r4 = r0 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r4 == 0) goto L1e
            androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
            int r0 = r0.getOrientation()
            if (r0 != r2) goto L1b
            goto L1f
        L1b:
            r1 = -2
            r3 = -1
            goto L1f
        L1e:
            r1 = -2
        L1f:
            android.widget.LinearLayout r0 = new android.widget.LinearLayout
            android.content.Context r6 = r6.getContext()
            r0.<init>(r6)
            r0.setOrientation(r2)
            androidx.recyclerview.widget.RecyclerView$LayoutParams r6 = new androidx.recyclerview.widget.RecyclerView$LayoutParams
            r6.<init>(r1, r3)
            r0.setLayoutParams(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.uilib.widget.recyclerview.delegate.adapter.BaseHeaderAdapter.getExtraArea(android.view.ViewGroup):android.widget.LinearLayout");
    }

    public void addFooterView(View view) {
        checkArgumentNotNull(view);
        LinearLayout linearLayout = this.mFooterArea;
        if (linearLayout != null) {
            linearLayout.addView(view, -1, -2);
            notifyItemChanged(getItemCount() - 1);
        } else {
            if (this.footerCache == null) {
                this.footerCache = new HashSet<>();
            }
            this.footerCache.add(view);
        }
    }

    public void addHeaderView(View view) {
        checkArgumentNotNull(view);
        LinearLayout linearLayout = this.mHeaderArea;
        if (linearLayout != null) {
            linearLayout.addView(view, -1, -2);
            notifyItemChanged(0);
        } else {
            if (this.headerCache == null) {
                this.headerCache = new HashSet<>();
            }
            this.headerCache.add(view);
        }
    }

    public View findViewInFooterArea(int i2) {
        return this.mFooterArea.findViewById(i2);
    }

    public View findViewInHeaderArea(int i2) {
        return this.mHeaderArea.findViewById(i2);
    }

    public final int footerAreaCount() {
        return 1;
    }

    public abstract int getCount();

    public final int getExtraViewCount() {
        return headerAreaCount() + footerAreaCount();
    }

    public int getFooterHeight() {
        return this.mFooterArea.getHeight();
    }

    public int getHeaderHeight() {
        return this.mHeaderArea.getHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return getCount() + getExtraViewCount();
    }

    public abstract int getItemType(int i2);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i2) {
        if (i2 == 0) {
            return -100;
        }
        return (i2 <= 0 || i2 < getItemCount() - footerAreaCount()) ? getItemType(i2 - headerAreaCount()) : ITEM_TYPE_FOOTERAREA;
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public LinearLayout getmFooterArea() {
        return this.mFooterArea;
    }

    public LinearLayout getmHeaderArea() {
        return this.mHeaderArea;
    }

    public final int headerAreaCount() {
        return 1;
    }

    public void notifyItemChanged(int i2, boolean z) {
        if (!z) {
            i2 += headerAreaCount();
        }
        try {
            super.notifyItemChanged(i2);
        } catch (IllegalStateException e2) {
            if (e2.getMessage() == null || !e2.getMessage().contains("RecyclerView is computing a skin_setting_item or scrolling")) {
                throw e2;
            }
            Log.e("KGRecyclerViewO", "Warning:" + e2.getMessage());
        }
    }

    public void notifyItemRemoved(int i2, boolean z) {
        if (!z) {
            i2 += headerAreaCount();
        }
        try {
            super.notifyItemRemoved(i2);
        } catch (IllegalStateException e2) {
            if (e2.getMessage() == null || !e2.getMessage().contains("RecyclerView is computing a skin_setting_item or scrolling")) {
                throw e2;
            }
            Log.e("KGRecyclerViewO", "Warning:" + e2.getMessage());
        }
    }

    public abstract void onBoundViewHolder(ViewHolder viewHolder, int i2);

    public abstract ViewHolder onMakeViewHolder(ViewGroup viewGroup, int i2);

    public void removeFooterView(View view) {
        checkArgumentNotNull(view);
        this.mFooterArea.removeView(view);
        notifyItemChanged(getItemCount() - 1);
    }

    public void removeHeaderView(View view) {
        checkArgumentNotNull(view);
        this.mHeaderArea.removeView(view);
        notifyItemChanged(0);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(ViewHolder viewHolder, int i2) {
        if (i2 <= 0 || i2 == getItemCount() - 1) {
            return;
        }
        onBoundViewHolder(viewHolder, i2 - headerAreaCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == -100) {
            this.mHeaderArea = getExtraArea(viewGroup);
            HashSet<View> hashSet = this.headerCache;
            if (hashSet != null) {
                Iterator<View> it = hashSet.iterator();
                while (it.hasNext()) {
                    this.mHeaderArea.addView(it.next(), -1, -2);
                }
                this.headerCache.clear();
            }
            return new ExtraAreaHolder(this.mHeaderArea);
        }
        if (i2 != -101 || footerAreaCount() <= 0) {
            return onMakeViewHolder(viewGroup, i2);
        }
        this.mFooterArea = getExtraArea(viewGroup);
        HashSet<View> hashSet2 = this.footerCache;
        if (hashSet2 != null) {
            Iterator<View> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                this.mFooterArea.addView(it2.next(), -1, -2);
            }
            this.footerCache.clear();
        }
        return new ExtraAreaHolder(this.mFooterArea);
    }
}
