package g.a.n2;

import g.a.k0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d<T> extends l {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_consensus");
    private volatile Object _consensus = c.a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g.a.n2.l
    public final Object a(Object obj) {
        Object objC = this._consensus;
        if (objC == c.a) {
            objC = c(d(obj));
        }
        b(obj, objC);
        return objC;
    }

    public abstract void b(T t, Object obj);

    public final Object c(Object obj) {
        return e(obj) ? obj : this._consensus;
    }

    public abstract Object d(T t);

    public final boolean e(Object obj) {
        if (k0.a()) {
            if (!(obj != c.a)) {
                throw new AssertionError();
            }
        }
        return a.compareAndSet(this, c.a, obj);
    }
}
