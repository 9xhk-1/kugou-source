package com.kugou.android.watch.lite.base.ipc.peripheral;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class BinderCarrier implements Parcelable {
    public static final Parcelable.Creator<BinderCarrier> CREATOR = new a();
    public IBinder a;

    public class a implements Parcelable.Creator<BinderCarrier> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BinderCarrier createFromParcel(Parcel parcel) {
            return new BinderCarrier(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BinderCarrier[] newArray(int i2) {
            return new BinderCarrier[i2];
        }
    }

    public BinderCarrier(IInterface iInterface) {
        this.a = iInterface.asBinder();
    }

    public IBinder a() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongBinder(this.a);
    }

    public BinderCarrier(Parcel parcel) {
        this.a = parcel.readStrongBinder();
    }
}
