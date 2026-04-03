package com.kugou.common.network;

import android.support.v4.util.Pair;
import com.kugou.common.network.netgate.AckHostConfigEntity;
import com.kugou.common.network.networkutils.NetLog;
import com.kugou.common.network.proxy.KGHttpProxy;
import com.kugou.common.network.retry.IRetryStrategy;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsHttpVars {
    public static final int NETWORK_MODE_CRONET_HTTPS = 3;
    public static final int NETWORK_MODE_CRONET_QUIC = 4;
    public static final int NETWORK_MODE_HTTPCLIENT = 1;
    public static final int NETWORK_MODE_OKHTTP = 2;
    public static boolean isEnableProtocolRetry = false;
    public static int networkMode = 1;
    public static boolean switchparam_kg_user_agent = false;
    public static boolean switchparam_restag = true;
    public static int timeoutparam_2gconnent = 20000;
    public static int timeoutparam_2gread = 20000;
    public static int timeoutparam_3gconnent = 15000;
    public static int timeoutparam_3gread = 15000;
    public static int timeoutparam_wificonnect = 10000;
    public static int timeoutparam_wifiread = 10000;
    private String nameOfPlatformVersion = "Phone";
    private String channelId = "201";
    private boolean isDebug = true;
    private boolean isOnline = true;

    @Retention(RetentionPolicy.SOURCE)
    public @interface NetworkMode {
    }

    @Deprecated
    public String getChanelid() {
        return this.channelId;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public abstract KGHttpProxy getHttpProxy(String str);

    public abstract NetLog.ILog getILog();

    public int getMaxIdleSeparateConnectionCount() {
        return 0;
    }

    public String getMockInterceptor() {
        return null;
    }

    public String getNameOfPlatformVersion() {
        return this.nameOfPlatformVersion;
    }

    public String getNewDomain(String str, List<AckHostConfigEntity.UrlHostEntity> list) {
        return null;
    }

    public long getOkHttpPingInterval() {
        return 0L;
    }

    public String getOuterInterceptor() {
        return null;
    }

    public int getRec() {
        return 0;
    }

    public abstract IRetryStrategy getRetryStrategy();

    public Pair<String, String> getUnifiedGatewayHeader(String str, String str2) {
        return null;
    }

    public int getUnifiedGatewayTimeout() {
        return 0;
    }

    public long getUserId() {
        return 0L;
    }

    public boolean isCronetEnabled() {
        return false;
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public boolean isEnableRC() {
        return false;
    }

    public boolean isEnableRF() {
        return false;
    }

    public boolean isEnableTHash() {
        return false;
    }

    public boolean isEnableUserId() {
        return false;
    }

    public boolean isForceQuicCronetDefault() {
        return false;
    }

    public boolean isHostUsingSeparateConnectionPool(String str) {
        return false;
    }

    public boolean isOnline() {
        return this.isOnline;
    }

    public boolean isQuicUnifiedGateway(String str) {
        return false;
    }

    public abstract boolean isRetryStaticsOn();

    public boolean isUnifiedGateway(String str) {
        return false;
    }

    public abstract void logRetryNetwork(RetryStaticsLOG retryStaticsLOG);

    @Deprecated
    public void setChanelid(String str) {
        this.channelId = str;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public void setIsDebug(boolean z) {
        this.isDebug = z;
    }

    public void setIsOnline(boolean z) {
        this.isOnline = z;
    }

    public void setNameOfPlatformVersion(String str) {
        this.nameOfPlatformVersion = str;
    }

    public abstract void startNetTraffic();

    public abstract void stopNetTraffic(long j);
}
