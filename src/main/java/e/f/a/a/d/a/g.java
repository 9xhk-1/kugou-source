package e.f.a.a.d.a;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends e.f.a.a.d.b.f {
    public static byte[] l = {0};
    public static Map<String, String> m;
    public byte a = 0;
    public int b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f1444d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1445f = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f1446h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f1447i = "";
    public String j = "";
    public Map<String, String> k = null;

    static {
        HashMap map = new HashMap();
        m = map;
        map.put("", "");
    }

    @Override // e.f.a.a.d.b.f
    public void a(StringBuilder sb, int i2) {
    }

    @Override // e.f.a.a.d.b.f
    public void b(e.f.a.a.d.b.d dVar) {
        this.a = dVar.b(this.a, 0, true);
        this.b = dVar.e(this.b, 1, true);
        this.f1444d = dVar.k(l, 2, false);
        this.f1445f = dVar.y(3, false);
        this.f1446h = dVar.f(this.f1446h, 4, false);
        this.f1447i = dVar.y(5, false);
        this.j = dVar.y(6, false);
        this.k = (Map) dVar.h(m, 7, false);
    }

    @Override // e.f.a.a.d.b.f
    public void c(e.f.a.a.d.b.e eVar) {
        eVar.d(this.a, 0);
        eVar.g(this.b, 1);
        byte[] bArr = this.f1444d;
        if (bArr != null) {
            eVar.w(bArr, 2);
        }
        String str = this.f1445f;
        if (str != null) {
            eVar.r(str, 3);
        }
        eVar.h(this.f1446h, 4);
        String str2 = this.f1447i;
        if (str2 != null) {
            eVar.r(str2, 5);
        }
        String str3 = this.j;
        if (str3 != null) {
            eVar.r(str3, 6);
        }
        Map<String, String> map = this.k;
        if (map != null) {
            eVar.t(map, 7);
        }
    }
}
