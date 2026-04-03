package e.c.a.g.a.f.m;

import android.content.Context;
import android.content.SharedPreferences;
import com.kugou.android.watch.lite.base.application.KGApplication;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static volatile a b;
    public final Context a = KGApplication.getContext();

    public static a b() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public int a(int i2) {
        return c("key_app_ver_code", i2);
    }

    public final int c(String str, int i2) {
        SharedPreferences sharedPreferencesE = e();
        return sharedPreferencesE != null ? sharedPreferencesE.getInt(str, i2) : i2;
    }

    public int d(int i2) {
        try {
            return c("key_old_app_ver_code", i2);
        } catch (Exception unused) {
            return i2;
        }
    }

    public final SharedPreferences e() {
        return this.a.getSharedPreferences("app_info", 0);
    }

    public final boolean f(String str, int i2) {
        SharedPreferences sharedPreferencesE = e();
        if (sharedPreferencesE != null) {
            return sharedPreferencesE.edit().putInt(str, i2).commit();
        }
        return false;
    }

    public boolean g(int i2) {
        return f("key_app_ver_code", i2);
    }

    public boolean h(int i2) {
        return f("key_old_app_ver_code", i2);
    }
}
