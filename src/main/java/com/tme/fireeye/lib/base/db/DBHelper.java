package com.tme.fireeye.lib.base.db;

import android.content.Context;
import e.f.a.b.a.g.c;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class DBHelper extends SqliteHelper {
    public static final a Companion = new a(null);
    private static final String DATABASE_NAME = "fireeye_base_db";
    private static volatile DBHelper helper;
    private final c dbHandler;

    public static final class a {
        public a() {
        }

        public final DBHelper a(Context context) {
            j.f(context, "context");
            DBHelper dBHelper = DBHelper.helper;
            if (dBHelper == null) {
                synchronized (this) {
                    dBHelper = DBHelper.helper;
                    if (dBHelper == null) {
                        dBHelper = new DBHelper(context);
                        DBHelper.helper = dBHelper;
                    }
                }
            }
            return dBHelper;
        }

        public final void b(String str, String str2) {
            j.f(str, "tableName");
            j.f(str2, "createSql");
            SqliteHelper.Companion.b(str, str2);
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null);
        j.f(context, "context");
        this.dbHandler = c.f1466d.a(this);
    }

    public static final DBHelper getInstance(Context context) {
        return Companion.a(context);
    }

    public static final void registerTable(String str, String str2) {
        Companion.b(str, str2);
    }

    public final c getDbHandler() {
        return this.dbHandler;
    }
}
