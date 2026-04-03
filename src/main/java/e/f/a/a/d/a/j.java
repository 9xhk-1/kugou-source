package e.f.a.a.d.a;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends e.f.a.a.d.b.f {
    public static Map<String, String> l;
    public long a = 0;
    public byte b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1452d = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1453f = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1454h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, String> f1455i = null;
    public String j = "";
    public boolean k = true;

    static {
        HashMap map = new HashMap();
        l = map;
        map.put("", "");
    }

    @Override // e.f.a.a.d.b.f
    public void a(StringBuilder sb, int i2) {
    }

    @Override // e.f.a.a.d.b.f
    public void b(e.f.a.a.d.b.d dVar) {
        this.a = dVar.f(this.a, 0, true);
        this.b = dVar.b(this.b, 1, true);
        this.f1452d = dVar.y(2, false);
        this.f1453f = dVar.y(3, false);
        this.f1454h = dVar.y(4, false);
        this.f1455i = (Map) dVar.h(l, 5, false);
        this.j = dVar.y(6, false);
        this.k = dVar.j(this.k, 7, false);
    }

    @Override // e.f.a.a.d.b.f
    public void c(e.f.a.a.d.b.e eVar) {
        eVar.h(this.a, 0);
        eVar.d(this.b, 1);
        String str = this.f1452d;
        if (str != null) {
            eVar.r(str, 2);
        }
        String str2 = this.f1453f;
        if (str2 != null) {
            eVar.r(str2, 3);
        }
        String str3 = this.f1454h;
        if (str3 != null) {
            eVar.r(str3, 4);
        }
        Map<String, String> map = this.f1455i;
        if (map != null) {
            eVar.t(map, 5);
        }
        String str4 = this.j;
        if (str4 != null) {
            eVar.r(str4, 6);
        }
        eVar.v(this.k, 7);
    }
}
