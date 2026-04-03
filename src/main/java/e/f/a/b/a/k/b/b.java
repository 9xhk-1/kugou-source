package e.f.a.b.a.k.b;

import e.f.a.b.a.k.c.d;
import e.f.a.b.a.k.c.e;
import e.f.a.b.a.k.c.f;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends e implements Cloneable {
    public static a p = new a();
    public static Map<String, String> q;
    public boolean a = true;
    public boolean b = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1480d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1481f = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1482h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f1483i = null;
    public Map<String, String> j = null;
    public long k = 0;
    public String l = "";
    public String m = "";
    public int n = 0;
    public int o = 0;

    static {
        HashMap map = new HashMap();
        q = map;
        map.put("", "");
    }

    @Override // e.f.a.b.a.k.c.e
    public void a(StringBuilder sb, int i2) {
        e.f.a.b.a.k.c.b bVar = new e.f.a.b.a.k.c.b(sb, i2);
        bVar.m(this.a, "enable");
        bVar.m(this.b, "enableUserInfo");
        bVar.m(this.f1480d, "enableQuery");
        bVar.i(this.f1481f, "url");
        bVar.i(this.f1482h, "expUrl");
        bVar.g(this.f1483i, "security");
        bVar.k(this.j, "valueMap");
        bVar.f(this.k, "strategylastUpdateTime");
        bVar.i(this.l, "httpsUrl");
        bVar.i(this.m, "httpsExpUrl");
        bVar.e(this.n, "eventRecordCount");
        bVar.e(this.o, "eventTimeInterval");
    }

    @Override // e.f.a.b.a.k.c.e
    public void b(d dVar) {
        this.a = dVar.j(this.a, 0, true);
        this.b = dVar.j(this.b, 1, true);
        this.f1480d = dVar.j(this.f1480d, 2, true);
        this.f1481f = dVar.y(3, false);
        this.f1482h = dVar.y(4, false);
        this.f1483i = (a) dVar.g(p, 5, false);
        this.j = (Map) dVar.h(q, 6, false);
        this.k = dVar.f(this.k, 7, false);
        this.l = dVar.y(8, false);
        this.m = dVar.y(9, false);
        this.n = dVar.e(this.n, 10, false);
        this.o = dVar.e(this.o, 11, false);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        b bVar = (b) obj;
        return f.d(this.a, bVar.a) && f.d(this.b, bVar.b) && f.d(this.f1480d, bVar.f1480d) && f.c(this.f1481f, bVar.f1481f) && f.c(this.f1482h, bVar.f1482h) && f.c(this.f1483i, bVar.f1483i) && f.c(this.j, bVar.j) && f.b(this.k, bVar.k) && f.c(this.l, bVar.l) && f.c(this.m, bVar.m) && f.a(this.n, bVar.n) && f.a(this.o, bVar.o);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
