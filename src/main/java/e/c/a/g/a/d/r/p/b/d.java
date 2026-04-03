package e.c.a.g.a.d.r.p.b;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.musicfees.mediastore.entity.HashOffset;
import com.kugou.android.watch.lite.base.player.entity.CommNetSongUrlInfo;
import com.kugou.android.watch.lite.common.music.entity.MusicTransParamEnenty;
import com.kugou.android.watch.lite.user.login.UserData;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.network.AbsHttpClient;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import e.c.a.g.a.s.c1;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.w1;
import java.util.ArrayList;
import org.apache.http.Header;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends h<e.c.a.g.a.d.r.p.a.a> implements AbsHttpClient.IHttpProperty {
    public int b;
    public e.c.a.g.a.d.b.a c;

    public static e.c.a.g.a.d.r.p.a.c d(String str) {
        e.c.a.g.a.d.r.p.a.c cVar = new e.c.a.g.a.d.r.p.a.c();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                cVar.s0(jSONObject.getInt(NotificationCompat.CATEGORY_STATUS));
            }
            if (jSONObject.has("fail_process")) {
                cVar.S(jSONObject.getInt("fail_process"));
            }
            if (!TextUtils.isEmpty(jSONObject.optString("type"))) {
                cVar.t0(jSONObject.getString("type"));
                cVar.u0(l1.b());
            }
            if (jSONObject.has("pay_block_tpl")) {
                cVar.g0(jSONObject.optInt("pay_block_tpl", 0));
            }
            if (jSONObject.has("recommend_album_id")) {
                cVar.o0(jSONObject.optInt("recommend_album_id", 0));
            }
            if (jSONObject.has("trans_param")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("trans_param");
                if (jSONObject2.has("pay_block_tpl")) {
                    cVar.g0(jSONObject2.optInt("pay_block_tpl", 0));
                }
                if (jSONObject2.has("display")) {
                    cVar.P(jSONObject2.optInt("display", 0));
                }
                if (jSONObject2.has("display_rate")) {
                    cVar.Q(jSONObject2.optInt("display_rate", 0));
                }
            }
            if (jSONObject.has("albumname")) {
                cVar.L(jSONObject.getString("albumname"));
            }
            if (jSONObject.has("id")) {
                cVar.X(jSONObject.getInt("id"));
            }
            if (!TextUtils.isEmpty(jSONObject.optString("hash"))) {
                cVar.U(jSONObject.getString("hash").toLowerCase());
            }
            if (!TextUtils.isEmpty(jSONObject.optString("name"))) {
                cVar.d0(jSONObject.getString("name"));
            }
            if (jSONObject.has("level")) {
                cVar.a0(jSONObject.getInt("level"));
            }
            if (jSONObject.has("expire")) {
                cVar.R(jSONObject.getInt("expire"));
            }
            if (jSONObject.has("buy_count")) {
                cVar.N(jSONObject.getInt("buy_count"));
            }
            if (jSONObject.has("img")) {
                cVar.J(jSONObject.getString("img"));
            }
            if (jSONObject.has("singer_name")) {
                cVar.K(jSONObject.getString("singer_name"));
            }
            if (jSONObject.has("pkg_price")) {
                cVar.i0(jSONObject.getInt("pkg_price"));
            }
            if (jSONObject.has("addtime")) {
                cVar.H(jSONObject.getInt("addtime"));
            }
            if (jSONObject.has(CommNetSongUrlInfo.FAIL_PROCESS_BUY)) {
                cVar.M(jSONObject.getInt(CommNetSongUrlInfo.FAIL_PROCESS_BUY));
            }
            if (jSONObject.has("publish")) {
                cVar.l0(jSONObject.getInt("publish"));
            }
            if (jSONObject.has("privilege")) {
                cVar.k0(jSONObject.getInt("privilege"));
            }
            if (jSONObject.has("cid")) {
                cVar.O(jSONObject.getInt("cid"));
            }
            if (jSONObject.has("old_cpy")) {
                cVar.e0(jSONObject.getInt("old_cpy"));
            }
            if (jSONObject.has("rebuy_pay_type")) {
                cVar.n0(jSONObject.getInt("rebuy_pay_type"));
            }
            if (jSONObject.has("pay_block_text")) {
                try {
                    cVar.f0(Integer.valueOf(jSONObject.getString("pay_block_text")).intValue());
                } catch (Exception unused) {
                    cVar.f0(0);
                }
            }
            cVar.b0(jSONObject.optLong("album_audio_id", 0L));
            if (!TextUtils.isEmpty(jSONObject.optString("info"))) {
                JSONObject jSONObject3 = new JSONObject(jSONObject.getString("info"));
                e.c.a.g.a.d.r.p.a.d dVar = new e.c.a.g.a.d.r.p.a.d();
                if (jSONObject3.has("duration")) {
                    dVar.f(jSONObject3.getInt("duration"));
                }
                if (jSONObject3.has("bitrate")) {
                    dVar.e(jSONObject3.getInt("bitrate"));
                }
                if (!TextUtils.isEmpty(jSONObject3.optString("extname"))) {
                    dVar.g(jSONObject3.getString("extname"));
                }
                if (jSONObject3.has("filesize")) {
                    dVar.h(jSONObject3.getInt("filesize"));
                }
                cVar.Z(dVar);
            }
            if (jSONObject.has("price")) {
                cVar.j0(jSONObject.getInt("price"));
            }
            if (jSONObject.has("pay_type")) {
                cVar.h0(jSONObject.getInt("pay_type"));
            }
            if (jSONObject.has("relate_goods")) {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("relate_goods");
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        e.c.a.g.a.d.r.p.a.c cVarD = d(jSONArrayOptJSONArray.getString(i2));
                        if (cVarD != null) {
                            arrayList.add(cVarD);
                        }
                    }
                    cVar.p0(arrayList);
                }
            }
            if (jSONObject.has("album_id")) {
                cVar.I(jSONObject.getString("album_id"));
            }
            if (jSONObject.has("singername")) {
                cVar.q0(jSONObject.getString("singername"));
            }
            if (jSONObject.has(ApmDataKey.START_TIME)) {
                cVar.r0(jSONObject.optString(ApmDataKey.START_TIME));
            }
            MusicTransParamEnenty musicTransParamEnenty = new MusicTransParamEnenty();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("trans_param");
            if (jSONObjectOptJSONObject != null) {
                if (jSONObjectOptJSONObject.has("musicpack_advance")) {
                    musicTransParamEnenty.setMusicpackAdvance(jSONObjectOptJSONObject.getInt("musicpack_advance"));
                }
                if (c1.a() && jSONObjectOptJSONObject.has("hash_offset")) {
                    cVar.V(HashOffset.jsonToHashOffset(jSONObjectOptJSONObject.getJSONObject("hash_offset")));
                }
                if (jSONObjectOptJSONObject.has("identity_block")) {
                    cVar.Y(jSONObjectOptJSONObject.getInt("identity_block"));
                }
                if (jSONObjectOptJSONObject.has("all_quality_free")) {
                    musicTransParamEnenty.setAllQualityFree(jSONObjectOptJSONObject.getInt("all_quality_free"));
                }
                if (jSONObjectOptJSONObject.has("limited_free")) {
                    musicTransParamEnenty.setLimitedFree(jSONObjectOptJSONObject.getInt("limited_free"));
                }
                musicTransParamEnenty.setDisplay(jSONObjectOptJSONObject.optInt("display", 0));
                musicTransParamEnenty.setDisplayRate(jSONObjectOptJSONObject.optInt("display_rate", -1));
                if (c1.a() && cVar.l() != null && cVar.u() == 1) {
                    cVar.W(true);
                    if (e.c.a.g.a.d.r.h.e(cVar.D())) {
                        musicTransParamEnenty.setHave_listen_part(1);
                    } else {
                        musicTransParamEnenty.setHave_listen_part(2);
                    }
                }
            }
            cVar.c0(musicTransParamEnenty);
            return cVar;
        } catch (Exception e2) {
            if (g0.a) {
                g0.c("musicfees", e2.toString());
            }
            return null;
        }
    }

    public final void a(UserData userData) {
        if (userData == null) {
            return;
        }
        int vip_type = userData.getVip_type();
        if (w1.b(vip_type) && w1.a(userData.getMusicType()) && vip_type != 6) {
            userData.setVip_type(6);
        }
    }

    public e.c.a.g.a.d.b.a b() {
        return this.c;
    }

    @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void getResponseData(e.c.a.g.a.d.r.p.a.a aVar) {
        String str;
        String str2;
        if (aVar == null || TextUtils.isEmpty(this.a)) {
            throw new NullPointerException("resp is Empty");
        }
        try {
            JSONObject jSONObject = new JSONObject(this.a);
            if (TextUtils.isEmpty(jSONObject.optString(NotificationCompat.CATEGORY_STATUS))) {
                throw new NullPointerException("Login status is Null");
            }
            aVar.m(jSONObject.getInt(NotificationCompat.CATEGORY_STATUS));
            if (jSONObject.has("data")) {
                e.c.a.g.a.d.r.p.a.b bVar = new e.c.a.g.a.d.r.p.a.b();
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    str = "message";
                    str2 = "error_code";
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        try {
                            arrayList.add(d(jSONArray.get(i2).toString()));
                        } catch (Exception e2) {
                            e = e2;
                            if (!TextUtils.isEmpty(jSONObject.optString("data")) && !jSONObject.optString("data").equals("null")) {
                                JSONObject jSONObject2 = new JSONObject(jSONObject.getString("data"));
                                if (jSONObject2.has("goods")) {
                                    try {
                                        JSONArray jSONArray2 = jSONObject2.getJSONArray("goods");
                                        if (jSONArray2.length() > 0) {
                                            ArrayList arrayList2 = new ArrayList();
                                            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                                                e.c.a.g.a.d.r.p.a.c cVarD = d(jSONArray2.get(i3).toString());
                                                if (cVarD != null) {
                                                    arrayList2.add(cVarD);
                                                }
                                            }
                                            bVar.d(arrayList2);
                                        }
                                    } catch (Exception unused) {
                                        if (g0.a) {
                                            g0.c("musicfees", e.toString());
                                        }
                                    }
                                }
                                if (jSONObject2.has("remain")) {
                                    bVar.f(jSONObject2.getInt("remain"));
                                }
                                if (jSONObject2.has("total")) {
                                    bVar.g(jSONObject2.getInt("total"));
                                }
                                if (jSONObject2.has("consume")) {
                                    bVar.c(jSONObject2.getInt("consume"));
                                }
                                if (jSONObject2.has("upgrade")) {
                                    bVar.h(jSONObject2.getInt("upgrade"));
                                }
                            }
                            if (jSONObject.has("orders")) {
                                ArrayList arrayList3 = new ArrayList();
                                JSONArray jSONArray3 = jSONObject.getJSONArray("orders");
                                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                                    arrayList3.add(e(jSONArray3.get(i4).toString()));
                                }
                                bVar.e(arrayList3);
                            }
                            aVar.h(bVar);
                        }
                    }
                    aVar.j(arrayList);
                } catch (Exception e3) {
                    e = e3;
                    str = "message";
                    str2 = "error_code";
                }
            } else {
                str = "message";
                str2 = "error_code";
            }
            if (jSONObject.has("userinfo")) {
                f(jSONObject.optString("userinfo"));
            }
            String str3 = str2;
            if (jSONObject.has(str3)) {
                aVar.i(jSONObject.getInt(str3));
            }
            String str4 = str;
            if (jSONObject.has(str4)) {
                aVar.k(jSONObject.getString(str4));
            }
        } catch (Exception e4) {
            throw new NullPointerException("resp json format Incorrect:" + e4.getMessage());
        }
    }

    public final e.c.a.g.a.d.r.p.a.e e(String str) {
        e.c.a.g.a.d.r.p.a.e eVar = new e.c.a.g.a.d.r.p.a.e();
        try {
            JSONObject jSONObject = new JSONObject(str);
            eVar.a(jSONObject.getInt("addtime"));
            if (!TextUtils.isEmpty(jSONObject.optString("intro"))) {
                eVar.c(jSONObject.getString("intro"));
            }
            eVar.d(jSONObject.getInt("order_id"));
            if (!TextUtils.isEmpty(jSONObject.optString("pay_amount"))) {
                eVar.e(jSONObject.getString("pay_amount"));
            }
            if (!TextUtils.isEmpty(jSONObject.optString("pay_type"))) {
                eVar.f(jSONObject.getString("pay_type"));
            }
            if (!jSONObject.has("goods")) {
                return eVar;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("goods");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(d(jSONObject.getString("goods")));
            }
            eVar.b(arrayList);
            return eVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void f(String str) {
        if (g0.a) {
            g0.e("zzm-log", "privilege userinfo json:" + str);
        }
        UserData userDataNewEmptyInstance = UserData.newEmptyInstance();
        try {
            JSONObject jSONObject = new JSONObject(str);
            userDataNewEmptyInstance.setMusicType(Integer.parseInt(jSONObject.optString("m_type")));
            userDataNewEmptyInstance.setVip_type(Integer.parseInt(jSONObject.optString("vip_type")));
            userDataNewEmptyInstance.setM_is_old(Integer.parseInt(jSONObject.optString("m_is_old")));
            e.c.a.g.a.r.b.d0(Integer.parseInt(jSONObject.optString("quota_remain")));
            if (!userDataNewEmptyInstance.isVip() && !userDataNewEmptyInstance.isMusicPkg()) {
                e.c.a.g.a.f.k.c<UserData> cVarA = e.c.a.g.a.r.d.d.b.a.a();
                if (cVarA.a() != null && cVarA.f()) {
                    e.c.a.g.a.f.n.a.b().g(152, cVarA.a().getYoungIsVip());
                    e.c.a.g.a.f.n.a.b().i(153, cVarA.a().getYoungVipBeginTime());
                    e.c.a.g.a.f.n.a.b().i(OpenApiConstant.MessageBitmapArgsConstant.MESSAGE_HEIGHT_3, cVarA.a().getYoungVipEndTime());
                    e.c.a.g.a.f.n.a.b().g(155, cVarA.a().getYoungVipType());
                }
            }
            a(userDataNewEmptyInstance);
            e.c.a.g.a.f.n.a.b().f(23, w1.b(userDataNewEmptyInstance.getVip_type()));
            e.c.a.g.a.f.n.a.b().g(25, userDataNewEmptyInstance.getVip_type());
            e.c.a.g.a.f.n.a.b().g(39, userDataNewEmptyInstance.getMusicType());
            EventBus.getDefault().post(new e.c.a.g.a.r.d.c());
        } catch (Exception unused) {
        }
    }

    @Override // e.c.a.g.a.f.k.k.a
    public int getStatusCode() {
        return this.b;
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
    public boolean onContentType(String str) {
        return true;
    }

    @Override // e.c.a.g.a.f.k.k.a
    public void onHandleApmData(e.c.a.g.a.d.b.a aVar) {
        this.c = aVar;
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
    public boolean onHeaders(Header[] headerArr) {
        return true;
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
    public boolean onResponseCode(int i2) {
        setStatusCode(i2);
        return true;
    }

    public void setStatusCode(int i2) {
        this.b = i2;
    }
}
