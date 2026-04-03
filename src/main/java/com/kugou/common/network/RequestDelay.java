package com.kugou.common.network;

/* JADX INFO: loaded from: classes2.dex */
public class RequestDelay {
    public static final String GET_METHOD_CACHE = "HTTP-直接缓存";
    public static final String GET_METHOD_DIRECT = "HTTP-直接URL";
    public static final String GET_METHOD_NETGATE = "HTTP-容灾网关";
    public static final String GET_METHOD_PROTOCOL = "HTTP-协议重试";
    private long mDelayMillis = -1;
    private String mGetMethod;
    private int mSerId;
    private String mSerIp;

    public long getDelayMillis() {
        return this.mDelayMillis;
    }

    public String getGetMethod() {
        return this.mGetMethod;
    }

    public int getSerId() {
        return this.mSerId;
    }

    public String getSerIp() {
        return this.mSerIp;
    }

    public void setDelayMillis(long j) {
        this.mDelayMillis = j;
    }

    public void setGetMethod(String str) {
        this.mGetMethod = str;
    }

    public void setSerId(int i2) {
        this.mSerId = i2;
    }

    public void setSerIp(String str) {
        this.mSerIp = str;
    }

    public String toString() {
        return "RequestDelay is " + this.mSerIp + ", " + this.mSerId + ", " + this.mGetMethod + ", " + this.mDelayMillis;
    }
}
