package e.c.a.g.a.l;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.INetworkState;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import e.c.a.g.a.s.r1;
import e.c.a.g.a.s.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ArrayList<KGSong> f1104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f1105g;
    public String a;
    public long b;
    public long c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f1106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1107e;

    public class a implements Runnable {
        public a(e eVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class b extends e.c.a.g.a.r.e.a<e.c.a.g.a.l.b> implements INetworkState, AbsHttpClient.IHttpException {
        public String b;
        public String c;

        public b(String str) {
            this.c = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x01f9 A[Catch: Exception -> 0x0238, TryCatch #1 {Exception -> 0x0238, blocks: (B:5:0x0011, B:7:0x0023, B:9:0x002d, B:11:0x0035, B:15:0x005f, B:19:0x006b, B:21:0x0071, B:23:0x0077, B:25:0x007f, B:26:0x0082, B:28:0x013e, B:30:0x014b, B:34:0x0172, B:41:0x01f5, B:43:0x01f9, B:44:0x0217, B:46:0x021d, B:48:0x0223, B:49:0x022a, B:51:0x0230, B:29:0x0146, B:52:0x0234), top: B:61:0x0011 }] */
        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void getResponseData(e.c.a.g.a.l.b r18) {
            /*
                Method dump skipped, instruction units count: 573
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.l.e.b.getResponseData(e.c.a.g.a.l.b):void");
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.AbsHttpClient.IHttpException
        public void onContentException(int i2, String str, int i3, byte[] bArr) {
        }

        @Override // com.kugou.common.network.INetworkState
        public void onReadEnd() {
        }

        @Override // com.kugou.common.network.INetworkState
        public void onReadStart() {
        }

        @Override // com.kugou.common.network.INetworkState
        public void onRequest() {
            e.this.b = System.currentTimeMillis();
        }

        @Override // com.kugou.common.network.INetworkState
        public void onResponse(int i2) {
            if (i2 == 200 || i2 == 206) {
                e.this.c = System.currentTimeMillis();
            }
        }

        @Override // com.kugou.common.network.INetworkState
        public void onStop() {
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        public void setContext(byte[] bArr) {
            this.b = new String(bArr);
        }
    }

    public class c extends e.c.a.g.a.f.k.a {
        public String a;
        public List<f> b;

        public c() {
        }

        @NonNull
        public final String b() {
            String str = this.a;
            if (str != null) {
                return str;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            List<f> list = this.b;
            if (list == null || list.isEmpty()) {
                this.a = "";
            } else {
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                for (f fVar : this.b) {
                    int iA = fVar.a();
                    Set hashSet = (Set) map.get(Integer.valueOf(iA));
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        map.put(Integer.valueOf(iA), hashSet);
                    }
                    hashSet.add(fVar.b());
                    Set hashSet2 = (Set) map2.get(Integer.valueOf(iA));
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet();
                        map2.put(Integer.valueOf(iA), hashSet2);
                    }
                    hashSet2.add(Long.valueOf(fVar.c()));
                }
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 1; i2 <= 7; i2++) {
                    String str2 = null;
                    switch (i2) {
                        case 1:
                            str2 = "p";
                            break;
                        case 2:
                            str2 = "d";
                            break;
                        case 3:
                            str2 = "c";
                            break;
                        case 4:
                            str2 = "dp";
                            break;
                        case 5:
                            str2 = "s";
                            break;
                        case 6:
                            str2 = "cm";
                            break;
                        case 7:
                            str2 = "f";
                            break;
                    }
                    if (str2 != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray2 = new JSONArray();
                            Set set = (Set) map.get(Integer.valueOf(i2));
                            if (set != null) {
                                Iterator it = set.iterator();
                                while (it.hasNext()) {
                                    jSONArray2.put((String) it.next());
                                }
                            }
                            JSONArray jSONArray3 = new JSONArray();
                            Set set2 = (Set) map2.get(Integer.valueOf(i2));
                            if (set2 != null) {
                                Iterator it2 = set2.iterator();
                                while (it2.hasNext()) {
                                    jSONArray3.put((Long) it2.next());
                                }
                            }
                            jSONObject.put("t", str2);
                            jSONObject.put("h", jSONArray2);
                            jSONObject.put("i", jSONArray3);
                            jSONArray.put(jSONObject);
                        } catch (Exception e2) {
                            g0.h("lzm", e2);
                        }
                    }
                }
                this.a = jSONArray.toString();
            }
            if (g0.a) {
                g0.b("lzm", "NewSongProtocol-getBody time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            }
            return this.a;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            try {
                return e.this.f1107e == 2 ? new ByteArrayEntity(s.a(b(), "")) : new StringEntity(b(), "UTF-8");
            } catch (Exception e2) {
                g0.k(e2);
                return null;
            }
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "NewSongRecommend";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "POST";
        }

        @Override // e.c.a.g.a.f.k.a
        public ConfigKey getUrlConfigKey() {
            return e.c.a.g.a.f.e.b.K;
        }

        public /* synthetic */ c(e eVar, a aVar) {
            this();
        }
    }

    public e(Context context, String str) {
        this.f1107e = 2;
        this.f1106d = context;
        this.a = str;
        this.f1107e = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.L, 1);
    }

    public static ArrayList<KGSong> d() {
        return f1104f;
    }

    public static int e() {
        return f1105g;
    }

    public static int f() {
        return e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.z, 20);
    }

    public static void i(ArrayList<KGSong> arrayList) {
        f1104f = arrayList;
    }

    public static void j(int i2) {
        f1105g = i2;
    }

    public static void k(int i2) {
    }

    public e.c.a.g.a.l.b g(int i2, long j, int i3, int i4, String str, int i5, int i6, PageKey pageKey) {
        Hashtable<String, Object> hashtable = new Hashtable<>();
        hashtable.put("plat", l1.r(this.f1106d));
        hashtable.put(ClientCookie.VERSION_ATTR, Integer.valueOf(l1.G()));
        hashtable.put("uuid", m.h());
        hashtable.put("refresh_type", Integer.valueOf(i3));
        hashtable.put("since_id", Long.valueOf(j));
        hashtable.put("device_id", m.f(this.f1106d));
        hashtable.put("user_type", Integer.valueOf(i4));
        hashtable.put("apiver", 2);
        hashtable.put("vip_type", Integer.valueOf(e.c.a.g.a.r.b.z()));
        hashtable.put("m_type", Integer.valueOf(e.c.a.g.a.r.b.i()));
        hashtable.put("area_code", e.c.a.g.a.r.b.c());
        hashtable.put("has_cache", Integer.valueOf(i6));
        hashtable.put("need_subscribed", Integer.valueOf(i5));
        hashtable.put("from", "single_tab");
        hashtable.put("encoding", Integer.valueOf(this.f1107e));
        e.c.a.g.a.r.g.c.u(hashtable, pageKey);
        if (!str.equals("")) {
            hashtable.put("tag_ids", str);
        }
        hashtable.put("user", e.c.a.g.a.r.b.n());
        c cVar = new c(this, null);
        b bVar = new b(this.a);
        e.c.a.g.a.l.b bVar2 = new e.c.a.g.a.l.b();
        if (this.f1107e == 2) {
            try {
                r1.i(hashtable, s.a(cVar.b(), ""));
            } catch (IOException e2) {
                g0.k(e2);
            }
        } else {
            r1.h(hashtable, cVar.b());
        }
        bVar2.l(i2);
        e.c.a.g.a.f.k.k.e eVarA = e.c.a.g.a.f.k.k.e.a();
        cVar.setParams(hashtable);
        eVarA.setReadTimeout(eVarA.getReadTimeout() + BaseConnection.CONNECT_TIMEOUT);
        eVarA.setConnTimeout(eVarA.getConnTimeout() + BaseConnection.CONNECT_TIMEOUT);
        eVarA.setNetworkStateListener(bVar);
        try {
            eVarA.request(cVar, bVar);
            if (g0.a) {
                g0.b("zkzhou", "手机酷狗乐库");
            }
            eVarA.getRequestDelay();
        } catch (Exception unused) {
        }
        bVar.getResponseData(bVar2);
        if (bVar2.f() == 1) {
            j0.b().a(new a(this));
        }
        return bVar2;
    }

    public e.c.a.g.a.l.b h(int i2, long j, int i3, String str, int i4, int i5, PageKey pageKey) {
        int iF = f();
        if (g0.a) {
            g0.c("NewSongProtocol", "新歌模块用户听歌 " + iF + " 首，服务器要求 " + f() + " 首。");
        }
        return g(i2, j, i3, iF < f() ? 1 : 0, str, i4, i5, pageKey);
    }
}
