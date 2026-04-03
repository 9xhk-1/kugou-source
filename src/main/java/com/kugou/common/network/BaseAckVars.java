package com.kugou.common.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.kugou.common.network.netgate.AckDnsManager;
import com.kugou.common.network.netgate.AckHostConfigEntity;
import com.kugou.common.network.netgate.AckHostManager;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.network.netgate.AckProtocolManager;
import com.kugou.common.network.netgate.HostKeyProtocolEntity;
import com.kugou.common.network.netgate.NetgateEntity;
import com.kugou.common.network.netgate.NetgateManager;
import com.kugou.common.network.protocol.RequestPackage;
import com.kugou.common.network.retry.HttpRetryManager;
import com.kugou.common.network.retry.RetryConfigInfo;
import com.kugou.common.network.retry.RetryExtraParam;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseAckVars extends AbsAckVars {
    public long startTime = SystemClock.elapsedRealtime();
    private Executor executor = Executors.newCachedThreadPool();

    @Override // com.kugou.common.network.AbsAckVars
    public boolean canUseUnicomProxy() {
        return false;
    }

    @Override // com.kugou.common.network.AbsAckVars
    public void execute(Runnable runnable) {
        this.executor.execute(runnable);
    }

    @Override // com.kugou.common.network.AbsAckVars
    public List<String> getAckDnsAddress(String str) {
        return AckDnsManager.getInstance().getAddress(str);
    }

    @Override // com.kugou.common.network.AbsAckVars
    public List<AckHostConfigEntity.UrlHostEntity> getAckHostList(String str) {
        return AckHostManager.getInstance().getHostList(str);
    }

    @Override // com.kugou.common.network.AbsAckVars
    public HostKeyProtocolEntity getAckProtocolEntity(String str) {
        return AckProtocolManager.getInstance().getProtocolEntity(str);
    }

    @Override // com.kugou.common.network.AbsAckVars
    public abstract Hashtable<String, String> getAckRequestParams();

    @Override // com.kugou.common.network.AbsAckVars
    public abstract String getAckUrl();

    @Override // com.kugou.common.network.AbsAckVars
    public abstract String getBackupAddress();

    @Override // com.kugou.common.network.AbsAckVars
    public String getBgServiceConnectAction() {
        return "";
    }

    @Override // com.kugou.common.network.AbsAckVars
    public abstract Context getContext();

    @Override // com.kugou.common.network.AbsAckVars
    public int getDefalutRawResource() {
        return 0;
    }

    @Override // com.kugou.common.network.AbsAckVars
    public HostKeyProtocolEntity getExtraAckProtocolEntity(String str) {
        return null;
    }

    @Override // com.kugou.common.network.AbsAckVars
    public abstract AbsHttpClient getHttpClient();

    @Override // com.kugou.common.network.AbsAckVars
    public String getKingProxyCheckUrl(String str) {
        return null;
    }

    @Override // com.kugou.common.network.AbsAckVars
    public List<NetgateEntity> getNetgate(String str) {
        return NetgateManager.getInstance().getNetgate(str);
    }

    @Override // com.kugou.common.network.AbsAckVars
    public List<String> getRequestRetryUrls(RequestPackage requestPackage) {
        return new ArrayList();
    }

    @Override // com.kugou.common.network.AbsAckVars
    public RetryConfigInfo getRetryConfigInfo(@NonNull String str) {
        return HttpRetryManager.getInstance().getRetryConfigInfo(str);
    }

    @Override // com.kugou.common.network.AbsAckVars
    public RetryStaticsLOG getRetryStaticsLOG() {
        return new RetryStaticsLOG(getContext());
    }

    @Override // com.kugou.common.network.AbsAckVars
    public abstract String getRetryTime();

    @Override // com.kugou.common.network.AbsAckVars
    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.kugou.common.network.AbsAckVars
    public void handleNetQuality(AbsHttpClient absHttpClient, RetryExtraParam retryExtraParam, RequestPackage requestPackage, Exception exc, int i2, boolean z, int i3, int i4) {
    }

    @Override // com.kugou.common.network.AbsAckVars
    public boolean isAvalidNetSetting(Context context) {
        return true;
    }

    @Override // com.kugou.common.network.AbsAckVars
    public boolean isBgProcess() {
        return true;
    }

    @Override // com.kugou.common.network.AbsAckVars
    public boolean isEnableProtocolRetry() {
        getHttpClient().getmHttpVariables();
        return AbsHttpVars.isEnableProtocolRetry;
    }

    @Override // com.kugou.common.network.AbsAckVars
    public boolean isProbePickUp() {
        return false;
    }

    @Override // com.kugou.common.network.AbsAckVars
    public void markRequest(String str, String str2, int i2, int i3) {
        HttpRetryManager.getInstance().markRequest(str, str2, i2, i3);
    }

    @Override // com.kugou.common.network.AbsAckVars
    public void networkHasReady() {
    }

    @Override // com.kugou.common.network.AbsAckVars
    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
    }

    @Override // com.kugou.common.network.AbsAckVars
    public abstract void registerSysReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter);

    @Override // com.kugou.common.network.AbsAckVars
    public void reportKingProxyError(int i2, String str, Exception exc, long j) {
    }

    @Override // com.kugou.common.network.AbsAckVars
    public void sendException(boolean z, boolean z2, String str) {
    }

    @Override // com.kugou.common.network.AbsAckVars
    public boolean setAckDnsAddressAvailable(String str, String str2, boolean z) {
        return AckDnsManager.getInstance().setAddressAvailable(str, str2, z);
    }

    @Override // com.kugou.common.network.AbsAckVars
    public void setLastNetworkActiveMillies(long j) {
        AckManager.getInstance().setLastNetworkdActiveMillies(j);
    }

    @Override // com.kugou.common.network.AbsAckVars
    public void setLocalServers(String str) {
    }

    @Override // com.kugou.common.network.AbsAckVars
    public boolean setNetgateAvailable(String str, boolean z) {
        return NetgateManager.getInstance().setNetgateAvailable(str, z);
    }

    @Override // com.kugou.common.network.AbsAckVars
    public void setServerTime(long j) {
    }
}
