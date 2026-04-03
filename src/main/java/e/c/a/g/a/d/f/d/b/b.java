package e.c.a.g.a.d.f.d.b;

import androidx.room.Dao;
import androidx.room.Query;

/* JADX INFO: loaded from: classes.dex */
@Dao
public abstract class b extends e.c.a.g.a.d.f.a<a> {
    @Query("DELETE FROM lyric WHERE mix_id=:mixId")
    public abstract void h(long j);

    @Query("DELETE FROM lyric WHERE mix_id=:mixId AND hash=:hash AND display_name=:displayName AND duration=:duration")
    public abstract void i(long j, String str, String str2, long j2);

    @Query("SELECT * FROM lyric WHERE mix_id=:mixId AND hash=:hash AND display_name=:displayName AND duration=:duration")
    public abstract a j(long j, String str, String str2, long j2);
}
