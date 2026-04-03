package e.d.a.a;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static b a(File file) {
        Map<String, String> mapB = b(file);
        if (mapB == null) {
            return null;
        }
        String str = mapB.get("channel");
        mapB.remove("channel");
        return new b(str, mapB);
    }

    public static Map<String, String> b(File file) {
        try {
            String strC = c(file);
            if (strC == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strC);
            Iterator<String> itKeys = jSONObject.keys();
            HashMap map = new HashMap();
            while (itKeys.hasNext()) {
                String string = itKeys.next().toString();
                map.put(string, jSONObject.getString(string));
            }
            return map;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String c(File file) {
        return e.d(file, 1903654775);
    }
}
