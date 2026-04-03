package e.c.a.g.a.d.r.p.a;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public a a;
    public int b;

    public a a() {
        return this.a;
    }

    public boolean b() {
        return this.b == 1;
    }

    public boolean c() {
        return d();
    }

    public final boolean d() {
        a aVar = this.a;
        return (aVar == null || aVar.b() == null || this.a.b().a() == null || this.a.b().a().size() <= 0) ? false : true;
    }

    public boolean e() {
        return (this.b == 1 || d()) ? false : true;
    }

    public boolean f() {
        return this.b != 1 && d();
    }

    public void g(a aVar) {
        this.a = aVar;
    }

    public void h(int i2) {
        this.b = i2;
    }
}
