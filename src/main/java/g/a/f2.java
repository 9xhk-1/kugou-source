package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class f2 {
    public static final f2 b = new f2();
    public static final ThreadLocal<w0> a = new ThreadLocal<>();

    public final w0 a() {
        return a.get();
    }

    public final w0 b() {
        ThreadLocal<w0> threadLocal = a;
        w0 w0Var = threadLocal.get();
        if (w0Var != null) {
            return w0Var;
        }
        w0 w0VarA = z0.a();
        threadLocal.set(w0VarA);
        return w0VarA;
    }

    public final void c() {
        a.set(null);
    }

    public final void d(w0 w0Var) {
        f.z.d.j.f(w0Var, "eventLoop");
        a.set(w0Var);
    }
}
