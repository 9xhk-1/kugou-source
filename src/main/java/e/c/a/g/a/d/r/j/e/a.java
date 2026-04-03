package e.c.a.g.a.d.r.j.e;

import com.kugou.android.watch.lite.common.music.entity.KGSong;
import e.c.a.g.a.d.r.j.c.f;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends f {
    public a(e.c.a.g.a.d.r.m.a aVar) {
        super(aVar);
    }

    public final void B(e.c.a.g.a.d.r.n.a<?> aVar) {
        int iY = aVar.b().y();
        if (getFeeTaskImpl().v()) {
            ((KGSong) aVar.a()).b3(iY);
        }
    }

    @Override // e.c.a.g.a.d.r.j.c.b
    public void d(e.c.a.g.a.d.r.n.a<?> aVar, List<e.c.a.g.a.d.r.p.a.c> list) {
        super.d(aVar, list);
        B(aVar);
    }
}
