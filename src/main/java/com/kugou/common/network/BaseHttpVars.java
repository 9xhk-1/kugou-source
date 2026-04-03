package com.kugou.common.network;

import com.kugou.common.network.networkutils.NetLog;
import com.kugou.common.network.proxy.KGHttpProxy;
import com.kugou.common.network.retry.DefaultRetryStrategy;
import com.kugou.common.network.retry.IRetryStrategy;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;

/* JADX INFO: loaded from: classes.dex */
public class BaseHttpVars extends AbsHttpVars {
    @Override // com.kugou.common.network.AbsHttpVars
    public KGHttpProxy getHttpProxy(String str) {
        return null;
    }

    @Override // com.kugou.common.network.AbsHttpVars
    public NetLog.ILog getILog() {
        return null;
    }

    @Override // com.kugou.common.network.AbsHttpVars
    public IRetryStrategy getRetryStrategy() {
        return DefaultRetryStrategy.getInstance();
    }

    @Override // com.kugou.common.network.AbsHttpVars
    public boolean isRetryStaticsOn() {
        return false;
    }

    @Override // com.kugou.common.network.AbsHttpVars
    public void logRetryNetwork(RetryStaticsLOG retryStaticsLOG) {
    }

    @Override // com.kugou.common.network.AbsHttpVars
    public void startNetTraffic() {
    }

    @Override // com.kugou.common.network.AbsHttpVars
    public void stopNetTraffic(long j) {
    }
}
