package e.c.a.g.a.g.i;

import androidx.core.app.NotificationCompat;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import e.c.a.g.a.s.g0;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class u {
    public boolean a = false;
    public StringBuilder b = new StringBuilder();

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
            if (u.this.b.length() != 0) {
                u.this.b.append(RetryStaticsLOG.MARK_END);
            }
            StringBuilder sb = u.this.b;
            sb.append(str);
            sb.append(",");
            sb.append(z ? "1" : "0");
        }
    }

    public class b extends h {
        public b(u uVar) {
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            return null;
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
            return e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.d1);
        }
    }

    public class c extends i<t> implements AbsHttpClient.IHttpProperty {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f909e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f910f;

        public c(String str, String str2) {
            super(str, str2);
            this.f909e = null;
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void getResponseData(t tVar) {
            try {
                tVar.g(this.f910f);
                if (g0.a) {
                    g0.c("wwhSync", "get version data :" + this.f909e);
                }
                if (this.f909e == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(this.f909e);
                if (!u.this.a) {
                    u.this.a = !jSONObject.has(NotificationCompat.CATEGORY_STATUS);
                }
                if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS) == 0) {
                    if (!u.this.a) {
                        u.this.a = jSONObject.optInt("error_code") == 0;
                    }
                    tVar.f(jSONObject.optInt("error_code"));
                    return;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                tVar.i((short) 144);
                tVar.l(jSONObject2.getLong("userid"));
                tVar.j(jSONObject2.getInt("list_count"));
                tVar.k(jSONObject2.getInt("total_ver"));
                JSONArray jSONArray = jSONObject2.getJSONArray("info");
                int iOptInt = jSONObject2.optInt("list_count_max", 1001);
                int iOptInt2 = jSONObject2.optInt("file_count_max", 1000);
                int iOptInt3 = jSONObject2.optInt("favourite_count_max", 10000);
                int iOptInt4 = jSONObject2.optInt("list_pagesize", 300);
                if (g0.a) {
                    g0.c("wwhCloudMax", "歌单数：" + iOptInt + "-歌单歌曲最大数：" + iOptInt2 + "-我喜欢歌单最大歌曲数：" + iOptInt3 + "-一页请求歌单数：" + iOptInt4);
                }
                e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
                cVar.g("cloud_playlist_max_count" + e.c.a.g.a.r.b.o(), iOptInt);
                cVar.g("cloud_playlist_max_music_count" + e.c.a.g.a.r.b.o(), iOptInt2);
                cVar.g("cloud_fav_playlist_max_music_count" + e.c.a.g.a.r.b.o(), iOptInt3);
                cVar.g("cloud_protocol_per_list_page_size" + e.c.a.g.a.r.b.o(), iOptInt4);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                    tVar.a(jSONObject3.getInt("listid"), jSONObject3.getInt("list_ver"));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                u.this.a = true;
                if (g0.a) {
                    g0.b("BLUE", "versionRequestor errorCode is " + tVar.b());
                }
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

        @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
        public boolean onContentType(String str) {
            return true;
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.AbsHttpClient.IHttpException
        public void onHeaderException(int i2, String str, int i3, Header[] headerArr) {
        }

        @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
        public boolean onHeaders(Header[] headerArr) {
            return true;
        }

        @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
        public boolean onResponseCode(int i2) {
            this.f910f = i2;
            return true;
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        public void setContext(byte[] bArr) {
            try {
                this.f909e = a(bArr);
            } catch (Exception e2) {
                u.this.a = true;
                g0.k(e2);
            }
        }
    }

    public u(long j, String str) {
    }

    public t a() {
        b bVar = new b(this);
        c cVar = new c(bVar.b, bVar.c);
        t tVar = new t();
        a aVar = new a();
        try {
            e.c.a.g.a.f.k.k.e eVarA = e.c.a.g.a.f.k.k.e.a();
            eVarA.setRequestUrlReceiver(aVar);
            eVarA.request(bVar, cVar);
            if (g0.a) {
                g0.b("zkzhou", "手机网络歌曲收藏");
            }
            tVar.e(eVarA.getRequestDelay());
        } catch (Exception e2) {
            bVar.g();
            g0.k(e2);
            try {
                e.c.a.g.a.f.k.k.e eVarA2 = e.c.a.g.a.f.k.k.e.a();
                eVarA2.setRequestUrlReceiver(aVar);
                eVarA2.request(bVar, cVar);
                tVar.e(eVarA2.getRequestDelay());
            } catch (Exception e3) {
                bVar.g();
                g0.k(e2);
                int iC = e.c.a.g.a.f.k.k.f.c(e2);
                if (iC == 1000200) {
                    this.a = true;
                }
                tVar.f(iC);
                if (g0.a) {
                    g0.c("cloudsyncapm", "eid=" + iC + "terrMsg=" + e3.getMessage());
                }
            }
        }
        tVar.h(aVar.getRequestUrl(null));
        cVar.getResponseData(tVar);
        if (this.a) {
            this.a = false;
        }
        return tVar;
    }

    public String e() {
        return this.b.toString();
    }
}
