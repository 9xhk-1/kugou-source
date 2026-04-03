package com.kugou.android.watch.lite.newsong;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateListFragment;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import e.c.a.g.a.l.e;
import e.c.a.g.a.l.g;
import e.c.a.g.a.s.g0;
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

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
public final class NewSongListFragment extends DelegateListFragment<NewSongList, KGSong> {
    public final d H = f.b(new a());
    public final String I = "新歌速递";
    public final int J = 3;
    public final e.c.a.g.a.k.d.a K = new e.c.a.g.a.k.d.a(ApmDataTypeID.NEW_SONG_RECOMMEND);

    public static final class a extends k implements f.z.c.a<g> {

        /* JADX INFO: renamed from: com.kugou.android.watch.lite.newsong.NewSongListFragment$a$a, reason: collision with other inner class name */
        public static final class C0018a implements g.a {
            public static final C0018a a = new C0018a();

            @Override // e.c.a.g.a.l.g.a
            public final void onClick(KGSong kGSong, int i2) {
                if (kGSong != null) {
                    e.c.a.g.a.e.b.b(new YoungBITask(20084, "click").setType("1").setMixsongid(String.valueOf(kGSong.T1())));
                }
            }
        }

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g invoke() {
            g gVar = new g(NewSongListFragment.this, "3");
            gVar.q(C0018a.a);
            return gVar;
        }
    }

    public static final class b<T, R> implements Func1 {
        public b() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Observable<? extends e.c.a.g.a.f.k.c<NewSongList>> call(Integer num) {
            ArrayList<KGSong> arrayListD = e.d();
            if (arrayListD == null) {
                e.c.a.g.a.l.d dVar = new e.c.a.g.a.l.d();
                PageKey pageKeyM = NewSongListFragment.this.m();
                j.d(pageKeyM, "pageKey");
                return dVar.j(pageKeyM);
            }
            e.c.a.g.a.f.k.c cVar = new e.c.a.g.a.f.k.c();
            cVar.m(1);
            NewSongList newSongList = new NewSongList();
            newSongList.list = arrayListD;
            cVar.g(newSongList);
            cVar.h(true);
            return Observable.just(cVar);
        }
    }

    public static final class c<T, R> implements Func1 {
        public static final c<T, R> a = new c<>();

        public static final class a<T> implements r {
            public static final a<T> a = new a<>();

            @Override // e.c.a.g.a.s.r
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final boolean isFilter(KGSong kGSong) {
                return e.c.a.g.a.g.o.b.g(kGSong);
            }
        }

        public final e.c.a.g.a.f.k.c<NewSongList> a(e.c.a.g.a.f.k.c<NewSongList> cVar) {
            NewSongList newSongListA = cVar.a();
            List<KGSong> list = newSongListA == null ? null : newSongListA.list;
            if (!l0.g(list)) {
                l0.a(list, a.a);
            }
            return cVar;
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            e.c.a.g.a.f.k.c<NewSongList> cVar = (e.c.a.g.a.f.k.c) obj;
            a(cVar);
            return cVar;
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void B0(boolean z, Throwable th, Integer num) {
        j.e(th, "throwable");
        super.B0(z, th, num);
        j.d(Log.getStackTraceString(th), "getStackTraceString(throwable)");
        if (g0.f()) {
            Log.e("mhs_watch", "NewSongListFragment handleDataBackFirst");
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public e.c.a.g.a.f.o.h.a<KGSong> D0() {
        return K1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public String G0() {
        return "没有更多内容了";
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public List<KGSong> I0(boolean z, e.c.a.g.a.f.k.c<NewSongList> cVar) {
        j.e(cVar, "response");
        NewSongList newSongListA = cVar.a();
        if (newSongListA == null) {
            return null;
        }
        return newSongListA.list;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void I1() {
        super.I1();
        if (g0.f()) {
            Log.e("mhs_watch", "NewSongListFragment hanlderListShow");
        }
        this.K.j();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void J() {
        super.J();
        if (g0.f()) {
            Log.e("mhs_watch", "NewSongListFragment onFragmentResume");
        }
    }

    public final void J1() {
        e.c.a.g.a.e.b.b(new YoungBITask(20082, "exposure"));
    }

    public final g K1() {
        return (g) this.H.getValue();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void M0(e.c.a.g.a.f.k.c<NewSongList> cVar, boolean z) {
        j.e(cVar, "response");
        super.M0(cVar, z);
        Log.e("mhs_watch", "新歌速递 数据加载成功");
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void N0(int i2) {
        super.N0(i2);
        if (i2 == 1 && g0.f()) {
            Log.e("mhs_watch", "NewSongListFragment handleDataBackFirst");
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void O0(boolean z, Throwable th) {
        j.e(th, "throwable");
        super.O0(z, th);
        DelegateListFragment.C0(this, z, th, null, 4, null);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void h1() {
        super.h1();
        this.K.e();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void i1() {
        super.i1();
        this.K.g();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void l1(Throwable th, Integer num) {
        super.l1(th, num);
        String str = this.I;
        if (num != null && num.intValue() == 13) {
            str = "数据为空";
        }
        this.K.b(th, this.J, str, num);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void m1() {
        super.m1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void n1(e.c.a.g.a.f.k.c<NewSongList> cVar) {
        super.n1(cVar);
        if (cVar == null) {
            l1(null, 10);
            return;
        }
        if (!cVar.f()) {
            l1(new e.c.a.b.a.a.a.a(cVar.b()), 11);
            return;
        }
        boolean zG = true ^ l0.g(I0(true, cVar));
        if (zG) {
            this.K.i(zG);
            return;
        }
        int iB = cVar.b();
        if (iB == 0) {
            iB = e.e();
        }
        l1(new e.c.a.b.a.a.a.a(iB), 13);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public Observable<e.c.a.g.a.f.k.c<NewSongList>> o1(int i2) {
        if (i2 <= 1) {
            Observable<e.c.a.g.a.f.k.c<NewSongList>> map = Observable.just(1).flatMap(new b()).map(c.a);
            j.d(map, "override fun requestData(page: Int): Observable<CommonResponse<NewSongList?>> {\n        if (page > 1) {\n            val response = CommonResponse<NewSongList?>()\n            response.isEnd = true\n            response.setStatus(1)\n            return Observable.just(response)\n        }\n        return Observable.just(1)\n            .flatMap {\n                val autoSongs = NewSongProtocol.getAutoSongs()\n                if (autoSongs != null) {\n                    val response = CommonResponse<NewSongList?>()\n                    response.setStatus(1)\n                    val list = NewSongList()\n                    list.list = autoSongs\n                    response.data = list\n                    response.isEnd = true\n                    Observable.just(response)\n                } else {\n                    NewSongPresenter().request(pageKey)\n                }\n\n            }.map { resp ->\n                val songs = resp.data?.list\n                if (!ListUtil.isEmpty(songs)) {\n                    ListUtil.filter(songs) {\n                        ContentFilter.isFilter(it)\n                    }\n                }\n                resp\n            }\n    }");
            return map;
        }
        e.c.a.g.a.f.k.c cVar = new e.c.a.g.a.f.k.c();
        cVar.h(true);
        cVar.m(1);
        Observable<e.c.a.g.a.f.k.c<NewSongList>> observableJust = Observable.just(cVar);
        j.d(observableJust, "just(response)");
        return observableJust;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (g0.f()) {
            Log.e("mhs_watch", "NewSongListFragment oncreate");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return View.inflate(getContext(), R.layout.fragment_new_song, null);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        if (g0.f()) {
            Log.e("mhs_watch", "NewSongListFragment onViewCreated");
        }
        super.onViewCreated(view, bundle);
        View viewFindViewById = requireView().findViewById(R.id.content_detail);
        j.d(viewFindViewById, "requireView().findViewById(R.id.content_detail)");
        DelegateListFragment.A0(this, (KGRecyclerView) viewFindViewById, new LinearLayoutManager(getContext()), K1(), null, 8, null);
        j1();
        J1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void q1() {
        super.q1();
        e.c.a.g.a.e.b.b(new YoungBITask(20498, "click").setType("2"));
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "新歌速递";
    }
}
