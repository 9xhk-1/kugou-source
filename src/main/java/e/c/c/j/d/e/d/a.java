package e.c.c.j.d.e.d;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public String a;
    public Map<String, String> b;
    public Map<String, Long> c;

    public a(String str, Map<String, String> map, Map<String, Long> map2) {
        this.b = new HashMap();
        this.c = new HashMap();
        this.a = str;
        this.b = map;
        this.c = map2;
    }

    public Map<String, String> a() {
        return this.b;
    }

    public Map<String, Long> b() {
        return this.c;
    }

    public String c() {
        return this.a;
    }
}
