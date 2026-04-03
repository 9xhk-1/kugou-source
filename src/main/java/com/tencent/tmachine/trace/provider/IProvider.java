package com.tencent.tmachine.trace.provider;

import com.tencent.tmachine.trace.core.ErrorExtra;
import com.tencent.tmachine.trace.core.IProviderListener;

/* JADX INFO: loaded from: classes2.dex */
public interface IProvider {
    boolean destroy();

    boolean disable();

    boolean enable();

    void error(ErrorExtra errorExtra);

    boolean init(IProviderListener iProviderListener);
}
