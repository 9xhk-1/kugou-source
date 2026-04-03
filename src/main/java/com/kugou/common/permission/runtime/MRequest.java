package com.kugou.common.permission.runtime;

import android.content.Context;
import android.util.Log;
import com.kugou.common.BuildConfig;
import com.kugou.common.permission.Action;
import com.kugou.common.permission.GrantAction;
import com.kugou.common.permission.KGPermission;
import com.kugou.common.permission.PermissionActivity;
import com.kugou.common.permission.Rationale;
import com.kugou.common.permission.RequestExecutor;
import com.kugou.common.permission.checker.PermissionChecker;
import com.kugou.common.permission.checker.StandardChecker;
import com.kugou.common.permission.rationale.RationaleTrace;
import com.kugou.common.permission.source.Source;
import com.kugou.common.permission.util.MainExecutor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MRequest implements PermissionRequest, RequestExecutor, PermissionActivity.RequestListener {
    private static final MainExecutor EXECUTOR = new MainExecutor();
    private static final PermissionChecker STANDARD_CHECKER = new StandardChecker();
    private final Rationale<List<String>> mDefaultRationale;
    private Action<List<String>> mDenied;
    private String[] mDeniedPermissions;
    private GrantAction<List<String>> mGrantAction;
    private Action<List<String>> mGranted;
    private String[] mPermissions;
    private Rationale<List<String>> mRationale;
    private Runnable mRequest;
    private Source mSource;

    public MRequest(Source source) {
        Rationale<List<String>> rationale = new Rationale<List<String>>() { // from class: com.kugou.common.permission.runtime.MRequest.1
            @Override // com.kugou.common.permission.Rationale
            public void showRationale(Context context, List<String> list, RequestExecutor requestExecutor) {
                requestExecutor.execute();
            }
        };
        this.mDefaultRationale = rationale;
        this.mRationale = rationale;
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
                grantAction.onTokenAction(KGPermission.genTokenForPermission(this.mRationale, listAsList), listAsList);
            }
        } catch (Exception e2) {
            Log.e("AndPermission", "Please check the onGranted() method body for bugs.", e2);
            Action<List<String>> action2 = this.mDenied;
            if (action2 != null) {
                action2.onAction(listAsList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCallback(boolean z) {
        List<String> deniedPermissions = getDeniedPermissions(STANDARD_CHECKER, this.mSource, this.mPermissions);
        if (z) {
            ArrayList arrayList = new ArrayList(1);
            for (String str : this.mPermissions) {
                if (!deniedPermissions.contains(str)) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() > 0) {
                RationaleTrace.trace((String[]) arrayList.toArray(new String[0]), this.mRationale);
            }
        }
        for (String str2 : this.mPermissions) {
            if (!deniedPermissions.contains(str2) && !RationaleTrace.hasShowRationale(str2, this.mRationale)) {
                deniedPermissions.add(str2);
            }
        }
        if (deniedPermissions.isEmpty()) {
            callbackSucceed();
        } else {
            callbackFailed(deniedPermissions);
        }
    }

    private static List<String> getDeniedPermissions(PermissionChecker permissionChecker, Source source, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!permissionChecker.hasPermission(source.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private static List<String> getRationalePermissions(Source source, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (source.isShowRationalePermission(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    @Override // com.kugou.common.permission.RequestExecutor
    public void cancel() {
        dispatchCallback(false);
    }

    @Override // com.kugou.common.permission.RequestExecutor
    public void execute() {
        Runnable runnable = this.mRequest;
        if (runnable != null) {
            runnable.run();
        }
        PermissionActivity.requestPermission(this.mSource.getContext(), this.mDeniedPermissions, this);
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
        this.mRequest = runnable;
        return this;
    }

    @Override // com.kugou.common.permission.PermissionActivity.RequestListener
    public void onRequestCallback() {
        EXECUTOR.postDelayed(new Runnable() { // from class: com.kugou.common.permission.runtime.MRequest.2
            @Override // java.lang.Runnable
            public void run() {
                MRequest.this.dispatchCallback(true);
            }
        }, 100L);
    }

    @Override // com.kugou.common.permission.runtime.PermissionRequest
    public PermissionRequest permission(String... strArr) {
        this.mPermissions = strArr;
        return this;
    }

    @Override // com.kugou.common.permission.runtime.PermissionRequest
    public PermissionRequest rationale(Rationale<List<String>> rationale) {
        this.mRationale = rationale;
        return this;
    }

    @Override // com.kugou.common.permission.runtime.PermissionRequest
    public void start() {
        if (BuildConfig.DEBUG && this.mDefaultRationale == this.mRationale) {
            callbackFailed(Arrays.asList(this.mPermissions));
            return;
        }
        List<String> deniedPermissions = getDeniedPermissions(STANDARD_CHECKER, this.mSource, this.mPermissions);
        ArrayList arrayList = new ArrayList(deniedPermissions);
        for (String str : this.mPermissions) {
            if (!deniedPermissions.contains(str) && !RationaleTrace.hasShowRationale(str, this.mRationale)) {
                arrayList.add(str);
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        this.mDeniedPermissions = strArr;
        if (strArr.length > 0) {
            this.mRationale.showRationale(this.mSource.getContext(), arrayList, this);
        } else {
            dispatchCallback(false);
        }
    }

    @Override // com.kugou.common.permission.runtime.PermissionRequest
    public PermissionRequest onGranted(GrantAction<List<String>> grantAction) {
        this.mGrantAction = grantAction;
        return this;
    }
}
