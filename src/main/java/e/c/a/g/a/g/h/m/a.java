package e.c.a.g.a.g.h.m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import com.kugou.android.watch.lite.component.main.recommend.RecommendFragment;
import e.c.a.g.a.o.c.a;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends e.c.a.g.a.f.o.h.a<a.d> {
    public final RecommendFragment c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View.OnClickListener f816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LayoutInflater f817e;

    /* JADX INFO: renamed from: e.c.a.g.a.g.h.m.a$a, reason: collision with other inner class name */
    public static final class C0132a extends e.c.a.g.a.f.l.b {
        public final Fragment c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f818d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f819e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0132a(View view, Fragment fragment, View.OnClickListener onClickListener) {
            super(view);
            j.e(view, "view");
            j.e(fragment, "frag");
            j.e(onClickListener, "listener");
            this.c = fragment;
            this.f818d = (ImageView) view.findViewById(R.id.recommend_img);
            this.f819e = (TextView) view.findViewById(R.id.recommend_title);
            view.setOnClickListener(onClickListener);
        }

        @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.e
        public void c(Object obj, int i2) {
            super.c(obj, i2);
            if (obj instanceof a.d) {
                this.itemView.setTag(obj);
                a.d dVar = (a.d) obj;
                Glide.with(this.c).load(dVar.f1137e).placeholder(R.drawable.album_img_default).into(this.f818d);
                this.f819e.setText(dVar.c);
            }
        }
    }

    public a(RecommendFragment recommendFragment, View.OnClickListener onClickListener) {
        j.e(recommendFragment, "frag");
        j.e(onClickListener, "listener");
        this.c = recommendFragment;
        this.f816d = onClickListener;
        this.f817e = LayoutInflater.from(recommendFragment.requireContext());
    }

    @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
    public void b(KGRecyclerView.e<?> eVar, int i2) {
        j.e(eVar, "kvh");
        a.d item = getItem(i2);
        if (eVar instanceof C0132a) {
            ((C0132a) eVar).c(item, i2);
        }
    }

    @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
    public KGRecyclerView.e<?> d(ViewGroup viewGroup, int i2) {
        View viewInflate = this.f817e.inflate(R.layout.item_recommend, viewGroup, false);
        j.d(viewInflate, "inflater.inflate(R.layout.item_recommend, viewGroup, false)");
        return new C0132a(viewInflate, this.c, this.f816d);
    }
}
