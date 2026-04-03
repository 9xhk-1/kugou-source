package e.c.a.g.a.d.s;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Dao
public abstract class f extends e.c.a.g.a.d.f.a<d> {
    @Query("DELETE FROM fee_kubi_buy_info_tab WHERE userid = :userId AND albumId IN (:albumIds)")
    public abstract void h(long j, List<Long> list);

    @Query("DELETE FROM fee_kubi_buy_info_tab WHERE userid = :userId AND mixid IN (:mixIds)")
    public abstract void i(long j, List<Long> list);

    @Query("SELECT * FROM fee_kubi_buy_info_tab WHERE userid = :userId")
    public abstract List<d> j(long j);

    @Query("SELECT * FROM fee_kubi_buy_info_tab WHERE albumId IN (:albumIds) AND userid = :userId")
    public abstract List<d> k(List<Long> list, long j);

    @Query("SELECT * FROM fee_kubi_buy_info_tab WHERE userid = :userId AND mixid IN (:mixIds)")
    public abstract List<d> l(long j, List<Long> list);

    @Insert
    public abstract void m(List<d> list);

    @Update
    public abstract void n(d dVar);
}
