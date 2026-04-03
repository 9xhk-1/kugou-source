package com.kugou.common.filemanager.downloadengine.stat;

/* JADX INFO: loaded from: classes2.dex */
public class NatProxyClientStat {
    private int natType = 0;
    private boolean ipv6 = false;
    private int success = 0;
    private int connectOver = 0;
    private int connectSuccTimes = 0;
    private int connectFailTimes = 0;
    private int getProxySuccTimes = 0;
    private int getProxyFailTimes = 0;
    private int duration = 0;
    private int getProxyDuration = 0;
    private int connectDuration = 0;

    public NatProxyClientStat createNew() {
        NatProxyClientStat natProxyClientStat = new NatProxyClientStat();
        natProxyClientStat.ipv6 = this.ipv6;
        return natProxyClientStat;
    }

    public int getConnectDuration() {
        return this.connectDuration;
    }

    public int getConnectFailTimes() {
        return this.connectFailTimes;
    }

    public int getConnectOver() {
        return this.connectOver;
    }

    public int getConnectSuccTimes() {
        return this.connectSuccTimes;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getGetProxyDuration() {
        return this.getProxyDuration;
    }

    public int getGetProxyFailTimes() {
        return this.getProxyFailTimes;
    }

    public int getGetProxySuccTimes() {
        return this.getProxySuccTimes;
    }

    public int getNatType() {
        return this.natType;
    }

    public int getSuccess() {
        return this.success;
    }

    public boolean isFinished() {
        return this.success == 1 || this.connectOver == 1;
    }

    public boolean isIPv6() {
        return this.ipv6;
    }

    public boolean isValid() {
        return (getConnectSuccTimes() == 0 && getConnectFailTimes() == 0 && getGetProxySuccTimes() == 0 && getGetProxyFailTimes() == 0) ? false : true;
    }

    public void merge(NatProxyClientStat natProxyClientStat) {
        this.natType = natProxyClientStat.natType;
        this.ipv6 = natProxyClientStat.ipv6;
        this.connectFailTimes += natProxyClientStat.connectFailTimes;
        this.success = natProxyClientStat.success;
        this.connectOver = natProxyClientStat.connectOver;
        this.duration += natProxyClientStat.duration;
        this.getProxyDuration += natProxyClientStat.getProxyDuration;
        this.connectDuration += natProxyClientStat.connectDuration;
        this.connectSuccTimes += natProxyClientStat.connectSuccTimes;
        this.getProxySuccTimes += natProxyClientStat.getProxySuccTimes;
        this.getProxyFailTimes += natProxyClientStat.getProxyFailTimes;
    }

    public void setConnectDuration(int i2) {
        this.connectDuration = i2;
    }

    public void setConnectFailTimes(int i2) {
        this.connectFailTimes = i2;
    }

    public void setConnectOver(int i2) {
        this.connectOver = i2;
    }

    public void setConnectSuccTimes(int i2) {
        this.connectSuccTimes = i2;
    }

    public void setDuration(int i2) {
        this.duration = i2;
    }

    public void setGetProxyDuration(int i2) {
        this.getProxyDuration = i2;
    }

    public void setGetProxyFailTimes(int i2) {
        this.getProxyFailTimes = i2;
    }

    public void setGetProxySuccTimes(int i2) {
        this.getProxySuccTimes = i2;
    }

    public void setIPv6(boolean z) {
        this.ipv6 = z;
    }

    public void setNatType(int i2) {
        this.natType = i2;
    }

    public void setSuccess(int i2) {
        this.success = i2;
    }
}
