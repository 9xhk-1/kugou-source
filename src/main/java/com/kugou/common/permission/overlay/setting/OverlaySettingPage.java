package com.kugou.common.permission.overlay.setting;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.kugou.common.permission.source.Source;

/* JADX INFO: loaded from: classes2.dex */
public class OverlaySettingPage {
    private static final String MARK = Build.MANUFACTURER.toLowerCase();
    private Source mSource;

    public OverlaySettingPage(Source source) {
        this.mSource = source;
    }

    private void appDetailsApi(int i2) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.mSource.getContext().getPackageName(), null));
        this.mSource.startActivityForResult(intent, i2);
    }

    private boolean defaultApi(int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.fromParts("package", this.mSource.getContext().getPackageName(), null));
        try {
            this.mSource.startActivityForResult(intent, i2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean meiZuApi(int i2) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", this.mSource.getContext().getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        try {
            this.mSource.startActivityForResult(intent, i2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void start(int i2) {
        if (defaultApi(i2)) {
            return;
        }
        appDetailsApi(i2);
    }
}
