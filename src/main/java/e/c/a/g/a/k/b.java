package e.c.a.g.a.k;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.network.ackutils.StringResponsePackage;
import e.c.a.g.a.f.j.a.e;
import e.c.a.g.a.f.j.c.d;
import e.c.a.g.a.f.k.f;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.r0;
import java.util.ArrayList;
import java.util.Hashtable;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static volatile b b;
    public String a;

    public class a extends e.c.a.g.a.f.k.a {
        public String a;

        public a(b bVar, String str) {
            this.a = str;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            return null;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return this.a;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "GET";
        }

        @Override // e.c.a.g.a.f.k.a
        public ConfigKey getUrlConfigKey() {
            if (g0.a) {
                g0.b("wufuqin", "getUrlConfigKey: " + e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.a0));
            }
            return e.c.a.g.a.f.e.b.a0;
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.k.b$b, reason: collision with other inner class name */
    public class C0167b extends StringResponsePackage<e.c.a.g.a.l.b> {
        public C0167b() {
        }

        @Override // com.kugou.common.network.ackutils.StringResponsePackage, com.kugou.common.network.protocol.ResponsePackage
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void getResponseData(e.c.a.g.a.l.b bVar) {
            String str;
            String str2;
            C0167b c0167b = this;
            String str3 = "privilege_high";
            String str4 = "eaway";
            if (TextUtils.isEmpty(c0167b.mJsonString)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(c0167b.mJsonString);
                int i2 = jSONObject.getInt(NotificationCompat.CATEGORY_STATUS);
                bVar.n(jSONObject.getInt(NotificationCompat.CATEGORY_STATUS));
                bVar.h(jSONObject.optInt("error_code"));
                bVar.i(jSONObject.optString("error_msg"));
                if (i2 == 0) {
                    return;
                }
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                ArrayList<KGSong> arrayList = new ArrayList<>(0);
                try {
                    bVar.k(jSONObject.getInt("total"));
                    if (g0.a) {
                        g0.b("wufuqin", "getResponseData: total2= " + jSONObject.getInt("total"));
                    }
                } catch (Exception unused) {
                }
                int length = jSONArray.length();
                if (g0.a) {
                    g0.b("wufuqin", "getResponseData: " + length);
                }
                if (length > 0) {
                    int i3 = 0;
                    while (i3 < length) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        if (jSONObject2 != null && jSONObject2.has("filename")) {
                            KGSong kGSong = new KGSong(b.this.a);
                            kGSong.A4("5");
                            String string = jSONObject2.getString("filename");
                            h1.w(string);
                            e eVarR = h1.r(string);
                            kGSong.e3(eVarR.a());
                            kGSong.t3(eVarR.a());
                            kGSong.o4(jSONObject2.getLong("filesize"));
                            kGSong.B3(jSONObject2.getString("hash"));
                            kGSong.A3(300);
                            kGSong.X2(jSONObject2.getInt("bitrate"));
                            kGSong.j3(jSONObject2.getString("extname"));
                            kGSong.X3(jSONObject2.optString("video_hash"));
                            kGSong.C3(jSONObject2.optString("hash_320"));
                            kGSong.p4(jSONObject2.optInt("filesize_320"));
                            kGSong.C4(jSONObject2.optString("sqhash"));
                            kGSong.D4(jSONObject2.optInt("sqfilesize"));
                            JSONArray jSONArray2 = jSONObject2.getJSONArray("remarks");
                            if (jSONArray2.length() > 0) {
                                kGSong.j4(jSONArray2.getJSONObject(0).optString("remark"));
                            }
                            kGSong.R2(kGSong.h1());
                            kGSong.o3(jSONObject2.optInt("feetype"));
                            kGSong.w4(jSONObject2.optString("addtime"));
                            kGSong.R2(kGSong.h1());
                            try {
                                kGSong.S3(jSONObject2.getInt("privilege"), jSONObject2.getInt("privilege_320"), jSONObject2.getInt(str3));
                                if (g0.a) {
                                    g0.e(str4, "privilege:" + jSONObject2.getInt("privilege") + "320privilege:" + jSONObject2.getInt("privilege_320") + "sqprivilege:" + jSONObject2.getInt(str3));
                                }
                            } catch (Exception unused2) {
                                if (g0.a) {
                                    g0.e(str4, "privilege: RankingSongListProtocol");
                                }
                            }
                            kGSong.M4(1);
                            kGSong.n3(jSONObject2.optString("album_id"));
                            r0.i(jSONObject2, kGSong);
                            str = str3;
                            str2 = str4;
                            kGSong.Q3(jSONObject2.optLong("album_audio_id", 0L));
                            int iOptInt = jSONObject2.optInt("buy_count", 0);
                            if (iOptInt < 0) {
                                iOptInt = 0;
                            }
                            kGSong.Z2(iOptInt);
                            try {
                                if (jSONObject2.optInt("inlist") == 0) {
                                    kGSong.G3(-1);
                                } else {
                                    kGSong.G3(1);
                                }
                            } catch (Exception e2) {
                                g0.k(e2);
                            }
                            kGSong.U3(jSONObject2.optString("rp_type"));
                            kGSong.m3(jSONObject2.optInt("fail_process", 0));
                            kGSong.e4(jSONObject2.optInt("pay_type", 0));
                            kGSong.b4(jSONObject2.optInt("old_cpy", -1));
                            kGSong.O4(l1.b());
                            kGSong.c3(jSONObject2.optString("album_sizable_cover"));
                            if (g0.a) {
                                g0.e("ranklist", "cwt log 是否在版权列表中：" + String.valueOf(kGSong.N1()));
                            }
                            if (e.c.a.g.a.f.a.b() && d.d(kGSong)) {
                                kGSong.z3(r0.c(jSONObject2));
                            }
                            arrayList.add(kGSong);
                        } else {
                            str = str3;
                            str2 = str4;
                        }
                        i3++;
                        c0167b = this;
                        str3 = str;
                        str4 = str2;
                    }
                }
                bVar.m(arrayList);
            } catch (JSONException unused3) {
            }
        }
    }

    public static b c(String str) {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        b.a = str;
        return b;
    }

    @Nullable
    public e.c.a.g.a.l.b b(String str, int i2, int i3, PageKey pageKey) {
        return d(str, 38236, i2, i3, pageKey);
    }

    public final e.c.a.g.a.l.b d(String str, int i2, int i3, int i4, PageKey pageKey) {
        a aVar = new a(this, str);
        C0167b c0167b = new C0167b();
        Hashtable<String, Object> hashtable = new Hashtable<>(0);
        hashtable.put("rank_id", Integer.valueOf(i2));
        hashtable.put("page", Integer.valueOf(i3));
        hashtable.put("pagesize", Integer.valueOf(i4));
        hashtable.put("scence", 3);
        e.c.a.g.a.r.g.c.u(hashtable, pageKey);
        f.a.d(hashtable);
        aVar.setParams(hashtable);
        try {
            e.c.a.g.a.f.k.k.e eVarA = e.c.a.g.a.f.k.k.e.a();
            e.c.a.g.a.l.b bVar = new e.c.a.g.a.l.b();
            eVarA.request(aVar, c0167b);
            c0167b.getResponseData(bVar);
            return bVar;
        } catch (Exception e2) {
            if (!g0.f()) {
                return null;
            }
            g0.k(e2);
            return null;
        }
    }

    @Nullable
    public e.c.a.g.a.l.b e(String str, int i2, int i3, PageKey pageKey) {
        return d(str, 38235, i2, i3, pageKey);
    }
}
