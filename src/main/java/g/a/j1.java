package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class j1 extends h {
    public final f.z.c.l<Throwable, f.s> a;

    /* JADX WARN: Multi-variable type inference failed */
    public j1(f.z.c.l<? super Throwable, f.s> lVar) {
        f.z.d.j.f(lVar, "handler");
        this.a = lVar;
    }

    @Override // g.a.i
    public void a(Throwable th) {
        this.a.invoke(th);
    }

    @Override // f.z.c.l
    public /* bridge */ /* synthetic */ f.s invoke(Throwable th) {
        a(th);
        return f.s.a;
    }

    public String toString() {
        return "InvokeOnCancel[" + l0.a(this.a) + '@' + l0.b(this) + ']';
    }
}
