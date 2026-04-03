package com.kugou.common.permission.overlay;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import com.kugou.common.R;
import com.kugou.common.permission.Action;
import com.kugou.common.permission.GrantAction;
import com.kugou.common.permission.KGPermission;
import com.kugou.common.permission.Rationale;
import com.kugou.common.permission.RequestExecutor;
import com.kugou.common.permission.rationale.RationaleTrace;
import com.kugou.common.permission.source.Source;
import qihoo.sdk.event.SystemEvent;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseRequest implements OverlayRequest {
    private Action<Void> mDenied;
    private GrantAction<Void> mGrantAction;
    private Action<Void> mGranted;
    private Rationale<Void> mRationale = new Rationale<Void>() { // from class: com.kugou.common.permission.overlay.BaseRequest.1
        @Override // com.kugou.common.permission.Rationale
        public void showRationale(Context context, Void r2, RequestExecutor requestExecutor) {
            requestExecutor.execute();
        }
    };
    private Source mSource;

    public BaseRequest(Source source) {
        this.mSource = source;
    }

    public static boolean tryDisplayDialog(Context context) {
        Dialog dialog = new Dialog(context, R.style.Permission_Theme_Dialog);
        dialog.getWindow().setType(Build.VERSION.SDK_INT >= 26 ? 2038 : SystemEvent.CODE_SYSTEM_EVENT_TEMP_HIGH_EXCEPTION);
        try {
            dialog.show();
            if (!dialog.isShowing()) {
                return true;
            }
            dialog.dismiss();
            return true;
        } catch (Exception unused) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            return false;
        } catch (Throwable th) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            throw th;
        }
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
        GrantAction<Void> grantAction = this.mGrantAction;
        if (grantAction != null) {
            grantAction.onTokenAction(KGPermission.genTokenForPermission(this.mRationale, RationaleTrace.PERMISSION_OVERLAY), null);
        }
    }

    @Override // com.kugou.common.permission.overlay.OverlayRequest
    public final OverlayRequest onDenied(Action<Void> action) {
        this.mDenied = action;
        return this;
    }

    @Override // com.kugou.common.permission.overlay.OverlayRequest
    @Deprecated
    public final OverlayRequest onGranted(Action<Void> action) {
        this.mGranted = action;
        return this;
    }

    @Override // com.kugou.common.permission.overlay.OverlayRequest
    public final OverlayRequest rationale(Rationale<Void> rationale) {
        RationaleTrace.trace(RationaleTrace.PERMISSION_OVERLAY, rationale);
        this.mRationale = rationale;
        return this;
    }

    public final void showRationale(RequestExecutor requestExecutor) {
        this.mRationale.showRationale(this.mSource.getContext(), null, requestExecutor);
    }

    @Override // com.kugou.common.permission.overlay.OverlayRequest
    public final OverlayRequest onGranted(GrantAction<Void> grantAction) {
        this.mGrantAction = grantAction;
        return this;
    }
}
