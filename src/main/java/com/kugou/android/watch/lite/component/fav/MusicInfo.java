package com.kugou.android.watch.lite.component.fav;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MusicInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<MusicInfo> CREATOR = new a();
    public long a;
    public String b;

    public class a implements Parcelable.Creator<MusicInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MusicInfo createFromParcel(Parcel parcel) {
            return new MusicInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MusicInfo[] newArray(int i2) {
            return new MusicInfo[i2];
        }
    }

    public MusicInfo() {
    }

    public static int c(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public String a() {
        return this.b;
    }

    public long b() {
        return this.a;
    }

    public void d(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(long j) {
        this.a = j;
    }

    public boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!(obj instanceof MusicInfo)) {
            return super.equals(obj);
        }
        MusicInfo musicInfo = (MusicInfo) obj;
        if (this.a > 0 && musicInfo.b() > 0) {
            return this.a == musicInfo.b();
        }
        if (this.a > 0 || musicInfo.b() > 0 || (str = this.b) == null) {
            return false;
        }
        return str.equalsIgnoreCase(musicInfo.a());
    }

    public int hashCode() {
        int iHashCode;
        long j = this.a;
        if (j > 0) {
            iHashCode = c(j);
        } else {
            String str = this.b;
            if (str == null) {
                return super.hashCode();
            }
            iHashCode = str.toLowerCase().hashCode();
        }
        return 527 + iHashCode;
    }

    public String toString() {
        return "MusicInfo{mixId=" + this.a + ", hashValue='" + this.b + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
    }

    public MusicInfo(long j, String str) {
        this.a = j;
        this.b = str;
    }

    public MusicInfo(Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readString();
    }
}
