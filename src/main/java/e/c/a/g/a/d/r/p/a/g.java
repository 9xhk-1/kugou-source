package e.c.a.g.a.d.r.p.a;

import com.kugou.android.watch.lite.base.uistructure.PageKey;
import e.c.a.g.a.s.g0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public String a;
    public int b;
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PageKey f522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f523h;

    public long a() {
        return this.f520e;
    }

    public String b() {
        return this.f519d;
    }

    public String c() {
        return this.c;
    }

    public int d() {
        return this.b;
    }

    public String e() {
        return this.f523h;
    }

    public PageKey f() {
        return this.f522g;
    }

    public String g() {
        return this.a;
    }

    public boolean h() {
        if (g0.a) {
            g0.e("zzm-log", "hash" + this.c + "isNeedRecovery：" + this.f521f);
        }
        return this.f521f;
    }

    public void i(long j) {
        this.f520e = j;
    }

    public void j(String str) {
        this.f519d = str;
    }

    public void k(String str) {
        this.c = str;
    }

    public void l(int i2) {
        this.b = i2;
    }

    public void m(String str) {
        this.f523h = str;
    }

    public void n(boolean z) {
        this.f521f = z;
    }

    public void o(PageKey pageKey) {
        this.f522g = pageKey;
    }

    public void p(String str) {
        this.a = str;
    }

    public String q() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.b);
            String str = this.a;
            if (str != null) {
                jSONObject.put("type", str);
            }
            String str2 = this.c;
            if (str2 != null) {
                jSONObject.put("hash", str2);
            }
            String str3 = this.f523h;
            if (str3 != null) {
                jSONObject.put("name", str3);
            }
            String str4 = this.f519d;
            if (str4 != null) {
                jSONObject.put("album_id", str4);
            }
            long j = this.f520e;
            if (j != 0) {
                jSONObject.put("album_audio_id", j);
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            g0.k(e2);
            return "";
        }
    }

    public JSONObject r() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.b);
            String str = this.a;
            if (str != null) {
                jSONObject.put("type", str);
            }
            String str2 = this.c;
            if (str2 != null) {
                jSONObject.put("hash", str2);
            }
            String str3 = this.f523h;
            if (str3 != null) {
                jSONObject.put("name", str3);
            }
            String str4 = this.f519d;
            if (str4 != null) {
                jSONObject.put("album_id", str4);
            }
            long j = this.f520e;
            if (j != 0) {
                jSONObject.put("album_audio_id", j);
            }
            e.c.a.g.a.r.g.c.v(jSONObject, this.f522g);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
