package com.qihoo.kidwatch.logger;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import com.qihoo.kidwatch.logger.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class BinderParcel implements Parcelable {
    public static final Parcelable.Creator<BinderParcel> CREATOR = new Parcelable.Creator<BinderParcel>() { // from class: com.qihoo.kidwatch.logger.BinderParcel.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BinderParcel createFromParcel(Parcel parcel) {
            return new BinderParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BinderParcel[] newArray(int i2) {
            return new BinderParcel[i2];
        }
    };
    private a.AbstractBinderC0025a instant;
    private a mIBinder;

    public BinderParcel(Parcel parcel) {
        this.mIBinder = a.AbstractBinderC0025a.a(parcel.readStrongBinder());
    }

    public BinderParcel(a.AbstractBinderC0025a abstractBinderC0025a) {
        this.instant = abstractBinderC0025a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public a getService() {
        return this.mIBinder;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongBinder(this.instant);
    }
}
