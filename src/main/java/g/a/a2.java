package g.a;

import f.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a2 {
    public static final boolean a(int i2) {
        return i2 == 1;
    }

    public static final boolean b(int i2) {
        return i2 == 0 || i2 == 1;
    }

    public static final <T> void c(f.w.d<? super T> dVar, T t, int i2) {
        f.z.d.j.f(dVar, "$this$resumeMode");
        if (i2 == 0) {
            j.a aVar = f.j.a;
            f.j.a(t);
            dVar.resumeWith(t);
            return;
        }
        if (i2 == 1) {
            p0.d(dVar, t);
            return;
        }
        if (i2 == 2) {
            p0.f(dVar, t);
            return;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return;
            }
            throw new IllegalStateException(("Invalid mode " + i2).toString());
        }
        n0 n0Var = (n0) dVar;
        f.w.g context = n0Var.getContext();
        Object objC = g.a.n2.u.c(context, n0Var.f1610i);
        try {
            f.w.d<T> dVar2 = n0Var.k;
            j.a aVar2 = f.j.a;
            f.j.a(t);
            dVar2.resumeWith(t);
            f.s sVar = f.s.a;
        } finally {
            g.a.n2.u.a(context, objC);
        }
    }

    public static final <T> void d(f.w.d<? super T> dVar, T t, int i2) {
        f.z.d.j.f(dVar, "$this$resumeUninterceptedMode");
        if (i2 == 0) {
            f.w.d dVarC = f.w.i.b.c(dVar);
            j.a aVar = f.j.a;
            f.j.a(t);
            dVarC.resumeWith(t);
            return;
        }
        if (i2 == 1) {
            p0.d(f.w.i.b.c(dVar), t);
            return;
        }
        if (i2 == 2) {
            j.a aVar2 = f.j.a;
            f.j.a(t);
            dVar.resumeWith(t);
            return;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return;
            }
            throw new IllegalStateException(("Invalid mode " + i2).toString());
        }
        f.w.g context = dVar.getContext();
        Object objC = g.a.n2.u.c(context, null);
        try {
            j.a aVar3 = f.j.a;
            f.j.a(t);
            dVar.resumeWith(t);
            f.s sVar = f.s.a;
        } finally {
            g.a.n2.u.a(context, objC);
        }
    }

    public static final <T> void e(f.w.d<? super T> dVar, Throwable th, int i2) {
        f.z.d.j.f(dVar, "$this$resumeUninterceptedWithExceptionMode");
        f.z.d.j.f(th, "exception");
        if (i2 == 0) {
            f.w.d dVarC = f.w.i.b.c(dVar);
            j.a aVar = f.j.a;
            Object objA = f.k.a(th);
            f.j.a(objA);
            dVarC.resumeWith(objA);
            return;
        }
        if (i2 == 1) {
            p0.e(f.w.i.b.c(dVar), th);
            return;
        }
        if (i2 == 2) {
            j.a aVar2 = f.j.a;
            Object objA2 = f.k.a(th);
            f.j.a(objA2);
            dVar.resumeWith(objA2);
            return;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return;
            }
            throw new IllegalStateException(("Invalid mode " + i2).toString());
        }
        f.w.g context = dVar.getContext();
        Object objC = g.a.n2.u.c(context, null);
        try {
            j.a aVar3 = f.j.a;
            Object objA3 = f.k.a(th);
            f.j.a(objA3);
            dVar.resumeWith(objA3);
            f.s sVar = f.s.a;
        } finally {
            g.a.n2.u.a(context, objC);
        }
    }

    public static final <T> void f(f.w.d<? super T> dVar, Throwable th, int i2) {
        f.z.d.j.f(dVar, "$this$resumeWithExceptionMode");
        f.z.d.j.f(th, "exception");
        if (i2 == 0) {
            j.a aVar = f.j.a;
            Object objA = f.k.a(th);
            f.j.a(objA);
            dVar.resumeWith(objA);
            return;
        }
        if (i2 == 1) {
            p0.e(dVar, th);
            return;
        }
        if (i2 == 2) {
            p0.g(dVar, th);
            return;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return;
            }
            throw new IllegalStateException(("Invalid mode " + i2).toString());
        }
        n0 n0Var = (n0) dVar;
        f.w.g context = n0Var.getContext();
        Object objC = g.a.n2.u.c(context, n0Var.f1610i);
        try {
            f.w.d<T> dVar2 = n0Var.k;
            j.a aVar2 = f.j.a;
            Object objA2 = f.k.a(g.a.n2.p.k(th, dVar2));
            f.j.a(objA2);
            dVar2.resumeWith(objA2);
            f.s sVar = f.s.a;
        } finally {
            g.a.n2.u.a(context, objC);
        }
    }
}
