package e.c.a.g.a.h;

import android.content.Context;
import android.text.TextUtils;
import com.kugou.android.watch.lite.guessyoulike.GuessYouLikeHelper;
import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.protocol.AbstractRequestPackage;
import e.c.a.g.a.s.e0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.s;
import e.c.a.g.a.s.x0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public String a;
    public JSONArray b;
    public JSONArray c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONArray f1064d;

    public class a extends e.c.a.g.a.r.e.a<i> {
        public int b;
        public boolean c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public e.c.a.g.a.d.b.a f1065d;

        public a(int i2) {
            this.b = i2;
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void getResponseData(i iVar) {
            g.this.f(this.a, iVar, this.b, this.c);
        }

        public void b(boolean z) {
            this.c = z;
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        public ResponseTypeChecker.ResponseType getResponseType() {
            return ResponseTypeChecker.ResponseType.JSON;
        }
    }

    public class b extends AbstractRequestPackage {
        public JSONObject a;

        public b(g gVar, JSONObject jSONObject) {
            this.a = jSONObject;
            e.c.a.d.a aVar = new e.c.a.d.a(jSONObject.toString(), new HashMap(), true);
            aVar.b();
            Hashtable<String, Object> hashtable = new Hashtable<>();
            this.mParams = hashtable;
            hashtable.putAll(aVar.a());
        }

        @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
        public String getGetRequestParams() {
            return super.getGetRequestParams();
        }

        @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
        public Header[] getHttpHeaders() {
            if (!e.c.a.g.a.r.b.F()) {
                return super.getHttpHeaders();
            }
            return new Header[]{new BasicHeader("KG-FAKE", e.c.a.g.a.r.b.o() + "")};
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v4, types: [org.apache.http.HttpEntity] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v6, types: [org.apache.http.entity.AbstractHttpEntity, org.apache.http.entity.ByteArrayEntity] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            ?? byteArrayEntity;
            Exception e2;
            ?? r0 = 0;
            ?? r02 = 0;
            try {
                try {
                    byteArrayEntity = new ByteArrayEntity(s.a(this.a.toString(), "UTF-8"));
                    try {
                        byteArrayEntity.setContentEncoding("gzip");
                        r0 = "gzip";
                        byteArrayEntity = byteArrayEntity;
                    } catch (IOException unused) {
                        r02 = byteArrayEntity;
                        r0 = r02;
                        byteArrayEntity = new ByteArrayEntity(this.a.toString().getBytes());
                    } catch (Exception e3) {
                        e2 = e3;
                        g0.k(e2);
                        return byteArrayEntity;
                    }
                } catch (IOException unused2) {
                }
            } catch (Exception e4) {
                byteArrayEntity = r0;
                e2 = e4;
            }
            return byteArrayEntity;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return b.class.getSimpleName();
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "POST";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getUrl() {
            String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.N0);
            return TextUtils.isEmpty(config) ? "https://gateway.kugou.com/persnfm.service/v2/personal_recommend" : config;
        }
    }

    public g(Context context, String str) {
        this.a = str;
    }

    public JSONObject b(l lVar, boolean z) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        JSONObject jSONObjectE = e(lVar, z);
        if (jSONObjectE != null) {
            try {
                jSONObjectE.put("recommend_source_locked", e.c.a.g.a.f.m.c.a.e("KEY_ENABLE_PERSONALITY_REC", false) ? "1" : "0");
            } catch (JSONException e2) {
                g0.k(e2);
            }
        }
        if (jSONObjectE != null && (jSONArray3 = this.b) != null && jSONArray3.length() > 0) {
            try {
                jSONObjectE.put("client_playlist", this.b);
            } catch (JSONException e3) {
                g0.k(e3);
            }
        }
        if (jSONObjectE != null && (jSONArray2 = this.c) != null) {
            try {
                jSONObjectE.put("recommend_source", jSONArray2);
            } catch (JSONException e4) {
                g0.k(e4);
            }
        }
        if (jSONObjectE != null && (jSONArray = this.f1064d) != null && jSONArray.length() > 0) {
            try {
                jSONObjectE.put("black_singerid", this.f1064d);
            } catch (JSONException e5) {
                g0.k(e5);
            }
        }
        return jSONObjectE;
    }

    public i c(l lVar) {
        return d(lVar, false);
    }

    public i d(l lVar, boolean z) {
        i iVar = new i();
        if (lVar == null) {
            return iVar;
        }
        b bVar = new b(this, b(lVar, z));
        a aVar = new a(lVar.o);
        aVar.b(z);
        try {
            e.c.a.g.a.f.k.k.e.a().request(bVar, aVar);
            aVar.getResponseData(iVar);
        } catch (Exception e2) {
            g0.k(e2);
        }
        if (aVar.f1065d != null && bVar.getPostRequestEntity() != null) {
            aVar.f1065d.j(bVar.getPostRequestEntity().getContentLength());
        }
        iVar.f1072i = aVar;
        return iVar;
    }

    public JSONObject e(l lVar, boolean z) {
        if (lVar == null) {
            return null;
        }
        Hashtable<String, Object> hashtableH = GuessYouLikeHelper.h();
        hashtableH.put("action", lVar.a);
        hashtableH.put("playlist_ver", 2);
        hashtableH.put("mark_list", lVar.c);
        hashtableH.put("hash_like_list", lVar.f1086g);
        hashtableH.put("callerid", z ? "1" : "0");
        e.c.a.g.a.g.e.d dVar = e.c.a.g.a.g.e.d.a;
        if (dVar.k()) {
            hashtableH.put("age_group", "" + dVar.f());
        }
        hashtableH.put("song_pool_id", Integer.valueOf(e.c.a.g.a.r.b.l()));
        hashtableH.put("mode", h.c(lVar.o));
        if (lVar.b == 1) {
            hashtableH.put("is_channel", 1);
        }
        hashtableH.put("active_swtich", e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.S0) ? "on" : "off");
        x0.a(hashtableH);
        if ("login".equals(lVar.a)) {
            long j = lVar.n;
            if (j > 0) {
                hashtableH.put("new_sync_point", Long.valueOf(j));
            }
            if (!TextUtils.isEmpty(lVar.c())) {
                hashtableH.put("hash", lVar.c());
            }
        }
        if (lVar.b() != null) {
            hashtableH.put("fix_playlist", lVar.b());
        }
        if ("play".equals(lVar.a)) {
            String str = lVar.f1087h;
            hashtableH.put("songid", str != null ? str : "");
            hashtableH.put("hash", lVar.c());
            hashtableH.put("cur_mark", lVar.a());
            hashtableH.put("playtime", Long.valueOf(lVar.f1085f));
            hashtableH.put("is_overplay", Integer.valueOf(lVar.f1084e));
            hashtableH.put("remain_songcnt", Integer.valueOf(lVar.j));
        } else if ("click_red".equals(lVar.a) || "cancel_red".equals(lVar.a) || "garbage".equals(lVar.a) || "download".equals(lVar.a) || "black_singer".equals(lVar.a) || "cancel_black_singer".equals(lVar.a) || "update_recommend_source".equals(lVar.a) || "cancel_garbage".equals(lVar.a) || "change_song_pool".equals(lVar.a)) {
            String str2 = lVar.f1087h;
            hashtableH.put("songid", str2 != null ? str2 : "");
            hashtableH.put("hash", lVar.c());
            hashtableH.put("cur_mark", lVar.a());
            hashtableH.put("playtime", Long.valueOf(lVar.f1085f));
            hashtableH.put("remain_songcnt", Integer.valueOf(lVar.j));
            if ("black_singer".equals(lVar.a) || "cancel_black_singer".equals(lVar.a)) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(lVar.l[0].b());
                hashtableH.put("black_singerid", jSONArray);
            }
        }
        hashtableH.put("rec_vip_info", GuessYouLikeHelper.d());
        return e0.b(hashtableH);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x03fc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x026b A[Catch: JSONException -> 0x046b, TryCatch #0 {JSONException -> 0x046b, blocks: (B:10:0x0035, B:13:0x0057, B:15:0x005b, B:17:0x0072, B:19:0x0078, B:21:0x007e, B:23:0x0084, B:27:0x00a9, B:28:0x00d2, B:30:0x00d8, B:32:0x00f4, B:33:0x00fb, B:35:0x010e, B:37:0x0111, B:39:0x0119, B:41:0x0122, B:44:0x0137, B:46:0x021a, B:48:0x0220, B:49:0x0227, B:51:0x022d, B:52:0x0252, B:54:0x025a, B:56:0x026b, B:58:0x0280, B:59:0x0293, B:61:0x029b, B:65:0x02a7, B:67:0x02b7, B:69:0x02d6, B:78:0x02ea, B:79:0x02f5, B:81:0x02fe, B:82:0x0322, B:84:0x0344, B:85:0x036a, B:87:0x0373, B:89:0x0379, B:90:0x0380, B:92:0x0386, B:94:0x038c, B:96:0x0396, B:100:0x03ef, B:101:0x03fc, B:43:0x012e, B:102:0x040b, B:104:0x0423, B:105:0x0448, B:107:0x044d, B:108:0x0452), top: B:113:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0280 A[Catch: JSONException -> 0x046b, TryCatch #0 {JSONException -> 0x046b, blocks: (B:10:0x0035, B:13:0x0057, B:15:0x005b, B:17:0x0072, B:19:0x0078, B:21:0x007e, B:23:0x0084, B:27:0x00a9, B:28:0x00d2, B:30:0x00d8, B:32:0x00f4, B:33:0x00fb, B:35:0x010e, B:37:0x0111, B:39:0x0119, B:41:0x0122, B:44:0x0137, B:46:0x021a, B:48:0x0220, B:49:0x0227, B:51:0x022d, B:52:0x0252, B:54:0x025a, B:56:0x026b, B:58:0x0280, B:59:0x0293, B:61:0x029b, B:65:0x02a7, B:67:0x02b7, B:69:0x02d6, B:78:0x02ea, B:79:0x02f5, B:81:0x02fe, B:82:0x0322, B:84:0x0344, B:85:0x036a, B:87:0x0373, B:89:0x0379, B:90:0x0380, B:92:0x0386, B:94:0x038c, B:96:0x0396, B:100:0x03ef, B:101:0x03fc, B:43:0x012e, B:102:0x040b, B:104:0x0423, B:105:0x0448, B:107:0x044d, B:108:0x0452), top: B:113:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x029b A[Catch: JSONException -> 0x046b, TryCatch #0 {JSONException -> 0x046b, blocks: (B:10:0x0035, B:13:0x0057, B:15:0x005b, B:17:0x0072, B:19:0x0078, B:21:0x007e, B:23:0x0084, B:27:0x00a9, B:28:0x00d2, B:30:0x00d8, B:32:0x00f4, B:33:0x00fb, B:35:0x010e, B:37:0x0111, B:39:0x0119, B:41:0x0122, B:44:0x0137, B:46:0x021a, B:48:0x0220, B:49:0x0227, B:51:0x022d, B:52:0x0252, B:54:0x025a, B:56:0x026b, B:58:0x0280, B:59:0x0293, B:61:0x029b, B:65:0x02a7, B:67:0x02b7, B:69:0x02d6, B:78:0x02ea, B:79:0x02f5, B:81:0x02fe, B:82:0x0322, B:84:0x0344, B:85:0x036a, B:87:0x0373, B:89:0x0379, B:90:0x0380, B:92:0x0386, B:94:0x038c, B:96:0x0396, B:100:0x03ef, B:101:0x03fc, B:43:0x012e, B:102:0x040b, B:104:0x0423, B:105:0x0448, B:107:0x044d, B:108:0x0452), top: B:113:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02a7 A[Catch: JSONException -> 0x046b, TryCatch #0 {JSONException -> 0x046b, blocks: (B:10:0x0035, B:13:0x0057, B:15:0x005b, B:17:0x0072, B:19:0x0078, B:21:0x007e, B:23:0x0084, B:27:0x00a9, B:28:0x00d2, B:30:0x00d8, B:32:0x00f4, B:33:0x00fb, B:35:0x010e, B:37:0x0111, B:39:0x0119, B:41:0x0122, B:44:0x0137, B:46:0x021a, B:48:0x0220, B:49:0x0227, B:51:0x022d, B:52:0x0252, B:54:0x025a, B:56:0x026b, B:58:0x0280, B:59:0x0293, B:61:0x029b, B:65:0x02a7, B:67:0x02b7, B:69:0x02d6, B:78:0x02ea, B:79:0x02f5, B:81:0x02fe, B:82:0x0322, B:84:0x0344, B:85:0x036a, B:87:0x0373, B:89:0x0379, B:90:0x0380, B:92:0x0386, B:94:0x038c, B:96:0x0396, B:100:0x03ef, B:101:0x03fc, B:43:0x012e, B:102:0x040b, B:104:0x0423, B:105:0x0448, B:107:0x044d, B:108:0x0452), top: B:113:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02fe A[Catch: JSONException -> 0x046b, TryCatch #0 {JSONException -> 0x046b, blocks: (B:10:0x0035, B:13:0x0057, B:15:0x005b, B:17:0x0072, B:19:0x0078, B:21:0x007e, B:23:0x0084, B:27:0x00a9, B:28:0x00d2, B:30:0x00d8, B:32:0x00f4, B:33:0x00fb, B:35:0x010e, B:37:0x0111, B:39:0x0119, B:41:0x0122, B:44:0x0137, B:46:0x021a, B:48:0x0220, B:49:0x0227, B:51:0x022d, B:52:0x0252, B:54:0x025a, B:56:0x026b, B:58:0x0280, B:59:0x0293, B:61:0x029b, B:65:0x02a7, B:67:0x02b7, B:69:0x02d6, B:78:0x02ea, B:79:0x02f5, B:81:0x02fe, B:82:0x0322, B:84:0x0344, B:85:0x036a, B:87:0x0373, B:89:0x0379, B:90:0x0380, B:92:0x0386, B:94:0x038c, B:96:0x0396, B:100:0x03ef, B:101:0x03fc, B:43:0x012e, B:102:0x040b, B:104:0x0423, B:105:0x0448, B:107:0x044d, B:108:0x0452), top: B:113:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0344 A[Catch: JSONException -> 0x046b, TryCatch #0 {JSONException -> 0x046b, blocks: (B:10:0x0035, B:13:0x0057, B:15:0x005b, B:17:0x0072, B:19:0x0078, B:21:0x007e, B:23:0x0084, B:27:0x00a9, B:28:0x00d2, B:30:0x00d8, B:32:0x00f4, B:33:0x00fb, B:35:0x010e, B:37:0x0111, B:39:0x0119, B:41:0x0122, B:44:0x0137, B:46:0x021a, B:48:0x0220, B:49:0x0227, B:51:0x022d, B:52:0x0252, B:54:0x025a, B:56:0x026b, B:58:0x0280, B:59:0x0293, B:61:0x029b, B:65:0x02a7, B:67:0x02b7, B:69:0x02d6, B:78:0x02ea, B:79:0x02f5, B:81:0x02fe, B:82:0x0322, B:84:0x0344, B:85:0x036a, B:87:0x0373, B:89:0x0379, B:90:0x0380, B:92:0x0386, B:94:0x038c, B:96:0x0396, B:100:0x03ef, B:101:0x03fc, B:43:0x012e, B:102:0x040b, B:104:0x0423, B:105:0x0448, B:107:0x044d, B:108:0x0452), top: B:113:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0386 A[Catch: JSONException -> 0x046b, TryCatch #0 {JSONException -> 0x046b, blocks: (B:10:0x0035, B:13:0x0057, B:15:0x005b, B:17:0x0072, B:19:0x0078, B:21:0x007e, B:23:0x0084, B:27:0x00a9, B:28:0x00d2, B:30:0x00d8, B:32:0x00f4, B:33:0x00fb, B:35:0x010e, B:37:0x0111, B:39:0x0119, B:41:0x0122, B:44:0x0137, B:46:0x021a, B:48:0x0220, B:49:0x0227, B:51:0x022d, B:52:0x0252, B:54:0x025a, B:56:0x026b, B:58:0x0280, B:59:0x0293, B:61:0x029b, B:65:0x02a7, B:67:0x02b7, B:69:0x02d6, B:78:0x02ea, B:79:0x02f5, B:81:0x02fe, B:82:0x0322, B:84:0x0344, B:85:0x036a, B:87:0x0373, B:89:0x0379, B:90:0x0380, B:92:0x0386, B:94:0x038c, B:96:0x0396, B:100:0x03ef, B:101:0x03fc, B:43:0x012e, B:102:0x040b, B:104:0x0423, B:105:0x0448, B:107:0x044d, B:108:0x0452), top: B:113:0x0035 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(java.lang.String r23, e.c.a.g.a.h.i r24, int r25, boolean r26) {
        /*
            Method dump skipped, instruction units count: 1136
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.h.g.f(java.lang.String, e.c.a.g.a.h.i, int, boolean):void");
    }
}
