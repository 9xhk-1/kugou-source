package com.kugou.android.watch.lite.common.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.kugou.uilib.widget.recyclerview.delegate.adapter.BaseHeaderAdapter;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class KGRecyclerView extends KgDataRecylerView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f139i = KGRecyclerView.class.getSimpleName();
    public c a;
    public d b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f140d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f141f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Runnable f142h;

    public static abstract class a extends RecyclerView.Adapter<e> {
        public KGRecyclerView a;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onBindViewHolder(e eVar, int i2) {
            if (i2 <= 0 || i2 == getItemCount() - 1) {
                ((b) eVar).d();
            } else {
                b(eVar, i2 - this.a.f());
            }
        }

        public abstract void b(e eVar, int i2);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final e onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return i2 == -100 ? new b(this.a.f140d) : i2 == -101 ? new b(this.a.f141f) : d(viewGroup, i2);
        }

        public abstract e d(ViewGroup viewGroup, int i2);

        public abstract int getCount();

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            KGRecyclerView kGRecyclerView = this.a;
            if (kGRecyclerView == null) {
                return getCount();
            }
            return getCount() + kGRecyclerView.getExtraViewCount();
        }

        public int getItemType(int i2) {
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int i2) {
            if (i2 == 0) {
                return -100;
            }
            return (i2 <= 0 || i2 != getItemCount() + (-1)) ? getItemType(i2 - this.a.f()) : BaseHeaderAdapter.ITEM_TYPE_FOOTERAREA;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            this.a = (KGRecyclerView) recyclerView;
            if (g0.a) {
                g0.e(KGRecyclerView.f139i, "Adapter.onAttachedToRecyclerView");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
            this.a = null;
            if (g0.a) {
                g0.e(KGRecyclerView.f139i, "Adapter.onDetachedFromRecyclerView");
            }
        }
    }

    public static class b extends e {
        public b(View view) {
            super(view);
            view.setClickable(false);
            view.setLongClickable(false);
        }

        public void d() {
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
                this.itemView.setLayoutParams(layoutParams);
            }
        }
    }

    public interface c {
        void onItemClick(KGRecyclerView kGRecyclerView, View view, int i2, long j);
    }

    public interface d {
        boolean onItemLongClick(KGRecyclerView kGRecyclerView, View view, int i2, long j);
    }

    public static abstract class e<D> extends RecyclerView.ViewHolder {
        public View.OnClickListener a;
        public View.OnLongClickListener b;

        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KGRecyclerView kGRecyclerViewB = e.this.b(view, (View) view.getParent(), true);
                if (kGRecyclerViewB == null) {
                    return;
                }
                a adapter = kGRecyclerViewB.getAdapter();
                if (kGRecyclerViewB.a == null || adapter == null) {
                    return;
                }
                int position = e.this.getPosition() - kGRecyclerViewB.f();
                kGRecyclerViewB.a.onItemClick(kGRecyclerViewB, view, position, adapter.getItemId(position));
            }
        }

        public class b implements View.OnLongClickListener {
            public b() {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                KGRecyclerView kGRecyclerViewB = e.this.b(view, (View) view.getParent(), false);
                if (kGRecyclerViewB == null) {
                    return false;
                }
                a adapter = kGRecyclerViewB.getAdapter();
                if (kGRecyclerViewB.b == null || adapter == null) {
                    return false;
                }
                int position = e.this.getPosition() - kGRecyclerViewB.f();
                return kGRecyclerViewB.b.onItemLongClick(kGRecyclerViewB, view, position, adapter.getItemId(position));
            }
        }

        public e(View view) {
            super(view);
            a aVar = new a();
            this.a = aVar;
            this.b = new b();
            view.setOnClickListener(aVar);
            view.setOnLongClickListener(this.b);
        }

        public final KGRecyclerView b(View view, View view2, boolean z) {
            if (view2 == null) {
                return null;
            }
            if (view2 instanceof KGRecyclerView) {
                return (KGRecyclerView) view2;
            }
            if (z) {
                throw new IllegalStateException("Make sure the clicking itemView :" + view.toString() + "'s parent is A kind of " + KGRecyclerView.class.getSimpleName());
            }
            if (g0.a) {
                g0.b(KGRecyclerView.f139i, "Make sure the clicking itemView :" + view.toString() + "'s parent is A kind of " + KGRecyclerView.class.getSimpleName());
            }
            return null;
        }

        public void c(D d2, int i2) {
        }
    }

    public KGRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f140d = null;
        this.f141f = null;
        setItemAnimator(null);
        g();
    }

    public void c(View view) {
        e(view);
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f141f.addView(view);
        if (getAdapter() != null) {
            getAdapter().notifyItemChanged(getAdapter().getItemCount() - 1);
        }
    }

    public void d(View view) {
        e(view);
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f140d.addView(view);
        if (getAdapter() != null) {
            getAdapter().notifyItemChanged(0);
        }
    }

    public final void e(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Argument can not be null!");
        }
    }

    public int f() {
        return 1;
    }

    public final void g() {
        if (this.f140d == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f140d = linearLayout;
            linearLayout.setOrientation(1);
        }
        if (this.f141f == null) {
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            this.f141f = linearLayout2;
            linearLayout2.setOrientation(1);
        }
    }

    public int getExtraViewCount() {
        return 2;
    }

    public View getFooterArea() {
        return this.f141f;
    }

    public int getFooterHeight() {
        return this.f141f.getHeight();
    }

    public View getHeaderArea() {
        return this.f140d;
    }

    public int getHeaderHeight() {
        return this.f140d.getHeight();
    }

    public LinearLayoutManager getLinearLayoutManager() {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null || !(layoutManager instanceof LinearLayoutManager)) {
            return null;
        }
        return (LinearLayoutManager) layoutManager;
    }

    public final c getOnItemClickListener() {
        return this.a;
    }

    public final d getOnItemLongClickListener() {
        return this.b;
    }

    public LinearLayout getmFooterArea() {
        return this.f141f;
    }

    public LinearLayout getmHeaderArea() {
        return this.f140d;
    }

    public void setAdapter(a aVar) {
        super.setAdapter((RecyclerView.Adapter) aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        LinearLayoutManager linearLayoutManager = getLinearLayoutManager();
        if (linearLayoutManager != null) {
            Runnable runnable = this.f142h;
            if (runnable != null) {
                runnable.run();
                return;
            }
            boolean z = linearLayoutManager.getOrientation() == 0;
            this.f140d.setLayoutParams(new RecyclerView.LayoutParams(z ? -2 : -1, -2));
            this.f141f.setLayoutParams(new RecyclerView.LayoutParams(z ? -2 : -1, -2));
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.a = cVar;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.b = dVar;
    }

    public void setOverHeaderFooterLPAction(Runnable runnable) {
        this.f142h = runnable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public a getAdapter() {
        return (a) super.getAdapter();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    @Deprecated
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter instanceof a) {
            setAdapter((a) adapter);
            return;
        }
        throw new IllegalArgumentException(KGRecyclerView.class.getCanonicalName() + " must use A adapter which is " + a.class.getCanonicalName());
    }

    public KGRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f140d = null;
        this.f141f = null;
        setItemAnimator(null);
        g();
    }
}
