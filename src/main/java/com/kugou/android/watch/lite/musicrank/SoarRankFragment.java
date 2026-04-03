package com.kugou.android.watch.lite.musicrank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateListFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import e.c.a.g.a.l.g;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.r;
import f.d;
import f.f;
import f.z.d.j;
import f.z.d.k;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
public final class SoarRankFragment extends AbsRankListFragment {
    public int I;
    public final d H = f.b(new a());
    public final String J = "飙升榜";
    public final int K = 2;
    public final e.c.a.g.a.k.d.a L = new e.c.a.g.a.k.d.a(ApmDataTypeID.SOAR_RANKING_LIST);

    public static final class a extends k implements f.z.c.a<g> {
        public a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g invoke() {
            return new g(SoarRankFragment.this, "2");
        }
    }

    public static final class b<T, R> implements Func1 {
        public final /* synthetic */ int a;
        public final /* synthetic */ SoarRankFragment b;

        public b(int i2, SoarRankFragment soarRankFragment) {
            this.a = i2;
            this.b = soarRankFragment;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.l.b call(Integer num) {
            e.c.a.g.a.k.b bVarC = e.c.a.g.a.k.b.c("飙升榜");
            int i2 = this.a;
            return bVarC.e("小天才", i2, e.c.a.g.a.k.c.c.a(i2), this.b.m());
        }
    }

    public static final class c<T, R> implements Func1 {

        public static final class a<T> implements r {
            public static final a<T> a = new a<>();

            @Override // e.c.a.g.a.s.r
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final boolean isFilter(KGSong kGSong) {
                return e.c.a.g.a.g.o.b.g(kGSong);
            }
        }

        public c() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.f.k.c<e.c.a.g.a.l.b> call(e.c.a.g.a.l.b bVar) {
            e.c.a.g.a.f.k.c<e.c.a.g.a.l.b> cVar = new e.c.a.g.a.f.k.c<>();
            boolean z = true;
            if (bVar != null) {
                cVar.g(bVar);
                cVar.m(bVar.f());
                cVar.k(bVar.a());
                SoarRankFragment.this.I += l0.e(bVar.e());
                cVar.h(SoarRankFragment.this.I >= 100 || SoarRankFragment.this.I >= bVar.d());
            } else {
                cVar.m(0);
                cVar.h(true);
            }
            e.c.a.g.a.l.b bVarA = cVar.a();
            ArrayList<KGSong> arrayListE = bVarA == null ? null : bVarA.e();
            if (arrayListE != null && !arrayListE.isEmpty()) {
                z = false;
            }
            if (!z) {
                l0.a(arrayListE, a.a);
            }
            return cVar;
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public String G0() {
        return "没有更多内容";
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public List<KGSong> I0(boolean z, e.c.a.g.a.f.k.c<e.c.a.g.a.l.b> cVar) {
        j.e(cVar, "response");
        e.c.a.g.a.l.b bVarA = cVar.a();
        if (bVarA == null) {
            return null;
        }
        return bVarA.e();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void I1() {
        super.I1();
        this.L.j();
    }

    @Override // com.kugou.android.watch.lite.musicrank.AbsRankListFragment
    public g L1() {
        return P1();
    }

    public final g P1() {
        return (g) this.H.getValue();
    }

    @Override // com.kugou.android.watch.lite.musicrank.AbsRankListFragment, com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void f1(List<? extends KGSong> list, boolean z) {
        j.e(list, "newAddedData");
        super.f1(list, z);
        if (X0() || !e.c.a.g.a.k.c.c.b(E0())) {
            return;
        }
        g1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void h1() {
        super.h1();
        this.L.e();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void i1() {
        super.i1();
        this.L.g();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void l1(Throwable th, Integer num) {
        super.l1(th, num);
        this.L.b(th, this.K, this.J, num);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void m1() {
        super.m1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void n1(e.c.a.g.a.f.k.c<e.c.a.g.a.l.b> cVar) {
        super.n1(cVar);
        if (cVar == null) {
            l1(null, 10);
        } else if (cVar.f()) {
            this.L.i(!l0.g(I0(true, cVar)));
        } else {
            l1(new e.c.a.b.a.a.a.a(cVar.b()), 11);
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public Observable<e.c.a.g.a.f.k.c<e.c.a.g.a.l.b>> o1(int i2) {
        if (i2 <= 1 || P1().i().size() < 100) {
            Observable<e.c.a.g.a.f.k.c<e.c.a.g.a.l.b>> map = Observable.just(Integer.valueOf(i2)).subscribeOn(Schedulers.io()).map(new b(i2, this)).map(new c());
            j.d(map, "override fun requestData(page: Int): Observable<CommonResponse<NetSongResponse>> {\n        if(page > 1 && adapter.datas.size >= MAX_SIZE){\n            val response = CommonResponse<NetSongResponse>()\n            response.data = NetSongResponse()\n            response.setStatus(1)\n            response.isEnd = true\n            return Observable.just(response)\n        }\n        return Observable.just(page)\n            .subscribeOn(Schedulers.io())\n            .map {\n                RankListProtocol.getInstance(\"飙升榜\")\n                    .getSoarRankListData(\"小天才\", page, RankPageLoadCtrl.INSTANCE.getPageCountByPageNo(page), pageKey)\n            }\n            .map{\n                val response = CommonResponse<NetSongResponse>()\n                if(it != null){\n                    response.data = it\n                    response.setStatus(it.status)\n                    response.setErrorCode(it.errcode)\n                    showDataCount += ListUtil.getSize(it.songs)\n                    response.isEnd = showDataCount >= MAX_SIZE || showDataCount >= it.recordcount\n                }else{\n                    response.setStatus(0)\n                    response.isEnd = true\n                }\n\n                val songs = response.data?.songs\n                if (!songs.isNullOrEmpty()) {\n                    ListUtil.filter(songs) { song ->\n                        ContentFilter.isFilter(song)\n                    }\n                }\n\n                response\n            }\n    }");
            return map;
        }
        e.c.a.g.a.f.k.c cVar = new e.c.a.g.a.f.k.c();
        cVar.g(new e.c.a.g.a.l.b());
        cVar.m(1);
        cVar.h(true);
        Observable<e.c.a.g.a.f.k.c<e.c.a.g.a.l.b>> observableJust = Observable.just(cVar);
        j.d(observableJust, "just(response)");
        return observableJust;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return View.inflate(getContext(), R.layout.fragment_list_rank, null);
    }

    @Override // com.kugou.android.watch.lite.musicrank.AbsRankListFragment, com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        View viewFindViewById = requireView().findViewById(R.id.content_detail);
        j.d(viewFindViewById, "requireView().findViewById(R.id.content_detail)");
        DelegateListFragment.A0(this, (KGRecyclerView) viewFindViewById, new LinearLayoutManager(getContext()), P1(), null, 8, null);
        j1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void q1() {
        super.q1();
        e.c.a.g.a.e.b.b(new YoungBITask(20498, "click").setType("1"));
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "飙升榜";
    }
}
