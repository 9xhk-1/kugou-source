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
@Entity(tableName = "lyric")
@i(tableName = "lyric")
public final class a {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DbOpenHelper.ID)
    public int a;

    @ColumnInfo(name = "hash")
    public final String b;

    @ColumnInfo(name = "display_name")
    public final String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColumnInfo(name = "mix_id")
    public final long f414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @ColumnInfo(name = "duration")
    public final long f415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @ColumnInfo(name = "file_path")
    public final String f416f;

    public a(int i2, String str, String str2, long j, long j2, String str3) {
        this.a = i2;
        this.b = str;
        this.c = str2;
        this.f414d = j;
        this.f415e = j2;
        this.f416f = str3;
    }

    public final String a() {
        return this.c;
    }

    public final long b() {
        return this.f415e;
    }

    public final String c() {
        return this.f416f;
    }

    public final String d() {
        return this.b;
    }

    public final int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && j.a(this.b, aVar.b) && j.a(this.c, aVar.c) && this.f414d == aVar.f414d && this.f415e == aVar.f415e && j.a(this.f416f, aVar.f416f);
    }

    public final long f() {
        return this.f414d;
    }

    public int hashCode() {
        int i2 = this.a * 31;
        String str = this.b;
        int iHashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode2 = str2 == null ? 0 : str2.hashCode();
        long j = this.f414d;
        int i3 = (((iHashCode + iHashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.f415e;
        int i4 = (i3 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str3 = this.f416f;
        return i4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "Lyric(id=" + this.a + ", hash=" + ((Object) this.b) + ", displayName=" + ((Object) this.c) + ", mixId=" + this.f414d + ", duration=" + this.f415e + ", filePath=" + ((Object) this.f416f) + ')';
    }

    public /* synthetic */ a(int i2, String str, String str2, long j, long j2, String str3, int i3, g gVar) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? 0L : j, (i3 & 16) == 0 ? j2 : 0L, (i3 & 32) == 0 ? str3 : "");
    }

    @Ignore
    public a() {
        this(0, null, null, 0L, 0L, "", 31, null);
    }
}
