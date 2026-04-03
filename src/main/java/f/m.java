package f;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class m<T> implements d<T>, Serializable {
    public f.z.c.a<? extends T> a;
    public volatile Object b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f1524d;

    public m(f.z.c.a<? extends T> aVar, Object obj) {
        f.z.d.j.e(aVar, "initializer");
        this.a = aVar;
        this.b = q.a;
        this.f1524d = obj == null ? this : obj;
    }

    @Override // f.d
    public T getValue() {
        T tInvoke;
        T t = (T) this.b;
        q qVar = q.a;
        if (t != qVar) {
            return t;
        }
        synchronized (this.f1524d) {
            tInvoke = (T) this.b;
            if (tInvoke == qVar) {
                f.z.c.a<? extends T> aVar = this.a;
                f.z.d.j.c(aVar);
                tInvoke = aVar.invoke();
                this.b = tInvoke;
                this.a = null;
            }
        }
        return tInvoke;
    }

    @Override // f.d
    public boolean isInitialized() {
        return this.b != q.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ m(f.z.c.a aVar, Object obj, int i2, f.z.d.g gVar) {
        this(aVar, (i2 & 2) != 0 ? null : obj);
    }
}
