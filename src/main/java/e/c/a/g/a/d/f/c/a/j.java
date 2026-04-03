package e.c.a.g.a.d.f.c.a;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes.dex */
@Entity(tableName = "kugou_playlists")
@i(tableName = "kugou_playlists")
public final class j {

    @ColumnInfo(name = "list_new_sort")
    public int A;

    @ColumnInfo(name = "list_sync_user_ids")
    public String B;

    @ColumnInfo(name = "list_musiclib_id")
    public int C;

    @ColumnInfo(name = "origin_red_dot")
    public String D;

    @ColumnInfo(name = "local_red_dot")
    public String E;

    @ColumnInfo(name = "is_new")
    public int F;

    @ColumnInfo(name = "is_private")
    public int G;

    @ColumnInfo(name = "post_state")
    public int H;

    @ColumnInfo(name = "pub_type")
    public int I;

    @ColumnInfo(name = "is_custom_pic")
    public int J;

    @ColumnInfo(name = "unique_code")
    public String K;

    @ColumnInfo(name = "numOfSongs")
    public int L;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DbOpenHelper.ID)
    public int a;

    @ColumnInfo(name = "type")
    public int b;

    @ColumnInfo(name = "global_id")
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColumnInfo(name = "name")
    public String f397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @ColumnInfo(name = "create_type")
    public int f398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @ColumnInfo(name = "list_id")
    public int f399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @ColumnInfo(name = ActivityChooserModel.ATTRIBUTE_WEIGHT)
    public int f400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @ColumnInfo(name = ClientCookie.VERSION_ATTR)
    public int f401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @ColumnInfo(name = "add_date")
    public long f402i;

    @ColumnInfo(name = "modified_date")
    public long j;

    @ColumnInfo(name = NotificationCompat.CATEGORY_STATUS)
    public int k;

    @ColumnInfo(name = "userAccount")
    public String l;

    @ColumnInfo(name = "list_type")
    public int m;

    @ColumnInfo(name = "list_create_userid")
    public String n;

    @ColumnInfo(name = "list_create_listid")
    public String o;

    @ColumnInfo(name = "list_create_username")
    public String p;

    @ColumnInfo(name = "list_ico")
    public String q;

    @ColumnInfo(name = "list_tags")
    public String r;

    @ColumnInfo(name = "list_intro")
    public String s;

    @ColumnInfo(name = "list_create_version")
    public int t;

    @ColumnInfo(name = "list_create_source")
    public int u;

    @ColumnInfo(name = "list_special_id")
    public int v;

    @ColumnInfo(name = "list_album_id")
    public long w;

    @ColumnInfo(name = "list_create_time")
    public long x;

    @ColumnInfo(name = "list_fav_version")
    public int y;

    @ColumnInfo(name = "download_song_num")
    public int z;

    public j(int i2, int i3, String str, String str2, int i4, int i5, int i6, int i7, long j, long j2, int i8, String str3, int i9, String str4, String str5, String str6, String str7, String str8, String str9, int i10, int i11, int i12, long j3, long j4, int i13, int i14, int i15, String str10, int i16, String str11, String str12, int i17, int i18, int i19, int i20, int i21, String str13, int i22) {
        f.z.d.j.e(str, "globalCollectionId");
        f.z.d.j.e(str2, "name");
        f.z.d.j.e(str3, "userAccount");
        f.z.d.j.e(str4, "listCreateUserid");
        f.z.d.j.e(str5, "listCreateListId");
        f.z.d.j.e(str6, "listCreateUsername");
        f.z.d.j.e(str7, "listIco");
        f.z.d.j.e(str8, "listTags");
        f.z.d.j.e(str9, "listIntro");
        f.z.d.j.e(str10, "list_sync_user_ids");
        f.z.d.j.e(str11, "origin_red_dot");
        f.z.d.j.e(str12, "local_red_dot");
        f.z.d.j.e(str13, "unique_code");
        this.a = i2;
        this.b = i3;
        this.c = str;
        this.f397d = str2;
        this.f398e = i4;
        this.f399f = i5;
        this.f400g = i6;
        this.f401h = i7;
        this.f402i = j;
        this.j = j2;
        this.k = i8;
        this.l = str3;
        this.m = i9;
        this.n = str4;
        this.o = str5;
        this.p = str6;
        this.q = str7;
        this.r = str8;
        this.s = str9;
        this.t = i10;
        this.u = i11;
        this.v = i12;
        this.w = j3;
        this.x = j4;
        this.y = i13;
        this.z = i14;
        this.A = i15;
        this.B = str10;
        this.C = i16;
        this.D = str11;
        this.E = str12;
        this.F = i17;
        this.G = i18;
        this.H = i19;
        this.I = i20;
        this.J = i21;
        this.K = str13;
        this.L = i22;
    }

    public final String A() {
        return this.D;
    }

    public final int B() {
        return this.H;
    }

    public final int C() {
        return this.I;
    }

    public final int D() {
        return this.k;
    }

    public final int E() {
        return this.b;
    }

    public final String F() {
        return this.K;
    }

    public final String G() {
        return this.l;
    }

    public final int H() {
        return this.f401h;
    }

    public final int I() {
        return this.f400g;
    }

    public final int J() {
        return this.J;
    }

    public final int K() {
        return this.F;
    }

    public final int L() {
        return this.G;
    }

    public final void M(int i2) {
        this.o = String.valueOf(i2);
    }

    public final void N(long j) {
        this.n = String.valueOf(j);
    }

    public final void O(String str) {
        f.z.d.j.e(str, "userName");
        this.p = str;
    }

    public final void P(boolean z) {
        this.J = z ? 1 : 0;
    }

    public final void Q(String str) {
        f.z.d.j.e(str, "<set-?>");
        this.c = str;
    }

    public final void R(int i2) {
        this.a = i2;
    }

    public final void S(boolean z) {
    }

    public final void T(String str) {
        f.z.d.j.e(str, "pic");
        this.q = str;
    }

    public final void U(int i2) {
        this.f399f = i2;
    }

    public final void V(String str) {
        f.z.d.j.e(str, "<set-?>");
        this.s = str;
    }

    public final void W(int i2) {
        this.u = i2;
    }

    public final void X(String str) {
        f.z.d.j.e(str, "<set-?>");
        this.r = str;
    }

    public final void Y(int i2) {
        this.m = i2;
    }

    public final void Z(int i2) {
        this.C = i2;
    }

    public final long a() {
        return this.f402i;
    }

    public final void a0(String str) {
        f.z.d.j.e(str, "<set-?>");
        this.f397d = str;
    }

    public final int b() {
        return this.f398e;
    }

    public final void b0(int i2) {
        this.L = i2;
    }

    public final int c() {
        return this.z;
    }

    public final void c0(int i2) {
        this.I = i2;
    }

    public final String d() {
        return this.c;
    }

    public final void d0(int i2) {
        this.b = i2;
    }

    public final int e() {
        return this.a;
    }

    public final void e0(int i2) {
        this.f401h = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.a == jVar.a && this.b == jVar.b && f.z.d.j.a(this.c, jVar.c) && f.z.d.j.a(this.f397d, jVar.f397d) && this.f398e == jVar.f398e && this.f399f == jVar.f399f && this.f400g == jVar.f400g && this.f401h == jVar.f401h && this.f402i == jVar.f402i && this.j == jVar.j && this.k == jVar.k && f.z.d.j.a(this.l, jVar.l) && this.m == jVar.m && f.z.d.j.a(this.n, jVar.n) && f.z.d.j.a(this.o, jVar.o) && f.z.d.j.a(this.p, jVar.p) && f.z.d.j.a(this.q, jVar.q) && f.z.d.j.a(this.r, jVar.r) && f.z.d.j.a(this.s, jVar.s) && this.t == jVar.t && this.u == jVar.u && this.v == jVar.v && this.w == jVar.w && this.x == jVar.x && this.y == jVar.y && this.z == jVar.z && this.A == jVar.A && f.z.d.j.a(this.B, jVar.B) && this.C == jVar.C && f.z.d.j.a(this.D, jVar.D) && f.z.d.j.a(this.E, jVar.E) && this.F == jVar.F && this.G == jVar.G && this.H == jVar.H && this.I == jVar.I && this.J == jVar.J && f.z.d.j.a(this.K, jVar.K) && this.L == jVar.L;
    }

    public final long f() {
        return this.w;
    }

    public final void f0(int i2) {
        this.f400g = i2;
    }

    public final String g() {
        return this.o;
    }

    public final int h() {
        return this.u;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.f397d.hashCode()) * 31) + this.f398e) * 31) + this.f399f) * 31) + this.f400g) * 31) + this.f401h) * 31;
        long j = this.f402i;
        int i2 = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.j;
        int iHashCode2 = (((((((((((((((((((((((((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.k) * 31) + this.l.hashCode()) * 31) + this.m) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + this.p.hashCode()) * 31) + this.q.hashCode()) * 31) + this.r.hashCode()) * 31) + this.s.hashCode()) * 31) + this.t) * 31) + this.u) * 31) + this.v) * 31;
        long j3 = this.w;
        int i3 = (iHashCode2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.x;
        return ((((((((((((((((((((((((((((i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.y) * 31) + this.z) * 31) + this.A) * 31) + this.B.hashCode()) * 31) + this.C) * 31) + this.D.hashCode()) * 31) + this.E.hashCode()) * 31) + this.F) * 31) + this.G) * 31) + this.H) * 31) + this.I) * 31) + this.J) * 31) + this.K.hashCode()) * 31) + this.L;
    }

    public final String i() {
        return this.n;
    }

    public final String j() {
        return this.p;
    }

    public final int k() {
        return this.t;
    }

    public final String l() {
        return this.q;
    }

    public final int m() {
        return this.f399f;
    }

    public final String n() {
        return this.s;
    }

    public final String o() {
        return this.r;
    }

    public final int p() {
        return this.m;
    }

    public final long q() {
        return this.x;
    }

    public final int r() {
        return this.y;
    }

    public final int s() {
        return this.C;
    }

    public final int t() {
        return this.A;
    }

    public String toString() {
        return "Playlist(id=" + this.a + ", type=" + this.b + ", globalCollectionId=" + this.c + ", name=" + this.f397d + ", createType=" + this.f398e + ", listId=" + this.f399f + ", weight=" + this.f400g + ", version=" + this.f401h + ", addData=" + this.f402i + ", modifiedDate=" + this.j + ", status=" + this.k + ", userAccount=" + this.l + ", listType=" + this.m + ", listCreateUserid=" + this.n + ", listCreateListId=" + this.o + ", listCreateUsername=" + this.p + ", listIco=" + this.q + ", listTags=" + this.r + ", listIntro=" + this.s + ", listCreateVersion=" + this.t + ", listCreateSource=" + this.u + ", listspecialId=" + this.v + ", listAlbumId=" + this.w + ", list_create_time=" + this.x + ", list_fav_version=" + this.y + ", download_song_num=" + this.z + ", list_new_sort=" + this.A + ", list_sync_user_ids=" + this.B + ", list_musiclib_id=" + this.C + ", origin_red_dot=" + this.D + ", local_red_dot=" + this.E + ", is_new=" + this.F + ", is_private=" + this.G + ", post_state=" + this.H + ", pub_type=" + this.I + ", is_custom_pic=" + this.J + ", unique_code=" + this.K + ", numOfSongs=" + this.L + ')';
    }

    public final String u() {
        return this.B;
    }

    public final int v() {
        return this.v;
    }

    public final String w() {
        return this.E;
    }

    public final long x() {
        return this.j;
    }

    public final String y() {
        return this.f397d;
    }

    public final int z() {
        return this.L;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ j(int i2, int i3, String str, String str2, int i4, int i5, int i6, int i7, long j, long j2, int i8, String str3, int i9, String str4, String str5, String str6, String str7, String str8, String str9, int i10, int i11, int i12, long j3, long j4, int i13, int i14, int i15, String str10, int i16, String str11, String str12, int i17, int i18, int i19, int i20, int i21, String str13, int i22, int i23, int i24, f.z.d.g gVar) {
        String str14;
        str14 = "";
        this((i23 & 1) != 0 ? 0 : i2, (i23 & 2) != 0 ? 0 : i3, (i23 & 4) != 0 ? "" : str, (i23 & 8) != 0 ? "" : str2, (i23 & 16) != 0 ? 0 : i4, (i23 & 32) != 0 ? 0 : i5, (i23 & 64) != 0 ? 0 : i6, (i23 & 128) != 0 ? 0 : i7, (i23 & 256) != 0 ? 0L : j, (i23 & 512) != 0 ? 0L : j2, (i23 & 1024) != 0 ? 0 : i8, (i23 & 2048) != 0 ? "" : str3, (i23 & 4096) != 0 ? 0 : i9, (i23 & 8192) != 0 ? "" : str4, (i23 & 16384) != 0 ? str14 : str5, (i23 & 32768) != 0 ? str14 : str6, (i23 & 65536) != 0 ? str14 : str7, (i23 & 131072) != 0 ? str14 : str8, (i23 & 262144) != 0 ? str14 : str9, (i23 & 524288) != 0 ? 0 : i10, (i23 & 1048576) != 0 ? 1 : i11, (i23 & 2097152) != 0 ? 0 : i12, (i23 & 4194304) != 0 ? 0L : j3, (i23 & 8388608) != 0 ? 0L : j4, (i23 & 16777216) != 0 ? 0 : i13, (i23 & 33554432) != 0 ? 0 : i14, (i23 & 67108864) != 0 ? -1 : i15, (i23 & 134217728) != 0 ? str14 : str10, (i23 & 268435456) != 0 ? 0 : i16, (i23 & 536870912) != 0 ? str14 : str11, (i23 & BasicMeasure.EXACTLY) != 0 ? str14 : str12, (i23 & Integer.MIN_VALUE) != 0 ? 0 : i17, (i24 & 1) != 0 ? 0 : i18, (i24 & 2) == 0 ? i19 : 1, (i24 & 4) != 0 ? 0 : i20, (i24 & 8) != 0 ? 0 : i21, (i24 & 16) == 0 ? str13 : "", (i24 & 32) != 0 ? 0 : i22);
    }

    @Ignore
    public j() {
        this(0, 0, null, null, 0, 0, 0, 0, 0L, 0L, 0, null, 0, null, null, null, null, null, null, 0, 0, 0, 0L, 0L, 0, 0, 0, null, 0, null, null, 0, 0, 0, 0, 0, null, 0, -3, 63, null);
    }
}
