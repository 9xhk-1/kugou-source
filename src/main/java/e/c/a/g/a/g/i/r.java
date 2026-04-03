package e.c.a.g.a.g.i;

import androidx.core.app.NotificationCompat;
import com.kugou.common.network.ResponseTypeChecker;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class r {
    public int a;
    public int b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f890e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f891f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<e.c.a.g.a.g.k.c.a> f892g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashMap<String, String> f893h;

    public class a extends h {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f894g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f895h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f896i = 1;
        public int j = 0;
        public int k;

        public a() {
            h();
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("listid", r.this.k());
                jSONObject.put("list_ver", r.this.j());
                jSONObject.put("type", r.this.f889d);
                JSONArray jSONArray = new JSONArray();
                if (r.this.f891f == 1) {
                    for (int i2 = this.f894g; i2 < this.f895h; i2++) {
                        j(i2, jSONArray);
                    }
                } else {
                    for (int i3 = this.f895h - 1; i3 >= this.f894g; i3--) {
                        j(i3, jSONArray);
                    }
                }
                jSONObject.put("data", jSONArray);
                if (g0.f()) {
                    g0.b("zhpu_cloud", "add song request:" + jSONObject.toString());
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
            return e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.j1);
        }

        public final void h() {
            int size = r.this.f892g.size();
            this.k = size;
            if (size % 300 == 0) {
                this.f896i = size / 300;
            } else {
                this.f896i = (size / 300) + 1;
            }
        }

        public boolean i() {
            int i2 = this.j;
            if (i2 >= this.f896i) {
                return false;
            }
            int i3 = i2 + 1;
            this.j = i3;
            this.f894g = (i3 - 1) * 300;
            int i4 = i3 * 300;
            this.f895h = i4;
            int i5 = this.k;
            if (i4 >= i5) {
                i4 = i5;
            }
            this.f895h = i4;
            return true;
        }

        public void j(int i2, JSONArray jSONArray) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("number", 1);
            e.c.a.g.a.g.k.c.a aVar = (e.c.a.g.a.g.k.c.a) r.this.f892g.get(i2);
            jSONObject.put("name", aVar.p());
            jSONObject.put("hash", aVar.n().toLowerCase());
            jSONObject.put("size", aVar.r());
            jSONObject.put("sort", aVar.q());
            jSONObject.put("timelen", aVar.s());
            jSONObject.put("bitrate", (int) aVar.m());
            jSONObject.put("album_id", aVar.a());
            jSONObject.put("mixsongid", aVar.f());
            jSONArray.put(jSONObject);
        }
    }

    public class b extends i<s> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f897e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f898f;

        public b(String str, String str2) {
            super(str, str2);
            this.f897e = null;
            this.f898f = -1;
        }

        public int c() {
            return this.f898f;
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void getResponseData(s sVar) {
            long j;
            boolean z;
            int i2 = 0;
            try {
                this.f851d = false;
                if (this.f897e == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(this.f897e);
                if (g0.a) {
                    g0.b("wwhSync", "add song response: " + this.f897e);
                }
                int i3 = 1;
                if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS) != 1) {
                    sVar.h(jSONObject.optInt("error_code"));
                    return;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                sVar.k((short) 144);
                sVar.o(jSONObject2.getLong("userid"));
                int i4 = jSONObject2.getInt("listid");
                int i5 = jSONObject2.getInt("count");
                sVar.n(i4);
                sVar.l(i5);
                sVar.m(jSONObject2.getInt("list_ver"));
                sVar.j(jSONObject2.getInt("pre_list_ver"));
                if (this.f898f == -1) {
                    this.f898f = sVar.c();
                }
                JSONArray jSONArray = jSONObject2.getJSONArray("info");
                int length = jSONArray.length();
                int i6 = 0;
                while (i6 < length) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i6);
                    int i7 = jSONObject3.getInt("fileid");
                    String string = jSONObject3.getString("name");
                    int i8 = jSONObject3.getInt("sort");
                    String string2 = jSONObject3.getString("hash");
                    String strOptString = jSONObject3.optString("album_id");
                    long jOptLong = jSONObject3.optLong("mixsongid", 0L);
                    if (r.this.f893h.containsKey(string2.toUpperCase())) {
                        j = 0;
                        z = true;
                    } else {
                        j = jOptLong;
                        z = false;
                    }
                    boolean z2 = jSONObject3.optInt("csong", i2) == i3;
                    String strOptString2 = jSONObject3.optString("album_name");
                    if (jSONObject3.optInt("code") == 205) {
                        r.this.c = HttpStatus.SC_RESET_CONTENT;
                    }
                    sVar.a(0, i7, string2, 0, 0, i8, (short) 0, string, 0, null, 0, 0, strOptString, j, z2, strOptString2, z);
                    i6++;
                    length = length;
                    jSONArray = jSONArray;
                    i3 = 1;
                    i2 = 0;
                }
                if (r.this.c == 205) {
                    sVar.i(r.this.c);
                }
                this.f851d = true;
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
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            try {
                this.f897e = e.c.a.g.a.r.g.a.a(bArr, "utf-8", this.b, this.c);
            } catch (Exception e2) {
                g0.k(e2);
            }
        }
    }

    public r(long j, int i2, int i3, int i4) {
        this.f892g = null;
        this.f893h = null;
        this.a = i2;
        this.b = i3;
        this.f889d = i4;
        this.f892g = new ArrayList(1);
        this.f893h = new HashMap<>();
    }

    public s a() {
        a aVar = new a();
        b bVar = new b(aVar.b, aVar.c);
        s sVar = new s();
        while (aVar.i()) {
            try {
                e.c.a.g.a.f.k.k.e.a().request(aVar, bVar);
                bVar.getResponseData(sVar);
            } catch (Exception e2) {
                g0.k(e2);
                sVar = null;
            }
        }
        if (sVar != null && bVar.b()) {
            sVar.j(bVar.c());
        }
        return sVar;
    }

    public boolean h(int i2, int i3, String str, int i4, int i5, int i6, short s, String str2, int i7, String str3, int i8, int i9, String str4, long j, boolean z) {
        if (this.f892g == null) {
            this.f892g = new ArrayList(1);
        }
        e.c.a.g.a.g.k.c.a aVar = new e.c.a.g.a.g.k.c.a(i2, i3, str, i4, i5, i6, s, str2, i7, str3, i8, i9, str4, j, z);
        if (j <= 0) {
            String upperCase = str.toUpperCase();
            this.f893h.put(upperCase, upperCase);
        }
        this.f892g.add(aVar);
        this.f890e = this.f892g.size();
        return true;
    }

    public int i() {
        return this.f890e;
    }

    public int j() {
        return this.b;
    }

    public int k() {
        return this.a;
    }

    public void l(int i2) {
        this.f891f = i2;
    }
}
