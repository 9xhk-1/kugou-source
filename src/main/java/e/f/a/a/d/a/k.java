package e.f.a.a.d.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends e.f.a.a.d.b.f implements Cloneable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static ArrayList<j> f1456i;
    public static Map<String, String> j;
    public byte a = 0;
    public String b = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1457d = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<j> f1458f = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, String> f1459h = null;

    @Override // e.f.a.a.d.b.f
    public void a(StringBuilder sb, int i2) {
    }

    @Override // e.f.a.a.d.b.f
    public void b(e.f.a.a.d.b.d dVar) {
        this.a = dVar.b(this.a, 0, true);
        this.b = dVar.y(1, false);
        this.f1457d = dVar.y(2, false);
        if (f1456i == null) {
            f1456i = new ArrayList<>();
            f1456i.add(new j());
        }
        this.f1458f = (ArrayList) dVar.h(f1456i, 3, false);
        if (j == null) {
            HashMap map = new HashMap();
            j = map;
            map.put("", "");
        }
        this.f1459h = (Map) dVar.h(j, 4, false);
    }

    @Override // e.f.a.a.d.b.f
    public void c(e.f.a.a.d.b.e eVar) {
        eVar.d(this.a, 0);
        String str = this.b;
        if (str != null) {
            eVar.r(str, 1);
        }
        String str2 = this.f1457d;
        if (str2 != null) {
            eVar.r(str2, 2);
        }
        ArrayList<j> arrayList = this.f1458f;
        if (arrayList != null) {
            eVar.s(arrayList, 3);
        }
        Map<String, String> map = this.f1459h;
        if (map != null) {
            eVar.t(map, 4);
        }
    }
}
