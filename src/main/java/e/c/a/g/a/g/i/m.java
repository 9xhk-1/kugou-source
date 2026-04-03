package e.c.a.g.a.g.i;

import androidx.core.app.NotificationCompat;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import com.kugou.uilib.widget.textview.span.TopicHighlightHelper;
import e.c.a.g.a.s.g0;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    public long a;
    public int b;
    public boolean c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StringBuilder f856d = new StringBuilder();

    public class a implements AbsHttpClient.IRequestUrlReceiver {
        public String a = null;

        public a() {
        }

        @Override // com.kugou.common.network.AbsHttpClient.IRequestUrlReceiver
        public String getRequestUrl(String str) {
            return this.a;
        }

        @Override // com.kugou.common.network.AbsHttpClient.IRequestUrlReceiver
        public void onHttpGet(String str) {
            this.a = str;
        }

        @Override // com.kugou.common.network.AbsHttpClient.IRequestUrlReceiver
        public void onHttpPost(String str) {
            this.a = str;
        }

        @Override // com.kugou.common.network.AbsHttpClient.IRequestUrlReceiver
        public void onUrlState(String str, boolean z) {
            if (m.this.f856d.length() != 0) {
                m.this.f856d.append(RetryStaticsLOG.MARK_END);
            }
            StringBuilder sb = m.this.f856d;
            sb.append(str);
            sb.append(",");
            sb.append(z ? "1" : "0");
        }
    }

    public class b extends h {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f857g = 1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f858h;

        public b() {
            this.f858h = 300;
            this.f858h = 100;
        }

        @Override // e.c.a.g.a.g.i.h
        public long e() {
            return m.this.a;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", m.this.b);
                jSONObject.put("page", this.f857g);
                jSONObject.put("pagesize", this.f858h);
                if (e.c.a.g.a.r.b.o() != e()) {
                    jSONObject.put("userid", e());
                }
                byte[] bArrC = e.c.a.g.a.r.g.a.c(jSONObject.toString(), "UTF-8", this.b, this.c);
                ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(16);
                byteArrayBuffer.append(bArrC, 0, bArrC.length);
                return new ByteArrayEntity(byteArrayBuffer.toByteArray());
            } catch (Exception e2) {
                if (!g0.f()) {
                    return null;
                }
                g0.k(e2);
                return null;
            }
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "CloudMusic";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "POST";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getUrl() {
            return e.c.a.g.a.r.b.o() == e() ? e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.g1) : e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.h1);
        }

        public void h() {
            this.f857g++;
        }
    }

    public class c extends i<p> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f860e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f861f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f862g;

        public c(String str, String str2) {
            super(str, str2);
            this.f860e = "all_list";
            this.f861f = null;
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void getResponseData(p pVar) {
            int i2 = 0;
            this.f851d = false;
            try {
                if (g0.a) {
                    g0.c("wwhSync", "get list data :" + this.f861f);
                }
                if (this.f861f == null) {
                    return;
                }
                boolean z = g0.a;
                JSONObject jSONObject = new JSONObject(this.f861f);
                if (!m.this.c) {
                    m.this.c = !jSONObject.has(NotificationCompat.CATEGORY_STATUS);
                }
                if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS) != 1) {
                    if (!m.this.c) {
                        m.this.c = jSONObject.optInt("error_code") == 0;
                    }
                    pVar.g(jSONObject.optInt("error_code"));
                    if (g0.a) {
                        g0.e("CloudMusicGetLMRequestor", this.f861f);
                        return;
                    }
                    return;
                }
                if (g0.a) {
                    g0.b("zhpu_cloud_get_all", "get all list: " + this.f861f);
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                pVar.h((short) 144);
                pVar.k(jSONObject2.getLong("userid"));
                pVar.i(jSONObject2.getInt("list_count"));
                pVar.j(jSONObject2.getInt("total_ver"));
                JSONArray jSONArray = jSONObject2.getJSONArray("info");
                int length = jSONArray.length();
                JSONArray jSONArray2 = new JSONArray();
                int i3 = 0;
                while (i3 < length) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                    o oVar = new o();
                    oVar.H(i2);
                    int i4 = jSONObject3.getInt("listid");
                    int i5 = jSONObject3.getInt("count");
                    String string = jSONObject3.getString("name");
                    oVar.E(i4);
                    int i6 = jSONObject3.getInt("list_ver");
                    oVar.C(i6);
                    oVar.G(jSONObject3.getInt("sort"));
                    oVar.D(i5);
                    int i7 = jSONObject3.getInt("type");
                    oVar.q(i7);
                    oVar.F(string);
                    JSONArray jSONArray3 = jSONArray;
                    oVar.A(jSONObject3.optInt("source"));
                    oVar.w(jSONObject3.optString("pic"));
                    oVar.r(jSONObject3.optInt("list_create_listid"));
                    int i8 = length;
                    oVar.s(jSONObject3.optLong("list_create_userid"));
                    oVar.t(jSONObject3.optString("list_create_username"));
                    oVar.o(jSONObject3.optString("intro"));
                    oVar.B(jSONObject3.optString("tags"));
                    oVar.x(jSONObject3.optInt("radio_id"));
                    oVar.y(jSONObject3.optInt("radio_status"));
                    oVar.z(jSONObject3.optInt("radio_type"));
                    oVar.u(jSONObject3.optInt("musiclib_id"));
                    oVar.n(jSONObject3.optInt("ifpublish"));
                    oVar.p(jSONObject3.optInt("is_featured", 0) == 1);
                    oVar.m(jSONObject3.optString("list_create_gid"));
                    oVar.v(jSONObject3.optString("global_collection_id"));
                    oVar.l(jSONObject3.optInt("is_custom_pic") == 1);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("listid", i4);
                    jSONObject4.put("count", i5);
                    jSONObject4.put(ClientCookie.VERSION_ATTR, i6);
                    jSONObject4.put("type", this.f860e);
                    JSONArray jSONArray4 = jSONArray2;
                    jSONObject4.put("time", System.currentTimeMillis());
                    jSONArray4.put(jSONObject4);
                    if (e.c.a.g.a.r.b.o() == pVar.c() && string.equals("我喜欢") && i7 == 0) {
                        j.b(e.c.a.g.a.r.b.o(), i4);
                        j.a(e.c.a.g.a.r.b.o(), i5);
                    }
                    pVar.a(oVar);
                    i3++;
                    jSONArray2 = jSONArray4;
                    jSONArray = jSONArray3;
                    length = i8;
                    i2 = 0;
                }
                int i9 = length;
                e.c.a.g.a.r.b.o();
                pVar.c();
                this.f851d = i9 > 0;
            } catch (Exception e2) {
                g0.k(e2);
            }
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        public ResponseTypeChecker.ResponseType getResponseType() {
            return ResponseTypeChecker.ResponseType.NOT_EMPTY;
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.AbsHttpClient.IHttpException
        public void onContentException(int i2, String str, int i3, byte[] bArr) {
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.AbsHttpClient.IHttpException
        public void onHeaderException(int i2, String str, int i3, Header[] headerArr) {
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        public void setContext(byte[] bArr) {
            try {
                this.f861f = a(bArr);
            } catch (Exception e2) {
                m.this.c = true;
                g0.k(e2);
            }
        }
    }

    public m(long j, int i2, int i3, int i4) {
        this.b = 2;
        this.a = j;
        this.b = i4;
    }

    public p a() {
        e.c.a.g.a.f.k.k.e eVarA;
        e.c.a.g.a.f.k.k.e eVarA2;
        Exception e2;
        e.c.a.g.a.f.k.k.e eVarA3;
        e.c.a.g.a.f.k.k.e eVarA4;
        a aVar = new a();
        b bVar = new b();
        c cVar = new c(bVar.b, bVar.c);
        p pVar = new p();
        try {
            eVarA3 = e.c.a.g.a.f.k.k.e.a();
            eVarA3.setRequestUrlReceiver(aVar);
            eVarA3.request(bVar, cVar);
            cVar.getResponseData(pVar);
            while (true) {
                try {
                    if (pVar.e() <= pVar.f().size()) {
                        break;
                    }
                    bVar.h();
                    eVarA = e.c.a.g.a.f.k.k.e.a();
                    eVarA.request(bVar, cVar);
                    cVar.getResponseData(pVar);
                    try {
                        if (!cVar.b()) {
                            eVarA3 = eVarA;
                            break;
                        }
                        eVarA3 = eVarA;
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        bVar.g();
                        g0.k(e);
                        try {
                            eVarA2 = e.c.a.g.a.f.k.k.e.a();
                            eVarA2.setRequestUrlReceiver(aVar);
                            eVarA2.request(bVar, cVar);
                            cVar.getResponseData(pVar);
                            while (pVar.e() > pVar.f().size()) {
                                try {
                                    bVar.h();
                                    eVarA4 = e.c.a.g.a.f.k.k.e.a();
                                    eVarA4.request(bVar, cVar);
                                    cVar.getResponseData(pVar);
                                } catch (Exception e4) {
                                    e2 = e4;
                                }
                                try {
                                    if (!cVar.b()) {
                                        eVarA3 = eVarA4;
                                        break;
                                    }
                                    eVarA2 = eVarA4;
                                } catch (Exception e5) {
                                    e2 = e5;
                                    eVarA2 = eVarA4;
                                    e2.printStackTrace();
                                    bVar.g();
                                    g0.k(e);
                                    pVar.g(e.c.a.g.a.f.k.k.f.c(e));
                                    pVar = null;
                                    eVarA3 = eVarA2;
                                }
                            }
                        } catch (Exception e6) {
                            eVarA2 = eVarA;
                            e2 = e6;
                        }
                        eVarA3 = eVarA2;
                    }
                } catch (Exception e7) {
                    eVarA = eVarA3;
                    e = e7;
                }
            }
        } catch (Exception e8) {
            e = e8;
            eVarA = null;
        }
        if (this.c) {
            if (eVarA3 != null) {
                StringBuilder sb = new StringBuilder(eVarA3.getCurServerIp());
                sb.append(TopicHighlightHelper.SHARP);
                sb.append(bVar.f850f);
                sb.append(TopicHighlightHelper.SHARP);
                sb.append(cVar.f862g);
                sb.append(TopicHighlightHelper.SHARP);
                String str = cVar.f861f;
                sb.append(str == null ? -1 : str.length());
                sb.append(TopicHighlightHelper.SHARP);
                String str2 = cVar.f861f;
                sb.append(str2 == null ? "空" : "".equals(str2) ? "空字符串" : cVar.f861f);
            }
            this.c = false;
        }
        return pVar;
    }

    public void g(String str) {
        this.f856d.append(str);
    }
}
