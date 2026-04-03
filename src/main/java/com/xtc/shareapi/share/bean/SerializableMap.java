package com.xtc.shareapi.share.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class SerializableMap implements Parcelable {
    public static final Parcelable.Creator<SerializableMap> CREATOR = new Parcelable.Creator<SerializableMap>() { // from class: com.xtc.shareapi.share.bean.SerializableMap.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SerializableMap createFromParcel(Parcel parcel) {
            return new SerializableMap(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SerializableMap[] newArray(int i2) {
            return new SerializableMap[i2];
        }
    };
    private HashMap map;

    public SerializableMap() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public HashMap getMap() {
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

    public SerializableMap(HashMap<String, String> map) {
        this.map = map;
    }

    public SerializableMap(Parcel parcel) {
        this.map = parcel.readHashMap(HashMap.class.getClassLoader());
    }
}
