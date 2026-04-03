package d.a.a.a$b.c.b;

import d.a.a.a$b.c.b.c.a;
import f.j;
import f.k;
import f.s;
import f.z.d.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a<T extends d.a.a.a$b.c.b.c.a> {
    public static final ThreadLocal<List<d.a.a.a$b.c.b.b<? extends d.a.a.a$b.c.b.c.a>>> a = new b();
    public static final C0034a b = new C0034a();

    /* JADX INFO: renamed from: d.a.a.a$b.c.b.a$a, reason: collision with other inner class name */
    public static final class C0034a extends ThreadLocal<Boolean> {
        @Override // java.lang.ThreadLocal
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    }

    public static final class b extends ThreadLocal<List<d.a.a.a$b.c.b.b<? extends d.a.a.a$b.c.b.c.a>>> {
        @Override // java.lang.ThreadLocal
        public List<d.a.a.a$b.c.b.b<? extends d.a.a.a$b.c.b.c.a>> initialValue() {
            return new ArrayList();
        }
    }

    public final void a(d.a.a.a$b.c.b.b<T> bVar) {
        j.e(bVar, "eventSubscriber");
        if (j.a(b.get(), Boolean.TRUE)) {
            e.g.b.b.a.a("EventPublisher", "is publishing, not allow subscribe");
            return;
        }
        e.g.b.b.a.a("EventPublisher", "subscribe...");
        List<d.a.a.a$b.c.b.b<? extends d.a.a.a$b.c.b.c.a>> list = a.get();
        if (list == null) {
            return;
        }
        list.add(bVar);
    }

    public final void b(T t) throws Throwable {
        Object objA;
        j.e(t, "t");
        C0034a c0034a = b;
        Boolean bool = c0034a.get();
        Boolean bool2 = Boolean.TRUE;
        if (j.a(bool, bool2)) {
            e.g.b.b.a.a("EventPublisher", "is publishing, not publish again");
            return;
        }
        try {
            j.a aVar = f.j.a;
            c0034a.set(bool2);
            List<d.a.a.a$b.c.b.b<? extends d.a.a.a$b.c.b.c.a>> list = a.get();
            e.g.b.b.a.a("EventPublisher", f.z.d.j.l("event is publishing...", list));
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    ((d.a.a.a$b.c.b.b) it.next()).a(t);
                }
            }
            b.set(Boolean.FALSE);
            objA = s.a;
            f.j.a(objA);
        } catch (Throwable th) {
            j.a aVar2 = f.j.a;
            objA = k.a(th);
            f.j.a(objA);
        }
        Throwable thB = f.j.b(objA);
        if (thB == null) {
            return;
        }
        b.set(Boolean.FALSE);
        throw thB;
    }
}
