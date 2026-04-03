package g.a.p2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i implements Runnable {
    public long a;
    public j b;

    public i(long j, j jVar) {
        f.z.d.j.f(jVar, "taskContext");
        this.a = j;
        this.b = jVar;
    }

    public final l a() {
        return this.b.getTaskMode();
    }

    public i() {
        this(0L, h.b);
    }
}
