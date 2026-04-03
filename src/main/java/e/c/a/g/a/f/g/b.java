package e.c.a.g.a.f.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f654d;
    public final String a;
    public final boolean b;
    public final int c;

    public b(String str, boolean z, int i2) {
        this.a = str;
        this.b = z;
        this.c = i2;
    }

    public static b a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            return new b(jSONObject.getString("content"), jSONObject.getBoolean("fromFileCache"), jSONObject.getInt("material"));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", this.a);
            jSONObject.put("fromFileCache", this.b);
            jSONObject.put("material", this.c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    @NonNull
    public String toString() {
        return b();
    }
}
