package e.c.a.g.a.r.e.i;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.r1;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    public interface a {
        @Headers({"retrofit_interceptor_ignore:true"})
        @POST
        Call<g> sendMobileCode(@QueryMap Map<String, String> map, @Body RequestBody requestBody);
    }

    public static class b extends Converter.Factory {

        public class a implements Converter<ResponseBody, g> {
            public a(b bVar) {
            }

            @Override // retrofit2.Converter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public g convert(ResponseBody responseBody) throws IOException {
                String strString = responseBody.string();
                g gVar = new g();
                try {
                    JSONObject jSONObject = new JSONObject(strString);
                    gVar.j(jSONObject.getInt(NotificationCompat.CATEGORY_STATUS));
                    if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS) == 1) {
                        gVar.f(jSONObject.optString("data"));
                        JSONObject jSONObject2 = new JSONObject(jSONObject.optString("data"));
                        gVar.f(jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE));
                        gVar.g(jSONObject2.optInt("count"));
                    } else {
                        gVar.i(jSONObject.optInt("error_code"));
                        gVar.h(jSONObject.optString("data"));
                    }
                } catch (JSONException e2) {
                    g0.k(e2);
                }
                return gVar;
            }
        }

        @Override // retrofit2.Converter.Factory
        public Converter<ResponseBody, g> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return new a(this);
        }
    }

    public static String a(long j, int i2, String str, long j2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("plat", "1");
            jSONObject.put("businessid", i2);
            jSONObject.put("clienttime_ms", j);
            String strD = e.c.a.g.a.r.g.a.d();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("clienttime_ms", j);
            jSONObject3.put("key", strD);
            jSONObject.put("pk", e.c.a.g.a.r.g.d.d(jSONObject3.toString(), l1.h()));
            if (!e.c.a.g.a.r.b.F()) {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("mobile", f.a(str));
                    jSONObject2.put("mobile", str);
                }
                if (j2 > 0) {
                    jSONObject.put("userid", j2);
                    jSONObject2.put("mobile", str);
                }
            } else if (TextUtils.isEmpty(str) || str.contains("*")) {
                jSONObject.put("userid", e.c.a.g.a.r.b.o());
                jSONObject2.put("token", e.c.a.g.a.r.b.n());
            } else {
                jSONObject.put("mobile", f.a(str));
                jSONObject2.put("mobile", str);
            }
            jSONObject.put("params", e.c.a.g.a.r.g.a.b(jSONObject2.toString(), strD));
            return jSONObject.toString();
        } catch (Exception e2) {
            g0.k(e2);
            return "";
        }
    }

    public g b(String str, int i2) {
        return c(str, 0L, i2);
    }

    public final g c(String str, long j, int i2) {
        a aVar = (a) new Retrofit.Builder().setModuleName("SendMobileCodeProtocolV7").addConverterFactory(new b()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.q1, "https://login.user.kugou.com/v8/send_mobile_code")).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build().create(a.class);
        e.c.a.g.a.r.g.c cVarZ = e.c.a.g.a.r.g.c.z();
        cVarZ.s();
        Map<String, String> mapE = cVarZ.E();
        String strA = a(h1.v(mapE.get("clienttime"), 0L), i2, str, j);
        mapE.put("signature", r1.f(e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f642d), mapE, strA));
        try {
            Response<g> responseExecute = aVar.sendMobileCode(mapE, RequestBody.create(MediaType.parse("application/json"), strA)).execute();
            if (!responseExecute.isSuccessful() || responseExecute.body() == null) {
                return null;
            }
            return responseExecute.body();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
