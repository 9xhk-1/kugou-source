package com.tme.fireeye.crash.comm.biz;

import android.os.Parcel;
import android.os.Parcelable;
import e.f.a.a.a.k.f;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new a();
    public long a;
    public int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f264d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f265f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f266h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f267i;
    public long j;
    public long k;
    public long l;
    public String m;
    public long n;
    public boolean o;
    public String p;
    public String q;
    public int r;
    public int s;
    public int t;
    public Map<String, String> u;
    public Map<String, String> v;

    public class a implements Parcelable.Creator<UserInfoBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public UserInfoBean[] newArray(int i2) {
            return new UserInfoBean[i2];
        }
    }

    public UserInfoBean() {
        this.n = 0L;
        this.o = false;
        this.p = "unknown";
        this.s = -1;
        this.t = -1;
        this.u = null;
        this.v = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.b);
        parcel.writeString(this.f264d);
        parcel.writeString(this.f265f);
        parcel.writeLong(this.f266h);
        parcel.writeLong(this.f267i);
        parcel.writeLong(this.j);
        parcel.writeLong(this.k);
        parcel.writeLong(this.l);
        parcel.writeString(this.m);
        parcel.writeLong(this.n);
        parcel.writeByte(this.o ? (byte) 1 : (byte) 0);
        parcel.writeString(this.p);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        f.L(parcel, this.u);
        f.L(parcel, this.v);
        parcel.writeString(this.q);
        parcel.writeInt(this.r);
    }

    public UserInfoBean(Parcel parcel) {
        this.n = 0L;
        this.o = false;
        this.p = "unknown";
        this.s = -1;
        this.t = -1;
        this.u = null;
        this.v = null;
        this.b = parcel.readInt();
        this.f264d = parcel.readString();
        this.f265f = parcel.readString();
        this.f266h = parcel.readLong();
        this.f267i = parcel.readLong();
        this.j = parcel.readLong();
        this.k = parcel.readLong();
        this.l = parcel.readLong();
        this.m = parcel.readString();
        this.n = parcel.readLong();
        this.o = parcel.readByte() == 1;
        this.p = parcel.readString();
        this.s = parcel.readInt();
        this.t = parcel.readInt();
        this.u = f.z(parcel);
        this.v = f.z(parcel);
        this.q = parcel.readString();
        this.r = parcel.readInt();
    }
}
