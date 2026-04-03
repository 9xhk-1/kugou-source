package com.kugou.common.filemanager.downloadengine.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IntRange;

/* JADX INFO: loaded from: classes2.dex */
public class P2PStatistics implements Parcelable {
    public static final Parcelable.Creator<P2PStatistics> CREATOR = new Parcelable.Creator<P2PStatistics>() { // from class: com.kugou.common.filemanager.downloadengine.entity.P2PStatistics.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public P2PStatistics createFromParcel(Parcel parcel) {
            P2PStatistics p2PStatistics = new P2PStatistics();
            p2PStatistics.setP2pPlatform(parcel.readInt());
            p2PStatistics.setUsedHashSources(parcel.readInt());
            p2PStatistics.setAvgP2P(parcel.readInt());
            p2PStatistics.setAvgP2S(parcel.readInt());
            p2PStatistics.setAvgP2SP(parcel.readInt());
            p2PStatistics.setAvgSrc(parcel.readInt());
            p2PStatistics.setPerValidSrc(parcel.readInt());
            p2PStatistics.setPerP2PDown(parcel.readInt());
            p2PStatistics.setPerDuplicate(parcel.readInt());
            p2PStatistics.setSeaFileCount(parcel.readInt());
            p2PStatistics.setSeaFileTimeoutCount(parcel.readInt());
            p2PStatistics.setType(parcel.readInt());
            p2PStatistics.setSeaFileSuccseCount(parcel.readInt());
            p2PStatistics.setSeaFileSuccseTime(parcel.readInt());
            p2PStatistics.setCheckSumSuccseCount(parcel.readInt());
            p2PStatistics.setCheckSumSuccseTime(parcel.readInt());
            p2PStatistics.setPureP2P(parcel.readInt());
            p2PStatistics.setCallmeSuccessCount(parcel.readInt());
            p2PStatistics.setCallmeSuccessTime(parcel.readInt());
            p2PStatistics.setInSourceCount(parcel.readInt());
            p2PStatistics.setExSourceCount(parcel.readInt());
            p2PStatistics.setPerValidInSrc(parcel.readInt());
            p2PStatistics.setPCValidBlocks(parcel.readInt());
            p2PStatistics.setMobileValidBlocks(parcel.readInt());
            p2PStatistics.setCDNValidBlocks(parcel.readInt());
            p2PStatistics.setXcdnValidBlocks(parcel.readInt());
            p2PStatistics.setTotalValidBlocks(parcel.readInt());
            p2PStatistics.setPCValidBlocks6(parcel.readInt());
            p2PStatistics.setMobileValidBlocks6(parcel.readInt());
            p2PStatistics.setCDNValidBlocks6(parcel.readInt());
            p2PStatistics.setXcdnValidBlocks6(parcel.readInt());
            p2PStatistics.setTotalValidBlocks6(parcel.readInt());
            p2PStatistics.setPCConnectSource(parcel.readInt());
            p2PStatistics.setPCValidSource(parcel.readInt());
            p2PStatistics.setPCIntranetConnectSource(parcel.readInt());
            p2PStatistics.setPCIntranetValidSource(parcel.readInt());
            p2PStatistics.setPCIntranetValidBlocks(parcel.readInt());
            p2PStatistics.setMobileConnectSource(parcel.readInt());
            p2PStatistics.setMobileValidSource(parcel.readInt());
            p2PStatistics.setMobileIntranetConnectSource(parcel.readInt());
            p2PStatistics.setMobileIntranetValidSource(parcel.readInt());
            p2PStatistics.setMobileIntranetValidBlocks(parcel.readInt());
            p2PStatistics.setIntranetConnect(parcel.readInt());
            p2PStatistics.setIntranetMiss(parcel.readInt());
            p2PStatistics.setIntranetFound(parcel.readInt());
            p2PStatistics.setIntranetBind(parcel.readInt());
            p2PStatistics.setHasPlayed(parcel.readInt() == 1);
            p2PStatistics.setHasDownloaded(parcel.readInt() == 1);
            p2PStatistics.setHasCached(parcel.readInt() == 1);
            p2PStatistics.setFreeUsingCDN(parcel.readInt() == 1);
            return p2PStatistics;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public P2PStatistics[] newArray(int i2) {
            return new P2PStatistics[i2];
        }
    };
    private int avgP2P;
    private int avgP2S;
    private int avgP2SP;
    private int avgSrc;
    private int callmeSuccessCount;
    private int callmeSuccessTime;
    private int cdnValidBlocks;
    private int cdnValidBlocks6;
    private int checkSumSuccseCount;
    private int checkSumSuccseTime;
    private int exSourceCount;
    private int inSourceCount;
    private int intranetBind;
    private int intranetConnect;
    private int intranetFound;
    private int intranetMiss;
    private int mobileConnectSource;
    private int mobileIntranetConnectSource;
    private int mobileIntranetValidBlocks;
    private int mobileIntranetValidSource;
    private int mobileValidBlocks;
    private int mobileValidBlocks6;
    private int mobileValidSource;
    private int p2pPlatform;
    private int pcConnectSource;
    private int pcIntranetConnectSource;
    private int pcIntranetValidBlocks;
    private int pcIntranetValidSource;
    private int pcValidBlocks;
    private int pcValidBlocks6;
    private int pcValidSource;
    private int perDuplicate;
    private int perP2PDown;
    private int perValidInSrc;
    private int perValidSrc;
    private int pureP2P;
    private int seaFileCount;
    private int seaFileSuccseCount;
    private int seaFileSuccseTime;
    private int seaFileTimeoutCount;
    private int totalValidBlocks;
    private int totalValidBlocks6;
    private int type;
    private int usedHashSources;
    private int xcdnValidBlocks;
    private int xcdnValidBlocks6;
    public boolean hasPlayed = false;
    public boolean hasDownloaded = false;
    public boolean hasCached = false;
    public boolean freeUsingCDN = false;

    public static P2PStatistics createForHttpStat(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) long j, HTTPStatistics hTTPStatistics) {
        P2PStatistics p2PStatistics = new P2PStatistics();
        p2PStatistics.p2pPlatform = i2;
        p2PStatistics.avgP2P = 0;
        p2PStatistics.avgP2S = i3;
        p2PStatistics.avgP2SP = i3;
        p2PStatistics.avgSrc = 0;
        p2PStatistics.perValidSrc = 0;
        p2PStatistics.perP2PDown = 0;
        p2PStatistics.perDuplicate = 0;
        p2PStatistics.seaFileCount = 0;
        p2PStatistics.seaFileTimeoutCount = 0;
        p2PStatistics.type = 0;
        p2PStatistics.seaFileSuccseCount = 0;
        p2PStatistics.seaFileSuccseTime = 0;
        p2PStatistics.checkSumSuccseCount = 0;
        p2PStatistics.checkSumSuccseTime = 0;
        p2PStatistics.pureP2P = 2;
        p2PStatistics.callmeSuccessCount = 0;
        p2PStatistics.callmeSuccessTime = 0;
        p2PStatistics.inSourceCount = 0;
        p2PStatistics.exSourceCount = 0;
        p2PStatistics.perValidInSrc = 0;
        if (hTTPStatistics != null) {
            p2PStatistics.cdnValidBlocks = toBlocks(hTTPStatistics.getTotalRecvBytes());
            p2PStatistics.cdnValidBlocks6 = toBlocks(hTTPStatistics.getTotalRecvBytes6());
            p2PStatistics.xcdnValidBlocks = toBlocks(hTTPStatistics.getTotalXcdnBytes());
            p2PStatistics.xcdnValidBlocks6 = toBlocks(hTTPStatistics.getTotalXcdnBytes6());
        } else {
            p2PStatistics.cdnValidBlocks = toBlocks(j);
        }
        p2PStatistics.totalValidBlocks = p2PStatistics.cdnValidBlocks;
        p2PStatistics.totalValidBlocks6 = p2PStatistics.cdnValidBlocks6;
        p2PStatistics.hasPlayed = false;
        p2PStatistics.hasDownloaded = false;
        p2PStatistics.hasCached = false;
        return p2PStatistics;
    }

    private static int toBlocks(@IntRange(from = 0) long j) {
        return (int) ((j + 1023) / 1024);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAvgP2P() {
        return this.avgP2P;
    }

    public int getAvgP2S() {
        return this.avgP2S;
    }

    public int getAvgP2SP() {
        return this.avgP2SP;
    }

    public int getAvgSrc() {
        return this.avgSrc;
    }

    public int getCDNValidBlocks() {
        return this.cdnValidBlocks;
    }

    public int getCDNValidBlocks6() {
        return this.cdnValidBlocks6;
    }

    public int getCallmeSuccessCount() {
        return this.callmeSuccessCount;
    }

    public int getCallmeSuccessTime() {
        return this.callmeSuccessTime;
    }

    public int getCheckSumSuccseCount() {
        return this.checkSumSuccseCount;
    }

    public int getCheckSumSuccseTime() {
        return this.checkSumSuccseTime;
    }

    public int getExSourceCount() {
        return this.exSourceCount;
    }

    public boolean getFreeUsingCDN() {
        return this.freeUsingCDN;
    }

    public boolean getHasCached() {
        return this.hasCached;
    }

    public boolean getHasDownloaded() {
        return this.hasDownloaded;
    }

    public boolean getHasPlayed() {
        return this.hasPlayed;
    }

    public int getInSourceCount() {
        return this.inSourceCount;
    }

    public int getIntranetBind() {
        return this.intranetBind;
    }

    public int getIntranetConnect() {
        return this.intranetConnect;
    }

    public int getIntranetFound() {
        return this.intranetFound;
    }

    public int getIntranetMiss() {
        return this.intranetMiss;
    }

    public int getMobileConnectSource() {
        return this.mobileConnectSource;
    }

    public int getMobileIntranetConnectSource() {
        return this.mobileIntranetConnectSource;
    }

    public int getMobileIntranetValidBlocks() {
        return this.mobileIntranetValidBlocks;
    }

    public int getMobileIntranetValidSource() {
        return this.mobileIntranetValidSource;
    }

    public int getMobileValidBlocks() {
        return this.mobileValidBlocks;
    }

    public int getMobileValidBlocks6() {
        return this.mobileValidBlocks6;
    }

    public int getMobileValidSource() {
        return this.mobileValidSource;
    }

    public int getP2pPlatform() {
        return this.p2pPlatform;
    }

    public int getPCConnectSource() {
        return this.pcConnectSource;
    }

    public int getPCIntranetConnectSource() {
        return this.pcIntranetConnectSource;
    }

    public int getPCIntranetValidBlocks() {
        return this.pcIntranetValidBlocks;
    }

    public int getPCIntranetValidSource() {
        return this.pcIntranetValidSource;
    }

    public int getPCValidBlocks() {
        return this.pcValidBlocks;
    }

    public int getPCValidBlocks6() {
        return this.pcValidBlocks6;
    }

    public int getPCValidSource() {
        return this.pcValidSource;
    }

    public int getPerDuplicate() {
        return this.perDuplicate;
    }

    public int getPerP2PDown() {
        return this.perP2PDown;
    }

    public int getPerValidInSrc() {
        return this.perValidInSrc;
    }

    public int getPerValidSrc() {
        return this.perValidSrc;
    }

    public int getPureP2P() {
        return this.pureP2P;
    }

    public int getSeaFileCount() {
        return this.seaFileCount;
    }

    public int getSeaFileSuccseCount() {
        return this.seaFileSuccseCount;
    }

    public int getSeaFileSuccseTime() {
        return this.seaFileSuccseTime;
    }

    public int getSeaFileTimeoutCount() {
        return this.seaFileTimeoutCount;
    }

    public int getTotalValidBlocks() {
        return this.totalValidBlocks;
    }

    public int getTotalValidBlocks6() {
        return this.totalValidBlocks6;
    }

    public int getType() {
        return this.type;
    }

    public int getUsedHashSources() {
        return this.usedHashSources;
    }

    public int getXcdnValidBlocks() {
        return this.xcdnValidBlocks;
    }

    public int getXcdnValidBlocks6() {
        return this.xcdnValidBlocks6;
    }

    public void setAvgP2P(int i2) {
        this.avgP2P = i2;
    }

    public void setAvgP2S(int i2) {
        this.avgP2S = i2;
    }

    public void setAvgP2SP(int i2) {
        this.avgP2SP = i2;
    }

    public void setAvgSrc(int i2) {
        this.avgSrc = i2;
    }

    public void setCDNValidBlocks(int i2) {
        this.cdnValidBlocks = i2;
    }

    public void setCDNValidBlocks6(@IntRange(from = 0) int i2) {
        this.cdnValidBlocks6 = i2;
    }

    public void setCallmeSuccessCount(int i2) {
        this.callmeSuccessCount = i2;
    }

    public void setCallmeSuccessTime(int i2) {
        this.callmeSuccessTime = i2;
    }

    public void setCheckSumSuccseCount(int i2) {
        this.checkSumSuccseCount = i2;
    }

    public void setCheckSumSuccseTime(int i2) {
        this.checkSumSuccseTime = i2;
    }

    public void setExSourceCount(int i2) {
        this.exSourceCount = i2;
    }

    public void setFreeUsingCDN(boolean z) {
        this.freeUsingCDN = z;
    }

    public void setHasCached(boolean z) {
        this.hasCached = z;
    }

    public void setHasDownloaded(boolean z) {
        this.hasDownloaded = z;
    }

    public void setHasPlayed(boolean z) {
        this.hasPlayed = z;
    }

    public void setInSourceCount(int i2) {
        this.inSourceCount = i2;
    }

    public void setIntranetBind(@IntRange(from = 0) int i2) {
        this.intranetBind = i2;
    }

    public void setIntranetConnect(@IntRange(from = 0) int i2) {
        this.intranetConnect = i2;
    }

    public void setIntranetFound(@IntRange(from = 0) int i2) {
        this.intranetFound = i2;
    }

    public void setIntranetMiss(@IntRange(from = 0) int i2) {
        this.intranetMiss = i2;
    }

    public void setMobileConnectSource(int i2) {
        this.mobileConnectSource = i2;
    }

    public void setMobileIntranetConnectSource(@IntRange(from = 0) int i2) {
        this.mobileIntranetConnectSource = i2;
    }

    public void setMobileIntranetValidBlocks(@IntRange(from = 0) int i2) {
        this.mobileIntranetValidBlocks = i2;
    }

    public void setMobileIntranetValidSource(@IntRange(from = 0) int i2) {
        this.mobileIntranetValidSource = i2;
    }

    public void setMobileValidBlocks(int i2) {
        this.mobileValidBlocks = i2;
    }

    public void setMobileValidBlocks6(@IntRange(from = 0) int i2) {
        this.mobileValidBlocks6 = i2;
    }

    public void setMobileValidSource(int i2) {
        this.mobileValidSource = i2;
    }

    public void setP2pPlatform(int i2) {
        this.p2pPlatform = i2;
    }

    public void setPCConnectSource(int i2) {
        this.pcConnectSource = i2;
    }

    public void setPCIntranetConnectSource(@IntRange(from = 0) int i2) {
        this.pcIntranetConnectSource = i2;
    }

    public void setPCIntranetValidBlocks(@IntRange(from = 0) int i2) {
        this.pcIntranetValidBlocks = i2;
    }

    public void setPCIntranetValidSource(@IntRange(from = 0) int i2) {
        this.pcIntranetValidSource = i2;
    }

    public void setPCValidBlocks(int i2) {
        this.pcValidBlocks = i2;
    }

    public void setPCValidBlocks6(@IntRange(from = 0) int i2) {
        this.pcValidBlocks6 = i2;
    }

    public void setPCValidSource(int i2) {
        this.pcValidSource = i2;
    }

    public void setPerDuplicate(int i2) {
        this.perDuplicate = i2;
    }

    public void setPerP2PDown(int i2) {
        this.perP2PDown = i2;
    }

    public void setPerValidInSrc(int i2) {
        this.perValidInSrc = i2;
    }

    public void setPerValidSrc(int i2) {
        this.perValidSrc = i2;
    }

    public void setPureP2P(int i2) {
        this.pureP2P = i2;
    }

    public void setSeaFileCount(int i2) {
        this.seaFileCount = i2;
    }

    public void setSeaFileSuccseCount(int i2) {
        this.seaFileSuccseCount = i2;
    }

    public void setSeaFileSuccseTime(int i2) {
        this.seaFileSuccseTime = i2;
    }

    public void setSeaFileTimeoutCount(int i2) {
        this.seaFileTimeoutCount = i2;
    }

    public void setTotalValidBlocks(int i2) {
        this.totalValidBlocks = i2;
    }

    public void setTotalValidBlocks6(@IntRange(from = 0) int i2) {
        this.totalValidBlocks6 = i2;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setUsedHashSources(int i2) {
        this.usedHashSources = i2;
    }

    public void setXcdnValidBlocks(@IntRange(from = 0) int i2) {
        this.xcdnValidBlocks = i2;
    }

    public void setXcdnValidBlocks6(@IntRange(from = 0) int i2) {
        this.xcdnValidBlocks6 = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("p2pPlatform=" + getP2pPlatform());
        sb.append(" usedPlatform=" + getUsedHashSources());
        sb.append(" avgP2P=" + getAvgP2P());
        sb.append(" blocks:" + this.pcValidBlocks + "/" + this.mobileValidBlocks + "/" + this.cdnValidBlocks + "/" + this.xcdnValidBlocks + "/" + this.totalValidBlocks);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" avgP2S=");
        sb2.append(getAvgP2S());
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(" avgP2SP=");
        sb3.append(getAvgP2SP());
        sb.append(sb3.toString());
        sb.append(" avgSrc=" + getAvgSrc());
        sb.append(" perValidSrc=" + getPerValidSrc());
        sb.append(" perP2PDown=" + getPerP2PDown());
        sb.append(" perDuplicate=" + getPerDuplicate());
        sb.append(" seaFileCount=" + getSeaFileCount());
        sb.append(" seaFileTimeoutCount=" + getSeaFileTimeoutCount());
        sb.append(" callmeSucCount=" + getCallmeSuccessCount());
        sb.append(" callmeSucTime=" + getCallmeSuccessTime());
        sb.append(" inSourceCount=" + getInSourceCount());
        sb.append(" exSourceCount=" + getExSourceCount());
        sb.append(" perValidInSrc=" + getPerValidInSrc());
        sb.append(" getHasPlayed=" + getHasPlayed());
        sb.append(" getHasDownloaded=" + getHasDownloaded());
        sb.append(" hasCached=" + getHasCached());
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.p2pPlatform);
        parcel.writeInt(this.usedHashSources);
        parcel.writeInt(this.avgP2P);
        parcel.writeInt(this.avgP2S);
        parcel.writeInt(this.avgP2SP);
        parcel.writeInt(this.avgSrc);
        parcel.writeInt(this.perValidSrc);
        parcel.writeInt(this.perP2PDown);
        parcel.writeInt(this.perDuplicate);
        parcel.writeInt(this.seaFileCount);
        parcel.writeInt(this.seaFileTimeoutCount);
        parcel.writeInt(this.type);
        parcel.writeInt(this.seaFileSuccseCount);
        parcel.writeInt(this.seaFileSuccseTime);
        parcel.writeInt(this.checkSumSuccseCount);
        parcel.writeInt(this.checkSumSuccseTime);
        parcel.writeInt(this.pureP2P);
        parcel.writeInt(this.callmeSuccessCount);
        parcel.writeInt(this.callmeSuccessTime);
        parcel.writeInt(this.inSourceCount);
        parcel.writeInt(this.exSourceCount);
        parcel.writeInt(this.perValidInSrc);
        parcel.writeInt(this.pcValidBlocks);
        parcel.writeInt(this.mobileValidBlocks);
        parcel.writeInt(this.cdnValidBlocks);
        parcel.writeInt(this.xcdnValidBlocks);
        parcel.writeInt(this.totalValidBlocks);
        parcel.writeInt(this.pcValidBlocks6);
        parcel.writeInt(this.mobileValidBlocks6);
        parcel.writeInt(this.cdnValidBlocks6);
        parcel.writeInt(this.xcdnValidBlocks6);
        parcel.writeInt(this.totalValidBlocks6);
        parcel.writeInt(this.pcConnectSource);
        parcel.writeInt(this.pcValidSource);
        parcel.writeInt(this.pcIntranetConnectSource);
        parcel.writeInt(this.pcIntranetValidSource);
        parcel.writeInt(this.pcIntranetValidBlocks);
        parcel.writeInt(this.mobileConnectSource);
        parcel.writeInt(this.mobileValidSource);
        parcel.writeInt(this.mobileIntranetConnectSource);
        parcel.writeInt(this.mobileIntranetValidSource);
        parcel.writeInt(this.mobileIntranetValidBlocks);
        parcel.writeInt(this.intranetConnect);
        parcel.writeInt(this.intranetMiss);
        parcel.writeInt(this.intranetFound);
        parcel.writeInt(this.intranetBind);
        parcel.writeInt(this.hasPlayed ? 1 : 0);
        parcel.writeInt(this.hasDownloaded ? 1 : 0);
        parcel.writeInt(this.hasCached ? 1 : 0);
        parcel.writeInt(this.freeUsingCDN ? 1 : 0);
    }
}
