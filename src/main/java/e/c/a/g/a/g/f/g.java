package e.c.a.g.a.g.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.component.fav.MusicInfo;
import e.c.a.g.a.d.f.c.a.j;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.j0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public volatile HashMap<MusicInfo, Boolean> a = new HashMap<>();
    public volatile boolean b = false;
    public final SparseBooleanArray c = new SparseBooleanArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f775e;

    public class a implements Func1<Object, Object> {
        public a(g gVar) {
        }

        @Override // rx.functions.Func1
        public Object call(Object obj) {
            return null;
        }
    }

    public class b implements Runnable {
        public b(g gVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ PageKey b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ KGMusic f776d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f777f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ e.c.a.g.a.d.r.e f778h;

        public c(int i2, PageKey pageKey, KGMusic kGMusic, String str, e.c.a.g.a.d.r.e eVar) {
            this.a = i2;
            this.b = pageKey;
            this.f776d = kGMusic;
            this.f777f = str;
            this.f778h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVarJ = g.j();
            if (jVarJ != null) {
                g.this.g(this.a, this.b, this.f776d, jVarJ, this.f777f, this.f778h);
            } else {
                g.this.f774d = new f(this.a, this.b, this.f776d, this.f777f, this.f778h);
            }
        }
    }

    public static class d {
        public static g a = new g();
    }

    public class e extends BroadcastReceiver {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.this;
                gVar.g(gVar.f774d.d(), g.this.f774d.e(), g.this.f774d.b(), g.j(), g.this.f774d.a(), g.this.f774d.c());
                g.this.f774d = null;
            }
        }

        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (g0.a) {
                g0.b("MyFavUtils", "action:  " + action);
            }
            if ("com.kugou.android.user_login_out".equals(action)) {
                g.this.c.clear();
                g.this.m();
                return;
            }
            if ("com.kugou.android.user_login_success".equals(action)) {
                g.this.c.clear();
                g.this.m();
                g.this.b = true;
                return;
            }
            if ("android.intent.action.cloudmusic.success".equals(action)) {
                return;
            }
            if (!"com.kugou.android.cloud_music_delete_success".equals(action)) {
                if (!"com.kugou.android.mymusic.fav.list_id_done".equals(action) || g.this.f774d == null) {
                    return;
                }
                j0.b().a(new a());
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra("del_cloud_music_info");
            if (serializableExtra != null) {
                ArrayList<MusicInfo> arrayList = (ArrayList) serializableExtra;
                if (arrayList.isEmpty()) {
                    return;
                }
                g.this.s(false, arrayList);
            }
        }

        public /* synthetic */ e(g gVar, a aVar) {
            this();
        }
    }

    public g() {
        new HashMap();
        this.f775e = new b(this);
        o();
        m();
    }

    public static j j() {
        if (TextUtils.isEmpty(e.c.a.g.a.r.b.j())) {
            return null;
        }
        return e.c.a.g.a.g.k.b.a.h(e.c.a.g.a.r.b.j(), true);
    }

    public static g k() {
        return d.a;
    }

    public static ArrayList<MusicInfo> l(List<? extends KGMusic> list) {
        ArrayList<MusicInfo> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (KGMusic kGMusic : list) {
                if (kGMusic != null) {
                    arrayList.add(new MusicInfo(kGMusic.getMixId(), kGMusic.getHashValue()));
                }
            }
        }
        return arrayList;
    }

    public static boolean p(String str, long j) {
        boolean z = false;
        if (TextUtils.isEmpty(str) && j <= 0) {
            return false;
        }
        j jVarJ = j();
        if (jVarJ != null && !TextUtils.isEmpty(e.c.a.g.a.g.k.b.a.l(jVarJ.d(), j))) {
            z = true;
        }
        if (g0.a) {
            g0.c("MyFavUtils", "isMyFav: hash" + str + ", mixId: " + j + ", isExist: " + z);
        }
        return z;
    }

    public static boolean r(String str, long j) {
        if (k().q(j, str, "")) {
            return true;
        }
        return p(str, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(int r20, com.kugou.android.watch.lite.base.uistructure.PageKey r21, com.kugou.android.watch.lite.common.music.entity.KGMusic r22, e.c.a.g.a.d.f.c.a.j r23, java.lang.String r24, e.c.a.g.a.d.r.e r25) {
        /*
            Method dump skipped, instruction units count: 636
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.g.f.g.g(int, com.kugou.android.watch.lite.base.uistructure.PageKey, com.kugou.android.watch.lite.common.music.entity.KGMusic, e.c.a.g.a.d.f.c.a.j, java.lang.String, e.c.a.g.a.d.r.e):void");
    }

    public void h(int i2, PageKey pageKey, KGMusic kGMusic, String str, e.c.a.g.a.d.r.e eVar) {
        j0.b().a(new c(i2, pageKey, kGMusic, str, eVar));
    }

    public void i(long j) {
        if (j > 0) {
            Observable.just(null).delay(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).map(new a(this)).subscribe(i1.a, i1.b);
        }
    }

    public final void m() {
        n(false);
    }

    public final void n(boolean z) {
        if (g0.a) {
            g0.b("MyFavUtils", "getMyFavCache(): updateByBroadCast: " + z + ", lastBroadCastIsLOGINSUCCESS: " + this.b);
        }
        if (!z) {
            j0.b().a(this.f775e);
        } else if (this.b) {
            this.b = false;
            j0.b().a(this.f775e);
        }
    }

    public final void o() {
        e eVar = new e(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.kugou.android.user_login_out");
        intentFilter.addAction("com.kugou.android.user_login_success");
        intentFilter.addAction("android.intent.action.cloudmusic.success");
        intentFilter.addAction("com.kugou.android.cloud_music_delete_success");
        intentFilter.addAction("com.kugou.android.mymusic.fav.list_id_done");
        e.c.a.g.a.f.d.a.b(eVar, intentFilter);
    }

    public boolean q(long j, String str, String str2) {
        boolean z = this.a != null && this.a.containsKey(new MusicInfo(j, str));
        if (g0.a) {
            g0.c("MyFavUtils", "isMyFavWithCache: hash: " + str + ", mixId: " + j + ", name: " + str2 + ", isExist: " + z + ", favHashMaps: " + this.a.size());
        }
        return z;
    }

    public void s(boolean z, ArrayList<MusicInfo> arrayList) {
        boolean zF = e.c.a.g.a.r.b.F();
        if (!zF) {
            if (g0.a) {
                g0.c("MyFavUtils", "updateMyFavHashMapsCache(): login: " + zF);
                return;
            }
            return;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (MusicInfo musicInfo : arrayList) {
            if (z) {
                this.a.put(musicInfo, Boolean.TRUE);
            } else {
                this.a.remove(musicInfo);
            }
            if (g0.a) {
                g0.c("MyFavUtils", "updateMyFavHashMapsCache(): add: " + z + ", hash: " + musicInfo.a() + ", mixId: " + musicInfo.b() + ", favHashMaps: " + this.a.size() + ", login: --true");
            }
        }
    }
}
