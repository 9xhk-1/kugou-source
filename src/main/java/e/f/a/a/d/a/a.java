package e.f.a.a.d.a;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends e.f.a.a.d.b.f implements Cloneable {
    public String a = "";
    public String b = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1430d = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1431f = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1432h = "";

    @Override // e.f.a.a.d.b.f
    public void a(StringBuilder sb, int i2) {
    }

    @Override // e.f.a.a.d.b.f
    public void b(e.f.a.a.d.b.d dVar) {
        this.a = dVar.y(0, true);
        this.b = dVar.y(1, false);
        this.f1430d = dVar.y(2, false);
        this.f1431f = dVar.y(3, false);
        this.f1432h = dVar.y(4, false);
    }

    @Override // e.f.a.a.d.b.f
    public void c(e.f.a.a.d.b.e eVar) {
        eVar.r(this.a, 0);
        String str = this.b;
        if (str != null) {
            eVar.r(str, 1);
        }
        String str2 = this.f1430d;
        if (str2 != null) {
            eVar.r(str2, 2);
        }
        String str3 = this.f1431f;
        if (str3 != null) {
            eVar.r(str3, 3);
        }
        String str4 = this.f1432h;
        if (str4 != null) {
            eVar.r(str4, 4);
        }
    }
}
