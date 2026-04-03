package com.kugou.common.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import com.kugou.common.network.netgate.AckHostConfigEntity;
import com.kugou.common.network.netgate.HostKeyProtocolEntity;
import com.kugou.common.network.netgate.NetgateEntity;
import com.kugou.common.network.protocol.RequestPackage;
import com.kugou.common.network.retry.RetryConfigInfo;
import com.kugou.common.network.retry.RetryExtraParam;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import java.util.Hashtable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsAckVars {
    public abstract boolean canUseUnicomProxy();

    public abstract void execute(Runnable runnable);

    public abstract List<String> getAckDnsAddress(String str);

    public abstract List<AckHostConfigEntity.UrlHostEntity> getAckHostList(String str);

    public abstract HostKeyProtocolEntity getAckProtocolEntity(String str);

    public abstract Hashtable<String, String> getAckRequestParams();

    public abstract String getAckUrl();

    public abstract String getBackupAddress();

    public abstract String getBgServiceConnectAction();

    public String getCachePrefix() {
        return "ack-";
    }

    public abstract Context getContext();

    public abstract int getDefalutRawResource();

    public abstract HostKeyProtocolEntity getExtraAckProtocolEntity(String str);

    public abstract AbsHttpClient getHttpClient();

    public abstract String getKingProxyCheckUrl(String str);

    public abstract List<NetgateEntity> getNetgate(String str);

    public abstract List<String> getRequestRetryUrls(RequestPackage requestPackage);

    public abstract RetryConfigInfo getRetryConfigInfo(@NonNull String str);

    public abstract RetryStaticsLOG getRetryStaticsLOG();

    public abstract String getRetryTime();

    public String getSharedPreferencesName() {
        return "ispArea";
    }

    public abstract long getStartTime();

    public abstract void handleNetQuality(AbsHttpClient absHttpClient, RetryExtraParam retryExtraParam, RequestPackage requestPackage, Exception exc, int i2, boolean z, int i3, int i4);

    public abstract boolean isAvalidNetSetting(Context context);

    public abstract boolean isBgProcess();

    public abstract boolean isEnableProtocolRetry();

    public abstract boolean isProbePickUp();

    public abstract void markRequest(String str, String str2, int i2, int i3);

    public abstract void networkHasReady();

    public abstract void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter);

    public abstract void registerSysReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter);

    public abstract void reportKingProxyError(int i2, String str, Exception exc, long j);

    public abstract void sendException(boolean z, boolean z2, String str);

    public abstract boolean setAckDnsAddressAvailable(String str, String str2, boolean z);

    public abstract void setLastNetworkActiveMillies(long j);

    public abstract void setLocalServers(String str);

    public abstract boolean setNetgateAvailable(String str, boolean z);

    public abstract void setServerTime(long j);
}
