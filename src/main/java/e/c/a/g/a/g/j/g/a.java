package e.c.a.g.a.g.j.g;

import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.datacollect.bi.use.TraceFullTask;
import e.c.a.g.a.d.x.f;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void a(int i2, KGMusicWrapper kGMusicWrapper) {
        if (kGMusicWrapper == null) {
            return;
        }
        TraceFullTask svar1 = new YoungBITask(20030, "click").setMixsongid(String.valueOf(kGMusicWrapper.getMixId())).setType("1").setSvar1(String.valueOf(i2));
        if (i2 == 22) {
            int i3 = f.i();
            if (i3 == 0) {
                svar1.setSvar4("1");
            } else if (i3 == 1) {
                svar1.setSvar4("2");
            } else if (i3 == 2) {
                svar1.setSvar4("3");
            }
        }
        e.c.a.g.a.e.b.b(svar1);
    }
}
