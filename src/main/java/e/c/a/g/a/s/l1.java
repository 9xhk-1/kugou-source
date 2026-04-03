package e.c.a.g.a.s;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.content.ContextCompat;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.network.ExceptionParse;
import com.kugou.common.permission.KGPermission;
import com.kugou.common.permission.Permission;
import com.kugou.common.permission.particular.setting.CheckWriteSettingPermissionUtils;
import com.kugou.common.utils.SecretAccess;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class l1 {
    public static String a = null;

    @Nullable
    public static Class<?> b = null;

    @Nullable
    public static Class<?> c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f1212d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f1213e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f1214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Boolean f1215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Integer f1216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Boolean f1217i;

    /* JADX INFO: loaded from: classes2.dex */
    public static class a {
        public final String a;

        public a(boolean z, String str, String str2) {
            this.a = str;
        }
    }

    public static int A() {
        return Build.VERSION.SDK_INT;
    }

    public static String B(long j) {
        if (j <= 0) {
            return "0.0M";
        }
        if (j > 0 && j < 102400) {
            return "0.1M";
        }
        return h1.c("#.#", (j / 1024.0f) / 1024.0f) + "M";
    }

    public static a C(boolean z) {
        return new a(L(), (String) (z ? v() : w()).first, (String) (z ? v() : w()).second);
    }

    @TargetApi(16)
    public static String D(Context context) {
        if (A() < 16) {
            return E();
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return String.valueOf((memoryInfo.totalMem / 1024) / 1024);
    }

    public static String E() {
        return String.valueOf(F());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    public static long F() throws Throwable {
        FileReader fileReader;
        Throwable th;
        IOException e2;
        BufferedReader bufferedReader;
        ?? r0 = "/proc/meminfo";
        try {
            try {
                fileReader = new FileReader("/proc/meminfo");
            } catch (IOException e3) {
                fileReader = null;
                e2 = e3;
                bufferedReader = null;
            } catch (Throwable th2) {
                fileReader = null;
                th = th2;
                r0 = 0;
            }
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
            } catch (IOException e4) {
                e2 = e4;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                r0 = 0;
                y.a(fileReader);
                y.a(r0);
                throw th;
            }
            try {
                jIntValue = bufferedReader.readLine() != null ? Integer.valueOf(r1.split("\\s+")[1]).intValue() : 0L;
                bufferedReader.close();
            } catch (IOException e5) {
                e2 = e5;
                g0.i(e2);
            }
            y.a(fileReader);
            y.a(bufferedReader);
            return jIntValue / 1024;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static int G() {
        return e.c.a.g.a.r.e.b.c(KGApplication.getContext());
    }

    public static boolean H() {
        return KGPermission.uCantAskMePermissionState(e.c.c.o.f.a(), Permission.READ_PHONE_STATE);
    }

    public static void I(Activity activity) {
        InputMethodManager inputMethodManager;
        View currentFocus;
        if (activity == null || (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) == null || !inputMethodManager.isActive() || (currentFocus = activity.getCurrentFocus()) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public static void J(Context context, View view) {
        if (context != null) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
                if (inputMethodManager == null || view == null || !inputMethodManager.isActive(view)) {
                    return;
                }
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean K() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean L() {
        return f1212d;
    }

    public static boolean M() {
        return !TextUtils.isEmpty(e.c.c.e.a);
    }

    public static boolean N() {
        if (Q("158")) {
            return true;
        }
        return "158".equals(j());
    }

    public static boolean O(String str, String str2) {
        String upperCase = str.toUpperCase();
        if (upperCase.equals("MP3") || upperCase.equals("FLAC") || upperCase.equals("APE")) {
            return true;
        }
        return upperCase.equals("M4A") && !TextUtils.isEmpty(str2);
    }

    public static boolean P() {
        return "d3".equalsIgnoreCase(q());
    }

    public static boolean Q(String str) {
        int iA;
        if (!g0.a || (iA = e.c.a.g.a.c.a.a.a()) <= 0) {
            return false;
        }
        return String.valueOf(iA).equals(str);
    }

    public static boolean R() {
        if (f1216h == null) {
            f1216h = Integer.valueOf(Settings.Global.getInt(KGApplication.getApplication().getContentResolver(), "com.xxun.is_special_screen", -1));
        }
        return f1216h.intValue() == -1 || f1216h.intValue() == 1;
    }

    public static boolean S() {
        if (f1215g == null) {
            f1215g = Boolean.valueOf(e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.P2, false));
        }
        return f1215g.booleanValue();
    }

    public static boolean T() {
        return (X() || b0() || f0()) ? false : true;
    }

    public static boolean U() {
        if (Q("154")) {
            return true;
        }
        return k0() && "154".equals(j());
    }

    public static boolean V() {
        if (Q("151")) {
            return true;
        }
        return "huawei".equalsIgnoreCase(p());
    }

    public static boolean W(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static boolean X() {
        return Z() || Y();
    }

    public static boolean Y() {
        if (Q("161")) {
            return true;
        }
        return "161".equals(j());
    }

    public static boolean Z() {
        if (Q("157")) {
            return true;
        }
        return "157".equals(j());
    }

    public static void a(Context context) {
        Object systemService = context.getSystemService("statusbar");
        try {
            Class<?> cls = Class.forName("android.app.StatusBarManager");
            (Build.VERSION.SDK_INT >= 17 ? cls.getMethod("collapsePanels", new Class[0]) : cls.getMethod("collapse", new Class[0])).invoke(systemService, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a0() {
        if (f1217i == null) {
            f1217i = Boolean.valueOf("1".equals(k1.a("ro.sgtc.windowisround")));
        }
        return f1217i.booleanValue();
    }

    public static long b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jM = e.c.a.g.a.r.b.m();
        if (jM <= 0) {
            if (g0.a) {
                g0.b("SystemUtils", "currentTime in Millis : " + k.b(jCurrentTimeMillis));
            }
            return jCurrentTimeMillis;
        }
        long jElapsedRealtime = jM + SystemClock.elapsedRealtime();
        if (g0.a) {
            g0.b("SystemUtils", "serverTime in Millis : " + k.b(jElapsedRealtime));
        }
        return jElapsedRealtime;
    }

    public static boolean b0() {
        if (Q(ExceptionParse.NET_ISP_GATEWAY_BUSY) || Q("162")) {
            return true;
        }
        String strJ = j();
        return ExceptionParse.NET_ISP_GATEWAY_BUSY.equals(strJ) || "162".equals(strJ);
    }

    public static int c(float f2) {
        return d(e.c.c.o.f.a(), f2);
    }

    public static boolean c0() {
        return X() || b0();
    }

    public static int d(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean d0() {
        String strP = p();
        return "mi kids".equalsIgnoreCase(strP) || "mikids".equalsIgnoreCase(strP);
    }

    public static int e(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }

    public static boolean e0() {
        return "MiKidsSmartWatch_4PRO".equalsIgnoreCase(q());
    }

    public static int f() {
        try {
            return Integer.parseInt(e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.c));
        } catch (NumberFormatException unused) {
            return 3337;
        }
    }

    public static boolean f0() {
        if (Q("153")) {
            return true;
        }
        return "oppo".equalsIgnoreCase(p());
    }

    public static String g() {
        String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f642d);
        return TextUtils.isEmpty(config) ? "9FUAroQHHdX8ngYHdTg5v1m9LiX0rX8d" : config;
    }

    public static boolean g0() {
        if (Q(ExceptionParse.NET_RESPONSE_502)) {
            return true;
        }
        String strP = p();
        return (strP == null ? "" : strP.toLowerCase()).contains("qihoo") || h0();
    }

    public static String h() {
        String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f645g);
        return TextUtils.isEmpty(config) ? "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCne54UAsqsxPOLTSBJrG3Ihm5p09g65siECkyuR+2Qc7x+kfTxET/IhDasM2o5Ql+enIyzcMDqwvmNbfbuvPe9UH8umxEU5N1TS7OJdJANmzjKNHFUo3oWC/TOFUY3QpiZIv57T0NFpMo/48Hys1D5b161HjsG7L3J5uW3BZDW+wIDAQAB" : config;
    }

    public static boolean h0() {
        return k0() && ExceptionParse.NET_RESPONSE_502.equals(j());
    }

    public static long i(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return (memoryInfo.availMem / 1024) / 1024;
    }

    public static boolean i0() {
        return q().equals("SIM-AL00");
    }

    public static String j() {
        if (g0.a) {
            int iA = e.c.a.g.a.c.a.a.a();
            if (iA > 0) {
                return String.valueOf(iA);
            }
            if (!TextUtils.isEmpty("")) {
                return "";
            }
        }
        if (a == null) {
            e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
            String strD = cVar.d("sp_key_app_channel", "");
            if (TextUtils.isEmpty(strD)) {
                if (!m0() || TextUtils.isEmpty(s())) {
                    strD = e.d.a.a.g.b(KGApplication.getContext());
                    if (TextUtils.isEmpty(strD)) {
                        Log.e("youth_watch", "get channel fail！！！！！！！！");
                        strD = k0() ? "154" : "150";
                    }
                } else {
                    Log.d("youth_watch", "watch_tag_by_package");
                    strD = "748";
                }
                cVar.i("sp_key_app_channel", strD);
            }
            a = strD;
            Log.d("youth_watch", "channel=" + a);
        }
        return a;
    }

    public static boolean j0() {
        return CheckWriteSettingPermissionUtils.checkHasPermission(KGApplication.getContext());
    }

    public static int k(Context context) {
        try {
            return ((AudioManager) context.getSystemService("audio")).getStreamVolume(3);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 1;
        }
    }

    public static boolean k0() {
        String strP = p();
        return strP != null && strP.toLowerCase().contains("sprd");
    }

    public static String l(Context context) {
        return !e.c.a.g.a.f.m.c.a.e("key_agree_privacy", false) ? "" : t(true).a;
    }

    public static boolean l0(Context context) {
        return "wifi".equals(o(context));
    }

    @SuppressLint({"MissingPermission"})
    public static String m() {
        String str = "";
        String str2 = f1214f;
        if (str2 != null) {
            return str2;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) e.c.c.o.f.a().getSystemService("phone");
            if (telephonyManager != null && telephonyManager.getSimState() == 5) {
                String subscriberId = telephonyManager.getSubscriberId();
                if (subscriberId != null) {
                    str = subscriberId;
                }
                f1214f = str;
            }
        } catch (SecurityException unused) {
        }
        return str;
    }

    public static boolean m0() {
        if (Q("150")) {
            return true;
        }
        return "xtc".equalsIgnoreCase(p());
    }

    public static String n(Context context) {
        return h1.j(l(context));
    }

    public static boolean n0() {
        return Q("155") || o0() || d0();
    }

    public static String o(Context context) {
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
            int i2 = u0.i(telephonyManager);
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

    public static boolean o0() {
        return "xiaoxun".equalsIgnoreCase(p());
    }

    public static String p() {
        return Build.BRAND;
    }

    public static boolean p0(Context context, String str) {
        return context != null && ContextCompat.checkSelfPermission(context, str) == -1;
    }

    public static String q() {
        return Build.MODEL;
    }

    public static int q0(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String r(Context context) {
        return b0.b(context);
    }

    public static void r0(boolean z, Class<?> cls) {
        synchronized (f1213e) {
            f1212d = z;
            b = cls;
        }
    }

    public static String s() {
        try {
            Bundle bundleCall = e.c.c.o.f.a().getContentResolver().call(Uri.parse("content://com.xtc.preset.icon.account"), "getPresetIconStr", (String) null, (Bundle) null);
            if (bundleCall != null) {
                return bundleCall.getString("GET_PRESET_ICON_STR");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void s0(Class<?> cls) {
        c = cls;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static e.c.a.g.a.f.g.b t(boolean z) {
        String strI;
        int i2;
        boolean z2;
        e.c.a.g.a.f.g.b bVar;
        if (z && (bVar = e.c.a.g.a.f.g.b.f654d) != null) {
            return bVar;
        }
        boolean z3 = false;
        boolean z4 = Build.VERSION.SDK_INT <= 28;
        boolean zH = H();
        if (z4 && zH) {
            try {
                strI = SecretAccess.getDeviceId();
                i2 = 1;
            } catch (Exception unused) {
                strI = "";
                i2 = 0;
            }
        } else {
            strI = "";
            i2 = 0;
        }
        if (TextUtils.isEmpty(strI)) {
            e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
            e.c.a.g.a.f.g.b bVarA = e.c.a.g.a.f.g.b.a(cVar.d("key_rich_imei", ""));
            if (bVarA != null) {
                strI = bVarA.a;
                i2 = bVarA.c;
            } else {
                strI = cVar.d("auto_save_imei", "");
                i2 = 3;
            }
            if (g0.a) {
                g0.b("wufuqin", "getIMEI2=: " + strI);
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (TextUtils.isEmpty(strI)) {
            strI = m.i(false);
            i2 = 4;
        } else {
            z3 = z2;
        }
        e.c.a.g.a.f.g.b bVar2 = new e.c.a.g.a.f.g.b(strI, z3, i2);
        if (z) {
            e.c.a.g.a.f.g.b.f654d = bVar2;
        }
        if (i2 == 1 && !z3) {
            e.c.a.g.a.f.m.c cVar2 = e.c.a.g.a.f.m.c.a;
            cVar2.i("auto_save_imei", strI);
            cVar2.i("key_rich_imei", bVar2.b());
        }
        return bVar2;
    }

    public static void t0(EditText editText) {
        try {
            ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String u() {
        return Build.VERSION.RELEASE;
    }

    public static Pair<String, String> v() {
        return c == null ? new Pair<>("", "") : new Pair<>(c.getSimpleName(), c.getName());
    }

    public static Pair<String, String> w() {
        Pair<String, String> pair;
        synchronized (f1213e) {
            pair = b == null ? new Pair<>("", "") : new Pair<>(b.getSimpleName(), b.getName());
        }
        return pair;
    }

    public static int x() {
        DisplayMetrics displayMetrics = KGApplication.getContext().getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            return 0;
        }
        return displayMetrics.heightPixels;
    }

    public static f1 y(Context context) {
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        return new f1(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static int z(Context context) {
        new DisplayMetrics();
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }
}
