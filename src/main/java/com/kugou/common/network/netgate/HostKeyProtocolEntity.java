package com.kugou.common.network.netgate;

import android.os.Parcel;
import android.os.Parcelable;
import com.kugou.common.network.netgate.AckHostConfigEntity;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class HostKeyProtocolEntity implements Parcelable {
    public static final Parcelable.Creator<HostKeyProtocolEntity> CREATOR = new Parcelable.Creator<HostKeyProtocolEntity>() { // from class: com.kugou.common.network.netgate.HostKeyProtocolEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HostKeyProtocolEntity createFromParcel(Parcel parcel) {
            return new HostKeyProtocolEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HostKeyProtocolEntity[] newArray(int i2) {
            return new HostKeyProtocolEntity[i2];
        }
    };
    public final List<AckHostConfigEntity.HeaderParam> headerParams;
    public final List<AckHostConfigEntity.UrlHostEntity> urlHosts;

    public HostKeyProtocolEntity(List<AckHostConfigEntity.HeaderParam> list, List<AckHostConfigEntity.UrlHostEntity> list2) {
        this.headerParams = list;
        this.urlHosts = list2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.headerParams);
        parcel.writeTypedList(this.urlHosts);
    }

    public HostKeyProtocolEntity(Parcel parcel) {
        this.headerParams = parcel.createTypedArrayList(AckHostConfigEntity.HeaderParam.CREATOR);
        this.urlHosts = parcel.createTypedArrayList(AckHostConfigEntity.UrlHostEntity.CREATOR);
    }
}
