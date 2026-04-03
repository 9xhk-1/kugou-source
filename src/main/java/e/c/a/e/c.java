package e.c.a.e;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import e.c.a.g.a.f.k.f;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.r1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static Map<String, String> a = new HashMap();

    public class a implements Action1<e.c.a.g.a.f.k.c<JSONObject>> {
        public final /* synthetic */ List a;

        public a(List list) {
            this.a = list;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(e.c.a.g.a.f.k.c<JSONObject> cVar) {
            JSONObject jSONObjectA = cVar.a();
            for (e.c.a.e.b bVar : this.a) {
                if (jSONObjectA == null || !jSONObjectA.has(bVar.getSource())) {
                    try {
                        bVar.handleConfig("SharedPreference", bVar.readFromLocal());
                    } catch (Exception e2) {
                        if (g0.a) {
                            e2.printStackTrace();
                        }
                    }
                } else {
                    String strOptString = jSONObjectA.optString(bVar.getSource());
                    bVar.save2Local(strOptString);
                    try {
                        bVar.handleConfig("Net", strOptString);
                    } catch (Exception e3) {
                        if (g0.a) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public class b implements Action1<Throwable> {
        public final /* synthetic */ List a;

        public b(List list) {
            this.a = list;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            for (e.c.a.e.b bVar : this.a) {
                try {
                    bVar.handleConfig("SharedPreference", bVar.readFromLocal());
                } catch (Exception e2) {
                    if (g0.a) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.e.c$c, reason: collision with other inner class name */
    public interface InterfaceC0039c {
        @GET
        Observable<ResponseBody> get(@QueryMap Map<String, String> map);
    }

    public static Observable<e.c.a.g.a.f.k.c<JSONObject>> a(String str) {
        InterfaceC0039c interfaceC0039c = (InterfaceC0039c) new Retrofit.Builder().setModuleName("TME_AB").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.N, "https://gateway.kugou.com/youth/v1/ab/tmeab")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(InterfaceC0039c.class);
        HashMap<String, String> map = new HashMap<>(12);
        map.put("platform", "android-watch");
        map.put("ab_source", str);
        f.a.c(map, "");
        return interfaceC0039c.get(map).flatMap(new Func1() { // from class: e.c.a.e.a
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return Observable.just(c.d((ResponseBody) obj));
            }
        });
    }

    public static void b(List<e.c.a.e.b> list) {
        StringBuilder sb = new StringBuilder();
        for (e.c.a.e.b bVar : list) {
            a.put(bVar.getSource(), bVar.getSPKey());
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(bVar.getSource());
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        a(string).subscribeOn(Schedulers.io()).subscribe(new a(list), new b(list));
    }

    public static e.c.a.g.a.f.k.c<JSONObject> d(ResponseBody responseBody) {
        e.c.a.g.a.f.k.c<JSONObject> cVar = new e.c.a.g.a.f.k.c<>();
        try {
            JSONObject jSONObject = new JSONObject(responseBody.string());
            int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
            int iOptInt2 = jSONObject.optInt("errcode");
            String strOptString = jSONObject.optString("error");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            cVar.m(iOptInt);
            cVar.i(iOptInt2);
            cVar.j(strOptString);
            if (iOptInt == 1 && jSONObjectOptJSONObject != null) {
                cVar.g(jSONObjectOptJSONObject);
            }
        } catch (Exception unused) {
        }
        return cVar;
    }
}
