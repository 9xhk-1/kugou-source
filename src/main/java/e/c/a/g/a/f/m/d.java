package e.c.a.g.a.f.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import e.c.a.g.a.s.g0;
import e.c.c.o.f;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile d f695d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f696e = "LAST_NEW_SONG_PUBLISH_REQUEST_RECOMMEND_TIME";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f697f = "LAST_NEW_SONG_PUBLISH_SINCE_ID";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f698g = "NEW_SONG_PUBLISH_REFRESH_ELAPSED_REALTIME";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f699h = "NEW_SONG_PUBLISH_LAST_REQUEST_NUM";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f700i = "key_xtc_voice_enable";
    public final Context a;
    public final String b;
    public final int c;

    public d(Context context, String str, int i2) {
        this.a = context;
        this.b = str;
        this.c = i2;
    }

    public static boolean a() {
        return c().b(f700i, true);
    }

    public static d c() {
        if (f695d == null) {
            f695d = new d(f.a(), "fore_process", 0);
        }
        return f695d;
    }

    public static long e(int i2) {
        return c().d(f697f + i2, 0L);
    }

    public static boolean g(boolean z) {
        return c().b("sp_key_enable_catch_timeout_exception", z);
    }

    public static boolean h(boolean z) {
        return c().b("sp_key_enable_kill_timeout_exception", z);
    }

    public static boolean l(boolean z) {
        return c().i("sp_key_enable_catch_timeout_exception", z);
    }

    public static boolean m(boolean z) {
        return c().i("sp_key_enable_kill_timeout_exception", z);
    }

    public static void n(int i2) {
        if (i2 > 0) {
            c().j(f699h, i2);
        }
    }

    public static void o(long j) {
        if (j > 0) {
            c().k(f698g, j);
        }
    }

    public static void p(boolean z) {
        c().i(f700i, z);
    }

    public static void q(int i2) {
        c().k(f696e + i2, System.currentTimeMillis());
    }

    public static void r(int i2, long j) {
        if (j <= 0) {
            return;
        }
        c().k(f697f + i2, j);
    }

    public final boolean b(String str, boolean z) {
        SharedPreferences sharedPreferencesF = f();
        return sharedPreferencesF != null ? sharedPreferencesF.getBoolean(str, z) : z;
    }

    public final long d(String str, long j) {
        SharedPreferences sharedPreferencesF = f();
        return sharedPreferencesF != null ? sharedPreferencesF.getLong(str, j) : j;
    }

    public final SharedPreferences f() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.a.getSharedPreferences(this.b, this.c);
        }
        if (!g0.a) {
            return null;
        }
        g0.c("SharedPreferencesDelegate::getSharedPreferences", "error mNameOfFile " + this.b + " mode " + this.c);
        return null;
    }

    public final boolean i(String str, boolean z) {
        SharedPreferences sharedPreferencesF = f();
        if (sharedPreferencesF != null) {
            return sharedPreferencesF.edit().putBoolean(str, z).commit();
        }
        return false;
    }

    public final boolean j(String str, int i2) {
        SharedPreferences sharedPreferencesF = f();
        if (sharedPreferencesF != null) {
            return sharedPreferencesF.edit().putInt(str, i2).commit();
        }
        return false;
    }

    public final boolean k(String str, long j) {
        SharedPreferences sharedPreferencesF = f();
        if (sharedPreferencesF != null) {
            return sharedPreferencesF.edit().putLong(str, j).commit();
        }
        return false;
    }
}
