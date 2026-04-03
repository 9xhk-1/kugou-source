package e.f.a.a.d.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends e.f.a.a.d.b.f {
    public static a A;
    public static ArrayList<a> B;
    public static ArrayList<a> C;
    public static ArrayList<c> D;
    public static Map<String, String> E;
    public static Map<String, String> F;
    public static Map<String, String> y;
    public static b z;
    public String a = "";
    public long b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1436d = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1437f = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1438h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f1439i = "";
    public String j = "";
    public Map<String, String> k = null;
    public String l = "";
    public b m = null;
    public int n = 0;
    public String o = "";
    public String p = "";
    public a q = null;
    public ArrayList<a> r = null;
    public ArrayList<a> s = null;
    public ArrayList<c> t = null;
    public Map<String, String> u = null;
    public Map<String, String> v = null;
    public String w = "";
    public boolean x = true;

    static {
        HashMap map = new HashMap();
        y = map;
        map.put("", "");
        z = new b();
        A = new a();
        ArrayList<a> arrayList = new ArrayList<>();
        B = arrayList;
        arrayList.add(new a());
        ArrayList<a> arrayList2 = new ArrayList<>();
        C = arrayList2;
        arrayList2.add(new a());
        ArrayList<c> arrayList3 = new ArrayList<>();
        D = arrayList3;
        arrayList3.add(new c());
        HashMap map2 = new HashMap();
        E = map2;
        map2.put("", "");
        HashMap map3 = new HashMap();
        F = map3;
        map3.put("", "");
    }

    @Override // e.f.a.a.d.b.f
    public void a(StringBuilder sb, int i2) {
    }

    @Override // e.f.a.a.d.b.f
    public void b(e.f.a.a.d.b.d dVar) {
        this.a = dVar.y(0, true);
        this.b = dVar.f(this.b, 1, true);
        this.f1436d = dVar.y(2, true);
        this.f1437f = dVar.y(3, false);
        this.f1438h = dVar.y(4, false);
        this.f1439i = dVar.y(5, false);
        this.j = dVar.y(6, false);
        this.k = (Map) dVar.h(y, 7, false);
        this.l = dVar.y(8, false);
        this.m = (b) dVar.g(z, 9, false);
        this.n = dVar.e(this.n, 10, false);
        this.o = dVar.y(11, false);
        this.p = dVar.y(12, false);
        this.q = (a) dVar.g(A, 13, false);
        this.r = (ArrayList) dVar.h(B, 14, false);
        this.s = (ArrayList) dVar.h(C, 15, false);
        this.t = (ArrayList) dVar.h(D, 16, false);
        this.u = (Map) dVar.h(E, 17, false);
        this.v = (Map) dVar.h(F, 18, false);
        this.w = dVar.y(19, false);
        this.x = dVar.j(this.x, 20, false);
    }

    @Override // e.f.a.a.d.b.f
    public void c(e.f.a.a.d.b.e eVar) {
        eVar.r(this.a, 0);
        eVar.h(this.b, 1);
        eVar.r(this.f1436d, 2);
        String str = this.f1437f;
        if (str != null) {
            eVar.r(str, 3);
        }
        String str2 = this.f1438h;
        if (str2 != null) {
            eVar.r(str2, 4);
        }
        String str3 = this.f1439i;
        if (str3 != null) {
            eVar.r(str3, 5);
        }
        String str4 = this.j;
        if (str4 != null) {
            eVar.r(str4, 6);
        }
        Map<String, String> map = this.k;
        if (map != null) {
            eVar.t(map, 7);
        }
        String str5 = this.l;
        if (str5 != null) {
            eVar.r(str5, 8);
        }
        b bVar = this.m;
        if (bVar != null) {
            eVar.i(bVar, 9);
        }
        eVar.g(this.n, 10);
        String str6 = this.o;
        if (str6 != null) {
            eVar.r(str6, 11);
        }
        String str7 = this.p;
        if (str7 != null) {
            eVar.r(str7, 12);
        }
        a aVar = this.q;
        if (aVar != null) {
            eVar.i(aVar, 13);
        }
        ArrayList<a> arrayList = this.r;
        if (arrayList != null) {
            eVar.s(arrayList, 14);
        }
        ArrayList<a> arrayList2 = this.s;
        if (arrayList2 != null) {
            eVar.s(arrayList2, 15);
        }
        ArrayList<c> arrayList3 = this.t;
        if (arrayList3 != null) {
            eVar.s(arrayList3, 16);
        }
        Map<String, String> map2 = this.u;
        if (map2 != null) {
            eVar.t(map2, 17);
        }
        Map<String, String> map3 = this.v;
        if (map3 != null) {
            eVar.t(map3, 18);
        }
        String str8 = this.w;
        if (str8 != null) {
            eVar.r(str8, 19);
        }
        eVar.v(this.x, 20);
    }
}
