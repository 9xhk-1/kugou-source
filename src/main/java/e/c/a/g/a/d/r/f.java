package e.c.a.g.a.d.r;

import com.kugou.android.watch.lite.base.fav.CloudMusicModel;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import e.c.a.g.a.d.f.c.a.j;
import java.text.DecimalFormat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static void a(List<KGSong> list, Initiator initiator, e eVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c.a.g.a.d.r.k.b bVar = new e.c.a.g.a.d.r.k.b(list);
        bVar.c(initiator);
        bVar.L(eVar);
        e.c.a.g.a.d.r.n.h.c().d(bVar);
    }

    public static String b(double d2) {
        int i2 = (int) ((d2 * 100.0d) % 100.0d);
        return i2 == 0 ? c(d2, 0) : i2 % 10 == 0 ? c(d2, 1) : c(d2, 2);
    }

    public static String c(double d2, int i2) {
        String str = i2 > 0 ? "0." : "0";
        for (int i3 = 0; i3 < i2; i3++) {
            str = str + "0";
        }
        return new DecimalFormat(str).format(d2);
    }

    public static void d(boolean z, List<KGMusicWrapper> list, boolean z2, e eVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c.a.g.a.d.x.e.c();
        e.c.a.g.a.d.r.o.c cVar = new e.c.a.g.a.d.r.o.c(list);
        cVar.i1(1);
        cVar.e1(z2);
        cVar.g1(z);
        cVar.L(eVar);
        e.c.a.g.a.d.r.n.h.c().d(cVar);
    }

    public static void e(boolean z, List<KGMusicWrapper> list, int i2, boolean z2, e eVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        e.c.a.g.a.d.x.e.c();
        e.c.a.g.a.d.r.o.c cVar = new e.c.a.g.a.d.r.o.c(list);
        cVar.f1(i2);
        cVar.g1(z);
        cVar.h1(z2);
        cVar.L(eVar);
        e.c.a.g.a.d.r.n.h.c().d(cVar);
    }

    public static void f(Initiator initiator, List<KGSong> list, CloudMusicModel cloudMusicModel, j jVar, e eVar) {
        if (list != null) {
            e.c.a.g.a.d.r.m.a aVar = new e.c.a.g.a.d.r.m.a(cloudMusicModel, jVar, list);
            aVar.c(initiator);
            aVar.L(eVar);
            e.c.a.g.a.d.r.n.h.c().d(aVar);
        }
    }
}
