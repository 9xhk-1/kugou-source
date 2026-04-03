package e.c.a.g.a.d.f.c.a;

import android.database.Cursor;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes.dex */
public final class l extends k {
    public final RoomDatabase c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EntityInsertionAdapter<j> f403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EntityDeletionOrUpdateAdapter<j> f404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedSQLiteStatement f405f;

    public class a extends EntityInsertionAdapter<j> {
        public a(l lVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, j jVar) {
            supportSQLiteStatement.bindLong(1, jVar.e());
            supportSQLiteStatement.bindLong(2, jVar.E());
            if (jVar.d() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, jVar.d());
            }
            if (jVar.y() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, jVar.y());
            }
            supportSQLiteStatement.bindLong(5, jVar.b());
            supportSQLiteStatement.bindLong(6, jVar.m());
            supportSQLiteStatement.bindLong(7, jVar.I());
            supportSQLiteStatement.bindLong(8, jVar.H());
            supportSQLiteStatement.bindLong(9, jVar.a());
            supportSQLiteStatement.bindLong(10, jVar.x());
            supportSQLiteStatement.bindLong(11, jVar.D());
            if (jVar.G() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, jVar.G());
            }
            supportSQLiteStatement.bindLong(13, jVar.p());
            if (jVar.i() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, jVar.i());
            }
            if (jVar.g() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, jVar.g());
            }
            if (jVar.j() == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, jVar.j());
            }
            if (jVar.l() == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, jVar.l());
            }
            if (jVar.o() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, jVar.o());
            }
            if (jVar.n() == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, jVar.n());
            }
            supportSQLiteStatement.bindLong(20, jVar.k());
            supportSQLiteStatement.bindLong(21, jVar.h());
            supportSQLiteStatement.bindLong(22, jVar.v());
            supportSQLiteStatement.bindLong(23, jVar.f());
            supportSQLiteStatement.bindLong(24, jVar.q());
            supportSQLiteStatement.bindLong(25, jVar.r());
            supportSQLiteStatement.bindLong(26, jVar.c());
            supportSQLiteStatement.bindLong(27, jVar.t());
            if (jVar.u() == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, jVar.u());
            }
            supportSQLiteStatement.bindLong(29, jVar.s());
            if (jVar.A() == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, jVar.A());
            }
            if (jVar.w() == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, jVar.w());
            }
            supportSQLiteStatement.bindLong(32, jVar.K());
            supportSQLiteStatement.bindLong(33, jVar.L());
            supportSQLiteStatement.bindLong(34, jVar.B());
            supportSQLiteStatement.bindLong(35, jVar.C());
            supportSQLiteStatement.bindLong(36, jVar.J());
            if (jVar.F() == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindString(37, jVar.F());
            }
            supportSQLiteStatement.bindLong(38, jVar.z());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `kugou_playlists` (`_id`,`type`,`global_id`,`name`,`create_type`,`list_id`,`weight`,`version`,`add_date`,`modified_date`,`status`,`userAccount`,`list_type`,`list_create_userid`,`list_create_listid`,`list_create_username`,`list_ico`,`list_tags`,`list_intro`,`list_create_version`,`list_create_source`,`list_special_id`,`list_album_id`,`list_create_time`,`list_fav_version`,`download_song_num`,`list_new_sort`,`list_sync_user_ids`,`list_musiclib_id`,`origin_red_dot`,`local_red_dot`,`is_new`,`is_private`,`post_state`,`pub_type`,`is_custom_pic`,`unique_code`,`numOfSongs`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public class b extends EntityDeletionOrUpdateAdapter<j> {
        public b(l lVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, j jVar) {
            supportSQLiteStatement.bindLong(1, jVar.e());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `kugou_playlists` WHERE `_id` = ?";
        }
    }

    public class c extends EntityDeletionOrUpdateAdapter<j> {
        public c(l lVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, j jVar) {
            supportSQLiteStatement.bindLong(1, jVar.e());
            supportSQLiteStatement.bindLong(2, jVar.E());
            if (jVar.d() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, jVar.d());
            }
            if (jVar.y() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, jVar.y());
            }
            supportSQLiteStatement.bindLong(5, jVar.b());
            supportSQLiteStatement.bindLong(6, jVar.m());
            supportSQLiteStatement.bindLong(7, jVar.I());
            supportSQLiteStatement.bindLong(8, jVar.H());
            supportSQLiteStatement.bindLong(9, jVar.a());
            supportSQLiteStatement.bindLong(10, jVar.x());
            supportSQLiteStatement.bindLong(11, jVar.D());
            if (jVar.G() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, jVar.G());
            }
            supportSQLiteStatement.bindLong(13, jVar.p());
            if (jVar.i() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, jVar.i());
            }
            if (jVar.g() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, jVar.g());
            }
            if (jVar.j() == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, jVar.j());
            }
            if (jVar.l() == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, jVar.l());
            }
            if (jVar.o() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, jVar.o());
            }
            if (jVar.n() == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, jVar.n());
            }
            supportSQLiteStatement.bindLong(20, jVar.k());
            supportSQLiteStatement.bindLong(21, jVar.h());
            supportSQLiteStatement.bindLong(22, jVar.v());
            supportSQLiteStatement.bindLong(23, jVar.f());
            supportSQLiteStatement.bindLong(24, jVar.q());
            supportSQLiteStatement.bindLong(25, jVar.r());
            supportSQLiteStatement.bindLong(26, jVar.c());
            supportSQLiteStatement.bindLong(27, jVar.t());
            if (jVar.u() == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, jVar.u());
            }
            supportSQLiteStatement.bindLong(29, jVar.s());
            if (jVar.A() == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, jVar.A());
            }
            if (jVar.w() == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, jVar.w());
            }
            supportSQLiteStatement.bindLong(32, jVar.K());
            supportSQLiteStatement.bindLong(33, jVar.L());
            supportSQLiteStatement.bindLong(34, jVar.B());
            supportSQLiteStatement.bindLong(35, jVar.C());
            supportSQLiteStatement.bindLong(36, jVar.J());
            if (jVar.F() == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindString(37, jVar.F());
            }
            supportSQLiteStatement.bindLong(38, jVar.z());
            supportSQLiteStatement.bindLong(39, jVar.e());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `kugou_playlists` SET `_id` = ?,`type` = ?,`global_id` = ?,`name` = ?,`create_type` = ?,`list_id` = ?,`weight` = ?,`version` = ?,`add_date` = ?,`modified_date` = ?,`status` = ?,`userAccount` = ?,`list_type` = ?,`list_create_userid` = ?,`list_create_listid` = ?,`list_create_username` = ?,`list_ico` = ?,`list_tags` = ?,`list_intro` = ?,`list_create_version` = ?,`list_create_source` = ?,`list_special_id` = ?,`list_album_id` = ?,`list_create_time` = ?,`list_fav_version` = ?,`download_song_num` = ?,`list_new_sort` = ?,`list_sync_user_ids` = ?,`list_musiclib_id` = ?,`origin_red_dot` = ?,`local_red_dot` = ?,`is_new` = ?,`is_private` = ?,`post_state` = ?,`pub_type` = ?,`is_custom_pic` = ?,`unique_code` = ?,`numOfSongs` = ? WHERE `_id` = ?";
        }
    }

    public class d extends SharedSQLiteStatement {
        public d(l lVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE kugou_playlists SET weight =? WHERE _id=?";
        }
    }

    public class e extends SharedSQLiteStatement {
        public e(l lVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE kugou_playlists SET version =? WHERE global_id=?";
        }
    }

    public class f extends SharedSQLiteStatement {
        public f(l lVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM kugou_playlists WHERE _id=?";
        }
    }

    public l(RoomDatabase roomDatabase) {
        this.c = roomDatabase;
        this.f403d = new a(this, roomDatabase);
        new b(this, roomDatabase);
        this.f404e = new c(this, roomDatabase);
        new d(this, roomDatabase);
        this.f405f = new e(this, roomDatabase);
        new f(this, roomDatabase);
    }

    @Override // e.c.a.g.a.d.f.a
    public int b(SupportSQLiteQuery supportSQLiteQuery) {
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, supportSQLiteQuery, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.k
    public j h(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM KUGOU_PLAYLISTS WHERE global_id =?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            j jVar = cursorQuery.moveToFirst() ? new j(cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID)), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "type")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "global_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "name")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "create_type")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_id")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT)), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, ClientCookie.VERSION_ATTR)), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "add_date")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "modified_date")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, NotificationCompat.CATEGORY_STATUS)), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "userAccount")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_type")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_create_userid")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_create_listid")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_create_username")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_ico")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_tags")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_intro")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_create_version")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_create_source")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_special_id")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_album_id")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_create_time")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_fav_version")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "download_song_num")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_new_sort")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_sync_user_ids")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_musiclib_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin_red_dot")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "local_red_dot")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_new")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_private")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "post_state")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "pub_type")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_custom_pic")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_code")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "numOfSongs"))) : null;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return jVar;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.k
    public int i(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT list_new_sort FROM kugou_playlists  WHERE global_id =?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.k
    public j j(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM KUGOU_PLAYLISTS WHERE global_id =?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            j jVar = cursorQuery.moveToFirst() ? new j(cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID)), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "type")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "global_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "name")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "create_type")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_id")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT)), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, ClientCookie.VERSION_ATTR)), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "add_date")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "modified_date")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, NotificationCompat.CATEGORY_STATUS)), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "userAccount")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_type")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_create_userid")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_create_listid")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_create_username")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_ico")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_tags")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_intro")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_create_version")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_create_source")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_special_id")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_album_id")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_create_time")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_fav_version")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "download_song_num")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_new_sort")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_sync_user_ids")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_musiclib_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin_red_dot")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "local_red_dot")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_new")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_private")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "post_state")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "pub_type")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_custom_pic")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_code")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "numOfSongs"))) : null;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return jVar;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.k
    public void k(int i2, String str) {
        this.c.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f405f.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str);
        }
        this.c.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.c.setTransactionSuccessful();
        } finally {
            this.c.endTransaction();
            this.f405f.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // e.c.a.g.a.d.f.a
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public long f(j jVar) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            long jInsertAndReturnId = this.f403d.insertAndReturnId(jVar);
            this.c.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // e.c.a.g.a.d.f.a
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public int g(j... jVarArr) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            int iHandleMultiple = this.f404e.handleMultiple(jVarArr) + 0;
            this.c.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.c.endTransaction();
        }
    }
}
