package e.c.a.g.a.g.i;

import android.text.TextUtils;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.network.protocol.AbstractRequestPackage;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.q0;
import java.util.ArrayList;
import java.util.Hashtable;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h extends AbstractRequestPackage {
    public String a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f850f;
    public String b = null;
    public String c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f849e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConfigKey[] f848d = g.a();

    public static class a implements Header {
        public String a;
        public String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // org.apache.http.Header
        public HeaderElement[] getElements() throws ParseException {
            return null;
        }

        @Override // org.apache.http.Header
        public String getName() {
            return this.a;
        }

        @Override // org.apache.http.Header
        public String getValue() {
            return this.b;
        }
    }

    public h() {
        this.a = "";
        this.a = d();
    }

    public void a(Hashtable<String, Object> hashtable) {
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        if (TextUtils.isEmpty(this.a)) {
            char[] cArr = new char[6];
            for (int i2 = 0; i2 < 6; i2++) {
                double dRandom = Math.random();
                double d2 = 62;
                Double.isNaN(d2);
                cArr[i2] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt((int) (dRandom * d2));
            }
            this.a = new String(cArr);
            this.b = new q0().e(this.a).substring(0, 16);
            this.c = new q0().e(this.a).substring(16, 32);
            if (g0.a) {
                g0.b("getRandomAesStr", this.a);
            }
        }
        return this.a;
    }

    public long e() {
        return e.c.a.g.a.r.b.o();
    }

    public void f() {
        long configAsInt = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.c);
        String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f642d);
        int iC = e.c.a.g.a.r.e.b.c(e.c.c.o.f.a());
        String strN = l1.n(e.c.c.o.f.a());
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        Hashtable<String, Object> hashtable = new Hashtable<>();
        this.mParams = hashtable;
        hashtable.put("appid", Long.valueOf(configAsInt));
        this.mParams.put("clientver", Integer.valueOf(iC));
        this.mParams.put("mid", strN);
        this.mParams.put("clienttime", Integer.valueOf(iCurrentTimeMillis));
        String strB = e.c.a.g.a.r.e.b.b(configAsInt, config, iC, iCurrentTimeMillis + "");
        this.f850f = strB;
        this.mParams.put("key", strB);
        this.mParams.put("dfid", e.c.a.g.a.s.m.e());
        a(this.mParams);
        this.a = d();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("aes", this.a);
            jSONObject.put("uid", e());
            jSONObject.put("token", e.c.a.g.a.r.b.n());
            this.mParams.put("p", e.c.a.g.a.r.g.d.e(jSONObject.toString(), l1.h()));
        } catch (Exception e2) {
            if (g0.f()) {
                g0.k(e2);
            }
        }
    }

    public void g() {
        ConfigKey[] configKeyArr = this.f848d;
        if (configKeyArr == null || configKeyArr.length <= 0) {
            return;
        }
        g.b(configKeyArr[this.f849e]);
        int i2 = this.f849e + 1;
        this.f849e = i2;
        this.f849e = i2 % this.f848d.length;
    }

    @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
    public String getGetRequestParams() {
        f();
        return super.getGetRequestParams();
    }

    @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
    public Header[] getHttpHeaders() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a("Content-Type", "application/json;charset=utf-8"));
        return (Header[]) arrayList.toArray(new Header[arrayList.size()]);
    }
}
