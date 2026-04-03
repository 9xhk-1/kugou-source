package com.kugou.common.permission.install;

import com.kugou.common.permission.Action;
import com.kugou.common.permission.GrantAction;
import com.kugou.common.permission.Rationale;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public interface InstallRequest {
    InstallRequest file(File file);

    InstallRequest onDenied(Action<File> action);

    @Deprecated
    InstallRequest onGranted(Action<File> action);

    InstallRequest onGranted(GrantAction<File> grantAction);

    InstallRequest rationale(Rationale<File> rationale);

    void start();
}
