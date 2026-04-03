package e.c.a.g.a.d.f.c.a;

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
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class p extends o {
    public final RoomDatabase c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EntityInsertionAdapter<q> f411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedSQLiteStatement f413f;

    public class a extends EntityInsertionAdapter<q> {
        public a(p pVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, q qVar) {
            supportSQLiteStatement.bindLong(1, qVar.b());
            supportSQLiteStatement.bindLong(2, qVar.c());
            if (qVar.a() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, qVar.a());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `recent_songs` (`lastPlayTime`,`mixId`,`hash`) VALUES (?,?,?)";
        }
    }

    public class b extends EntityDeletionOrUpdateAdapter<q> {
        public b(p pVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, q qVar) {
            supportSQLiteStatement.bindLong(1, qVar.b());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `recent_songs` WHERE `lastPlayTime` = ?";
        }
    }

    public class c extends EntityDeletionOrUpdateAdapter<q> {
        public c(p pVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, q qVar) {
            supportSQLiteStatement.bindLong(1, qVar.b());
            supportSQLiteStatement.bindLong(2, qVar.c());
            if (qVar.a() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, qVar.a());
            }
            supportSQLiteStatement.bindLong(4, qVar.b());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `recent_songs` SET `lastPlayTime` = ?,`mixId` = ?,`hash` = ? WHERE `lastPlayTime` = ?";
        }
    }

    public class d extends SharedSQLiteStatement {
        public d(p pVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM recent_songs WHERE mixId =?";
        }
    }

    public class e extends SharedSQLiteStatement {
        public e(p pVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE recent_songs SET lastPlayTime=? WHERE mixId =?";
        }
    }

    public class f extends SharedSQLiteStatement {
        public f(p pVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM recent_songs WHERE hash = ? AND mixId <= 0";
        }
    }

    public p(RoomDatabase roomDatabase) {
        this.c = roomDatabase;
        this.f411d = new a(this, roomDatabase);
        new b(this, roomDatabase);
        new c(this, roomDatabase);
        this.f412e = new d(this, roomDatabase);
        this.f413f = new e(this, roomDatabase);
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

    @Override // e.c.a.g.a.d.f.a
    public List<Long> e(List<? extends q> list) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.f411d.insertAndReturnIdsList(list);
            this.c.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.o
    public void h(long j) {
        this.c.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f412e.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j);
        this.c.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.c.setTransactionSuccessful();
        } finally {
            this.c.endTransaction();
            this.f412e.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.o
    public q i(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM recent_songs WHERE hash = ? AND mixId <= 0", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? new q(cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastPlayTime")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixId")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash"))) : null;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.o
    public q j(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM recent_songs WHERE mixId =?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? new q(cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastPlayTime")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixId")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash"))) : null;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.o
    public int k() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM recent_songs WHERE mixId > 0", 0);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.o
    public List<q> l(long j, int i2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM recent_songs WHERE lastPlayTime < ? ORDER BY lastPlayTime DESC LIMIT ?", 2);
        roomSQLiteQueryAcquire.bindLong(1, j);
        roomSQLiteQueryAcquire.bindLong(2, i2);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastPlayTime");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new q(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getLong(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.o
    public void m(long j, long j2) {
        this.c.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f413f.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j2);
        supportSQLiteStatementAcquire.bindLong(2, j);
        this.c.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.c.setTransactionSuccessful();
        } finally {
            this.c.endTransaction();
            this.f413f.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // e.c.a.g.a.d.f.a
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public long f(q qVar) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            long jInsertAndReturnId = this.f411d.insertAndReturnId(qVar);
            this.c.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.c.endTransaction();
        }
    }
}
