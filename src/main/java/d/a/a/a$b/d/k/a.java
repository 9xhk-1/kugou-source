package d.a.a.a$b.d.k;

import f.z.d.j;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a a = new a();

    public final d.a.a.a$b.a.a a(JSONObject jSONObject) throws JSONException {
        j.e(jSONObject, "jsonObject");
        int i2 = jSONObject.getInt("cardId");
        int i3 = jSONObject.getInt("hostId");
        int i4 = jSONObject.getInt("action");
        int i5 = jSONObject.getInt("cardType");
        JSONObject jSONObject2 = jSONObject.has("param") ? jSONObject.getJSONObject("param") : new JSONObject();
        Iterator<String> itKeys = jSONObject2.keys();
        LinkedHashMap linkedHashMap = null;
        if (!itKeys.hasNext()) {
            itKeys = null;
        }
        if (itKeys != null) {
            linkedHashMap = new LinkedHashMap();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                j.d(next, "key");
                String string = jSONObject2.getString(next);
                j.d(string, "params.getString(key)");
                linkedHashMap.put(next, string);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i5);
        sb.append('&');
        sb.append(i2);
        sb.append('&');
        sb.append(i3);
        return new d.a.a.a$b.a.a(sb.toString(), i4, linkedHashMap);
    }
}
