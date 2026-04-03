package e.f.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import e.f.a.a.a.k.e;
import e.f.a.a.a.k.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static List<a> a = new ArrayList();
    public static boolean b;
    public static e.f.a.a.a.g.b c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f1325d;

    public static synchronized void a(a aVar) {
        if (!a.contains(aVar)) {
            a.add(aVar);
        }
    }

    public static boolean b(e.f.a.a.a.h.b bVar) {
        List<String> list = bVar.K;
        Objects.requireNonNull(bVar);
        return list != null && list.contains("fireeye");
    }

    public static synchronized void c(Context context, String str, boolean z, b bVar) {
        if (f1325d) {
            e.f.a.a.a.k.c.j("[init] initial Multi-times, ignore this.", new Object[0]);
            return;
        }
        if (context == null) {
            Log.w(e.f.a.a.a.k.c.b, "[init] context is null, check it.");
            return;
        }
        if (str == null) {
            Log.e(e.f.a.a.a.k.c.b, "init arg 'crashReportAppID' should not be null!");
            return;
        }
        f1325d = true;
        if (z) {
            b = true;
            e.f.a.a.a.k.c.c = true;
            e.f.a.a.a.k.c.j("FireEye debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
            e.f.a.a.a.k.c.c("--------------------------------------------------------------------------------------------", new Object[0]);
            e.f.a.a.a.k.c.j("FireEye debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
            e.f.a.a.a.k.c.j("[1] 输出详细的FireEye SDK的Log -- More detailed log of FireEye SDK will be output to logcat;", new Object[0]);
            e.f.a.a.a.k.c.j("[2] 每一条Crash都会被立即上报 -- Every crash caught by FireEye will be uploaded immediately.", new Object[0]);
            e.f.a.a.a.k.c.j("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
            e.f.a.a.a.k.c.c("--------------------------------------------------------------------------------------------", new Object[0]);
            e.f.a.a.a.k.c.i("[init] Open debug mode of FireEye.", new Object[0]);
        }
        e.f.a.a.a.k.c.f(" crash report start initializing...", new Object[0]);
        e.f.a.a.a.k.c.i("[init] FireEye start initializing...", new Object[0]);
        e.f.a.a.a.k.c.f("[init] FireEye complete version: v%s", "2.4.14");
        Context contextD = f.d(context);
        e.f.a.a.a.h.b bVarE = e.f.a.a.a.h.b.e(contextD);
        bVarE.E();
        e.e(contextD);
        c = e.f.a.a.a.g.b.s(contextD, a);
        e.f.a.a.a.j.d.j(contextD);
        e.f.a.a.a.i.a aVarJ = e.f.a.a.a.i.a.j(contextD, a);
        e.f.a.a.a.f.b bVarE2 = e.f.a.a.a.f.b.e(contextD);
        if (b(bVarE)) {
            return;
        }
        bVarE.J(str);
        e.f.a.a.a.k.c.f("[param] Set APP ID:%s", str);
        d(bVar, bVarE);
        for (int i2 = 0; i2 < a.size(); i2++) {
            try {
                if (bVarE2.d(a.get(i2).a)) {
                    a.get(i2).b(contextD, z, bVar);
                }
            } catch (Throwable th) {
                if (!e.f.a.a.a.k.c.k(th)) {
                    th.printStackTrace();
                }
            }
        }
        e.f.a.a.a.e.b.r(contextD, bVar);
        aVarJ.k(bVar != null ? bVar.c() : 0L);
        e.f.a.a.a.k.c.i("[init] FireEye initialization finished.", new Object[0]);
    }

    public static void d(b bVar, e.f.a.a.a.h.b bVar2) {
        byte[] bArr;
        if (bVar == null) {
            return;
        }
        String strD = bVar.d();
        if (!TextUtils.isEmpty(strD)) {
            if (strD.length() > 100) {
                String strSubstring = strD.substring(0, 100);
                e.f.a.a.a.k.c.j("appVersion %s length is over limit %d substring to %s", strD, 100, strSubstring);
                strD = strSubstring;
            }
            bVar2.K(strD);
            e.f.a.a.a.k.c.f("[param] Set App version: %s", bVar.d());
        }
        try {
            if (bVar.i()) {
                String strA = bVar.a();
                if (!TextUtils.isEmpty(strA)) {
                    if (strA.length() > 100) {
                        String strSubstring2 = strA.substring(0, 100);
                        e.f.a.a.a.k.c.j("appChannel %s length is over limit %d substring to %s", strA, 100, strSubstring2);
                        strA = strSubstring2;
                    }
                    c.D(556, "app_channel", strA.getBytes(), null, false);
                    bVar2.D = strA;
                }
            } else {
                Map<String, byte[]> mapV = c.v(556, null, true);
                if (mapV != null && (bArr = mapV.get("app_channel")) != null) {
                    bVar2.D = new String(bArr);
                }
            }
            e.f.a.a.a.k.c.f("[param] Set App channel: %s", bVar2.D);
        } catch (Exception e2) {
            if (b) {
                e2.printStackTrace();
            }
        }
        String strB = bVar.b();
        if (!TextUtils.isEmpty(strB)) {
            if (strB.length() > 100) {
                String strSubstring3 = strB.substring(0, 100);
                e.f.a.a.a.k.c.j("appPackageName %s length is over limit %d substring to %s", strB, 100, strSubstring3);
                strB = strSubstring3;
            }
            bVar2.f1345e = strB;
            e.f.a.a.a.k.c.f("[param] Set App package: %s", bVar.b());
        }
        String strE = bVar.e();
        if (strE != null) {
            if (strE.length() > 100) {
                String strSubstring4 = strE.substring(0, 100);
                e.f.a.a.a.k.c.j("deviceId %s length is over limit %d substring to %s", strE, 100, strSubstring4);
                strE = strSubstring4;
            }
            bVar2.L(strE);
            e.f.a.a.a.k.c.f("[param] Set device ID: %s", strE);
        }
        bVar2.f1348h = bVar.j();
        e.b = bVar.h();
    }
}
