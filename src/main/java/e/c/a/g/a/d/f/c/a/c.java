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
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c extends e.c.a.g.a.d.f.c.a.b {
    public final RoomDatabase c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EntityInsertionAdapter<e.c.a.g.a.d.f.c.a.a> f388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f389e;

    public class a extends EntityInsertionAdapter<e.c.a.g.a.d.f.c.a.a> {
        public a(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, e.c.a.g.a.d.f.c.a.a aVar) {
            supportSQLiteStatement.bindLong(1, aVar.m());
            supportSQLiteStatement.bindLong(2, aVar.e());
            supportSQLiteStatement.bindLong(3, aVar.k());
            supportSQLiteStatement.bindLong(4, aVar.f());
            supportSQLiteStatement.bindLong(5, aVar.b());
            if (aVar.c() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, aVar.c());
            }
            supportSQLiteStatement.bindLong(7, aVar.q());
            supportSQLiteStatement.bindLong(8, aVar.d());
            supportSQLiteStatement.bindLong(9, aVar.a());
            supportSQLiteStatement.bindLong(10, aVar.r());
            supportSQLiteStatement.bindLong(11, aVar.j());
            supportSQLiteStatement.bindLong(12, aVar.n());
            if (aVar.p() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, aVar.p());
            }
            supportSQLiteStatement.bindLong(14, aVar.t());
            supportSQLiteStatement.bindLong(15, aVar.v());
            supportSQLiteStatement.bindLong(16, aVar.l());
            supportSQLiteStatement.bindLong(17, aVar.g());
            if (aVar.h() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, aVar.h());
            }
            supportSQLiteStatement.bindLong(19, aVar.o());
            if (aVar.s() == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, aVar.s());
            }
            if (aVar.i() == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, aVar.i());
            }
            if (aVar.u() == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, aVar.u());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `downloadtask` (`_id`,`downloadsize`,`filesize`,`downloadstate`,`download_error_code`,`downloadkey`,`quality`,`downloadmode`,`addtime`,`songid`,`fileid`,`iscover`,`module`,`statuscode`,`uploadstate`,`filetype`,`downloadtype`,`fee_album_id`,`mix_id`,`source_hash`,`file_path`,`tmp_cache_path`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public class b extends EntityDeletionOrUpdateAdapter<e.c.a.g.a.d.f.c.a.a> {
        public b(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, e.c.a.g.a.d.f.c.a.a aVar) {
            supportSQLiteStatement.bindLong(1, aVar.m());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `downloadtask` WHERE `_id` = ?";
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.f.c.a.c$c, reason: collision with other inner class name */
    public class C0049c extends EntityDeletionOrUpdateAdapter<e.c.a.g.a.d.f.c.a.a> {
        public C0049c(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, e.c.a.g.a.d.f.c.a.a aVar) {
            supportSQLiteStatement.bindLong(1, aVar.m());
            supportSQLiteStatement.bindLong(2, aVar.e());
            supportSQLiteStatement.bindLong(3, aVar.k());
            supportSQLiteStatement.bindLong(4, aVar.f());
            supportSQLiteStatement.bindLong(5, aVar.b());
            if (aVar.c() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, aVar.c());
            }
            supportSQLiteStatement.bindLong(7, aVar.q());
            supportSQLiteStatement.bindLong(8, aVar.d());
            supportSQLiteStatement.bindLong(9, aVar.a());
            supportSQLiteStatement.bindLong(10, aVar.r());
            supportSQLiteStatement.bindLong(11, aVar.j());
            supportSQLiteStatement.bindLong(12, aVar.n());
            if (aVar.p() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, aVar.p());
            }
            supportSQLiteStatement.bindLong(14, aVar.t());
            supportSQLiteStatement.bindLong(15, aVar.v());
            supportSQLiteStatement.bindLong(16, aVar.l());
            supportSQLiteStatement.bindLong(17, aVar.g());
            if (aVar.h() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, aVar.h());
            }
            supportSQLiteStatement.bindLong(19, aVar.o());
            if (aVar.s() == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, aVar.s());
            }
            if (aVar.i() == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, aVar.i());
            }
            if (aVar.u() == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, aVar.u());
            }
            supportSQLiteStatement.bindLong(23, aVar.m());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `downloadtask` SET `_id` = ?,`downloadsize` = ?,`filesize` = ?,`downloadstate` = ?,`download_error_code` = ?,`downloadkey` = ?,`quality` = ?,`downloadmode` = ?,`addtime` = ?,`songid` = ?,`fileid` = ?,`iscover` = ?,`module` = ?,`statuscode` = ?,`uploadstate` = ?,`filetype` = ?,`downloadtype` = ?,`fee_album_id` = ?,`mix_id` = ?,`source_hash` = ?,`file_path` = ?,`tmp_cache_path` = ? WHERE `_id` = ?";
        }
    }

    public class d extends SharedSQLiteStatement {
        public d(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM downloadtask WHERE downloadkey=?";
        }
    }

    public class e extends SharedSQLiteStatement {
        public e(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM downloadtask WHERE _id=?";
        }
    }

    public c(RoomDatabase roomDatabase) {
        this.c = roomDatabase;
        this.f388d = new a(this, roomDatabase);
        new b(this, roomDatabase);
        new C0049c(this, roomDatabase);
        new d(this, roomDatabase);
        this.f389e = new e(this, roomDatabase);
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
    public List<Long> e(List<? extends e.c.a.g.a.d.f.c.a.a> list) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.f388d.insertAndReturnIdsList(list);
            this.c.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.b
    public void h(int i2) {
        this.c.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f389e.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        this.c.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.c.setTransactionSuccessful();
        } finally {
            this.c.endTransaction();
            this.f389e.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.b
    public List<e.c.a.g.a.d.f.c.a.a> i() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM downloadtask WHERE mix_id > 0 order by _id DESC", 0);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadsize");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filesize");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadstate");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "download_error_code");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadkey");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "quality");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadmode");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "addtime");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songid");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileid");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "iscover");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "module");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "statuscode");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "uploadstate");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filetype");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadtype");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fee_album_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mix_id");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "source_hash");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "file_path");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tmp_cache_path");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    int i3 = cursorQuery.getInt(columnIndexOrThrow);
                    int i4 = cursorQuery.getInt(columnIndexOrThrow2);
                    int i5 = cursorQuery.getInt(columnIndexOrThrow3);
                    int i6 = cursorQuery.getInt(columnIndexOrThrow4);
                    int i7 = cursorQuery.getInt(columnIndexOrThrow5);
                    String string = cursorQuery.getString(columnIndexOrThrow6);
                    int i8 = cursorQuery.getInt(columnIndexOrThrow7);
                    int i9 = cursorQuery.getInt(columnIndexOrThrow8);
                    long j = cursorQuery.getLong(columnIndexOrThrow9);
                    long j2 = cursorQuery.getLong(columnIndexOrThrow10);
                    long j3 = cursorQuery.getLong(columnIndexOrThrow11);
                    int i10 = cursorQuery.getInt(columnIndexOrThrow12);
                    String string2 = cursorQuery.getString(columnIndexOrThrow13);
                    int i11 = i2;
                    int i12 = cursorQuery.getInt(i11);
                    int i13 = columnIndexOrThrow;
                    int i14 = columnIndexOrThrow15;
                    int i15 = cursorQuery.getInt(i14);
                    columnIndexOrThrow15 = i14;
                    int i16 = columnIndexOrThrow16;
                    int i17 = cursorQuery.getInt(i16);
                    columnIndexOrThrow16 = i16;
                    int i18 = columnIndexOrThrow17;
                    int i19 = cursorQuery.getInt(i18);
                    columnIndexOrThrow17 = i18;
                    int i20 = columnIndexOrThrow18;
                    String string3 = cursorQuery.getString(i20);
                    columnIndexOrThrow18 = i20;
                    int i21 = columnIndexOrThrow19;
                    long j4 = cursorQuery.getLong(i21);
                    columnIndexOrThrow19 = i21;
                    int i22 = columnIndexOrThrow20;
                    String string4 = cursorQuery.getString(i22);
                    columnIndexOrThrow20 = i22;
                    int i23 = columnIndexOrThrow21;
                    String string5 = cursorQuery.getString(i23);
                    columnIndexOrThrow21 = i23;
                    int i24 = columnIndexOrThrow22;
                    columnIndexOrThrow22 = i24;
                    arrayList.add(new e.c.a.g.a.d.f.c.a.a(i3, i4, i5, i6, i7, string, i8, i9, j, j2, j3, i10, string2, i12, i15, i17, i19, string3, j4, string4, string5, cursorQuery.getString(i24)));
                    columnIndexOrThrow = i13;
                    i2 = i11;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.b
    public int j() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM downloadtask WHERE mix_id > 0", 0);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.b
    public e.c.a.g.a.d.f.c.a.a k(int i2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM downloadtask WHERE _id=?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            e.c.a.g.a.d.f.c.a.a aVar = cursorQuery.moveToFirst() ? new e.c.a.g.a.d.f.c.a.a(cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID)), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadsize")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "filesize")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadstate")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "download_error_code")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadkey")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "quality")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadmode")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "addtime")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "songid")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileid")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "iscover")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "module")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "statuscode")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "uploadstate")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "filetype")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadtype")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "fee_album_id")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "mix_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "source_hash")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "file_path")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "tmp_cache_path"))) : null;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return aVar;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.b
    public e.c.a.g.a.d.f.c.a.a l(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM downloadtask WHERE downloadkey=?", 1);
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
            e.c.a.g.a.d.f.c.a.a aVar = cursorQuery.moveToFirst() ? new e.c.a.g.a.d.f.c.a.a(cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID)), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadsize")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "filesize")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadstate")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "download_error_code")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadkey")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "quality")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadmode")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "addtime")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "songid")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileid")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "iscover")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "module")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "statuscode")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "uploadstate")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "filetype")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadtype")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "fee_album_id")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "mix_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "source_hash")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "file_path")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "tmp_cache_path"))) : null;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return aVar;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.b
    public List<e.c.a.g.a.d.f.c.a.a> m(int i2, int i3) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM downloadtask WHERE _id <= ? order by _id DESC LIMIT ?", 2);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        roomSQLiteQueryAcquire.bindLong(2, i3);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadsize");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filesize");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadstate");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "download_error_code");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadkey");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "quality");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadmode");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "addtime");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songid");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileid");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "iscover");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "module");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "statuscode");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "uploadstate");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filetype");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadtype");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fee_album_id");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mix_id");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "source_hash");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "file_path");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tmp_cache_path");
            int i4 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                int i5 = cursorQuery.getInt(columnIndexOrThrow);
                int i6 = cursorQuery.getInt(columnIndexOrThrow2);
                int i7 = cursorQuery.getInt(columnIndexOrThrow3);
                int i8 = cursorQuery.getInt(columnIndexOrThrow4);
                int i9 = cursorQuery.getInt(columnIndexOrThrow5);
                String string = cursorQuery.getString(columnIndexOrThrow6);
                int i10 = cursorQuery.getInt(columnIndexOrThrow7);
                int i11 = cursorQuery.getInt(columnIndexOrThrow8);
                long j = cursorQuery.getLong(columnIndexOrThrow9);
                long j2 = cursorQuery.getLong(columnIndexOrThrow10);
                long j3 = cursorQuery.getLong(columnIndexOrThrow11);
                int i12 = cursorQuery.getInt(columnIndexOrThrow12);
                String string2 = cursorQuery.getString(columnIndexOrThrow13);
                int i13 = i4;
                int i14 = cursorQuery.getInt(i13);
                int i15 = columnIndexOrThrow;
                int i16 = columnIndexOrThrow15;
                int i17 = cursorQuery.getInt(i16);
                columnIndexOrThrow15 = i16;
                int i18 = columnIndexOrThrow16;
                int i19 = cursorQuery.getInt(i18);
                columnIndexOrThrow16 = i18;
                int i20 = columnIndexOrThrow17;
                int i21 = cursorQuery.getInt(i20);
                columnIndexOrThrow17 = i20;
                int i22 = columnIndexOrThrow18;
                String string3 = cursorQuery.getString(i22);
                columnIndexOrThrow18 = i22;
                int i23 = columnIndexOrThrow19;
                long j4 = cursorQuery.getLong(i23);
                columnIndexOrThrow19 = i23;
                int i24 = columnIndexOrThrow20;
                String string4 = cursorQuery.getString(i24);
                columnIndexOrThrow20 = i24;
                int i25 = columnIndexOrThrow21;
                String string5 = cursorQuery.getString(i25);
                columnIndexOrThrow21 = i25;
                int i26 = columnIndexOrThrow22;
                columnIndexOrThrow22 = i26;
                arrayList.add(new e.c.a.g.a.d.f.c.a.a(i5, i6, i7, i8, i9, string, i10, i11, j, j2, j3, i12, string2, i14, i17, i19, i21, string3, j4, string4, string5, cursorQuery.getString(i26)));
                columnIndexOrThrow = i15;
                i4 = i13;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.b
    public e.c.a.g.a.d.f.c.a.a n() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM downloadtask order by _id DESC LIMIT 1", 0);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            e.c.a.g.a.d.f.c.a.a aVar = cursorQuery.moveToFirst() ? new e.c.a.g.a.d.f.c.a.a(cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID)), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadsize")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "filesize")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadstate")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "download_error_code")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadkey")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "quality")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadmode")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "addtime")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "songid")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileid")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "iscover")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "module")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "statuscode")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "uploadstate")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "filetype")), cursorQuery.getInt(CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadtype")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "fee_album_id")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "mix_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "source_hash")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "file_path")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "tmp_cache_path"))) : null;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return aVar;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // e.c.a.g.a.d.f.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public long f(e.c.a.g.a.d.f.c.a.a aVar) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            long jInsertAndReturnId = this.f388d.insertAndReturnId(aVar);
            this.c.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.c.endTransaction();
        }
    }
}
