package e.c.a.g.a.d.a;

import android.text.TextUtils;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import e.c.a.g.a.d.a.a;
import e.c.a.g.a.f.k.k.e;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class b extends e.c.a.g.a.d.a.a {
    public final HashMap<String, e.c.a.g.a.d.a.c> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a.C0041a f361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a.b f362e;

    public class a implements Action1<Integer> {
        public final /* synthetic */ Runnable a;

        public a(b bVar, Runnable runnable) {
            this.a = runnable;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Integer num) {
            if (num == null || num.intValue() <= 0) {
                return;
            }
            this.a.run();
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.a.b$b, reason: collision with other inner class name */
    public class C0042b implements Func1<List<KGSong>, Integer> {
        public C0042b(b bVar) {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call(List<KGSong> list) {
            List listC = b.d().c(list);
            int i2 = 0;
            if (l0.g(listC)) {
                return 0;
            }
            for (KGSong kGSong : list) {
                Iterator it = listC.iterator();
                while (true) {
                    if (it.hasNext()) {
                        e.c.a.g.a.d.a.c cVar = (e.c.a.g.a.d.a.c) it.next();
                        String strY1 = kGSong.y1();
                        if (!TextUtils.isEmpty(strY1)) {
                            if (strY1.equals(Long.toString(cVar.b()))) {
                                kGSong.c3(cVar.a());
                                i2++;
                                break;
                            }
                        }
                    }
                }
            }
            return Integer.valueOf(i2);
        }
    }

    public static class c {
        public static final b a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b d() {
        return c.a;
    }

    public void b(List<KGSong> list, Runnable runnable) {
        Observable.just(list).subscribeOn(Schedulers.io()).map(new C0042b(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, runnable), i1.b);
    }

    public final List<e.c.a.g.a.d.a.c> c(List<KGSong> list) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.b.clear();
        this.a.clear();
        ArrayList arrayList = new ArrayList();
        for (KGSong kGSong : list) {
            if (kGSong != null) {
                e.c.a.g.a.d.a.c cVar = this.c.get(kGSong.y1());
                if (cVar != null) {
                    arrayList.add(cVar);
                } else {
                    this.b.add(kGSong.J1());
                    this.a.add(Long.valueOf(kGSong.T1()));
                }
            }
        }
        if (this.a.size() == 0) {
            return arrayList;
        }
        ArrayList<e.c.a.g.a.d.a.c> arrayList2 = new ArrayList();
        try {
            e.a().request(this.f361d, this.f362e);
            this.f362e.getResponseData(arrayList2);
            for (e.c.a.g.a.d.a.c cVar2 : arrayList2) {
                this.c.put(Long.toString(cVar2.b()), cVar2);
            }
            arrayList2.addAll(arrayList);
            return arrayList2;
        } catch (Exception e2) {
            g0.k(e2);
            return null;
        }
    }

    public b() {
        this.c = new HashMap<>();
        this.f361d = new a.C0041a();
        this.f362e = new a.b(this);
    }
}
