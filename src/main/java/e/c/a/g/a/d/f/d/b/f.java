package e.c.a.g.a.d.f.d.b;

import android.database.Cursor;
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

/* JADX INFO: loaded from: classes.dex */
public final class f extends e {
    public final RoomDatabase c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EntityInsertionAdapter<e.c.a.g.a.d.f.d.b.d> f423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f424e;

    public class a extends EntityInsertionAdapter<e.c.a.g.a.d.f.d.b.d> {
        public a(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, e.c.a.g.a.d.f.d.b.d dVar) {
            supportSQLiteStatement.bindLong(1, dVar.d());
            if (dVar.c() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, dVar.c());
            }
            if (dVar.b() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, dVar.b());
            }
            supportSQLiteStatement.bindLong(4, dVar.e());
            supportSQLiteStatement.bindLong(5, dVar.a());
            if (dVar.f() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, dVar.f());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `song_cover` (`_id`,`hash`,`display_name`,`mix_id`,`add_time`,`url`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }
    }

    public class b extends EntityDeletionOrUpdateAdapter<e.c.a.g.a.d.f.d.b.d> {
        public b(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, e.c.a.g.a.d.f.d.b.d dVar) {
            supportSQLiteStatement.bindLong(1, dVar.d());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `song_cover` WHERE `_id` = ?";
        }
    }

    public class c extends EntityDeletionOrUpdateAdapter<e.c.a.g.a.d.f.d.b.d> {
        public c(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, e.c.a.g.a.d.f.d.b.d dVar) {
            supportSQLiteStatement.bindLong(1, dVar.d());
            if (dVar.c() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, dVar.c());
            }
            if (dVar.b() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, dVar.b());
            }
            supportSQLiteStatement.bindLong(4, dVar.e());
            supportSQLiteStatement.bindLong(5, dVar.a());
            if (dVar.f() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, dVar.f());
            }
            supportSQLiteStatement.bindLong(7, dVar.d());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `song_cover` SET `_id` = ?,`hash` = ?,`display_name` = ?,`mix_id` = ?,`add_time` = ?,`url` = ? WHERE `_id` = ?";
        }
    }

    public class d extends SharedSQLiteStatement {
        public d(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM song_cover WHERE mix_id=? AND hash=? AND display_name=?";
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.c = roomDatabase;
        this.f423d = new a(this, roomDatabase);
        new b(this, roomDatabase);
        new c(this, roomDatabase);
        this.f424e = new d(this, roomDatabase);
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

    @Override // e.c.a.g.a.d.f.d.b.e
    public void h(long j, String str, String str2) {
        this.c.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f424e.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str);
        }
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, str2);
        }
        this.c.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.c.setTransactionSuccessful();
        } finally {
            this.c.endTransaction();
            this.f424e.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // e.c.a.g.a.d.f.d.b.e
    public e.c.a.g.a.d.f.d.b.d i(long j, String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song_cover WHERE mix_id=? AND hash=? AND display_name=?", 3);
        roomSQLiteQueryAcquire.bindLong(1, j);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, str2);
        }
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? new e.c.a.g.a.d.f.d.b.d(cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID)), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_name")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "mix_id")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "add_time")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "url"))) : null;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // e.c.a.g.a.d.f.a
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public long f(e.c.a.g.a.d.f.d.b.d dVar) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            long jInsertAndReturnId = this.f423d.insertAndReturnId(dVar);
            this.c.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.c.endTransaction();
        }
    }
}
