package d.a.a.a$b.a.c;

import android.content.Context;
import f.z.d.s;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public a() {
        e.g.a.b.b.a.g.a aVar = e.g.a.b.b.a.g.a.a;
        ConcurrentHashMap<f.c0.b<?>, f.d<?>> concurrentHashMapA = aVar.a();
        f.c0.b bVarA = s.a(Context.class);
        Objects.requireNonNull(concurrentHashMapA, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        f.d<?> orDefault = concurrentHashMapA.getOrDefault(bVarA, null);
        Object value = orDefault == null ? null : orDefault.getValue();
        if ((value instanceof Context ? (Context) value : null) == null) {
            aVar.b(s.a(Context.class));
        }
    }

    public abstract void a(String str, byte[] bArr);

    public abstract byte[] b(String str);
}
