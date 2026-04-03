package com.kugou.common.permission.overlay;

import com.kugou.common.permission.PermissionActivity;
import com.kugou.common.permission.RequestExecutor;
import com.kugou.common.permission.overlay.setting.CheckFloatWindowPermissionUtils;
import com.kugou.common.permission.source.Source;
import com.kugou.common.permission.util.MainExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class LRequest extends BaseRequest implements RequestExecutor, PermissionActivity.RequestListener {
    private static final MainExecutor EXECUTOR = new MainExecutor();
    private Source mSource;

    public LRequest(Source source) {
        super(source);
        this.mSource = source;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCallback() {
        if (this.mSource.canDrawOverlays() && hasFloatWindowPermission()) {
            callbackSucceed();
        } else {
            callbackFailed();
        }
    }

    private boolean hasFloatWindowPermission() {
        return CheckFloatWindowPermissionUtils.checkOpResult(this.mSource.getContext(), CheckFloatWindowPermissionUtils.OP_FLOAT_WINDOW) == 0 || (CheckFloatWindowPermissionUtils.checkOpResult(this.mSource.getContext(), CheckFloatWindowPermissionUtils.OP_FLOAT_WINDOW) == 3 && BaseRequest.tryDisplayDialog(this.mSource.getContext()));
    }

    @Override // com.kugou.common.permission.RequestExecutor
    public void cancel() {
        callbackFailed();
    }

    @Override // com.kugou.common.permission.RequestExecutor
    public void execute() {
        PermissionActivity.requestAlertWindow(this.mSource.getContext(), this);
    }

    @Override // com.kugou.common.permission.PermissionActivity.RequestListener
    public void onRequestCallback() {
        EXECUTOR.postDelayed(new Runnable() { // from class: com.kugou.common.permission.overlay.LRequest.1
            @Override // java.lang.Runnable
            public void run() {
                LRequest.this.dispatchCallback();
            }
        }, 100L);
    }

    @Override // com.kugou.common.permission.overlay.OverlayRequest
    public void start() {
        if (CheckFloatWindowPermissionUtils.checkHasPermission(this.mSource.getContext())) {
            callbackSucceed();
        } else {
            showRationale(this);
        }
    }
}
