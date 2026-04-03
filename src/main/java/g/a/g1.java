package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class g1 implements h1 {
    public final v1 a;

    public g1(v1 v1Var) {
        f.z.d.j.f(v1Var, "list");
        this.a = v1Var;
    }

    @Override // g.a.h1
    public v1 getList() {
        return this.a;
    }

    @Override // g.a.h1
    public boolean isActive() {
        return false;
    }

    public String toString() {
        return k0.c() ? getList().s("New") : super.toString();
    }
}
