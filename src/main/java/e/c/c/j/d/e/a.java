package e.c.c.j.d.e;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public String a = "ApmCache";
    public List<String> b = new ArrayList();
    public Map<String, Map<String, String>> c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, Map<String, Long>> f1248d = new ConcurrentHashMap();

    public void a(String str, String str2, String str3) {
        e(str).put(str2, str3);
    }

    public void b(String str, String str2, long j) {
        f(str).put(str2, Long.valueOf(j));
    }

    public void c(String str) {
        this.f1248d.remove(str);
        this.c.remove(str);
    }

    public synchronized e.c.c.j.d.e.d.a d(String str) {
        if (str == null) {
            return null;
        }
        Map<String, String> map = this.c.get(str);
        Map<String, Long> map2 = this.f1248d.get(str);
        c(str);
        return h(new e.c.c.j.d.e.d.a(b.b().a(str), map, map2));
    }

    public final synchronized Map<String, String> e(String str) {
        if (str == null) {
            return new HashMap();
        }
        Map<String, String> map = this.c.get(str);
        if (map == null) {
            map = new HashMap<>();
            this.c.put(str, map);
        }
        return map;
    }

    public final Map<String, Long> f(String str) {
        if (str == null) {
            return new HashMap();
        }
        Map<String, Long> map = this.f1248d.get(str);
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        this.f1248d.put(str, map2);
        return map2;
    }

    public final boolean g(String str) {
        return this.b.contains(str);
    }

    public final e.c.c.j.d.e.d.a h(e.c.c.j.d.e.d.a aVar) {
        if (g(aVar.c())) {
            return null;
        }
        Log.d(this.a, "syncApmDataFromDb: 该类型无需db缓存");
        return aVar;
    }
}
