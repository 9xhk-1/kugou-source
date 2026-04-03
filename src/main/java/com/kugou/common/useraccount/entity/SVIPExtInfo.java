package com.kugou.common.useraccount.entity;

import android.os.Parcel;
import android.support.annotation.IntRange;
import com.kugou.android.watch.lite.common.INoGuard;
import com.kugou.common.useraccount.utils.SVIPExtInfoUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SVIPExtInfo implements INoGuard {
    public static final int DEFAULT_NUM = -1;
    private String su_vip_begin_time;
    private String su_vip_clearday;
    private String su_vip_end_time;
    private String su_vip_y_endtime;
    private int svipLevel = -1;
    private int svipScore = -1;
    private int vipUserType = -1;
    private int vipUserYType = -1;

    public static void createFParcel(SVIPExtInfo sVIPExtInfo, Parcel parcel) {
        if (sVIPExtInfo == null || parcel == null) {
            return;
        }
        sVIPExtInfo.setSvipLevel(parcel.readInt());
        sVIPExtInfo.setSvipScore(parcel.readInt());
        sVIPExtInfo.setVipUserType(parcel.readInt());
        sVIPExtInfo.setVipUserYType(parcel.readInt());
        sVIPExtInfo.setSu_vip_begin_time(parcel.readString());
        sVIPExtInfo.setSu_vip_end_time(parcel.readString());
        sVIPExtInfo.setSu_vip_y_endtime(parcel.readString());
        sVIPExtInfo.setSu_vip_clearday(parcel.readString());
    }

    public SVIPExtInfo getSVIPExtInfo() {
        SVIPExtInfo sVIPExtInfo = new SVIPExtInfo();
        SVIPExtInfoUtil.copy(this, sVIPExtInfo);
        return sVIPExtInfo;
    }

    public String getSu_vip_begin_time() {
        return this.su_vip_begin_time;
    }

    public String getSu_vip_clearday() {
        return this.su_vip_clearday;
    }

    public String getSu_vip_end_time() {
        return this.su_vip_end_time;
    }

    public String getSu_vip_y_endtime() {
        return this.su_vip_y_endtime;
    }

    public int getSvipLevel() {
        return this.svipLevel;
    }

    public int getSvipScore() {
        return this.svipScore;
    }

    public int getVipUserType() {
        return this.vipUserType;
    }

    public int getVipUserYType() {
        return this.vipUserYType;
    }

    public boolean isLevelDefault() {
        return getSvipLevel() == -1 || getSvipScore() == -1;
    }

    public boolean isSuperVipInfoDefault() {
        return this.vipUserType == -1;
    }

    public boolean isValid() {
        return SVIPExtInfoUtil.isValid(getSvipLevel());
    }

    public void setSu_vip_begin_time(String str) {
        this.su_vip_begin_time = str;
    }

    public void setSu_vip_clearday(String str) {
        this.su_vip_clearday = str;
    }

    public void setSu_vip_end_time(String str) {
        this.su_vip_end_time = str;
    }

    public void setSu_vip_y_endtime(String str) {
        this.su_vip_y_endtime = str;
    }

    public void setSvipLevel(int i2) {
        this.svipLevel = i2;
    }

    public void setSvipScore(int i2) {
        this.svipScore = i2;
    }

    public void setVipUserType(@IntRange(from = -1) int i2) {
        this.vipUserType = i2;
    }

    public void setVipUserYType(@IntRange(from = -1) int i2) {
        this.vipUserYType = i2;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        toJson(jSONObject);
        return jSONObject.toString();
    }

    public void write2Parcel(Parcel parcel) {
        if (parcel == null) {
            return;
        }
        parcel.writeInt(this.svipLevel);
        parcel.writeInt(this.svipScore);
        parcel.writeInt(this.vipUserType);
        parcel.writeInt(this.vipUserYType);
        parcel.writeString(this.su_vip_begin_time);
        parcel.writeString(this.su_vip_end_time);
        parcel.writeString(this.su_vip_y_endtime);
        parcel.writeString(this.su_vip_clearday);
    }

    public void toJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("svip_level", getSvipLevel());
            jSONObject.put("svip_score", getSvipScore());
            jSONObject.put("user_type", getVipUserType());
            jSONObject.put("user_y_type", getVipUserYType());
            jSONObject.put("su_vip_begin_time", getSu_vip_begin_time());
            jSONObject.put("su_vip_end_time", getSu_vip_end_time());
            jSONObject.put("su_vip_clearday", getSu_vip_clearday());
            jSONObject.put("su_vip_y_endtime", getSu_vip_y_endtime());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
