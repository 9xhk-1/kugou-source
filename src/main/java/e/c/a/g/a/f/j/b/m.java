package e.c.a.g.a.f.j.b;

import android.text.TextUtils;
import com.kugou.android.watch.lite.common.music.entity.MusicTransParamEnenty;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.r0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m {
    public static boolean a(n nVar) {
        return o(nVar.getUpdataFlag(), nVar) > 0;
    }

    public static e.c.a.g.a.f.j.a.a b(e.c.a.g.a.d.r.p.a.g gVar, e.c.a.g.a.d.r.p.a.c cVar) {
        if (gVar == null || cVar == null || !TextUtils.equals(cVar.k(), gVar.c())) {
            return null;
        }
        e.c.a.g.a.f.j.a.a aVar = new e.c.a.g.a.f.j.a.a();
        gVar.b();
        return aVar;
    }

    public static ArrayList<e.c.a.g.a.f.j.a.a> c(List<e.c.a.g.a.d.r.p.a.g> list, List<e.c.a.g.a.d.r.p.a.c> list2) {
        if (list == null || list2 == null || list.size() != list2.size()) {
            return null;
        }
        ArrayList<e.c.a.g.a.f.j.a.a> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            e.c.a.g.a.f.j.a.a aVarB = b(list.get(i2), list2.get(i2));
            if (aVarB == null) {
                return null;
            }
            arrayList.add(aVarB);
        }
        return arrayList;
    }

    public static boolean d(n nVar) {
        if (nVar == null) {
            return false;
        }
        int charge = nVar.getCharge();
        String musicFeeType = nVar.getMusicFeeType();
        int failProcess = nVar.getFailProcess();
        if (charge == 0 || charge == h.b || TextUtils.isEmpty(musicFeeType)) {
            return false;
        }
        return failProcess != 0 || e.c.a.g.a.d.r.g.u(charge) || e.c.a.g.a.d.r.g.y(charge);
    }

    public static String e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            if (!g0.a) {
                return null;
            }
            g0.c("xutaici-FeesUtils-getFeeStatusKey", "hash is null");
            return null;
        }
        try {
            if (TextUtils.isEmpty(str2) || "0".equals(str2)) {
                str2 = h.a;
            }
        } catch (NumberFormatException unused) {
            str2 = h.a;
        }
        return str.toUpperCase().concat("_").concat(str2);
    }

    public static boolean f(int i2) {
        return i2 == -1 || (i2 & 1) > 0 || (i2 & 2) > 0 || (i2 & 4) > 0 || (i2 & 8) > 0 || (i2 & 16) > 0 || (i2 & 32) > 0;
    }

    public static boolean g(n nVar) {
        return (r0.h(nVar.getMusicTransParamEnenty()) || r0.b(nVar.getMusicTransParamEnenty()) || r0.j(nVar.getMusicTransParamEnenty()) || e.c.a.g.a.d.r.g.s(nVar.getMusicTransParamEnenty()) || d(nVar)) ? false : true;
    }

    public static boolean h(int i2) {
        return i2 == -1 || (i2 & 8) > 0;
    }

    public static boolean i(int i2) {
        return i2 == -1 || (i2 & 32) > 0;
    }

    public static boolean j(int i2) {
        return i2 == -1 || (i2 & 1) > 0;
    }

    public static boolean k(long j) {
        return j == 0 || l1.b() - j > 604800000;
    }

    public static boolean l(int i2) {
        return i2 == -1 || (i2 & 16) > 0;
    }

    public static boolean m(int i2) {
        return i2 == -1 || (i2 & 4) > 0;
    }

    public static boolean n(int i2) {
        return i2 == -1 || (i2 & 2) > 0;
    }

    public static int o(int i2, n nVar) {
        if (j(nVar.getUpdataFlag()) && !d(nVar)) {
            i2 = r(false, i2);
        }
        if (m(nVar.getUpdataFlag()) && !r0.e(nVar.getMusicTransParamEnenty())) {
            i2 = s(false, i2);
        }
        if (n(nVar.getUpdataFlag()) && !r0.h(nVar.getMusicTransParamEnenty())) {
            i2 = t(false, i2);
        }
        if (h(nVar.getUpdataFlag()) && !r0.b(nVar.getMusicTransParamEnenty())) {
            i2 = p(false, i2);
        }
        if (l(nVar.getUpdataFlag()) && !r0.j(nVar.getMusicTransParamEnenty())) {
            i2 = v(false, i2);
        }
        return (i(nVar.getUpdataFlag()) && r0.m(nVar.getMusicTransParamEnenty())) ? u(true, i2) : i2;
    }

    public static int p(boolean z, int i2) {
        return q(i2, 8, z);
    }

    public static int q(int i2, int i3, boolean z) {
        return z ? i2 | i3 : i2 & (i3 ^ (-1));
    }

    public static int r(boolean z, int i2) {
        return q(i2, 1, z);
    }

    public static int s(boolean z, int i2) {
        return q(i2, 4, z);
    }

    public static int t(boolean z, int i2) {
        return q(i2, 2, z);
    }

    public static int u(boolean z, int i2) {
        return q(i2, 32, z);
    }

    public static int v(boolean z, int i2) {
        return q(i2, 16, z);
    }

    public static MusicTransParamEnenty w(MusicTransParamEnenty musicTransParamEnenty, n nVar) {
        MusicTransParamEnenty musicTransParamEnenty2 = nVar.getMusicTransParamEnenty();
        if (musicTransParamEnenty2 == null) {
            return null;
        }
        if (musicTransParamEnenty == null) {
            musicTransParamEnenty = new MusicTransParamEnenty();
        }
        if (n(nVar.getUpdataFlag())) {
            musicTransParamEnenty.setMusicpackAdvance(musicTransParamEnenty2.getMusicpackAdvance());
        }
        if (m(nVar.getUpdataFlag())) {
            musicTransParamEnenty.setHave_listen_part(musicTransParamEnenty2.getHave_listen_part());
        }
        if (h(nVar.getUpdataFlag())) {
            musicTransParamEnenty.setAllQualityFree(musicTransParamEnenty2.getAllQualityFree());
        }
        if (l(nVar.getUpdataFlag())) {
            musicTransParamEnenty.setLimitedFree(musicTransParamEnenty2.getLimitedFree());
        }
        if (i(nVar.getUpdataFlag())) {
            musicTransParamEnenty.setDisplay(musicTransParamEnenty2.getDisplay());
            musicTransParamEnenty.setDisplayRate(musicTransParamEnenty2.getDisplayRate());
        }
        if (nVar.fromCache()) {
            musicTransParamEnenty.setFromCache(true);
        } else {
            musicTransParamEnenty.setFromCache(false);
        }
        return musicTransParamEnenty;
    }
}
