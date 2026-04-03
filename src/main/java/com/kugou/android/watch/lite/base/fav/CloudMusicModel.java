package com.kugou.android.watch.lite.base.fav;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class CloudMusicModel implements Parcelable {
    public static final Parcelable.Creator<CloudMusicModel> CREATOR = new a();
    public boolean a;
    public boolean b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f27d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f28f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f29h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f30i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public String o;
    public boolean p;
    public String q;
    public String r;
    public String s;
    public String t;
    public long u;

    public class a implements Parcelable.Creator<CloudMusicModel> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CloudMusicModel createFromParcel(Parcel parcel) {
            CloudMusicModel cloudMusicModel = new CloudMusicModel();
            cloudMusicModel.w(parcel.readInt() == 1);
            cloudMusicModel.n(parcel.readInt() == 1);
            cloudMusicModel.z(parcel.readString());
            cloudMusicModel.m(parcel.readString());
            cloudMusicModel.j(parcel.readInt() == 1);
            cloudMusicModel.s(parcel.readString());
            cloudMusicModel.k(parcel.readInt() == 1);
            cloudMusicModel.q(parcel.readInt() == 1);
            cloudMusicModel.x(parcel.readString());
            cloudMusicModel.l(parcel.readString());
            cloudMusicModel.u(parcel.readInt() == 1);
            cloudMusicModel.r(parcel.readLong());
            return cloudMusicModel;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CloudMusicModel[] newArray(int i2) {
            return new CloudMusicModel[i2];
        }
    }

    public CloudMusicModel() {
        this.m = true;
        this.p = false;
        this.s = null;
        this.t = "其他";
        this.u = -1L;
    }

    public void A(boolean z) {
        this.k = z;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CloudMusicModel clone() {
        CloudMusicModel cloudMusicModel = new CloudMusicModel();
        cloudMusicModel.w(this.a);
        cloudMusicModel.n(this.b);
        cloudMusicModel.z(this.f27d);
        cloudMusicModel.m(this.f28f);
        cloudMusicModel.j(this.f29h);
        cloudMusicModel.s(this.o);
        cloudMusicModel.k(this.m);
        cloudMusicModel.q(this.p);
        cloudMusicModel.x(this.q);
        cloudMusicModel.l(this.t);
        cloudMusicModel.o(this.j);
        cloudMusicModel.A(this.k);
        cloudMusicModel.y(this.l);
        cloudMusicModel.v(this.n);
        cloudMusicModel.p(this.r);
        cloudMusicModel.t(this.s);
        cloudMusicModel.u(this.f30i);
        cloudMusicModel.r(this.u);
        return cloudMusicModel;
    }

    public String b() {
        return this.f28f;
    }

    public int c() {
        return this.j;
    }

    public String d() {
        return this.f27d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.f29h;
    }

    public boolean f() {
        return this.b;
    }

    public boolean g() {
        return this.p;
    }

    public boolean h() {
        return this.a;
    }

    public boolean i() {
        return this.k;
    }

    public void j(boolean z) {
        this.f29h = z;
    }

    public void k(boolean z) {
        this.m = z;
    }

    public void l(String str) {
        this.t = str;
    }

    public void m(String str) {
        this.f28f = str;
    }

    public void n(boolean z) {
        this.b = z;
    }

    public void o(int i2) {
        this.j = i2;
    }

    public void p(String str) {
        this.r = str;
    }

    public void q(boolean z) {
        this.p = z;
    }

    public void r(long j) {
        this.u = j;
    }

    public void s(String str) {
        this.o = str;
    }

    public void t(String str) {
        this.s = str;
    }

    public void u(boolean z) {
        this.f30i = z;
    }

    public void v(int i2) {
        this.n = i2;
    }

    public void w(boolean z) {
        this.a = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a ? 1 : 0);
        parcel.writeInt(this.b ? 1 : 0);
        parcel.writeString(this.f27d);
        parcel.writeString(this.f28f);
        parcel.writeInt(this.f29h ? 1 : 0);
        parcel.writeString(this.o);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeInt(this.p ? 1 : 0);
        parcel.writeString(this.q);
        parcel.writeString(this.t);
        parcel.writeInt(this.f30i ? 1 : 0);
        parcel.writeLong(this.u);
    }

    public void x(String str) {
        this.q = str;
    }

    public void y(boolean z) {
        this.l = z;
    }

    public void z(String str) {
        this.f27d = str;
    }

    public CloudMusicModel(boolean z, boolean z2, String str, String str2, boolean z3) {
        this.m = true;
        this.p = false;
        this.s = null;
        this.t = "其他";
        this.u = -1L;
        this.a = z;
        this.b = z2;
        this.f27d = str;
        m(str2);
        this.f29h = z3;
    }

    public CloudMusicModel(boolean z, boolean z2, String str, String str2, boolean z3, boolean z4) {
        this(z, z2, str, str2, z3);
        this.k = z4;
    }
}
