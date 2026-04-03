package e.c.a.g.a.d.d;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.common.startAppAPM.task.Http2HttpsHelper;
import e.c.a.g.a.f.k.c;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.r1;
import e.c.a.g.a.s.t;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import okhttp3.ResponseBody;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;
import rx.Observable;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e.c.a.g.a.d.d.a$a, reason: collision with other inner class name */
    public static class C0045a extends Converter.Factory {

        /* JADX INFO: renamed from: e.c.a.g.a.d.d.a$a$a, reason: collision with other inner class name */
        public class C0046a implements Converter<ResponseBody, c<e.c.a.g.a.d.d.b>> {
            public C0046a(C0045a c0045a) {
            }

            @Override // retrofit2.Converter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c<e.c.a.g.a.d.d.b> convert(ResponseBody responseBody) throws IOException {
                c<e.c.a.g.a.d.d.b> cVar = new c<>();
                String strString = responseBody.string();
                if (TextUtils.isEmpty(strString)) {
                    return cVar;
                }
                try {
                    JSONObject jSONObject = new JSONObject(strString);
                    cVar.m(jSONObject.optInt(NotificationCompat.CATEGORY_STATUS));
                    cVar.i(jSONObject.optInt("error_code"));
                    cVar.l(jSONObject.optString("errmsg"));
                    if (cVar.f()) {
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("data");
                        JSONObject jSONObjectOptJSONObject = (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) ? null : jSONArrayOptJSONArray.optJSONObject(0);
                        if (jSONObjectOptJSONObject != null) {
                            cVar.g((e.c.a.g.a.d.d.b) t.a(jSONObjectOptJSONObject.toString(), e.c.a.g.a.d.d.b.class));
                        }
                    }
                } catch (Exception e2) {
                    g0.k(e2);
                }
                return cVar;
            }
        }

        @Override // retrofit2.Converter.Factory
        @Nullable
        public Converter<ResponseBody, c<e.c.a.g.a.d.d.b>> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return new C0046a(this);
        }
    }

    public interface b {
        @GET
        Observable<c<e.c.a.g.a.d.d.b>> getAudioClimax(@HeaderMap Map<String, String> map, @QueryMap Map<String, String> map2);
    }

    public static Observable<c<e.c.a.g.a.d.d.b>> a(long j, String str) {
        Retrofit retrofitBuild = new Retrofit.Builder().setModuleName("RingtoneRequestDetail").addConverterFactory(new C0045a()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.T1, Http2HttpsHelper.INSTANCE.getAudio_climax_url())).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setExcludeEndChar().build();
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("audio_id", j);
            jSONObject.put("hash", str);
            jSONArray.put(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        e.c.a.g.a.r.g.c cVarZ = e.c.a.g.a.r.g.c.z();
        cVarZ.q("userid");
        cVarZ.f(new String[0]);
        cVarZ.i(new String[0]);
        cVarZ.h(new String[0]);
        cVarZ.m(new String[0]);
        cVarZ.o(new String[0]);
        cVarZ.p(new String[0]);
        cVarZ.c("data", jSONArray.toString());
        Map<String, String> mapE = cVarZ.E();
        mapE.put("signature", r1.d(r1.g(mapE)));
        HashMap map = new HashMap();
        map.put("KG-TID", String.valueOf(HttpStatus.SC_BAD_REQUEST));
        return ((b) retrofitBuild.create(b.class)).getAudioClimax(map, mapE);
    }
}
