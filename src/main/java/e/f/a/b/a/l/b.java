package e.f.a.b.a.l;

import f.z.d.g;
import f.z.d.j;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public JSONObject a;

    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public b(JSONObject jSONObject) {
        j.f(jSONObject, "params");
        this.a = jSONObject;
        j.b(UUID.randomUUID().toString(), "UUID.randomUUID().toString()");
        System.currentTimeMillis();
    }

    public final void a(int i2) {
    }

    public final void b(long j) {
    }

    public final void c(JSONObject jSONObject) {
        j.f(jSONObject, "<set-?>");
        this.a = jSONObject;
    }

    public final void d(String str) {
        j.f(str, "<set-?>");
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof b) && j.a(this.a, ((b) obj).a);
        }
        return true;
    }

    public int hashCode() {
        JSONObject jSONObject = this.a;
        if (jSONObject != null) {
            return jSONObject.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ReportData(params=" + this.a + ")";
    }

    public /* synthetic */ b(JSONObject jSONObject, int i2, g gVar) {
        this((i2 & 1) != 0 ? new JSONObject() : jSONObject);
    }
}
