package e.c.a.g.a.d.f.c.a;

import androidx.room.Dao;
import androidx.room.Query;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Dao
public abstract class e extends e.c.a.g.a.d.f.a<d> {
    @Query("DELETE FROM history_record WHERE mixId IN (:mixIds) AND userId =:userId")
    public abstract int h(List<Long> list, long j);

    @Query("SELECT * FROM history_record WHERE mixId =:mixId AND userId =:userId")
    public abstract d i(long j, long j2);

    @Query("SELECT * FROM history_record WHERE userId =:userId AND opTime < :opTime ORDER BY opTime DESC LIMIT :pageCount")
    public abstract List<d> j(long j, int i2, long j2);

    @Query("UPDATE history_record SET opTime=:time , playCount = :playCount WHERE mixId =:mixId AND userId =:userId")
    public abstract void k(long j, long j2, long j3, long j4);
}
