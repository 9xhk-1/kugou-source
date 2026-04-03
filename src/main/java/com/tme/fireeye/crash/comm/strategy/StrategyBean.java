package com.tme.fireeye.crash.comm.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.tmachine.trace.provider.stacktrace.StackTraceConfig;
import e.f.a.a.a.k.f;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class StrategyBean implements Parcelable {
    public static String A = "https://report.tencentmusic.com/api/v1/crash";
    public static final Parcelable.Creator<StrategyBean> CREATOR = new a();
    public static String z = "https://report.tencentmusic.com/api/v1/crash";
    public long a;
    public long b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f269d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f270f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f272i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public long o;
    public long p;
    public String q;
    public String r;
    public String s;
    public Map<String, String> t;
    public int u;
    public long v;
    public long w;
    public long x;
    public long y;

    public class a implements Parcelable.Creator<StrategyBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public StrategyBean[] newArray(int i2) {
            return new StrategyBean[i2];
        }
    }

    public StrategyBean() {
        this.a = -1L;
        this.b = -1L;
        this.f269d = true;
        this.f270f = true;
        this.f271h = true;
        this.f272i = true;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.p = StackTraceConfig.DEFAULT_TRACE_DURATION;
        this.q = z;
        this.r = A;
        this.u = 10;
        this.v = 300000L;
        this.w = -1L;
        this.x = 2000L;
        this.y = 2000L;
        this.b = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(");
        sb.append("@L@L");
        sb.append("@)");
        sb.toString();
        sb.setLength(0);
        sb.append("*^");
        sb.append("@K#K");
        sb.append("@!");
        this.s = sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.b);
        parcel.writeByte(this.f269d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f270f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f271h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        f.L(parcel, this.t);
        parcel.writeByte(this.f272i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.p);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.o);
        parcel.writeInt(this.u);
        parcel.writeLong(this.v);
        parcel.writeLong(this.w);
    }

    public StrategyBean(Parcel parcel) {
        this.a = -1L;
        this.b = -1L;
        boolean z2 = true;
        this.f269d = true;
        this.f270f = true;
        this.f271h = true;
        this.f272i = true;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.p = StackTraceConfig.DEFAULT_TRACE_DURATION;
        this.q = z;
        this.r = A;
        this.u = 10;
        this.v = 300000L;
        this.w = -1L;
        this.x = 2000L;
        this.y = 2000L;
        try {
            String str = "S(@L@L@)";
            this.b = parcel.readLong();
            this.f269d = parcel.readByte() == 1;
            this.f270f = parcel.readByte() == 1;
            this.f271h = parcel.readByte() == 1;
            this.q = parcel.readString();
            this.r = parcel.readString();
            this.s = parcel.readString();
            this.t = f.z(parcel);
            this.f272i = parcel.readByte() == 1;
            this.j = parcel.readByte() == 1;
            this.m = parcel.readByte() == 1;
            this.n = parcel.readByte() == 1;
            this.p = parcel.readLong();
            this.k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z2 = false;
            }
            this.l = z2;
            this.o = parcel.readLong();
            this.u = parcel.readInt();
            this.v = parcel.readLong();
            this.w = parcel.readLong();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
