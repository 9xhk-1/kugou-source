package com.kugou.common.filemanager.downloadengine.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IntRange;
import com.kugou.common.filemanager.downloadengine.DownloadMode;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadStatistics implements Parcelable {
    public static final Parcelable.Creator<DownloadStatistics> CREATOR = new Parcelable.Creator<DownloadStatistics>() { // from class: com.kugou.common.filemanager.downloadengine.entity.DownloadStatistics.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadStatistics createFromParcel(Parcel parcel) {
            return new DownloadStatistics(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadStatistics[] newArray(int i2) {
            return new DownloadStatistics[i2];
        }
    };
    private String authErrorInfo;
    private long avgSpeed;
    private int downloadMode;
    private long ensureCacheSize;
    private int errorNo;
    private String extName;
    private long fileSize;
    private long formatID3Duration;
    private String formatID3Message;
    private int formatID3Result;
    private long fullID3Duration;
    private boolean hasDownloaded;
    private boolean hasPlayed;
    private String holderTag;
    private HTTPStatistics http;
    private boolean isH265;
    private boolean isUnhealthSpeed;
    private long lastSequenceSize;
    private long leftDownloadSize;
    private String networkChange;
    private P2PStatistics p2p;
    private boolean p2pOnly;
    private int p2pPlatform;
    private boolean passiveCDN;
    private boolean passiveMode;
    private String retryDomainStates;

    @SeedResourceType
    private int seedResourceType;
    private long totalRecvBytes;
    private long transformDuration;
    private String transformMessage;
    private long usedTime;

    public Object createHTTP() {
        if (this.http == null) {
            this.http = new HTTPStatistics();
        }
        return this.http;
    }

    public Object createP2P() {
        if (this.p2p == null) {
            this.p2p = new P2PStatistics();
        }
        return this.p2p;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAuthErrorInfo() {
        return this.authErrorInfo;
    }

    public long getAvgSpeed() {
        return this.avgSpeed;
    }

    public int getDownloadMode() {
        return this.downloadMode;
    }

    public DownloadMode getDownloadModeEnum() {
        return DownloadMode.values()[this.downloadMode];
    }

    public long getEnsureCacheSize() {
        return this.ensureCacheSize;
    }

    public int getErrorNo() {
        return this.errorNo;
    }

    public String getExtName() {
        return this.extName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public long getFormatID3Duration() {
        return this.formatID3Duration;
    }

    public String getFormatID3Message() {
        return this.formatID3Message;
    }

    public int getFormatID3Result() {
        return this.formatID3Result;
    }

    public long getFullID3Duration() {
        return this.fullID3Duration;
    }

    public HTTPStatistics getHTTP() {
        return this.http;
    }

    public String getHolderTag() {
        return this.holderTag;
    }

    public long getLastSequenceSize() {
        return this.lastSequenceSize;
    }

    public long getLeftDownloadSize() {
        return this.leftDownloadSize;
    }

    public String getNetworkChange() {
        return this.networkChange;
    }

    public P2PStatistics getP2P() {
        return this.p2p;
    }

    public int getP2pPlatform() {
        return this.p2pPlatform;
    }

    public String getRetryDomainStates() {
        return this.retryDomainStates;
    }

    @SeedResourceType
    public int getSeedResourceType() {
        return this.seedResourceType;
    }

    public long getTotalRecvBytes() {
        return this.totalRecvBytes;
    }

    public long getTransformDuration() {
        return this.transformDuration;
    }

    public String getTransformMessage() {
        return this.transformMessage;
    }

    public long getUsedTime() {
        return this.usedTime;
    }

    public boolean isFormatID3Success() {
        return getFormatID3Result() == 3;
    }

    public boolean isH265() {
        return this.isH265;
    }

    public boolean isHasDownloaded() {
        return this.hasDownloaded;
    }

    public boolean isHasPlayed() {
        return this.hasPlayed;
    }

    public boolean isP2pOnly() {
        return this.p2pOnly;
    }

    public boolean isPassiveCDN() {
        return this.passiveCDN;
    }

    public boolean isPassiveMode() {
        return this.passiveMode;
    }

    public boolean isUnhealthSpeed() {
        return this.isUnhealthSpeed;
    }

    public void setAuthErrorInfo(String str) {
        this.authErrorInfo = str;
    }

    public void setAvgSpeed(long j) {
        this.avgSpeed = j;
    }

    public void setDownloadMode(int i2) {
        DownloadMode[] downloadModeArrValues = DownloadMode.values();
        if (i2 < 0 || i2 >= downloadModeArrValues.length) {
            i2 = 0;
        }
        this.downloadMode = i2;
    }

    public void setEnsureCacheSize(@IntRange(from = 0) long j) {
        this.ensureCacheSize = j;
    }

    public void setErrorNo(int i2) {
        this.errorNo = i2;
    }

    public void setExtName(String str) {
        this.extName = str;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setFormatID3Duration(long j) {
        this.formatID3Duration = j;
    }

    public void setFormatID3Message(String str) {
        this.formatID3Message = str;
    }

    public void setFormatID3Result(int i2) {
        this.formatID3Result = i2;
    }

    public void setFullID3Duration(long j) {
        this.fullID3Duration = j;
    }

    public void setH265(boolean z) {
        this.isH265 = z;
    }

    public void setHasDownloaded(boolean z) {
        this.hasDownloaded = z;
    }

    public void setHasPlayed(boolean z) {
        this.hasPlayed = z;
    }

    public void setHolderTag(String str) {
        this.holderTag = str;
    }

    public void setLastSequenceSize(long j) {
        this.lastSequenceSize = j;
    }

    public void setLeftDownloadSize(long j) {
        this.leftDownloadSize = j;
    }

    public void setNetworkChange(String str) {
        this.networkChange = str;
    }

    public void setP2pOnly(boolean z) {
        this.p2pOnly = z;
    }

    public void setP2pPlatform(int i2) {
        this.p2pPlatform = i2;
    }

    public void setPassiveCDN(boolean z) {
        this.passiveCDN = z;
    }

    public void setPassiveMode(boolean z) {
        this.passiveMode = z;
    }

    public void setRetryDomainStates(String str) {
        this.retryDomainStates = str;
    }

    public void setSeedResourceType(@SeedResourceType int i2) {
        this.seedResourceType = i2;
    }

    public void setTotalRecvBytes(@IntRange(from = 0) long j) {
        this.totalRecvBytes = j;
    }

    public void setTransformDuration(@IntRange(from = 0) long j) {
        this.transformDuration = j;
    }

    public void setTransformMessage(String str) {
        this.transformMessage = str;
    }

    public void setUnhealthSpeed(boolean z) {
        this.isUnhealthSpeed = z;
    }

    public void setUsedTime(long j) {
        this.usedTime = j;
    }

    public String toString() {
        return "DownloadStatistics{p2pPlatform=" + this.p2pPlatform + ", fileSize=" + this.fileSize + ", lastSequenceSize=" + this.lastSequenceSize + ", avgSpeed=" + this.avgSpeed + ", retryDomainStates='" + this.retryDomainStates + "', downloadMode=" + this.downloadMode + ", errorNo=" + this.errorNo + ", usedTime=" + this.usedTime + ", seedResourceType=" + this.seedResourceType + ", formatID3Result=" + this.formatID3Result + ", formatID3Message='" + this.formatID3Message + "', fullID3Duration=" + this.fullID3Duration + ", formatID3Duration=" + this.formatID3Duration + ", transformDuration=" + this.transformDuration + ", transformMessage='" + this.transformMessage + "', leftDownloadSize=" + this.leftDownloadSize + ", totalRecvBytes=" + this.totalRecvBytes + ", hasPlayed=" + this.hasPlayed + ", hasDownloaded=" + this.hasDownloaded + ", isUnhealthSpeed=" + this.isUnhealthSpeed + ", isH265=" + this.isH265 + ", p2p=" + this.p2p + ", http=" + this.http + ", networkChange='" + this.networkChange + "', holderTag='" + this.holderTag + "', p2pOnly=" + this.p2pOnly + ", ensureCacheSize=" + this.ensureCacheSize + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.p2pPlatform);
        parcel.writeLong(this.fileSize);
        parcel.writeLong(this.lastSequenceSize);
        parcel.writeLong(this.avgSpeed);
        parcel.writeString(this.retryDomainStates);
        parcel.writeInt(this.downloadMode);
        parcel.writeInt(this.errorNo);
        parcel.writeLong(this.usedTime);
        parcel.writeInt(this.formatID3Result);
        parcel.writeString(this.formatID3Message);
        parcel.writeLong(this.fullID3Duration);
        parcel.writeLong(this.formatID3Duration);
        parcel.writeInt(this.isUnhealthSpeed ? 1 : 0);
        parcel.writeParcelable(this.p2p, i2);
        parcel.writeParcelable(this.http, i2);
        parcel.writeString(this.networkChange);
        parcel.writeLong(this.leftDownloadSize);
        parcel.writeInt(this.hasPlayed ? 1 : 0);
        parcel.writeInt(this.hasDownloaded ? 1 : 0);
        parcel.writeString(this.authErrorInfo);
    }

    public DownloadStatistics() {
        this.p2pOnly = false;
        this.ensureCacheSize = 0L;
        this.passiveMode = false;
        this.passiveCDN = false;
    }

    private DownloadStatistics(Parcel parcel) {
        this.p2pOnly = false;
        this.ensureCacheSize = 0L;
        this.passiveMode = false;
        this.passiveCDN = false;
        this.p2pPlatform = parcel.readInt();
        this.fileSize = parcel.readLong();
        this.lastSequenceSize = parcel.readLong();
        this.avgSpeed = parcel.readLong();
        this.retryDomainStates = parcel.readString();
        this.downloadMode = parcel.readInt();
        this.errorNo = parcel.readInt();
        this.usedTime = parcel.readLong();
        this.formatID3Result = parcel.readInt();
        this.formatID3Message = parcel.readString();
        this.fullID3Duration = parcel.readLong();
        this.formatID3Duration = parcel.readLong();
        this.isUnhealthSpeed = parcel.readInt() == 1;
        this.p2p = (P2PStatistics) parcel.readParcelable(P2PStatistics.class.getClassLoader());
        this.http = (HTTPStatistics) parcel.readParcelable(HTTPStatistics.class.getClassLoader());
        this.networkChange = parcel.readString();
        this.leftDownloadSize = parcel.readLong();
        this.hasPlayed = parcel.readInt() == 1;
        this.hasDownloaded = parcel.readInt() == 1;
        this.authErrorInfo = parcel.readString();
    }
}
