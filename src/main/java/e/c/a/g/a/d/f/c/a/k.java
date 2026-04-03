package e.c.a.g.a.d.f.c.a;

import androidx.room.Dao;
import androidx.room.Query;

/* JADX INFO: loaded from: classes.dex */
@Dao
public abstract class k extends e.c.a.g.a.d.f.a<j> {
    @Query("SELECT * FROM KUGOU_PLAYLISTS WHERE global_id =:global_id")
    public abstract j h(String str);

    @Query("SELECT list_new_sort FROM kugou_playlists  WHERE global_id =:id")
    public abstract int i(String str);

    @Query("SELECT * FROM KUGOU_PLAYLISTS WHERE global_id =:globalId")
    public abstract j j(String str);

    @Query("UPDATE kugou_playlists SET version =:version WHERE global_id=:pid")
    public abstract void k(int i2, String str);
}
