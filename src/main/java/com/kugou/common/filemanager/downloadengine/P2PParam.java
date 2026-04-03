package com.kugou.common.filemanager.downloadengine;

import android.support.annotation.IntRange;
import android.support.v4.media.MediaDescriptionCompat;

/* JADX INFO: loaded from: classes2.dex */
public class P2PParam {
    private String dfid;
    private boolean enableCheckNATv6;
    private boolean enableFakePushHash;
    private boolean enableP2PPush;
    private long flowReportMB;
    private boolean forceOnlyIPv6;
    private int ipv6Intranet;
    private int maxMVUnreadBuffer;
    private int minMVUnreadBuffer;
    private int mobileIntranet;
    private int pcIntranet;
    private String socks5;
    private int minAppSpeed = -1;
    private int minDownloadSpeed = -1;
    private int minMusicDownloadSpeed = -1;
    private int minMVDownloadSpeed = -1;
    private int playCDNAccelerate = -1;
    private int playMVCDNAccelerate = -1;
    private int seafileTimeout = 0;
    private int seafileFirstTimeout = 0;
    private int maxChannel = 0;
    private int waitRttScale = -1;
    private int channelSpeedUp = -1;
    private int maxPushSpeed = 0;
    private int playSongScale = -1;
    private int backgroundPlaySongLimitScale = -1;
    private int downSongScale = -1;
    private int playMVScale = -1;
    private int downMVScale = -1;
    private boolean mvAutoSuspendBuffer = false;
    private int songExtraSrc = -1;
    private int songHeadBufferSeconds = 0;
    private int mvHeadBufferSeconds = 0;
    private int mvLowBufferSeconds = 0;
    private int mvLowSpeedSeconds = 0;
    private int mvLowSpeedScale = 0;
    private int musicAbortP2PSeedNum = 0;
    private int mvAbortP2PSeedNum = 0;
    private boolean telecomUA = true;
    private int feeVerifyPolicy = 1;
    private boolean cacheV4 = false;
    private boolean dnsIPv6First = false;
    private int ipv6FallbackTimeout = 0;
    private boolean ipv6CDNFirst = false;
    private int ipv6FlowPercent = 0;
    private int firstBlockDNSPolicy = 0;
    private int xcdnMinReadSpeedKB = 0;
    private int xcdnConnectTimeout = 0;
    private int ipv6P2PSwitch = 0;
    private long ipv6PeerPolicy = 0;
    private boolean retryMoreIP = false;
    private int waitID3DataTimeout = 0;
    private int natLans6 = 10;
    private int natInterval6 = 10;
    private int loginNatProxy = 0;
    private boolean sharableIPv6 = false;
    private boolean masterTapePlayTransform = false;

    public int getBackgroundPlaySongLimitScale() {
        return this.backgroundPlaySongLimitScale;
    }

    public boolean getCacheV4() {
        return this.cacheV4;
    }

    public int getChannelSpeedUp() {
        return this.channelSpeedUp;
    }

    public String getDFID() {
        return this.dfid;
    }

    public int getDownMVScale() {
        return this.downMVScale;
    }

    public int getDownSongScale() {
        return this.downSongScale;
    }

    public boolean getEnableCheckNATv6() {
        return this.enableCheckNATv6;
    }

    public boolean getEnableP2PPush() {
        return this.enableP2PPush;
    }

    public boolean getFakePushHash() {
        return this.enableFakePushHash;
    }

    public int getFeeVerifyPolicy() {
        return this.feeVerifyPolicy;
    }

    public int getFirstBlockDNSPolicy() {
        return this.firstBlockDNSPolicy;
    }

    public long getFlowReportMB() {
        return this.flowReportMB;
    }

    public boolean getForceOnlyIPv6() {
        return this.forceOnlyIPv6;
    }

    public boolean getIPv6CDNFirst() {
        return this.ipv6CDNFirst;
    }

    public int getIPv6FallbackTimeout() {
        return this.ipv6FallbackTimeout;
    }

    public boolean getIPv6First() {
        return this.dnsIPv6First;
    }

    public int getIPv6FlowPercent() {
        return this.ipv6FlowPercent;
    }

    public int getIPv6Intranet() {
        return this.ipv6Intranet;
    }

    public int getIPv6P2PSwitch() {
        return this.ipv6P2PSwitch;
    }

    public long getIPv6PeerPolicy() {
        return this.ipv6PeerPolicy;
    }

    public int getLoginNatProxy() {
        return this.loginNatProxy;
    }

    public int getMVAbortP2PSeedNum() {
        return this.mvAbortP2PSeedNum;
    }

    public boolean getMVAutoSuspendBuffer() {
        return this.mvAutoSuspendBuffer;
    }

    public int getMVHeadBufferSeconds() {
        return this.mvHeadBufferSeconds;
    }

    public int getMVLowBufferSeconds() {
        return this.mvLowBufferSeconds;
    }

    public int getMVLowSpeedScale() {
        return this.mvLowSpeedScale;
    }

    public int getMVLowSpeedSeconds() {
        return this.mvLowSpeedSeconds;
    }

    public boolean getMasterTapePlayTransform() {
        return this.masterTapePlayTransform;
    }

    public int getMaxChannel() {
        return this.maxChannel;
    }

    public int getMaxMVUnreadBuffer() {
        return this.maxMVUnreadBuffer;
    }

    public int getMaxPushSpeed() {
        return this.maxPushSpeed;
    }

    public int getMinAppSpeed() {
        return this.minAppSpeed;
    }

    public int getMinDownloadSpeed() {
        return this.minDownloadSpeed;
    }

    public int getMinMVDownloadSpeed() {
        return this.minMVDownloadSpeed;
    }

    public int getMinMVUnreadBuffer() {
        return this.minMVUnreadBuffer;
    }

    public int getMinMusicDownloadSpeed() {
        return this.minMusicDownloadSpeed;
    }

    public int getMobileIntranet() {
        return this.mobileIntranet;
    }

    public int getMusicAbortP2PSeedNum() {
        return this.musicAbortP2PSeedNum;
    }

    public int getNatInterval6() {
        return this.natInterval6;
    }

    public int getNatLans6() {
        return this.natLans6;
    }

    public int getPCIntranet() {
        return this.pcIntranet;
    }

    public int getPlayCDNAccelerate() {
        return this.playCDNAccelerate;
    }

    public int getPlayMVCDNAccelerate() {
        return this.playMVCDNAccelerate;
    }

    public int getPlayMVScale() {
        return this.playMVScale;
    }

    public int getPlaySongScale() {
        return this.playSongScale;
    }

    public boolean getRetryMoreIP() {
        return this.retryMoreIP;
    }

    public String getSOCKS5() {
        return this.socks5;
    }

    public int getSeafileFirstTimeout() {
        return this.seafileFirstTimeout;
    }

    public int getSeafileTimeout() {
        return this.seafileTimeout;
    }

    public boolean getSharableIPv6() {
        return this.sharableIPv6;
    }

    public int getSongExtraSrc() {
        return this.songExtraSrc;
    }

    public int getSongHeadBufferSeconds() {
        return this.songHeadBufferSeconds;
    }

    public boolean getTelecomUA() {
        return this.telecomUA;
    }

    public int getWaitID3DataTimeout() {
        return this.waitID3DataTimeout;
    }

    public int getWaitRttScale() {
        return this.waitRttScale;
    }

    public int getXcdnConnectTimeout() {
        return this.xcdnConnectTimeout;
    }

    public int getXcdnMinReadSpeedKB() {
        return this.xcdnMinReadSpeedKB;
    }

    public void setBackgroundPlaySongLimitScale(int i2) {
        this.backgroundPlaySongLimitScale = i2;
    }

    public void setCacheV4(boolean z) {
        this.cacheV4 = z;
    }

    public void setChannelSpeedUp(int i2) {
        this.channelSpeedUp = i2;
    }

    public void setDFID(String str) {
        this.dfid = str;
    }

    public void setDownMVScale(int i2) {
        this.downMVScale = i2;
    }

    public void setDownSongScale(int i2) {
        this.downSongScale = i2;
    }

    public void setEnableCheckNATv6(boolean z) {
        this.enableCheckNATv6 = z;
    }

    public void setEnableFakePushHash(boolean z) {
        this.enableFakePushHash = z;
    }

    public void setEnableP2PPush(boolean z) {
        this.enableP2PPush = z;
    }

    public void setFeeVerifyPolicy(int i2) {
        this.feeVerifyPolicy = i2;
    }

    public void setFirstBlockDNSPolicy(@IntRange(from = 0, to = 10) int i2) {
        this.firstBlockDNSPolicy = i2;
    }

    public void setFlowReportMB(@IntRange(from = 0, to = 1024) long j) {
        this.flowReportMB = j;
    }

    public void setForceOnlyIPv6(boolean z) {
        this.forceOnlyIPv6 = z;
    }

    public void setIPv6CDNFirst(boolean z) {
        this.ipv6CDNFirst = z;
    }

    public void setIPv6FallbackTimeout(int i2) {
        this.ipv6FallbackTimeout = i2;
    }

    public void setIPv6First(boolean z) {
        this.dnsIPv6First = z;
    }

    public void setIPv6FlowPercent(@IntRange(from = 0, to = 100) int i2) {
        this.ipv6FlowPercent = i2;
    }

    public void setIPv6Intranet(@IntRange(from = 0, to = 1) int i2) {
        this.ipv6Intranet = i2;
    }

    public void setIPv6P2PSwitch(@IntRange(from = 0, to = MediaDescriptionCompat.BT_FOLDER_TYPE_ARTISTS) int i2) {
        this.ipv6P2PSwitch = i2;
    }

    public void setIPv6PeerPolicy(@IntRange(from = 0, to = 9999999999L) long j) {
        this.ipv6PeerPolicy = j;
    }

    public void setLoginNatProxy(@IntRange(from = 0, to = MediaDescriptionCompat.BT_FOLDER_TYPE_ARTISTS) int i2) {
        this.loginNatProxy = i2;
    }

    public void setMVAbortP2PSeedNum(@IntRange(from = 0) int i2) {
        this.mvAbortP2PSeedNum = i2;
    }

    public void setMVAutoSuspendBuffer(boolean z) {
        this.mvAutoSuspendBuffer = z;
    }

    public void setMVHeadBufferSeconds(int i2) {
        this.mvHeadBufferSeconds = i2;
    }

    public void setMVLowBufferSeconds(int i2) {
        this.mvLowBufferSeconds = i2;
    }

    public void setMVLowSpeedScale(int i2) {
        this.mvLowSpeedScale = i2;
    }

    public void setMVLowSpeedSeconds(int i2) {
        this.mvLowSpeedSeconds = i2;
    }

    public void setMasterTapePlayTransform(boolean z) {
        this.masterTapePlayTransform = z;
    }

    public void setMaxChannel(int i2) {
        this.maxChannel = i2;
    }

    public void setMaxMVUnreadBuffer(int i2) {
        this.maxMVUnreadBuffer = i2;
    }

    public void setMaxPushSpeed(int i2) {
        this.maxPushSpeed = i2;
    }

    public void setMinAppSpeed(int i2) {
        this.minAppSpeed = i2;
    }

    public void setMinDownloadSpeed(int i2) {
        this.minDownloadSpeed = i2;
    }

    public void setMinMVDownloadSpeed(int i2) {
        this.minMVDownloadSpeed = i2;
    }

    public void setMinMVUnreadBuffer(int i2) {
        this.minMVUnreadBuffer = i2;
    }

    public void setMinMusicDownloadSpeed(int i2) {
        this.minMusicDownloadSpeed = i2;
    }

    public void setMobileIntranet(@IntRange(from = 0, to = 1) int i2) {
        this.mobileIntranet = i2;
    }

    public void setMusicAbortP2PSeedNum(@IntRange(from = 0) int i2) {
        this.musicAbortP2PSeedNum = i2;
    }

    public void setNatInterval6(@IntRange(from = 0, to = 30) int i2) {
        this.natInterval6 = i2;
    }

    public void setNatLans6(@IntRange(from = 0, to = 100) int i2) {
        this.natLans6 = i2;
    }

    public void setPCIntranet(@IntRange(from = 0, to = 1) int i2) {
        this.pcIntranet = i2;
    }

    public void setPlayCDNAccelerate(int i2) {
        this.playCDNAccelerate = i2;
    }

    public void setPlayMVCDNAccelerate(int i2) {
        this.playMVCDNAccelerate = i2;
    }

    public void setPlayMVScale(int i2) {
        this.playMVScale = i2;
    }

    public void setPlaySongScale(int i2) {
        this.playSongScale = i2;
    }

    public void setRetryMoreIP(boolean z) {
        this.retryMoreIP = z;
    }

    public void setSOCKS5(String str) {
        this.socks5 = str;
    }

    public void setSeafileFirstTimeout(int i2) {
        this.seafileFirstTimeout = i2;
    }

    public void setSeafileTimeout(int i2) {
        this.seafileTimeout = i2;
    }

    public void setSharableIPv6(boolean z) {
        this.sharableIPv6 = z;
    }

    public void setSongExtraSrc(int i2) {
        this.songExtraSrc = i2;
    }

    public void setSongHeadBufferSeconds(int i2) {
        this.songHeadBufferSeconds = i2;
    }

    public void setTelecomUA(boolean z) {
        this.telecomUA = z;
    }

    public void setWaitID3DataTimeout(int i2) {
        this.waitID3DataTimeout = i2;
    }

    public void setWaitRttScale(int i2) {
        this.waitRttScale = i2;
    }

    public void setXcdnConnectTimeout(@IntRange(from = 0) int i2) {
        this.xcdnConnectTimeout = i2;
    }

    public void setXcdnMinReadSpeedKB(@IntRange(from = 0) int i2) {
        this.xcdnMinReadSpeedKB = i2;
    }
}
