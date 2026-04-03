package com.kugou.common.filemanager.downloadengine.entity;

/* JADX INFO: loaded from: classes2.dex */
public class HttpSessionInfo {
    private String connectHost;
    private String connectResolvedHost;
    private int errorNumber;
    private String finalConnectIP;
    private int httpErrorCode;

    public HttpSessionInfo() {
    }

    public String getConnectHost() {
        return this.connectHost;
    }

    public String getConnectResolvedHost() {
        return this.connectResolvedHost;
    }

    public int getErrorNumber() {
        return this.errorNumber;
    }

    public String getFinalConnectIP() {
        return this.finalConnectIP;
    }

    public int getHttpErrorCode() {
        return this.httpErrorCode;
    }

    public void setConnectHost(String str) {
        this.connectHost = str;
    }

    public void setConnectResolvedHost(String str) {
        this.connectResolvedHost = str;
    }

    public void setErrorNumber(int i2) {
        this.errorNumber = i2;
    }

    public void setFinalConnectIP(String str) {
        this.finalConnectIP = str;
    }

    public void setHttpErrorCode(int i2) {
        this.httpErrorCode = i2;
    }

    public HttpSessionInfo(String str, String str2, String str3, int i2, int i3) {
        this.connectHost = str;
        this.connectResolvedHost = str2;
        this.finalConnectIP = str3;
        this.httpErrorCode = i2;
        this.errorNumber = i3;
    }
}
