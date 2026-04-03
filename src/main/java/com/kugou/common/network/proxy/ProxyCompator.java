package com.kugou.common.network.proxy;

import android.support.annotation.NonNull;
import com.kugou.common.network.AbsHttpVars;
import com.kugou.common.network.netgate.AckManager;

/* JADX INFO: loaded from: classes2.dex */
public class ProxyCompator {
    public static KGHttpProxy createHttpProxy(String str, @NonNull AbsHttpVars absHttpVars) {
        KGHttpProxy httpProxy = absHttpVars.getHttpProxy(str);
        return httpProxy == null ? CMWapProxy.newInstance(AckManager.getAckVars().getContext()) : httpProxy;
    }
}
