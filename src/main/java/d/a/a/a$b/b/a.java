package d.a.a.a$b.b;

import f.z.d.j;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a a = new a();
    public static boolean b;

    /* JADX INFO: renamed from: d.a.a.a$b.b.a$a, reason: collision with other inner class name */
    public static final class C0032a<T> implements f.d<T> {
        public f.z.c.a<? extends T> a;
        public T b;

        public C0032a(f.z.c.a<? extends T> aVar) {
            j.e(aVar, "initializer");
            this.a = aVar;
        }

        @Override // f.d
        public T getValue() {
            f.z.c.a<? extends T> aVar;
            if (this.b == null && (aVar = this.a) != null) {
                this.b = aVar == null ? null : aVar.invoke();
                this.a = null;
            }
            return this.b;
        }

        @Override // f.d
        public boolean isInitialized() {
            return this.b != null;
        }

        public String toString() {
            return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
        }
    }

    public final void a(f.c0.b<?> bVar, f.d<?> dVar) {
        boolean z;
        j.e(bVar, "kClass");
        j.e(dVar, "lazyInstance");
        e.g.a.b.b.a.g.a aVar = e.g.a.b.b.a.g.a.a;
        ConcurrentHashMap<f.c0.b<?>, f.d<?>> concurrentHashMapA = aVar.a();
        if (concurrentHashMapA.containsKey(bVar)) {
            aVar.c("Object of the same class [ " + ((Object) bVar.getSimpleName()) + " ] type are injected");
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        concurrentHashMapA.put(bVar, dVar);
    }
}
