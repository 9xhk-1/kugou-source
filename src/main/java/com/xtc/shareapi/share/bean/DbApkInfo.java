package com.xtc.shareapi.share.bean;

/* JADX INFO: loaded from: classes2.dex */
public class DbApkInfo {
    private String certificate;
    private String certificateList;
    private Long createTime;
    private int id;
    private String packageName;
    private int versionCode;

    public String getCertificate() {
        return this.certificate;
    }

    public String getCertificateList() {
        return this.certificateList;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public int getId() {
        return this.id;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public void setCertificate(String str) {
        this.certificate = str;
    }

    public void setCertificateList(String str) {
        this.certificateList = str;
    }

    public void setCreateTime(Long l) {
        this.createTime = l;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setVersionCode(int i2) {
        this.versionCode = i2;
    }

    public String toString() {
        return "DbApkInfo{id=" + this.id + ", versionCode=" + this.versionCode + ", packageName='" + this.packageName + "', certificate='" + this.certificate + "', createTime=" + this.createTime + ", certificateList=" + this.certificateList + '}';
    }
}
