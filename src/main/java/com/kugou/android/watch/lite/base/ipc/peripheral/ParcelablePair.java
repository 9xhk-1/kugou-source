package com.kugou.android.watch.lite.base.ipc.peripheral;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelablePair<F, S> implements Parcelable {
    public static final Parcelable.Creator<ParcelablePair> CREATOR = new a();
    public F a;
    public S b;

    public class a implements Parcelable.Creator<ParcelablePair> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelablePair createFromParcel(Parcel parcel) {
            return new ParcelablePair(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelablePair[] newArray(int i2) {
            return new ParcelablePair[i2];
        }
    }

    public ParcelablePair(Parcel parcel) {
        this.a = (F) parcel.readValue(ParcelablePair.class.getClassLoader());
        this.b = (S) parcel.readValue(ParcelablePair.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.a);
        parcel.writeValue(this.b);
    }
}
