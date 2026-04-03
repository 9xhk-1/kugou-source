package e.c.a.g.a.g.h.l;

import androidx.core.app.NotificationCompat;
import e.c.a.g.a.s.g0;
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
public final class f {
    public static final f a = new f();

    public static final class a<T, R> implements Func1 {
        public static final a<T, R> a = new a<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Observable<? extends e.c.a.g.a.f.k.c<Object>> call(ResponseBody responseBody) {
            f fVar = f.a;
            j.d(responseBody, "responseBody");
            return fVar.b(responseBody);
        }
    }

    public final Observable<e.c.a.g.a.f.k.c<Object>> b(ResponseBody responseBody) {
        try {
            e.c.a.g.a.f.k.c cVar = new e.c.a.g.a.f.k.c();
            String strString = responseBody.string();
            if (g0.a) {
                g0.e("lzq-young", strString);
            }
            JSONObject jSONObject = new JSONObject(strString);
            cVar.m(jSONObject.getInt(NotificationCompat.CATEGORY_STATUS));
            cVar.i(jSONObject.getInt("error_code"));
            cVar.l(jSONObject.getString("error_msg"));
            Observable<e.c.a.g.a.f.k.c<Object>> observableJust = Observable.just(cVar);
            j.d(observableJust, "{\n            val response = CommonResponse<Any>()\n            val content = responseBody.string()\n            if (KGLog.DEBUG) KGLog.i(\"lzq-young\", content)\n            val jsonObject = JSONObject(content)\n            response.setStatus(jsonObject.getInt(\"status\"))\n            response.errcode = jsonObject.getInt(\"error_code\")\n            response.errorMsg = jsonObject.getString(\"error_msg\")\n            Observable.just(response)\n        }");
            return observableJust;
        } catch (Exception unused) {
            Observable<e.c.a.g.a.f.k.c<Object>> observableError = Observable.error(new e.c.a.g.a.f.k.g.b(null));
            j.d(observableError, "{\n            Observable.error(ChannelParseException(null))\n        }");
            return observableError;
        }
    }

    public final Observable<e.c.a.g.a.f.k.c<Object>> c() {
        e.c.a.g.a.f.k.d dVar = (e.c.a.g.a.f.k.d) new Retrofit.Builder().setModuleName("ReportMidToServerProtocol").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.a1, "https://youth.kugou.com/v2/report/user_visit")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(e.c.a.g.a.f.k.d.class);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        e.c.a.g.a.f.k.f.a.e(linkedHashMap, "");
        Observable observableFlatMap = dVar.post(linkedHashMap).flatMap(a.a);
        j.d(observableFlatMap, "viewInterface.post(map)\n            .flatMap { responseBody ->\n                parseBody(responseBody)\n            }");
        return observableFlatMap;
    }
}
