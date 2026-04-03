package e.c.a.g.a.d.d0;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import com.tencent.mars.xlog.Log;
import com.tencent.mars.xlog.Xlog;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.d;
import e.c.c.o.f;
import f.e0.n;
import f.u.i;
import f.z.d.j;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final c a = new c();
    public static boolean b = false;
    public static final String c = "KugouWatchApp";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f376d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f377e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f380h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f381i;
    public static final int j;
    public static boolean k;
    public static final int l;

    static {
        j.l("KugouWatchApp", ".mmap3");
        c.b bVar = e.c.a.g.a.f.e.c.a;
        boolean z = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.O3, 1) == 1;
        f379g = z;
        f380h = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.P3, 200);
        f381i = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.R3, 5);
        j = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.C, 26);
        k = z;
        l = 172800;
    }

    public final boolean a() {
        long jD = d.d(f.a());
        int i2 = f380h;
        if (jD >= 1048576 * i2) {
            return true;
        }
        RingBiReportHelper.INSTANCE.reportHeadFeedBack("当前存储空间低于" + i2 + "M，不做数据上传，请清理空间后尝试");
        return false;
    }

    public final void b(String str, String str2) {
        j.e(str, "tag");
        j.e(str2, NotificationCompat.CATEGORY_MESSAGE);
        if (f379g && k) {
            Log.d(str, str2);
        }
    }

    public final String c() {
        return f377e;
    }

    public final String d() {
        String str = f377e;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        Context context = KGApplication.getContext();
        j.d(context, "getContext()");
        return f(context);
    }

    public final boolean e() {
        return k;
    }

    public final String f(Context context) {
        j.e(context, "context");
        return j.l(context.getCacheDir().getAbsolutePath(), "/xlog_cache");
    }

    public final String g(Context context) {
        String path;
        j.e(context, "context");
        File fileJ = j(context);
        return (fileJ == null || (path = fileJ.getPath()) == null) ? "" : path;
    }

    public final boolean h() {
        return f378f;
    }

    public final String i() {
        return f376d;
    }

    public final File j(Context context) {
        File file;
        if (Build.VERSION.SDK_INT >= 29) {
            File[] externalFilesDirs = ContextCompat.getExternalFilesDirs(context, "xlog");
            j.d(externalFilesDirs, "getExternalFilesDirs(context, \"xlog\")");
            File file2 = (File) i.i(externalFilesDirs);
            if (file2 == null) {
                return null;
            }
            file = new File(file2, "xlog");
        } else {
            file = new File(((Object) Environment.getExternalStorageDirectory().getAbsolutePath()) + "/Android/data/" + ((Object) context.getPackageName()) + "/files/xlog");
        }
        return file;
    }

    public final int k() {
        return f381i;
    }

    public final String l() {
        String str = f376d;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        Context context = KGApplication.getContext();
        j.d(context, "getContext()");
        return g(context);
    }

    public final String m() {
        String strL = f377e;
        if (TextUtils.isEmpty(strL)) {
            Context context = KGApplication.getContext();
            j.d(context, "getContext()");
            strL = f(context);
        }
        if (TextUtils.isEmpty(strL)) {
            return "";
        }
        String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
        j.d(str, "sdf.format(date)");
        if (!n.k(strL, "/", false, 2, null)) {
            strL = j.l(strL, "/");
        }
        return strL + c + '_' + str + ".xlog";
    }

    public final String n() {
        String strL = f376d;
        if (TextUtils.isEmpty(strL)) {
            Context context = KGApplication.getContext();
            j.d(context, "getContext()");
            strL = g(context);
        }
        if (TextUtils.isEmpty(strL)) {
            return "";
        }
        String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
        j.d(str, "sdf.format(date)");
        if (!n.k(strL, "/", false, 2, null)) {
            strL = j.l(strL, "/");
        }
        return strL + c + '_' + str + ".xlog";
    }

    public final String o() {
        return c;
    }

    public final void p(String str, String str2) {
        j.e(str, "tag");
        j.e(str2, NotificationCompat.CATEGORY_MESSAGE);
        if (f379g && k) {
            Log.i(str, str2);
        }
    }

    public final void q(Context context, String str) {
        j.e(context, "context");
        j.e(str, "pubKey");
        if (!f379g) {
            android.util.Log.e("mhs_watch_xlog", "xlog is not enable");
            return;
        }
        if (b) {
            return;
        }
        try {
            long jD = d.d(f.a());
            int i2 = f380h;
            boolean z = jD > ((long) (1048576 * i2));
            k = z;
            if (!z) {
                RingBiReportHelper.INSTANCE.reportHeadFeedBack("当前存储空间低于" + i2 + "MB，不做数据写入");
            }
            boolean z2 = k && Build.VERSION.SDK_INT >= j;
            k = z2;
            if (!z2) {
                RingBiReportHelper.INSTANCE.reportHeadFeedBack("存储空间较小或者小于指定的sdk版本，直接retun");
                return;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        System.loadLibrary("c++_shared");
        System.loadLibrary("marsxlog");
        f376d = g(context);
        String strF = f(context);
        new File(strF).mkdirs();
        f377e = strF;
        try {
            android.util.Log.e("mhs_watch_xlog", "logDir = " + f376d + ", cacheDir = " + f377e + ", logVersion = 0, pubKey = " + str + ", getXLogPath = " + n() + ", getXLogCachePath = " + m());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        Xlog xlog = new Xlog();
        c cVar = a;
        xlog.appenderOpen(0, 0, cVar.c(), cVar.i(), cVar.o(), 2);
        xlog.setMaxAliveTime(0L, l);
        xlog.setMaxFileSize(0L, 4194304L);
        Log.setLogImp(xlog);
        Log.setConsoleLogOpen(false);
        try {
            boolean zC = e.c.a.g.a.g.o.b.c();
            f378f = zC;
            if (!zC) {
                e.c.a.g.a.f.m.b.m().G();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("forceUploadXlogContent = ");
            sb.append(f378f);
            sb.append(", canWriteLog = ");
            sb.append(k);
            sb.append(", Build.VERSION.SDK_INT >= xlogMinAllowSdk = ");
            int i3 = Build.VERSION.SDK_INT;
            int i4 = j;
            sb.append(i3 >= i4);
            sb.append(", xlogMinAllowSdk = ");
            sb.append(i4);
            sb.append(", Build.VERSION.SDK_INT = ");
            sb.append(i3);
            sb.append(", 是否已经强制上传过 = ");
            sb.append(e.c.a.g.a.f.m.b.m().B());
            android.util.Log.e("mhs_watch_xlog", sb.toString());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        b = true;
    }

    public final boolean r() {
        return f379g;
    }

    public final void s() {
        if (b) {
            Log.appenderClose();
            b = false;
        }
    }

    public final void t(boolean z) {
        k = z;
    }
}
