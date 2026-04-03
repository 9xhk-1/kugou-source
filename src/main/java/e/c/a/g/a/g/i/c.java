package e.c.a.g.a.g.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.common.network.ExceptionParse;
import com.kugou.framework.lyric.loader.KrcLoader;
import e.c.a.g.a.g.i.b;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.n0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public int a;

    public class a {
        public String a;
        public long b;
        public long c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public KGMusic f838d;

        public a(c cVar) {
        }

        public String toString() {
            return "ErrorMusic{mOldHashValue='" + this.a + "', mNewHashValue='" + this.f838d.getHashValue() + "', mOldMixId=" + this.b + ", mNewMixId=" + this.c + '}';
        }
    }

    public static class b {
        public String a;
        public long b;
        public long c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f840e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<Long> f841f;

        public String toString() {
            return "RequestData{hash='" + this.a + "', mixId=" + this.b + ", albumId=" + this.c + ", trackerName='" + this.f840e + "', checkMixIdList=" + this.f841f + '}';
        }
    }

    @Nullable
    public static e.c.a.g.a.g.i.b h(long j) {
        HashMap<String, Object> map = new HashMap<>();
        long jF = l1.f();
        int iC = e.c.a.g.a.r.e.b.c(e.c.c.o.f.a());
        String strN = l1.n(e.c.c.o.f.a());
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String strG = l1.g();
        map.put("appid", Long.valueOf(jF));
        map.put("clienttime", Integer.valueOf(iCurrentTimeMillis));
        map.put("clientver", Integer.valueOf(iC));
        map.put("mid", strN);
        map.put("key", e.c.a.g.a.r.e.b.b(jF, strG, iC, iCurrentTimeMillis + ""));
        ArrayList arrayList = new ArrayList();
        b bVar = new b();
        bVar.a = "";
        bVar.b = j;
        arrayList.add(bVar);
        return (e.c.a.g.a.g.i.b) l0.c(new c().f(map, arrayList, true), 0);
    }

    public final boolean a(List<Long> list, long j) {
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().longValue() == j) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String strReplaceAll = str.replaceAll(" ", "");
        String strReplaceAll2 = str2.replaceAll(" ", "");
        if (strReplaceAll.equalsIgnoreCase(strReplaceAll2)) {
            return true;
        }
        if (strReplaceAll2.contains("、") && !TextUtils.isEmpty(strReplaceAll) && strReplaceAll.contains("、")) {
            return n0.b(strReplaceAll, strReplaceAll2);
        }
        if (strReplaceAll2.contains("、") && !TextUtils.isEmpty(strReplaceAll) && !strReplaceAll.contains("、")) {
            return n0.a(strReplaceAll, strReplaceAll2);
        }
        if (strReplaceAll2.contains("、") || TextUtils.isEmpty(strReplaceAll) || !strReplaceAll.contains("、")) {
            return false;
        }
        return n0.a(strReplaceAll, strReplaceAll2);
    }

    public List<a> c(List<KGMusic> list) {
        HashMap<String, Object> map;
        int i2;
        int i3;
        HashMap<String, Object> map2;
        int i4;
        int i5;
        List<b> list2;
        if (list == null || list.size() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        HashMap<String, Object> mapG = g();
        ArrayList arrayList2 = new ArrayList();
        HashMap map3 = new HashMap();
        boolean z = false;
        for (int i6 = 0; i6 < list.size(); i6++) {
            KGMusic kGMusic = list.get(i6);
            String hashValue = !TextUtils.isEmpty(kGMusic.getHashValue()) ? kGMusic.getHashValue() : !TextUtils.isEmpty(kGMusic.getHash320()) ? kGMusic.getHash320() : !TextUtils.isEmpty(kGMusic.getSqHash()) ? kGMusic.getSqHash() : !TextUtils.isEmpty(kGMusic.getM4aHash()) ? kGMusic.getM4aHash() : "";
            long mixId = kGMusic.getMixId();
            b bVar = new b();
            bVar.a = hashValue;
            if (mixId > 0) {
                bVar.b = mixId;
            }
            bVar.c = kGMusic.getAlbumID();
            bVar.f839d = kGMusic.getArtistName();
            arrayList2.add(bVar);
            if (!TextUtils.isEmpty(hashValue)) {
                map3.put(hashValue, kGMusic);
            }
        }
        List arrayList3 = new ArrayList();
        if (arrayList2.size() > 50) {
            arrayList3 = e.c.a.g.a.d.r.d.k(arrayList2, 50);
        } else {
            arrayList3.add(arrayList2);
        }
        int size = arrayList3.size();
        StringBuilder sb = new StringBuilder();
        int i7 = 0;
        while (i7 < size) {
            List<b> list3 = (List) arrayList3.get(i7);
            List<e.c.a.g.a.g.i.b> listF = f(mapG, list3, z);
            if (listF == null || list3.size() != listF.size()) {
                map = mapG;
                i2 = size;
                i3 = i7;
            } else {
                int size2 = list3.size();
                int i8 = 0;
                while (i8 < size2) {
                    b.C0138b c0138bC = listF.get(i8).c();
                    KGMusic kGMusic2 = (KGMusic) map3.get(list3.get(i8).a);
                    if (kGMusic2 == null || c0138bC == null) {
                        map2 = mapG;
                        i4 = size;
                        i5 = i7;
                        list2 = list3;
                    } else {
                        kGMusic2.setHashType(300);
                        String hashValue2 = kGMusic2.getHashValue();
                        map2 = mapG;
                        i4 = size;
                        long mixId2 = kGMusic2.getMixId();
                        if (TextUtils.isEmpty(c0138bC.h())) {
                            i5 = i7;
                            list2 = list3;
                            kGMusic2.setHashValue(c0138bC.g());
                            kGMusic2.setSize(c0138bC.a());
                        } else {
                            kGMusic2.setHashValue(c0138bC.h());
                            i5 = i7;
                            list2 = list3;
                            kGMusic2.setSize(c0138bC.b());
                        }
                        kGMusic2.setHash320(c0138bC.i());
                        kGMusic2.setSize320(c0138bC.c());
                        if (!TextUtils.isEmpty(c0138bC.k())) {
                            kGMusic2.setSqHash(c0138bC.k());
                            kGMusic2.setSqSize(c0138bC.e());
                        } else if (!TextUtils.isEmpty(c0138bC.j())) {
                            kGMusic2.setSqHash(c0138bC.j());
                            kGMusic2.setSqSize(c0138bC.d());
                        }
                        if (!TextUtils.isEmpty(hashValue2) && !hashValue2.equalsIgnoreCase(kGMusic2.getHashValue())) {
                            a aVar = new a(this);
                            aVar.a = hashValue2;
                            aVar.b = mixId2;
                            aVar.c = listF.get(i8).a();
                            aVar.f838d = kGMusic2;
                            arrayList.add(aVar);
                            sb.append(aVar.toString());
                        }
                    }
                    i8++;
                    i7 = i5;
                    mapG = map2;
                    size = i4;
                    list3 = list2;
                }
                map = mapG;
                i2 = size;
                i3 = i7;
                for (KGMusic kGMusic3 : list) {
                    kGMusic3.setHashType(e.c.a.g.a.f.j.a.b.b(kGMusic3.getHashType()));
                }
            }
            i7 = i3 + 1;
            mapG = map;
            size = i2;
            z = false;
        }
        return arrayList;
    }

    public final e.c.a.g.a.g.i.b d(e.c.a.g.a.g.i.b bVar, JSONObject jSONObject, boolean z) {
        b.C0138b c0138bI = null;
        JSONObject jSONObjectOptJSONObject = jSONObject != null ? jSONObject.optJSONObject("audio_info") : null;
        if (jSONObjectOptJSONObject != null) {
            c0138bI = i(jSONObjectOptJSONObject);
            bVar.l(c0138bI);
        }
        if (jSONObject != null) {
            bVar.i(jSONObject.optLong("album_audio_id", 0L));
        }
        if (z) {
            j(jSONObject, bVar);
            if (jSONObjectOptJSONObject != null && c0138bI != null) {
                l(jSONObjectOptJSONObject, bVar);
            }
            k(jSONObject, bVar);
        }
        return bVar;
    }

    public final List<e.c.a.g.a.g.i.b> e(JSONArray jSONArray, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            e.c.a.g.a.g.i.b bVar = new e.c.a.g.a.g.i.b();
            d(bVar, jSONObjectOptJSONObject, z);
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public final List<e.c.a.g.a.g.i.b> f(HashMap<String, Object> map, List<b> list, boolean z) {
        JSONObject jSONObject;
        JSONArray jSONArrayOptJSONArray;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            HashMap map2 = new HashMap();
            map2.put("hash", bVar.a);
            long j = bVar.b;
            if (j > 0) {
                map2.put("album_audio_id", String.valueOf(j));
            }
            arrayList.add(map2);
            sb.append(bVar.toString());
            sb.append(",");
        }
        map.put("data", arrayList);
        map.put("show_privilege", 0);
        map.put("show_author_alias", 0);
        map.put("show_rel_album_audio_info", 0);
        map.put("show_remarks", 0);
        map.put("dfid", e.c.a.g.a.s.m.e());
        map.put("plat", 1);
        z zVar = new z(map, "POST", e.c.a.g.a.f.e.b.f1);
        zVar.d(2);
        Hashtable<String, Object> hashtable = new Hashtable<>();
        hashtable.put("dfid", e.c.a.g.a.s.m.e());
        zVar.setParams(hashtable);
        ArrayList arrayList2 = new ArrayList();
        try {
            e.c.a.g.a.f.k.k.e.a().request(zVar, zVar);
            try {
                jSONObject = new JSONObject(zVar.c());
            } catch (Exception unused) {
            }
            if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS) == 1 && (jSONArrayOptJSONArray = jSONObject.optJSONArray("data")) != null && jSONArrayOptJSONArray.length() >= 1) {
                int length = jSONArrayOptJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    e.c.a.g.a.g.i.b bVar2 = new e.c.a.g.a.g.i.b();
                    try {
                        JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i3);
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() >= 1) {
                            d(bVar2, m(jSONArrayOptJSONArray2, list, i3), z);
                            if (this.a == 1) {
                                bVar2.k(e(jSONArrayOptJSONArray2, z));
                            }
                            sb2.append(bVar2.d());
                            sb2.append(",");
                            sb2.append(bVar2.h());
                            sb2.append(bVar2.a());
                            sb2.append(",");
                            sb2.append(bVar2.g());
                            sb2.append("\n");
                        }
                    } catch (Exception unused2) {
                    }
                    arrayList2.add(bVar2);
                }
                return arrayList2;
            }
            return null;
        } catch (Exception unused3) {
            return null;
        }
    }

    public final HashMap<String, Object> g() {
        HashMap<String, Object> map = new HashMap<>();
        int configAsInt = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.c);
        int iC = e.c.a.g.a.r.e.b.c(e.c.c.o.f.a());
        String strN = l1.n(e.c.c.o.f.a());
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f642d);
        map.put("appid", Integer.valueOf(configAsInt));
        map.put("clienttime", Integer.valueOf(iCurrentTimeMillis));
        map.put("clientver", Integer.valueOf(iC));
        map.put("mid", strN);
        map.put("key", e.c.a.g.a.r.e.b.b(configAsInt, config, iC, iCurrentTimeMillis + ""));
        return map;
    }

    public final b.C0138b i(JSONObject jSONObject) {
        b.C0138b c0138b;
        b.C0138b c0138b2 = null;
        try {
            c0138b = new b.C0138b();
        } catch (Exception e2) {
            e = e2;
        }
        try {
            c0138b.u(jSONObject.optString("hash", "").toLowerCase());
            c0138b.o(jSONObject.optLong("filesize", 0L));
            c0138b.v(jSONObject.optString("hash_128", ""));
            c0138b.p(jSONObject.optLong("filesize_128", 0L));
            c0138b.A(jSONObject.optLong("timelength_128", 0L));
            c0138b.w(jSONObject.optString("hash_320", ""));
            c0138b.q(jSONObject.optLong("filesize_320", 0L));
            c0138b.B(jSONObject.optLong("timelength_320", 0L));
            c0138b.x(jSONObject.optString("hash_ape", ""));
            c0138b.r(jSONObject.optLong("filesize_ape", 0L));
            c0138b.C(jSONObject.optLong("timelength_ape", 0L));
            c0138b.m(jSONObject.optLong("bitrate_ape", 0L));
            c0138b.y(jSONObject.optString("hash_flac", ""));
            c0138b.s(jSONObject.optLong("filesize_flac", 0L));
            c0138b.D(jSONObject.optLong("timelength_flac", 0L));
            c0138b.n(jSONObject.optLong("bitrate_flac", 0L));
            return c0138b;
        } catch (Exception e3) {
            e = e3;
            c0138b2 = c0138b;
            g0.k(e);
            return c0138b2;
        }
    }

    public final e.c.a.g.a.g.i.b j(JSONObject jSONObject, e.c.a.g.a.g.i.b bVar) {
        if (bVar != null && jSONObject != null) {
            try {
                bVar.t(jSONObject.optString("author_name"));
                bVar.m(jSONObject.optString("ori_audio_name", ""));
                bVar.o(jSONObject.optString("bpm", ""));
                bVar.p(jSONObject.optString("bpmType", ""));
                bVar.r(jSONObject.optString(KrcLoader.TAG_LANGUAGE, ""));
                bVar.n(jSONObject.optString("suffix_audio_name", ""));
                String strE = bVar.e();
                if (!TextUtils.isEmpty(strE)) {
                    bVar.m(bVar.d() + "(" + strE + ")");
                }
            } catch (Exception e2) {
                g0.k(e2);
            }
        }
        return bVar;
    }

    public final void k(JSONObject jSONObject, e.c.a.g.a.g.i.b bVar) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("album_info");
        if (jSONObjectOptJSONObject == null || bVar == null) {
            return;
        }
        b.a aVar = new b.a();
        aVar.d(jSONObjectOptJSONObject.optLong("album_id", 0L));
        aVar.e(jSONObjectOptJSONObject.optString("album_name", ""));
        aVar.g(jSONObjectOptJSONObject.optInt("is_publish", 0));
        aVar.h(jSONObjectOptJSONObject.optString("publish_date", ""));
        aVar.f(jSONObjectOptJSONObject.optString("sizable_cover", ""));
        bVar.j(aVar);
    }

    public final void l(JSONObject jSONObject, e.c.a.g.a.g.i.b bVar) {
        b.C0138b c0138bC;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tags");
        if (jSONArrayOptJSONArray == null || (c0138bC = bVar.c()) == null) {
            return;
        }
        int length = jSONArrayOptJSONArray.length();
        c0138bC.z(new ArrayList());
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < length; i2++) {
            b.c cVar = new b.c();
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                cVar.c(jSONObjectOptJSONObject.optString("parent_id"));
                cVar.d(jSONObjectOptJSONObject.optString("tag_id"));
                cVar.e(jSONObjectOptJSONObject.optString("tag_name"));
            }
            if (!TextUtils.isEmpty(cVar.b())) {
                String strA = cVar.a();
                if (ExceptionParse.NET_URL_PROTOCOL_ERROR.equals(strA)) {
                    bVar.s(cVar.b());
                } else if ("3".equals(strA)) {
                    if (c0138bC.f() == null) {
                        c0138bC.t(new ArrayList());
                    }
                    if (g0.a) {
                        g0.e("MusicInfoMatchManager", "parseDataInfo trackerName: " + bVar.d() + " genre: " + cVar.b());
                    }
                    if (!hashSet.contains(cVar.b())) {
                        hashSet.add(cVar.b());
                        c0138bC.f().add(cVar);
                    }
                }
                c0138bC.l().add(cVar);
            }
        }
        if (c0138bC.f() == null || c0138bC.f().isEmpty()) {
            return;
        }
        bVar.q(n0.c(c0138bC.f()));
        if (g0.a) {
            g0.e("MusicInfoMatchManager", "parseDataInfo trackerName: " + bVar.d() + " genre: " + bVar.f());
        }
    }

    public JSONObject m(JSONArray jSONArray, List<b> list, int i2) {
        boolean z;
        JSONObject jSONObjectOptJSONObject = null;
        if (jSONArray.length() == 1) {
            return jSONArray.optJSONObject(0);
        }
        b bVar = (i2 < 0 || i2 >= list.size()) ? null : list.get(i2);
        if (bVar == null) {
            return null;
        }
        long j = bVar.c;
        String str = bVar.f839d;
        List<Long> list2 = bVar.f841f;
        if (list2 == null || list2.isEmpty()) {
            z = false;
        } else {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i3);
                long jOptLong = jSONObjectOptJSONObject2.optLong("album_audio_id", 0L);
                List<Long> list3 = bVar.f841f;
                if (list3 != null && !list3.isEmpty() && a(bVar.f841f, jOptLong)) {
                    jSONObjectOptJSONObject = jSONObjectOptJSONObject2;
                    z = true;
                    break;
                }
            }
            z = false;
        }
        if (z && jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject;
        }
        if (TextUtils.isEmpty(str)) {
            return jSONArray.optJSONObject(0);
        }
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject jSONObjectOptJSONObject3 = jSONArray.optJSONObject(i4);
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("album_info");
            if (jSONObjectOptJSONObject4 != null) {
                long jOptLong2 = jSONObjectOptJSONObject4.optLong("album_id", 0L);
                if ((j == jOptLong2 && jOptLong2 != 0) || b(str, jSONObjectOptJSONObject3.optString("author_name"))) {
                    return jSONObjectOptJSONObject3;
                }
            }
            if (i4 == jSONArray.length() - 1) {
                jSONObjectOptJSONObject = jSONArray.optJSONObject(0);
            }
        }
        return jSONObjectOptJSONObject;
    }
}
