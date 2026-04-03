package e.c.a.g.a.g.e;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static String c = "grade_limit_songs";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static f f761d;
    public SharedPreferences a;
    public String b = "mixsong_grade_user_settings";

    public f(Context context) {
        this.a = context.getSharedPreferences("mixsong_grade_user_settings", 0);
    }

    public static f a(Context context) {
        if (f761d == null) {
            synchronized (f.class) {
                if (f761d == null) {
                    f761d = new f(context.getApplicationContext());
                }
            }
        }
        return f761d;
    }

    public String b(String str, String str2) {
        return this.a.getString(str, str2);
    }

    public void c(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.a.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }
}
