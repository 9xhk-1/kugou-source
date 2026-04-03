package com.kugou.common.filemanager.downloadengine.entity;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class HashInfo {
    private int bitrate;
    private String dir;
    private int downUsedSeconds;
    private int durationSeconds;
    private String fileName;
    private long fileSize;
    private String hash;
    private int hashType;

    public HashInfo(int i2, String str, long j, int i3) {
        this.hashType = i2;
        setHash(str);
        this.fileSize = j;
        this.fileName = "";
        this.durationSeconds = 0;
        this.bitrate = 0;
        this.fileName = "";
        this.dir = "";
        this.downUsedSeconds = i3;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public String getDir() {
        return this.dir;
    }

    public int getDownUsedSeconds() {
        return this.downUsedSeconds;
    }

    public int getDurationSeconds() {
        return this.durationSeconds;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getHash() {
        return this.hash;
    }

    public int getHashType() {
        return this.hashType;
    }

    public void setBitrate(int i2) {
        this.bitrate = i2;
    }

    public void setDir(String str) {
        this.dir = str;
    }

    public void setDownUsedSeconds(int i2) {
        this.downUsedSeconds = i2;
    }

    public void setDurationSeconds(int i2) {
        this.durationSeconds = i2;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setHash(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hash = str;
        } else {
            this.hash = str.toLowerCase();
        }
    }

    public void setHashType(int i2) {
        this.hashType = i2;
    }

    public HashInfo(int i2, String str, long j, String str2, String str3) {
        this(i2, str, j, str2, str3, 0, 0);
    }

    public HashInfo(int i2, String str, long j, String str2, String str3, int i3, int i4) {
        this.hashType = i2;
        setHash(str);
        this.fileSize = j;
        this.fileName = str2;
        this.dir = str3;
        this.durationSeconds = i3;
        this.bitrate = i4;
        this.downUsedSeconds = 0;
    }
}
