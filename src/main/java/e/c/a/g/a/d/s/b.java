package e.c.a.g.a.d.s;

import android.content.Intent;
import com.kugou.android.watch.lite.base.myassets.protocol.GetGoodsByVerProtocol;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import e.c.a.g.a.f.j.b.m;
import e.c.a.g.a.s.g0;
import f.z.d.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b a = new b();
    public static Executor b;

    public static final class a<T, R> implements Func1 {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<KGSong> call(GetGoodsByVerProtocol.GoodsSongResponse goodsSongResponse) {
            ArrayList<KGSong> arrayList = new ArrayList();
            if (goodsSongResponse != null) {
                String str = this.a;
                String str2 = this.b;
                if ("525".equals(str)) {
                    e.c.a.g.a.f.m.b.m().V(true);
                }
                b bVar = b.a;
                List<e.c.a.g.a.d.r.p.a.g> listK = bVar.k(goodsSongResponse);
                h.i().c(bVar.j(goodsSongResponse));
                if (!listK.isEmpty()) {
                    e.c.a.g.a.d.r.p.a.h hVar = new e.c.a.g.a.d.r.p.a.h();
                    hVar.b = "audio";
                    hVar.a = "special_local_query";
                    e.c.a.g.a.d.r.p.a.a aVarF = new e.c.a.g.a.d.r.p.b.e().f(hVar, "download", 1, listK, 0);
                    if (aVarF != null && aVarF.f() == 1) {
                        m.c(listK, aVarF.d());
                        ArrayList<KGSong> arrayListR = e.c.a.g.a.d.r.g.R(aVarF.d(), str2, 1);
                        j.d(arrayListR, "translateGoodsToKGSongs(musicsresult.goods, source, 1)");
                        arrayList.addAll(arrayListR);
                        List<e.c.a.g.a.d.r.p.a.c> listD = aVarF.d();
                        j.d(listD, "musicsresult.goods");
                        bVar.e(listD, arrayList);
                        if (arrayList.size() > 0) {
                            for (KGSong kGSong : arrayList) {
                                kGSong.R3("my_asset");
                                kGSong.u4(19);
                                kGSong.W3(e.c.a.g.a.f.j.a.d.b);
                                kGSong.X0 = 1044;
                            }
                            h.i().d(arrayList);
                            int size = arrayList.size();
                            j.c(listK);
                            if (size == listK.size()) {
                                int size2 = listK.size();
                                int i2 = 0;
                                if (size2 > 0) {
                                    while (true) {
                                        int i3 = i2 + 1;
                                        if (i3 >= size2) {
                                            break;
                                        }
                                        i2 = i3;
                                    }
                                }
                            }
                        }
                    }
                }
                b.a.c(goodsSongResponse);
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.s.b$b, reason: collision with other inner class name */
    public static final class C0078b<T> implements Action1 {
        public static final C0078b<T> a = new C0078b<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(List<KGSong> list) {
            j.d(list, "it");
            if (!list.isEmpty()) {
                e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.bought_musics_update"));
            }
        }
    }

    public static final class c<T> implements Action1 {
        public static final c<T> a = new c<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(List<KGSong> list) {
        }
    }

    public static final class d<T> implements Action1 {
        public static final d<T> a = new d<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            g0.k(th);
        }
    }

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        j.d(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        b = executorServiceNewSingleThreadExecutor;
    }

    public final void c(GetGoodsByVerProtocol.GoodsSongResponse goodsSongResponse) {
        HashSet<Long> hashSet = new HashSet<>();
        HashSet<Long> hashSet2 = new HashSet<>();
        for (GetGoodsByVerProtocol.Good good : goodsSongResponse.getData().getGoods()) {
            if (good.getStatus() == 2) {
                if ("audio".equals(good.getType())) {
                    hashSet.add(Long.valueOf(good.getId()));
                } else if ("album".equals(good.getType())) {
                    hashSet2.add(Long.valueOf(good.getId()));
                }
            }
        }
        h.i().h(hashSet);
        h.i().g(hashSet2);
    }

    public final void d(String str, String str2) {
        j.e(str, "source");
        j.e(str2, "kgTid");
        if (e.c.a.g.a.r.b.F()) {
            i(str, !e.c.a.g.a.f.m.b.m().z(), str2);
        }
    }

    public final void e(List<? extends e.c.a.g.a.d.r.p.a.c> list, List<KGSong> list2) {
        j.e(list, "goods");
        j.e(list2, "kgsongs");
        if (list.isEmpty() || list2.isEmpty() || list.size() != list2.size()) {
            return;
        }
        int size = list2.size();
        int i2 = 0;
        if (size <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            KGSong kGSong = list2.get(i2);
            e.c.a.g.a.d.r.p.a.c cVar = list.get(i2);
            kGSong.R2(cVar.B());
            kGSong.P2(cVar.e());
            if (i3 >= size) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    public final Scheduler f(String str) {
        Scheduler schedulerIo;
        String str2;
        if (h(str)) {
            schedulerIo = Schedulers.from(b);
            str2 = "from(singleThreadExecutor)";
        } else {
            schedulerIo = Schedulers.io();
            str2 = "io()";
        }
        j.d(schedulerIo, str2);
        return schedulerIo;
    }

    public final int g() {
        if (e.c.a.g.a.r.b.o() <= 0 || !e.c.a.g.a.f.m.b.m().E()) {
            return 0;
        }
        return e.c.a.g.a.f.m.b.m().s();
    }

    public final boolean h(String str) {
        return j.a("591", str);
    }

    public final void i(String str, boolean z, String str2) {
        j.e(str, "source");
        j.e(str2, "kgTid");
        GetGoodsByVerProtocol.a.b(z ? 0 : g(), 1, str2).map(new a(str2, str)).doOnNext(C0078b.a).subscribeOn(f(str2)).observeOn(AndroidSchedulers.mainThread()).subscribe((Action1) c.a, d.a);
    }

    public final List<Long> j(GetGoodsByVerProtocol.GoodsSongResponse goodsSongResponse) {
        j.e(goodsSongResponse, "result");
        ArrayList arrayList = new ArrayList();
        if (!goodsSongResponse.getData().getGoods().isEmpty()) {
            for (GetGoodsByVerProtocol.Good good : goodsSongResponse.getData().getGoods()) {
                if (good != null && "album".equals(good.getType()) && good.getStatus() != 2) {
                    arrayList.add(Long.valueOf(good.getId()));
                }
            }
        }
        return arrayList;
    }

    public final List<e.c.a.g.a.d.r.p.a.g> k(GetGoodsByVerProtocol.GoodsSongResponse goodsSongResponse) {
        ArrayList arrayList = new ArrayList();
        if (!goodsSongResponse.getData().getGoods().isEmpty()) {
            for (GetGoodsByVerProtocol.Good good : goodsSongResponse.getData().getGoods()) {
                if (!"album".equals(good.getType())) {
                    e.c.a.g.a.d.r.p.a.g gVar = new e.c.a.g.a.d.r.p.a.g();
                    gVar.l((int) good.getGood_scid());
                    gVar.p("audio");
                    gVar.i(good.getId());
                    arrayList.add(gVar);
                }
            }
        }
        return arrayList;
    }
}
