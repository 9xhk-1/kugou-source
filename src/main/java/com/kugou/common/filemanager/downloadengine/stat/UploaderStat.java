package com.kugou.common.filemanager.downloadengine.stat;

import android.support.annotation.IntRange;

/* JADX INFO: loaded from: classes2.dex */
public class UploaderStat {
    private int natType = 0;
    private boolean ipv6 = false;
    private int workVer = 0;
    private long stopDuration = 0;
    private long startupDuration = 0;
    private int sessionCount = 0;
    private int acceptedSessionCount = 0;
    private int transmittedSessionCount = 0;
    private int deniedSessionCount = 0;
    private int fileNotExistSessionCount = 0;
    private int disabledSessionCount = 0;
    private long channel1Duration = 0;
    private long channel2Duration = 0;
    private long channel3Duration = 0;
    private long channelTotalDuration = 0;
    private long uploadTotalDuration = 0;
    private long transmitTotalDuration = 0;
    private int uploadBlockTotal = 0;
    private int requestBlockTotal = 0;
    private int halfSecondCount = 0;
    private int halfSecondBlockTotal = 0;
    private long resourceSessionDuration = 0;
    private int resourceSessionCount = 0;
    private int resourceSessionBlockTotal = 0;
    private long appSessionDuration = 0;
    private int appSessionCount = 0;
    private int appSessionBlockTotal = 0;
    private int randomNumAckCount = 0;
    private long randomNumAckRttDuration = 0;
    private int channelMaxSpeed = 0;
    private String topHash = "";
    private int topHashCount = 0;
    private int hashCount = 0;
    private String topFlowHashes = "";

    public int getAcceptedSessionCount() {
        return this.acceptedSessionCount;
    }

    public int getAppSessionBlockTotal() {
        return this.appSessionBlockTotal;
    }

    public int getAppSessionCount() {
        return this.appSessionCount;
    }

    public long getAppSessionDurationLong() {
        return this.appSessionDuration;
    }

    public long getChannel1DurationLong() {
        return this.channel1Duration;
    }

    public long getChannel2DurationLong() {
        return this.channel2Duration;
    }

    public long getChannel3DurationLong() {
        return this.channel3Duration;
    }

    public int getChannelMaxSpeed() {
        return this.channelMaxSpeed;
    }

    public long getChannelTotalDurationLong() {
        return this.channelTotalDuration;
    }

    public int getDeniedSessionCount() {
        return this.deniedSessionCount;
    }

    public int getDisabledSessionCount() {
        return this.disabledSessionCount;
    }

    public int getFileNotExistSessionCount() {
        return this.fileNotExistSessionCount;
    }

    public int getHalfSecondBlockTotal() {
        return this.halfSecondBlockTotal;
    }

    public int getHalfSecondCount() {
        return this.halfSecondCount;
    }

    public int getHashCount() {
        return this.hashCount;
    }

    public int getNatType() {
        return this.natType;
    }

    public int getRandomNumAckCount() {
        return this.randomNumAckCount;
    }

    public long getRandomNumAckRttDurationLong() {
        return this.randomNumAckRttDuration;
    }

    public int getRequestBlockTotal() {
        return this.requestBlockTotal;
    }

    public int getResourceSessionBlockTotal() {
        return this.resourceSessionBlockTotal;
    }

    public int getResourceSessionCount() {
        return this.resourceSessionCount;
    }

    public long getResourceSessionDurationLong() {
        return this.resourceSessionDuration;
    }

    public int getSessionCount() {
        return this.sessionCount;
    }

    public long getStartupDurationLong() {
        return this.startupDuration;
    }

    public long getStopDurationLong() {
        return this.stopDuration;
    }

    public String getTopFlowHashes() {
        return this.topFlowHashes;
    }

    public String getTopHash() {
        return this.topHash;
    }

    public int getTopHashCount() {
        return this.topHashCount;
    }

    public long getTransmitTotalDurationLong() {
        return this.transmitTotalDuration;
    }

    public int getTransmittedSessionCount() {
        return this.transmittedSessionCount;
    }

    public int getUploadBlockTotal() {
        return this.uploadBlockTotal;
    }

    public long getUploadTotalDurationLong() {
        return this.uploadTotalDuration;
    }

    public int getWorkVer() {
        return this.workVer;
    }

    public boolean isIPv6() {
        return this.ipv6;
    }

    public void merge(UploaderStat uploaderStat) {
        this.stopDuration += uploaderStat.stopDuration;
        this.startupDuration += uploaderStat.startupDuration;
        this.sessionCount += uploaderStat.sessionCount;
        this.acceptedSessionCount += uploaderStat.acceptedSessionCount;
        this.transmittedSessionCount += uploaderStat.transmittedSessionCount;
        this.deniedSessionCount += uploaderStat.deniedSessionCount;
        this.fileNotExistSessionCount += uploaderStat.fileNotExistSessionCount;
        this.disabledSessionCount += uploaderStat.disabledSessionCount;
        this.channel1Duration += uploaderStat.channel1Duration;
        this.channel2Duration += uploaderStat.channel2Duration;
        this.channel3Duration += uploaderStat.channel3Duration;
        this.channelTotalDuration += uploaderStat.channelTotalDuration;
        this.uploadTotalDuration += uploaderStat.uploadTotalDuration;
        this.transmitTotalDuration += uploaderStat.transmitTotalDuration;
        this.uploadBlockTotal += uploaderStat.uploadBlockTotal;
        this.requestBlockTotal += uploaderStat.requestBlockTotal;
        this.halfSecondCount += uploaderStat.halfSecondCount;
        this.halfSecondBlockTotal += uploaderStat.halfSecondBlockTotal;
        this.resourceSessionDuration += uploaderStat.resourceSessionDuration;
        this.resourceSessionCount += uploaderStat.resourceSessionCount;
        this.resourceSessionBlockTotal += uploaderStat.resourceSessionBlockTotal;
        this.appSessionDuration += uploaderStat.appSessionDuration;
        this.appSessionCount += uploaderStat.appSessionCount;
        this.appSessionBlockTotal += uploaderStat.appSessionBlockTotal;
        this.randomNumAckCount += uploaderStat.randomNumAckCount;
        this.randomNumAckRttDuration += uploaderStat.randomNumAckRttDuration;
        int i2 = uploaderStat.channelMaxSpeed;
        if (i2 > this.channelMaxSpeed) {
            this.channelMaxSpeed = i2;
        }
        this.topHash = uploaderStat.topHash;
        this.topHashCount = uploaderStat.topHashCount;
        this.hashCount = uploaderStat.hashCount;
    }

    public void setAcceptedSessionCount(int i2) {
        this.acceptedSessionCount = i2;
    }

    public void setAppSessionBlockTotal(int i2) {
        this.appSessionBlockTotal = i2;
    }

    public void setAppSessionCount(int i2) {
        this.appSessionCount = i2;
    }

    public void setAppSessionDuration(int i2) {
        setAppSessionDurationLong(i2);
    }

    public void setAppSessionDurationLong(@IntRange(from = 0) long j) {
        if (j < 0) {
            return;
        }
        this.appSessionDuration = j;
    }

    public void setChannel1Duration(int i2) {
        setChannel1DurationLong(i2);
    }

    public void setChannel1DurationLong(@IntRange(from = 0) long j) {
        if (j < 0) {
            return;
        }
        this.channel1Duration = j;
    }

    public void setChannel2Duration(int i2) {
        setChannel2DurationLong(i2);
    }

    public void setChannel2DurationLong(@IntRange(from = 0) long j) {
        if (j < 0) {
            return;
        }
        this.channel2Duration = j;
    }

    public void setChannel3Duration(int i2) {
        setChannel3DurationLong(i2);
    }

    public void setChannel3DurationLong(@IntRange(from = 0) long j) {
        if (j < 0) {
            return;
        }
        this.channel3Duration = j;
    }

    public void setChannelMaxSpeed(int i2) {
        this.channelMaxSpeed = i2;
    }

    public void setChannelTotalDuration(int i2) {
        setChannelTotalDurationLong(i2);
    }

    public void setChannelTotalDurationLong(@IntRange(from = 0) long j) {
        if (j < 0) {
            return;
        }
        this.channelTotalDuration = j;
    }

    public void setDeniedSessionCount(int i2) {
        this.deniedSessionCount = i2;
    }

    public void setDisabledSessionCount(int i2) {
        this.disabledSessionCount = i2;
    }

    public void setFileNotExistSessionCount(int i2) {
        this.fileNotExistSessionCount = i2;
    }

    public void setHalfSecondBlockTotal(int i2) {
        this.halfSecondBlockTotal = i2;
    }

    public void setHalfSecondCount(int i2) {
        this.halfSecondCount = i2;
    }

    public void setHashCount(int i2) {
        this.hashCount = i2;
    }

    public void setIPv6(boolean z) {
        this.ipv6 = z;
    }

    public void setNatType(int i2) {
        this.natType = i2;
    }

    public void setRandomNumAckCount(int i2) {
        this.randomNumAckCount = i2;
    }

    public void setRandomNumAckRttDuration(int i2) {
        setRandomNumAckRttDurationLong(i2);
    }

    public void setRandomNumAckRttDurationLong(@IntRange(from = 0) long j) {
        if (j < 0) {
            return;
        }
        this.randomNumAckRttDuration = j;
    }

    public void setRequestBlockTotal(int i2) {
        this.requestBlockTotal = i2;
    }

    public void setResourceSessionBlockTotal(int i2) {
        this.resourceSessionBlockTotal = i2;
    }

    public void setResourceSessionCount(int i2) {
        this.resourceSessionCount = i2;
    }

    public void setResourceSessionDuration(int i2) {
        setResourceSessionDurationLong(i2);
    }

    public void setResourceSessionDurationLong(@IntRange(from = 0) long j) {
        if (j < 0) {
            return;
        }
        this.resourceSessionDuration = j;
    }

    public void setSessionCount(int i2) {
        this.sessionCount = i2;
    }

    public void setStartupDuration(int i2) {
        setStopDurationLong(i2);
    }

    public void setStartupDurationLong(@IntRange(from = 0) long j) {
        if (j < 0) {
            return;
        }
        this.startupDuration = j;
    }

    public void setStopDuration(int i2) {
        setStopDurationLong(i2);
    }

    public void setStopDurationLong(@IntRange(from = 0) long j) {
        if (j < 0) {
            return;
        }
        this.stopDuration = j;
    }

    public void setTopFlowHashes(String str) {
        this.topFlowHashes = str;
    }

    public void setTopHash(String str) {
        this.topHash = str;
    }

    public void setTopHashCount(int i2) {
        this.topHashCount = i2;
    }

    public void setTransmitTotalDuration(int i2) {
        setTransmitTotalDurationLong(i2);
    }

    public void setTransmitTotalDurationLong(@IntRange(from = 0) long j) {
        if (j < 0) {
            return;
        }
        this.transmitTotalDuration = j;
    }

    public void setTransmittedSessionCount(int i2) {
        this.transmittedSessionCount = i2;
    }

    public void setUploadBlockTotal(int i2) {
        this.uploadBlockTotal = i2;
    }

    public void setUploadTotalDuration(int i2) {
        setUploadTotalDurationLong(i2);
    }

    public void setUploadTotalDurationLong(@IntRange(from = 0) long j) {
        if (j < 0) {
            return;
        }
        this.uploadTotalDuration = j;
    }

    public void setWorkVer(int i2) {
        this.workVer = i2;
    }
}
