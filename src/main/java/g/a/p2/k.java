package g.a.p2;

import g.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f1642d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Runnable runnable, long j, j jVar) {
        super(j, jVar);
        f.z.d.j.f(runnable, "block");
        f.z.d.j.f(jVar, "taskContext");
        this.f1642d = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1642d.run();
        } finally {
            this.b.afterTask();
        }
    }

    public String toString() {
        return "Task[" + l0.a(this.f1642d) + '@' + l0.b(this.f1642d) + ", " + this.a + ", " + this.b + ']';
    }
}
