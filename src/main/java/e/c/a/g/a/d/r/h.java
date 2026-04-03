package e.c.a.g.a.d.r;

import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static boolean a(int i2, int i3) {
        return b(i2) && (i3 & 1) > 0;
    }

    public static boolean b(int i2) {
        return (i2 & 4) == 4;
    }

    public static boolean c(int i2) {
        return (i2 & 8) == 8;
    }

    public static int d(List<e.c.a.g.a.d.r.n.a<?>> list) {
        return -1;
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "album".equalsIgnoreCase(str);
    }

    public static boolean f(int i2, int i3) {
        return c(i2) || a(i2, i3);
    }

    public static boolean g(e.c.a.g.a.d.r.p.a.c cVar) {
        if (cVar != null) {
            return !h(cVar.t());
        }
        return false;
    }

    public static boolean h(int i2) {
        return i2 != 0;
    }
}
