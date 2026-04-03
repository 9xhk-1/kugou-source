package e.c.a.g.a.r.d.d;

import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.kugou.android.watch.lite.user.entity.BusiVip;
import com.kugou.android.watch.lite.user.login.UserData;
import e.c.a.g.a.s.r1;
import f.z.d.j;
import java.io.IOException;
import java.util.LinkedHashMap;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final b a = new b();

    public final e.c.a.g.a.f.k.c<UserData> a() {
        e.c.a.g.a.f.k.d dVar = (e.c.a.g.a.f.k.d) new Retrofit.Builder().setModuleName("User").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(e.c.a.g.a.f.e.b.q, "https://kugouvip.kugou.com/v1/get_union_vip")).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build().create(e.c.a.g.a.f.k.d.class);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("busi_type", BusiVip.CODE);
        try {
            return c(dVar.call(e.c.a.g.a.f.k.f.a.e(linkedHashMap, "")).execute().body());
        } catch (IOException unused) {
            return new e.c.a.g.a.f.k.c<>();
        }
    }

    public final UserData b(String str) {
        if (str == null) {
            UserData userDataNewEmptyInstance = UserData.newEmptyInstance();
            j.d(userDataNewEmptyInstance, "newEmptyInstance()");
            return userDataNewEmptyInstance;
        }
        JSONObject jSONObject = new JSONObject(str);
        int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        UserData userDataNewEmptyInstance2 = UserData.newEmptyInstance();
        if (iOptInt == 1 && jSONObjectOptJSONObject != null) {
            userDataNewEmptyInstance2 = (UserData) new Gson().fromJson(jSONObjectOptJSONObject.toString(), UserData.class);
            e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
            cVar.i("young_user_data_json", str);
            cVar.i("young_vip_info_json", str);
        }
        j.d(userDataNewEmptyInstance2, "userData");
        return userDataNewEmptyInstance2;
    }

    public final e.c.a.g.a.f.k.c<UserData> c(ResponseBody responseBody) {
        e.c.a.g.a.f.k.c<UserData> cVar = new e.c.a.g.a.f.k.c<>();
        if (responseBody == null) {
            return cVar;
        }
        try {
            String strString = responseBody.string();
            JSONObject jSONObject = new JSONObject(strString);
            cVar.g(b(strString));
            cVar.i(jSONObject.optInt("error_code"));
            cVar.m(jSONObject.optInt(NotificationCompat.CATEGORY_STATUS));
        } catch (Exception unused) {
        }
        return cVar;
    }
}
