package e.c.a.g.a.d.s;

import android.util.Log;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public final c a;

    public class a implements Runnable {
        public final /* synthetic */ long a;

        public a(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            String.valueOf(this.a);
            try {
                h.this.a.b(this.a, e.g(this.a));
                if (g0.a) {
                    g0.e("FeeLimitedFreeDataMgrLog", "loadCache all data success");
                }
            } catch (Throwable th) {
                g0.e("FeeLimitedFreeDataMgrLog", "loadCache 2 e:" + Log.getStackTraceString(th));
            }
        }
    }

    public static class b {
        public static final h a = new h(null);
    }

    public /* synthetic */ h(a aVar) {
        this();
    }

    public static h i() {
        return b.a;
    }

    public void b(HashSet<Long> hashSet, HashSet<String> hashSet2, boolean z) {
        this.a.c(e.c.a.g.a.r.b.o(), hashSet, hashSet2);
    }

    public void c(List<Long> list) {
        if (list == null || list.isEmpty() || !e.c.a.g.a.r.b.F()) {
            return;
        }
        long jO = e.c.a.g.a.r.b.o();
        HashSet<Long> hashSet = new HashSet<>();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next());
        }
        this.a.a(jO, hashSet);
        e.a(e.c.a.g.a.r.b.o(), list);
    }

    public void d(List<KGSong> list) {
        if (list == null || list.size() == 0 || !e.c.a.g.a.r.b.F()) {
            return;
        }
        HashSet<Long> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        for (KGSong kGSong : list) {
            if (kGSong != null) {
                hashSet2.add(kGSong.J1());
                hashSet.add(Long.valueOf(kGSong.T1()));
            }
        }
        if (hashSet2.size() == 0 && hashSet.size() == 0) {
            return;
        }
        b(hashSet, hashSet2, false);
        e.b(e.c.a.g.a.r.b.o(), list);
    }

    public boolean e(long j, long j2) {
        return this.a.d(j, j2);
    }

    public boolean f(long j, long j2, String str) {
        return this.a.e(j, j2, str);
    }

    public void g(HashSet<Long> hashSet) {
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        this.a.g(e.c.a.g.a.r.b.o(), hashSet);
        e.h(e.c.a.g.a.r.b.o(), hashSet);
    }

    public void h(HashSet<Long> hashSet) {
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        this.a.f(e.c.a.g.a.r.b.o(), hashSet);
        e.i(e.c.a.g.a.r.b.o(), hashSet);
    }

    public void j(long j) {
        j0.b().a(new a(j));
    }

    public h() {
        this.a = new c();
    }
}
