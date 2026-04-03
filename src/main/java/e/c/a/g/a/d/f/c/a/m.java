package e.c.a.g.a.d.f.c.a;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.kugou.android.watch.lite.component.playlist.entity.KGPlaylistMusic;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Dao
public abstract class m extends e.c.a.g.a.d.f.a<KGPlaylistMusic> {
    @Query("DELETE  FROM playlistsong WHERE global_id =:globalId")
    public abstract void h(String str);

    @Query("SELECT COUNT(*) FROM playlistsong  WHERE global_id =:id")
    public abstract int i(String str);

    @Query("SELECT COUNT(*) FROM playlistsong  WHERE global_id =:id AND mixId not in (:filterMixs) ")
    public abstract int j(String str, List<Long> list);

    @Query("SELECT fileOrderWeight FROM playlistsong WHERE global_id =:globalId AND mixId =:mixId")
    public abstract int k(String str, long j);

    @Query("SELECT fileOrderWeight FROM playlistsong WHERE global_id =:globalId AND mMusicId =:musicId AND mixId <= 0")
    public abstract int l(String str, long j);

    @Query("SELECT MAX(fileOrderWeight) FROM playlistsong WHERE global_id =:globalId")
    public abstract int m(String str);

    @Query("SELECT MIN(fileOrderWeight) FROM playlistsong WHERE global_id =:globalId")
    public abstract int n(String str);

    @Query("SELECT * FROM playlistsong WHERE global_id =:globalId")
    public abstract List<KGPlaylistMusic> o(String str);

    @Query("SELECT * FROM playlistsong WHERE global_id =:globalId AND mixId =:mixId")
    public abstract KGPlaylistMusic p(String str, long j);

    @Query("SELECT * FROM playlistsong WHERE global_id =:globalId AND hash =:hashValue")
    public abstract KGPlaylistMusic q(String str, String str2);

    @Query("SELECT * FROM playlistsong WHERE global_id =:globalId order by playlistsong.fileOrderWeight ASC")
    public abstract List<KGPlaylistMusic> r(String str);

    @Query("SELECT * FROM playlistsong WHERE global_id =:globalId AND fileOrderWeight >= :start order by fileOrderWeight ASC LIMIT :pageCount")
    public abstract List<KGPlaylistMusic> s(String str, int i2, int i3);

    @Insert
    public abstract long t(KGPlaylistMusic kGPlaylistMusic);

    @Query("DELETE FROM playlistsong WHERE global_id=:globalId AND (mixId IN (:mixIds) OR hash IN (:hashGroup))")
    public abstract int u(String str, List<Long> list, List<String> list2);

    @Query("DELETE FROM playlistsong WHERE global_id=:globalId AND isLocal < 1")
    public abstract int v(String str);

    @Query("DELETE FROM playlistsong WHERE global_id=:globalId AND hash in (:hashs)")
    public abstract void w(String str, List<String> list);

    @Query("DELETE FROM playlistsong WHERE global_id=:globalId AND mixId in (:mixIds)")
    public abstract void x(String str, List<Long> list);

    @Query("DELETE FROM playlistsong WHERE global_id=:globalId AND mixId IN (:mixIds) OR mixId < 0 AND mMusicId IN (:musicIds)")
    public abstract int y(String str, List<Long> list, List<Long> list2);

    @Update
    public abstract int z(List<KGPlaylistMusic> list);
}
