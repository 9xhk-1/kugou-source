package e.c.a.g.a.f.j.c;

import android.text.TextUtils;
import android.util.Log;
import e.c.a.g.a.g.i.q;
import e.c.a.g.a.s.e;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(q qVar) {
        if (qVar != null && g()) {
            Iterator<e.c.a.g.a.g.k.c.a> it = qVar.h().iterator();
            int iG = qVar.g();
            int i2 = 0;
            StringBuilder sb = new StringBuilder();
            if (e.c.a.g.a.g.f.c.a.i()) {
                while (it.hasNext()) {
                    e.c.a.g.a.g.k.c.a next = it.next();
                    int iH = h(next);
                    if (iH > 0) {
                        if (g0.a) {
                            g0.b("fav_audio_filter", "filterLongAudio: " + next.p() + " filterType: " + iH);
                        }
                        i2++;
                        it.remove();
                        if (i2 < 5) {
                            sb.append(", filterType " + iH + ", name = " + next.p());
                        }
                    }
                }
            }
            String str = "被过滤几首歌=" + i2 + ", srcListCount = " + iG + ", removeCount = " + i2;
            if (g0.a) {
                g0.b("fav_audio_filter", str + ", " + ((Object) sb));
            }
            qVar.m(i2);
            qVar.q(iG - i2);
            e.c.a.g.a.g.f.c.a.s(str, sb.toString());
        }
    }

    public static String b() {
        return e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.B1);
    }

    public static String c() {
        return e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.z1);
    }

    public static String d() {
        return e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.A1);
    }

    public static boolean e() {
        String strB = b();
        String strD = e.c.a.g.a.f.m.c.a.d("last_fav_long_audio_accurate_filter_keyword", "");
        if (g0.a) {
            g0.b("fav_audio_filter", "isAccurateFilterKeywordChanged: rules:" + strB + "  oldRules:" + strD);
        }
        return !TextUtils.isEmpty(strB) ? !strB.equalsIgnoreCase(strD) : !TextUtils.isEmpty(strD);
    }

    public static boolean f() {
        String strC = c();
        String strD = e.c.a.g.a.f.m.c.a.d("last_fav_long_audio_channels", "");
        if (g0.a) {
            g0.b("fav_audio_filter", "isChannelFilterRuleChanged: new:" + strC + "  old:" + strD);
        }
        return !TextUtils.isEmpty(strC) ? !strC.equalsIgnoreCase(strD) : !TextUtils.isEmpty(strD);
    }

    public static boolean g() {
        String strC = c();
        String[] strArrSplit = TextUtils.isEmpty(strC) ? null : strC.split(",");
        if (strArrSplit != null && strArrSplit.length > 0) {
            String strJ = l1.j();
            for (String str : strArrSplit) {
                if (strJ != null && strJ.equalsIgnoreCase(str.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int h(e.c.a.g.a.g.k.c.a aVar) {
        if (e.c(aVar.c())) {
            return 1;
        }
        if (aVar.h() != null && e.a(aVar.h().getPay_block_tpl())) {
            return 2;
        }
        String strN = n(aVar.p());
        if (g0.a) {
            Log.d("fav_audio_filter", "isFilterThisSong: songName：" + strN);
        }
        return k(strN) ? 3 : 0;
    }

    public static boolean i() {
        return f() || j() || e();
    }

    public static boolean j() {
        String strD = d();
        String strD2 = e.c.a.g.a.f.m.c.a.d("last_fav_long_audio_fuzzy_filter_keyword", "");
        if (g0.a) {
            g0.b("fav_audio_filter", "isChannelFilterRuleChanged: rules:" + strD + "  oldRules:" + strD2);
        }
        return !TextUtils.isEmpty(strD) ? !strD.equalsIgnoreCase(strD2) : !TextUtils.isEmpty(strD2);
    }

    public static boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArrM = m(b());
        if (strArrM != null) {
            for (String str2 : strArrM) {
                if (!TextUtils.isEmpty(str2) && str.equals(str2)) {
                    return true;
                }
            }
        }
        String[] strArrM2 = m(d());
        if (strArrM2 != null) {
            for (String str3 : strArrM2) {
                if (!TextUtils.isEmpty(str3) && str.toLowerCase().contains(str3.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void l() {
        e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
        cVar.i("last_fav_long_audio_channels", c());
        cVar.i("last_fav_long_audio_fuzzy_filter_keyword", d());
        cVar.i("last_fav_long_audio_accurate_filter_keyword", b());
    }

    public static String[] m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return str.split(",");
        } catch (Exception unused) {
            return null;
        }
    }

    public static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int iIndexOf = str.indexOf(" - ");
        int i2 = iIndexOf + 3;
        if (iIndexOf == -1) {
            iIndexOf = str.indexOf("-");
            i2 = iIndexOf + 1;
        }
        if (iIndexOf <= 0) {
            return str;
        }
        String strTrim = str.substring(i2).trim();
        int iLastIndexOf = strTrim.lastIndexOf(".");
        return iLastIndexOf > 0 ? strTrim.substring(0, iLastIndexOf).trim() : strTrim;
    }
}
