package com.xtc.shareapi.share.bean;

/* JADX INFO: loaded from: classes2.dex */
public class AppInfo {
    private int allow;
    private String packageName;
    private String token;

    public AppInfo() {
    }

    public int getAllow() {
        return this.allow;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getToken() {
        return this.token;
    }

    public void setAllow(int i2) {
        this.allow = i2;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        return "AppInfo{packageName='" + this.packageName + "', allow=" + this.allow + ", token='" + this.token + "'}";
    }

    public AppInfo(String str, int i2, String str2) {
        this.packageName = str;
        this.allow = i2;
        this.token = str2;
    }
}
