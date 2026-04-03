package com.kugou.common.filemanager.downloadengine.entity;

/* JADX INFO: loaded from: classes2.dex */
public class CustomProxy {
    public boolean cantUseProxy;
    public String customURL;
    public String headers;
    public String host;
    public String[] hostBackups;
    public String lastProxyHost;
    public String password;
    public int port;
    public boolean proxyCancelled;
    public String proxyName;
    public int type;
    public String username;

    public String getCustomURL() {
        return this.customURL;
    }

    public String getHeaders() {
        return this.headers;
    }

    public String getHost() {
        return this.host;
    }

    public String[] getHostBackups() {
        return this.hostBackups;
    }

    public String getLastProxyHost() {
        return this.lastProxyHost;
    }

    public String getPassword() {
        return this.password;
    }

    public int getPort() {
        return this.port;
    }

    public boolean getProxyCancelled() {
        return this.proxyCancelled;
    }

    public String getProxyName() {
        return this.proxyName;
    }

    public int getType() {
        return this.type;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isCantUseProxy() {
        return this.cantUseProxy;
    }

    public void setCantUseProxy(boolean z) {
        this.cantUseProxy = z;
    }

    public void setCustomURL(String str) {
        this.customURL = str;
    }

    public void setHeaders(String str) {
        this.headers = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setHostBackups(String[] strArr) {
        this.hostBackups = strArr;
    }

    public void setLastProxyHost(String str) {
        this.lastProxyHost = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPort(int i2) {
        this.port = i2;
    }

    public void setProxyCancelled(boolean z) {
        this.proxyCancelled = z;
    }

    public void setProxyName(String str) {
        this.proxyName = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setUsername(String str) {
        this.username = str;
    }
}
