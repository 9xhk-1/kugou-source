package e.c.a.g.a.i;

import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.historycloud.HistoryRecord;
import e.c.a.g.a.f.k.f;
import e.c.a.g.a.g.p.d.d;
import e.c.a.g.a.s.r1;
import f.z.d.j;
import java.util.Iterator;
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
public final class c {
    public static final c a = new c();

    public static final class a<T, R> implements Func1 {
        public static final a<T, R> a = new a<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.f.k.c<List<d>> call(ResponseBody responseBody) {
            try {
                JSONObject jSONObject = new JSONObject(responseBody.string());
                e.c.a.g.a.f.k.c<List<d>> cVar = new e.c.a.g.a.f.k.c<>();
                cVar.m(jSONObject.optInt(NotificationCompat.CATEGORY_STATUS));
                cVar.k(jSONObject.optInt("error_code"));
                cVar.j(jSONObject.optString("error_msg"));
                return cVar;
            } catch (Exception unused) {
                return new e.c.a.g.a.f.k.c<>();
            }
        }
    }

    public final Observable<e.c.a.g.a.f.k.c<List<d>>> a(List<HistoryRecord> list) {
        e.c.a.g.a.f.k.d dVar = (e.c.a.g.a.f.k.d) new Retrofit.Builder().setModuleName("UploadSongsProtocol").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.e3, "https://gateway.kugou.com/playhistory/youth/v1/upload_songs")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(e.c.a.g.a.f.k.d.class);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(((HistoryRecord) it.next()).mapUploadSong());
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("songs", jSONArray);
            jSONObject.put("userid", e.c.a.g.a.r.b.o());
            jSONObject.put("token", e.c.a.g.a.r.b.n());
            jSONObject.put("type", e.c.a.g.a.f.h.a.a.a.h());
        } catch (Exception unused) {
        }
        String string = jSONObject.toString();
        j.d(string, "body.toString()");
        Observable map = dVar.post(f.a.e(linkedHashMap, string), RequestBody.create(MediaType.parse("application/json"), string)).map(a.a);
        j.d(map, "viewInterface.post(\n            params,\n            RequestBody.create(MediaType.parse(\"application/json\"), bodyStr)\n        ).map { responseBody ->\n            try {\n                val jsonObj = JSONObject(responseBody.string())\n                val response = CommonResponse<List<ProductEntity>?>()\n                response.setStatus(jsonObj.optInt(\"status\"))\n                response.setErrorCode(jsonObj.optInt(\"error_code\"))\n                response.setError(jsonObj.optString(\"error_msg\"))\n                response\n            } catch (e: Exception) {\n                CommonResponse<List<ProductEntity>?>()\n            }\n        }");
        return map;
    }
}
