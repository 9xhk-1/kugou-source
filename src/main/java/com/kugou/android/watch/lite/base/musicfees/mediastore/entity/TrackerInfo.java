package com.kugou.android.watch.lite.base.musicfees.mediastore.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.kugou.android.watch.lite.common.INoGuard;
import com.kugou.android.watch.lite.common.music.entity.ExtraInfo;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TrackerInfo implements Parcelable, Serializable, INoGuard {
    public static final Parcelable.Creator<TrackerInfo> CREATOR = new a();
    public static final int MODE_AUTO_ONLY = 1;
    public static final int MODE_FORCE = 2;
    public static final int MODE_NOT_IN_HISTORY = 3;

    @SerializedName("auth")
    public String auth;
    public long dbId;

    @SerializedName("hash")
    public String hash;
    public transient boolean isAuto;
    private transient boolean isInHistory;

    @SerializedName("mixsongid")
    public String mixsongid;
    public int mode;

    @SerializedName("module_id")
    public int moudleId;

    @SerializedName("open_time")
    public String openTime;
    public long updateTime;

    public class a implements Parcelable.Creator<TrackerInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrackerInfo createFromParcel(Parcel parcel) {
            return new TrackerInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TrackerInfo[] newArray(int i2) {
            return new TrackerInfo[i2];
        }
    }

    public TrackerInfo() {
        this.moudleId = Integer.MIN_VALUE;
        this.mode = 1;
        this.isAuto = false;
        this.isInHistory = true;
    }

    public static TrackerInfo fromJsonObj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        TrackerInfo trackerInfo = new TrackerInfo();
        trackerInfo.setAuth(jSONObject.optString("auth"));
        trackerInfo.setMoudleId(jSONObject.optInt("moudleId"));
        trackerInfo.setOpenTime(jSONObject.optString("openTime"));
        trackerInfo.setMode(jSONObject.optInt("mode"));
        return trackerInfo;
    }

    public static void parseTrackerInfoToKgSongByHistoryMode(JSONObject jSONObject, KGSong kGSong) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || kGSong == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("tracker_info")) == null) {
            return;
        }
        TrackerInfo trackerInfo = new TrackerInfo();
        trackerInfo.setAuth(jSONObjectOptJSONObject.optString("auth"));
        trackerInfo.setMoudleId(jSONObjectOptJSONObject.optInt("module_id"));
        trackerInfo.setOpenTime(jSONObjectOptJSONObject.optString("open_time"));
        trackerInfo.setMode(3);
        trackerInfo.setInHistory(false);
        ExtraInfo extraInfo = new ExtraInfo();
        extraInfo.trackerInfo = trackerInfo;
        kGSong.b1(extraInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAuth() {
        return this.auth;
    }

    public long getDbId() {
        return this.dbId;
    }

    public String getHash() {
        return this.hash;
    }

    public String getMixSongId() {
        return this.mixsongid;
    }

    public int getMode() {
        return this.mode;
    }

    public int getMoudleId() {
        return this.moudleId;
    }

    public String getOpenTime() {
        return this.openTime;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.auth) || TextUtils.isEmpty(this.openTime) || this.moudleId == Integer.MIN_VALUE) ? false : true;
    }

    public void setAuth(String str) {
        this.auth = str;
    }

    public void setAuto(boolean z) {
        this.isAuto = z;
    }

    public void setDbId(long j) {
        this.dbId = j;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setInHistory(boolean z) {
        this.isInHistory = z;
    }

    public void setMixsongid(String str) {
        this.mixsongid = str;
    }

    public void setMode(int i2) {
        this.mode = i2;
    }

    public void setMoudleId(int i2) {
        this.moudleId = i2;
    }

    public void setOpenTime(String str) {
        this.openTime = str;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("auth", this.auth);
            jSONObject.put("moudleId", this.moudleId);
            jSONObject.put("openTime", this.openTime);
            jSONObject.put("mode", this.mode);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "TrackerInfo{auth='" + this.auth + "', moudleId=" + this.moudleId + ", openTime='" + this.openTime + "', mixsongid='" + this.mixsongid + "', hash='" + this.hash + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.auth);
        parcel.writeInt(this.moudleId);
        parcel.writeString(this.openTime);
        parcel.writeInt(this.mode);
        parcel.writeInt(this.isAuto ? 1 : 0);
        parcel.writeInt(this.isInHistory ? 1 : 0);
    }

    public TrackerInfo(Parcel parcel) {
        this.moudleId = Integer.MIN_VALUE;
        this.mode = 1;
        this.isAuto = false;
        this.isInHistory = true;
        this.auth = parcel.readString();
        this.moudleId = parcel.readInt();
        this.openTime = parcel.readString();
        this.mode = parcel.readInt();
        this.isAuto = parcel.readInt() == 1;
        this.isInHistory = parcel.readInt() == 1;
    }
}
