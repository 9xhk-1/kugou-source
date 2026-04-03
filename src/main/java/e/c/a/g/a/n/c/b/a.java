package e.c.a.g.a.n.c.b;

import androidx.core.app.NotificationCompat;
import com.google.gson.JsonObject;
import e.c.a.g.a.f.k.c;
import e.c.a.g.a.f.k.d;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.r1;
import f.z.d.j;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final a a = new a();

    /* JADX INFO: renamed from: e.c.a.g.a.n.c.b.a$a, reason: collision with other inner class name */
    public static final class C0169a<T, R> implements Func1 {
        public static final C0169a<T, R> a = new C0169a<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Observable<? extends c<e.c.a.g.a.n.c.a>> call(ResponseBody responseBody) {
            a aVar = a.a;
            j.d(responseBody, "responseBody");
            return aVar.d(responseBody);
        }
    }

    public static final class b<T, R> implements Func1 {
        public static final b<T, R> a = new b<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c<e.c.a.g.a.n.c.a> call(Throwable th) {
            c<e.c.a.g.a.n.c.a> cVar = new c<>();
            cVar.m(0);
            return cVar;
        }
    }

    public final Observable<c<e.c.a.g.a.n.c.a>> b(String str, String str2) {
        j.e(str, "eventId");
        j.e(str2, "busId");
        d dVar = (d) new Retrofit.Builder().setModuleName("IOT").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.o1, "https://verifyservice.kugou.com/v1/iot_qrcode")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(d.class);
        String strD = e.c.a.g.a.r.g.a.d();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / ((long) 1000));
        JsonObject jsonObject = new JsonObject();
        String strH = l1.h();
        j.d(strH, "getAppRsa()");
        HashMap map = new HashMap();
        map.put("clienttime", Integer.valueOf(iCurrentTimeMillis));
        j.d(strD, "aesKey");
        map.put("key", strD);
        jsonObject.addProperty("pk", e.c.a.g.a.r.g.d.e(e.c.a.g.a.r.e.b.e(map), strH));
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("userid", Long.valueOf(e.c.a.g.a.r.b.o()));
        jsonObject2.addProperty("eventid", str);
        jsonObject2.addProperty("businessid", str2);
        jsonObject2.addProperty("token", e.c.a.g.a.f.m.c.a.d("key_user_token", "-"));
        jsonObject.addProperty("params", e.c.a.g.a.r.g.a.b(jsonObject2.toString(), strD));
        jsonObject.addProperty("userid", Long.valueOf(e.c.a.g.a.r.b.o()));
        HashMap map2 = new HashMap();
        map2.put("clienttime", String.valueOf(iCurrentTimeMillis));
        String string = jsonObject.toString();
        j.d(string, "bodyObject.toString()");
        e.c.a.g.a.r.g.c cVarZ = e.c.a.g.a.r.g.c.z();
        cVarZ.k(string, map2);
        Map<String, String> mapE = cVarZ.E();
        j.d(mapE, "getGenerator()\n            .appendCommonSignature(body, clientTimeMap)\n            .toMapParams()");
        Observable<c<e.c.a.g.a.n.c.a>> observableOnErrorReturn = dVar.post(mapE, RequestBody.create(MediaType.parse("application/json"), string)).flatMap(C0169a.a).onErrorReturn(b.a);
        j.d(observableOnErrorReturn, "request.post(map, RequestBody.create(MediaType.parse(\"application/json\"), body))\n            .flatMap { responseBody ->\n                parseBody(responseBody)\n            }\n            .onErrorReturn {\n                val response = CommonResponse<IOTCode>()\n                response.setStatus(0)\n                response\n            }");
        return observableOnErrorReturn;
    }

    public final String c(String str) {
        return "https://activity.kugou.com/iot/v-c0a49360/index.html?code=" + str + "&id=" + e.c.a.g.a.r.b.o() + "&name=" + ((Object) URLEncoder.encode(e.c.a.g.a.r.b.r()));
    }

    public final Observable<c<e.c.a.g.a.n.c.a>> d(ResponseBody responseBody) {
        JSONObject jSONObjectOptJSONObject;
        try {
            c cVar = new c();
            String strString = responseBody.string();
            if (g0.a) {
                g0.e("lzq-young", strString);
            }
            JSONObject jSONObject = new JSONObject(strString);
            cVar.m(jSONObject.optInt(NotificationCompat.CATEGORY_STATUS));
            cVar.k(jSONObject.optInt("error_code"));
            cVar.l(jSONObject.optString("error_msg"));
            if (cVar.f() && (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) != null) {
                String strOptString = jSONObjectOptJSONObject.optString("qrcode_token", "");
                long jOptLong = jSONObjectOptJSONObject.optLong("ttl", 0L);
                j.d(strOptString, "qrcodeToken");
                cVar.g(new e.c.a.g.a.n.c.a(strOptString, a.c(strOptString), jOptLong));
            }
            Observable<c<e.c.a.g.a.n.c.a>> observableJust = Observable.just(cVar);
            j.d(observableJust, "{\n            val response = CommonResponse<IOTCode>()\n            val content = responseBody.string()\n            if (KGLog.DEBUG) KGLog.i(\"lzq-young\", content)\n            val jsonObject = JSONObject(content)\n            response.setStatus(jsonObject.optInt(\"status\"))\n            response.setErrorCode(jsonObject.optInt(\"error_code\"))\n            response.errorMsg = jsonObject.optString(\"error_msg\")\n            if (response.isSuccess) {\n                val data = jsonObject.optJSONObject(\"data\")\n                data?.run {\n                    val qrcodeToken = optString(\"qrcode_token\", \"\")\n                    val ttl = optLong(\"ttl\", 0)\n                    response.data = IOTCode(qrcodeToken, getUrl(qrcodeToken), ttl)\n                }\n            }\n            Observable.just(response)\n        }");
            return observableJust;
        } catch (Exception unused) {
            Observable<c<e.c.a.g.a.n.c.a>> observableError = Observable.error(new e.c.a.g.a.f.k.g.b(null));
            j.d(observableError, "{\n            Observable.error(ChannelParseException(null))\n        }");
            return observableError;
        }
    }
}
