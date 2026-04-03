package e.c.a.g.a.f.c;

import e.c.a.g.a.f.k.f;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.r1;
import e.c.a.g.a.s.t;
import f.z.d.j;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    public static final class a<T, R> implements Func1 {
        public static final a<T, R> a = new a<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Observable<? extends e.c.a.g.a.f.k.c<List<b>>> call(ResponseBody responseBody) {
            try {
                JSONObject jSONObject = new JSONObject(responseBody.string());
                e.c.a.g.a.f.k.c cVarG = f.a.g(jSONObject);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.optJSONArray("ads");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    cVarG.g(t.b(jSONArrayOptJSONArray.toString(), b.class));
                }
                return Observable.just(cVarG);
            } catch (Exception unused) {
                return Observable.error(new Exception("parse gson fail"));
            }
        }
    }

    public final Observable<e.c.a.g.a.f.k.c<List<b>>> a() {
        Retrofit retrofitBuild = new Retrofit.Builder().setModuleName("ComActivityProtocol").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.c3, "https://gateway.kugou.com/youth/v1/watch/get_ad_popup")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build();
        e.c.a.g.a.r.g.c cVarZ = e.c.a.g.a.r.g.c.z();
        if (e.c.a.g.a.r.b.F()) {
            cVarZ.q("userid");
            cVarZ.p(new String[0]);
        }
        cVarZ.c("source", l1.j());
        cVarZ.b("vip_status", Integer.valueOf(b()));
        cVarZ.j("");
        Map<String, String> mapE = cVarZ.E();
        e.c.a.g.a.f.k.d dVar = (e.c.a.g.a.f.k.d) retrofitBuild.create(e.c.a.g.a.f.k.d.class);
        j.d(mapE, "params");
        Observable observableFlatMap = dVar.get(mapE).flatMap(a.a);
        j.d(observableFlatMap, "request.create(ICommonService::class.java)\n            .get(params)\n            .flatMap { responseBody ->\n                return@flatMap try {\n                    val jsonObject = JSONObject(responseBody.string())\n                    val response =\n                        ProtocolUtil.parseCommonResponse<List<ComActivityEntity>?>(jsonObject)\n                    val ads = jsonObject.optJSONObject(\"data\")?.optJSONArray(\"ads\")\n                    if (ads != null && ads.length() > 0) {\n                        response.data =\n                            GsonUtil.jsonToObjList(ads.toString(), ComActivityEntity::class.java)\n                    }\n                    Observable.just(response)\n                } catch (e: Exception) {\n                    Observable.error(Exception(\"parse gson fail\"))\n                }\n            }");
        return observableFlatMap;
    }

    public final int b() {
        if (e.c.a.g.a.r.b.K()) {
            return 2;
        }
        return e.c.a.g.a.r.b.O() ? 1 : 0;
    }
}
