package com.kugou.common.permission.particular;

import android.content.Context;
import com.kugou.common.permission.Action;
import com.kugou.common.permission.GrantAction;
import com.kugou.common.permission.KGPermission;
import com.kugou.common.permission.Rationale;
import com.kugou.common.permission.RequestExecutor;
import com.kugou.common.permission.rationale.RationaleTrace;
import com.kugou.common.permission.source.Source;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseRequest implements ParticularRequest {
    private Action<Void> mDenied;
    private Action<Void> mGranted;
    private GrantAction<Void> mGrantedAction;
    private Rationale<Void> mRationale = new Rationale<Void>() { // from class: com.kugou.common.permission.particular.BaseRequest.1
        @Override // com.kugou.common.permission.Rationale
        public void showRationale(Context context, Void r2, RequestExecutor requestExecutor) {
            requestExecutor.execute();
        }
    };
    private Source mSource;

    public BaseRequest(Source source) {
        this.mSource = source;
    }

    public final void callbackFailed() {
        Action<Void> action = this.mDenied;
        if (action != null) {
            action.onAction(null);
        }
    }

    public final void callbackSucceed() {
        Action<Void> action = this.mGranted;
        if (action != null) {
            action.onAction(null);
        }
        GrantAction<Void> grantAction = this.mGrantedAction;
        if (grantAction != null) {
            grantAction.onTokenAction(KGPermission.genTokenForPermission(this.mRationale, RationaleTrace.PERMISSION_PARTICULAR), null);
        }
    }

    @Override // com.kugou.common.permission.particular.ParticularRequest
    public ParticularRequest onDenied(Action<Void> action) {
        this.mDenied = action;
        return this;
    }

    @Override // com.kugou.common.permission.particular.ParticularRequest
    @Deprecated
    public ParticularRequest onGranted(Action<Void> action) {
        this.mGranted = action;
        return this;
    }

    @Override // com.kugou.common.permission.particular.ParticularRequest
    public ParticularRequest rationale(Rationale<Void> rationale) {
        RationaleTrace.trace(RationaleTrace.PERMISSION_PARTICULAR, rationale);
        this.mRationale = rationale;
        return this;
    }

    public final void showRationale(RequestExecutor requestExecutor) {
        this.mRationale.showRationale(this.mSource.getContext(), null, requestExecutor);
    }

    @Override // com.kugou.common.permission.particular.ParticularRequest
    public ParticularRequest onGranted(GrantAction<Void> grantAction) {
        this.mGrantedAction = grantAction;
        return this;
    }
}
