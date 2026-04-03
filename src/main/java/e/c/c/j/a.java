package e.c.c.j;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements e.c.c.k.a {
    public String a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    try {
                        jSONObject.put(entry.getKey(), value);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return jSONObject.toString();
    }

    @Override // e.c.c.k.a
    public e.c.c.k.f.b toCacheData(String str, Map<String, String> map) {
        return new e.c.c.k.f.b("2", "", a(map), System.currentTimeMillis());
    }
}
