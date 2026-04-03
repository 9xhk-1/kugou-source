package g.a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    public static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(t.class, "_handled");
    private volatile int _handled;
    public final Throwable a;

    public t(Throwable th, boolean z) {
        f.z.d.j.f(th, "cause");
        this.a = th;
        this._handled = z ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return l0.a(this) + '[' + this.a + ']';
    }

    public /* synthetic */ t(Throwable th, boolean z, int i2, f.z.d.g gVar) {
        this(th, (i2 & 2) != 0 ? false : z);
    }
}
