package e.c.a.g.a.d.f.d.b;

import androidx.room.Dao;
import androidx.room.Query;

/* JADX INFO: loaded from: classes.dex */
@Dao
public abstract class e extends e.c.a.g.a.d.f.a<d> {
    @Query("DELETE FROM song_cover WHERE mix_id=:mixId AND hash=:hash AND display_name=:displayName")
    public abstract void h(long j, String str, String str2);

    @Query("SELECT * FROM song_cover WHERE mix_id=:mixId AND hash=:hash AND display_name=:displayName")
    public abstract d i(long j, String str, String str2);
}
