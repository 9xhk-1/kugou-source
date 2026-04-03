package com.kugou.android.watch.lite.component.main.recommend.detail;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateListFragment;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import com.kugou.android.watch.lite.recommend.entity.SheetMusicBean;
import com.kugou.android.watch.lite.recommend.entity.SheetMusicListResp;
import e.c.a.g.a.f.k.c;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u1;
import f.d;
import f.f;
import f.u.n;
import f.z.d.j;
import f.z.d.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import rx.Observable;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
public final class DetailFragment extends DelegateListFragment<SheetMusicListResp.DataBean, SheetMusicBean> implements View.OnClickListener {
    public final d H = f.b(new a());
    public String I = "";

    public static final class a extends k implements f.z.c.a<e.c.a.g.a.g.h.m.c.a> {
        public a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.g.h.m.c.a invoke() {
            return new e.c.a.g.a.g.h.m.c.a(DetailFragment.this);
        }
    }

    public static final class b<T, R> implements Func1 {
        public b() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c<SheetMusicListResp.DataBean> call(SheetMusicListResp sheetMusicListResp) {
            c<SheetMusicListResp.DataBean> cVar = new c<>();
            SheetMusicListResp.DataBean dataBean = sheetMusicListResp == null ? null : sheetMusicListResp.data;
            if (dataBean != null) {
                cVar.g(sheetMusicListResp.data);
                cVar.m(sheetMusicListResp.status);
                cVar.i(sheetMusicListResp.error_code);
                cVar.h(l0.e(DetailFragment.this.K1().i()) + l0.e(dataBean.song_data_list) >= dataBean.total);
            } else {
                cVar.m(0);
                cVar.h(true);
            }
            return cVar;
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public e.c.a.g.a.f.o.h.a<SheetMusicBean> D0() {
        return K1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public String G0() {
        return "没有更多内容了";
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public List<SheetMusicBean> I0(boolean z, c<SheetMusicListResp.DataBean> cVar) {
        j.e(cVar, "response");
        SheetMusicListResp.DataBean dataBeanA = cVar.a();
        if (dataBeanA == null) {
            return null;
        }
        return dataBeanA.song_data_list;
    }

    public final e.c.a.g.a.g.h.m.c.a K1() {
        return (e.c.a.g.a.g.h.m.c.a) this.H.getValue();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public Observable<c<SheetMusicListResp.DataBean>> o1(int i2) {
        Observable map = e.c.a.g.a.o.b.c(this.I, i2, 20).map(new b());
        j.d(map, "override fun requestData(curPage: Int): Observable<CommonResponse<SheetMusicListResp.DataBean>> {\n        return MusicCategoryService.getMusicSheetList(resourceId, curPage, 20)\n            .map { result ->\n                val resp = CommonResponse<SheetMusicListResp.DataBean>()\n                val data = result?.data\n                if (data != null) {\n                    resp.data = result.data\n                    resp.setStatus(result.status)\n                    resp.errcode = result.error_code\n                    resp.isEnd =\n                        (ListUtil.getSize(adapter.datas) + ListUtil.getSize(data.song_data_list)) >= data.total\n                } else {\n                    resp.setStatus(0)\n                    resp.isEnd = true\n                }\n                resp\n            }\n    }");
        return map;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j.e(view, "view");
        if (!u1.g() && view.getId() == R.id.search_song_root) {
            Integer num = (Integer) view.getTag();
            int iIntValue = num == null ? 0 : num.intValue();
            ArrayList<SheetMusicBean> arrayListI = K1().i();
            if (l0.g(arrayListI)) {
                p1.h(getContext(), "歌曲列表为空，请重试");
                return;
            }
            j.d(arrayListI, "list");
            ArrayList arrayList = new ArrayList(n.j(arrayListI, 10));
            Iterator<T> it = arrayListI.iterator();
            while (it.hasNext()) {
                arrayList.add(((SheetMusicBean) it.next()).getKGSong());
            }
            Initiator initiatorCarryPagePath = Initiator.create(m()).carryPagePath(n());
            j.d(initiatorCarryPagePath, "create(pageKey).carryPagePath(pagePath)");
            e.c.a.g.a.d.x.f.y(true, e.c.a.g.a.f.j.a.c.g(arrayList, initiatorCarryPagePath, "45"), iIntValue, true, l());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_recommend_detail, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String string;
        String string2;
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String str = "歌单";
        if (arguments != null && (string2 = arguments.getString("key_title", "歌单")) != null) {
            str = string2;
        }
        Bundle arguments2 = getArguments();
        String str2 = "";
        if (arguments2 != null && (string = arguments2.getString("key_resource_id", "")) != null) {
            str2 = string;
        }
        this.I = str2;
        if (TextUtils.isEmpty(str2)) {
            p1.h(KGApplication.getContext(), "数据异常，请稍后重试");
            e();
            return;
        }
        View viewJ0 = j0(R.id.content_title);
        Objects.requireNonNull(viewJ0, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewJ0).setText(str);
        View viewFindViewById = requireView().findViewById(R.id.content_detail);
        j.d(viewFindViewById, "requireView().findViewById(R.id.content_detail)");
        DelegateListFragment.A0(this, (KGRecyclerView) viewFindViewById, new LinearLayoutManager(getContext()), K1(), null, 8, null);
        j1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "推荐详情页";
    }
}
