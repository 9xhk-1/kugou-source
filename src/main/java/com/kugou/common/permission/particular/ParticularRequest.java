package com.kugou.common.permission.particular;

import com.kugou.common.permission.Action;
import com.kugou.common.permission.GrantAction;
import com.kugou.common.permission.Rationale;

/* JADX INFO: loaded from: classes2.dex */
public interface ParticularRequest {
    ParticularRequest onDenied(Action<Void> action);

    @Deprecated
    ParticularRequest onGranted(Action<Void> action);

    ParticularRequest onGranted(GrantAction<Void> grantAction);

    ParticularRequest rationale(Rationale<Void> rationale);

    void start();
}
