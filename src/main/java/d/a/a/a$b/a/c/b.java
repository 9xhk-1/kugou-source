package d.a.a.a$b.a.c;

import android.content.Context;
import f.z.d.s;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public final Context a;

    public b() {
        Object value;
        e.g.a.b.b.a.g.a aVar = e.g.a.b.b.a.g.a.a;
        ConcurrentHashMap<f.c0.b<?>, f.d<?>> concurrentHashMapA = aVar.a();
        f.c0.b bVarA = s.a(Context.class);
        Objects.requireNonNull(concurrentHashMapA, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        Context context = null;
        f.d<?> orDefault = concurrentHashMapA.getOrDefault(bVarA, null);
        Context context2 = (orDefault == null || (value = orDefault.getValue()) == null || !(value instanceof Context)) ? null : (Context) value;
        if (context2 == null) {
            aVar.b(s.a(Context.class));
        } else {
            context = context2;
        }
        this.a = context;
    }

    public abstract String a(String str);

    public abstract boolean b(String str, String str2);
}
