package e.c.c.l;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a implements e.c.c.k.a {
    @Override // e.c.c.k.a
    public e.c.c.k.f.b toCacheData(String str, Map<String, String> map) {
        return new e.c.c.k.f.b("1", str, map.get("data"), System.currentTimeMillis());
    }
}
