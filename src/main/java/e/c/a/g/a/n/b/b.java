package e.c.a.g.a.n.b;

import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.config.ConfigKey;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.r1;
import java.io.IOException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    @Nullable
    public static a a() {
        try {
            return b();
        } catch (Exception e2) {
            if (e2 instanceof SSLHandshakeException) {
                e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.auto.login_time_error"));
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static a b() throws Exception {
        e.c.a.g.a.f.k.d dVar = (e.c.a.g.a.f.k.d) new Retrofit.Builder().setModuleName("QrCode").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.v, "https://login-user.kugou.com/v2/qrcode")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(e.c.a.g.a.f.k.d.class);
        e.c.a.g.a.r.g.c cVarZ = e.c.a.g.a.r.g.c.z();
        cVarZ.c("plat", "1");
        cVarZ.c("type", "3");
        cVarZ.j("");
        ResponseBody responseBodyBody = dVar.call(cVarZ.E()).execute().body();
        if (responseBodyBody == null) {
            return null;
        }
        a aVar = new a();
        JSONObject jSONObject = new JSONObject(responseBodyBody.string());
        aVar.a = jSONObject.optInt("error_code");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        if (jSONObjectOptJSONObject != null) {
            aVar.d(jSONObjectOptJSONObject.optString("qrcode"));
        }
        return aVar;
    }

    @Nullable
    public static d c(String str) {
        try {
            return d(str);
        } catch (Exception e2) {
            if (e2 instanceof SSLHandshakeException) {
                e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.auto.login_time_error"));
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static d d(String str) throws Exception {
        e.c.a.g.a.f.k.d dVar = (e.c.a.g.a.f.k.d) new Retrofit.Builder().setModuleName("QrCode").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.u, "https://gateway.kugou.com/wechat.mobile/api/v1/qrcode/login")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(e.c.a.g.a.f.k.d.class);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wxid", 8);
            jSONObject.put("plat", 1);
            jSONObject.put("dev", l1.n(KGApplication.getContext()));
            jSONObject.put("login_code", str);
            jSONObject.put("source_type", 1);
            jSONObject.put("source_id", l1.j());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String string = jSONObject.toString();
        RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), string);
        e.c.a.g.a.r.g.c cVarZ = e.c.a.g.a.r.g.c.z();
        cVarZ.c("plat", "1");
        cVarZ.c("type", "3");
        cVarZ.j(string);
        ResponseBody responseBodyBody = dVar.call(cVarZ.E(), requestBodyCreate).execute().body();
        if (responseBodyBody == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject(responseBodyBody.string());
        if (jSONObject2.optInt(NotificationCompat.CATEGORY_STATUS) != 1) {
            return null;
        }
        d dVar2 = new d();
        JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("data");
        dVar2.a = jSONObjectOptJSONObject.optInt("qr_code_type");
        dVar2.f1123e = str;
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("qr_code_info");
        if (jSONObjectOptJSONObject2 != null) {
            dVar2.c = jSONObjectOptJSONObject2.optString("url");
            dVar2.b = jSONObjectOptJSONObject2.optLong("expire_time");
        }
        return dVar2;
    }

    @Nullable
    public static c e(String str) {
        try {
            ConfigKey configKey = new ConfigKey(e.c.a.g.a.f.e.b.w.key + "/" + str);
            Retrofit retrofitBuild = new Retrofit.Builder().setModuleName("QrCode").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(configKey, "https://login-user.kugou.com/v2/get_userinfo_qrcode/" + str)).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build();
            e.c.a.g.a.r.g.c cVarZ = e.c.a.g.a.r.g.c.z();
            cVarZ.c("plat", "1");
            cVarZ.c("qrcode", str);
            cVarZ.j("");
            ResponseBody responseBodyBody = ((e.c.a.g.a.f.k.d) retrofitBuild.create(e.c.a.g.a.f.k.d.class)).call(cVarZ.E()).execute().body();
            if (responseBodyBody == null) {
                return null;
            }
            c cVar = new c();
            String strString = responseBodyBody.string();
            if (g0.a) {
                g0.b("young_xcl", "qr_code_status = " + strString);
            }
            JSONObject jSONObject = new JSONObject(strString);
            cVar.a = jSONObject.optInt("error_code");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null) {
                cVar.b = true;
                cVar.f1119e = jSONObjectOptJSONObject.optString("nickname");
                cVar.f1120f = jSONObjectOptJSONObject.optString("pic");
                cVar.c = jSONObjectOptJSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                cVar.f1121g = jSONObjectOptJSONObject.optString("token");
                cVar.f1118d = jSONObjectOptJSONObject.optLong("userid");
            } else {
                cVar.b = false;
            }
            return cVar;
        } catch (IOException | JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
