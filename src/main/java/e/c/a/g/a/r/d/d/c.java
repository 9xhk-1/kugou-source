package e.c.a.g.a.r.d.d;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.network.AbsHttpClient;
import e.c.a.g.a.f.k.k.h;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f1165e = 1;
    public String a = "UpdateUserInfoProtocol";
    public int b = 0;
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1166d;

    public class a implements AbsHttpClient.IRequestUrlReceiver {
        public String a = null;

        public a(c cVar) {
        }

        @Override // com.kugou.common.network.AbsHttpClient.IRequestUrlReceiver
        public String getRequestUrl(String str) {
            return this.a;
        }

        @Override // com.kugou.common.network.AbsHttpClient.IRequestUrlReceiver
        public void onHttpGet(String str) {
            this.a = str;
        }

        @Override // com.kugou.common.network.AbsHttpClient.IRequestUrlReceiver
        public void onHttpPost(String str) {
            this.a = str;
        }

        @Override // com.kugou.common.network.AbsHttpClient.IRequestUrlReceiver
        public void onUrlState(String str, boolean z) {
        }
    }

    public static class b {
        public int a;
        public int b;
        public String c;

        public boolean a() {
            return this.a == 1;
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.r.d.d.c$c, reason: collision with other inner class name */
    public class C0179c extends g {
        public C0179c() {
        }

        @Override // e.c.a.g.a.r.d.d.g, com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
        public String getGetRequestParams() {
            return "";
        }

        @Override // e.c.a.g.a.r.d.d.g, com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            try {
                this.map.put("userid", Long.valueOf(e.c.a.g.a.r.b.o()));
                String strE = c.this.e();
                if (strE == null) {
                    return null;
                }
                HashMap map = new HashMap();
                map.put("clienttime", Integer.valueOf(this.clientTime));
                if (c.this.b == c.f1165e) {
                    map.put("token", e.c.a.g.a.r.b.n());
                }
                String strD = e.c.a.g.a.r.e.b.d(map);
                if (g0.a) {
                    g0.e(c.this.a, strD);
                }
                this.map.put("p", e.c.a.g.a.r.g.d.d(strD, l1.h()));
                String strD2 = e.c.a.g.a.r.e.b.d(this.map);
                if (!TextUtils.isEmpty(strE)) {
                    strD2 = strD2.substring(0, strD2.length() - 1) + "," + strE + "}";
                }
                StringEntity stringEntity = new StringEntity(strD2, "utf-8");
                if (g0.a) {
                    g0.e("UpdateUserInfoProtocol", strD2);
                }
                return stringEntity;
            } catch (Exception e2) {
                g0.k(e2);
                return null;
            }
        }

        @Override // e.c.a.g.a.r.d.d.g, com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "User";
        }

        @Override // e.c.a.g.a.r.d.d.g, com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "POST";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getUrl() {
            return e.c.a.g.a.f.e.c.c().getConfig(getUrlConfigKey());
        }

        public ConfigKey getUrlConfigKey() {
            return e.c.a.g.a.f.e.b.c0;
        }
    }

    public class d extends h<b> {
        public e.c.a.g.a.d.b.a b;

        public d(c cVar) {
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void getResponseData(b bVar) {
            String str = this.a;
            if (str == null || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.a);
                bVar.a = jSONObject.getInt(NotificationCompat.CATEGORY_STATUS);
                bVar.b = jSONObject.getInt("error_code");
                if (TextUtils.isEmpty(jSONObject.optString("data"))) {
                    return;
                }
                bVar.c = jSONObject.getString("data");
            } catch (Exception e2) {
                bVar.a = 0;
                g0.k(e2);
            }
        }

        @Override // e.c.a.g.a.f.k.k.a
        public void onHandleApmData(e.c.a.g.a.d.b.a aVar) {
            this.b = aVar;
        }
    }

    public final String e() {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(this.c)) {
            map.put("nickname", this.c);
        }
        if (!TextUtils.isEmpty(this.f1166d)) {
            map.put("photo", this.f1166d);
        }
        if (map.size() == 0) {
            return null;
        }
        String strD = e.c.a.g.a.r.e.b.d(map);
        if (TextUtils.isEmpty(strD)) {
            return null;
        }
        return "\"data\":" + strD;
    }

    public final b f() {
        b bVar = new b();
        C0179c c0179c = new C0179c();
        d dVar = new d(this);
        a aVar = new a(this);
        try {
            e.c.a.g.a.f.k.k.e eVarA = e.c.a.g.a.f.k.k.e.a();
            eVarA.setRequestUrlReceiver(aVar);
            eVarA.request(c0179c, dVar);
            dVar.getResponseData(bVar);
        } catch (Exception e2) {
            g0.k(e2);
        }
        if (g0.a) {
            g0.b(this.a, "UpdateUserInfoProtocol");
        }
        return bVar;
    }

    public b g(String str) {
        this.b = f1165e;
        this.c = str;
        return f();
    }

    public b h(String str) {
        this.b = f1165e;
        this.f1166d = str;
        return f();
    }
}
