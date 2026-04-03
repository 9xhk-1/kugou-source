package e.g.b;

import android.util.Log;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public final void a(String str, String str2) {
        j.e(str, "tag");
        j.e(str2, "message");
        Log.d(str, e(c(), str2));
    }

    public final void b(String str, String str2) {
        j.e(str, "tag");
        j.e(str2, "message");
        Log.e(str, e(c(), str2));
    }

    public abstract String c();

    public final void d(String str, String str2) {
        j.e(str, "tag");
        j.e(str2, "message");
        Log.i(str, e(c(), str2));
    }

    public final String e(String str, String str2) {
        return str + " | " + str2;
    }

    public final void f(String str, String str2) {
        j.e(str, "tag");
        j.e(str2, "message");
        Log.w(str, e(c(), str2));
    }
}
