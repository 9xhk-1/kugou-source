package e.c.a.g.a.g.g.d;

import android.annotation.SuppressLint;
import android.util.Log;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.p;
import e.c.a.g.a.s.q;
import e.c.c.o.f;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static int a = c.c().getConfigAsInt(e.c.a.g.a.f.e.b.B, 3);

    public static void a() throws Throwable {
        String str = new b(f.a()).a().a;
        c(str, "Core.db");
        d(str, "app_info.xml");
        b(str, "mmkv.default");
        b(str, "mmkv.default.crc");
    }

    public static void b(String str, String str2) throws Throwable {
        String str3 = ("/data/data/" + str) + "/shared_prefs/files/mmkv" + str2;
        String str4 = e.c.a.g.a.f.f.a.q + str2;
        p.e(str4);
        p.a(str3, str4);
    }

    @SuppressLint({"SdCardPath"})
    public static void c(String str, String str2) throws Throwable {
        String str3 = ("/data/data/" + str) + "/databases/" + str2;
        String str4 = e.c.a.g.a.f.f.a.q + str2;
        q.k(str4);
        p.a(str3, str4);
    }

    public static void d(String str, String str2) throws Throwable {
        String str3 = ("/data/data/" + str) + "/shared_prefs/" + str2;
        String str4 = e.c.a.g.a.f.f.a.q + str2;
        p.e(str4);
        p.a(str3, str4);
    }

    public static void e() throws Throwable {
        String str = e.c.a.g.a.f.f.a.r;
        e.c.a.g.a.d.d0.b bVar = e.c.a.g.a.d.d0.b.a;
        e.c.a.g.a.d.d0.c cVar = e.c.a.g.a.d.d0.c.a;
        bVar.a(bVar.c(cVar.c(), 4), str);
        Log.e("mhs_watch_xlog", "getXLogPath = " + cVar.n() + ", target = " + str);
    }

    public static int f(String str) {
        try {
            String[] strArrSplit = e.c.a.g.a.f.m.b.m().n().split("_");
            if (str.equals(strArrSplit[0])) {
                return Integer.parseInt(strArrSplit[1]);
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0141  */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void g(java.lang.String r29, int r30) {
        /*
            Method dump skipped, instruction units count: 1461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.g.g.d.a.g(java.lang.String, int):void");
    }
}
