package e.c.a.g.a.g.k.c;

import com.kugou.android.watch.lite.common.music.entity.MusicTransParamEnenty;
import e.c.a.g.a.f.j.b.h;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public MusicTransParamEnenty B;
    public int a;
    public int b;
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public short f964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public short f965h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f966i;
    public boolean j;
    public int k;
    public String l;
    public int m;
    public int n;
    public String o;
    public String p;
    public long q;
    public boolean r;
    public int s;
    public int t;
    public String u;
    public long v;
    public long w;
    public long z;
    public int x = h.b;
    public int y = -1;
    public int A = -1;

    public a(int i2, int i3, String str, int i4, int i5, int i6, short s, String str2, int i7, String str3, int i8, int i9, String str4, long j, boolean z) {
        this.c = null;
        this.l = null;
        this.a = i2;
        this.b = i3;
        this.c = str;
        this.f961d = i4;
        this.f962e = i5;
        this.f963f = i6;
        this.f964g = s;
        this.f966i = str2;
        this.f965h = (short) str2.length();
        this.k = i7;
        this.l = str3;
        this.m = i8;
        this.n = i9;
        this.q = j;
        this.o = str4;
        this.j = z;
    }

    public void A(long j) {
        this.z = j;
    }

    public void B(int i2) {
        this.t = i2;
    }

    public void C(String str) {
        this.u = str;
    }

    public void D(MusicTransParamEnenty musicTransParamEnenty) {
        this.B = musicTransParamEnenty;
    }

    public void E(int i2) {
        this.y = i2;
    }

    public void F(int i2) {
        this.s = i2;
    }

    public void G(int i2) {
        this.x = i2;
    }

    public void H(long j) {
        this.v = j;
    }

    public void I(boolean z) {
        this.r = z;
    }

    public void J(int i2) {
        this.f963f = i2;
    }

    public String a() {
        return this.o;
    }

    public String b() {
        return this.p;
    }

    public int c() {
        return this.A;
    }

    public long d() {
        return this.z;
    }

    public int e() {
        return this.t;
    }

    public long f() {
        return this.q;
    }

    public String g() {
        return this.u;
    }

    public MusicTransParamEnenty h() {
        return this.B;
    }

    public int i() {
        return this.y;
    }

    public int j() {
        return this.s;
    }

    public int k() {
        return this.x;
    }

    public long l() {
        return this.v;
    }

    public short m() {
        return this.f964g;
    }

    public String n() {
        return this.c;
    }

    public int o() {
        return this.b;
    }

    public String p() {
        return this.f966i;
    }

    public int q() {
        return this.f963f;
    }

    public int r() {
        return this.f962e;
    }

    public int s() {
        return this.f961d;
    }

    public String t() {
        return this.l;
    }

    public String toString() {
        return "CloudMusicListFile{mOP=" + this.a + ", mFileID=" + this.b + ", mFileHash='" + this.c + "', mFileTimeLen=" + this.f961d + ", mFileSize=" + this.f962e + ", mFileOrderWeight=" + this.f963f + ", mFileBitRate=" + ((int) this.f964g) + ", mFileNameLen=" + ((int) this.f965h) + ", mFileName='" + this.f966i + "', isMusicCloud=" + this.j + ", mSection=" + this.k + ", mMVHash='" + this.l + "', mMVTrack=" + this.m + ", mMVType=" + this.n + ", mAlbum_id='" + this.o + "', mAlbumName='" + this.p + "', mixId=" + this.q + ", updateMixid=" + this.r + ", payType=" + this.s + ", failProcess=" + this.t + ", musicFeeType='" + this.u + "', updateFeeStatusTime=" + this.v + ", localMusicFeeId=" + this.w + ", privilege=" + this.x + ", oldCpy=" + this.y + ", collectTime=" + this.z + ", category=" + this.A + ", musicTransParamEnenty=" + this.B + '}';
    }

    public int u() {
        return this.m;
    }

    public int v() {
        return this.n;
    }

    public boolean w() {
        return this.j;
    }

    public boolean x() {
        return this.r;
    }

    public void y(String str) {
        this.p = str;
    }

    public void z(int i2) {
        this.A = i2;
    }
}
