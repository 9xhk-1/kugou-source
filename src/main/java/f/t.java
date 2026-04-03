package f;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class t<T> implements d<T>, Serializable {
    public f.z.c.a<? extends T> a;
    public Object b;

    public t(f.z.c.a<? extends T> aVar) {
        f.z.d.j.e(aVar, "initializer");
        this.a = aVar;
        this.b = q.a;
    }

    @Override // f.d
    public T getValue() {
        if (this.b == q.a) {
            f.z.c.a<? extends T> aVar = this.a;
            f.z.d.j.c(aVar);
            this.b = aVar.invoke();
            this.a = null;
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
