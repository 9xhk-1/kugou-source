package g.a;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class d1 extends c1 {
    public final Executor a;

    public d1(Executor executor) {
        f.z.d.j.f(executor, "executor");
        this.a = executor;
        d();
    }

    @Override // g.a.b1
    public Executor c() {
        return this.a;
    }
}
