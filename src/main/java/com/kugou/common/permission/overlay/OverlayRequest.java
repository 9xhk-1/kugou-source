package com.kugou.common.permission.overlay;

import com.kugou.common.permission.Action;
import com.kugou.common.permission.GrantAction;
import com.kugou.common.permission.Rationale;

/* JADX INFO: loaded from: classes2.dex */
public interface OverlayRequest {
    OverlayRequest onDenied(Action<Void> action);

    @Deprecated
    OverlayRequest onGranted(Action<Void> action);

    OverlayRequest onGranted(GrantAction<Void> grantAction);

    OverlayRequest rationale(Rationale<Void> rationale);

    void start();
}
