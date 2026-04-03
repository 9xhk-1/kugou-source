package e.c.a.g.a.d.r.p.b;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import e.c.a.g.a.s.e0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f532d = 2;
    public String a = "musicfees";
    public e.c.a.g.a.d.b.a b;
    public int c;

    public e.c.a.g.a.d.r.p.a.a a(e.c.a.g.a.d.r.p.a.h hVar, String str, List<e.c.a.g.a.d.r.p.a.g> list, int i2) {
        if (list == null || list.size() == 0) {
            return null;
        }
        e.c.a.g.a.d.r.p.a.a aVar = new e.c.a.g.a.d.r.p.a.a();
        Hashtable hashtable = new Hashtable();
        hashtable.put("time", Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
        hashtable.put("num", Integer.valueOf(i2));
        hashtable.put(NotificationCompat.CATEGORY_MESSAGE, str);
        try {
            hashtable.put("lists", k(list));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a aVar2 = new a(this, hashtable, e.c.a.g.a.d.r.p.b.a.f525e, hVar);
        if (g0.a) {
            g0.e(this.a, aVar2.getUrl());
        }
        d dVar = new d();
        try {
            e.c.a.g.a.f.k.k.e.a().request(aVar2, dVar);
            dVar.getResponseData(aVar);
            return aVar;
        } catch (Exception e3) {
            g0.k(e3);
            return null;
        }
    }

    public e.c.a.g.a.d.r.p.a.a b(e.c.a.g.a.d.r.p.a.h hVar, String str, List<e.c.a.g.a.d.r.p.a.g> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        e.c.a.g.a.d.r.p.a.a aVar = new e.c.a.g.a.d.r.p.a.a();
        Hashtable hashtable = new Hashtable();
        hashtable.put("time", Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
        hashtable.put("num", Integer.valueOf(list.size()));
        hashtable.put(NotificationCompat.CATEGORY_MESSAGE, str);
        try {
            hashtable.put("lists", k(list));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a aVar2 = new a(this, hashtable, e.c.a.g.a.d.r.p.b.a.f525e, hVar);
        if (g0.a) {
            g0.e(this.a, aVar2.getUrl());
        }
        d dVar = new d();
        try {
            e.c.a.g.a.f.k.k.e.a().request(aVar2, dVar);
            dVar.getResponseData(aVar);
            return aVar;
        } catch (Exception e3) {
            g0.k(e3);
            return null;
        }
    }

    public b c() {
        b bVar = new b();
        a aVar = new a(this, new Hashtable(), e.c.a.g.a.d.r.p.b.a.l, null);
        if (g0.a) {
            g0.e(this.a, aVar.getUrl());
        }
        c cVar = new c();
        try {
            e.c.a.g.a.f.k.k.e.a().request(aVar, cVar);
            cVar.getResponseData(bVar);
        } catch (Exception unused) {
            bVar = null;
        }
        if (bVar != null) {
            bVar.j(aVar.c);
        }
        return bVar;
    }

    public e.c.a.g.a.d.b.a d() {
        return this.b;
    }

    public e.c.a.g.a.d.r.p.a.a e(int i2) {
        e.c.a.g.a.d.r.p.a.a aVar = new e.c.a.g.a.d.r.p.a.a();
        a aVar2 = new a(this, new Hashtable(), e.c.a.g.a.d.r.p.b.a.f526f, null);
        if (g0.a) {
            g0.e(this.a, aVar2.getUrl());
        }
        d dVar = new d();
        try {
            e.c.a.g.a.f.k.k.e eVarA = e.c.a.g.a.f.k.k.e.a();
            if (i2 != 0) {
                eVarA.setMaxWaitDuration(i2);
            }
            eVarA.request(aVar2, dVar);
            dVar.getResponseData(aVar);
        } catch (Exception e2) {
            g0.k(e2);
            aVar = null;
        }
        if (aVar != null && aVar.b() != null && aVar.f() == 1) {
            e.c.a.g.a.r.b.d0(aVar.b().b());
        }
        return aVar;
    }

    public e.c.a.g.a.d.r.p.a.a f(e.c.a.g.a.d.r.p.a.h hVar, String str, int i2, List<e.c.a.g.a.d.r.p.a.g> list, int i3) {
        return g(hVar, str, i2, list, i3, false);
    }

    public e.c.a.g.a.d.r.p.a.a g(e.c.a.g.a.d.r.p.a.h hVar, String str, int i2, List<e.c.a.g.a.d.r.p.a.g> list, int i3, boolean z) {
        if (e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.U3, true) && !TextUtils.isEmpty(str)) {
            if (str.equals("play")) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (e.c.a.g.a.d.r.p.a.g gVar : list) {
                    e.c.a.g.a.d.r.p.a.c cVarC = e.c.a.g.a.d.r.b.d().c(gVar.a());
                    if (cVarC != null) {
                        arrayList.add(cVarC);
                    } else {
                        arrayList2.add(gVar);
                    }
                }
                if (arrayList2.isEmpty()) {
                    e.c.a.g.a.d.r.p.a.a aVar = new e.c.a.g.a.d.r.p.a.a();
                    aVar.m(1);
                    aVar.j(arrayList);
                    return aVar;
                }
                e.c.a.g.a.d.r.p.a.a aVarH = h(hVar, str, i2, arrayList2, i3, z);
                if (aVarH == null || aVarH.f() != 1) {
                    return aVarH;
                }
                e.c.a.g.a.d.r.b.d().a(aVarH.d());
                aVarH.a(arrayList);
                return aVarH;
            }
        }
        return h(hVar, str, i2, list, i3, z);
    }

    public final e.c.a.g.a.d.r.p.a.a h(e.c.a.g.a.d.r.p.a.h hVar, String str, int i2, List<e.c.a.g.a.d.r.p.a.g> list, int i3, boolean z) {
        boolean z2;
        PageKey pageKeyF;
        e.c.a.g.a.d.r.p.a.a aVar = new e.c.a.g.a.d.r.p.a.a();
        Hashtable hashtable = new Hashtable();
        hashtable.put("behavior", str);
        hashtable.put("relate", Integer.valueOf(i2));
        hashtable.put("area_code", e.c.a.g.a.r.b.c());
        hashtable.put("need_userinfo", Integer.valueOf(z ? 1 : 0));
        try {
            hashtable.put("resource", k(list));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if ("play".equals(str)) {
            hashtable.put("need_hash_offset", 1);
            z2 = true;
        } else {
            z2 = false;
        }
        try {
            if (list.size() > 0 && list.get(0) != null && (pageKeyF = list.get(0).f()) != null && j.b().f()) {
                JSONObject jSONObject = new JSONObject();
                e.c.a.g.a.r.g.c.v(jSONObject, pageKeyF);
                hashtable.put("source", jSONObject);
                if (g0.a) {
                    g0.b("getResPrivilege", jSONObject.toString());
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        e.c.a.g.a.r.b.F();
        a aVar2 = new a(this, hashtable, e.c.a.g.a.d.r.p.b.a.f524d, hVar, z2);
        if (g0.a) {
            g0.e(this.a, aVar2.getUrl());
        }
        d dVar = new d();
        try {
            e.c.a.g.a.f.k.k.e eVarA = e.c.a.g.a.f.k.k.e.a();
            if (i3 != 0) {
                eVarA.setMaxWaitDuration(i3);
            }
            eVarA.request(aVar2, dVar);
            dVar.getResponseData(aVar);
        } catch (NullPointerException e4) {
            g0.k(e4);
            aVar = new e.c.a.g.a.d.r.p.a.a();
            aVar.m(f532d);
            if (g0.a) {
                g0.c("wuhq_null", "" + e4.getMessage());
            }
        } catch (Exception e5) {
            g0.k(e5);
            aVar = null;
        }
        this.b = dVar.b();
        this.c = dVar.getStatusCode();
        return aVar;
    }

    public e.c.a.g.a.d.r.p.a.f i(e.c.a.g.a.d.r.p.a.h hVar, String str, e.c.a.g.a.d.r.p.a.g gVar, int i2) {
        if (gVar == null) {
            return null;
        }
        e.c.a.g.a.d.r.p.a.f fVar = new e.c.a.g.a.d.r.p.a.f();
        Hashtable hashtable = new Hashtable();
        hashtable.put("behavior", str);
        hashtable.put("fromdr", 1);
        hashtable.put("mtype", Integer.valueOf(e.c.a.g.a.r.b.i()));
        hashtable.put("cmd", 22);
        hashtable.put("module", hVar == null ? "" : hVar.a);
        if (gVar.g() != null) {
            hashtable.put("type", gVar.g());
        }
        if (gVar.c() != null) {
            hashtable.put("hash", gVar.c());
        }
        if (gVar.b() != null) {
            hashtable.put("album_id", gVar.b());
        }
        if (gVar.a() != 0) {
            hashtable.put("album_audio_id", Long.valueOf(gVar.a()));
        }
        f fVar2 = new f(gVar.c(), hashtable);
        g gVar2 = new g();
        try {
            e.c.a.g.a.f.k.k.e eVarA = e.c.a.g.a.f.k.k.e.a();
            eVarA.request(fVar2, gVar2);
            if (i2 != 0) {
                eVarA.setMaxWaitDuration(i2);
            }
            gVar2.getResponseData(fVar);
            return fVar;
        } catch (Exception e2) {
            g0.k(e2);
            return null;
        }
    }

    public int j() {
        return this.c;
    }

    public final JSONArray k(List<e.c.a.g.a.d.r.p.a.g> list) {
        JSONArray jSONArray = new JSONArray();
        for (e.c.a.g.a.d.r.p.a.g gVar : list) {
            if (gVar != null) {
                jSONArray.put(gVar.r());
            }
        }
        return jSONArray;
    }

    public class a extends e.c.a.g.a.d.r.p.b.a {
        public int m;

        public a(e eVar, Hashtable<String, Object> hashtable, int i2, e.c.a.g.a.d.r.p.a.h hVar, boolean z) {
            super(hVar, z);
            this.mParams.putAll(hashtable);
            this.m = i2;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            try {
                String strA = e0.a(this.mParams);
                if (g0.a) {
                    g0.e("musicfees", strA);
                }
                StringEntity stringEntity = new StringEntity(strA, "utf-8");
                stringEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
                return stringEntity;
            } catch (UnsupportedEncodingException e2) {
                g0.k(e2);
                return null;
            }
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "mediastore";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getUrl() {
            String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.B0);
            int i2 = this.m;
            if (i2 == e.c.a.g.a.d.r.p.b.a.f524d) {
                return config + "get_res_privilege";
            }
            if (i2 == e.c.a.g.a.d.r.p.b.a.f525e) {
                return config + "buy_res_vip";
            }
            if (i2 == e.c.a.g.a.d.r.p.b.a.f526f) {
                return config + "get_remain_quota";
            }
            if (i2 == e.c.a.g.a.d.r.p.b.a.f527g) {
                return config + "get_orders";
            }
            if (i2 == e.c.a.g.a.d.r.p.b.a.f528h) {
                return config + "get_goods";
            }
            if (i2 == e.c.a.g.a.d.r.p.b.a.f529i) {
                return config + "get_buy_info";
            }
            if (i2 == e.c.a.g.a.d.r.p.b.a.j) {
                return config + "get_goods_buycount";
            }
            if (i2 == e.c.a.g.a.d.r.p.b.a.k) {
                return config + "get_video_privilege";
            }
            if (i2 != e.c.a.g.a.d.r.p.b.a.l) {
                return "";
            }
            return config + "show_pay_info";
        }

        public a(e eVar, Hashtable<String, Object> hashtable, int i2, e.c.a.g.a.d.r.p.a.h hVar) {
            super(hVar, true);
            this.mParams.putAll(hashtable);
            this.m = i2;
        }
    }
}
