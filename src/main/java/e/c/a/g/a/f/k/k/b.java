package e.c.a.g.a.f.k.k;

import e.c.a.g.a.s.g0;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static volatile b c;
    public volatile HashSet<String> a;
    public boolean b = false;

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    public boolean b(String str) {
        if (str.endsWith("/multipart/upload") || str.endsWith("/multipart/query/partnumber") || str.endsWith("/multipart/complete")) {
            return true;
        }
        boolean zContains = this.a.contains(str);
        if (g0.a) {
            g0.e("CoreRequestFilter", "url=" + str + " " + zContains);
        }
        return zContains;
    }

    public boolean c() {
        return this.b;
    }
}
