package com.kugou.framework.hack.sandbox;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresPermission;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserModel;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.permission.Permission;
import com.kugou.framework.hack.HackHub;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.g0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SandBoxStrategy {
    private static final int SWITCH_APP = 1;
    private static final int SWITCH_CONTACTS = 5;
    private static final int SWITCH_DEVID = 2;
    private static final int SWITCH_IMEI = 3;
    private static final int SWITCH_MEID = 4;
    private static final int SWITCH_PKG = 0;
    private static final int SWITCH_WIFI = 6;
    private static final String TAG = "SandBox";
    private static String sDeviceId;
    private final Context context;
    private final ThreadLocal<Boolean> ctSafeVisit;
    private volatile PackageManager packageManager;
    private final ThreadLocal<Boolean> pmSafeVisit;
    private final boolean[] switcher;
    private volatile TelephonyManager telephonyManager;
    private final ThreadLocal<Boolean> tmSafeVisit;
    private final HackHub.UnionDecision unionDecision;
    private final ThreadLocal<Boolean> wfSafeVisit;
    private volatile WifiManager wifiManager;

    public static class Holder {
        public static final SandBoxStrategy instance = new SandBoxStrategy();

        private Holder() {
        }
    }

    public static void apply() {
        Holder.instance.setupConfig();
    }

    public static SandBoxStrategy get() {
        return Holder.instance;
    }

    private PackageManager getPackageManager() {
        if (this.packageManager == null) {
            this.packageManager = this.context.getPackageManager();
        }
        return this.packageManager;
    }

    private TelephonyManager getTelephonyManager() {
        if (this.telephonyManager == null) {
            this.telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
        }
        return this.telephonyManager;
    }

    private WifiManager getWifiManager() {
        if (this.wifiManager == null) {
            this.wifiManager = (WifiManager) this.context.getSystemService("wifi");
        }
        return this.wifiManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isClosed(int i2) {
        return !this.switcher[i2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void log(String str) {
        Log.i(TAG, str);
        if (g0.a) {
            g0.e(TAG, g0.d());
        }
    }

    private void setupConfig() {
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.switcher;
            if (i2 >= zArr.length) {
                HackHub.pkg().setDecision(this.unionDecision);
                return;
            } else {
                zArr[i2] = true;
                i2++;
            }
        }
    }

    public String getAppName() {
        try {
            try {
                this.pmSafeVisit.set(Boolean.TRUE);
                return this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).applicationInfo.loadLabel(this.context.getPackageManager()).toString();
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                this.pmSafeVisit.set(Boolean.FALSE);
                return null;
            }
        } finally {
            this.pmSafeVisit.set(Boolean.FALSE);
        }
    }

    public ApplicationInfo getApplicationInfo(String str) {
        try {
            return getPackageManager().getApplicationInfo(str, 8192);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @RequiresPermission(Permission.ACCESS_COARSE_LOCATION)
    public CellLocation getCellLocation() {
        try {
            this.tmSafeVisit.set(Boolean.TRUE);
            return getTelephonyManager().getCellLocation();
        } finally {
            this.tmSafeVisit.set(Boolean.FALSE);
        }
    }

    @SuppressLint({"MissingPermission"})
    public String getDeviceId() {
        if (c.c().getConfigAsBoolean(b.N2, false)) {
            return getDeviceIdOrigin();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return null;
        }
        String strB = e.c.a.g.a.f.m.b.m().b();
        sDeviceId = strB;
        try {
            if (!"_".equals(strB)) {
                return sDeviceId;
            }
            this.tmSafeVisit.set(Boolean.TRUE);
            if (g0.a) {
                g0.e(TAG, "call TelephonyManager getDeviceId");
            }
            sDeviceId = "";
            if (g0.a) {
                g0.e(TAG, "call TelephonyManager getDeviceId, sDeviceId = " + sDeviceId);
            }
            e.c.a.g.a.f.m.b.m().H(sDeviceId);
            return sDeviceId;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        } finally {
            this.tmSafeVisit.set(Boolean.FALSE);
        }
    }

    @SuppressLint({"MissingPermission"})
    public String getDeviceIdOrigin() {
        String str = sDeviceId;
        try {
            if (str != null) {
                if (str.isEmpty()) {
                    return null;
                }
                return sDeviceId;
            }
            try {
                this.tmSafeVisit.set(Boolean.TRUE);
                sDeviceId = getTelephonyManager().getDeviceId();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.tmSafeVisit.set(Boolean.FALSE);
            if (sDeviceId == null) {
                sDeviceId = "";
            }
            return sDeviceId;
        } catch (Throwable th) {
            this.tmSafeVisit.set(Boolean.FALSE);
            throw th;
        }
    }

    public String getImei() {
        try {
            try {
                this.tmSafeVisit.set(Boolean.TRUE);
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getImei", new Class[0]);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(getTelephonyManager(), new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.tmSafeVisit.set(Boolean.FALSE);
                return null;
            }
        } finally {
            this.tmSafeVisit.set(Boolean.FALSE);
        }
    }

    public List<ApplicationInfo> getInstalledApplications(int i2) {
        try {
            try {
                this.pmSafeVisit.set(Boolean.TRUE);
                return getPackageManager().getInstalledApplications(i2);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.pmSafeVisit.set(Boolean.FALSE);
                return null;
            }
        } finally {
            this.pmSafeVisit.set(Boolean.FALSE);
        }
    }

    public List<PackageInfo> getInstalledPackages(int i2) {
        try {
            try {
                this.pmSafeVisit.set(Boolean.TRUE);
                return getPackageManager().getInstalledPackages(i2);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.pmSafeVisit.set(Boolean.FALSE);
                return null;
            }
        } finally {
            this.pmSafeVisit.set(Boolean.FALSE);
        }
    }

    public String getMeid() {
        try {
            try {
                this.tmSafeVisit.set(Boolean.TRUE);
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getMeid", new Class[0]);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(getTelephonyManager(), new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.tmSafeVisit.set(Boolean.FALSE);
                return null;
            }
        } finally {
            this.tmSafeVisit.set(Boolean.FALSE);
        }
    }

    public String getNetworkOperatorName() {
        try {
            this.tmSafeVisit.set(Boolean.TRUE);
            return getTelephonyManager().getNetworkOperatorName();
        } finally {
            this.tmSafeVisit.set(Boolean.FALSE);
        }
    }

    public List<ActivityManager.RunningTaskInfo> getRunningTasks(int i2) {
        Context context = this.context;
        if (context != null) {
            try {
                return ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningTasks(i2);
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
        return new ArrayList();
    }

    public List<ScanResult> getScanResults() {
        try {
            this.wfSafeVisit.set(Boolean.TRUE);
            return getWifiManager().getScanResults();
        } finally {
            this.wfSafeVisit.set(Boolean.FALSE);
        }
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public String getSimSerialNumber() {
        try {
            this.tmSafeVisit.set(Boolean.TRUE);
            return getTelephonyManager().getSimSerialNumber();
        } finally {
            this.tmSafeVisit.set(Boolean.FALSE);
        }
    }

    @RequiresPermission(Permission.READ_PHONE_STATE)
    public String getSubscriberId() {
        try {
            this.tmSafeVisit.set(Boolean.TRUE);
            return getTelephonyManager().getSubscriberId();
        } finally {
            this.tmSafeVisit.set(Boolean.FALSE);
        }
    }

    public WifiInfo getWifiConnectionInfo() {
        WifiManager wifiManager = (WifiManager) this.context.getSystemService("wifi");
        try {
            this.wfSafeVisit.set(Boolean.TRUE);
            return wifiManager.getConnectionInfo();
        } finally {
            this.wfSafeVisit.set(Boolean.FALSE);
        }
    }

    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        ThreadLocal<Boolean> threadLocal = "com.android.contacts".equals(uri.getAuthority()) ? this.ctSafeVisit : null;
        if (threadLocal == null) {
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        }
        try {
            threadLocal.set(Boolean.TRUE);
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        } finally {
            threadLocal.set(Boolean.FALSE);
        }
    }

    private SandBoxStrategy() {
        this.switcher = new boolean[]{false, false, false, false, false, false, false};
        this.pmSafeVisit = new ThreadLocal<>();
        this.tmSafeVisit = new ThreadLocal<>();
        this.ctSafeVisit = new ThreadLocal<>();
        this.wfSafeVisit = new ThreadLocal<>();
        this.unionDecision = new HackHub.UnionDecision() { // from class: com.kugou.framework.hack.sandbox.SandBoxStrategy.1
            private volatile HackHub.Reply<Object> cachedEmptyList;
            private volatile HackHub.Reply<String> cachedFakeSeries;

            private HackHub.Reply<?> obtainEmptyList() {
                if (this.cachedEmptyList == null) {
                    try {
                        Constructor<?> declaredConstructor = Class.forName("android.content.pm.ParceledListSlice").getDeclaredConstructor(List.class);
                        declaredConstructor.setAccessible(true);
                        this.cachedEmptyList = new HackHub.Reply<>(true, declaredConstructor.newInstance(Collections.emptyList()));
                    } catch (Throwable unused) {
                    }
                }
                return this.cachedEmptyList;
            }

            private HackHub.Reply<String> obtainFakeSeries() {
                if (this.cachedFakeSeries == null) {
                    String string = Settings.Secure.getString(SandBoxStrategy.this.context.getContentResolver(), "android_id");
                    if (string == null) {
                        string = "";
                    }
                    this.cachedFakeSeries = new HackHub.Reply<>(true, string);
                }
                return this.cachedFakeSeries;
            }

            @Override // com.kugou.framework.hack.HackHub.UnionDecision, com.kugou.framework.hack.HackHub.Phone.Decision
            public HackHub.Reply<String> getDeviceId() {
                if (SandBoxStrategy.this.isClosed(2)) {
                    SandBoxStrategy.log("getDeviceId closed");
                    return null;
                }
                Boolean bool = (Boolean) SandBoxStrategy.this.tmSafeVisit.get();
                SandBoxStrategy.log("getDeviceId: " + bool);
                if (bool == null || !bool.booleanValue()) {
                    return obtainFakeSeries();
                }
                return null;
            }

            @Override // com.kugou.framework.hack.HackHub.UnionDecision, com.kugou.framework.hack.HackHub.Phone.Decision
            public HackHub.Reply<String> getImei(int i2) {
                if (SandBoxStrategy.this.isClosed(3)) {
                    SandBoxStrategy.log("getImei closed");
                    return null;
                }
                Boolean bool = (Boolean) SandBoxStrategy.this.tmSafeVisit.get();
                SandBoxStrategy.log("getImei: " + bool);
                if (bool == null || !bool.booleanValue()) {
                    return obtainFakeSeries();
                }
                return null;
            }

            @Override // com.kugou.framework.hack.HackHub.UnionDecision, com.kugou.framework.hack.HackHub.Package.Decision
            public HackHub.Reply<?> getInstalledApplications() {
                if (SandBoxStrategy.this.isClosed(1)) {
                    SandBoxStrategy.log("getInstalledApplications closed");
                    return null;
                }
                Boolean bool = (Boolean) SandBoxStrategy.this.pmSafeVisit.get();
                SandBoxStrategy.log("getInstalledApplications: " + bool);
                if (bool == null || !bool.booleanValue()) {
                    return obtainEmptyList();
                }
                return null;
            }

            @Override // com.kugou.framework.hack.HackHub.UnionDecision, com.kugou.framework.hack.HackHub.Package.Decision
            public HackHub.Reply<?> getInstalledPackages() {
                if (SandBoxStrategy.this.isClosed(0)) {
                    SandBoxStrategy.log("getInstalledPackages closed");
                    return null;
                }
                Boolean bool = (Boolean) SandBoxStrategy.this.pmSafeVisit.get();
                SandBoxStrategy.log("getInstalledPackages: " + bool);
                if (bool == null || !bool.booleanValue()) {
                    return obtainEmptyList();
                }
                return null;
            }

            @Override // com.kugou.framework.hack.HackHub.UnionDecision, com.kugou.framework.hack.HackHub.Phone.Decision
            public HackHub.Reply<String> getMeid(int i2) {
                if (SandBoxStrategy.this.isClosed(4)) {
                    SandBoxStrategy.log("getMeid closed");
                    return null;
                }
                Boolean bool = (Boolean) SandBoxStrategy.this.tmSafeVisit.get();
                SandBoxStrategy.log("getMeid: " + bool);
                if (bool == null || !bool.booleanValue()) {
                    return obtainFakeSeries();
                }
                return null;
            }

            @Override // com.kugou.framework.hack.HackHub.UnionDecision, com.kugou.framework.hack.HackHub.Wifi.Decision
            public HackHub.Reply<WifiInfo> getWifiInfo() {
                if (SandBoxStrategy.this.isClosed(6)) {
                    SandBoxStrategy.log("wifi-info closed");
                    return null;
                }
                Boolean bool = (Boolean) SandBoxStrategy.this.wfSafeVisit.get();
                SandBoxStrategy.log("getWifiInfo: " + bool);
                if (bool == null || !bool.booleanValue()) {
                    return new HackHub.Reply<>(true, null);
                }
                return null;
            }

            @Override // com.kugou.framework.hack.HackHub.UnionDecision, com.kugou.framework.hack.HackHub.Provider.Decision
            public HackHub.Reply<Cursor> query(String str, Object[] objArr) {
                if (!"com.android.contacts".equals(str)) {
                    return null;
                }
                if (SandBoxStrategy.this.isClosed(5)) {
                    SandBoxStrategy.log("contract closed");
                    return null;
                }
                Boolean bool = (Boolean) SandBoxStrategy.this.ctSafeVisit.get();
                SandBoxStrategy.log("query contract: " + bool);
                if (bool == null || !bool.booleanValue()) {
                    return new HackHub.Reply<>(true, null);
                }
                return null;
            }

            @Override // com.kugou.framework.hack.HackHub.UnionDecision, com.kugou.framework.hack.HackHub.Phone.Decision
            public HackHub.Reply<String> getDeviceId(int i2) {
                if (SandBoxStrategy.this.isClosed(2)) {
                    SandBoxStrategy.log("getDeviceId_1 closed");
                    return null;
                }
                Boolean bool = (Boolean) SandBoxStrategy.this.tmSafeVisit.get();
                SandBoxStrategy.log("getDeviceId_1: " + bool);
                if (bool == null || !bool.booleanValue()) {
                    return obtainFakeSeries();
                }
                return null;
            }
        };
        this.context = KGApplication.getContext();
    }

    public String getImei(int i2) {
        try {
            try {
                this.tmSafeVisit.set(Boolean.TRUE);
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getImei", Integer.TYPE);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(getTelephonyManager(), Integer.valueOf(i2));
            } catch (Exception e2) {
                e2.printStackTrace();
                this.tmSafeVisit.set(Boolean.FALSE);
                return null;
            }
        } finally {
            this.tmSafeVisit.set(Boolean.FALSE);
        }
    }

    public String getMeid(int i2) {
        try {
            try {
                this.tmSafeVisit.set(Boolean.TRUE);
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getMeid", Integer.TYPE);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(getTelephonyManager(), Integer.valueOf(i2));
            } catch (Exception e2) {
                e2.printStackTrace();
                this.tmSafeVisit.set(Boolean.FALSE);
                return null;
            }
        } finally {
            this.tmSafeVisit.set(Boolean.FALSE);
        }
    }
}
