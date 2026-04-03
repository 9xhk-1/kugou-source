package e.c.a.g.a.d.x.p;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.common.startAppAPM.task.Http2HttpsHelper;
import com.xtc.payapi.contact.BaseResponse;
import e.c.a.g.a.f.k.d;
import e.c.a.g.a.s.a0;
import e.c.a.g.a.s.r1;
import f.z.d.j;
import java.io.IOException;
import java.util.Map;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final c a = new c();

    public final e.c.a.g.a.f.k.c<String> a(ResponseBody responseBody) {
        JSONArray jSONArrayOptJSONArray;
        int length;
        int length2;
        e.c.a.g.a.f.k.c<String> cVar = new e.c.a.g.a.f.k.c<>();
        if (responseBody == null) {
            return cVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(responseBody.string());
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("data");
            cVar.i(jSONObject.optInt("error_code"));
            cVar.m(jSONObject.optInt(NotificationCompat.CATEGORY_STATUS));
            if (jSONArrayOptJSONArray2 == null) {
                return cVar;
            }
            String strD = null;
            int length3 = jSONArrayOptJSONArray2.length();
            if (length3 > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i2);
                    JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("album");
                    if (jSONArrayOptJSONArray3 != null && (length2 = jSONArrayOptJSONArray3.length()) > 0) {
                        int i4 = 0;
                        while (true) {
                            int i5 = i4 + 1;
                            JSONObject jSONObject2 = jSONArrayOptJSONArray3.getJSONObject(i4);
                            j.d(jSONObject2, "getJSONObject(index)");
                            String strOptString = jSONObject2.optString("sizable_cover");
                            j.d(strOptString, "albumCover");
                            if (strOptString.length() > 0) {
                                strD = a0.d(strOptString);
                            }
                            if (i5 >= length2) {
                                break;
                            }
                            i4 = i5;
                        }
                    }
                    if ((strD == null || strD.length() == 0) && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("author")) != null && (length = jSONArrayOptJSONArray.length()) > 0) {
                        int i6 = 0;
                        while (true) {
                            int i7 = i6 + 1;
                            JSONObject jSONObject3 = jSONArrayOptJSONArray.getJSONObject(i6);
                            j.d(jSONObject3, "getJSONObject(index)");
                            String strOptString2 = jSONObject3.optString("sizable_avatar");
                            j.d(strOptString2, "authorCover");
                            if (strOptString2.length() > 0) {
                                strD = a0.d(strOptString2);
                            }
                            if (i7 >= length) {
                                break;
                            }
                            i6 = i7;
                        }
                    }
                    if (i3 >= length3) {
                        break;
                    }
                    i2 = i3;
                }
            }
            cVar.g(strD);
        } catch (Exception unused) {
        }
        return cVar;
    }

    public final e.c.a.g.a.f.k.c<String> b(b bVar) {
        String str = "";
        j.e(bVar, "bean");
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("hash", TextUtils.isEmpty(bVar.b()) ? "" : bVar.b()).put("filename", bVar.a()).put("album_audio_id", bVar.c()));
            String string = jSONArray.toString();
            j.d(string, "jsonArray.toString()");
            str = string;
        } catch (JSONException unused) {
        }
        e.c.a.g.a.r.g.c cVarZ = e.c.a.g.a.r.g.c.z();
        cVarZ.f(new String[0]);
        cVarZ.i(new String[0]);
        cVarZ.c("author_image_type", "4,5");
        cVarZ.c("album_image_type", BaseResponse.Code.ERROR_OTHER);
        cVarZ.c("data", str);
        Map<String, String> mapE = cVarZ.E();
        d dVar = (d) new Retrofit.Builder().setModuleName("Avatar").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.V0, Http2HttpsHelper.INSTANCE.getContainer_kmrcdn_url())).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(d.class);
        try {
            j.d(mapE, "params");
            return a(dVar.call(mapE).execute().body());
        } catch (IOException unused2) {
            return new e.c.a.g.a.f.k.c<>();
        }
    }
}
