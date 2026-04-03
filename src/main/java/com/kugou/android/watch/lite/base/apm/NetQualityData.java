package com.kugou.android.watch.lite.base.apm;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public class NetQualityData extends AbsNetQualityData {
    public String b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f17f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f18h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f19i;
    public long j;
    public int k;
    public String l;
    public String m;
    public int n;
    public int o;

    public NetQualityData(Parcel parcel) {
        super(parcel);
        this.b = parcel.readString();
        this.f16d = parcel.readInt();
        this.f17f = parcel.readLong();
        this.f18h = parcel.readInt();
        this.f19i = parcel.readString();
        this.j = parcel.readLong();
        this.k = parcel.readInt();
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.n = parcel.readInt();
        this.o = parcel.readInt();
    }

    @Override // com.kugou.android.watch.lite.base.apm.AbsNetQualityData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.b);
        parcel.writeInt(this.f16d);
        parcel.writeLong(this.f17f);
        parcel.writeInt(this.f18h);
        parcel.writeString(this.f19i);
        parcel.writeLong(this.j);
        parcel.writeInt(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
    }
}
