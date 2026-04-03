package e.c.c.k;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static volatile c b = new c();
    public HashMap<String, b> a = new HashMap<>();

    public c() {
        d();
    }

    public static c c() {
        return b;
    }

    public HashMap<String, b> a() {
        return this.a;
    }

    public b b(String str) {
        return this.a.get(str);
    }

    public void d() {
        this.a.put("1", new b("1", new e.c.c.l.a(), new e.c.c.l.d(), new e.c.c.l.c(), true, false));
        b bVar = new b("2", new e.c.c.j.a(), new e.c.c.j.c(), new e.c.c.j.b(), false, false);
        bVar.g(true);
        this.a.put("2", bVar);
        this.a.put("3", new b("3", new e.c.c.m.b(), new e.c.c.m.d(), new e.c.c.m.c(), true, true));
    }
}
