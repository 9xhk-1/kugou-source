package g.a.p2;

import g.a.b0;
import g.a.n2.r;
import g.a.n2.t;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b0 f1635i;
    public static final c j;

    static {
        c cVar = new c();
        j = cVar;
        f1635i = cVar.d(t.d("kotlinx.coroutines.io.parallelism", f.b0.f.b(64, r.a()), 0, 0, 12, null));
    }

    public c() {
        super(0, 0, null, 7, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("DefaultDispatcher cannot be closed");
    }

    public final b0 g() {
        return f1635i;
    }

    @Override // g.a.b0
    public String toString() {
        return "DefaultDispatcher";
    }
}
