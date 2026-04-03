package com.kugou.common.network.retry;

import com.kugou.common.network.protocol.RequestPackage;

/* JADX INFO: loaded from: classes2.dex */
public interface NetQuality {
    void onNetQuality(RequestPackage requestPackage, Exception exc);
}
