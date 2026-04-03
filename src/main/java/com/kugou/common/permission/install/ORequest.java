package com.kugou.common.permission.install;

import com.kugou.common.permission.PermissionActivity;
import com.kugou.common.permission.RequestExecutor;
import com.kugou.common.permission.source.Source;
import com.kugou.common.permission.util.MainExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class ORequest extends BaseRequest implements RequestExecutor, PermissionActivity.RequestListener {
    private static final MainExecutor EXECUTOR = new MainExecutor();
    private Source mSource;

    public ORequest(Source source) {
        super(source);
        this.mSource = source;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCallback() {
        if (!this.mSource.canRequestPackageInstalls()) {
            callbackFailed();
        } else {
            callbackSucceed();
            install();
        }
    }

    @Override // com.kugou.common.permission.RequestExecutor
    public void cancel() {
        callbackFailed();
    }

    @Override // com.kugou.common.permission.RequestExecutor
    public void execute() {
        PermissionActivity.requestInstall(this.mSource.getContext(), this);
    }

    @Override // com.kugou.common.permission.PermissionActivity.RequestListener
    public void onRequestCallback() {
        EXECUTOR.postDelayed(new Runnable() { // from class: com.kugou.common.permission.install.ORequest.1
            @Override // java.lang.Runnable
            public void run() {
                ORequest.this.dispatchCallback();
            }
        }, 100L);
    }

    @Override // com.kugou.common.permission.install.InstallRequest
    public void start() {
        if (!this.mSource.canRequestPackageInstalls()) {
            showRationale(this);
        } else {
            callbackSucceed();
            install();
        }
    }
}
