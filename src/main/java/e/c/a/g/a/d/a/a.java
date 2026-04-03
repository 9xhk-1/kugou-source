package e.c.a.g.a.d.a;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.network.ackutils.StringResponsePackage;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import e.c.a.g.a.s.q0;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public List<Long> a;
    public List<String> b;

    /* JADX INFO: renamed from: e.c.a.g.a.d.a.a$a, reason: collision with other inner class name */
    public class C0041a extends e.c.a.g.a.f.k.a {
        public C0041a() {
        }

        @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
        public String getGetRequestParams() {
            return "?dfid=" + m.e();
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            JSONObject jSONObject = new JSONObject();
            try {
                long jF = l1.f();
                String strG = l1.g();
                String strValueOf = String.valueOf(l1.G());
                String strValueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
                Object objE = new q0().e(jF + strG + strValueOf + strValueOf2);
                jSONObject.put("appid", jF);
                jSONObject.put("clientver", strValueOf);
                jSONObject.put("mid", l1.n(KGApplication.getContext()));
                jSONObject.put("clienttime", strValueOf2);
                jSONObject.put("key", objE);
                jSONObject.put("fields", "album_name,album_id,publish_date,author_name,sizable_cover");
                jSONObject.put("dfid", m.e());
                jSONObject.put("plat", 1);
                JSONArray jSONArray = new JSONArray();
                a aVar = a.this;
                List<Long> list = aVar.a;
                if (list != null && aVar.b != null && list.size() == a.this.b.size()) {
                    for (int i2 = 0; i2 < a.this.a.size(); i2++) {
                        long jLongValue = a.this.a.get(i2).longValue();
                        String str = a.this.b.get(i2);
                        JSONObject jSONObject2 = new JSONObject();
                        if (jLongValue > 0) {
                            jSONObject2.put("album_audio_id", jLongValue);
                        }
                        jSONObject2.put("hash", str);
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                g0.k(e2);
            }
            StringEntity stringEntity = null;
            try {
                StringEntity stringEntity2 = new StringEntity(jSONObject.toString(), "UTF-8");
                try {
                    stringEntity2.setContentType("application/json");
                    return stringEntity2;
                } catch (UnsupportedEncodingException e3) {
                    e = e3;
                    stringEntity = stringEntity2;
                    if (g0.a) {
                        g0.c("AlbumMatch", "JsonRequestPackage ALBUM DETAIL getPostRequestEntity error");
                    }
                    g0.k(e);
                    return stringEntity;
                }
            } catch (UnsupportedEncodingException e4) {
                e = e4;
            }
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "ALBUM_DETAIL";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "POST";
        }

        @Override // e.c.a.g.a.f.k.a
        public ConfigKey getUrlConfigKey() {
            return e.c.a.g.a.f.e.b.U0;
        }
    }

    public class b extends StringResponsePackage<List<c>> {
        public b(a aVar) {
        }

        @Override // com.kugou.common.network.ackutils.StringResponsePackage, com.kugou.common.network.protocol.ResponsePackage
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void getResponseData(List<c> list) {
            if (list == null || TextUtils.isEmpty(this.mJsonString)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.mJsonString);
                int i2 = jSONObject.getInt(NotificationCompat.CATEGORY_STATUS);
                if (i2 != 0 && i2 == 1) {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONArray jSONArrayOptJSONArray = jSONArray.optJSONArray(i3);
                        c cVar = new c();
                        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(0);
                            cVar.e(jSONObject2.getLong("album_id"));
                            cVar.f(jSONObject2.getString("album_name"));
                            cVar.g(jSONObject2.optString("publish_date"));
                            cVar.d(jSONObject2.optString("sizable_cover"));
                            cVar.c(jSONObject2.optString("author_name"));
                        }
                        list.add(cVar);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
