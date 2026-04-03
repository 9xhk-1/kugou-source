package g.a;

import f.j;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 {
    public static final g.a.n2.q a = new g.a.n2.q("UNDEFINED");

    public static final <T> void b(q0<? super T> q0Var, int i2) {
        f.z.d.j.f(q0Var, "$this$dispatch");
        f.w.d<? super T> dVarC = q0Var.c();
        if (!a2.b(i2) || !(dVarC instanceof n0) || a2.a(i2) != a2.a(q0Var.f1648d)) {
            c(q0Var, dVarC, i2);
            return;
        }
        b0 b0Var = ((n0) dVarC).j;
        f.w.g context = dVarC.getContext();
        if (b0Var.b(context)) {
            b0Var.a(context, q0Var);
        } else {
            h(q0Var);
        }
    }

    public static final <T> void c(q0<? super T> q0Var, f.w.d<? super T> dVar, int i2) {
        f.z.d.j.f(q0Var, "$this$resume");
        f.z.d.j.f(dVar, "delegate");
        Object objG = q0Var.g();
        Throwable thD = q0Var.d(objG);
        if (thD == null) {
            a2.c(dVar, q0Var.e(objG), i2);
            return;
        }
        if (!(dVar instanceof q0)) {
            thD = g.a.n2.p.k(thD, dVar);
        }
        a2.f(dVar, thD, i2);
    }

    public static final <T> void d(f.w.d<? super T> dVar, T t) {
        boolean z;
        f.z.d.j.f(dVar, "$this$resumeCancellable");
        if (!(dVar instanceof n0)) {
            j.a aVar = f.j.a;
            f.j.a(t);
            dVar.resumeWith(t);
            return;
        }
        n0 n0Var = (n0) dVar;
        if (n0Var.j.b(n0Var.getContext())) {
            n0Var.f1608f = t;
            n0Var.f1648d = 1;
            n0Var.j.a(n0Var.getContext(), n0Var);
            return;
        }
        w0 w0VarB = f2.b.b();
        if (w0VarB.j()) {
            n0Var.f1608f = t;
            n0Var.f1648d = 1;
            w0VarB.f(n0Var);
            return;
        }
        w0VarB.h(true);
        try {
            m1 m1Var = (m1) n0Var.getContext().get(m1.f1605g);
            if (m1Var == null || m1Var.isActive()) {
                z = false;
            } else {
                CancellationException cancellationException = m1Var.getCancellationException();
                j.a aVar2 = f.j.a;
                Object objA = f.k.a(cancellationException);
                f.j.a(objA);
                n0Var.resumeWith(objA);
                z = true;
            }
            if (!z) {
                f.w.g context = n0Var.getContext();
                Object objC = g.a.n2.u.c(context, n0Var.f1610i);
                try {
                    f.w.d<T> dVar2 = n0Var.k;
                    j.a aVar3 = f.j.a;
                    f.j.a(t);
                    dVar2.resumeWith(t);
                    f.s sVar = f.s.a;
                    g.a.n2.u.a(context, objC);
                } catch (Throwable th) {
                    g.a.n2.u.a(context, objC);
                    throw th;
                }
            }
            while (w0VarB.m()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final <T> void e(f.w.d<? super T> dVar, Throwable th) {
        f.z.d.j.f(dVar, "$this$resumeCancellableWithException");
        f.z.d.j.f(th, "exception");
        if (!(dVar instanceof n0)) {
            j.a aVar = f.j.a;
            Object objA = f.k.a(g.a.n2.p.k(th, dVar));
            f.j.a(objA);
            dVar.resumeWith(objA);
            return;
        }
        n0 n0Var = (n0) dVar;
        f.w.g context = n0Var.k.getContext();
        boolean z = false;
        int i2 = 2;
        Throwable th2 = null;
        byte b = 0;
        t tVar = new t(th, z, i2, 0 == true ? 1 : 0);
        if (n0Var.j.b(context)) {
            n0Var.f1608f = new t(th, z, i2, b == true ? 1 : 0);
            n0Var.f1648d = 1;
            n0Var.j.a(context, n0Var);
            return;
        }
        w0 w0VarB = f2.b.b();
        if (w0VarB.j()) {
            n0Var.f1608f = tVar;
            n0Var.f1648d = 1;
            w0VarB.f(n0Var);
            return;
        }
        w0VarB.h(true);
        try {
            m1 m1Var = (m1) n0Var.getContext().get(m1.f1605g);
            if (m1Var != null && !m1Var.isActive()) {
                CancellationException cancellationException = m1Var.getCancellationException();
                j.a aVar2 = f.j.a;
                Object objA2 = f.k.a(cancellationException);
                f.j.a(objA2);
                n0Var.resumeWith(objA2);
                z = true;
            }
            if (!z) {
                f.w.g context2 = n0Var.getContext();
                Object objC = g.a.n2.u.c(context2, n0Var.f1610i);
                try {
                    f.w.d<T> dVar2 = n0Var.k;
                    j.a aVar3 = f.j.a;
                    Object objA3 = f.k.a(g.a.n2.p.k(th, dVar2));
                    f.j.a(objA3);
                    dVar2.resumeWith(objA3);
                    f.s sVar = f.s.a;
                    g.a.n2.u.a(context2, objC);
                } catch (Throwable th3) {
                    g.a.n2.u.a(context2, objC);
                    throw th3;
                }
            }
            while (w0VarB.m()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final <T> void f(f.w.d<? super T> dVar, T t) {
        f.z.d.j.f(dVar, "$this$resumeDirect");
        if (!(dVar instanceof n0)) {
            j.a aVar = f.j.a;
            f.j.a(t);
            dVar.resumeWith(t);
        } else {
            f.w.d<T> dVar2 = ((n0) dVar).k;
            j.a aVar2 = f.j.a;
            f.j.a(t);
            dVar2.resumeWith(t);
        }
    }

    public static final <T> void g(f.w.d<? super T> dVar, Throwable th) {
        f.z.d.j.f(dVar, "$this$resumeDirectWithException");
        f.z.d.j.f(th, "exception");
        if (!(dVar instanceof n0)) {
            j.a aVar = f.j.a;
            Object objA = f.k.a(g.a.n2.p.k(th, dVar));
            f.j.a(objA);
            dVar.resumeWith(objA);
            return;
        }
        f.w.d<T> dVar2 = ((n0) dVar).k;
        j.a aVar2 = f.j.a;
        Object objA2 = f.k.a(g.a.n2.p.k(th, dVar2));
        f.j.a(objA2);
        dVar2.resumeWith(objA2);
    }

    public static final void h(q0<?> q0Var) {
        w0 w0VarB = f2.b.b();
        if (w0VarB.j()) {
            w0VarB.f(q0Var);
            return;
        }
        w0VarB.h(true);
        try {
            c(q0Var, q0Var.c(), 3);
            do {
            } while (w0VarB.m());
        } finally {
            try {
            } finally {
            }
        }
    }
}
