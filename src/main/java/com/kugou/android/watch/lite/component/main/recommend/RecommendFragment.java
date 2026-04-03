package com.kugou.android.watch.lite.component.main.recommend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateListFragment;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import e.c.a.g.a.f.k.c;
import e.c.a.g.a.o.c.a;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u1;
import f.d;
import f.f;
import f.z.d.j;
import f.z.d.k;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
public final class RecommendFragment extends DelegateListFragment<a.b, a.d> implements View.OnClickListener {
    public final d H = f.b(new a());

    public static final class a extends k implements f.z.c.a<e.c.a.g.a.g.h.m.a> {
        public a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.g.h.m.a invoke() {
            RecommendFragment recommendFragment = RecommendFragment.this;
            return new e.c.a.g.a.g.h.m.a(recommendFragment, recommendFragment);
        }
    }

    public static final class b<T, R> implements Func1 {
        public static final b<T, R> a = new b<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c<a.b> call(a.b bVar) {
            c<a.b> cVar = new c<>();
            if (bVar != null) {
                cVar.m(1);
                cVar.h(true);
                cVar.g(bVar);
            }
            return cVar;
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public e.c.a.g.a.f.o.h.a<a.d> D0() {
        return J1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public String G0() {
        return "暂时没有内容哦";
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public List<a.d> I0(boolean z, c<a.b> cVar) {
        j.e(cVar, "response");
        a.b bVarA = cVar.a();
        if (bVarA == null) {
            return null;
        }
        return bVarA.f1130g;
    }

    public final e.c.a.g.a.g.h.m.a J1() {
        return (e.c.a.g.a.g.h.m.a) this.H.getValue();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public Observable<c<a.b>> o1(int i2) {
        Observable map = e.c.a.g.a.o.b.b(237, 365, 3027).map(b.a);
        j.d(map, "getModuleByModuleId(\n            RecommendConst.ZONE_ID,\n            RecommendConst.CATEGORY_ID,\n            RecommendConst.KU_RECOMMEND_MODULE_ID\n        ).map { bean ->\n            val resp = CommonResponse<ZoneHomeBean.ModuleBean>()\n            if (bean != null) {\n                resp.setStatus(1)\n                resp.isEnd = true\n                resp.data = bean\n            }\n            resp\n        }");
        return map;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j.e(view, "view");
        if (!u1.g() && view.getId() == R.id.recommend_item_root) {
            Object tag = view.getTag();
            if (!(tag instanceof a.d)) {
                p1.h(getContext(), "数据异常，请稍后重试");
                return;
            }
            s0 s0Var = s0.a;
            a.d dVar = (a.d) tag;
            String str = dVar.c;
            j.d(str, "data.resource_name");
            String str2 = dVar.a;
            j.d(str2, "data.resource_id");
            s0Var.E(str, str2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_recommend, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        View viewFindViewById = view.findViewById(R.id.content_detail);
        j.d(viewFindViewById, "view.findViewById(R.id.content_detail)");
        DelegateListFragment.A0(this, (KGRecyclerView) viewFindViewById, new LinearLayoutManager(getContext()), J1(), null, 8, null);
        j1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "大家都在听";
    }
}
