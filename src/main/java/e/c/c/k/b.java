package e.c.c.k;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public a a;
    public e b;
    public d c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1251f = false;

    public b(String str, a aVar, e eVar, d dVar, boolean z, boolean z2) {
        this.f1249d = true;
        this.f1250e = false;
        this.a = aVar;
        this.b = eVar;
        this.c = dVar;
        this.f1249d = z;
        this.f1250e = z2;
    }

    public a a() {
        return this.a;
    }

    public d b() {
        return this.c;
    }

    public e c() {
        return this.b;
    }

    public boolean d() {
        return this.f1250e;
    }

    public boolean e() {
        return this.f1251f;
    }

    public boolean f() {
        return this.f1249d;
    }

    public void g(boolean z) {
        this.f1251f = z;
    }
}
