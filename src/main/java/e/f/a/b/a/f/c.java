package e.f.a.b.a.f;

import f.z.d.j;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final c b = new c();
    public static final CopyOnWriteArrayList<b> a = new CopyOnWriteArrayList<>();

    public final void a(a aVar) {
        j.f(aVar, "crashDesc");
        Iterator<T> it = a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).onAnr(aVar);
        }
    }

    public final void b(a aVar) {
        j.f(aVar, "crashDesc");
        Iterator<T> it = a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).onJavaCrash(aVar);
        }
    }

    public final void c(a aVar) {
        j.f(aVar, "crashDesc");
        Iterator<T> it = a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).onNativeCrash(aVar);
        }
    }
}
