package com.kugou.android.watch.lite.component.playlist.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.provider.FontsContractCompat;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import e.c.a.g.a.d.f.c.a.i;
import e.c.a.g.a.f.j.a.e;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import f.e0.o;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
@Entity(tableName = "playlistsong")
@i(tableName = "playlistsong")
public final class KGPlaylistMusic implements Parcelable {
    public static final Parcelable.Creator<KGPlaylistMusic> CREATOR = new a();
    public String A;
    public String B;
    public long C;
    public long D;
    public int E;

    @ColumnInfo(name = "global_id")
    public String F;

    @Ignore
    public KGMusic G;
    public String H;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DbOpenHelper.ID)
    public long a;
    public int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f180d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f181f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @ColumnInfo(name = FontsContractCompat.Columns.FILE_ID)
    public int f183i;
    public int j;
    public long k;
    public int l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public String q;
    public long r;
    public boolean s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public static final class a implements Parcelable.Creator<KGPlaylistMusic> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public KGPlaylistMusic createFromParcel(Parcel parcel) {
            j.e(parcel, "in");
            return new KGPlaylistMusic(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public KGPlaylistMusic[] newArray(int i2) {
            return new KGPlaylistMusic[i2];
        }
    }

    public KGPlaylistMusic(Parcel parcel) {
        j.e(parcel, "in");
        this.j = -1;
        this.k = -1L;
        this.E = -1;
        this.F = "";
        this.b = parcel.readInt();
        this.f180d = parcel.readInt();
        this.f181f = parcel.readInt();
        this.f182h = parcel.readLong();
        this.f183i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readLong();
        this.l = parcel.readInt();
        this.p = parcel.readInt();
        this.G = (KGMusic) parcel.readParcelable(KGMusic.class.getClassLoader());
        this.q = parcel.readString();
        this.r = parcel.readLong();
        this.t = parcel.readString();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.y = parcel.readString();
        this.z = parcel.readString();
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readInt();
        this.n = parcel.readInt();
        this.m = parcel.readInt() == 1;
        this.o = parcel.readInt();
        this.H = parcel.readString();
    }

    public final String A() {
        return this.x;
    }

    public final String B() {
        return this.y;
    }

    public final String C() {
        return this.B;
    }

    public final int D() {
        return this.l;
    }

    public final boolean E() {
        return this.m;
    }

    public final boolean F() {
        return this.s;
    }

    public final void G(int i2) {
        this.n = i2;
    }

    public final void H(long j) {
        this.D = j;
    }

    public final void I(String str) {
        this.q = str;
    }

    public final void J(String str) {
        this.q = str;
    }

    public final void K(long j) {
        this.k = j;
    }

    public final void L(int i2) {
        this.f183i = i2;
    }

    public final void M(int i2) {
        this.j = i2;
    }

    public final void N(int i2) {
        this.p = i2;
    }

    public final void O(String str) {
        j.e(str, "<set-?>");
        this.F = str;
    }

    public final void P(String str) {
        this.H = str;
    }

    public final void Q(long j) {
        this.a = j;
    }

    public final void R(int i2) {
        this.l = i2;
    }

    public final void S(long j) {
        this.C = j;
    }

    public final void T(KGMusic kGMusic) {
        this.G = kGMusic;
    }

    public final void U(long j) {
        this.f182h = j;
    }

    public final void V(int i2) {
        this.E = i2;
    }

    public final void W(long j) {
        this.r = j;
    }

    public final void X(boolean z) {
        this.m = z;
    }

    public final void Y(int i2) {
        this.o = i2;
    }

    public final void Z(boolean z) {
        this.s = z;
    }

    public final int a() {
        return this.n;
    }

    public final void a0(int i2) {
        this.f180d = i2;
    }

    public final long b() {
        return this.D;
    }

    public final void b0(int i2) {
        this.b = i2;
    }

    public final String c() {
        return this.q;
    }

    public final void c0(int i2) {
        this.f181f = i2;
    }

    public final long d() {
        return this.k;
    }

    public final void d0(String str) {
        this.v = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f183i;
    }

    public final void e0(String str) {
        this.w = str;
    }

    public final int f() {
        return this.j;
    }

    public final void f0(String str) {
        this.t = str;
    }

    public final int g() {
        return this.p;
    }

    public final void g0(String str) {
        this.u = str;
    }

    public final String h() {
        return this.F;
    }

    public final void h0(String str) {
        this.z = str;
    }

    public final String i() {
        return this.H;
    }

    public final void i0(String str) {
        this.A = str;
    }

    public final long j() {
        return this.a;
    }

    public final void j0(String str) {
        this.x = str;
    }

    public final KGMusic k() {
        KGMusic kGMusic = this.G;
        if (kGMusic != null) {
            if (n() <= 0) {
                U(kGMusic.sid);
            } else {
                long jN = n();
                long j = kGMusic.sid;
                if (jN != j) {
                    if (j > 0) {
                        U(j);
                    } else if (g0.a) {
                        g0.c("BLUE-KGPlaylistMusic", "empty music id in kgmusic, but not empty in playlistmusic");
                    }
                }
            }
        }
        return this.G;
    }

    public final void k0(String str) {
        this.y = str;
    }

    public final long l() {
        return this.C;
    }

    public final void l0(String str) {
        this.B = str;
    }

    public final KGMusic m() {
        return this.G;
    }

    public final void m0(KGMusic kGMusic) {
        this.G = kGMusic;
    }

    public final long n() {
        return this.f182h;
    }

    public final int o() {
        return this.E;
    }

    public final long p() {
        return this.r;
    }

    public final int q() {
        return this.o;
    }

    public final int r() {
        return this.f180d;
    }

    public final int s() {
        return this.b;
    }

    public final int t() {
        return this.f181f;
    }

    public String toString() {
        return "KGPlaylistMusic{mPlaylistId=" + this.f180d + ", mFileId=" + this.f183i + ", feeAlbumId='" + ((Object) this.q) + "'}";
    }

    public final String u() {
        return this.v;
    }

    public final String v() {
        return this.w;
    }

    public final String w() {
        return this.t;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        j.e(parcel, "dest");
        parcel.writeInt(this.b);
        parcel.writeInt(this.f180d);
        parcel.writeInt(this.f181f);
        parcel.writeLong(this.f182h);
        parcel.writeInt(this.f183i);
        parcel.writeInt(this.j);
        parcel.writeLong(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.p);
        parcel.writeParcelable(this.G, i2);
        parcel.writeString(this.q);
        parcel.writeLong(this.r);
        parcel.writeString(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeString(this.y);
        parcel.writeString(this.z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeInt(this.E);
        parcel.writeInt(this.n);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeInt(this.o);
        parcel.writeString(this.H);
    }

    public final String x() {
        return this.u;
    }

    public final String y() {
        return this.z;
    }

    public final String z() {
        return this.A;
    }

    public KGPlaylistMusic(e.c.a.g.a.g.k.c.a aVar, String str) {
        this.j = -1;
        this.k = -1L;
        this.E = -1;
        this.F = "";
        if (aVar != null) {
            this.m = aVar.w();
            this.f183i = aVar.o();
            this.j = aVar.q();
            KGMusic kGMusic = new KGMusic();
            this.G = kGMusic;
            j.c(kGMusic);
            kGMusic.hashType = 100;
            KGMusic kGMusic2 = this.G;
            j.c(kGMusic2);
            kGMusic2.source = str;
            KGMusic kGMusic3 = this.G;
            j.c(kGMusic3);
            kGMusic3.duration = aVar.s();
            KGMusic kGMusic4 = this.G;
            j.c(kGMusic4);
            kGMusic4.feeAlbumId = aVar.a();
            KGMusic kGMusic5 = this.G;
            j.c(kGMusic5);
            kGMusic5.mixId = aVar.f();
            KGMusic kGMusic6 = this.G;
            j.c(kGMusic6);
            kGMusic6.failProcess = aVar.e();
            KGMusic kGMusic7 = this.G;
            j.c(kGMusic7);
            kGMusic7.updateFeeStatusTime = aVar.l();
            KGMusic kGMusic8 = this.G;
            j.c(kGMusic8);
            kGMusic8.payType = aVar.j();
            KGMusic kGMusic9 = this.G;
            j.c(kGMusic9);
            kGMusic9.musicFeeType = aVar.g();
            KGMusic kGMusic10 = this.G;
            j.c(kGMusic10);
            kGMusic10.oldCpy = aVar.i();
            KGMusic kGMusic11 = this.G;
            j.c(kGMusic11);
            kGMusic11.charge = aVar.k();
            KGMusic kGMusic12 = this.G;
            j.c(kGMusic12);
            kGMusic12.mixId = aVar.f();
            if (!TextUtils.isEmpty(aVar.a())) {
                try {
                    KGMusic kGMusic13 = this.G;
                    j.c(kGMusic13);
                    String strA = aVar.a();
                    j.d(strA, "file.albumId");
                    kGMusic13.albumID = Long.parseLong(strA);
                } catch (Exception e2) {
                    g0.k(e2);
                }
            }
            I(aVar.a());
            String strP = aVar.p();
            if (!TextUtils.isEmpty(strP)) {
                j.d(strP, "fileName");
                int iJ = o.J(strP, ".", 0, false, 6, null);
                if (iJ > 0) {
                    strP = strP.substring(0, iJ);
                    j.d(strP, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                if (!TextUtils.isEmpty(strP)) {
                    e eVarR = h1.r(strP);
                    KGMusic kGMusic14 = this.G;
                    j.c(kGMusic14);
                    kGMusic14.displayName = eVarR.a();
                    KGMusic kGMusic15 = this.G;
                    j.c(kGMusic15);
                    kGMusic15.fullName = eVarR.b();
                }
            }
            KGMusic kGMusic16 = this.G;
            j.c(kGMusic16);
            kGMusic16.hashValue = aVar.n();
            KGMusic kGMusic17 = this.G;
            j.c(kGMusic17);
            kGMusic17.size = aVar.r();
            KGMusic kGMusic18 = this.G;
            j.c(kGMusic18);
            kGMusic18.mvHashValue = aVar.t();
            KGMusic kGMusic19 = this.G;
            j.c(kGMusic19);
            kGMusic19.mvTracks = aVar.u();
            KGMusic kGMusic20 = this.G;
            j.c(kGMusic20);
            kGMusic20.mvType = aVar.v();
            KGMusic kGMusic21 = this.G;
            j.c(kGMusic21);
            kGMusic21.setMusicTransParamEnenty(aVar.h());
            if (g0.f()) {
                Log.e("mhs_watch_fav_update", j.l("CloudMusicListFile, file.privilege = ", Integer.valueOf(aVar.k())));
            }
            if (aVar.s() > 0) {
                KGMusic kGMusic22 = this.G;
                j.c(kGMusic22);
                kGMusic22.m4aSize = ((aVar.s() / 1000) * 32000) / 8;
            } else {
                KGMusic kGMusic23 = this.G;
                j.c(kGMusic23);
                kGMusic23.m4aSize = 1048576L;
            }
            KGMusic kGMusic24 = this.G;
            j.c(kGMusic24);
            kGMusic24.albumName = aVar.b();
            KGMusic kGMusic25 = this.G;
            j.c(kGMusic25);
            kGMusic25.hashType = 100;
            this.s = aVar.x();
            this.H = aVar.n();
        }
    }

    public KGPlaylistMusic(KGMusic kGMusic, String str) {
        j.e(str, "globalId");
        this.j = -1;
        this.k = -1L;
        this.E = -1;
        this.F = "";
        if (kGMusic != null) {
            m0(kGMusic);
            this.F = str;
            this.r = kGMusic.mixId;
            this.f182h = kGMusic.getMusiclibId();
            this.H = kGMusic.hashValue;
        }
    }

    public KGPlaylistMusic() {
        this.j = -1;
        this.k = -1L;
        this.E = -1;
        this.F = "";
        KGMusic kGMusic = new KGMusic();
        this.G = kGMusic;
        j.c(kGMusic);
        kGMusic.source = KGMusic.MUSIC_SOURCE_CLOUD;
    }
}
