package e.c.a.g.a.h;

import androidx.exifinterface.media.ExifInterface;
import e.c.a.g.a.s.g0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    public String a;
    public int b;
    public int c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1074e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f1076g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1073d = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1075f = 0;

    public String a() {
        return this.a;
    }

    public JSONObject b(int i2) {
        return c();
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, this.b);
            jSONObject.put(ExifInterface.GPS_DIRECTION_TRUE, this.c);
            jSONObject.put("C", this.f1073d);
            jSONObject.put("f", this.f1074e);
            jSONObject.put("h", this.a);
            jSONObject.put("s", this.f1075f);
            return jSONObject;
        } catch (JSONException e2) {
            g0.k(e2);
            return null;
        }
    }
}
