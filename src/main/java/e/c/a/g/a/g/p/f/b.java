package e.c.a.g.a.g.p.f;

import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kugou.android.watch.lite.user.entity.BusiVip;
import com.xtc.shareapi.share.shareobject.ShareCloudFileResource;
import e.c.a.g.a.g.p.d.i;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.r1;
import f.b0.f;
import f.z.d.j;
import java.util.LinkedHashMap;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final b a = new b();
    public static final long b = f.b(e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.r2, ShareCloudFileResource.HEIGHT), 60);

    public static final class a<T, R> implements Func1 {
        public static final a<T, R> a = new a<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Observable<? extends e.c.a.g.a.f.k.c<e.c.a.g.a.g.p.d.b>> call(ResponseBody responseBody) {
            e.c.a.g.a.f.k.f fVar = e.c.a.g.a.f.k.f.a;
            j.d(responseBody, "responseBody");
            return e.c.a.g.a.f.k.f.b(fVar, responseBody, e.c.a.g.a.g.p.d.b.class, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.p.f.b$b, reason: collision with other inner class name */
    public static final class C0161b<T, R> implements Func1 {
        public static final C0161b<T, R> a = new C0161b<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Observable<? extends e.c.a.g.a.f.k.c<i>> call(ResponseBody responseBody) {
            e.c.a.g.a.f.k.f fVar = e.c.a.g.a.f.k.f.a;
            j.d(responseBody, "responseBody");
            return e.c.a.g.a.f.k.f.b(fVar, responseBody, i.class, null, 4, null);
        }
    }

    public static final class c<T, R> implements Func1 {
        public static final c<T, R> a = new c<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Observable<? extends e.c.a.g.a.f.k.c<e.c.a.g.a.g.p.d.c>> call(ResponseBody responseBody) {
            e.c.a.g.a.f.k.f fVar = e.c.a.g.a.f.k.f.a;
            j.d(responseBody, "responseBody");
            return e.c.a.g.a.f.k.f.b(fVar, responseBody, e.c.a.g.a.g.p.d.c.class, null, 4, null);
        }
    }

    public static final class d<T, R> implements Func1 {
        public static final d<T, R> a = new d<>();

        public static final class a extends TypeToken<List<? extends e.c.a.g.a.g.p.d.d>> {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.f.k.c<List<e.c.a.g.a.g.p.d.d>> call(ResponseBody responseBody) {
            try {
                JSONObject jSONObject = new JSONObject(responseBody.string());
                e.c.a.g.a.f.k.c<List<e.c.a.g.a.g.p.d.d>> cVar = new e.c.a.g.a.f.k.c<>();
                cVar.m(jSONObject.optInt(NotificationCompat.CATEGORY_STATUS));
                cVar.k(jSONObject.optInt("error_code"));
                cVar.j(jSONObject.optString("error_msg"));
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.optJSONArray("lists");
                if (jSONArrayOptJSONArray == null) {
                    return cVar;
                }
                cVar.g(new Gson().fromJson(jSONArrayOptJSONArray.toString(), new a().getType()));
                return cVar;
            } catch (Exception unused) {
                return new e.c.a.g.a.f.k.c<>();
            }
        }
    }

    public final Observable<e.c.a.g.a.f.k.c<e.c.a.g.a.g.p.d.b>> a(String str, String str2, String str3, String str4) {
        j.e(str, "payType");
        j.e(str2, "platform");
        j.e(str3, "productId");
        j.e(str4, "sourceId");
        e.c.a.g.a.f.k.d dVar = (e.c.a.g.a.f.k.d) new Retrofit.Builder().setModuleName("VipProductProtocol").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.q2, "https://gateway.kugou.com/youth/v1/watch/create_order")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(e.c.a.g.a.f.k.d.class);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("kugouid", String.valueOf(e.c.a.g.a.r.b.o()));
        String strN = e.c.a.g.a.r.b.n();
        j.d(strN, "getToken()");
        linkedHashMap.put("token", strN);
        String str5 = e.c.c.b.c;
        j.d(str5, "channel");
        linkedHashMap.put("channel_id", str5);
        JSONObject jSONObject = new JSONObject();
        try {
            long jB = (l1.b() / ((long) 1000)) + b;
            jSONObject.put("pay_type", str);
            jSONObject.put("platform", str2);
            jSONObject.put("product_id", str3);
            jSONObject.put("busi_type", BusiVip.CODE);
            jSONObject.put("sourceid", str4);
            jSONObject.put("expire_time", jB);
            jSONObject.put("channel_id", e.c.c.b.c);
        } catch (Exception unused) {
        }
        String string = jSONObject.toString();
        j.d(string, "body.toString()");
        Observable observableFlatMap = dVar.post(e.c.a.g.a.f.k.f.a.e(linkedHashMap, string), RequestBody.create(MediaType.parse("application/json"), string)).flatMap(a.a);
        j.d(observableFlatMap, "viewInterface.post(\n            params,\n            RequestBody.create(MediaType.parse(\"application/json\"), bodyStr)\n        ).flatMap { responseBody ->\n            ProtocolUtil.bodyToResponse(responseBody, CommonOrderEntity::class.java)\n        }");
        return observableFlatMap;
    }

    public final Observable<e.c.a.g.a.f.k.c<i>> b(String str, String str2, String str3) {
        j.e(str, "payType");
        j.e(str2, "platform");
        j.e(str3, "productId");
        e.c.a.g.a.f.k.d dVar = (e.c.a.g.a.f.k.d) new Retrofit.Builder().setModuleName("VipProductProtocol").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.n2, "https://kugouvip.kugou.com/v1/create_order")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(e.c.a.g.a.f.k.d.class);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String strValueOf = String.valueOf(l1.f());
        linkedHashMap.put("srcappid", strValueOf);
        linkedHashMap.put("clientappid", strValueOf);
        linkedHashMap.put("kugouid", String.valueOf(e.c.a.g.a.r.b.o()));
        String strN = e.c.a.g.a.r.b.n();
        j.d(strN, "getToken()");
        linkedHashMap.put("clienttoken", strN);
        String str4 = e.c.c.b.c;
        j.d(str4, "channel");
        linkedHashMap.put("channel_id", str4);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("kugouid", String.valueOf(e.c.a.g.a.r.b.o()));
            jSONObject.put("clientappid", strValueOf);
            jSONObject.put("clienttoken", e.c.a.g.a.r.b.n());
            jSONObject.put("pay_type", str);
            jSONObject.put("platform", str2);
            jSONObject.put("product_id", str3);
            jSONObject.put("busi_type", BusiVip.CODE);
            jSONObject.put("channel_id", e.c.c.b.c);
        } catch (Exception unused) {
        }
        String string = jSONObject.toString();
        j.d(string, "body.toString()");
        Observable observableFlatMap = dVar.post(e.c.a.g.a.f.k.f.a.e(linkedHashMap, string), RequestBody.create(MediaType.parse("application/json"), string)).flatMap(C0161b.a);
        j.d(observableFlatMap, "viewInterface.post(\n            params,\n            RequestBody.create(MediaType.parse(\"application/json\"), bodyStr)\n        ).flatMap { responseBody ->\n            ProtocolUtil.bodyToResponse(responseBody, XtcOrderEntity::class.java)\n        }");
        return observableFlatMap;
    }

    public final long c() {
        return b;
    }

    public final Observable<e.c.a.g.a.f.k.c<e.c.a.g.a.g.p.d.c>> d(String str) {
        j.e(str, "orderNumber");
        e.c.a.g.a.f.k.d dVar = (e.c.a.g.a.f.k.d) new Retrofit.Builder().setModuleName("VipProductProtocol").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.o2, "https://kugouvip.kugou.com/v1/order_query")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(e.c.a.g.a.f.k.d.class);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("clientappid", String.valueOf(l1.f()));
        String strN = e.c.a.g.a.r.b.n();
        j.d(strN, "getToken()");
        linkedHashMap.put("clienttoken", strN);
        linkedHashMap.put("kugouid", String.valueOf(e.c.a.g.a.r.b.o()));
        linkedHashMap.put("order_no", str);
        linkedHashMap.put("busi_type", BusiVip.CODE);
        Observable observableFlatMap = dVar.get(e.c.a.g.a.f.k.f.a.e(linkedHashMap, "")).flatMap(c.a);
        j.d(observableFlatMap, "viewInterface.get(params)\n            .flatMap { responseBody ->\n                ProtocolUtil.bodyToResponse(responseBody, OrderStatusEntity::class.java)\n            }");
        return observableFlatMap;
    }

    public final Observable<e.c.a.g.a.f.k.c<List<e.c.a.g.a.g.p.d.d>>> e(String[] strArr) {
        j.e(strArr, "productList");
        e.c.a.g.a.f.k.d dVar = (e.c.a.g.a.f.k.d) new Retrofit.Builder().setModuleName("VipProductProtocol").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.m2, "https://kugouvip.kugou.com/v1/product_batch")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(e.c.a.g.a.f.k.d.class);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("kugouid", String.valueOf(e.c.a.g.a.r.b.o()));
            jSONObject.put("busi_type", BusiVip.CODE);
            jSONObject.put("clientappid", String.valueOf(l1.f()));
            jSONObject.put("clienttoken", e.c.a.g.a.r.b.n());
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            int length = strArr.length;
            while (i2 < length) {
                String str = strArr[i2];
                i2++;
                jSONArray.put(str);
            }
            jSONObject.put("product_id_list", jSONArray);
        } catch (Exception unused) {
        }
        String string = jSONObject.toString();
        j.d(string, "body.toString()");
        Observable map = dVar.post(e.c.a.g.a.f.k.f.a.e(linkedHashMap, string), RequestBody.create(MediaType.parse("application/json"), string)).map(d.a);
        j.d(map, "viewInterface.post(\n            params,\n            RequestBody.create(MediaType.parse(\"application/json\"), bodyStr)\n        ).map { responseBody ->\n            try {\n                val jsonObj = JSONObject(responseBody.string())\n                val response = CommonResponse<List<ProductEntity>?>()\n                response.setStatus(jsonObj.optInt(\"status\"))\n                response.setErrorCode(jsonObj.optInt(\"error_code\"))\n                response.setError(jsonObj.optString(\"error_msg\"))\n\n                val dataObj = jsonObj.optJSONObject(\"data\")\n                val listObj = dataObj?.optJSONArray(\"lists\")\n                if (listObj != null) {\n                    response.data = Gson().fromJson(\n                        listObj.toString(),\n                        object : TypeToken<List<ProductEntity>?>() {}.type\n                    )\n                }\n                response\n            } catch (e: Exception) {\n                CommonResponse<List<ProductEntity>?>()\n            }\n        }");
        return map;
    }
}
