package com.tme.fireeye.crash.crashmodule;

import android.os.Parcel;
import android.os.Parcelable;
import com.tme.fireeye.crash.comm.info.PlugInBean;
import e.f.a.a.a.k.f;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new a();
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public byte[] F;
    public Map<String, String> G;
    public String H;
    public String I;
    public long J;
    public long K;
    public long L;
    public long M;
    public long N;
    public long O;
    public String P;
    public String Q;
    public String R;
    public String S;
    public String T;
    public long U;
    public boolean V;
    public Map<String, String> W;
    public Map<String, String> X;
    public int Y;
    public int Z;
    public long a;
    public Map<String, String> a0;
    public int b;
    public Map<String, String> b0;
    public byte[] c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f273d;
    public String d0;
    public String e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f274f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f276i;
    public String j;
    public Map<String, PlugInBean> k;
    public Map<String, PlugInBean> l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public long v;
    public String w;
    public int x;
    public String y;
    public String z;

    public class a implements Parcelable.Creator<CrashDetailBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CrashDetailBean[] newArray(int i2) {
            return new CrashDetailBean[i2];
        }
    }

    public CrashDetailBean() {
        this.a = -1L;
        this.b = 0;
        this.f273d = UUID.randomUUID().toString();
        this.f274f = false;
        this.f275h = "";
        this.f276i = "";
        this.j = "";
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = 0;
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "";
        this.u = "";
        this.v = -1L;
        this.w = null;
        this.x = 0;
        this.y = "";
        this.z = "";
        this.A = "";
        this.B = "";
        this.C = "";
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = "";
        this.I = "";
        this.J = -1L;
        this.K = -1L;
        this.L = -1L;
        this.M = -1L;
        this.N = -1L;
        this.O = -1L;
        this.P = "";
        this.Q = "";
        this.R = "";
        this.S = "";
        this.T = "";
        this.U = -1L;
        this.V = false;
        this.W = null;
        this.X = null;
        this.Y = -1;
        this.Z = -1;
        this.a0 = null;
        this.b0 = null;
        this.c0 = null;
        this.d0 = null;
        this.e0 = null;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return 1;
        }
        long j = this.v - crashDetailBean.v;
        if (j > 0) {
            return 1;
        }
        return j < 0 ? -1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.b);
        parcel.writeString(this.f273d);
        parcel.writeByte(this.f274f ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f275h);
        parcel.writeString(this.f276i);
        parcel.writeString(this.j);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.o ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.t);
        parcel.writeString(this.u);
        parcel.writeLong(this.v);
        parcel.writeString(this.w);
        parcel.writeInt(this.x);
        parcel.writeString(this.y);
        parcel.writeString(this.z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        f.L(parcel, this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeLong(this.J);
        parcel.writeLong(this.K);
        parcel.writeLong(this.L);
        parcel.writeLong(this.M);
        parcel.writeLong(this.N);
        parcel.writeLong(this.O);
        parcel.writeString(this.P);
        parcel.writeString(this.Q);
        parcel.writeString(this.R);
        parcel.writeString(this.S);
        parcel.writeString(this.T);
        parcel.writeLong(this.U);
        parcel.writeByte(this.V ? (byte) 1 : (byte) 0);
        f.L(parcel, this.W);
        f.K(parcel, this.k);
        f.K(parcel, this.l);
        parcel.writeInt(this.Y);
        parcel.writeInt(this.Z);
        f.L(parcel, this.a0);
        f.L(parcel, this.b0);
        parcel.writeByteArray(this.c0);
        parcel.writeByteArray(this.F);
        parcel.writeString(this.d0);
        parcel.writeString(this.e0);
        parcel.writeString(this.E);
    }

    public CrashDetailBean(Parcel parcel) {
        this.a = -1L;
        this.b = 0;
        this.f273d = UUID.randomUUID().toString();
        this.f274f = false;
        this.f275h = "";
        this.f276i = "";
        this.j = "";
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = 0;
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "";
        this.u = "";
        this.v = -1L;
        this.w = null;
        this.x = 0;
        this.y = "";
        this.z = "";
        this.A = "";
        this.B = "";
        this.C = "";
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = "";
        this.I = "";
        this.J = -1L;
        this.K = -1L;
        this.L = -1L;
        this.M = -1L;
        this.N = -1L;
        this.O = -1L;
        this.P = "";
        this.Q = "";
        this.R = "";
        this.S = "";
        this.T = "";
        this.U = -1L;
        this.V = false;
        this.W = null;
        this.X = null;
        this.Y = -1;
        this.Z = -1;
        this.a0 = null;
        this.b0 = null;
        this.c0 = null;
        this.d0 = null;
        this.e0 = null;
        this.b = parcel.readInt();
        this.f273d = parcel.readString();
        this.f274f = parcel.readByte() == 1;
        this.f275h = parcel.readString();
        this.f276i = parcel.readString();
        this.j = parcel.readString();
        this.m = parcel.readByte() == 1;
        this.n = parcel.readByte() == 1;
        this.o = parcel.readByte() == 1;
        this.p = parcel.readInt();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.t = parcel.readString();
        this.u = parcel.readString();
        this.v = parcel.readLong();
        this.w = parcel.readString();
        this.x = parcel.readInt();
        this.y = parcel.readString();
        this.z = parcel.readString();
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.G = f.z(parcel);
        this.H = parcel.readString();
        this.I = parcel.readString();
        this.J = parcel.readLong();
        this.K = parcel.readLong();
        this.L = parcel.readLong();
        this.M = parcel.readLong();
        this.N = parcel.readLong();
        this.O = parcel.readLong();
        this.P = parcel.readString();
        this.Q = parcel.readString();
        this.R = parcel.readString();
        this.S = parcel.readString();
        this.T = parcel.readString();
        this.U = parcel.readLong();
        this.V = parcel.readByte() == 1;
        this.W = f.z(parcel);
        this.k = f.y(parcel);
        this.l = f.y(parcel);
        this.Y = parcel.readInt();
        this.Z = parcel.readInt();
        this.a0 = f.z(parcel);
        this.b0 = f.z(parcel);
        this.c0 = parcel.createByteArray();
        this.F = parcel.createByteArray();
        this.d0 = parcel.readString();
        this.e0 = parcel.readString();
        this.E = parcel.readString();
    }
}
