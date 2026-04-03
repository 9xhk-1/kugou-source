package e.f.a.a.a.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import e.f.a.a.a.k.f;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static b a = null;
    public static DbOpenHelper b = null;
    public static boolean c = false;

    public class a extends Thread {
        public int a;
        public e.f.a.a.a.g.a b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f1336d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ContentValues f1337f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f1338h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String[] f1339i;
        public String j;
        public String[] k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String[] q;
        public int r;
        public String s;
        public byte[] t;

        public a(int i2, e.f.a.a.a.g.a aVar) {
            this.a = i2;
            this.b = aVar;
        }

        public void a(String str, String str2, String[] strArr) {
            this.f1336d = str;
            this.p = str2;
            this.q = strArr;
        }

        public void b(int i2) {
            this.r = i2;
        }

        public void c(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f1338h = z;
            this.f1336d = str;
            this.f1339i = strArr;
            this.j = str2;
            this.k = strArr2;
            this.l = str3;
            this.m = str4;
            this.n = str5;
            this.o = str6;
        }

        public void d(String str, ContentValues contentValues) {
            this.f1336d = str;
            this.f1337f = contentValues;
        }

        public void e(int i2, String str, byte[] bArr) {
            this.r = i2;
            this.s = str;
            this.t = bArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            switch (this.a) {
                case 1:
                    b.this.n(this.f1336d, this.f1337f, this.b);
                    break;
                case 2:
                    b.this.j(this.f1336d, this.p, this.q, this.b);
                    break;
                case 3:
                    Cursor cursorL = b.this.l(this.f1338h, this.f1336d, this.f1339i, this.j, this.k, this.l, this.m, this.n, this.o, this.b);
                    if (cursorL != null) {
                        cursorL.close();
                    }
                    break;
                case 4:
                    b.this.o(this.r, this.s, this.t, this.b);
                    break;
                case 5:
                    b.this.k(this.r, this.b);
                    break;
                case 6:
                    b.this.m(this.r, this.s, this.b);
                    break;
            }
        }
    }

    public b(Context context, List<e.f.a.a.a.a> list) {
        b = new DbOpenHelper(context, list);
    }

    public static synchronized b r() {
        return a;
    }

    public static synchronized b s(Context context, List<e.f.a.a.a.a> list) {
        if (a == null) {
            a = new b(context, list);
        }
        return a;
    }

    public long A(String str, ContentValues contentValues, e.f.a.a.a.g.a aVar, boolean z) {
        if (z) {
            return n(str, contentValues, aVar);
        }
        a aVar2 = new a(1, aVar);
        aVar2.d(str, contentValues);
        e.f.a.a.a.k.a.b().d(aVar2);
        return 0L;
    }

    public final synchronized boolean B(c cVar) {
        ContentValues contentValuesQ;
        if (cVar == null) {
            return false;
        }
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = b.getWritableDatabase();
            if (writableDatabase == null || (contentValuesQ = q(cVar)) == null) {
                if (c && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            }
            long jReplace = writableDatabase.replace(DbOpenHelper.TABLE_PREFERENCE, DbOpenHelper.ID, contentValuesQ);
            if (jReplace >= 0) {
                e.f.a.a.a.k.c.b("[Database] insert %s success.", DbOpenHelper.TABLE_PREFERENCE);
                cVar.a = jReplace;
                return true;
            }
            if (c && writableDatabase != null) {
                writableDatabase.close();
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!e.f.a.a.a.k.c.k(th)) {
                    th.printStackTrace();
                }
                if (c && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            } finally {
                if (c && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }

    public synchronized boolean C(c cVar) {
        ContentValues contentValuesP;
        if (cVar == null) {
            return false;
        }
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = b.getWritableDatabase();
            if (writableDatabase == null || (contentValuesP = p(cVar)) == null) {
                if (c && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            }
            long jReplace = writableDatabase.replace(DbOpenHelper.TABLE_LOCAL_RECORD, DbOpenHelper.ID, contentValuesP);
            if (jReplace >= 0) {
                e.f.a.a.a.k.c.b("[Database] insert %s success.", DbOpenHelper.TABLE_LOCAL_RECORD);
                cVar.a = jReplace;
                return true;
            }
            if (c && writableDatabase != null) {
                writableDatabase.close();
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!e.f.a.a.a.k.c.k(th)) {
                    th.printStackTrace();
                }
                if (c && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            } finally {
                if (c && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }

    public boolean D(int i2, String str, byte[] bArr, e.f.a.a.a.g.a aVar, boolean z) {
        if (z) {
            return o(i2, str, bArr, aVar);
        }
        a aVar2 = new a(4, aVar);
        aVar2.e(i2, str, bArr);
        e.f.a.a.a.k.a.b().d(aVar2);
        return true;
    }

    public c g(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            c cVar = new c();
            cVar.a = cursor.getLong(cursor.getColumnIndex(DbOpenHelper.ID));
            cVar.b = cursor.getInt(cursor.getColumnIndex(DbOpenHelper.TYPE));
            cVar.c = cursor.getString(cursor.getColumnIndex(DbOpenHelper.PROCESS));
            cVar.f1340d = cursor.getString(cursor.getColumnIndex(DbOpenHelper.THREAD));
            cVar.f1341e = cursor.getLong(cursor.getColumnIndex(DbOpenHelper.TIME));
            cVar.f1343g = cursor.getBlob(cursor.getColumnIndex(DbOpenHelper.DATAS));
            return cVar;
        } catch (Throwable th) {
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public c h(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            c cVar = new c();
            cVar.a = cursor.getLong(cursor.getColumnIndex(DbOpenHelper.ID));
            cVar.f1341e = cursor.getLong(cursor.getColumnIndex(DbOpenHelper.TIME));
            cVar.f1342f = cursor.getString(cursor.getColumnIndex(DbOpenHelper.TYPE));
            cVar.f1343g = cursor.getBlob(cursor.getColumnIndex(DbOpenHelper.DATAS));
            return cVar;
        } catch (Throwable th) {
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public int i(String str, String str2, String[] strArr, e.f.a.a.a.g.a aVar, boolean z) {
        if (z) {
            return j(str, str2, strArr, aVar);
        }
        a aVar2 = new a(2, aVar);
        aVar2.a(str, str2, strArr);
        e.f.a.a.a.k.a.b().d(aVar2);
        return 0;
    }

    public final synchronized int j(String str, String str2, String[] strArr, e.f.a.a.a.g.a aVar) {
        int iDelete;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = b.getWritableDatabase();
            iDelete = writableDatabase != null ? writableDatabase.delete(str, str2, strArr) : 0;
        } catch (Throwable th) {
            try {
                if (!e.f.a.a.a.k.c.k(th)) {
                    th.printStackTrace();
                }
                if (aVar != null) {
                    aVar.onResult(0);
                }
                if (c && writableDatabase != null) {
                }
            } finally {
                if (aVar != null) {
                    aVar.onResult(0);
                }
                if (c && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
        return iDelete;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d A[DONT_GENERATE, PHI: r0
  0x002d: PHI (r0v1 java.util.HashMap) = (r0v3 java.util.HashMap), (r0v4 java.util.HashMap) binds: [B:22:0x003b, B:16:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.String, byte[]> k(int r4, e.f.a.a.a.g.a r5) {
        /*
            r3 = this;
            r0 = 0
            java.util.List r4 = r3.u(r4)     // Catch: java.lang.Throwable -> L31
            if (r4 == 0) goto L2b
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L31
            r1.<init>()     // Catch: java.lang.Throwable -> L31
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L28
        L10:
            boolean r0 = r4.hasNext()     // Catch: java.lang.Throwable -> L28
            if (r0 == 0) goto L26
            java.lang.Object r0 = r4.next()     // Catch: java.lang.Throwable -> L28
            e.f.a.a.a.g.c r0 = (e.f.a.a.a.g.c) r0     // Catch: java.lang.Throwable -> L28
            byte[] r2 = r0.f1343g     // Catch: java.lang.Throwable -> L28
            if (r2 == 0) goto L10
            java.lang.String r0 = r0.f1342f     // Catch: java.lang.Throwable -> L28
            r1.put(r0, r2)     // Catch: java.lang.Throwable -> L28
            goto L10
        L26:
            r0 = r1
            goto L2b
        L28:
            r4 = move-exception
            r0 = r1
            goto L32
        L2b:
            if (r5 == 0) goto L3e
        L2d:
            r5.onResult(r0)
            goto L3e
        L31:
            r4 = move-exception
        L32:
            boolean r1 = e.f.a.a.a.k.c.k(r4)     // Catch: java.lang.Throwable -> L3f
            if (r1 != 0) goto L3b
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L3f
        L3b:
            if (r5 == 0) goto L3e
            goto L2d
        L3e:
            return r0
        L3f:
            r4 = move-exception
            if (r5 == 0) goto L45
            r5.onResult(r0)
        L45:
            goto L47
        L46:
            throw r4
        L47:
            goto L46
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.a.a.a.g.b.k(int, e.f.a.a.a.g.a):java.util.Map");
    }

    public final synchronized Cursor l(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, e.f.a.a.a.g.a aVar) {
        Cursor cursorQuery;
        try {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            cursorQuery = writableDatabase != null ? writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6) : null;
        } catch (Throwable th) {
            try {
                if (!e.f.a.a.a.k.c.k(th)) {
                    th.printStackTrace();
                }
                if (aVar != null) {
                }
            } finally {
                if (aVar != null) {
                    aVar.onResult(null);
                }
            }
        }
        return cursorQuery;
    }

    public final synchronized boolean m(int i2, String str, e.f.a.a.a.g.a aVar) {
        boolean z;
        String str2;
        SQLiteDatabase sQLiteDatabase = null;
        z = false;
        try {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    if (f.q(str)) {
                        str2 = "_id = " + i2;
                    } else {
                        str2 = "_id = " + i2 + " and " + DbOpenHelper.TYPE + " = \"" + str + "\"";
                    }
                    int iDelete = writableDatabase.delete(DbOpenHelper.TABLE_PREFERENCE, str2, null);
                    e.f.a.a.a.k.c.b("[Database] deleted %s data %d", DbOpenHelper.TABLE_PREFERENCE, Integer.valueOf(iDelete));
                    if (iDelete > 0) {
                        z = true;
                    }
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase = writableDatabase;
                    try {
                        if (!e.f.a.a.a.k.c.k(th)) {
                            th.printStackTrace();
                        }
                    } finally {
                        if (aVar != null) {
                            aVar.onResult(Boolean.FALSE);
                        }
                        if (c && sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                    }
                }
            }
            if (aVar != null) {
                aVar.onResult(Boolean.valueOf(z));
            }
            if (c && writableDatabase != null) {
                writableDatabase.close();
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return z;
    }

    public final synchronized long n(String str, ContentValues contentValues, e.f.a.a.a.g.a aVar) {
        long j;
        j = 0;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null && contentValues != null) {
                long jReplace = writableDatabase.replace(str, DbOpenHelper.ID, contentValues);
                if (jReplace >= 0) {
                    e.f.a.a.a.k.c.b("[Database] insert %s success.", str);
                } else {
                    e.f.a.a.a.k.c.j("[Database] replace %s error.", str);
                }
                j = jReplace;
            }
        } catch (Throwable th) {
            try {
                if (!e.f.a.a.a.k.c.k(th)) {
                    th.printStackTrace();
                }
                if (aVar != null) {
                    aVar.onResult(0L);
                }
                if (c && 0 != 0) {
                }
            } finally {
                if (aVar != null) {
                    aVar.onResult(0L);
                }
                if (c && 0 != 0) {
                    writableDatabase.close();
                }
            }
        }
        return j;
    }

    public final boolean o(int i2, String str, byte[] bArr, e.f.a.a.a.g.a aVar) {
        try {
            c cVar = new c();
            cVar.a = i2;
            cVar.f1342f = str;
            cVar.f1341e = System.currentTimeMillis();
            cVar.f1343g = bArr;
            boolean zB = B(cVar);
            if (aVar == null) {
                return zB;
            }
            aVar.onResult(Boolean.valueOf(zB));
            return zB;
        } catch (Throwable th) {
            try {
                if (!e.f.a.a.a.k.c.k(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
                if (aVar != null) {
                    aVar.onResult(Boolean.FALSE);
                }
            }
        }
    }

    public ContentValues p(c cVar) {
        if (cVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j = cVar.a;
            if (j > 0) {
                contentValues.put(DbOpenHelper.ID, Long.valueOf(j));
            }
            contentValues.put(DbOpenHelper.TYPE, Integer.valueOf(cVar.b));
            contentValues.put(DbOpenHelper.PROCESS, cVar.c);
            contentValues.put(DbOpenHelper.THREAD, cVar.f1340d);
            contentValues.put(DbOpenHelper.TIME, Long.valueOf(cVar.f1341e));
            byte[] bArr = cVar.f1343g;
            if (bArr != null) {
                contentValues.put(DbOpenHelper.DATAS, bArr);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public ContentValues q(c cVar) {
        if (cVar != null && !f.q(cVar.f1342f)) {
            try {
                ContentValues contentValues = new ContentValues();
                long j = cVar.a;
                if (j > 0) {
                    contentValues.put(DbOpenHelper.ID, Long.valueOf(j));
                }
                contentValues.put(DbOpenHelper.TYPE, cVar.f1342f);
                contentValues.put(DbOpenHelper.TIME, Long.valueOf(cVar.f1341e));
                byte[] bArr = cVar.f1343g;
                if (bArr != null) {
                    contentValues.put(DbOpenHelper.DATAS, bArr);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!e.f.a.a.a.k.c.k(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c4 A[Catch: all -> 0x00d6, TRY_LEAVE, TryCatch #0 {all -> 0x00d6, blocks: (B:44:0x00be, B:46:0x00c4), top: B:68:0x00be, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c9 A[Catch: all -> 0x00e8, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:14:0x0034, B:15:0x0037, B:18:0x003d, B:35:0x00ac, B:36:0x00af, B:39:0x00b5, B:48:0x00c9, B:49:0x00cc, B:52:0x00d2, B:55:0x00d9, B:56:0x00dc, B:59:0x00e2, B:60:0x00e5, B:44:0x00be, B:46:0x00c4), top: B:70:0x0001, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<e.f.a.a.a.g.c> t(int r12) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.a.a.a.g.b.t(int):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cb A[Catch: all -> 0x00cf, PHI: r1
  0x00cb: PHI (r1v2 android.database.sqlite.SQLiteDatabase) = (r1v1 android.database.sqlite.SQLiteDatabase), (r1v4 android.database.sqlite.SQLiteDatabase) binds: [B:57:0x00e6, B:43:0x00c9] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #5 {, blocks: (B:9:0x002c, B:10:0x002f, B:13:0x0035, B:30:0x00b2, B:31:0x00b5, B:34:0x00bb, B:54:0x00df, B:55:0x00e2, B:44:0x00cb, B:63:0x00ee, B:64:0x00f1, B:67:0x00f7, B:68:0x00fa, B:41:0x00c5, B:50:0x00d4, B:52:0x00da), top: B:83:0x0002, inners: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List<e.f.a.a.a.g.c> u(int r12) {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.a.a.a.g.b.u(int):java.util.List");
    }

    public Map<String, byte[]> v(int i2, e.f.a.a.a.g.a aVar, boolean z) {
        if (z) {
            return k(i2, aVar);
        }
        a aVar2 = new a(5, aVar);
        aVar2.b(i2);
        e.f.a.a.a.k.a.b().d(aVar2);
        return null;
    }

    public Cursor w(String str, String[] strArr, String str2, String[] strArr2, e.f.a.a.a.g.a aVar, boolean z) {
        return x(false, str, strArr, str2, strArr2, null, null, null, null, aVar, z);
    }

    public Cursor x(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, e.f.a.a.a.g.a aVar, boolean z2) {
        if (z2) {
            return l(z, str, strArr, str2, strArr2, str3, str4, str5, str6, aVar);
        }
        a aVar2 = new a(3, aVar);
        aVar2.c(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
        e.f.a.a.a.k.a.b().d(aVar2);
        return null;
    }

    public synchronized void y(int i2) {
        String str;
        SQLiteDatabase writableDatabase = b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i2 >= 0) {
                try {
                    str = "_tp = " + i2;
                } catch (Throwable th) {
                    try {
                        if (!e.f.a.a.a.k.c.k(th)) {
                            th.printStackTrace();
                        }
                        if (c && writableDatabase != null) {
                        }
                    } finally {
                        if (c && writableDatabase != null) {
                            writableDatabase.close();
                        }
                    }
                }
            } else {
                str = null;
            }
            e.f.a.a.a.k.c.b("[Database] deleted %s data %d", DbOpenHelper.TABLE_LOCAL_RECORD, Integer.valueOf(writableDatabase.delete(DbOpenHelper.TABLE_LOCAL_RECORD, str, null)));
        }
    }

    public synchronized void z(List<c> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = b.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    for (c cVar : list) {
                        sb.append(" or ");
                        sb.append(DbOpenHelper.ID);
                        sb.append(" = ");
                        sb.append(cVar.a);
                    }
                    String string = sb.toString();
                    if (string.length() > 0) {
                        string = string.substring(4);
                    }
                    sb.setLength(0);
                    try {
                        e.f.a.a.a.k.c.b("[Database] deleted %s data %d", DbOpenHelper.TABLE_LOCAL_RECORD, Integer.valueOf(writableDatabase.delete(DbOpenHelper.TABLE_LOCAL_RECORD, string, null)));
                    } catch (Throwable th) {
                        try {
                            if (!e.f.a.a.a.k.c.k(th)) {
                                th.printStackTrace();
                            }
                            if (c) {
                            }
                        } finally {
                            if (c) {
                                writableDatabase.close();
                            }
                        }
                    }
                }
            }
        }
    }
}
