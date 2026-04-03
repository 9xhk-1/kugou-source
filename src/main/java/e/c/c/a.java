package e.c.c;

import com.kugou.datacollect.apm.ApmData;
import com.kugou.datacollect.crash.bean.CrashBean;
import e.c.c.o.j;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static volatile a a = new a();

    public static a e() {
        return a;
    }

    public void a(ApmData apmData) {
        e.c.c.k.g.a.e().c("2", "", apmData.toMap());
        e.c.c.k.g.a.e().k();
    }

    public void b(String str) {
        HashMap map = new HashMap();
        map.put("data", str);
        e.c.c.k.g.a.e().a("1", "10033", map);
    }

    public void c(String str) {
        HashMap map = new HashMap();
        map.put("data", str);
        e.c.c.k.g.a.e().c("1", "10033", map);
        e.c.c.k.g.a.e().k();
    }

    public void d(CrashBean crashBean) {
        HashMap map = new HashMap();
        map.put("data", crashBean.toJson().toString());
        e.c.c.k.g.a.e().c("3", "", map);
    }

    public void f(String str) {
        b.b = str;
    }

    public void g(String str) {
        b.c = str;
    }

    public void h(boolean z) {
        e.c.c.o.g.a = true;
    }

    public void i(String str) {
        b.f1245e = str;
    }

    public void j() {
        e.c.c.k.g.a.e().i();
        e.c.c.k.g.b.a().b("");
        j.e();
    }
}
