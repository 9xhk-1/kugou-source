package com.kugou.android.watch.lite.guessyoulike;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.common.player.kugouplayer.j;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import com.kugou.common.useraccount.entity.SVIPExtInfo;
import com.kugou.common.useraccount.utils.SVIPExtInfoUtil;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.h.a;
import e.c.a.g.a.h.g;
import e.c.a.g.a.h.h;
import e.c.a.g.a.h.i;
import e.c.a.g.a.h.l;
import e.c.a.g.a.r.b;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.q0;
import e.c.c.o.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GuessYouLikeHelper {
    public static volatile GuessYouLikeHelper a;
    public static byte[] b = new byte[0];

    public static class MusicStatusOnNext implements Parcelable {
        public static final Parcelable.Creator<MusicStatusOnNext> CREATOR = new a();
        public int a;
        public String b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f208d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f209f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f210h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f211i;

        public class a implements Parcelable.Creator<MusicStatusOnNext> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public MusicStatusOnNext createFromParcel(Parcel parcel) {
                return new MusicStatusOnNext(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public MusicStatusOnNext[] newArray(int i2) {
                return new MusicStatusOnNext[i2];
            }
        }

        public MusicStatusOnNext() {
        }

        public static MusicStatusOnNext a(String str) {
            MusicStatusOnNext musicStatusOnNext = new MusicStatusOnNext();
            try {
                JSONObject jSONObject = new JSONObject(str);
                musicStatusOnNext.a = jSONObject.optInt("overPlay");
                musicStatusOnNext.b = jSONObject.optString("curMark");
                musicStatusOnNext.f208d = jSONObject.optString("songId");
                musicStatusOnNext.f209f = jSONObject.optString("hash");
                musicStatusOnNext.f210h = jSONObject.optInt("playTime");
                musicStatusOnNext.f211i = jSONObject.optInt("remainSongcnt");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return musicStatusOnNext;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.f208d);
            parcel.writeString(this.f209f);
            parcel.writeInt(this.f210h);
            parcel.writeInt(this.f211i);
        }

        public MusicStatusOnNext(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readString();
            this.f208d = parcel.readString();
            this.f209f = parcel.readString();
            this.f210h = parcel.readInt();
            this.f211i = parcel.readInt();
        }
    }

    public GuessYouLikeHelper() {
        new ArrayList();
    }

    public static void a(KGSong kGSong) {
    }

    public static Map<String, Object> c() {
        HashMap map = new HashMap();
        boolean zN = b.N();
        int i2 = b.H() ? 1 : 0;
        if (zN) {
            i2 |= 2;
        }
        int iZ = b.z();
        int i3 = b.i();
        String strN = b.n();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token", strN);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        map.put("vip_flags", Integer.valueOf(i2));
        map.put("m_type", Integer.valueOf(i3));
        map.put("vip_type", Integer.valueOf(iZ));
        map.put("u_info", j.t(jSONObject.toString().getBytes()));
        return map;
    }

    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        SVIPExtInfo mineSVIPExtInfo = SVIPExtInfoUtil.getMineSVIPExtInfo();
        if (mineSVIPExtInfo != null) {
            try {
                jSONObject.put("user_type", mineSVIPExtInfo.getVipUserType());
                jSONObject.put("user_y_type", mineSVIPExtInfo.getVipUserYType());
                jSONObject.put("su_vip_end_time", mineSVIPExtInfo.getSu_vip_end_time());
                jSONObject.put("vip_end_time", b.x());
                jSONObject.put("m_end_time", b.f());
                jSONObject.put("is_vip", b.O() ? "1" : "0");
            } catch (JSONException unused) {
            }
        }
        h.a.a.b.a("mhs_watch", "creatVipInfoParam param =" + jSONObject);
        return jSONObject;
    }

    public static GuessYouLikeHelper g() {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new GuessYouLikeHelper();
                }
            }
        }
        return a;
    }

    public static Hashtable<String, Object> h() {
        Hashtable<String, Object> hashtable = new Hashtable<>();
        String config = c.c().getConfig(e.c.a.g.a.f.e.b.c);
        String config2 = c.c().getConfig(e.c.a.g.a.f.e.b.f642d);
        String strValueOf = String.valueOf(l1.G());
        String strValueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
        String strE = new q0().e(config + config2 + strValueOf + strValueOf2);
        hashtable.put("appid", config);
        hashtable.put("clientver", strValueOf);
        hashtable.put("platform", "android");
        hashtable.put("mid", l1.n(f.a()));
        hashtable.put("clienttime", strValueOf2);
        hashtable.put("key", strE);
        hashtable.put("userid", Long.valueOf(b.o()));
        hashtable.put("area_code", b.c());
        hashtable.putAll(c());
        return hashtable;
    }

    public static String k() {
        return e.c.a.g.a.f.m.c.a.d("mark_list", "");
    }

    public static void l() {
        a.c(f.a()).b();
    }

    public void b(l lVar, ArrayList<String> arrayList) {
        lVar.a = "login";
        lVar.f1086g = h.e(arrayList);
        lVar.c = k();
        Object[] array = j().toArray();
        int length = array.length;
        MusicStatusOnNext[] musicStatusOnNextArr = new MusicStatusOnNext[length];
        if (array != null) {
            for (int i2 = 0; i2 < array.length; i2++) {
                musicStatusOnNextArr[i2] = (MusicStatusOnNext) array[i2];
            }
        }
        if (length > 1) {
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < length; i3++) {
                MusicStatusOnNext musicStatusOnNext = musicStatusOnNextArr[i3];
                if (musicStatusOnNext != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ID", musicStatusOnNext.f208d);
                        jSONObject.put("h", musicStatusOnNext.f209f);
                        jSONObject.put("pt", musicStatusOnNext.f210h);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                }
            }
            lVar.d(jSONArray);
        }
        if (g0.a) {
            g0.c("burone", lVar.toString());
        }
    }

    public ArrayList<String> e() {
        return new ArrayList<>();
    }

    public i f(String str) {
        GuessYouLikeHelper guessYouLikeHelperG = g();
        l lVar = new l();
        lVar.o = 1281;
        guessYouLikeHelperG.b(lVar, guessYouLikeHelperG.i());
        boolean z = false;
        i iVarC = c.c().getConfigAsInt(e.c.a.g.a.f.e.b.O0, 1) == 1 ? new g(f.a(), "首页").c(lVar) : new e.c.a.g.a.h.f(f.a(), "首页").d(lVar);
        if (iVarC != null && iVarC.a == 1) {
            z = true;
        }
        RingBiReportHelper.INSTANCE.reportHead3("推荐接口", "入口来源，sourceApi=" + str + ", hasData = " + z);
        if (iVarC != null && iVarC.a == 1) {
            l();
            ArrayList<KGSong> arrayListA = iVarC.f1071h.a();
            h.b(arrayListA, "为你推荐");
            new ArrayList().addAll(arrayListA);
        }
        return iVarC;
    }

    public ArrayList<String> i() {
        ArrayList<String> arrayListE = e();
        if (arrayListE.size() <= 5) {
            return arrayListE;
        }
        Collections.shuffle(arrayListE);
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> it = arrayListE.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            if (arrayList.size() == 5) {
                break;
            }
        }
        return arrayList;
    }

    public Collection<MusicStatusOnNext> j() {
        ArrayList arrayList = new ArrayList();
        String strD = e.c.a.g.a.f.m.c.a.d("KEY_UPLOAD_QUEUE", "");
        if (!TextUtils.isEmpty(strD)) {
            try {
                JSONArray jSONArray = new JSONArray(strD);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(MusicStatusOnNext.a(jSONArray.getJSONObject(i2).toString()));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }
}
