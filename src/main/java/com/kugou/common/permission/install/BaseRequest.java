package com.kugou.common.permission.install;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.kugou.common.permission.Action;
import com.kugou.common.permission.GrantAction;
import com.kugou.common.permission.KGPermission;
import com.kugou.common.permission.Rationale;
import com.kugou.common.permission.RequestExecutor;
import com.kugou.common.permission.rationale.RationaleTrace;
import com.kugou.common.permission.source.Source;
import com.kugou.common.permission.util.FileUtil;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseRequest implements InstallRequest {
    private final Rationale<File> mDefaultRationale;
    private Action<File> mDenied;
    private File mFile;
    private GrantAction<File> mGrantAction;
    private Action<File> mGranted;
    private Rationale<File> mRationale;
    private Source mSource;

    public BaseRequest(Source source) {
        Rationale<File> rationale = new Rationale<File>() { // from class: com.kugou.common.permission.install.BaseRequest.1
            @Override // com.kugou.common.permission.Rationale
            public void showRationale(Context context, File file, RequestExecutor requestExecutor) {
                requestExecutor.execute();
            }
        };
        this.mDefaultRationale = rationale;
        this.mRationale = rationale;
        this.mSource = source;
    }

    public final void callbackFailed() {
        Action<File> action = this.mDenied;
        if (action != null) {
            action.onAction(this.mFile);
        }
    }

    public final void callbackSucceed() {
        String[] strArr = RationaleTrace.PERMISSION_INSTALL;
        RationaleTrace.trace(strArr, this.mRationale);
        Action<File> action = this.mGranted;
        if (action != null) {
            action.onAction(this.mFile);
        }
        GrantAction<File> grantAction = this.mGrantAction;
        if (grantAction != null) {
            grantAction.onTokenAction(KGPermission.genTokenForPermission(this.mRationale, strArr), null);
        }
    }

    @Override // com.kugou.common.permission.install.InstallRequest
    public final InstallRequest file(File file) {
        this.mFile = file;
        return this;
    }

    public final void install() {
        Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
        intent.setFlags(268435456);
        intent.addFlags(1);
        Uri fileUri = FileUtil.getFileUri(this.mSource.getContext(), this.mFile);
        intent.setDataAndType(fileUri, "application/vnd.android.package-archive");
        if (Build.VERSION.SDK_INT >= 24) {
            Iterator<ResolveInfo> it = this.mSource.getContext().getPackageManager().queryIntentActivities(intent, 65536).iterator();
            while (it.hasNext()) {
                this.mSource.getContext().grantUriPermission(it.next().activityInfo.packageName, fileUri, 3);
            }
        }
        this.mSource.startActivity(intent);
    }

    @Override // com.kugou.common.permission.install.InstallRequest
    public final InstallRequest onDenied(Action<File> action) {
        this.mDenied = action;
        return this;
    }

    @Override // com.kugou.common.permission.install.InstallRequest
    @Deprecated
    public final InstallRequest onGranted(Action<File> action) {
        this.mGranted = action;
        return this;
    }

    @Override // com.kugou.common.permission.install.InstallRequest
    public final InstallRequest rationale(Rationale<File> rationale) {
        this.mRationale = rationale;
        return this;
    }

    public final void showRationale(RequestExecutor requestExecutor) {
        this.mRationale.showRationale(this.mSource.getContext(), null, requestExecutor);
    }

    @Override // com.kugou.common.permission.install.InstallRequest
    public InstallRequest onGranted(GrantAction<File> grantAction) {
        this.mGrantAction = grantAction;
        return this;
    }
}
