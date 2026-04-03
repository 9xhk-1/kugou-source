package e.c.a.g.a.d.x.t;

import android.text.TextUtils;
import android.util.Pair;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l0;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements e.c.a.g.a.d.x.t.a {
    public final List<String> a = new ArrayList();
    public final Map<String, String> b = new HashMap();
    public final Map<String, String> c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Gson f616d = new Gson();

    public class a extends TypeToken<List<KGMusicWrapper>> {
        public a(b bVar) {
        }
    }

    public b() {
        c();
        d();
    }

    public void a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            b(jSONArray.optJSONObject(i2));
        }
    }

    public void b(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (objOpt instanceof JSONObject) {
                b((JSONObject) objOpt);
            } else if (objOpt instanceof JSONArray) {
                a((JSONArray) objOpt);
            } else if (e(next, objOpt)) {
                itKeys.remove();
            }
        }
    }

    public final void c() {
        this.a.add("curPosition");
        this.a.add("disposableStartMs");
        this.a.add("personFmClimaxEnd");
        this.a.add("personFmClimaxStart");
        this.a.add("guessYouLikeMark");
        this.a.add("nameType");
        this.a.add("extUniqueId");
        this.a.add("feeType");
        this.a.add("fileOrderWeight");
        this.a.add("genreId");
        this.a.add("gif_id");
        this.a.add("sourceMode");
    }

    public final void d() {
        ArrayList<Pair> arrayList = new ArrayList();
        arrayList.add(new Pair("a1", "constructType"));
        arrayList.add(new Pair("a2", "haveChargOf"));
        arrayList.add(new Pair("a3", "isCurSelectedSong"));
        arrayList.add(new Pair("a4", "isDownLocalorCache"));
        arrayList.add(new Pair("a5", "songtype"));
        arrayList.add(new Pair("a6", "isKGFileExist"));
        arrayList.add(new Pair("a7", "isNeedCheckQuality"));
        arrayList.add(new Pair("a8", "mPagePath"));
        arrayList.add(new Pair("a9", "musicWrapperCode"));
        arrayList.add(new Pair("a10", "userSelQuality"));
        arrayList.add(new Pair("a11", "needCheckListenPartPermission"));
        arrayList.add(new Pair("a12", "isListenPart"));
        arrayList.add(new Pair("a13", "reportState"));
        arrayList.add(new Pair("b1", "albumID"));
        arrayList.add(new Pair("b2", "audioId"));
        arrayList.add(new Pair("b3", "albumName"));
        arrayList.add(new Pair("b4", "albumname"));
        arrayList.add(new Pair("b5", "behavior"));
        arrayList.add(new Pair("b6", "duration"));
        arrayList.add(new Pair("b7", "filehash"));
        arrayList.add(new Pair("b8", "fileuserkey"));
        arrayList.add(new Pair("b9", "maskOfForceDownload"));
        arrayList.add(new Pair("b10", "musicTransParamEnenty"));
        arrayList.add(new Pair("b11", "pay_block_tpl"));
        arrayList.add(new Pair("b12", "musichash"));
        arrayList.add(new Pair("b13", "p2pSource"));
        arrayList.add(new Pair("b14", "qualitytype"));
        arrayList.add(new Pair("b15", "updateFeeStatusTime"));
        arrayList.add(new Pair("b16", "musicFeeType"));
        arrayList.add(new Pair("b17", "failProcess"));
        arrayList.add(new Pair("b18", "musicname"));
        arrayList.add(new Pair("b19", "privilege"));
        arrayList.add(new Pair("b20", "guessYouLikeBiString"));
        arrayList.add(new Pair("b21", "musicLinkSource"));
        arrayList.add(new Pair("b22", "artistName"));
        arrayList.add(new Pair("b23", "trackName"));
        arrayList.add(new Pair("b24", "mvHashValue"));
        arrayList.add(new Pair("b25", "feeAlbumId"));
        arrayList.add(new Pair("b26", "displayName"));
        arrayList.add(new Pair("b27", "recSongInfo"));
        arrayList.add(new Pair("b28", "singerInfos"));
        arrayList.add(new Pair("b29", "sourceType"));
        arrayList.add(new Pair("b30", "songSource"));
        arrayList.add(new Pair("b31", "mvTracks"));
        arrayList.add(new Pair("b32", "filesize"));
        arrayList.add(new Pair("b33", "isCharge"));
        arrayList.add(new Pair("b34", "has_accompany"));
        arrayList.add(new Pair("b35", "hashValue"));
        arrayList.add(new Pair("b36", "hashType"));
        arrayList.add(new Pair("b37", "bitrate"));
        arrayList.add(new Pair("c1", "personFmClimaxEnd"));
        arrayList.add(new Pair("c2", "personFmClimaxStart"));
        arrayList.add(new Pair("c3", "offset_hash"));
        arrayList.add(new Pair("c4", "alg_path"));
        arrayList.add(new Pair("c5", "predict_v"));
        arrayList.add(new Pair("c6", "rec_desc"));
        arrayList.add(new Pair("c7", "rec_desc2"));
        arrayList.add(new Pair("c8", "similar_desc"));
        arrayList.add(new Pair("c9", "similarity"));
        arrayList.add(new Pair("c10", "have_listen_part"));
        arrayList.add(new Pair("c11", "musicpackAdvance"));
        arrayList.add(new Pair("c12", "end_byte"));
        arrayList.add(new Pair("c13", "module_id"));
        arrayList.add(new Pair("c14", "open_time"));
        arrayList.add(new Pair("c15", "displayRate"));
        arrayList.add(new Pair("c16", "pageCode"));
        for (Pair pair : arrayList) {
            this.b.put((String) pair.second, (String) pair.first);
            this.c.put((String) pair.first, (String) pair.second);
        }
    }

    public final boolean e(String str, Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            return TextUtils.isEmpty((String) obj);
        }
        if (obj instanceof Boolean) {
            return Boolean.FALSE.equals(obj);
        }
        if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            if (iIntValue != 0) {
                return iIntValue == -1 && this.a.contains(str);
            }
            return true;
        }
        if (obj instanceof Long) {
            long jLongValue = ((Long) obj).longValue();
            if (jLongValue != 0) {
                return jLongValue == -1 && this.a.contains(str);
            }
            return true;
        }
        if (!(obj instanceof Float)) {
            return false;
        }
        float fFloatValue = ((Float) obj).floatValue();
        if (fFloatValue != 0.0f) {
            return fFloatValue == -1.0f && this.a.contains(str);
        }
        return true;
    }

    public final void f(JSONArray jSONArray, Map<String, String> map) throws JSONException {
        if (jSONArray == null) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            g(jSONArray.optJSONObject(i2), map);
        }
    }

    @Override // e.c.a.g.a.d.x.t.a
    public List<KGMusicWrapper> fromJson(String str) {
        Type type = new a(this).getType();
        try {
            JSONArray jSONArray = new JSONArray(str);
            f(jSONArray, this.c);
            str = jSONArray.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            if (g0.a) {
                g0.b("QueueSerializeStrategy", "fromJson: e=" + e2);
            }
        }
        return (List) this.f616d.fromJson(str, type);
    }

    public final void g(JSONObject jSONObject, Map<String, String> map) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            arrayList.add(itKeys.next());
        }
        for (String str : arrayList) {
            Object objOpt = jSONObject.opt(str);
            if (objOpt instanceof JSONObject) {
                g((JSONObject) objOpt, map);
            } else {
                String str2 = map.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.remove(str);
                    jSONObject.put(str2, objOpt);
                }
            }
        }
    }

    @Override // e.c.a.g.a.d.x.t.a
    public String toJson(List<KGMusicWrapper> list) {
        if (l0.g(list)) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray(this.f616d.toJson(list));
            a(jSONArray);
            f(jSONArray, this.b);
            return jSONArray.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            if (!g0.a) {
                return "";
            }
            g0.b("QueueSerializeStrategy", "toJson: e=" + e2);
            return "";
        }
    }
}
