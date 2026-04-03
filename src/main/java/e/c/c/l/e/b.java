package e.c.c.l.e;

import com.kugou.common.player.kugouplayer.j;
import e.c.c.o.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public final String a = m.v();
    public j b;

    public static class a {
        public long a;
        public long b;
        public String c;
    }

    public b() {
        try {
            this.b = new j(e.c.c.o.f.a());
        } catch (Exception e2) {
            e2.printStackTrace();
            this.b = null;
        }
        j jVar = this.b;
        if (jVar != null) {
            jVar.l(this.a);
        }
    }

    public byte[] a(byte[] bArr) {
        j jVar = this.b;
        if (jVar != null) {
            return jVar.o(bArr);
        }
        return null;
    }

    public String b(long j) {
        String string;
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(String.valueOf(j));
            string = new JSONObject().put("appends", jSONArray).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            string = null;
        }
        j jVar = this.b;
        if (jVar != null) {
            return jVar.m(string);
        }
        return null;
    }

    public a c() {
        j jVar = this.b;
        if (jVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.c = jVar.q(null);
        aVar.b = this.b.r(null);
        aVar.a = this.b.s(null);
        return aVar;
    }

    public String d() {
        return this.a;
    }

    public boolean e() {
        j jVar = this.b;
        if (jVar != null) {
            return jVar.p(null);
        }
        return false;
    }

    public void f(String str) {
        j jVar = this.b;
        if (jVar != null) {
            jVar.n(str);
        }
    }
}
