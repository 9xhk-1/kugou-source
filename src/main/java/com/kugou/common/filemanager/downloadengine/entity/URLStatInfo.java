package com.kugou.common.filemanager.downloadengine.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IntRange;

/* JADX INFO: loaded from: classes2.dex */
public class URLStatInfo implements Parcelable {
    public static final Parcelable.Creator<URLStatInfo> CREATOR = new Parcelable.Creator<URLStatInfo>() { // from class: com.kugou.common.filemanager.downloadengine.entity.URLStatInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public URLStatInfo createFromParcel(Parcel parcel) {
            return new URLStatInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public URLStatInfo[] newArray(int i2) {
            return new URLStatInfo[i2];
        }
    };
    private int errorCode;
    private String errorDetail;
    private int httpErrorCode;
    private String resolvedHosts;
    private String url;

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

    public int getHTTPErrorCode() {
        return this.httpErrorCode;
    }

    public String getResolvedHosts() {
        return this.resolvedHosts;
    }

    public String getURL() {
        return this.url;
    }

    public void setErrorCode(int i2) {
        if (i2 == 0) {
            this.errorCode = 0;
        } else {
            this.errorCode = i2 + 100;
        }
    }

    public void setErrorDetail(String str) {
        this.errorDetail = str;
    }

    public void setHTTPErrorCode(int i2) {
        this.httpErrorCode = i2;
    }

    public void setResolvedHosts(String str) {
        this.resolvedHosts = str;
    }

    public void setURL(String str) {
        this.url = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, @IntRange(from = -2147483648L) int i2) {
        parcel.writeString(this.url);
        parcel.writeString(this.resolvedHosts);
        parcel.writeInt(this.errorCode);
        parcel.writeInt(this.httpErrorCode);
        parcel.writeString(this.errorDetail);
    }

    public URLStatInfo() {
    }

    private URLStatInfo(Parcel parcel) {
        this.url = parcel.readString();
        this.resolvedHosts = parcel.readString();
        this.errorCode = parcel.readInt();
        this.httpErrorCode = parcel.readInt();
        this.errorDetail = parcel.readString();
    }
}
