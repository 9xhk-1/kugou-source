package com.kugou.common.permission.runtime.setting;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.kugou.common.permission.source.Source;

/* JADX INFO: loaded from: classes2.dex */
public class RuntimeSettingPage {
    private static final String MARK = Build.MANUFACTURER.toLowerCase();
    private Source mSource;

    public RuntimeSettingPage(Source source) {
        this.mSource = source;
    }

    private static Intent defaultApi(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    private static boolean hasActivity(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    private static Intent huaweiApi(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return defaultApi(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        return intent;
    }

    private static Intent meizuApi(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return defaultApi(context);
        }
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", context.getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        return intent;
    }

    private static Intent oppoApi(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packageName", context.getPackageName());
        intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
        return intent;
    }

    private static Intent vivoApi(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packagename", context.getPackageName());
        intent.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
        if (hasActivity(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
        return intent;
    }

    private static Intent xiaomiApi(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        return intent;
    }

    public void start(int i2) {
        String str = MARK;
        try {
            this.mSource.startActivityForResult(str.contains("huawei") ? huaweiApi(this.mSource.getContext()) : str.contains("xiaomi") ? xiaomiApi(this.mSource.getContext()) : str.contains("oppo") ? oppoApi(this.mSource.getContext()) : str.contains("vivo") ? vivoApi(this.mSource.getContext()) : str.contains("meizu") ? meizuApi(this.mSource.getContext()) : defaultApi(this.mSource.getContext()), i2);
        } catch (Exception unused) {
            this.mSource.startActivityForResult(defaultApi(this.mSource.getContext()), i2);
        }
    }
}
