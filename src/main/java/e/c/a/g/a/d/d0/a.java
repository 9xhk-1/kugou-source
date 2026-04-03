package e.c.a.g.a.d.d0;

import android.text.TextUtils;
import android.util.Log;
import e.c.c.o.g;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static boolean a;
    public static boolean b;

    static {
        c cVar = c.a;
        a = cVar.r();
        b = cVar.r();
    }

    public static void a(String str, String str2) {
        if (b) {
            String strC = c(str2);
            if (g.d()) {
                Log.d("XKGLog-" + str, strC);
            }
            c.a.b(str, strC);
        }
    }

    public static void b(String str, String str2) {
        if (b) {
            String strC = c(str2);
            if (g.d()) {
                Log.i("XKGLog-" + str, strC);
            }
            c.a.p(str, strC);
        }
    }

    public static String c(String str) {
        return (TextUtils.isEmpty(str) || str.length() <= 1000) ? str : str.substring(0, 1000);
    }
}
