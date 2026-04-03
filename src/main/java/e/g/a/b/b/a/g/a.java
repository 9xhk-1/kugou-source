package e.g.a.b.b.a.g;

import f.d;
import f.z.d.j;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final a a = new a();
    public static final ConcurrentHashMap<f.c0.b<?>, d<?>> b = new ConcurrentHashMap<>();

    public final ConcurrentHashMap<f.c0.b<?>, d<?>> a() {
        return b;
    }

    public final void b(f.c0.b<?> bVar) {
        j.e(bVar, "kClass");
        c("the class of [" + ((Object) bVar.getSimpleName()) + "] are not injected");
    }

    public final void c(String str) {
        j.e(str, "message");
        e.g.b.b.a.b("ClientDI", j.l("onError, ", str));
    }
}
