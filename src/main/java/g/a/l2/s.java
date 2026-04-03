package g.a.l2;

import f.j;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f1602f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g.a.j<f.s> f1603h;

    /* JADX WARN: Multi-variable type inference failed */
    public s(Object obj, g.a.j<? super f.s> jVar) {
        f.z.d.j.f(jVar, "cont");
        this.f1602f = obj;
        this.f1603h = jVar;
    }

    @Override // g.a.l2.q
    public void s(Object obj) {
        f.z.d.j.f(obj, "token");
        this.f1603h.completeResume(obj);
    }

    @Override // g.a.l2.q
    public Object t() {
        return this.f1602f;
    }

    @Override // g.a.n2.i
    public String toString() {
        return "SendElement(" + t() + ')';
    }

    @Override // g.a.l2.q
    public void u(h<?> hVar) {
        f.z.d.j.f(hVar, "closed");
        g.a.j<f.s> jVar = this.f1603h;
        Throwable thZ = hVar.z();
        j.a aVar = f.j.a;
        Object objA = f.k.a(thZ);
        f.j.a(objA);
        jVar.resumeWith(objA);
    }

    @Override // g.a.l2.q
    public Object v(Object obj) {
        return this.f1603h.tryResume(f.s.a, obj);
    }
}
