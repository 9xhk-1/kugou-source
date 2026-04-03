package e.c.a.g.a.d.f.c.a;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f extends e {
    public final RoomDatabase c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EntityInsertionAdapter<e.c.a.g.a.d.f.c.a.d> f392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f393e;

    public class a extends EntityInsertionAdapter<e.c.a.g.a.d.f.c.a.d> {
        public a(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, e.c.a.g.a.d.f.c.a.d dVar) {
            supportSQLiteStatement.bindLong(1, dVar.c());
            supportSQLiteStatement.bindLong(2, dVar.b());
            supportSQLiteStatement.bindLong(3, dVar.d());
            supportSQLiteStatement.bindLong(4, dVar.a());
            supportSQLiteStatement.bindLong(5, dVar.e());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `history_record` (`opTime`,`mixId`,`playCount`,`action`,`userId`) VALUES (?,?,?,?,?)";
        }
    }

    public class b extends EntityDeletionOrUpdateAdapter<e.c.a.g.a.d.f.c.a.d> {
        public b(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, e.c.a.g.a.d.f.c.a.d dVar) {
            supportSQLiteStatement.bindLong(1, dVar.c());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `history_record` WHERE `opTime` = ?";
        }
    }

    public class c extends EntityDeletionOrUpdateAdapter<e.c.a.g.a.d.f.c.a.d> {
        public c(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, e.c.a.g.a.d.f.c.a.d dVar) {
            supportSQLiteStatement.bindLong(1, dVar.c());
            supportSQLiteStatement.bindLong(2, dVar.b());
            supportSQLiteStatement.bindLong(3, dVar.d());
            supportSQLiteStatement.bindLong(4, dVar.a());
            supportSQLiteStatement.bindLong(5, dVar.e());
            supportSQLiteStatement.bindLong(6, dVar.c());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `history_record` SET `opTime` = ?,`mixId` = ?,`playCount` = ?,`action` = ?,`userId` = ? WHERE `opTime` = ?";
        }
    }

    public class d extends SharedSQLiteStatement {
        public d(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE history_record SET opTime=? , playCount = ? WHERE mixId =? AND userId =?";
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.c = roomDatabase;
        this.f392d = new a(this, roomDatabase);
        new b(this, roomDatabase);
        new c(this, roomDatabase);
        this.f393e = new d(this, roomDatabase);
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

    @Override // e.c.a.g.a.d.f.c.a.e
    public int h(List<Long> list, long j) {
        this.c.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM history_record WHERE mixId IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") AND userId =");
        sbNewStringBuilder.append("?");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.c.compileStatement(sbNewStringBuilder.toString());
        int i2 = 1;
        for (Long l : list) {
            if (l == null) {
                supportSQLiteStatementCompileStatement.bindNull(i2);
            } else {
                supportSQLiteStatementCompileStatement.bindLong(i2, l.longValue());
            }
            i2++;
        }
        supportSQLiteStatementCompileStatement.bindLong(size + 1, j);
        this.c.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.c.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.e
    public e.c.a.g.a.d.f.c.a.d i(long j, long j2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM history_record WHERE mixId =? AND userId =?", 2);
        roomSQLiteQueryAcquire.bindLong(1, j);
        roomSQLiteQueryAcquire.bindLong(2, j2);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? new e.c.a.g.a.d.f.c.a.d(cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "opTime")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixId")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "playCount")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "action")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "userId"))) : null;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.e
    public List<e.c.a.g.a.d.f.c.a.d> j(long j, int i2, long j2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM history_record WHERE userId =? AND opTime < ? ORDER BY opTime DESC LIMIT ?", 3);
        roomSQLiteQueryAcquire.bindLong(1, j2);
        roomSQLiteQueryAcquire.bindLong(2, j);
        roomSQLiteQueryAcquire.bindLong(3, i2);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "opTime");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playCount");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "action");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userId");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new e.c.a.g.a.d.f.c.a.d(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getLong(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.getLong(columnIndexOrThrow5)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.e
    public void k(long j, long j2, long j3, long j4) {
        this.c.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f393e.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j2);
        supportSQLiteStatementAcquire.bindLong(2, j3);
        supportSQLiteStatementAcquire.bindLong(3, j);
        supportSQLiteStatementAcquire.bindLong(4, j4);
        this.c.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.c.setTransactionSuccessful();
        } finally {
            this.c.endTransaction();
            this.f393e.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // e.c.a.g.a.d.f.a
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public long f(e.c.a.g.a.d.f.c.a.d dVar) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            long jInsertAndReturnId = this.f392d.insertAndReturnId(dVar);
            this.c.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.c.endTransaction();
        }
    }
}
