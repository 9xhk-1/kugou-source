package e.c.a.g.a.l;

import androidx.core.view.PointerIconCompat;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.newsong.NewSongList;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.w0;
import f.z.d.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public final String a = "NewSongPresenter";
    public final ArrayList<KGSong> b = new ArrayList<>();
    public e.c.a.g.a.l.c c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1103e;

    public static final class a implements Func1<String, List<KGSong>> {
        public final /* synthetic */ PageKey b;

        public a(PageKey pageKey) {
            this.b = pageKey;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<KGSong> call(String str) {
            j.e(str, "t");
            boolean z = true;
            if (Math.abs(System.currentTimeMillis() - e.c.a.g.a.f.m.c.a.c("NEW_SONG_PUBLISH_REFRESH_ELAPSED_REALTIME", 0L)) < w0.a(1)) {
                ArrayList arrayListH = d.this.h();
                if ((arrayListH == null ? 0 : arrayListH.size()) >= 3) {
                    if (g0.a) {
                        g0.e(d.this.a, j.l("使用文件缓存数据 size:", arrayListH != null ? Integer.valueOf(arrayListH.size()) : null));
                    }
                    return arrayListH;
                }
            } else {
                z = false;
            }
            ArrayList arrayListI = d.this.i(this.b);
            if ((arrayListI == null ? 0 : arrayListI.size()) >= 3) {
                if (g0.a) {
                    g0.e(d.this.a, j.l("使用网络数据 size:", arrayListI != null ? Integer.valueOf(arrayListI.size()) : null));
                }
                return arrayListI;
            }
            if (!z) {
                ArrayList arrayListH2 = d.this.h();
                if ((arrayListH2 != null ? arrayListH2.size() : 0) >= 3) {
                    if (g0.a) {
                        g0.e(d.this.a, j.l("网络数据不足，使用文件缓存数据 size:", arrayListH2 != null ? Integer.valueOf(arrayListH2.size()) : null));
                    }
                    return arrayListH2;
                }
            }
            return null;
        }
    }

    public static final class b<T, R> implements Func1 {
        public static final b<T, R> a = new b<>();

        public final List<KGSong> a(List<KGSong> list) {
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    ((KGSong) it.next()).X0 = PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW;
                }
            }
            return list;
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            List<KGSong> list = (List) obj;
            a(list);
            return list;
        }
    }

    public static final class c<T, R> implements Func1 {
        public c() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.f.k.c<NewSongList> call(List<KGSong> list) {
            if (list != null) {
                d dVar = d.this;
                if (list.size() >= 3) {
                    dVar.b.clear();
                    dVar.b.addAll(list);
                    Collections.shuffle(dVar.b);
                }
            }
            NewSongList newSongList = new NewSongList();
            newSongList.list = list;
            e.c.a.g.a.f.k.c<NewSongList> cVar = new e.c.a.g.a.f.k.c<>();
            cVar.g(newSongList);
            cVar.m(1);
            return cVar;
        }
    }

    public d() {
        double dRandom = Math.random();
        double d2 = 15;
        Double.isNaN(d2);
        this.f1102d = ((int) (dRandom * d2)) + 85;
        this.f1103e = 50;
    }

    public final void e(ArrayList<KGSong> arrayList) {
        if (arrayList.size() < 2) {
            return;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList2 = new ArrayList();
        for (KGSong kGSong : arrayList) {
            if (!linkedHashSet.contains(String.valueOf(kGSong.T1()))) {
                linkedHashSet.add(String.valueOf(kGSong.T1()));
                arrayList2.add(kGSong);
            } else if (g0.a) {
                g0.e(this.a, j.l("filterSongs 重复歌曲:", kGSong.A2()));
            }
        }
        arrayList.clear();
        arrayList.addAll(arrayList2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final e.c.a.g.a.l.c f() {
        /*
            r5 = this;
            long r0 = e.c.a.g.a.r.b.o()
            e.c.a.g.a.l.c r2 = r5.c
            r3 = 0
            if (r2 == 0) goto L16
            r4 = 1
            if (r2 != 0) goto Le
        Lc:
            r4 = 0
            goto L14
        Le:
            boolean r2 = r2.x(r0)
            if (r2 != r4) goto Lc
        L14:
            if (r4 == 0) goto L1d
        L16:
            e.c.a.g.a.l.c r2 = new e.c.a.g.a.l.c
            r2.<init>(r0, r3)
            r5.c = r2
        L1d:
            e.c.a.g.a.l.c r0 = r5.c
            f.z.d.j.c(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.l.d.f():e.c.a.g.a.l.c");
    }

    public final ArrayList<KGSong> g() {
        return this.b;
    }

    public final ArrayList<KGSong> h() {
        ArrayList<KGSong> arrayList = null;
        while (true) {
            if (arrayList != null && !arrayList.isEmpty() && arrayList.size() >= this.f1102d) {
                e(arrayList);
                int size = arrayList.size();
                int i2 = this.f1102d;
                if (size <= i2) {
                    return arrayList;
                }
                List<KGSong> listSubList = arrayList.subList(0, Math.min(i2, arrayList.size()));
                j.d(listSubList, "songs.subList(0, min(songMaxCount, songs.size))");
                ArrayList<KGSong> arrayList2 = new ArrayList<>();
                arrayList2.addAll(listSubList);
                return arrayList2;
            }
            if (arrayList != null) {
                if (arrayList.isEmpty()) {
                    if (g0.a) {
                        g0.b("lzm", "cache songs all duplicated, try next page");
                    }
                } else if (arrayList.size() < this.f1102d && g0.a) {
                    g0.b("lzm", "cache songs less than " + this.f1102d + ", add next page");
                }
            }
            ArrayList<KGSong> arrayListU = f().u();
            if (arrayListU == null) {
                return arrayList;
            }
            if (arrayList == null) {
                arrayList = arrayListU;
            } else {
                arrayList.addAll(arrayListU);
            }
        }
    }

    public final ArrayList<KGSong> i(PageKey pageKey) {
        ArrayList<KGSong> arrayList = new ArrayList<>();
        int i2 = 0;
        while (true) {
            if (arrayList.size() >= this.f1103e || i2 >= 3) {
                break;
            }
            if (g0.a) {
                g0.e(this.a, j.l("loadNewSongFromNet requestTimes:", Integer.valueOf(i2)));
            }
            int i3 = i2 + 1;
            try {
                e.c.a.g.a.l.b bVarH = new e(e.c.c.o.f.a(), "/首页/个性化推荐/新歌").h(0, e.c.a.g.a.f.m.d.e(0), arrayList.isEmpty() ? 0 : 1, "", 1, 0, pageKey);
                if (bVarH != null) {
                    e.k(bVarH.f());
                    e.j(bVarH.a());
                    ArrayList<KGSong> arrayListE = bVarH.e();
                    e.c.a.g.a.f.m.d.q(0);
                    e.c.a.g.a.f.m.d.o(System.currentTimeMillis());
                    e.c.a.g.a.f.m.d.r(0, bVarH.c());
                    e.c.a.g.a.f.m.d.n(arrayListE == null ? 0 : arrayListE.size());
                    if (g0.a) {
                        String str = this.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("loadNewSongFromNet requestTimes:");
                        sb.append(i3);
                        sb.append(" data size:");
                        sb.append(arrayListE == null ? null : Integer.valueOf(arrayListE.size()));
                        g0.e(str, sb.toString());
                    }
                    if (arrayListE != null && (arrayListE.isEmpty() ^ true)) {
                        arrayList.addAll(arrayListE);
                    }
                }
            } catch (Exception e2) {
                if (g0.a) {
                    e2.printStackTrace();
                }
            }
            i2 = i3;
        }
        e(arrayList);
        if (!arrayList.isEmpty()) {
            f().a(arrayList);
        }
        if (g0.a) {
            g0.e(this.a, "loadNewSongFromNet done:" + i2 + " allSongs size:" + arrayList.size());
        }
        return arrayList;
    }

    public final Observable<e.c.a.g.a.f.k.c<NewSongList>> j(PageKey pageKey) {
        j.e(pageKey, "pageKey");
        if (this.b.size() < 3) {
            Observable<e.c.a.g.a.f.k.c<NewSongList>> map = Observable.just("").subscribeOn(Schedulers.io()).map(new a(pageKey)).map(b.a).map(new c());
            j.d(map, "fun request(pageKey: PageKey) : Observable<CommonResponse<NewSongList?>> {\n        if (newSongData.size >= 3) {\n            // setup 1. 内存有数据直接使用\n            newSongData.shuffle()\n\n            if (KGLog.DEBUG) KGLog.i(logTag, \"使用内存缓存数据 size:${newSongData.size}\")\n            val list = NewSongList()\n            list.list = newSongData\n            val response = CommonResponse<NewSongList?>()\n            response.data = list\n            response.setStatus(1)\n            return Observable.just(response)\n        } else {\n            return Observable.just(\"\")\n                .subscribeOn(Schedulers.io())\n                .map(object : Func1<String, MutableList<KGSong>?>{\n                    override fun call(t: String): MutableList<KGSong>? {\n\n                        val currentTime = System.currentTimeMillis()\n                        val lastRequestTime = SettingPrefs.get(SettingPrefsKeys.NEW_SONG_PUBLISH_REFRESH_ELAPSED_REALTIME,0L)\n                        var loadCache = false\n\n                        // setup 2. 请求时间小于一天&有缓存数据 -> 使用文件缓存数据\n                        if (Math.abs(currentTime - lastRequestTime) < 1.dayMs()) {\n                            val cacheSong = loadCacheFromFile()\n                            loadCache = true\n                            if ((cacheSong?.size ?: 0) >= 3) {\n                                if (KGLog.DEBUG) KGLog.i(logTag, \"使用文件缓存数据 size:${cacheSong?.size}\")\n                                return cacheSong\n                            }\n                        }\n\n                        // setup 3. 请求网络数据\n                        val netData = loadNewSongFromNet(pageKey)\n                        if ((netData?.size ?: 0) >= 3) {\n                            if (KGLog.DEBUG) KGLog.i(logTag, \"使用网络数据 size:${netData?.size}\")\n                            return netData\n                        }\n\n//                    // setup 4. 最后还是使用文件缓存数据\n                        if (!loadCache) {\n                            val cacheSong = loadCacheFromFile()\n                            if ((cacheSong?.size ?: 0) >= 3) {\n                                if (KGLog.DEBUG) KGLog.i(logTag, \"网络数据不足，使用文件缓存数据 size:${cacheSong?.size}\")\n                                return cacheSong\n                            }\n                        }\n\n                        return null\n                    }\n                })\n                .map {\n                    it?.forEach { kgSong ->\n                        kgSong.musicLinkSource = MusicLinkSource.SOURCE_LIB_SONG\n                    }\n                    it\n                }\n                .map {\n                    it?.run {\n                        if (size >= 3) {\n                            newSongData.clear()\n                            newSongData.addAll(this)\n                            newSongData.shuffle()\n                        }\n                    }\n                    val list = NewSongList()\n                    list.list = it\n                    val response = CommonResponse<NewSongList?>()\n                    response.data = list\n                    response.setStatus(1)\n                    response\n                }\n        }\n    }");
            return map;
        }
        Collections.shuffle(this.b);
        if (g0.a) {
            g0.e(this.a, j.l("使用内存缓存数据 size:", Integer.valueOf(this.b.size())));
        }
        NewSongList newSongList = new NewSongList();
        newSongList.list = this.b;
        e.c.a.g.a.f.k.c cVar = new e.c.a.g.a.f.k.c();
        cVar.g(newSongList);
        cVar.m(1);
        Observable<e.c.a.g.a.f.k.c<NewSongList>> observableJust = Observable.just(cVar);
        j.d(observableJust, "just(response)");
        return observableJust;
    }
}
