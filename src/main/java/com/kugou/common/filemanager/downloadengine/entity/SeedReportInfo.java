package com.kugou.common.filemanager.downloadengine.entity;

/* JADX INFO: loaded from: classes2.dex */
public class SeedReportInfo {
    private int errorCode;
    private long fileSize;
    private String hash;

    @SeedResourceType
    private int resource;
    private int state;
    private long taskKey;
    private int usedMilli;

    public int getErrorCode() {
        return this.errorCode;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getHash() {
        return this.hash;
    }

    public int getResourceType() {
        return this.resource;
    }

    public int getState() {
        return this.state;
    }

    public long getTaskKey() {
        return this.taskKey;
    }

    public int getUsedMilli() {
        return this.usedMilli;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setResourceType(@SeedResourceType int i2) {
        this.resource = i2;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setTaskKey(long j) {
        this.taskKey = j;
    }

    public void setUsedMilli(int i2) {
        this.usedMilli = i2;
    }
}
