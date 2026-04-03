package e.c.a.g.a.r.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import e.c.a.g.a.s.q0;
import e.c.a.g.a.s.r1;
import e.c.c.o.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public Map<String, String> a = new HashMap();

    public static String A(String str) {
        String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f642d);
        if (g0.a) {
            g0.b("yyt_sign", config + str + config);
        }
        return q0.g(config + str + config);
    }

    public static String B(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        D(map, sb);
        return sb.toString();
    }

    public static void D(Map<String, ?> map, StringBuilder sb) {
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
                sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
                sb.append(map.get(str));
            }
        }
    }

    public static void a(Map<String, Object> map, String str) {
        if (str == null) {
            str = "";
        }
        Context contextA = f.a();
        map.put("dfid", m.e());
        map.put("appid", 3337);
        map.put("mid", l1.n(contextA));
        map.put("uuid", m.h());
        map.put("clientver", Integer.valueOf(e.c.a.g.a.r.e.b.c(contextA)));
        map.put("clienttime", Long.valueOf(System.currentTimeMillis() / 1000));
        map.put("signature", A(B(map) + str));
    }

    public static boolean t(PageKey pageKey) {
        return pageKey == null || pageKey.getPageId() <= 0 || !j.b().f();
    }

    public static void u(Hashtable<String, Object> hashtable, PageKey pageKey) {
        if (t(pageKey)) {
            return;
        }
        hashtable.put("page_id", Integer.toString(pageKey.getPageId()));
        hashtable.put("ppage_id", pageKey.getPageStackSplit());
        if (g0.a) {
            g0.e("ParamGenerator", String.format("C page_id:%s ppage_id:%s", Integer.valueOf(pageKey.getPageId()), pageKey.getPageStackSplit()));
        }
    }

    public static void v(JSONObject jSONObject, PageKey pageKey) throws JSONException {
        if (t(pageKey)) {
            return;
        }
        jSONObject.put("page_id", pageKey.getPageId());
        jSONObject.put("ppage_id", pageKey.getPageStackSplit());
        if (g0.a) {
            g0.e("ParamGenerator", String.format("E page_id:%s ppage_id:%s", Integer.valueOf(pageKey.getPageId()), pageKey.getPageStackSplit()));
        }
    }

    public static void w(Map<String, String> map, PageKey pageKey) {
        if (t(pageKey)) {
            return;
        }
        map.put("page_id", Integer.toString(pageKey.getPageId()));
        map.put("ppage_id", pageKey.getPageStackSplit());
        if (g0.a) {
            g0.e("ParamGenerator", String.format("A page_id:%s ppage_id:%s", Integer.valueOf(pageKey.getPageId()), pageKey.getPageStackSplit()));
        }
    }

    public static Map<String, String> y(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        e.c.a.g.a.f.m.b bVarM = e.c.a.g.a.f.m.b.m();
        try {
            e.c.a.g.a.r.e.e.e(bVarM);
            String strC = e.c.a.g.a.r.e.e.c(bVarM);
            if (strC == null) {
                strC = "";
            }
            map.put("KG-DEVID", strC);
            String strD = e.c.a.g.a.r.e.e.d(bVarM);
            long j = Long.parseLong(strD) / 1000;
            map.put("KG-CLIENTTIMEMS", strD);
        } catch (Throwable th) {
            g0.c("ParamGenerator", th + "getTimeStamp err");
            map.put("clienttime", String.valueOf((int) (System.currentTimeMillis() / 1000)));
        }
        return map;
    }

    public static c z() {
        return new c();
    }

    public final String C(Map<String, ?> map, String str) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f642d);
        StringBuilder sb = new StringBuilder();
        sb.append(config);
        D(map, sb);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append(config);
        return q0.k(sb.toString());
    }

    public Map<String, String> E() {
        return this.a;
    }

    public Map<String, String> F(String str) {
        Map<String, String> map = this.a;
        if (map != null) {
            map.put("signature", r1.d(r1.g(this.a) + str));
        }
        return this.a;
    }

    public c b(String str, Object obj) {
        this.a.put(str, String.valueOf(obj));
        return this;
    }

    public c c(String str, String str2) {
        this.a.put(str, str2);
        return this;
    }

    public c d() {
        e("");
        return this;
    }

    public c e(String str) {
        Map<String, String> map = this.a;
        map.put("signature", C(map, str));
        return this;
    }

    public c f(String... strArr) {
        this.a.put(x("appid", strArr), String.valueOf(3337));
        return this;
    }

    public c g(String... strArr) {
        this.a.put(x("channelID", strArr), l1.j());
        return this;
    }

    public c h(String... strArr) {
        this.a.put(x("clienttime", strArr), String.valueOf(System.currentTimeMillis() / 1000));
        return this;
    }

    public c i(String... strArr) {
        this.a.put(x("clientver", strArr), String.valueOf(l1.G()));
        return this;
    }

    public c j(String str) {
        if (str == null) {
            str = "";
        }
        Context contextA = f.a();
        this.a.put("dfid", m.e());
        this.a.put("appid", String.valueOf(3337));
        this.a.put("mid", l1.n(contextA));
        this.a.put("uuid", m.h());
        this.a.put("clientver", String.valueOf(10503));
        this.a.put("clienttime", String.valueOf(System.currentTimeMillis() / 1000));
        String strB = B(this.a);
        String strReplace = str.replace("\\/", "/");
        this.a.put("signature", A(strB + strReplace));
        return this;
    }

    public c k(String str, Map<String, String> map) {
        if (str == null) {
            str = "";
        }
        Context context = KGApplication.getContext();
        this.a.put("dfid", m.e());
        this.a.put("appid", e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.c));
        this.a.put("mid", l1.n(context));
        this.a.put("uuid", m.h());
        this.a.put("clientver", String.valueOf(e.c.a.g.a.r.e.b.c(context)));
        this.a.put("clienttime", String.valueOf(System.currentTimeMillis() / 1000));
        if (map != null) {
            this.a.putAll(map);
        }
        String strB = B(this.a);
        this.a.put("signature", A(strB + str));
        return this;
    }

    public c l(String... strArr) {
        this.a.put(x("deviceid", strArr), m.h());
        return this;
    }

    public c m(String... strArr) {
        this.a.put(x("dfid", strArr), m.e());
        return this;
    }

    public c n(String... strArr) {
        m(strArr);
        return this;
    }

    public c o(String... strArr) {
        this.a.put(x("mid", strArr), l1.n(f.a()));
        return this;
    }

    public c p(String... strArr) {
        this.a.put(x("token", strArr), e.c.a.g.a.r.b.n());
        return this;
    }

    public c q(String... strArr) {
        this.a.put(x("uid", strArr), String.valueOf(e.c.a.g.a.r.b.o()));
        return this;
    }

    public c r(String... strArr) {
        this.a.put(x("uuid", strArr), m.h());
        return this;
    }

    public c s() {
        c("clienttime", String.valueOf(System.currentTimeMillis() / 1000));
        c("mid", l1.n(f.a()));
        c("dfid", m.e());
        c("uuid", m.h());
        c("appid", String.valueOf(3337));
        c("clientver", String.valueOf(l1.G()));
        return this;
    }

    public final String x(@NonNull String str, @Nullable String... strArr) {
        return (strArr == null || strArr.length == 0) ? str : strArr[0];
    }
}
