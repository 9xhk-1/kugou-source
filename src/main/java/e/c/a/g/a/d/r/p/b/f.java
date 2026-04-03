package e.c.a.g.a.d.r.p.b;

import android.text.TextUtils;
import android.util.Log;
import com.kugou.common.config.ConfigKey;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import e.c.a.g.a.s.q0;
import e.c.a.g.a.s.r1;
import java.util.Hashtable;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes.dex */
public class f extends e.c.a.g.a.f.k.a {
    public String a;
    public Hashtable<String, Object> b;

    public f(String str, Hashtable<String, Object> hashtable) {
        this.a = str;
        this.b = hashtable;
        a();
    }

    public final void a() {
        int configAsInt = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.c, 3337);
        if (this.mParams == null) {
            this.mParams = new Hashtable<>();
        }
        String strN = l1.n(e.c.c.o.f.a());
        int iG = l1.G();
        String strN2 = e.c.a.g.a.r.b.n();
        this.mParams.putAll(this.b);
        int iZ = e.c.a.g.a.r.b.z();
        long jO = e.c.a.g.a.r.b.o();
        String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f643e);
        String config2 = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f644f);
        if (TextUtils.isEmpty(config) || TextUtils.isEmpty(config2)) {
            this.mParams.put("key", new q0().e(this.a + "kgcloudv2" + configAsInt + strN + jO));
        } else {
            this.mParams.put("pidversion", config);
            this.mParams.put("key", new q0().e(this.a + config2 + configAsInt + strN + jO));
        }
        this.mParams.put("pid", Integer.valueOf(HttpStatus.SC_LENGTH_REQUIRED));
        this.mParams.put("appid", Integer.valueOf(configAsInt));
        this.mParams.put("mid", strN);
        this.mParams.put(ClientCookie.VERSION_ATTR, Integer.valueOf(iG));
        this.mParams.put("token", strN2);
        this.mParams.put("vipType", Integer.valueOf(iZ));
        this.mParams.put("userid", Long.valueOf(jO));
        this.mParams.put("area_code", e.c.a.g.a.r.b.c());
        this.mParams.put("dfid", m.e());
        if (jO > 0) {
            this.mParams.put("ptype", Integer.valueOf(e.c.a.g.a.d.r.a.c().d(jO)));
        } else {
            this.mParams.put("ptype", 0);
        }
        String config3 = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f642d);
        Hashtable<String, Object> hashtable = this.mParams;
        e.c.a.g.a.r.g.c cVarZ = e.c.a.g.a.r.g.c.z();
        cVarZ.s();
        hashtable.putAll(cVarZ.E());
        Hashtable<String, Object> hashtable2 = this.mParams;
        hashtable2.put("signature", r1.e(config3, hashtable2, null));
        if (g0.a) {
            g0.b("siganid-pagekey", "trackcdn-recovery");
        }
        setParams(this.mParams);
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public HttpEntity getPostRequestEntity() {
        return null;
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getRequestModuleName() {
        return "recovery_media_store";
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getRequestType() {
        return "GET";
    }

    @Override // e.c.a.g.a.f.k.a
    public ConfigKey getUrlConfigKey() {
        Log.d("mhs_watch_http", "trackerurl - 1");
        return e.c.a.g.a.f.e.b.Y;
    }
}
