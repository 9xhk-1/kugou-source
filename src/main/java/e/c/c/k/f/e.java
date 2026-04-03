package e.c.c.k.f;

import android.content.ContentValues;
import android.database.Cursor;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import e.c.c.o.l;
import e.c.c.o.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static volatile e c;
    public Map<String, List<b>> a = new HashMap();
    public int b = 0;

    public static e q() {
        if (c == null) {
            synchronized (e.class) {
                if (c == null) {
                    c = new e();
                }
            }
        }
        return c;
    }

    public void a(b bVar) {
        try {
            q().b(bVar.a, bVar.c, bVar.b, bVar.f1252d);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(String str, String str2, String str3, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", str);
        contentValues.put("data", str3);
        contentValues.put("bussiniss", str2);
        contentValues.put("time", Long.valueOf(j));
        contentValues.put("app_version", Integer.valueOf(m.x(e.c.c.o.f.a())));
        if (e.c.c.k.c.c().b(str).e()) {
            contentValues.put("isMomeryCache", Boolean.TRUE);
        }
        try {
            e.c.c.o.f.a().getContentResolver().insert(f.d(), contentValues);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(b bVar) {
        List<b> arrayList = this.a.get(bVar.a);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.a.put(bVar.a, arrayList);
        }
        arrayList.add(bVar);
    }

    public void d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sendATOnce", Boolean.TRUE);
        try {
            e.c.c.o.f.a().getContentResolver().insert(f.d(), contentValues);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e(Long l) {
        try {
            e.c.c.o.f.a().getContentResolver().delete(f.d(), "_id = " + l, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f(List<Long> list) {
        Iterator<Long> it = list.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next().longValue() + ",";
        }
        try {
            e.c.c.o.f.a().getContentResolver().delete(f.d(), "_id in (" + str.substring(0, str.length() - 1) + ")", null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0069 A[Catch: Exception -> 0x0076, TRY_ENTER, TryCatch #2 {Exception -> 0x0076, blocks: (B:3:0x0016, B:17:0x0069, B:19:0x006f, B:20:0x0072, B:5:0x002c, B:7:0x0032, B:13:0x0060, B:15:0x0064), top: B:29:0x0016, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<e.c.c.k.f.g> g(java.lang.String r10) {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SELECT _id,first_post_time,lastsent_begin_id FROM data_collect_info WHERE first_post_time >0 AND lastsent_begin_id >0 And type = "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r6 = r1.toString()
            android.content.Context r10 = e.c.c.o.f.a()     // Catch: java.lang.Exception -> L76
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Exception -> L76
            android.net.Uri r4 = e.c.c.k.f.f.f()     // Catch: java.lang.Exception -> L76
            r5 = 0
            r7 = 0
            java.lang.String r8 = "_id ASC"
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L76
        L2a:
            if (r10 == 0) goto L5e
            boolean r1 = r10.moveToNext()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            if (r1 == 0) goto L5e
            java.lang.String r1 = "_id"
            int r1 = r10.getColumnIndexOrThrow(r1)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            long r3 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            java.lang.String r1 = "first_post_time"
            int r1 = r10.getColumnIndexOrThrow(r1)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            java.lang.String r1 = "lastsent_begin_id"
            int r1 = r10.getColumnIndexOrThrow(r1)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            long r7 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            e.c.c.k.f.g r1 = new e.c.c.k.f.g     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            r2 = r1
            r2.<init>(r3, r5, r7)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            r0.add(r1)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            goto L2a
        L5a:
            r1 = move-exception
            goto L6d
        L5c:
            r1 = move-exception
            goto L64
        L5e:
            if (r10 == 0) goto L73
            r10.close()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            goto L73
        L64:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L5a
            if (r10 == 0) goto L7a
        L69:
            r10.close()     // Catch: java.lang.Exception -> L76
            goto L7a
        L6d:
            if (r10 == 0) goto L72
            r10.close()     // Catch: java.lang.Exception -> L76
        L72:
            throw r1     // Catch: java.lang.Exception -> L76
        L73:
            if (r10 == 0) goto L7a
            goto L69
        L76:
            r10 = move-exception
            r10.printStackTrace()
        L7a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.c.k.f.e.g(java.lang.String):java.util.ArrayList");
    }

    public long h() {
        long j = q().j();
        e.c.c.o.g.a("siganid", "getCacheSize:" + j);
        return j;
    }

    public int i() {
        if (this.b == 0) {
            int iX = m.x(e.c.c.o.f.a());
            e.c.c.o.g.a("siganid", "之前的版本的版本号:0");
            e.c.c.o.g.a("siganid", "当前版本的版本号:" + iX);
            if (iX == 0) {
                e.c.c.o.g.a("siganid", "旧数据版本号为0：上个版本号=当前版本号curDatasAppVersion取0");
            } else {
                this.b = 0;
            }
        }
        return this.b;
    }

    public long j() {
        try {
            Cursor cursorQuery = e.c.c.o.f.a().getContentResolver().query(f.f(), null, "SELECT  COUNT(*)  FROM data_collect_info", null, null);
            long j = (cursorQuery == null || !cursorQuery.moveToNext()) ? 0L : cursorQuery.getInt(0);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return j;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public long k() {
        return l.e(e.c.c.o.f.a()).b("data_collect_starttime", System.currentTimeMillis()).longValue();
    }

    public Map<Long, List<b>> l(String str) {
        HashMap map = new HashMap();
        for (g gVar : q().g(str)) {
            List<b> listR = q().r(str, gVar.b(), gVar.c());
            if (listR != null) {
                List list = (List) map.get(Long.valueOf(gVar.a()));
                if (list == null) {
                    map.put(Long.valueOf(gVar.a()), listR);
                } else {
                    list.addAll(listR);
                }
            }
        }
        return map;
    }

    public long m() {
        return l.e(e.c.c.o.f.a()).b("data_collect_last_starttime", System.currentTimeMillis()).longValue();
    }

    public int n() {
        try {
            Cursor cursorQuery = e.c.c.o.f.a().getContentResolver().query(f.f(), null, "SELECT app_version FROM data_collect_info ORDER BY app_version ASC  LIMIT 0,1;", null, null);
            try {
                try {
                    int iX = m.x(e.c.c.o.f.a());
                    while (cursorQuery != null && cursorQuery.moveToNext()) {
                        iX = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("app_version"));
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return iX;
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return m.x(e.c.c.o.f.a());
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            return m.x(e.c.c.o.f.a());
        }
    }

    public List<b> o(String str) {
        return this.a.get(str);
    }

    public List<b> p(String str) {
        List<b> listR = q().r(str, 0L, 0L);
        if (listR == null) {
            return null;
        }
        return listR;
    }

    public List<b> r(String str, long j, long j2) {
        String str2;
        int iN = n();
        this.b = iN;
        if (iN == 0) {
            str2 = "SELECT type,_id,time,data,bussiniss FROM data_collect_info WHERE (app_version IS NULL  OR TYPE = \"START_UP\") AND type = " + str + " LIMIT 1000 ;";
        } else {
            str2 = "SELECT type,_id,time,data,bussiniss FROM data_collect_info WHERE (app_version=" + this.b + " OR TYPE = \"START_UP\") AND type = " + str + " LIMIT 1000 ;";
        }
        if (j2 > 0) {
            str2 = "SELECT type,_id,time,data,bussiniss FROM data_collect_info WHERE (_id>=" + j + " AND " + DbOpenHelper.ID + "<=" + j2 + " OR TYPE = \"START_UP\") AND type = " + str;
        }
        String str3 = str2;
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = e.c.c.o.f.a().getContentResolver().query(f.f(), null, str3, null, "_id ASC");
            while (cursorQuery != null) {
                try {
                    try {
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("type"));
                        long j3 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("time"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("data"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("bussiniss"));
                        long j4 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow(DbOpenHelper.ID));
                        if (str != null) {
                            b bVar = new b(string, string3, string2, j3);
                            bVar.f(j4);
                            arrayList.add(bVar);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (cursorQuery == null) {
                            return null;
                        }
                        cursorQuery.close();
                        return null;
                    }
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public void s(long j, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", str);
        try {
            e.c.c.o.f.a().getContentResolver().update(f.d(), contentValues, "_id = " + j, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void t(long j, long j2, long j3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_post_time", Long.valueOf(j));
        contentValues.put("lastsent_begin_id", Long.valueOf(j2));
        try {
            e.c.c.o.f.a().getContentResolver().update(f.d(), contentValues, "_id = " + j3, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
