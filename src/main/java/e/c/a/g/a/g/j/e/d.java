package e.c.a.g.a.g.j.e;

import e.c.a.g.a.f.k.f;
import e.c.a.g.a.s.r1;
import f.z.d.j;
import java.io.IOException;
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
public final class d {

    public static final class a<T, R> implements Func1 {
        public static final a<T, R> a = new a<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.f.k.c<String> call(ResponseBody responseBody) throws IOException {
            return f.a.g(new JSONObject(responseBody.string()));
        }
    }

    public final Observable<e.c.a.g.a.f.k.c<String>> a(int i2, String str, int i3, String str2, String str3) {
        j.e(str, "content");
        j.e(str3, "reason");
        Retrofit retrofitBuild = new Retrofit.Builder().setModuleName("User").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.E3, "https://unifiedreport.kugou.com/v1/report")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reported_kugouid", e.c.a.g.a.r.b.o());
            jSONObject.put("report_kugouid", e.c.a.g.a.r.b.o());
            jSONObject.put("content", str);
            jSONObject.put("report_type", i3);
            jSONObject.put("report_class", 1);
            if (str2 != null) {
                jSONObject.put("type_content", str2);
            }
            jSONObject.put("report_sort", 1);
            jSONObject.put("report_reason", str3);
            jSONObject.put("token", e.c.a.g.a.r.b.n());
        } catch (Exception unused) {
        }
        String string = jSONObject.toString();
        j.d(string, "bodyObj.toString()");
        e.c.a.g.a.r.g.c cVarZ = e.c.a.g.a.r.g.c.z();
        cVarZ.b("source", Integer.valueOf(i2));
        cVarZ.b("kugouid", Long.valueOf(e.c.a.g.a.r.b.o()));
        cVarZ.j(string);
        Map<String, String> mapE = cVarZ.E();
        e.c.a.g.a.f.k.d dVar = (e.c.a.g.a.f.k.d) retrofitBuild.create(e.c.a.g.a.f.k.d.class);
        j.d(mapE, "params");
        Observable map = dVar.post(mapE, RequestBody.create(MediaType.parse("application/json"), string)).map(a.a);
        j.d(map, "request.create(ICommonService::class.java).post(\n            params,\n            RequestBody.create(MediaType.parse(\"application/json\"), bodyStr)\n        ).map {\n            val json = it.string()\n            ProtocolUtil.parseCommonResponse(JSONObject(json))\n        }");
        return map;
    }
}
