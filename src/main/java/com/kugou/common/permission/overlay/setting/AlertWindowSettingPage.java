package com.kugou.common.permission.overlay.setting;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.kugou.common.permission.source.Source;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class AlertWindowSettingPage {
    private static final String MARK = Build.MANUFACTURER.toLowerCase();
    private Source mSource;

    public AlertWindowSettingPage(Source source) {
        this.mSource = source;
    }

    private static Intent defaultApi(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    private static boolean hasActivity(Context context, Intent intent) {
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && activityInfo.exported && TextUtils.isEmpty(activityInfo.permission)) {
                return true;
            }
        }
        return false;
    }

    private Intent huaweiApi(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        if (hasActivity(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
        if (hasActivity(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
        return hasActivity(context, intent) ? intent : defaultApi(context);
    }

    private Intent meizuApi(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", context.getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        return intent;
    }

    private Intent oppoApi(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packageName", context.getPackageName());
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.floatwindow.FloatWindowListActivity");
        if (hasActivity(context, intent)) {
            return intent;
        }
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
        if (hasActivity(context, intent)) {
            return intent;
        }
        intent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
        if (hasActivity(context, intent)) {
            return intent;
        }
        intent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.permission.floatwindow.FloatWindowListActivity");
        if (hasActivity(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionTopActivity");
        if (hasActivity(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionTopActivity");
        if (hasActivity(context, intent)) {
            return intent;
        }
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.PermissionTopActivity");
        return hasActivity(context, intent) ? intent : defaultApi(context);
    }

    private Intent vivoApi(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.FloatWindowManager");
        intent.putExtra("packagename", context.getPackageName());
        if (hasActivity(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
        if (hasActivity(context, intent)) {
            return intent;
        }
        intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
        return hasActivity(context, intent) ? intent : defaultApi(context);
    }

    private Intent xiaomiApi(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (hasActivity(context, intent)) {
            return intent;
        }
        intent.setPackage("com.miui.securitycenter");
        if (hasActivity(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        if (hasActivity(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        return hasActivity(context, intent) ? intent : defaultApi(context);
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
