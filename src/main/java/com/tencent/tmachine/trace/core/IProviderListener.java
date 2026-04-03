package com.tencent.tmachine.trace.core;

import com.tencent.tmachine.trace.provider.Provider;

/* JADX INFO: loaded from: classes2.dex */
public interface IProviderListener {
    void onDestroy(Provider provider);

    void onDisable(Provider provider);

    void onEnable(Provider provider);

    void onError(Provider provider, ErrorExtra errorExtra);

    void onInit(Provider provider);
}
