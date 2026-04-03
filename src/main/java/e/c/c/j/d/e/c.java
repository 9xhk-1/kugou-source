package e.c.c.j.d.e;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static volatile c c;
    public Map<String, Integer> a = new HashMap();
    public Map<String, Set<String>> b = new HashMap();

    public static c e() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public synchronized void a(String str, String str2) {
        b(str).add(str2);
    }

    public final Set<String> b(String str) {
        Set<String> set = this.b.get(str);
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        this.b.put(str, hashSet);
        return hashSet;
    }

    public final synchronized int c(String str) {
        Set<String> setB = b(str);
        if (setB == null) {
            return 0;
        }
        return setB.size();
    }

    public final int d(String str) {
        Integer num = this.a.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean f(String str) {
        return d(str) == c(str);
    }

    public void g(String str, int i2) {
        this.a.put(str, Integer.valueOf(i2));
    }
}
