package e.c.a.g.a.d.f.c.a;

import android.database.Cursor;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Dao
public abstract class g extends e.c.a.g.a.d.f.a<KGMusic> {
    @Query("DELETE FROM kugou_songs WHERE globalCollectionId =:globalCollectionId")
    public abstract void h(String str);

    @Query("SELECT _id, hashValue FROM kugou_songs WHERE hashValue in (:hashGroup)")
    public abstract Cursor i(List<String> list);

    @Query("SELECT _id,hashValue FROM kugou_songs WHERE hashValue in (:hashGroup) AND mixId <= 0 GROUP BY hashValue")
    public abstract Cursor j(List<String> list);

    @Query("SELECT _id FROM kugou_songs WHERE mixId in (:mixIds) GROUP BY mixId")
    public abstract Cursor k(List<Long> list);

    @Query("SELECT _id,mixId FROM kugou_songs WHERE mixId in (:mixIds) GROUP BY mixId")
    public abstract Cursor l(List<Long> list);

    @Query("SELECT * FROM kugou_songs WHERE hashValue =UPPER(:hash)")
    public abstract KGMusic m(String str);

    @Query("SELECT * FROM kugou_songs WHERE hashValue = UPPER(:musicHash) AND mixId =:mixId")
    public abstract KGMusic n(long j, String str);

    @Query("SELECT * FROM kugou_songs WHERE mixId =:mixId")
    public abstract KGMusic o(long j);

    @Query("SELECT * FROM kugou_songs WHERE hashValue in (:hashList)")
    public abstract List<KGMusic> p(List<String> list);

    @Query("SELECT * FROM kugou_songs WHERE mixId in (:mixIds)")
    public abstract List<KGMusic> q(List<Long> list);

    @Query("SELECT * FROM kugou_songs WHERE hashValue in (:hasGroup) OR m4aHash in (:hasGroup) OR hash320 in (:hasGroup) OR sqHash in (:hasGroup)")
    public abstract List<KGMusic> r(List<String> list);

    @Update
    public abstract int s(List<? extends KGMusic> list);
}
