package e.c.a.g.a.k;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.android.watch.lite.common.music.entity.KGMusicForUI;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.music.entity.SingerInfo;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.network.ackutils.StringResponsePackage;
import e.c.a.g.a.f.k.f;
import e.c.a.g.a.g.e.d;
import e.c.a.g.a.s.e;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.r0;
import java.util.ArrayList;
import java.util.Hashtable;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static volatile a b;
    public String a;

    /* JADX INFO: renamed from: e.c.a.g.a.k.a$a, reason: collision with other inner class name */
    public class C0166a extends e.c.a.g.a.f.k.a {
        public String a;

        public C0166a(a aVar, String str) {
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
                g0.b("wufuqin", "getUrlConfigKey: " + e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.b0));
            }
            return e.c.a.g.a.f.e.b.b0;
        }
    }

    public class b extends StringResponsePackage<e.c.a.g.a.l.b> {
        public b() {
        }

        public final void a(e.c.a.g.a.l.b bVar, JSONObject jSONObject) {
            try {
                bVar.n(jSONObject.getInt(NotificationCompat.CATEGORY_STATUS));
                if (bVar.a() <= 0) {
                    bVar.h(jSONObject.optInt("error_code", 0));
                }
                if (TextUtils.isEmpty(bVar.b())) {
                    bVar.i(jSONObject.optString("error_msg", ""));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.kugou.common.network.ackutils.StringResponsePackage, com.kugou.common.network.protocol.ResponsePackage
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void getResponseData(e.c.a.g.a.l.b bVar) {
            if (TextUtils.isEmpty(this.mJsonString)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.mJsonString);
                int i2 = jSONObject.getInt(NotificationCompat.CATEGORY_STATUS);
                a(bVar, jSONObject);
                if (i2 == 0) {
                    return;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                JSONArray jSONArray = jSONObject2.getJSONArray("list");
                ArrayList<KGSong> arrayList = new ArrayList<>(0);
                try {
                    bVar.k(jSONObject2.getInt("total"));
                    if (g0.a) {
                        g0.b("wufuqin", "getResponseData: total2= " + jSONObject2.getInt("total"));
                    }
                } catch (Exception unused) {
                }
                int length = jSONArray.length();
                if (g0.a) {
                    g0.b("wufuqin", "getResponseData: " + length);
                }
                if (length > 0) {
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                        if (jSONObject3 != null) {
                            try {
                                arrayList.add(a.e(jSONObject3, a.this.a));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
                bVar.m(arrayList);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static a c(String str) {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        b.a = str;
        return b;
    }

    public static KGSong e(JSONObject jSONObject, String str) {
        KGMusicForUI kGMusicForUI = new KGMusicForUI();
        String strOptString = jSONObject.optString("album_audio_id");
        String strOptString2 = jSONObject.optString("audio_id");
        String strOptString3 = jSONObject.optString("author_name");
        String strOptString4 = jSONObject.optString("ori_audio_name");
        String strOptString5 = jSONObject.optString("suffix_audio_name");
        if (!TextUtils.isEmpty(strOptString)) {
            kGMusicForUI.setMixId(Long.parseLong(strOptString));
        }
        if (!TextUtils.isEmpty(strOptString2)) {
            kGMusicForUI.setAudioId(Long.parseLong(strOptString2));
        }
        kGMusicForUI.setArtistName(strOptString3);
        kGMusicForUI.setTrackName(strOptString4);
        kGMusicForUI.setDisplayName(strOptString3 + " - " + strOptString4);
        kGMusicForUI.setExtname(strOptString5);
        String strOptString6 = jSONObject.optString("sd_hash");
        kGMusicForUI.setMvHashValue(TextUtils.isEmpty(strOptString6) ? jSONObject.optString("qhd_hash") : strOptString6);
        kGMusicForUI.setMvType(TextUtils.isEmpty(strOptString6) ? 0 : 2);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("audio_info");
        String str2 = "";
        if (jSONObjectOptJSONObject != null) {
            String strOptString7 = jSONObjectOptJSONObject.optString("hash_128");
            String strOptString8 = jSONObjectOptJSONObject.optString("filesize_128");
            String strOptString9 = jSONObjectOptJSONObject.optString("timelength_128");
            if (TextUtils.isEmpty(strOptString7)) {
                strOptString7 = jSONObjectOptJSONObject.optString("hash");
                strOptString8 = jSONObjectOptJSONObject.optString("filesize");
                strOptString9 = jSONObjectOptJSONObject.optString("timelength");
            }
            kGMusicForUI.setFailProcess(jSONObjectOptJSONObject.optInt("fail_process"));
            kGMusicForUI.setPayType(jSONObjectOptJSONObject.optInt("pay_type"));
            kGMusicForUI.setOldCpy(jSONObjectOptJSONObject.optInt("old_cpy"));
            kGMusicForUI.setMusicFeeType(jSONObjectOptJSONObject.optString("type"));
            kGMusicForUI.setHashValue(strOptString7);
            kGMusicForUI.setSize(Long.parseLong(strOptString8));
            kGMusicForUI.setDuration((long) Double.parseDouble(strOptString9));
            String strOptString10 = jSONObjectOptJSONObject.optString("hash_320");
            String strOptString11 = jSONObjectOptJSONObject.optString("filesize_320");
            kGMusicForUI.setHash320(strOptString10);
            kGMusicForUI.setSize320(Long.parseLong(strOptString11));
            String strOptString12 = jSONObjectOptJSONObject.optString("hash_flac");
            String strOptString13 = jSONObjectOptJSONObject.optString("filesize_flac");
            kGMusicForUI.setSqHash(strOptString12);
            kGMusicForUI.setSqSize(Long.parseLong(strOptString13));
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("album_info");
            if (jSONObjectOptJSONObject2 != null) {
                String strOptString14 = jSONObjectOptJSONObject2.optString("album_name");
                long jOptInt = jSONObjectOptJSONObject2.optInt("album_id");
                kGMusicForUI.setAlbumName(strOptString14);
                kGMusicForUI.setAlbumID(jOptInt);
                kGMusicForUI.setFeeAlbumId(String.valueOf(jOptInt));
                String strOptString15 = jSONObjectOptJSONObject2.optString("sizable_cover");
                if (strOptString15.contains("{size}")) {
                    kGMusicForUI.setImgUrl(strOptString15.replace("{size}", "240"));
                    str2 = strOptString15;
                }
            } else {
                String strOptString16 = jSONObject.optString("album_name");
                long jOptInt2 = jSONObject.optInt("album_id");
                kGMusicForUI.setAlbumName(strOptString16);
                if (jOptInt2 > 0) {
                    kGMusicForUI.setAlbumID(jOptInt2);
                    kGMusicForUI.setFeeAlbumId(String.valueOf(jOptInt2));
                }
            }
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("authors");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            SingerInfo[] singerInfoArr = new SingerInfo[jSONArrayOptJSONArray.length()];
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                SingerInfo singerInfo = new SingerInfo();
                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i2);
                String strOptString17 = jSONObjectOptJSONObject3.optString("author_id", "0");
                String strOptString18 = jSONObjectOptJSONObject3.optString("author_name");
                singerInfo.d(Integer.parseInt(strOptString17));
                singerInfo.e(strOptString18);
                singerInfoArr[i2] = singerInfo;
            }
            kGMusicForUI.setSingerInfos(singerInfoArr);
        }
        KGSong kgSong = kGMusicForUI.toKgSong();
        kgSong.setMusicTransParamEnenty(r0.d(jSONObjectOptJSONObject));
        r0.l(kgSong, kgSong.getMusicTransParamEnenty());
        if (kgSong.getMusicTransParamEnenty() != null && e.a(kgSong.getMusicTransParamEnenty().getPay_block_tpl())) {
            kgSong.U2(2);
        }
        if (jSONObjectOptJSONObject != null) {
            kgSong.S3(jSONObjectOptJSONObject.optInt("privilege"), jSONObjectOptJSONObject.optInt("privilege_320"), jSONObjectOptJSONObject.optInt("privilege_flac"));
        }
        kgSong.s4(strOptString4);
        kgSong.M4(2);
        kgSong.A3(300);
        kgSong.A4("18");
        kgSong.y4(str);
        if (TextUtils.isEmpty(kgSong.r1())) {
            kgSong.c3(str2);
        }
        kgSong.w3(jSONObject.optString("alg_path"));
        return kgSong;
    }

    @Nullable
    public e.c.a.g.a.l.b b(String str, int i2, int i3, PageKey pageKey) {
        return d(str, 336, i2, i3, pageKey);
    }

    public final e.c.a.g.a.l.b d(String str, int i2, int i3, int i4, PageKey pageKey) {
        C0166a c0166a = new C0166a(this, str);
        b bVar = new b();
        Hashtable<String, Object> hashtable = new Hashtable<>(0);
        hashtable.put("level", Integer.valueOf(d.a.f()));
        hashtable.put("page", Integer.valueOf(i3));
        hashtable.put("pagesize", Integer.valueOf(i4));
        e.c.a.g.a.r.g.c.u(hashtable, pageKey);
        f.a.d(hashtable);
        c0166a.setParams(hashtable);
        try {
            e.c.a.g.a.f.k.k.e eVarA = e.c.a.g.a.f.k.k.e.a();
            e.c.a.g.a.l.b bVar2 = new e.c.a.g.a.l.b();
            eVarA.request(c0166a, bVar);
            bVar.getResponseData(bVar2);
            return bVar2;
        } catch (Exception e2) {
            if (!g0.f()) {
                return null;
            }
            g0.k(e2);
            return null;
        }
    }
}
