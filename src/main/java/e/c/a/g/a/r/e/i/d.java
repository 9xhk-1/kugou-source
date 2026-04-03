package e.c.a.g.a.r.e.i;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.kugou.common.network.ackutils.StringResponsePackage;
import com.kugou.common.network.networkutils.UrlEncoderUtil;
import com.kugou.common.network.protocol.AbstractRequestPackage;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.m0;
import e.c.a.g.a.s.q0;
import java.util.Hashtable;
import org.apache.http.HttpEntity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    public static class b extends AbstractRequestPackage {
        public b() {
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            return null;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "Share";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "GET";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getUrl() {
            return e.c.a.g.a.f.e.c.c().b(e.c.a.g.a.f.e.b.F0, "http://t.service.kugou.com/app/");
        }
    }

    public static class c extends StringResponsePackage<C0180d> {
        public c() {
        }

        @Override // com.kugou.common.network.ackutils.StringResponsePackage, com.kugou.common.network.protocol.ResponsePackage
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void getResponseData(C0180d c0180d) {
            try {
                JSONObject jSONObject = new JSONObject(this.mJsonString);
                if (!"0".equals(jSONObject.getString(NotificationCompat.CATEGORY_STATUS))) {
                    c0180d.a = jSONObject.getString("data");
                } else {
                    c0180d.b = 2;
                    c0180d.c = jSONObject.optInt("err_code");
                }
            } catch (JSONException e2) {
                g0.k(e2);
                c0180d.b = 3;
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.r.e.i.d$d, reason: collision with other inner class name */
    public static class C0180d {
        public String a = "";
        public int b = 0;
        public int c;
    }

    public static String c(String str) {
        String str2;
        C0180d c0180dA = new d().a(str, m0.a());
        int i2 = c0180dA.b;
        boolean z = true;
        if (i2 == 1 || i2 == 3 || i2 == 2) {
            z = false;
            str2 = str;
        } else {
            str2 = c0180dA.a;
        }
        Log.e("mhs_watch", "link=" + str + ", shortLink = " + str2 + ", success = " + z);
        return str2;
    }

    public C0180d a(String str, int i2) {
        return b(str, i2, true);
    }

    public C0180d b(String str, int i2, boolean z) {
        C0180d c0180d = new C0180d();
        if (str != null) {
            try {
                if (!str.equals("")) {
                    c cVar = new c();
                    b bVar = new b();
                    Hashtable<String, Object> hashtable = new Hashtable<>();
                    hashtable.put("cmid", 5);
                    q0 q0Var = new q0();
                    hashtable.put("md5", q0Var.e("kgclientshare" + q0Var.d(e.a(str).getBytes())));
                    if (z) {
                        str = str.replaceAll(" ", "");
                    }
                    hashtable.put("url", UrlEncoderUtil.encode(e.a(str)));
                    hashtable.put("area_code", e.c.a.g.a.r.b.c());
                    bVar.setParams(hashtable);
                    e.c.a.g.a.f.k.k.e eVarA = e.c.a.g.a.f.k.k.e.a();
                    if (i2 != 0) {
                        eVarA.setMaxWaitDuration(i2);
                    }
                    e.c.a.g.a.f.k.k.e.a().request(bVar, cVar);
                    cVar.getResponseData(c0180d);
                    return c0180d;
                }
            } catch (Exception e2) {
                g0.k(e2);
                c0180d.b = 1;
                return c0180d;
            }
        }
        c0180d.b = 2;
        return c0180d;
    }
}
