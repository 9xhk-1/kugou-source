package f;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class l<T> implements d<T>, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater<l<?>, Object> f1523d = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "b");
    public volatile f.z.c.a<? extends T> a;
    private volatile Object b;

    public l(f.z.c.a<? extends T> aVar) {
        f.z.d.j.e(aVar, "initializer");
        this.a = aVar;
        this.b = q.a;
    }

    @Override // f.d
    public T getValue() {
        T t = (T) this.b;
        q qVar = q.a;
        if (t != qVar) {
            return t;
        }
        f.z.c.a<? extends T> aVar = this.a;
        if (aVar != null) {
            T tInvoke = aVar.invoke();
            if (f1523d.compareAndSet(this, qVar, tInvoke)) {
                this.a = null;
                return tInvoke;
            }
        }
        return (T) this.b;
    }

    @Override // f.d
    public boolean isInitialized() {
        return this.b != q.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
