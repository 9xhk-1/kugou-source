package com.kugou.android.watch.lite.component.recentplaylist;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateListFragment;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import e.c.a.g.a.d.f.c.a.q;
import e.c.a.g.a.g.d.c;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.o;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.r;
import e.c.a.g.a.s.u1;
import f.u.m;
import f.u.n;
import f.u.u;
import f.z.c.l;
import f.z.d.j;
import f.z.d.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
@e.c.c.l.f.b(id = -1)
public final class RecentPlaySongsFragment extends DelegateListFragment<List<? extends KGMusicWrapper>, KGMusicWrapper> {
    public ImageView H;
    public e.c.a.g.a.g.d.a I;
    public Subscription J;
    public volatile long L;
    public final e.c.a.g.a.g.c K = new e.c.a.g.a.g.c(new int[]{20, 80, 50, 20}, new int[]{2, 3});
    public final HashSet<Long> M = new HashSet<>();
    public final f.d N = f.f.b(new a());
    public final String O = "最近播放页面";
    public final int P = 103;
    public final e.c.a.g.a.k.d.a Q = new e.c.a.g.a.k.d.a(ApmDataTypeID.RECENT_PLAY_LIST_PAGE);
    public final BroadcastReceiver R = new BroadcastReceiver() { // from class: com.kugou.android.watch.lite.component.recentplaylist.RecentPlaySongsFragment$broadcastReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            j.e(context, "context");
            j.e(intent, "intent");
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && j.a(action, "com.kugou.young.watch.songdbupdated")) {
                Bundle extras = intent.getExtras();
                Object obj = null;
                KGMusicWrapper kGMusicWrapper = extras == null ? null : (KGMusicWrapper) extras.getParcelable("arg_song");
                if (kGMusicWrapper != null) {
                    ArrayList<KGMusicWrapper> arrayListI = this.a.V1().i();
                    j.d(arrayListI, "adapter.datas");
                    Iterator<T> it = arrayListI.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (((KGMusicWrapper) next).getMixId() == kGMusicWrapper.getMixId()) {
                            obj = next;
                            break;
                        }
                    }
                    KGMusicWrapper kGMusicWrapper2 = (KGMusicWrapper) obj;
                    if (kGMusicWrapper2 != null) {
                        this.a.V1().k(kGMusicWrapper2);
                    }
                    this.a.V1().e(0, kGMusicWrapper);
                    this.a.V1().notifyDataSetChanged();
                    this.a.M.add(Long.valueOf(kGMusicWrapper.getMixId()));
                    this.a.T1();
                }
            }
        }
    };

    /* JADX INFO: loaded from: classes2.dex */
    public static final class a extends k implements f.z.c.a<e.c.a.g.a.g.d.c> {

        /* JADX INFO: renamed from: com.kugou.android.watch.lite.component.recentplaylist.RecentPlaySongsFragment$a$a, reason: collision with other inner class name */
        public static final class C0015a implements c.a {
            public final /* synthetic */ RecentPlaySongsFragment a;

            public C0015a(RecentPlaySongsFragment recentPlaySongsFragment) {
                this.a = recentPlaySongsFragment;
            }

            @Override // e.c.a.g.a.g.d.c.a
            public void onLongClick(KGMusicWrapper kGMusicWrapper) {
                j.e(kGMusicWrapper, "music");
                e.c.a.g.a.g.d.a aVar = this.a.I;
                if (aVar == null || !aVar.isShowing()) {
                    this.a.I = new e.c.a.g.a.g.d.a(this.a, kGMusicWrapper, 2);
                    e.c.a.g.a.g.d.a aVar2 = this.a.I;
                    if (aVar2 != null) {
                        aVar2.show();
                    }
                    e.c.a.g.a.e.b.b(new YoungBITask(20483, "click").setType("2"));
                }
            }
        }

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.g.d.c invoke() {
            RecentPlaySongsFragment recentPlaySongsFragment = RecentPlaySongsFragment.this;
            return new e.c.a.g.a.g.d.c(recentPlaySongsFragment, "41", new C0015a(recentPlaySongsFragment));
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class b<T, R> implements Func1 {
        public static final b<T, R> a = new b<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer call(String str) {
            return Integer.valueOf(e.c.a.g.a.g.m.b.a.c());
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class c<T> implements Action1 {
        public static final c<T> a = new c<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Integer num) {
            EventBus.getDefault().post(new e.c.a.g.a.g.m.a(null, true));
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class d<T> implements Action1 {
        public d() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            p1.h(RecentPlaySongsFragment.this.getContext(), "数据库异常，请退出重试");
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class e implements Runnable {
        public final /* synthetic */ List<KGMusicWrapper> a;
        public final /* synthetic */ RecentPlaySongsFragment b;

        public static final class a extends k implements l<KGMusicWrapper, CharSequence> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            @Override // f.z.c.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(KGMusicWrapper kGMusicWrapper) {
                j.e(kGMusicWrapper, "it");
                return String.valueOf(kGMusicWrapper.getMixId());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(List<? extends KGMusicWrapper> list, RecentPlaySongsFragment recentPlaySongsFragment) {
            this.a = list;
            this.b = recentPlaySongsFragment;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<KGMusicWrapper> list = this.a;
            if (list == null || list.isEmpty()) {
                return;
            }
            e.c.a.g.a.g.f.d.b(3, String.valueOf(this.b.E0() - 1), u.B(this.a, ",", null, null, 0, null, a.a, 30, null));
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ RecentPlaySongsFragment a;

            public a(RecentPlaySongsFragment recentPlaySongsFragment) {
                this.a = recentPlaySongsFragment;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.U1();
            }
        }

        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (u1.g()) {
                return;
            }
            e.c.a.g.a.d.h.a aVar = new e.c.a.g.a.d.h.a(RecentPlaySongsFragment.this.requireActivity());
            aVar.e("是否确认删除全部历史");
            aVar.a("取消");
            aVar.b("确认");
            aVar.d(new a(RecentPlaySongsFragment.this));
            aVar.show();
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class g<T, R> implements Func1 {
        public final /* synthetic */ int a;
        public final /* synthetic */ RecentPlaySongsFragment b;

        public static final class a<T> implements r {
            public final /* synthetic */ RecentPlaySongsFragment a;

            public a(RecentPlaySongsFragment recentPlaySongsFragment) {
                this.a = recentPlaySongsFragment;
            }

            @Override // e.c.a.g.a.s.r
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final boolean isFilter(q qVar) {
                return this.a.M.contains(Long.valueOf(qVar.c()));
            }
        }

        public g(int i2, RecentPlaySongsFragment recentPlaySongsFragment) {
            this.a = i2;
            this.b = recentPlaySongsFragment;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<q> call(Integer num) {
            if (this.a == 1) {
                this.b.L = System.currentTimeMillis();
            }
            List<q> listE = e.c.a.g.a.g.m.b.a.e(this.b.L, this.b.K.a(this.a));
            if (!(listE == null || listE.isEmpty())) {
                this.b.L = ((q) u.D(listE)).b();
                if (true ^ this.b.M.isEmpty()) {
                    l0.a(listE, new a(this.b));
                }
            }
            if (g0.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestData: curPage=");
                sb.append(this.a);
                sb.append(", size=");
                sb.append(listE == null ? null : Integer.valueOf(listE.size()));
                g0.b("RecentPlaySongsFragment", sb.toString());
            }
            return listE;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class h<T, R> implements Func1 {
        public h() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.f.k.c<List<KGMusicWrapper>> call(List<q> list) {
            ArrayList arrayList = new ArrayList(l0.e(list));
            if (!(list == null || list.isEmpty())) {
                ArrayList arrayList2 = new ArrayList(n.j(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Long.valueOf(((q) it.next()).c()));
                }
                List<KGMusic> listQ = e.c.a.g.a.g.k.a.a.q(arrayList2);
                LinkedHashMap linkedHashMap = new LinkedHashMap(listQ.size());
                for (T t : listQ) {
                    linkedHashMap.put(Long.valueOf(((KGMusic) t).mixId), t);
                }
                Initiator initiatorCarryPagePath = Initiator.create(RecentPlaySongsFragment.this.m()).carryPagePath(RecentPlaySongsFragment.this.n());
                for (q qVar : list) {
                    KGMusic kGMusicL = (KGMusic) linkedHashMap.get(Long.valueOf(qVar.c()));
                    if (kGMusicL == null && !j.a(qVar.a(), "")) {
                        kGMusicL = e.c.a.g.a.g.k.a.a.l(qVar.a());
                    }
                    if (kGMusicL != null) {
                        KGMusicWrapper kGMusicWrapperA = e.c.a.g.a.f.j.a.c.a(initiatorCarryPagePath, "41", kGMusicL);
                        j.d(kGMusicWrapperA, "createKGMusicWrapper(\n                                initiator,\n                                TraceSource.SOURCE_41,\n                                music\n                            )");
                        arrayList.add(kGMusicWrapperA);
                    }
                }
            }
            e.c.a.g.a.f.k.c<List<KGMusicWrapper>> cVar = new e.c.a.g.a.f.k.c<>();
            cVar.m(1);
            cVar.g(arrayList);
            cVar.h(l0.g(list));
            return cVar;
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public e.c.a.g.a.f.o.h.a<KGMusicWrapper> D0() {
        return V1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public String G0() {
        return "暂时没有内容哦";
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void G1() {
        super.G1();
        e.c.a.g.a.g.f.d.c(3, "-1004", String.valueOf(E0()));
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public List<KGMusicWrapper> I0(boolean z, e.c.a.g.a.f.k.c<List<? extends KGMusicWrapper>> cVar) {
        j.e(cVar, "response");
        List<KGMusicWrapper> list = (List) cVar.a();
        return list == null ? m.d() : list;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void I1() {
        super.I1();
        this.Q.j();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void O0(boolean z, Throwable th) {
        j.e(th, "t");
        super.O0(z, th);
        e.c.a.g.a.g.f.d.c(3, "-1002", E0() + ", e:" + ((Object) th.getMessage()));
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void P0(e.c.a.g.a.f.k.c<List<? extends KGMusicWrapper>> cVar, boolean z) {
        j.e(cVar, "response");
        super.P0(cVar, z);
        j0.b().a(new e(cVar.a(), this));
    }

    public final void T1() {
        boolean zIsEmpty = V1().i().isEmpty();
        ImageView imageView = this.H;
        if (imageView != null) {
            imageView.setVisibility(zIsEmpty ^ true ? 0 : 8);
        }
        if (zIsEmpty) {
            y1();
        } else {
            x1();
        }
    }

    public final void U1() {
        i1.a(this.J);
        this.J = Observable.just("").subscribeOn(Schedulers.io()).map(b.a).observeOn(AndroidSchedulers.mainThread()).subscribe((Action1) c.a, (Action1<Throwable>) new d());
    }

    public final e.c.a.g.a.g.d.c V1() {
        return (e.c.a.g.a.g.d.c) this.N.getValue();
    }

    public final void W1() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.kugou.young.watch.songdbupdated");
        e.c.a.g.a.f.d.a.b(this.R, intentFilter);
    }

    public final void X1() {
        ImageView imageView = (ImageView) j0(R.id.content_delete);
        this.H = imageView;
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(new f());
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public boolean a1() {
        return false;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void f1(List<? extends KGMusicWrapper> list, boolean z) {
        j.e(list, "newAddedData");
        super.f1(list, z);
        ImageView imageView = this.H;
        if (imageView != null) {
            imageView.setVisibility(V1().j() ^ true ? 0 : 8);
        }
        if (X0() || !this.K.b(E0())) {
            return;
        }
        g1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void h1() {
        super.h1();
        this.Q.e();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void i1() {
        super.i1();
        this.Q.g();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void l1(Throwable th, Integer num) {
        super.l1(th, num);
        this.Q.b(th, this.P, this.O, num);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void m1() {
        super.m1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void n1(e.c.a.g.a.f.k.c<List<? extends KGMusicWrapper>> cVar) {
        super.n1(cVar);
        if (cVar == null) {
            l1(null, 10);
        } else if (cVar.f()) {
            this.Q.i(!l0.g(I0(true, cVar)));
        } else {
            l1(new e.c.a.b.a.a.a.a(cVar.b()), 11);
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public Observable<e.c.a.g.a.f.k.c<List<? extends KGMusicWrapper>>> o1(int i2) {
        Observable<e.c.a.g.a.f.k.c<List<? extends KGMusicWrapper>>> map = Observable.just(Integer.valueOf(i2)).subscribeOn(Schedulers.io()).map(new g(i2, this)).map(new h());
        j.d(map, "override fun requestData(curPage: Int): Observable<CommonResponse<List<KGMusicWrapper>>> {\n        return Observable.just(curPage)\n            .subscribeOn(Schedulers.io())\n            .map {\n                // 第一页重置数据\n                if (curPage == 1) {\n                    lastPlayTime = System.currentTimeMillis()\n                }\n                // 分页加载，按照播放时间作为分页的分界线\n                val pageCount = pageLoadCtrl.getPageCountByPageNo(curPage)\n                val songs = RecentPlayListDaoHelper.getList(lastPlayTime, pageCount)\n                if (!songs.isNullOrEmpty()) {\n                    lastPlayTime = songs.last().lastPlayTime\n                    if (newestPlaySongSet.isNotEmpty()) {\n                        ListUtil.filter(songs) { newestPlaySongSet.contains(it.mixId) }\n                    }\n                }\n                if (KGLog.DEBUG)\n                    KGLog.d(TAG, \"requestData: curPage=$curPage, size=${songs?.size}\");\n                songs\n            }\n            .map { list ->\n                val result = ArrayList<KGMusicWrapper>(ListUtil.getSize(list))\n                if (!list.isNullOrEmpty()) {\n                    val mixIds = list.map { it.mixId }\n                    val musicMap = KGMusicDaoHelper\n                        .getKGMusicListByMixidList(mixIds)\n                        .toMap { it.mixId }\n\n                    val initiator = Initiator.create(pageKey).carryPagePath(pagePath)\n                    list.forEach { record ->\n                        var music = musicMap[record.mixId]\n                        if (music == null && record.hash != \"\") {\n                            music = KGMusicDaoHelper.getKGMusicByHash(record.hash)\n                        }\n                        if (music != null) {\n                            val wrapper = KGDataConvertHelper.createKGMusicWrapper(\n                                initiator,\n                                TraceSource.SOURCE_41,\n                                music\n                            )\n                            result.add(wrapper)\n                        }\n                    }\n                }\n                val response = CommonResponse<List<KGMusicWrapper>>()\n                response.setStatus(1)\n                response.data = result\n                response.isEnd = ListUtil.isEmpty(list)\n                response\n            }\n    }");
        return map;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return View.inflate(getContext(), R.layout.fragment_recent_playlist, null);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        o.a(this);
        e.c.a.g.a.f.d.a.g(this.R);
        i1.a(this.J);
        this.J = null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.g.m.a aVar) {
        j.e(aVar, NotificationCompat.CATEGORY_EVENT);
        if (aVar.a()) {
            V1().h();
            this.M.clear();
        } else {
            KGMusicWrapper kGMusicWrapperB = aVar.b();
            if (kGMusicWrapperB != null) {
                V1().k(kGMusicWrapperB);
                this.M.remove(Long.valueOf(kGMusicWrapperB.getMixId()));
            }
        }
        V1().notifyDataSetChanged();
        T1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        View viewFindViewById = requireView().findViewById(R.id.content_detail);
        j.d(viewFindViewById, "requireView().findViewById(R.id.content_detail)");
        DelegateListFragment.A0(this, (KGRecyclerView) viewFindViewById, new LinearLayoutManager(getContext()), V1(), null, 8, null);
        X1();
        W1();
        j1();
        EventBus.getDefault().register(this);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void q1() {
        super.q1();
        e.c.a.g.a.e.b.b(new YoungBITask(20498, "click").setType("4"));
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "历史";
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void y1() {
        super.y1();
        ImageView imageView = this.H;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        e.c.a.g.a.g.f.d.b(3, "0", "");
    }
}
