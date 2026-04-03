package com.kugou.common.filemanager.downloadengine.entity;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class SeedResponseInfo {
    private boolean encrypto;

    @SeedError
    private int error;
    private long fileSize;
    private String hash;
    private long peerID;

    @SeedResourceType
    private int resourceType;
    private long taskKey;
    private String[] urls;

    public boolean getEncrypto() {
        return this.encrypto;
    }

    public int getError() {
        return this.error;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getHash() {
        return this.hash;
    }

    public long getPeerID() {
        return this.peerID;
    }

    public int getResourceType() {
        return this.resourceType;
    }

    public long getTaskKey() {
        return this.taskKey;
    }

    public String[] getUrls() {
        return this.urls;
    }

    public void setEncrypto(boolean z) {
        this.encrypto = z;
    }

    public void setError(@SeedError int i2) {
        this.error = i2;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setPeerID(long j) {
        this.peerID = j;
    }

    public void setResourceType(@SeedResourceType int i2) {
        this.resourceType = i2;
    }

    public void setTaskKey(long j) {
        this.taskKey = j;
    }

    public void setUrls(String[] strArr) {
        this.urls = strArr;
    }

    public String shortInfo() {
        if (TextUtils.isEmpty(this.hash)) {
            return "";
        }
        return this.resourceType + ":" + this.hash + ":" + this.fileSize;
    }
}
