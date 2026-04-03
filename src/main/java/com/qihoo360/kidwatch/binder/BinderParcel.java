package com.qihoo360.kidwatch.binder;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class BinderParcel implements Parcelable {
    public static final Parcelable.Creator<BinderParcel> CREATOR = new a();
    public IBinder a;

    public static class a implements Parcelable.Creator<BinderParcel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BinderParcel createFromParcel(Parcel parcel) {
            return new BinderParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BinderParcel[] newArray(int i2) {
            return new BinderParcel[i2];
        }
    }

    public BinderParcel(Parcel parcel) {
        this.a = parcel.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongBinder(this.a);
    }
}
