package e.c.a.g.a.d.s;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
@Entity(tableName = "fee_kubi_buy_info_tab")
@e.c.a.g.a.d.f.c.a.i(tableName = "fee_kubi_buy_info_tab")
public final class d {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(defaultValue = "0", name = "id")
    public long a;

    @ColumnInfo(name = "fileHash")
    public String b;

    @ColumnInfo(defaultValue = "0", name = "mixid")
    public long c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColumnInfo(defaultValue = "0", name = "userid")
    public long f539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @ColumnInfo(defaultValue = "0", name = "updateTime")
    public long f540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @ColumnInfo(defaultValue = "0", name = "createTime")
    public long f541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @ColumnInfo(defaultValue = "0", name = "albumId")
    public long f542g;

    public d(long j, String str, long j2, long j3, long j4, long j5, long j6) {
        this.a = j;
        this.b = str;
        this.c = j2;
        this.f539d = j3;
        this.f540e = j4;
        this.f541f = j5;
        this.f542g = j6;
    }

    public final long a() {
        return this.f542g;
    }

    public final long b() {
        return this.f541f;
    }

    public final String c() {
        return this.b;
    }

    public final long d() {
        return this.a;
    }

    public final long e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && j.a(this.b, dVar.b) && this.c == dVar.c && this.f539d == dVar.f539d && this.f540e == dVar.f540e && this.f541f == dVar.f541f && this.f542g == dVar.f542g;
    }

    public final long f() {
        return this.f540e;
    }

    public final long g() {
        return this.f539d;
    }

    public final void h(String str) {
        this.b = str;
    }

    public int hashCode() {
        long j = this.a;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.b;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j2 = this.c;
        int i3 = (((i2 + iHashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.f539d;
        int i4 = (i3 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.f540e;
        int i5 = (i4 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.f541f;
        int i6 = (i5 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.f542g;
        return i6 + ((int) (j6 ^ (j6 >>> 32)));
    }

    public final void i(long j) {
        this.f540e = j;
    }

    public String toString() {
        return "FeeKubiBuyInfo(id=" + this.a + ", fileHash=" + ((Object) this.b) + ", mixid=" + this.c + ", userid=" + this.f539d + ", updateTime=" + this.f540e + ", createTime=" + this.f541f + ", albumId=" + this.f542g + ')';
    }

    public /* synthetic */ d(long j, String str, long j2, long j3, long j4, long j5, long j6, int i2, f.z.d.g gVar) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0L : j2, (i2 & 8) != 0 ? 0L : j3, (i2 & 16) != 0 ? 0L : j4, (i2 & 32) != 0 ? 0L : j5, (i2 & 64) == 0 ? j6 : 0L);
    }

    @Ignore
    public d() {
        this(0L, null, 0L, 0L, 0L, 0L, 0L, 126, null);
    }
}
