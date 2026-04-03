package com.kugou.common.permission.particular;

import com.kugou.common.permission.Action;
import com.kugou.common.permission.GrantAction;
import com.kugou.common.permission.PermissionActivity;
import com.kugou.common.permission.Rationale;
import com.kugou.common.permission.RequestExecutor;
import com.kugou.common.permission.particular.setting.CheckWriteSettingPermissionUtils;
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
        if (CheckWriteSettingPermissionUtils.checkHasPermission(this.mSource.getContext())) {
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
        PermissionActivity.requestParticular(this.mSource.getContext(), this);
    }

    @Override // com.kugou.common.permission.particular.BaseRequest, com.kugou.common.permission.particular.ParticularRequest
    public /* bridge */ /* synthetic */ ParticularRequest onDenied(Action action) {
        return super.onDenied(action);
    }

    @Override // com.kugou.common.permission.particular.BaseRequest, com.kugou.common.permission.particular.ParticularRequest
    @Deprecated
    public /* bridge */ /* synthetic */ ParticularRequest onGranted(Action action) {
        return super.onGranted((Action<Void>) action);
    }

    @Override // com.kugou.common.permission.PermissionActivity.RequestListener
    public void onRequestCallback() {
        EXECUTOR.postDelayed(new Runnable() { // from class: com.kugou.common.permission.particular.LRequest.1
            @Override // java.lang.Runnable
            public void run() {
                LRequest.this.dispatchCallback();
            }
        }, 100L);
    }

    @Override // com.kugou.common.permission.particular.BaseRequest, com.kugou.common.permission.particular.ParticularRequest
    public /* bridge */ /* synthetic */ ParticularRequest rationale(Rationale rationale) {
        return super.rationale(rationale);
    }

    @Override // com.kugou.common.permission.particular.ParticularRequest
    public void start() {
        if (CheckWriteSettingPermissionUtils.checkHasPermission(this.mSource.getContext())) {
            callbackSucceed();
        } else {
            showRationale(this);
        }
    }

    @Override // com.kugou.common.permission.particular.BaseRequest, com.kugou.common.permission.particular.ParticularRequest
    public /* bridge */ /* synthetic */ ParticularRequest onGranted(GrantAction grantAction) {
        return super.onGranted((GrantAction<Void>) grantAction);
    }
}
