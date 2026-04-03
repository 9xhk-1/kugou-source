package com.kugou.android.watch.lite.common.network;

import com.kugou.android.watch.lite.common.INoGuard;
import com.kugou.android.watch.lite.common.network.http.HttpLoggingInterceptor;
import com.kugou.android.watch.lite.common.network.http.RetrofitRequestInterceptor;
import com.kugou.common.network.AbsHttpVars;
import com.kugou.common.network.BaseHttpVars;
import com.kugou.common.network.networkutils.NetLog;
import com.kugou.common.network.proxy.KGHttpProxy;
import com.kugou.common.network.retry.ACKRetryStrategy;
import com.kugou.common.network.retry.IRetryStrategy;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import e.c.a.g.a.f.m.c;
import e.c.a.g.a.f.n.a;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class KGHttpVariables extends BaseHttpVars implements INoGuard {
    private static final int PERSONALITY = 1;
    private static KGHttpVariables instance;
    private volatile boolean isInitRecValue = false;

    private KGHttpVariables() {
        AbsHttpVars.isEnableProtocolRetry = true;
    }

    public static KGHttpVariables getInstance() {
        if (instance == null) {
            synchronized (KGHttpVariables.class) {
                if (instance == null) {
                    instance = new KGHttpVariables();
                }
            }
        }
        return instance;
    }

    public static KGHttpVariables getInstance2() {
        return getInstance();
    }

    @Override // com.kugou.common.network.BaseHttpVars, com.kugou.common.network.AbsHttpVars
    public KGHttpProxy getHttpProxy(String str) {
        return null;
    }

    @Override // com.kugou.common.network.BaseHttpVars, com.kugou.common.network.AbsHttpVars
    public NetLog.ILog getILog() {
        return null;
    }

    @Override // com.kugou.common.network.AbsHttpVars
    public String getMockInterceptor() {
        return g0.a ? HttpLoggingInterceptor.class.getName() : "";
    }

    @Override // com.kugou.common.network.AbsHttpVars
    public String getOuterInterceptor() {
        return RetrofitRequestInterceptor.class.getName();
    }

    @Override // com.kugou.common.network.AbsHttpVars
    public int getRec() {
        int iC;
        if (this.isInitRecValue) {
            iC = a.b().c(149, 0);
        } else {
            synchronized (this) {
                if (this.isInitRecValue) {
                    iC = a.b().c(149, 0);
                } else {
                    iC = refreshRecValue();
                    this.isInitRecValue = true;
                }
            }
        }
        if (g0.a) {
            g0.b("kg_net", "recValue: " + Integer.toBinaryString(iC));
        }
        return iC;
    }

    @Override // com.kugou.common.network.BaseHttpVars, com.kugou.common.network.AbsHttpVars
    public IRetryStrategy getRetryStrategy() {
        return ACKRetryStrategy.getInstance();
    }

    @Override // com.kugou.common.network.BaseHttpVars, com.kugou.common.network.AbsHttpVars
    public boolean isRetryStaticsOn() {
        return false;
    }

    @Override // com.kugou.common.network.BaseHttpVars, com.kugou.common.network.AbsHttpVars
    public void logRetryNetwork(RetryStaticsLOG retryStaticsLOG) {
    }

    public int refreshRecValue() {
        int i2 = c.a.e("KEY_ENABLE_PERSONALITY_REC", true) ? 1 : 0;
        if (g0.a) {
            g0.b("kg_net", "setting: " + Integer.toBinaryString(i2));
        }
        a.b().g(149, i2);
        return i2;
    }

    @Override // com.kugou.common.network.BaseHttpVars, com.kugou.common.network.AbsHttpVars
    public void startNetTraffic() {
    }

    @Override // com.kugou.common.network.BaseHttpVars, com.kugou.common.network.AbsHttpVars
    public void stopNetTraffic(long j) {
    }
}
