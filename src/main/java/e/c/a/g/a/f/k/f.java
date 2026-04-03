package e.c.a.g.a.f.k;

import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import e.c.a.g.a.s.e0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import e.c.a.g.a.s.r1;
import f.z.c.p;
import f.z.d.j;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import rx.Observable;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final f a = new f();

    public static /* synthetic */ Observable b(f fVar, ResponseBody responseBody, Class cls, p pVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            pVar = null;
        }
        return fVar.a(responseBody, cls, pVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Observable<c<T>> a(ResponseBody responseBody, Class<T> cls, p<? super JSONObject, ? super Class<T>, ? extends T> pVar) {
        j.e(responseBody, "responseBody");
        j.e(cls, "entity");
        try {
            JSONObject jSONObject = new JSONObject(responseBody.string());
            c cVarG = g(jSONObject);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null) {
                if (pVar == null) {
                    cVarG.g(new Gson().fromJson(jSONObjectOptJSONObject.toString(), (Class) cls));
                } else {
                    cVarG.g(pVar.invoke(jSONObjectOptJSONObject, cls));
                }
            }
            Observable<c<T>> observableJust = Observable.just(cVarG);
            j.d(observableJust, "{\n            val jsonObject = JSONObject(responseBody.string())\n            val response = parseCommonResponse<T?>(jsonObject)\n            val data = jsonObject.optJSONObject(\"data\")\n            if (data != null) {\n                if (dataConvert == null) {\n                    response.data = Gson().fromJson(data.toString(), entity)\n                } else {\n                    response.data = dataConvert.invoke(data, entity)\n                }\n            }\n            Observable.just(response)\n        }");
            return observableJust;
        } catch (Exception unused) {
            Observable<c<T>> observableError = Observable.error(new Exception("parse gson fail"));
            j.d(observableError, "{\n            Observable.error<CommonResponse<T?>>(Exception(\"parse gson fail\"))\n        }");
            return observableError;
        }
    }

    public final Map<String, String> c(HashMap<String, String> map, String str) {
        j.e(map, "params");
        j.e(str, "postContent");
        if (e.c.a.g.a.r.b.F()) {
            String string = Long.toString(e.c.a.g.a.r.b.o());
            j.d(string, "toString(CommonEnvManager.getUserID())");
            map.put("userid", string);
            String strN = e.c.a.g.a.r.b.n();
            j.d(strN, "getToken()");
            map.put("token", strN);
        }
        map.put("appid", String.valueOf(e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.c)));
        String string2 = Integer.toString(l1.G());
        j.d(string2, "toString(SystemUtils.getVersionCode())");
        map.put("clientver", string2);
        String string3 = Long.toString(l1.b() / ((long) 1000));
        j.d(string3, "toString(SystemUtils.currentTimeMillis() / 1000)");
        map.put("clienttime", string3);
        String strN2 = l1.n(e.c.c.o.f.a());
        j.d(strN2, "getMid(KGCommonApplication.getContext())");
        map.put("mid", strN2);
        String strH = m.h();
        j.d(strH, "getUUID()");
        map.put("uuid", strH);
        String strE = m.e();
        j.d(strE, "getDeviceFingerIdDateNotNull()");
        map.put("dfid", strE);
        String strD = r1.d(j.l(r1.g(map), str));
        j.d(strD, "getSign(\n            Utils.map2SortString(params) + postContent\n        )");
        map.put("signature", strD);
        return map;
    }

    public final Map<String, Object> d(Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("appid", Integer.valueOf(e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.c)));
        map.put("clientver", Integer.valueOf(l1.G()));
        map.put("clienttime", Long.valueOf(l1.b() / ((long) 1000)));
        map.put("mid", l1.n(e.c.c.o.f.a()));
        map.put("uuid", m.h());
        map.put("dfid", m.e());
        map.put("signature", r1.d(r1.g(map)));
        return map;
    }

    public final Map<String, String> e(Map<String, String> map, String str) {
        j.e(str, "postContent");
        if (map == null) {
            map = new HashMap<>();
        }
        if (e.c.a.g.a.r.b.F()) {
            String string = Long.toString(e.c.a.g.a.r.b.o());
            j.d(string, "toString(CommonEnvManager.getUserID())");
            map.put("userid", string);
            String strN = e.c.a.g.a.r.b.n();
            j.d(strN, "getToken()");
            map.put("token", strN);
        }
        map.put("appid", String.valueOf(e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.c)));
        String string2 = Integer.toString(l1.G());
        j.d(string2, "toString(SystemUtils.getVersionCode())");
        map.put("clientver", string2);
        String string3 = Long.toString(l1.b() / ((long) 1000));
        j.d(string3, "toString(SystemUtils.currentTimeMillis() / 1000)");
        map.put("clienttime", string3);
        String strN2 = l1.n(e.c.c.o.f.a());
        j.d(strN2, "getMid(KGCommonApplication.getContext())");
        map.put("mid", strN2);
        String strH = m.h();
        j.d(strH, "getUUID()");
        map.put("uuid", strH);
        String strE = m.e();
        j.d(strE, "getDeviceFingerIdDateNotNull()");
        map.put("dfid", strE);
        String strD = r1.d(j.l(r1.g(map), str));
        j.d(strD, "getSign(\n            Utils.map2SortString(params) + postContent\n        )");
        map.put("signature", strD);
        return map;
    }

    public final Hashtable<String, Object> f(Hashtable<String, Object> hashtable, String str) {
        j.e(str, "postContent");
        if (hashtable == null) {
            hashtable = new Hashtable<>();
        }
        if (e.c.a.g.a.r.b.F()) {
            hashtable.put("userid", Long.toString(e.c.a.g.a.r.b.o()));
            hashtable.put("token", e.c.a.g.a.r.b.n());
        }
        hashtable.put("appid", Integer.toString(e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.c)));
        hashtable.put("clientver", Integer.toString(l1.G()));
        hashtable.put("clienttime", Long.toString(l1.b() / ((long) 1000)));
        hashtable.put("mid", l1.n(e.c.c.o.f.a()));
        hashtable.put("uuid", m.h());
        hashtable.put("dfid", m.e());
        hashtable.put("signature", r1.d(j.l(r1.g(hashtable), str)));
        return hashtable;
    }

    public final <T> c<T> g(JSONObject jSONObject) {
        j.e(jSONObject, "jsonObject");
        c<T> cVar = new c<>();
        cVar.m(jSONObject.optInt(NotificationCompat.CATEGORY_STATUS));
        cVar.k(e0.c(jSONObject, "error_code", "err_code", 0));
        cVar.j(e0.d(jSONObject, "error_msg", "err_msg", ""));
        return cVar;
    }
}
