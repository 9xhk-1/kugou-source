package e.f.a.a.a.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.kugou.framework.lyric.LyricManager;
import com.tme.fireeye.crash.comm.biz.UserInfoBean;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import e.f.a.a.a.k.f;
import e.f.a.a.d.a.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public Context a;
    public long b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1326d;

    /* JADX INFO: renamed from: e.f.a.a.a.e.a$a, reason: collision with other inner class name */
    public class C0243a implements e.f.a.a.a.j.c {
        public final /* synthetic */ List a;

        public C0243a(List list) {
            this.a = list;
        }

        @Override // e.f.a.a.a.j.c
        public void onUploadEnd(int i2, g gVar, long j, long j2, boolean z, String str) {
            if (z) {
                e.f.a.a.a.k.c.b("[UserInfo] Successfully uploaded user info.", new Object[0]);
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (UserInfoBean userInfoBean : this.a) {
                    userInfoBean.f267i = jCurrentTimeMillis;
                    a.this.m(userInfoBean, true);
                }
            }
        }

        @Override // e.f.a.a.a.j.c
        public void onUploadStart(int i2) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.o();
            } catch (Throwable th) {
                e.f.a.a.a.k.c.k(th);
            }
        }
    }

    public class c implements Runnable {
        public boolean a;
        public UserInfoBean b;

        public c(UserInfoBean userInfoBean, boolean z) {
            this.b = userInfoBean;
            this.a = z;
        }

        public final void a(UserInfoBean userInfoBean) {
            e.f.a.a.a.h.b bVarM;
            if (userInfoBean == null || (bVarM = e.f.a.a.a.h.b.m()) == null) {
                return;
            }
            userInfoBean.m = bVarM.t();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                UserInfoBean userInfoBean = this.b;
                if (userInfoBean != null) {
                    a(userInfoBean);
                    e.f.a.a.a.k.c.b("[UserInfo] Record user info.", new Object[0]);
                    a.this.m(this.b, false);
                }
                if (this.a) {
                    a.this.n();
                }
            } catch (Throwable th) {
                if (e.f.a.a.a.k.c.k(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis >= a.this.b) {
                a.this.i(3, false, 0L);
                a.this.e();
            } else {
                e.f.a.a.a.k.a aVarB = e.f.a.a.a.k.a.b();
                a aVar = a.this;
                aVarB.e(aVar.new d(), (aVar.b - jCurrentTimeMillis) + 5000);
            }
        }
    }

    public class e implements Runnable {
        public long a;

        public e(long j) {
            this.a = 21600000L;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.n();
            a.this.f(this.a);
        }
    }

    public a(Context context, boolean z) {
        this.f1326d = true;
        this.a = context;
        this.f1326d = z;
    }

    public static UserInfoBean g(Context context, int i2) {
        e.f.a.a.a.h.b bVarE = e.f.a.a.a.h.b.e(context);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.b = i2;
        userInfoBean.f264d = bVarE.f1346f;
        userInfoBean.f265f = bVarE.x();
        userInfoBean.f266h = System.currentTimeMillis();
        userInfoBean.f267i = -1L;
        userInfoBean.q = bVarE.d();
        userInfoBean.r = i2 != 1 ? 0 : 1;
        userInfoBean.o = bVarE.B();
        userInfoBean.p = bVarE.R;
        userInfoBean.j = bVarE.S;
        userInfoBean.k = bVarE.T;
        userInfoBean.l = bVarE.U;
        userInfoBean.n = bVarE.V;
        userInfoBean.u = bVarE.h();
        userInfoBean.v = bVarE.g();
        userInfoBean.s = bVarE.z();
        userInfoBean.t = bVarE.s();
        return userInfoBean;
    }

    public void d(long j) {
        e.f.a.a.a.k.a.b().e(new c(null, true), j);
    }

    public void e() {
        this.b = f.o() + 86400000;
        e.f.a.a.a.k.a.b().e(new d(), (this.b - System.currentTimeMillis()) + 5000);
    }

    public void f(long j) {
        e.f.a.a.a.k.a.b().e(new e(j), j);
    }

    public UserInfoBean h(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(DbOpenHelper.DATAS));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex(DbOpenHelper.ID));
            UserInfoBean userInfoBean = (UserInfoBean) f.H(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public void i(int i2, boolean z, long j) {
        e.f.a.a.a.i.a aVarG = e.f.a.a.a.i.a.g();
        if (aVarG != null && !aVarG.h().f270f && i2 != 1 && i2 != 3) {
            e.f.a.a.a.k.c.c("UserInfo is disable", new Object[0]);
            return;
        }
        if (i2 == 1 || i2 == 3) {
            this.c++;
        }
        e.f.a.a.a.k.a.b().e(new c(g(this.a, i2), z), j);
    }

    public ContentValues j(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j = userInfoBean.a;
            if (j > 0) {
                contentValues.put(DbOpenHelper.ID, Long.valueOf(j));
            }
            contentValues.put(DbOpenHelper.TIME, Long.valueOf(userInfoBean.f266h));
            contentValues.put(DbOpenHelper.UPLOAD_TIME, Long.valueOf(userInfoBean.f267i));
            contentValues.put(DbOpenHelper.TYPE, Integer.valueOf(userInfoBean.b));
            contentValues.put(DbOpenHelper.PROCESS, userInfoBean.f264d);
            contentValues.put(DbOpenHelper.DATAS, f.t(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public List<UserInfoBean> k(String str) {
        Cursor cursorW;
        String str2;
        try {
            if (f.q(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + LyricManager.STR_REPLACE_RESULT_TAG;
            }
            cursorW = e.f.a.a.a.g.b.r().w(DbOpenHelper.TABLE_USER_INFO, null, str2, null, null, true);
            if (cursorW == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursorW.moveToNext()) {
                    UserInfoBean userInfoBeanH = h(cursorW);
                    if (userInfoBeanH != null) {
                        arrayList.add(userInfoBeanH);
                    } else {
                        try {
                            long j = cursorW.getLong(cursorW.getColumnIndex(DbOpenHelper.ID));
                            sb.append(" or ");
                            sb.append(DbOpenHelper.ID);
                            sb.append(" = ");
                            sb.append(j);
                        } catch (Throwable unused) {
                            e.f.a.a.a.k.c.j("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String string = sb.toString();
                if (string.length() > 0) {
                    e.f.a.a.a.k.c.j("[Database] deleted %s error data %d", DbOpenHelper.TABLE_USER_INFO, Integer.valueOf(e.f.a.a.a.g.b.r().i(DbOpenHelper.TABLE_USER_INFO, string.substring(4), null, null, true)));
                }
                if (cursorW != null) {
                    cursorW.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!e.f.a.a.a.k.c.k(th)) {
                        th.printStackTrace();
                    }
                    if (cursorW != null) {
                        cursorW.close();
                    }
                    return null;
                } finally {
                    if (cursorW != null) {
                        cursorW.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorW = null;
        }
    }

    public void l(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size() && i2 < 50; i2++) {
            UserInfoBean userInfoBean = list.get(i2);
            sb.append(" or ");
            sb.append(DbOpenHelper.ID);
            sb.append(" = ");
            sb.append(userInfoBean.a);
        }
        String string = sb.toString();
        if (string.length() > 0) {
            string = string.substring(4);
        }
        String str = string;
        sb.setLength(0);
        try {
            e.f.a.a.a.k.c.b("[Database] deleted %s data %d", DbOpenHelper.TABLE_USER_INFO, Integer.valueOf(e.f.a.a.a.g.b.r().i(DbOpenHelper.TABLE_USER_INFO, str, null, null, true)));
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.k(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void m(UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> listK;
        if (userInfoBean == null) {
            return;
        }
        if (!z && userInfoBean.b != 1 && (listK = k(e.f.a.a.a.h.b.e(this.a).f1346f)) != null && listK.size() >= 20) {
            e.f.a.a.a.k.c.f("[UserInfo] There are too many user info in local: %d", Integer.valueOf(listK.size()));
            return;
        }
        long jA = e.f.a.a.a.g.b.r().A(DbOpenHelper.TABLE_USER_INFO, j(userInfoBean), null, true);
        if (jA >= 0) {
            e.f.a.a.a.k.c.b("[Database] insert %s success with ID: %d", DbOpenHelper.TABLE_USER_INFO, Long.valueOf(jA));
            userInfoBean.a = jA;
        }
    }

    public void n() {
        e.f.a.a.a.k.a aVarB = e.f.a.a.a.k.a.b();
        if (aVarB != null) {
            aVarB.d(new b());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00f2 A[Catch: all -> 0x01a4, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x007b, B:38:0x0083, B:39:0x008f, B:40:0x0094, B:42:0x009a, B:44:0x00a8, B:46:0x00b5, B:47:0x00b8, B:49:0x00c6, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:83:0x0137, B:85:0x013f, B:88:0x0148, B:90:0x0150, B:92:0x0154, B:93:0x0178, B:97:0x0196, B:100:0x019b, B:59:0x00e6), top: B:108:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011d A[Catch: all -> 0x01a4, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x007b, B:38:0x0083, B:39:0x008f, B:40:0x0094, B:42:0x009a, B:44:0x00a8, B:46:0x00b5, B:47:0x00b8, B:49:0x00c6, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:83:0x0137, B:85:0x013f, B:88:0x0148, B:90:0x0150, B:92:0x0154, B:93:0x0178, B:97:0x0196, B:100:0x019b, B:59:0x00e6), top: B:108:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0126 A[Catch: all -> 0x01a4, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x007b, B:38:0x0083, B:39:0x008f, B:40:0x0094, B:42:0x009a, B:44:0x00a8, B:46:0x00b5, B:47:0x00b8, B:49:0x00c6, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:83:0x0137, B:85:0x013f, B:88:0x0148, B:90:0x0150, B:92:0x0154, B:93:0x0178, B:97:0x0196, B:100:0x019b, B:59:0x00e6), top: B:108:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void o() {
        /*
            Method dump skipped, instruction units count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.a.a.a.e.a.o():void");
    }
}
