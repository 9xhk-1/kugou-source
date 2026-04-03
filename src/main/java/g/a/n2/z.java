package g.a.n2;

/* JADX INFO: loaded from: classes2.dex */
public final class z {
    public Object[] a;
    public int b;
    public final f.w.g c;

    public z(f.w.g gVar, int i2) {
        f.z.d.j.f(gVar, "context");
        this.c = gVar;
        this.a = new Object[i2];
    }

    public final void a(Object obj) {
        Object[] objArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        objArr[i2] = obj;
    }

    public final f.w.g b() {
        return this.c;
    }

    public final void c() {
        this.b = 0;
    }

    public final Object d() {
        Object[] objArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        return objArr[i2];
    }
}
