package com.kugou.common.useraccount.utils;

import android.text.TextUtils;
import com.kugou.common.useraccount.entity.SVIPExtInfo;
import e.c.a.g.a.f.m.c;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.m1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SVIPExtInfoUtil {
    public static void copy(SVIPExtInfo sVIPExtInfo, SVIPExtInfo sVIPExtInfo2) {
        if (sVIPExtInfo == null || sVIPExtInfo2 == null) {
            return;
        }
        sVIPExtInfo2.setSvipLevel(sVIPExtInfo.getSvipLevel());
        sVIPExtInfo2.setSvipScore(sVIPExtInfo.getSvipScore());
        sVIPExtInfo2.setVipUserType(sVIPExtInfo.getVipUserType());
        sVIPExtInfo2.setVipUserYType(sVIPExtInfo.getVipUserYType());
        sVIPExtInfo2.setSu_vip_begin_time(sVIPExtInfo.getSu_vip_begin_time());
        sVIPExtInfo2.setSu_vip_end_time(sVIPExtInfo.getSu_vip_end_time());
        sVIPExtInfo2.setSu_vip_clearday(sVIPExtInfo.getSu_vip_clearday());
        sVIPExtInfo2.setSu_vip_y_endtime(sVIPExtInfo.getSu_vip_y_endtime());
    }

    public static SVIPExtInfo getMineSVIPExtInfo() {
        return getMineSVIPExtInfo(false);
    }

    public static boolean isValid(int i2) {
        return i2 >= 0;
    }

    public static void onlySaveSvipInfo(SVIPExtInfo sVIPExtInfo) {
        if (sVIPExtInfo == null || sVIPExtInfo.isLevelDefault()) {
            return;
        }
        c cVar = c.a;
        cVar.g("svip_level_type", sVIPExtInfo.getSvipLevel());
        cVar.g("svip_score_type", sVIPExtInfo.getSvipScore());
    }

    public static void parseAsSVIPExtInfo(SVIPExtInfo sVIPExtInfo, JSONObject jSONObject) {
        parseAsSVIPExtInfo(sVIPExtInfo, jSONObject, jSONObject, false);
    }

    public static void parseAsSVIPExtInfoFromComment(SVIPExtInfo sVIPExtInfo, JSONObject jSONObject) {
        parseAsSVIPExtInfo(sVIPExtInfo, jSONObject, jSONObject.optJSONObject("vipinfo"), false);
    }

    public static void removeFromSettingPrefs() {
        if (m1.c()) {
            j0.b().a(new Runnable() { // from class: com.kugou.common.useraccount.utils.SVIPExtInfoUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    SVIPExtInfoUtil.removeMyLevelInfo();
                }
            });
        } else {
            removeMyLevelInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void removeMyLevelInfo() {
        c cVar = c.a;
        cVar.k("svip_level_type");
        cVar.k("svip_score_type");
        cVar.k("super_vip_expand_info");
    }

    public static void saveSVIPExtInfo(SVIPExtInfo sVIPExtInfo) {
        if (sVIPExtInfo == null) {
            return;
        }
        if (!sVIPExtInfo.isSuperVipInfoDefault()) {
            c.a.i("super_vip_expand_info", sVIPExtInfo.toJson());
        }
        onlySaveSvipInfo(sVIPExtInfo);
    }

    public static SVIPExtInfo getMineSVIPExtInfo(boolean z) {
        SVIPExtInfo sVIPExtInfo = new SVIPExtInfo();
        if (!z) {
            c cVar = c.a;
            int iB = cVar.b("svip_level_type", -1);
            int iB2 = cVar.b("svip_score_type", -1);
            if (isValid(iB)) {
                sVIPExtInfo.setSvipLevel(iB);
                sVIPExtInfo.setSvipScore(iB2);
            }
        }
        String strD = c.a.d("super_vip_expand_info", "");
        if (!TextUtils.isEmpty(strD)) {
            try {
                JSONObject jSONObject = new JSONObject(strD);
                parseAsSVIPExtInfo(sVIPExtInfo, jSONObject, jSONObject, true);
            } catch (Exception unused) {
            }
        }
        return sVIPExtInfo;
    }

    private static void parseAsSVIPExtInfo(SVIPExtInfo sVIPExtInfo, JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        if (sVIPExtInfo == null) {
            return;
        }
        if (jSONObject != null && !z) {
            if (jSONObject.has("svip_level")) {
                sVIPExtInfo.setSvipLevel(jSONObject.optInt("svip_level", -1));
            }
            if (jSONObject.has("svip_score")) {
                sVIPExtInfo.setSvipScore(jSONObject.optInt("svip_score", -1));
            }
        }
        if (jSONObject2 != null) {
            if (jSONObject2.has("user_type")) {
                sVIPExtInfo.setVipUserType(jSONObject2.optInt("user_type", -1));
            }
            if (jSONObject2.has("user_y_type")) {
                sVIPExtInfo.setVipUserYType(jSONObject2.optInt("user_y_type", -1));
            }
            if (jSONObject2.has("su_vip_begin_time")) {
                sVIPExtInfo.setSu_vip_begin_time(jSONObject2.optString("su_vip_begin_time"));
            }
            if (jSONObject2.has("su_vip_end_time")) {
                sVIPExtInfo.setSu_vip_end_time(jSONObject2.optString("su_vip_end_time"));
            }
            if (jSONObject2.has("su_vip_clearday")) {
                sVIPExtInfo.setSu_vip_clearday(jSONObject2.optString("su_vip_clearday"));
            }
            if (jSONObject2.has("su_vip_y_endtime")) {
                sVIPExtInfo.setSu_vip_y_endtime(jSONObject2.optString("su_vip_y_endtime"));
            }
        }
    }
}
