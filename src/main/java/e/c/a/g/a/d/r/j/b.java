package e.c.a.g.a.d.r.j;

import com.kugou.android.watch.lite.common.music.entity.SongQuality;
import e.c.a.g.a.d.r.g;
import e.c.a.g.a.d.r.i;
import e.c.a.g.a.d.r.p.a.c;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b<T> {

    /* JADX INFO: renamed from: e.c.a.g.a.d.r.j.b$b, reason: collision with other inner class name */
    public static class C0072b {
        public static b a = new b();
    }

    public static b g() {
        return C0072b.a;
    }

    public boolean a(int i2) {
        return 2 == i2 || 3 == i2 || 4 == i2 || 5 == i2 || 7 == i2 || 15 == i2 || 16 == i2 || 10 == i2;
    }

    public int b(c cVar, boolean z, boolean z2, boolean z3) {
        if (cVar == null || cVar == null) {
            return 9;
        }
        if (z && g.j(cVar)) {
            return cVar.C() == 1 ? 9 : 11;
        }
        if (z3 && g.n(cVar)) {
            return 12;
        }
        if (!z3 || z2) {
            return 13;
        }
        return f(cVar, false);
    }

    public int c(List<e.c.a.g.a.d.r.n.a<T>> list, e.c.a.g.a.d.r.k.b bVar, boolean z, SongQuality songQuality) {
        if (list == null || list.size() == 0 || bVar == null) {
            return 9;
        }
        ArrayList arrayList = new ArrayList(list);
        boolean z2 = !bVar.p0();
        c cVarB = ((e.c.a.g.a.d.r.n.a) arrayList.get(0)).b();
        if (songQuality == null) {
            songQuality = bVar.e0();
        }
        c cVarF = i.f(cVarB, songQuality);
        if (g0.a) {
            i.g("MusicFeesDelegate/getDownloadFeesType", cVarF);
        }
        if (!z || z2) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int iB = b(i.f(((e.c.a.g.a.d.r.n.a) it.next()).b(), songQuality), bVar.s(), false, true);
                if (a(iB)) {
                    if (!g0.a) {
                        return 14;
                    }
                    g0.e("zzm-log", "有一首可以音乐包购买statusCode:" + iB);
                    return 14;
                }
            }
        }
        return b(cVarF, bVar.s(), z2, z);
    }

    public c d(List<e.c.a.g.a.d.r.n.a<T>> list, e.c.a.g.a.d.r.k.b bVar, SongQuality songQuality) {
        if (list == null || list.size() == 0 || bVar == null) {
            return null;
        }
        c cVarB = ((e.c.a.g.a.d.r.n.a) new ArrayList(list).get(0)).b();
        if (songQuality == null) {
            songQuality = bVar.e0();
        }
        c cVarF = i.f(cVarB, songQuality);
        if (g0.a) {
            i.g("MusicFeesDelegate/getDownloadFeesType", cVarF);
        }
        return cVarF;
    }

    public int e(c cVar) {
        return f(cVar, false);
    }

    public int f(c cVar, boolean z) {
        if (cVar == null) {
            return 9;
        }
        if (g.j(cVar)) {
            return 11;
        }
        if (g.n(cVar)) {
            return 12;
        }
        if (e.c.a.g.a.r.b.c().equals("4") && g.K(cVar)) {
            return 16;
        }
        if (e.c.a.g.a.r.b.c().equals("5") && g.K(cVar)) {
            return g.f(cVar) ? 16 : 15;
        }
        if (!g.d(cVar) && !g.e(cVar) && g.a(cVar) && !g.b(cVar)) {
            return 1;
        }
        if (!g.d(cVar) && !g.e(cVar) && !g.a(cVar) && g.b(cVar)) {
            return e.c.a.g.a.r.b.G() ? 10 : 2;
        }
        if (!g.d(cVar) && !g.e(cVar) && g.a(cVar) && g.b(cVar)) {
            return e.c.a.g.a.r.b.G() ? 10 : 3;
        }
        if (g.d(cVar) && !g.e(cVar) && !g.c(cVar)) {
            return e.c.a.g.a.r.b.G() ? 9 : 4;
        }
        if (!g.d(cVar) && g.e(cVar) && !g.c(cVar)) {
            return e.c.a.g.a.r.b.O() ? 9 : 6;
        }
        if (g.d(cVar) && g.e(cVar) && !g.c(cVar)) {
            return (e.c.a.g.a.r.b.O() || e.c.a.g.a.r.b.G()) ? 9 : 5;
        }
        if (g.d(cVar) && !g.e(cVar) && g.a(cVar) && !g.b(cVar)) {
            return e.c.a.g.a.r.b.G() ? 9 : 7;
        }
        if (!g.d(cVar) && g.e(cVar) && g.a(cVar) && !g.b(cVar)) {
            if (e.c.a.g.a.r.b.O()) {
                return 9;
            }
            return (z || e.c.a.g.a.r.b.G()) ? 6 : 8;
        }
        if (g.d(cVar) && g.e(cVar) && g.a(cVar) && !g.b(cVar)) {
            return (e.c.a.g.a.r.b.O() || e.c.a.g.a.r.b.G()) ? 9 : 7;
        }
        if (g.d(cVar) && !g.e(cVar) && !g.a(cVar) && g.b(cVar)) {
            return e.c.a.g.a.r.b.G() ? 9 : 4;
        }
        if (!g.d(cVar) && g.e(cVar) && !g.a(cVar) && g.b(cVar)) {
            if (e.c.a.g.a.r.b.O()) {
                return 9;
            }
            return e.c.a.g.a.r.b.G() ? 10 : 2;
        }
        if (g.d(cVar) && g.e(cVar) && !g.a(cVar) && g.b(cVar)) {
            return (e.c.a.g.a.r.b.O() || e.c.a.g.a.r.b.G()) ? 9 : 4;
        }
        if (g.d(cVar) && !g.e(cVar) && g.a(cVar) && g.b(cVar)) {
            return e.c.a.g.a.r.b.G() ? 9 : 7;
        }
        if (g.d(cVar) || !g.e(cVar) || !g.a(cVar) || !g.b(cVar)) {
            return (g.d(cVar) && g.e(cVar) && g.a(cVar) && g.b(cVar) && !e.c.a.g.a.r.b.O() && !e.c.a.g.a.r.b.G()) ? 7 : 9;
        }
        if (e.c.a.g.a.r.b.O()) {
            return 9;
        }
        return e.c.a.g.a.r.b.G() ? 10 : 3;
    }

    public b() {
    }
}
