package e.c.a.g.a.d.f.c.a;

import androidx.room.Dao;
import androidx.room.Query;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Dao
public abstract class o extends e.c.a.g.a.d.f.a<q> {
    @Query("DELETE FROM recent_songs WHERE mixId =:mixId")
    public abstract void h(long j);

    @Query("SELECT * FROM recent_songs WHERE hash = :hash AND mixId <= 0")
    public abstract q i(String str);

    @Query("SELECT * FROM recent_songs WHERE mixId =:mixId")
    public abstract q j(long j);

    @Query("SELECT COUNT(*) FROM recent_songs WHERE mixId > 0")
    public abstract int k();

    @Query("SELECT * FROM recent_songs WHERE lastPlayTime < :lastPlayTime ORDER BY lastPlayTime DESC LIMIT :pageCount")
    public abstract List<q> l(long j, int i2);

    @Query("UPDATE recent_songs SET lastPlayTime=:time WHERE mixId =:mixId")
    public abstract void m(long j, long j2);
}
