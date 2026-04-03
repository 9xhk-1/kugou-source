package com.kugou.android.watch.lite.component.fav;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateListFragment;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import com.kugou.android.watch.lite.component.playlist.entity.KGPlaylistMusic;
import com.kugou.common.startAppAPM.task.ApmReportHelper;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.g.i.w;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.m;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;
import f.u.n;
import f.u.u;
import f.z.c.l;
import f.z.d.j;
import f.z.d.k;
import f.z.d.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
@e.c.c.l.f.b(id = 967177915)
public final class FavListFragment extends DelegateListFragment<List<? extends KGMusicWrapper>, KGMusicWrapper> {
    public volatile int H;
    public final boolean I = e.c.a.g.a.g.o.b.l();
    public boolean J;
    public boolean K;
    public final f.d L;
    public Subscription M;
    public final e.c.a.g.a.g.c N;
    public final f.d O;
    public boolean P;
    public boolean Q;
    public final BroadcastReceiver R;
    public final boolean S;

    public static final class a extends k implements f.z.c.a<e.c.a.g.a.g.f.b> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.g.f.b invoke() {
            return new e.c.a.g.a.g.f.b();
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ List<KGMusicWrapper> a;
        public final /* synthetic */ FavListFragment b;

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
        public b(List<? extends KGMusicWrapper> list, FavListFragment favListFragment) {
            this.a = list;
            this.b = favListFragment;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<KGMusicWrapper> list = this.a;
            if (list == null || list.isEmpty()) {
                if (e.c.a.g.a.d.d0.a.a) {
                    e.c.a.g.a.d.d0.a.a("FavListFragment", "handleSuccess (curPage - 1) = " + (this.b.E0() - 1) + ", isNullOrEmpty。");
                    return;
                }
                return;
            }
            String strB = u.B(this.a, ",", null, null, 0, null, a.a, 30, null);
            e.c.a.g.a.g.f.d.b(1, String.valueOf(this.b.E0() - 1), strB);
            if (e.c.a.g.a.d.d0.a.a) {
                e.c.a.g.a.d.d0.a.a("FavListFragment", "handleSuccess (curPage - 1) = " + (this.b.E0() - 1) + ", mixIds = " + strB);
            }
        }
    }

    public static final class c extends k implements f.z.c.a<Boolean> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        public final boolean a() {
            try {
                if (g0.a) {
                    return true;
                }
                String strI = m.i(false);
                j.d(strI, "uuid");
                String strSubstring = strI.substring(strI.length() - 2);
                j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                f.e0.a.a(16);
                return ((float) e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.r3, 20)) >= (((float) Integer.parseInt(strSubstring, 16)) / 255.0f) * ((float) 100);
            } catch (Exception unused) {
                return false;
            }
        }

        @Override // f.z.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(a());
        }
    }

    public static final class d implements View.OnClickListener {
        public static final d a = new d();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (u1.h(1000)) {
                Log.e("FavListFragment", "call() -> 点击事件过快");
                return;
            }
            if (u0.n(KGApplication.getContext(), true)) {
                w.a aVar = w.l;
                if (aVar.g()) {
                    p1.f(KGApplication.getContext(), "正在同步...");
                    Log.d("FavListFragment", "page 正在同步...");
                } else {
                    Log.d("FavListFragment", "page 开始同步...");
                    e.c.a.g.a.g.f.c.a.w(aVar.b());
                }
            }
        }
    }

    public static final class e<T, R> implements Func1 {
        public final /* synthetic */ int a;
        public final /* synthetic */ FavListFragment b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f151d;

        public e(int i2, FavListFragment favListFragment, String str) {
            this.a = i2;
            this.b = favListFragment;
            this.f151d = str;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<KGPlaylistMusic> call(Integer num) {
            if (this.a == 1) {
                FavListFragment favListFragment = this.b;
                e.c.a.g.a.g.k.b bVar = e.c.a.g.a.g.k.b.a;
                String str = this.f151d;
                j.d(str, "favId");
                favListFragment.H = bVar.f(str);
            }
            int i2 = this.b.H;
            int iA = this.b.N.a(this.a);
            e.c.a.g.a.g.k.b bVar2 = e.c.a.g.a.g.k.b.a;
            String str2 = this.f151d;
            j.d(str2, "favId");
            List<KGPlaylistMusic> listN = bVar2.n(str2, i2, iA);
            if (!(listN == null || listN.isEmpty())) {
                this.b.H = ((KGPlaylistMusic) u.D(listN)).f() + 1;
            }
            if (this.a <= 2) {
                FavListFragment favListFragment2 = this.b;
                StringBuilder sb = new StringBuilder();
                sb.append("1 requestData, favId = ");
                sb.append((Object) this.f151d);
                sb.append(", curPage = ");
                sb.append(this.a);
                sb.append(", size = ");
                sb.append(listN == null ? null : Integer.valueOf(listN.size()));
                sb.append(", order = ");
                sb.append(this.b.H);
                favListFragment2.a2(sb.toString(), "requestData");
            }
            if (g0.a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestData: curPage=");
                sb2.append(this.a);
                sb2.append(" size=");
                sb2.append(listN != null ? Integer.valueOf(listN.size()) : null);
                sb2.append(" order=");
                sb2.append(this.b.H);
                g0.b("FavListFragment", sb2.toString());
            }
            return listN;
        }
    }

    public static final class f<T, R> implements Func1 {
        public final /* synthetic */ int b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f152d;

        public f(int i2, String str) {
            this.b = i2;
            this.f152d = str;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.f.k.c<List<KGMusicWrapper>> call(List<KGPlaylistMusic> list) {
            KGMusic kGMusicL;
            boolean zJ;
            ArrayList arrayList = new ArrayList(l0.e(list));
            if (!(list == null || list.isEmpty())) {
                ArrayList arrayList2 = new ArrayList(n.j(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Long.valueOf(((KGPlaylistMusic) it.next()).p()));
                }
                List<KGMusic> listQ = e.c.a.g.a.g.k.a.a.q(arrayList2);
                LinkedHashMap linkedHashMap = new LinkedHashMap(listQ.size());
                for (T t : listQ) {
                    linkedHashMap.put(Long.valueOf(((KGMusic) t).mixId), t);
                }
                Initiator initiatorCarryPagePath = Initiator.create(FavListFragment.this.m()).carryPagePath(FavListFragment.this.n());
                for (KGPlaylistMusic kGPlaylistMusic : list) {
                    try {
                        kGMusicL = (KGMusic) linkedHashMap.get(Long.valueOf(kGPlaylistMusic.p()));
                        if (((kGPlaylistMusic != null && kGPlaylistMusic.p() == 0) || kGMusicL == null) && kGPlaylistMusic.i() != null && !j.a(kGPlaylistMusic.i(), "")) {
                            e.c.a.g.a.g.k.a aVar = e.c.a.g.a.g.k.a.a;
                            String strI = kGPlaylistMusic.i();
                            j.c(strI);
                            kGMusicL = aVar.l(strI);
                        }
                        zJ = e.c.a.g.a.g.o.b.j(kGMusicL);
                        if (kGMusicL != null && zJ) {
                            Log.e("mhs_watch_grade_filter", "music:" + ((Object) kGMusicL.getDisplayName()) + ", music.getMixId = " + Long.valueOf(kGMusicL.getMixId()));
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        Log.e("mhs_watch_fav2", j.l("e = ", e2));
                    }
                    if (kGMusicL == null || zJ) {
                        Log.e("mhs_watch_fav", j.l("music: ", kGMusicL));
                    } else {
                        kGPlaylistMusic.T(kGMusicL);
                        KGMusicWrapper kGMusicWrapperB = e.c.a.g.a.f.j.a.c.b(initiatorCarryPagePath, "43", kGPlaylistMusic);
                        j.d(kGMusicWrapperB, "createKGMusicWrapper(\n                                    initiator, TraceSource.SOURCE_43, playlistMusic\n                                )");
                        arrayList.add(kGMusicWrapperB);
                        if (g0.f() && kGPlaylistMusic != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("music: ");
                            sb.append(kGMusicL);
                            sb.append("， playlistMusic.hash!! = ");
                            String strI2 = kGPlaylistMusic.i();
                            j.c(strI2);
                            sb.append(strI2);
                            Log.e("mhs_watch_fav", sb.toString());
                        }
                    }
                }
            }
            if (this.b <= 2) {
                FavListFragment favListFragment = FavListFragment.this;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("2 requestData, favId = ");
                sb2.append((Object) this.f152d);
                sb2.append(", result = ");
                sb2.append(Integer.valueOf(arrayList.size()));
                sb2.append(", list = ");
                sb2.append(list == null ? null : Integer.valueOf(list.size()));
                favListFragment.a2(sb2.toString(), "requestData");
            }
            e.c.a.g.a.f.k.c<List<KGMusicWrapper>> cVar = new e.c.a.g.a.f.k.c<>();
            cVar.g(arrayList);
            cVar.h(l0.g(list));
            cVar.m(1);
            return cVar;
        }
    }

    public static final class g implements KGRecyclerView.c {

        public static final class a<T, R> implements Func1 {
            public final /* synthetic */ FavListFragment a;
            public final /* synthetic */ KGMusicWrapper b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f153d;

            public a(FavListFragment favListFragment, KGMusicWrapper kGMusicWrapper, int i2) {
                this.a = favListFragment;
                this.b = kGMusicWrapper;
                this.f153d = i2;
            }

            @Override // rx.functions.Func1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Pair<Integer, List<KGMusicWrapper>> call(ArrayList<KGMusicWrapper> arrayList) {
                KGMusic kgmusic;
                if (this.a.I && e.c.a.g.a.g.o.b.f(this.b.getKgmusic())) {
                    Context context = this.a.getContext();
                    String strD = e.c.a.g.a.g.o.b.d();
                    KGMusicWrapper kGMusicWrapper = this.b;
                    p1.i(context, strD, j.l("isFilter, music = ", kGMusicWrapper == null ? null : kGMusicWrapper.getKgmusic()));
                    return null;
                }
                if (this.a.X1()) {
                    KGMusicWrapper kGMusicWrapper2 = this.b;
                    boolean z = false;
                    if (kGMusicWrapper2 != null && (kgmusic = kGMusicWrapper2.getKgmusic()) != null && kgmusic.mixId == 0) {
                        z = true;
                    }
                    if (z) {
                        KGMusic kgmusic2 = this.b.getKgmusic();
                        if (!TextUtils.isEmpty(kgmusic2 == null ? null : kgmusic2.hashValue)) {
                            Context context2 = this.a.getContext();
                            KGMusicWrapper kGMusicWrapper3 = this.b;
                            p1.i(context2, "歌曲信息错误，暂无法播放", j.l("2 isFilter, music = ", kGMusicWrapper3 == null ? null : kGMusicWrapper3.getKgmusic()));
                            return null;
                        }
                    }
                }
                int i2 = this.f153d;
                j.d(arrayList, "it");
                return new e.c.a.g.a.g.a(i2, arrayList).b();
            }
        }

        public static final class b<T> implements Action1 {
            public final /* synthetic */ FavListFragment a;

            public b(FavListFragment favListFragment) {
                this.a = favListFragment;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void call(Pair<Integer, List<KGMusicWrapper>> pair) {
                this.a.M = null;
                FavListFragment favListFragment = this.a;
                favListFragment.a2(j.l("setupRecyclerViewClick = playAll, isProgressDialogShowing = ", Boolean.valueOf(favListFragment.m0())), "click");
                if (this.a.m0()) {
                    this.a.i0();
                    if (pair == null) {
                        return;
                    }
                    Object obj = pair.first;
                    j.d(obj, "pair.first");
                    int iIntValue = ((Number) obj).intValue();
                    Object obj2 = pair.second;
                    j.d(obj2, "pair.second");
                    e.c.a.g.a.d.x.f.y(true, (List) obj2, iIntValue, true, this.a.l());
                }
            }
        }

        public static final class c<T> implements Action1 {
            public final /* synthetic */ FavListFragment a;

            public c(FavListFragment favListFragment) {
                this.a = favListFragment;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void call(Throwable th) {
                this.a.M = null;
                FavListFragment favListFragment = this.a;
                favListFragment.a2(j.l("setupRecyclerViewClick = 播放失败，请重试, isProgressDialogShowing = ", Boolean.valueOf(favListFragment.m0())), "click");
                if (this.a.m0()) {
                    this.a.i0();
                    p1.h(KGApplication.getContext(), "播放失败，请重试");
                }
            }
        }

        public g() {
        }

        @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.c
        public final void onItemClick(KGRecyclerView kGRecyclerView, View view, int i2, long j) {
            KGMusicWrapper item;
            if (u1.i(view) || (item = FavListFragment.this.W1().getItem(i2)) == null) {
                return;
            }
            FavListFragment.this.q0(true);
            FavListFragment.this.h0();
            i1.a(FavListFragment.this.M);
            FavListFragment favListFragment = FavListFragment.this;
            Observable observableObserveOn = Observable.just(favListFragment.W1().i()).map(new a(FavListFragment.this, item, i2)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            FavListFragment favListFragment2 = FavListFragment.this;
            favListFragment.M = observableObserveOn.subscribe(new b(favListFragment2), new c(favListFragment2));
            e.c.a.g.a.e.b.b(new YoungBITask(20482, "click").setType("1").setMixsongid(String.valueOf(item.getMixId())));
        }
    }

    public static final class h implements KGRecyclerView.d {
        public h() {
        }

        @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.d
        public final boolean onItemLongClick(KGRecyclerView kGRecyclerView, View view, int i2, long j) {
            if (u1.i(view) || i2 < 0) {
                return false;
            }
            KGMusicWrapper item = FavListFragment.this.W1().getItem(i2);
            if (e.c.a.g.a.d.d0.a.a) {
                e.c.a.g.a.d.d0.a.a("FavListFragment", j.l("setOnItemLongClickListener item = ", item));
            }
            if (item == null) {
                return false;
            }
            new e.c.a.g.a.g.f.a(FavListFragment.this, item).show();
            e.c.a.g.a.e.b.b(new YoungBITask(20482, "click").setType("2").setMixsongid(String.valueOf(item.getMixId())));
            return true;
        }
    }

    public FavListFragment() {
        c.b bVar = e.c.a.g.a.f.e.c.a;
        this.J = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.J3, 1) == 1;
        this.L = f.f.b(a.a);
        this.N = new e.c.a.g.a.g.c(new int[]{20, 80, 50, 20});
        this.O = f.f.b(c.a);
        this.Q = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.A3, 1) == 1;
        this.R = new BroadcastReceiver() { // from class: com.kugou.android.watch.lite.component.fav.FavListFragment$receiver$1

            public static final class a<T, R> implements Func1 {
                public static final a<T, R> a = new a<>();

                @Override // rx.functions.Func1
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Integer call(Integer num) {
                    int iB = -1;
                    try {
                        String strJ = e.c.a.g.a.r.b.j();
                        if (!TextUtils.isEmpty(strJ)) {
                            e.c.a.g.a.g.k.b bVar = e.c.a.g.a.g.k.b.a;
                            j.d(strJ, "favId");
                            iB = bVar.b(strJ);
                        }
                    } catch (Exception unused) {
                    }
                    return Integer.valueOf(iB);
                }
            }

            public static final class b<T> implements Action1 {
                public final /* synthetic */ FavListFragment a;
                public final /* synthetic */ q b;

                public b(FavListFragment favListFragment, q qVar) {
                    this.a = favListFragment;
                    this.b = qVar;
                }

                @Override // rx.functions.Action1
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final void call(Integer num) {
                    e.c.a.g.a.g.f.c.a.s("收藏页", j.l("needForeceReloadData localdata size, it = ", num));
                    j.d(num, "it");
                    if (num.intValue() <= 0) {
                        this.a.G1();
                        this.b.a = 2;
                    } else {
                        this.a.r1(1);
                        this.a.Z0(false);
                        this.b.a = 1;
                    }
                }
            }

            public static final class c<T> implements Action1 {
                public static final c<T> a = new c<>();

                @Override // rx.functions.Action1
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final void call(Throwable th) {
                }
            }

            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                KGMusicWrapper kGMusicWrapper;
                String lowerCase;
                String hashValue;
                j.e(context, "context");
                j.e(intent, "intent");
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                }
                if (g0.a) {
                    g0.b("FavListFragment", j.l("onReceive: action=", action));
                }
                if (e.c.a.g.a.d.d0.a.a) {
                    e.c.a.g.a.d.d0.a.a("FavListFragment", j.l("onReceive action = ", action));
                }
                if (action != null) {
                    switch (action.hashCode()) {
                        case -1923228876:
                            if (action.equals("com.kugou.android.cloud_playlist_updateed") && intent.getBooleanExtra("once_update_playlist", false)) {
                                this.a.j1();
                                this.a.K = false;
                                this.a.a2("ACTION_CLOUD_PLAYLIST_REFRES", "receiver");
                            }
                            break;
                        case -502153045:
                            if (action.equals("com.kugou.android.update_fav_btn_state")) {
                                this.a.j1();
                                this.a.a2("UPDATE_FAV_BTN_STATE", "receiver");
                                break;
                            }
                            break;
                        case 875757098:
                            if (action.equals("com.kugou.android.cloud_music_delete_success")) {
                                Serializable serializableExtra = intent.getSerializableExtra("del_cloud_music_info");
                                if (serializableExtra instanceof ArrayList) {
                                    ArrayList<MusicInfo> arrayList = (ArrayList) serializableExtra;
                                    if (arrayList.isEmpty()) {
                                        this.a.j1();
                                        this.a.a2("ACTION_CLOUD_MUSIC_DELETE_SUCCESS", "receiver");
                                    } else {
                                        FavListFragment favListFragment = this.a;
                                        boolean z = false;
                                        for (MusicInfo musicInfo : arrayList) {
                                            String strA = musicInfo.a();
                                            long jB = musicInfo.b();
                                            Object obj = null;
                                            if (jB > 0) {
                                                ArrayList<KGMusicWrapper> arrayListI = favListFragment.W1().i();
                                                j.d(arrayListI, "adapter.datas");
                                                Iterator<T> it = arrayListI.iterator();
                                                while (true) {
                                                    if (it.hasNext()) {
                                                        Object next = it.next();
                                                        KGMusicWrapper kGMusicWrapper2 = (KGMusicWrapper) next;
                                                        if (kGMusicWrapper2 != null && kGMusicWrapper2.getMixId() == jB) {
                                                            obj = next;
                                                        }
                                                    }
                                                }
                                                kGMusicWrapper = (KGMusicWrapper) obj;
                                            } else {
                                                ArrayList<KGMusicWrapper> arrayListI2 = favListFragment.W1().i();
                                                j.d(arrayListI2, "adapter.datas");
                                                Iterator<T> it2 = arrayListI2.iterator();
                                                while (true) {
                                                    if (it2.hasNext()) {
                                                        Object next2 = it2.next();
                                                        KGMusicWrapper kGMusicWrapper3 = (KGMusicWrapper) next2;
                                                        String str = "";
                                                        if (kGMusicWrapper3 != null && (hashValue = kGMusicWrapper3.getHashValue()) != null) {
                                                            str = hashValue;
                                                        }
                                                        String lowerCase2 = str.toLowerCase();
                                                        j.d(lowerCase2, "(this as java.lang.String).toLowerCase()");
                                                        if (strA == null) {
                                                            lowerCase = null;
                                                        } else {
                                                            lowerCase = strA.toLowerCase();
                                                            j.d(lowerCase, "(this as java.lang.String).toLowerCase()");
                                                        }
                                                        if (j.a(lowerCase2, lowerCase)) {
                                                            obj = next2;
                                                        }
                                                    }
                                                }
                                                kGMusicWrapper = (KGMusicWrapper) obj;
                                            }
                                            if (kGMusicWrapper != null) {
                                                favListFragment.W1().k(kGMusicWrapper);
                                                favListFragment.W1().notifyDataSetChanged();
                                                z = true;
                                            }
                                        }
                                        this.a.a2(j.l("ACTION_CLOUD_MUSIC_DELETE_SUCCESS, hasChanged = ", Boolean.valueOf(z)), "receiver");
                                        if (z) {
                                            if (this.a.W1().j() && this.a.X0()) {
                                                this.a.y1();
                                            } else if (this.a.W1().getCount() <= this.a.N.a(1)) {
                                                this.a.g1();
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                            break;
                        case 1125446651:
                            if (action.equals("com.kugou.android.mymusic.fav.cloudsycing")) {
                                q qVar = new q();
                                if (intent.hasExtra("KEY_FAV_CLOUD_SUCCESS")) {
                                    boolean booleanExtra = intent.getBooleanExtra("KEY_FAV_CLOUD_SUCCESS", true);
                                    if (this.a.K && !booleanExtra) {
                                        e.c.a.g.a.g.f.c.a.s("收藏页", "needForeceReloadData = " + this.a.K + ", isSuccess = " + booleanExtra);
                                        this.a.K = false;
                                        Observable.just(1).subscribeOn(Schedulers.io()).map(a.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this.a, qVar), c.a);
                                    } else if (booleanExtra) {
                                        this.a.r1(1);
                                        this.a.Z0(false);
                                        qVar.a = 1;
                                    } else {
                                        this.a.G1();
                                        qVar.a = 2;
                                    }
                                }
                                if (this.a.E0() == 1) {
                                    this.a.a2(j.l("ACTION_FAV_CLOUD_SYNCING, step = ", Integer.valueOf(qVar.a)), "receiver");
                                }
                                break;
                            }
                            break;
                    }
                }
            }
        };
        this.S = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.p0, 1) == 1;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void B0(boolean z, Throwable th, Integer num) {
        j.e(th, "throwable");
        super.B0(z, th, num);
        ApmReportHelper apmReportHelper = ApmReportHelper.INSTANCE;
        apmReportHelper.netFinishFavPageAPMLoadTime();
        String stackTraceString = Log.getStackTraceString(th);
        j.d(stackTraceString, "getStackTraceString(throwable)");
        apmReportHelper.failFavPageAPM(num, stackTraceString);
        if (g0.f()) {
            Log.e("mhs_watch", "NewSongListFragment handleDataBackFirst");
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public e.c.a.g.a.f.o.h.a<KGMusicWrapper> D0() {
        return W1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public String G0() {
        return "暂时没有内容哦";
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void G1() {
        super.G1();
        e.c.a.g.a.g.f.d.d("-1004", String.valueOf(E0()));
        if (e.c.a.g.a.d.d0.a.a) {
            e.c.a.g.a.d.d0.a.a("FavListFragment", j.l("showRefresh curPage = ", Integer.valueOf(E0())));
        }
        if (this.P || E0() != 1 || u0.n(KGApplication.getContext(), true)) {
            return;
        }
        e.c.a.g.a.d.d0.a.a("FavListFragment", "showRefresh 展示刷新的时候，检查网络是否正常");
        this.P = true;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public List<KGMusicWrapper> I0(boolean z, e.c.a.g.a.f.k.c<List<? extends KGMusicWrapper>> cVar) {
        j.e(cVar, "response");
        List<KGMusicWrapper> list = (List) cVar.a();
        return list == null ? f.u.m.d() : list;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void I1() {
        super.I1();
        ApmReportHelper.INSTANCE.uiFavPageAPMoadTime();
        if (g0.f()) {
            Log.e("mhs_watch", "NewSongListFragment hanlderListShow");
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void M0(e.c.a.g.a.f.k.c<List<? extends KGMusicWrapper>> cVar, boolean z) {
        j.e(cVar, "response");
        super.M0(cVar, z);
        Log.e("mhs_watch", "收藏数据 数据加载成功");
        ApmReportHelper.INSTANCE.favPageAPMSuccess(Y1(cVar));
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void N0(int i2) {
        super.N0(i2);
        if (i2 == 1) {
            ApmReportHelper.INSTANCE.netFinishFavPageAPMLoadTime();
            if (g0.f()) {
                Log.e("mhs_watch", "NewSongListFragment handleDataBackFirst");
            }
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void O0(boolean z, Throwable th) {
        j.e(th, "throwable");
        super.O0(z, th);
        e.c.a.g.a.g.f.d.d("-1002", E0() + ", e:" + ((Object) th.getMessage()));
        DelegateListFragment.C0(this, z, th, null, 4, null);
        if (e.c.a.g.a.d.d0.a.a) {
            e.c.a.g.a.d.d0.a.a("FavListFragment", "handleFailed (isLoadMore) = " + z + ", e = " + th);
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void P0(e.c.a.g.a.f.k.c<List<? extends KGMusicWrapper>> cVar, boolean z) {
        j.e(cVar, "response");
        super.P0(cVar, z);
        j0.b().a(new b(cVar.a(), this));
    }

    public final e.c.a.g.a.g.f.b W1() {
        return (e.c.a.g.a.g.f.b) this.L.getValue();
    }

    public final boolean X1() {
        return this.J;
    }

    public final String Y1(e.c.a.g.a.f.k.c<List<KGMusicWrapper>> cVar) throws JSONException {
        List<KGMusicWrapper> listA;
        String string;
        String str = "0";
        if (cVar != null && (listA = cVar.a()) != null && (string = Integer.valueOf(listA.size()).toString()) != null) {
            str = string;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("size", str);
        String string2 = jSONObject.toString();
        j.d(string2, "json.toString()");
        return string2;
    }

    public final boolean Z1() {
        return ((Boolean) this.O.getValue()).booleanValue();
    }

    public final void a2(String str, String str2) {
        if (!this.S) {
            if (g0.f()) {
                g0.c("mhs_watch", j.l("TYPE_FAV needReport = ", Boolean.valueOf(this.S)));
                return;
            }
            return;
        }
        e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setFo("/首页/收藏页面").setType("3").setSvar1(str).setSvar2(str2));
        e.c.a.g.a.d.d0.a.a("FavListFragment", "page /首页/收藏页面 1," + ((Object) str) + "2," + ((Object) str2));
    }

    public final void b2(KGRecyclerView kGRecyclerView) {
        kGRecyclerView.setOnItemClickListener(new g());
        kGRecyclerView.setOnItemLongClickListener(new h());
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public boolean c1() {
        return !this.K;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void f1(List<? extends KGMusicWrapper> list, boolean z) {
        j.e(list, "newAddedData");
        super.f1(list, z);
        if (X0() || !this.N.b(E0())) {
            return;
        }
        g1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public Observable<e.c.a.g.a.f.k.c<List<? extends KGMusicWrapper>>> o1(int i2) {
        String strJ = e.c.a.g.a.r.b.j();
        if (!TextUtils.isEmpty(strJ)) {
            Observable<e.c.a.g.a.f.k.c<List<? extends KGMusicWrapper>>> map = Observable.just(Integer.valueOf(i2)).subscribeOn(Schedulers.io()).map(new e(i2, this, strJ)).map(new f(i2, strJ));
            j.d(map, "override fun requestData(curPage: Int): Observable<CommonResponse<List<KGMusicWrapper>>> {\n        val favId = CommonEnvManager.getMyFavPlaylistId();\n        if (TextUtils.isEmpty(favId)) {\n            ListTrace.exposeListErr(ListTrace.ERR_1001, curPage.toString())\n            val res = CommonResponse<List<KGMusicWrapper>>()\n            res.isEnd = true\n            res.setStatus(1)\n\n            reportHead(\"requestData, favId = null\", \"requestData\")\n\n            return Observable.just(res)\n        }\n\n        return Observable.just(curPage)\n            .subscribeOn(Schedulers.io())\n            .map {\n                // 第一页重置数据\n                if (curPage == 1) {\n                    lastFileOrder = PlaylistDaoHelper.getMinFileOrderWeight(favId)\n                }\n                val start = lastFileOrder\n                val pageCount = pageLoadCtrl.getPageCountByPageNo(curPage)\n                val list = PlaylistDaoHelper.getPlaylistMusicsByPage(favId, start, pageCount)\n                if (!list.isNullOrEmpty()) {\n                    lastFileOrder = list.last().fileOrderWeight + 1\n                }\n                if (curPage <= 2) {\n                    reportHead(\"1 requestData, favId = \" + favId + \", curPage = \" + curPage + \", size = \" + list?.size + \", order = \" + lastFileOrder, \"requestData\")\n                }\n\n                if (KGLog.DEBUG) KGLog.d(TAG,\n                    \"requestData: curPage=$curPage size=${list?.size} order=$lastFileOrder\");\n                list\n            }\n            .map { list ->\n                val result = ArrayList<KGMusicWrapper>(ListUtil.getSize(list))\n                //补充完整KGMusic\n                if (!list.isNullOrEmpty()) {\n                    val mixIds = list.map { it.mixId }\n                    val musicMap = KGMusicDaoHelper\n                        .getKGMusicListByMixidList(mixIds)\n                        .toMap { it.mixId }\n\n                    val initiator = Initiator.create(pageKey).carryPagePath(pagePath)\n                    list.forEach { playlistMusic ->\n                        try {\n                            var music = musicMap[playlistMusic.mixId]\n\n                            if ((playlistMusic != null && playlistMusic.mixId == 0L || music == null) && playlistMusic.hash != null && playlistMusic.hash != \"\") {\n                                music = KGMusicDaoHelper.getKGMusicByHash(playlistMusic.hash!!)\n                            }\n                            var isFilterGradeSongLimit = ContentFilter.isFilterGradeSongLimit(music)\n                            if (music != null && isFilterGradeSongLimit) {\n                                Log.e(\"mhs_watch_grade_filter\", \"music:\" + music?.getDisplayName() + \", music.getMixId = \" + music?.getMixId())\n                            }\n\n                            if (music != null && !isFilterGradeSongLimit) {\n                                playlistMusic.mKgMusic = music\n                                val wrapper = KGDataConvertHelper.createKGMusicWrapper(\n                                    initiator, TraceSource.SOURCE_43, playlistMusic\n                                )\n                                result.add(wrapper)\n                                if (KGLog.isDebug() && playlistMusic != null) {\n                                    Log.e(\"mhs_watch_fav\", \"music: $music， playlistMusic.hash!! = \" + playlistMusic.hash!!)\n                                }\n                            } else {\n                                Log.e(\"mhs_watch_fav\", \"music: $music\")\n                            }\n                        } catch (e: Exception) {\n                            e.printStackTrace()\n                            Log.e(\"mhs_watch_fav2\", \"e = \" + e)\n                        }\n                    }\n                }\n\n                if (curPage <= 2) {\n                    reportHead(\"2 requestData, favId = \" + favId + \", result = \" + result?.size + \", list = \" + list?.size, \"requestData\")\n                }\n\n                val res = CommonResponse<List<KGMusicWrapper>>()\n                res.data = result\n                res.isEnd = ListUtil.isEmpty(list)\n                res.setStatus(1)\n                res\n            }\n    }");
            return map;
        }
        e.c.a.g.a.g.f.d.d("-1001", String.valueOf(i2));
        e.c.a.g.a.f.k.c cVar = new e.c.a.g.a.f.k.c();
        cVar.h(true);
        cVar.m(1);
        a2("requestData, favId = null", "requestData");
        Observable<e.c.a.g.a.f.k.c<List<? extends KGMusicWrapper>>> observableJust = Observable.just(cVar);
        j.d(observableJust, "just(res)");
        return observableJust;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_fav_list, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment, com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        i1.a(this.M);
        if (Z1()) {
            e.c.a.g.a.g.f.c.a.x(true ^ w.l.g());
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        e.c.a.g.a.f.d.a.g(this.R);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        KGRecyclerView kGRecyclerView = (KGRecyclerView) requireView().findViewById(R.id.content_detail);
        j.d(kGRecyclerView, "rv");
        b2(kGRecyclerView);
        DelegateListFragment.A0(this, kGRecyclerView, new LinearLayoutManager(getContext()), W1(), null, 8, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.kugou.android.mymusic.fav.cloudsycing");
        intentFilter.addAction("com.kugou.android.update_fav_btn_state");
        intentFilter.addAction("com.kugou.android.cloud_music_delete_success");
        intentFilter.addAction("com.kugou.android.cloud_playlist_updateed");
        e.c.a.g.a.f.d.a.b(this.R, intentFilter);
        e.c.a.g.a.r.a.h();
        ApmReportHelper.INSTANCE.startFavPageAPM();
        StringBuilder sb = new StringBuilder();
        sb.append("进入页面 fav, isEnableFavOptimize = ");
        sb.append(Z1());
        sb.append(", isCloudSyncing = ");
        w.a aVar = w.l;
        sb.append(aVar.g());
        a2(sb.toString(), "onCreated");
        if (this.Q) {
            ImageView imageView = (ImageView) view.findViewById(R.id.content_fav_sync_img);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        } else {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.content_fav_sync_img);
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        }
        ImageView imageView3 = (ImageView) view.findViewById(R.id.content_fav_sync_img);
        if (imageView3 != null) {
            imageView3.setOnClickListener(d.a);
        }
        if (!Z1()) {
            e.c.a.g.a.g.f.c.a.x(true);
            D1();
            return;
        }
        if (aVar.g()) {
            D1();
            if (e.c.a.g.a.d.d0.a.a) {
                e.c.a.g.a.d.d0.a.a("FavListFragment", j.l("onViewCreated isCloudSyncing = ", Boolean.valueOf(aVar.g())));
                return;
            }
            return;
        }
        e.c.a.g.a.g.f.c cVar = e.c.a.g.a.g.f.c.a;
        if (!cVar.e()) {
            j1();
            if (e.c.a.g.a.d.d0.a.a) {
                e.c.a.g.a.d.d0.a.a("FavListFragment", "onViewCreated onRefresh.");
                return;
            }
            return;
        }
        D1();
        this.K = true;
        cVar.w(aVar.a());
        if (e.c.a.g.a.d.d0.a.a) {
            e.c.a.g.a.d.d0.a.a("FavListFragment", "onViewCreated checkCountError.");
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void q1() {
        super.q1();
        e.c.a.g.a.e.b.b(new YoungBITask(20498, "click").setType("3"));
        if (e.c.a.g.a.d.d0.a.a) {
            e.c.a.g.a.d.d0.a.a("FavListFragment", "retry");
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "收藏";
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void y1() {
        super.y1();
        e.c.a.g.a.g.f.d.b(1, "0", "");
        if (e.c.a.g.a.d.d0.a.a) {
            e.c.a.g.a.d.d0.a.a("FavListFragment", "showEmpty");
        }
    }
}
