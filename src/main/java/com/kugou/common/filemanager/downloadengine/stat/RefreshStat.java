package com.kugou.common.filemanager.downloadengine.stat;

/* JADX INFO: loaded from: classes2.dex */
public class RefreshStat {
    private int fileCount;
    private int hashAppSuccCount;
    private int hashAudioSuccCount;
    private int hashCount;
    private int hashImageSuccCount;
    private int hashMVSuccCount;
    private int hashOtherSuccCount;
    private int hashSuccCount;
    private boolean ipv6 = false;
    private int natType = 0;
    private int requestCount;
    private int requestDuration;
    private int requestSuccess;

    public int getFileCount() {
        return this.fileCount;
    }

    public int getHashAppSuccCount() {
        return this.hashAppSuccCount;
    }

    public int getHashAudioSuccCount() {
        return this.hashAudioSuccCount;
    }

    public int getHashCount() {
        return this.hashCount;
    }

    public int getHashImageSuccCount() {
        return this.hashImageSuccCount;
    }

    public int getHashMVSuccCount() {
        return this.hashMVSuccCount;
    }

    public int getHashOtherSuccCount() {
        return this.hashOtherSuccCount;
    }

    public int getHashSuccCount() {
        return this.hashSuccCount;
    }

    public int getNatType() {
        return this.natType;
    }

    public int getRequestCount() {
        return this.requestCount;
    }

    public int getRequestDuration() {
        return this.requestDuration;
    }

    public int getRequestSuccess() {
        return this.requestSuccess;
    }

    public boolean isIPv6() {
        return this.ipv6;
    }

    public void setFileCount(int i2) {
        this.fileCount = i2;
    }

    public void setHashAppSuccCount(int i2) {
        this.hashAppSuccCount = i2;
    }

    public void setHashAudioSuccCount(int i2) {
        this.hashAudioSuccCount = i2;
    }

    public void setHashCount(int i2) {
        this.hashCount = i2;
    }

    public void setHashImageSuccCount(int i2) {
        this.hashImageSuccCount = i2;
    }

    public void setHashMVSuccCount(int i2) {
        this.hashMVSuccCount = i2;
    }

    public void setHashOtherSuccCount(int i2) {
        this.hashOtherSuccCount = i2;
    }

    public void setHashSuccCount(int i2) {
        this.hashSuccCount = i2;
    }

    public void setIPv6(boolean z) {
        this.ipv6 = z;
    }

    public void setNatType(int i2) {
        this.natType = i2;
    }

    public void setRequestCount(int i2) {
        this.requestCount = i2;
    }

    public void setRequestDuration(int i2) {
        this.requestDuration = i2;
    }

    public void setRequestSuccess(int i2) {
        this.requestSuccess = i2;
    }
}
