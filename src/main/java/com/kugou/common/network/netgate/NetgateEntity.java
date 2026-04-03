package com.kugou.common.network.netgate;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class NetgateEntity implements Parcelable {
    public static final Parcelable.Creator<NetgateEntity> CREATOR = new Parcelable.Creator<NetgateEntity>() { // from class: com.kugou.common.network.netgate.NetgateEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetgateEntity createFromParcel(Parcel parcel) {
            return new NetgateEntity(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetgateEntity[] newArray(int i2) {
            return new NetgateEntity[i2];
        }
    };
    public String aliasHost;
    public String netgate;
    public String oriHost;
    public String oriUrl;

    public NetgateEntity(String str, String str2, String str3, String str4) {
        this.netgate = str;
        this.oriUrl = str2;
        this.oriHost = str3;
        this.aliasHost = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[" + this.oriUrl + ", " + this.netgate + ", " + this.oriHost + ", " + this.aliasHost + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.netgate);
        parcel.writeString(this.oriHost);
        parcel.writeString(this.aliasHost);
        parcel.writeString(this.oriUrl);
    }
}
