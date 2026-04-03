package e.c.a.g.a.f.l;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<Item> extends RecyclerView.Adapter<b> {
    public final ArrayList<Item> a = new ArrayList<>();
    public LayoutInflater b;

    public void a(b bVar, int i2) {
    }

    public Item b(int i2) {
        return this.a.get(i2);
    }

    public List<Item> c() {
        return this.a;
    }

    public abstract void d(b bVar, Item item, int i2);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i2) {
        d(bVar, this.a.get(i2), i2);
        a(bVar, i2);
    }

    public abstract b f(LayoutInflater layoutInflater, ViewGroup viewGroup, int i2);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return f(this.b, viewGroup, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    public boolean h(Item item) {
        int iIndexOf = this.a.indexOf(item);
        if (iIndexOf < 0) {
            return false;
        }
        this.a.set(iIndexOf, item);
        notifyItemChanged(iIndexOf);
        return true;
    }

    public void i(List<Item> list) {
        ArrayList<Item> arrayList = this.a;
        if (arrayList != list) {
            arrayList.clear();
            if (list != null) {
                this.a.addAll(list);
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.b = LayoutInflater.from(recyclerView.getContext());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }
}
