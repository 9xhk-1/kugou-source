package com.kugou.android.watch.lite.component.main.simple;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateListFragment;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import com.kugou.android.watch.lite.guessyoulike.GuessYouLikeHelper;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import e.c.a.g.a.f.k.c;
import e.c.a.g.a.h.i;
import e.c.a.g.a.l.g;
import e.c.a.g.a.s.l0;
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
public final class RadioSongListFragment extends DelegateListFragment<List<? extends KGSong>, KGSong> {
    public final d H = f.b(new a());
    public final String I = "为你推荐";
    public final int J = 7;
    public final e.c.a.g.a.k.d.a K = new e.c.a.g.a.k.d.a(ApmDataTypeID.RCM_LIST_REPORT);

    public static final class a extends k implements f.z.c.a<g> {
        public a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g invoke() {
            return new g(RadioSongListFragment.this, "4");
        }
    }

    public static final class b<T, R> implements Func1 {
        public b() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c<List<KGSong>> call(String str) {
            e.c.a.g.a.h.d dVar;
            i iVarF = GuessYouLikeHelper.g().f("推荐页面");
            ArrayList<KGSong> arrayListA = null;
            if (iVarF != null && (dVar = iVarF.f1071h) != null) {
                arrayListA = dVar.a();
            }
            int i2 = iVarF == null ? 0 : iVarF.b;
            int i3 = iVarF != null ? iVarF.a : 0;
            try {
                RadioSongListFragment.this.L1(arrayListA);
            } catch (Exception unused) {
            }
            c<List<KGSong>> cVar = new c<>();
            cVar.h(true);
            cVar.k(i2);
            cVar.m(i3);
            cVar.g(arrayListA);
            return cVar;
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
    public List<KGSong> I0(boolean z, c<List<? extends KGSong>> cVar) {
        j.e(cVar, "response");
        return (List) cVar.a();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void I1() {
        super.I1();
        this.K.j();
    }

    public final g K1() {
        return (g) this.H.getValue();
    }

    public final void L1(ArrayList<KGSong> arrayList) {
        if (l0.g(arrayList)) {
            RingBiReportHelper.INSTANCE.reportHead3("推荐列表无数据", "fragment");
        }
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
        this.K.b(th, this.J, this.I, num);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void m1() {
        super.m1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void n1(c<List<? extends KGSong>> cVar) {
        super.n1(cVar);
        if (cVar == null) {
            l1(null, 10);
        } else if (cVar.f()) {
            this.K.i(!l0.g(cVar.a()));
        } else {
            l1(new e.c.a.b.a.a.a.a(cVar.b()), 11);
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public Observable<c<List<? extends KGSong>>> o1(int i2) {
        Observable<c<List<? extends KGSong>>> map = Observable.just("").map(new b());
        j.d(map, "override fun requestData(page: Int): Observable<CommonResponse<List<KGSong>>> {\n        return Observable.just(\"\")\n            .map {\n                val result =  GuessYouLikeHelper.getInstance().getGuessYouLikeSongs(\"推荐页面\");\n                val songs = result?.channelSongsEntity?.getChannelSongs()\n                val errorCode = result?.errorCode ?: 0\n                val status = result?.status ?: 0\n                try {\n                    report(songs)\n                } catch (e: Exception) {\n                }\n\n                CommonResponse<List<KGSong>>().apply {\n                    isEnd = true\n                    setErrorCode(errorCode)\n                    setStatus(status)\n                    data = songs\n                }\n            }\n    }");
        return map;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_new_song, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.content_title);
        Bundle arguments = getArguments();
        textView.setText(arguments == null ? null : arguments.getString("key_title"));
        View viewFindViewById = view.findViewById(R.id.content_detail);
        j.d(viewFindViewById, "view.findViewById(R.id.content_detail)");
        DelegateListFragment.A0(this, (KGRecyclerView) viewFindViewById, new LinearLayoutManager(getContext()), K1(), null, 8, null);
        j1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "为你推荐";
    }
}
