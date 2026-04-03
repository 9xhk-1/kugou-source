package e.c.a.g.a.d.f.c.a;

import android.database.Cursor;
import androidx.core.provider.FontsContractCompat;
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
import com.kugou.android.watch.lite.component.playlist.entity.KGPlaylistMusic;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class n extends m {
    public final RoomDatabase c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EntityInsertionAdapter<KGPlaylistMusic> f406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EntityInsertionAdapter<KGPlaylistMusic> f407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EntityDeletionOrUpdateAdapter<KGPlaylistMusic> f408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SharedSQLiteStatement f409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SharedSQLiteStatement f410h;

    public class a extends EntityInsertionAdapter<KGPlaylistMusic> {
        public a(n nVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, KGPlaylistMusic kGPlaylistMusic) {
            supportSQLiteStatement.bindLong(1, kGPlaylistMusic.j());
            supportSQLiteStatement.bindLong(2, kGPlaylistMusic.s());
            supportSQLiteStatement.bindLong(3, kGPlaylistMusic.r());
            supportSQLiteStatement.bindLong(4, kGPlaylistMusic.t());
            supportSQLiteStatement.bindLong(5, kGPlaylistMusic.n());
            supportSQLiteStatement.bindLong(6, kGPlaylistMusic.e());
            supportSQLiteStatement.bindLong(7, kGPlaylistMusic.f());
            supportSQLiteStatement.bindLong(8, kGPlaylistMusic.d());
            supportSQLiteStatement.bindLong(9, kGPlaylistMusic.D());
            supportSQLiteStatement.bindLong(10, kGPlaylistMusic.E() ? 1L : 0L);
            supportSQLiteStatement.bindLong(11, kGPlaylistMusic.a());
            supportSQLiteStatement.bindLong(12, kGPlaylistMusic.q());
            supportSQLiteStatement.bindLong(13, kGPlaylistMusic.g());
            if (kGPlaylistMusic.c() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, kGPlaylistMusic.c());
            }
            supportSQLiteStatement.bindLong(15, kGPlaylistMusic.p());
            supportSQLiteStatement.bindLong(16, kGPlaylistMusic.F() ? 1L : 0L);
            if (kGPlaylistMusic.w() == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, kGPlaylistMusic.w());
            }
            if (kGPlaylistMusic.x() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, kGPlaylistMusic.x());
            }
            if (kGPlaylistMusic.u() == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, kGPlaylistMusic.u());
            }
            if (kGPlaylistMusic.v() == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, kGPlaylistMusic.v());
            }
            if (kGPlaylistMusic.A() == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, kGPlaylistMusic.A());
            }
            if (kGPlaylistMusic.B() == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, kGPlaylistMusic.B());
            }
            if (kGPlaylistMusic.y() == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, kGPlaylistMusic.y());
            }
            if (kGPlaylistMusic.z() == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, kGPlaylistMusic.z());
            }
            if (kGPlaylistMusic.C() == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindString(25, kGPlaylistMusic.C());
            }
            supportSQLiteStatement.bindLong(26, kGPlaylistMusic.l());
            supportSQLiteStatement.bindLong(27, kGPlaylistMusic.b());
            supportSQLiteStatement.bindLong(28, kGPlaylistMusic.o());
            if (kGPlaylistMusic.h() == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, kGPlaylistMusic.h());
            }
            if (kGPlaylistMusic.i() == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, kGPlaylistMusic.i());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `playlistsong` (`_id`,`playlistMusicId`,`playlistId`,`playlistServerId`,`mMusicId`,`file_id`,`fileOrderWeight`,`fileAddTime`,`isLocal`,`isMusicCloud`,`audioId`,`musicSource`,`flag`,`feeAlbumId`,`mixId`,`isNeedUpdateMixid`,`singerPinyinName`,`singerPinyinNameSimple`,`singerDigitName`,`singerDigitNameSimple`,`songPinyinName`,`songPinyinNameSimple`,`songDigitName`,`songDigitNameSimple`,`songSyncUserIds`,`lastUserManualOperateTime`,`collectTime`,`maskOfForceDownload`,`global_id`,`hash`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public class b extends EntityInsertionAdapter<KGPlaylistMusic> {
        public b(n nVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, KGPlaylistMusic kGPlaylistMusic) {
            supportSQLiteStatement.bindLong(1, kGPlaylistMusic.j());
            supportSQLiteStatement.bindLong(2, kGPlaylistMusic.s());
            supportSQLiteStatement.bindLong(3, kGPlaylistMusic.r());
            supportSQLiteStatement.bindLong(4, kGPlaylistMusic.t());
            supportSQLiteStatement.bindLong(5, kGPlaylistMusic.n());
            supportSQLiteStatement.bindLong(6, kGPlaylistMusic.e());
            supportSQLiteStatement.bindLong(7, kGPlaylistMusic.f());
            supportSQLiteStatement.bindLong(8, kGPlaylistMusic.d());
            supportSQLiteStatement.bindLong(9, kGPlaylistMusic.D());
            supportSQLiteStatement.bindLong(10, kGPlaylistMusic.E() ? 1L : 0L);
            supportSQLiteStatement.bindLong(11, kGPlaylistMusic.a());
            supportSQLiteStatement.bindLong(12, kGPlaylistMusic.q());
            supportSQLiteStatement.bindLong(13, kGPlaylistMusic.g());
            if (kGPlaylistMusic.c() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, kGPlaylistMusic.c());
            }
            supportSQLiteStatement.bindLong(15, kGPlaylistMusic.p());
            supportSQLiteStatement.bindLong(16, kGPlaylistMusic.F() ? 1L : 0L);
            if (kGPlaylistMusic.w() == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, kGPlaylistMusic.w());
            }
            if (kGPlaylistMusic.x() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, kGPlaylistMusic.x());
            }
            if (kGPlaylistMusic.u() == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, kGPlaylistMusic.u());
            }
            if (kGPlaylistMusic.v() == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, kGPlaylistMusic.v());
            }
            if (kGPlaylistMusic.A() == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, kGPlaylistMusic.A());
            }
            if (kGPlaylistMusic.B() == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, kGPlaylistMusic.B());
            }
            if (kGPlaylistMusic.y() == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, kGPlaylistMusic.y());
            }
            if (kGPlaylistMusic.z() == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, kGPlaylistMusic.z());
            }
            if (kGPlaylistMusic.C() == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindString(25, kGPlaylistMusic.C());
            }
            supportSQLiteStatement.bindLong(26, kGPlaylistMusic.l());
            supportSQLiteStatement.bindLong(27, kGPlaylistMusic.b());
            supportSQLiteStatement.bindLong(28, kGPlaylistMusic.o());
            if (kGPlaylistMusic.h() == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, kGPlaylistMusic.h());
            }
            if (kGPlaylistMusic.i() == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, kGPlaylistMusic.i());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR ABORT INTO `playlistsong` (`_id`,`playlistMusicId`,`playlistId`,`playlistServerId`,`mMusicId`,`file_id`,`fileOrderWeight`,`fileAddTime`,`isLocal`,`isMusicCloud`,`audioId`,`musicSource`,`flag`,`feeAlbumId`,`mixId`,`isNeedUpdateMixid`,`singerPinyinName`,`singerPinyinNameSimple`,`singerDigitName`,`singerDigitNameSimple`,`songPinyinName`,`songPinyinNameSimple`,`songDigitName`,`songDigitNameSimple`,`songSyncUserIds`,`lastUserManualOperateTime`,`collectTime`,`maskOfForceDownload`,`global_id`,`hash`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public class c extends EntityDeletionOrUpdateAdapter<KGPlaylistMusic> {
        public c(n nVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, KGPlaylistMusic kGPlaylistMusic) {
            supportSQLiteStatement.bindLong(1, kGPlaylistMusic.j());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `playlistsong` WHERE `_id` = ?";
        }
    }

    public class d extends EntityDeletionOrUpdateAdapter<KGPlaylistMusic> {
        public d(n nVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, KGPlaylistMusic kGPlaylistMusic) {
            supportSQLiteStatement.bindLong(1, kGPlaylistMusic.j());
            supportSQLiteStatement.bindLong(2, kGPlaylistMusic.s());
            supportSQLiteStatement.bindLong(3, kGPlaylistMusic.r());
            supportSQLiteStatement.bindLong(4, kGPlaylistMusic.t());
            supportSQLiteStatement.bindLong(5, kGPlaylistMusic.n());
            supportSQLiteStatement.bindLong(6, kGPlaylistMusic.e());
            supportSQLiteStatement.bindLong(7, kGPlaylistMusic.f());
            supportSQLiteStatement.bindLong(8, kGPlaylistMusic.d());
            supportSQLiteStatement.bindLong(9, kGPlaylistMusic.D());
            supportSQLiteStatement.bindLong(10, kGPlaylistMusic.E() ? 1L : 0L);
            supportSQLiteStatement.bindLong(11, kGPlaylistMusic.a());
            supportSQLiteStatement.bindLong(12, kGPlaylistMusic.q());
            supportSQLiteStatement.bindLong(13, kGPlaylistMusic.g());
            if (kGPlaylistMusic.c() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, kGPlaylistMusic.c());
            }
            supportSQLiteStatement.bindLong(15, kGPlaylistMusic.p());
            supportSQLiteStatement.bindLong(16, kGPlaylistMusic.F() ? 1L : 0L);
            if (kGPlaylistMusic.w() == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, kGPlaylistMusic.w());
            }
            if (kGPlaylistMusic.x() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, kGPlaylistMusic.x());
            }
            if (kGPlaylistMusic.u() == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, kGPlaylistMusic.u());
            }
            if (kGPlaylistMusic.v() == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, kGPlaylistMusic.v());
            }
            if (kGPlaylistMusic.A() == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, kGPlaylistMusic.A());
            }
            if (kGPlaylistMusic.B() == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, kGPlaylistMusic.B());
            }
            if (kGPlaylistMusic.y() == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, kGPlaylistMusic.y());
            }
            if (kGPlaylistMusic.z() == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, kGPlaylistMusic.z());
            }
            if (kGPlaylistMusic.C() == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindString(25, kGPlaylistMusic.C());
            }
            supportSQLiteStatement.bindLong(26, kGPlaylistMusic.l());
            supportSQLiteStatement.bindLong(27, kGPlaylistMusic.b());
            supportSQLiteStatement.bindLong(28, kGPlaylistMusic.o());
            if (kGPlaylistMusic.h() == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, kGPlaylistMusic.h());
            }
            if (kGPlaylistMusic.i() == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, kGPlaylistMusic.i());
            }
            supportSQLiteStatement.bindLong(31, kGPlaylistMusic.j());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `playlistsong` SET `_id` = ?,`playlistMusicId` = ?,`playlistId` = ?,`playlistServerId` = ?,`mMusicId` = ?,`file_id` = ?,`fileOrderWeight` = ?,`fileAddTime` = ?,`isLocal` = ?,`isMusicCloud` = ?,`audioId` = ?,`musicSource` = ?,`flag` = ?,`feeAlbumId` = ?,`mixId` = ?,`isNeedUpdateMixid` = ?,`singerPinyinName` = ?,`singerPinyinNameSimple` = ?,`singerDigitName` = ?,`singerDigitNameSimple` = ?,`songPinyinName` = ?,`songPinyinNameSimple` = ?,`songDigitName` = ?,`songDigitNameSimple` = ?,`songSyncUserIds` = ?,`lastUserManualOperateTime` = ?,`collectTime` = ?,`maskOfForceDownload` = ?,`global_id` = ?,`hash` = ? WHERE `_id` = ?";
        }
    }

    public class e extends SharedSQLiteStatement {
        public e(n nVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE  FROM playlistsong WHERE global_id =?";
        }
    }

    public class f extends SharedSQLiteStatement {
        public f(n nVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM playlistsong WHERE global_id=? AND isLocal < 1";
        }
    }

    public class g extends SharedSQLiteStatement {
        public g(n nVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE playlistsong SET fileOrderWeight =? WHERE mixId =? AND global_id =?";
        }
    }

    public class h extends SharedSQLiteStatement {
        public h(n nVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE playlistsong SET fileOrderWeight =? WHERE mMusicId =? AND mixId <= 0 AND global_id =?";
        }
    }

    public n(RoomDatabase roomDatabase) {
        this.c = roomDatabase;
        this.f406d = new a(this, roomDatabase);
        this.f407e = new b(this, roomDatabase);
        new c(this, roomDatabase);
        this.f408f = new d(this, roomDatabase);
        this.f409g = new e(this, roomDatabase);
        this.f410h = new f(this, roomDatabase);
        new g(this, roomDatabase);
        new h(this, roomDatabase);
    }

    @Override // e.c.a.g.a.d.f.a
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public long f(KGPlaylistMusic kGPlaylistMusic) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            long jInsertAndReturnId = this.f406d.insertAndReturnId(kGPlaylistMusic);
            this.c.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // e.c.a.g.a.d.f.a
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public int g(KGPlaylistMusic... kGPlaylistMusicArr) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            int iHandleMultiple = this.f408f.handleMultiple(kGPlaylistMusicArr) + 0;
            this.c.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.c.endTransaction();
        }
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
    public List<Long> e(List<? extends KGPlaylistMusic> list) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.f406d.insertAndReturnIdsList(list);
            this.c.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.m
    public void h(String str) {
        this.c.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f409g.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        this.c.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.c.setTransactionSuccessful();
        } finally {
            this.c.endTransaction();
            this.f409g.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.m
    public int i(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM playlistsong  WHERE global_id =?", 1);
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

    @Override // e.c.a.g.a.d.f.c.a.m
    public int j(String str, List<Long> list) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT COUNT(*) FROM playlistsong  WHERE global_id =");
        sbNewStringBuilder.append("?");
        sbNewStringBuilder.append(" AND mixId not in (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") ");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
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
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.m
    public int k(String str, long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT fileOrderWeight FROM playlistsong WHERE global_id =? AND mixId =?", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        roomSQLiteQueryAcquire.bindLong(2, j);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.m
    public int l(String str, long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT fileOrderWeight FROM playlistsong WHERE global_id =? AND mMusicId =? AND mixId <= 0", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        roomSQLiteQueryAcquire.bindLong(2, j);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.m
    public int m(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT MAX(fileOrderWeight) FROM playlistsong WHERE global_id =?", 1);
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

    @Override // e.c.a.g.a.d.f.c.a.m
    public int n(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT MIN(fileOrderWeight) FROM playlistsong WHERE global_id =?", 1);
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

    @Override // e.c.a.g.a.d.f.c.a.m
    public List<KGPlaylistMusic> o(String str) throws Throwable {
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
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM playlistsong WHERE global_id =?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlistMusicId");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlistId");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlistServerId");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mMusicId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FontsContractCompat.Columns.FILE_ID);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileOrderWeight");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileAddTime");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLocal");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isMusicCloud");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioId");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicSource");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flag");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeAlbumId");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixId");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isNeedUpdateMixid");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerPinyinName");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerPinyinNameSimple");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerDigitName");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerDigitNameSimple");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songPinyinName");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songPinyinNameSimple");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songDigitName");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songDigitNameSimple");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songSyncUserIds");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUserManualOperateTime");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "maskOfForceDownload");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "global_id");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash");
            int i2 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                KGPlaylistMusic kGPlaylistMusic = new KGPlaylistMusic();
                ArrayList arrayList2 = arrayList;
                int i3 = columnIndexOrThrow12;
                kGPlaylistMusic.Q(cursorQuery.getLong(columnIndexOrThrow));
                kGPlaylistMusic.b0(cursorQuery.getInt(columnIndexOrThrow2));
                kGPlaylistMusic.a0(cursorQuery.getInt(columnIndexOrThrow3));
                kGPlaylistMusic.c0(cursorQuery.getInt(columnIndexOrThrow4));
                kGPlaylistMusic.U(cursorQuery.getLong(columnIndexOrThrow5));
                kGPlaylistMusic.L(cursorQuery.getInt(columnIndexOrThrow6));
                kGPlaylistMusic.M(cursorQuery.getInt(columnIndexOrThrow7));
                kGPlaylistMusic.K(cursorQuery.getLong(columnIndexOrThrow8));
                kGPlaylistMusic.R(cursorQuery.getInt(columnIndexOrThrow9));
                kGPlaylistMusic.X(cursorQuery.getInt(columnIndexOrThrow10) != 0);
                kGPlaylistMusic.G(cursorQuery.getInt(columnIndexOrThrow11));
                kGPlaylistMusic.Y(cursorQuery.getInt(i3));
                kGPlaylistMusic.N(cursorQuery.getInt(columnIndexOrThrow13));
                int i4 = i2;
                int i5 = columnIndexOrThrow;
                kGPlaylistMusic.J(cursorQuery.getString(i4));
                int i6 = columnIndexOrThrow15;
                kGPlaylistMusic.W(cursorQuery.getLong(i6));
                int i7 = columnIndexOrThrow16;
                kGPlaylistMusic.Z(cursorQuery.getInt(i7) != 0);
                int i8 = columnIndexOrThrow17;
                kGPlaylistMusic.f0(cursorQuery.getString(i8));
                int i9 = columnIndexOrThrow18;
                kGPlaylistMusic.g0(cursorQuery.getString(i9));
                columnIndexOrThrow18 = i9;
                int i10 = columnIndexOrThrow19;
                kGPlaylistMusic.d0(cursorQuery.getString(i10));
                columnIndexOrThrow19 = i10;
                int i11 = columnIndexOrThrow20;
                kGPlaylistMusic.e0(cursorQuery.getString(i11));
                columnIndexOrThrow20 = i11;
                int i12 = columnIndexOrThrow21;
                kGPlaylistMusic.j0(cursorQuery.getString(i12));
                columnIndexOrThrow21 = i12;
                int i13 = columnIndexOrThrow22;
                kGPlaylistMusic.k0(cursorQuery.getString(i13));
                columnIndexOrThrow22 = i13;
                int i14 = columnIndexOrThrow23;
                kGPlaylistMusic.h0(cursorQuery.getString(i14));
                columnIndexOrThrow23 = i14;
                int i15 = columnIndexOrThrow24;
                kGPlaylistMusic.i0(cursorQuery.getString(i15));
                columnIndexOrThrow24 = i15;
                int i16 = columnIndexOrThrow25;
                kGPlaylistMusic.l0(cursorQuery.getString(i16));
                int i17 = columnIndexOrThrow26;
                kGPlaylistMusic.S(cursorQuery.getLong(i17));
                int i18 = columnIndexOrThrow2;
                int i19 = columnIndexOrThrow27;
                int i20 = columnIndexOrThrow13;
                kGPlaylistMusic.H(cursorQuery.getLong(i19));
                int i21 = columnIndexOrThrow28;
                kGPlaylistMusic.V(cursorQuery.getInt(i21));
                int i22 = columnIndexOrThrow29;
                kGPlaylistMusic.O(cursorQuery.getString(i22));
                int i23 = columnIndexOrThrow30;
                kGPlaylistMusic.P(cursorQuery.getString(i23));
                arrayList = arrayList2;
                arrayList.add(kGPlaylistMusic);
                columnIndexOrThrow30 = i23;
                columnIndexOrThrow = i5;
                i2 = i4;
                columnIndexOrThrow15 = i6;
                columnIndexOrThrow16 = i7;
                columnIndexOrThrow17 = i8;
                columnIndexOrThrow25 = i16;
                columnIndexOrThrow26 = i17;
                columnIndexOrThrow28 = i21;
                columnIndexOrThrow13 = i20;
                columnIndexOrThrow27 = i19;
                columnIndexOrThrow29 = i22;
                columnIndexOrThrow2 = i18;
                columnIndexOrThrow12 = i3;
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

    @Override // e.c.a.g.a.d.f.c.a.m
    public KGPlaylistMusic p(String str, long j) throws Throwable {
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
        KGPlaylistMusic kGPlaylistMusic;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM playlistsong WHERE global_id =? AND mixId =?", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        roomSQLiteQueryAcquire.bindLong(2, j);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlistMusicId");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlistId");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlistServerId");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mMusicId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FontsContractCompat.Columns.FILE_ID);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileOrderWeight");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileAddTime");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLocal");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isMusicCloud");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioId");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicSource");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flag");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeAlbumId");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixId");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isNeedUpdateMixid");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerPinyinName");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerPinyinNameSimple");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerDigitName");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerDigitNameSimple");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songPinyinName");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songPinyinNameSimple");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songDigitName");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songDigitNameSimple");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songSyncUserIds");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUserManualOperateTime");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "maskOfForceDownload");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "global_id");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash");
            if (cursorQuery.moveToFirst()) {
                KGPlaylistMusic kGPlaylistMusic2 = new KGPlaylistMusic();
                kGPlaylistMusic2.Q(cursorQuery.getLong(columnIndexOrThrow));
                kGPlaylistMusic2.b0(cursorQuery.getInt(columnIndexOrThrow2));
                kGPlaylistMusic2.a0(cursorQuery.getInt(columnIndexOrThrow3));
                kGPlaylistMusic2.c0(cursorQuery.getInt(columnIndexOrThrow4));
                kGPlaylistMusic2.U(cursorQuery.getLong(columnIndexOrThrow5));
                kGPlaylistMusic2.L(cursorQuery.getInt(columnIndexOrThrow6));
                kGPlaylistMusic2.M(cursorQuery.getInt(columnIndexOrThrow7));
                kGPlaylistMusic2.K(cursorQuery.getLong(columnIndexOrThrow8));
                kGPlaylistMusic2.R(cursorQuery.getInt(columnIndexOrThrow9));
                kGPlaylistMusic2.X(cursorQuery.getInt(columnIndexOrThrow10) != 0);
                kGPlaylistMusic2.G(cursorQuery.getInt(columnIndexOrThrow11));
                kGPlaylistMusic2.Y(cursorQuery.getInt(columnIndexOrThrow12));
                kGPlaylistMusic2.N(cursorQuery.getInt(columnIndexOrThrow13));
                kGPlaylistMusic2.J(cursorQuery.getString(columnIndexOrThrow14));
                kGPlaylistMusic2.W(cursorQuery.getLong(columnIndexOrThrow15));
                kGPlaylistMusic2.Z(cursorQuery.getInt(columnIndexOrThrow16) != 0);
                kGPlaylistMusic2.f0(cursorQuery.getString(columnIndexOrThrow17));
                kGPlaylistMusic2.g0(cursorQuery.getString(columnIndexOrThrow18));
                kGPlaylistMusic2.d0(cursorQuery.getString(columnIndexOrThrow19));
                kGPlaylistMusic2.e0(cursorQuery.getString(columnIndexOrThrow20));
                kGPlaylistMusic2.j0(cursorQuery.getString(columnIndexOrThrow21));
                kGPlaylistMusic2.k0(cursorQuery.getString(columnIndexOrThrow22));
                kGPlaylistMusic2.h0(cursorQuery.getString(columnIndexOrThrow23));
                kGPlaylistMusic2.i0(cursorQuery.getString(columnIndexOrThrow24));
                kGPlaylistMusic2.l0(cursorQuery.getString(columnIndexOrThrow25));
                kGPlaylistMusic2.S(cursorQuery.getLong(columnIndexOrThrow26));
                kGPlaylistMusic2.H(cursorQuery.getLong(columnIndexOrThrow27));
                kGPlaylistMusic2.V(cursorQuery.getInt(columnIndexOrThrow28));
                kGPlaylistMusic2.O(cursorQuery.getString(columnIndexOrThrow29));
                kGPlaylistMusic2.P(cursorQuery.getString(columnIndexOrThrow30));
                kGPlaylistMusic = kGPlaylistMusic2;
            } else {
                kGPlaylistMusic = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return kGPlaylistMusic;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.m
    public KGPlaylistMusic q(String str, String str2) throws Throwable {
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
        KGPlaylistMusic kGPlaylistMusic;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM playlistsong WHERE global_id =? AND hash =?", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlistMusicId");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlistId");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlistServerId");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mMusicId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FontsContractCompat.Columns.FILE_ID);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileOrderWeight");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileAddTime");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLocal");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isMusicCloud");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioId");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicSource");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flag");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeAlbumId");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixId");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isNeedUpdateMixid");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerPinyinName");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerPinyinNameSimple");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerDigitName");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerDigitNameSimple");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songPinyinName");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songPinyinNameSimple");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songDigitName");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songDigitNameSimple");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songSyncUserIds");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUserManualOperateTime");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "maskOfForceDownload");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "global_id");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash");
            if (cursorQuery.moveToFirst()) {
                KGPlaylistMusic kGPlaylistMusic2 = new KGPlaylistMusic();
                kGPlaylistMusic2.Q(cursorQuery.getLong(columnIndexOrThrow));
                kGPlaylistMusic2.b0(cursorQuery.getInt(columnIndexOrThrow2));
                kGPlaylistMusic2.a0(cursorQuery.getInt(columnIndexOrThrow3));
                kGPlaylistMusic2.c0(cursorQuery.getInt(columnIndexOrThrow4));
                kGPlaylistMusic2.U(cursorQuery.getLong(columnIndexOrThrow5));
                kGPlaylistMusic2.L(cursorQuery.getInt(columnIndexOrThrow6));
                kGPlaylistMusic2.M(cursorQuery.getInt(columnIndexOrThrow7));
                kGPlaylistMusic2.K(cursorQuery.getLong(columnIndexOrThrow8));
                kGPlaylistMusic2.R(cursorQuery.getInt(columnIndexOrThrow9));
                kGPlaylistMusic2.X(cursorQuery.getInt(columnIndexOrThrow10) != 0);
                kGPlaylistMusic2.G(cursorQuery.getInt(columnIndexOrThrow11));
                kGPlaylistMusic2.Y(cursorQuery.getInt(columnIndexOrThrow12));
                kGPlaylistMusic2.N(cursorQuery.getInt(columnIndexOrThrow13));
                kGPlaylistMusic2.J(cursorQuery.getString(columnIndexOrThrow14));
                kGPlaylistMusic2.W(cursorQuery.getLong(columnIndexOrThrow15));
                kGPlaylistMusic2.Z(cursorQuery.getInt(columnIndexOrThrow16) != 0);
                kGPlaylistMusic2.f0(cursorQuery.getString(columnIndexOrThrow17));
                kGPlaylistMusic2.g0(cursorQuery.getString(columnIndexOrThrow18));
                kGPlaylistMusic2.d0(cursorQuery.getString(columnIndexOrThrow19));
                kGPlaylistMusic2.e0(cursorQuery.getString(columnIndexOrThrow20));
                kGPlaylistMusic2.j0(cursorQuery.getString(columnIndexOrThrow21));
                kGPlaylistMusic2.k0(cursorQuery.getString(columnIndexOrThrow22));
                kGPlaylistMusic2.h0(cursorQuery.getString(columnIndexOrThrow23));
                kGPlaylistMusic2.i0(cursorQuery.getString(columnIndexOrThrow24));
                kGPlaylistMusic2.l0(cursorQuery.getString(columnIndexOrThrow25));
                kGPlaylistMusic2.S(cursorQuery.getLong(columnIndexOrThrow26));
                kGPlaylistMusic2.H(cursorQuery.getLong(columnIndexOrThrow27));
                kGPlaylistMusic2.V(cursorQuery.getInt(columnIndexOrThrow28));
                kGPlaylistMusic2.O(cursorQuery.getString(columnIndexOrThrow29));
                kGPlaylistMusic2.P(cursorQuery.getString(columnIndexOrThrow30));
                kGPlaylistMusic = kGPlaylistMusic2;
            } else {
                kGPlaylistMusic = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return kGPlaylistMusic;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.m
    public List<KGPlaylistMusic> r(String str) throws Throwable {
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
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM playlistsong WHERE global_id =? order by playlistsong.fileOrderWeight ASC", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlistMusicId");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlistId");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlistServerId");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mMusicId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FontsContractCompat.Columns.FILE_ID);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileOrderWeight");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileAddTime");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLocal");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isMusicCloud");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioId");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicSource");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flag");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeAlbumId");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixId");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isNeedUpdateMixid");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerPinyinName");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerPinyinNameSimple");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerDigitName");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerDigitNameSimple");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songPinyinName");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songPinyinNameSimple");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songDigitName");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songDigitNameSimple");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songSyncUserIds");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUserManualOperateTime");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "maskOfForceDownload");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "global_id");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash");
            int i2 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                KGPlaylistMusic kGPlaylistMusic = new KGPlaylistMusic();
                ArrayList arrayList2 = arrayList;
                int i3 = columnIndexOrThrow12;
                kGPlaylistMusic.Q(cursorQuery.getLong(columnIndexOrThrow));
                kGPlaylistMusic.b0(cursorQuery.getInt(columnIndexOrThrow2));
                kGPlaylistMusic.a0(cursorQuery.getInt(columnIndexOrThrow3));
                kGPlaylistMusic.c0(cursorQuery.getInt(columnIndexOrThrow4));
                kGPlaylistMusic.U(cursorQuery.getLong(columnIndexOrThrow5));
                kGPlaylistMusic.L(cursorQuery.getInt(columnIndexOrThrow6));
                kGPlaylistMusic.M(cursorQuery.getInt(columnIndexOrThrow7));
                kGPlaylistMusic.K(cursorQuery.getLong(columnIndexOrThrow8));
                kGPlaylistMusic.R(cursorQuery.getInt(columnIndexOrThrow9));
                kGPlaylistMusic.X(cursorQuery.getInt(columnIndexOrThrow10) != 0);
                kGPlaylistMusic.G(cursorQuery.getInt(columnIndexOrThrow11));
                kGPlaylistMusic.Y(cursorQuery.getInt(i3));
                kGPlaylistMusic.N(cursorQuery.getInt(columnIndexOrThrow13));
                int i4 = i2;
                int i5 = columnIndexOrThrow;
                kGPlaylistMusic.J(cursorQuery.getString(i4));
                int i6 = columnIndexOrThrow15;
                kGPlaylistMusic.W(cursorQuery.getLong(i6));
                int i7 = columnIndexOrThrow16;
                kGPlaylistMusic.Z(cursorQuery.getInt(i7) != 0);
                int i8 = columnIndexOrThrow17;
                kGPlaylistMusic.f0(cursorQuery.getString(i8));
                int i9 = columnIndexOrThrow18;
                kGPlaylistMusic.g0(cursorQuery.getString(i9));
                columnIndexOrThrow18 = i9;
                int i10 = columnIndexOrThrow19;
                kGPlaylistMusic.d0(cursorQuery.getString(i10));
                columnIndexOrThrow19 = i10;
                int i11 = columnIndexOrThrow20;
                kGPlaylistMusic.e0(cursorQuery.getString(i11));
                columnIndexOrThrow20 = i11;
                int i12 = columnIndexOrThrow21;
                kGPlaylistMusic.j0(cursorQuery.getString(i12));
                columnIndexOrThrow21 = i12;
                int i13 = columnIndexOrThrow22;
                kGPlaylistMusic.k0(cursorQuery.getString(i13));
                columnIndexOrThrow22 = i13;
                int i14 = columnIndexOrThrow23;
                kGPlaylistMusic.h0(cursorQuery.getString(i14));
                columnIndexOrThrow23 = i14;
                int i15 = columnIndexOrThrow24;
                kGPlaylistMusic.i0(cursorQuery.getString(i15));
                columnIndexOrThrow24 = i15;
                int i16 = columnIndexOrThrow25;
                kGPlaylistMusic.l0(cursorQuery.getString(i16));
                int i17 = columnIndexOrThrow26;
                kGPlaylistMusic.S(cursorQuery.getLong(i17));
                int i18 = columnIndexOrThrow2;
                int i19 = columnIndexOrThrow27;
                int i20 = columnIndexOrThrow13;
                kGPlaylistMusic.H(cursorQuery.getLong(i19));
                int i21 = columnIndexOrThrow28;
                kGPlaylistMusic.V(cursorQuery.getInt(i21));
                int i22 = columnIndexOrThrow29;
                kGPlaylistMusic.O(cursorQuery.getString(i22));
                int i23 = columnIndexOrThrow30;
                kGPlaylistMusic.P(cursorQuery.getString(i23));
                arrayList = arrayList2;
                arrayList.add(kGPlaylistMusic);
                columnIndexOrThrow30 = i23;
                columnIndexOrThrow = i5;
                i2 = i4;
                columnIndexOrThrow15 = i6;
                columnIndexOrThrow16 = i7;
                columnIndexOrThrow17 = i8;
                columnIndexOrThrow25 = i16;
                columnIndexOrThrow26 = i17;
                columnIndexOrThrow28 = i21;
                columnIndexOrThrow13 = i20;
                columnIndexOrThrow27 = i19;
                columnIndexOrThrow29 = i22;
                columnIndexOrThrow2 = i18;
                columnIndexOrThrow12 = i3;
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

    @Override // e.c.a.g.a.d.f.c.a.m
    public List<KGPlaylistMusic> s(String str, int i2, int i3) throws Throwable {
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
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM playlistsong WHERE global_id =? AND fileOrderWeight >= ? order by fileOrderWeight ASC LIMIT ?", 3);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        roomSQLiteQueryAcquire.bindLong(2, i2);
        roomSQLiteQueryAcquire.bindLong(3, i3);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlistMusicId");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlistId");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlistServerId");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mMusicId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FontsContractCompat.Columns.FILE_ID);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileOrderWeight");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileAddTime");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLocal");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isMusicCloud");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioId");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicSource");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flag");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeAlbumId");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixId");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isNeedUpdateMixid");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerPinyinName");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerPinyinNameSimple");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerDigitName");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singerDigitNameSimple");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songPinyinName");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songPinyinNameSimple");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songDigitName");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songDigitNameSimple");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songSyncUserIds");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUserManualOperateTime");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "maskOfForceDownload");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "global_id");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash");
            int i4 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                KGPlaylistMusic kGPlaylistMusic = new KGPlaylistMusic();
                int i5 = columnIndexOrThrow12;
                int i6 = columnIndexOrThrow13;
                kGPlaylistMusic.Q(cursorQuery.getLong(columnIndexOrThrow));
                kGPlaylistMusic.b0(cursorQuery.getInt(columnIndexOrThrow2));
                kGPlaylistMusic.a0(cursorQuery.getInt(columnIndexOrThrow3));
                kGPlaylistMusic.c0(cursorQuery.getInt(columnIndexOrThrow4));
                kGPlaylistMusic.U(cursorQuery.getLong(columnIndexOrThrow5));
                kGPlaylistMusic.L(cursorQuery.getInt(columnIndexOrThrow6));
                kGPlaylistMusic.M(cursorQuery.getInt(columnIndexOrThrow7));
                kGPlaylistMusic.K(cursorQuery.getLong(columnIndexOrThrow8));
                kGPlaylistMusic.R(cursorQuery.getInt(columnIndexOrThrow9));
                kGPlaylistMusic.X(cursorQuery.getInt(columnIndexOrThrow10) != 0);
                kGPlaylistMusic.G(cursorQuery.getInt(columnIndexOrThrow11));
                kGPlaylistMusic.Y(cursorQuery.getInt(i5));
                int i7 = columnIndexOrThrow;
                kGPlaylistMusic.N(cursorQuery.getInt(i6));
                int i8 = i4;
                kGPlaylistMusic.J(cursorQuery.getString(i8));
                int i9 = columnIndexOrThrow15;
                int i10 = columnIndexOrThrow2;
                kGPlaylistMusic.W(cursorQuery.getLong(i9));
                int i11 = columnIndexOrThrow16;
                kGPlaylistMusic.Z(cursorQuery.getInt(i11) != 0);
                int i12 = columnIndexOrThrow17;
                kGPlaylistMusic.f0(cursorQuery.getString(i12));
                int i13 = columnIndexOrThrow18;
                kGPlaylistMusic.g0(cursorQuery.getString(i13));
                int i14 = columnIndexOrThrow19;
                kGPlaylistMusic.d0(cursorQuery.getString(i14));
                int i15 = columnIndexOrThrow20;
                kGPlaylistMusic.e0(cursorQuery.getString(i15));
                int i16 = columnIndexOrThrow21;
                kGPlaylistMusic.j0(cursorQuery.getString(i16));
                int i17 = columnIndexOrThrow22;
                kGPlaylistMusic.k0(cursorQuery.getString(i17));
                int i18 = columnIndexOrThrow23;
                kGPlaylistMusic.h0(cursorQuery.getString(i18));
                int i19 = columnIndexOrThrow24;
                kGPlaylistMusic.i0(cursorQuery.getString(i19));
                int i20 = columnIndexOrThrow25;
                kGPlaylistMusic.l0(cursorQuery.getString(i20));
                columnIndexOrThrow16 = i11;
                int i21 = columnIndexOrThrow26;
                kGPlaylistMusic.S(cursorQuery.getLong(i21));
                int i22 = columnIndexOrThrow27;
                kGPlaylistMusic.H(cursorQuery.getLong(i22));
                int i23 = columnIndexOrThrow28;
                kGPlaylistMusic.V(cursorQuery.getInt(i23));
                int i24 = columnIndexOrThrow29;
                kGPlaylistMusic.O(cursorQuery.getString(i24));
                int i25 = columnIndexOrThrow30;
                kGPlaylistMusic.P(cursorQuery.getString(i25));
                arrayList.add(kGPlaylistMusic);
                columnIndexOrThrow30 = i25;
                columnIndexOrThrow12 = i5;
                columnIndexOrThrow = i7;
                i4 = i8;
                columnIndexOrThrow17 = i12;
                columnIndexOrThrow27 = i22;
                columnIndexOrThrow29 = i24;
                columnIndexOrThrow2 = i10;
                columnIndexOrThrow15 = i9;
                columnIndexOrThrow18 = i13;
                columnIndexOrThrow19 = i14;
                columnIndexOrThrow20 = i15;
                columnIndexOrThrow21 = i16;
                columnIndexOrThrow22 = i17;
                columnIndexOrThrow23 = i18;
                columnIndexOrThrow24 = i19;
                columnIndexOrThrow25 = i20;
                columnIndexOrThrow26 = i21;
                columnIndexOrThrow28 = i23;
                columnIndexOrThrow13 = i6;
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

    @Override // e.c.a.g.a.d.f.c.a.m
    public long t(KGPlaylistMusic kGPlaylistMusic) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            long jInsertAndReturnId = this.f407e.insertAndReturnId(kGPlaylistMusic);
            this.c.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.m
    public int u(String str, List<Long> list, List<String> list2) {
        this.c.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM playlistsong WHERE global_id=");
        sbNewStringBuilder.append("?");
        sbNewStringBuilder.append(" AND (mixId IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") OR hash IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, list2.size());
        sbNewStringBuilder.append("))");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.c.compileStatement(sbNewStringBuilder.toString());
        if (str == null) {
            supportSQLiteStatementCompileStatement.bindNull(1);
        } else {
            supportSQLiteStatementCompileStatement.bindString(1, str);
        }
        int i2 = 2;
        for (Long l : list) {
            if (l == null) {
                supportSQLiteStatementCompileStatement.bindNull(i2);
            } else {
                supportSQLiteStatementCompileStatement.bindLong(i2, l.longValue());
            }
            i2++;
        }
        int i3 = size + 2;
        for (String str2 : list2) {
            if (str2 == null) {
                supportSQLiteStatementCompileStatement.bindNull(i3);
            } else {
                supportSQLiteStatementCompileStatement.bindString(i3, str2);
            }
            i3++;
        }
        this.c.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.c.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.m
    public int v(String str) {
        this.c.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f410h.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        this.c.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.c.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.c.endTransaction();
            this.f410h.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.m
    public void w(String str, List<String> list) {
        this.c.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM playlistsong WHERE global_id=");
        sbNewStringBuilder.append("?");
        sbNewStringBuilder.append(" AND hash in (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, list.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.c.compileStatement(sbNewStringBuilder.toString());
        if (str == null) {
            supportSQLiteStatementCompileStatement.bindNull(1);
        } else {
            supportSQLiteStatementCompileStatement.bindString(1, str);
        }
        int i2 = 2;
        for (String str2 : list) {
            if (str2 == null) {
                supportSQLiteStatementCompileStatement.bindNull(i2);
            } else {
                supportSQLiteStatementCompileStatement.bindString(i2, str2);
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

    @Override // e.c.a.g.a.d.f.c.a.m
    public void x(String str, List<Long> list) {
        this.c.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM playlistsong WHERE global_id=");
        sbNewStringBuilder.append("?");
        sbNewStringBuilder.append(" AND mixId in (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, list.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.c.compileStatement(sbNewStringBuilder.toString());
        if (str == null) {
            supportSQLiteStatementCompileStatement.bindNull(1);
        } else {
            supportSQLiteStatementCompileStatement.bindString(1, str);
        }
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

    @Override // e.c.a.g.a.d.f.c.a.m
    public int y(String str, List<Long> list, List<Long> list2) {
        this.c.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM playlistsong WHERE global_id=");
        sbNewStringBuilder.append("?");
        sbNewStringBuilder.append(" AND mixId IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") OR mixId < 0 AND mMusicId IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, list2.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.c.compileStatement(sbNewStringBuilder.toString());
        if (str == null) {
            supportSQLiteStatementCompileStatement.bindNull(1);
        } else {
            supportSQLiteStatementCompileStatement.bindString(1, str);
        }
        int i2 = 2;
        for (Long l : list) {
            if (l == null) {
                supportSQLiteStatementCompileStatement.bindNull(i2);
            } else {
                supportSQLiteStatementCompileStatement.bindLong(i2, l.longValue());
            }
            i2++;
        }
        int i3 = size + 2;
        for (Long l2 : list2) {
            if (l2 == null) {
                supportSQLiteStatementCompileStatement.bindNull(i3);
            } else {
                supportSQLiteStatementCompileStatement.bindLong(i3, l2.longValue());
            }
            i3++;
        }
        this.c.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.c.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.m
    public int z(List<KGPlaylistMusic> list) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            int iHandleMultiple = this.f408f.handleMultiple(list) + 0;
            this.c.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.c.endTransaction();
        }
    }
}
