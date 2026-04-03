package com.kugou.common.utils;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.support.annotation.RequiresPermission;
import android.telephony.CellLocation;
import android.text.TextUtils;
import android.util.Log;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.INoGuard;
import com.kugou.common.permission.KGPermission;
import com.kugou.common.permission.Permission;
import com.kugou.framework.hack.sandbox.SandBoxStrategy;
import e.c.a.g.a.s.m;
import e.c.c.o.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SecretAccess implements INoGuard {
    public static final String DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00";
    private static final String LOG_TAG = "SecretAccess";

    public static String getAndroidId() {
        Log.d(LOG_TAG, "get androidId from libj");
        if (PrivacyUtil.hasAgreed()) {
            return m.c(KGApplication.getContext());
        }
        return null;
    }

    public static String getAppName() {
        if (PrivacyUtil.hasAgreed()) {
            return SandBoxStrategy.get().getAppName();
        }
        return null;
    }

    public static ApplicationInfo getApplicationInfo(String str) {
        if (!TextUtils.isEmpty(str) && PrivacyUtil.hasAgreed()) {
            return SandBoxStrategy.get().getApplicationInfo(str);
        }
        return null;
    }

    @RequiresPermission(Permission.ACCESS_COARSE_LOCATION)
    public static CellLocation getCellLocation() {
        if (privacyAndPhoneState()) {
            return SandBoxStrategy.get().getCellLocation();
        }
        return null;
    }

    public static String getDeviceId() {
        Log.d(LOG_TAG, "get deviceId from libj");
        if (privacyAndPhoneState()) {
            return SandBoxStrategy.get().getDeviceId();
        }
        return null;
    }

    @RequiresPermission("com.android.permission.GET_INSTALLED_APPS")
    public static List<ApplicationInfo> getInstalledApplications(int i2) {
        if (PrivacyUtil.hasAgreed()) {
            return SandBoxStrategy.get().getInstalledApplications(i2);
        }
        return null;
    }

    public static List<PackageInfo> getInstalledPackages(int i2) {
        if (PrivacyUtil.hasAgreed()) {
            return SandBoxStrategy.get().getInstalledPackages(i2);
        }
        return null;
    }

    @RequiresPermission(Permission.READ_PHONE_STATE)
    public static String getNetworkOperatorName() {
        if (privacyAndPhoneState()) {
            return SandBoxStrategy.get().getNetworkOperatorName();
        }
        return null;
    }

    public static List<ActivityManager.RunningTaskInfo> getRunningTasks(int i2) {
        if (PrivacyUtil.hasAgreed()) {
            Log.i(LOG_TAG, "getRunningTaskInfo, 满足读取条件，调用系统接口获取");
            return SandBoxStrategy.get().getRunningTasks(i2);
        }
        Log.i(LOG_TAG, "getRunningTaskInfo, 不满足读取条件，返回空列表");
        return new ArrayList();
    }

    public static String getSafeDeviceId() {
        return getDeviceId();
    }

    public static String getSafeImei() {
        if (privacyAndPhoneState()) {
            return SandBoxStrategy.get().getImei();
        }
        return null;
    }

    public static String getSafeMeid() {
        if (privacyAndPhoneState()) {
            return SandBoxStrategy.get().getMeid();
        }
        return null;
    }

    @RequiresPermission(Permission.READ_PHONE_STATE)
    public static String getSafeSubscriberId() {
        if (privacyAndPhoneState()) {
            return SandBoxStrategy.get().getSubscriberId();
        }
        return null;
    }

    public static String getSafeUUID(String str) {
        return "-";
    }

    public static List<ScanResult> getScanResults() {
        if (PrivacyUtil.hasAgreed()) {
            return SandBoxStrategy.get().getScanResults();
        }
        return null;
    }

    @RequiresPermission(Permission.READ_PHONE_STATE)
    public static String getSimSerialNumber() {
        if (privacyAndPhoneState()) {
            return SandBoxStrategy.get().getSimSerialNumber();
        }
        return null;
    }

    public static WifiInfo getWifiConnectionInfo() {
        if (PrivacyUtil.hasAgreed()) {
            return SandBoxStrategy.get().getWifiConnectionInfo();
        }
        return null;
    }

    private static boolean privacyAndPhoneState() {
        return PrivacyUtil.hasAgreed() && KGPermission.uCantAskMePermissionState(f.a(), Permission.READ_PHONE_STATE);
    }

    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return SandBoxStrategy.get().query(contentResolver, uri, strArr, str, strArr2, str2);
    }

    public static String getSafeImei(int i2) {
        if (privacyAndPhoneState()) {
            return SandBoxStrategy.get().getImei(i2);
        }
        return null;
    }

    public static String getSafeMeid(int i2) {
        if (privacyAndPhoneState()) {
            return SandBoxStrategy.get().getMeid(i2);
        }
        return null;
    }
}
