package e.c.a.g.a.f.o.h;

import android.support.annotation.Nullable;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.m1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> extends KGRecyclerView.a {
    public ArrayList<T> b = new ArrayList<>();

    public void e(int i2, T t) {
        g();
        if (i2 < 0 || i2 > this.b.size() || t == null) {
            return;
        }
        this.b.add(i2, t);
    }

    public void f(List<T> list) {
        g();
        if (list == null || list.size() <= 0) {
            return;
        }
        this.b.addAll(list);
    }

    public void g() {
        m1.a();
    }

    @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
    public int getCount() {
        ArrayList<T> arrayList = this.b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Nullable
    public T getItem(int i2) {
        if (i2 < 0 || i2 >= this.b.size()) {
            return null;
        }
        return this.b.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    public void h() {
        g();
        this.b.clear();
    }

    public ArrayList<T> i() {
        return this.b;
    }

    public boolean j() {
        return l0.g(this.b);
    }

    public void k(T t) {
        g();
        if (t != null) {
            this.b.remove(t);
        }
    }

    public void l(List<T> list) {
        g();
        ArrayList<T> arrayList = this.b;
        if (arrayList == list) {
            return;
        }
        arrayList.clear();
        if (list != null) {
            this.b.addAll(list);
        }
    }
}
