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
public final class c extends e.c.a.g.a.d.f.d.b.b {
    public final RoomDatabase c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EntityInsertionAdapter<e.c.a.g.a.d.f.d.b.a> f417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedSQLiteStatement f419f;

    public class a extends EntityInsertionAdapter<e.c.a.g.a.d.f.d.b.a> {
        public a(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, e.c.a.g.a.d.f.d.b.a aVar) {
            supportSQLiteStatement.bindLong(1, aVar.e());
            if (aVar.d() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, aVar.d());
            }
            if (aVar.a() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, aVar.a());
            }
            supportSQLiteStatement.bindLong(4, aVar.f());
            supportSQLiteStatement.bindLong(5, aVar.b());
            if (aVar.c() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, aVar.c());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `lyric` (`_id`,`hash`,`display_name`,`mix_id`,`duration`,`file_path`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }
    }

    public class b extends EntityDeletionOrUpdateAdapter<e.c.a.g.a.d.f.d.b.a> {
        public b(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, e.c.a.g.a.d.f.d.b.a aVar) {
            supportSQLiteStatement.bindLong(1, aVar.e());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `lyric` WHERE `_id` = ?";
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.f.d.b.c$c, reason: collision with other inner class name */
    public class C0050c extends EntityDeletionOrUpdateAdapter<e.c.a.g.a.d.f.d.b.a> {
        public C0050c(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, e.c.a.g.a.d.f.d.b.a aVar) {
            supportSQLiteStatement.bindLong(1, aVar.e());
            if (aVar.d() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, aVar.d());
            }
            if (aVar.a() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, aVar.a());
            }
            supportSQLiteStatement.bindLong(4, aVar.f());
            supportSQLiteStatement.bindLong(5, aVar.b());
            if (aVar.c() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, aVar.c());
            }
            supportSQLiteStatement.bindLong(7, aVar.e());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `lyric` SET `_id` = ?,`hash` = ?,`display_name` = ?,`mix_id` = ?,`duration` = ?,`file_path` = ? WHERE `_id` = ?";
        }
    }

    public class d extends SharedSQLiteStatement {
        public d(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM lyric WHERE mix_id=? AND hash=? AND display_name=? AND duration=?";
        }
    }

    public class e extends SharedSQLiteStatement {
        public e(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM lyric WHERE mix_id=?";
        }
    }

    public c(RoomDatabase roomDatabase) {
        this.c = roomDatabase;
        this.f417d = new a(this, roomDatabase);
        new b(this, roomDatabase);
        new C0050c(this, roomDatabase);
        this.f418e = new d(this, roomDatabase);
        this.f419f = new e(this, roomDatabase);
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

    @Override // e.c.a.g.a.d.f.d.b.b
    public void h(long j) {
        this.c.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f419f.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j);
        this.c.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.c.setTransactionSuccessful();
        } finally {
            this.c.endTransaction();
            this.f419f.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // e.c.a.g.a.d.f.d.b.b
    public void i(long j, String str, String str2, long j2) {
        this.c.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f418e.acquire();
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
        supportSQLiteStatementAcquire.bindLong(4, j2);
        this.c.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.c.setTransactionSuccessful();
        } finally {
            this.c.endTransaction();
            this.f418e.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // e.c.a.g.a.d.f.d.b.b
    public e.c.a.g.a.d.f.d.b.a j(long j, String str, String str2, long j2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM lyric WHERE mix_id=? AND hash=? AND display_name=? AND duration=?", 4);
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
        roomSQLiteQueryAcquire.bindLong(4, j2);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? new e.c.a.g.a.d.f.d.b.a(cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID)), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_name")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "mix_id")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "duration")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "file_path"))) : null;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // e.c.a.g.a.d.f.a
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public long f(e.c.a.g.a.d.f.d.b.a aVar) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            long jInsertAndReturnId = this.f417d.insertAndReturnId(aVar);
            this.c.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.c.endTransaction();
        }
    }
}
