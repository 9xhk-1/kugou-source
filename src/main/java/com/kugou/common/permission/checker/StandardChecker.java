package com.kugou.common.permission.checker;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.kugou.common.permission.KGPermission;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class StandardChecker implements PermissionChecker {
    @Override // com.kugou.common.permission.checker.PermissionChecker
    public boolean hasPermission(Context context, String... strArr) {
        return hasPermission(context, Arrays.asList(strArr));
    }

    @Override // com.kugou.common.permission.checker.PermissionChecker
    public boolean hasPermission(Context context, List<String> list) {
        if (!KGPermission.enableChecker) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        AppOpsManager appOpsManager = null;
        for (String str : list) {
            if (context.checkPermission(str, Process.myPid(), Process.myUid()) == -1) {
                return false;
            }
            String strPermissionToOp = AppOpsManager.permissionToOp(str);
            if (!TextUtils.isEmpty(strPermissionToOp)) {
                if (appOpsManager == null) {
                    appOpsManager = (AppOpsManager) context.getSystemService("appops");
                }
                if (appOpsManager.checkOpNoThrow(strPermissionToOp, Process.myUid(), context.getPackageName()) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
