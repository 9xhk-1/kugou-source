package e.c.a.g.a.h;

import android.util.Log;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static boolean a(KGSong kGSong) {
        if (kGSong == null) {
            return false;
        }
        return !e.c.a.g.a.f.j.c.d.d(kGSong) || (e.c.a.g.a.f.j.c.d.d(kGSong) && kGSong.H1() != null);
    }

    public static void b(List<KGSong> list, String str) {
        for (KGSong kGSong : list) {
            if (kGSong != null && kGSong != null) {
                Log.e("mhs_watch_error", str + " isVipMusic" + e.c.a.g.a.f.j.c.d.d(kGSong) + ", firstSong.hashOffset = " + kGSong.H1());
            }
        }
    }

    public static String c(int i2) {
        return i2 == 1282 ? "peak" : i2 == 1283 ? "small" : i2 == 1284 ? "radio" : "normal";
    }

    public static void d(List<KGSong> list) {
        if (!e.c.a.g.a.f.a.n() || list == null || list.isEmpty() || a(list.get(0))) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (KGSong kGSong : list) {
            if (kGSong != null) {
                if (a(kGSong)) {
                    arrayList.add(kGSong);
                } else {
                    arrayList2.add(kGSong);
                }
                if (g0.f()) {
                    Log.e("mhs_watch_rcm", "resetSongOrder song = " + kGSong);
                }
            }
        }
        list.clear();
        list.addAll(arrayList);
        list.addAll(arrayList2);
    }

    public static String e(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append("-");
        }
        return stringBuffer.deleteCharAt(stringBuffer.length() - 1).toString();
    }
}
