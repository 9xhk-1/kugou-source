package g.a;

import f.j;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q0<T> extends g.a.p2.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1648d;

    public q0(int i2) {
        this.f1648d = i2;
    }

    public void b(Object obj, Throwable th) {
        f.z.d.j.f(th, "cause");
    }

    public abstract f.w.d<T> c();

    public final Throwable d(Object obj) {
        if (!(obj instanceof t)) {
            obj = null;
        }
        t tVar = (t) obj;
        if (tVar != null) {
            return tVar.a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T e(Object obj) {
        return obj;
    }

    public final void f(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            f.a.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        String str = "Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers";
        if (th == null) {
            f.z.d.j.n();
            throw null;
        }
        d0.a(c().getContext(), new j0(str, th));
    }

    public abstract Object g();

    @Override // java.lang.Runnable
    public final void run() {
        Object objA;
        g.a.p2.j jVar = this.b;
        try {
            f.w.d<T> dVarC = c();
            if (dVarC == null) {
                throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
            }
            n0 n0Var = (n0) dVarC;
            f.w.d<T> dVar = n0Var.k;
            f.w.g context = dVar.getContext();
            Object objG = g();
            Object objC = g.a.n2.u.c(context, n0Var.f1610i);
            try {
                Throwable thD = d(objG);
                m1 m1Var = a2.a(this.f1648d) ? (m1) context.get(m1.f1605g) : null;
                if (thD == null && m1Var != null && !m1Var.isActive()) {
                    CancellationException cancellationException = m1Var.getCancellationException();
                    b(objG, cancellationException);
                    j.a aVar = f.j.a;
                    Object objA2 = f.k.a(g.a.n2.p.k(cancellationException, dVar));
                    f.j.a(objA2);
                    dVar.resumeWith(objA2);
                } else if (thD != null) {
                    j.a aVar2 = f.j.a;
                    Object objA3 = f.k.a(g.a.n2.p.k(thD, dVar));
                    f.j.a(objA3);
                    dVar.resumeWith(objA3);
                } else {
                    T tE = e(objG);
                    j.a aVar3 = f.j.a;
                    f.j.a(tE);
                    dVar.resumeWith(tE);
                }
                Object objA4 = f.s.a;
                try {
                    j.a aVar4 = f.j.a;
                    jVar.afterTask();
                    f.j.a(objA4);
                } catch (Throwable th) {
                    j.a aVar5 = f.j.a;
                    objA4 = f.k.a(th);
                    f.j.a(objA4);
                }
                f(null, f.j.b(objA4));
            } finally {
                g.a.n2.u.a(context, objC);
            }
        } catch (Throwable th2) {
            try {
                j.a aVar6 = f.j.a;
                jVar.afterTask();
                objA = f.s.a;
                f.j.a(objA);
            } catch (Throwable th3) {
                j.a aVar7 = f.j.a;
                objA = f.k.a(th3);
                f.j.a(objA);
            }
            f(th2, f.j.b(objA));
        }
    }
}
