package e.c.a.g.a.o;

import com.kugou.android.watch.lite.recommend.entity.SheetMusicListResp;
import com.kugou.common.config.ConfigKey;
import e.c.a.g.a.o.c.a;
import e.c.a.g.a.r.g.c;
import e.c.a.g.a.s.h;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.q0;
import e.c.a.g.a.s.r1;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    public class a implements Func1<e.c.a.g.a.o.c.b, Observable<a.b>> {
        public final /* synthetic */ int a;

        public a(int i2) {
            this.a = i2;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Observable<a.b> call(e.c.a.g.a.o.c.b bVar) {
            e.c.a.g.a.o.c.a aVar;
            if (bVar == null || bVar.a != 1 || (aVar = bVar.c) == null) {
                return Observable.error(new h("请求失败"));
            }
            List<a.b> list = aVar.c;
            int iE = l0.e(list);
            for (int i2 = 0; i2 < iE; i2++) {
                a.b bVar2 = list.get(i2);
                if (bVar2 != null && bVar2.a == this.a) {
                    return Observable.just(bVar2);
                }
            }
            return Observable.just(null);
        }
    }

    public static Map<String, String> a(String str) {
        if (str == null) {
            str = "";
        }
        c cVarZ = c.z();
        cVarZ.q("userid");
        cVarZ.p(new String[0]);
        cVarZ.f(new String[0]);
        cVarZ.o(new String[0]);
        cVarZ.m(new String[0]);
        cVarZ.i(new String[0]);
        cVarZ.h(new String[0]);
        Map<String, String> mapE = cVarZ.E();
        mapE.put("signature", q0.g("deAl9p7QuuB4Da2r" + c.B(mapE) + str + "deAl9p7QuuB4Da2r"));
        return mapE;
    }

    public static Observable<a.b> b(int i2, int i3, int i4) {
        return e(i2, i3).flatMap(new a(i4));
    }

    public static Observable<SheetMusicListResp> c(String str, int i2, int i3) {
        e.c.a.g.a.o.a aVar = (e.c.a.g.a.o.a) d("getMusicSheetList", e.c.a.g.a.f.e.b.O1, "https://openapi.kugou.com/v1/collection/audio").create(e.c.a.g.a.o.a.class);
        c cVarZ = c.z();
        cVarZ.c("KG-RC", "0");
        cVarZ.c("KG-MODULE", "100999");
        Map<String, String> mapE = cVarZ.E();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("global_collection_id", str);
            jSONObject.put("field_type", "simplified");
            jSONObject.put("page", String.valueOf(i2));
            jSONObject.put("pagesize", String.valueOf(i3));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String string = jSONObject.toString();
        return aVar.queryMusicSheetList(mapE, a(string), RequestBody.create(MediaType.parse("application/json"), string));
    }

    public static Retrofit d(String str, ConfigKey configKey, String str2) {
        return new Retrofit.Builder().setModuleName(str).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(configKey, str2)).setExcludeEndChar().build();
    }

    public static Observable<e.c.a.g.a.o.c.b> e(int i2, int i3) {
        Retrofit retrofitD = d("yuekucategory", e.c.a.g.a.f.e.b.N1, "https://yuekucategory.kugou.com/v1/zone/home");
        c cVarZ = c.z();
        cVarZ.f(new String[0]);
        cVarZ.i(new String[0]);
        cVarZ.h(new String[0]);
        cVarZ.o(new String[0]);
        cVarZ.m(new String[0]);
        cVarZ.b("id", Integer.valueOf(i2));
        if (i3 != -1) {
            cVarZ.b("category_id", Integer.valueOf(i3));
        }
        cVarZ.d();
        return ((e.c.a.g.a.o.a) retrofitD.create(e.c.a.g.a.o.a.class)).getZoneHome(cVarZ.E());
    }
}
