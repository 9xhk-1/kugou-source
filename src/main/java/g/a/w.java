package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class w {
    public final Object a;
    public final f.z.c.l<Throwable, f.s> b;

    /* JADX WARN: Multi-variable type inference failed */
    public w(Object obj, f.z.c.l<? super Throwable, f.s> lVar) {
        f.z.d.j.f(lVar, "onCancellation");
        this.a = obj;
        this.b = lVar;
    }

    public String toString() {
        return "CompletedWithCancellation[" + this.a + ']';
    }
}
