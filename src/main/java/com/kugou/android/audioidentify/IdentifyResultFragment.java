package com.kugou.android.audioidentify;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.s.i;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.u1;
import f.s;
import f.u.u;
import f.z.c.p;
import f.z.d.j;
import f.z.d.k;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@e.c.c.l.f.b(id = -1)
public final class IdentifyResultFragment extends DelegateFragment implements View.OnClickListener {
    public RecyclerView r;
    public final a s = new a(this);
    public int t;
    public e.c.a.g.a.g.j.d.b u;

    public static final class a extends e.c.a.g.a.f.o.h.a<KGSong> {
        public final View.OnClickListener c;

        public a(View.OnClickListener onClickListener) {
            j.e(onClickListener, "clickListener");
            this.c = onClickListener;
        }

        @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
        public void b(KGRecyclerView.e<?> eVar, int i2) {
            j.e(eVar, "kvh");
            ((b) eVar).d(getItem(i2), i2);
        }

        @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
        public KGRecyclerView.e<?> d(ViewGroup viewGroup, int i2) {
            j.e(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_identify_result_list, viewGroup, false);
            j.d(viewInflate, "from(viewGroup.context)\n                    .inflate(R.layout.item_identify_result_list, viewGroup, false)");
            return new b(viewInflate, this.c);
        }
    }

    public static final class b extends KGRecyclerView.e<KGSong> {
        public final TextView c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f5d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f6e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view, View.OnClickListener onClickListener) {
            super(view);
            j.e(view, "itemView");
            j.e(onClickListener, "clickListener");
            this.c = (TextView) view.findViewById(R.id.tv_number);
            this.f5d = (TextView) view.findViewById(R.id.tv_song_name);
            this.f6e = (TextView) view.findViewById(R.id.tv_singer_name);
            view.setOnClickListener(onClickListener);
        }

        public void d(KGSong kGSong, int i2) {
            String strL;
            String strL2;
            super.c(kGSong, i2);
            if (kGSong == null) {
                return;
            }
            String strV2 = kGSong.v2();
            if (strV2 == null) {
                strV2 = "";
            }
            this.itemView.setTag(Integer.valueOf(i2));
            boolean z = true;
            this.c.setText(String.valueOf(i2 + 1));
            TextView textView = this.f5d;
            String strL22 = kGSong.l2();
            if (strL22 == null || strL22.length() == 0) {
                String strB1 = kGSong.B1();
                if (strB1 == null || strB1.length() == 0) {
                    String strS1 = kGSong.s1();
                    if (strS1 != null && strS1.length() != 0) {
                        z = false;
                    }
                    strL = !z ? j.l(kGSong.s1(), strV2) : kGSong.g1();
                } else {
                    strL = j.l(kGSong.B1(), strV2);
                }
            } else {
                if (TextUtils.isEmpty(kGSong.o2())) {
                    strL2 = kGSong.l2();
                } else {
                    strL2 = kGSong.l2() + " - " + ((Object) kGSong.o2());
                }
                strL = j.l(strL2, strV2);
            }
            textView.setText(strL);
            this.f6e.setText(kGSong.j1());
        }
    }

    public static final class c extends k implements p<Float, Float, s> {
        public final /* synthetic */ RecyclerView a;
        public final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(RecyclerView recyclerView, int i2) {
            super(2);
            this.a = recyclerView;
            this.b = i2;
        }

        public final void a(float f2, float f3) {
            this.a.scrollBy(0, f3 > 0.0f ? -this.b : this.b);
        }

        @Override // f.z.c.p
        public /* bridge */ /* synthetic */ s invoke(Float f2, Float f3) {
            a(f2.floatValue(), f3.floatValue());
            return s.a;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        j.e(view, "v");
        if (!u1.i(view) && view.getId() == R.id.item_result_list_root) {
            Integer num = (Integer) view.getTag();
            int iIntValue = num == null ? 0 : num.intValue();
            Initiator initiatorCarryPagePath = Initiator.create(m()).carryPagePath(n());
            j.d(initiatorCarryPagePath, "create(pageKey).carryPagePath(pagePath)");
            f.y(true, e.c.a.g.a.f.j.a.c.g(this.s.i(), initiatorCarryPagePath, "44"), iIntValue, true, l());
            ArrayList<KGSong> arrayListI = this.s.i();
            j.d(arrayListI, "adapter.datas");
            KGSong kGSong = (KGSong) u.w(arrayListI, iIntValue);
            Long lValueOf = kGSong == null ? null : Long.valueOf(kGSong.T1());
            YoungBITask youngBITaskAppend = new YoungBITask(20435, "click").append("page", String.valueOf(iIntValue));
            String str = "";
            if (lValueOf != null && (string = lValueOf.toString()) != null) {
                str = string;
            }
            e.c.a.g.a.e.b.b(youngBITaskAppend.setMixsongid(str).setType("1").setTab("1").setSvar1(u0()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_identify_result, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        e.c.a.g.a.g.j.d.b bVar = this.u;
        if (bVar != null) {
            bVar.i();
        }
        e.c.a.g.a.e.b.b(new YoungBITask(20435, "click").append("page", String.valueOf(this.s.getCount())).setType("1").setTab("6").setSvar1(u0()));
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        ArrayList parcelableArrayList = arguments == null ? null : arguments.getParcelableArrayList("key_song_list");
        Bundle arguments2 = getArguments();
        Integer numValueOf = arguments2 == null ? null : Integer.valueOf(arguments2.getInt("key_source_from", this.t));
        this.t = numValueOf == null ? this.t : numValueOf.intValue();
        View viewFindViewById = view.findViewById(R.id.recycler_view);
        j.d(viewFindViewById, "view.findViewById(R.id.recycler_view)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        this.r = recyclerView;
        if (recyclerView == null) {
            j.t("mRecyclerView");
            throw null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView2 = this.r;
        if (recyclerView2 == null) {
            j.t("mRecyclerView");
            throw null;
        }
        recyclerView2.setAdapter(this.s);
        RecyclerView recyclerView3 = this.r;
        if (recyclerView3 == null) {
            j.t("mRecyclerView");
            throw null;
        }
        i iVar = new i();
        iVar.b(l1.c(15.0f));
        recyclerView3.addItemDecoration(iVar);
        this.s.l(parcelableArrayList);
        this.s.notifyDataSetChanged();
        if (l1.f0()) {
            View viewFindViewById2 = view.findViewById(R.id.root_view);
            j.d(viewFindViewById2, "view.findViewById(R.id.root_view)");
            ViewGroup viewGroup = (ViewGroup) viewFindViewById2;
            RecyclerView recyclerView4 = this.r;
            if (recyclerView4 != null) {
                v0(viewGroup, recyclerView4);
            } else {
                j.t("mRecyclerView");
                throw null;
            }
        }
    }

    public final String u0() {
        int i2 = this.t;
        return i2 != 0 ? i2 != 1 ? "" : "3" : "1";
    }

    public final void v0(ViewGroup viewGroup, RecyclerView recyclerView) {
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R.layout.layout_rotary_keypad_holder, viewGroup, false);
        viewGroup.addView(viewInflate, 0);
        int iC = l1.c(7.0f);
        j.d(viewInflate, "scrollHolder");
        e.c.a.g.a.g.j.d.b bVar = new e.c.a.g.a.g.j.d.b(viewInflate);
        bVar.m(new c(recyclerView, iC));
        s sVar = s.a;
        this.u = bVar;
    }
}
