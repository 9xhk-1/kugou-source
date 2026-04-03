package e.c.e.b.c;

import android.support.annotation.NonNull;
import android.util.Pair;
import e.c.e.b.c.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public final Object a = new Object();
    public Map<b, C0214a> b = new HashMap();

    /* JADX INFO: renamed from: e.c.e.b.c.a$a, reason: collision with other inner class name */
    public static class C0214a {

        @NonNull
        public b a;
        public Map<Class, Object> b;

        public C0214a(@NonNull b bVar) {
            this.a = bVar;
            b.a provider = bVar.getProvider();
            if (provider == null) {
                return;
            }
            Map<Class, Object> mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
            this.b = mapSynchronizedMap;
            provider.init(mapSynchronizedMap);
        }

        public final <I> I b(Class<I> cls) {
            Map<Class, Object> map = this.b;
            if (map == null) {
                return null;
            }
            return (I) map.get(cls);
        }
    }

    public <A, R, H> R a(Class<H> cls, A a, d<A, R, H> dVar) {
        List<H> listC = c(cls);
        e.c.e.b.c.e.a<A, R> aVar = new e.c.e.b.c.e.a<>(a);
        Pair<Boolean, R> pairB = b(listC, aVar, dVar);
        if (((Boolean) pairB.first).booleanValue()) {
            return (R) pairB.second;
        }
        aVar.b = dVar.impl(aVar);
        if (listC != null) {
            Iterator<H> it = listC.iterator();
            while (it.hasNext()) {
                dVar.invokeAfter(it.next(), aVar);
            }
        }
        return aVar.b;
    }

    public final <A, R, H> Pair<Boolean, R> b(List<H> list, e.c.e.b.c.e.a<A, R> aVar, d<A, R, H> dVar) {
        if (list != null) {
            ArrayList arrayList = null;
            for (H h2 : list) {
                int iInvokeBefore = dVar.invokeBefore(h2, aVar);
                if (iInvokeBefore != 0) {
                    if (iInvokeBefore == 1) {
                        if (e.c.e.b.b.b.f().debug()) {
                            e.c.e.b.b.b.f().w("ExtendManager", "intercept by " + h2 + "\n" + dVar);
                        }
                        return Pair.create(Boolean.TRUE, aVar.b);
                    }
                    if (iInvokeBefore != 2) {
                        throw new RuntimeException("unknown action returned from " + h2);
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(h2);
                }
            }
            if (arrayList != null) {
                b(arrayList, aVar, dVar);
            }
        }
        return Pair.create(Boolean.FALSE, null);
    }

    public final <I> List<I> c(Class<I> cls) {
        ArrayList arrayList = new ArrayList();
        Iterator<C0214a> it = this.b.values().iterator();
        while (it.hasNext()) {
            Object objB = it.next().b(cls);
            if (objB != null) {
                arrayList.add(objB);
            }
        }
        return arrayList;
    }

    public void d(b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.a) {
            if (!this.b.containsKey(bVar)) {
                this.b.put(bVar, new C0214a(bVar));
                return;
            }
            if (e.c.e.b.b.b.f().debug()) {
                e.c.e.b.b.b.f().w("ExtendManager", "registered extend: " + bVar);
            }
        }
    }
}
