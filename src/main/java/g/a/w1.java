package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class w1 implements t0, o {
    public static final w1 a = new w1();

    @Override // g.a.o
    public boolean childCancelled(Throwable th) {
        f.z.d.j.f(th, "cause");
        return false;
    }

    @Override // g.a.t0
    public void dispose() {
    }

    public String toString() {
        return "NonDisposableHandle";
    }
}
