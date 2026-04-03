package e.c.a.g.a.s;

import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e0 {
    public static String a(Hashtable<?, ?> hashtable) {
        if (hashtable == null || hashtable.size() == 0) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<?, ?> entry : hashtable.entrySet()) {
            try {
                jSONObject.put(entry.getKey().toString(), entry.getValue());
            } catch (Exception unused) {
            }
        }
        return jSONObject.toString();
    }

    public static JSONObject b(Hashtable<?, ?> hashtable) {
        if (hashtable == null || hashtable.size() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<?, ?> entry : hashtable.entrySet()) {
            try {
                jSONObject.put(entry.getKey().toString(), entry.getValue());
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static int c(JSONObject jSONObject, String str, String str2, int i2) {
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return jSONObject.optInt(str, i2);
            }
            if (jSONObject.has(str2)) {
                return jSONObject.optInt(str2, i2);
            }
        }
        return i2;
    }

    public static String d(JSONObject jSONObject, String str, String str2, String str3) {
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return jSONObject.optString(str, str3);
            }
            if (jSONObject.has(str2)) {
                return jSONObject.optString(str2, str3);
            }
        }
        return str3;
    }
}
