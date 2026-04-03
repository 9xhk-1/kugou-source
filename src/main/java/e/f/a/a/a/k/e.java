package e.f.a.a.a.k;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static boolean a = true;
    public static boolean b = true;
    public static StringBuilder c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f1366d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f1367e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f1368f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Context f1369g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f1370h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f1371i = false;
    public static final Object j = new Object();

    public static class a {
        public boolean a;
        public File b;
    }

    static {
        try {
            new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            c.d(th.getCause());
        }
    }

    public static byte[] a() {
        if (b) {
            return f.O(null, c.toString(), "FireEyeLog.txt");
        }
        return null;
    }

    public static byte[] b() {
        return a ? a() : d();
    }

    public static String c() {
        e.f.a.a.a.d dVar;
        try {
            e.f.a.a.a.h.b bVarM = e.f.a.a.a.h.b.m();
            if (bVarM == null || (dVar = bVarM.h0) == null) {
                return null;
            }
            return dVar.getLogFromNative();
        } catch (Throwable th) {
            if (c.k(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] d() {
        if (!b) {
            return null;
        }
        if (f1371i) {
            c.f("[LogUtil] Get user log from native.", new Object[0]);
            String strC = c();
            if (strC != null) {
                c.f("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(strC.length()));
                return f.O(null, strC, "FireEyeNativeLog.txt");
            }
        }
        StringBuilder sb = new StringBuilder();
        synchronized (j) {
            a aVar = f1366d;
            if (aVar != null && aVar.a && f1366d.b != null && f1366d.b.length() > 0) {
                sb.append(f.e(f1366d.b, 30720, true));
            }
            StringBuilder sb2 = c;
            if (sb2 != null && sb2.length() > 0) {
                sb.append(c.toString());
            }
        }
        return f.O(null, sb.toString(), "FireEyeLog.txt");
    }

    public static synchronized void e(Context context) {
        if (f1370h || context == null || !b) {
            return;
        }
        try {
            Executors.newSingleThreadExecutor();
            c = new StringBuilder(0);
            f1369g = context;
            e.f.a.a.a.h.b bVarE = e.f.a.a.a.h.b.e(context);
            f1367e = bVarE.f1346f;
            Objects.requireNonNull(bVarE);
            f1368f = "";
            String str = f1369g.getFilesDir().getPath() + "/fireeyelog_" + f1367e + "_" + f1368f + ".txt";
            Process.myPid();
        } catch (Throwable unused) {
        }
        f1370h = true;
    }
}
