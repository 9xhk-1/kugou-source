package com.kugou.common.permission.install;

import com.kugou.common.permission.source.Source;

/* JADX INFO: loaded from: classes2.dex */
public class NRequest extends BaseRequest {
    public NRequest(Source source) {
        super(source);
    }

    @Override // com.kugou.common.permission.install.InstallRequest
    public void start() {
        callbackSucceed();
        install();
    }
}
