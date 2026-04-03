package g.a;

import f.j;

/* JADX INFO: loaded from: classes2.dex */
public final class b2 extends s1<m1> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f.w.d<f.s> f1560h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b2(m1 m1Var, f.w.d<? super f.s> dVar) {
        super(m1Var);
        f.z.d.j.f(m1Var, "job");
        f.z.d.j.f(dVar, "continuation");
        this.f1560h = dVar;
    }

    @Override // f.z.c.l
    public /* bridge */ /* synthetic */ f.s invoke(Throwable th) {
        s(th);
        return f.s.a;
    }

    @Override // g.a.x
    public void s(Throwable th) {
        f.w.d<f.s> dVar = this.f1560h;
        f.s sVar = f.s.a;
        j.a aVar = f.j.a;
        f.j.a(sVar);
        dVar.resumeWith(sVar);
    }

    @Override // g.a.n2.i
    public String toString() {
        return "ResumeOnCompletion[" + this.f1560h + ']';
    }
}
