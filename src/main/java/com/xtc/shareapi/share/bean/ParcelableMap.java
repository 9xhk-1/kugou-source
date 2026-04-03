package com.xtc.shareapi.share.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ParcelableMap implements Parcelable {
    public static final Parcelable.Creator<ParcelableMap> CREATOR = new Parcelable.Creator<ParcelableMap>() { // from class: com.xtc.shareapi.share.bean.ParcelableMap.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableMap createFromParcel(Parcel parcel) {
            return new ParcelableMap(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableMap[] newArray(int i2) {
            return new ParcelableMap[i2];
        }
    };
    private Map map;

    public ParcelableMap() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, String> getMap() {
        return this.map;
    }

    public void setMap(HashMap map) {
        this.map = map;
    }

    public String toString() {
        return "SerializableMap{map=" + this.map + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeMap(this.map);
    }

    public ParcelableMap(Map<String, String> map) {
        this.map = map;
    }

    public ParcelableMap(Parcel parcel) {
        this.map = parcel.readHashMap(HashMap.class.getClassLoader());
    }
}
