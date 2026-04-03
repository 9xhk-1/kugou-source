package com.kugou.common.permission.install;

import com.kugou.common.permission.Options;
import com.kugou.common.permission.source.Source;

/* JADX INFO: loaded from: classes2.dex */
public class ORequestFactory implements Options.InstallRequestFactory {
    @Override // com.kugou.common.permission.Options.InstallRequestFactory
    public InstallRequest create(Source source) {
        return new ORequest(source);
    }
}
