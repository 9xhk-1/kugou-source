package e.c.c.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.kugou.common.utils.SecretAccess;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.u0;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    public static class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static b f1278d;
        public final String a;
        public final boolean b;
        public final int c;

        public static b c(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new b(jSONObject.getString("content"), jSONObject.getBoolean("fromFileCache"), jSONObject.getInt("material"));
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public String d() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("content", this.a);
                jSONObject.put("fromFileCache", this.b);
                jSONObject.put("material", this.c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }

        public String toString() {
            return d();
        }

        public b(String str, boolean z, int i2) {
            this.a = str;
            this.b = z;
            this.c = i2;
        }
    }

    public static String A(String str) {
        return str == null ? "" : str.substring(0, Math.min(102400, str.length()));
    }

    public static void a(String str) {
        File[] fileArrListFiles;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                    for (File file2 : fileArrListFiles) {
                        a(file2.getAbsolutePath());
                    }
                }
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    public static int b(float f2) {
        return c(f.a(), f2);
    }

    public static int c(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8").replace(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, "%20");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String e(Context context) {
        return new i().e(j(context) + System.currentTimeMillis());
    }

    public static String f(Context context) {
        String strD = l.e(context).d("android_id", "");
        return (strD == null || strD.equals("") || strD.equals("null")) ? e.c.a.g.a.s.m.c(context) : strD;
    }

    public static ConnectivityManager g() {
        return (ConnectivityManager) f.a().getSystemService("connectivity");
    }

    public static long h(Context context) {
        return context.getSharedPreferences("setting", 0).getLong("coverInstallDateTemp", 0L);
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String i(boolean z, Context... contextArr) {
        return s(z).a;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String j(Context... contextArr) {
        return i(true, contextArr);
    }

    @SuppressLint({"MissingPermission"})
    public static String k() {
        return l1.m();
    }

    public static String l(Context context) {
        return l1.n(context);
    }

    public static int m(Context context) {
        String strN = n(context);
        if ("wifi".equals(strN)) {
            return 2;
        }
        if ("2G".equals(strN)) {
            return 4;
        }
        return ("3G".equals(strN) || "4G".equals(strN)) ? 3 : 0;
    }

    public static String n(Context context) {
        return o(context);
    }

    public static String o(Context context) {
        return p(g());
    }

    public static String p(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo;
        String str = "unknown";
        if (connectivityManager == null) {
            return "unknown";
        }
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
        }
        if (activeNetworkInfo == null) {
            return "nonetwork";
        }
        if (activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 9) {
            return "wifi";
        }
        TelephonyManager telephonyManager = (TelephonyManager) f.a().getSystemService("phone");
        str = "3G";
        if (telephonyManager != null) {
            int i2 = u0.i(telephonyManager);
            return (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 7 || i2 == 11) ? "2G" : i2 != 13 ? "3G" : "4G";
        }
        return str;
    }

    public static String q(Context context) {
        String strN = n(context);
        return "wifi".equals(strN) ? "1" : "2G".equals(strN) ? "2" : "3G".equals(strN) ? "3" : "4G".equals(strN) ? "4" : "0";
    }

    public static String r(Context context) {
        String simOperator;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return (telephonyManager.getSimState() != 5 || (simOperator = telephonyManager.getSimOperator()) == null) ? "" : simOperator;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static b s(boolean z) {
        String deviceId;
        int i2;
        boolean z2;
        if (z && b.f1278d != null) {
            return b.f1278d;
        }
        boolean z3 = false;
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                deviceId = SecretAccess.getDeviceId();
                i2 = 1;
            } catch (Exception e2) {
                e2.printStackTrace();
                deviceId = "";
                i2 = 0;
            }
        } else {
            deviceId = "";
            i2 = 0;
        }
        if (TextUtils.isEmpty(deviceId)) {
            b bVarC = b.c(l.e(f.a()).c());
            if (bVarC != null) {
                String str = bVarC.a;
                i2 = bVarC.c;
                deviceId = str;
            } else {
                deviceId = l.e(f.a()).a();
                i2 = 3;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (TextUtils.isEmpty(deviceId)) {
            deviceId = v();
            i2 = 4;
        } else {
            z3 = z2;
        }
        b bVar = new b(deviceId, z3, i2);
        if (z) {
            b unused = b.f1278d = bVar;
        }
        if (i2 == 1 && !z3) {
            l.e(f.a()).h(deviceId);
            l.e(f.a()).i(bVar.d());
        }
        return bVar;
    }

    public static String t() {
        return Build.VERSION.RELEASE;
    }

    public static int u() {
        return Build.VERSION.SDK_INT;
    }

    public static String v() {
        return e.c.a.g.a.s.m.i(false);
    }

    public static String w(boolean z) {
        return e.c.a.g.a.s.m.i(z);
    }

    public static int x(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 9001;
        }
    }

    public static String y(String str) {
        try {
            BigInteger bigInteger = new BigInteger("0");
            BigInteger bigInteger2 = new BigInteger("16");
            String strE = new i().e(str);
            int length = strE.length();
            for (int i2 = 0; i2 < length; i2++) {
                bigInteger = bigInteger.add(new BigInteger("" + strE.charAt(i2), 16).multiply(bigInteger2.pow((length - 1) - i2)));
            }
            return bigInteger.toString();
        } catch (Exception unused) {
            return "0";
        }
    }

    public static boolean z(Context context) {
        return ("unknown".endsWith(n(context)) || "nonetwork".endsWith(n(context))) ? false : true;
    }
}
