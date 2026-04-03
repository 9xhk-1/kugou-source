package e.c.a.g.a.g.o;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.network.ExceptionParse;
import com.kugou.common.network.networkutils.UrlEncoderUtil;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import e.c.a.g.a.s.r;
import e.c.a.g.a.s.x;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    public class a implements r<h> {
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ StringBuilder b;

        public a(StringBuilder sb, StringBuilder sb2) {
            this.a = sb;
            this.b = sb2;
        }

        @Override // e.c.a.g.a.s.r
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean isFilter(h hVar) {
            boolean z = hVar == null || e.c.a.g.a.g.o.b.g(hVar.a());
            if (z) {
                if (hVar != null && hVar.a() != null) {
                    this.b.append("displayName = " + hVar.a().s1() + ", mixid = " + hVar.a().T1());
                }
            } else if (hVar != null && hVar.a() != null) {
                this.a.append("displayName = " + hVar.a().s1() + ", mixid = " + hVar.a().T1());
            }
            return z;
        }
    }

    public static class b extends e.c.a.g.a.f.k.a {
        public /* synthetic */ b(Map map, a aVar) {
            this(map);
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            return null;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "SearchSong";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "GET";
        }

        @Override // e.c.a.g.a.f.k.a
        public ConfigKey getUrlConfigKey() {
            return e.c.a.g.a.f.e.b.D0;
        }

        public b(Map<String, String> map) {
            Hashtable<String, Object> hashtable = new Hashtable<>();
            this.mParams = hashtable;
            hashtable.putAll(map);
        }
    }

    public static class c extends e.c.a.g.a.f.k.k.a<g> {
        public String a;
        public String b;
        public long c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f1007d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1008e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public e.c.a.g.a.d.b.a f1009f;

        public c(String str, String str2, int i2) {
            this.a = str;
            this.b = str2;
            this.f1008e = i2;
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void getResponseData(g gVar) {
            super.getResponseData(gVar);
            f.b(gVar, this.jsonStr, this.a, this.b, this.f1008e);
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.AbsHttpClient.IHttpException
        public void onContentException(int i2, String str, int i3, byte[] bArr) {
        }

        @Override // e.c.a.g.a.f.k.k.a
        public void onHandleApmData(e.c.a.g.a.d.b.a aVar) {
            this.f1009f = aVar;
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
        public void setContext(byte[] bArr) {
            super.setContext(bArr);
        }
    }

    public static void b(g gVar, String str, String str2, String str3, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z = true;
            gVar.d(jSONObject.optInt(NotificationCompat.CATEGORY_STATUS) == 1);
            gVar.k(jSONObject.optInt("error_code"));
            if (!gVar.a()) {
                int iOptInt = jSONObject.optInt("error_code");
                if (iOptInt != 0) {
                    e.c.a.g.a.d.b.a aVar = new e.c.a.g.a.d.b.a();
                    aVar.k(ResponseHandlerForApm.E2);
                    aVar.g(String.valueOf(iOptInt));
                    gVar.c(aVar);
                }
                gVar.k(iOptInt);
                e.c.a.g.a.d.d0.a.a("SearchSongNewProtocol2", "searchResult online fail response = " + gVar);
                return;
            }
            ArrayList<h> arrayList = new ArrayList<>();
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            gVar.q(jSONObject2.optInt("total"));
            gVar.h(jSONObject2.optString("allowerr"));
            gVar.p(jSONObject2.optInt("isshareresult") == 1);
            int iOptInt2 = jSONObject2.optInt("pagesize", 10);
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("lists");
            int length = jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.length() : 0;
            if (length >= iOptInt2) {
                z = false;
            }
            gVar.j(z);
            e.c.a.g.a.d.d0.a.a("SearchSongNewProtocol2", "searchResult online isSuccess response = " + gVar + ", listCount = " + length);
            if (length > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
                    if (jSONObjectOptJSONObject != null) {
                        h hVar = new h();
                        KGSong kGSongA = e.c.a.g.a.s.b.a(jSONObjectOptJSONObject, true, i3, str2, false, i2);
                        hVar.d(kGSongA);
                        hVar.c(jSONObjectOptJSONObject.optInt("FoldType", -1));
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("Grp");
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                            ArrayList<KGSong> arrayList2 = new ArrayList<>(0);
                            for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i4);
                                if (jSONObjectOptJSONObject2 != null) {
                                    arrayList2.add(e.c.a.g.a.s.b.a(jSONObjectOptJSONObject2, false, i4, str2, false, i2));
                                }
                            }
                            hVar.e(arrayList2);
                        }
                        arrayList.add(hVar);
                        if (kGSongA != null) {
                            Log.e("mhs_watch_error", "isVipMusic" + e.c.a.g.a.f.j.c.d.d(kGSongA) + ", firstSong.hashOffset = " + kGSongA.H1());
                        }
                    }
                }
                x.b(arrayList);
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                l0.a(arrayList, new a(sb, sb2));
                e.c.a.g.a.d.d0.a.a("SearchSongNewProtocol2", "searchResult final listCount = " + arrayList.size() + ", 没有被过滤 = " + ((Object) sb) + ", 被过滤 = " + ((Object) sb2));
                gVar.o(arrayList);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            e.c.a.g.a.d.b.a aVar2 = new e.c.a.g.a.d.b.a();
            aVar2.k(ResponseHandlerForApm.E4);
            aVar2.g("222222");
            gVar.c(aVar2);
            e.c.a.g.a.d.d0.a.a("SearchSongNewProtocol2", "searchResult JSONException e = " + e2);
        }
    }

    public static String c(String str) {
        return (TextUtils.isEmpty(str) || "全部".equals(str)) ? "" : str;
    }

    public static g d(String str, int i2, String str2, int i3, boolean z, boolean z2, String str3, PageKey pageKey) {
        return e(str, i2, str2, i3, z, z2, false, str3, pageKey);
    }

    public static g e(String str, int i2, String str2, int i3, boolean z, boolean z2, boolean z3, String str3, PageKey pageKey) {
        g gVar = new g();
        e.c.a.g.a.r.g.c cVarZ = e.c.a.g.a.r.g.c.z();
        cVarZ.c("keyword", str);
        cVarZ.c("page", String.valueOf(i2));
        cVarZ.c("pagesize", String.valueOf(10));
        cVarZ.c("userid", String.valueOf(e.c.a.g.a.r.b.o()));
        cVarZ.i(new String[0]);
        cVarZ.c("platform", "AndroidFilter");
        cVarZ.b("filter", Integer.valueOf(i3));
        cVarZ.c("tag", "em");
        cVarZ.c("iscorrection", String.valueOf(z2 ? 2 : z ? 1 : 0));
        cVarZ.c("privilegefilter", Integer.toString(z3 ? 1 : 0));
        cVarZ.b("appid", Integer.valueOf(l1.f()));
        cVarZ.c("area_code", e.c.a.g.a.r.b.c());
        cVarZ.h("clienttime");
        cVarZ.c("dopicfull", "1");
        cVarZ.o("mid");
        cVarZ.c("dfid", m.e());
        cVarZ.l("uuid");
        cVarZ.c("token", e.c.a.g.a.r.b.n());
        Map<String, String> mapE = cVarZ.E();
        if (!TextUtils.isEmpty(c(str3))) {
            mapE.put("sectag", str3);
        }
        e.c.a.g.a.r.g.c.w(mapE, pageKey);
        mapE.put("signature", e.c.a.g.a.r.g.c.A(e.c.a.g.a.r.g.c.B(mapE)));
        mapE.remove("keyword");
        mapE.put("keyword", UrlEncoderUtil.encode(str));
        if (mapE.containsKey("sectag")) {
            mapE.remove("sectag");
            mapE.put("sectag", UrlEncoderUtil.encode(str3));
            if (g0.a) {
                g0.c("SearchSongNewProtocol2", "SearchSongNewProtocol2 search tag " + str3);
            }
        }
        if (mapE.containsKey("user_labels")) {
            mapE.remove("user_labels");
            mapE.put("user_labels", UrlEncoderUtil.encode(""));
        }
        b bVar = new b(mapE, null);
        c cVar = new c(str2, str, i2);
        e.c.a.g.a.f.k.k.e eVarA = e.c.a.g.a.f.k.k.e.a();
        cVar.c = System.currentTimeMillis();
        try {
            try {
                eVarA.request(bVar, cVar);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ExpCode", ExceptionParse.parseResultCode(e2));
                    jSONObject.put("ExpContent", e2.toString());
                    gVar.d(false);
                    gVar.m("net");
                    gVar.l(ExceptionParse.parseResultCode(e2));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                if (cVar.f1007d == 0) {
                    cVar.f1007d = System.currentTimeMillis();
                }
                gVar.n(cVar.f1007d - cVar.c);
                if (g0.a) {
                }
            }
            gVar.c(cVar.f1009f);
            cVar.getResponseData(gVar);
            gVar.b(gVar.f() == null || gVar.f().size() == 0);
            gVar.a();
            return gVar;
        } finally {
            if (cVar.f1007d == 0) {
                cVar.f1007d = System.currentTimeMillis();
            }
            gVar.n(cVar.f1007d - cVar.c);
            if (g0.a) {
                g0.b("zkzhou", "手机酷狗歌曲搜索");
            }
            gVar.i(eVarA.getRequestDelay());
        }
    }
}
