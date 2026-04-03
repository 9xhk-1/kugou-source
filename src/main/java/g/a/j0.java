package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 extends Error {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(String str, Throwable th) {
        super(str, th);
        f.z.d.j.f(str, "message");
        f.z.d.j.f(th, "cause");
    }
}
