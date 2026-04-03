package com.kugou.common.permission.runtime;

import com.kugou.common.permission.Action;
import com.kugou.common.permission.GrantAction;
import com.kugou.common.permission.KGPermission;
import com.kugou.common.permission.Rationale;
import com.kugou.common.permission.checker.PermissionChecker;
import com.kugou.common.permission.checker.StrictChecker;
import com.kugou.common.permission.source.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LRequest implements PermissionRequest {
    private static final PermissionChecker CHECKER = new StrictChecker();
    private Action<List<String>> mDenied;
    private GrantAction<List<String>> mGrantAction;
    private Action<List<String>> mGranted;
    private String[] mPermissions;
    private Source mSource;
    private Rationale<List<String>> rationale;

    public LRequest(Source source) {
        this.mSource = source;
    }

    private void callbackFailed(List<String> list) {
        Action<List<String>> action = this.mDenied;
        if (action != null) {
            action.onAction(list);
        }
    }

    private void callbackSucceed() {
        List<String> listAsList = Arrays.asList(this.mPermissions);
        try {
            Action<List<String>> action = this.mGranted;
            if (action != null) {
                action.onAction(listAsList);
            }
            GrantAction<List<String>> grantAction = this.mGrantAction;
            if (grantAction != null) {
                grantAction.onTokenAction(KGPermission.genTokenForPermission(this.rationale, listAsList), listAsList);
            }
        } catch (Exception unused) {
            Action<List<String>> action2 = this.mDenied;
            if (action2 != null) {
                action2.onAction(listAsList);
            }
        }
    }

    private static List<String> getDeniedPermissions(Source source, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!CHECKER.hasPermission(source.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    @Override // com.kugou.common.permission.runtime.PermissionRequest
    public PermissionRequest onDenied(Action<List<String>> action) {
        this.mDenied = action;
        return this;
    }

    @Override // com.kugou.common.permission.runtime.PermissionRequest
    @Deprecated
    public PermissionRequest onGranted(Action<List<String>> action) {
        this.mGranted = action;
        return this;
    }

    @Override // com.kugou.common.permission.runtime.PermissionRequest
    public PermissionRequest onRequest(Runnable runnable) {
        return this;
    }

    @Override // com.kugou.common.permission.runtime.PermissionRequest
    public PermissionRequest permission(String... strArr) {
        this.mPermissions = strArr;
        return this;
    }

    @Override // com.kugou.common.permission.runtime.PermissionRequest
    public PermissionRequest rationale(Rationale<List<String>> rationale) {
        this.rationale = rationale;
        return this;
    }

    @Override // com.kugou.common.permission.runtime.PermissionRequest
    public void start() {
        List<String> deniedPermissions = getDeniedPermissions(this.mSource, this.mPermissions);
        if (deniedPermissions.isEmpty()) {
            callbackSucceed();
        } else {
            callbackFailed(deniedPermissions);
        }
    }

    @Override // com.kugou.common.permission.runtime.PermissionRequest
    public PermissionRequest onGranted(GrantAction<List<String>> grantAction) {
        this.mGrantAction = grantAction;
        return this;
    }
}
