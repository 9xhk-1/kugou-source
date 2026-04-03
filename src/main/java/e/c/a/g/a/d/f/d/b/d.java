package e.c.a.g.a.d.f.d.b;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import e.c.a.g.a.d.f.c.a.i;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
@Entity(tableName = "song_cover")
@i(tableName = "song_cover")
public final class d {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DbOpenHelper.ID)
    public int a;

    @ColumnInfo(name = "hash")
    public final String b;

    @ColumnInfo(name = "display_name")
    public final String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColumnInfo(name = "mix_id")
    public final long f420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @ColumnInfo(name = "add_time")
    public final long f421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @ColumnInfo(name = "url")
    public final String f422f;

    public d(int i2, String str, String str2, long j, long j2, String str3) {
        this.a = i2;
        this.b = str;
        this.c = str2;
        this.f420d = j;
        this.f421e = j2;
        this.f422f = str3;
    }

    public final long a() {
        return this.f421e;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }

    public final int d() {
        return this.a;
    }

    public final long e() {
        return this.f420d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && j.a(this.b, dVar.b) && j.a(this.c, dVar.c) && this.f420d == dVar.f420d && this.f421e == dVar.f421e && j.a(this.f422f, dVar.f422f);
    }

    public final String f() {
        return this.f422f;
    }

    public int hashCode() {
        int i2 = this.a * 31;
        String str = this.b;
        int iHashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode2 = str2 == null ? 0 : str2.hashCode();
        long j = this.f420d;
        int i3 = (((iHashCode + iHashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.f421e;
        int i4 = (i3 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str3 = this.f422f;
        return i4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "SongCover(id=" + this.a + ", hash=" + ((Object) this.b) + ", displayName=" + ((Object) this.c) + ", mixId=" + this.f420d + ", addTime=" + this.f421e + ", url=" + ((Object) this.f422f) + ')';
    }

    public /* synthetic */ d(int i2, String str, String str2, long j, long j2, String str3, int i3, g gVar) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? 0L : j, (i3 & 16) != 0 ? System.currentTimeMillis() : j2, (i3 & 32) == 0 ? str3 : "");
    }

    @Ignore
    public d() {
        this(0, null, null, 0L, 0L, "", 31, null);
    }
}
