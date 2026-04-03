package com.kugou.common.filemanager.downloadengine.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IntRange;

/* JADX INFO: loaded from: classes2.dex */
public class HTTPStatistics implements Parcelable {
    public static final Parcelable.Creator<HTTPStatistics> CREATOR = new Parcelable.Creator<HTTPStatistics>() { // from class: com.kugou.common.filemanager.downloadengine.entity.HTTPStatistics.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HTTPStatistics createFromParcel(Parcel parcel) {
            HTTPStatistics hTTPStatistics = new HTTPStatistics();
            hTTPStatistics.setResolvedHosts(parcel.readString());
            hTTPStatistics.setUrlConnected(parcel.readString());
            hTTPStatistics.setErrorCode(parcel.readInt());
            hTTPStatistics.urlInfos = (URLStatInfo[]) parcel.createTypedArray(URLStatInfo.CREATOR);
            hTTPStatistics.setTotalRecvBytes(parcel.readLong());
            hTTPStatistics.setTotalRecvBytes6(parcel.readLong());
            hTTPStatistics.setTotalXcdnBytes(parcel.readLong());
            hTTPStatistics.setTotalXcdnBytes6(parcel.readLong());
            hTTPStatistics.setHasPlayed(parcel.readInt() == 1);
            hTTPStatistics.setHasDownloaded(parcel.readInt() == 1);
            hTTPStatistics.setHasCached(parcel.readInt() == 1);
            return hTTPStatistics;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HTTPStatistics[] newArray(int i2) {
            return new HTTPStatistics[i2];
        }
    };
    private int errorCode;
    private String resolvedHosts;
    private long totalRecvBytes;
    private long totalRecvBytes6;
    private long totalXcdnBytes;
    private long totalXcdnBytes6;
    private String urlConnected;
    private URLStatInfo[] urlInfos;
    public boolean hasPlayed = false;
    public boolean hasDownloaded = false;
    public boolean hasCached = false;

    public Object[] createURLInfos(int i2) {
        this.urlInfos = new URLStatInfo[i2];
        Object[] objArr = new Object[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.urlInfos[i3] = new URLStatInfo();
            objArr[i3] = this.urlInfos[i3];
        }
        return objArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getErrorCode() {
        return this.errorCode;
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

    public String getResolvedHosts() {
        return this.resolvedHosts;
    }

    public long getTotalRecvBytes() {
        return this.totalRecvBytes;
    }

    public long getTotalRecvBytes6() {
        return this.totalRecvBytes6;
    }

    public long getTotalXcdnBytes() {
        return this.totalXcdnBytes;
    }

    public long getTotalXcdnBytes6() {
        return this.totalXcdnBytes6;
    }

    public String getUrlConnected() {
        return this.urlConnected;
    }

    public URLStatInfo[] getUrlInfos() {
        return this.urlInfos;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
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

    public void setResolvedHosts(String str) {
        this.resolvedHosts = str;
    }

    public void setTotalRecvBytes(long j) {
        this.totalRecvBytes = j;
    }

    public void setTotalRecvBytes6(@IntRange(from = 0) long j) {
        this.totalRecvBytes6 = j;
    }

    public void setTotalXcdnBytes(@IntRange(from = 0) long j) {
        this.totalXcdnBytes = j;
    }

    public void setTotalXcdnBytes6(@IntRange(from = 0) long j) {
        this.totalXcdnBytes6 = j;
    }

    public void setUrlConnected(String str) {
        this.urlConnected = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("resovledHosts=" + getResolvedHosts());
        sb.append(" errorCode=" + getErrorCode());
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.resolvedHosts);
        parcel.writeString(this.urlConnected);
        parcel.writeInt(this.errorCode);
        parcel.writeTypedArray(this.urlInfos, i2);
        parcel.writeLong(this.totalRecvBytes);
        parcel.writeLong(this.totalRecvBytes6);
        parcel.writeLong(this.totalXcdnBytes);
        parcel.writeLong(this.totalXcdnBytes6);
        parcel.writeInt(this.hasPlayed ? 1 : 0);
        parcel.writeInt(this.hasDownloaded ? 1 : 0);
        parcel.writeInt(this.hasCached ? 1 : 0);
    }
}
