package com.kugou.common.permission.overlay;

import com.kugou.common.permission.PermissionActivity;
import com.kugou.common.permission.RequestExecutor;
import com.kugou.common.permission.overlay.setting.CheckFloatWindowPermissionUtils;
import com.kugou.common.permission.source.Source;
import com.kugou.common.permission.util.MainExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class MRequest extends BaseRequest implements RequestExecutor, PermissionActivity.RequestListener {
    private static final MainExecutor EXECUTOR = new MainExecutor();
    private Source mSource;

    public MRequest(Source source) {
        super(source);
        this.mSource = source;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCallback() {
        if (this.mSource.canDrawOverlays() && BaseRequest.tryDisplayDialog(this.mSource.getContext())) {
            callbackSucceed();
        } else {
            callbackFailed();
        }
    }

    @Override // com.kugou.common.permission.RequestExecutor
    public void cancel() {
        callbackFailed();
    }

    @Override // com.kugou.common.permission.RequestExecutor
    public void execute() {
        PermissionActivity.requestOverlay(this.mSource.getContext(), this);
    }

    @Override // com.kugou.common.permission.PermissionActivity.RequestListener
    public void onRequestCallback() {
        EXECUTOR.postDelayed(new Runnable() { // from class: com.kugou.common.permission.overlay.MRequest.1
            @Override // java.lang.Runnable
            public void run() {
                MRequest.this.dispatchCallback();
            }
        }, 100L);
    }

    @Override // com.kugou.common.permission.overlay.OverlayRequest
    public void start() {
        if (CheckFloatWindowPermissionUtils.checkHasPermission(this.mSource.getContext())) {
            dispatchCallback();
        } else {
            showRationale(this);
        }
    }
}
