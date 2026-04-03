package e.c.a.g.a.d.f.c.a;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;

/* JADX INFO: loaded from: classes.dex */
@Entity(tableName = "downloadtask")
@i(tableName = "downloadtask")
public final class a {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DbOpenHelper.ID)
    public int a;

    @ColumnInfo(name = "downloadsize")
    public int b;

    @ColumnInfo(name = "filesize")
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColumnInfo(name = "downloadstate")
    public int f382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @ColumnInfo(name = "download_error_code")
    public int f383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @ColumnInfo(name = "downloadkey")
    public String f384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @ColumnInfo(name = "quality")
    public int f385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @ColumnInfo(name = "downloadmode")
    public int f386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @ColumnInfo(name = "addtime")
    public long f387i;

    @ColumnInfo(name = "songid")
    public long j;

    @ColumnInfo(name = "fileid")
    public long k;

    @ColumnInfo(name = "iscover")
    public int l;

    @ColumnInfo(name = "module")
    public String m;

    @ColumnInfo(name = "statuscode")
    public int n;

    @ColumnInfo(name = "uploadstate")
    public int o;

    @ColumnInfo(name = "filetype")
    public int p;

    @ColumnInfo(name = "downloadtype")
    public int q;

    @ColumnInfo(name = "fee_album_id")
    public String r;

    @ColumnInfo(name = "mix_id")
    public long s;

    @ColumnInfo(name = "source_hash")
    public String t;

    @ColumnInfo(name = "file_path")
    public String u;

    @ColumnInfo(name = "tmp_cache_path")
    public String v;

    public a(int i2, int i3, int i4, int i5, int i6, String str, int i7, int i8, long j, long j2, long j3, int i9, String str2, int i10, int i11, int i12, int i13, String str3, long j4, String str4, String str5, String str6) {
        f.z.d.j.e(str, "downloadkey");
        f.z.d.j.e(str2, "module");
        f.z.d.j.e(str3, "fee_album_id");
        f.z.d.j.e(str4, "source_hash");
        f.z.d.j.e(str5, "filePath");
        f.z.d.j.e(str6, "tmpCachePath");
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.f382d = i5;
        this.f383e = i6;
        this.f384f = str;
        this.f385g = i7;
        this.f386h = i8;
        this.f387i = j;
        this.j = j2;
        this.k = j3;
        this.l = i9;
        this.m = str2;
        this.n = i10;
        this.o = i11;
        this.p = i12;
        this.q = i13;
        this.r = str3;
        this.s = j4;
        this.t = str4;
        this.u = str5;
        this.v = str6;
    }

    public final void A(long j) {
        this.s = j;
    }

    public final void B(int i2) {
        this.f385g = i2;
    }

    public final void C(String str) {
        f.z.d.j.e(str, "<set-?>");
        this.t = str;
    }

    public final void D(String str) {
        f.z.d.j.e(str, "<set-?>");
        this.v = str;
    }

    public final long a() {
        return this.f387i;
    }

    public final int b() {
        return this.f383e;
    }

    public final String c() {
        return this.f384f;
    }

    public final int d() {
        return this.f386h;
    }

    public final int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.f382d == aVar.f382d && this.f383e == aVar.f383e && f.z.d.j.a(this.f384f, aVar.f384f) && this.f385g == aVar.f385g && this.f386h == aVar.f386h && this.f387i == aVar.f387i && this.j == aVar.j && this.k == aVar.k && this.l == aVar.l && f.z.d.j.a(this.m, aVar.m) && this.n == aVar.n && this.o == aVar.o && this.p == aVar.p && this.q == aVar.q && f.z.d.j.a(this.r, aVar.r) && this.s == aVar.s && f.z.d.j.a(this.t, aVar.t) && f.z.d.j.a(this.u, aVar.u) && f.z.d.j.a(this.v, aVar.v);
    }

    public final int f() {
        return this.f382d;
    }

    public final int g() {
        return this.q;
    }

    public final String h() {
        return this.r;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.f382d) * 31) + this.f383e) * 31) + this.f384f.hashCode()) * 31) + this.f385g) * 31) + this.f386h) * 31;
        long j = this.f387i;
        int i2 = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.j;
        int i3 = (i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.k;
        int iHashCode2 = (((((((((((((((i3 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.l) * 31) + this.m.hashCode()) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r.hashCode()) * 31;
        long j4 = this.s;
        return ((((((iHashCode2 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.t.hashCode()) * 31) + this.u.hashCode()) * 31) + this.v.hashCode();
    }

    public final String i() {
        return this.u;
    }

    public final long j() {
        return this.k;
    }

    public final int k() {
        return this.c;
    }

    public final int l() {
        return this.p;
    }

    public final int m() {
        return this.a;
    }

    public final int n() {
        return this.l;
    }

    public final long o() {
        return this.s;
    }

    public final String p() {
        return this.m;
    }

    public final int q() {
        return this.f385g;
    }

    public final long r() {
        return this.j;
    }

    public final String s() {
        return this.t;
    }

    public final int t() {
        return this.n;
    }

    public String toString() {
        return "DownloadSong(id=" + this.a + ", downloadsize=" + this.b + ", filesize=" + this.c + ", downloadstate=" + this.f382d + ", download_error_code=" + this.f383e + ", downloadkey=" + this.f384f + ", quality=" + this.f385g + ", downloadmode=" + this.f386h + ", addtime=" + this.f387i + ", songid=" + this.j + ", fileid=" + this.k + ", iscover=" + this.l + ", module=" + this.m + ", statuscode=" + this.n + ", uploadstate=" + this.o + ", filetype=" + this.p + ", downloadtype=" + this.q + ", fee_album_id=" + this.r + ", mix_id=" + this.s + ", source_hash=" + this.t + ", filePath=" + this.u + ", tmpCachePath=" + this.v + ')';
    }

    public final String u() {
        return this.v;
    }

    public final int v() {
        return this.o;
    }

    public final void w(String str) {
        f.z.d.j.e(str, "<set-?>");
        this.f384f = str;
    }

    public final void x(int i2) {
        this.f382d = i2;
    }

    public final void y(String str) {
        f.z.d.j.e(str, "<set-?>");
        this.r = str;
    }

    public final void z(String str) {
        f.z.d.j.e(str, "<set-?>");
        this.u = str;
    }

    public /* synthetic */ a(int i2, int i3, int i4, int i5, int i6, String str, int i7, int i8, long j, long j2, long j3, int i9, String str2, int i10, int i11, int i12, int i13, String str3, long j4, String str4, String str5, String str6, int i14, f.z.d.g gVar) {
        this((i14 & 1) != 0 ? 0 : i2, (i14 & 2) != 0 ? 0 : i3, (i14 & 4) != 0 ? 0 : i4, (i14 & 8) != 0 ? 0 : i5, (i14 & 16) != 0 ? 0 : i6, (i14 & 32) != 0 ? "" : str, (i14 & 64) != 0 ? 0 : i7, (i14 & 128) != 0 ? 0 : i8, (i14 & 256) != 0 ? 0L : j, (i14 & 512) != 0 ? 0L : j2, (i14 & 1024) != 0 ? 0L : j3, (i14 & 2048) != 0 ? 0 : i9, (i14 & 4096) != 0 ? "" : str2, (i14 & 8192) != 0 ? 0 : i10, (i14 & 16384) != 0 ? 0 : i11, (i14 & 32768) != 0 ? 0 : i12, (i14 & 65536) != 0 ? 0 : i13, (i14 & 131072) != 0 ? "" : str3, (i14 & 262144) != 0 ? 0L : j4, (i14 & 524288) != 0 ? "" : str4, (i14 & 1048576) != 0 ? "" : str5, (i14 & 2097152) == 0 ? str6 : "");
    }

    @Ignore
    public a() {
        this(0, 0, 0, 0, 0, null, 0, 0, 0L, 0L, 0L, 0, null, 0, 0, 0, 0, null, 0L, null, null, null, 4194302, null);
    }
}
