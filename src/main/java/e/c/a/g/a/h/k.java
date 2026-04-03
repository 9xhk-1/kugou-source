package e.c.a.g.a.h;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.musicfees.mediastore.entity.TrackerInfo;
import com.kugou.android.watch.lite.common.music.entity.ExtraInfo;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.music.entity.RecSongInfo;
import com.kugou.android.watch.lite.common.music.entity.SingerInfo;
import com.kugou.android.watch.lite.guessyoulike.GuessYouLikeHelper;
import com.kugou.android.watch.lite.guessyoulike.MusicConInfo;
import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.protocol.AbstractRequestPackage;
import e.c.a.g.a.s.e0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.r0;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    public Context a;

    public static class a {
        public int a;
        public int b;
        public boolean c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d f1077d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1078e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public e.c.a.g.a.d.b.a f1079f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f1080g;
    }

    public static class b extends AbstractRequestPackage {
        public JSONArray a;
        public String b;
        public boolean c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f1081d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f1082e;

        public b(Context context, JSONArray jSONArray, String str, boolean z, long j, long j2) {
            this.a = jSONArray;
            this.b = str;
            this.c = z;
            this.f1081d = j;
            this.f1082e = j2;
        }

        public final JSONObject a() {
            Hashtable<String, Object> hashtableH = GuessYouLikeHelper.h();
            hashtableH.put("last_uplpad_hash", this.b);
            hashtableH.put("complete", this.c ? "1" : "0");
            hashtableH.put("client_playlist", this.a);
            hashtableH.put("prev_sync_point", Long.valueOf(this.f1081d));
            hashtableH.put("next_sync_point", Long.valueOf(this.f1082e));
            hashtableH.put("playlist_ver", 2);
            String strC = h.c(1281);
            hashtableH.put("action", "sync");
            hashtableH.put("mode", strC);
            JSONObject jSONObjectB = e0.b(hashtableH);
            try {
                jSONObjectB.put("complete", this.c ? 1 : 0);
            } catch (JSONException e2) {
                g0.k(e2);
            }
            return jSONObjectB;
        }

        @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
        public String getGetRequestParams() {
            return super.getGetRequestParams();
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            try {
                return new StringEntity(a().toString(), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                g0.k(e2);
                return null;
            }
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
            return e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.R0);
        }
    }

    public static class c extends e.c.a.g.a.r.e.a<a> {
        public e.c.a.g.a.d.b.a b;

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void getResponseData(a aVar) {
            aVar.f1079f = this.b;
            try {
                JSONObject jSONObject = new JSONObject(this.a);
                aVar.a = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                aVar.b = jSONObject.optInt("error_code");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (aVar.a == 0) {
                    this.b.g("200");
                    this.b.k(ResponseHandlerForApm.E2);
                    aVar.f1079f.g("200");
                    aVar.f1079f.k(ResponseHandlerForApm.E2);
                }
                if (jSONObjectOptJSONObject != null) {
                    aVar.f1080g = jSONObjectOptJSONObject.optLong("sync_point", 0L);
                    aVar.c = jSONObjectOptJSONObject.optBoolean("is_clean");
                    aVar.f1078e = 1282;
                    aVar.f1077d = b(jSONObjectOptJSONObject, aVar.f1078e);
                }
            } catch (JSONException e2) {
                g0.k(e2);
            }
        }

        public final d b(JSONObject jSONObject, int i2) {
            ArrayList<KGSong> arrayList;
            ArrayList<MusicConInfo> arrayList2;
            ArrayList<KGSong> arrayList3;
            JSONArray jSONArray;
            SingerInfo[] singerInfoArr;
            JSONArray jSONArray2;
            d dVar = new d();
            int i3 = -1;
            jSONObject.optInt("algorithm_id", -1);
            try {
                jSONArray = jSONObject.getJSONArray("song_list");
                arrayList3 = new ArrayList<>();
            } catch (JSONException e2) {
                e = e2;
                arrayList = null;
            }
            try {
                arrayList2 = new ArrayList<>();
                int i4 = 0;
                int i5 = 0;
                while (i5 < jSONArray.length()) {
                    try {
                        KGSong kGSong = new KGSong("");
                        GuessYouLikeHelper.a(kGSong);
                        kGSong.M4(2);
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                        JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("rec_song_info");
                        if (jSONObjectOptJSONObject != null) {
                            kGSong.i4(RecSongInfo.parseRecSongInfo(jSONObjectOptJSONObject));
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
                        kGSong.A4("10");
                        kGSong.n3(jSONObject2.optString("album_id"));
                        r0.i(jSONObject2, kGSong);
                        kGSong.Q3(jSONObject2.optLong("mixsongid", 0L));
                        kGSong.e4(jSONObject2.optInt("pay_type"));
                        kGSong.m3(jSONObject2.optInt("fail_process"));
                        kGSong.U3(jSONObject2.optString("type"));
                        kGSong.b4(jSONObject2.optInt("old_cpy", i3));
                        kGSong.O4(l1.b());
                        kGSong.b1 = jSONObject2.optInt("collect_usercnt", i4);
                        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("singerinfo");
                        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                            singerInfoArr = null;
                        } else {
                            singerInfoArr = new SingerInfo[jSONArrayOptJSONArray.length()];
                            for (int i6 = 0; i6 < jSONArrayOptJSONArray.length(); i6++) {
                                SingerInfo singerInfo = new SingerInfo();
                                JSONObject jSONObject3 = jSONArrayOptJSONArray.getJSONObject(i6);
                                singerInfo.d(jSONObject3.optInt("id"));
                                singerInfo.e(jSONObject3.optString("name"));
                                singerInfoArr[i6] = singerInfo;
                            }
                            kGSong.n4(singerInfoArr);
                        }
                        kGSong.n4(singerInfoArr);
                        JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("relate_goods");
                        int i7 = 0;
                        int i8 = 0;
                        int i9 = 0;
                        int i10 = 0;
                        while (i7 < jSONArrayOptJSONArray2.length()) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i7);
                            int iOptInt = jSONObjectOptJSONObject2.optInt("level");
                            if (g0.a) {
                                StringBuilder sb = new StringBuilder();
                                jSONArray2 = jSONArray;
                                sb.append("level: ");
                                sb.append(iOptInt);
                                g0.b("zzm-log", sb.toString());
                            } else {
                                jSONArray2 = jSONArray;
                            }
                            int iOptInt2 = jSONObjectOptJSONObject2.optInt("privilege");
                            if (iOptInt == 2) {
                                i8 = iOptInt2;
                            } else if (iOptInt == 4) {
                                i9 = iOptInt2;
                            } else if (iOptInt == 5) {
                                i10 = iOptInt2;
                            }
                            i7++;
                            jSONArray = jSONArray2;
                        }
                        JSONArray jSONArray3 = jSONArray;
                        kGSong.S3(i8, i9, i10);
                        if (g0.a) {
                            g0.b("burone", "response song -- " + kGSong.s1() + "  id=" + kGSong.L1());
                        }
                        int iOptInt3 = jSONObject2.optInt("climax_end_time");
                        int iOptInt4 = jSONObject2.optInt("climax_start_time");
                        int iOptInt5 = jSONObject2.optInt("climax_timelength");
                        ExtraInfo extraInfo = new ExtraInfo();
                        extraInfo.personFmClimaxStart = iOptInt4;
                        extraInfo.personFmClimaxEnd = iOptInt3;
                        JSONObject jSONObjectOptJSONObject3 = jSONObject2.optJSONObject("tracker_info");
                        if (jSONObjectOptJSONObject3 != null) {
                            TrackerInfo trackerInfo = new TrackerInfo();
                            trackerInfo.setAuth(jSONObjectOptJSONObject3.optString("auth"));
                            trackerInfo.setMoudleId(jSONObjectOptJSONObject3.optInt("module_id"));
                            trackerInfo.setOpenTime(jSONObjectOptJSONObject3.optString("open_time"));
                            trackerInfo.setMode(2);
                            extraInfo.trackerInfo = trackerInfo;
                        }
                        kGSong.b1(extraInfo);
                        if (e.c.a.g.a.f.a.b() && e.c.a.g.a.f.j.c.d.d(kGSong)) {
                            kGSong.z3(r0.c(jSONObject2));
                        }
                        if (i2 != 1282) {
                            arrayList3.add(kGSong);
                        } else if (iOptInt3 > 0 && iOptInt4 > 0 && iOptInt5 > 0) {
                            MusicConInfo musicConInfo = new MusicConInfo();
                            musicConInfo.b(kGSong.J1());
                            musicConInfo.c(iOptInt4);
                            int iT1 = iOptInt4 + 30000;
                            if (iT1 > kGSong.t1()) {
                                iT1 = (int) kGSong.t1();
                            }
                            musicConInfo.a(iT1);
                            arrayList2.add(musicConInfo);
                            arrayList3.add(kGSong);
                        }
                        i5++;
                        jSONArray = jSONArray3;
                        i3 = -1;
                        i4 = 0;
                    } catch (JSONException e3) {
                        e = e3;
                        arrayList = arrayList3;
                        g0.k(e);
                        arrayList3 = arrayList;
                    }
                }
            } catch (JSONException e4) {
                e = e4;
                arrayList = arrayList3;
                arrayList2 = null;
                g0.k(e);
                arrayList3 = arrayList;
                dVar.d(arrayList2);
                dVar.b(arrayList3);
                return dVar;
            }
            dVar.d(arrayList2);
            dVar.b(arrayList3);
            return dVar;
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        public ResponseTypeChecker.ResponseType getResponseType() {
            return ResponseTypeChecker.ResponseType.JSON;
        }
    }

    public k(Context context) {
        this.a = context;
    }

    public a a(JSONArray jSONArray, String str, boolean z, long j, long j2) {
        a aVar = new a();
        b bVar = new b(this.a, jSONArray, str, z, j, j2);
        c cVar = new c();
        try {
            e.c.a.g.a.f.k.k.e.a().request(bVar, cVar);
            cVar.getResponseData(aVar);
        } catch (Exception e2) {
            g0.k(e2);
            aVar.f1079f = cVar.b;
        }
        return aVar;
    }
}
