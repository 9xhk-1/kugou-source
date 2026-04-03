package e.c.a.g.a.n.c.b;

import androidx.core.app.NotificationCompat;
import com.google.gson.JsonObject;
import e.c.a.g.a.f.k.c;
import e.c.a.g.a.f.k.d;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.r1;
import f.z.d.j;
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
public final class b {
    public static final b a = new b();

    public static final class a<T, R> implements Func1 {
        public static final a<T, R> a = new a<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Observable<? extends c<Integer>> call(ResponseBody responseBody) {
            b bVar = b.a;
            j.d(responseBody, "responseBody");
            return bVar.c(responseBody);
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.n.c.b.b$b, reason: collision with other inner class name */
    public static final class C0170b<T, R> implements Func1 {
        public static final C0170b<T, R> a = new C0170b<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c<Integer> call(Throwable th) {
            c<Integer> cVar = new c<>();
            cVar.m(0);
            return cVar;
        }
    }

    public final Observable<c<Integer>> b(String str, String str2) {
        j.e(str, "eventId");
        j.e(str2, "qrcodeToken");
        d dVar = (d) new Retrofit.Builder().setModuleName("IOT").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.p1, "https://verifyservice.kugou.com/v1/iot_query_event")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(d.class);
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
        jsonObject2.addProperty("qrcode_token", str2);
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
        Observable<c<Integer>> observableOnErrorReturn = dVar.post(mapE, RequestBody.create(MediaType.parse("application/json"), string)).flatMap(a.a).onErrorReturn(C0170b.a);
        j.d(observableOnErrorReturn, "request.post(map, RequestBody.create(MediaType.parse(\"application/json\"), body))\n            .flatMap { responseBody ->\n                parseBody(responseBody)\n            }\n            .onErrorReturn {\n                val response = CommonResponse<Int>()\n                response.setStatus(0)\n                response\n            }");
        return observableOnErrorReturn;
    }

    public final Observable<c<Integer>> c(ResponseBody responseBody) {
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
                cVar.g(Integer.valueOf(jSONObjectOptJSONObject.optInt(NotificationCompat.CATEGORY_MESSAGE, 0)));
            }
            Observable<c<Integer>> observableJust = Observable.just(cVar);
            j.d(observableJust, "{\n            val response = CommonResponse<Int>()\n            val content = responseBody.string()\n            if (KGLog.DEBUG) KGLog.i(\"lzq-young\", content)\n            val jsonObject = JSONObject(content)\n            response.setStatus(jsonObject.optInt(\"status\"))\n            response.setErrorCode(jsonObject.optInt(\"error_code\"))\n            response.errorMsg = jsonObject.optString(\"error_msg\")\n            if (response.isSuccess) {\n                val data = jsonObject.optJSONObject(\"data\")\n                data?.run {\n                    val codeDesc = optInt(\"msg\", 0)\n                    response.data = codeDesc\n                }\n            }\n            Observable.just(response)\n        }");
            return observableJust;
        } catch (Exception unused) {
            Observable<c<Integer>> observableError = Observable.error(new e.c.a.g.a.f.k.g.b(null));
            j.d(observableError, "{\n            Observable.error(ChannelParseException(null))\n        }");
            return observableError;
        }
    }
}
