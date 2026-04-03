package e.c.a.g.a.g.h.l;

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

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final b a = new b();

    public static final class a<T, R> implements Func1 {
        public static final a<T, R> a = new a<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Observable<? extends e.c.a.g.a.f.k.c<e.c.a.g.a.g.h.l.a>> call(ResponseBody responseBody) {
            b bVar = b.a;
            j.d(responseBody, "responseBody");
            return bVar.d(responseBody);
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.h.l.b$b, reason: collision with other inner class name */
    public static final class C0130b<T, R> implements Func1 {
        public static final C0130b<T, R> a = new C0130b<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.f.k.c<e.c.a.g.a.g.h.l.a> call(Throwable th) {
            e.c.a.g.a.f.k.c<e.c.a.g.a.g.h.l.a> cVar = new e.c.a.g.a.f.k.c<>();
            cVar.m(0);
            return cVar;
        }
    }

    public final Observable<e.c.a.g.a.f.k.c<e.c.a.g.a.g.h.l.a>> b() {
        if (!e.c.a.g.a.f.e.c.a.a().getConfigAsBoolean(e.c.a.g.a.f.e.b.Z0, true)) {
            e.c.a.g.a.f.k.c cVar = new e.c.a.g.a.f.k.c();
            cVar.m(0);
            Observable<e.c.a.g.a.f.k.c<e.c.a.g.a.g.h.l.a>> observableJust = Observable.just(cVar);
            j.d(observableJust, "just(response)");
            return observableJust;
        }
        e.c.a.g.a.f.k.d dVar = (e.c.a.g.a.f.k.d) new Retrofit.Builder().setModuleName("GetAccountStatProtocol").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.Y0, "https://gateway.kugou.com/youth/v4/user/get_account_stat_watch")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(e.c.a.g.a.f.k.d.class);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String strJ = l1.j();
        j.d(strJ, "getChannel()");
        linkedHashMap.put("source", strJ);
        e.c.a.g.a.f.k.f.a.e(linkedHashMap, "");
        Observable<e.c.a.g.a.f.k.c<e.c.a.g.a.g.h.l.a>> observableOnErrorReturn = dVar.get(linkedHashMap).flatMap(a.a).onErrorReturn(C0130b.a);
        j.d(observableOnErrorReturn, "viewInterface.get(map)\n            .flatMap { responseBody ->\n                parseBody(responseBody)\n            }\n            .onErrorReturn {\n                val response = CommonResponse<ActivityUserType>()\n                response.setStatus(0)\n                response\n            }");
        return observableOnErrorReturn;
    }

    public final String c(Integer num) {
        return (num != null && 1 == num.intValue()) ? "1" : (num != null && num.intValue() == 0) ? "2" : "";
    }

    public final Observable<e.c.a.g.a.f.k.c<e.c.a.g.a.g.h.l.a>> d(ResponseBody responseBody) {
        JSONObject jSONObjectOptJSONObject;
        try {
            e.c.a.g.a.f.k.c cVar = new e.c.a.g.a.f.k.c();
            JSONObject jSONObject = new JSONObject(responseBody.string());
            cVar.m(jSONObject.optInt(NotificationCompat.CATEGORY_STATUS));
            cVar.k(jSONObject.optInt("error_code"));
            cVar.l(jSONObject.optString("error_msg"));
            if (cVar.f() && (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) != null) {
                cVar.g(new e.c.a.g.a.g.h.l.a(jSONObjectOptJSONObject.optInt("is_send_vip", 0), jSONObjectOptJSONObject.optInt("account_stat", 0), jSONObjectOptJSONObject.optInt("type", 0), jSONObjectOptJSONObject.optInt("vip_months", 1), jSONObjectOptJSONObject.optString("vip_des", "")));
            }
            Observable<e.c.a.g.a.f.k.c<e.c.a.g.a.g.h.l.a>> observableJust = Observable.just(cVar);
            j.d(observableJust, "{\n            val response = CommonResponse<ActivityUserType>()\n            val content = responseBody.string()\n            val jsonObject = JSONObject(content)\n            response.setStatus(jsonObject.optInt(\"status\"))\n            response.setErrorCode(jsonObject.optInt(\"error_code\"))\n            response.errorMsg = jsonObject.optString(\"error_msg\")\n            if (response.isSuccess) {\n                val data = jsonObject.optJSONObject(\"data\")\n                data?.run {\n                    val isNew = this.optInt(\"account_stat\", 0)\n                    val isSendVip = optInt(\"is_send_vip\", 0)\n                    val vipSource = optInt(\"type\", 0)\n                    val vipMonths = optInt(\"vip_months\", 1)\n                    val vipDesc = optString(\"vip_des\", \"\")\n                    response.data =\n                        ActivityUserType(isSendVip, isNew, vipSource, vipMonths, vipDesc)\n                }\n            }\n            Observable.just(response)\n        }");
            return observableJust;
        } catch (Exception unused) {
            Observable<e.c.a.g.a.f.k.c<e.c.a.g.a.g.h.l.a>> observableError = Observable.error(new e.c.a.g.a.f.k.g.b(null));
            j.d(observableError, "{\n            Observable.error(ChannelParseException(null))\n        }");
            return observableError;
        }
    }
}
