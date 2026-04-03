package e.c.a.g.a.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.media.AudioAttributesCompat;
import com.kugou.android.watch.lite.base.musicfees.mediastore.entity.TrackerInfo;
import com.kugou.android.watch.lite.common.music.entity.ExtraInfo;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.music.entity.RecSongInfo;
import com.kugou.android.watch.lite.common.music.entity.SingerInfo;
import com.kugou.android.watch.lite.guessyoulike.GuessYouLikeHelper;
import com.kugou.android.watch.lite.guessyoulike.MusicConInfo;
import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.protocol.RequestPackage;
import e.c.a.g.a.s.e0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.r0;
import e.c.a.g.a.s.s;
import e.c.a.g.a.s.x0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public String a;
    public JSONArray b;
    public JSONArray c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONArray f1061d;

    public class a extends e.c.a.g.a.r.e.a<i> {
        public int b;
        public boolean c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public e.c.a.g.a.d.b.a f1062d;

        public a(int i2) {
            this.b = i2;
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void getResponseData(i iVar) {
            f.this.g(this.a, iVar, this.b, this.c);
        }

        public void b(boolean z) {
            this.c = z;
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        public ResponseTypeChecker.ResponseType getResponseType() {
            return ResponseTypeChecker.ResponseType.JSON;
        }
    }

    public class b implements RequestPackage {
        public byte[] a;

        public b(byte[] bArr) {
            this.a = bArr;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getGetRequestParams() {
            return null;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public Header[] getHttpHeaders() {
            return null;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            ByteArrayEntity byteArrayEntity;
            Exception e2;
            try {
                byteArrayEntity = new ByteArrayEntity(this.a);
                try {
                    if (f.this.b != null && f.this.b.length() > 0) {
                        byteArrayEntity.setContentEncoding("gzip");
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    g0.k(e2);
                }
            } catch (Exception e4) {
                byteArrayEntity = null;
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
            return e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.M0);
        }
    }

    public f(Context context, String str) {
        this.a = str;
    }

    public byte[] c(l lVar, boolean z) {
        byte[] bytes;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        JSONObject jSONObjectF = f(lVar, z);
        if (jSONObjectF != null) {
            try {
                jSONObjectF.put("recommend_source_locked", e.c.a.g.a.f.m.c.a.e("KEY_ENABLE_PERSONALITY_REC", false) ? "1" : "0");
            } catch (JSONException e2) {
                g0.k(e2);
            }
        }
        if (jSONObjectF != null && (jSONArray3 = this.b) != null && jSONArray3.length() > 0) {
            try {
                jSONObjectF.put("client_playlist", this.b);
            } catch (JSONException e3) {
                g0.k(e3);
            }
        }
        if (jSONObjectF != null && (jSONArray2 = this.c) != null) {
            try {
                jSONObjectF.put("recommend_source", jSONArray2);
            } catch (JSONException e4) {
                g0.k(e4);
            }
        }
        if (jSONObjectF != null && (jSONArray = this.f1061d) != null && jSONArray.length() > 0) {
            try {
                jSONObjectF.put("black_singerid", this.f1061d);
            } catch (JSONException e5) {
                g0.k(e5);
            }
        }
        if (jSONObjectF == null) {
            return new byte[0];
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONArray jSONArray4 = this.b;
        if (jSONArray4 == null || jSONArray4.length() <= 0) {
            bytes = jSONObjectF.toString().getBytes();
        } else {
            try {
                bytes = s.a(jSONObjectF.toString(), "UTF-8");
            } catch (IOException e6) {
                g0.k(e6);
                bytes = jSONObjectF.toString().getBytes();
            }
        }
        if (g0.a) {
            g0.e("young_xcl", "cwtPersonalFM转义耗时：：：：" + (System.currentTimeMillis() - jCurrentTimeMillis));
        }
        return bytes;
    }

    public i d(l lVar) {
        return e(lVar, false);
    }

    public i e(l lVar, boolean z) {
        i iVar = new i();
        if (lVar == null) {
            return iVar;
        }
        b bVar = new b(c(lVar, z));
        a aVar = new a(lVar.o);
        aVar.b(z);
        try {
            e.c.a.g.a.f.k.k.e.a().request(bVar, aVar);
            aVar.getResponseData(iVar);
        } catch (Exception e2) {
            g0.k(e2);
        }
        if (aVar.f1062d != null && bVar.getPostRequestEntity() != null) {
            aVar.f1062d.j(bVar.getPostRequestEntity().getContentLength());
        }
        return iVar;
    }

    public JSONObject f(l lVar, boolean z) {
        if (lVar == null) {
            return null;
        }
        Hashtable<String, Object> hashtableH = GuessYouLikeHelper.h();
        hashtableH.put("action", lVar.a);
        hashtableH.put("playlist_ver", 2);
        hashtableH.put("mark_list", lVar.c);
        hashtableH.put("hash_like_list", lVar.f1086g);
        hashtableH.put("callerid", z ? "1" : "0");
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
        return e0.b(hashtableH);
    }

    public final void g(String str, i iVar, int i2, boolean z) {
        JSONArray jSONArray;
        int i3;
        if (TextUtils.isEmpty(str) || iVar == null) {
            return;
        }
        iVar.j = i2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            iVar.a = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
            iVar.b = jSONObject.optInt("error_code");
            iVar.f1071h = new d();
            if (iVar.a == 0) {
                if (g0.a) {
                    g0.b("burone", "获取猜你喜欢电台失败，errorCode=" + iVar.b);
                    return;
                }
                return;
            }
            if (jSONObject.has("data")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) {
                    if (g0.a) {
                        g0.b("burone", "返回dataObj = null");
                        return;
                    }
                    return;
                }
                int i4 = 0;
                iVar.f1070g = jSONObjectOptJSONObject.optInt("sync_point", 0);
                iVar.f1069f = jSONObjectOptJSONObject.optInt("sync_need", 0);
                iVar.c = jSONObjectOptJSONObject.optString("mark_list");
                iVar.f1067d = jSONObjectOptJSONObject.optInt("is_clean") != 0;
                iVar.f1068e = jSONObjectOptJSONObject.optString("cur_mark");
                iVar.f1071h.c(9);
                int i5 = -1;
                jSONObjectOptJSONObject.optInt("algorithm_id", -1);
                JSONArray jSONArray2 = jSONObjectOptJSONObject.getJSONArray("song_list");
                ArrayList<KGSong> arrayList = new ArrayList<>();
                ArrayList<MusicConInfo> arrayList2 = new ArrayList<>();
                int i6 = 0;
                while (i6 < jSONArray2.length()) {
                    KGSong kGSong = new KGSong(this.a);
                    GuessYouLikeHelper.a(kGSong);
                    kGSong.M4(2);
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i6);
                    JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("rec_song_info");
                    if (jSONObjectOptJSONObject2 != null) {
                        kGSong.i4(RecSongInfo.parseRecSongInfo(jSONObjectOptJSONObject2));
                    }
                    kGSong.e3(jSONObject2.optString("filename"));
                    kGSong.B3(jSONObject2.optString("hash"));
                    kGSong.E3(jSONObject2.optInt("songid"));
                    kGSong.d4(jSONObject2.optLong("owner_count"));
                    kGSong.o4(jSONObject2.optLong("file_size"));
                    kGSong.X2(jSONObject2.optInt("bitrate"));
                    kGSong.j3(jSONObject2.optString("extname"));
                    kGSong.g3(jSONObject2.optLong("time_length") * 1000);
                    kGSong.X3(jSONObject2.optString("mv_hash"));
                    kGSong.Z3(jSONObject2.optInt("music_trac"));
                    kGSong.C3(jSONObject2.optString("hash_320"));
                    kGSong.C4(jSONObject2.optString("hash_flac"));
                    kGSong.p4(jSONObject2.optInt("filesize_320"));
                    kGSong.D4(jSONObject2.optInt("filesize_flac"));
                    kGSong.u4(18);
                    kGSong.A4("10");
                    kGSong.n3(jSONObject2.optString("album_id"));
                    kGSong.Q3(jSONObject2.optLong("mixsongid", 0L));
                    kGSong.X0 = AudioAttributesCompat.FLAG_ALL;
                    kGSong.d3(iVar.f1068e);
                    kGSong.R2(jSONObject2.optString("author_name"));
                    kGSong.e4(jSONObject2.optInt("pay_type"));
                    kGSong.m3(jSONObject2.optInt("fail_process"));
                    kGSong.U3(jSONObject2.optString("type"));
                    kGSong.b4(jSONObject2.optInt("old_cpy", i5));
                    kGSong.O4(l1.b());
                    kGSong.b1 = jSONObject2.optInt("collect_usercnt", i4);
                    r0.i(jSONObject2, kGSong);
                    JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("singerinfo");
                    SingerInfo[] singerInfoArr = null;
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                        singerInfoArr = new SingerInfo[jSONArrayOptJSONArray.length()];
                        for (int i7 = 0; i7 < jSONArrayOptJSONArray.length(); i7++) {
                            SingerInfo singerInfo = new SingerInfo();
                            JSONObject jSONObject3 = jSONArrayOptJSONArray.getJSONObject(i7);
                            singerInfo.d(jSONObject3.optInt("id"));
                            singerInfo.e(jSONObject3.optString("name"));
                            singerInfoArr[i7] = singerInfo;
                        }
                        kGSong.n4(singerInfoArr);
                    }
                    kGSong.n4(singerInfoArr);
                    JSONObject jSONObjectOptJSONObject3 = jSONObject2.optJSONObject("channel_info");
                    JSONObject jSONObjectOptJSONObject4 = jSONObject2.optJSONObject("channel_song_info");
                    if (jSONObjectOptJSONObject3 != null) {
                        iVar.f1071h.a.put(Long.toString(kGSong.T1()), jSONObjectOptJSONObject3.toString());
                    }
                    if (jSONObjectOptJSONObject4 != null) {
                        iVar.f1071h.b.put(Long.toString(kGSong.T1()), jSONObjectOptJSONObject4.toString());
                    }
                    JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("relate_goods");
                    int length = jSONArrayOptJSONArray2 != null ? jSONArrayOptJSONArray2.length() : 0;
                    int i8 = 0;
                    int i9 = 0;
                    int i10 = 0;
                    int i11 = 0;
                    while (i8 < length) {
                        JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i8);
                        JSONArray jSONArray3 = jSONArray2;
                        int iOptInt = jSONObjectOptJSONObject5.optInt("level");
                        if (g0.a) {
                            jSONArray = jSONArrayOptJSONArray2;
                            i3 = length;
                            g0.b("zzm-log", "level: " + iOptInt);
                        } else {
                            jSONArray = jSONArrayOptJSONArray2;
                            i3 = length;
                        }
                        int iOptInt2 = jSONObjectOptJSONObject5.optInt("privilege");
                        if (iOptInt == 2) {
                            i9 = iOptInt2;
                        } else if (iOptInt == 4) {
                            i10 = iOptInt2;
                        } else if (iOptInt == 5) {
                            i11 = iOptInt2;
                        }
                        i8++;
                        jSONArray2 = jSONArray3;
                        jSONArrayOptJSONArray2 = jSONArray;
                        length = i3;
                    }
                    JSONArray jSONArray4 = jSONArray2;
                    kGSong.S3(i9, i10, i11);
                    if (g0.a) {
                        g0.b("burone", "response song -- " + kGSong.s1() + "  id=" + kGSong.L1());
                    }
                    int iOptInt3 = jSONObject2.optInt("climax_end_time");
                    int iOptInt4 = jSONObject2.optInt("climax_start_time");
                    jSONObject2.optInt("climax_timelength");
                    ExtraInfo extraInfo = new ExtraInfo();
                    extraInfo.personFmClimaxStart = iOptInt4;
                    extraInfo.personFmClimaxEnd = iOptInt3;
                    JSONObject jSONObjectOptJSONObject6 = jSONObject2.optJSONObject("tracker_info");
                    if (jSONObjectOptJSONObject6 != null) {
                        TrackerInfo trackerInfo = new TrackerInfo();
                        trackerInfo.setAuth(jSONObjectOptJSONObject6.optString("auth"));
                        trackerInfo.setMoudleId(jSONObjectOptJSONObject6.optInt("module_id"));
                        trackerInfo.setOpenTime(jSONObjectOptJSONObject6.optString("open_time"));
                        trackerInfo.setMode(2);
                        extraInfo.trackerInfo = trackerInfo;
                    }
                    kGSong.b1(extraInfo);
                    if (e.c.a.g.a.f.a.b() && e.c.a.g.a.f.j.c.d.d(kGSong)) {
                        kGSong.z3(r0.c(jSONObject2));
                    }
                    arrayList.add(kGSong);
                    i6++;
                    jSONArray2 = jSONArray4;
                    i4 = 0;
                    i5 = -1;
                }
                iVar.f1071h.d(arrayList2);
                iVar.f1071h.b(arrayList);
                if (g0.a) {
                    g0.b("burone", "返回歌曲数：" + arrayList.size() + "  回复实体：" + iVar.toString());
                }
            }
        } catch (JSONException e2) {
            g0.k(e2);
        }
    }
}
