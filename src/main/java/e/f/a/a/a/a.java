package e.f.a.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tme.fireeye.crash.comm.strategy.StrategyBean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public int a;
    public String b;
    public String c;

    public abstract String[] a();

    public abstract void b(Context context, boolean z, b bVar);

    public void c(SQLiteDatabase sQLiteDatabase) {
    }

    public void d(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        try {
            if (a() == null) {
                return;
            }
            for (String str : a()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
            }
            c(sQLiteDatabase);
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.d(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void e(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        try {
            if (a() == null) {
                return;
            }
            for (String str : a()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
            }
            c(sQLiteDatabase);
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.d(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void f(StrategyBean strategyBean) {
    }
}
