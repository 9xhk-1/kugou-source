package e.c.a.g.a.f.h.a;

import android.content.Context;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.historycloud.HistoryRecord;
import e.c.a.g.a.d.f.b;
import e.c.a.g.a.d.f.c.a.d;
import e.c.a.g.a.d.f.c.a.e;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.l1;
import f.u.n;
import f.z.d.j;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a a = new a();
    public static final e b;

    static {
        b bVar = b.a;
        Context context = KGApplication.getContext();
        j.d(context, "getContext()");
        b = bVar.a(context).g();
    }

    public final List<HistoryRecord> a(List<d> list) {
        j.e(list, "historyPlaySongs");
        ArrayList arrayList = new ArrayList(n.j(list, 10));
        for (d dVar : list) {
            Integer numValueOf = null;
            long jLongValue = (dVar == null ? null : Long.valueOf(dVar.b())).longValue();
            long jLongValue2 = (dVar == null ? null : Long.valueOf(dVar.c())).longValue() / ((long) 1000);
            long jLongValue3 = (dVar == null ? null : Long.valueOf(dVar.d())).longValue();
            if (dVar != null) {
                numValueOf = Integer.valueOf((int) dVar.a());
            }
            arrayList.add(new HistoryRecord(jLongValue, jLongValue2, jLongValue3, numValueOf.intValue()));
        }
        return arrayList;
    }

    public final d b(KGMusicWrapper kGMusicWrapper) {
        j.e(kGMusicWrapper, "music");
        d dVar = new d();
        dVar.h(System.currentTimeMillis());
        dVar.g(kGMusicWrapper.getMixId());
        dVar.i(0L);
        dVar.f(1L);
        dVar.j(e.c.a.g.a.r.b.o());
        return dVar;
    }

    public final int c(List<Long> list) {
        j.e(list, "mixIds");
        return b.h(list, e.c.a.g.a.r.b.o());
    }

    public final int d() {
        return c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.S, 30);
    }

    public final int e() {
        return c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.T, 3);
    }

    public final int f() {
        return c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.U, 50);
    }

    public final List<d> g(long j, int i2) {
        return b.j(j, i2, e.c.a.g.a.r.b.o());
    }

    public final int h() {
        if (l1.m0()) {
            return 2;
        }
        if (l1.V()) {
            return 3;
        }
        return l1.g0() ? 4 : 0;
    }

    public final d i(KGMusicWrapper kGMusicWrapper) {
        j.e(kGMusicWrapper, "kgMusic");
        return b.i(kGMusicWrapper.getMixId(), e.c.a.g.a.r.b.o());
    }

    public final void j(KGMusicWrapper kGMusicWrapper) {
        j.e(kGMusicWrapper, "music");
        d dVarI = i(kGMusicWrapper);
        if (dVarI != null) {
            b.k(kGMusicWrapper.getMixId(), System.currentTimeMillis(), dVarI.d() + 1, e.c.a.g.a.r.b.o());
        } else {
            b.d(b(kGMusicWrapper));
        }
    }

    public final boolean k() {
        return c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.g3, 1) == 1;
    }
}
