package e.c.a.g.a.g.e;

import androidx.core.app.NotificationCompat;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.r1;
import f.z.d.j;
import java.io.IOException;
import java.util.LinkedHashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b a = new b();

    public static final class a<T, R> implements Func1 {
        public static final a<T, R> a = new a<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.f.k.c<String> call(ResponseBody responseBody) {
            try {
                JSONObject jSONObject = new JSONObject(responseBody.string());
                e.c.a.g.a.f.k.c<String> cVar = new e.c.a.g.a.f.k.c<>();
                cVar.m(jSONObject.optInt(NotificationCompat.CATEGORY_STATUS));
                cVar.k(jSONObject.optInt("error_code"));
                cVar.j(jSONObject.optString("error_msg"));
                cVar.g(jSONObject.optString("data"));
                return cVar;
            } catch (Exception unused) {
                return new e.c.a.g.a.f.k.c<>();
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.e.b$b, reason: collision with other inner class name */
    public static final class C0116b<T, R> implements Func1 {
        public static final C0116b<T, R> a = new C0116b<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.f.k.c<String> call(ResponseBody responseBody) {
            try {
                JSONObject jSONObject = new JSONObject(responseBody.string());
                e.c.a.g.a.f.k.c<String> cVar = new e.c.a.g.a.f.k.c<>();
                cVar.m(jSONObject.optInt(NotificationCompat.CATEGORY_STATUS));
                cVar.k(jSONObject.optInt("error_code"));
                cVar.j(jSONObject.optString("error_msg"));
                cVar.g(jSONObject.optString("data"));
                return cVar;
            } catch (Exception unused) {
                return new e.c.a.g.a.f.k.c<>();
            }
        }
    }

    public static final class c<T, R> implements Func1 {
        public static final c<T, R> a = new c<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.f.k.c<String> call(ResponseBody responseBody) {
            try {
                JSONObject jSONObject = new JSONObject(responseBody.string());
                e.c.a.g.a.f.k.c<String> cVar = new e.c.a.g.a.f.k.c<>();
                cVar.m(jSONObject.optInt(NotificationCompat.CATEGORY_STATUS));
                cVar.k(jSONObject.optInt("error_code"));
                cVar.j(jSONObject.optString("error_msg"));
                cVar.g(jSONObject.optString("data"));
                return cVar;
            } catch (Exception unused) {
                return new e.c.a.g.a.f.k.c<>();
            }
        }
    }

    public final e.c.a.g.a.g.e.c a() {
        try {
            Retrofit retrofitBuild = new Retrofit.Builder().setModuleName("FamilyControllerProtocol").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.h3, "https://gateway.kugou.com/youth/v1/watch/get_bind_status")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String strN = l1.n(e.c.c.o.f.a());
            j.d(strN, "getMid(KGCommonApplication.getContext())");
            linkedHashMap.put("device_id", strN);
            String strJ = l1.j();
            j.d(strJ, "getChannel()");
            linkedHashMap.put("channel_id", strJ);
            ResponseBody responseBodyBody = ((e.c.a.g.a.f.k.d) retrofitBuild.create(e.c.a.g.a.f.k.d.class)).call(e.c.a.g.a.f.k.f.a.e(linkedHashMap, "")).execute().body();
            if (responseBodyBody == null) {
                return null;
            }
            e.c.a.g.a.g.e.c cVar = new e.c.a.g.a.g.e.c();
            String strString = responseBodyBody.string();
            if (g0.a) {
                g0.b("young_xcl", j.l("qr_code_status = ", strString));
            }
            JSONObject jSONObject = new JSONObject(strString);
            cVar.a = jSONObject.optInt("error_code");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null) {
                cVar.b = true;
                cVar.c = jSONObjectOptJSONObject.optInt("bind_status");
            } else {
                cVar.b = false;
            }
            return cVar;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (JSONException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public final Observable<e.c.a.g.a.f.k.c<String>> b() {
        e.c.a.g.a.f.k.d dVar = (e.c.a.g.a.f.k.d) new Retrofit.Builder().setModuleName("FamilyControllerProtocol").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.k3, "https://gateway.kugou.com/youth/v1/watch/get_black_song_list")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(e.c.a.g.a.f.k.d.class);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String strN = l1.n(e.c.c.o.f.a());
        j.d(strN, "getMid(KGCommonApplication.getContext())");
        linkedHashMap.put("device_id", strN);
        String strJ = l1.j();
        j.d(strJ, "getChannel()");
        linkedHashMap.put("channel_id", strJ);
        Observable map = dVar.get(e.c.a.g.a.f.k.f.a.e(linkedHashMap, "")).map(a.a);
        j.d(map, "viewInterface.get(\n            params\n        ).map { responseBody ->\n            try {\n                val jsonObj = JSONObject(responseBody.string())\n                val response = CommonResponse<String?>()\n                response.setStatus(jsonObj.optInt(\"status\"))\n                response.setErrorCode(jsonObj.optInt(\"error_code\"))\n                response.setError(jsonObj.optString(\"error_msg\"))\n                response.data = jsonObj.optString(\"data\")\n                response\n            } catch (e: Exception) {\n                CommonResponse<String?>()\n            }\n        }");
        return map;
    }

    public final Observable<e.c.a.g.a.f.k.c<String>> c(String str) {
        e.c.a.g.a.f.k.d dVar = (e.c.a.g.a.f.k.d) new Retrofit.Builder().setModuleName("FamilyControllerProtocol").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.m3, "https://gateway.kugou.com/youth/v1/watch/set_age")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(e.c.a.g.a.f.k.d.class);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", l1.n(e.c.c.o.f.a()));
            jSONObject.put("age", str);
            jSONObject.put("channel_id", l1.j());
        } catch (Exception unused) {
        }
        String string = jSONObject.toString();
        j.d(string, "body.toString()");
        Observable map = dVar.post(e.c.a.g.a.f.k.f.a.e(linkedHashMap, string), RequestBody.create(MediaType.parse("application/json"), string)).map(C0116b.a);
        j.d(map, "viewInterface.post(\n            params,\n            RequestBody.create(MediaType.parse(\"application/json\"), bodyStr)\n        ).map { responseBody ->\n            try {\n                val jsonObj = JSONObject(responseBody.string())\n                val response = CommonResponse<String?>()\n                response.setStatus(jsonObj.optInt(\"status\"))\n                response.setErrorCode(jsonObj.optInt(\"error_code\"))\n                response.setError(jsonObj.optString(\"error_msg\"))\n                response.data = jsonObj.optString(\"data\")\n                response\n            } catch (e: Exception) {\n                CommonResponse<String?>()\n            }\n        }");
        return map;
    }

    public final Observable<e.c.a.g.a.f.k.c<String>> d(int i2) {
        e.c.a.g.a.f.k.d dVar = (e.c.a.g.a.f.k.d) new Retrofit.Builder().setModuleName("FamilyControllerProtocol").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.n3, "https://gateway.kugou.com/youth/v1/watch/bind_watch")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(e.c.a.g.a.f.k.d.class);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", l1.n(e.c.c.o.f.a()));
            jSONObject.put("bind_status", i2);
            jSONObject.put("channel_id", l1.j());
        } catch (Exception unused) {
        }
        String string = jSONObject.toString();
        j.d(string, "body.toString()");
        Observable map = dVar.post(e.c.a.g.a.f.k.f.a.e(linkedHashMap, string), RequestBody.create(MediaType.parse("application/json"), string)).map(c.a);
        j.d(map, "viewInterface.post(\n            params,\n            RequestBody.create(MediaType.parse(\"application/json\"), bodyStr)\n        ).map { responseBody ->\n            try {\n                val jsonObj = JSONObject(responseBody.string())\n                val response = CommonResponse<String?>()\n                response.setStatus(jsonObj.optInt(\"status\"))\n                response.setErrorCode(jsonObj.optInt(\"error_code\"))\n                response.setError(jsonObj.optString(\"error_msg\"))\n                response.data = jsonObj.optString(\"data\")\n                response\n            } catch (e: Exception) {\n                CommonResponse<String?>()\n            }\n        }");
        return map;
    }
}
