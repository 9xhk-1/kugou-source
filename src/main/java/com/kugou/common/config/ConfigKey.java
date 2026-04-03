package com.kugou.common.config;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ConfigKey implements Parcelable {
    public static final Parcelable.Creator<ConfigKey> CREATOR = new Parcelable.Creator<ConfigKey>() { // from class: com.kugou.common.config.ConfigKey.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConfigKey createFromParcel(Parcel parcel) {
            return new ConfigKey(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConfigKey[] newArray(int i2) {
            return new ConfigKey[i2];
        }
    };
    public final String key;

    public ConfigKey(String str) {
        if (str == null) {
            this.key = "";
        } else {
            this.key = str;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj == null || !(obj instanceof ConfigKey)) ? super.equals(obj) : this.key.equals(((ConfigKey) obj).key);
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        return this.key;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.key);
    }
}
