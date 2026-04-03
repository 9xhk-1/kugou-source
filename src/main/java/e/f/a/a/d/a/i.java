package e.f.a.a.d.a;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends e.f.a.a.d.b.f implements Cloneable {
    public static h p = new h();
    public static Map<String, String> q;
    public boolean a = true;
    public boolean b = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1448d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1449f = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1450h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f1451i = null;
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

    @Override // e.f.a.a.d.b.f
    public void a(StringBuilder sb, int i2) {
        e.f.a.a.d.b.b bVar = new e.f.a.a.d.b.b(sb, i2);
        bVar.m(this.a, "enable");
        bVar.m(this.b, "enableUserInfo");
        bVar.m(this.f1448d, "enableQuery");
        bVar.i(this.f1449f, "url");
        bVar.i(this.f1450h, "expUrl");
        bVar.g(this.f1451i, "security");
        bVar.k(this.j, "valueMap");
        bVar.f(this.k, "strategylastUpdateTime");
        bVar.i(this.l, "httpsUrl");
        bVar.i(this.m, "httpsExpUrl");
        bVar.e(this.n, "eventRecordCount");
        bVar.e(this.o, "eventTimeInterval");
    }

    @Override // e.f.a.a.d.b.f
    public void b(e.f.a.a.d.b.d dVar) {
        this.a = dVar.j(this.a, 0, true);
        this.b = dVar.j(this.b, 1, true);
        this.f1448d = dVar.j(this.f1448d, 2, true);
        this.f1449f = dVar.y(3, false);
        this.f1450h = dVar.y(4, false);
        this.f1451i = (h) dVar.g(p, 5, false);
        this.j = (Map) dVar.h(q, 6, false);
        this.k = dVar.f(this.k, 7, false);
        this.l = dVar.y(8, false);
        this.m = dVar.y(9, false);
        this.n = dVar.e(this.n, 10, false);
        this.o = dVar.e(this.o, 11, false);
    }

    @Override // e.f.a.a.d.b.f
    public void c(e.f.a.a.d.b.e eVar) {
        eVar.v(this.a, 0);
        eVar.v(this.b, 1);
        eVar.v(this.f1448d, 2);
        String str = this.f1449f;
        if (str != null) {
            eVar.r(str, 3);
        }
        String str2 = this.f1450h;
        if (str2 != null) {
            eVar.r(str2, 4);
        }
        h hVar = this.f1451i;
        if (hVar != null) {
            eVar.i(hVar, 5);
        }
        Map<String, String> map = this.j;
        if (map != null) {
            eVar.t(map, 6);
        }
        eVar.h(this.k, 7);
        String str3 = this.l;
        if (str3 != null) {
            eVar.r(str3, 8);
        }
        String str4 = this.m;
        if (str4 != null) {
            eVar.r(str4, 9);
        }
        eVar.g(this.n, 10);
        eVar.g(this.o, 11);
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
        i iVar = (i) obj;
        return e.f.a.a.d.b.g.d(this.a, iVar.a) && e.f.a.a.d.b.g.d(this.b, iVar.b) && e.f.a.a.d.b.g.d(this.f1448d, iVar.f1448d) && e.f.a.a.d.b.g.c(this.f1449f, iVar.f1449f) && e.f.a.a.d.b.g.c(this.f1450h, iVar.f1450h) && e.f.a.a.d.b.g.c(this.f1451i, iVar.f1451i) && e.f.a.a.d.b.g.c(this.j, iVar.j) && e.f.a.a.d.b.g.b(this.k, iVar.k) && e.f.a.a.d.b.g.c(this.l, iVar.l) && e.f.a.a.d.b.g.c(this.m, iVar.m) && e.f.a.a.d.b.g.a(this.n, iVar.n) && e.f.a.a.d.b.g.a(this.o, iVar.o);
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
