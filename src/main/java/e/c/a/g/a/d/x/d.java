package e.c.a.g.a.d.x;

import android.text.TextUtils;
import e.c.a.g.a.s.q;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final String a;
    public static final String b;

    static {
        String str = e.c.a.g.a.f.f.a.o + "/default/";
        a = str;
        b = str;
    }

    public static long a(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return 0L;
        }
        return new File(str).length();
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static boolean c(String str, int i2, long j, boolean z) {
        return b(d(e(str, i2, j, z)));
    }

    public static String d(String str) {
        File file = new File(b, "done");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str).getAbsolutePath();
    }

    public static String e(String str, int i2, long j, boolean z) {
        if (!z) {
            return (str + "-" + i2 + "-" + j).toLowerCase() + e.c.a.g.a.f.f.a.f653i;
        }
        return (str + "-" + i2 + "-" + j).toLowerCase() + "-part" + e.c.a.g.a.f.f.a.f653i;
    }

    public static String f(String str) {
        String str2 = b;
        if (!q.F(str2)) {
            q.f(str2);
        }
        return new File(str2, str).getAbsolutePath();
    }
}
