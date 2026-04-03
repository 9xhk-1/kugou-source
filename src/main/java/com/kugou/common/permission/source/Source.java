package com.kugou.common.permission.source;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Source {
    private static final String OPSTR_SYSTEM_ALERT_WINDOW = "android:system_alert_window";
    private static final int OP_REQUEST_INSTALL_PACKAGES = 66;
    private AppOpsManager mAppOpsManager;
    private PackageManager mPackageManager;
    private int mTargetSdkVersion;

    private AppOpsManager getAppOpsManager() {
        if (this.mAppOpsManager == null) {
            this.mAppOpsManager = (AppOpsManager) getContext().getSystemService("appops");
        }
        return this.mAppOpsManager;
    }

    private PackageManager getPackageManager() {
        if (this.mPackageManager == null) {
            this.mPackageManager = getContext().getPackageManager();
        }
        return this.mPackageManager;
    }

    private int getTargetSdkVersion() {
        if (this.mTargetSdkVersion < 14) {
            this.mTargetSdkVersion = getContext().getApplicationInfo().targetSdkVersion;
        }
        return this.mTargetSdkVersion;
    }

    public final boolean canDrawOverlays() {
        if (Build.VERSION.SDK_INT >= 23) {
            return getAppOpsManager().checkOpNoThrow(OPSTR_SYSTEM_ALERT_WINDOW, Process.myUid(), getContext().getPackageName()) == 0;
        }
        return true;
    }

    public final boolean canRequestPackageInstalls() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23 || i2 < 26) {
            return true;
        }
        if (getTargetSdkVersion() >= 26) {
            return getPackageManager().canRequestPackageInstalls();
        }
        try {
            Class cls = Integer.TYPE;
            return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOpNoThrow", cls, cls, String.class).invoke(getAppOpsManager(), 66, Integer.valueOf(Process.myUid()), getContext().getPackageName())).intValue() == 0;
        } catch (Exception unused) {
            return true;
        }
    }

    public abstract Context getContext();

    public abstract boolean isShowRationalePermission(String str);

    public abstract void startActivity(Intent intent);

    public abstract void startActivityForResult(Intent intent, int i2);
}
