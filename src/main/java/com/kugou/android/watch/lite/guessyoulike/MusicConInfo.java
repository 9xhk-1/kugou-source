package com.kugou.android.watch.lite.guessyoulike;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class MusicConInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<MusicConInfo> CREATOR = new a();
    public String a = null;
    public int b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f212d = 0;

    public class a implements Parcelable.Creator<MusicConInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MusicConInfo createFromParcel(Parcel parcel) {
            MusicConInfo musicConInfo = new MusicConInfo();
            musicConInfo.b(parcel.readString());
            musicConInfo.c(parcel.readInt());
            musicConInfo.a(parcel.readInt());
            return musicConInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MusicConInfo[] newArray(int i2) {
            return new MusicConInfo[i2];
        }
    }

    public void a(int i2) {
        this.f212d = i2;
    }

    public void b(String str) {
        this.a = str;
    }

    public void c(int i2) {
        this.b = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.b + "-" + this.f212d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.f212d);
    }
}
