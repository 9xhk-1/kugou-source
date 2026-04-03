package e.c.a.d;

import android.content.Context;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import e.c.c.o.f;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public String a;
    public Map<String, String> b;
    public boolean c;

    public a(String str, Map<String, String> map, boolean z) {
        this.c = true;
        this.a = str;
        this.b = map;
        this.c = z;
    }

    public Map<String, String> a() {
        return this.b;
    }

    public void b() {
        if (this.c) {
            Context contextA = f.a();
            this.b.put("dfid", e.c.a.g.a.f.m.b.m().f());
            this.b.put("appid", Long.toString(l1.f()));
            this.b.put("mid", l1.n(contextA));
            this.b.put("uuid", m.h());
            this.b.put("clientver", String.valueOf(l1.G()));
            this.b.put("clienttime", String.valueOf(System.currentTimeMillis() / 1000));
        }
        b.b(this.b, this.a.getBytes());
    }
}
