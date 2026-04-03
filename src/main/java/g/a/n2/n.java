package g.a.n2;

import g.a.a2;
import g.a.m1;

/* JADX INFO: loaded from: classes2.dex */
public class n<T> extends g.a.a<T> implements f.w.j.a.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f.w.d<T> f1617f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public n(f.w.g gVar, f.w.d<? super T> dVar) {
        super(gVar, true);
        f.z.d.j.f(gVar, "context");
        f.z.d.j.f(dVar, "uCont");
        this.f1617f = dVar;
    }

    @Override // g.a.a
    public int a0() {
        return 2;
    }

    @Override // g.a.t1
    public void d(Object obj, int i2) {
        if (!(obj instanceof g.a.t)) {
            a2.d(this.f1617f, obj, i2);
            return;
        }
        Throwable thK = ((g.a.t) obj).a;
        if (i2 != 4) {
            thK = p.k(thK, this.f1617f);
        }
        a2.e(this.f1617f, thK, i2);
    }

    public final m1 g0() {
        return (m1) this.f1559d.get(m1.f1605g);
    }

    @Override // f.w.j.a.e
    public final f.w.j.a.e getCallerFrame() {
        return (f.w.j.a.e) this.f1617f;
    }

    @Override // f.w.j.a.e
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // g.a.t1
    public final boolean y() {
        return true;
    }
}
