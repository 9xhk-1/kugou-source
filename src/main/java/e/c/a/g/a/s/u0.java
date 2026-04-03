package e.c.a.g.a.s;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.room.RoomMasterTable;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.network.NetRequestDialog;
import com.kugou.common.permission.KGPermission;
import com.kugou.common.permission.Permission;
import com.kugou.datacollect.bi.use.TraceFullTask;
import java.util.Random;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public class u0 {
    public static boolean a = false;
    public static final boolean b = u(e.c.a.g.a.f.e.b.d4, 0);
    public static final boolean c = u(e.c.a.g.a.f.e.b.e4, 100);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f1225d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f1226e = false;

    public class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            boolean unused = u0.f1226e = false;
            if (e.c.a.g.a.f.m.c.a.e("once_request_mobile_net", false)) {
                this.a.run();
            }
        }
    }

    public class b implements DialogInterface.OnDismissListener {
        public final /* synthetic */ Runnable a;

        public b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            boolean unused = u0.f1226e = false;
            this.a.run();
        }
    }

    public class c implements Action1<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Throwable b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Throwable f1227d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f1228f;

        public c(int i2, Throwable th, Throwable th2, String str) {
            this.a = i2;
            this.b = th;
            this.f1227d = th2;
            this.f1228f = str;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(String str) {
            String str2 = "";
            try {
                YoungBITask source = new YoungBITask(22020024, "statistics").setSource("" + this.a);
                StringBuilder sb = new StringBuilder();
                String str3 = "1";
                sb.append(u0.q(KGApplication.getContext()) ? "1" : "0");
                sb.append("_");
                sb.append(u0.l(KGApplication.getContext()) ? "1" : "0");
                sb.append("_");
                sb.append(u0.w(KGApplication.getContext()) ? "1" : "0");
                sb.append("_");
                if (!u0.p(KGApplication.getContext())) {
                    str3 = "0";
                }
                sb.append(str3);
                TraceFullTask ivar1 = source.setState(sb.toString()).setIvar1("调用stack = \n" + Log.getStackTraceString(this.b));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("异常stack = \n");
                if (this.f1227d != null) {
                    str2 = "" + u0.k(this.f1227d);
                }
                sb2.append(str2);
                e.c.a.g.a.e.b.b(ivar1.setIvar2(sb2.toString()).setIvar3(this.f1228f));
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.e("22020024", "1, e = " + e2);
            }
        }
    }

    public static void A(int i2, String str, String str2) {
        B(i2, str, str2, null);
    }

    public static void B(int i2, String str, String str2, Throwable th) {
        boolean z = b;
        if (z) {
            try {
                Log.d("mhs_watch", "reportNetWorkStatusInfo, statue isEnable = " + z + ", isCommonNetworkEnable = " + c);
                m1.d(500, new c(i2, new Throwable(str), th, str2));
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.e("22020024", "2, e = " + e2);
            }
        }
    }

    public static void C(int i2, String str, Throwable th) {
        B(i2, str, "", th);
    }

    public static void c(Context context, String str, Runnable runnable) {
        if (!f1226e && h(e.c.c.o.f.a()) == 2) {
            if (e.c.a.g.a.f.m.c.a.e("once_request_mobile_net", false)) {
                runnable.run();
                return;
            }
            NetRequestDialog netRequestDialog = new NetRequestDialog(context, str, true);
            netRequestDialog.setOnDismissListener(new b(runnable));
            netRequestDialog.show();
            f1226e = true;
        }
    }

    public static void d(Context context, Runnable runnable) {
        KGMusicWrapper currentSong = e.c.a.g.a.d.x.h.y().getCurrentSong();
        if (currentSong != null && RoomMasterTable.DEFAULT_ID.equals(e.c.a.g.a.f.j.c.d.b(currentSong))) {
            runnable.run();
            return;
        }
        if (context == null) {
            context = KGApplication.getContext();
        }
        if (m(context)) {
            if (l1.V()) {
                f(context, "当前没有连接Wi-Fi，是否启用流量？", runnable);
            } else {
                runnable.run();
            }
        }
    }

    public static void e(Context context, Runnable runnable) {
        f(context, "当前没有连接Wi-Fi，是否用流量播放？", runnable);
    }

    public static void f(Context context, String str, Runnable runnable) {
        if (f1226e) {
            return;
        }
        int iH = h(e.c.c.o.f.a());
        if (iH == 1) {
            p1.h(context, "无可用网络\n请检查后再试");
            return;
        }
        if (iH != 2) {
            if (iH != 3) {
                return;
            }
            runnable.run();
        } else {
            if (e.c.a.g.a.f.m.c.a.e("once_request_mobile_net", false)) {
                runnable.run();
                return;
            }
            NetRequestDialog netRequestDialog = new NetRequestDialog(context, str, false);
            netRequestDialog.setOnDismissListener(new a(runnable));
            netRequestDialog.show();
            f1226e = true;
        }
    }

    public static boolean g(Context context) {
        if (context == null || v(context)) {
            return false;
        }
        return x(context);
    }

    public static int h(Context context) {
        ConnectivityManager connectivityManager = context != null ? (ConnectivityManager) context.getSystemService("connectivity") : null;
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return 1;
        }
        return activeNetworkInfo.getType() == 1 ? 3 : 2;
    }

    public static int i(TelephonyManager telephonyManager) {
        if (telephonyManager == null) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return telephonyManager.getNetworkType();
            }
            if (KGPermission.uCantAskMePermissionState(KGApplication.getContext(), Permission.READ_PHONE_STATE)) {
                return telephonyManager.getNetworkType();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String j(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null) {
            try {
                connectivityManager = (ConnectivityManager) e.c.c.o.f.a().getSystemService("connectivity");
            } catch (Exception e2) {
                e2.printStackTrace();
                connectivityManager = null;
            }
        } else {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            return "unknown";
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "nonetwork";
            }
            if (activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 9) {
                return "wifi";
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "3G";
            }
            int i2 = i(telephonyManager);
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    return "3G";
                case 13:
                    return "4G";
                case 16:
                default:
                    Log.d("kugou", "getNetworkType returns a unknown value:" + i2);
                    return "3G";
            }
        } catch (Exception | OutOfMemoryError unused) {
            return "unknown";
        }
    }

    public static String k(Throwable th) {
        StringBuilder sb = new StringBuilder();
        if (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (stackTraceElement != null) {
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public static boolean l(Context context) {
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) e.c.c.o.f.a().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnectedOrConnecting();
                }
                return false;
            } catch (Exception e2) {
                g0.k(e2);
            }
        }
        return false;
    }

    public static boolean m(Context context) {
        return n(context, true);
    }

    public static boolean n(Context context, boolean z) {
        if (l1.m0() && g(context)) {
            return false;
        }
        if (r(context)) {
            return true;
        }
        if (z) {
            p1.h(context, "无可用网络\n请检查后再试");
        }
        return false;
    }

    public static boolean o(Context context) {
        String str;
        Exception exc;
        String str2 = null;
        Exception exc2 = null;
        boolean z = false;
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) e.c.c.o.f.a().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 0) {
                        z = true;
                    }
                }
                exc = null;
            } catch (Exception e2) {
                exc2 = e2;
                if (g0.a) {
                    exc2.printStackTrace();
                }
                str = "isMobileAvailable-Exception";
                Exception exc3 = exc2;
                str2 = str;
                exc = exc3;
            }
            if (c && !f1225d && !z) {
                C(3, str2, exc);
            }
            return z;
        }
        str = "isMobileAvailable context = null";
        Exception exc32 = exc2;
        str2 = str;
        exc = exc32;
        if (c) {
            C(3, str2, exc);
        }
        return z;
    }

    public static boolean p(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) e.c.c.o.f.a().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return activeNetworkInfo.getType() == 0;
        } catch (Exception e2) {
            if (g0.a) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public static boolean q(Context context) {
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) e.c.c.o.f.a().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
                return false;
            } catch (Exception e2) {
                g0.k(e2);
            }
        }
        return false;
    }

    public static boolean r(Context context) {
        String str;
        Exception exc;
        String str2 = null;
        Exception exc2 = null;
        boolean z = false;
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) e.c.c.o.f.a().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.isConnected()) {
                        z = true;
                    }
                }
                exc = null;
            } catch (Exception e2) {
                exc2 = e2;
                g0.k(exc2);
                str = "isNetworkConected-Exception";
                Exception exc3 = exc2;
                str2 = str;
                exc = exc3;
            }
            f1225d = z;
            if (c && !z) {
                C(1, str2, exc);
            }
            return z;
        }
        str = "isNetworkConected context = null";
        Exception exc32 = exc2;
        str2 = str;
        exc = exc32;
        f1225d = z;
        if (c) {
            C(1, str2, exc);
        }
        return z;
    }

    public static boolean s(Context context) {
        return e.c.a.g.a.f.m.c.a.e("OFFLINE_MODE", false) && !"wifi".equals(j(context));
    }

    public static boolean t(float f2) {
        if (g0.a) {
            g0.b("SystemUtils", "isPicked percent= " + f2);
        }
        if (f2 <= 0.0f) {
            return false;
        }
        return f2 >= 100.0f || new Random().nextFloat() < f2 / 100.0f;
    }

    public static boolean u(ConfigKey configKey, int i2) {
        try {
            return t(e.c.a.g.a.f.e.c.c().getConfigAsInt(configKey, i2));
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean v(Context context) {
        String str;
        Exception exc;
        String str2 = null;
        Exception exc2 = null;
        boolean z = false;
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) e.c.c.o.f.a().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 1) {
                        z = true;
                    }
                }
                exc = null;
            } catch (Exception e2) {
                exc2 = e2;
                if (g0.a) {
                    exc2.printStackTrace();
                }
                str = "isWifiConnected-Exception";
                Exception exc3 = exc2;
                str2 = str;
                exc = exc3;
            }
            if (c && !f1225d && !z) {
                C(2, str2, exc);
            }
            return z;
        }
        str = "isWifiConnected context = null";
        Exception exc32 = exc2;
        str2 = str;
        exc = exc32;
        if (c) {
            C(2, str2, exc);
        }
        return z;
    }

    public static boolean w(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) e.c.c.o.f.a().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return activeNetworkInfo.getType() == 1;
        } catch (Exception e2) {
            if (g0.a) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public static boolean x(Context context) {
        boolean zB = new t0(context).b(context.getPackageName());
        if (zB) {
            p1.f(context, "您的网络已被家长禁用");
            e.c.a.g.a.d.d0.a.a("Parent", "parent lock");
        }
        return zB;
    }

    public static boolean y(Context context) {
        if (h(e.c.c.o.f.a()) == 2) {
            return !e.c.a.g.a.f.m.c.a.e("once_request_mobile_net", false);
        }
        return false;
    }

    public static void z(int i2, String str) {
        B(i2, str, "", null);
    }
}
