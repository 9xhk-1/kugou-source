package e.c.a.g.a.d.f.c.a;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/* JADX INFO: loaded from: classes.dex */
@Entity(tableName = "recent_songs")
@i(tableName = "recent_songs")
public final class q {

    @PrimaryKey
    @ColumnInfo(name = "lastPlayTime")
    public long a;

    @ColumnInfo(name = "mixId")
    public long b;

    @ColumnInfo(name = "hash")
    public String c;

    public q(long j, long j2, String str) {
        f.z.d.j.e(str, "hash");
        this.a = j;
        this.b = j2;
        this.c = str;
    }

    public final String a() {
        return this.c;
    }

    public final long b() {
        return this.a;
    }

    public final long c() {
        return this.b;
    }

    public final void d(String str) {
        f.z.d.j.e(str, "<set-?>");
        this.c = str;
    }

    public final void e(long j) {
        this.a = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.a == qVar.a && this.b == qVar.b && f.z.d.j.a(this.c, qVar.c);
    }

    public final void f(long j) {
        this.b = j;
    }

    public int hashCode() {
        long j = this.a;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.b;
        return ((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "RecentPlaySong(lastPlayTime=" + this.a + ", mixId=" + this.b + ", hash=" + this.c + ')';
    }

    public /* synthetic */ q(long j, long j2, String str, int i2, f.z.d.g gVar) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) == 0 ? j2 : 0L, (i2 & 4) != 0 ? "" : str);
    }

    @Ignore
    public q() {
        this(0L, 0L, null, 6, null);
    }
}
