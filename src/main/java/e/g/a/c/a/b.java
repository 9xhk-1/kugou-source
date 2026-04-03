package e.g.a.c.a;

import android.content.Context;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import f.j;
import f.k;
import f.z.d.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final b a = new b();

    public final void a(JSONObject jSONObject, String str, String str2, Object obj) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("id");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject2 == null) {
            jSONObjectOptJSONObject2 = new JSONObject();
        }
        if (obj == null) {
            jSONObjectOptJSONObject2.remove(str2);
        } else {
            jSONObjectOptJSONObject2.put(str2, obj);
        }
        jSONObjectOptJSONObject.put(str, jSONObjectOptJSONObject2);
        jSONObject.put("id", jSONObjectOptJSONObject);
    }

    public final long b(Context context) {
        Object objA;
        j.e(context, "context");
        try {
            j.a aVar = f.j.a;
            objA = Long.valueOf(context.getPackageManager().getPackageInfo(OpenApiConstant.App.LAUNCHER, 0) == null ? -1L : r5.versionCode);
            f.j.a(objA);
        } catch (Throwable th) {
            j.a aVar2 = f.j.a;
            objA = k.a(th);
            f.j.a(objA);
        }
        if (f.j.c(objA)) {
            objA = -1L;
        }
        return ((Number) objA).longValue();
    }

    public final void c(JSONObject jSONObject, String str, String str2, Object obj) throws JSONException {
        f.z.d.j.e(jSONObject, "jsonObject");
        f.z.d.j.e(str, "id");
        f.z.d.j.e(str2, "key");
        if (jSONObject.optBoolean("LOCAL_UPDATE")) {
            a(jSONObject, str, str2, obj);
            return;
        }
        d(jSONObject, str, str2, obj);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("child");
        if (jSONArrayOptJSONArray == null) {
            return;
        }
        int i2 = 0;
        int length = jSONArrayOptJSONArray.length();
        if (length <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (f.z.d.j.a(jSONObjectOptJSONObject.getString("type"), "constraint")) {
                b bVar = a;
                f.z.d.j.d(jSONObjectOptJSONObject, "entityChild");
                bVar.c(jSONObjectOptJSONObject, str, str2, obj);
            } else {
                b bVar2 = a;
                f.z.d.j.d(jSONObjectOptJSONObject, "entityChild");
                bVar2.d(jSONObjectOptJSONObject, str, str2, obj);
            }
            if (i3 >= length) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    public final void d(JSONObject jSONObject, String str, String str2, Object obj) throws JSONException {
        if (f.z.d.j.a(str, jSONObject.optString("id"))) {
            if (obj == null) {
                jSONObject.remove(str2);
            } else {
                jSONObject.put(str2, obj);
            }
        }
    }
}
