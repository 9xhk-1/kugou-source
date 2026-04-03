package e.c.a.g.a.d.f.c.a;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/* JADX INFO: loaded from: classes.dex */
@Entity(tableName = "history_record")
@i(tableName = "history_record")
public final class d {

    @PrimaryKey
    @ColumnInfo(name = "opTime")
    public long a;

    @ColumnInfo(name = "mixId")
    public long b;

    @ColumnInfo(name = "playCount")
    public long c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColumnInfo(name = "action")
    public long f390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @ColumnInfo(name = "userId")
    public long f391e;

    public d(long j, long j2, long j3, long j4, long j5) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.f390d = j4;
        this.f391e = j5;
    }

    public final long a() {
        return this.f390d;
    }

    public final long b() {
        return this.b;
    }

    public final long c() {
        return this.a;
    }

    public final long d() {
        return this.c;
    }

    public final long e() {
        return this.f391e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && this.b == dVar.b && this.c == dVar.c && this.f390d == dVar.f390d && this.f391e == dVar.f391e;
    }

    public final void f(long j) {
        this.f390d = j;
    }

    public final void g(long j) {
        this.b = j;
    }

    public final void h(long j) {
        this.a = j;
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.b;
        int i2 = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.c;
        int i3 = (i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.f390d;
        int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.f391e;
        return i4 + ((int) (j5 ^ (j5 >>> 32)));
    }

    public final void i(long j) {
        this.c = j;
    }

    public final void j(long j) {
        this.f391e = j;
    }

    public String toString() {
        return "HistoryPlaySong(opTime=" + this.a + ", mixId=" + this.b + ", playCount=" + this.c + ", action=" + this.f390d + ", userId=" + this.f391e + ')';
    }

    public /* synthetic */ d(long j, long j2, long j3, long j4, long j5, int i2, f.z.d.g gVar) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? 0L : j2, (i2 & 4) != 0 ? 0L : j3, (i2 & 8) != 0 ? 0L : j4, (i2 & 16) == 0 ? j5 : 0L);
    }

    @Ignore
    public d() {
        this(0L, 0L, 0L, 0L, 0L, 30, null);
    }
}
