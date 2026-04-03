package d.a.a.a$b.d;

import f.s;
import f.z.c.l;
import f.z.d.k;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class e extends k implements f.z.c.a<s> {
    public final /* synthetic */ byte[] a;
    public final /* synthetic */ l<d.a.a.a$b.c.b.c.b, s> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e(b bVar, byte[] bArr, l<? super d.a.a.a$b.c.b.c.b, s> lVar) {
        super(0);
        this.a = bArr;
        this.b = lVar;
    }

    @Override // f.z.c.a
    public s invoke() {
        Map<String, String> mapA;
        String orDefault;
        e.g.a.b.b.a.g.a aVar = e.g.a.b.b.a.g.a.a;
        ConcurrentHashMap<f.c0.b<?>, f.d<?>> concurrentHashMapA = aVar.a();
        f.c0.b bVarA = f.z.d.s.a(j.class);
        Objects.requireNonNull(concurrentHashMapA, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        f.d<?> orDefault2 = concurrentHashMapA.getOrDefault(bVarA, null);
        Object value = orDefault2 == null ? null : orDefault2.getValue();
        j jVar = value instanceof j ? (j) value : null;
        if (jVar == null) {
            aVar.b(f.z.d.s.a(j.class));
        } else {
            d.a.a.a$b.a.a aVarA = ((h) jVar).a(this.a);
            if (aVarA != null && (mapA = aVarA.a()) != null && (orDefault = mapA.getOrDefault("life_circle", null)) != null && aVarA.b == 2) {
                String strB = aVarA.b();
                d.a.a.a$b.c.b.c.b bVar = new d.a.a.a$b.c.b.c.b(strB, orDefault);
                f.z.d.j.l(Thread.currentThread().getName(), "Facade.CardClientFacade");
                System.currentTimeMillis();
                this.b.invoke(bVar);
                e.g.b.b.a.a("Facade.CardClientFacade", "[DEBUG_" + strB + "] request action: " + orDefault);
            }
        }
        return s.a;
    }
}
