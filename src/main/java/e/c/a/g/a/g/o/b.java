package e.c.a.g.a.g.o;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.RoomMasterTable;
import com.google.gson.Gson;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import com.kugou.uilib.widget.textview.span.TopicHighlightHelper;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.l1;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static String[] a;
    public static String[] b;
    public static String[] c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String[] f993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String[] f994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Set<String> f995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String[] f996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Set<String> f997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Set<String> f998i = new HashSet();
    public static final String[] j = {"恐怖背景", "黑暗背景"};
    public static String[] k = null;
    public static volatile int l = 0;

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            b.q();
        }
    }

    public static boolean a() {
        if (k == null) {
            String strB = e.c.a.g.a.f.e.c.c().b(e.c.a.g.a.f.e.b.H2, "");
            k = n(strB);
            Log.e("mhs_watch_xlog", "forceDisableMod = " + strB);
        }
        String[] strArr = k;
        if (strArr != null && strArr.length > 0) {
            String strQ = l1.q();
            for (String str : k) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strQ) && strQ.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(String str, String str2) {
        if (a == null) {
            a = n(e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.v1));
        }
        if (a != null) {
            String strB = h1.b(str);
            String strB2 = h1.b(str2);
            for (String str3 : a) {
                if (!TextUtils.isEmpty(str3)) {
                    String[] strArrSplit = str3.split(TopicHighlightHelper.AT);
                    String str4 = (String) l0.d(strArrSplit, 0, null);
                    String str5 = (String) l0.d(strArrSplit, 1, null);
                    if (!TextUtils.isEmpty(str4) && str4.trim().equalsIgnoreCase(strB) && !TextUtils.isEmpty(str5) && str5.trim().equalsIgnoreCase(strB2)) {
                        if (g0.a) {
                            g0.b("young-hqd", "ignore song filter: " + str4 + " - " + str5);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean c() {
        if (f996g == null) {
            String strB = e.c.a.g.a.f.e.c.c().b(e.c.a.g.a.f.e.b.Q3, "");
            f996g = n(strB);
            Log.e("mhs_watch_xlog", "forceUploadList = " + strB);
        }
        String[] strArr = f996g;
        if (strArr != null && strArr.length > 0) {
            String strN = l1.n(KGApplication.getContext());
            for (String str : f996g) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strN) && strN.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String d() {
        return e.c.a.g.a.f.e.c.c().b(e.c.a.g.a.f.e.b.D1, "该歌曲暂无版权");
    }

    public static Set<String> e() {
        if (f997h == null) {
            s();
        }
        return f997h;
    }

    public static boolean f(KGMusic kGMusic) {
        if (kGMusic == null) {
            return true;
        }
        return k(String.valueOf(kGMusic.getMixId()), kGMusic.getArtistName(), kGMusic.getTrackName(), null, kGMusic.getAudioType(), kGMusic.source);
    }

    public static boolean g(KGSong kGSong) {
        if (kGSong == null) {
            return true;
        }
        return k(String.valueOf(kGSong.T1()), kGSong.j1(), h1.q(kGSong.l2(), kGSong.A2()), kGSong.v2(), kGSong.m1(), kGSong.q2());
    }

    public static boolean h(@NonNull String str) {
        if (f994e == null) {
            u();
        }
        String lowerCase = str.toLowerCase();
        String[] strArr = f994e;
        if (strArr != null) {
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2) && lowerCase.contains(str2.toLowerCase())) {
                    return true;
                }
            }
        }
        for (String str3 : j) {
            if (lowerCase.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(long j2) {
        String strValueOf = String.valueOf(j2);
        if (f997h == null) {
            s();
        }
        Set<String> set = f997h;
        if (set == null || !set.contains(strValueOf)) {
            return false;
        }
        String str = "music musicId:" + j2;
        if (g0.f()) {
            Log.e("mhs_watch_grade_filter", str);
        }
        f998i.add(str);
        return true;
    }

    public static boolean j(KGMusic kGMusic) {
        if (kGMusic == null) {
            return false;
        }
        if (f997h == null) {
            s();
        }
        String strValueOf = String.valueOf(kGMusic.getMixId());
        Set<String> set = f997h;
        if (set == null || !set.contains(strValueOf)) {
            return false;
        }
        String str = "music:" + kGMusic.getDisplayName() + ", music.getMixId = " + kGMusic.getMixId() + ", source = " + kGMusic.source;
        if (g0.f()) {
            Log.e("mhs_watch_grade_filter", str);
        }
        f998i.add(str);
        return true;
    }

    public static synchronized boolean k(String str, String str2, String str3, String str4, int i2, String str5) {
        if (b(str2, str3)) {
            return false;
        }
        if (e.c.a.g.a.s.e.b(i2) && e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.m1, false)) {
            if (g0.a) {
                g0.b("ContentFilter", "isFilter: filter isCommAudioBook ");
            }
            return true;
        }
        String lowerCase = h1.b(str2).trim().toLowerCase();
        String lowerCase2 = h1.b(str3).trim().toLowerCase();
        if (g0.a) {
            g0.b("ContentFilter", "isFilter: songName=" + lowerCase2 + "   singer=" + lowerCase);
        }
        if (!TextUtils.isEmpty(lowerCase) && h(lowerCase)) {
            if (g0.a) {
                g0.b("ContentFilter", "isFilter: filter singer : " + lowerCase);
            }
            return true;
        }
        if (TextUtils.isEmpty(lowerCase2)) {
            return false;
        }
        if (f993d == null) {
            o();
        }
        String[] strArr = f993d;
        if (strArr != null) {
            for (String str6 : strArr) {
                if (!TextUtils.isEmpty(str6) && lowerCase2.equalsIgnoreCase(str6)) {
                    if (g0.a) {
                        g0.b("ContentFilter", "isFilter: filter:" + lowerCase2);
                    }
                    return true;
                }
            }
        }
        if (b == null) {
            r();
        }
        String[] strArr2 = b;
        if (strArr2 != null) {
            for (String str7 : strArr2) {
                if (!TextUtils.isEmpty(str7)) {
                    String lowerCase3 = str7.toLowerCase();
                    if (lowerCase2.contains(lowerCase3)) {
                        if (g0.a) {
                            g0.b("ContentFilter", "isFilter: filter:" + lowerCase2);
                        }
                        return true;
                    }
                    if (!TextUtils.isEmpty(str4) && str4.contains(lowerCase3)) {
                        if (g0.a) {
                            g0.b("ContentFilter", "isFilter: filter:" + lowerCase2);
                        }
                        return true;
                    }
                }
            }
        }
        if (c == null) {
            t();
        }
        String[] strArr3 = c;
        if (strArr3 != null) {
            for (String str8 : strArr3) {
                if (!TextUtils.isEmpty(str8)) {
                    String lowerCase4 = str8.toLowerCase();
                    if (lowerCase2.matches(lowerCase4)) {
                        if (g0.a) {
                            g0.b("ContentFilter", "isFilter: filter:" + lowerCase2);
                        }
                        return true;
                    }
                    if (!TextUtils.isEmpty(str4) && str4.matches(lowerCase4)) {
                        if (g0.a) {
                            g0.b("ContentFilter", "isFilter: filter:" + lowerCase2);
                        }
                        return true;
                    }
                }
            }
        }
        if (f995f == null) {
            v();
        }
        Set<String> set = f995f;
        if (set != null && set.contains(str)) {
            if (g0.a) {
                g0.b("ContentFilter", "isFilter: filter:" + lowerCase2);
            }
            return true;
        }
        if (f997h == null) {
            s();
        }
        Set<String> set2 = f997h;
        if (set2 == null || !set2.contains(str)) {
            return false;
        }
        String str9 = "music:" + lowerCase2 + ", music.getMixId = " + str + ", source = " + str5;
        if (g0.f()) {
            Log.e("mhs_watch_grade_filter", str9);
        }
        f998i.add(str9);
        return true;
    }

    public static boolean l() {
        return e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.C1, true);
    }

    public static boolean m(KGMusicWrapper kGMusicWrapper) {
        String strB = e.c.a.g.a.f.j.c.d.b(kGMusicWrapper);
        if (strB == null) {
            return false;
        }
        return "43".equals(strB) || RoomMasterTable.DEFAULT_ID.equals(strB) || "41".equals(strB);
    }

    public static String[] n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return str.split(",");
        } catch (Exception unused) {
            return null;
        }
    }

    public static void o() {
        f993d = n(e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.u1));
        if (g0.a) {
            g0.b("ContentFilter", "isFilter: accurateArray:" + new Gson().toJson(f993d));
        }
    }

    public static void p() {
        if (l > 3) {
            return;
        }
        j0.b().a(new a());
    }

    public static synchronized void q() {
        Log.d("mhs_wacth_update", "updateConfig");
        l++;
        try {
            o();
            r();
            t();
            v();
            u();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void r() {
        b = n(e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.t1));
        if (g0.a) {
            g0.b("ContentFilter", "isFilter: fuzzyArray:" + new Gson().toJson(b));
        }
    }

    public static void s() {
        f997h = new HashSet();
        try {
            String[] strArrN = n(e.c.a.g.a.g.e.f.a(KGApplication.getContext()).b(e.c.a.g.a.g.e.f.c, ""));
            if (!l0.h(strArrN)) {
                Collections.addAll(f997h, strArrN);
            }
            e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.refresh_filtersong"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (g0.a) {
            g0.b("ContentFilter", "mhs_watch_grade_filter isFilter: getLimitSong:" + new Gson().toJson(f997h));
        }
    }

    public static void t() {
        c = n(e.c.a.g.a.f.e.c.c().b(e.c.a.g.a.f.e.b.s1, "Gloomy.*Sunday"));
        if (g0.a) {
            g0.b("ContentFilter", "isFilter: regexArray:" + new Gson().toJson(c));
        }
    }

    public static void u() {
        f994e = n(e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.w1));
    }

    public static void v() {
        f995f = new HashSet();
        String[] strArrN = n(e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.x1));
        if (!l0.h(strArrN)) {
            Collections.addAll(f995f, strArrN);
        }
        if (g0.a) {
            g0.b("ContentFilter", "isFilter: accurateArray:" + new Gson().toJson(f995f));
        }
    }

    public static void w() {
        try {
            Set<String> set = f998i;
            if (set != null && !set.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                boolean z = true;
                for (String str : f998i) {
                    if (!z) {
                        sb.append(",");
                    }
                    sb.append(str);
                    z = false;
                }
                RingBiReportHelper.INSTANCE.reportHeadGrade("getLimitSong 上传结果 通知上报过滤 = " + sb.toString(), "");
                f998i.clear();
            }
        } catch (Exception unused) {
        }
    }
}
