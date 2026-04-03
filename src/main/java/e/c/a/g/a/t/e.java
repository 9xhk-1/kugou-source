package e.c.a.g.a.t;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.CExtraInfo;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.component.SplashActivity;
import com.kugou.android.watch.lite.component.player.NormalPlayerHolderFragment;
import com.kugou.android.watch.lite.component.search.SearchFragment;
import e.c.a.g.a.d.f.c.a.q;
import e.c.a.g.a.d.v.f;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;
import f.u.n;
import f.u.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import org.apache.http.HttpStatus;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final String b = "tips_play_status_key";
    public static final String c = "need_check_network_status";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f1235d = "last";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f1236e = "random";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Boolean f1238g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Subscription f1240i;
    public static boolean j;
    public static final e a = new e();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Handler f1237f = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f1239h = e.c.a.g.a.g.o.b.l();
    public static final String k = "XtcVoiceHelper";

    public interface a {
        void fail();

        void success(e.c.a.g.a.f.k.c<List<KGSong>> cVar);
    }

    public static final class b<T> implements Action1 {
        public static final b<T> a = new b<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(KGMusicWrapper kGMusicWrapper) {
            if (kGMusicWrapper != null) {
                ArrayList arrayList = new ArrayList();
                KGMusic kgmusic = kGMusicWrapper.getKgmusic();
                if (kgmusic != null) {
                    kgmusic.applyExtraInfo(CExtraInfo.addSource("211"));
                }
                arrayList.add(kGMusicWrapper);
                Log.e(e.k, f.z.d.j.l("插入到播放队列里 播放 Song Title: ", kGMusicWrapper.getDisplayName()));
                e.c.a.g.a.d.x.f.l(true, arrayList, true, e.a.k());
                return;
            }
            if (e.c.a.g.a.d.x.f.r()) {
                if (e.e(e.a, true, false, false, true, null, 16, null)) {
                }
            } else if (e.c.a.g.a.d.x.f.q()) {
                e.c.a.g.a.d.x.f.B();
            } else {
                e.c.a.g.a.d.x.f.x();
            }
        }
    }

    public static final class c<T> implements Action1 {
        public static final c<T> a = new c<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            if (th == null) {
                return;
            }
            th.printStackTrace();
        }
    }

    public static final class d<T> implements Observable.OnSubscribe {
        public static final d<T> a = new d<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Subscriber<? super KGMusicWrapper> subscriber) {
            f.z.d.j.e(subscriber, "emitter");
            try {
                boolean z = true;
                List<KGMusicWrapper> listJ = e.a.j(true);
                if (listJ != null && !listJ.isEmpty()) {
                    z = false;
                }
                subscriber.onNext(z ? null : listJ.get(0));
                subscriber.onCompleted();
            } catch (Exception e2) {
                subscriber.onError(e2);
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.t.e$e, reason: collision with other inner class name */
    public static final class RunnableC0198e implements Runnable {
        public static final RunnableC0198e a = new RunnableC0198e();

        @Override // java.lang.Runnable
        public final void run() {
            e.a.P();
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ int a;

        public f(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.R(e.a, this.a, 0, 2, null);
        }
    }

    public static final class g<T> implements Action1 {
        public final /* synthetic */ String a;
        public final /* synthetic */ a b;

        public g(String str, a aVar) {
            this.a = str;
            this.b = aVar;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<List<KGSong>> cVar) {
            f.z.d.j.e(cVar, "response");
            e eVar = e.a;
            e.j = false;
            e.c.a.g.a.e.b.b(new YoungBITask(22020022, "statistics").setKw1(this.a).setState(f.z.d.j.l("", Integer.valueOf(cVar.b()))).setSvar1("语音搜索播歌"));
            if (cVar.f() || !l0.g(cVar.a()) || TextUtils.isEmpty(cVar.c())) {
                eVar.u(this.b, cVar);
            } else {
                eVar.q(this.a, this.b, new Exception(cVar.c()));
            }
        }
    }

    public static final class h<T> implements Action1 {
        public final /* synthetic */ String a;
        public final /* synthetic */ a b;

        public h(String str, a aVar) {
            this.a = str;
            this.b = aVar;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            e.a.q(this.a, this.b, th);
            e.j = false;
            try {
                e.c.a.g.a.e.b.b(new YoungBITask(22020022, "statistics").setKw1(this.a).setState("101020").setSvar1("语音搜索播歌"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static final class i implements Runnable {
        public static final i a = new i();

        @Override // java.lang.Runnable
        public final void run() {
            e.c.a.g.a.d.x.f.s();
        }
    }

    public static final class j implements a {
        public final /* synthetic */ String a;

        public j(String str) {
            this.a = str;
        }

        @Override // e.c.a.g.a.t.e.a
        public void fail() {
            Log.d("mhs_watch", "loadSeachData fail");
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
        @Override // e.c.a.g.a.t.e.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void success(e.c.a.g.a.f.k.c<java.util.List<com.kugou.android.watch.lite.common.music.entity.KGSong>> r13) {
            /*
                Method dump skipped, instruction units count: 404
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.t.e.j.success(e.c.a.g.a.f.k.c):void");
        }
    }

    public static final class k implements Runnable {
        public static final k a = new k();

        @Override // java.lang.Runnable
        public final void run() {
            e.c.a.g.a.d.x.f.B();
        }
    }

    public static final class l<T, R> implements Func1 {
        public final /* synthetic */ String a;

        public l(String str) {
            this.a = str;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.g.o.g call(String str) {
            if (e.c.a.g.a.g.o.i.a.b().c(str)) {
                e.c.a.g.a.g.o.g gVar = new e.c.a.g.a.g.o.g();
                gVar.d(true);
                gVar.j(true);
                return gVar;
            }
            int configAsInt = e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.G1, 0);
            String str2 = this.a;
            e eVar = e.a;
            return e.c.a.g.a.g.o.f.d(str2, 1, eVar.o(), configAsInt, true, false, "", eVar.m());
        }
    }

    public static final class m<T, R> implements Func1 {
        public static final m<T, R> a = new m<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.f.k.c<List<KGSong>> call(e.c.a.g.a.g.o.g gVar) {
            e.c.a.g.a.f.k.c<List<KGSong>> cVar = new e.c.a.g.a.f.k.c<>();
            cVar.h(gVar.g());
            cVar.m(1);
            ArrayList<e.c.a.g.a.g.o.h> arrayListF = gVar.f();
            if (arrayListF != null) {
                ArrayList arrayList = new ArrayList(arrayListF.size());
                int i2 = 0;
                int size = arrayListF.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i3 = i2 + 1;
                        arrayList.add(arrayListF.get(i2).a());
                        if (i3 > size) {
                            break;
                        }
                        i2 = i3;
                    }
                }
                cVar.g(arrayList);
            }
            return cVar;
        }
    }

    public static /* synthetic */ void R(e eVar, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = RecyclerView.MAX_SCROLL_DURATION;
        }
        eVar.Q(i2, i3);
    }

    public static /* synthetic */ void U(e eVar, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = true;
        }
        eVar.T(i2, z);
    }

    public static /* synthetic */ boolean e(e eVar, boolean z, boolean z2, boolean z3, boolean z4, String str, int i2, Object obj) {
        boolean z5 = (i2 & 8) != 0 ? true : z4;
        if ((i2 & 16) != 0) {
            str = "0";
        }
        return eVar.d(z, z2, z3, z5, str);
    }

    public final void A(String str) {
        f.z.d.j.e(str, "query");
        B(str);
    }

    public final void B(String str) {
        f.z.d.j.e(str, "query");
        Log.e("mhs_watch", "1");
        if (u1.h(700) || TextUtils.isEmpty(str) || !e.c.a.g.a.d.l.a.e()) {
            return;
        }
        try {
            Log.e("mhs_watch", "needJumpSeachPageAndShowToastReal");
            Bundle bundle = new Bundle();
            bundle.putString("voice_search_text", str);
            if (e.c.a.g.a.d.v.c.b() instanceof SearchFragment) {
                EventBus.getDefault().post(new e.c.a.g.a.t.d(str));
            } else {
                s0.a.x(bundle);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void C() {
        if (e(this, true, false, false, true, null, 16, null)) {
            Log.e(k, "nextSongForService");
            e.c.a.g.a.g.j.g.a.a(11, e.c.a.g.a.d.x.f.e());
            u0.d(KGApplication.getContext(), i.a);
        }
    }

    public final void D() {
        String str = k;
        Log.d(str, "onPause");
        if (x() && c(true)) {
            if (!e.c.a.g.a.d.x.f.o()) {
                Log.e(str, "onPause , 播放器没有初始化，重新触发重试");
                return;
            }
            L();
            Log.e("mhs_watch", "暂停播放");
            e.c.a.g.a.e.b.b(new YoungBITask(22020022, "statistics").setSvar1("暂停当前歌曲"));
        }
    }

    public final void E() {
        String str = k;
        Log.d(str, "onPlay");
        if (x() && c(true)) {
            if (!e.c.a.g.a.d.x.f.o()) {
                Log.e(str, "onPlay , 播放器没有初始化，重新触发重试");
            } else {
                M();
                e.c.a.g.a.e.b.b(new YoungBITask(22020022, "statistics").setSvar1("播放当前歌曲"));
            }
        }
    }

    public final void F(String str, Bundle bundle) {
        f.z.d.j.e(bundle, NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE);
        String str2 = k;
        Log.d(str2, f.z.d.j.l("onPlayFromSearch, query = ", str));
        if (x()) {
            if (!g(str, bundle)) {
                Log.e(str2, "onPlayFromSearch, dataCanUsed is false.");
                return;
            }
            if (w(str, bundle)) {
                return;
            }
            Log.e(str2, "onPlayFromSearch, isForeProcess. KGApplication.isForeProcess() = " + KGApplication.isForeProcess() + ", Foreground.isForeground() = " + e.c.a.g.a.d.l.a.e());
            if (KGApplication.isForeProcess() && !e.c.a.g.a.d.l.a.e()) {
                e.c.a.g.a.t.c.c = new e.c.a.g.a.t.a(str, bundle);
                I();
                Log.e(str2, "onPlayFromSearch, 拉起app试一下.");
                return;
            }
            if (v(str, bundle)) {
                return;
            }
            boolean zE = e.c.a.g.a.f.m.c.a.e("sp_key_show_privacy", true);
            g0.c(str2, f.z.d.j.l("onPlayFromSearch, show = ", Boolean.valueOf(zE)));
            if (zE) {
                e.c.a.g.a.t.c.c = new e.c.a.g.a.t.a(str, bundle);
                if (g0.f()) {
                    Log.e(str2, "onPlayFromSearch, 请先同意隐私政策.");
                    return;
                }
                return;
            }
            if (!e.c.a.g.a.d.x.f.o()) {
                Log.e(str2, "loadSeachData , 播放器没有初始化，重新触发重试");
            } else {
                f.z.d.j.c(str);
                z(str, new j(str));
            }
        }
    }

    public final void G() {
        String str = k;
        Log.d(str, "onSkipToNext");
        if (x() && c(true)) {
            if (!e.c.a.g.a.d.x.f.o()) {
                Log.e(str, "onSkipToNext , 播放器没有初始化，重新触发重试");
                return;
            }
            EventBus.getDefault().post(new e.c.a.g.a.t.c(2));
            C();
            Log.e("mhs_watch", "播放下一首");
            e.c.a.g.a.e.b.b(new YoungBITask(22020022, "statistics").setSvar1("播放下一首"));
        }
    }

    public final void H() {
        String str = k;
        Log.d(str, "onSkipToPrevious");
        if (x() && c(true)) {
            if (!e.c.a.g.a.d.x.f.o()) {
                Log.e(str, "onSkipToPrevious , 播放器没有初始化，重新触发重试");
                return;
            }
            Log.e("mhs_watch", "播放上一首");
            EventBus.getDefault().post(new e.c.a.g.a.t.c(1));
            N();
            e.c.a.g.a.e.b.b(new YoungBITask(22020022, "statistics").setSvar1("播放上一首"));
        }
    }

    public final void I() {
        Intent intentA = s0.a.a(KGApplication.getContext(), SplashActivity.class);
        intentA.putExtra(c, true);
        KGApplication.getContext().startActivity(intentA);
        Log.e("mhs_watch", "打开app");
    }

    public final void J() {
        if (e.c.a.g.a.d.v.c.b() == null || e.c.a.g.a.d.v.c.b().g() == null || (e.c.a.g.a.d.v.c.b() instanceof NormalPlayerHolderFragment)) {
            return;
        }
        e.c.a.g.a.d.v.c.b().g().F0(true);
        Log.e("mhs_watch", "跳到播放器");
    }

    public final void K(String str) {
        f.z.d.j.e(str, "keyword");
        p1.h(KGApplication.getContext(), "歌曲加载失败");
        A(str);
    }

    public final void L() {
        if (e.c.a.g.a.d.x.f.q()) {
            Log.e(k, "pauseSong");
            V();
        }
    }

    public final void M() {
        if (e.c.a.g.a.d.x.f.q()) {
            return;
        }
        Log.e(k, "playSong");
        V();
    }

    public final void N() {
        if (e(this, true, false, false, true, null, 16, null)) {
            Log.e(k, "preSongForService");
            e.c.a.g.a.g.j.g.a.a(10, e.c.a.g.a.d.x.f.e());
            u0.d(KGApplication.getContext(), k.a);
        }
    }

    public final void O() {
        Log.e("mhs_watch_play", f.z.d.j.l("队里有多少 PlayerController.size() = ", Integer.valueOf(e.c.a.g.a.d.x.f.G())));
    }

    public final void P() {
        try {
            e.c.a.g.a.e.b.b(new YoungBITask(22020022, "statistics").setSvar1("听歌识曲"));
            e.c.a.g.a.e.b.b(new YoungBITask(HttpStatus.SC_MOVED_TEMPORARILY, "click").setType("1"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void Q(int i2, int i3) {
        try {
            if (i2 == 0) {
                e.c.a.g.a.e.b.b(new YoungBITask(22020022, "statistics").setSvar1("设置为顺序播放"));
            } else if (i2 == 1) {
                e.c.a.g.a.e.b.b(new YoungBITask(22020022, "statistics").setSvar1("设置为单曲循环"));
            } else if (i2 != 2) {
            } else {
                e.c.a.g.a.e.b.b(new YoungBITask(22020022, "statistics").setSvar1("设置为随机播放"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final Observable<e.c.a.g.a.f.k.c<List<KGSong>>> S(String str) {
        if (!TextUtils.isEmpty(str)) {
            Observable<e.c.a.g.a.f.k.c<List<KGSong>>> map = Observable.just(str).map(new l(str)).map(m.a);
            f.z.d.j.d(map, "keyword: String?): Observable<CommonResponse<List<KGSong>>> {\n        if (TextUtils.isEmpty(keyword)) {\n            val response = CommonResponse<List<KGSong>>()\n            response.isEnd = true\n            response.data = ArrayList()\n            response.setStatus(1)\n            return Observable.just(response)\n        }\n        return Observable.just(keyword)\n            .map(Func1 { s ->\n                if (KeywordMatcher.getInstance().isHit(s)) {\n                    val response = SearchSongResponse()\n                    response.isSuccess = true\n                    response.isEnd = true\n                    return@Func1 response\n                }\n                val type = KGConfigManager.instance.getConfigAsInt(\n                    KGConfigKeys.watch_content_search_song_type,\n                    0\n                )\n                SearchSongNewProtocol2.getSearchSongResponse(\n                    keyword, 1,\n                    getSourcePath(), type,\n                    true, false, \"\", pageKey\n                )\n            }).map { srcResp ->\n                val response = CommonResponse<List<KGSong>>()\n                response.isEnd = srcResp.isEnd\n                response.setStatus(1)\n                val srcList = srcResp.searchVersionSongInfo\n                if (srcList != null) {\n                    val songList = ArrayList<KGSong>(srcList.size)\n                    for (i in srcList.indices) {\n                        songList.add(srcList[i].netAudios)\n                    }\n                    response.data = songList\n                }\n                response\n            }");
            return map;
        }
        e.c.a.g.a.f.k.c cVar = new e.c.a.g.a.f.k.c();
        cVar.h(true);
        cVar.g(new ArrayList());
        cVar.m(1);
        Observable<e.c.a.g.a.f.k.c<List<KGSong>>> observableJust = Observable.just(cVar);
        f.z.d.j.d(observableJust, "just(response)");
        return observableJust;
    }

    public final void T(int i2, boolean z) {
        Log.e("mhs_watch_mode1", "sendChangeModeEvent: " + i2 + ", needShowEvent " + z);
        if (i2 == 0) {
            if (z) {
                EventBus.getDefault().post(new e.c.a.g.a.t.c(5));
            }
        } else if (i2 == 1) {
            if (z) {
                EventBus.getDefault().post(new e.c.a.g.a.t.c(6));
            }
        } else if (i2 == 2 && z) {
            EventBus.getDefault().post(new e.c.a.g.a.t.c(7));
        }
    }

    public final void V() {
        String str;
        String string;
        if (e(this, true, false, false, true, null, 16, null)) {
            if (e.c.a.g.a.d.x.f.q()) {
                e.c.a.g.a.d.x.f.t();
                str = "2";
            } else {
                e.c.a.g.a.d.x.f.x();
                str = "1";
            }
            Log.e("mhs_watch", "toggleSongForService");
            YoungBITask youngBITask = new YoungBITask(14, "click");
            KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
            String str2 = "";
            if (kGMusicWrapperE != null && (string = Long.valueOf(kGMusicWrapperE.getMixId()).toString()) != null) {
                str2 = string;
            }
            e.c.a.g.a.e.b.b(youngBITask.setMixsongid(str2).setType("1").setTab(str));
            Intent intent = new Intent("com.kugou.young.xtc.statusupdate");
            if ("2".equals(str)) {
                intent.putExtra(l(), 2);
            } else {
                intent.putExtra(l(), 3);
            }
            e.c.a.g.a.f.d.a.d(intent);
        }
    }

    public final boolean c(boolean z) {
        boolean zE = e.c.a.g.a.f.m.c.a.e("sp_key_show_privacy", true);
        if (!zE) {
            g0.c(k, "checkAndJumpApp, no jump");
            return true;
        }
        if (z) {
            e.c.a.g.a.t.c.j = "播放队列暂无歌曲，请添加后操作";
        }
        Log.e("mhs_watch", "跳到同意页面，请添加后操作");
        I();
        g0.c(k, "checkAndJumpApp, show = " + zE + "，跳同意页面");
        return false;
    }

    public final boolean d(boolean z, boolean z2, boolean z3, boolean z4, String str) {
        f.z.d.j.e(str, "loginSource");
        if (z4 && u1.h(700)) {
            return false;
        }
        if (z && e.c.a.g.a.d.x.f.r()) {
            if (!KGApplication.isForeProcess() || e.c.a.g.a.d.l.a.e()) {
                p1.h(KGApplication.getContext(), "播放队列暂无歌曲，请添加后操作");
                Log.e("mhs_watch", "播放队列暂无歌曲，请添加后操作");
            } else {
                e.c.a.g.a.t.c.j = "播放队列暂无歌曲，请添加后操作";
                Log.e("mhs_watch", "播放队列暂无歌曲，请添加后操作");
                I();
            }
            return false;
        }
        if (z2 && f(str)) {
            Log.e("mhs_watch", "2");
            return false;
        }
        if (!z3 || u0.m(KGApplication.getContext())) {
            return true;
        }
        Log.e("mhs_watch", "3");
        return false;
    }

    public final boolean f(String str) {
        if (e.c.a.g.a.r.b.F()) {
            return false;
        }
        s0.a.l(str);
        return true;
    }

    public final boolean g(String str, Bundle bundle) {
        f.z.d.j.e(bundle, NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE);
        String string = bundle.getString("name", "");
        Log.d(k, "onPlayFromSearch,handlerOtherOrder  query = " + ((Object) str) + ", name = " + ((Object) string));
        return f1235d.equals(string) || f1236e.equals(string) || !TextUtils.isEmpty(str);
    }

    public final boolean h(KGSong kGSong) {
        if (kGSong != null) {
            kGSong.T1();
            if (kGSong.T1() != 0) {
                try {
                    if (e.c.a.g.a.d.x.f.o() && !e.c.a.g.a.d.x.f.q() && e.c.a.g.a.d.x.f.e() != null) {
                        KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
                        if ((kGMusicWrapperE != null && kGMusicWrapperE.getMixId() == kGSong.T1()) && kGSong.T1() != 0) {
                            e.c.a.g.a.d.x.f.x();
                            Log.e("mhs_watch_error", "fristSongCheckIsCurrentOnPlayerPause, play");
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                Log.e("mhs_watch_error", "fristSongCheckIsCurrentOnPlayerPause, step 2 return false");
                return false;
            }
        }
        Log.e("mhs_watch_error", "fristSongCheckIsCurrentOnPlayerPause, return false");
        return false;
    }

    public final KGSong i(List<? extends KGSong> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (!e.c.a.g.a.f.a.s()) {
            return list.get(0);
        }
        Iterator<? extends KGSong> it = list.iterator();
        while (it.hasNext()) {
            KGSong next = it.next();
            if (next != null && (!e.c.a.g.a.f.j.c.d.d(next) || next.H1() != null)) {
                return next;
            }
        }
        return list.get(0);
    }

    public final List<KGMusicWrapper> j(boolean z) {
        int i2;
        ArrayList arrayList = new ArrayList();
        try {
            e.c.a.g.a.g.m.b bVar = e.c.a.g.a.g.m.b.a;
            if (bVar.f()) {
                int iD = bVar.d();
                long jCurrentTimeMillis = System.currentTimeMillis();
                Initiator initiatorCarryPagePath = Initiator.create(m()).carryPagePath(n());
                for (int i3 = 0; i3 < iD; i3 = i2) {
                    List<q> listE = e.c.a.g.a.g.m.b.a.e(jCurrentTimeMillis, 20);
                    boolean z2 = true;
                    if (listE == null || listE.isEmpty()) {
                        break;
                    }
                    int size = i3 + listE.size();
                    long jB = ((q) u.D(listE)).b();
                    KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
                    Long lValueOf = kGMusicWrapperE == null ? null : Long.valueOf(kGMusicWrapperE.getMixId());
                    ArrayList<KGMusicWrapper> arrayList2 = new ArrayList(l0.e(listE));
                    if (listE != null && !listE.isEmpty()) {
                        z2 = false;
                    }
                    if (z2) {
                        i2 = size;
                    } else {
                        ArrayList arrayList3 = new ArrayList(n.j(listE, 10));
                        Iterator<T> it = listE.iterator();
                        while (it.hasNext()) {
                            arrayList3.add(Long.valueOf(((q) it.next()).c()));
                        }
                        List<KGMusic> listQ = e.c.a.g.a.g.k.a.a.q(arrayList3);
                        LinkedHashMap linkedHashMap = new LinkedHashMap(listQ.size());
                        for (Object obj : listQ) {
                            linkedHashMap.put(Long.valueOf(((KGMusic) obj).mixId), obj);
                            size = size;
                        }
                        i2 = size;
                        for (q qVar : listE) {
                            long jC = qVar.c();
                            if (lValueOf == null || jC != lValueOf.longValue()) {
                                KGMusic kGMusicL = (KGMusic) linkedHashMap.get(Long.valueOf(qVar.c()));
                                if (kGMusicL == null && !f.z.d.j.a(qVar.a(), "")) {
                                    kGMusicL = e.c.a.g.a.g.k.a.a.l(qVar.a());
                                }
                                if (kGMusicL != null) {
                                    KGMusicWrapper kGMusicWrapperA = e.c.a.g.a.f.j.a.c.a(initiatorCarryPagePath, "211", kGMusicL);
                                    f.z.d.j.d(kGMusicWrapperA, "createKGMusicWrapper(\n                                        initiator,\n                                        TraceSource.SOURCE_211, // TODO: 重新确认下这个逻辑\n                                        music\n                                    )");
                                    arrayList2.add(kGMusicWrapperA);
                                }
                            }
                        }
                    }
                    if (f1239h) {
                        for (KGMusicWrapper kGMusicWrapper : arrayList2) {
                            if (kGMusicWrapper != null && !e.c.a.g.a.g.o.b.f(kGMusicWrapper.getKgmusic())) {
                                arrayList.add(kGMusicWrapper);
                                KGMusicWrapper kGMusicWrapperE2 = e.c.a.g.a.d.x.f.e();
                                String str = k;
                                Log.e(str, f.z.d.j.l("当前正在播放 播放 Song Title: ", kGMusicWrapperE2 == null ? null : kGMusicWrapperE2.getDisplayName()));
                                Log.e(str, f.z.d.j.l("下一首 播放 Song Title: ", kGMusicWrapper.getDisplayName()));
                                if (z) {
                                    break;
                                }
                            }
                        }
                    }
                    if (z) {
                        if (!arrayList.isEmpty()) {
                            return arrayList;
                        }
                    } else if (arrayList.size() >= 20) {
                        return arrayList;
                    }
                    jCurrentTimeMillis = jB;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e(k, f.z.d.j.l("getHistoryPlayeMusics e = ", e2));
        }
        Log.e(k, f.z.d.j.l("getHistoryPlayeMusics targetMusics size = ", Integer.valueOf(arrayList.size())));
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d A[Catch: Exception -> 0x0046, TRY_LEAVE, TryCatch #1 {Exception -> 0x0046, blocks: (B:15:0x0039, B:17:0x003d), top: B:29:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0010 A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:4:0x000c, B:6:0x0010, B:8:0x0016, B:10:0x0020), top: B:27:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final e.c.a.g.a.d.r.e k() {
        /*
            r4 = this;
            e.c.a.g.a.d.j.a r0 = e.c.a.g.a.d.j.a.e()
            android.app.Activity r0 = r0.c()
            java.lang.String r1 = "mhs_watch"
            if (r0 == 0) goto L10
            boolean r2 = r0 instanceof com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity     // Catch: java.lang.Exception -> L2d
            if (r2 != 0) goto L37
        L10:
            com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment r2 = e.c.a.g.a.d.v.c.b()     // Catch: java.lang.Exception -> L2d
            if (r2 == 0) goto L37
            com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment r2 = e.c.a.g.a.d.v.c.b()     // Catch: java.lang.Exception -> L2d
            e.c.a.g.a.d.r.e r2 = r2.l()     // Catch: java.lang.Exception -> L2d
            if (r2 == 0) goto L37
            com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment r2 = e.c.a.g.a.d.v.c.b()     // Catch: java.lang.Exception -> L2d
            e.c.a.g.a.d.r.e r2 = r2.l()     // Catch: java.lang.Exception -> L2d
            android.app.Activity r0 = r2.getActivity()     // Catch: java.lang.Exception -> L2d
            goto L37
        L2d:
            r2 = move-exception
            java.lang.String r3 = "1 getMusicFeesDelegate e = "
            java.lang.String r2 = f.z.d.j.l(r3, r2)
            android.util.Log.d(r1, r2)
        L37:
            if (r0 == 0) goto L3d
            boolean r2 = r0 instanceof com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity     // Catch: java.lang.Exception -> L46
            if (r2 != 0) goto L50
        L3d:
            e.c.a.g.a.d.j.a r2 = e.c.a.g.a.d.j.a.e()     // Catch: java.lang.Exception -> L46
            com.kugou.android.watch.lite.component.MainActivity r0 = r2.d()     // Catch: java.lang.Exception -> L46
            goto L50
        L46:
            r2 = move-exception
            java.lang.String r3 = "2 getMusicFeesDelegate e = "
            java.lang.String r2 = f.z.d.j.l(r3, r2)
            android.util.Log.d(r1, r2)
        L50:
            java.lang.String r2 = "getMusicFeesDelegate = 3"
            android.util.Log.d(r1, r2)
            boolean r2 = r0 instanceof com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity
            if (r2 == 0) goto L63
            e.c.a.g.a.d.r.c r1 = e.c.a.g.a.d.r.c.v()
            com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity r0 = (com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity) r0
            r1.attachActivity(r0)
            return r1
        L63:
            java.lang.String r0 = "getMusicFeesDelegate = 4 null"
            android.util.Log.d(r1, r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.t.e.k():e.c.a.g.a.d.r.e");
    }

    public String l() {
        return b;
    }

    public final PageKey m() {
        return new PageKey(o(), 823673777, "", "/手表语音助手/搜索");
    }

    public final String n() {
        return "xtc-voice";
    }

    public String o() {
        f.a aVarA = e.c.a.g.a.d.v.f.a();
        aVarA.a("手表");
        aVarA.a("语音搜索");
        return aVarA.b();
    }

    public final void p(String str) {
        f.z.d.j.e(str, "keyword");
        p1.h(KGApplication.getContext(), "暂无此歌曲");
        A(str);
    }

    public final void q(String str, a aVar, Throwable th) {
        f.z.d.j.e(str, "keyword");
        p1.h(KGApplication.getContext(), e.c.a.g.a.f.k.k.f.b(th, "加载失败"));
        if (aVar != null) {
            aVar.fail();
        }
        A(str);
    }

    public final void r(boolean z) {
        Observable observableCreate = Observable.create(d.a);
        f.z.d.j.d(observableCreate, "create<KGMusicWrapper?> { emitter: Subscriber<in KGMusicWrapper?> ->\n                try {\n                    // 在这里执行查找操作\n                    val results = getHistoryPlayeMusics(true)\n                    var music :KGMusicWrapper? = null\n                    if (!results.isNullOrEmpty()) {\n                        music = results.get(0)\n                    }\n                    emitter.onNext(music) // 发射结果\n                    emitter.onCompleted() // 完成\n                } catch (e: java.lang.Exception) {\n                    emitter.onError(e) // 如果发生错误，发射错误\n                }\n            }");
        observableCreate.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Action1) b.a, c.a);
    }

    public final void s() {
        String str = k;
        Log.d(str, "Handling recognize_music action");
        if (x()) {
            if (KGApplication.isForeProcess() && !e.c.a.g.a.d.l.a.e()) {
                e.c.a.g.a.t.c.f1229d = true;
                I();
                if (g0.f()) {
                    Log.e(str, "听歌识曲, 拉起app试一下.");
                }
                f1237f.postDelayed(RunnableC0198e.a, 3000L);
                return;
            }
            if (e.c.a.g.a.f.m.c.a.e("sp_key_show_privacy", true)) {
                e.c.a.g.a.t.c.f1229d = true;
                Log.e(str, "onPlayFromSearch, 听歌识曲 请先同意隐私政策.");
                return;
            }
            Log.e("mhs_watch", "跳到识别页面");
            Bundle bundle = new Bundle();
            bundle.putBoolean("startIdentify", true);
            s0.a.c(bundle);
            P();
        }
    }

    public final void t(int i2) {
        String str = k;
        Log.d(str, "Handling setting loop mode action");
        if (x()) {
            if (KGApplication.isForeProcess() && !e.c.a.g.a.d.l.a.e()) {
                e.c.a.g.a.t.c.f1231f = new Pair<>(Boolean.TRUE, Integer.valueOf(i2));
                I();
                Log.e(str, "handleSettingLoopMode, 设置模式, 拉起app试一下.");
                f1237f.postDelayed(new f(i2), 3000L);
                return;
            }
            boolean z = e.c.a.g.a.d.v.c.b() instanceof NormalPlayerHolderFragment;
            if (e.c.a.g.a.d.v.c.a() != null && e.c.a.g.a.d.v.c.a().a != null) {
                AbsFrameworkFragment[] absFrameworkFragmentArr = e.c.a.g.a.d.v.c.a().a;
                f.z.d.j.d(absFrameworkFragmentArr, "genFragmentStackInfo().mFragments");
                int length = absFrameworkFragmentArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    AbsFrameworkFragment absFrameworkFragment = absFrameworkFragmentArr[i3];
                    i3++;
                    if (absFrameworkFragment instanceof NormalPlayerHolderFragment) {
                        z = true;
                        break;
                    }
                }
            }
            Log.e(k, "handleSettingLoopMode, containPlayerFragment = " + z + ", VoiceCmdEvent.sHasShowPlayerPage = " + e.c.a.g.a.t.c.f1232g);
            if (z || e.c.a.g.a.t.c.f1232g) {
                U(this, i2, false, 2, null);
            } else {
                try {
                    J();
                    e.c.a.g.a.t.c.f1233h = new Pair<>(Boolean.TRUE, Integer.valueOf(i2));
                    U(this, i2, false, 2, null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            R(this, i2, 0, 2, null);
        }
    }

    public final void u(a aVar, e.c.a.g.a.f.k.c<List<KGSong>> cVar) {
        if (aVar == null) {
            return;
        }
        aVar.success(cVar);
    }

    public final boolean v(String str, Bundle bundle) {
        f.z.d.j.e(bundle, NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE);
        String string = bundle.getString("name", "");
        String str2 = k;
        Log.d(str2, "onPlayFromSearch,handlerOtherOrder  query = " + ((Object) str) + ", name = " + ((Object) string));
        if (!f1235d.equals(string)) {
            return false;
        }
        if (!c(true)) {
            return true;
        }
        if (!e.c.a.g.a.d.x.f.o()) {
            Log.e(str2, "onPause , 播放器没有初始化，重新触发重试");
            return true;
        }
        r(true);
        e.c.a.g.a.e.b.b(new YoungBITask(22020022, "statistics").setSvar1("播放历史上一首"));
        return true;
    }

    public final boolean w(String str, Bundle bundle) {
        f.z.d.j.e(bundle, NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE);
        String string = bundle.getString("name", "");
        String str2 = k;
        Log.d(str2, "onPlayFromSearch,handlerOtherOrder  query = " + ((Object) str) + ", name = " + ((Object) string));
        if (!f1236e.equals(string)) {
            return false;
        }
        if (!c(true)) {
            return true;
        }
        if (!e.c.a.g.a.d.x.f.o()) {
            Log.e(str2, "onPause , 播放器没有初始化，重新触发重试");
            return true;
        }
        e.c.a.g.a.e.b.b(new YoungBITask(22020022, "statistics").setSvar1("随机播放一首歌"));
        if (!e.c.a.g.a.d.x.f.r()) {
            e.c.a.g.a.d.x.f.C();
        } else if (!e(this, true, false, false, true, null, 16, null)) {
            return true;
        }
        return true;
    }

    public final boolean x() {
        Log.e("mhs_watch", f.z.d.j.l("开始读取 语音助手开关 isEnableVoice:", f1238g));
        if (!l1.m0()) {
            return false;
        }
        Boolean bool = f1238g;
        if (bool != null) {
            Log.e("mhs_watch", f.z.d.j.l("返回elese isEnableVoice: ", bool));
            return f.z.d.j.a(f1238g, Boolean.TRUE);
        }
        Boolean boolValueOf = Boolean.valueOf(e.c.a.g.a.f.m.d.a());
        f1238g = boolValueOf;
        Log.e("mhs_watch", f.z.d.j.l("结束 语音助手开关 isEnableVoice: ", boolValueOf));
        return f.z.d.j.a(f1238g, Boolean.TRUE);
    }

    public final boolean y() {
        Object systemService = KGApplication.getApplication().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) systemService).getRunningServices(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).iterator();
        while (it.hasNext()) {
            if (f.z.d.j.a("com.kugou.android.watch.lite.service.MediaService", it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public final void z(String str, a aVar) {
        f.z.d.j.e(str, "keyword");
        if (!j && u0.n(KGApplication.getContext(), false)) {
            j = true;
            i1.a(f1240i);
            f1240i = S(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(str, aVar), new h(str, aVar));
        }
    }
}
