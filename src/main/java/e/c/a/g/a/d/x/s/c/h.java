package e.c.a.g.a.d.x.s.c;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.player.lyric.entity.LyricAuthorBean;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.networkutils.UrlEncoderUtil;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.q1;
import e.c.c.o.m;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public e.c.a.g.a.f.k.k.e a;
    public long b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f613g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f614h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f615i;
    public String j;
    public long k;
    public String l;
    public e.c.a.g.a.d.b.a o;
    public boolean c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f610d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f611e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f612f = false;
    public ArrayList<e.c.a.g.a.d.x.s.b.b> m = new ArrayList<>();
    public ArrayList<e.c.a.g.a.d.x.s.b.b> n = new ArrayList<>();
    public String p = null;

    public class a extends e.c.a.g.a.f.k.a {
        public a(boolean z) {
        }

        @Override // e.c.a.g.a.f.k.a
        public String getDefaultUrl() {
            return "https://gateway.kugou.com/lyrics/v1/search";
        }

        @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
        public String getGetRequestParams() {
            e.c.a.g.a.r.g.c cVarZ = e.c.a.g.a.r.g.c.z();
            cVarZ.f("appid");
            cVarZ.i("clientver");
            cVarZ.c("man", "no");
            cVarZ.c("keyword", h.this.f613g);
            cVarZ.c("duration", h.this.b <= 0 ? "0" : String.valueOf(h.this.b));
            cVarZ.c("hash", TextUtils.isEmpty(h.this.j) ? "" : h.this.j);
            cVarZ.c("album_audio_id", String.valueOf(h.this.k));
            cVarZ.c("lrctxt", "1");
            cVarZ.e("");
            Map<String, String> mapE = cVarZ.E();
            StringBuilder sb = new StringBuilder();
            sb.append("?");
            for (String str : mapE.keySet()) {
                sb.append(str);
                sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
                sb.append(UrlEncoderUtil.encode(mapE.get(str), "utf-8"));
                sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
        public Header[] getHttpHeaders() {
            return q1.a(new Header[]{new BasicHeader("clienttime", String.valueOf(System.currentTimeMillis() / 1000)), new BasicHeader("mid", m.l(KGApplication.getContext())), new BasicHeader("dfid", e.c.a.g.a.f.m.b.m().f()), new BasicHeader("uuid", e.c.a.g.a.s.m.h()), new BasicHeader("userid", String.valueOf(e.c.a.g.a.r.b.o())), new BasicHeader("token", String.valueOf(e.c.a.g.a.r.b.n()))});
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            return null;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "Lyric";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "GET";
        }

        @Override // e.c.a.g.a.f.k.a
        public ConfigKey getUrlConfigKey() {
            return e.c.a.g.a.f.e.b.X0;
        }
    }

    public class b extends e.c.a.g.a.f.k.k.a<Object> {
        public String a;

        public b() {
        }

        public final void a(JSONArray jSONArray, List<e.c.a.g.a.d.x.s.b.b> list, boolean z) throws JSONException {
            int length;
            if (jSONArray != null && (length = jSONArray.length()) > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    e.c.a.g.a.d.x.s.b.b bVar = new e.c.a.g.a.d.x.s.b.b();
                    bVar.p(z);
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String string = jSONObject.getString("id");
                    if (TextUtils.isEmpty(string) || string.equalsIgnoreCase("null")) {
                        bVar.k(-2147483648L);
                    } else {
                        bVar.k(Integer.valueOf(string).intValue());
                        String string2 = jSONObject.getString("uid");
                        if (!TextUtils.isEmpty(string2) && !string2.equalsIgnoreCase("null")) {
                            bVar.q(Long.valueOf(string2).longValue());
                        }
                        bVar.h(jSONObject.getString("singer"));
                        bVar.o(jSONObject.getString("song"));
                        bVar.g(jSONObject.getString("accesskey"));
                        bVar.n(jSONObject.getInt("adjust"));
                        bVar.i(jSONObject.optInt("contenttype", 0));
                        String string3 = jSONObject.getString("duration");
                        if (!TextUtils.isEmpty(string3) && !string3.equalsIgnoreCase("null")) {
                            bVar.m(Integer.valueOf(string3).intValue());
                        }
                        String string4 = jSONObject.getString("score");
                        if (!TextUtils.isEmpty(string4) && !string4.equalsIgnoreCase("null")) {
                            bVar.l(Integer.valueOf(string4).intValue());
                        }
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("parinfo");
                        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                            ArrayList<LyricAuthorBean> arrayList = new ArrayList<>();
                            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                                JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i3);
                                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() == 4) {
                                    LyricAuthorBean lyricAuthorBean = new LyricAuthorBean();
                                    String strOptString = jSONArrayOptJSONArray2.optString(0);
                                    String strOptString2 = jSONArrayOptJSONArray2.optString(1);
                                    String strOptString3 = jSONArrayOptJSONArray2.optString(2);
                                    String strOptString4 = jSONArrayOptJSONArray2.optString(3);
                                    if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3) && !TextUtils.isEmpty(strOptString4)) {
                                        lyricAuthorBean.a(strOptString2);
                                        lyricAuthorBean.d(strOptString);
                                        lyricAuthorBean.b(strOptString4);
                                        lyricAuthorBean.c(strOptString3);
                                        arrayList.add(lyricAuthorBean);
                                    }
                                }
                            }
                            bVar.j(arrayList);
                        }
                        list.add(bVar);
                    }
                }
            }
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
        public void getResponseData(Object obj) {
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
        public ResponseTypeChecker.ResponseType getResponseType() {
            return ResponseTypeChecker.ResponseType.JSON;
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.AbsHttpClient.IHttpException
        public void onContentException(int i2, String str, int i3, byte[] bArr) {
            h.this.f612f = true;
        }

        @Override // e.c.a.g.a.f.k.k.a
        public void onHandleApmData(e.c.a.g.a.d.b.a aVar) {
            h.this.o = aVar;
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.AbsHttpClient.IHttpException
        public void onHeaderException(int i2, String str, int i3, Header[] headerArr) {
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
        public void setContext(byte[] bArr) {
            try {
                String str = new String(bArr, "utf-8");
                this.a = str;
                h.this.l = str;
            } catch (UnsupportedEncodingException e2) {
                g0.k(e2);
                h.this.l = e2.getMessage();
            }
            String str2 = this.a;
            if (str2 == null || str2.length() <= 0) {
                h.this.p = "27";
                h.this.c = true;
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.a);
                String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_STATUS, "0");
                if (!"200".equals(strOptString)) {
                    h.this.p = strOptString;
                    h.this.c = true;
                }
                if (!"OK".equals(jSONObject.getString("info"))) {
                    h.this.c = true;
                }
                if (jSONObject.getInt("proposal") == 0) {
                    h.this.c = true;
                }
                if (jSONObject.optInt("ugc", 0) == 0) {
                    h.this.f610d = false;
                } else {
                    h.this.f610d = true;
                }
                h.this.f611e = jSONObject.optInt("ugccount", 0);
                if (!h.this.c || h.this.f610d) {
                    h.this.f614h = jSONObject.optString("companys");
                    h.this.f615i = jSONObject.optInt("has_complete_right", 0);
                    a(jSONObject.optJSONArray("candidates"), h.this.m, false);
                    a(jSONObject.optJSONArray("ugccandidates"), h.this.n, true);
                }
            } catch (Exception e3) {
                if (g0.a) {
                    g0.b("zwkk", "error:" + e3.getMessage());
                }
                h.this.c = true;
            }
        }
    }

    public h(String str, long j, String str2, long j2) {
        this.f613g = str;
        this.b = j;
        this.j = str2;
        this.k = j2;
        if (g0.a) {
            g0.c("lyric mix song id", "lyric mix song id lyric more option " + this.k);
        }
        this.a = e.c.a.g.a.f.k.k.e.a();
    }

    public ArrayList<e.c.a.g.a.d.x.s.b.b> r(boolean z) {
        try {
            this.a.request(new a(z), new b());
        } catch (Exception e2) {
            g0.k(e2);
            this.f612f = true;
        }
        return this.m;
    }

    public String s() {
        return this.p;
    }

    public String t() {
        return this.f614h;
    }

    public int u() {
        return this.f615i;
    }

    public e.c.a.g.a.d.b.a v() {
        return this.o;
    }

    public int w() {
        return this.f611e;
    }

    public boolean x() {
        return this.f610d;
    }

    public boolean y() {
        if (TextUtils.isEmpty(this.j)) {
            return true;
        }
        return this.f612f;
    }

    public boolean z() {
        return this.c;
    }
}
