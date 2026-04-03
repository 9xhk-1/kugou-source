package com.kugou.common.permission.particular.setting;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.kugou.common.permission.source.Source;

/* JADX INFO: loaded from: classes2.dex */
public class ParticularSettingPage {
    private static final String MARK = Build.MANUFACTURER.toLowerCase();
    private Source mSource;

    public ParticularSettingPage(Source source) {
        this.mSource = source;
    }

    private void appDetailsApi(int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.fromParts("package", this.mSource.getContext().getPackageName(), null));
        try {
            intent.addFlags(268435456);
            this.mSource.startActivityForResult(intent, i2);
        } catch (Exception unused) {
        }
    }

    private boolean defaultApi(int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.fromParts("package", this.mSource.getContext().getPackageName(), null));
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
