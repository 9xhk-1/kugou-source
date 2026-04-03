package e.c.a.g.a.d.r.o;

import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.r.g;
import e.c.a.g.a.d.r.n.d;
import e.c.a.g.a.d.x.h;
import e.c.a.g.a.s.j1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends d<KGMusicWrapper> {
    public List<Integer> l;
    public KGMusicWrapper[] m;
    public HashSet<Integer> n;
    public HashMap<String, e.c.a.g.a.d.r.p.a.c> o;
    public KGMusicWrapper p;

    public e.c.a.g.a.d.r.p.a.c T(String str) {
        return this.o.get(str);
    }

    public void U() {
        this.o = new HashMap<>();
        this.n = new HashSet<>();
    }

    public void V() {
        List<e.c.a.g.a.d.r.n.a<T>> list = this.j;
        if (list != 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                e.c.a.g.a.d.r.n.a aVar = (e.c.a.g.a.d.r.n.a) it.next();
                if (F(aVar) && !g.p(aVar.b()) && g.j(aVar.b()) && aVar.d() == 1) {
                    this.l.add(Integer.valueOf(aVar.b().m()));
                }
            }
        }
    }

    public boolean W(e.c.a.g.a.d.r.p.a.c cVar) {
        Iterator it = this.f500h.iterator();
        KGMusicWrapper kGMusicWrapper = null;
        while (it.hasNext()) {
            e.c.a.g.a.d.r.n.a aVar = (e.c.a.g.a.d.r.n.a) it.next();
            if (aVar != null && aVar.b() == cVar) {
                kGMusicWrapper = (KGMusicWrapper) aVar.a();
            }
        }
        if (kGMusicWrapper == null) {
            return false;
        }
        a0(kGMusicWrapper);
        X(new KGMusicWrapper[]{kGMusicWrapper});
        return true;
    }

    public void X(KGMusicWrapper[] kGMusicWrapperArr) {
        if (kGMusicWrapperArr == null) {
            return;
        }
        for (KGMusicWrapper kGMusicWrapper : kGMusicWrapperArr) {
            if (kGMusicWrapper != null) {
                int iHashCode = kGMusicWrapper.hashCode();
                if (kGMusicWrapper.haveChargOf()) {
                    this.n.add(Integer.valueOf(iHashCode));
                }
                kGMusicWrapper.setHaveChargOf(true);
                kGMusicWrapper.setMusicWrapperCode(iHashCode);
            }
        }
    }

    public void Y(List<e.c.a.g.a.d.r.n.a<KGMusicWrapper>> list) {
        ArrayList arrayList = new ArrayList();
        for (e.c.a.g.a.d.r.n.a<KGMusicWrapper> aVar : list) {
            if (aVar != null && aVar.a() != null && aVar.b() != null) {
                this.o.put(aVar.a().getHashValueV2(), aVar.b());
                if (b.h(aVar.a(), aVar.b())) {
                    arrayList.add(aVar.a());
                }
            }
        }
        try {
            if (j1.a("SAVEQUEUE")) {
                return;
            }
            e.c.a.g.a.d.x.g.h().j(h.y().getIQueue());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int Z(KGMusicWrapper[] kGMusicWrapperArr, KGMusicWrapper[] kGMusicWrapperArr2, int i2) {
        if (kGMusicWrapperArr != null && kGMusicWrapperArr.length != 0 && i2 >= 0 && i2 <= kGMusicWrapperArr.length - 1 && kGMusicWrapperArr2 != null && kGMusicWrapperArr2.length != 0) {
            KGMusicWrapper kGMusicWrapper = kGMusicWrapperArr[i2];
            for (int i3 = 0; i3 < kGMusicWrapperArr2.length; i3++) {
                if (kGMusicWrapperArr2[i3] == kGMusicWrapper) {
                    return i3;
                }
            }
        }
        return 0;
    }

    public void a0(KGMusicWrapper kGMusicWrapper) {
        if (this.p != null || kGMusicWrapper == null) {
            return;
        }
        this.p = kGMusicWrapper;
    }

    public void b0(KGMusicWrapper kGMusicWrapper) {
    }

    @Override // e.c.a.g.a.d.r.n.d
    public List<e.c.a.g.a.d.r.n.a<KGMusicWrapper>> q() {
        ArrayList arrayList = new ArrayList();
        KGMusicWrapper[] kGMusicWrapperArr = this.m;
        if (kGMusicWrapperArr == null) {
            return arrayList;
        }
        for (KGMusicWrapper kGMusicWrapper : kGMusicWrapperArr) {
            if (kGMusicWrapper != null) {
                arrayList.add(new e.c.a.g.a.d.r.n.a(kGMusicWrapper));
            }
        }
        return arrayList;
    }
}
