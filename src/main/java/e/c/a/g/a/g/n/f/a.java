package e.c.a.g.a.g.n.f;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.musicfees.mediastore.entity.HashOffset;
import e.c.a.g.a.d.r.p.a.g;
import e.c.a.g.a.r.g.c;
import e.c.a.g.a.s.c1;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.q0;
import e.c.a.g.a.s.r1;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: e.c.a.g.a.g.n.f.a$a, reason: collision with other inner class name */
    public interface InterfaceC0151a {
        @POST
        Call<e.c.a.g.a.g.n.f.b> getResPrivilege(@HeaderMap Map<String, String> map, @QueryMap Map<String, String> map2, @Body RequestBody requestBody);
    }

    public static class b extends Converter.Factory {

        /* JADX INFO: renamed from: e.c.a.g.a.g.n.f.a$b$a, reason: collision with other inner class name */
        public class C0152a implements Converter<ResponseBody, e.c.a.g.a.g.n.f.b> {
            public C0152a(b bVar) {
            }

            @Override // retrofit2.Converter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public e.c.a.g.a.g.n.f.b convert(ResponseBody responseBody) throws IOException {
                JSONObject jSONObject;
                String strString = responseBody.string();
                e.c.a.g.a.g.n.f.b bVar = new e.c.a.g.a.g.n.f.b();
                if (TextUtils.isEmpty(strString)) {
                    return null;
                }
                try {
                    jSONObject = new JSONObject(strString);
                } catch (Exception e2) {
                    g0.k(e2);
                }
                if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS) == 0) {
                    bVar.r(0);
                    bVar.m(jSONObject.optInt("error_code"));
                    return bVar;
                }
                bVar.r(1);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("data");
                if ((jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.length() : 0) <= 0) {
                    return null;
                }
                a.e(jSONArrayOptJSONArray.get(0).toString(), bVar);
                return bVar;
            }
        }

        public b(String str) {
        }

        @Override // retrofit2.Converter.Factory
        @Nullable
        public Converter<ResponseBody, e.c.a.g.a.g.n.f.b> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return new C0152a(this);
        }
    }

    public static void e(String str, e.c.a.g.a.g.n.f.b bVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                bVar.t(jSONObject.getInt(NotificationCompat.CATEGORY_STATUS));
            }
            if (jSONObject.has("ringtone_privilege")) {
                bVar.s(jSONObject.getInt("ringtone_privilege"));
            }
            if (jSONObject.has("old_cpy")) {
                bVar.p(jSONObject.getInt("old_cpy"));
            }
            if (jSONObject.has("trans_param")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("trans_param");
                if (jSONObject2.has("pay_block_tpl")) {
                    bVar.q(jSONObject2.optInt("pay_block_tpl", 0));
                }
                if (jSONObject2.has("display")) {
                    bVar.k(jSONObject2.optInt("display", 0));
                }
                if (jSONObject2.has("display_rate")) {
                    bVar.l(jSONObject2.optInt("display_rate", 0));
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("trans_param");
            if (jSONObjectOptJSONObject != null) {
                if (c1.a() && jSONObjectOptJSONObject.has("hash_offset")) {
                    bVar.n(HashOffset.jsonToHashOffset(jSONObjectOptJSONObject.getJSONObject("hash_offset")));
                }
                if (c1.a() && bVar.d() != null && bVar.f() == 1) {
                    bVar.o(true);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final Map<String, String> a(String str) {
        c cVarZ = c.z();
        cVarZ.q("userid");
        cVarZ.f(new String[0]);
        cVarZ.i(new String[0]);
        cVarZ.h(new String[0]);
        cVarZ.m(new String[0]);
        cVarZ.o(new String[0]);
        cVarZ.p(new String[0]);
        Map<String, String> mapE = cVarZ.E();
        mapE.put("signature", d(c.B(mapE) + str));
        return mapE;
    }

    public final Map<String, String> b() {
        c cVarZ = c.z();
        cVarZ.c("KG-RC", "0");
        cVarZ.c("KG-MODULE", "100998");
        return cVarZ.E();
    }

    @Nullable
    public e.c.a.g.a.g.n.f.b c(g gVar) {
        InterfaceC0151a interfaceC0151a = (InterfaceC0151a) new Retrofit.Builder().setModuleName("kKugouSetRing").addConverterFactory(new b(gVar.q())).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.S1, "http://openapi.kugou.com/ringtone/v1/get_res_privilege")).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setExcludeEndChar().build().create(InterfaceC0151a.class);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("behavior", "play");
            jSONObject.put("relate", 0);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(f(gVar));
            jSONObject.put("resource", jSONArray);
            jSONObject.put("area_code", e.c.a.g.a.r.b.c());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        try {
            Response<e.c.a.g.a.g.n.f.b> responseExecute = interfaceC0151a.getResPrivilege(b(), a(jSONObject.toString()), RequestBody.create(MediaType.parse("application/json"), jSONObject.toString())).execute();
            if (!responseExecute.isSuccessful() || responseExecute.body() == null) {
                return null;
            }
            return responseExecute.body();
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public final String d(String str) {
        return q0.g("4nx7WhCw4kZdasSQ" + str + "4nx7WhCw4kZdasSQ");
    }

    public JSONObject f(g gVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", gVar.d());
            if (!TextUtils.isEmpty(gVar.g())) {
                jSONObject.put("type", gVar.g());
            }
            if (!TextUtils.isEmpty(gVar.c())) {
                jSONObject.put("hash", gVar.c());
            }
            if (!TextUtils.isEmpty(gVar.e())) {
                jSONObject.put("name", gVar.e());
            }
            if (!TextUtils.isEmpty(gVar.b())) {
                jSONObject.put("album_id", gVar.b());
            }
            jSONObject.put("album_audio_id", gVar.a() + "");
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
