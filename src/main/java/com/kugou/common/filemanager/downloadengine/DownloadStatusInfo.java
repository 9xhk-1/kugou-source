package com.kugou.common.filemanager.downloadengine;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadStatusInfo {
    private long cdnSpeedAvg;
    private long cdnSpeedNow;
    private long cdnSpeedRecent;
    private int downloadMode;
    private long downloadSize;
    private long fileSize;
    private boolean isUnhealthSpeed;
    private boolean isUsedUnHealthSpeed;
    private String key;
    private long lastSequenceSize;
    private long speedAvg;
    private long speedNow;
    private long speedRecent;
    private int state;
    private long usedTime;
    private long validSize;
    private int virtualProgressSeparated;
    private int virtualProgressSequence;

    public long getCdnSpeedAvg() {
        return this.cdnSpeedAvg;
    }

    public long getCdnSpeedNow() {
        return this.cdnSpeedNow;
    }

    public long getCdnSpeedRecent() {
        return this.cdnSpeedRecent;
    }

    public int getDownloadMode() {
        return this.downloadMode;
    }

    public DownloadMode getDownloadModeEnum() {
        return DownloadMode.values()[this.downloadMode];
    }

    public long getDownloadSize() {
        return this.downloadSize;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getKey() {
        return this.key;
    }

    public long getLastSequenceSize() {
        return this.lastSequenceSize;
    }

    public long getSpeedAvg() {
        return this.speedAvg;
    }

    public long getSpeedNow() {
        return this.speedNow;
    }

    public long getSpeedRecent() {
        return this.speedRecent;
    }

    public int getState() {
        return this.state;
    }

    public long getUsedTime() {
        return this.usedTime;
    }

    public long getValidSize() {
        return this.validSize;
    }

    public int getVirtualProgressSeparated() {
        return this.virtualProgressSeparated;
    }

    public int getVirtualProgressSequence() {
        return this.virtualProgressSequence;
    }

    public boolean isUnhealthSpeed() {
        return this.isUnhealthSpeed;
    }

    public boolean isUsedUnHealthSpeed() {
        return this.isUsedUnHealthSpeed;
    }

    public void setCdnSpeedAvg(long j) {
        this.cdnSpeedAvg = j;
    }

    public void setCdnSpeedNow(long j) {
        this.cdnSpeedNow = j;
    }

    public void setCdnSpeedRecent(long j) {
        this.cdnSpeedRecent = j;
    }

    public void setDownloadMode(int i2) {
        DownloadMode[] downloadModeArrValues = DownloadMode.values();
        int i3 = this.downloadMode;
        if (i3 < 0 || i3 >= downloadModeArrValues.length) {
            this.downloadMode = 0;
        }
        this.downloadMode = i2;
    }

    public void setDownloadSize(long j) {
        this.downloadSize = j;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setIsUnhealthSpeed(boolean z) {
        this.isUnhealthSpeed = z;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLastSequenceSize(long j) {
        this.lastSequenceSize = j;
    }

    public void setSpeedAvg(long j) {
        this.speedAvg = j;
    }

    public void setSpeedNow(long j) {
        this.speedNow = j;
    }

    public void setSpeedRecent(long j) {
        this.speedRecent = j;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setUsedTime(long j) {
        this.usedTime = j;
    }

    public void setUsedUnHealthSpeed(boolean z) {
        this.isUsedUnHealthSpeed = z;
    }

    public void setValidSize(long j) {
        this.validSize = j;
    }

    public void setVirtualProgressSeparated(int i2) {
        this.virtualProgressSeparated = i2;
    }

    public void setVirtualProgressSequence(int i2) {
        this.virtualProgressSequence = i2;
    }
}
