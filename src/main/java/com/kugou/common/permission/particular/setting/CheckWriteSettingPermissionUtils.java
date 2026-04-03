package com.kugou.common.permission.particular.setting;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/* JADX INFO: loaded from: classes2.dex */
public class CheckWriteSettingPermissionUtils {
    public static boolean checkHasPermission(Context context) {
        return Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(context);
    }
}
