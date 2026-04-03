package e.c.a.g.a.g.p.e;

import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements c {
    public final d a;
    public final e b;
    public final String[] c;

    public a(d dVar, e eVar) {
        j.e(dVar, "view");
        j.e(eVar, "vipProduct");
        this.a = dVar;
        this.b = eVar;
        this.c = new String[]{eVar.a, eVar.b, eVar.c};
    }

    public final d a() {
        return this.a;
    }

    public final String[] b() {
        return this.c;
    }

    public final e c() {
        return this.b;
    }
}
