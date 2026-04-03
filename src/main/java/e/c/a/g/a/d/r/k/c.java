package e.c.a.g.a.d.r.k;

import android.os.SystemClock;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import e.c.a.g.a.d.r.g;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final String c = "c";
    public volatile boolean a = false;
    public long b;

    public c() {
        this.b = 0L;
        this.b = SystemClock.elapsedRealtime();
    }

    public Collection<KGSong> a(Collection<KGSong> collection, int i2, List<e.c.a.g.a.d.r.n.a<KGSong>> list, boolean z) {
        if (collection == null || collection.size() == 0) {
            return null;
        }
        g.h(list);
        if (this.a) {
            if (g0.a) {
                g0.e(c, "getExcuteTime:" + b());
            }
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (KGSong kGSong : collection) {
            if (kGSong.T1() > 0) {
                linkedHashMap.put(kGSong.J1() + kGSong.T1(), kGSong);
            } else if (kGSong.f1() != 0) {
                linkedHashMap.put(kGSong.J1() + kGSong.f1(), kGSong);
            } else {
                linkedHashMap.put(kGSong.J1(), kGSong);
            }
        }
        if (this.a) {
            if (g0.a) {
                g0.e(c, "getExcuteTime:" + b());
            }
            return null;
        }
        KGSong[] kGSongArr = (KGSong[]) linkedHashMap.values().toArray(new KGSong[r7.size() - 1]);
        ArrayList arrayList = new ArrayList(kGSongArr.length);
        Collections.addAll(arrayList, kGSongArr);
        if (!this.a) {
            arrayList.trimToSize();
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        }
        if (g0.a) {
            g0.e(c, "getExcuteTime:" + b());
        }
        return null;
    }

    public final long b() {
        return SystemClock.elapsedRealtime() - this.b;
    }

    public void c() {
        this.a = true;
    }
}
