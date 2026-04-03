package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(String str, Throwable th) {
        super(str, th);
        f.z.d.j.f(str, "message");
        f.z.d.j.f(th, "cause");
    }
}
