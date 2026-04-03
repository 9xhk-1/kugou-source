package g.a;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 implements Executor {
    public final b0 a;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        f.z.d.j.f(runnable, "block");
        this.a.a(f.w.h.a, runnable);
    }

    public String toString() {
        return this.a.toString();
    }
}
