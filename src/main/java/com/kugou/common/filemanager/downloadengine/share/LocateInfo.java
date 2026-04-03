package com.kugou.common.filemanager.downloadengine.share;

/* JADX INFO: loaded from: classes2.dex */
public class LocateInfo {
    private String fileName;
    private long fileSize;
    private int hashType;
    private String path;

    public LocateInfo(int i2, String str, long j, String str2) {
        this.hashType = i2;
        this.path = str;
        this.fileSize = j;
        this.fileName = str2;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public int getHashType() {
        return this.hashType;
    }

    public String getPath() {
        return this.path;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setHashType(int i2) {
        this.hashType = i2;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
