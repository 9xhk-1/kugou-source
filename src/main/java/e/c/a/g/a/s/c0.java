package e.c.a.g.a.s;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c0<T> {
    public final Map<Class<? extends T>, T> a = new HashMap();
    public a<T> b;
    public b<T> c;

    public interface a<T> {
        T create(Class<? extends T> cls);
    }

    public interface b<T> {
        void onInit(T t);
    }

    public final <E extends T> T a(Class<E> cls) {
        a<T> aVar = this.b;
        T tCreate = aVar != null ? aVar.create(cls) : b(cls);
        b<T> bVar = this.c;
        if (bVar != null) {
            bVar.onInit(tCreate);
        }
        this.a.put(cls, tCreate);
        return tCreate;
    }

    public final <E extends T> T b(Class<E> cls) {
        try {
            return cls.newInstance();
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public <E extends T> E c(Class<E> cls) {
        T t = this.a.get(cls);
        return t == null ? a(cls) : t;
    }

    public void d(a<T> aVar) {
        this.b = aVar;
    }

    public void e(b<T> bVar) {
        this.c = bVar;
    }
}
