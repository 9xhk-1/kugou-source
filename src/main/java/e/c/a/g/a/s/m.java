package e.c.a.g.a.s;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.utils.SecretAccess;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public class m {
    public static Boolean a;
    public static Boolean b;
    public static Boolean c;

    public static void a() {
        try {
            String strD = e.c.a.g.a.f.m.c.a.d("android_id", "");
            Log.d("mhs_watch_androidid", "checkAndgenerateAndroidId, currentAndroid = " + strD);
            if (TextUtils.isEmpty(strD) || "null".equals(strD)) {
                b(KGApplication.getContext());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String b(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (string == null || string.equals("9774d56d682e549c") || string.length() < 15) {
            string = new BigInteger(64, new SecureRandom()).toString(16);
        }
        String strI = q0.i(string);
        e.c.a.g.a.f.m.c.a.i("android_id", strI);
        return strI;
    }

    public static String c(Context context) {
        e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
        if (cVar.e("sp_key_show_privacy", true)) {
            Log.d("yyt_andorid_id", "ignore android id before agree");
            return "";
        }
        String strD = cVar.d("android_id", "");
        if (strD == null || strD.equals("") || strD.equals("null")) {
            if (e.c.a.g.a.d.l.a.c() <= 0) {
                Log.d("yyt_andorid_id", "ignore android id when background");
                return "";
            }
            strD = b(context);
        }
        if (g0.a) {
            g0.b("yyt_andorid_id", strD);
        }
        return strD;
    }

    public static String d() {
        return "getPhoneModel = " + l1.q() + ", getPhoneBrand = " + l1.p() + ",gitVersion = 8bc5fbeb,debugChannel = , VERSION_NAME = 2.4.5.1, appversioncode = 10503, channel = " + e.c.c.b.c;
    }

    public static String e() {
        return e.c.a.g.a.f.m.b.m().f();
    }

    public static String f(Context context) {
        return c(context);
    }

    public static String g() {
        int iA = l1.A();
        String strValueOf = String.valueOf(e.c.a.g.a.f.m.b.m().h(2));
        long jH = e.c.a.g.a.f.m.b.m().h(3);
        long jH2 = e.c.a.g.a.f.m.b.m().h(1);
        long jH3 = e.c.a.g.a.f.m.b.m().h(4);
        f1 f1VarY = l1.y(KGApplication.getContext());
        return iA + "," + strValueOf + "," + jH + "," + jH2 + "," + jH3 + "," + (f1VarY.a + "x" + f1VarY.b);
    }

    public static String h() {
        return i(true);
    }

    public static String i(boolean z) {
        if (a == null) {
            a = Boolean.valueOf(e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.U2, false));
        }
        String strC = c(KGApplication.getContext());
        String safeUUID = (a.booleanValue() && z) ? SecretAccess.getSafeUUID(strC) : strC;
        if (g0.a) {
            g0.e("young-hqd", String.format("getUUID config:%s, safe:%s, origin:%s result:%s", a, Boolean.valueOf(z), strC, safeUUID));
        }
        return safeUUID;
    }

    public static boolean j() {
        if (ContextCompat.checkSelfPermission(KGApplication.getContext(), "android.permission.BLUETOOTH") != 0) {
            Log.d("AbstractCtrlStrategy", "没有权限，安全返回 false.");
            return false;
        }
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                Log.d("AbstractCtrlStrategy", "设备不支持蓝牙.");
                return false;
            }
            if (!defaultAdapter.isEnabled()) {
                Log.d("AbstractCtrlStrategy", "蓝牙未开启.");
                return false;
            }
            int profileConnectionState = defaultAdapter.getProfileConnectionState(2);
            if (g0.a) {
                g0.c("DeviceUtils", "A2DP 连接状态: " + profileConnectionState + " (0=断开, 1=连接中, 2=已连接, 3=断开中)");
            }
            return profileConnectionState == 2;
        } catch (Exception e2) {
            if (g0.a) {
                g0.c("DeviceUtils", "检测蓝牙连接状态时发生 SecurityException e = " + e2);
            }
            return false;
        }
    }

    public static boolean k() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                int profileConnectionState = defaultAdapter.getProfileConnectionState(2);
                if (g0.a) {
                    g0.c("youth-watch", "getProfileConnectionState(0 断开；1 连接中；2 连接；3 断开中)： " + profileConnectionState);
                }
                return profileConnectionState == 2;
            }
        } catch (Exception e2) {
            g0.k(e2);
        }
        return false;
    }

    public static boolean l() {
        PackageManager packageManager;
        if (c == null && (packageManager = KGApplication.getContext().getPackageManager()) != null && !packageManager.hasSystemFeature("android.hardware.camera.any") && !packageManager.hasSystemFeature("android.hardware.camera.front")) {
            c = Boolean.FALSE;
        }
        if (c == null) {
            c = Boolean.TRUE;
        }
        return c.booleanValue();
    }

    public static boolean m() {
        if (b == null) {
            b = Boolean.valueOf(n());
        }
        return b.booleanValue();
    }

    public static boolean n() {
        long jH = e.c.a.g.a.f.m.b.m().h(1);
        int configAsInt = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.w2, 2);
        if (jH > 0 && jH <= configAsInt) {
            return true;
        }
        long jH2 = e.c.a.g.a.f.m.b.m().h(2);
        return jH2 > 0 && jH2 <= ((long) e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.x2, 500));
    }

    @WorkerThread
    public static void o() {
        e.c.a.g.a.f.m.b bVarM = e.c.a.g.a.f.m.b.m();
        if (!bVarM.x(1)) {
            int iG = l.g();
            if (iG == -1) {
                iG = 0;
            }
            Log.d("device_info", "cpu cores count: " + iG);
            bVarM.N(1, (long) iG);
        }
        if (!bVarM.x(2)) {
            long jH = (l.h(KGApplication.getContext()) / 1024) / 1024;
            Log.d("device_info", "ram size:" + jH);
            bVarM.N(2, jH);
        }
        if (!bVarM.x(3)) {
            long jE = (d.e() / 1024) / 1024;
            Log.d("device_info", "rom size:" + jE);
            bVarM.N(3, jE);
        }
        if (bVarM.x(4)) {
            return;
        }
        long jD = l.d();
        Log.d("device_info", "max freq khz:" + jD);
        bVarM.N(4, jD);
    }
}
