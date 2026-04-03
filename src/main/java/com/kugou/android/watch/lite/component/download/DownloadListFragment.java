package com.kugou.android.watch.lite.component.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.RoomMasterTable;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateListFragment;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.widget.PlayerBall;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import e.c.a.g.a.d.d0.a;
import e.c.a.g.a.g.d.c;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.o;
import f.f;
import f.u.m;
import f.u.n;
import f.u.u;
import f.z.c.l;
import f.z.d.j;
import f.z.d.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
@e.c.c.l.f.b(id = -1)
public final class DownloadListFragment extends DelegateListFragment<List<? extends KGMusicWrapper>, KGMusicWrapper> {
    public e.c.a.g.a.g.d.a H;
    public PlayerBall I;
    public volatile int J = -1;
    public final e.c.a.g.a.g.c K = new e.c.a.g.a.g.c(new int[]{20, 80, 50, 20});
    public final f.d L = f.b(new a());
    public final BroadcastReceiver M = new BroadcastReceiver() { // from class: com.kugou.android.watch.lite.component.download.DownloadListFragment$broadcastReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            j.e(context, "context");
            j.e(intent, "intent");
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && j.a(action, "com.kugou.android.download_file_success")) {
                this.a.j1();
                a.b("DownloadListFragment", "onReceive, DOWNLOAD_FILE_SUCCESS, onRefresh");
            }
        }
    };
    public final String N = "下载页面";
    public final int O = 101;
    public final e.c.a.g.a.k.d.a P = new e.c.a.g.a.k.d.a(ApmDataTypeID.DOWNLOAD_LIST_PAGE);

    public static final class a extends k implements f.z.c.a<e.c.a.g.a.g.d.c> {

        /* JADX INFO: renamed from: com.kugou.android.watch.lite.component.download.DownloadListFragment$a$a, reason: collision with other inner class name */
        public static final class C0011a implements c.a {
            public final /* synthetic */ DownloadListFragment a;

            public C0011a(DownloadListFragment downloadListFragment) {
                this.a = downloadListFragment;
            }

            @Override // e.c.a.g.a.g.d.c.a
            public void onLongClick(KGMusicWrapper kGMusicWrapper) {
                j.e(kGMusicWrapper, "music");
                e.c.a.g.a.g.d.a aVar = this.a.H;
                if (aVar == null || !aVar.isShowing()) {
                    this.a.H = new e.c.a.g.a.g.d.a(this.a, kGMusicWrapper, 1);
                    e.c.a.g.a.g.d.a aVar2 = this.a.H;
                    if (aVar2 != null) {
                        aVar2.show();
                    }
                    e.c.a.g.a.e.b.b(new YoungBITask(20483, "click").setType("2"));
                    e.c.a.g.a.d.d0.a.b("DownloadListFragment", j.l("onLongClick, music = ", kGMusicWrapper));
                }
            }
        }

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.g.d.c invoke() {
            DownloadListFragment downloadListFragment = DownloadListFragment.this;
            return new e.c.a.g.a.g.d.c(downloadListFragment, RoomMasterTable.DEFAULT_ID, new C0011a(downloadListFragment));
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ List<KGMusicWrapper> a;
        public final /* synthetic */ DownloadListFragment b;

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
        public b(List<? extends KGMusicWrapper> list, DownloadListFragment downloadListFragment) {
            this.a = list;
            this.b = downloadListFragment;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<KGMusicWrapper> list = this.a;
            if (list == null || list.isEmpty()) {
                if (e.c.a.g.a.d.d0.a.a) {
                    e.c.a.g.a.d.d0.a.a("DownloadListFragment", "handleSuccess isNullOrEmpty ");
                    return;
                }
                return;
            }
            String strB = u.B(this.a, ",", null, null, 0, null, a.a, 30, null);
            e.c.a.g.a.g.f.d.b(2, String.valueOf(this.b.E0() - 1), strB);
            if (e.c.a.g.a.d.d0.a.a) {
                e.c.a.g.a.d.d0.a.a("DownloadListFragment", "handleSuccess (curPage - 1).toString() = " + (this.b.E0() - 1) + ", mixIds = " + strB);
            }
        }
    }

    public static final class c<T, R> implements Func1 {
        public final /* synthetic */ int a;
        public final /* synthetic */ DownloadListFragment b;

        public c(int i2, DownloadListFragment downloadListFragment) {
            this.a = i2;
            this.b = downloadListFragment;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<e.c.a.g.a.d.f.c.a.a> call(Integer num) {
            if (this.a == 1) {
                DownloadListFragment downloadListFragment = this.b;
                e.c.a.g.a.d.f.c.a.a aVarG = e.c.a.g.a.g.d.d.a.g();
                downloadListFragment.J = aVarG == null ? -1 : aVarG.m();
            }
            List<e.c.a.g.a.d.f.c.a.a> listF = e.c.a.g.a.g.d.d.a.f(this.b.J, this.b.K.a(this.a));
            if (!(listF == null || listF.isEmpty())) {
                this.b.J = ((e.c.a.g.a.d.f.c.a.a) u.D(listF)).m() - 1;
            }
            if (g0.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestData:page=");
                sb.append(this.a);
                sb.append(" size=");
                sb.append(listF == null ? null : Integer.valueOf(listF.size()));
                sb.append(" last=");
                sb.append(this.b.J);
                g0.b("DownloadListFragment", sb.toString());
            }
            if (e.c.a.g.a.d.d0.a.a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestData:page=");
                sb2.append(this.a);
                sb2.append(" size=");
                sb2.append(listF != null ? Integer.valueOf(listF.size()) : null);
                sb2.append(" last=");
                sb2.append(this.b.J);
                e.c.a.g.a.d.d0.a.a("DownloadListFragment", sb2.toString());
            }
            return listF;
        }
    }

    public static final class d<T, R> implements Func1 {
        public final /* synthetic */ int b;

        public d(int i2) {
            this.b = i2;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.f.k.c<List<KGMusicWrapper>> call(List<e.c.a.g.a.d.f.c.a.a> list) {
            ArrayList arrayList = new ArrayList(l0.e(list));
            if (!(list == null || list.isEmpty())) {
                ArrayList arrayList2 = new ArrayList(n.j(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Long.valueOf(((e.c.a.g.a.d.f.c.a.a) it.next()).o()));
                }
                List<KGMusic> listQ = e.c.a.g.a.g.k.a.a.q(arrayList2);
                LinkedHashMap linkedHashMap = new LinkedHashMap(listQ.size());
                for (T t : listQ) {
                    linkedHashMap.put(Long.valueOf(((KGMusic) t).mixId), t);
                }
                Initiator initiatorCarryPagePath = Initiator.create(DownloadListFragment.this.m()).carryPagePath(DownloadListFragment.this.n());
                for (e.c.a.g.a.d.f.c.a.a aVar : list) {
                    KGMusic kGMusicL = (KGMusic) linkedHashMap.get(Long.valueOf(aVar.o()));
                    if (kGMusicL == null && !j.a(aVar.s(), "")) {
                        kGMusicL = e.c.a.g.a.g.k.a.a.l(aVar.s());
                    }
                    if (kGMusicL != null) {
                        kGMusicL.setFromLocalMusic(true);
                        kGMusicL.extUniqueId = aVar.m();
                        KGMusicWrapper kGMusicWrapperA = e.c.a.g.a.f.j.a.c.a(initiatorCarryPagePath, RoomMasterTable.DEFAULT_ID, kGMusicL);
                        j.d(kGMusicWrapperA, "createKGMusicWrapper(\n                                initiator,\n                                TraceSource.SOURCE_42,\n                                music\n                            )");
                        if (e.c.a.g.a.g.o.b.j(kGMusicL)) {
                            Log.d("mhs_watch_grade_filter", "music = " + kGMusicL.mixId + ", music = " + ((Object) kGMusicL.getDisplayName()));
                        } else {
                            arrayList.add(kGMusicWrapperA);
                        }
                    }
                }
                if (e.c.a.g.a.d.d0.a.a) {
                    e.c.a.g.a.d.d0.a.a("DownloadListFragment", "requestData " + this.b + ", mixIds:" + arrayList2);
                }
            }
            if (e.c.a.g.a.d.d0.a.a) {
                e.c.a.g.a.d.d0.a.a("DownloadListFragment", "requestData " + this.b + ", ListUtil.isEmpty(list) " + l0.g(list));
            }
            e.c.a.g.a.f.k.c<List<KGMusicWrapper>> cVar = new e.c.a.g.a.f.k.c<>();
            cVar.m(1);
            cVar.h(l0.g(list));
            cVar.g(arrayList);
            return cVar;
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public e.c.a.g.a.f.o.h.a<KGMusicWrapper> D0() {
        return P1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void G() {
        super.G();
        PlayerBall playerBall = this.I;
        if (playerBall == null) {
            return;
        }
        playerBall.j(false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public String G0() {
        return "暂时没有内容哦";
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void G1() {
        super.G1();
        e.c.a.g.a.g.f.d.c(2, "-1004", String.valueOf(E0()));
        if (e.c.a.g.a.d.d0.a.a) {
            e.c.a.g.a.d.d0.a.a("DownloadListFragment", j.l("showRefresh curPage = ", Integer.valueOf(E0())));
        }
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
        this.P.j();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void J() {
        super.J();
        PlayerBall playerBall = this.I;
        if (playerBall == null) {
            return;
        }
        playerBall.j(e.c.a.g.a.d.x.f.q());
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void O0(boolean z, Throwable th) {
        j.e(th, "t");
        super.O0(z, th);
        e.c.a.g.a.g.f.d.c(2, "-1002", E0() + ", e:" + ((Object) th.getMessage()));
        if (e.c.a.g.a.d.d0.a.a) {
            e.c.a.g.a.d.d0.a.a("DownloadListFragment", "handleFailed " + E0() + ", e:" + ((Object) th.getMessage()));
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void P0(e.c.a.g.a.f.k.c<List<? extends KGMusicWrapper>> cVar, boolean z) {
        j.e(cVar, "response");
        super.P0(cVar, z);
        j0.b().a(new b(cVar.a(), this));
    }

    public final e.c.a.g.a.g.d.c P1() {
        return (e.c.a.g.a.g.d.c) this.L.getValue();
    }

    public final void Q1() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.kugou.android.download_file_success");
        e.c.a.g.a.f.d.a.b(this.M, intentFilter);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public boolean a1() {
        return false;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void f1(List<? extends KGMusicWrapper> list, boolean z) {
        j.e(list, "newAddedData");
        super.f1(list, z);
        if (X0() || !this.K.b(E0())) {
            return;
        }
        g1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void h1() {
        super.h1();
        this.P.e();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void i1() {
        super.i1();
        this.P.g();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void l1(Throwable th, Integer num) {
        super.l1(th, num);
        this.P.b(th, this.O, this.N, num);
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
            this.P.i(!l0.g(I0(true, cVar)));
        } else {
            l1(new e.c.a.b.a.a.a.a(cVar.b()), 11);
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public Observable<e.c.a.g.a.f.k.c<List<? extends KGMusicWrapper>>> o1(int i2) {
        Observable<e.c.a.g.a.f.k.c<List<? extends KGMusicWrapper>>> map = Observable.just(Integer.valueOf(i2)).subscribeOn(Schedulers.io()).map(new c(i2, this)).map(new d(i2));
        j.d(map, "override fun requestData(curPage: Int): Observable<CommonResponse<List<KGMusicWrapper>>> {\n        return Observable.just(curPage)\n            .subscribeOn(Schedulers.io())\n            .map {\n                // 第一页重置数据\n                if (curPage == 1) {\n                    lastId = DownloadSongDaoHelper.getNewestDownloadSong()?.id ?: -1\n                }\n                val pageCount = pageLoadCtrl.getPageCountByPageNo(curPage)\n                val list = DownloadSongDaoHelper.getList(lastId, pageCount)\n                if (!list.isNullOrEmpty()) {\n                    lastId = list.last().id - 1\n                }\n                if (KGLog.DEBUG) {\n                    KGLog.d(TAG, \"requestData:page=$curPage size=${list?.size} last=$lastId\");\n                }\n                if (XKGLog.isEnable) {\n                    XKGLog.d(TAG, \"requestData:page=$curPage size=${list?.size} last=$lastId\");\n                }\n                return@map list\n            }\n            .map { list ->\n                //补充完整\n                val result = ArrayList<KGMusicWrapper>(ListUtil.getSize(list))\n                if (!list.isNullOrEmpty()) {\n                    val mixIds = list.map { it.mix_id }\n                    val musicMap = KGMusicDaoHelper\n                        .getKGMusicListByMixidList(mixIds)\n                        .toMap { it.mixId }\n\n                    val initiator = Initiator.create(pageKey).carryPagePath(pagePath)\n                    list.forEach { downloadSongs ->\n                        var music = musicMap[downloadSongs.mix_id]\n\n                        if (music == null && downloadSongs.source_hash != \"\") {\n                            music = KGMusicDaoHelper.getKGMusicByHash(downloadSongs.source_hash)\n                        }\n                        if (music != null) {\n                            music.isFromLocalMusic = true\n                            music.extUniqueId = downloadSongs.id\n                            val wrapper = KGDataConvertHelper.createKGMusicWrapper(\n                                initiator,\n                                TraceSource.SOURCE_42,\n                                music\n                            )\n                            if (!ContentFilter.isFilterGradeSongLimit(music)) {\n                                result.add(wrapper)\n                            } else {\n                                Log.d(\"mhs_watch_grade_filter\", \"music = \" + music.mixId + \", \" + \"music = \" + music.getDisplayName())\n                            }\n                        }\n                    }\n                    if (XKGLog.isEnable) {\n                        XKGLog.d(TAG, \"requestData \" + \"${curPage}, mixIds:\" + mixIds);\n                    }\n                }\n\n                if (XKGLog.isEnable) {\n                    XKGLog.d(TAG, \"requestData \" + \"${curPage}, ListUtil.isEmpty(list) \" + ListUtil.isEmpty(list));\n                }\n\n                val response = CommonResponse<List<KGMusicWrapper>>()\n                response.setStatus(1)\n                response.isEnd = ListUtil.isEmpty(list)\n                response.data = result\n                response\n            }\n    }");
        return map;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return View.inflate(getContext(), R.layout.fragment_download_list, null);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        o.a(this);
        e.c.a.g.a.f.d.a.g(this.M);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.g.d.b bVar) {
        j.e(bVar, NotificationCompat.CATEGORY_EVENT);
        if (bVar.a() < 0) {
            return;
        }
        KGMusicWrapper kGMusicWrapper = null;
        Iterator<KGMusicWrapper> it = P1().i().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            KGMusicWrapper next = it.next();
            if (next.getKgmusic().extUniqueId == bVar.a()) {
                kGMusicWrapper = next;
                break;
            }
        }
        if (kGMusicWrapper != null) {
            P1().k(kGMusicWrapper);
            P1().notifyDataSetChanged();
            boolean z = false;
            if (P1().i().isEmpty()) {
                y1();
                z = true;
            }
            e.c.a.g.a.d.d0.a.b("DownloadListFragment", "onEventMainThread, DeleteDownloadItemEvent destSong " + kGMusicWrapper + ", isEmpty = " + z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PlayerBall playerBall = this.I;
        if (playerBall == null) {
            return;
        }
        playerBall.j(false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PlayerBall playerBall = this.I;
        if (playerBall == null) {
            return;
        }
        playerBall.j(e.c.a.g.a.d.x.f.q());
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        PlayerBall playerBall = (PlayerBall) view.findViewById(R.id.play_ball);
        this.I = playerBall;
        if (playerBall != null) {
            playerBall.setupFragment(this);
        }
        View viewFindViewById = requireView().findViewById(R.id.content_detail);
        j.d(viewFindViewById, "requireView().findViewById(R.id.content_detail)");
        DelegateListFragment.A0(this, (KGRecyclerView) viewFindViewById, new LinearLayoutManager(getContext()), P1(), null, 8, null);
        j1();
        Q1();
        EventBus.getDefault().register(this);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "下载";
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void y1() {
        super.y1();
        e.c.a.g.a.g.f.d.b(2, "0", "");
        if (e.c.a.g.a.d.d0.a.a) {
            e.c.a.g.a.d.d0.a.a("DownloadListFragment", "showEmpty");
        }
    }
}
