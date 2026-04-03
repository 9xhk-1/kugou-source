package e.c.a.g.a.g.e;

import androidx.core.app.NotificationCompat;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.r1;
import f.z.d.j;
import java.util.LinkedHashMap;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a a = new a();

    /* JADX INFO: renamed from: e.c.a.g.a.g.e.a$a, reason: collision with other inner class name */
    public static final class C0115a<T, R> implements Func1 {
        public static final C0115a<T, R> a = new C0115a<>();

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

    public final Observable<e.c.a.g.a.f.k.c<String>> a() {
        e.c.a.g.a.f.k.d dVar = (e.c.a.g.a.f.k.d) new Retrofit.Builder().setModuleName("AvatarListProtocol").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.U1, "https://gateway.kugou.com/youth/v1/watch/get_official_img")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(e.c.a.g.a.f.k.d.class);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String strN = l1.n(e.c.c.o.f.a());
        j.d(strN, "getMid(KGCommonApplication.getContext())");
        linkedHashMap.put("device_id", strN);
        String strJ = l1.j();
        j.d(strJ, "getChannel()");
        linkedHashMap.put("channel_id", strJ);
        Observable map = dVar.get(e.c.a.g.a.f.k.f.a.e(linkedHashMap, "")).map(C0115a.a);
        j.d(map, "viewInterface.get(\n            params\n        ).map { responseBody ->\n            try {\n                val jsonObj = JSONObject(responseBody.string())\n                val response = CommonResponse<String?>()\n                response.setStatus(jsonObj.optInt(\"status\"))\n                response.setErrorCode(jsonObj.optInt(\"error_code\"))\n                response.setError(jsonObj.optString(\"error_msg\"))\n                response.data = jsonObj.optString(\"data\")\n                response\n            } catch (e: Exception) {\n                CommonResponse<String?>()\n            }\n        }");
        return map;
    }
}
