package e.c.a.g.a.r.d.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.q0;
import e.c.a.g.a.s.r1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.ResponseBody;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: e.c.a.g.a.r.d.d.a$a, reason: collision with other inner class name */
    public static class C0178a {
        public int a;
        public String b;
    }

    public interface b {
        @GET
        Observable<ResponseBody> getAuthorization(@QueryMap Map<String, Object> map);

        @GET
        Call<ResponseBody> getAuthorizationSync(@QueryMap Map<String, Object> map);
    }

    public static C0178a a(ResponseBody responseBody) {
        JSONObject jSONObject;
        int iOptInt;
        C0178a c0178a = new C0178a();
        try {
            jSONObject = new JSONObject(responseBody.string());
            iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
            jSONObject.optInt("error_code");
            jSONObject.optString("errmsg");
        } catch (Exception e2) {
            c0178a.a = 0;
            e2.printStackTrace();
        }
        if (iOptInt == 0) {
            c0178a.a = iOptInt;
            return c0178a;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        if (jSONObjectOptJSONObject != null) {
            String strOptString = jSONObjectOptJSONObject.optString("authorization");
            c0178a.a = 1;
            c0178a.b = strOptString;
        }
        return c0178a;
    }

    public static Map<String, Object> b(String str, String str2, String str3) {
        Context contextA = e.c.c.o.f.a();
        HashMap map = new HashMap();
        map.put("bucket", str2);
        map.put("filename", str);
        map.put("method", str3);
        map.put("loginType", Integer.valueOf(e.c.a.g.a.r.b.F() ? 1 : 0));
        map.put("buVerifyCode", d(str2));
        map.put("extranet", 1);
        map.put("userid", String.valueOf(e.c.a.g.a.r.b.o()));
        map.put("token", e.c.a.g.a.r.b.n());
        map.put(ClientCookie.VERSION_ATTR, String.valueOf(e.c.a.g.a.r.e.b.c(contextA)));
        e.c.a.g.a.r.g.c.a(map, "");
        return map;
    }

    public static C0178a c(String str, String str2, String str3) {
        Retrofit retrofitBuild = new Retrofit.Builder().setModuleName("Bss").setMultiUrl(r1.c(e.c.a.g.a.f.e.b.C0, "https://gateway.kugou.com/bsstrackercdngz/v1/upload/auth")).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setExcludeEndChar().build();
        try {
            return a(((b) retrofitBuild.create(b.class)).getAuthorizationSync(b(str2, str, str3)).execute().body());
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String d(String str) {
        long jF;
        if (!TextUtils.isEmpty(str)) {
            jF = l1.f();
            str.hashCode();
            switch (str) {
                case "h5feedback":
                    return q0.g(jF + str + "a3fa304a233e3d39");
                case "mobileservice":
                    return q0.g(jF + str + "9348cd7332aee0ad");
                case "kugouicon":
                    return q0.g(jF + str + "6e57833bad2f98d6");
            }
        }
        if (g0.a) {
            throw new IllegalStateException(String.format("非法bucket:%s，请联系后端获取相应的buVerifyCode", str));
        }
        return "";
    }
}
