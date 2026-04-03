package com.kugou.common.permission;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionGlobalSetting {
    private static Class<? extends PermissionActivity> processPermissionClass = PermissionActivity.class;

    public static Class<? extends PermissionActivity> getProcessPermissionClass() {
        return processPermissionClass;
    }

    public static void setProcessPermissionClass(Class<? extends PermissionActivity> cls) {
        processPermissionClass = cls;
    }
}
