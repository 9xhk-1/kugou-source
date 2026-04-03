package e.c.c.o;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public class l {
    public static l b;
    public SharedPreferences a;

    public l(Context context) {
        f(context);
    }

    public static l e(Context context) {
        if (b == null) {
            b = new l(context);
        }
        return b;
    }

    public String a() {
        return d("auto_save_imei", "");
    }

    public Long b(String str, long j) {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences == null ? Long.valueOf(j) : Long.valueOf(sharedPreferences.getLong(str, j));
    }

    public String c() {
        return d("key_rich_imei", null);
    }

    public String d(String str, String str2) {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
    }

    public void f(Context context) {
        this.a = context.getSharedPreferences("bisdk", 4);
    }

    public void g(String str, String str2) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public void h(String str) {
        g("auto_save_imei", str);
    }

    public void i(String str) {
        g("key_rich_imei", str);
    }
}
