package e.c.c.j.d.e;

import e.c.c.o.g;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static volatile b b;
    public Map<String, Integer> a = new HashMap();

    public static b b() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    public String a(String str) {
        try {
            return str.split("-")[0];
        } catch (Exception unused) {
            g.a("autoapm", "getKey: 不合法session");
            return "";
        }
    }

    public String c(String str) {
        Integer num = this.a.get(str);
        int iValueOf = num == null ? 1 : Integer.valueOf(num.intValue() + 1);
        String str2 = str + "-" + iValueOf;
        this.a.put(str, iValueOf);
        return str2;
    }
}
