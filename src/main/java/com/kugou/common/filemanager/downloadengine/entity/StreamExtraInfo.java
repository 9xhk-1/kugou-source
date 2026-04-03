package com.kugou.common.filemanager.downloadengine.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IntRange;

/* JADX INFO: loaded from: classes2.dex */
public class StreamExtraInfo implements Parcelable {
    public static final Parcelable.Creator<StreamExtraInfo> CREATOR = new Parcelable.Creator<StreamExtraInfo>() { // from class: com.kugou.common.filemanager.downloadengine.entity.StreamExtraInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StreamExtraInfo createFromParcel(Parcel parcel) {
            StreamExtraInfo streamExtraInfo = new StreamExtraInfo();
            streamExtraInfo.readFromParcel(parcel);
            return streamExtraInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StreamExtraInfo[] newArray(int i2) {
            return new StreamExtraInfo[i2];
        }
    };
    private int errorCode;
    private String errorDetail;
    private String fileHash;
    private long mixSongID;
    private String plainHash;
    private String quality;

    public StreamExtraInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorDetail() {
        return this.errorDetail;
    }

    public String getFileHash() {
        return this.fileHash;
    }

    public long getMixSongID() {
        return this.mixSongID;
    }

    public String getPlainHash() {
        return this.plainHash;
    }

    public String getQuality() {
        return this.quality;
    }

    public void readFromParcel(Parcel parcel) {
        this.errorCode = parcel.readInt();
        this.errorDetail = parcel.readString();
        this.mixSongID = parcel.readLong();
        this.fileHash = parcel.readString();
        this.quality = parcel.readString();
        this.plainHash = parcel.readString();
    }

    public void setErrorCode(@IntRange(from = 0) int i2) {
        this.errorCode = i2;
    }

    public void setErrorDetail(String str) {
        this.errorDetail = str;
    }

    public void setFileHash(String str) {
        this.fileHash = str;
    }

    public void setMixSongID(@IntRange(from = 0) long j) {
        this.mixSongID = j;
    }

    public void setPlainHash(String str) {
        this.plainHash = str;
    }

    public void setQuality(String str) {
        this.quality = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, @IntRange(from = 0) int i2) {
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.errorDetail);
        parcel.writeLong(this.mixSongID);
        parcel.writeString(this.fileHash);
        parcel.writeString(this.quality);
        parcel.writeString(this.plainHash);
    }

    public StreamExtraInfo(long j, String str) {
        this.mixSongID = j;
        this.quality = str;
    }
}
