package e.c.a.g.a.d.x;

import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.f.c.a.q;
import e.c.a.g.a.s.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    public final ArrayList<KGMusicWrapper> a(int i2) {
        List<q> listE = e.c.a.g.a.g.m.b.a.e(System.currentTimeMillis(), i2);
        ArrayList<KGMusicWrapper> arrayList = new ArrayList<>(l0.e(listE));
        if (!(listE == null || listE.isEmpty())) {
            ArrayList arrayList2 = new ArrayList(f.u.n.j(listE, 10));
            Iterator<T> it = listE.iterator();
            while (it.hasNext()) {
                arrayList2.add(Long.valueOf(((q) it.next()).c()));
            }
            List<KGMusic> listQ = e.c.a.g.a.g.k.a.a.q(arrayList2);
            LinkedHashMap linkedHashMap = new LinkedHashMap(listQ.size());
            for (Object obj : listQ) {
                linkedHashMap.put(Long.valueOf(((KGMusic) obj).mixId), obj);
            }
            Initiator initiatorCreate = Initiator.create(PageKey.make("", 0, ""));
            for (q qVar : listE) {
                KGMusic kGMusicL = (KGMusic) linkedHashMap.get(Long.valueOf(qVar.c()));
                if (kGMusicL == null && !f.z.d.j.a(qVar.a(), "")) {
                    kGMusicL = e.c.a.g.a.g.k.a.a.l(qVar.a());
                }
                if (kGMusicL != null) {
                    KGMusicWrapper kGMusicWrapperA = e.c.a.g.a.f.j.a.c.a(initiatorCreate, "41", kGMusicL);
                    f.z.d.j.d(kGMusicWrapperA, "createKGMusicWrapper(\n                        initiator,\n                        TraceSource.SOURCE_41,\n                        music\n                    )");
                    arrayList.add(kGMusicWrapperA);
                }
            }
        }
        return arrayList;
    }
}
