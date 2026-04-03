package e.c.a.g.a.d.r.p.a;

import e.c.a.g.a.s.g0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public String a;
    public String b;
    public int c;

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.c);
            String str = this.b;
            if (str != null) {
                jSONObject.put("type", str);
            }
            String str2 = this.a;
            if (str2 != null) {
                jSONObject.put("module", str2);
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            g0.k(e2);
            return "";
        }
    }
}
