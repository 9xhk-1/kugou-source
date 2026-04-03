package com.tme.fireeye.crash.comm.info;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new a();
    public final String a;
    public final String b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f268d;

    public class a implements Parcelable.Creator<PlugInBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlugInBean[] newArray(int i2) {
            return new PlugInBean[i2];
        }
    }

    public PlugInBean(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.f268d = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.a + " plV:" + this.b + " plUUID:" + this.f268d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.f268d);
    }

    public PlugInBean(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.f268d = parcel.readString();
    }
}
