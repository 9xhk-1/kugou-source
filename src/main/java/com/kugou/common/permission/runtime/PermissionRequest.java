package com.kugou.common.permission.runtime;

import com.kugou.common.permission.Action;
import com.kugou.common.permission.GrantAction;
import com.kugou.common.permission.Rationale;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface PermissionRequest {
    PermissionRequest onDenied(Action<List<String>> action);

    @Deprecated
    PermissionRequest onGranted(Action<List<String>> action);

    PermissionRequest onGranted(GrantAction<List<String>> grantAction);

    PermissionRequest onRequest(Runnable runnable);

    PermissionRequest permission(String... strArr);

    PermissionRequest rationale(Rationale<List<String>> rationale);

    void start();
}
