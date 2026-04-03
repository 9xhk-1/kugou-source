package e.c.a.g.a.d.s;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g extends f {
    public final RoomDatabase c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EntityInsertionAdapter<e.c.a.g.a.d.s.d> f543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EntityInsertionAdapter<e.c.a.g.a.d.s.d> f544e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EntityDeletionOrUpdateAdapter<e.c.a.g.a.d.s.d> f545f;

    public class a extends EntityInsertionAdapter<e.c.a.g.a.d.s.d> {
        public a(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, e.c.a.g.a.d.s.d dVar) {
            supportSQLiteStatement.bindLong(1, dVar.d());
            if (dVar.c() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, dVar.c());
            }
            supportSQLiteStatement.bindLong(3, dVar.e());
            supportSQLiteStatement.bindLong(4, dVar.g());
            supportSQLiteStatement.bindLong(5, dVar.f());
            supportSQLiteStatement.bindLong(6, dVar.b());
            supportSQLiteStatement.bindLong(7, dVar.a());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `fee_kubi_buy_info_tab` (`id`,`fileHash`,`mixid`,`userid`,`updateTime`,`createTime`,`albumId`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
        }
    }

    public class b extends EntityInsertionAdapter<e.c.a.g.a.d.s.d> {
        public b(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, e.c.a.g.a.d.s.d dVar) {
            supportSQLiteStatement.bindLong(1, dVar.d());
            if (dVar.c() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, dVar.c());
            }
            supportSQLiteStatement.bindLong(3, dVar.e());
            supportSQLiteStatement.bindLong(4, dVar.g());
            supportSQLiteStatement.bindLong(5, dVar.f());
            supportSQLiteStatement.bindLong(6, dVar.b());
            supportSQLiteStatement.bindLong(7, dVar.a());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR ABORT INTO `fee_kubi_buy_info_tab` (`id`,`fileHash`,`mixid`,`userid`,`updateTime`,`createTime`,`albumId`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
        }
    }

    public class c extends EntityDeletionOrUpdateAdapter<e.c.a.g.a.d.s.d> {
        public c(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, e.c.a.g.a.d.s.d dVar) {
            supportSQLiteStatement.bindLong(1, dVar.d());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `fee_kubi_buy_info_tab` WHERE `id` = ?";
        }
    }

    public class d extends EntityDeletionOrUpdateAdapter<e.c.a.g.a.d.s.d> {
        public d(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, e.c.a.g.a.d.s.d dVar) {
            supportSQLiteStatement.bindLong(1, dVar.d());
            if (dVar.c() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, dVar.c());
            }
            supportSQLiteStatement.bindLong(3, dVar.e());
            supportSQLiteStatement.bindLong(4, dVar.g());
            supportSQLiteStatement.bindLong(5, dVar.f());
            supportSQLiteStatement.bindLong(6, dVar.b());
            supportSQLiteStatement.bindLong(7, dVar.a());
            supportSQLiteStatement.bindLong(8, dVar.d());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `fee_kubi_buy_info_tab` SET `id` = ?,`fileHash` = ?,`mixid` = ?,`userid` = ?,`updateTime` = ?,`createTime` = ?,`albumId` = ? WHERE `id` = ?";
        }
    }

    public g(RoomDatabase roomDatabase) {
        this.c = roomDatabase;
        this.f543d = new a(this, roomDatabase);
        this.f544e = new b(this, roomDatabase);
        new c(this, roomDatabase);
        this.f545f = new d(this, roomDatabase);
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

    @Override // e.c.a.g.a.d.s.f
    public void h(long j, List<Long> list) {
        this.c.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM fee_kubi_buy_info_tab WHERE userid = ");
        sbNewStringBuilder.append("?");
        sbNewStringBuilder.append(" AND albumId IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, list.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.c.compileStatement(sbNewStringBuilder.toString());
        supportSQLiteStatementCompileStatement.bindLong(1, j);
        int i2 = 2;
        for (Long l : list) {
            if (l == null) {
                supportSQLiteStatementCompileStatement.bindNull(i2);
            } else {
                supportSQLiteStatementCompileStatement.bindLong(i2, l.longValue());
            }
            i2++;
        }
        this.c.beginTransaction();
        try {
            supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.c.setTransactionSuccessful();
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // e.c.a.g.a.d.s.f
    public void i(long j, List<Long> list) {
        this.c.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM fee_kubi_buy_info_tab WHERE userid = ");
        sbNewStringBuilder.append("?");
        sbNewStringBuilder.append(" AND mixid IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, list.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.c.compileStatement(sbNewStringBuilder.toString());
        supportSQLiteStatementCompileStatement.bindLong(1, j);
        int i2 = 2;
        for (Long l : list) {
            if (l == null) {
                supportSQLiteStatementCompileStatement.bindNull(i2);
            } else {
                supportSQLiteStatementCompileStatement.bindLong(i2, l.longValue());
            }
            i2++;
        }
        this.c.beginTransaction();
        try {
            supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.c.setTransactionSuccessful();
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // e.c.a.g.a.d.s.f
    public List<e.c.a.g.a.d.s.d> j(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM fee_kubi_buy_info_tab WHERE userid = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileHash");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userid");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updateTime");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createTime");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new e.c.a.g.a.d.s.d(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.getLong(columnIndexOrThrow5), cursorQuery.getLong(columnIndexOrThrow6), cursorQuery.getLong(columnIndexOrThrow7)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // e.c.a.g.a.d.s.f
    public List<e.c.a.g.a.d.s.d> k(List<Long> list, long j) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT ");
        sbNewStringBuilder.append("*");
        sbNewStringBuilder.append(" FROM fee_kubi_buy_info_tab WHERE albumId IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") AND userid = ");
        sbNewStringBuilder.append("?");
        int i2 = 1;
        int i3 = size + 1;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), i3);
        for (Long l : list) {
            if (l == null) {
                roomSQLiteQueryAcquire.bindNull(i2);
            } else {
                roomSQLiteQueryAcquire.bindLong(i2, l.longValue());
            }
            i2++;
        }
        roomSQLiteQueryAcquire.bindLong(i3, j);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileHash");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userid");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updateTime");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createTime");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new e.c.a.g.a.d.s.d(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.getLong(columnIndexOrThrow5), cursorQuery.getLong(columnIndexOrThrow6), cursorQuery.getLong(columnIndexOrThrow7)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // e.c.a.g.a.d.s.f
    public List<e.c.a.g.a.d.s.d> l(long j, List<Long> list) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT ");
        sbNewStringBuilder.append("*");
        sbNewStringBuilder.append(" FROM fee_kubi_buy_info_tab WHERE userid = ");
        sbNewStringBuilder.append("?");
        sbNewStringBuilder.append(" AND mixid IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        int i2 = 2;
        for (Long l : list) {
            if (l == null) {
                roomSQLiteQueryAcquire.bindNull(i2);
            } else {
                roomSQLiteQueryAcquire.bindLong(i2, l.longValue());
            }
            i2++;
        }
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileHash");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userid");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updateTime");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createTime");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new e.c.a.g.a.d.s.d(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.getLong(columnIndexOrThrow5), cursorQuery.getLong(columnIndexOrThrow6), cursorQuery.getLong(columnIndexOrThrow7)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // e.c.a.g.a.d.s.f
    public void m(List<e.c.a.g.a.d.s.d> list) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            this.f544e.insert(list);
            this.c.setTransactionSuccessful();
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // e.c.a.g.a.d.s.f
    public void n(e.c.a.g.a.d.s.d dVar) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            this.f545f.handle(dVar);
            this.c.setTransactionSuccessful();
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // e.c.a.g.a.d.f.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public long f(e.c.a.g.a.d.s.d dVar) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            long jInsertAndReturnId = this.f543d.insertAndReturnId(dVar);
            this.c.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.c.endTransaction();
        }
    }
}
