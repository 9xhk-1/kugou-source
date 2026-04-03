package e.c.a.g.a.d.f.c.a;

import androidx.room.Dao;
import androidx.room.Query;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Dao
public abstract class b extends e.c.a.g.a.d.f.a<a> {
    @Query("DELETE FROM downloadtask WHERE _id=:uniqueId")
    public abstract void h(int i2);

    @Query("SELECT * FROM downloadtask WHERE mix_id > 0 order by _id DESC")
    public abstract List<a> i();

    @Query("SELECT COUNT(*) FROM downloadtask WHERE mix_id > 0")
    public abstract int j();

    @Query("SELECT * FROM downloadtask WHERE _id=:uniqueId")
    public abstract a k(int i2);

    @Query("SELECT * FROM downloadtask WHERE downloadkey=:key")
    public abstract a l(String str);

    @Query("SELECT * FROM downloadtask WHERE _id <= :lastId order by _id DESC LIMIT :pageCount")
    public abstract List<a> m(int i2, int i3);

    @Query("SELECT * FROM downloadtask order by _id DESC LIMIT 1")
    public abstract a n();
}
