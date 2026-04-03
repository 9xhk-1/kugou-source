package g.a;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class e1 {
    public static final b0 a(Executor executor) {
        b0 b0Var;
        f.z.d.j.f(executor, "$this$asCoroutineDispatcher");
        r0 r0Var = (r0) (!(executor instanceof r0) ? null : executor);
        return (r0Var == null || (b0Var = r0Var.a) == null) ? new d1(executor) : b0Var;
    }
}
