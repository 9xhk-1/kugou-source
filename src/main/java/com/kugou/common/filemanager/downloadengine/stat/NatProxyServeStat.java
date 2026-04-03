package com.kugou.common.filemanager.downloadengine.stat;

import android.support.annotation.IntRange;

/* JADX INFO: loaded from: classes2.dex */
public class NatProxyServeStat {
    private int missLatelyRoutePkgNum;
    private int noProxyRoutePkgNum;
    private int natType = 0;
    private boolean ipv6 = false;
    private int acceptTimes = 0;
    private int denyTimes = 0;
    private int onlineCount = 0;
    private int invalidRoutePkgNum = 0;
    private int routePkgNum = 0;
    private int duration = 0;
    private int maxChannel = 0;
    private long allClientDuration = 0;
    private long allChannelDuration = 0;

    public int getAcceptTimes() {
        return this.acceptTimes;
    }

    public long getAllChannelDuration() {
        return this.allChannelDuration;
    }

    public long getAllClientDuration() {
        return this.allClientDuration;
    }

    public int getDenyTimes() {
        return this.denyTimes;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getInvalidRoutePkgNum() {
        return this.invalidRoutePkgNum;
    }

    public int getMaxChannel() {
        return this.maxChannel;
    }

    public int getMissLatelyRoutePkgNum() {
        return this.missLatelyRoutePkgNum;
    }

    public int getNatType() {
        return this.natType;
    }

    public int getNoProxyRoutePkgNum() {
        return this.noProxyRoutePkgNum;
    }

    public int getOnlineCount() {
        return this.onlineCount;
    }

    public int getRoutePkgNum() {
        return this.routePkgNum;
    }

    public boolean isIPv6() {
        return this.ipv6;
    }

    public void merge(NatProxyServeStat natProxyServeStat) {
        this.acceptTimes += natProxyServeStat.acceptTimes;
        this.denyTimes += natProxyServeStat.denyTimes;
        int i2 = this.onlineCount;
        int i3 = natProxyServeStat.onlineCount;
        if (i2 < i3) {
            this.onlineCount = i3;
        }
        this.noProxyRoutePkgNum += natProxyServeStat.noProxyRoutePkgNum;
        this.missLatelyRoutePkgNum += natProxyServeStat.missLatelyRoutePkgNum;
        this.invalidRoutePkgNum += natProxyServeStat.invalidRoutePkgNum;
        this.routePkgNum += natProxyServeStat.routePkgNum;
        this.maxChannel = natProxyServeStat.maxChannel;
        this.duration += natProxyServeStat.duration;
        this.allChannelDuration += natProxyServeStat.allChannelDuration;
        this.allClientDuration += natProxyServeStat.allClientDuration;
    }

    public void setAcceptTimes(int i2) {
        this.acceptTimes = i2;
    }

    public void setAllChannelDuration(@IntRange(from = 0) long j) {
        this.allChannelDuration = j;
    }

    public void setAllClientDuration(@IntRange(from = 0) long j) {
        this.allClientDuration = j;
    }

    public void setDenyTimes(int i2) {
        this.denyTimes = i2;
    }

    public void setDuration(int i2) {
        this.duration = i2;
    }

    public void setIPv6(boolean z) {
        this.ipv6 = z;
    }

    public void setInvalidRoutePkgNum(int i2) {
        this.invalidRoutePkgNum = i2;
    }

    public void setMaxChannel(int i2) {
        this.maxChannel = i2;
    }

    public void setMissLatelyRoutePkgNum(int i2) {
        this.missLatelyRoutePkgNum = i2;
    }

    public void setNatType(int i2) {
        this.natType = i2;
    }

    public void setNoProxyRoutePkgNum(int i2) {
        this.noProxyRoutePkgNum = i2;
    }

    public void setOnlineCount(int i2) {
        this.onlineCount = i2;
    }

    public void setRoutePkgNum(int i2) {
        this.routePkgNum = i2;
    }
}
