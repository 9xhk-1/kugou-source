package com.kugou.android.watch.lite.base.apm;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsNetQualityData implements Parcelable {
    public static final Parcelable.Creator<AbsNetQualityData> CREATOR = new a();
    public int a;

    public class a implements Parcelable.Creator<AbsNetQualityData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NetQualityData createFromParcel(Parcel parcel) {
            switch (parcel.readInt()) {
                case 46001:
                    return new NetQualityData(parcel);
                case 46002:
                    throw new RuntimeException("not find class");
                default:
                    throw new RuntimeException("Bad NetQulity data");
            }
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AbsNetQualityData[] newArray(int i2) {
            return new AbsNetQualityData[i2];
        }
    }

    public AbsNetQualityData(Parcel parcel) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
    }
}
