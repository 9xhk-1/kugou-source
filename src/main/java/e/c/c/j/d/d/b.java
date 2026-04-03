package e.c.c.j.d.d;

import e.c.c.o.g;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static b b;
    public a a = new a();

    public static b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    public void b(String str, e.c.c.j.d.e.d.a aVar) {
        Class<? extends c>[] clsArr = this.a.a().get(str);
        Map<String, String> map = new HashMap<>();
        map.put("type", str);
        for (Class<? extends c> cls : clsArr) {
            try {
                map = cls.newInstance().a(aVar, map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        g.a("autoapm", "translate result.size() :  " + map.size());
    }
}
