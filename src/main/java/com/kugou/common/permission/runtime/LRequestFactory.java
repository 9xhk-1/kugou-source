package com.kugou.common.permission.runtime;

import com.kugou.common.permission.runtime.Runtime;
import com.kugou.common.permission.source.Source;

/* JADX INFO: loaded from: classes2.dex */
public class LRequestFactory implements Runtime.PermissionRequestFactory {
    @Override // com.kugou.common.permission.runtime.Runtime.PermissionRequestFactory
    public PermissionRequest create(Source source) {
        return new LRequest(source);
    }
}
