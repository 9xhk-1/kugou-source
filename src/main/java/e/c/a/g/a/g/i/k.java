package e.c.a.g.a.g.i;

import androidx.core.app.NotificationCompat;
import com.kugou.common.network.ResponseTypeChecker;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    public int a;
    public int b;
    public List<Integer> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f852d;

    public class b extends h {
        public b() {
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("listid", k.this.f());
                jSONObject.put("list_ver", k.this.e());
                jSONObject.put("type", k.this.f852d);
                JSONArray jSONArray = new JSONArray();
                int size = k.this.c.size();
                for (int i2 = 0; i2 < size; i2++) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("fileid", ((Integer) k.this.c.get(i2)).intValue());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("data", jSONArray);
                if (g0.a) {
                    g0.b("zhpu_cloud", "delete songs request: " + jSONObject.toString());
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
            return e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.k1);
        }
    }

    public class c extends i<l> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f854e;

        public c(k kVar, String str, String str2) {
            super(str, str2);
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void getResponseData(l lVar) {
            if (this.f854e != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.f854e);
                    if (g0.a) {
                        g0.b("zhpu_cloud", "delete songs response: " + this.f854e);
                    }
                    if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS) == 1) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        lVar.f((short) 144);
                        lVar.j(jSONObject2.getLong("userid"));
                        int i2 = jSONObject2.getInt("listid");
                        int i3 = jSONObject2.getInt("count");
                        lVar.i(i2);
                        lVar.g(i3);
                        lVar.h(jSONObject2.getInt("list_ver"));
                        lVar.e(jSONObject2.getInt("pre_list_ver"));
                    }
                } catch (Exception e2) {
                    g0.k(e2);
                }
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
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            try {
                this.f854e = e.c.a.g.a.r.g.a.a(bArr, "utf-8", this.b, this.c);
            } catch (Exception unused) {
            }
        }
    }

    public k(long j, int i2, int i3, int i4) {
        this.c = null;
        this.a = i2;
        this.b = i3;
        this.f852d = i4;
        if (0 == 0) {
            this.c = new ArrayList(1);
        }
    }

    public l a() {
        b bVar = new b();
        c cVar = new c(this, bVar.c(), bVar.b());
        l lVar = new l();
        try {
            e.c.a.g.a.f.k.k.e.a().request(bVar, cVar);
        } catch (Exception e2) {
            g0.k(e2);
            bVar.g();
            try {
                e.c.a.g.a.f.k.k.e.a().request(bVar, cVar);
            } catch (Exception e3) {
                e3.printStackTrace();
                bVar.g();
            }
        }
        cVar.getResponseData(lVar);
        return lVar;
    }

    public boolean d(int i2) {
        if (this.c == null) {
            this.c = new ArrayList(1);
        }
        this.c.add(new Integer(i2));
        this.c.size();
        return true;
    }

    public int e() {
        return this.b;
    }

    public int f() {
        return this.a;
    }
}
